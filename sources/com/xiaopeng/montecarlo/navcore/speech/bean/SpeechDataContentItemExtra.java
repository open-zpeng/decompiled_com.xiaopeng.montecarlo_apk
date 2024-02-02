package com.xiaopeng.montecarlo.navcore.speech.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
/* loaded from: classes2.dex */
public class SpeechDataContentItemExtra implements Serializable {
    @SerializedName("navi")
    private String mNavi;

    public String getNavi() {
        return this.mNavi;
    }

    public void setNavi(String str) {
        this.mNavi = str;
    }
}
