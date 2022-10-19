package com.controller;

import java.util.Base64;
import java.util.Date;
import java.util.List;

import javax.persistence.metamodel.SetAttribute;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.entity.*;
import com.repository.*;
import com.service.*;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private AdminService aser;

	@Autowired
	private StudentService sser;

	@Autowired
	private TeacherService tser;

	@Autowired
	private CourseService cser;

	@Autowired
	private SubjectService subser;

	@Autowired
	private AttendanceService atser;

	@Autowired
	private MarkService mser;

	@Autowired
	private NoticeService nser;

	@GetMapping("/login")
	public String adminLogin() {
		return "alogin";
	}

	@PostMapping("/adminlogin")
	public String validateAdmin(ModelMap model, @RequestParam String email, @RequestParam String password,
			HttpSession hs) {
		password = (Base64.getEncoder().encodeToString(password.getBytes()));
		if (aser.validateAdmin(email, password)) {
			Admin a = new Admin();
			a.setAdemail(email);
			hs.setAttribute("aobj", a);
			hs.setAttribute("roll", "admin");
			return "redirect:/admin/home";
		} else {
			model.put("fmsg", "invalid username and password");
			return "alogin";
		}
	}

	@GetMapping("/logout")
	public String logout(HttpSession hs, ModelMap model) {
		hs.invalidate();
		model.addAttribute("smsg", "logged out successfully");
		return "alogin";
	}

	@GetMapping("/home")
	public String adminHome(ModelMap model) {
		model.put("tc", tser.getTeacherCount());
		model.put("sc", sser.getStudentCount());
		return "/admin/home";
	}

	@GetMapping("/add_info")
	public String addInfo(ModelMap model) {
		model.addAttribute("allCourse", cser.getCourse());
		return "/admin/add_info";
	}

	// *************** Course *************************
	@PostMapping("/addcourse")
	public String addCourse(ModelMap model, @RequestParam String course) {
		List<Course> clist = cser.getCourse();
		for (Course c : clist) {
			if (c.getCourse().equals(course)) {
				model.put("fmsg", "Course added already");
				return addInfo(model);
			}
		}

		boolean b = cser.addCourse(course);
		if (b)
			model.put("smsg", "course added successfully");
		else
			model.put("fmsg", "course not added");
		return addInfo(model);
	}

	@GetMapping("/getcourse")
	public List<Course> getCourse() {
		return cser.getCourse();
	}

	// **************** course end **********************

	// **************** Subject ******************

	@PostMapping("/addsubject")
	public String addSubject(ModelMap model, @RequestParam String course, @RequestParam String semestar,
			@RequestParam String subject) {
		List<Subject> slist = subser.getAllSubject();
		for (Subject s : slist) {
			if (s.getSubject().equals(subject)) {
				model.put("fmsg", "Subject added already");
				return addInfo(model);
			}
		}

		boolean b = subser.addSubject(course, semestar, subject);

		if (b)
			model.put("smsg", "Subject added successfully");
		else
			model.put("fmsg", "Subject not added");

		return "/admin/add_info";
	}

	// **************** Subject end ******************

	// **************** Student ******************

	@PostMapping("/addstudent")
	public String addStudent(ModelMap model, @ModelAttribute("student") Student student) {
		// Encoder encoder = Base64.getEncoder();
		// password = encoder.encodeToString(password.getBytes());
		student.setPassword(Base64.getEncoder().encodeToString(student.getPassword().getBytes()));
		List<Student> slist = sser.getStudent();
		for (Student s : slist) {
			if (s.getEmail().equals(student.getEmail())) {
				model.put("fmsg", "Student with this email id has added already");
				return addInfo(model);
			}
		}

		boolean b = sser.addStudent(student);

		if (b)
			model.put("smsg", "student added successfully");
		else
			model.put("fmsg", "student not added");

		// return "redirect:/admin/add_info";
		return addInfo(model);
	}

	@GetMapping("/student")
	public String searchStudent(ModelMap model) {
		model.addAttribute("allCourse", cser.getCourse());
		return "/admin/student";// jsp page
	}

	@PostMapping("/getstudent")
	public String searchstudent(ModelMap model, @RequestParam String course, @RequestParam String semestar,
			@RequestParam String viewtype) {

		model.addAttribute("list", sser.getStudent(course, semestar));
		model.addAttribute("type", viewtype);
		model.addAttribute("course", course);
		model.addAttribute("semestar", semestar);
		return "/admin/view_student"; // jsp page
	}

	@GetMapping("/deletestudent/{id}/{semestar}/{course}/{type}")
	public String deletestudent(@PathVariable("id") int id, @PathVariable("semestar") String semestar,
			@PathVariable("course") String course, @PathVariable("type") String viewtype, ModelMap model) {
		boolean b = sser.deleteStudentById(id);
		if (b) {
			model.put("smsg", "student deleted successfully");
		} else {
			model.put("fmsg", "student not deleted");
		}
		model.addAttribute("list", sser.getStudent());
		model.addAttribute("type", viewtype);
		model.addAttribute("course", course);
		model.addAttribute("semestar", semestar);
		return searchstudent(model, course, semestar, viewtype);
	}

	// **************** student end ******************

	// **************** Teacher ******************

	@GetMapping("/teacher")
	public String getTeacher(ModelMap model) {
		model.addAttribute("tlist", tser.getTeacher());
		return "/admin/teacher";
	}

	@GetMapping("/editteacher/{id}")
	public String editTeacher(ModelMap model, @PathVariable("id") int id) {
		model.put("atobj", tser.getTeacherById(id));
		return "admin/edit_teacher";
	}

	@PostMapping("/updateteacher")
	public String updateTeacher(@ModelAttribute("uteacher") Teacher teacher, ModelMap model) {

		if (tser.updateProfile(teacher))
			model.put("smsg", "updated teacher");
		else
			model.put("fmsg", "profile not updated");

		return getTeacher(model);
	}

	@PostMapping("/addteacher")
	public String addTeacher(@ModelAttribute("teacher") Teacher teacher, ModelMap model) {
		// Encoder encoder = Base64.getEncoder();
		// password = encoder.encodeToString(password.getBytes());
		teacher.setPassword(Base64.getEncoder().encodeToString(teacher.getPassword().getBytes()));
		List<Teacher> tlist = tser.getTeacher();
		for (Teacher t : tlist) {
			if (t.getEmail().equals(teacher.getEmail())) {
				model.put("fmsg", "Teacher with this email id has added already");
				return addInfo(model);
			}
		}

		boolean b = tser.addTeacher(teacher);

		if (b)
			model.put("smsg", "teacher added successfully");
		else
			model.put("fmsg", "teacher not added");

		return "/admin/add_info";
	}

	@GetMapping("/deleteteacher/{id}")
	public String deleteTeacher(@PathVariable("id") int id, ModelMap model) {
		boolean b = tser.deleteTeacherById(id);

		if (b)
			model.put("smsg", "Teacher deleted successfully");
		else
			model.put("fmsg", "Teacher not deleted");

		model.addAttribute("tlist", tser.getTeacher());
		return "/admin/teacher";
	}

	// **************** Teacher end ******************

	// **************** attendance ******************

	@GetMapping("/attendance")
	public String searchAttendance(ModelMap model) {
		model.addAttribute("allCourse", cser.getCourse());
		return "/admin/attendance";// jsp page
	}

	@GetMapping("/view_attend/{sid}/{semestar}")
	public String viewAttendance(@PathVariable("sid") int sid, @PathVariable("semestar") String semestar,
			ModelMap model) {
		List<Attendance> list = (List<Attendance>) atser.getAttendanceById(sid, semestar);
		model.put("alist", list);
		return "admin/view_attend";
	}

	// **************** attendance end ******************

	// ****************** result ******************

	@GetMapping("/result")
	public String searchResult(ModelMap model) {
		model.addAttribute("allCourse", cser.getCourse());
		return "/admin/result";// jsp page
	}

	@GetMapping("/view_result/{sid}/{semestar}")
	public String viewResult(@PathVariable("sid") int sid, @PathVariable("semestar") String semestar, ModelMap model) {
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
		return "admin/view_result";
	}
	// ******************* result end ***************

	// ******************* notice start ***************
	@GetMapping("/notice")
	public String notice(ModelMap model) {
		// model.addAttribute("allNotice", nser.getAllNotice());
		return "/admin/notice";// jsp page
	}

	@PostMapping("/addnotice")
	public String addNotice(ModelMap model, @RequestParam String message, @RequestParam String name) {
		Notice notice = new Notice();
		Date date = new Date();
		notice.setDate(date.toString());
		notice.setMessage(message);
		notice.setName(name);
		if (nser.addNotice(notice))
			model.addAttribute("smsg", "Notice added successfully");
		else
			model.addAttribute("fmsg", "Notice not added");
		return "/admin/notice";// jsp page
	}

	@GetMapping("/viewnotice")
	public String viewNotice(ModelMap model) {
		model.addAttribute("allNotice", nser.getAllNotice());
		return "/admin/view_notice";
	}

	@GetMapping("/deletenotice/{id}")
	public String viewNotice(ModelMap model, @PathVariable int id) {
		if (nser.deleteNoticeById(id))
			model.addAttribute("smsg", "Notice deleted successfully");
		else
			model.addAttribute("fmsg", "Notice not deleted");
		model.addAttribute("allNotice", nser.getAllNotice());
		return "/admin/view_notice";
	}
}
