package com.xiaopeng.montecarlo.navcore.speech.request;

import com.google.gson.annotations.SerializedName;
/* loaded from: classes3.dex */
public class SpeechRequest {
    @SerializedName("mExtra")
    private String mExtra;
    @SerializedName("mType")
    private int mType;

    protected boolean canEqual(Object obj) {
        return obj instanceof SpeechRequest;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof SpeechRequest) {
            SpeechRequest speechRequest = (SpeechRequest) obj;
            if (speechRequest.canEqual(this) && getType() == speechRequest.getType()) {
                String extra = getExtra();
                String extra2 = speechRequest.getExtra();
                return extra != null ? extra.equals(extra2) : extra2 == null;
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        String extra = getExtra();
        return ((getType() + 59) * 59) + (extra == null ? 43 : extra.hashCode());
    }

    public SpeechRequest setExtra(String str) {
        this.mExtra = str;
        return this;
    }

    public SpeechRequest setType(int i) {
        this.mType = i;
        return this;
    }

    public int getType() {
        return this.mType;
    }

    public String getExtra() {
        return this.mExtra;
    }

    public String toString() {
        return "SpeechRequest{type='" + this.mType + "',\n\textra='" + this.mExtra + "'}";
    }
}
