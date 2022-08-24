package com.project.mock.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.mock.model.Car;
import com.project.mock.model.ParkingLot;
import com.project.mock.sql.CarSql;
import com.project.mock.sql.ParkingLotSql;

@Controller(value = "car")
public class CarController{
	private CarSql carSql = new CarSql();
	private ParkingLotSql parkingLotSql= new ParkingLotSql();
    
	@RequestMapping(value = "/car",method = RequestMethod.GET)
	public ModelAndView carList(Model model, @RequestParam(value = "/car", required = false) Long page, 
			@RequestParam(value = "search", required = false) String search) {
		ModelAndView modelAndView = new ModelAndView("carlist.jsp");
		if(page != null) {
			model.addAttribute("listCar", carSql.findAll(Integer.valueOf(String.valueOf(page))));
		}
		else {
			model.addAttribute("listCar", carSql.findAll(1));
		}
		if(search != null) {
			model.addAttribute("listCar", carSql.search(search));
		}
		model.addAttribute("numPage", carSql.numPage());
		return modelAndView;
	}
	
	@RequestMapping(value = "/add-car",method = RequestMethod.GET)
	public ModelAndView addCarView(Model model) {
		ModelAndView modelAndView = new ModelAndView("addcar.jsp");
		model.addAttribute("car", new Car());
		model.addAttribute("listparking", parkingLotSql.findAll());
		return modelAndView;
	}
	
	@RequestMapping(value = "/add-car",method = RequestMethod.POST)
	public String addCar(@ModelAttribute Car car,HttpServletRequest request) {
		String idparking = request.getParameter("parking");
		ParkingLot parkingLot = parkingLotSql.findById(Long.valueOf(idparking));
		car.setParkingLot(parkingLot);
		carSql.save(car);
		return "redirect:car";
	}
	
	
	
	@RequestMapping(value = "/delete-car",method = RequestMethod.GET)
	public String deleteCar(@RequestParam(value = "id") String id) {
		carSql.delete(id);
		return "redirect:car";
	}
	
	@RequestMapping(value = "/update-car",method = RequestMethod.GET)
	public ModelAndView updateCarView(Model model,@RequestParam(value = "id") String id) {
		ModelAndView modelAndView = new ModelAndView("views/updatecar.jsp");
		model.addAttribute("car", carSql.findById(id));
		model.addAttribute("listparking", parkingLotSql.findAll());
		return modelAndView;
	}
	
	@RequestMapping(value = "/update-car",method = RequestMethod.POST)
	public String updateCar(@ModelAttribute Car car,HttpServletRequest request) {
		String idparking = request.getParameter("parking");
		ParkingLot parkingLot = parkingLotSql.findById(Long.valueOf(idparking));
		car.setParkingLot(parkingLot);
		carSql.update(car);
		return "redirect:car";
	}
}
