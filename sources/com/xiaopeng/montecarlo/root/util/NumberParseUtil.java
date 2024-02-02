package com.xiaopeng.montecarlo.root.util;

import android.text.TextUtils;
/* loaded from: classes2.dex */
public class NumberParseUtil {
    public static float parseFloat(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return Float.parseFloat(str);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        return 0.0f;
    }
}
