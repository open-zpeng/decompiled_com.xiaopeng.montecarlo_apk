package com.xiaopeng.montecarlo.service.navi;

import android.os.Bundle;
/* loaded from: classes3.dex */
public interface IRequestEventCallback {
    void allWorkEnd();

    void setDataToMainActivity(Bundle bundle);

    void setNeedReturnResult(boolean z, String str);

    void setNeedStartMainActivity(boolean z);
}
