package com.xiaopeng.montecarlo.views;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.util.ThemeWatcherUtil;
import com.xiaopeng.xui.widget.XImageView;
import com.xiaopeng.xui.widget.XLinearLayout;
import com.xiaopeng.xui.widget.XTextView;
/* loaded from: classes3.dex */
public class ImageTextView extends XLinearLayout {
    private Context mContext;
    private XImageView mIcon;
    private View mLayoutView;
    private XTextView mText;

    public ImageTextView(Context context) {
        this(context, null);
    }

    public ImageTextView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ImageTextView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ImageTextView, i, 0);
        if (obtainStyledAttributes != null) {
            try {
                try {
                    setBackground(obtainStyledAttributes.getResourceId(1, R.drawable.selector_bg_image_text_view));
                    int resourceId = obtainStyledAttributes.getResourceId(0, 0);
                    if (resourceId != 0) {
                        setIcon(ThemeWatcherUtil.getDrawable(resourceId));
                    }
                    setTextColor(obtainStyledAttributes.getColor(3, ThemeWatcherUtil.getColor(R.color.color_guide_add_point_way_text)));
                    int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(4, 0);
                    if (dimensionPixelSize != 0) {
                        setTextSize(dimensionPixelSize);
                    }
                    setText(obtainStyledAttributes.getString(2));
                    int resourceId2 = obtainStyledAttributes.getResourceId(5, 0);
                    if (resourceId2 > 0) {
                        setTextStyle(resourceId2);
                    }
                } finally {
                    obtainStyledAttributes.recycle();
                }
            } catch (Resources.NotFoundException | UnsupportedOperationException e) {
                e.printStackTrace();
            }
        }
    }

    private void setTextStyle(int i) {
        this.mText.setTextAppearance(i);
        int colorResId = ThemeWatcherUtil.getColorResId(getTextColorResId(this.mContext, i));
        if (colorResId != 0) {
            this.mText.setTextColor(ContextUtils.getColor(colorResId));
        }
    }

    private int getTextColorResId(Context context, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i, new int[]{16842904});
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        obtainStyledAttributes.recycle();
        return resourceId;
    }

    public void setBackground(int i) {
        this.mLayoutView.setBackground(i != -1 ? ThemeWatcherUtil.getDrawable(i) : null);
    }

    public void setIcon(int i) {
        XImageView xImageView = this.mIcon;
        if (xImageView != null) {
            xImageView.setImageResource(i);
        }
    }

    public void setIcon(Drawable drawable) {
        XImageView xImageView = this.mIcon;
        if (xImageView != null) {
            xImageView.setImageDrawable(drawable);
        }
    }

    public void setText(String str) {
        XTextView xTextView = this.mText;
        if (xTextView != null) {
            xTextView.setText(str);
        }
    }

    public void setTextColor(int i) {
        XTextView xTextView = this.mText;
        if (xTextView != null) {
            xTextView.setTextColor(i);
        }
    }

    public void setTextColor(ColorStateList colorStateList) {
        XTextView xTextView = this.mText;
        if (xTextView != null) {
            xTextView.setTextColor(colorStateList);
        }
    }

    public void setTextSize(int i) {
        XTextView xTextView = this.mText;
        if (xTextView != null) {
            xTextView.setTextSize(0, i);
        }
    }

    private void init(Context context) {
        this.mContext = context;
        this.mLayoutView = LayoutInflater.from(this.mContext).inflate(R.layout.image_text_view_layout, (ViewGroup) this, true);
        this.mIcon = (XImageView) this.mLayoutView.findViewById(R.id.image_text_view_icon);
        this.mText = (XTextView) this.mLayoutView.findViewById(R.id.image_text_view_text);
        setGravity(17);
        setOrientation(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.xui.widget.XLinearLayout, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mContext = null;
    }
}
