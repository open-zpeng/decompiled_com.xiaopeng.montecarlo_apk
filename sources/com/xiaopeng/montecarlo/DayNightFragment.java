package com.xiaopeng.montecarlo;

import android.os.Bundle;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.xiaopeng.montecarlo.XpThemeSwitchReceiver;
import com.xiaopeng.montecarlo.root.theme.ThemeType;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.util.ThemeWatcherUtil;
/* loaded from: classes.dex */
public abstract class DayNightFragment extends Fragment implements XpThemeSwitchReceiver.ThemeSwitchListener {
    private static final L.Tag TAG = new L.Tag("DayNightFragment");
    protected ThemeType mCurrentSceneTheme = ThemeType.DEFAULT_THEME_TYPE;
    private String mThemeName;

    protected abstract boolean canSwitchDayNight();

    @Override // com.xiaopeng.montecarlo.XpThemeSwitchReceiver.ThemeSwitchListener
    public void onThemeSwitch(int i) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, L.formatDayNightSwitchLog("onThemeSwitch theme:" + i));
        }
        noticeThemeSwitch();
    }

    private void noticeThemeSwitch() {
        ThemeType currentTheme = ThemeWatcherUtil.getCurrentTheme();
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, L.formatDayNightSwitchLog("noticeThemeSwitch new theme:" + currentTheme + ",current theme:" + this.mCurrentSceneTheme + ",scene:" + getClass().getSimpleName()));
        }
        if (this.mCurrentSceneTheme != currentTheme) {
            this.mCurrentSceneTheme = currentTheme;
            onThemeSwitchInternal(currentTheme);
        }
    }

    private void registerStaticThemeWatcher() {
        if (getActivity() == null) {
            return;
        }
        this.mThemeName = ThemeWatcherUtil.newThemeNameForRepeatView(getClass().getSimpleName());
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, L.formatDayNightSwitchLog("registerStaticThemeWatcher mThemeName:" + this.mThemeName));
        }
        ThemeWatcherUtil.register(getActivity(), getView(), this.mThemeName);
    }

    private void unregisterStaticThemeWatcher() {
        if (getActivity() == null) {
            return;
        }
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, L.formatDayNightSwitchLog("unregisterStaticThemeWatcher mThemeName:" + this.mThemeName));
        }
        ThemeWatcherUtil.unregister(getActivity(), this.mThemeName);
    }

    private void registerDynamicThemeWatcher() {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, L.formatDayNightSwitchLog("registerDynamicThemeWatcher listener:" + this));
        }
        ThemeWatcherUtil.addXpThemeSwitchListener(this);
    }

    private void unregisterDynamicThemeWatcher() {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, L.formatDayNightSwitchLog("unregisterDynamicThemeWatcher listener:" + this));
        }
        ThemeWatcherUtil.removeXpThemeListener(this);
    }

    private void onThemeSwitchInternal(ThemeType themeType) {
        boolean canSwitchDayNight = canSwitchDayNight();
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, L.formatDayNightSwitchLog("onThemeSwitchInternal canSwitchDayNight:" + canSwitchDayNight + ",page:" + getClass().getSimpleName()));
        }
        if (canSwitchDayNight) {
            this.mCurrentSceneTheme = themeType;
            onThemeSwitchDelegate(themeType);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onThemeSwitchDelegate(ThemeType themeType) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, L.formatDayNightSwitchLog("onThemeSwitchDelegate theme:" + themeType + ",who:" + this));
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        this.mCurrentSceneTheme = ThemeWatcherUtil.getCurrentTheme();
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, L.formatDayNightSwitchLog("onCreate mCurrentSceneTheme:" + this.mCurrentSceneTheme + ",scene:" + getClass().getSimpleName()));
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, L.formatDayNightSwitchLog("onViewCreated scene:" + getClass().getSimpleName()));
        }
        try {
            registerDynamicThemeWatcher();
        } catch (Exception e) {
            L.Tag tag2 = TAG;
            L.e(tag2, "onViewCreated e:" + e.toString());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, L.formatDayNightSwitchLog("onDestroyView scene:" + getClass().getSimpleName()));
        }
        try {
            unregisterDynamicThemeWatcher();
        } catch (Exception e) {
            L.Tag tag2 = TAG;
            L.e(tag2, "onDestroyView e:" + e.toString());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, L.formatDayNightSwitchLog("onPause scene:" + getClass().getSimpleName()));
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, L.formatDayNightSwitchLog("onStop scene:" + getClass().getSimpleName()));
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, L.formatDayNightSwitchLog("onResume scene:" + getClass().getSimpleName()));
        }
        noticeThemeSwitch();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, L.formatDayNightSwitchLog("onStart scene:" + getClass().getSimpleName()));
        }
    }
}
