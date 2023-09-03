package com.design.pay.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PayType {
    AliPay("AliPay","支付宝支付"),
    WxPay("WxPay","微信支付"),
    UnionPay("UnionPay","银联支付");



    private String name;
    private String desc;
}
