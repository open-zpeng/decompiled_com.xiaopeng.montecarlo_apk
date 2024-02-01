package com.xiaopeng.montecarlo.theme;

import android.content.Context;
import androidx.annotation.NonNull;
/* loaded from: classes3.dex */
public class ThemeEngineBuilder implements IThemeEngineBuilder {
    @Override // com.xiaopeng.montecarlo.theme.IThemeEngineBuilder
    public IThemeEngine createEngine(@NonNull Context context) {
        return new ThemeEngine();
    }
}
