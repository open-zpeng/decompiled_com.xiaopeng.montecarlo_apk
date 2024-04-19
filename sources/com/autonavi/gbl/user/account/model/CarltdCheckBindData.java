package com.autonavi.gbl.user.account.model;

import com.autonavi.gbl.user.account.model.BindStatus;
import java.io.Serializable;
/* loaded from: classes2.dex */
public class CarltdCheckBindData implements Serializable {
    @BindStatus.BindStatus1
    public int hasBind;

    public CarltdCheckBindData() {
        this.hasBind = -1;
    }

    public CarltdCheckBindData(@BindStatus.BindStatus1 int i) {
        this.hasBind = i;
    }
}
