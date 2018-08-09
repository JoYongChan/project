package com.naver.project;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.naver.project.entities.Storemanagement;
import com.naver.project.service.StoremanagementDAO;

@Controller
public class LoginController {
	
	@Autowired				
	private SqlSession sqlSessoin;
	@Autowired
	private Storemanagement storemanagement;
	
	@RequestMapping(value = "/loginForm", method = RequestMethod.GET)
	public String loginForm(Model model) {
		return "login/login";
	}

	@RequestMapping(value = "/storeAdmin", method = RequestMethod.GET)
	public String storeAdmin(Model model) {
		return "register/store_insert_form";
	}
	
	@RequestMapping(value = "/storeInsert", method = RequestMethod.POST)
	public String storeInsert(Model model,@ModelAttribute Storemanagement storemanagement) {
		StoremanagementDAO dao = sqlSessoin.getMapper(StoremanagementDAO.class);
		dao.insertRow(storemanagement);
		
		
		return "login/login";
	}
	
	

	@RequestMapping(value = "/tableAccount", method = RequestMethod.GET)
	public String tableAccount(Model model) {
		return "register/table_insert_form";
	}

}
