package com.naver.project;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProductController {
	@RequestMapping(value = "/productStockList", method = RequestMethod.GET)
	public String productStockList(Model model) {
		return "product/productstock_list";
	}
	
	@RequestMapping(value = "/productStockInsertForm", method = RequestMethod.GET)
	public String productStockInsertForm(Model model) {
		return "product/productstock_insert_form";
	}
	
	@RequestMapping(value = "/productStockInsert", method = RequestMethod.GET)
	public String productStockInsert(Model model) {
		return "redirect:productStockList";
	}
	
	@RequestMapping(value = "/productStockUpdateForm", method = RequestMethod.GET)
	public String productStockUpdateForm(Model model) {
		return "product/productstock_update_form";
	}
	
	@RequestMapping(value = "/productStockUpdate", method = RequestMethod.GET)
	public String productStockUpdate(Model model) {
		return "redirect:productStockList";
	}
	
	@RequestMapping(value = "/productStockDelete", method = RequestMethod.GET)
	public String productStockDelete(Model model) {
		return "redirect:productStockList";
	}

	@RequestMapping(value = "/productBuyList", method = RequestMethod.GET)
	public String productBuyList(Model model) {
		return "product/productbuy_list";
	}
	
	@RequestMapping(value = "/productBuyInsertForm", method = RequestMethod.GET)
	public String productBuyInsertForm(Model model) {
		return "product/productbuy_insert_form";
	}
	
	@RequestMapping(value = "/productBuyInsert", method = RequestMethod.GET)
	public String productBuyInsert(Model model) {
		return "redirect:productBuyList";
	}
	
	@RequestMapping(value = "/productBuyUpdateForm", method = RequestMethod.GET)
	public String productBuyUpdateForm(Model model) {
		return "product/productbuy_update_form";
	}
	
	@RequestMapping(value = "/productBuyUpdate", method = RequestMethod.GET)
	public String productBuyUpdate(Model model) {
		return "redirect:productBuyList";
	}
	
	@RequestMapping(value = "/productBuyDelete", method = RequestMethod.GET)
	public String productBuyDelete(Model model) {
		return "redirect:productBuyList";
	}

	@RequestMapping(value = "/productList", method = RequestMethod.GET)
	public String productList(Model model) {
		return "product/product_list";
	}
	
	@RequestMapping(value = "/productInsertForm", method = RequestMethod.GET)
	public String productInsertForm(Model model) {
		return "product/product_insert_form";
	}
	
	@RequestMapping(value = "/productInsert", method = RequestMethod.GET)
	public String productInsert(Model model) {
		return "redirect:productList";
	}
	
	@RequestMapping(value = "/productUpdateForm", method = RequestMethod.GET)
	public String productUpdateForm(Model model) {
		return "product/product_update_form";
	}
	
	@RequestMapping(value = "/productUpdate", method = RequestMethod.GET)
	public String productUpdate(Model model) {
		return "redirect:productList";
	}
	
	@RequestMapping(value = "/productDelete", method = RequestMethod.GET)
	public String productDelete(Model model) {
		return "redirect:productList";
	}
}
