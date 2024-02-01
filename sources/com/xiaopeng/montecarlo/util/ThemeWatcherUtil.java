package com.xiaopeng.montecarlo.util;

import android.content.Context;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.xiaopeng.montecarlo.IntentActions;
import com.xiaopeng.montecarlo.XpThemeSwitchReceiver;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.theme.IThemeSwitchListener;
import com.xiaopeng.montecarlo.theme.LocalThemeManager;
import com.xiaopeng.montecarlo.theme.ThemeEngineBuilder;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class ThemeWatcherUtil {
    private static final L.Tag TAG = new L.Tag("ThemeWatcherUtil");
    public static final int THEME_DAY = 1;
    public static final int THEME_NIGHT = 2;
    private static LocalThemeManager sLocalThemeManager;
    private static XpThemeSwitchReceiver sXpThemeSwitchReceiver;

    public static void init(Context context) {
        if (sLocalThemeManager == null) {
            sLocalThemeManager = new LocalThemeManager(context, new ThemeEngineBuilder());
            sLocalThemeManager.onStart();
            addXpThemeSwitchReceiver(context);
        }
    }

    public static void release(Context context) {
        sLocalThemeManager.onStop();
        removeXpThemeSwitchReceiver(context);
    }

    public static void register(Context context, View view, String str) {
        sLocalThemeManager.registerAutoSwitchView(view, str);
    }

    public static void unregister(Context context, String str) {
        sLocalThemeManager.unregisterAutoSwitchView(str);
    }

    public static int getColor(int i) {
        return sLocalThemeManager.getColor(i);
    }

    public static int getColorResId(int i) {
        return sLocalThemeManager.getColorResId(i);
    }

    public static Drawable getDrawable(int i) {
        return sLocalThemeManager.getDrawable(i);
    }

    public static int getDrawableResId(int i) {
        return sLocalThemeManager.getDrawableResId(i);
    }

    public static String newThemeNameForRepeatView(String str) {
        return sLocalThemeManager.newThemeNameForRepeatView(str);
    }

    public static int getMapModeByCurrentTheme() {
        return sLocalThemeManager.getMapModeByTheme();
    }

    public static void addThemeListener(IThemeSwitchListener iThemeSwitchListener) {
        sLocalThemeManager.addThemeListener(iThemeSwitchListener);
    }

    public static void removeThemeListener(IThemeSwitchListener iThemeSwitchListener) {
        sLocalThemeManager.removeThemeListener(iThemeSwitchListener);
    }

    public static void addXpThemeSwitchListener(XpThemeSwitchReceiver.ThemeSwitchListener themeSwitchListener) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "addXpThemeSwitchListener listener:" + themeSwitchListener);
        }
        XpThemeSwitchReceiver xpThemeSwitchReceiver = sXpThemeSwitchReceiver;
        if (xpThemeSwitchReceiver != null) {
            xpThemeSwitchReceiver.addThemeSwitchListener(themeSwitchListener);
        }
    }

    public static void removeXpThemeListener(XpThemeSwitchReceiver.ThemeSwitchListener themeSwitchListener) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "removeXpThemeListener listener:" + themeSwitchListener);
        }
        XpThemeSwitchReceiver xpThemeSwitchReceiver = sXpThemeSwitchReceiver;
        if (xpThemeSwitchReceiver != null) {
            xpThemeSwitchReceiver.removeThemeSwtichListener(themeSwitchListener);
        }
    }

    public static ArrayList<XpThemeSwitchReceiver.ThemeSwitchListener> getAllXpThemeSwitchListener() {
        XpThemeSwitchReceiver xpThemeSwitchReceiver = sXpThemeSwitchReceiver;
        if (xpThemeSwitchReceiver == null) {
            return null;
        }
        return xpThemeSwitchReceiver.getListenerList();
    }

    public static int getDayNightMode() {
        return sLocalThemeManager.getDayNightMode();
    }

    public static int getCurrentTheme() {
        return getDayNightMode();
    }

    public static boolean isDayMode() {
        return sLocalThemeManager.isDayMode();
    }

    private static void addXpThemeSwitchReceiver(Context context) {
        if (sXpThemeSwitchReceiver != null) {
            return;
        }
        sXpThemeSwitchReceiver = new XpThemeSwitchReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(IntentActions.ACTION_XP_THEME_SWITCH);
        context.registerReceiver(sXpThemeSwitchReceiver, intentFilter);
    }

    private static void removeXpThemeSwitchReceiver(Context context) {
        XpThemeSwitchReceiver xpThemeSwitchReceiver;
        if (context == null || (xpThemeSwitchReceiver = sXpThemeSwitchReceiver) == null) {
            return;
        }
        xpThemeSwitchReceiver.removeListeners();
        context.unregisterReceiver(sXpThemeSwitchReceiver);
        sXpThemeSwitchReceiver = null;
    }

    public static void checkCachedThemeIsSameWithSystemTheme() {
        if (L.ENABLE) {
            L.d(TAG, L.formatDayNightSwitchLog("checkCachedThemeIsSameWithSystemTheme"));
        }
        sLocalThemeManager.checkCachedThemeIsSameWithSystemTheme();
    }

    public static void executeOnConfigurationChanged(Configuration configuration, boolean z) {
        L.Tag tag = TAG;
        L.i(tag, L.formatDayNightSwitchLog("executeOnConfigurationChanged isFromActivity:" + z));
        sLocalThemeManager.executeOnConfigurationChanged(configuration, z);
    }
}
