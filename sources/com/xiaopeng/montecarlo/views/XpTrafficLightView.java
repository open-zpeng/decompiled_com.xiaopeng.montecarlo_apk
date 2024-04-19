package com.xiaopeng.montecarlo.views;

import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.xiaopeng.libtheme.ThemeManager;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.navcore.sr.TrafficLightState;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.util.ThemeWatcherUtil;
import com.xiaopeng.xui.widget.XFrameLayout;
import com.xiaopeng.xui.widget.XImageView;
/* loaded from: classes3.dex */
public class XpTrafficLightView extends XFrameLayout {
    XImageView mLeftLight;
    XImageView mRightLight;
    XImageView mStraightLight;
    TrafficLightState mTrafficLightState;

    public XpTrafficLightView(Context context) {
        this(context, null);
    }

    public XpTrafficLightView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public XpTrafficLightView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        View inflate = LayoutInflater.from(ContextUtils.getContext()).inflate(R.layout.layout_traffic_light_view, (ViewGroup) this, true);
        this.mLeftLight = (XImageView) inflate.findViewById(R.id.left_or_turnaround_light);
        this.mStraightLight = (XImageView) inflate.findViewById(R.id.straight_light);
        this.mRightLight = (XImageView) inflate.findViewById(R.id.right_light);
    }

    public void setTrafficLightState(TrafficLightState trafficLightState) {
        this.mTrafficLightState = trafficLightState;
        if (trafficLightState == TrafficLightState.NONE) {
            if (getVisibility() != 8) {
                setVisibility(8);
                return;
            }
            return;
        }
        if (getVisibility() != 0) {
            setVisibility(0);
        }
        this.mLeftLight.setImageResource(0);
        this.mStraightLight.setImageResource(0);
        this.mRightLight.setImageResource(0);
        this.mLeftLight.setBackgroundDrawable(ThemeWatcherUtil.getDrawable(R.drawable.trafficlight_empty_left));
        this.mStraightLight.setBackgroundDrawable(ThemeWatcherUtil.getDrawable(R.drawable.trafficlight_empty_center));
        this.mRightLight.setBackgroundDrawable(ThemeWatcherUtil.getDrawable(R.drawable.trafficlight_empty_right));
        switch (trafficLightState) {
            case TURN_LEFT_GREEN:
                this.mLeftLight.setImageResource(R.drawable.trafficlight_green_left);
                return;
            case TURN_LEFT_YELLOW:
                this.mLeftLight.setImageResource(R.drawable.trafficlight_yellow_left);
                return;
            case TURN_LEFT_RED:
                this.mLeftLight.setImageResource(R.drawable.trafficlight_red_left);
                return;
            case TURNAROUND_GREEN:
                this.mLeftLight.setImageResource(R.drawable.trafficlight_green_turnaround);
                return;
            case TURNAROUND_YELLOW:
                this.mLeftLight.setImageResource(R.drawable.trafficlight_yellow_turnaround);
                return;
            case TURNAROUND_RED:
                this.mLeftLight.setImageResource(R.drawable.trafficlight_red_turnaround);
                return;
            case STRAIGHT_GREEN:
                this.mStraightLight.setImageResource(R.drawable.trafficlight_green_center);
                return;
            case STRAIGHT_YELLOW:
                this.mStraightLight.setImageResource(R.drawable.trafficlight_yellow_center);
                return;
            case STRAIGHT_RED:
                this.mStraightLight.setImageResource(R.drawable.trafficlight_red_center);
                return;
            case TURN_RIGHT_GREEN:
                this.mRightLight.setImageResource(R.drawable.trafficlight_green_right);
                return;
            case TURN_RIGHT_YELLOW:
                this.mRightLight.setImageResource(R.drawable.trafficlight_yellow_right);
                return;
            case TURN_RIGHT_RED:
                this.mRightLight.setImageResource(R.drawable.trafficlight_red_right);
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.xui.widget.XFrameLayout, android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (ThemeManager.isThemeChanged(configuration) && getVisibility() == 0) {
            setTrafficLightState(this.mTrafficLightState);
        }
    }
}
