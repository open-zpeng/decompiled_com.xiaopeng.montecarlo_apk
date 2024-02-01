package com.xiaopeng.xui.widget.slider;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.xiaopeng.speech.vui.constants.VuiConstants;
import com.xiaopeng.vui.commons.IVuiElementBuilder;
import com.xiaopeng.vui.commons.model.VuiElement;
import com.xiaopeng.vui.commons.model.VuiEvent;
import com.xiaopeng.xui.vui.floatinglayer.VuiFloatingLayerManager;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class XSlider extends AbsSlider {
    private ProgressChangeListener progressChangeListener;
    private SliderProgressListener sliderProgressListener;

    /* loaded from: classes3.dex */
    public interface ProgressChangeListener {
        void onProgressChanged(XSlider xSlider, float f, String str, boolean z);
    }

    /* loaded from: classes3.dex */
    public interface SliderProgressListener {
        void onProgressChanged(XSlider xSlider, float f, String str);

        void onStartTrackingTouch(XSlider xSlider);

        void onStopTrackingTouch(XSlider xSlider);
    }

    public XSlider(Context context) {
        this(context, null);
    }

    public XSlider(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public XSlider(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (isEnabled()) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action == 1) {
                    if (this.mIsDragging) {
                        this.mIsDragging = false;
                    } else {
                        SliderProgressListener sliderProgressListener = this.sliderProgressListener;
                        if (sliderProgressListener != null) {
                            sliderProgressListener.onStartTrackingTouch(this);
                        }
                    }
                    this.indicatorX = motionEvent.getX();
                    stickIndicator();
                    notifyChildren(true, true);
                    getParent().requestDisallowInterceptTouchEvent(false);
                    SliderProgressListener sliderProgressListener2 = this.sliderProgressListener;
                    if (sliderProgressListener2 != null) {
                        sliderProgressListener2.onStopTrackingTouch(this);
                    }
                    invalidateAll();
                } else if (action != 2) {
                    if (action == 3) {
                        if (this.mIsDragging) {
                            this.mIsDragging = false;
                        }
                        invalidateAll();
                    }
                } else if (this.mIsDragging) {
                    this.indicatorX = motionEvent.getX();
                    notifyChildren(true, false);
                    invalidateAll();
                } else if (Math.abs(motionEvent.getX() - this.mTouchDownX) > this.mScaledTouchSlop) {
                    this.mIsDragging = true;
                    SliderProgressListener sliderProgressListener3 = this.sliderProgressListener;
                    if (sliderProgressListener3 != null) {
                        sliderProgressListener3.onStartTrackingTouch(this);
                    }
                    this.indicatorX = motionEvent.getX();
                    getParent().requestDisallowInterceptTouchEvent(true);
                    notifyChildren(true, false);
                    invalidateAll();
                }
            } else if (isInScrollContainer()) {
                this.mTouchDownX = motionEvent.getX();
            } else {
                this.mIsDragging = true;
                getParent().requestDisallowInterceptTouchEvent(true);
                SliderProgressListener sliderProgressListener4 = this.sliderProgressListener;
                if (sliderProgressListener4 != null) {
                    sliderProgressListener4.onStartTrackingTouch(this);
                }
                this.indicatorX = motionEvent.getX();
                notifyChildren(true, false);
                invalidateAll();
            }
            return true;
        }
        return true;
    }

    private void notifyChildren(boolean z, boolean z2) {
        float filterValidValue = filterValidValue();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            SlideLineView slideLineView = (SlideLineView) getChildAt(i);
            if (slideLineView.getX() + (slideLineView.getWidth() / 2) <= filterValidValue()) {
                if (!slideLineView.isSelect()) {
                    slideLineView.setSelect(true);
                }
            } else {
                slideLineView.setSelect(false);
            }
        }
        if (z) {
            float f = filterValidValue - 16.0f;
            this.indicatorValue = (f / this.workableTotalWidth) * (this.endIndex - this.startIndex);
            if (this.sliderProgressListener != null) {
                if (z2 || this.indicatorValue + this.startIndex >= this.currentUpdateIndex + this.accuracy || this.indicatorValue + this.startIndex <= this.currentUpdateIndex - this.accuracy || this.currentUpdateIndex == 0.0f) {
                    this.sliderProgressListener.onProgressChanged(this, this.indicatorValue + this.startIndex, this.unit);
                    this.indicatorValue = (f / this.workableTotalWidth) * (this.endIndex - this.startIndex);
                    this.currentUpdateIndex = ((int) this.indicatorValue) + this.startIndex;
                    updateVui(this);
                }
            }
        }
    }

    @Override // com.xiaopeng.xui.widget.slider.AbsSlider
    public float getIndicatorValue() {
        return (this.indicatorValue + this.startIndex) * this.mStep;
    }

    @Override // com.xiaopeng.xui.widget.slider.AbsSlider
    public void setAccuracy(float f) {
        this.accuracy = f;
    }

    @Override // com.xiaopeng.xui.widget.slider.AbsSlider
    public float getIndicatorLocationX() {
        return this.indicatorX;
    }

    public void setSliderProgressListener(SliderProgressListener sliderProgressListener) {
        this.sliderProgressListener = sliderProgressListener;
    }

    public void setProgressChangeListener(ProgressChangeListener progressChangeListener) {
        this.progressChangeListener = progressChangeListener;
    }

    public void setCurrentIndex(int i) {
        setCurrentIndex(i, false);
    }

    public void setCurrentIndex(final int i, final boolean z) {
        post(new Runnable() { // from class: com.xiaopeng.xui.widget.slider.-$$Lambda$XSlider$6nRMnQGFhZSAnHXSTyWZZ5qLEF4
            @Override // java.lang.Runnable
            public final void run() {
                XSlider.this.lambda$setCurrentIndex$0$XSlider(i, z);
            }
        });
    }

    public /* synthetic */ void lambda$setCurrentIndex$0$XSlider(int i, boolean z) {
        ProgressChangeListener progressChangeListener;
        this.indicatorX = (((i - this.startIndex) / (this.endIndex - this.startIndex)) * this.workableTotalWidth) + 16.0f;
        this.indicatorValue = i - this.startIndex;
        invalidate();
        notifyChildren(false, false);
        if (!this.hidePop) {
            this.indicatorDrawable.updateCenter(filterValidValue(), getPopString(), this.isNight, getWidth());
        }
        if (z && (progressChangeListener = this.progressChangeListener) != null) {
            progressChangeListener.onProgressChanged(this, this.indicatorValue + this.startIndex, this.unit, true);
        }
        if (getVuiValue() == null || ((Float) getVuiValue()).floatValue() != getIndicatorValue()) {
            updateVui(this);
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        if (!z) {
            this.mIsDragging = false;
        }
        super.setEnabled(z);
        for (int i = 0; i < getChildCount(); i++) {
            getChildAt(i).setEnabled(z);
        }
        setAlphaByEnable(z);
        invalidate();
    }

    public void setStartIndex(int i) {
        if (i == this.endIndex) {
            throw new RuntimeException("startIndex = endIndex!!!");
        }
        this.startIndex = i;
        post(new Runnable() { // from class: com.xiaopeng.xui.widget.slider.-$$Lambda$XSlider$Xz60DHZ7J60ywvILqd--vaYYV3k
            @Override // java.lang.Runnable
            public final void run() {
                XSlider.this.lambda$setStartIndex$1$XSlider();
            }
        });
    }

    public /* synthetic */ void lambda$setStartIndex$1$XSlider() {
        if (!this.hidePop) {
            this.indicatorDrawable.updateCenter(filterValidValue(), getPopString(), this.isNight, getWidth());
        }
        invalidate();
    }

    public void setEndIndex(int i) {
        if (this.startIndex == i) {
            throw new RuntimeException("startIndex = endIndex!!!");
        }
        this.endIndex = i;
        post(new Runnable() { // from class: com.xiaopeng.xui.widget.slider.-$$Lambda$XSlider$kB2KeMUVNgZs-Tjtgxuk4WuttL4
            @Override // java.lang.Runnable
            public final void run() {
                XSlider.this.lambda$setEndIndex$2$XSlider();
            }
        });
    }

    public /* synthetic */ void lambda$setEndIndex$2$XSlider() {
        invalidate();
    }

    public void setInitIndex(int i) {
        if (i > this.endIndex) {
            this.initIndex = this.endIndex;
        } else if (i < this.startIndex) {
            this.initIndex = this.startIndex;
        } else {
            this.initIndex = i;
            this.indicatorValue = i - this.startIndex;
            invalidate();
        }
    }

    @Override // com.xiaopeng.vui.commons.IVuiElementListener
    public VuiElement onBuildVuiElement(String str, IVuiElementBuilder iVuiElementBuilder) {
        try {
            setVuiValue(Float.valueOf(getIndicatorValue()));
        } catch (JSONException unused) {
        }
        if (getVuiProps() != null && getVuiProps().has(VuiConstants.PROPS_SETPROPS) && getVuiProps().getBoolean(VuiConstants.PROPS_SETPROPS)) {
            return null;
        }
        JSONObject vuiProps = getVuiProps();
        if (vuiProps == null) {
            vuiProps = new JSONObject();
        }
        vuiProps.put("minValue", this.startIndex);
        vuiProps.put("maxValue", this.endIndex);
        vuiProps.put(VuiConstants.PROPS_INTERVAL, (int) Math.ceil((this.endIndex - this.startIndex) / 10.0d));
        setVuiProps(vuiProps);
        return null;
    }

    @Override // com.xiaopeng.vui.commons.IVuiElementListener
    public boolean onVuiElementEvent(final View view, VuiEvent vuiEvent) {
        Double d;
        int round;
        logD("slider onVuiElementEvent");
        if (view == null || (d = (Double) vuiEvent.getEventValue(vuiEvent)) == null) {
            return false;
        }
        if (this.mStep == 1) {
            round = (int) Math.ceil(d.doubleValue());
        } else {
            round = (int) Math.round(d.doubleValue() / this.mStep);
        }
        if (round >= this.startIndex && round <= this.endIndex) {
            setCurrentIndex(round, true);
            post(new Runnable() { // from class: com.xiaopeng.xui.widget.slider.-$$Lambda$XSlider$8q6TCB-9AxkZNaxjbRsq1Ki1ixY
                @Override // java.lang.Runnable
                public final void run() {
                    XSlider.this.lambda$onVuiElementEvent$3$XSlider(view);
                }
            });
        }
        return true;
    }

    public /* synthetic */ void lambda$onVuiElementEvent$3$XSlider(View view) {
        VuiFloatingLayerManager.show(view, ((int) getIndicatorLocationX()) - (getWidth() / 2), (int) ((getHeightExIndicator() / 2.0f) - (getHeight() / 2)));
    }
}
