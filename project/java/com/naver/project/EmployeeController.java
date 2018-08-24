package com.naver.project;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.naver.project.entities.Commute;
import com.naver.project.entities.Employee;
import com.naver.project.entities.Salary;
import com.naver.project.entities.Storemanagement;
import com.naver.project.service.CommuteDAO;
import com.naver.project.service.EmployeeDAO;
import com.naver.project.service.SalaryDAO;
import com.naver.project.service.StoremanagementDAO;

@Controller
public class EmployeeController {
	@Autowired				
	private SqlSession sqlSessoin;
	@Autowired
	private Employee employee;
	@Autowired
	private Commute commute;
	
	@RequestMapping(value = "/employeeInsertForm", method = RequestMethod.GET)
	public String employeeInsertForm(Model model) {
		StoremanagementDAO dao = sqlSessoin.getMapper(StoremanagementDAO.class);
		ArrayList<Storemanagement> storemanagements = dao.selectAll();
		model.addAttribute("storemanagements",storemanagements);
		return "employee/employee_insert_form";
	}
	
	@RequestMapping(value = "/empcodeConfirm", method = RequestMethod.POST)
	@ResponseBody
	public int empcodeConfirm(@RequestParam String empcode) {
		EmployeeDAO dao = sqlSessoin.getMapper(EmployeeDAO.class);
		int exist =0;
		exist= dao.selectEmpConfirm(empcode);
		
		return exist;
	}
	
	@RequestMapping(value = "/employeeInsert", method = RequestMethod.POST)
	public String employeeInsert(Model model,@ModelAttribute Employee employee,@RequestParam CommonsMultipartFile imgfile) {
		String originalname = imgfile.getOriginalFilename();
		int position = originalname.lastIndexOf(".");	//마지막 . 위치
		String strempcode = employee.getEmpcode();  
		String ext ="";
		String newfilename="";
		String realpath = "";
		String path = "C:/Users/IT/Desktop/sourcetree/project/src/main/webapp/resources/empphoto/";
		//이미지 디폴트
		if(originalname.equals("")) {
			ext = ".png";
			newfilename ="noimage1.png";
			realpath = "resources/img/";
		}else {
			ext = originalname.substring(position);//마지막부터 끝까지
			newfilename = strempcode+ext;
			realpath = "resources/empphoto/";
			try {
				byte bytes[] = imgfile.getBytes();
				BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream(path+newfilename));
				output.write(bytes);
				output.flush();
				output.close();
			} catch (Exception e) {
				System.out.println("error: "+e.getMessage());
			}
		}
		employee.setPhoto(realpath+newfilename);
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		employee.setHiredate(format.format(date));
		EmployeeDAO dao = sqlSessoin.getMapper(EmployeeDAO.class);
		dao.insertRow(employee);
		
