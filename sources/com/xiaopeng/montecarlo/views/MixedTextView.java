package com.xiaopeng.montecarlo.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.util.ThemeWatcherUtil;
import com.xiaopeng.xui.widget.XLinearLayout;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class MixedTextView extends XLinearLayout {
    private static final L.Tag TAG = new L.Tag("MixedTextView");
    private StringBuilder mBuilder;
    private Context mContext;
    private List<Integer> mStyleList;
    private List<Integer> mTextColorList;
    private TextView tv;

    public MixedTextView(Context context) {
        this(context, null);
    }

    public MixedTextView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public MixedTextView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        getTypeStyle(context, attributeSet);
    }

    private void addView(TextView textView, int i) {
        if (this.mStyleList.get(i).intValue() > 0) {
            textView.setTextAppearance(this.mStyleList.get(i).intValue());
            textView.setSelected(isSelected());
            addView(textView);
        }
        if (i > 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) textView.getLayoutParams();
            layoutParams.leftMargin = ContextUtils.getDimensionPixelSize(R.dimen.mixed_text_view_interval);
            textView.setLayoutParams(layoutParams);
        }
    }

    private int getTextColorResId(Context context, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i, new int[]{16842904});
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        obtainStyledAttributes.recycle();
        return resourceId;
    }

    public void updateTheme() {
        for (int i = 0; i < getChildCount(); i++) {
            if (L.ENABLE) {
                L.Tag tag = TAG;
                L.d(tag, "updateTheme mText1Color: " + this.mTextColorList.get(i) + ",index:" + i);
            }
            if (this.mTextColorList.get(i).intValue() > 0) {
                ((TextView) getChildAt(i)).setTextColor(getContext().getResources().getColorStateList(ThemeWatcherUtil.getColorResId(this.mTextColorList.get(i).intValue()), this.mContext.getTheme()));
            }
        }
    }

    public void setTextSize(int i, float f) {
        if (getChildAt(i) != null) {
            ((TextView) getChildAt(i)).setTextSize(f);
        }
    }

    public void setTextFont(int i, String str) {
        if (TextUtils.isEmpty(str) || getChildAt(i) == null) {
            return;
        }
        ((TextView) getChildAt(i)).setTypeface(Typeface.create(str, 0));
    }

    public void setTextColorResId(int i, int i2) {
        if (i2 > getChildCount() - 1 || i2 > this.mTextColorList.size() - 1) {
            return;
        }
        this.mTextColorList.set(i2, Integer.valueOf(i));
        if (getChildAt(i2) != null) {
            ((TextView) getChildAt(i2)).setTextColor(ThemeWatcherUtil.getColor(i));
        }
    }

    public void updateMixedText(List<String> list) {
        if (list == null || CollectionUtils.isEmpty(list)) {
            return;
        }
        this.mBuilder = new StringBuilder();
        if (list.size() > 4) {
            list = list.subList(0, 4);
        }
        for (int i = 0; i < getChildCount(); i++) {
            if (getChildAt(i) != null) {
                getChildAt(i).setVisibility(8);
            }
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            TextView textView = (TextView) getChildAt(i2);
            if (getChildAt(i2) == null) {
                textView = new TextView(this.mContext);
                addView(textView, i2);
            }
            if (!TextUtils.isEmpty(list.get(i2))) {
                if (textView.getVisibility() != 0) {
                    textView.setVisibility(0);
                }
                textView.setText(list.get(i2));
                this.mBuilder.append(list.get(i2));
            } else {
                textView.setVisibility(8);
            }
        }
    }

    public String getDisplayString() {
        StringBuilder sb = this.mBuilder;
        if (sb == null) {
            return null;
        }
        return sb.toString();
    }

    private void getTypeStyle(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.MixedTextView);
        try {
            if (obtainStyledAttributes != null) {
                try {
                    this.mStyleList = new ArrayList();
                    this.mTextColorList = new ArrayList();
                    this.mStyleList.add(Integer.valueOf(obtainStyledAttributes.getResourceId(1, 0)));
                    this.mStyleList.add(Integer.valueOf(obtainStyledAttributes.getResourceId(2, 0)));
                    this.mStyleList.add(Integer.valueOf(obtainStyledAttributes.getResourceId(3, 0)));
                    this.mStyleList.add(Integer.valueOf(obtainStyledAttributes.getResourceId(4, 0)));
                    this.mTextColorList.add(Integer.valueOf(getTextColorResId(context, obtainStyledAttributes.getResourceId(1, 0))));
                    this.mTextColorList.add(Integer.valueOf(getTextColorResId(context, obtainStyledAttributes.getResourceId(2, 0))));
                    this.mTextColorList.add(Integer.valueOf(getTextColorResId(context, obtainStyledAttributes.getResourceId(3, 0))));
                    this.mTextColorList.add(Integer.valueOf(getTextColorResId(context, obtainStyledAttributes.getResourceId(4, 0))));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public void updateChildViewLayoutParams(int i, LinearLayout.LayoutParams layoutParams) {
        TextView textView = (TextView) getChildAt(i);
        if (textView == null || layoutParams == null) {
            return;
        }
        textView.setLayoutParams(layoutParams);
    }

    public LinearLayout.LayoutParams getChildViewLayoutParams(int i) {
        if (getChildAt(i) != null) {
            return (LinearLayout.LayoutParams) getChildAt(i).getLayoutParams();
        }
        return null;
    }
}
