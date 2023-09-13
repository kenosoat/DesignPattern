package com.design.auditlog.impl;

import com.design.auditlog.AbstractAuditLogProcessor;
import com.design.pojo.AuditLog;

public class LoginLogProcessor extends AbstractAuditLogProcessor {
    @Override
    public AuditLog details(AuditLog auditLog) {
        auditLog.setDetail("登录时间");
        return auditLog;
    }
}
