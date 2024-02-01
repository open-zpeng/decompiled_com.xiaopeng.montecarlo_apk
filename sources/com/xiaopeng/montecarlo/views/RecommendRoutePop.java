package com.xiaopeng.montecarlo.views;

import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import androidx.annotation.Nullable;
import com.autonavi.gbl.guide.model.PathTrafficEventInfo;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.XpThemeSwitchReceiver;
import com.xiaopeng.montecarlo.navcore.mapdisplay.MapViewWrapper;
import com.xiaopeng.montecarlo.navcore.util.TBTUtil;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.IVariantPath;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.util.ThemeWatcherUtil;
import com.xiaopeng.xui.widget.XImageView;
import com.xiaopeng.xui.widget.XLinearLayout;
import com.xiaopeng.xui.widget.XTextView;
/* loaded from: classes3.dex */
public class RecommendRoutePop extends XLinearLayout implements View.OnClickListener {
    private static final L.Tag TAG = new L.Tag("RecommendRoutePop");
    private int mIconId;
    private PathTrafficEventInfo mInfo;
    private IRecommendRouteSwitchListener mListener;
    private MapViewWrapper mMapViewWrapper;
    private IVariantPath mPath;
    private View mRootView;
    private XTextView mRouteSwitchButton;
    private XTextView mRouteTrafficDescription;
    private XTextView mRouteTrafficDescription2;
    private XImageView mRouteTrafficIcon;
    private XTextView mRouteTrafficIgnoreButton;
    private XTextView mRouteTrafficSaveTime;
    private XTextView mRouteTrafficTitle;
    private int mRouteType;
    private XpThemeSwitchReceiver.ThemeSwitchListener mThemeSwitchListener;

    /* loaded from: classes3.dex */
    public interface IRecommendRouteSwitchListener {
        void onIgnore();

        void onSwitch(IVariantPath iVariantPath, int i);
    }

    public RecommendRoutePop(Context context) {
        super(context);
        this.mListener = null;
        this.mPath = null;
        this.mThemeSwitchListener = new XpThemeSwitchReceiver.ThemeSwitchListener() { // from class: com.xiaopeng.montecarlo.views.RecommendRoutePop.1
            @Override // com.xiaopeng.montecarlo.XpThemeSwitchReceiver.ThemeSwitchListener
            public void onThemeSwitch(int i) {
                RecommendRoutePop.this.updateTheme();
            }
        };
        init(context);
    }

    public RecommendRoutePop(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mListener = null;
        this.mPath = null;
        this.mThemeSwitchListener = new XpThemeSwitchReceiver.ThemeSwitchListener() { // from class: com.xiaopeng.montecarlo.views.RecommendRoutePop.1
            @Override // com.xiaopeng.montecarlo.XpThemeSwitchReceiver.ThemeSwitchListener
            public void onThemeSwitch(int i) {
                RecommendRoutePop.this.updateTheme();
            }
        };
        init(context);
    }

