package com.xiaopeng.montecarlo.views;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.timer.XCountDownTimer;
import com.xiaopeng.montecarlo.util.ThemeWatcherUtil;
import com.xiaopeng.xui.widget.XButton;
import com.xiaopeng.xui.widget.XRelativeLayout;
import com.xiaopeng.xui.widget.XTextView;
/* loaded from: classes3.dex */
public class TipsView extends XRelativeLayout implements View.OnClickListener {
    private static final int DEFAULT_MAX_TIME = 15000;
    private static final int MESSAGE_TIME_OUT = 0;
    private static final L.Tag TAG = new L.Tag("TipsView");
    public static final int TIP_TYPE_REMIND = 1;
    public static final int TIP_TYPE_WARNING = 0;
    private XButton mActionBtn;
    private int mBgColorId;
    private XTextView mClockTv;
    private XRelativeLayout mContainer;
    private String mContent;
    private XTextView mContentTv;
    private IActionListener mListener;
    private View mRootView;
    private int mTimeCountDown;
    private final XCountDownTimer mTimer;
    private String mTitle;
    private XTextView mTitleTv;
    private boolean mUseBgImage;

    /* loaded from: classes3.dex */
    public interface IActionListener {
        void onClose();

        void onTipsAction();
    }

    public TipsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mTitle = "";
        this.mContent = "";
        this.mBgColorId = -1;
        this.mUseBgImage = true;
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.layout_tips, this);
        this.mTitleTv = (XTextView) findViewById(R.id.tips_title);
        this.mContentTv = (XTextView) findViewById(R.id.tips_content);
        this.mActionBtn = (XButton) findViewById(R.id.tips_detail_btn);
        this.mClockTv = (XTextView) findViewById(R.id.clock_close);
        this.mContainer = (XRelativeLayout) findViewById(R.id.tips_container);
        initClickListener();
        this.mTimer = new XCountDownTimer(15000L, new XCountDownTimer.ITimerCallback() { // from class: com.xiaopeng.montecarlo.views.TipsView.1
            @Override // com.xiaopeng.montecarlo.root.util.timer.XCountDownTimer.ITimerCallback
            public void onTick(long j) {
                if (TipsView.this.getVisibility() != 0 || TipsView.this.mClockTv == null) {
                    return;
                }
                TipsView.this.mClockTv.setText(String.format(ContextUtils.getString(R.string.restricted_rule_detail_guide_close_btn_name), Long.valueOf(j)));
            }

            @Override // com.xiaopeng.montecarlo.root.util.timer.XCountDownTimer.ITimerCallback
            public void onTimeOut() {
                if (TipsView.this.mListener != null) {
                    TipsView.this.mListener.onClose();
                }
                TipsView.this.hide();
            }
        });
    }

    public void setActionListener(IActionListener iActionListener) {
        this.mListener = iActionListener;
    }

    private void initClickListener() {
        this.mActionBtn.setOnClickListener(this);
        this.mClockTv.setOnClickListener(this);
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    public void setContent(String str) {
        this.mContent = str;
    }

    public void setBgColor(int i) {
        this.mBgColorId = i;
    }

    public void setUseBgImage(boolean z) {
        this.mUseBgImage = z;
    }

    public void setTimeCountDown(int i) {
        this.mTimeCountDown = i;
    }

    public void updateView(int i) {
        Drawable drawable;
        int color = ThemeWatcherUtil.getColor(R.color.restricted_rule_yellow_text_color);
        if (i == 0) {
            setBackgroundResId(R.drawable.layer_bg_restrict_pop_view_content);
            color = ThemeWatcherUtil.getColor(R.color.restricted_rule_red_text_color);
        } else if (i == 1) {
            setBackgroundResId(R.drawable.layer_bg_restrict_pop_view_content);
        }
        this.mActionBtn.setTextColor(color);
        if (!this.mUseBgImage) {
            setTextColor(color);
            this.mClockTv.setTextColor(color);
            Drawable drawable2 = ContextUtils.getContext().getDrawable(R.drawable.layer_bg_restrict_close);
            if (drawable2 != null) {
                if (drawable2 instanceof GradientDrawable) {
                    ((GradientDrawable) drawable2).setStroke(ContextUtils.getDimensionPixelSize(R.dimen.restrict_bg_stroke_width), color);
                } else if ((drawable2 instanceof LayerDrawable) && (drawable = ((LayerDrawable) drawable2).getDrawable(0)) != null && (drawable instanceof GradientDrawable)) {
                    ((GradientDrawable) drawable).setStroke(ContextUtils.getDimensionPixelSize(R.dimen.restrict_bg_stroke_width), color);
                }
                this.mClockTv.setBackground(drawable2);
            }
            this.mActionBtn.setBackground(ThemeWatcherUtil.getDrawable(R.drawable.layer_bg_restrict_detail_btn));
            return;
        }
        setTextColor(getResources().getColor(ThemeWatcherUtil.isDayMode() ? R.color.bg_card_bg_white : R.color.tag_text_white_night));
        setCloseBtnBackgroundResId(R.drawable.shape_bg_white_frame_close);
        setActionBtnBackgroundResId(R.drawable.shape_bg_white_with_corner6);
    }

    private void setTextColor(int i) {
        this.mTitleTv.setTextColor(i);
        this.mContentTv.setTextColor(i);
        this.mClockTv.setTextColor(i);
    }

    public void setBackgroundResId(int i) {
        this.mContainer.setBackground(ThemeWatcherUtil.getDrawable(i));
    }

    public void setCloseBtnBackgroundResId(int i) {
        this.mClockTv.setBackground(ThemeWatcherUtil.getDrawable(i));
    }

    public void setActionBtnBackgroundResId(int i) {
        this.mActionBtn.setBackground(ThemeWatcherUtil.getDrawable(i));
    }

    public void show() {
        L.Tag tag = TAG;
        L.i(tag, "show: " + this.mTitle + ", content: " + this.mContent);
        if (!TextUtils.isEmpty(this.mTitle)) {
            this.mTitleTv.setText(this.mTitle);
            this.mTitleTv.setVisibility(0);
        } else {
            this.mTitleTv.setVisibility(8);
        }
        if (!TextUtils.isEmpty(this.mContent)) {
            this.mContentTv.setText(this.mContent);
            this.mContentTv.setVisibility(0);
        } else {
            this.mContentTv.setVisibility(8);
        }
        setVisibility(0);
        this.mTimer.start();
    }

    public void hide() {
        L.i(TAG, "hide");
        setVisibility(8);
        this.mTimer.stop();
        setActionListener(null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.clock_close) {
            L.Tag tag = TAG;
            L.i(tag, "onClick close: " + this.mListener);
            IActionListener iActionListener = this.mListener;
            if (iActionListener != null) {
                iActionListener.onClose();
            }
            hide();
        } else if (id != R.id.tips_detail_btn) {
        } else {
            L.Tag tag2 = TAG;
            L.i(tag2, "onClick detail: " + this.mListener);
            IActionListener iActionListener2 = this.mListener;
            if (iActionListener2 != null) {
                iActionListener2.onTipsAction();
            }
            hide();
        }
    }
}
