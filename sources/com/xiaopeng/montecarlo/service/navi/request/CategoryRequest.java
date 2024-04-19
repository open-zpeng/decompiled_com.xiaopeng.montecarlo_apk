package com.xiaopeng.montecarlo.service.navi.request;

import com.google.gson.annotations.SerializedName;
import com.xiaopeng.montecarlo.navcore.speech.voicefusion.VoiceFusionUtil;
/* loaded from: classes3.dex */
public class CategoryRequest {
    @SerializedName("category")
    public String mCategory;
    @SerializedName(VoiceFusionUtil.KEY_KEYWORD)
    public String mKeyword;
}
