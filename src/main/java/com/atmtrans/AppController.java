package com.atmtrans;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppController {


	@Autowired
	private RouteService routeService;

	@Autowired
	private TicketService ticketService;
	
	@RequestMapping("/")
	public String viewHomePage(Model model) {

		
		return "index";
	}
	


	//Routes mapping

	@RequestMapping("/routes")
	public String showAllRoutes(Model model){
		List<Route> routeList = routeService.listAll();
		model.addAttribute("routeList", routeList);
		return "route_list";
	}

	@RequestMapping("/newroute")
	public String shoeNewRoutePage(Model model){
		Route route = new Route();
		model.addAttribute("route", route);
		return "new_route";
	}

	@RequestMapping(value = "/saveroute", method = RequestMethod.POST)
	public String saveProduct(@ModelAttribute("route") Route route) {
		routeService.save(route);

		return "redirect:/routes";
	}

    @RequestMapping("/deleteroute/{id}")
    public String deleteRoute(@PathVariable(name = "id") int id) {
        routeService.delete(id);
        return "redirect:/routes";
    }

    @RequestMapping("/editroute/{id}")
    public ModelAndView showEditRoutePage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("edit_route");
        Route route = routeService.get(id);
        mav.addObject("route", route);

        return mav;
    }

    //Tickets mapping

	@RequestMapping("/tickets")
	public String showAllTickets(Model model){
		List<Ticket> ticketList = ticketService.listAll();
		model.addAttribute("ticketList", ticketList);
		return "ticket_list";
	}

	@RequestMapping("/newticket/{id}")
    public ModelAndView shoeNewTicketPage(@PathVariable(name = "id") int id){
        ModelAndView mav = new ModelAndView("new_ticket");
	    Route route = routeService.get(id);
	    Ticket ticket = new Ticket();


        mav.addObject("route", route);
        mav.addObject("ticket", ticket);
        return mav;
	}

	@RequestMapping(value = "/saveticket", method = RequestMethod.POST)
	public String saveTicket(@ModelAttribute("ticket") Ticket ticket) {
		ticketService.save(ticket);

		return "redirect:/tickets";
	}

	@RequestMapping("/deleteticket/{id}")
	public String deleteTicket(@PathVariable(name = "id") int id) {
		ticketService.delete(id);
		return "redirect:/tickets";
	}





}
