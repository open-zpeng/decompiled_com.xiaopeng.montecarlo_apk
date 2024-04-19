package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class GWorkdayListResponseParam extends BLResponseBase implements Serializable {
    public int iSwitch = 0;
    public int year = 0;
    public ArrayList<String> vctWorkday = new ArrayList<>();
    public ArrayList<String> vctHoliday = new ArrayList<>();
}
