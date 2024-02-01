package com.alibaba.android.ark;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public final class AIMGroupCreateGroupConvParam implements Serializable {
    private static final long serialVersionUID = -7940541324313466734L;
    public String bizType;
    public HashMap<String, String> ctx;
    public HashMap<String, String> ext;
    public String icon;
    public HashMap<String, String> operatorExtension;
    public String operatorNick;
    public String parentId;
    public String title;
    public ArrayList<AIMGroupUserInfo> userInfos;

    public AIMGroupCreateGroupConvParam(ArrayList<AIMGroupUserInfo> arrayList, String str, String str2, String str3, HashMap<String, String> hashMap, HashMap<String, String> hashMap2, String str4, HashMap<String, String> hashMap3, String str5) {
        this.userInfos = arrayList;
        this.title = str;
        this.icon = str2;
        this.bizType = str3;
        this.ext = hashMap;
        this.ctx = hashMap2;
        this.operatorNick = str4;
        this.operatorExtension = hashMap3;
        this.parentId = str5;
    }

    public AIMGroupCreateGroupConvParam() {
    }

    public ArrayList<AIMGroupUserInfo> getUserInfos() {
        return this.userInfos;
    }

    public String getTitle() {
        return this.title;
    }

    public String getIcon() {
        return this.icon;
    }

    public String getBizType() {
        return this.bizType;
    }

    public HashMap<String, String> getExt() {
        return this.ext;
    }

    public HashMap<String, String> getCtx() {
        return this.ctx;
    }

    public String getOperatorNick() {
        return this.operatorNick;
    }

    public HashMap<String, String> getOperatorExtension() {
        return this.operatorExtension;
    }

    public String getParentId() {
        return this.parentId;
    }

    public String toString() {
        return "AIMGroupCreateGroupConvParam{userInfos=" + this.userInfos + ",title=" + this.title + ",icon=" + this.icon + ",bizType=" + this.bizType + ",ext=" + this.ext + ",ctx=" + this.ctx + ",operatorNick=" + this.operatorNick + ",operatorExtension=" + this.operatorExtension + ",parentId=" + this.parentId + "}";
    }
}
