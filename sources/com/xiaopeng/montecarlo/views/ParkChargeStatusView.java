package com.xiaopeng.montecarlo.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.util.ThemeWatcherUtil;
import com.xiaopeng.xui.widget.XImageView;
import com.xiaopeng.xui.widget.XTextView;
/* loaded from: classes3.dex */
public class ParkChargeStatusView extends LinearLayout {
    public static final int TYPE_PARK = 0;
    private int mIconHeight;
    private int mIconWidth;
    @BindView(R.id.iv_park_icon)
    XImageView mIvParkIcon;
    private int mNumTextSize;
    private int mParkTextSize;
    private View mRootView;
    @BindView(R.id.tv_park_remain)
    XTextView mTvParkRemain;
    @BindView(R.id.tv_park_remain_num)
    XTextView mTvParkRemainNum;
    @BindView(R.id.tv_park_total)
    XTextView mTvParkTotal;
    private int mType;

    public ParkChargeStatusView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public ParkChargeStatusView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mType = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ParkChargeStatusView);
        if (obtainStyledAttributes != null) {
            try {
                try {
                    this.mType = obtainStyledAttributes.getInteger(4, 0);
                    this.mIconWidth = obtainStyledAttributes.getDimensionPixelSize(1, 40);
                    this.mIconHeight = obtainStyledAttributes.getDimensionPixelSize(0, 26);
                    this.mParkTextSize = obtainStyledAttributes.getDimensionPixelSize(3, 20);
                    this.mNumTextSize = obtainStyledAttributes.getDimensionPixelSize(2, 20);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.layout_park_info, this);
        ButterKnife.bind(this, this.mRootView);
        ViewGroup.LayoutParams layoutParams = this.mIvParkIcon.getLayoutParams();
        layoutParams = layoutParams == null ? new ViewGroup.LayoutParams(-2, -2) : layoutParams;
        layoutParams.width = this.mIconWidth;
        layoutParams.height = this.mIconHeight;
        this.mIvParkIcon.setLayoutParams(layoutParams);
        setGravity(16);
        this.mTvParkRemain.setTextSize(this.mParkTextSize);
        this.mTvParkRemainNum.setTextSize(this.mNumTextSize);
        this.mTvParkTotal.setTextSize(this.mParkTextSize);
    }

    public void initParkSpaceData(XPPoiInfo xPPoiInfo) {
        if (xPPoiInfo == null) {
            return;
        }
        initParkSpaceData(xPPoiInfo.getParkTotal(), xPPoiInfo.getParkRemain());
    }

    private void initParkSpaceData(int i, int i2) {
        if (i == 0 && i2 == 0) {
            this.mRootView.setVisibility(0);
            this.mTvParkRemain.setVisibility(8);
            this.mTvParkRemainNum.setVisibility(8);
            this.mTvParkTotal.setVisibility(0);
            this.mTvParkTotal.setText(ContextUtils.getString(R.string.park_info_full));
            this.mIvParkIcon.setImageResource(ThemeWatcherUtil.getDrawableResId(R.drawable.vector_tag_texttag_smallunavailable_p));
        } else if (i <= 0 || i2 <= 0) {
            if (i > 0 && i2 < 0) {
                this.mRootView.setVisibility(0);
                this.mTvParkRemain.setVisibility(8);
                this.mTvParkRemainNum.setVisibility(8);
                this.mTvParkTotal.setVisibility(0);
                this.mTvParkTotal.setText(String.format(ContextUtils.getString(R.string.park_info_total), Integer.valueOf(i)));
                this.mIvParkIcon.setImageDrawable(ThemeWatcherUtil.getDrawable(R.drawable.vector_tag_texttag_smallp));
                return;
            }
            this.mRootView.setVisibility(8);
        } else {
            this.mRootView.setVisibility(0);
            this.mTvParkRemain.setVisibility(0);
            this.mTvParkRemainNum.setVisibility(0);
            this.mTvParkTotal.setVisibility(0);
            this.mTvParkRemainNum.setText(String.valueOf(i2));
            XTextView xTextView = this.mTvParkTotal;
            xTextView.setText("/" + String.format(ContextUtils.getString(R.string.park_info_total_card), Integer.valueOf(i)));
            this.mIvParkIcon.setImageDrawable(ThemeWatcherUtil.getDrawable(R.drawable.vector_tag_texttag_smallp));
        }
    }

    private int getTypeColor(int i) {
        return ContextUtils.getColor(R.color.primary_positive_normal);
    }
}
