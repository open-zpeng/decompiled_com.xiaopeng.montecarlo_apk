package com.xiaopeng.montecarlo.views;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import androidx.annotation.DrawableRes;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.util.ThemeWatcherUtil;
import com.xiaopeng.xui.widget.XImageButton;
import com.xiaopeng.xui.widget.XRelativeLayout;
import com.xiaopeng.xui.widget.XTextView;
/* loaded from: classes3.dex */
public class ExpandableTextView extends XRelativeLayout implements View.OnClickListener {
    private static final int DEFAULT_TOGGLE_TYPE = 0;
    private static final int EXPAND_INDICATOR_IMAGE_BUTTON = 0;
    private static final int EXPAND_INDICATOR_TEXT_VIEW = 1;
    private static final int MAX_COLLAPSED_LINES = 8;
    private static final L.Tag TAG = new L.Tag("ExpandableTextView");
    private OnExpandableTextViewChangeListener mChangeListener;
    private boolean mCollapsed;
    private int mCollapsedHeight;
    private SparseBooleanArray mCollapsedStatus;
    @IdRes
    private int mExpandCollapseToggleId;
    private IExpandIndicatorController mExpandIndicatorController;
    private boolean mExpandToggleOnTextClick;
    @IdRes
    private int mExpandableTextId;
    private OnExpandStateChangeListener mListener;
    private int mMarginBetweenTxtAndBottom;
    private int mMaxCollapsedLines;
    private int mPosition;
    private boolean mRelayout;
    protected XImageButton mToggleView;
    protected XTextView mTv;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public interface IExpandIndicatorController {
        void changeState(boolean z);

        void setView(View view);
    }

    /* loaded from: classes3.dex */
    public interface OnExpandStateChangeListener {
        void onExpandStateChanged(XTextView xTextView, boolean z);
    }

    /* loaded from: classes3.dex */
    public interface OnExpandableTextViewChangeListener {
        void onToggleViewVisibleChangeListener(int i);
    }

    public XImageButton getToggleView() {
        return this.mToggleView;
    }

    public void setChangeListener(OnExpandableTextViewChangeListener onExpandableTextViewChangeListener) {
        this.mChangeListener = onExpandableTextViewChangeListener;
    }

    public ExpandableTextView(Context context) {
        this(context, null);
    }

