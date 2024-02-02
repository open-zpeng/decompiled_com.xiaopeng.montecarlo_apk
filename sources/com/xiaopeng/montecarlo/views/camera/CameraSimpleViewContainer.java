package com.xiaopeng.montecarlo.views.camera;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import butterknife.ButterKnife;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.XpThemeSwitchReceiver;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.scenes.cruisescene.util.ToggleShowCardConflictHelper;
import com.xiaopeng.montecarlo.util.ThemeWatcherUtil;
import com.xiaopeng.montecarlo.views.OnViewStateChangedListener;
import com.xiaopeng.xui.widget.XLinearLayout;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class CameraSimpleViewContainer extends XLinearLayout implements ToggleShowCardConflictHelper.IConflictControlView {
    public static final int MAX_SHOW_CAMERA_VIEW = 3;
    private static final L.Tag TAG = new L.Tag("CameraSimpleViewContainer");
    private boolean mCanShowByOther;
    private ICameraAdapter mICameraAdapter;
    private XpThemeSwitchReceiver.ThemeSwitchListener mThemeSwitchListener;
    private OnViewStateChangedListener mVisibilityChangeListener;

    @Override // com.xiaopeng.montecarlo.scenes.cruisescene.util.ToggleShowCardConflictHelper.IConflictControlView
    public ViewGroup getToggleView() {
        return this;
    }

    public CameraSimpleViewContainer(Context context) {
        this(context, null);
    }

    public CameraSimpleViewContainer(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public CameraSimpleViewContainer(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCanShowByOther = true;
        this.mThemeSwitchListener = new XpThemeSwitchReceiver.ThemeSwitchListener() { // from class: com.xiaopeng.montecarlo.views.camera.CameraSimpleViewContainer.1
            @Override // com.xiaopeng.montecarlo.XpThemeSwitchReceiver.ThemeSwitchListener
            public void onThemeSwitch(int i2) {
                CameraSimpleViewContainer.this.renderDayNightTheme();
            }
        };
        ButterKnife.bind(this);
        setVisibility(8);
        int dimensionPixelSize = ContextUtils.getDimensionPixelSize(R.dimen.camera_panel_width);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CameraSimpleViewContainer);
        int i2 = 0;
        if (obtainStyledAttributes != null) {
            try {
                try {
                    i2 = (int) obtainStyledAttributes.getDimension(0, dimensionPixelSize);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
        if (this.mICameraAdapter == null) {
            this.mICameraAdapter = new DefaultCameraAdapter(this, 3, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.xui.widget.XLinearLayout, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        renderDayNightTheme();
        ThemeWatcherUtil.addXpThemeSwitchListener(this.mThemeSwitchListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.xui.widget.XLinearLayout, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ThemeWatcherUtil.removeXpThemeListener(this.mThemeSwitchListener);
    }

    public void setOnVisibilityChangeListener(OnViewStateChangedListener onViewStateChangedListener) {
        this.mVisibilityChangeListener = onViewStateChangedListener;
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        OnViewStateChangedListener onViewStateChangedListener = this.mVisibilityChangeListener;
        if (onViewStateChangedListener != null) {
            onViewStateChangedListener.onVisibleStateChanged(this, this, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void renderDayNightTheme() {
        setDividerDrawable(ThemeWatcherUtil.getDrawable(R.drawable.vector_basicicon_simple_next));
        setBackground(ThemeWatcherUtil.getDrawable(R.drawable.shape_bg_camera_container_radius20));
        this.mICameraAdapter.renderDayNightTheme();
    }

    @MainThread
    public void notifyListChange(List<? extends ICameraData> list) {
        if (L.ENABLE) {
            L.d(TAG, "width" + getMeasuredWidth());
        }
        ArrayList arrayList = new ArrayList();
        if (CollectionUtils.isNotEmpty(list)) {
            for (int i = 0; i < list.size(); i++) {
                ICameraData iCameraData = list.get(i);
                if (iCameraData != null && iCameraData.getRemainDistance() > 0 && iCameraData.hasDrawable()) {
                    arrayList.add(iCameraData);
                    if (arrayList.size() >= 3) {
                        break;
                    }
                }
            }
        }
        this.mICameraAdapter.setData(arrayList);
        if (L.ENABLE) {
            L.d(TAG, "notifyListChange mCanShowByOther=" + this.mCanShowByOther);
        }
        if (!hasData() || !this.mCanShowByOther) {
            setVisibility(8);
        } else {
            setVisibility(0);
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.cruisescene.util.ToggleShowCardConflictHelper.IConflictControlView
    public boolean hasData() {
        return this.mICameraAdapter.getDataCount() > 0;
    }

    @Override // com.xiaopeng.montecarlo.scenes.cruisescene.util.ToggleShowCardConflictHelper.IConflictControlView
    public void setCanShowByOther(boolean z) {
        this.mCanShowByOther = z;
    }
}
