package com.autonavi.gbl.map.layer;

import android.util.Log;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.map.layer.impl.BaseLayerImpl;
import com.autonavi.gbl.map.layer.impl.ILayerMgrImpl;
import com.autonavi.gbl.map.layer.model.ScaleInfo;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.util.ArrayList;
@IntfAuto(target = ILayerMgrImpl.class, type = BuildType.JCTRL)
/* loaded from: classes2.dex */
public class LayerMgr {
    private static String PACKAGE = ReflexTool.PN(LayerMgr.class);
    private ILayerMgrImpl mControl;
    private boolean mHasDestroy;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected void clean() {
    }

    protected LayerMgr(long j, boolean z) {
        this(new ILayerMgrImpl(j, z));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(LayerMgr.class, this, this.mControl);
        }
    }

    public LayerMgr(ILayerMgrImpl iLayerMgrImpl) {
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mHasDestroy = false;
        this.mControl = null;
        $constructor(iLayerMgrImpl);
    }

    private void $constructor(ILayerMgrImpl iLayerMgrImpl) {
        if (iLayerMgrImpl != null) {
            this.mControl = iLayerMgrImpl;
            this.mTargetId = String.format("LayerMgr_%s_%d", String.valueOf(ILayerMgrImpl.getCPtr(this.mControl)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    protected ILayerMgrImpl getControl() {
        return this.mControl;
    }

    public void addLayer(BaseLayer baseLayer) {
        TypeHelper typeHelper;
        try {
            Method method = LayerMgr.class.getMethod("addLayer", BaseLayer.class);
            BaseLayerImpl baseLayerImpl = null;
            if (baseLayer != null && (typeHelper = this.mTypeHelper) != null) {
                baseLayerImpl = (BaseLayerImpl) typeHelper.transfer(method, 0, baseLayer);
            }
            ILayerMgrImpl iLayerMgrImpl = this.mControl;
            if (iLayerMgrImpl != null) {
                iLayerMgrImpl.addLayer(baseLayerImpl);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public void removeLayer(BaseLayer baseLayer) {
        TypeHelper typeHelper;
        try {
            Method method = LayerMgr.class.getMethod("removeLayer", BaseLayer.class);
            BaseLayerImpl baseLayerImpl = null;
            if (baseLayer != null && (typeHelper = this.mTypeHelper) != null) {
                baseLayerImpl = (BaseLayerImpl) typeHelper.transfer(method, 0, baseLayer);
            }
            ILayerMgrImpl iLayerMgrImpl = this.mControl;
            if (iLayerMgrImpl != null) {
                iLayerMgrImpl.removeLayer(baseLayerImpl);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public BaseLayer getLayerByID(BigInteger bigInteger) {
        BaseLayerImpl layerByID;
        TypeHelper typeHelper;
        try {
            Method method = LayerMgr.class.getMethod("getLayerByID", BigInteger.class);
            ILayerMgrImpl iLayerMgrImpl = this.mControl;
            if (iLayerMgrImpl == null || (layerByID = iLayerMgrImpl.getLayerByID(bigInteger)) == null || (typeHelper = this.mTypeHelper) == null) {
                return null;
            }
            return (BaseLayer) typeHelper.transfer(method, -1, (Object) layerByID, true);
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public ArrayList<BaseLayer> getAllLayers() {
        ArrayList<BaseLayerImpl> allLayers;
        TypeHelper typeHelper;
        try {
            Method method = LayerMgr.class.getMethod("getAllLayers", new Class[0]);
            ILayerMgrImpl iLayerMgrImpl = this.mControl;
            if (iLayerMgrImpl == null || (allLayers = iLayerMgrImpl.getAllLayers()) == null || (typeHelper = this.mTypeHelper) == null) {
                return null;
            }
            return (ArrayList) typeHelper.transfer(method, -1, (ArrayList) allLayers, true);
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public void updateStyle() {
        ILayerMgrImpl iLayerMgrImpl = this.mControl;
        if (iLayerMgrImpl != null) {
            iLayerMgrImpl.updateStyle();
        }
    }

    public void sortAllLayer() {
        ILayerMgrImpl iLayerMgrImpl = this.mControl;
        if (iLayerMgrImpl != null) {
            iLayerMgrImpl.sortAllLayer();
        }
    }

    public void setAllPointLayerItemsScale(ScaleInfo scaleInfo) {
        ILayerMgrImpl iLayerMgrImpl = this.mControl;
        if (iLayerMgrImpl != null) {
            iLayerMgrImpl.setAllPointLayerItemsScale(scaleInfo);
        }
    }

    protected void unbind() {
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
