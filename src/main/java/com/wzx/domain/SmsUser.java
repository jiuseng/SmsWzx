package com.wzx.domain;

import lombok.Data;

import java.util.Date;

@Data
public class SmsUser {
    private Integer smsId;

    private String smsUsername;

    private String smsPassword;

    private String smsName;

    private Date smsDate;

    private Date smsBirth;

    private String smsAddress;

    private Integer smsDelete;

}