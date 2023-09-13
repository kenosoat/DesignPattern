package com.design.builder;

import com.design.constants.TicketConstant;
import com.design.pojo.PersonalTicket;

public class PersonalTicketBuilder extends TicketBuilder<PersonalTicket>{

    private PersonalTicket personalTicket = TicketConstant.personalTicket.clone();


    @Override
    public void setParam(String title, String userName) {
        personalTicket.setTitle(title);
        personalTicket.setUserName(userName);
    }

    @Override
    public void setContent(String content) {
        personalTicket.setContent(content);
    }

    @Override
    public void setProduct(String product) {
        personalTicket.setProduct(product);
    }

    @Override
    public PersonalTicket buildTicket() {
        return personalTicket;
    }
}
