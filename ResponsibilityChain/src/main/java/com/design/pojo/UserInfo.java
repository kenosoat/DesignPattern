package com.design.pojo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class UserInfo {
    private String userName;
    private String openId;
    // 消费金额
    private BigDecimal consumeAmount;
    private String city;
    private boolean newUser;
    private Long dayCloseCount;
    private Long weekCloseCount;
}
