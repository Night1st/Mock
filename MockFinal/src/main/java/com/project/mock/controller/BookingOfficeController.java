package com.project.mock.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.mock.model.BookingOffice;
import com.project.mock.sql.BookingOfficeSql;
import com.project.mock.sql.TripSql;

@Controller(value = "booking")
public class BookingOfficeController{
	private BookingOfficeSql bookingOfficeSql = new BookingOfficeSql();
	private TripSql tripSql = new TripSql();
       
	@RequestMapping(value = "/bookingoffice",method = RequestMethod.GET)
	public ModelAndView bookingList(Model model, @RequestParam(value = "page", required = false) Long page, 
			@RequestParam(value = "search", required = false) String search) {
		ModelAndView modelAndView = new ModelAndView("bookingofficelist.jsp");
		if(page != null) {
			model.addAttribute("listBooking", bookingOfficeSql.findAll(Integer.valueOf(String.valueOf(page))));
		}
		else {
			model.addAttribute("listBooking", bookingOfficeSql.findAll(1));
		}
		if(search != null) {
			model.addAttribute("listBooking", bookingOfficeSql.search(search));
		}
		model.addAttribute("numPage", bookingOfficeSql.numPage());
		return modelAndView;
	}

	@RequestMapping(value = "/add-bookingoffice",method = RequestMethod.GET)
	public ModelAndView AddBookingView(Model model) {
		ModelAndView modelAndView = new ModelAndView("addbookingoffice.jsp");
		model.addAttribute("bookingOffice", new BookingOffice());
		model.addAttribute("trip", tripSql.findAll());
		return modelAndView;
	}
	
	@RequestMapping(value = "/add-bookingoffice",method = RequestMethod.POST)
	public String AddBooking(@ModelAttribute BookingOffice bookingOffice,HttpServletRequest request) {
		String idTrip = request.getParameter("trips");
		bookingOffice.setTrip(tripSql.findById(Long.valueOf(idTrip)));
		bookingOfficeSql.save(bookingOffice);
		return "redirect:booking";
		
	}

}
