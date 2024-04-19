package com.xiaopeng.montecarlo.navcore.httpclient.requests;

import com.google.gson.annotations.SerializedName;
/* loaded from: classes2.dex */
public class MapDataRequest {
    @SerializedName("content")
    private String mContent;
    @SerializedName("time_stamp")
    private long mTimeStamp;

    protected boolean canEqual(Object obj) {
        return obj instanceof MapDataRequest;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof MapDataRequest) {
            MapDataRequest mapDataRequest = (MapDataRequest) obj;
            if (mapDataRequest.canEqual(this) && getTimeStamp() == mapDataRequest.getTimeStamp()) {
                String content = getContent();
                String content2 = mapDataRequest.getContent();
                return content != null ? content.equals(content2) : content2 == null;
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        long timeStamp = getTimeStamp();
        String content = getContent();
        return ((((int) (timeStamp ^ (timeStamp >>> 32))) + 59) * 59) + (content == null ? 43 : content.hashCode());
    }

    public MapDataRequest setContent(String str) {
        this.mContent = str;
        return this;
    }

    public MapDataRequest setTimeStamp(long j) {
        this.mTimeStamp = j;
        return this;
    }

    public String toString() {
        return "MapDataRequest(mContent=" + getContent() + ", mTimeStamp=" + getTimeStamp() + ")";
    }

    public String getContent() {
        return this.mContent;
    }

    public long getTimeStamp() {
        return this.mTimeStamp;
    }
}
