package com.xiaopeng.montecarlo.views;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.navcore.sr.IHappyEnding;
import com.xiaopeng.montecarlo.navcore.sr.data.HappyEnding;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.TimeFormatUtil;
import com.xiaopeng.montecarlo.root.util.UiHandlerUtil;
import com.xiaopeng.montecarlo.root.util.WorkThreadUtil;
import com.xiaopeng.xui.app.XDialogPure;
import com.xiaopeng.xui.widget.XButton;
import com.xiaopeng.xui.widget.XLinearLayout;
import com.xiaopeng.xui.widget.XTextView;
/* loaded from: classes3.dex */
public class HappyEndingView implements IHappyEnding {
    @Override // com.xiaopeng.montecarlo.navcore.sr.IHappyEnding
    public void onShow(@NonNull final HappyEnding happyEnding) {
        WorkThreadUtil.getInstance().executeCachedTask(new Runnable() { // from class: com.xiaopeng.montecarlo.views.-$$Lambda$HappyEndingView$Sw3lKom_gExpIncPL1avaQ7VE_g
            @Override // java.lang.Runnable
            public final void run() {
                HappyEndingView.lambda$onShow$2(HappyEnding.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$onShow$2(@NonNull final HappyEnding happyEnding) {
        final View inflate = LayoutInflater.from(ContextUtils.getContext()).inflate(R.layout.layout_happy_ending_dialog, (ViewGroup) null, false);
        if (inflate == null) {
            return;
        }
        UiHandlerUtil.getInstance().runOnUiThread(new Runnable() { // from class: com.xiaopeng.montecarlo.views.-$$Lambda$HappyEndingView$-GtHlScADZtg_iLv06vQSQTqRyE
            @Override // java.lang.Runnable
            public final void run() {
                HappyEndingView.lambda$null$1(inflate, happyEnding);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$null$1(@SuppressLint({"InflateParams"}) View view, @NonNull HappyEnding happyEnding) {
        int i;
        XLinearLayout xLinearLayout = (XLinearLayout) view.findViewById(R.id.happy_ending_detail);
        Glide.with(ContextUtils.getContext()).load(happyEnding.getAvatar()).apply(new RequestOptions().placeholder(R.drawable.x_ic_logo).circleCrop()).into((ImageView) view.findViewById(R.id.happy_ending_user_img));
        ((XTextView) view.findViewById(R.id.happy_ending_user_name)).setText(happyEnding.getName());
        ((XTextView) view.findViewById(R.id.happy_ending_time)).setText(TimeFormatUtil.formatMonthTime(happyEnding.getTime()));
        ((XTextView) view.findViewById(R.id.happy_ending_total_mileage_value)).setText(String.valueOf(((int) happyEnding.getTotalMileage()) / 1000));
        XLinearLayout xLinearLayout2 = (XLinearLayout) view.findViewById(R.id.happy_ending_traffic_light);
        if (happyEnding.getTrafficLightsCount() > 0) {
            xLinearLayout2.setVisibility(0);
            ((XTextView) view.findViewById(R.id.happy_ending_traffic_light_value)).setText(String.valueOf(happyEnding.getTrafficLightsCount()));
            i = 1;
        } else {
            xLinearLayout2.setVisibility(8);
            i = 0;
        }
        XLinearLayout xLinearLayout3 = (XLinearLayout) view.findViewById(R.id.happy_ending_lane_change);
        if (happyEnding.getLaneChangeCount() > 0) {
            i++;
            xLinearLayout3.setVisibility(0);
            ((XTextView) view.findViewById(R.id.happy_ending_lane_change_value)).setText(String.valueOf(happyEnding.getLaneChangeCount()));
        } else {
            xLinearLayout3.setVisibility(8);
        }
        XLinearLayout xLinearLayout4 = (XLinearLayout) view.findViewById(R.id.happy_ending_roundabout);
        if (happyEnding.getRoundaboutCount() > 0) {
            i++;
            xLinearLayout4.setVisibility(0);
            ((XTextView) view.findViewById(R.id.happy_ending_roundabout_value)).setText(String.valueOf(happyEnding.getRoundaboutCount()));
        } else {
            xLinearLayout4.setVisibility(8);
        }
        XLinearLayout xLinearLayout5 = (XLinearLayout) view.findViewById(R.id.happy_ending_obstacle);
        if (happyEnding.getDetourObstacleCount() > 0) {
            i++;
            xLinearLayout5.setVisibility(0);
            ((XTextView) view.findViewById(R.id.happy_ending_obstacle_value)).setText(String.valueOf(happyEnding.getDetourObstacleCount()));
        } else {
            xLinearLayout5.setVisibility(8);
        }
        xLinearLayout.setWeightSum(i > 3 ? 4.0f : 3.0f);
        XDialogPure.Parameters Builder = XDialogPure.Parameters.Builder();
        Builder.setLayoutParams(new ViewGroup.LayoutParams(ContextUtils.getDimensionPixelSize(R.dimen.happy_ending_width), ContextUtils.getDimensionPixelSize(R.dimen.happy_ending_height)));
        Builder.setFullScreen(true);
        final XDialogPure xDialogPure = new XDialogPure(ContextUtils.getContext(), Builder);
        ((XButton) view.findViewById(R.id.happy_ending_done)).setOnClickListener(new View.OnClickListener() { // from class: com.xiaopeng.montecarlo.views.-$$Lambda$HappyEndingView$6jkxEi_xcWZL6vKJnMSBu1HVzVA
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                XDialogPure.this.dismiss();
            }
        });
        xDialogPure.setContentView(view);
        xDialogPure.setCanceledOnTouchOutside(true);
        xDialogPure.setSystemDialog(2008);
        xDialogPure.show();
    }
}
