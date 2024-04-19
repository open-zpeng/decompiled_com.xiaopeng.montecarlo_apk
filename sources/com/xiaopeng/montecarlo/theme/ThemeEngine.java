package com.xiaopeng.montecarlo.theme;

import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.xiaopeng.montecarlo.root.theme.ThemeType;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.L;
import java.util.Iterator;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes3.dex */
public class ThemeEngine implements IThemeEngine {
    private static final L.Tag TAG = new L.Tag("ThemeEngine");
    private static final AtomicInteger VIEW_FLAG = new AtomicInteger(1);
    private Context mContext;
    private Vector<IThemeSwitchListener> mThemeSwitchListeners = new Vector<>();
    public ThemeType mCurrentTheme = ThemeType.DEFAULT_THEME_TYPE;
    private ComponentCallbacks mComponentCallbacks = new ComponentCallbacks() { // from class: com.xiaopeng.montecarlo.theme.ThemeEngine.1
        @Override // android.content.ComponentCallbacks
        public void onLowMemory() {
        }

        @Override // android.content.ComponentCallbacks
        public void onConfigurationChanged(Configuration configuration) {
            ThemeEngine.this.executeOnConfigurationChanged(configuration, false);
        }
    };

    @Override // com.xiaopeng.montecarlo.theme.IThemeEngine
    public int getColorResId(int i) {
        return i;
    }

    @Override // com.xiaopeng.montecarlo.theme.IThemeEngine
    public int getDrawableResId(int i) {
        return i;
    }

    @Override // com.xiaopeng.montecarlo.theme.IThemeEngine
    public String getThemeVersion() {
        return "v1.0.0";
    }

    @Override // com.xiaopeng.montecarlo.theme.IThemeEngine
    public void registerAutoSwitchView(View view, String str) {
    }

    @Override // com.xiaopeng.montecarlo.theme.IThemeEngine
    public void unregisterAutoSwitchView(String str) {
    }

    @Override // com.xiaopeng.montecarlo.theme.IThemeEngine
    public void executeOnConfigurationChanged(Configuration configuration, boolean z) {
        ThemeType parseTheme = ThemeType.parseTheme(configuration);
        L.Tag tag = TAG;
        L.i(tag, L.formatDayNightSwitchLog("executeOnConfigurationChanged ThemeType:" + parseTheme + ",isFromActivity:" + z));
        if (parseTheme != this.mCurrentTheme) {
            this.mCurrentTheme = parseTheme;
            Iterator<IThemeSwitchListener> it = this.mThemeSwitchListeners.iterator();
            while (it.hasNext()) {
                try {
                    it.next().onSwitchTheme(getCurrentTheme().name(), getCurrentTheme());
                } catch (Exception e) {
                    L.Tag tag2 = TAG;
                    L.e(tag2, L.formatDayNightSwitchLog("executeOnConfigurationChanged onSwitchTheme e:" + e.getStackTrace().toString()));
                }
            }
            return;
        }
        L.i(TAG, L.formatDayNightSwitchLog("executeOnConfigurationChanged theme not changed"));
    }

    @Override // com.xiaopeng.montecarlo.theme.IThemeEngine
    public boolean isThemeChanged(Configuration configuration) {
        return ThemeType.parseTheme(configuration) != this.mCurrentTheme;
    }

    @Override // com.xiaopeng.montecarlo.theme.IThemeEngine
    public void init(Context context) {
        this.mContext = context;
        this.mContext.registerComponentCallbacks(this.mComponentCallbacks);
        this.mCurrentTheme = ThemeType.parseTheme(context.getResources().getConfiguration());
        L.Tag tag = TAG;
        L.i(tag, L.formatDayNightSwitchLog("init isDayMode:" + this.mCurrentTheme.isDayMode()));
    }

    @Override // com.xiaopeng.montecarlo.theme.IThemeEngine
    public void release() {
        this.mContext.unregisterComponentCallbacks(this.mComponentCallbacks);
        this.mThemeSwitchListeners.clear();
    }

    @Override // com.xiaopeng.montecarlo.theme.IThemeEngine
    public void addThemeListener(IThemeSwitchListener iThemeSwitchListener) {
        CollectionUtils.listAdd(this.mThemeSwitchListeners, iThemeSwitchListener);
    }

    @Override // com.xiaopeng.montecarlo.theme.IThemeEngine
    public void removeThemeListener(IThemeSwitchListener iThemeSwitchListener) {
        this.mThemeSwitchListeners.remove(iThemeSwitchListener);
    }

    @Override // com.xiaopeng.montecarlo.theme.IThemeEngine
    public ThemeType getCurrentTheme() {
        return this.mCurrentTheme;
    }

    @Override // com.xiaopeng.montecarlo.theme.IThemeEngine
    public boolean isDayMode() {
        return this.mCurrentTheme.isDayMode();
    }

    @Override // com.xiaopeng.montecarlo.theme.IThemeEngine
    public int getColor(int i) {
        return ContextUtils.getColor(i);
    }

    @Override // com.xiaopeng.montecarlo.theme.IThemeEngine
    public Drawable getDrawable(int i) {
        return ContextUtils.getDrawable(i);
    }

    @Override // com.xiaopeng.montecarlo.theme.IThemeEngine
    public String newThemeNameForRepeatView(String str) {
        return str + "-_Adapter_-" + VIEW_FLAG.getAndAdd(1);
    }

    @Override // com.xiaopeng.montecarlo.theme.IThemeEngine
    public void checkCachedThemeIsSameWithSystemTheme() {
        ThemeType parseTheme = ThemeType.parseTheme(this.mContext.getResources().getConfiguration());
        L.Tag tag = TAG;
        L.i(tag, L.formatDayNightSwitchLog("checkCachedThemeIsSameWithSystemTheme systemThemeType:" + parseTheme + ",mIsDayMode:" + parseTheme.isDayMode()));
        if (parseTheme != this.mCurrentTheme) {
            this.mCurrentTheme = parseTheme;
            L.i(TAG, L.formatDayNightSwitchLog("checkCachedThemeIsSameWithSystemTheme mIsDayMode is not same with isDayOfSystem, need sync"));
        }
    }
}
