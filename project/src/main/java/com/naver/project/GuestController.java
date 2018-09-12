package com.naver.project;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.naver.project.entities.Guest;
import com.naver.project.service.GuestDao;

@Controller

public class GuestController {
	@Autowired
	private SqlSession sqlSession;
	@RequestMapping(value = "/guestInsertForm", method = RequestMethod.GET)
	public String guestInsertForm(Model model) {
		SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd");
		String date = sm.format(new Date());
		String curyyyy = date.substring(0,4);
		String curmm = date.substring(5,7);
		String curdd = date.substring(8,10);
		model.addAttribute("curyyyy", curyyyy);
		model.addAttribute("curmm", curmm);
		model.addAttribute("curdd", curdd);
		return "register/guest_insert_form";
	}
	@RequestMapping(value = "/guestListForm", method = RequestMethod.GET)
	public String guestListForm(Model model) {
		GuestDao guestdao = sqlSession.getMapper(GuestDao.class);
		ArrayList<Guest> gusets = guestdao.selectAll();
		model.addAttribute("gusets", gusets);
		return "register/guest_list_form";
	}
	
	@RequestMapping(value = "/guestInsert", method = RequestMethod.POST)
<<<<<<< HEAD
	public String guestInsert(@ModelAttribute Guest guest ) {
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm");
		guest.setInputdate(format.format(date));
		System.out.println("---------inputdate:"+guest.getInputdate());
		GuestDao guestdao = sqlSession.getMapper(GuestDao.class);
		guest.setBirthday(guest.getYyyy()+guest.getMm()+guest.getDd());
		guest.setPhone(guest.getPhone1()+guest.getPhone2()+guest.getPhone3());
		guestdao.insertRow(guest);
=======
	public String guestInsert(Model model, @ModelAttribute Guest guest) {
//		Date date = new Date();
//		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm");
//		member.setInputdate(format.format(date));
//		MemberDao dao = sqlSession.getMapper(MemberDao.class);
//		try {
//			String encodingPassowrd = passwordEncoder.encode(member.getPassword());
//			member.setPassword(encodingPassowrd);
//			int result = dao.insertRow(member);
//			if (result > 0) {
//				model.addAttribute("msg", "���� ���� �Ͽ����ϴ�");
//			}
//			System.out.println("success" + result);
//		} catch (Exception e) {
//			System.out.println("insert err:" + e.getMessage());
//		}
>>>>>>> cca2e0e7877dcac410d4d1bff6cf8b2ece401fc9

		return "home";
	}
	@RequestMapping(value = "/gusetUpdateForm", method = RequestMethod.GET)
	public String gusetUpdateForm(Model model, @RequestParam String phone,@ModelAttribute Guest guest) {
		GuestDao guestdao = sqlSession.getMapper(GuestDao.class);
		String birdate = guest.getBirthday();
		String biryyyy = birdate.substring(0,4);
		String birmm = birdate.substring(4,5);
		String birdd = birdate.substring(5);
		model.addAttribute("biryyyy", biryyyy);
		model.addAttribute("birmm", birmm);
		model.addAttribute("birdd", birdd);
		String phonenum = guest.getPhone();
		String phone1 = phonenum.substring(0,3);
		String phone2 = phonenum.substring(3,7);
		String phone3 = phonenum.substring(7,11);
		model.addAttribute("phone1", phone1);
		model.addAttribute("phone2", phone2);
		model.addAttribute("phone3", phone3);
		Guest guests = guestdao.selectOne(phone);
		model.addAttribute("guests", guests);
		return "register/guest_update_form";
	}
	@RequestMapping(value = "/gusetUpdate", method = RequestMethod.POST)
	public String gusetUpdate(@ModelAttribute Guest guest) {
		GuestDao guestdao = sqlSession.getMapper(GuestDao.class);
			guest.setBirthday(guest.getYyyy()+guest.getMm()+guest.getDd());
			guest.setPhone(guest.getPhone1()+guest.getPhone2()+guest.getPhone3());
			guestdao.updateRow(guest);
		
		return "home";
	}
	@RequestMapping(value = "/guestDelete", method = RequestMethod.GET)
	public String guestDelete(Model model, @RequestParam String phone,@ModelAttribute Guest guest) {
		GuestDao guestdao = sqlSession.getMapper(GuestDao.class);
//		guest.setBirthday(guest.getYyyy()+guest.getMm()+guest.getDd());
		guest.setPhone(guest.getPhone1()+guest.getPhone2()+guest.getPhone3());
		System.out.println(phone);
		guestdao.deleteRow(phone);
		
		return "home";
	}
<<<<<<< HEAD
=======

//	@RequestMapping(value = "/loginForm", method = RequestMethod.GET)
//	public String loginForm() {
//		return "login/login";
//	}

//	@RequestMapping(value = "/login", method = RequestMethod.POST)
//	public String login(@ModelAttribute Member member, HttpSession session) {
//		MemberDao dao = sqlSession.getMapper(MemberDao.class);
//		Member data = dao.login(member.getEmail());
//		if (data == null) {
//			return "login/login_fail";
//		} else {
//			boolean passchk = BCrypt.checkpw(member.getPassword(), data.getPassword());
//			System.out.println("---passchk:" + passchk);
//			if (passchk) {
//				session.setAttribute("sessionemail", data.getEmail());
//				session.setAttribute("sessionpassword", data.getPassword());
//				session.setAttribute("sessionname", data.getName());
//				session.setAttribute("sessionphoto", data.getPhoto());
//				return "redirect:index";
//			} else {
//				return "login/login_fail";
//			}
//		}
//	}
//
//	@RequestMapping(value = "/logOut", method = RequestMethod.GET)
//	public String logOut(HttpSession session) {
//		session.invalidate();
//		return "redirect:index";
//	}
//
//
//

//
//

//
//	@RequestMapping(value = "/memberSearch", method = RequestMethod.GET)
//	public String memberSearch(Model model) {
//		MemberDao dao = sqlSession.getMapper(MemberDao.class);
//		ArrayList<Member> members = dao.selectAll();
//		model.addAttribute("members", members);
//		return "member/member_search";
//	}
//
//	@RequestMapping(value = "/memberUpdateForm", method = RequestMethod.GET)
//	public String memberUpdateForm(Model model, @RequestParam String email) {
//		MemberDao dao = sqlSession.getMapper(MemberDao.class);
//		Member member = dao.selectOne(email);
//		String encodingPassowrd = passwordEncoder.encode(member.getPassword());
//		member.setPassword(encodingPassowrd);
//		model.addAttribute("member", member);
//		return "member/member_update_form";
//	}
//
//	@RequestMapping(value = "/memberUpdate", method = RequestMethod.POST)
//	public String memberUpdate(@ModelAttribute Member member, @RequestParam CommonsMultipartFile imgfile) {
//
//		String originalname = imgfile.getOriginalFilename();
//		String newfilename = "";
//		String realpath = "";
//		System.out.println("ori:" + originalname);
//		System.out.println("before:" + member.getBeforephoto());
//		if (originalname.equals("")) {
//			member.setPhoto(member.getBeforephoto());
//		} else {
//			int position = originalname.lastIndexOf(".");
//			String ext = originalname.substring(position);
//			newfilename = member.getEmail() + ext;
//			realpath = "resources/uploadattachs/";
//			try {
//				String path = "D:/ncs4webproject/ncs4project/src/main/webapp/resources/uploadattachs/";
//				member.setPhoto(realpath + newfilename);
//				byte bytes[] = imgfile.getBytes();
//				BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream(path + newfilename));
//				output.write(bytes);
//				output.flush();
//				output.close();
//			} catch (Exception e) {
//				// TODO: handle exception
//			}
//		}
//
//		MemberDao dao = sqlSession.getMapper(MemberDao.class);
//		try {
//			int result = dao.updateRow(member);
//			System.out.println("success" + result);
//		} catch (Exception e) {
//			System.out.println("insert err:" + e.getMessage());
//		}
//		return "member/member_result";
//	}
//
//	@RequestMapping(value = "/memberDelete", method = RequestMethod.GET)
//	public String memberDelete(Model model, @RequestParam String email) {
//		MemberDao dao = sqlSession.getMapper(MemberDao.class);
//		int result = dao.deleteRow(email);
//		if (result > 0) {
//			model.addAttribute("msg", "���� �Ǿ����ϴ�");
//		}
//		System.out.println("------>>>>" + result);
//		return "member/member_result";
//	}
>>>>>>> cca2e0e7877dcac410d4d1bff6cf8b2ece401fc9
}
