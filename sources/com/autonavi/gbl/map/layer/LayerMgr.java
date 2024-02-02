package com.autonavi.gbl.map.layer;

import android.util.Log;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.map.layer.impl.BaseLayerImpl;
import com.autonavi.gbl.map.layer.impl.LayerMgrImpl;
import com.autonavi.gbl.map.layer.model.ScaleInfo;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.util.ArrayList;
@IntfAuto(target = LayerMgrImpl.class, type = BuildType.JCTRL)
/* loaded from: classes.dex */
public class LayerMgr {
    private static String PACKAGE = ReflexTool.PN(LayerMgr.class);
    private LayerMgrImpl mControl;
    private boolean mHasDestroy;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected LayerMgr(long j, boolean z) {
        this(new LayerMgrImpl(j, z));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(LayerMgr.class, this, this.mControl);
        }
    }

    public LayerMgr(LayerMgrImpl layerMgrImpl) {
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mHasDestroy = false;
        this.mControl = null;
        $constructor(layerMgrImpl);
    }

    private void $constructor(LayerMgrImpl layerMgrImpl) {
        if (layerMgrImpl != null) {
            this.mControl = layerMgrImpl;
            this.mTargetId = String.format("LayerMgr_%s_%d", String.valueOf(LayerMgrImpl.getCPtr(this.mControl)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    protected LayerMgrImpl getControl() {
        return this.mControl;
    }

    public void addLayer(BaseLayer baseLayer) {
        try {
            Method method = LayerMgr.class.getMethod("addLayer", BaseLayer.class);
            if (baseLayer != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r1 = typeHelper != null ? (BaseLayerImpl) typeHelper.transfer(method, 0, baseLayer) : null;
                if (r1 == null) {
                    DebugTool.e("%s: $pLayer == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.layer.LayerMgr.1
                    }));
                }
            }
            LayerMgrImpl layerMgrImpl = this.mControl;
            if (layerMgrImpl != null) {
                layerMgrImpl.addLayer(r1);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public void removeLayer(BaseLayer baseLayer) {
        try {
            Method method = LayerMgr.class.getMethod("removeLayer", BaseLayer.class);
            if (baseLayer != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r1 = typeHelper != null ? (BaseLayerImpl) typeHelper.transfer(method, 0, baseLayer) : null;
                if (r1 == null) {
                    DebugTool.e("%s: $pLayer == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.layer.LayerMgr.2
                    }));
                }
            }
            LayerMgrImpl layerMgrImpl = this.mControl;
            if (layerMgrImpl != null) {
                layerMgrImpl.removeLayer(r1);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public BaseLayer getLayerByID(BigInteger bigInteger) {
        BaseLayerImpl layerByID;
        try {
            Method method = LayerMgr.class.getMethod("getLayerByID", BigInteger.class);
            LayerMgrImpl layerMgrImpl = this.mControl;
            if (layerMgrImpl != null && (layerByID = layerMgrImpl.getLayerByID(bigInteger)) != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r0 = typeHelper != null ? (BaseLayer) typeHelper.transfer(method, -1, (Object) layerByID, true) : null;
                if (r0 == null) {
                    DebugTool.e("%s: $ret == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.layer.LayerMgr.3
                    }));
                }
            }
            return r0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public ArrayList<BaseLayer> getAllLayers() {
        ArrayList<BaseLayerImpl> allLayers;
        try {
            Method method = LayerMgr.class.getMethod("getAllLayers", new Class[0]);
            LayerMgrImpl layerMgrImpl = this.mControl;
            if (layerMgrImpl != null && (allLayers = layerMgrImpl.getAllLayers()) != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r0 = typeHelper != null ? (ArrayList) typeHelper.transfer(method, -1, (ArrayList) allLayers, true) : null;
                if (r0 == null) {
                    DebugTool.e("%s: $ret == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.layer.LayerMgr.4
                    }));
                }
            }
            return r0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public void updateStyle() {
        LayerMgrImpl layerMgrImpl = this.mControl;
        if (layerMgrImpl != null) {
            layerMgrImpl.updateStyle();
        }
    }

    public void sortAllLayer() {
        LayerMgrImpl layerMgrImpl = this.mControl;
        if (layerMgrImpl != null) {
            layerMgrImpl.sortAllLayer();
        }
    }

    public void setAllPointLayerItemsScale(ScaleInfo scaleInfo) {
        LayerMgrImpl layerMgrImpl = this.mControl;
        if (layerMgrImpl != null) {
            layerMgrImpl.setAllPointLayerItemsScale(scaleInfo);
        }
    }

    public void lockLayers() {
        LayerMgrImpl layerMgrImpl = this.mControl;
        if (layerMgrImpl != null) {
            layerMgrImpl.lockLayers();
        }
    }

    public void unLockLayers() {
        LayerMgrImpl layerMgrImpl = this.mControl;
        if (layerMgrImpl != null) {
            layerMgrImpl.unLockLayers();
        }
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.layer.LayerMgr.5
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
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.layer.LayerMgr.6
        }));
    }

    protected synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.layer.LayerMgr.7
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
