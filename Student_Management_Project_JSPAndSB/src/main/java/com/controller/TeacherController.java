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
import com.entity.Course;
import com.entity.Mark;
import com.entity.Student;
import com.entity.Teacher;
import com.service.AttendanceService;
import com.service.CourseService;
import com.service.MarkService;
import com.service.NoticeService;
import com.service.StudentService;
import com.service.SubjectService;
import com.service.TeacherService;

@Controller
@RequestMapping("/teacher")
public class TeacherController {
	@Autowired
	private StudentService sser;

	@Autowired
	private TeacherService tser;

	@Autowired
	private CourseService cser;

	@Autowired
	private SubjectService subser;

	@Autowired
	private AttendanceService aser;

	@Autowired
	private MarkService mser;

	@Autowired
	private NoticeService nser;

	@GetMapping("/login")
	public String teacherLogin() {
		return "tlogin";
	}

	@PostMapping("/teacherlogin")
	public String validate(ModelMap model, @RequestParam String email, @RequestParam String password, HttpSession hs) {
		password = (Base64.getEncoder().encodeToString(password.getBytes()));
		if (tser.validate(email, password)) {
			Teacher t = tser.getLogin(email, password);
			hs.setAttribute("tobj", t);
			hs.setAttribute("roll", "teacher");
			return "redirect:/teacher/home";
		} else {
			model.put("fmsg", "invalid username and password");
			return "tlogin";
		}
	}

	@GetMapping("/logout")
	public String logout(HttpSession hs, ModelMap model) {
		hs.invalidate();
		model.addAttribute("smsg", "logged out successfully");
		return "tlogin";
	}

	@GetMapping("/home")
	public String home(ModelMap model) {
		model.put("tc", tser.getTeacherCount());
		model.put("sc", sser.getStudentCount());
		return "/teacher/home";
	}

	@GetMapping("/view_profile")
	public String profile(ModelMap model) {
		return "/teacher/view_profile";
	}

	@PostMapping("/updatepassword")
	public String updatePassword(@RequestParam String npassword, @RequestParam String cpassword,
			@RequestParam String email, ModelMap model) {
		npassword = (Base64.getEncoder().encodeToString(npassword.getBytes()));
		cpassword = (Base64.getEncoder().encodeToString(cpassword.getBytes()));

		if (tser.updatePassword(cpassword, npassword, email))
			model.put("smsg", "updated password");
		else
			model.put("fmsg", "password not updated");

		return "/teacher/view_profile";
	}

	@GetMapping("/student")
	public String searchStudent(ModelMap model) {
		model.addAttribute("allCourse", cser.getCourse());
		return "/teacher/student";// jsp page
	}

	@PostMapping("/getstudent")
	public String searchstudent(ModelMap model, @RequestParam String course, @RequestParam String semestar,
			@RequestParam String viewtype) {
		model.addAttribute("list", sser.getStudent(course, semestar));
		model.addAttribute("type", viewtype);
		model.addAttribute("course", course);
		model.addAttribute("semestar", semestar);
		return "/teacher/view_student"; // jsp page
	}

	// ***************** attendance ********************

	@GetMapping("/attendance")
	public String searchAttendance(ModelMap model) {
		model.addAttribute("allCourse", cser.getCourse());
		return "/teacher/attendance";// jsp page
	}

	@GetMapping("/take_atten/{id}")
	public String addAttendance(@PathVariable("id") int id, ModelMap model) {
		model.addAttribute("asobj", sser.getStudentById(id));
		return "teacher/take_atten";
	}

	@PostMapping("/addattendance")
	public String addAttendance(ModelMap model, @ModelAttribute("attendance") Attendance attendance) {
		List<Attendance> alist = aser.getAttendanceById(attendance.getSid(), attendance.getSemestar());
		for (Attendance a : alist) {
			if (a.getYear().equals(attendance.getYear()) && a.getMonth().equals(attendance.getMonth())) {
				model.put("fmsg", "Attendance added already");
				return searchstudent(model, attendance.getCourse(), attendance.getSemestar(), "attend");
			}
		}

		Attendance a = aser.addAttendance(attendance);

		if (a != null)
			model.put("smsg", "Attendance added successfully");
		else
			model.put("fmsg", "Attendance not added");

		return searchstudent(model, a.getCourse(), a.getSemestar(), "attend");
	}

