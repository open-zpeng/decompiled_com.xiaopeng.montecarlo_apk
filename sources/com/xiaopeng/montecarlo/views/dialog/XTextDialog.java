package com.xiaopeng.montecarlo.views.dialog;

import android.content.Context;
import com.xiaopeng.montecarlo.R;
/* loaded from: classes3.dex */
public class XTextDialog extends XBaseDialog {
    private ThemeWatcher mThemeWatcher;

    /* loaded from: classes3.dex */
    public interface ThemeWatcher {
        void changeTheme(boolean z);
    }

    public XTextDialog(Context context) {
        super(context);
    }

    public XTextDialog(Context context, int i, boolean z) {
        super(context, i, R.style.dialog_style, z, false);
    }

    @Override // com.xiaopeng.montecarlo.views.dialog.XBaseDialog
    public void initDialog() {
        super.initDialog();
        setGravity(17);
    }

    @Override // com.xiaopeng.montecarlo.views.dialog.XBaseDialog
    public void setIsNight(boolean z) {
        super.setIsNight(z);
        ThemeWatcher themeWatcher = this.mThemeWatcher;
        if (themeWatcher != null) {
            themeWatcher.changeTheme(z);
        }
    }

    public void setThemeWatcher(ThemeWatcher themeWatcher) {
        this.mThemeWatcher = themeWatcher;
    }
}
