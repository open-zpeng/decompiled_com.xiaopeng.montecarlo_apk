package com.xiaopeng.montecarlo.views.dialog;

import android.content.Context;
/* loaded from: classes3.dex */
public class XNoTitleDialog extends XBaseDialog {
    private ThemeWatcher mThemeWatcher;

    /* loaded from: classes3.dex */
    public interface ThemeWatcher {
        void changeTheme(boolean z);
    }

    public XNoTitleDialog(Context context) {
        super(context);
    }

    @Override // com.xiaopeng.montecarlo.views.dialog.XBaseDialog
    public void setIsNight(boolean z) {
        super.setIsNight(z);
        ThemeWatcher themeWatcher = this.mThemeWatcher;
        if (themeWatcher != null) {
            themeWatcher.changeTheme(z);
        }
    }

    @Override // com.xiaopeng.montecarlo.views.dialog.XBaseDialog
    public void initDialog() {
        super.initDialog();
        showTitle(false);
        showClose(false);
        setGravity(17);
        showCancelButton(true);
    }

    public void setThemeWatcher(ThemeWatcher themeWatcher) {
        this.mThemeWatcher = themeWatcher;
    }
}
