package com.autonavi.gbl.layer;

import android.util.Log;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.layer.impl.IBizUserControl;
import com.autonavi.gbl.layer.model.BizPointBusinessInfo;
import com.autonavi.gbl.layer.model.BizUserFavoritePoint;
import com.autonavi.gbl.layer.model.BizUserType;
import com.autonavi.gbl.layer.model.ColorSpeedPair;
import com.autonavi.gbl.layer.model.RainbowLinePoint;
import com.autonavi.gbl.map.layer.BaseLayer;
import com.autonavi.gbl.map.layer.impl.BaseLayerImpl;
import com.autonavi.gbl.user.usertrack.model.GpsTrackDepthInfo;
import com.autonavi.gbl.util.model.ErrorCode;
import java.lang.reflect.Method;
import java.util.ArrayList;
@IntfAuto(target = IBizUserControl.class, type = BuildType.JCTRL)
/* loaded from: classes.dex */
public class BizUserControl extends BizControl {
    private static String PACKAGE = ReflexTool.PN(BizUserControl.class);
    private IBizUserControl mControl;
    private boolean mHasDestroy;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected BizUserControl(long j, boolean z) {
        this(new IBizUserControl(j, z));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(BizUserControl.class, this, this.mControl);
        }
    }

    public BizUserControl(IBizUserControl iBizUserControl) {
        super(iBizUserControl);
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mHasDestroy = false;
        this.mControl = null;
        $constructor(iBizUserControl);
    }

    private void $constructor(IBizUserControl iBizUserControl) {
        if (iBizUserControl != null) {
            this.mControl = iBizUserControl;
            this.mTargetId = String.format("BizUserControl_%s_%d", String.valueOf(IBizUserControl.getCPtr(this.mControl)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.layer.BizControl
    public IBizUserControl getControl() {
        return this.mControl;
    }

    public void updateGpsTrack(GpsTrackDepthInfo gpsTrackDepthInfo) {
        IBizUserControl iBizUserControl = this.mControl;
        if (iBizUserControl != null) {
            iBizUserControl.updateGpsTrack(gpsTrackDepthInfo);
        }
    }

    public void updateSendToCar(BizPointBusinessInfo bizPointBusinessInfo, int i, int i2) {
        IBizUserControl iBizUserControl = this.mControl;
        if (iBizUserControl != null) {
            iBizUserControl.updateSendToCar(bizPointBusinessInfo, i, i2);
        }
    }

    public void updateFavoriteMain(ArrayList<BizUserFavoritePoint> arrayList) {
        IBizUserControl iBizUserControl = this.mControl;
        if (iBizUserControl != null) {
            iBizUserControl.updateFavoriteMain(arrayList);
        }
    }

    public void updateFavoritePoi(BizUserFavoritePoint bizUserFavoritePoint) {
        IBizUserControl iBizUserControl = this.mControl;
        if (iBizUserControl != null) {
            iBizUserControl.updateFavoritePoi(bizUserFavoritePoint);
        }
    }

    public BaseLayer getUserLayer(@BizUserType.BizUserType1 int i) {
        BaseLayerImpl userLayer;
        try {
            Method method = BizUserControl.class.getMethod("getUserLayer", Integer.TYPE);
            IBizUserControl iBizUserControl = this.mControl;
            if (iBizUserControl != null && (userLayer = iBizUserControl.getUserLayer(i)) != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r0 = typeHelper != null ? (BaseLayer) typeHelper.transfer(method, -1, (Object) userLayer, true) : null;
                if (r0 == null) {
                    DebugTool.e("%s: $ret == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.BizUserControl.1
                    }));
                }
            }
            return r0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    @ErrorCode.ErrorCode1
    public int updateRainbowLine(ArrayList<ColorSpeedPair> arrayList, ArrayList<RainbowLinePoint> arrayList2) {
        IBizUserControl iBizUserControl = this.mControl;
        if (iBizUserControl != null) {
            return iBizUserControl.updateRainbowLine(arrayList, arrayList2);
        }
        return Integer.MIN_VALUE;
    }

    public boolean setFavoriteScale(@BizUserType.BizUserType1 int i, float[] fArr) {
        if (fArr != null && fArr.length == 0) {
            fArr = null;
        }
        IBizUserControl iBizUserControl = this.mControl;
        if (iBizUserControl != null) {
            return iBizUserControl.setFavoriteScale(i, fArr);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.layer.BizControl
    public void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.BizUserControl.2
        });
        objArr[1] = String.valueOf(this.mTypeHelper != null);
        DebugTool.d("%s: mTypeHelper=%s", objArr);
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mTypeHelper = null;
        }
        super.unbind();
    }

    @Override // com.autonavi.gbl.layer.BizControl
    public void onDestroy() {
        this.mHasDestroy = true;
        clean();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.layer.BizControl
    public void clean() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.BizUserControl.3
        }));
        super.clean();
    }

    @Override // com.autonavi.gbl.layer.BizControl
    protected synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.BizUserControl.4
        }));
        if (!this.mHasDestroy) {
            onDestroy();
        }
        if (this.mTypeHelper != null) {
            TypeHelper typeHelper = this.mTypeHelper;
            TypeHelper.unbindAllTarget(PACKAGE, this);
        }
        if (this.mControl != null) {
            this.mControl = null;
        }
        unbind();
    }
}
