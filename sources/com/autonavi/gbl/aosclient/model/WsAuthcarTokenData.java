package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class WsAuthcarTokenData implements Serializable {
    public ArrayList<WsAuthcarTokenDataPermission> permissions;
    public WsAuthcarTokenDataToken token;

    public WsAuthcarTokenData() {
        this.token = new WsAuthcarTokenDataToken();
        this.permissions = new ArrayList<>();
    }

    public WsAuthcarTokenData(WsAuthcarTokenDataToken wsAuthcarTokenDataToken, ArrayList<WsAuthcarTokenDataPermission> arrayList) {
        this.token = wsAuthcarTokenDataToken;
        this.permissions = arrayList;
    }
}
