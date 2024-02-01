package com.autonavi.gbl.layer;

import android.util.Log;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.layer.impl.IBizUserControlImpl;
import com.autonavi.gbl.layer.model.BizPointBusinessInfo;
import com.autonavi.gbl.layer.model.BizUserFavoritePoint;
import com.autonavi.gbl.layer.model.BizUserType;
import com.autonavi.gbl.layer.model.ColorSpeedPair;
import com.autonavi.gbl.layer.model.RainbowLinePoint;
import com.autonavi.gbl.map.layer.BaseLayer;
import com.autonavi.gbl.map.layer.impl.BaseLayerImpl;
import com.autonavi.gbl.user.usertrack.model.GpsTrackDepthInfo;
import java.lang.reflect.Method;
import java.util.ArrayList;
@IntfAuto(target = IBizUserControlImpl.class, type = BuildType.JCTRL)
/* loaded from: classes.dex */
public class BizUserControl extends BizControl {
    private static String PACKAGE = ReflexTool.PN(BizUserControl.class);
    private IBizUserControlImpl mControl;
    private boolean mHasDestroy;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected BizUserControl(long j, boolean z) {
        this(new IBizUserControlImpl(j, z));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(BizUserControl.class, this, this.mControl);
        }
    }

    public BizUserControl(IBizUserControlImpl iBizUserControlImpl) {
        super(iBizUserControlImpl);
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mHasDestroy = false;
        this.mControl = null;
        $constructor(iBizUserControlImpl);
    }

    private void $constructor(IBizUserControlImpl iBizUserControlImpl) {
        if (iBizUserControlImpl != null) {
            this.mControl = iBizUserControlImpl;
            this.mTargetId = String.format("BizUserControl_%s_%d", String.valueOf(IBizUserControlImpl.getCPtr(this.mControl)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.layer.BizControl
    public IBizUserControlImpl getControl() {
        return this.mControl;
    }

    public void updateGpsTrack(GpsTrackDepthInfo gpsTrackDepthInfo) {
        IBizUserControlImpl iBizUserControlImpl = this.mControl;
        if (iBizUserControlImpl != null) {
            iBizUserControlImpl.updateGpsTrack(gpsTrackDepthInfo);
        }
    }

    public void updateSendToCar(BizPointBusinessInfo bizPointBusinessInfo, int i, int i2) {
        IBizUserControlImpl iBizUserControlImpl = this.mControl;
        if (iBizUserControlImpl != null) {
            iBizUserControlImpl.updateSendToCar(bizPointBusinessInfo, i, i2);
        }
    }

    public void updateFavoriteMain(ArrayList<BizUserFavoritePoint> arrayList) {
        IBizUserControlImpl iBizUserControlImpl = this.mControl;
        if (iBizUserControlImpl != null) {
            iBizUserControlImpl.updateFavoriteMain(arrayList);
        }
    }

    public void updateFavoritePoi(BizUserFavoritePoint bizUserFavoritePoint) {
        IBizUserControlImpl iBizUserControlImpl = this.mControl;
        if (iBizUserControlImpl != null) {
            iBizUserControlImpl.updateFavoritePoi(bizUserFavoritePoint);
        }
    }

    public BaseLayer getUserLayer(@BizUserType.BizUserType1 int i) {
        BaseLayerImpl userLayer;
        TypeHelper typeHelper;
        try {
            Method method = BizUserControl.class.getMethod("getUserLayer", Integer.TYPE);
            IBizUserControlImpl iBizUserControlImpl = this.mControl;
            if (iBizUserControlImpl == null || (userLayer = iBizUserControlImpl.getUserLayer(i)) == null || (typeHelper = this.mTypeHelper) == null) {
                return null;
            }
            return (BaseLayer) typeHelper.transfer(method, -1, (Object) userLayer, true);
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public int updateRainbowLine(ArrayList<ColorSpeedPair> arrayList, ArrayList<RainbowLinePoint> arrayList2) {
        IBizUserControlImpl iBizUserControlImpl = this.mControl;
        if (iBizUserControlImpl != null) {
            return iBizUserControlImpl.updateRainbowLine(arrayList, arrayList2);
        }
        return Integer.MIN_VALUE;
    }

    public boolean setFavoriteScale(@BizUserType.BizUserType1 int i, float[] fArr) {
        if (fArr != null && fArr.length == 0) {
            fArr = null;
        }
        IBizUserControlImpl iBizUserControlImpl = this.mControl;
        if (iBizUserControlImpl != null) {
            return iBizUserControlImpl.setFavoriteScale(i, fArr);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.layer.BizControl
    public void unbind() {
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
        super.clean();
    }

    @Override // com.autonavi.gbl.layer.BizControl
    protected synchronized void delete() {
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
