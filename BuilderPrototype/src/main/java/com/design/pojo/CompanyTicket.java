package com.design.pojo;

import lombok.Data;

@Data
public class CompanyTicket implements Cloneable{
    private String type;
    private String footer;

    private String userName;
    private String title;

    private String content;
    private String product;
    private String companyName;
    private String bankInfo;

    @Override
    public CompanyTicket clone() {
        CompanyTicket companyTicket = null;
        try {
            companyTicket = (CompanyTicket) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return companyTicket;
    }
}
