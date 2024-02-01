package com.xiaopeng.montecarlo.views.dialog;

import android.content.Context;
import android.view.Window;
import android.view.WindowManager;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.xui.app.XLoadingDialog;
/* loaded from: classes3.dex */
public class XLandLoadingDialog extends XLoadingDialog {
    public XLandLoadingDialog(Context context) {
        this(context, R.style.loading_dialog_style);
    }

    public XLandLoadingDialog(Context context, int i) {
        super(context, i);
        create();
    }

    public void correctedLocation() {
        Window window = getWindow();
        if (window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.gravity = 17;
            window.setAttributes(attributes);
        }
    }
}
