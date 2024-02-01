package com.xiaopeng.montecarlo.views.dialog;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.navcore.bean.location.TestLocInfo;
import com.xiaopeng.montecarlo.navcore.location.DRServiceManager;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.xui.widget.XImageView;
import com.xiaopeng.xui.widget.XLinearLayout;
import com.xiaopeng.xui.widget.XRelativeLayout;
import com.xiaopeng.xui.widget.XTextView;
/* loaded from: classes3.dex */
public class LocationDebugDialog extends XRelativeLayout implements View.OnClickListener, View.OnTouchListener {
    private static final int MSG_WHAT = 1;
    private static final L.Tag TAG = new L.Tag("Loc_DebugDialog");
    private XLinearLayout mDialogContent;
    private XTextView mDialogText;
    private int mDownX;
    private int mDownY;
    private Handler mHandler;
    private DRServiceManager.ILocChangeTestListener mILocChangeTestListener;
    private int mRawX;
    private int mRawY;
    private XImageView mScaleImageView;
    private SwitchStateCallback mSwitchStateCallback;

    /* loaded from: classes3.dex */
    public interface SwitchStateCallback {
        void updateViewHeight(int i);

        void updateViewLayout(int i, int i2);

        void updateViewLayoutSize(boolean z);
    }

    public LocationDebugDialog(Context context) {
        this(context, null);
    }

    public LocationDebugDialog(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LocationDebugDialog(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mScaleImageView = null;
        this.mDialogContent = null;
        this.mDialogText = null;
        this.mSwitchStateCallback = null;
        this.mHandler = new Handler() { // from class: com.xiaopeng.montecarlo.views.dialog.LocationDebugDialog.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
                if (message.what != 1) {
                    return;
                }
                LocationDebugDialog.this.showDebugText((TestLocInfo) message.obj);
            }
        };
        this.mILocChangeTestListener = new DRServiceManager.ILocChangeTestListener() { // from class: com.xiaopeng.montecarlo.views.dialog.LocationDebugDialog.2
            @Override // com.xiaopeng.montecarlo.navcore.location.DRServiceManager.ILocChangeTestListener
            public void locChange(TestLocInfo testLocInfo) {
                if (LocationDebugDialog.this.isDialogContentShow()) {
                    LocationDebugDialog.this.mHandler.obtainMessage(1, testLocInfo).sendToTarget();
                }
            }
        };
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.mScaleImageView = (XImageView) findViewById(R.id.loc_debug_dialog_scale);
        this.mDialogContent = (XLinearLayout) findViewById(R.id.loc_debug_dialog_content);
        this.mDialogText = (XTextView) findViewById(R.id.loc_debug_dialog_text);
        this.mScaleImageView.setOnClickListener(this);
        this.mScaleImageView.setOnTouchListener(this);
        DRServiceManager.getInstance().addLocChangeTestListener(this.mILocChangeTestListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDebugText(TestLocInfo testLocInfo) {
        String vehicleString;
        int locDebugMode = DRServiceManager.getInstance().getLocDebugMode();
        if (1 == locDebugMode) {
            vehicleString = testLocInfo.toString();
        } else {
            vehicleString = 2 == locDebugMode ? testLocInfo.toVehicleString() : "";
        }
        this.mDialogText.setText(vehicleString);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.xui.widget.XRelativeLayout, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        DRServiceManager.getInstance().removeLocChangeTestListener(this.mILocChangeTestListener);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        view.getId();
    }

    public void setSwitchStateCallback(SwitchStateCallback switchStateCallback) {
        this.mSwitchStateCallback = switchStateCallback;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.mRawX = (int) motionEvent.getRawX();
            this.mRawY = (int) motionEvent.getRawY();
            this.mDownX = this.mRawX;
            this.mDownY = this.mRawY;
        } else if (action == 1) {
            int rawY = (int) motionEvent.getRawY();
            if (Math.abs(((int) motionEvent.getRawX()) - this.mDownX) < 10 && Math.abs(rawY - this.mDownY) < 10) {
                boolean z = this.mDialogContent.getVisibility() != 0;
                this.mDialogContent.setVisibility(z ? 0 : 8);
                SwitchStateCallback switchStateCallback = this.mSwitchStateCallback;
                if (switchStateCallback != null) {
                    switchStateCallback.updateViewLayoutSize(z);
                }
            }
        } else if (action == 2) {
            int rawX = (int) motionEvent.getRawX();
            int rawY2 = (int) motionEvent.getRawY();
            int i = rawX - this.mRawX;
            int i2 = rawY2 - this.mRawY;
            this.mRawX = rawX;
            this.mRawY = rawY2;
            SwitchStateCallback switchStateCallback2 = this.mSwitchStateCallback;
            if (switchStateCallback2 != null) {
                switchStateCallback2.updateViewLayout(i, i2);
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isDialogContentShow() {
        XLinearLayout xLinearLayout = this.mDialogContent;
        return xLinearLayout != null && xLinearLayout.getVisibility() == 0;
    }
}
