package com.xiaopeng.montecarlo.views;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import com.xiaopeng.libtheme.ThemeManager;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPLaneInfo;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.RootUtil;
import com.xiaopeng.montecarlo.util.ResUtil;
import com.xiaopeng.xui.widget.XLinearLayout;
import java.util.List;
/* loaded from: classes3.dex */
public class LaneInfoView extends XLinearLayout {
    private static final int NAV_LANES_MAX = 7;
    private static final int NAV_LANES_MAX_RESIZE_HEIGHT = 10;
    private static final int NAV_LANES_MAX_RESIZE_WIDTH = 7;
    private static final L.Tag TAG = new L.Tag("LaneInfoView");
    private boolean mIsResize;
    private int mLaneItemViewNormalSize;
    private int mLaneItemViewSize;
    private int mLaneItemViewSmallSize;
    private int mLaneNum;
    private int mLeft;
    private int mMaxHideCount;
    private int mMaxWidth;
    private IOnVisibilityChangeListener mOnVisibilityChangeListener;
    private int mRight;
    private boolean mShowMiddle;
    private int mTop;

    /* loaded from: classes3.dex */
    public interface IOnVisibilityChangeListener {
        void onVisibilityChanged(int i);
    }

    public LaneInfoView(Context context) {
        this(context, null);
    }

