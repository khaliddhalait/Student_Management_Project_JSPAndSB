package com.controller;

import java.util.Base64;
import java.util.List;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.entity.Attendance;
import com.entity.Mark;
import com.entity.Student;
import com.service.AttendanceService;
import com.service.MarkService;
import com.service.NoticeService;
import com.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {
	@Autowired
	private StudentService sser;
	
	@Autowired
	private AttendanceService atser;
	
	@Autowired
	private MarkService mser;
	
	@Autowired
	private NoticeService nser;
	
	@GetMapping("/index")
	public String index() {
		return "index";
	}
	
	@GetMapping("/login")
	public String studentLogin() {
		return "slogin";
	}

	@PostMapping("/studentlogin")
	public String validate(ModelMap model, @RequestParam String email, @RequestParam String password,HttpSession hs ) {
		password =(Base64.getEncoder().encodeToString(password.getBytes()));
		if (sser.validate(email, password)) {
			Student s = sser.getLogin(email, password);
			hs.setAttribute("sobj", s);
			hs.setAttribute("roll", "student");
			return "redirect:/student/home";
		} else {
			model.put("fmsg", "invalid username and password");
			return "slogin";
		}
	}
	
	@GetMapping("/home")
	public String home(ModelMap model) {
		return "/student/home";
	}
	
	@GetMapping("/view_profile")
	public String profile(ModelMap model) {
		return "/student/view_profile";
	}
	
	@GetMapping("/edit_profile")
	public String editProfilePage() {
		return "student/edit_profile";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession hs , ModelMap model) {
		hs.invalidate();
		model.addAttribute("smsg", "logged out successfully");
		return "slogin";
	}
	
	@PostMapping("/updateprofile")
	public String updateProfile(@ModelAttribute("student") Student student,ModelMap model,HttpSession hs) {
		
		if (sser.updateProfile(student)) {
			hs.setAttribute("sobj", sser.getStudentById(student.getId()));
			hs.setAttribute("roll", "student");
			model.put("smsg", "Student's profile is updated");
		} else {
			model.put("fmsg", "Student's profile is not updated");
		}
		return "/student/view_profile";
	}
	
	@PostMapping("/updatepassword")
	public String updatePassword(@RequestParam String npassword ,@RequestParam String cpassword ,@RequestParam String email,ModelMap model) {
		npassword = (Base64.getEncoder().encodeToString(npassword.getBytes()));
		cpassword = (Base64.getEncoder().encodeToString(cpassword.getBytes()));
		if (sser.updatePassword(cpassword,npassword,email)) 
			model.put("smsg", "password updated");
		 else 
			model.put("fmsg", "password not updated");
		
		return "/student/view_profile";
	}
	
	@GetMapping("/view_attend/{sid}/{semestar}")
	public String viewAttendance(@PathVariable("sid") int sid, @PathVariable("semestar") String semestar,
			ModelMap model) {
		List<Attendance> list = atser.getAttendanceById(sid, semestar);
		model.put("alist", list);
		return "student/view_attend";
	}
	
	@GetMapping("/result/{sid}/{semestar}")
	public String viewResult(@PathVariable("sid") int sid, @PathVariable("semestar") String semestar,
			ModelMap model) {
		List<Mark> list = mser.getMarkByIdAndSemestar(sid, semestar);
		model.put("mlist", list);
		try {

			int tmark = list.size() * 100;
			int gmark = 0;
			boolean b = true;
			for (Mark m : list) {
				gmark = gmark + m.getMark();
				if (m.getMark() < 40)
					b = false;
			}
			int per = (gmark * 100) / tmark;
			String res;
			if (b) {
				if (per >= 60)
					res = "I division";
				else if (per >= 50 && per < 60)
					res = "II division";
				else if (per >= 40 && per < 50)
					res = "III division";
				else
					res = "Fail";
			} else {
				res = "Fail";
			}
			model.put("tmark", tmark);
			model.put("gmark", gmark);
			model.put("per", per);
			model.put("res", res);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "student/view_result";
	}
	
	@GetMapping("/viewnotice")
	public String viewNotice(ModelMap model) {
		model.addAttribute("allNotice", nser.getAllNotice());
		return "/student/view_notice";
	}
}
