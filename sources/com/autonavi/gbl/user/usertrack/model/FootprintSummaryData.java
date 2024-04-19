package com.autonavi.gbl.user.usertrack.model;

import com.autonavi.gbl.user.usertrack.model.FootprintSwitchStatus;
import java.io.Serializable;
/* loaded from: classes2.dex */
public class FootprintSummaryData implements Serializable {
    public SummaryModuleCity city;
    @FootprintSwitchStatus.FootprintSwitchStatus1
    public int curSwitch;
    public SummaryModuleDriver driver;
    public boolean isLogin;
    public SummaryModulePoint point;

    public FootprintSummaryData() {
        this.isLogin = false;
        this.curSwitch = 2;
        this.city = new SummaryModuleCity();
        this.driver = new SummaryModuleDriver();
        this.point = new SummaryModulePoint();
    }

    public FootprintSummaryData(boolean z, @FootprintSwitchStatus.FootprintSwitchStatus1 int i, SummaryModuleCity summaryModuleCity, SummaryModuleDriver summaryModuleDriver, SummaryModulePoint summaryModulePoint) {
        this.isLogin = z;
        this.curSwitch = i;
        this.city = summaryModuleCity;
        this.driver = summaryModuleDriver;
        this.point = summaryModulePoint;
    }
}
