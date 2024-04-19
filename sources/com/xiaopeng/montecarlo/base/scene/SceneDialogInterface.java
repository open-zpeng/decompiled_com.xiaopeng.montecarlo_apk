package com.xiaopeng.montecarlo.base.scene;

import android.view.KeyEvent;
/* loaded from: classes2.dex */
public interface SceneDialogInterface {

    /* loaded from: classes2.dex */
    public interface OnCancelListener {
        void onCancel(SceneDialogInterface sceneDialogInterface);
    }

    /* loaded from: classes2.dex */
    public interface OnClickListener {
        void onClick(SceneDialogInterface sceneDialogInterface, int i);
    }

    /* loaded from: classes2.dex */
    public interface OnDismissListener {
        void onDismiss(SceneDialogInterface sceneDialogInterface);
    }

    /* loaded from: classes2.dex */
    public interface OnKeyListener {
        boolean onKey(SceneDialogInterface sceneDialogInterface, int i, KeyEvent keyEvent);
    }

    /* loaded from: classes2.dex */
    public interface OnMultiChoiceClickListener {
        void onClick(SceneDialogInterface sceneDialogInterface, int i, boolean z);
    }

    /* loaded from: classes2.dex */
    public interface OnShowListener {
        void onShow(SceneDialogInterface sceneDialogInterface);
    }

    void cancel();

    void dismiss();
}
