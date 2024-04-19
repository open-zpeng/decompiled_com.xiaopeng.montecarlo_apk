package com.xiaopeng.montecarlo.service.navi.type;

import android.text.TextUtils;
import com.google.gson.annotations.SerializedName;
import com.xiaopeng.montecarlo.navcore.speech.request.SpeechRequestFactory;
import com.xiaopeng.montecarlo.scenes.routescene.RouteSaveState;
/* loaded from: classes3.dex */
public final class Request {
    public static final int BACK_RESULT_BROADCAST = 2;
    public static final int BACK_RESULT_CALLBACK = 1;
    public static final int BACK_RESULT_END = 3;
    public static final int BACK_RESULT_IPCMESSAGE = 0;
    public static final int BACK_RESULT_LOGI = 3;
    public static final int BACK_RESULT_START = 0;
    @SerializedName("app_id")
    @RequestStringField(def = "", value = "setApp_id")
    private String mAppId;
    @SerializedName("back_type")
    @RequestIntField(def = 0, value = "setBack_type")
    private int mBackType = 0;
    @SerializedName("content")
    @RequestStringField(def = "", value = "setContent")
    private String mContent;
    @SerializedName("out_time")
    @RequestIntField(def = 5000, value = "setOut_time")
    private int mOutTime;
    @SerializedName(RouteSaveState.KEY_ROUTE_REQUEST_ID)
    @RequestIntField(def = 0, value = "setRequest_id")
    private int mRequestId;
    @SerializedName(SpeechRequestFactory.PARAM_WHAT)
    @RequestIntField(def = 0, value = "setWhat")
    private int mWhat;

    public String getApp_id() {
        return this.mAppId;
    }

    public void setApp_id(String str) {
        this.mAppId = str;
    }

    public int getRequest_id() {
        return this.mRequestId;
    }

    public void setRequest_id(int i) {
        this.mRequestId = i;
    }

    public String getContent() {
        return this.mContent;
    }

    public void setContent(String str) {
        this.mContent = str;
    }

    public int getWhat() {
        return this.mWhat;
    }

    public void setWhat(int i) {
        this.mWhat = i;
    }

    public int getBack_type() {
        return this.mBackType;
    }

    public void setBack_type(int i) {
        this.mBackType = i;
    }

    public void setOut_time(int i) {
        this.mOutTime = i;
    }

    public int getOut_time() {
        return this.mOutTime;
    }

    public boolean isValid() {
        int i;
        return !TextUtils.isEmpty(this.mAppId) && !TextUtils.isEmpty(this.mContent) && (i = this.mBackType) >= 0 && i <= 3;
    }

    public String toString() {
        return "Request{app_id='" + this.mAppId + "', request_id=" + this.mRequestId + ", content='" + this.mContent + "', what=" + this.mWhat + ", back_type=" + this.mBackType + ",out_time=" + this.mOutTime + '}';
    }
}
