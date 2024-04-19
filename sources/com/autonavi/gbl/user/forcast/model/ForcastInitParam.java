package com.autonavi.gbl.user.forcast.model;

import com.autonavi.gbl.util.model.DateTime;
import java.io.Serializable;
/* loaded from: classes2.dex */
public class ForcastInitParam implements Serializable {
    public String dbPath;
    public int nMaxEnergyMileage;
    public int nStatThreshold;
    public int nTopArrivedMaxCnt;
    public DateTime stCurTime;

    public ForcastInitParam() {
        this.nMaxEnergyMileage = 50;
        this.nTopArrivedMaxCnt = 8;
        this.nStatThreshold = 5;
        this.stCurTime = new DateTime();
        this.dbPath = "";
    }

    public ForcastInitParam(int i, int i2, int i3, DateTime dateTime, String str) {
        this.nMaxEnergyMileage = i;
        this.nTopArrivedMaxCnt = i2;
        this.nStatThreshold = i3;
        this.stCurTime = dateTime;
        this.dbPath = str;
    }
}
