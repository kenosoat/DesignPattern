package com.design.pojo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuditLog {
    private String user;
    private String action;
    private String orderNo;
    private Object detail;
    private String tag;
}
