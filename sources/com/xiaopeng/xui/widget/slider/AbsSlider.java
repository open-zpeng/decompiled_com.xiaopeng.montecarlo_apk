package com.xiaopeng.xui.widget.slider;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.ColorInt;
import androidx.core.content.ContextCompat;
import com.xiaopeng.vui.commons.IVuiElementListener;
import com.xiaopeng.xpui.R;
import com.xiaopeng.xui.theme.XThemeManager;
import com.xiaopeng.xui.widget.XViewGroup;
import java.text.DecimalFormat;
/* loaded from: classes3.dex */
public abstract class AbsSlider extends XViewGroup implements IVuiElementListener {
    protected static final int BG_ITEM_MARGIN = 18;
    protected static final int BG_ITEM_SIZE = 30;
    protected static final int BG_ITEM_SIZE_MIN = 3;
    protected static final int CHILDREN_LAYOUT_HEIGHT = 40;
    protected static final int CHILDREN_LAYOUT_WIDTH = 20;
    private static final int INDICATOR_BALL_RADIUS = 9;
    protected static final int INDICATOR_HOLD_HORIZONTAL = 0;
    protected static final int INDICATOR_HOLD_VERTICAL = 40;
    protected static final int INDICATOR_MARGIN = 16;
    private static final int INDICATOR_OUTER = 7;
    protected float accuracy;
    private LinearGradient barGradient;
    @ColorInt
    int bgBallColor;
    @ColorInt
    int bgDayColor;
    private final Paint bgGradientPaint;
    private final float bgHeight;
    protected float bgItemGap;
    @ColorInt
    int bgLineColorSelect;
    private Paint bgLinePaint;
    @ColorInt
    int bgNightColor;
    private Paint bgPaint;
    protected float bgVertical;
    private Paint bollPaint;
    protected float currentUpdateIndex;
    @ColorInt
    private int customBackground;
    protected int decimal;
    protected DecimalFormat decimalFormat;
    private float desireHeight;
    private final float desireWidth;
    protected int disableAlpha;
    protected boolean dismissPop;
    private final int enableAlpha;
    protected int endColor;
    protected int endIndex;
    private final Paint gradientPaint;
    protected boolean hidePop;
    IndicatorDrawable indicatorDrawable;
    private int indicatorHoldVertical;
    protected float indicatorValue;
    protected float indicatorX;
    protected int initIndex;
    protected boolean isNight;
    private int itemCount;
    protected int leftColor;
    @ColorInt
    int lineColorSelect;
    protected Paint lineSelectPaint;
    protected boolean mIsDragging;
    protected float mScaledTouchSlop;
    protected int mStep;
    protected float mTouchDownX;
    protected String prefixUnit;
    protected int rightColor;
    private final float roundRadius;
    protected int startIndex;
    protected BitmapDrawable thumb;
    protected int topColor;
    protected String unit;
    protected int upperLimit;
    protected int workableTotalWidth;

    private int resetAlpha(@ColorInt int i, int i2) {
        return (i & 16777215) | (i2 << 24);
    }

    public AbsSlider(Context context) {
        this(context, null);
    }

