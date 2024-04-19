package com.xiaopeng.montecarlo.views.dialog;

import android.content.Context;
import android.view.View;
import androidx.annotation.StyleRes;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.XpThemeSwitchReceiver;
import com.xiaopeng.montecarlo.root.theme.ThemeType;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.util.ThemeWatcherUtil;
import com.xiaopeng.xui.app.XDialog;
import com.xiaopeng.xui.app.XDialogInterface;
/* loaded from: classes3.dex */
public class XBaseDialog extends XDialog {
    private CharSequence mCancelText;
    private XDialogInterface.OnClickListener mNegativeButtonListener;
    private CharSequence mOkText;
    private XDialogInterface.OnClickListener mPositiveButtonListener;
    private XpThemeSwitchReceiver.ThemeSwitchListener mThemeSwitchListener;

    /* loaded from: classes3.dex */
    public interface ThemeWatcher {
        void changeTheme(boolean z);
    }

    @Override // com.xiaopeng.xui.app.XDialog
    public void cancel() {
    }

    @StyleRes
    public int getTheme() {
        return R.style.dialog_style;
    }

    public void setCancelButtonTextColor(int i) {
    }

    public void setGravity(int i) {
    }

    public void setIsNight(boolean z) {
    }

    public void setOkButtonTextColor(int i) {
    }

    public void setThemeWatcher(ThemeWatcher themeWatcher) {
    }

    public void showCancelButton(boolean z) {
    }

    public void showOkButton(boolean z) {
    }

    public void showTitle(boolean z) {
    }

    public /* synthetic */ void lambda$new$0$XBaseDialog(int i) {
        setIsNight(ThemeType.parseTheme(i).isNightMode());
    }

    public XBaseDialog(Context context) {
        this(context, -1, true);
    }

    public XBaseDialog(Context context, int i) {
        this(context, i, true);
    }

    public XBaseDialog(Context context, int i, boolean z) {
        this(context, i, R.style.dialog_style, z, true);
    }

    public XBaseDialog(Context context, int i, @StyleRes int i2, boolean z, boolean z2) {
        super(context, i, XDialog.Parameters.Builder().setTheme(i2).setFullScreen(z));
        this.mThemeSwitchListener = new XpThemeSwitchReceiver.ThemeSwitchListener() { // from class: com.xiaopeng.montecarlo.views.dialog.-$$Lambda$XBaseDialog$96fovstp4dNfoQQml5jYKUeB54Q
            @Override // com.xiaopeng.montecarlo.XpThemeSwitchReceiver.ThemeSwitchListener
            public final void onThemeSwitch(int i3) {
                XBaseDialog.this.lambda$new$0$XBaseDialog(i3);
            }
        };
        if (z2) {
            setSystemDialog(2008);
        }
        this.mOkText = ContextUtils.getText(17039370);
        this.mCancelText = ContextUtils.getText(17039360);
        initDialog();
    }

    public void initDialog() {
        getContentView().addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.xiaopeng.montecarlo.views.dialog.XBaseDialog.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                ThemeWatcherUtil.addXpThemeSwitchListener(XBaseDialog.this.mThemeSwitchListener);
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                ThemeWatcherUtil.removeXpThemeListener(XBaseDialog.this.mThemeSwitchListener);
            }
        });
    }

    public XDialog setContentView(View view, boolean z) {
        return setCustomView(view, z);
    }

    public void setContentText(int i) {
        setContentText(ContextUtils.getString(i));
    }

    public void setContentText(String str) {
        setMessage(str);
    }

    public void setOkButtonText(int i) {
        setOkButtonText(ContextUtils.getString(i));
    }

    public void setOkButtonText(CharSequence charSequence) {
        this.mOkText = charSequence;
        setPositiveButton(this.mOkText, this.mPositiveButtonListener);
    }

    public void setOkButtonClickListener(final View.OnClickListener onClickListener) {
        this.mPositiveButtonListener = new XDialogInterface.OnClickListener() { // from class: com.xiaopeng.montecarlo.views.dialog.XBaseDialog.2
            @Override // com.xiaopeng.xui.app.XDialogInterface.OnClickListener
            public void onClick(XDialog xDialog, int i) {
                View.OnClickListener onClickListener2 = onClickListener;
                if (onClickListener2 != null) {
                    onClickListener2.onClick(xDialog.getContentView());
                }
            }
        };
        setPositiveButton(this.mOkText, this.mPositiveButtonListener);
    }

    public void setCancelButtonText(int i) {
        setCancelButtonText(ContextUtils.getText(i));
    }

    public void setCancelButtonText(CharSequence charSequence) {
        this.mCancelText = charSequence;
        setNegativeButton(this.mCancelText, this.mNegativeButtonListener);
    }

    public void setCancelButtonClickListener(final View.OnClickListener onClickListener) {
        this.mNegativeButtonListener = new XDialogInterface.OnClickListener() { // from class: com.xiaopeng.montecarlo.views.dialog.XBaseDialog.3
            @Override // com.xiaopeng.xui.app.XDialogInterface.OnClickListener
            public void onClick(XDialog xDialog, int i) {
                View.OnClickListener onClickListener2 = onClickListener;
                if (onClickListener2 != null) {
                    onClickListener2.onClick(xDialog.getContentView());
                }
            }
        };
        setNegativeButton(this.mCancelText, this.mNegativeButtonListener);
    }

    public void hideCancelButton() {
        setNegativeButton((CharSequence) null);
    }

    public void setOkButtonEnable(boolean z) {
        setPositiveButtonEnable(z);
    }

    public void setCancelButtonEnable(boolean z) {
        setNegativeButtonEnable(z);
    }

    public void showClose(boolean z) {
        setCloseVisibility(z);
    }

    @Override // com.xiaopeng.xui.app.XDialog
    public boolean isShowing() {
        return getDialog().isShowing();
    }
}
