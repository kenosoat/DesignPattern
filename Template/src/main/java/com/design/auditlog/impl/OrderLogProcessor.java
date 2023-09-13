package com.design.auditlog.impl;

import com.design.auditlog.AbstractAuditLogProcessor;
import com.design.pojo.AuditLog;

public class OrderLogProcessor extends AbstractAuditLogProcessor {
    @Override
    public AuditLog details(AuditLog auditLog) {
        String orderNo = auditLog.getOrderNo();
        Object orderDetail = "根据订单id获取订单信息";
        auditLog.setDetail(orderDetail);
        return auditLog;
    }
}
