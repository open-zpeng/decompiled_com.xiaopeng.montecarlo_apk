package com.xiaopeng.montecarlo.service.navi.parser;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import com.xiaopeng.montecarlo.navcore.speech.voicefusion.VoiceFusionUtil;
import com.xiaopeng.montecarlo.root.util.GsonUtil;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.service.navi.INaviParser;
import com.xiaopeng.montecarlo.service.navi.IRequestEventCallback;
import com.xiaopeng.montecarlo.service.navi.request.CategoryRequest;
/* loaded from: classes3.dex */
public class CategorySearchParser implements INaviParser {
    private static final L.Tag TAG = new L.Tag("CategorySearchParser");

    @Override // com.xiaopeng.montecarlo.service.navi.INaviParser
    public void onCreate(@NonNull Context context) {
    }

    @Override // com.xiaopeng.montecarlo.service.navi.INaviParser
    public void onHandleEvent(@NonNull Context context, @NonNull String str, @NonNull IRequestEventCallback iRequestEventCallback) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "onHandleEvent content:" + str);
        }
        CategoryRequest categoryRequest = (CategoryRequest) GsonUtil.fromJson(str, (Class<Object>) CategoryRequest.class);
        iRequestEventCallback.setNeedReturnResult(false, null);
        iRequestEventCallback.setNeedStartMainActivity(true);
        if (categoryRequest != null) {
            Bundle bundle = new Bundle();
            bundle.putString(VoiceFusionUtil.KEY_KEYWORD, categoryRequest.mKeyword);
            bundle.putString("category", categoryRequest.mCategory);
            iRequestEventCallback.setDataToMainActivity(bundle);
        }
        iRequestEventCallback.allWorkEnd();
    }
}