    public ExpandableTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCollapsed = true;
        this.mExpandableTextId = R.id.expandable_text;
        this.mExpandCollapseToggleId = R.id.expand_collapse;
        init(context, attributeSet);
    }

    @TargetApi(11)
    public ExpandableTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCollapsed = true;
        this.mExpandableTextId = R.id.expandable_text;
        this.mExpandCollapseToggleId = R.id.expand_collapse;
        init(context, attributeSet);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, L.formatVoiceFullScenesLog("onClick view:" + view));
        }
        if (this.mToggleView.getVisibility() != 0) {
            return;
        }
        click(this.mCollapsed);
        OnExpandStateChangeListener onExpandStateChangeListener = this.mListener;
        if (onExpandStateChangeListener != null) {
            onExpandStateChangeListener.onExpandStateChanged(this.mTv, !this.mCollapsed);
        }
    }

    public void resetStatus(final boolean z) {
        if (this.mToggleView.getVisibility() != 0) {
            return;
        }
        this.mMarginBetweenTxtAndBottom = 0;
        this.mTv.post(new Runnable() { // from class: com.xiaopeng.montecarlo.views.ExpandableTextView.1
            @Override // java.lang.Runnable
            public void run() {
                if (ExpandableTextView.this.mTv != null) {
                    ExpandableTextView.this.click(z);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void click(boolean z) {
        this.mCollapsed = !z;
        this.mExpandIndicatorController.changeState(this.mCollapsed);
        SparseBooleanArray sparseBooleanArray = this.mCollapsedStatus;
        if (sparseBooleanArray != null) {
            sparseBooleanArray.put(this.mPosition, this.mCollapsed);
        }
        int height = this.mCollapsed ? this.mCollapsedHeight : (getHeight() + getRealTextViewHeight(this.mTv)) - this.mTv.getHeight();
        int i = this.mMarginBetweenTxtAndBottom;
        if (i != 0) {
            this.mTv.setMaxHeight(height - i);
        }
        getLayoutParams().height = height;
        requestLayout();
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        findViews();
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        if (!this.mRelayout || getVisibility() == 8) {
            super.onMeasure(i, i2);
            return;
        }
        this.mRelayout = false;
        this.mToggleView.setVisibility(8);
        onToggleViewVisibleChanged(this.mToggleView.getVisibility());
        this.mTv.setMaxLines(Integer.MAX_VALUE);
        super.onMeasure(i, i2);
        int lineCount = this.mTv.getLineCount();
        int i3 = this.mMaxCollapsedLines;
        if (lineCount <= i3) {
            this.mCollapsedHeight = getMeasuredHeight();
            return;
        }
        if (this.mCollapsed) {
            this.mTv.setMaxLines(i3);
        }
        this.mToggleView.setVisibility(0);
        onToggleViewVisibleChanged(this.mToggleView.getVisibility());
        super.onMeasure(i, i2);
        if (this.mCollapsed) {
            this.mTv.post(new Runnable() { // from class: com.xiaopeng.montecarlo.views.ExpandableTextView.2
                @Override // java.lang.Runnable
                public void run() {
                    ExpandableTextView expandableTextView = ExpandableTextView.this;
                    expandableTextView.mMarginBetweenTxtAndBottom = expandableTextView.getHeight() - ExpandableTextView.this.mTv.getHeight();
                }
            });
            this.mCollapsedHeight = getMeasuredHeight();
        }
    }

    public void setOnExpandStateChangeListener(@Nullable OnExpandStateChangeListener onExpandStateChangeListener) {
        this.mListener = onExpandStateChangeListener;
    }

    public void setText(@Nullable CharSequence charSequence) {
        this.mRelayout = true;
        this.mTv.setText(charSequence);
        setVisibility(TextUtils.isEmpty(charSequence) ? 8 : 0);
        getLayoutParams().height = -2;
        requestLayout();
    }

    public void setText(@Nullable CharSequence charSequence, @NonNull SparseBooleanArray sparseBooleanArray, int i) {
        this.mCollapsedStatus = sparseBooleanArray;
        this.mPosition = i;
        this.mCollapsed = sparseBooleanArray.get(i, true);
        this.mExpandIndicatorController.changeState(this.mCollapsed);
        setText(charSequence);
    }

    @Nullable
    public CharSequence getText() {
        XTextView xTextView = this.mTv;
        return xTextView == null ? "" : xTextView.getText();
    }

    private void init(Context context, AttributeSet attributeSet) {
        LayoutInflater.from(context).inflate(R.layout.layout_expand_textview, (ViewGroup) this, true);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ExpandableTextView);
        this.mMaxCollapsedLines = obtainStyledAttributes.getInt(6, 8);
        this.mExpandableTextId = obtainStyledAttributes.getResourceId(5, R.id.expandable_text);
        this.mExpandCollapseToggleId = obtainStyledAttributes.getResourceId(1, R.id.expand_collapse);
        this.mExpandToggleOnTextClick = obtainStyledAttributes.getBoolean(3, true);
        this.mExpandIndicatorController = setupExpandToggleController(getContext(), obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        setVisibility(8);
    }

    private void findViews() {
        this.mTv = (XTextView) findViewById(this.mExpandableTextId);
        if (this.mExpandToggleOnTextClick) {
            this.mTv.setOnClickListener(this);
        } else {
            this.mTv.setOnClickListener(null);
        }
        this.mToggleView = (XImageButton) findViewById(this.mExpandCollapseToggleId);
        this.mExpandIndicatorController.setView(this.mToggleView);
        this.mExpandIndicatorController.changeState(this.mCollapsed);
        this.mToggleView.setOnClickListener(this);
    }

    private void onToggleViewVisibleChanged(int i) {
        OnExpandableTextViewChangeListener onExpandableTextViewChangeListener = this.mChangeListener;
        if (onExpandableTextViewChangeListener != null) {
            onExpandableTextViewChangeListener.onToggleViewVisibleChangeListener(i);
        }
    }

    private static Drawable getDrawable(@NonNull Context context, @DrawableRes int i) {
        return ThemeWatcherUtil.getDrawable(i);
    }

    private static int getRealTextViewHeight(@NonNull XTextView xTextView) {
        return (xTextView.getLayout() == null ? 0 : xTextView.getLayout().getLineTop(xTextView.getLineCount())) + xTextView.getCompoundPaddingTop() + xTextView.getCompoundPaddingBottom();
    }

    private static IExpandIndicatorController setupExpandToggleController(@NonNull Context context, TypedArray typedArray) {
        int i = typedArray.getInt(4, 0);
        if (i != 0) {
            if (i == 1) {
                return new TextViewExpandController(typedArray.getString(2), typedArray.getString(0));
            }
            throw new IllegalStateException("Must be of enum: ExpandableTextView_expandToggleType, one of EXPAND_INDICATOR_IMAGE_BUTTON or EXPAND_INDICATOR_TEXT_VIEW.");
        }
        return new ImageButtonExpandController(typedArray.getResourceId(2, R.drawable.vector_ic_xsmall_lower), typedArray.getResourceId(0, R.drawable.vector_ic_xsmall_upper));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class ImageButtonExpandController implements IExpandIndicatorController {
        private final int mCollapseDrawableRes;
        private final int mExpandDrawableRes;
        private ImageButton mImageButton;

        public ImageButtonExpandController(int i, int i2) {
            this.mExpandDrawableRes = i;
            this.mCollapseDrawableRes = i2;
        }

        @Override // com.xiaopeng.montecarlo.views.ExpandableTextView.IExpandIndicatorController
        public void changeState(boolean z) {
            this.mImageButton.setImageDrawable(z ? ThemeWatcherUtil.getDrawable(this.mExpandDrawableRes) : ThemeWatcherUtil.getDrawable(this.mCollapseDrawableRes));
        }

        @Override // com.xiaopeng.montecarlo.views.ExpandableTextView.IExpandIndicatorController
        public void setView(View view) {
            this.mImageButton = (ImageButton) view;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class TextViewExpandController implements IExpandIndicatorController {
        private final String mCollapseText;
        private final String mExpandText;
        private XTextView mTextView;

        public TextViewExpandController(String str, String str2) {
            this.mExpandText = str;
            this.mCollapseText = str2;
        }

        @Override // com.xiaopeng.montecarlo.views.ExpandableTextView.IExpandIndicatorController
        public void changeState(boolean z) {
            this.mTextView.setText(z ? this.mExpandText : this.mCollapseText);
        }

        @Override // com.xiaopeng.montecarlo.views.ExpandableTextView.IExpandIndicatorController
        public void setView(View view) {
            this.mTextView = (XTextView) view;
        }
    }
}
