package com.xiaopeng.montecarlo.navcore.database.bean.greendao;

import com.google.gson.annotations.SerializedName;
import com.lzy.okgo.cache.CacheEntity;
import com.xiaopeng.speech.vui.constants.VuiConstants;
import java.util.Date;
/* loaded from: classes3.dex */
public class XPWebConfigInfo {
    @SerializedName(VuiConstants.ELEMENT_ID)
    private Long id;
    @SerializedName(CacheEntity.KEY)
    private String key;
    @SerializedName("updateTime")
    private Date updateTime;
    @SerializedName("value")
    private String value;

    public XPWebConfigInfo(Long l, String str, String str2, Date date) {
        this.id = l;
        this.key = str;
        this.value = str2;
        this.updateTime = date;
    }

    public XPWebConfigInfo() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long l) {
        this.id = l;
    }

    public String getKey() {
        return this.key;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String str) {
        this.value = str;
    }

    public Date getUpdateTime() {
        return this.updateTime;
    }

    public void setUpdateTime(Date date) {
        this.updateTime = date;
    }
}
