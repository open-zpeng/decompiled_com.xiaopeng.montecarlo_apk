package com.xiaopeng.montecarlo.navcore.search;

import com.autonavi.gbl.common.model.RectFloat;
import com.google.gson.JsonObject;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import java.util.List;
/* loaded from: classes2.dex */
public class XPSearchResult {
    private Object[] mData;
    private JsonObject mJsonObject;
    private String mMsg;
    protected int mRequestId;
    protected int mResultCode = 0;
    protected List<XPPoiInfo> mXPPoiInfos = null;
    private RectFloat mRectFloat = null;
    private boolean mNeedLocation = false;

    public void cloneToObject(XPSearchResult xPSearchResult) {
        xPSearchResult.setRequestId(this.mRequestId);
        xPSearchResult.setResultCode(this.mResultCode);
        xPSearchResult.setXPPoiInfos(this.mXPPoiInfos);
        xPSearchResult.setRectFloat(this.mRectFloat);
        xPSearchResult.setNeedLocation(this.mNeedLocation);
    }

    public int getResultCode() {
        return this.mResultCode;
    }

    public void setResultCode(int i) {
        this.mResultCode = i;
    }

    public int getRequestId() {
        return this.mRequestId;
    }

    public void setRequestId(int i) {
        this.mRequestId = i;
    }

    public List<XPPoiInfo> list() {
        return this.mXPPoiInfos;
    }

    public List<XPPoiInfo> getXPPoiInfos() {
        return this.mXPPoiInfos;
    }

    public void setXPPoiInfos(List<XPPoiInfo> list) {
        this.mXPPoiInfos = list;
    }

    public RectFloat getRectFloat() {
        return this.mRectFloat;
    }

    public void setRectFloat(RectFloat rectFloat) {
        this.mRectFloat = rectFloat;
    }

    public boolean isNeedLocation() {
        return this.mNeedLocation;
    }

    public void setNeedLocation(boolean z) {
        this.mNeedLocation = z;
    }

    public JsonObject getJsonObject() {
        return this.mJsonObject;
    }

    public void setJsonObject(JsonObject jsonObject) {
        this.mJsonObject = jsonObject;
    }

    public String getMsg() {
        return this.mMsg;
    }

    public void setMsg(String str) {
        this.mMsg = str;
    }

    public Object[] getData() {
        return this.mData;
    }

    public void setData(Object... objArr) {
        this.mData = objArr;
    }
}
