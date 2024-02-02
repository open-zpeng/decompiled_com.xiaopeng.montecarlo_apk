package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class WsAuthcarServiceProvisionData implements Serializable {
    public ArrayList<WsAuthcarTokenDataPermission> permissions;
    public ArrayList<WsAuthcarServiceProvisionDataProvisionError> provision_errors;
    public WsAuthcarTokenDataToken token;

    public WsAuthcarServiceProvisionData() {
        this.provision_errors = new ArrayList<>();
        this.token = new WsAuthcarTokenDataToken();
        this.permissions = new ArrayList<>();
    }

    public WsAuthcarServiceProvisionData(ArrayList<WsAuthcarServiceProvisionDataProvisionError> arrayList, WsAuthcarTokenDataToken wsAuthcarTokenDataToken, ArrayList<WsAuthcarTokenDataPermission> arrayList2) {
        this.provision_errors = arrayList;
        this.token = wsAuthcarTokenDataToken;
        this.permissions = arrayList2;
    }
}
