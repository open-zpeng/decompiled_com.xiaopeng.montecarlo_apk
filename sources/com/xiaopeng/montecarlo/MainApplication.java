package com.xiaopeng.montecarlo;

import android.app.Application;
import android.content.Context;
import com.bumptech.glide.request.target.ViewTarget;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.TraceUtils;
import io.reactivex.functions.Consumer;
import io.reactivex.plugins.RxJavaPlugins;
/* loaded from: classes.dex */
public class MainApplication extends Application {
    private static final L.Tag TAG = new L.Tag("MainApplication");

    @Override // android.content.ContextWrapper
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        initRxJavaThreadParam();
        InitializerManager.getInstance().init(this, TAG);
        L.i(TAG, "Application attachBaseContext start ");
        TraceUtils.alwaysTraceBegin("Application_InitializerManager_PHASE_APPLICATION_ATTACH");
        InitializerManager.getInstance().onBootPhase(100);
        TraceUtils.alwaysTraceEnd();
        L.i(TAG, "Application attachBaseContext end ");
    }

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        L.i(TAG, "Application onCreate start ");
        TraceUtils.alwaysTraceBegin("Application_InitializerManager_PHASE_APPLICATION_CREATE");
        ViewTarget.setTagId(R.id.glide_tag);
        setTheme(R.style.Montecarlo_AppTheme_Day);
        InitializerManager.getInstance().onBootPhase(101);
        TraceUtils.alwaysTraceEnd();
        L.i(TAG, "Application onCreate end ");
    }

    @Override // android.app.Application
    public void onTerminate() {
        super.onTerminate();
        L.i(TAG, "Application onTerminate start ");
        TraceUtils.alwaysTraceBegin("Application_InitializerManager_onTerminate");
        InitializerManager.getInstance().onTerminate();
        TraceUtils.alwaysTraceEnd();
        L.i(TAG, "Application onTerminate end ");
    }

    @Override // android.app.Application, android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
        super.onTrimMemory(i);
        L.Tag tag = TAG;
        L.i(tag, "onTrimMemory level：" + i);
    }

    @Override // android.app.Application, android.content.ComponentCallbacks
    public void onLowMemory() {
        super.onLowMemory();
        L.i(TAG, "onTrimMemory.");
    }

    private void initRxJavaThreadParam() {
        System.setProperty("rx2.computation-threads", "2");
        System.setProperty("rx2.io-priority", "1");
        RxJavaPlugins.setErrorHandler(new Consumer() { // from class: com.xiaopeng.montecarlo.-$$Lambda$MainApplication$HpT99UbiqP8AV4bGPaRXFYtjn7E
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ((Throwable) obj).printStackTrace();
            }
        });
    }
}
