package com.xiaopeng.montecarlo.root.util;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.TypedValue;
import androidx.annotation.NonNull;
import com.xiaopeng.montecarlo.root.util.L;
import java.lang.ref.WeakReference;
/* loaded from: classes2.dex */
public class ContextUtils {
    private static final L.Tag TAG = new L.Tag("ContextUtils");
    private static WeakReference<Context> sContext = null;
    private static WeakReference<Application> sApp = null;
    private static WeakReference<Activity> sActivity = null;

    public static void initApp(@NonNull Context context) {
        if (context != null && (context instanceof Application)) {
            sApp = new WeakReference<>((Application) context);
        }
        sContext = new WeakReference<>(context);
    }

    public static Application getApp() {
        Application application = sApp.get();
        if (application != null) {
            return application;
        }
        throw new IllegalArgumentException("ContextUtils sApp should not be null");
    }

    public static Context getContext() {
        Context context = sContext.get();
        if (context != null) {
            return context;
        }
        throw new IllegalArgumentException("ContextUtils sContext should not be null");
    }

    public static void initActivity(@NonNull Activity activity) {
        sActivity = new WeakReference<>(activity);
    }

    public static Activity getActivity() {
        WeakReference<Activity> weakReference = sActivity;
        if (weakReference == null) {
            return null;
        }
        Activity activity = weakReference.get();
        if (activity != null) {
            return activity;
        }
        L.d(TAG, "ContextUtils sActivity is null");
        return null;
    }

    public static String getString(int i) {
        Context context = sContext.get();
        if (context != null) {
            return context.getString(i);
        }
        throw new IllegalArgumentException("ContextUtils sContext should not be null");
    }

    public static CharSequence getText(int i) {
        Context context = sContext.get();
        if (context != null) {
            return context.getText(i);
        }
        throw new IllegalArgumentException("ContextUtils sContext should not be null");
    }

    public static String getString(int i, Object... objArr) {
        Context context = sContext.get();
        if (context != null) {
            return context.getString(i, objArr);
        }
        throw new IllegalArgumentException("ContextUtils sContext should not be null");
    }

    public static int getColor(int i) {
        Context context = sContext.get();
        if (context != null) {
            return context.getResources().getColor(i);
        }
        throw new IllegalArgumentException("ContextUtils sContext should not be null");
    }

    public static ColorStateList getColorStateList(int i) {
        Context context = sContext.get();
        if (context != null) {
            return context.getResources().getColorStateList(i);
        }
        throw new IllegalArgumentException("ContextUtils sContext should not be null");
    }

    public static int getDimensionPixelSize(int i) {
        Context context = sContext.get();
        if (context != null) {
            return context.getResources().getDimensionPixelSize(i);
        }
        throw new IllegalArgumentException("ContextUtils sContext should not be null");
    }

    public static Drawable getDrawable(int i) {
        Context context = sContext.get();
        if (context != null) {
            return context.getResources().getDrawable(i, context.getTheme());
        }
        throw new IllegalArgumentException("ContextUtils sContext should not be null");
    }

    public static String[] getStringArray(int i) {
        Context context = sContext.get();
        if (context != null) {
            return context.getResources().getStringArray(i);
        }
        throw new IllegalArgumentException("ContextUtils sContext should not be null");
    }

    public static int getInt(int i) {
        Context context = sContext.get();
        if (context != null) {
            return context.getResources().getInteger(i);
        }
        throw new IllegalArgumentException("ContextUtils sContext should not be null");
    }

    public static float getFloat(int i) {
        Context context = sContext.get();
        if (context != null) {
            TypedValue typedValue = new TypedValue();
            context.getResources().getValue(i, typedValue, true);
            return typedValue.getFloat();
        }
        throw new IllegalArgumentException("ContextUtils sContext should not be null");
    }

    public static float getFraction(int i) {
        Context context = sContext.get();
        if (context != null) {
            return context.getResources().getFraction(i, 1, 1);
        }
        throw new IllegalArgumentException("ContextUtils sContext should not be null");
    }

    public static float getDensity() {
        Context context = sContext.get();
        if (context != null) {
            return context.getResources().getDisplayMetrics().density;
        }
        throw new IllegalArgumentException("ContextUtils sContext should not be null");
    }

    public static int getDensityDpi() {
        Context context = sContext.get();
        if (context != null) {
            return context.getResources().getDisplayMetrics().densityDpi;
        }
        throw new IllegalArgumentException("ContextUtils sContext should not be null");
    }

    public static int getScreenWidth() {
        if (sContext.get() != null) {
            return RootUtil.getScreenWidth();
        }
        throw new IllegalArgumentException("ContextUtils sContext should not be null");
    }

    public static int getScreenHeight() {
        if (sContext.get() != null) {
            return RootUtil.getScreenHeight();
        }
        throw new IllegalArgumentException("ContextUtils sContext should not be null");
    }

    public static void startExternalActivity(Intent intent) {
        getContext().startActivity(intent);
    }

    public static void startActivityWithNewTask(Intent intent) {
        gotoHome(intent);
    }

    @Deprecated
    public static void startActivity(Intent intent) {
        gotoHome(intent);
    }

    public static void gotoHome() {
        gotoHome(null);
    }

    public static void gotoHome(Intent intent) {
        Bundle extras;
        Intent intent2 = new Intent("android.intent.action.MAIN");
        intent2.setFlags(268435456);
        intent2.addCategory("android.intent.category.HOME");
        Bundle bundle = new Bundle();
        if (intent != null && (extras = intent.getExtras()) != null) {
            bundle.putAll(extras);
        }
        intent2.putExtras(bundle);
        getContext().startActivity(intent2);
    }

    public static boolean isLandscape() {
        return getContext().getResources().getConfiguration().orientation == 2;
    }

    public static boolean isPortrait() {
        return getContext().getResources().getConfiguration().orientation == 1;
    }
}
