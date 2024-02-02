package com.xiaopeng.montecarlo.views;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.xui.widget.XImageView;
import com.xiaopeng.xui.widget.XTextView;
/* loaded from: classes3.dex */
public class ParkChargeStatusView_ViewBinding implements Unbinder {
    private ParkChargeStatusView target;

    @UiThread
    public ParkChargeStatusView_ViewBinding(ParkChargeStatusView parkChargeStatusView) {
        this(parkChargeStatusView, parkChargeStatusView);
    }

    @UiThread
    public ParkChargeStatusView_ViewBinding(ParkChargeStatusView parkChargeStatusView, View view) {
        this.target = parkChargeStatusView;
        parkChargeStatusView.mIvParkIcon = (XImageView) Utils.findRequiredViewAsType(view, R.id.iv_park_icon, "field 'mIvParkIcon'", XImageView.class);
        parkChargeStatusView.mTvParkRemain = (XTextView) Utils.findRequiredViewAsType(view, R.id.tv_park_remain, "field 'mTvParkRemain'", XTextView.class);
        parkChargeStatusView.mTvParkRemainNum = (XTextView) Utils.findRequiredViewAsType(view, R.id.tv_park_remain_num, "field 'mTvParkRemainNum'", XTextView.class);
        parkChargeStatusView.mTvParkTotal = (XTextView) Utils.findRequiredViewAsType(view, R.id.tv_park_total, "field 'mTvParkTotal'", XTextView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        ParkChargeStatusView parkChargeStatusView = this.target;
        if (parkChargeStatusView == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        parkChargeStatusView.mIvParkIcon = null;
        parkChargeStatusView.mTvParkRemain = null;
        parkChargeStatusView.mTvParkRemainNum = null;
        parkChargeStatusView.mTvParkTotal = null;
    }
}
