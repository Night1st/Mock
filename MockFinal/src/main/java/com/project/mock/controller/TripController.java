package com.project.mock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.mock.model.Trip;
import com.project.mock.sql.TripSql;

@Controller(value = "trip")
public class TripController{
	private TripSql tripSql = new TripSql();
       
	@RequestMapping(value = "/trip",method = RequestMethod.GET)
	public ModelAndView tripList(Model model, @RequestParam(value = "page", required = false) Long page, 
			@RequestParam(value = "search", required = false) String search) {
		ModelAndView modelAndView = new ModelAndView("triplist.jsp");
		if(page != null) {
			model.addAttribute("listTrip", tripSql.findAllByPage(Integer.valueOf(String.valueOf(page))));
		}
		else {
			model.addAttribute("listTrip", tripSql.findAllByPage(1));
		}
		if(search != null) {
			model.addAttribute("listTrip", tripSql.search(search));
		}
		model.addAttribute("numPage", tripSql.numPage());
		return modelAndView;
	}
	
	
	@RequestMapping(value = "/add-trip",method = RequestMethod.GET)
	public ModelAndView addTrip(Model model) {
		ModelAndView modelAndView = new ModelAndView("addtrip.jsp");
		model.addAttribute("trip", new Trip());
		return modelAndView;
	}
	
	@RequestMapping(value = "/add-trip",method = RequestMethod.POST)
	public String addTrip(@ModelAttribute Trip trip) {
		tripSql.save(trip);
		return "redirect:trip";
	}
	
	@RequestMapping(value = "/update-trip",method = RequestMethod.GET)
	public ModelAndView updateParkingLotView(Model model,@RequestParam(value = "id", required = true) Long id) {
		ModelAndView modelAndView = new ModelAndView("updateTrip.jsp");
		model.addAttribute("trip", tripSql.findById(id));
		return modelAndView;
	}
	
	@RequestMapping(value = "/update-trip",method = RequestMethod.POST)
	public String updateParkingLot(@ModelAttribute Trip trip) {
		tripSql.update(trip);
		return "redirect:trip";
	}
	
	@RequestMapping(value = "/delete-trip",method = RequestMethod.GET)
	public String delete(@RequestParam(value = "id", required = true) Long id) {
		try {
			tripSql.delete(id);
		} catch (Exception e) {
			return "Can't delete this trip";
		}
		return "redirect:trip";
	}

}
