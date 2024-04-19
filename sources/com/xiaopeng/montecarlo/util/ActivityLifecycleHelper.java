package com.xiaopeng.montecarlo.util;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.xiaopeng.montecarlo.MainActivity;
import com.xiaopeng.montecarlo.navcore.location.DRServiceManager;
import com.xiaopeng.montecarlo.navcore.sr.SRNaviManager;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.L;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class ActivityLifecycleHelper implements Application.ActivityLifecycleCallbacks {
    private static final L.Tag TAG = new L.Tag("ActivityLifecycleHelper");
    private static ActivityLifecycleHelper sHelper;
    private List<ActivityLifecycleListener> mListenerList = new ArrayList();
    private boolean mIsPause = false;

    /* loaded from: classes3.dex */
    public interface ActivityLifecycleListener {
        void onActivityCovered(boolean z);

        void onActivityResumed();

        void onActivityStopped();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
    }

    private ActivityLifecycleHelper() {
    }

    public static ActivityLifecycleHelper getInstance() {
        if (sHelper == null) {
            sHelper = new ActivityLifecycleHelper();
        }
        return sHelper;
    }

    public void init(Application application) {
        application.registerActivityLifecycleCallbacks(this);
    }

    public void deInit(Application application) {
        application.unregisterActivityLifecycleCallbacks(this);
        this.mListenerList.clear();
    }

    public boolean isInterestingActivityVisible() {
        return !this.mIsPause;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        if (activity instanceof MainActivity) {
            ContextUtils.initActivity(activity);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        if (activity instanceof MainActivity) {
            SRNaviManager.getInstance().setAppBackground(false);
            this.mIsPause = false;
            DRServiceManager.getInstance().setAppBackground(false);
            for (ActivityLifecycleListener activityLifecycleListener : this.mListenerList) {
                if (activityLifecycleListener != null) {
                    activityLifecycleListener.onActivityResumed();
                }
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        if (activity instanceof MainActivity) {
            SRNaviManager.getInstance().setAppBackground(true);
            this.mIsPause = true;
            DRServiceManager.getInstance().setAppBackground(true);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        if (activity instanceof MainActivity) {
            for (ActivityLifecycleListener activityLifecycleListener : this.mListenerList) {
                if (activityLifecycleListener != null) {
                    activityLifecycleListener.onActivityStopped();
                }
            }
        }
    }

    public void handleMapCovered(boolean z) {
        for (ActivityLifecycleListener activityLifecycleListener : this.mListenerList) {
            if (activityLifecycleListener != null) {
                activityLifecycleListener.onActivityCovered(z);
            }
        }
    }

    public void registerActivityLifecycleListener(ActivityLifecycleListener activityLifecycleListener) {
        if (activityLifecycleListener == null || this.mListenerList.contains(activityLifecycleListener)) {
            return;
        }
        this.mListenerList.add(activityLifecycleListener);
    }

    public void unregisterActivityLifecycleListener(ActivityLifecycleListener activityLifecycleListener) {
        if (activityLifecycleListener != null) {
            this.mListenerList.remove(activityLifecycleListener);
        }
    }
}
