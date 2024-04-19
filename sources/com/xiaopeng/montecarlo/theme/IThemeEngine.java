package com.xiaopeng.montecarlo.theme;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.NonNull;
import com.xiaopeng.montecarlo.root.theme.ThemeType;
/* loaded from: classes3.dex */
public interface IThemeEngine {
    void addThemeListener(IThemeSwitchListener iThemeSwitchListener);

    void checkCachedThemeIsSameWithSystemTheme();

    void executeOnConfigurationChanged(Configuration configuration, boolean z);

    int getColor(int i);

    int getColorResId(int i);

    ThemeType getCurrentTheme();

    Drawable getDrawable(int i);

    int getDrawableResId(int i);

    String getThemeVersion();

    void init(Context context);

    boolean isDayMode();

    boolean isThemeChanged(@NonNull Configuration configuration);

    String newThemeNameForRepeatView(String str);

    void registerAutoSwitchView(View view, String str);

    void release();

    void removeThemeListener(IThemeSwitchListener iThemeSwitchListener);

    void unregisterAutoSwitchView(String str);
}
