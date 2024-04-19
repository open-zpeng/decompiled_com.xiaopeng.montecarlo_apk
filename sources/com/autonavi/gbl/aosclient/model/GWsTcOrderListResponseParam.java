package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class GWsTcOrderListResponseParam extends BLResponseBase implements Serializable {
    public int code = 0;
    public String message = "";
    public String timestamp = "";
    public String version = "";
    public int hasMore = 0;
    public ArrayList<WsTcOrderListResponseData> data = new ArrayList<>();
    public long nextPageMaxTs = 0;
}
