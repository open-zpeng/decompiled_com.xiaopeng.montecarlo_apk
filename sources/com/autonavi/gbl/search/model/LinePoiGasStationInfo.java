package com.autonavi.gbl.search.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class LinePoiGasStationInfo extends LinePoiBase implements Serializable {
    public boolean discount = false;
    public String gasType = "";
    public ArrayList<LinePoiGasPrice> gasPrices = new ArrayList<>();
}
