package com.design.builder;

import com.design.constants.TicketConstant;
import com.design.pojo.CompanyTicket;

public class CompanyTicketBuilder extends TicketBuilder<CompanyTicket>{

    private CompanyTicket companyTicket = TicketConstant.companyTicket.clone();
    @Override
    public void setParam(String title, String userName) {
        companyTicket.setTitle(title);
        companyTicket.setUserName(userName);
    }

    @Override
    public void setContent(String content) {
        companyTicket.setContent(content);
    }

    @Override
    public void setProduct(String product) {
        companyTicket.setProduct(product);
    }

    @Override
    public void setBankInfoAndCompanyName(String bankInfo, String companyName) {
        companyTicket.setBankInfo(bankInfo);
        companyTicket.setCompanyName(companyName);
    }

    @Override
    public CompanyTicket buildTicket() {
        return companyTicket;
    }
}
