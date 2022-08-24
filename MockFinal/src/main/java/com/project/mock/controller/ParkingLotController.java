package com.project.mock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.mock.model.ParkingLot;
import com.project.mock.sql.ParkingLotSql;

@Controller(value = "parkinglot")
public class ParkingLotController{
     
	private ParkingLotSql parkingLotSql = new ParkingLotSql();
	
	@RequestMapping(value = "/parkinglot",method = RequestMethod.GET)
	public ModelAndView parkingLotList(Model model, @RequestParam(value = "page", required = false) Long page, 
			@RequestParam(value = "search", required = false) String search) {
		ModelAndView modelAndView = new ModelAndView("parkinglotlist.jsp");
		if(page != null) {
			model.addAttribute("listParking", parkingLotSql.findAll(Integer.valueOf(String.valueOf(page))));
		}
		else {
			model.addAttribute("listParking", parkingLotSql.findAll(1));
		}
		if(search != null) {
			model.addAttribute("listParking", parkingLotSql.search(search));
		}
		model.addAttribute("numPage", parkingLotSql.numPage());
		return modelAndView;
	}
	
	@RequestMapping(value = "/add-parkinglot",method = RequestMethod.GET)
	public ModelAndView addParkingLotView(Model model) {
		ModelAndView modelAndView = new ModelAndView("addparkinglot.jsp");
		model.addAttribute("parkingLot", new ParkingLot());
		return modelAndView;
	}
	
	@RequestMapping(value = "/add-parkinglot",method = RequestMethod.POST)
	public String AddParkingLot(@ModelAttribute ParkingLot parkingLot) {
		parkingLotSql.save(parkingLot);
		System.out.println(parkingLot);
		return "redirect:parkinglot";
	}
	
	@RequestMapping(value = "/delete-parkinglot",method = RequestMethod.GET)
	public String delete(@RequestParam(value = "id", required = true) Long id) {
		try {
			parkingLotSql.delete(id);
		} catch (Exception e) {
			return "Can't delete this parking lot";
		}
		return "redirect:parkinglot";
	}
	
	@RequestMapping(value = "/update-parkinglot",method = RequestMethod.GET)
	public ModelAndView updateParkingLotView(Model model,@RequestParam(value = "id", required = true) Long id) {
		ModelAndView modelAndView = new ModelAndView("views/updateParkingLot.jsp");
		model.addAttribute("parkingLot", parkingLotSql.findById(id));
		return modelAndView;
	}
	
	@RequestMapping(value = "/update-parkinglot",method = RequestMethod.POST)
	public String updateParkingLot(@ModelAttribute ParkingLot parkingLot) {
		parkingLotSql.update(parkingLot);
		return "redirect:parkinglot";
	}

}
