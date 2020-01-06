package com.wzx.domain;

import lombok.Data;

@Data
public class SmsPermission {
    private Integer id;

    private Integer perParentid;

    private String parIcon;

    private String perParentmenu;

    private Integer perSonid;

    private String sonIcon;

    private String perSonmenu;

    private String perUrl;

    private Integer parentSon;

}