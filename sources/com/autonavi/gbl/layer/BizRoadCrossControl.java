package com.autonavi.gbl.layer;

import android.util.Log;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.guide.model.CrossType;
import com.autonavi.gbl.guide.model.NaviInfo;
import com.autonavi.gbl.layer.impl.IBizRoadCrossControl;
import com.autonavi.gbl.map.layer.model.LayerTexture;
import com.autonavi.gbl.map.layer.model.RealCityTmcParam;
import com.autonavi.gbl.map.layer.model.VectorCrossViewPostureEvent;
import com.autonavi.gbl.map.layer.observer.IPrepareLayerStyle;
import com.autonavi.gbl.map.layer.observer.impl.IPrepareLayerStyleImpl;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
@IntfAuto(target = IBizRoadCrossControl.class, type = BuildType.JCTRL)
/* loaded from: classes.dex */
public class BizRoadCrossControl {
    private static String PACKAGE = ReflexTool.PN(BizRoadCrossControl.class);
    private IBizRoadCrossControl mControl;
    private boolean mHasDestroy;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected BizRoadCrossControl(long j, boolean z) {
        this(new IBizRoadCrossControl(j, z));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(BizRoadCrossControl.class, this, this.mControl);
        }
    }

    public BizRoadCrossControl(IBizRoadCrossControl iBizRoadCrossControl) {
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mHasDestroy = false;
        this.mControl = null;
        $constructor(iBizRoadCrossControl);
    }

    private void $constructor(IBizRoadCrossControl iBizRoadCrossControl) {
        if (iBizRoadCrossControl != null) {
            this.mControl = iBizRoadCrossControl;
            this.mTargetId = String.format("BizRoadCrossControl_%s_%d", String.valueOf(IBizRoadCrossControl.getCPtr(this.mControl)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    protected IBizRoadCrossControl getControl() {
        return this.mControl;
    }

    public boolean matchBizControl(long j) {
        IBizRoadCrossControl iBizRoadCrossControl = this.mControl;
        if (iBizRoadCrossControl != null) {
            return iBizRoadCrossControl.matchBizControl(j);
        }
        return false;
    }

    public void setStyle(IPrepareLayerStyle iPrepareLayerStyle) {
        HashSet hashSet;
        try {
            Method method = BizRoadCrossControl.class.getMethod("setStyle", IPrepareLayerStyle.class);
            TypeHelper typeHelper = this.mTypeHelper;
            if (typeHelper != null) {
                hashSet = (HashSet) typeHelper.getBindSet(method, 0);
            } else {
                hashSet = new HashSet();
            }
            hashSet.remove(iPrepareLayerStyle);
            if (iPrepareLayerStyle != null) {
                TypeHelper typeHelper2 = this.mTypeHelper;
                r3 = typeHelper2 != null ? (IPrepareLayerStyleImpl) typeHelper2.transfer(method, 0, iPrepareLayerStyle) : null;
                if (r3 == null) {
                    DebugTool.e("%s: $pStyle == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.BizRoadCrossControl.1
                    }));
                }
            }
            IBizRoadCrossControl iBizRoadCrossControl = this.mControl;
            if (iBizRoadCrossControl != null) {
                iBizRoadCrossControl.setStyle(r3);
                TypeHelper typeHelper3 = this.mTypeHelper;
                if (typeHelper3 != null) {
                    typeHelper3.unbindSet(method, 0, hashSet);
                }
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public void updateStyle(@CrossType.CrossType1 int i) {
        IBizRoadCrossControl iBizRoadCrossControl = this.mControl;
        if (iBizRoadCrossControl != null) {
            iBizRoadCrossControl.updateStyle(i);
        }
    }

    public void setRasterImageArrowColor(boolean z, int i) {
        IBizRoadCrossControl iBizRoadCrossControl = this.mControl;
        if (iBizRoadCrossControl != null) {
            iBizRoadCrossControl.setRasterImageArrowColor(z, i);
        }
    }

    public boolean setRasterImageData(LayerTexture layerTexture, LayerTexture layerTexture2) {
        IBizRoadCrossControl iBizRoadCrossControl = this.mControl;
        if (iBizRoadCrossControl != null) {
            return iBizRoadCrossControl.setRasterImageData(layerTexture, layerTexture2);
        }
        return false;
    }

    public boolean updateCross(byte[] bArr, @CrossType.CrossType1 int i) {
        if (bArr != null && bArr.length == 0) {
            bArr = null;
        }
        IBizRoadCrossControl iBizRoadCrossControl = this.mControl;
        if (iBizRoadCrossControl != null) {
            return iBizRoadCrossControl.updateCross(bArr, i);
        }
        return false;
    }

    public void hideCross(@CrossType.CrossType1 int i) {
        IBizRoadCrossControl iBizRoadCrossControl = this.mControl;
        if (iBizRoadCrossControl != null) {
            iBizRoadCrossControl.hideCross(i);
        }
    }

    public void set3DCrossCarMode(boolean z) {
        IBizRoadCrossControl iBizRoadCrossControl = this.mControl;
        if (iBizRoadCrossControl != null) {
            iBizRoadCrossControl.set3DCrossCarMode(z);
        }
    }

    public boolean setFlyTmc(byte[] bArr, ArrayList<RealCityTmcParam> arrayList) {
        if (bArr != null && bArr.length == 0) {
            bArr = null;
        }
        IBizRoadCrossControl iBizRoadCrossControl = this.mControl;
        if (iBizRoadCrossControl != null) {
            return iBizRoadCrossControl.setFlyTmc(bArr, arrayList);
        }
        return false;
    }

    public void updateNaviInfo(NaviInfo naviInfo) {
        IBizRoadCrossControl iBizRoadCrossControl = this.mControl;
        if (iBizRoadCrossControl != null) {
            iBizRoadCrossControl.updateNaviInfo(naviInfo);
        }
    }

    public void setVisible(@CrossType.CrossType1 int i, boolean z) {
        IBizRoadCrossControl iBizRoadCrossControl = this.mControl;
        if (iBizRoadCrossControl != null) {
            iBizRoadCrossControl.setVisible(i, z);
        }
    }

    public void setViewPostureEvent(@CrossType.CrossType1 int i, @VectorCrossViewPostureEvent.VectorCrossViewPostureEvent1 int i2) {
        IBizRoadCrossControl iBizRoadCrossControl = this.mControl;
        if (iBizRoadCrossControl != null) {
            iBizRoadCrossControl.setViewPostureEvent(i, i2);
        }
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.BizRoadCrossControl.2
        });
        objArr[1] = String.valueOf(this.mTypeHelper != null);
        DebugTool.d("%s: mTypeHelper=%s", objArr);
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mTypeHelper = null;
        }
    }

    public void onDestroy() {
        this.mHasDestroy = true;
        clean();
    }

    protected void clean() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.BizRoadCrossControl.3
        }));
    }

    protected synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.BizRoadCrossControl.4
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
