package com.xiaopeng.speech.protocol.node.carcontrol.bean;

import android.text.TextUtils;
import com.xiaopeng.montecarlo.navcore.speech.voicefusion.VoiceFusionUtil;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class UserBookValue {
    private String keyword;

    public static UserBookValue fromJson(String str) {
        UserBookValue userBookValue = new UserBookValue();
        try {
            String optString = new JSONObject(str).optString(VoiceFusionUtil.KEY_KEYWORD);
            if (!TextUtils.isEmpty(optString)) {
                userBookValue.keyword = optString;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userBookValue;
    }

    public String getKeyword() {
        return this.keyword;
    }
}
