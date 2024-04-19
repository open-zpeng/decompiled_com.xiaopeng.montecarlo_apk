package com.xiaopeng.montecarlo.views;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.root.carservice.CarServiceManager;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.TraceUtils;
import com.xiaopeng.montecarlo.util.NaviUtil;
import com.xiaopeng.montecarlo.util.ThemeWatcherUtil;
import com.xiaopeng.xui.widget.XRelativeLayout;
/* loaded from: classes3.dex */
public class BatteryView extends XRelativeLayout {
    public static final int BETTERY_NORMAL = 0;
    public static final int BETTERY_REDWARNING = 2;
    public static final int BETTERY_WARNING = 1;
    private static final L.Tag TAG = new L.Tag("BatteryView");
    private float mBatteryHeight;
    private int mBatteryNormalBackground;
    private int mBatteryNormalProgressDrawable;
    private int mBatteryProgress;
    private float mBatteryProgressMarginBottom;
    private float mBatteryProgressMarginLeft;
    private float mBatteryProgressMarginRight;
    private float mBatteryProgressMarginTop;
    private int mBatteryRedWarningBackground;
    private int mBatterySecondaryProgress;
    private int mBatteryState;
    private int mBatteryWarningBackground;
    private float mBatteryWidth;
    private Context mContext;
    private boolean mIsSelected;
    private ProgressBar mProgressBar;
    private RelativeLayout mRootView;

    public BatteryView(Context context) {
        this(context, null);
    }

