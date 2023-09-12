package com.design.pojo;

import lombok.Data;

@Data
public class PersonalTicket implements Cloneable{
    private String type;
    private String footer;



    private String title;
    private String userName;

    private String content;
    private String product;

    @Override
    public PersonalTicket clone()  {
        PersonalTicket personalTicket = null;
        try {
            personalTicket = (PersonalTicket) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return personalTicket;
    }
}