    public LaneInfoView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LaneInfoView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mIsResize = false;
        this.mMaxHideCount = 7;
        this.mLaneNum = 0;
        this.mLeft = 0;
        this.mRight = 0;
        this.mTop = 0;
        this.mShowMiddle = false;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.LaneInfoView);
        try {
            if (obtainStyledAttributes != null) {
                try {
                    this.mIsResize = obtainStyledAttributes.getBoolean(0, false);
                    this.mMaxHideCount = obtainStyledAttributes.getInteger(1, 7);
                    this.mShowMiddle = obtainStyledAttributes.getBoolean(2, this.mShowMiddle);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            initView();
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        IOnVisibilityChangeListener iOnVisibilityChangeListener = this.mOnVisibilityChangeListener;
        if (iOnVisibilityChangeListener != null) {
            iOnVisibilityChangeListener.onVisibilityChanged(i);
        }
    }

    private void initView() {
        setDividerDrawable(ContextUtils.getDrawable(R.drawable.divider_horizontal_padding10_lane));
        setShowDividers(2);
        setDividerPadding(0);
        this.mLaneItemViewNormalSize = getResources().getDimensionPixelSize(R.dimen.guide_lane_size);
        this.mLaneItemViewSmallSize = getResources().getDimensionPixelSize(R.dimen.guide_lane_small_size);
        this.mLaneItemViewSize = this.mLaneItemViewNormalSize;
        this.mTop = getResources().getDimensionPixelSize(R.dimen.lane_status_cross_top);
        this.mRight = RootUtil.getScreenWidth();
    }

    public void setOnVisibilityChangeListener(IOnVisibilityChangeListener iOnVisibilityChangeListener) {
        this.mOnVisibilityChangeListener = iOnVisibilityChangeListener;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.xui.widget.XLinearLayout, android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (ThemeManager.isThemeChanged(configuration) && getVisibility() == 0) {
            for (int i = 0; i < getChildCount(); i++) {
                ImageView imageView = (ImageView) getChildAt(i);
                if (imageView != null && imageView.getTag() != null) {
                    imageView.setImageResource(((Integer) imageView.getTag()).intValue());
                }
            }
        }
    }

    public void updateLaneData(XPLaneInfo xPLaneInfo) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("updateLaneData laneInfo: ");
            sb.append(xPLaneInfo == null ? " null" : Integer.valueOf(xPLaneInfo.mFrontLane.length));
            L.d(tag, sb.toString());
        }
        if (xPLaneInfo == null || xPLaneInfo.mFrontLane.length < 1) {
            this.mLaneNum = 0;
            setVisibility(8);
            return;
        }
        this.mLaneNum = xPLaneInfo.mFrontLane.length;
        if (xPLaneInfo.mFrontLane.length > this.mMaxHideCount) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        if (this.mIsResize) {
            updateLaneParams(xPLaneInfo.mFrontLane.length);
        }
        addLaneViews(xPLaneInfo.mFrontLane, xPLaneInfo.mBackLane);
    }

    private void addLaneViews(int[] iArr, int[] iArr2) {
        int i = 0;
        for (int i2 = 0; i2 < iArr.length; i2++) {
            int laneResource = ResUtil.getLaneResource(iArr2[i2], iArr[i2], true);
            if (laneResource == 0) {
                L.w(TAG, ">>> have not ind the resource id of lane image");
            } else {
                addLaneView(i, laneResource);
                i++;
            }
        }
        for (int i3 = i; i3 < getChildCount(); i3++) {
            getChildAt(i3).setVisibility(8);
        }
        if (i == 0) {
            setVisibility(8);
        }
    }

    private void addLaneView(int i, int i2) {
        LinearLayout.LayoutParams layoutParams;
        ImageView imageView = (ImageView) getChildAt(i);
        boolean z = false;
        if (imageView == null) {
            int i3 = this.mLaneItemViewSize;
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(i3, i3);
            layoutParams2.gravity = 16;
            layoutParams = layoutParams2;
            imageView = new ImageView(getContext());
            z = true;
        } else {
            layoutParams = (LinearLayout.LayoutParams) imageView.getLayoutParams();
            int i4 = this.mLaneItemViewSize;
            layoutParams.height = i4;
            layoutParams.width = i4;
            imageView.setVisibility(0);
        }
        if (z) {
            addView(imageView, layoutParams);
        } else {
            imageView.setLayoutParams(layoutParams);
        }
        imageView.setImageResource(i2);
        imageView.setTag(Integer.valueOf(i2));
        imageView.setContentDescription("LaneInfo" + i);
    }

    public void updateTollGateData(List<Integer> list) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("updateTollGateData laneInfo: ");
            sb.append(list == null ? " null" : Integer.valueOf(list.size()));
            L.d(tag, sb.toString());
        }
        if (CollectionUtils.isEmpty(list)) {
            this.mLaneNum = 0;
            setVisibility(8);
            return;
        }
        this.mLaneNum = list.size();
        if (list.size() > this.mMaxHideCount) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        if (this.mIsResize) {
            updateLaneParams(list.size());
        }
        drawTollGate(list);
    }

    public boolean hasLaneInfoToShow() {
        int i = this.mLaneNum;
        return i != 0 && i <= this.mMaxHideCount;
    }

    public void hideLaneInfoView() {
        this.mLaneNum = 0;
        setVisibility(8);
    }

    private void drawTollGate(List<Integer> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            int tollGateResource = ResUtil.getTollGateResource(list.get(i).intValue());
            if (tollGateResource == 0) {
                L.w(TAG, ">>> invalid toll gate");
            } else {
                addLaneView(i, tollGateResource);
            }
        }
        while (size < getChildCount()) {
            getChildAt(size).setVisibility(8);
            size++;
        }
    }

    public void setLeftOrRightLayout(View view, View view2, boolean z) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "left layout visible changed mLaneNum: " + this.mLaneNum + ", isLeftVisible: " + z);
        }
        setLeftOrRightLayout(view, view2, this.mLaneNum, z);
    }

    public void setLeftOrRightLayout(View view, View view2, int i, boolean z) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "setLeftOrRightLayout lanes: " + i + ", isLeftVisible: " + z);
        }
        RelativeLayout relativeLayout = (RelativeLayout) getParent();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) relativeLayout.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) view.getLayoutParams();
        layoutParams2.removeRule(3);
        layoutParams.removeRule(1);
        layoutParams.addRule(3, view2.getId());
        if ((i <= 7 && z) || i > this.mMaxHideCount) {
            layoutParams2.addRule(3, view2.getId());
            layoutParams.addRule(1, view.getId());
            return;
        }
        layoutParams2.addRule(3, relativeLayout.getId());
    }

    private void updateLaneParams(int i) {
        if (i <= 0) {
            return;
        }
        int dimensionPixelSize = ContextUtils.getDimensionPixelSize(R.dimen.guide_lane_min_margin);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
        int intrinsicWidth = (this.mLaneItemViewNormalSize * i) + ((i - 1) * getDividerDrawable().getIntrinsicWidth()) + getPaddingLeft() + getPaddingRight();
        int i2 = this.mRight - this.mLeft;
        if (intrinsicWidth > i2) {
            setVisibility(8);
        } else {
            setVisibility(0);
        }
        if (this.mShowMiddle) {
            layoutParams.removeRule(14);
            layoutParams.leftMargin = ((i2 - intrinsicWidth) / 2) + this.mLeft;
        } else {
            int i3 = (this.mMaxWidth - intrinsicWidth) / 2;
            if (i3 > this.mLeft && i3 + intrinsicWidth < this.mRight) {
                layoutParams.addRule(14);
                layoutParams.leftMargin = 0;
            } else {
                layoutParams.removeRule(14);
                layoutParams.leftMargin = dimensionPixelSize + this.mLeft;
            }
        }
        layoutParams.topMargin = this.mTop;
        setLayoutParams(layoutParams);
        L.Tag tag = TAG;
        L.i(tag, "updateLaneParams count: " + i + ", availableArea: " + i2 + ", requireWidth: " + intrinsicWidth + ",mMaxWidth: " + this.mMaxWidth + ", mLeft: " + this.mLeft + ", mRight: " + this.mRight);
    }

    public void setIsResize(boolean z) {
        this.mIsResize = z;
    }

    public void setAvailableArea(int i, int i2, int i3) {
        if (this.mLeft == i && this.mRight == i2 && this.mTop == i3) {
            return;
        }
        this.mLeft = i;
        this.mRight = i2;
        this.mTop = i3;
        updateLaneParams(this.mLaneNum);
    }

    public void setParentWidth(int i) {
        this.mMaxWidth = i;
    }
}