		return "redirect:employeeListForm";
	}
	
	@RequestMapping(value = "/employeeListForm", method = RequestMethod.GET)
	public String employeeListForm(Model model) {
		EmployeeDAO dao = sqlSessoin.getMapper(EmployeeDAO.class);
		ArrayList<Employee> employees = dao.selectAll();
		model.addAttribute("employees", employees);
		
		return "employee/employee_list_form";
	}
	
	@RequestMapping(value = "/employeeDetail", method = RequestMethod.GET)
	public String employeeDetail(Model model, String empcode) {
		EmployeeDAO dao = sqlSessoin.getMapper(EmployeeDAO.class);
		Employee employee = dao.selectOne(empcode);
		model.addAttribute("employee",employee);
		StoremanagementDAO storedao = sqlSessoin.getMapper(StoremanagementDAO.class);
		ArrayList<Storemanagement> storemanagements = storedao.selectAll();
		model.addAttribute("storemanagements",storemanagements);
		
		return "employee/employee_update_form";
	}
	
	@RequestMapping(value = "/employeeUpdateForm", method = RequestMethod.POST)
	public String employeeUpdateForm(Model model,@ModelAttribute Employee employee,@RequestParam CommonsMultipartFile imgfile) {
		String originalname = imgfile.getOriginalFilename();
		String strempcode = employee.getEmpcode();  
		String newfilename="";
		String realpath = "";
		//이미지 디폴트
		if(originalname.equals("")) {
			employee.setPhoto(employee.getBeforephoto());
		}else {
			int position = originalname.lastIndexOf(".");	//마지막 . 위치
			String ext = originalname.substring(position);//마지막부터 끝까지
			newfilename = strempcode+ext;
			realpath = "resources/empphoto/";
			try {
				String path = "C:/Users/IT/Desktop/sourcetree/project/src/main/webapp/resources/empphoto/";
				employee.setPhoto(realpath+newfilename);
				byte bytes[] = imgfile.getBytes();
				BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream(path+newfilename));
				output.write(bytes);
				output.flush();
				output.close();
			} catch (Exception e) {
				System.out.println("error: "+e.getMessage());
			}
		}
		EmployeeDAO dao = sqlSessoin.getMapper(EmployeeDAO.class);
		dao.updateRow(employee);
		
		return "redirect:employeeListForm";
	}
	
	@RequestMapping(value = "/employeeDelete", method = RequestMethod.GET)
	public String employeeDelete(Model model,@ModelAttribute Employee employee) {
		EmployeeDAO dao = sqlSessoin.getMapper(EmployeeDAO.class);
		dao.deleteRow(employee);
		
		return "redirect:employeeListForm";
	}
	
	@RequestMapping(value = "/employeeSalaryForm", method = RequestMethod.GET)
	public String employeeSalaryForm(Model model) {
		EmployeeDAO dao = sqlSessoin.getMapper(EmployeeDAO.class);
		ArrayList<Employee> employee = dao.selectAll();
		model.addAttribute("employee",employee);
		return "employee/employee_salary_form";
	}
	
	@RequestMapping(value = "/employeeSelected", method = RequestMethod.POST)	
	@ResponseBody
	public Employee employeeSelected(@RequestParam String empcode) {
		EmployeeDAO dao = sqlSessoin.getMapper(EmployeeDAO.class);
		employee = dao.selectOne(empcode);
		return employee;
	}
	
	//salary insert
	@RequestMapping(value = "/employeeSalary", method = RequestMethod.POST)	
	public String employeeSalary(@ModelAttribute Salary salary) {
		SalaryDAO dao = sqlSessoin.getMapper(SalaryDAO.class);
		dao.insertSalaryRow(salary);
		
		return "redirect:employeeSalaryListForm";
	}
	
	@RequestMapping(value = "/employeeSalaryListForm", method = RequestMethod.GET)
	public String employeeSalaryListForm(Model model) {
		SalaryDAO dao = sqlSessoin.getMapper(SalaryDAO.class);
		ArrayList<Salary> salarys = dao.selectSalaryAll();
		model.addAttribute("salarys",salarys);
		return "employee/employee_salary_list_form";
	}
	
	@RequestMapping(value = "/salaryDetail", method = RequestMethod.GET)
	public String salaryDetail(Model model, String empcode) {
		SalaryDAO dao = sqlSessoin.getMapper(SalaryDAO.class);
		Salary salary = dao.selectOne(empcode);
		model.addAttribute("salary",salary);
		
		return "employee/employee_salary_update_form";
	}
	
	@RequestMapping(value = "/employeeSalaryUpdateForm", method = RequestMethod.POST)
	public String employeeSalaryUpdateForm(Model model,@ModelAttribute Salary salary) {
		SalaryDAO dao = sqlSessoin.getMapper(SalaryDAO.class);
		dao.updateSalaryRow(salary);
		
		return "redirect:employeeSalaryListForm";
	}
	
	@RequestMapping(value = "/employeeSalaryDelete", method = RequestMethod.GET)
	public String employeeSalaryDelete(Model model,@ModelAttribute Salary salary) {
		SalaryDAO dao = sqlSessoin.getMapper(SalaryDAO.class);
		dao.deleteSalaryRow(salary);
		
		return "redirect:employeeSalaryListForm";
	}
	
	//근태commute
	@RequestMapping(value = "/employeeCommuteInsertForm", method = RequestMethod.GET)
	public String employeeCommuteInsertForm(Model model) {
		EmployeeDAO dao = sqlSessoin.getMapper(EmployeeDAO.class);
		ArrayList<Employee> commuteemployee = dao.selectAll();
		model.addAttribute("commuteemployee",commuteemployee);
		return "commute/employee_commute_insert_form";
	}
	
	@RequestMapping(value = "/employeeCommuteInsert", method = RequestMethod.POST)
	public String employeeCommuteInsert(Model model,@ModelAttribute Commute commute) {
		CommuteDAO dao = sqlSessoin.getMapper(CommuteDAO.class);
		Date date = new Date();
		SimpleDateFormat yymmdd = new SimpleDateFormat("yyyy-MM-dd");
		commute.setCommutedate(yymmdd.format(date));
		SimpleDateFormat hhmmss = new SimpleDateFormat("HH:mm:ss");
		commute.setAttendancetime(hhmmss.format(date));
		
		dao.insertRow(commute);
		
		return "redirect:employeeCommuteListForm";
	}
	
	@RequestMapping(value = "/employeeCommuteListForm", method = RequestMethod.GET)
	public String employeeCommuteListForm(Model model) {
		CommuteDAO dao = sqlSessoin.getMapper(CommuteDAO.class);
		ArrayList<Commute> commutes = dao.selectAll();
		model.addAttribute("commutes", commutes);
		
		return "commute/employee_commute_list_form";
	}
	
	@RequestMapping(value = "/employeeCommuteDetail", method = RequestMethod.GET)
	public String employeeCommuteDetail(Model model, String empcode,@ModelAttribute Commute commute) {
		CommuteDAO dao = sqlSessoin.getMapper(CommuteDAO.class);
		HashMap commutesearch = new HashMap();
		commutesearch.put("empcode",commute.getEmpcode());
		commutesearch.put("commutedate",commute.getCommutedate());
		Commute commute1 = dao.selectOne(commutesearch);
		model.addAttribute("commute1",commute1);
		
		return "commute/employee_commute_update_form";
	}
	
	@RequestMapping(value = "/employeeCommuteUpdate", method = RequestMethod.POST)
	public String employeeCommuteUpdate(Model model,@ModelAttribute Commute commute) {
		CommuteDAO dao = sqlSessoin.getMapper(CommuteDAO.class);
		Date date = new Date();
		SimpleDateFormat leaveworkhhmmss = new SimpleDateFormat("HH:mm:ss");
		commute.setLeaveworktime(leaveworkhhmmss.format(date));
		dao.updateRow(commute);
		return "redirect:employeeCommuteListForm";
	}
	
	@RequestMapping(value = "/employeeCommuteDelete", method = RequestMethod.GET)
	public String employeeCommuteDelete(Model model,@ModelAttribute Commute commute) {
		CommuteDAO dao = sqlSessoin.getMapper(CommuteDAO.class);
		dao.deleteRow(commute);
		
		return "redirect:employeeCommuteListForm";
	}
	
}
