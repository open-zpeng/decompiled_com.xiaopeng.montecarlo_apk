package com.autonavi.gbl.activation.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class AuthenticationGoodsInfo implements Serializable {
    public AuthenticationInfo authenticationInfo;
    public ArrayList<AuthenticationFunctionInfo> functionList;
    public String goodsName;
    public String sid;

    public AuthenticationGoodsInfo() {
        this.goodsName = "";
        this.sid = "";
        this.authenticationInfo = new AuthenticationInfo();
        this.functionList = new ArrayList<>();
    }

    public AuthenticationGoodsInfo(String str, String str2, AuthenticationInfo authenticationInfo, ArrayList<AuthenticationFunctionInfo> arrayList) {
        this.goodsName = str;
        this.sid = str2;
        this.authenticationInfo = authenticationInfo;
        this.functionList = arrayList;
    }
}
