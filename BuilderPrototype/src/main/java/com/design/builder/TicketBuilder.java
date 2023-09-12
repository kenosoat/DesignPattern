package com.design.builder;

public abstract class TicketBuilder<T> {

    public abstract void setParam(String title, String userName);

    public abstract void setContent(String content);

    public abstract void setProduct(String product);

    public void setBankInfoAndCompanyName(String BankInfo,String companyName){}

    public abstract T buildTicket();
}

