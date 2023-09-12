package com.design.constants;

import com.design.pojo.CompanyTicket;
import com.design.pojo.PersonalTicket;

public class TicketConstant {
    public static final PersonalTicket personalTicket = new PersonalTicket();
    public static final CompanyTicket companyTicket = new CompanyTicket();

    static {
        personalTicket.setFooter("footer");
        personalTicket.setType("personal");

        companyTicket.setFooter("footer");
        companyTicket.setType("company");
    }
}
