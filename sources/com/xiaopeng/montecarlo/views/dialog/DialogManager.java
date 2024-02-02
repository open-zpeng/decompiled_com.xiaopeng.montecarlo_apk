package com.xiaopeng.montecarlo.views.dialog;

import androidx.annotation.NonNull;
import com.xiaopeng.montecarlo.root.util.L;
/* loaded from: classes3.dex */
public class DialogManager {
    private static final L.Tag TAG = new L.Tag("DialogManager");
    private XBindAmapDialog mDialog;
    private DialogPresenter mPresenter;

    public DialogManager(@NonNull XBindAmapDialog xBindAmapDialog) {
        if (xBindAmapDialog == null) {
            throw new NullPointerException("XBindAmapDialog is null");
        }
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "init dailog:" + xBindAmapDialog);
        }
        this.mDialog = xBindAmapDialog;
        this.mPresenter = new DialogPresenter(this.mDialog);
    }

    public void release() {
        if (L.ENABLE) {
            L.d(TAG, "release");
        }
        this.mDialog = null;
        this.mPresenter = null;
    }

    public void secBindAMap() {
        DialogPresenter dialogPresenter = this.mPresenter;
        if (dialogPresenter != null) {
            dialogPresenter.secBindAMap();
        }
    }
}
