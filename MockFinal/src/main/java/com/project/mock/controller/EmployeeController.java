package com.project.mock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.mock.model.Employee;
import com.project.mock.sql.EmployeeSql;

@Controller(value = "employee")
public class EmployeeController {

	private EmployeeSql emp = new EmployeeSql();
	
	@RequestMapping(value = "/employee",method = RequestMethod.GET)
	public ModelAndView employeeList(Model model, @RequestParam(value = "page", required = false) Long page, 
			@RequestParam(value = "search", required = false) String search) {
		ModelAndView modelAndView = new ModelAndView("employeelist.jsp");
		if(page != null) {
			model.addAttribute("listEmployee", emp.findAll(Integer.valueOf(String.valueOf(page))));
		}
		else {
			model.addAttribute("listEmployee", emp.findAll(1));
		}
		if(search != null) {
			model.addAttribute("listEmployee", emp.search(search));
		}
		model.addAttribute("numPage", emp.numPage());
		return modelAndView;
	}
	
	@RequestMapping(value = "/error-add-employee",method = RequestMethod.GET)
	public ModelAndView error(Model model) {
		ModelAndView modelAndView = new ModelAndView("views/error/employeeError.jsp");
		return modelAndView;
	}
	
	@RequestMapping(value = "/add-employee",method = RequestMethod.GET)
	public ModelAndView AddEmployeeView(Model model) {
		ModelAndView modelAndView = new ModelAndView("addemployee.jsp");
		model.addAttribute("employee", new Employee());
		return modelAndView;
	}
	
	@RequestMapping(value = "/add-employee",method = RequestMethod.POST)
	public String AddEmployee(@ModelAttribute Employee employee) {
		if(checkPassword(employee.getPassword())) {
			emp.save(employee);
			return "redirect:employee";
		}
		else {
			return "redirect:error-add-employee";
		}
		
	}
	
	public boolean checkPassword(String password) {
		String regex = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{6,}";
		return password.matches(regex);
	
	}
	
	@RequestMapping(value = "/detail-employee",method = RequestMethod.GET)
	public ModelAndView detailEmployeeView(Model model,@RequestParam(value = "id") Long id) {
		ModelAndView modelAndView = new ModelAndView("employeedetail.jsp");
		System.out.println(emp.findById(id));
		model.addAttribute("employee", emp.findById(id));
		model.addAttribute("id", id);
		return modelAndView;
	}
	
	@RequestMapping(value = "/update-employee",method = RequestMethod.POST)
	public String deleteEmployee(@ModelAttribute Employee employee) {
		emp.update(employee);
		return "redirect:employee";
	}
	
	@RequestMapping(value = "/delete-employee",method = RequestMethod.GET)
	public String updateEmployee(@RequestParam(value = "id") Long id) {
		emp.delete(id);
		return "redirect:employee";
	}
	
	
}