    public BatteryView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BatteryView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TraceUtils.alwaysTraceBegin("BatteryView_create");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.BatteryView, i, 0);
        if (obtainStyledAttributes != null) {
            try {
                try {
                    this.mBatteryWidth = obtainStyledAttributes.getDimension(12, 0.0f);
                    this.mBatteryHeight = obtainStyledAttributes.getDimension(0, 0.0f);
                    this.mBatteryNormalBackground = obtainStyledAttributes.getResourceId(1, 0);
                    this.mBatteryNormalProgressDrawable = obtainStyledAttributes.getResourceId(2, R.drawable.layer_battery_progress_normal);
                    this.mBatteryWarningBackground = obtainStyledAttributes.getResourceId(11, 0);
                    this.mBatteryRedWarningBackground = obtainStyledAttributes.getResourceId(8, 0);
                    this.mBatteryProgressMarginLeft = obtainStyledAttributes.getDimension(5, 0.0f);
                    this.mBatteryProgressMarginTop = obtainStyledAttributes.getDimension(7, 0.0f);
                    this.mBatteryProgressMarginBottom = obtainStyledAttributes.getDimension(4, 0.0f);
                    this.mBatteryProgressMarginRight = obtainStyledAttributes.getDimension(6, 0.0f);
                    this.mBatteryState = obtainStyledAttributes.getInteger(10, 0);
                    this.mBatteryProgress = obtainStyledAttributes.getInteger(3, 0);
                    this.mBatterySecondaryProgress = obtainStyledAttributes.getInteger(9, 0);
                } finally {
                    obtainStyledAttributes.recycle();
                }
            } catch (Resources.NotFoundException | UnsupportedOperationException e) {
                e.printStackTrace();
            }
        }
        initBatteryView(context);
        TraceUtils.alwaysTraceEnd();
    }

    public ProgressBar getProgressBar() {
        return this.mProgressBar;
    }

    @Override // android.view.View
    public RelativeLayout getRootView() {
        return this.mRootView;
    }

    public void updateBattery(int i, int i2, int i3) {
        this.mBatteryState = i;
        this.mBatteryProgress = i2;
        this.mBatterySecondaryProgress = i3;
        updateProgressBar();
    }

    private void updateProgressBar() {
        int i = this.mBatteryState;
        if (i == 0) {
            if (this.mIsSelected) {
                this.mProgressBar.setProgressDrawable(ThemeWatcherUtil.getDrawable(R.drawable.layer_battery_progress_selected));
            } else {
                this.mProgressBar.setProgressDrawable(ThemeWatcherUtil.getDrawable(this.mBatteryNormalProgressDrawable));
            }
            this.mRootView.setBackground(ThemeWatcherUtil.getDrawable(this.mBatteryNormalBackground));
        } else if (1 == i) {
            this.mProgressBar.setProgressDrawable(ThemeWatcherUtil.getDrawable(R.drawable.layer_battery_progress_shortage));
            this.mRootView.setBackground(ThemeWatcherUtil.getDrawable(this.mBatteryWarningBackground));
        } else if (2 == i) {
            this.mProgressBar.setProgressDrawable(ThemeWatcherUtil.getDrawable(R.drawable.layer_battery_progress_little));
            this.mRootView.setBackground(ThemeWatcherUtil.getDrawable(this.mBatteryRedWarningBackground));
        }
        this.mProgressBar.setProgress(this.mBatteryProgress);
        this.mProgressBar.setSecondaryProgress(this.mBatterySecondaryProgress);
    }

    public void updateBatteryStatus(int i, int i2, int i3) {
        int i4;
        int checkBatteryStatus = NaviUtil.checkBatteryStatus(i, i2);
        if (checkBatteryStatus == -1) {
            setVisibility(8);
            return;
        }
        int i5 = 0;
        setVisibility(0);
        int maxMileAge = CarServiceManager.getInstance().getMaxMileAge();
        if (L.ENABLE) {
            L.d(TAG, ">>> updateBatteryStatus totalDis = " + maxMileAge);
        }
        if (maxMileAge != 0) {
            i5 = (i * 100) / maxMileAge;
            i4 = (i2 * 100) / maxMileAge;
        } else {
            i4 = 0;
        }
        if (L.ENABLE) {
            L.d(TAG, ">>> updateBatteryStatus carRemainProgress = " + i5 + " leftRemainProgress=" + i4);
        }
        updateBattery(checkBatteryStatus, i4, i5);
    }

    private void initBatteryView(Context context) {
        TraceUtils.alwaysTraceBegin("BatteryView_init");
        this.mContext = context;
        this.mRootView = (RelativeLayout) LayoutInflater.from(this.mContext).inflate(R.layout.layout_battery, (ViewGroup) this, true);
        this.mProgressBar = (ProgressBar) this.mRootView.findViewById(R.id.battery_progress);
        updateBattery(this.mBatteryState, this.mBatteryProgress, this.mBatterySecondaryProgress);
        formatRootView();
        formatProgressBar();
        TraceUtils.alwaysTraceEnd();
    }

    private void formatProgressBar() {
        ViewGroup.LayoutParams layoutParams;
        if (this.mProgressBar.getLayoutParams() != null) {
            layoutParams = this.mProgressBar.getLayoutParams();
        } else {
            layoutParams = new ViewGroup.LayoutParams(-1, -2);
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        if (marginLayoutParams.leftMargin == this.mBatteryProgressMarginLeft && marginLayoutParams.topMargin == this.mBatteryProgressMarginTop && marginLayoutParams.rightMargin == this.mBatteryProgressMarginRight && marginLayoutParams.bottomMargin == this.mBatteryProgressMarginBottom) {
            return;
        }
        marginLayoutParams.leftMargin = (int) this.mBatteryProgressMarginLeft;
        marginLayoutParams.topMargin = (int) this.mBatteryProgressMarginTop;
        marginLayoutParams.rightMargin = (int) this.mBatteryProgressMarginRight;
        marginLayoutParams.bottomMargin = (int) this.mBatteryProgressMarginBottom;
        this.mProgressBar.setLayoutParams(layoutParams);
    }

    private void formatRootView() {
        ViewGroup.LayoutParams layoutParams;
        if (this.mRootView.getLayoutParams() != null) {
            layoutParams = this.mRootView.getLayoutParams();
        } else {
            layoutParams = new ViewGroup.LayoutParams(-2, -2);
        }
        if (layoutParams.width == this.mBatteryWidth && layoutParams.height == this.mBatteryHeight) {
            return;
        }
        layoutParams.width = (int) this.mBatteryWidth;
        layoutParams.height = (int) this.mBatteryHeight;
        this.mRootView.setLayoutParams(layoutParams);
    }

    @Override // com.xiaopeng.xui.widget.XRelativeLayout, android.view.View
    public void setSelected(boolean z) {
        super.setSelected(z);
        this.mIsSelected = z;
        if (this.mBatteryState == 0) {
            if (this.mIsSelected) {
                this.mProgressBar.setProgressDrawable(ThemeWatcherUtil.getDrawable(R.drawable.layer_battery_progress_selected));
            } else {
                this.mProgressBar.setProgressDrawable(ThemeWatcherUtil.getDrawable(this.mBatteryNormalProgressDrawable));
            }
        }
    }
}
