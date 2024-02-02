package com.xiaopeng.montecarlo.service.navi.binder;

import android.content.Context;
import android.os.IBinder;
/* loaded from: classes3.dex */
public interface IBinderService {
    IBinder getBinder();

    void onCreate(Context context);

    void onDestroy();
}
