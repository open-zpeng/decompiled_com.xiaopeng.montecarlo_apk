package com.xiaopeng.montecarlo.views;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.xiaopeng.libtheme.ThemeManager;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.navcore.bean.direction.XPViaPoint;
import com.xiaopeng.montecarlo.navcore.util.MarkUtils;
import com.xiaopeng.montecarlo.navcore.xptbt.TBTManager;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.ILightBarInfo;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.bitmapfactory.BitmapFactoryResult;
import com.xiaopeng.montecarlo.root.util.bitmapfactory.BitmapFactoryXP;
import com.xiaopeng.montecarlo.root.util.bitmapfactory.DecodeResourceParam;
import com.xiaopeng.montecarlo.util.ThemeWatcherUtil;
import com.xiaopeng.xui.view.XView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class TrafficBar extends XView {
    private static final int OFFSET = 5;
    private static final int VIA_POINT_MAX_NUMS = 12;
    private int mBasicColor;
    private Bitmap mCarIcon;
    private int mCarId;
    private boolean mDrawTrafficBlock;
    private boolean mDrawVertical;
    private Bitmap mEndIcon;
    private int mEndId;
    private boolean mIsDay;
    private int mLabelColor;
    private Paint mLabelPaint;
    private double mLeftDistance;
    private ILightBarInfo mLightBarInfo;
    private Bitmap mLineBitmap;
    private Canvas mLineCanvas;
    private int mMarginBottom;
    private int mMarginEnd;
    private int mMarginStart;
    private int mMarginTop;
    private OnCarMoveListener mOnCarMoveListener;
    private int mOverlapSize;
    private int mPadding;
    private Paint mPaint;
    private int mPassedColor;
    private int mPassedIndex;
    private Rect mRect;
    private RectF mRectF;
    private Paint mRoundBitmapPaint;
    private PorterDuffXfermode mRoundBitmapXFremode;
    private int mRoundPx;
    private int mRoundPy;
    private double mTotalDistance;
    private int mTotalProcess;
    private int mTrafficBarHeight;
    private int mTrafficBarWidth;
    private int mViaIconAngleWidth;
    private int mViaIconPadding;
    private Bitmap mViaPassedIcon;
    private int mViaPassedId;
    private List<ViaPassIconBean> mViaPassedList;
    private Bitmap mViaPassingIcon;
    private int mViaPassingId;
    private List<ViaPassIconBean> mViaPassingList;
    private static final L.Tag TAG = new L.Tag("TrafficBar");
    private static short STATUS_FLAG_OLD = 0;
    private static short STATUS_FLAG_NEW = 1;
    private static short STATUS_FLAG_DARK_GREEN = 3;
    private static int OPEN_LOWER_BOUND = 100;
    private static int RAPIDER_LOWER_BOUND = 110;
    private static int RAPIDER_UPPER_BOUND = 140;
    private static int OPEN_UPPER_BOUND = 200;
    private static int SLOW_LOWER_BOUND = 200;
    private static int SLOW_UPPER_BOUND = 300;
    private static int JAM_LOWER_BOUND = 300;
    private static int CONGESTED_LOWER_BOUND = MarkUtils.MARKER_ID_BUBBLE_VIA_CHARGE;
    private static int CONGESTED_UPPER_BOUND = 390;
    private static int JAM_UPPER_BOUND = 400;
    private static int NO_STREAM_LOWER_BOUND = 900;
    private static int NO_STREAM_UPPER_BOUND = 999;

    /* loaded from: classes3.dex */
    public interface OnCarMoveListener {
        void onCarMove(float f);
    }

    /* loaded from: classes3.dex */
    public enum TrafficFineStatus {
        TRAFFIC_STATUS_UNKNOWN,
        TRAFFIC_STATUS_RAPIDER,
        TRAFFIC_STATUS_OPEN,
        TRAFFIC_STATUS_SLOW,
        TRAFFIC_STATUS_JAM,
        TRAFFIC_STATUS_CONGESTED,
        TRAFFIC_STATUS_NO_STREAM
    }

    public TrafficBar(Context context) {
        super(context);
        this.mTotalDistance = 0.0d;
        this.mLeftDistance = 0.0d;
        this.mPassedColor = 0;
        this.mBasicColor = 0;
        this.mLabelColor = 0;
        this.mTrafficBarWidth = 860;
        this.mTrafficBarHeight = 10;
        this.mPassedIndex = 0;
        this.mDrawTrafficBlock = false;
        this.mLineBitmap = null;
        this.mLineCanvas = null;
        init();
    }

    public TrafficBar(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mTotalDistance = 0.0d;
        this.mLeftDistance = 0.0d;
        this.mPassedColor = 0;
        this.mBasicColor = 0;
        this.mLabelColor = 0;
        this.mTrafficBarWidth = 860;
        this.mTrafficBarHeight = 10;
        this.mPassedIndex = 0;
        this.mDrawTrafficBlock = false;
        this.mLineBitmap = null;
        this.mLineCanvas = null;
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.TrafficBar, 0, 0);
        if (obtainStyledAttributes != null) {
            try {
                try {
                    this.mPassedColor = obtainStyledAttributes.getInteger(8, 0);
                    this.mBasicColor = obtainStyledAttributes.getInteger(0, 0);
                    this.mLabelColor = obtainStyledAttributes.getInteger(3, R.color.traffic_label_text_color);
                    this.mTrafficBarWidth = (int) obtainStyledAttributes.getDimension(12, context.getResources().getDimension(R.dimen.navi_traffic_width));
                    this.mTrafficBarHeight = (int) obtainStyledAttributes.getDimension(11, context.getResources().getDimension(R.dimen.navi_traffic_height));
                    this.mMarginTop = (int) obtainStyledAttributes.getDimension(7, 0.0f);
                    this.mMarginBottom = (int) obtainStyledAttributes.getDimension(4, 0.0f);
                    this.mMarginStart = (int) obtainStyledAttributes.getDimension(6, 0.0f);
                    this.mMarginEnd = (int) obtainStyledAttributes.getDimension(5, 0.0f);
                    this.mDrawVertical = this.mTrafficBarHeight > this.mTrafficBarWidth;
                    this.mCarId = obtainStyledAttributes.getResourceId(1, R.drawable.png_ic_carlocation_navigationstate01);
                    this.mEndId = obtainStyledAttributes.getResourceId(2, R.drawable.vector_ic_small_action_destination);
                    this.mViaPassingId = obtainStyledAttributes.getResourceId(10, R.drawable.png_poi_small_nav_passing_point);
                    this.mViaPassedId = obtainStyledAttributes.getResourceId(9, R.drawable.png_poi_small_nav_passed_point);
                    this.mPadding = (int) getResources().getDimension(R.dimen.navi_traffic_bar_margin);
                    this.mOverlapSize = (int) getResources().getDimension(R.dimen.navi_traffic_bar_overlap_margin);
                } finally {
                    obtainStyledAttributes.recycle();
                }
            } catch (Resources.NotFoundException | UnsupportedOperationException e) {
                e.printStackTrace();
            }
        }
        this.mRoundPx = (this.mDrawVertical ? this.mTrafficBarWidth : this.mTrafficBarHeight) / 2;
        this.mRoundPy = (this.mDrawVertical ? this.mTrafficBarWidth : this.mTrafficBarHeight) / 2;
        this.mViaIconPadding = getResources().getDimensionPixelSize(R.dimen.guide_traffic_bar_via_padding);
        this.mViaIconAngleWidth = getResources().getDimensionPixelSize(R.dimen.guide_traffic_bar_via_angle_width);
        init();
        updateCurrentTheme();
    }

    private void init() {
        this.mPaint = new Paint();
        this.mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.mPaint.setAntiAlias(true);
        this.mLabelPaint = new Paint(1);
        this.mLabelPaint.setTextSize(getResources().getDimension(R.dimen.font_size_18));
        this.mRoundBitmapPaint = new Paint();
        this.mRoundBitmapPaint.setAntiAlias(true);
        this.mRoundBitmapXFremode = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);
        this.mRect = new Rect();
        this.mRectF = new RectF();
        this.mViaPassedList = new ArrayList();
        this.mViaPassingList = new ArrayList();
    }

    public Bitmap getCarIcon() {
        return this.mCarIcon;
    }

    public Bitmap getEndIcon() {
        return this.mEndIcon;
    }

    public Bitmap getLineBitmap() {
        return this.mLineBitmap;
    }

    public Bitmap getViaPassingIcon() {
        return this.mViaPassingIcon;
    }

    public Bitmap getViaPassedIcon() {
        return this.mViaPassedIcon;
    }

    public void setCarMoveListener(OnCarMoveListener onCarMoveListener) {
        this.mOnCarMoveListener = onCarMoveListener;
    }

    public void removeCarMoveListener() {
        this.mOnCarMoveListener = null;
    }

    public void setLeftDistance(double d) {
        setLeftDistance(d, true);
    }

    public void setLeftDistance(double d, boolean z) {
        this.mLeftDistance = d;
        if (z) {
            invalidate();
        }
    }

    public void setLightBarInfo(@NonNull ILightBarInfo iLightBarInfo, int i, boolean z) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("setLightBarInfo : lightBarInfo - > [  item list :");
            sb.append(iLightBarInfo.getLightBarItemSize());
            sb.append(" , path ID: ");
            sb.append(iLightBarInfo.getPathId());
            sb.append(" ] , old path ID :");
            ILightBarInfo iLightBarInfo2 = this.mLightBarInfo;
            sb.append(iLightBarInfo2 == null ? " null " : Long.valueOf(iLightBarInfo2.getPathId()));
            sb.append(", old passed Index : ");
            sb.append(this.mPassedIndex);
            sb.append(" , passed Index : ");
            sb.append(i);
            sb.append(" , mDrawTrafficBlock : ");
            sb.append(this.mDrawTrafficBlock);
            sb.append(" isChanged : ");
            sb.append(z);
            L.d(tag, sb.toString());
        }
        ILightBarInfo iLightBarInfo3 = this.mLightBarInfo;
        boolean z2 = true;
        if (iLightBarInfo3 == null || iLightBarInfo3.getPathId() != iLightBarInfo.getPathId()) {
            z = true;
        }
        if (z) {
            this.mLightBarInfo = iLightBarInfo;
            this.mPassedIndex = i;
            if (!z && !this.mDrawTrafficBlock) {
                z2 = false;
            }
            this.mDrawTrafficBlock = z2;
            invalidate();
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        boolean z;
        int i;
        int i2;
        int i3;
        Canvas canvas2;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        this.mPaint.setColor(this.mBasicColor);
        int i10 = (this.mTrafficBarWidth - this.mMarginStart) - this.mMarginEnd;
        int i11 = (this.mTrafficBarHeight - this.mMarginTop) - this.mMarginBottom;
        this.mTotalProcess = this.mDrawVertical ? i11 : i10;
        int i12 = this.mMarginStart;
        int i13 = i12 + i10;
        int i14 = this.mMarginTop;
        int i15 = i11 + i14;
        this.mRect.set(i12, i14, i13, i15);
        if (this.mLineBitmap == null) {
            this.mLineBitmap = Bitmap.createBitmap(this.mRect.width(), this.mRect.height(), Bitmap.Config.ARGB_8888);
            this.mLineCanvas = new Canvas(this.mLineBitmap);
        }
        if (this.mDrawTrafficBlock) {
            this.mLineCanvas.drawRect(this.mRect, this.mPaint);
            z = true;
        } else {
            canvas.drawBitmap(this.mLineBitmap, this.mRect.left, this.mRect.top, (Paint) null);
            z = false;
        }
        double d = this.mTotalDistance;
        if (d != 0.0d) {
            double d2 = this.mLeftDistance;
            if (d2 != 0.0d && d2 <= d) {
                ILightBarInfo iLightBarInfo = this.mLightBarInfo;
                if (iLightBarInfo == null || !this.mDrawTrafficBlock) {
                    i = i15;
                    i2 = i10;
                    i3 = i11;
                } else {
                    this.mDrawTrafficBlock = false;
                    int lightBarItemSize = iLightBarInfo.getLightBarItemSize();
                    long j = (long) (this.mTotalDistance - this.mLeftDistance);
                    int i16 = 0;
                    int i17 = 0;
                    while (i16 < lightBarItemSize) {
                        int i18 = i17 + 1;
                        if (i17 < this.mPassedIndex) {
                            i8 = i15;
                            i6 = lightBarItemSize;
                            i4 = i10;
                            i5 = i11;
                            i7 = i18;
                        } else {
                            long lightBarItemLength = this.mLightBarInfo.getLightBarItemLength(i16) + j;
                            int i19 = this.mTotalProcess;
                            i4 = i10;
                            i5 = i11;
                            i6 = lightBarItemSize;
                            long j2 = j;
                            double d3 = ((float) j) * 1.0f;
                            int i20 = i15;
                            double d4 = this.mTotalDistance;
                            int i21 = ((int) (i19 * (d3 / d4))) + i12;
                            i7 = i18;
                            double d5 = ((float) lightBarItemLength) * 1.0f;
                            int i22 = ((int) (i19 * (d5 / d4))) + i12;
                            if (this.mDrawVertical) {
                                i9 = (i19 - ((int) (i19 * (d3 / d4)))) + i14;
                                i22 = (i19 - ((int) (i19 * (d5 / d4)))) + i14;
                                this.mRect.set(i12, i22, i13, i9);
                                i8 = i20;
                            } else {
                                i8 = i20;
                                this.mRect.set(i21, i14, i22, i8);
                                i9 = i21;
                            }
                            int color = ContextUtils.getColor(R.color.traffic_none_info);
                            if (this.mLightBarInfo.getStatusFlag(i16) == STATUS_FLAG_OLD) {
                                color = getTrafficColorByStatus(this.mLightBarInfo.getLightBarItemStatus(i16));
                            } else if (this.mLightBarInfo.getStatusFlag(i16) == STATUS_FLAG_NEW || this.mLightBarInfo.getStatusFlag(i16) == STATUS_FLAG_DARK_GREEN) {
                                color = getTrafficColorByFineStatus(this.mLightBarInfo.getLightBarItemFineStatus(i16));
                            }
                            this.mPaint.setColor(color);
                            this.mLineCanvas.drawRect(this.mRect, this.mPaint);
                            if (L.ENABLE) {
                                L.Tag tag = TAG;
                                StringBuilder sb = new StringBuilder();
                                sb.append("onDraw draw light bar item : ");
                                sb.append(i7 - 1);
                                sb.append(" ,  [ startDistance -> ");
                                sb.append(j2);
                                sb.append(" endDistance -> ");
                                sb.append(lightBarItemLength);
                                sb.append(" mLeftDistance - > ");
                                sb.append(this.mLeftDistance);
                                sb.append(" mTotalDistance -> ");
                                sb.append(this.mTotalDistance);
                                sb.append(" ], [ trafficStart -> ");
                                sb.append(i9);
                                sb.append(" trafficEnd -> ");
                                sb.append(i22);
                                sb.append(" traffic color -> ");
                                sb.append(Integer.toHexString(color));
                                sb.append(" ] ");
                                L.d(tag, sb.toString());
                            }
                            j = lightBarItemLength;
                        }
                        i16++;
                        i15 = i8;
                        i10 = i4;
                        i11 = i5;
                        lightBarItemSize = i6;
                        i17 = i7;
                    }
                    i = i15;
                    i2 = i10;
                    i3 = i11;
                    z = true;
                }
                if (L.ENABLE) {
                    L.d(TAG, "onDraw isDrawRefresh : " + z);
                }
                if (z) {
                    Bitmap roundBitmap = getRoundBitmap(this.mLineBitmap, this.mRoundPx, this.mRoundPy);
                    this.mRect.set(i12, i14, i13, i);
                    canvas2 = canvas;
                    canvas2.drawBitmap(roundBitmap, this.mRect.left, this.mRect.top, (Paint) null);
                    if (this.mLineCanvas != null) {
                        this.mLineCanvas = null;
                    }
                    this.mLineCanvas = new Canvas(roundBitmap);
                    Bitmap bitmap = this.mLineBitmap;
                    if (bitmap != null && !bitmap.isRecycled()) {
                        this.mLineBitmap.recycle();
                    }
                    this.mLineBitmap = roundBitmap;
                } else {
                    canvas2 = canvas;
                }
                double d6 = this.mTotalDistance;
                int i23 = ((int) (((d6 - this.mLeftDistance) / d6) * this.mTotalProcess)) + i12;
                this.mPaint.setColor(this.mPassedColor);
                boolean z2 = i23 < i13 - i3;
                if (this.mDrawVertical) {
                    i23 = ((int) ((this.mLeftDistance / this.mTotalDistance) * this.mTotalProcess)) + i14;
                    this.mRect.set(i12, i23, i13, i);
                    z2 = i23 > this.mTotalProcess;
                } else {
                    this.mRect.set(i12, i14, i23, i);
                }
                int i24 = i23;
                if (L.ENABLE) {
                    L.d(TAG, "onDraw draw past route passedEnd : " + i24);
                }
                if (z2) {
                    drawLeftRound(canvas2, this.mPaint, this.mRect);
                } else {
                    drawBasicRound(canvas2, this.mPaint, this.mRect);
                }
                this.mPaint.setColor(-1);
                int i25 = i3;
                drawViaPassIcon(canvas, this.mPaint, i25, i12, i14, i24);
                int i26 = i2;
                drawEndIcon(canvas, this.mPaint, i25, i26, i13);
                drawCarIcon(canvas, this.mPaint, i24, i26, i3, i14);
                super.onDraw(canvas);
                return;
            }
        }
        if (L.ENABLE) {
            L.d(TAG, "onDraw total:" + this.mTotalDistance + "  left:" + this.mLeftDistance);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.xui.view.XView, android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (ThemeManager.isThemeChanged(configuration) && getVisibility() == 0) {
            this.mDrawTrafficBlock = true;
        }
    }

    private void drawBasicRound(Canvas canvas, Paint paint, Rect rect) {
        this.mRectF.set(rect);
        canvas.drawRoundRect(this.mRectF, this.mRoundPx, this.mRoundPy, paint);
    }

    private void drawLeftRound(Canvas canvas, Paint paint, Rect rect) {
        this.mRectF.set(rect);
        canvas.drawRoundRect(this.mRectF, this.mRoundPx, this.mRoundPy, paint);
        this.mRectF.set(rect.width() - this.mRoundPx, 0.0f, rect.width(), this.mRoundPy);
        canvas.drawRect(this.mRectF, paint);
        this.mRectF.set(rect.width() - this.mRoundPx, rect.height() - this.mRoundPy, rect.width(), rect.height());
        canvas.drawRect(this.mRectF, paint);
    }

    private void drawCarIcon(Canvas canvas, Paint paint, int i, int i2, int i3, int i4) {
        Bitmap bitmap;
        float f;
        float height;
        if (this.mCarIcon != null) {
            if (this.mDrawVertical) {
                height = i - (bitmap.getHeight() / 2.0f);
                float f2 = i4;
                if (height < f2) {
                    height = f2;
                }
                f = (i2 - this.mCarIcon.getWidth()) / 2.0f;
            } else {
                float width = i - (bitmap.getWidth() / 2.0f);
                if (width > i2 - this.mCarIcon.getWidth()) {
                    width = i2 - this.mCarIcon.getWidth();
                }
                f = width;
                height = (i3 - this.mCarIcon.getHeight()) / 2.0f;
            }
            canvas.drawBitmap(this.mCarIcon, f, height, paint);
            OnCarMoveListener onCarMoveListener = this.mOnCarMoveListener;
            if (onCarMoveListener != null) {
                onCarMoveListener.onCarMove(height + (this.mCarIcon.getHeight() / 2.0f));
            }
        }
    }

    private void drawViaPassIcon(Canvas canvas, Paint paint, int i, int i2, int i3, int i4) {
        Bitmap bitmap;
        float f;
        float f2;
        boolean z;
        List<XPViaPoint> viaInfos = TBTManager.getInstance().getViaInfos(TBTManager.getInstance().getCurrentNaviId());
        if (CollectionUtils.isNotEmpty(viaInfos)) {
            this.mViaPassedList.clear();
            this.mViaPassingList.clear();
            int lastPassedIndexDiff = TBTManager.getInstance().getLastPassedIndexDiff();
            if (L.ENABLE) {
                L.d(TAG, ">>> drawViaPassIcon lastPassedIndex=" + lastPassedIndexDiff + " xpViaPoints.size()=" + viaInfos.size());
            }
            float f3 = 0.0f;
            while (lastPassedIndexDiff < viaInfos.size()) {
                XPViaPoint xPViaPoint = viaInfos.get(lastPassedIndexDiff);
                if (L.ENABLE) {
                    L.d(TAG, ">>> drawViaPassIcon i=" + lastPassedIndexDiff + " xpViaPoint.getIsPassedVia()=" + xPViaPoint.getIsPassedVia());
                }
                if (xPViaPoint.getIsPassedVia()) {
                    bitmap = this.mViaPassedIcon;
                } else {
                    bitmap = this.mViaPassingIcon;
                }
                if (bitmap != null) {
                    boolean z2 = false;
                    if (this.mDrawVertical) {
                        float max = Math.max(0.0f, (i3 + this.mTotalProcess) - ((float) ((xPViaPoint.getDistance() / this.mTotalDistance) * this.mTotalProcess))) - (bitmap.getHeight() / 2.0f);
                        float f4 = -bitmap.getWidth();
                        if (!xPViaPoint.getIsPassedVia() || max >= i4 - (bitmap.getHeight() / 2)) {
                            f = max;
                            f2 = f4;
                            z = true;
                        } else {
                            f = max;
                            f2 = f4;
                            z = false;
                        }
                    } else {
                        float distance = ((float) (((xPViaPoint.getDistance() / this.mTotalDistance) * this.mTotalProcess) - (bitmap.getWidth() / 2.0f))) + i2;
                        float height = (i - bitmap.getHeight()) - 1;
                        if (!xPViaPoint.getIsPassedVia() || distance <= i4 + (bitmap.getWidth() / 2)) {
                            f = height;
                            f2 = distance;
                            z = true;
                        } else {
                            f = height;
                            f2 = distance;
                            z = false;
                        }
                    }
                    if (L.ENABLE) {
                        L.d(TAG, ">>> drawViaPassIcon isNeedDraw=" + z + " left=" + f2 + " top=" + f + " lasttop=" + f3);
                    }
                    if (z) {
                        if (f3 != 0.0f) {
                            float f5 = f3 - f;
                            if (Math.abs(f5) < bitmap.getHeight() || f5 < 0.0f) {
                                f = f3 - this.mOverlapSize;
                                z2 = true;
                            }
                        }
                        f3 = (!z2 || f >= 0.0f) ? f : f3 - 5.0f;
                        if (xPViaPoint.getIsPassedVia()) {
                            this.mViaPassedList.add(new ViaPassIconBean(bitmap, f2, f3, lastPassedIndexDiff));
                        } else {
                            this.mViaPassingList.add(new ViaPassIconBean(bitmap, f2, f3, lastPassedIndexDiff));
                        }
                    }
                } else if (L.ENABLE) {
                    L.d(TAG, ">>> drawViaPassIcon bitmap is null");
                }
                lastPassedIndexDiff++;
            }
            drawViaPassIcon(canvas, paint, this.mViaPassedList, this.mViaPassingList);
        } else if (L.ENABLE) {
            L.d(TAG, ">>> drawViaPassIcon vias is empty");
        }
    }

    private void drawViaPassIcon(Canvas canvas, Paint paint, List<ViaPassIconBean> list, List<ViaPassIconBean> list2) {
        if (!CollectionUtils.isEmpty(list)) {
            for (ViaPassIconBean viaPassIconBean : list) {
                if (viaPassIconBean != null) {
                    if (L.ENABLE) {
                        L.d(TAG, ">>> draw via passed icon : " + viaPassIconBean.label);
                    }
                    canvas.drawBitmap(viaPassIconBean.bitmap, viaPassIconBean.left, viaPassIconBean.top, paint);
                    drawViaPassLabel(canvas, viaPassIconBean.bitmap, viaPassIconBean.label, viaPassIconBean.left, viaPassIconBean.top);
                }
            }
        }
        if (CollectionUtils.isEmpty(list2)) {
            return;
        }
        for (int size = list2.size() - 1; size >= 0; size--) {
            ViaPassIconBean viaPassIconBean2 = list2.get(size);
            if (viaPassIconBean2 != null) {
                if (L.ENABLE) {
                    L.d(TAG, ">>> draw via passing icon : " + viaPassIconBean2.label);
                }
                canvas.drawBitmap(viaPassIconBean2.bitmap, viaPassIconBean2.left, viaPassIconBean2.top, paint);
                drawViaPassLabel(canvas, viaPassIconBean2.bitmap, viaPassIconBean2.label, viaPassIconBean2.left, viaPassIconBean2.top);
            }
        }
    }

    private void drawViaPassLabel(Canvas canvas, Bitmap bitmap, int i, float f, float f2) {
        if (canvas == null || bitmap == null || i < 0 || i > 11) {
            return;
        }
        String valueOf = String.valueOf(i + 1);
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, ">>> draw via pass label : " + i);
        }
        this.mLabelPaint.setColor(getContext().getColor(this.mLabelColor));
        float measureText = this.mLabelPaint.measureText(valueOf);
        this.mRect.setEmpty();
        this.mLabelPaint.getTextBounds(valueOf, 0, valueOf.length(), this.mRect);
        canvas.drawText(valueOf, f + this.mViaIconPadding + ((((bitmap.getWidth() - (this.mViaIconPadding * 2)) - this.mViaIconAngleWidth) - measureText) / 2.0f), f2 + (bitmap.getHeight() / 2.0f) + (this.mRect.height() / 2.0f), this.mLabelPaint);
    }

    private void drawEndIcon(Canvas canvas, Paint paint, int i, int i2, int i3) {
        Bitmap bitmap = this.mEndIcon;
        if (bitmap != null) {
            canvas.drawBitmap(this.mEndIcon, this.mDrawVertical ? (i3 - bitmap.getHeight()) / 2.0f : i3 - bitmap.getWidth(), this.mDrawVertical ? (i2 - this.mEndIcon.getWidth()) + 3 : (i - this.mEndIcon.getHeight()) / 2.0f, paint);
        }
    }

    public void updateTrafficBarVariantPath(double d, boolean z, boolean z2) {
        this.mTotalDistance = d;
        this.mDrawTrafficBlock = !z;
        if (!z) {
            this.mLightBarInfo = null;
        }
        L.Tag tag = TAG;
        L.i(tag, "updateTrafficBarVariantPath : mTotalDistance - > " + this.mTotalDistance + "   isSceneLegal:" + z2);
        if (z2) {
            invalidate();
        }
    }

    public void updateTrafficBarVariantPath(double d) {
        this.mTotalDistance = d;
        L.Tag tag = TAG;
        L.i(tag, "updateTrafficBarVariantPath : mTotalDistance - > " + this.mTotalDistance);
        invalidate();
    }

    private int getTrafficColorByStatus(int i) {
        if (i == Integer.MIN_VALUE || i == 0) {
            return ContextUtils.getColor(R.color.traffic_none_info);
        }
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i == 4) {
                        return ContextUtils.getColor(R.color.traffic_serious_congestion);
                    }
                    return ContextUtils.getColor(R.color.traffic_none_info);
                }
                return ContextUtils.getColor(R.color.traffic_congestion);
            }
            return ContextUtils.getColor(R.color.traffic_slow);
        }
        return ContextUtils.getColor(R.color.traffic_normal);
    }

    private int getTrafficColorByFineStatus(int i) {
        switch (getTrafficFineStatus(i)) {
            case TRAFFIC_STATUS_UNKNOWN:
                return ContextUtils.getColor(R.color.traffic_none_info);
            case TRAFFIC_STATUS_RAPIDER:
                return ContextUtils.getColor(R.color.traffic_rapider);
            case TRAFFIC_STATUS_OPEN:
                return ContextUtils.getColor(R.color.traffic_normal);
            case TRAFFIC_STATUS_SLOW:
                return ContextUtils.getColor(R.color.traffic_slow);
            case TRAFFIC_STATUS_JAM:
                return ContextUtils.getColor(R.color.traffic_congestion);
            case TRAFFIC_STATUS_CONGESTED:
                return ContextUtils.getColor(R.color.traffic_serious_congestion);
            default:
                return ContextUtils.getColor(R.color.traffic_none_info);
        }
    }

    private TrafficFineStatus getTrafficFineStatus(int i) {
        if ((i >= OPEN_LOWER_BOUND && i < RAPIDER_LOWER_BOUND) || (i >= RAPIDER_UPPER_BOUND && i < OPEN_UPPER_BOUND)) {
            return TrafficFineStatus.TRAFFIC_STATUS_OPEN;
        }
        if (i >= RAPIDER_LOWER_BOUND && i < RAPIDER_UPPER_BOUND) {
            return TrafficFineStatus.TRAFFIC_STATUS_RAPIDER;
        }
        if (i >= SLOW_LOWER_BOUND && i < SLOW_UPPER_BOUND) {
            return TrafficFineStatus.TRAFFIC_STATUS_SLOW;
        }
        if ((i >= JAM_LOWER_BOUND && i < CONGESTED_LOWER_BOUND) || (i >= CONGESTED_UPPER_BOUND && i < JAM_UPPER_BOUND)) {
            return TrafficFineStatus.TRAFFIC_STATUS_JAM;
        }
        if (i >= CONGESTED_LOWER_BOUND && i < CONGESTED_UPPER_BOUND) {
            return TrafficFineStatus.TRAFFIC_STATUS_CONGESTED;
        }
        if (i >= NO_STREAM_LOWER_BOUND && i < NO_STREAM_UPPER_BOUND) {
            return TrafficFineStatus.TRAFFIC_STATUS_NO_STREAM;
        }
        return TrafficFineStatus.TRAFFIC_STATUS_UNKNOWN;
    }

    public void updatePassedAndBasicColor(int i, int i2) {
        this.mPassedColor = i;
        this.mBasicColor = i2;
        updateCarAndEndIcon();
        updateViasIcon();
        updateCurrentTheme();
        invalidate();
    }

    public void updateCarAndEndIcon() {
        if (this.mCarIcon == null || isThemeChanged()) {
            DecodeResourceParam.Builder builder = new DecodeResourceParam.Builder(getResourcesForDecode());
            builder.putParam(this.mCarId, null);
            BitmapFactoryXP.decodeResourceAsync(builder.build(), new BitmapFactoryXP.IDecodeResultListener() { // from class: com.xiaopeng.montecarlo.views.TrafficBar.1
                @Override // com.xiaopeng.montecarlo.root.util.bitmapfactory.BitmapFactoryXP.IDecodeResultListener
                public void onDecodeSuccess(BitmapFactoryResult bitmapFactoryResult) {
                    if (bitmapFactoryResult.mBitmap == null || bitmapFactoryResult.mBitmap.isRecycled()) {
                        L.w(TrafficBar.TAG, "result.mBitmap error");
                    } else if (TrafficBar.this.mCarId == bitmapFactoryResult.mResid) {
                        TrafficBar.this.mCarIcon = bitmapFactoryResult.mBitmap;
                        L.Tag tag = TrafficBar.TAG;
                        L.i(tag, "onDecodeSuccess mCarIcon:" + TrafficBar.this.mCarIcon);
                        if (TrafficBar.this.mCarIcon == null) {
                            TrafficBar.this.updateCarAndEndIcon();
                        }
                    }
                }

                @Override // com.xiaopeng.montecarlo.root.util.bitmapfactory.BitmapFactoryXP.IDecodeResultListener
                public void onComplete() {
                    L.i(TrafficBar.TAG, "onComplete mCarIcon");
                    TrafficBar.this.invalidate();
                }
            });
        }
        if (this.mEndIcon == null || isThemeChanged()) {
            DecodeResourceParam.Builder builder2 = new DecodeResourceParam.Builder(getResourcesForDecode());
            builder2.putParam(this.mEndId, null);
            BitmapFactoryXP.decodeResourceAsync(builder2.build(), new BitmapFactoryXP.IDecodeResultListener() { // from class: com.xiaopeng.montecarlo.views.TrafficBar.2
                @Override // com.xiaopeng.montecarlo.root.util.bitmapfactory.BitmapFactoryXP.IDecodeResultListener
                public void onDecodeSuccess(BitmapFactoryResult bitmapFactoryResult) {
                    if (bitmapFactoryResult.mBitmap == null || bitmapFactoryResult.mBitmap.isRecycled()) {
                        L.w(TrafficBar.TAG, "result.mBitmap error");
                    } else if (TrafficBar.this.mEndId == bitmapFactoryResult.mResid) {
                        TrafficBar.this.mEndIcon = bitmapFactoryResult.mBitmap;
                        L.Tag tag = TrafficBar.TAG;
                        L.i(tag, "onDecodeSuccess mEndIcon:" + TrafficBar.this.mEndIcon);
                        if (TrafficBar.this.mEndIcon == null) {
                            TrafficBar.this.updateCarAndEndIcon();
                        }
                    }
                }

                @Override // com.xiaopeng.montecarlo.root.util.bitmapfactory.BitmapFactoryXP.IDecodeResultListener
                public void onComplete() {
                    L.i(TrafficBar.TAG, "onComplete mEndIcon");
                    TrafficBar.this.invalidate();
                }
            });
        }
    }

    public void updateViasIcon() {
        if (this.mViaPassingIcon == null || isThemeChanged()) {
            DecodeResourceParam.Builder builder = new DecodeResourceParam.Builder(getResourcesForDecode());
            builder.putParam(this.mViaPassingId, null);
            BitmapFactoryXP.decodeResourceAsync(builder.build(), new BitmapFactoryXP.IDecodeResultListener() { // from class: com.xiaopeng.montecarlo.views.TrafficBar.3
                @Override // com.xiaopeng.montecarlo.root.util.bitmapfactory.BitmapFactoryXP.IDecodeResultListener
                public void onDecodeSuccess(BitmapFactoryResult bitmapFactoryResult) {
                    if (bitmapFactoryResult.mBitmap == null || bitmapFactoryResult.mBitmap.isRecycled()) {
                        L.w(TrafficBar.TAG, "result.mBitmap error");
                    } else if (TrafficBar.this.mViaPassingId == bitmapFactoryResult.mResid) {
                        TrafficBar.this.mViaPassingIcon = bitmapFactoryResult.mBitmap;
                        L.Tag tag = TrafficBar.TAG;
                        L.i(tag, "onDecodeSuccess mViaPassingIcon:" + TrafficBar.this.mViaPassingIcon);
                        if (TrafficBar.this.mViaPassingIcon == null) {
                            TrafficBar.this.updateViasIcon();
                        }
                    }
                }

                @Override // com.xiaopeng.montecarlo.root.util.bitmapfactory.BitmapFactoryXP.IDecodeResultListener
                public void onComplete() {
                    TrafficBar.this.invalidate();
                }
            });
        }
        if (this.mViaPassedIcon == null || isThemeChanged()) {
            DecodeResourceParam.Builder builder2 = new DecodeResourceParam.Builder(getResourcesForDecode());
            builder2.putParam(this.mViaPassedId, null);
            BitmapFactoryXP.decodeResourceAsync(builder2.build(), new BitmapFactoryXP.IDecodeResultListener() { // from class: com.xiaopeng.montecarlo.views.TrafficBar.4
                @Override // com.xiaopeng.montecarlo.root.util.bitmapfactory.BitmapFactoryXP.IDecodeResultListener
                public void onDecodeSuccess(BitmapFactoryResult bitmapFactoryResult) {
                    if (bitmapFactoryResult.mBitmap == null || bitmapFactoryResult.mBitmap.isRecycled()) {
                        L.w(TrafficBar.TAG, "result.mBitmap error");
                    } else if (TrafficBar.this.mViaPassedId == bitmapFactoryResult.mResid) {
                        TrafficBar.this.mViaPassedIcon = bitmapFactoryResult.mBitmap;
                        L.Tag tag = TrafficBar.TAG;
                        L.i(tag, "onDecodeSuccess mViaPassedIcon:" + TrafficBar.this.mViaPassedIcon);
                        if (TrafficBar.this.mViaPassedIcon == null) {
                            TrafficBar.this.updateViasIcon();
                        }
                    }
                }

                @Override // com.xiaopeng.montecarlo.root.util.bitmapfactory.BitmapFactoryXP.IDecodeResultListener
                public void onComplete() {
                    TrafficBar.this.invalidate();
                }
            });
        }
    }

    public void setDrawTrafficBlock(boolean z) {
        this.mDrawTrafficBlock = z;
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "setDrawTrafficBlock drawTrafficBlock:" + z);
        }
    }

    private Bitmap getRoundBitmap(Bitmap bitmap, int i, int i2) {
        if (bitmap == null) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Rect rect = new Rect(0, 0, width, height);
        RectF rectF = new RectF(rect);
        canvas.drawARGB(0, 0, 0, 0);
        this.mRoundBitmapPaint.reset();
        this.mRoundBitmapPaint.setAntiAlias(true);
        canvas.drawRoundRect(rectF, i, i2, this.mRoundBitmapPaint);
        this.mRoundBitmapPaint.setXfermode(this.mRoundBitmapXFremode);
        canvas.drawBitmap(bitmap, rect, rect, this.mRoundBitmapPaint);
        return createBitmap;
    }

    private void updateCurrentTheme() {
        this.mIsDay = ThemeWatcherUtil.isDayMode();
    }

    private boolean isThemeChanged() {
        return this.mIsDay != ThemeWatcherUtil.isDayMode();
    }

    private Resources getResourcesForDecode() {
        return ContextUtils.getContext().getResources();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class ViaPassIconBean {
        public Bitmap bitmap;
        public int label;
        public float left;
        public float top;

        public ViaPassIconBean(Bitmap bitmap, float f, float f2, int i) {
            this.bitmap = bitmap;
            this.left = f;
            this.top = f2;
            this.label = i;
        }
    }
}
