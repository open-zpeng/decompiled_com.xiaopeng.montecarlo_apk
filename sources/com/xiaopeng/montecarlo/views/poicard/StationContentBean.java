package com.xiaopeng.montecarlo.views.poicard;

import com.google.gson.annotations.SerializedName;
import com.xiaopeng.montecarlo.IntentActions;
import com.xiaopeng.montecarlo.navcore.search.param.CPSearchParam;
import com.xiaopeng.speech.vui.constants.VuiConstants;
/* loaded from: classes3.dex */
public class StationContentBean {
    public static final int ACTION_DRIVE_IN = 1;
    public static final int ACTION_DRIVE_OUT = 2;
    @SerializedName(IntentActions.ActionsKey.KEY_ACTION)
    private int mAction;
    @SerializedName(VuiConstants.ELEMENT_ID)
    private String mId;
    @SerializedName(CPSearchParam.PARAM_KEY_LAT)
    private String mLat;
    @SerializedName(CPSearchParam.PARAM_KEY_LNG)
    private String mLng;
    @SerializedName("name")
    private String mName;

    public int getAction() {
        return this.mAction;
    }

    public void setAction(int i) {
        this.mAction = i;
    }

    public String getId() {
        return this.mId;
    }

    public void setId(String str) {
        this.mId = str;
    }

    public String getLat() {
        return this.mLat;
    }

    public void setLat(String str) {
        this.mLat = str;
    }

    public String getLng() {
        return this.mLng;
    }

    public void setLng(String str) {
        this.mLng = str;
    }

    public String getName() {
        return this.mName;
    }

    public void setName(String str) {
        this.mName = str;
    }

    public String toString() {
        return "StationContentBean{action=" + this.mAction + ", id='" + this.mId + "', lat='" + this.mLat + "', lng='" + this.mLng + "', name='" + this.mName + "'}";
    }
}
