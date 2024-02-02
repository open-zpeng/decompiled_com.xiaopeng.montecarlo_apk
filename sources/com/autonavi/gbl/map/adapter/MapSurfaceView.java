package com.autonavi.gbl.map.adapter;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.autonavi.gbl.map.MapDevice;
import com.autonavi.gbl.map.MapService;
import com.autonavi.gbl.map.MapView;
import com.autonavi.gbl.map.OperatorGesture;
import com.autonavi.gbl.map.adapter.NetworkState;
import com.autonavi.gbl.map.model.EGLSurfaceAttr;
/* loaded from: classes.dex */
public class MapSurfaceView extends SurfaceView implements SurfaceHolder.Callback, NetworkState.NetworkChangeListener {
    private Context mContext;
    private MapDevice mDefaultDevice;
    private MapService mMapService;
    private MapView mMapView;
    private NetworkState mNetworkState;
    private EGLSurfaceAttr mSurfaceAttribute;

    public MapService getMapService() {
        return this.mMapService;
    }

    public void setMapService(MapService mapService) {
        this.mMapService = mapService;
    }

    public void setDefaultDevice(MapDevice mapDevice) {
        this.mDefaultDevice = mapDevice;
    }

    public void setDefaultMapView(MapView mapView) {
        this.mMapView = mapView;
    }

    public MapDevice getDefaultDevice() {
        return this.mDefaultDevice;
    }

    private void initNetworkState() {
        if (this.mNetworkState == null) {
            this.mNetworkState = new NetworkState();
        }
        NetworkState networkState = this.mNetworkState;
        if (networkState != null) {
            networkState.setNetworkListener(this);
            this.mNetworkState.registerNetChangeReceiver(this.mContext.getApplicationContext(), true);
            boolean isNetworkConnected = NetworkState.isNetworkConnected(this.mContext.getApplicationContext());
            MapService mapService = this.mMapService;
            if (mapService != null) {
                mapService.setNetworkType(isNetworkConnected ? 2 : 1);
            }
        }
    }

    private void uninitNetworkState() {
        NetworkState networkState = this.mNetworkState;
        if (networkState != null) {
            networkState.registerNetChangeReceiver(this.mContext.getApplicationContext(), false);
        }
    }

    @Override // com.autonavi.gbl.map.adapter.NetworkState.NetworkChangeListener
    public void networkStateChanged(Context context) {
        if (this.mMapService != null) {
            boolean isNetworkConnected = NetworkState.isNetworkConnected(context);
            MapService mapService = this.mMapService;
            if (mapService != null) {
                mapService.setNetworkType(isNetworkConnected ? 2 : 1);
            }
            MapDevice mapDevice = this.mDefaultDevice;
            if (mapDevice != null) {
                mapDevice.resetTickCount(6);
            }
        }
    }

    public MapSurfaceView(Context context) {
        super(context);
        this.mMapService = null;
        this.mDefaultDevice = null;
        this.mMapView = null;
        this.mNetworkState = null;
        this.mSurfaceAttribute = new EGLSurfaceAttr();
        this.mContext = context;
        getHolder().addCallback(this);
    }

    public MapSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMapService = null;
        this.mDefaultDevice = null;
        this.mMapView = null;
        this.mNetworkState = null;
        this.mSurfaceAttribute = new EGLSurfaceAttr();
        this.mContext = context;
        getHolder().addCallback(this);
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        MapDevice mapDevice = this.mDefaultDevice;
        if (mapDevice != null) {
            mapDevice.detachSurfaceFromDevice();
            EGLSurfaceAttr eGLSurfaceAttr = new EGLSurfaceAttr();
            eGLSurfaceAttr.display = -1L;
            eGLSurfaceAttr.nativeWindow = this.mDefaultDevice.getWindowFromSurface(surfaceHolder.getSurface());
            eGLSurfaceAttr.width = getWidth();
            eGLSurfaceAttr.height = getHeight();
            eGLSurfaceAttr.shareDeviceID = -1;
            eGLSurfaceAttr.isBackSurface = false;
            eGLSurfaceAttr.isNeedInitDraw = true;
            eGLSurfaceAttr.isOnlyCreatePBSurface = false;
            eGLSurfaceAttr.initColor = this.mSurfaceAttribute.initColor;
            eGLSurfaceAttr.isNativeWindowFromSurface = true;
            this.mDefaultDevice.attachSurfaceToDevice(eGLSurfaceAttr);
            initNetworkState();
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        if (this.mDefaultDevice != null) {
            EGLSurfaceAttr eGLSurfaceAttr = new EGLSurfaceAttr();
            eGLSurfaceAttr.display = -1L;
            eGLSurfaceAttr.nativeWindow = -1L;
            eGLSurfaceAttr.width = i2;
            eGLSurfaceAttr.height = i3;
            eGLSurfaceAttr.shareDeviceID = -1;
            eGLSurfaceAttr.isBackSurface = false;
            eGLSurfaceAttr.isNeedInitDraw = true;
            eGLSurfaceAttr.isOnlyCreatePBSurface = false;
            eGLSurfaceAttr.initColor = this.mSurfaceAttribute.initColor;
            eGLSurfaceAttr.isNativeWindowFromSurface = true;
            this.mDefaultDevice.changeDeviceSize(eGLSurfaceAttr);
        }
    }

    public EGLSurfaceAttr getGLSurfaceAttribute() {
        return this.mSurfaceAttribute;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        if (this.mDefaultDevice != null) {
            uninitNetworkState();
            this.mDefaultDevice.detachSurfaceFromDevice();
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
    }

    public void addView(int i, View view, FrameLayout.LayoutParams layoutParams) {
        if (view == null || layoutParams == null) {
            return;
        }
        ((ViewGroup) getParent()).addView(view, layoutParams);
    }

    public void removeView(int i, View view) {
        if (view == null) {
            return;
        }
        ((ViewGroup) getParent()).removeView(view);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        OperatorGesture operatorGesture;
        MapView mapView = this.mMapView;
        if (mapView == null || (operatorGesture = mapView.getOperatorGesture()) == null) {
            return false;
        }
        operatorGesture.addTouchEvent(MapHelper.getMotionEventHelper().translateMotionEvent(motionEvent));
        return true;
    }
}
