package com.autonavi.gbl.user.usertrack.model;

import com.autonavi.gbl.user.usertrack.model.FootprintSwitchStatus;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class FootprintNaviRecordData implements Serializable {
    @FootprintSwitchStatus.FootprintSwitchStatus1
    public int curSwitch;
    public boolean isLogin;
    public ArrayList<FootprintNaviRecord> record;

    public FootprintNaviRecordData() {
        this.isLogin = false;
        this.curSwitch = 2;
        this.record = new ArrayList<>();
    }

    public FootprintNaviRecordData(boolean z, @FootprintSwitchStatus.FootprintSwitchStatus1 int i, ArrayList<FootprintNaviRecord> arrayList) {
        this.isLogin = z;
        this.curSwitch = i;
        this.record = arrayList;
    }
}
