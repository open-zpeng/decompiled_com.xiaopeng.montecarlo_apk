package com.xiaopeng.montecarlo.base;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.xiaopeng.montecarlo.bridge.StatusConst;
import com.xiaopeng.montecarlo.util.SpeechEventBizHelper;
/* loaded from: classes2.dex */
public interface IBaseLogicView<T> {
    void backToLastMode(StatusConst.Mode mode, boolean z);

    void backToMode(StatusConst.Mode mode, boolean z);

    BaseBridge getBridge();

    StatusConst.Mode getCurrentSceneMode();

    boolean getHoldBoolean(String str, boolean z);

    double getHoldDouble(String str, double d);

    int getHoldInt(String str, int i);

    Parcelable getHoldParcelable(String str);

    String getHoldString(String str, String str2);

    MainContext getMainContext();

    /* renamed from: getPresenter */
    T mo118getPresenter();

    SpeechEventBizHelper getSpeechEventBizHelper();

    void goBack();

    void hide();

    boolean isPreScene(StatusConst.Mode mode);

    boolean isSceneLegal();

    boolean isSceneResumed();

    boolean isSceneVuiEnabled();

    void removeSceneAfterIndex(int i, int i2);

    void runOnUiThread(Runnable runnable);

    void runOnUiThreadDelayed(Runnable runnable, long j);

    void runOnUiThreadRelyMap(Runnable runnable);

    void saveHoldBoolean(String str, boolean z);

    void saveHoldDouble(String str, double d);

    void saveHoldInt(String str, int i);

    void saveHoldParcelable(@Nullable String str, @Nullable Parcelable parcelable);

    void saveHoldString(String str, String str2);

    String sceneLegalStatus();

    void setPresenter(T t);

    void setReturnResult(Bundle bundle);

    void show();

    void startScene(BaseBridge baseBridge);

    void startScene(BaseBridge baseBridge, int i);

    void stopSelf();
}
