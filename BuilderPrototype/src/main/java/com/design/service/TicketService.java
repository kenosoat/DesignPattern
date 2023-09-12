package com.design.service;

import com.design.builder.CompanyTicketBuilder;
import com.design.builder.PersonalTicketBuilder;
import com.design.builder.TicketBuilder;
import com.design.query.TicketParam;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class TicketService {

    public Object getTicket(TicketParam ticketParam) {
        TicketBuilder ticketBuilder = null;
        if(!Objects.isNull(ticketParam.getBankInfo())&&!ticketParam.getBankInfo().equals("")){
            ticketBuilder = new CompanyTicketBuilder();
        }else{
            ticketBuilder = new PersonalTicketBuilder();
        }
        ticketBuilder.setParam(ticketParam.getTitle(),ticketParam.getUserName());
        ticketBuilder.setBankInfoAndCompanyName(ticketParam.getBankInfo(),ticketParam.getCompanyName());
        ticketBuilder.setProduct("select from product");
        ticketBuilder.setContent("select from content");
        return ticketBuilder.buildTicket();
    }
}
