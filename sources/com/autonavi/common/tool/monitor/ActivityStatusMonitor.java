package com.autonavi.common.tool.monitor;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.autonavi.common.tool.CrashLogRecorder;
/* loaded from: classes.dex */
public class ActivityStatusMonitor implements Application.ActivityLifecycleCallbacks {
    private int mActivitiesCount;
    private final Application mApp;
    private boolean mRegistered;

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public ActivityStatusMonitor(Application application) {
        this.mApp = application;
    }

    public void start() {
        if (this.mRegistered) {
            return;
        }
        this.mApp.registerActivityLifecycleCallbacks(this);
        this.mRegistered = true;
    }

    public void stop() {
        if (this.mRegistered) {
            this.mApp.unregisterActivityLifecycleCallbacks(this);
            this.mRegistered = false;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        CrashLogRecorder.recordLog("A-Create: " + (activity.getClass().getSimpleName() + "@" + activity.hashCode()));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        if (this.mActivitiesCount == 0) {
            CrashLogRecorder.recordKeyValue("RealForeground", true);
        }
        this.mActivitiesCount++;
        String str = activity.getClass().getSimpleName() + "@" + activity.hashCode();
        CrashLogRecorder.recordKeyValue("CurrentActivity", str);
        CrashLogRecorder.recordKeyValue("LastActivity", str);
        CrashLogRecorder.recordLog("A-Start: " + str);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        this.mActivitiesCount--;
        if (this.mActivitiesCount == 0) {
            CrashLogRecorder.recordKeyValue("RealForeground", false);
            CrashLogRecorder.recordKeyValue("CurrentActivity", (String) null);
        }
        CrashLogRecorder.recordLog("A-Stop: " + (activity.getClass().getSimpleName() + "@" + activity.hashCode()));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        CrashLogRecorder.recordLog("A-Destroy: " + (activity.getClass().getSimpleName() + "@" + activity.hashCode()));
    }

    public boolean isRealForeground() {
        return this.mActivitiesCount > 0;
    }
}
