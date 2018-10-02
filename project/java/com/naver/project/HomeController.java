package com.naver.project;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate);
		return "home";
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String goHome() {
		return "home";
	}

	@RequestMapping(value = "/stockBuyForm", method = RequestMethod.GET)
	public String stockInsertForm(Model model) {
		return "stock/stock_buy_form";
	}

	@RequestMapping(value = "/stockList", method = RequestMethod.GET)
	public String stockList(Model model) {
		return "stock/stock_list";
	}
	
	@Autowired
	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

		Calendar c1 = Calendar.getInstance();

		String strToday = sdf.format(c1.getTime());

		System.out.println("Today=" + strToday);
		
		String[] list = {"",""};
		ArrayList<String> list2 = new ArrayList<String>();
//		ArrayList<DBitem> list = dao.
//		for(int i = 0; i < list.size(); i++) {
//			String item = list.indexof(i).getName();
//			list2.add(item);
//		}
		list2.add("180906");
		list2.add(",");
		list2.add("12");
		list2.add("180907");
		list2.add(",");
		list2.add("25");
		list2.add("180908");
		list2.add(",");
		list2.add("31");
		list2.add("180909");
		list2.add(",");
		list2.add("28");
		list2.add("180910");
		list2.add(",");
		list2.add("30");
		list2.add("180911");
		list2.add(",");
		list2.add("35");
		list2.add("180912");
		list2.add(",");
		list2.add("32");
		list2.add("180913");
		list2.add(",");
		list2.add("29");
		list2.add("180914");
		list2.add(",");
		list2.add("27");
		list2.add("180915");
		list2.add(",");
		list2.add("33");
		list2.add("180916");
		list2.add(",");
		list2.add("36");
		list2.add("180917");
		list2.add(",");
		list2.add("30");
		list2.add("180918");
		list2.add(",");
		list2.add("30");
		list2.add("180919");
		list2.add(",");
		list2.add("32");
		list2.add("180920");
		list2.add(",");
		list2.add("29");
		list2.add("180921");
		list2.add(",");
		list2.add("35");
		list2.add("180922");
		list2.add(",");
		list2.add("33");
		list2.add("180923");
		list2.add(",");
		list2.add("31");
		list2.add("180924");
		list2.add(",");
		list2.add("31");
		list2.add("180925");
		list2.add(",");
		list2.add("30");
		list2.add("180926");
		list2.add(",");
		list2.add("32");
		
		String title = "Test_"+strToday;
		String filepath = "C:/Users/IT";
		int resultcount = 0;
		int today = 180906;
		
		try {
			BufferedWriter fw = new BufferedWriter(new FileWriter(filepath+"/"+title+".csv",true));
			fw.write("date");
			fw.write(',');
			fw.write("sales");
			fw.newLine();
			int i = 1;
			for(String dom : list2) {
				fw.write(today+i);
				fw.write(',');
				fw.write(dom);
				i++;
				if(i%3==0) {
					fw.newLine();	
				}
				resultcount++;
				i++;
				if(resultcount %100==0) {
				}
			}
			fw.flush();
			fw.close();
		}catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
}
