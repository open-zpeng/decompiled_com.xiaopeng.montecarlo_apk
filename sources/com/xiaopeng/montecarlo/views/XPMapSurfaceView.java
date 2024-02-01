package com.xiaopeng.montecarlo.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import com.autonavi.gbl.map.adapter.MapSurfaceView;
import com.xiaopeng.montecarlo.util.ThemeWatcherUtil;
/* loaded from: classes3.dex */
public class XPMapSurfaceView extends MapSurfaceView {
    private int mEngineId;
    private float mLastX;
    private float mLastY;

    public XPMapSurfaceView(Context context) {
        super(context);
        this.mEngineId = 1;
    }

    public XPMapSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mEngineId = 1;
    }

    public int getEngineId() {
        return this.mEngineId;
    }

    public void setEngineId(int i) {
        this.mEngineId = i;
    }

    @Override // com.autonavi.gbl.map.adapter.MapSurfaceView, android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        setInitColor();
        super.surfaceCreated(surfaceHolder);
    }

    private void setInitColor() {
        int mapModeByCurrentTheme = ThemeWatcherUtil.getMapModeByCurrentTheme();
        if (mapModeByCurrentTheme == 1) {
            getGLSurfaceAttribute().initColor = -16777216;
        } else if (mapModeByCurrentTheme == 0) {
            getGLSurfaceAttribute().initColor = -1;
        }
    }
}
