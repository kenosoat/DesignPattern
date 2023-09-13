package com.design.auditlog.impl;

import com.design.auditlog.AbstractAuditLogProcessor;
import com.design.pojo.AuditLog;

public class PayLogProcessor extends AbstractAuditLogProcessor {
    @Override
    public AuditLog details(AuditLog auditLog) {
        String orderNo = auditLog.getOrderNo();
        Object orderDetail = "根据订单查看支付信息";
        auditLog.setDetail(orderDetail);
        return auditLog;
    }
}
