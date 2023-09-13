package com.design.auditlog;

import com.design.pojo.AuditLog;

public abstract class AbstractAuditLogProcessor {
    private final AuditLog buildAudit(String userName,String action, String orderId){
        AuditLog build = AuditLog.builder().user(userName).action(action).orderNo(orderId).build();
        return build;
    }
    // 各类审计日志实现
    public abstract AuditLog details(AuditLog auditLog);

    public final boolean sendToQueue(AuditLog auditLog){
        String tag = auditLog.getTag();

        // 根据tag/topic 将日志发送到消息队列
        return true;
    }

    public final boolean process(String userName,String action, String orderId){
        return sendToQueue(details(buildAudit(userName,action,orderId)));
    }
}
