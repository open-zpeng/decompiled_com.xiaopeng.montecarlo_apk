package com.xiaopeng.montecarlo.root.theme;

import android.content.res.Configuration;
import android.os.SystemProperties;
import android.text.TextUtils;
import androidx.annotation.NonNull;
/* loaded from: classes3.dex */
public enum ThemeType {
    THEME_DAY_NORMAL,
    THEME_DAY_XSPORT,
    THEME_DAY_BOOST,
    THEME_NIGHT_NORMAL,
    THEME_NIGHT_XSPORT,
    THEME_NIGHT_BOOST;
    
    private static final String THEME_STYLE_BOOST = "boost";
    private static final String THEME_STYLE_PROPERTY_NAME = "persist.sys.theme.style";
    private static final String THEME_STYLE_XSPORT = "xsport";
    public static final ThemeType DEFAULT_THEME_TYPE = THEME_DAY_NORMAL;

    public static ThemeType parseTheme(int i) {
        if (i == THEME_DAY_NORMAL.ordinal()) {
            return THEME_DAY_NORMAL;
        }
        if (i == THEME_DAY_XSPORT.ordinal()) {
            return THEME_DAY_XSPORT;
        }
        if (i == THEME_DAY_BOOST.ordinal()) {
            return THEME_DAY_BOOST;
        }
        if (i == THEME_NIGHT_NORMAL.ordinal()) {
            return THEME_NIGHT_NORMAL;
        }
        if (i == THEME_NIGHT_XSPORT.ordinal()) {
            return THEME_NIGHT_XSPORT;
        }
        if (i == THEME_NIGHT_BOOST.ordinal()) {
            return THEME_NIGHT_BOOST;
        }
        return DEFAULT_THEME_TYPE;
    }

    @NonNull
    public static ThemeType parseTheme(@NonNull Configuration configuration) {
        String str = SystemProperties.get(THEME_STYLE_PROPERTY_NAME, "");
        if (isDayMode(configuration)) {
            if (TextUtils.equals(str, THEME_STYLE_XSPORT)) {
                return THEME_DAY_XSPORT;
            }
            if (TextUtils.equals(str, THEME_STYLE_BOOST)) {
                return THEME_DAY_BOOST;
            }
            return THEME_DAY_NORMAL;
        } else if (TextUtils.equals(str, THEME_STYLE_XSPORT)) {
            return THEME_NIGHT_XSPORT;
        } else {
            if (TextUtils.equals(str, THEME_STYLE_BOOST)) {
                return THEME_NIGHT_BOOST;
            }
            return THEME_NIGHT_NORMAL;
        }
    }

    public static boolean isDayMode(Configuration configuration) {
        return (configuration.uiMode & 48) == 16;
    }

    public boolean isDayMode() {
        return this == THEME_DAY_NORMAL || this == THEME_DAY_XSPORT || this == THEME_DAY_BOOST;
    }

    public boolean isNightMode() {
        return this == THEME_NIGHT_NORMAL || this == THEME_NIGHT_XSPORT || this == THEME_NIGHT_BOOST;
    }
}
