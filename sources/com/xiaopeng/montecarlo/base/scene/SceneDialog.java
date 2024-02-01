package com.xiaopeng.montecarlo.base.scene;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.xiaopeng.montecarlo.base.scene.SceneDialogInterface;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public abstract class SceneDialog implements SceneDialogInterface, IQueueWorker {
    private static final int CANCEL = 68;
    private static final int DISMISS = 67;
    private static final int SHOW = 69;
    private Message mCancelMessage;
    private final Context mContext;
    private ViewGroup mDecor;
    private Message mDismissMessage;
    private final int mLayoutId;
    private LayoutInflater mLayoutInflater;
    private final IBaseScene mScene;
    private Message mShowMessage;
    private final Handler mHandler = new Handler(Looper.getMainLooper());
    private boolean mCreated = false;
    private boolean mShowing = false;
    private boolean mCanceled = false;
    private final Runnable mDismissAction = new Runnable() { // from class: com.xiaopeng.montecarlo.base.scene.SceneDialog.1
        @Override // java.lang.Runnable
        public void run() {
            SceneDialog.this.dismissDialog();
        }
    };
    private Handler mListenersHandler = new ListenersHandler(this);

    protected abstract void onCreate(Bundle bundle);

    protected abstract void onStart();

    protected abstract void onStop();

    public SceneDialog(Context context, IBaseScene iBaseScene, int i) {
        this.mContext = context;
        this.mScene = iBaseScene;
        this.mLayoutId = i;
        this.mLayoutInflater = LayoutInflater.from(context);
    }

    private void show() {
        if (this.mShowing) {
            ViewGroup viewGroup = this.mDecor;
            if (viewGroup != null) {
                viewGroup.setVisibility(0);
                return;
            }
            return;
        }
        this.mCanceled = false;
        ViewGroup baseView = this.mScene.getBaseView();
        this.mDecor = (ViewGroup) this.mLayoutInflater.inflate(this.mLayoutId, baseView, false);
        baseView.addView(this.mDecor);
        if (!this.mCreated) {
            dispatchOnCreate(null);
        }
        onStart();
        this.mShowing = true;
        sendShowMessage();
    }

    private void hide() {
        ViewGroup viewGroup = this.mDecor;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
    }

    @Override // com.xiaopeng.montecarlo.base.scene.SceneDialogInterface
    public void cancel() {
        Message message;
        if (!this.mCanceled && (message = this.mCancelMessage) != null) {
            this.mCanceled = true;
            Message.obtain(message).sendToTarget();
        }
        dismiss();
    }

    @Override // com.xiaopeng.montecarlo.base.scene.SceneDialogInterface
    public void dismiss() {
        if (Looper.myLooper() == this.mHandler.getLooper()) {
            dismissDialog();
        } else {
            this.mHandler.post(this.mDismissAction);
        }
    }

    @Override // com.xiaopeng.montecarlo.base.scene.IQueueWorker
    public void run() {
        show();
    }

    @Override // com.xiaopeng.montecarlo.base.scene.IQueueWorker
    public String dump() {
        return getClass().getSimpleName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dismissDialog() {
        if (this.mDecor == null || !this.mShowing) {
            return;
        }
        ViewGroup baseView = this.mScene.getBaseView();
        if (baseView != null) {
            baseView.removeView(this.mDecor);
        }
        this.mDecor = null;
        onStop();
        this.mShowing = false;
        sendDismissMessage();
        this.mScene.endWorker(this);
    }

    private void sendDismissMessage() {
        Message message = this.mDismissMessage;
        if (message != null) {
            Message.obtain(message).sendToTarget();
        }
    }

    private void sendShowMessage() {
        Message message = this.mShowMessage;
        if (message != null) {
            Message.obtain(message).sendToTarget();
        }
    }

    void dispatchOnCreate(Bundle bundle) {
        if (this.mCreated) {
            return;
        }
        onCreate(bundle);
        this.mCreated = true;
    }

    public ViewGroup getView() {
        return this.mDecor;
    }

    public View findViewById(int i) {
        ViewGroup viewGroup = this.mDecor;
        if (viewGroup != null) {
            return viewGroup.findViewById(i);
        }
        return null;
    }

    public final Context getContext() {
        return this.mContext;
    }

    public boolean isShowing() {
        return this.mShowing;
    }

    public void setOnCancelListener(SceneDialogInterface.OnCancelListener onCancelListener) {
        if (onCancelListener != null) {
            this.mCancelMessage = this.mListenersHandler.obtainMessage(68, onCancelListener);
        } else {
            this.mCancelMessage = null;
        }
    }

    public void setOnDismissListener(SceneDialogInterface.OnDismissListener onDismissListener) {
        if (onDismissListener != null) {
            this.mDismissMessage = this.mListenersHandler.obtainMessage(67, onDismissListener);
        } else {
            this.mDismissMessage = null;
        }
    }

    public void setOnShowListener(SceneDialogInterface.OnShowListener onShowListener) {
        if (onShowListener != null) {
            this.mShowMessage = this.mListenersHandler.obtainMessage(69, onShowListener);
        } else {
            this.mShowMessage = null;
        }
    }

    /* loaded from: classes.dex */
    private static final class ListenersHandler extends Handler {
        private WeakReference<SceneDialogInterface> mDialog;

        ListenersHandler(SceneDialog sceneDialog) {
            this.mDialog = new WeakReference<>(sceneDialog);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 67:
                    ((SceneDialogInterface.OnDismissListener) message.obj).onDismiss(this.mDialog.get());
                    return;
                case 68:
                    ((SceneDialogInterface.OnCancelListener) message.obj).onCancel(this.mDialog.get());
                    return;
                case 69:
                    ((SceneDialogInterface.OnShowListener) message.obj).onShow(this.mDialog.get());
                    return;
                default:
                    return;
            }
        }
    }
}
