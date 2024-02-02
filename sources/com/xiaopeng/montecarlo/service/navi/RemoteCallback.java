package com.xiaopeng.montecarlo.service.navi;

import android.os.IBinder;
import android.os.RemoteException;
import java.lang.reflect.Method;
/* loaded from: classes3.dex */
public class RemoteCallback {
    private INaviCallback mCallback;
    private IBinder.DeathRecipient mDeathRecipient = new IBinder.DeathRecipient() { // from class: com.xiaopeng.montecarlo.service.navi.RemoteCallback.1
        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            RemoteCallback.this.mCallback = null;
            RemoteCallback.this.mKilled = true;
        }
    };
    private boolean mKilled;
    private Method mOutTimeMethod1;
    private Method mOutTimeMethod2;

    public RemoteCallback(INaviCallback iNaviCallback) {
        this.mKilled = true;
        try {
            iNaviCallback.asBinder().linkToDeath(this.mDeathRecipient, 0);
            this.mCallback = iNaviCallback;
            this.mKilled = false;
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        try {
            this.mOutTimeMethod1 = iNaviCallback.getClass().getMethod("onTimeOut", new Class[0]);
        } catch (NoSuchMethodException unused) {
            this.mOutTimeMethod1 = null;
        }
        try {
            this.mOutTimeMethod2 = iNaviCallback.getClass().getMethod("onTimeOut", Integer.TYPE);
        } catch (NoSuchMethodException unused2) {
            this.mOutTimeMethod2 = null;
        }
    }

    public boolean isKilled() {
        return this.mKilled;
    }

    public void onBackResult(String str) {
        if (this.mKilled) {
            return;
        }
        try {
            this.mCallback.onBackResult(str);
        } catch (RemoteException e) {
            kill();
            e.printStackTrace();
        }
    }

    public void onTimeOut(int i) {
        if (this.mKilled) {
            return;
        }
        try {
            if (this.mOutTimeMethod1 != null) {
                this.mOutTimeMethod1.invoke(this.mCallback, new Object[0]);
            }
            if (this.mOutTimeMethod2 != null) {
                this.mOutTimeMethod2.invoke(this.mCallback, Integer.valueOf(i));
            }
        } catch (Exception e) {
            kill();
            e.printStackTrace();
        }
    }

    public void kill() {
        this.mCallback.asBinder().unlinkToDeath(this.mDeathRecipient, 0);
        this.mCallback = null;
        this.mKilled = true;
    }
}
