package com.xiaopeng.montecarlo.theme;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.NonNull;
import com.xiaopeng.montecarlo.root.util.L;
/* loaded from: classes3.dex */
public class LocalThemeManager {
    public static final int MAP_DEFAULT_MODE = 1;
    private static final L.Tag TAG = new L.Tag("LocalThemeManager");
    public static final int TIME_DAY = 1;
    public static final int TIME_NIGHT = 2;
    private Context mContext;
    private IThemeEngine mEngine;
    private IThemeEngineBuilder mEngineBuilder;
    private boolean mIsStarted = false;

    public LocalThemeManager(@NonNull Context context, IThemeEngineBuilder iThemeEngineBuilder) {
        this.mContext = context;
        this.mEngineBuilder = iThemeEngineBuilder;
    }

    public void onStart() {
        if (L.ENABLE) {
            L.d(TAG, L.formatDayNightSwitchLog("onStart"));
        }
        IThemeEngineBuilder iThemeEngineBuilder = this.mEngineBuilder;
        if (iThemeEngineBuilder != null) {
            this.mEngine = iThemeEngineBuilder.createEngine(this.mContext);
            this.mEngine.init(this.mContext);
            this.mIsStarted = true;
        }
    }

    public void onStop() {
        if (L.ENABLE) {
            L.d(TAG, L.formatDayNightSwitchLog("onStop"));
        }
        this.mIsStarted = false;
        this.mEngine.release();
        this.mEngine = null;
    }

    public void addThemeListener(IThemeSwitchListener iThemeSwitchListener) {
        if (this.mIsStarted) {
            this.mEngine.addThemeListener(iThemeSwitchListener);
        }
    }

    public void removeThemeListener(IThemeSwitchListener iThemeSwitchListener) {
        if (this.mIsStarted) {
            this.mEngine.removeThemeListener(iThemeSwitchListener);
        }
    }

    public boolean isDayMode() {
        if (this.mIsStarted) {
            return this.mEngine.isDayMode();
        }
        return true;
    }

    public int getDayNightMode() {
        return (!this.mIsStarted || isDayMode()) ? 1 : 2;
    }

    public int getColor(int i) {
        if (this.mIsStarted) {
            return this.mEngine.getColor(i);
        }
        return 0;
    }

    public int getColorResId(int i) {
        return this.mIsStarted ? this.mEngine.getColorResId(i) : i;
    }

    public Drawable getDrawable(int i) {
        if (this.mIsStarted) {
            return this.mEngine.getDrawable(i);
        }
        return this.mContext.getResources().getDrawable(i);
    }

    public int getDrawableResId(int i) {
        return this.mIsStarted ? this.mEngine.getDrawableResId(i) : i;
    }

    public String newThemeNameForRepeatView(@NonNull String str) {
        return this.mIsStarted ? this.mEngine.newThemeNameForRepeatView(str) : str;
    }

    public void registerAutoSwitchView(View view, String str) {
        if (this.mIsStarted) {
            this.mEngine.registerAutoSwitchView(view, str);
        }
    }

    public void unregisterAutoSwitchView(String str) {
        if (this.mIsStarted) {
            this.mEngine.unregisterAutoSwitchView(str);
        }
    }

    public int getMapModeByTheme() {
        return !isDayMode();
    }

    public void checkCachedThemeIsSameWithSystemTheme() {
        if (this.mIsStarted) {
            this.mEngine.checkCachedThemeIsSameWithSystemTheme();
        }
    }

    public void executeOnConfigurationChanged(Configuration configuration, boolean z) {
        if (this.mIsStarted) {
            this.mEngine.executeOnConfigurationChanged(configuration, z);
        } else {
            L.w(TAG, L.formatDayNightSwitchLog("executeOnConfigurationChanged failure"));
        }
    }
}
