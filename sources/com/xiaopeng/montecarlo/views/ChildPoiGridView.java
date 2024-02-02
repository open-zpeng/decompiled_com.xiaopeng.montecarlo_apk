package com.xiaopeng.montecarlo.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.util.ThemeWatcherUtil;
import com.xiaopeng.montecarlo.util.Utils;
import com.xiaopeng.xui.widget.XImageButton;
import com.xiaopeng.xui.widget.XLinearLayout;
import com.xiaopeng.xui.widget.XTextView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class ChildPoiGridView extends XLinearLayout {
    public static final int FULL_SCREEN_MAX_COLUMN = 4;
    public static final int FULL_SCREEN_MAX_ROWS = 5;
    private static final L.Tag TAG = new L.Tag("ChildPoiGridView");
    private ChildViewClickListener mChildViewClickListener;
    private int mColumnWidth;
    private boolean mCurrentExpand;
    private boolean mDefaultExpand;
    private XImageButton mIvExpand;
    private int mMaxColumn;
    private List<View> mRows;
    private List<XTextView> mSubButtons;
    private boolean mSupportExpand;
    private int mTotalChild;

    /* loaded from: classes3.dex */
    public interface ChildViewClickListener {
        void onChildClick(View view, XPPoiInfo xPPoiInfo);

        void onExpandViewClick(boolean z);
    }

    public List<XTextView> getSubButtons() {
        return this.mSubButtons;
    }

    public XImageButton getIvExpand() {
        return this.mIvExpand;
    }

    public List<View> getRows() {
        return this.mRows;
    }

    public ChildPoiGridView(Context context) {
        super(context);
        this.mMaxColumn = 4;
        this.mColumnWidth = 0;
        this.mTotalChild = 0;
        this.mSupportExpand = true;
        this.mDefaultExpand = false;
        this.mCurrentExpand = false;
        this.mRows = new ArrayList();
        this.mSubButtons = new ArrayList();
    }

    public ChildPoiGridView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMaxColumn = 4;
        this.mColumnWidth = 0;
        this.mTotalChild = 0;
        this.mSupportExpand = true;
        this.mDefaultExpand = false;
        this.mCurrentExpand = false;
        this.mRows = new ArrayList();
        this.mSubButtons = new ArrayList();
        init(context, attributeSet, -1);
    }

    public ChildPoiGridView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mMaxColumn = 4;
        this.mColumnWidth = 0;
        this.mTotalChild = 0;
        this.mSupportExpand = true;
        this.mDefaultExpand = false;
        this.mCurrentExpand = false;
        this.mRows = new ArrayList();
        this.mSubButtons = new ArrayList();
        init(context, attributeSet, i);
    }

    private void init(Context context, @Nullable AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.ChildPoiGridView, i, 0);
        if (obtainStyledAttributes != null) {
            this.mMaxColumn = obtainStyledAttributes.getInt(2, 4);
            this.mColumnWidth = obtainStyledAttributes.getDimensionPixelSize(0, ContextUtils.getDimensionPixelSize(R.dimen.poi_sub_child_width));
            this.mSupportExpand = obtainStyledAttributes.getBoolean(3, true);
            this.mDefaultExpand = obtainStyledAttributes.getBoolean(1, false);
            obtainStyledAttributes.recycle();
        }
    }

    public void addChildViews(int i, ArrayList<XPPoiInfo> arrayList) {
        int i2;
        resetStatus(i);
        if (this.mTotalChild == 0 || CollectionUtils.isEmpty(arrayList) || this.mTotalChild > arrayList.size()) {
            return;
        }
        int calculationRows = calculationRows(this.mTotalChild);
        for (int i3 = 0; i3 < calculationRows; i3++) {
            if (i3 == calculationRows - 1) {
                i2 = this.mTotalChild - (this.mMaxColumn * i3);
            } else {
                i2 = this.mMaxColumn;
            }
            addChildRowPois(this.mMaxColumn * i3, i2, arrayList);
        }
        updateStatus();
    }

    public void resetStatus(int i) {
        int i2 = this.mMaxColumn;
        if (i > i2 * 5) {
            i = i2 * 5;
        }
        this.mTotalChild = i;
        this.mRows.clear();
        this.mSubButtons.clear();
        this.mCurrentExpand = false;
        this.mIvExpand = null;
    }

    private void updateStatus() {
        XImageButton xImageButton;
        if (!this.mSupportExpand && (xImageButton = this.mIvExpand) != null) {
            xImageButton.setVisibility(8);
        }
        if (this.mDefaultExpand) {
            expand(true);
        }
    }

    private int calculationRows(int i) {
        int i2 = this.mMaxColumn;
        return (i / i2) + (i % i2 == 0 ? 0 : 1);
    }

    private void addChildRowPois(int i, int i2, ArrayList<XPPoiInfo> arrayList) {
        final XPPoiInfo xPPoiInfo;
        if (i2 > this.mMaxColumn) {
            return;
        }
        XLinearLayout xLinearLayout = (XLinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.layout_sub_poi_button_container, (ViewGroup) null);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, ContextUtils.getDimensionPixelSize(R.dimen.poi_sub_child_row_height));
        layoutParams.setMargins(0, ContextUtils.getDimensionPixelSize(R.dimen.poi_sub_child_row_top_bottom_margin), 0, ContextUtils.getDimensionPixelSize(R.dimen.poi_sub_child_row_top_bottom_margin));
        xLinearLayout.setLayoutParams(layoutParams);
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = i + i3;
            final XTextView xTextView = (XTextView) LayoutInflater.from(getContext()).inflate(R.layout.layout_sub_poi_button, (ViewGroup) null);
            XPPoiInfo xPPoiInfo2 = arrayList.get(i4);
            if (xPPoiInfo2 == null || TextUtils.isEmpty(xPPoiInfo2.getName())) {
                xPPoiInfo = xPPoiInfo2;
                xTextView.setText("");
            } else if (Utils.isPortrait()) {
                xTextView.setText(xPPoiInfo2.getName());
                xPPoiInfo = xPPoiInfo2;
            } else {
                xPPoiInfo = xPPoiInfo2;
                xTextView.setText(formatSubPoiName(xPPoiInfo2.getName(), 5, 3, 2, "..."));
            }
            xTextView.setTag(R.id.sup_poi_item, Integer.valueOf(i4));
            xTextView.setOnClickListener(new View.OnClickListener() { // from class: com.xiaopeng.montecarlo.views.ChildPoiGridView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (ChildPoiGridView.this.mChildViewClickListener != null) {
                        ChildPoiGridView.this.mChildViewClickListener.onChildClick(xTextView, xPPoiInfo);
                    }
                }
            });
            xTextView.setLayoutParams(new LinearLayout.LayoutParams(this.mColumnWidth, ContextUtils.getDimensionPixelSize(R.dimen.poi_sub_child_row_height)));
            xLinearLayout.addView(xTextView);
            int i5 = this.mMaxColumn;
            if (i3 < (i2 < i5 ? i2 - 1 : i5 - 1)) {
                addVerticalLineView(xLinearLayout);
            }
            this.mSubButtons.add(i4, xTextView);
        }
        if (this.mTotalChild <= this.mMaxColumn) {
            addView(xLinearLayout);
            this.mRows.add(xLinearLayout);
        } else if (i == 0) {
            LinearLayout linearLayout = new LinearLayout(getContext());
            linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            linearLayout.addView(xLinearLayout);
            this.mIvExpand = (XImageButton) LayoutInflater.from(getContext()).inflate(R.layout.layout_child_poi_grid_view_open, (ViewGroup) null);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(ContextUtils.getDimensionPixelSize(R.dimen.x_btn_icon_xsmall_bg_size), ContextUtils.getDimensionPixelSize(R.dimen.x_btn_icon_xsmall_bg_size));
            layoutParams2.setMargins(16, 9, 0, 0);
            this.mIvExpand.setLayoutParams(layoutParams2);
            linearLayout.addView(this.mIvExpand);
            this.mIvExpand.setOnClickListener(new View.OnClickListener() { // from class: com.xiaopeng.montecarlo.views.ChildPoiGridView.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    ChildPoiGridView childPoiGridView = ChildPoiGridView.this;
                    childPoiGridView.expand(!childPoiGridView.mCurrentExpand);
                    if (ChildPoiGridView.this.mChildViewClickListener != null) {
                        ChildPoiGridView.this.mChildViewClickListener.onExpandViewClick(ChildPoiGridView.this.mCurrentExpand);
                    }
                }
            });
            addView(linearLayout);
            this.mRows.add(linearLayout);
        } else {
            addView(xLinearLayout);
            xLinearLayout.setVisibility(8);
            this.mRows.add(xLinearLayout);
        }
    }

    private String formatSubPoiName(String str, int i, int i2, int i3, String str2) {
        StringBuilder sb = new StringBuilder();
        if (str.length() < i) {
            sb.append(str);
        } else {
            sb.append(str.substring(0, i2));
            sb.append(str2);
            sb.append(str.substring(str.length() - i3, str.length()));
        }
        return sb.toString();
    }

    private void addVerticalLineView(LinearLayout linearLayout) {
        LayoutInflater.from(getContext()).inflate(R.layout.layout_poi_right_line, linearLayout);
    }

    public void expand(boolean z) {
        this.mCurrentExpand = z;
        XImageButton xImageButton = this.mIvExpand;
        if (xImageButton != null) {
            xImageButton.setImageResource(ThemeWatcherUtil.getDrawableResId(z ? R.drawable.vector_ic_xsmall_upper : R.drawable.vector_ic_xsmall_lower));
        }
        if (CollectionUtils.isEmpty(this.mRows)) {
            return;
        }
        if (this.mRows.size() <= 1) {
            return;
        }
        for (int i = 1; i < this.mRows.size(); i++) {
            View view = this.mRows.get(i);
            if (view != null) {
                view.setVisibility(z ? 0 : 8);
            }
        }
    }

    public void setChildViewClickListener(ChildViewClickListener childViewClickListener) {
        this.mChildViewClickListener = childViewClickListener;
    }
}
