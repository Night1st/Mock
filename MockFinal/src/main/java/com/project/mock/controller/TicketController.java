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
import com.project.mock.model.Ticket;
import com.project.mock.model.Trip;
import com.project.mock.sql.CarSql;
import com.project.mock.sql.TicketSql;
import com.project.mock.sql.TripSql;

@Controller(value = "ticket")
public class TicketController{
	private TicketSql ticketSql = new TicketSql();
	private TripSql tripSql = new TripSql();
	private CarSql carSql = new CarSql();
       
	@RequestMapping(value = "/ticket",method = RequestMethod.GET)
	public ModelAndView ticketList(Model model, @RequestParam(value = "page", required = false) Long page, 
			@RequestParam(value = "search", required = false) String search) {
		ModelAndView modelAndView = new ModelAndView("ticketlist.jsp");
		if(page != null) {
			model.addAttribute("listTicket", ticketSql.findAll(Integer.valueOf(String.valueOf(page))));
		}
		else {
			model.addAttribute("listTicket", ticketSql.findAll(1));
		}
		if(search != null) {
			model.addAttribute("listTicket", ticketSql.search(search));
		}
		model.addAttribute("numPage", ticketSql.numPage());
		return modelAndView;
	}
	
	@RequestMapping(value = "/add-ticket",method = RequestMethod.GET)
	public ModelAndView addTicket(Model model) {
		ModelAndView modelAndView = new ModelAndView("addticket.jsp");
		model.addAttribute("tripList", tripSql.findAll());
		model.addAttribute("carList", carSql.findAll());
		model.addAttribute("ticket", new Ticket());
		return modelAndView;
	}
	
	@RequestMapping(value = "/add-ticket",method = RequestMethod.POST)
	public String addTicket(@ModelAttribute Ticket ticket,HttpServletRequest request) {
		String idTrip = request.getParameter("trips");
		String license = request.getParameter("license");
		Car car = carSql.findById(license);
		Trip trip = tripSql.findById(Long.valueOf(idTrip));
		ticket.setCar(car);
		ticket.setTrip(trip);
		System.out.println(ticket);
		ticketSql.save(ticket);
		return "redirect:ticket";
	}
	
	@RequestMapping(value = "/delete-ticket",method = RequestMethod.GET)
	public String deleteTicket(@RequestParam(value = "id") Long id) {
		ticketSql.delete(id);
		return "redirect:ticket";
	}

}