    public RecommendRoutePop(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mListener = null;
        this.mPath = null;
        this.mThemeSwitchListener = new XpThemeSwitchReceiver.ThemeSwitchListener() { // from class: com.xiaopeng.montecarlo.views.RecommendRoutePop.1
            @Override // com.xiaopeng.montecarlo.XpThemeSwitchReceiver.ThemeSwitchListener
            public void onThemeSwitch(int i2) {
                RecommendRoutePop.this.updateTheme();
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.layout_route_change_by_traffic, this);
        this.mRouteTrafficIcon = (XImageView) this.mRootView.findViewById(R.id.route_traffic_icon);
        this.mRouteTrafficTitle = (XTextView) this.mRootView.findViewById(R.id.route_traffic_title);
        this.mRouteTrafficDescription = (XTextView) this.mRootView.findViewById(R.id.route_traffic_description);
        this.mRouteTrafficDescription2 = (XTextView) this.mRootView.findViewById(R.id.route_traffic_description_2);
        this.mRouteTrafficSaveTime = (XTextView) this.mRootView.findViewById(R.id.route_traffic_save_time);
        this.mRouteTrafficIgnoreButton = (XTextView) this.mRootView.findViewById(R.id.route_traffic_ignore_button);
        this.mRouteSwitchButton = (XTextView) this.mRootView.findViewById(R.id.route_switch_button);
        this.mRouteSwitchButton.setOnClickListener(this);
        this.mRouteTrafficIgnoreButton.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id != R.id.route_switch_button) {
            if (id != R.id.route_traffic_ignore_button) {
                return;
            }
            setVisibility(8);
            if (this.mListener != null) {
                L.i(TAG, "click ignore");
                this.mListener.onIgnore();
                return;
            }
            return;
        }
        setVisibility(8);
        if (this.mListener != null) {
            L.Tag tag = TAG;
            L.i(tag, "click switch: pathID: " + TBTUtil.getPathId(this.mPath) + ", routeType: " + this.mRouteType);
            this.mListener.onSwitch(this.mPath, this.mRouteType);
        }
    }

    private void setTrafficIcon(int i) {
        this.mIconId = i;
        this.mRouteTrafficIcon.setImageResource(i);
    }

    private void setTitle(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.mRouteTrafficTitle.setVisibility(0);
            this.mRouteTrafficTitle.setText(str);
            return;
        }
        this.mRouteTrafficTitle.setVisibility(8);
    }

    private void setDescription(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.mRouteTrafficDescription.setVisibility(0);
            this.mRouteTrafficDescription.setText(str);
            return;
        }
        this.mRouteTrafficDescription.setVisibility(8);
    }

    private void setDescription2(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.mRouteTrafficDescription2.setText(str);
            this.mRouteTrafficDescription2.setVisibility(0);
            return;
        }
        this.mRouteTrafficDescription2.setVisibility(8);
    }

    private void setSaveTime(SpannableString spannableString) {
        if (!TextUtils.isEmpty(spannableString)) {
            this.mRouteTrafficSaveTime.setText(spannableString);
            this.mRouteTrafficSaveTime.setVisibility(0);
            return;
        }
        this.mRouteTrafficSaveTime.setVisibility(8);
    }

    private void setCanSwitch(boolean z) {
        if (z) {
            this.mRouteSwitchButton.setVisibility(0);
        } else {
            this.mRouteSwitchButton.setVisibility(8);
        }
    }

    public void show() {
        setVisibility(0);
        ThemeWatcherUtil.addXpThemeSwitchListener(this.mThemeSwitchListener);
    }

    public void hide() {
        setVisibility(8);
        ThemeWatcherUtil.removeXpThemeListener(this.mThemeSwitchListener);
        setListener(null);
    }

    public void updateInfo(String str, int i, String str2, String str3, SpannableString spannableString, IVariantPath iVariantPath, int i2, boolean z) {
        this.mRouteType = i2;
        this.mPath = iVariantPath;
        setTitle(str);
        setTrafficIcon(i);
        setDescription(str2);
        setDescription2(str3);
        setSaveTime(spannableString);
        setCanSwitch(z);
        updateTheme();
    }

    public void setListener(IRecommendRouteSwitchListener iRecommendRouteSwitchListener) {
        this.mListener = iRecommendRouteSwitchListener;
    }

    public void updateTheme() {
        this.mRouteTrafficIcon.setImageResource(ThemeWatcherUtil.getDrawableResId(this.mIconId));
        this.mRouteTrafficIgnoreButton.setTextColor(ThemeWatcherUtil.getColor(R.color.main_title_text_color));
    }

    public void setTimeOutText(long j) {
        String string;
        if (this.mRouteType == 5) {
            string = getContext().getString(R.string.ignore_btn_name_seconds, Long.valueOf(j));
        } else {
            string = getContext().getString(R.string.i_know_btn_name_seconds, Long.valueOf(j));
        }
        this.mRouteTrafficIgnoreButton.setText(string);
    }
}
