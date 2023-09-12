package com.design.controller;


import com.design.query.TicketParam;
import com.design.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @RequestMapping("getTicket")
    public Object getTicket(@RequestBody TicketParam ticketParam){
        return ticketService.getTicket(ticketParam);
    }
}
