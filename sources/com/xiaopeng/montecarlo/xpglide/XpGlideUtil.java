package com.xiaopeng.montecarlo.xpglide;

import android.text.TextUtils;
import com.bumptech.glide.load.Key;
import com.xiaopeng.montecarlo.root.util.L;
/* loaded from: classes3.dex */
class XpGlideUtil {
    private static final String KEY_END = ", ";
    private static final String KEY_MODEL_START = "model=";
    private static final String KEY_SOURCE_START = "sourceKey=";
    private static String mNewUrl;
    private static String mOldUrl;
    private static final L.Tag TAG = new L.Tag("XpGlideUtil");
    private static final int LENGTH_KEY_SOURCE = 10;
    private static final int LENGTH_KEY_MODEL = 6;

    XpGlideUtil() {
    }

    public static String getUrlFromKey(Key key) {
        int i;
        int indexOf;
        if (key == null) {
            if (L.ENABLE) {
                L.d(TAG, "getUrlFromKey: key = null ");
            }
            return null;
        }
        String obj = key.toString();
        if (!TextUtils.isEmpty(obj)) {
            if (!TextUtils.isEmpty(mNewUrl) && obj.contains(mNewUrl)) {
                return mNewUrl;
            }
            StringBuffer stringBuffer = new StringBuffer("getUrlFromKey key => ");
            stringBuffer.append(obj);
            int indexOf2 = obj.indexOf(KEY_SOURCE_START);
            if (indexOf2 > -1) {
                i = LENGTH_KEY_SOURCE;
            } else {
                indexOf2 = obj.indexOf(KEY_MODEL_START);
                if (indexOf2 > -1) {
                    i = LENGTH_KEY_MODEL;
                } else {
                    L.Tag tag = TAG;
                    L.i(tag, "getUrlFromKey: 当前key未支持 ：" + obj);
                }
            }
            if (L.ENABLE) {
                stringBuffer.append(", key_start => ");
                stringBuffer.append(indexOf2);
            }
            if (indexOf2 > -1 && (indexOf = obj.indexOf(KEY_END)) > -1) {
                if (L.ENABLE) {
                    stringBuffer.append(", key_end => ");
                    stringBuffer.append(indexOf);
                }
                String substring = obj.substring(indexOf2 + i, indexOf);
                if (L.ENABLE) {
                    stringBuffer.append(", url => ");
                    stringBuffer.append(substring);
                    L.d(TAG, stringBuffer.toString());
                }
                mNewUrl = substring;
                return substring;
            }
        }
        return null;
    }
}
