package com.xiaopeng.montecarlo.views.camera;

import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.TypefaceSpan;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.util.ThemeWatcherUtil;
import com.xiaopeng.xui.widget.XTextView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class DefaultCameraAdapter implements ICameraAdapter {
    private static final L.Tag TAG = new L.Tag("DefaultCameraAdapter");
    CameraSimpleViewContainer mCameraSimpleViewContainer;
    int mChildWidth;
    protected int mMaxItemViewCount;
    protected List<ViewHolder> mItemViewList = new ArrayList();
    protected List<ICameraData> mDataList = new ArrayList();
    Typeface mUnitTypeface = Typeface.create(ContextUtils.getString(R.string.xp_font_medium), 0);
    Typeface mNumberTypeface = Typeface.create(ContextUtils.getString(R.string.xp_font_number), 0);
    int mNumberTextSize = ContextUtils.getContext().getResources().getDimensionPixelOffset(R.dimen.camera_panel_number_text_size);
    int mUnitTextSize = ContextUtils.getContext().getResources().getDimensionPixelOffset(R.dimen.camera_panel_unit_text_size);
    String mUnitString = ContextUtils.getString(R.string.camera_unit_text);

    public DefaultCameraAdapter(CameraSimpleViewContainer cameraSimpleViewContainer, int i, int i2) {
        this.mMaxItemViewCount = 0;
        this.mCameraSimpleViewContainer = cameraSimpleViewContainer;
        this.mMaxItemViewCount = i;
        this.mChildWidth = i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SpannableString getRemainDistanceWithUnit(int i) {
        SpannableString spannableString = new SpannableString(i + this.mUnitString);
        spannableString.setSpan(new AbsoluteSizeSpan(this.mNumberTextSize), 0, spannableString.length() + (-1), 17);
        spannableString.setSpan(new TypefaceSpan(this.mNumberTypeface), 0, spannableString.length() + (-1), 17);
        return spannableString;
    }

    @Override // com.xiaopeng.montecarlo.views.camera.ICameraAdapter
    public void renderDayNightTheme() {
        for (ViewHolder viewHolder : this.mItemViewList) {
            viewHolder.getItemView().setTextColor(ThemeWatcherUtil.getColor(R.color.primary_text01));
        }
    }

    @Override // com.xiaopeng.montecarlo.views.camera.ICameraAdapter
    public void setData(List<ICameraData> list) {
        this.mDataList = list;
        refreshViews();
    }

    private void refreshViews() {
        int dataCount = getDataCount();
        if (dataCount > this.mMaxItemViewCount) {
            L.e(TAG, "refreshViews data size too large!");
            return;
        }
        int size = dataCount - this.mItemViewList.size();
        for (int i = 0; i < size; i++) {
            this.mItemViewList.add(new ViewHolder());
        }
        int size2 = this.mItemViewList.size();
        for (int i2 = 0; i2 < size2; i2++) {
            ViewHolder viewHolder = this.mItemViewList.get(i2);
            if (i2 < dataCount) {
                viewHolder.bindCameraItemView(this.mDataList.get(i2));
                viewHolder.getItemView().setVisibility(0);
            } else {
                viewHolder.getItemView().setVisibility(8);
            }
        }
    }

    @Override // com.xiaopeng.montecarlo.views.camera.ICameraAdapter
    public int getDataCount() {
        List<ICameraData> list = this.mDataList;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class ViewHolder {
        ICameraData mCameraData;
        LayerDrawable mCameraDrawableLayer = (LayerDrawable) ThemeWatcherUtil.getDrawable(R.drawable.level_bg_vector_ic_mid_camera);
        XTextView mTextView = createCameraItemView();

        ViewHolder() {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(DefaultCameraAdapter.this.mChildWidth, -2);
            layoutParams.gravity = 17;
            DefaultCameraAdapter.this.mCameraSimpleViewContainer.addView(this.mTextView, layoutParams);
        }

        protected XTextView getItemView() {
            return this.mTextView;
        }

        private XTextView createCameraItemView() {
            XTextView xTextView = new XTextView(DefaultCameraAdapter.this.mCameraSimpleViewContainer.getContext());
            xTextView.setWidth(ContextUtils.getContext().getResources().getDimensionPixelOffset(R.dimen.camera_panel_width));
            xTextView.setCompoundDrawablePadding(ContextUtils.getContext().getResources().getDimensionPixelOffset(R.dimen.camera_panel_padding));
            xTextView.setTextColor(ThemeWatcherUtil.getColor(R.color.primary_text01));
            xTextView.setGravity(17);
            xTextView.setTextSize(DefaultCameraAdapter.this.mUnitTextSize);
            xTextView.setTypeface(DefaultCameraAdapter.this.mUnitTypeface);
            return xTextView;
        }

        protected void bindCameraItemView(ICameraData iCameraData) {
            ICameraData iCameraData2 = this.mCameraData;
            if (iCameraData2 != null) {
                if (iCameraData2.getRemainDistance() != iCameraData.getRemainDistance()) {
                    this.mTextView.setText(DefaultCameraAdapter.this.getRemainDistanceWithUnit(iCameraData.getRemainDistance()));
                }
                if (!this.mCameraData.hasSameDrawableWith(iCameraData)) {
                    this.mTextView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, createTopDrawable(iCameraData.getCameraDrawable()), (Drawable) null, (Drawable) null);
                }
            } else {
                this.mTextView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, createTopDrawable(iCameraData.getCameraDrawable()), (Drawable) null, (Drawable) null);
                this.mTextView.setText(DefaultCameraAdapter.this.getRemainDistanceWithUnit(iCameraData.getRemainDistance()));
            }
            this.mCameraData = iCameraData;
        }

        private Drawable createTopDrawable(@NonNull Drawable drawable) {
            this.mCameraDrawableLayer.setDrawableByLayerId(R.id.camera_icon, drawable);
            return this.mCameraDrawableLayer;
        }
    }
}
