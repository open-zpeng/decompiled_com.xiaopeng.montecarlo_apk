package com.xiaopeng.montecarlo.navcore.account;

import android.text.TextUtils;
import androidx.annotation.NonNull;
/* loaded from: classes2.dex */
public class XpUserData {
    private String mOpenId;
    private String mSid;
    private String mUserId;

    public void setUserId(String str) {
        this.mUserId = str;
    }

    public String getUserId() {
        return this.mUserId;
    }

    public void setSid(String str) {
        this.mSid = str;
    }

    public String getSid() {
        return this.mSid;
    }

    public void setOpenId(String str) {
        this.mOpenId = str;
    }

    public String getOpenId() {
        return this.mOpenId;
    }

    public XpUserData(String str) {
        this.mUserId = str;
    }

    public boolean isCurrentLoginUser() {
        return TextUtils.equals(this.mUserId, XPAccountServiceWrapper.getInstance().getUserId());
    }

    @NonNull
    public String toString() {
        return "XpUserData{mUserId='" + this.mUserId + "', mSid='" + this.mSid + "', mOpenId='" + this.mOpenId + "'}";
    }
}