    public AbsSlider(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AbsSlider(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gradientPaint = new Paint(1);
        this.bgGradientPaint = new Paint(1);
        this.enableAlpha = 92;
        this.desireWidth = 644.0f;
        this.bgHeight = 40.0f;
        this.roundRadius = 16.0f;
        this.disableAlpha = 40;
        this.initIndex = -1;
        this.upperLimit = Integer.MIN_VALUE;
        this.bgVertical = 16.0f;
        this.accuracy = 1.0f;
        this.dismissPop = false;
        this.endColor = 1555808977;
        this.topColor = 1555808977;
        this.rightColor = -12871169;
        this.leftColor = -12860929;
        this.mStep = 1;
        this.hidePop = false;
        this.bgLineColorSelect = -15945223;
        this.bgNightColor = 1543503872;
        this.bgDayColor = 1560281087;
        this.bgBallColor = -12871169;
        this.lineColorSelect = -1;
        this.customBackground = 0;
        this.desireHeight = 100.0f;
        this.itemCount = 30;
        this.indicatorHoldVertical = 40;
        initView(context, attributeSet);
        initPaint();
        if (isInEditMode()) {
            return;
        }
        this.isNight = XThemeManager.isNight(getContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.xui.widget.XViewGroup, android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (!isInEditMode()) {
            this.isNight = XThemeManager.isNight(getContext());
        }
        invalidate();
    }

    private void initPaint() {
        if (!this.hidePop) {
            this.indicatorDrawable = new IndicatorDrawable(getContext());
        }
        this.bgPaint = new Paint(1);
        this.bgPaint.setStyle(Paint.Style.FILL);
        this.bgPaint.setColor(this.bgNightColor);
        this.bgLinePaint = new Paint(1);
        this.bgLinePaint.setStyle(Paint.Style.FILL);
        this.bgLinePaint.setStrokeCap(Paint.Cap.ROUND);
        this.bgLinePaint.setColor(this.bgLineColorSelect);
        this.bgLinePaint.setStrokeWidth(16.0f);
        this.bollPaint = new Paint(1);
        this.bollPaint.setStyle(Paint.Style.FILL);
        this.bollPaint.setColor(-1);
        this.lineSelectPaint = new Paint(1);
        this.lineSelectPaint.setStyle(Paint.Style.FILL);
        this.lineSelectPaint.setStrokeCap(Paint.Cap.ROUND);
        this.lineSelectPaint.setStrokeWidth(12.0f);
        this.lineSelectPaint.setColor(this.lineColorSelect);
        setEnabled(true);
        this.thumb = (BitmapDrawable) ContextCompat.getDrawable(getContext(), R.drawable.x_slider_slideblock_night);
    }

    private void initView(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.XSlider);
            this.unit = obtainStyledAttributes.getString(R.styleable.XSlider_slider_unit);
            this.startIndex = obtainStyledAttributes.getInteger(R.styleable.XSlider_slider_start_index, 0);
            this.mStep = obtainStyledAttributes.getInteger(R.styleable.XSlider_slider_step, 1);
            this.initIndex = obtainStyledAttributes.getInteger(R.styleable.XSlider_slider_init_index, -1);
            this.endIndex = obtainStyledAttributes.getInteger(R.styleable.XSlider_slider_end_index, 100);
            this.upperLimit = obtainStyledAttributes.getInteger(R.styleable.XSlider_slider_upper_limit, Integer.MIN_VALUE);
            this.decimal = obtainStyledAttributes.getInteger(R.styleable.XSlider_slider_index_decimal, 0);
            this.prefixUnit = obtainStyledAttributes.getString(R.styleable.XSlider_slider_unit_prefix);
            this.bgNightColor = obtainStyledAttributes.getColor(R.styleable.XSlider_slider_bg_color, this.bgNightColor);
            this.bgLineColorSelect = obtainStyledAttributes.getColor(R.styleable.XSlider_slider_bg_line_color, this.bgLineColorSelect);
            this.customBackground = obtainStyledAttributes.getColor(R.styleable.XSlider_slider_background, 0);
            this.accuracy = obtainStyledAttributes.getFloat(R.styleable.XSlider_slider_accuracy, 0.0f);
            this.hidePop = obtainStyledAttributes.getBoolean(R.styleable.XSlider_slider_hide_pop, false);
            this.dismissPop = obtainStyledAttributes.getBoolean(R.styleable.XSlider_slider_dismiss_pop, false);
            this.itemCount = obtainStyledAttributes.getInteger(R.styleable.XSlider_slider_item_count, 30);
            if (this.initIndex == -1) {
                int i = this.startIndex;
                int i2 = this.endIndex;
                if (i > i2) {
                    i = i2;
                }
                this.initIndex = i;
            }
            int i3 = this.initIndex;
            int i4 = this.startIndex;
            this.indicatorValue = i3 - i4;
            if (this.endIndex == i4) {
                throw new RuntimeException("startIndex = endIndex!!! please check the xml");
            }
            int i5 = this.decimal;
            this.decimalFormat = i5 == 0 ? null : i5 == 1 ? new DecimalFormat("0.0") : new DecimalFormat("0.00");
            if (this.accuracy == 0.0f) {
                int i6 = this.decimal;
                this.accuracy = i6 == 0 ? 1.0f : i6 == 1 ? 0.1f : 0.01f;
            }
            if (this.itemCount < 3) {
                this.itemCount = 3;
            }
            if (this.dismissPop) {
                this.hidePop = true;
                this.desireHeight = 32.0f;
                this.indicatorHoldVertical = 0;
            }
            obtainStyledAttributes.recycle();
        }
        setMinimumWidth(80);
        setBackground(new ColorDrawable(this.customBackground));
        this.mScaledTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(View.MeasureSpec.getMode(i) == Integer.MIN_VALUE ? 644 : getMeasuredWidth(), (int) this.desireHeight);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.isNight) {
            this.bgPaint.setColor(this.bgNightColor);
            canvas.drawRoundRect(0.0f, (getHeightExIndicator() / 2.0f) - this.bgVertical, getWidthExIndicator(), (getHeightExIndicator() / 2.0f) + this.bgVertical, 16.0f, 16.0f, this.bgPaint);
            return;
        }
        if (isEnabled()) {
            this.bgGradientPaint.setColor(this.endColor);
            canvas.drawRoundRect(0.0f, (getHeightExIndicator() / 2.0f) - this.bgVertical, getWidthExIndicator(), (getHeightExIndicator() / 2.0f) + this.bgVertical, 16.0f, 16.0f, this.bgGradientPaint);
        } else {
            this.bgPaint.setColor(this.bgDayColor);
            canvas.drawRoundRect(0.0f, (getHeightExIndicator() / 2.0f) - this.bgVertical, getWidthExIndicator(), (getHeightExIndicator() / 2.0f) + this.bgVertical, 16.0f, 16.0f, this.bgPaint);
        }
        if (isEnabled()) {
            this.gradientPaint.setShader(this.barGradient);
            canvas.drawRoundRect(0.0f, (getHeightExIndicator() / 2.0f) - this.bgVertical, filterValidValue() + 9.0f + 7.0f, (getHeightExIndicator() / 2.0f) + this.bgVertical, 16.0f, 16.0f, this.gradientPaint);
            return;
        }
        this.bgPaint.setColor(this.bgBallColor);
        canvas.drawRoundRect(0.0f, (getHeightExIndicator() / 2.0f) - this.bgVertical, filterValidValue() + 9.0f + 7.0f, (getHeightExIndicator() / 2.0f) + this.bgVertical, 16.0f, 16.0f, this.bgPaint);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        setPadding(0, 0, 0, 0);
        this.workableTotalWidth = i - 32;
        this.bgItemGap = this.workableTotalWidth / (this.itemCount - 1);
        int i5 = this.initIndex;
        int i6 = this.startIndex;
        this.indicatorX = (Math.abs((i5 - i6) / (this.endIndex - i6)) * this.workableTotalWidth) + 16.0f;
        for (int i7 = 0; i7 < this.itemCount; i7++) {
            addView(new SlideLineView(getContext(), this.indicatorX > (this.bgItemGap * ((float) i7)) + 16.0f));
        }
        this.barGradient = new LinearGradient(16.0f, 0.0f, this.workableTotalWidth, 0.0f, new int[]{this.leftColor, this.rightColor}, (float[]) null, Shader.TileMode.CLAMP);
        if (!this.hidePop) {
            this.indicatorDrawable.updateCenter(filterValidValue(), getPopString(), this.isNight, getWidth());
        }
        invalidate();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        float width = (getWidth() - 36) / (this.itemCount - 1);
        for (int i5 = 0; i5 < getChildCount(); i5++) {
            float f = (i5 * width) + 18.0f;
            getChildAt(i5).layout((int) (f - 10.0f), (((int) getHeightExIndicator()) / 2) - 20, (int) (f + 10.0f), (((int) getHeightExIndicator()) / 2) + 20);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void invalidateAll() {
        invalidate();
        if (this.hidePop) {
            return;
        }
        this.indicatorDrawable.updateCenter(filterValidValue(), getPopString(), this.isNight, getWidth());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isInScrollContainer() {
        for (ViewParent parent = getParent(); parent instanceof ViewGroup; parent = parent.getParent()) {
            if (((ViewGroup) parent).shouldDelayChildPressedState()) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void stickIndicator() {
        float f;
        if (this.mStep == 1) {
            return;
        }
        this.indicatorX = (((int) (((this.indicatorX - 16.0f) / f) + 0.5d)) * (this.workableTotalWidth / (this.endIndex - this.startIndex))) + 16.0f;
    }

    public float getIndicatorValue() {
        return (this.indicatorValue + this.startIndex) * this.mStep;
    }

    public void setAccuracy(float f) {
        this.accuracy = f;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        float filterValidValue = filterValidValue();
        if (filterValidValue == 0.0f) {
            return;
        }
        float heightExIndicator = getHeightExIndicator() / 2.0f;
        if (!this.hidePop) {
            this.indicatorDrawable.draw(canvas, this.isNight, isEnabled());
        }
        if (isEnabled()) {
            if (this.isNight) {
                canvas.drawBitmap(this.thumb.getBitmap(), filterValidValue - (this.thumb.getBitmap().getWidth() / 2), heightExIndicator - (this.thumb.getBitmap().getHeight() / 2), this.bgLinePaint);
            } else {
                canvas.drawCircle(filterValidValue, heightExIndicator, 9.0f, this.bollPaint);
            }
        }
    }

    public float getHeightExIndicator() {
        return getHeight() + this.indicatorHoldVertical;
    }

    private float getWidthExIndicator() {
        return getWidth() + 0;
    }

    public float getIndicatorLocationX() {
        return this.indicatorX;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public float filterValidValue() {
        if (this.indicatorX < 16.0f) {
            return 16.0f;
        }
        float width = (getWidth() - 16) - upperLimitDistance();
        float f = this.indicatorX;
        return f > width ? width : f;
    }

    private float upperLimitDistance() {
        int i;
        int i2;
        int i3 = this.upperLimit;
        if (i3 != Integer.MIN_VALUE && (i = this.startIndex) < (i2 = this.endIndex) && i <= i3 && i3 <= i2) {
            return ((i2 - i3) * this.workableTotalWidth) / (i2 - i);
        }
        return 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getPopString() {
        if (this.unit == null) {
            this.unit = "";
        }
        if (this.prefixUnit == null) {
            this.prefixUnit = "";
        }
        if (this.decimalFormat == null) {
            if (this.mStep == 1) {
                return this.prefixUnit + (this.startIndex + ((int) this.indicatorValue)) + this.unit;
            }
            return this.prefixUnit + ((this.startIndex + ((int) (this.indicatorValue + 0.5d))) * this.mStep) + this.unit;
        }
        return this.prefixUnit + this.decimalFormat.format((this.startIndex + this.indicatorValue) * this.mStep) + this.unit;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setAlphaByEnable(boolean z) {
        this.bgNightColor = resetAlpha(this.bgNightColor, z ? 92 : this.disableAlpha);
        this.bgDayColor = resetAlpha(this.bgDayColor, z ? 92 : this.disableAlpha);
        this.bgBallColor = resetAlpha(this.bgBallColor, z ? 255 : this.disableAlpha);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.xui.widget.XViewGroup, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.xui.widget.XViewGroup, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (isInEditMode()) {
            return;
        }
        this.isNight = XThemeManager.isNight(getContext());
    }
}
