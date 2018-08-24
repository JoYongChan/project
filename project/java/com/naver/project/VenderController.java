package com.naver.project;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class VenderController {
	
	@RequestMapping(value = "/venderList", method = RequestMethod.GET)
	public String venderList(Model model) {
		return "vender/vender_list";
	}
	
	@RequestMapping(value = "/venderInsertForm", method = RequestMethod.GET)
	public String venderInsertForm(Model model) {
		return "vender/vender_insert_form";
	}
	
	@RequestMapping(value = "/venderInsert", method = RequestMethod.GET)
	public String venderInsert(Model model) {
		return "redirect:venderList";
	}
	
	@RequestMapping(value = "/venderUpdateForm", method = RequestMethod.GET)
	public String venderUpdateForm(Model model, @RequestParam String venderproductcode) {
		return "vender/vender_update_form";
	}
	
	@RequestMapping(value = "/venderUpdate", method = RequestMethod.GET)
	public String venderUpdate(Model model) {
		return "redirect:venderList";
	}
	
	@RequestMapping(value = "/venderDelete", method = RequestMethod.GET)
	public String venderDelete(Model model) {
		return "redirect:venderList";
	}

	@RequestMapping(value = "/venderproductList", method = RequestMethod.GET)
	public String venderproductList(Model model) {
		return "vender/venderproduct_list";
	}
	
	@RequestMapping(value = "/venderproductInsertForm", method = RequestMethod.GET)
	public String venderproductInsertForm(Model model) {
		return "vender/venderproduct_insert_form";
	}
	
	@RequestMapping(value = "/venderproductInsert", method = RequestMethod.GET)
	public String venderproductInsert(Model model) {
		return "redirect:venderproductList";
	}
	
	@RequestMapping(value = "/venderproductUpdateForm", method = RequestMethod.GET)
	public String venderproductUpdateForm(Model model) {
		return "vender/venderproduct_update_form";
	}
	
	@RequestMapping(value = "/venderproductUpdate", method = RequestMethod.GET)
	public String venderproductUpdate(Model model) {
		return "redirect:venderproductList";
	}
	
	@RequestMapping(value = "/venderproductDelete", method = RequestMethod.GET)
	public String venderproductDelete(Model model) {
		return "redirect:venderproductList";
	}
}