	@GetMapping("/view_attend/{sid}/{semestar}")
	public String viewAttendance(@PathVariable("sid") int sid, @PathVariable("semestar") String semestar,
			ModelMap model) {
		List<Attendance> list = aser.getAttendanceById(sid, semestar);
		model.put("alist", list);
		return "teacher/view_attend";
	}

	@GetMapping("/deleteattendance/{id}/{sid}/{semestar}")
	public String viewAttendance(@PathVariable("id") int id, @PathVariable("sid") int sid,
			@PathVariable("semestar") String semestar, ModelMap model) {
		if (aser.deleteAttendance(id))
			model.put("smsg", "attendance deleted successfully");
		else
			model.put("fmsg", "error occured...");

		return viewAttendance(sid, semestar, model);
	}

	@GetMapping("/edit_attend/{id}")
	public String editAttendance(@PathVariable("id") int id, ModelMap model) {
		Attendance a = aser.getAttendanceById(id);
		model.put("att", a);
		return "teacher/edit_attend";
	}

	@PostMapping("/updateattendance")
	public String updateAttendance(@ModelAttribute Attendance a, ModelMap model) {
		if (aser.updateAttendanceById(a.getId(), a.getDays()))
			model.put("smsg", "attendance updated successfully");
		else
			model.put("fmsg", "error occured...");
		return viewAttendance(a.getSid(), a.getSemestar(), model);
	}

	// ************************ result ******************

	@GetMapping("/result")
	public String searchResult(ModelMap model) {
		model.addAttribute("allCourse", cser.getCourse());
		return "/teacher/result";// jsp page
	}

	@GetMapping("/add_mark/{id}")
	public String takeMark(@PathVariable("id") int id, ModelMap model) {
		//display student details on add_mark form
		model.addAttribute("asobj", sser.getStudentById(id));
		model.addAttribute("allsub", subser.getAllSubject());
		return "teacher/add_mark";
	}

	@PostMapping("/addmark")
	public String addMark(ModelMap model, @ModelAttribute("mark") Mark mark) {
		List<Mark> list = mser.getMarkByIdAndSemestar(mark.getSid(), mark.getSemestar());
		for (Mark ma : list) {
			if (ma.getSubject().equals(mark.getSubject())) {
				model.put("fmsg", "Mark added already");
				return searchstudent(model, ma.getCourse(), ma.getSemestar(), "res");
			}
		}

		Mark m = mser.addMark(mark);
		if (m != null)
			model.put("smsg", "Mark added successfully");
		else
			model.put("fmsg", "Mark not added");

		return searchstudent(model, m.getCourse(), m.getSemestar(), "res");
	}

	@GetMapping("/view_result/{sid}/{semestar}")
	public String viewMark(@PathVariable("sid") int sid, @PathVariable("semestar") String semestar, ModelMap model) {
		List<Mark> list = mser.getMarkByIdAndSemestar(sid, semestar);
		model.put("rsobj", sser.getStudentById(sid));
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
		return "teacher/view_result";
	}

	@GetMapping("/edit_mark/{id}")
	public String editMark(@PathVariable("id") int id, ModelMap model) {
		Mark m = mser.getMarkById(id);
		model.put("marks", m);
		return "teacher/edit_mark";
	}

	@GetMapping("/deletemark/{id}/{sid}/{semestar}")
	public String deleteMark(@PathVariable("id") int id, @PathVariable("sid") int sid,
			@PathVariable("semestar") String semestar, ModelMap model) {
		
		if (mser.deleteMark(id))
			model.put("smsg", "Mark deleted successfully");
		else 
			model.put("fmsg", "error occured...");
		
		return viewMark(sid, semestar, model);
	}

	@PostMapping("/updatemark")
	public String updateMark(@ModelAttribute Mark m, ModelMap model) {
		Mark ma = mser.getMarkById(m.getId());

		if (mser.updateMarkById(m.getId(), m.getMark()))
			model.put("smsg", "marks updated successfully");
		else
			model.put("fmsg", "error occured...");

		return viewMark(ma.getSid(), ma.getSemestar(), model);
	}

	@GetMapping("/viewnotice")
	public String viewNotice(ModelMap model) {
		model.addAttribute("allNotice", nser.getAllNotice());
		return "/teacher/view_notice";
	}
}
