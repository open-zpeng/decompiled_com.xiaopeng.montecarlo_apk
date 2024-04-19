package com.autonavi.gbl.layer.model;

import com.autonavi.gbl.map.layer.model.BizAny;
import java.io.Serializable;
/* loaded from: classes.dex */
public class BizBusinessInfo implements Serializable {
    public String id;
    public BizAny userData;

    public BizBusinessInfo() {
        this.id = "";
        this.userData = new BizAny();
    }

    public BizBusinessInfo(String str, BizAny bizAny) {
        this.id = str;
        this.userData = bizAny;
    }
}
