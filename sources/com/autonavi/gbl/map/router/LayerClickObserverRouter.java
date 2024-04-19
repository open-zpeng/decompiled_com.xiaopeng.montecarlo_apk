package com.autonavi.gbl.map.router;

import android.util.Log;
import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.map.layer.BaseLayer;
import com.autonavi.gbl.map.layer.LayerItem;
import com.autonavi.gbl.map.layer.impl.BaseLayerImpl;
import com.autonavi.gbl.map.layer.impl.LayerItemImpl;
import com.autonavi.gbl.map.layer.observer.ILayerClickObserver;
import com.autonavi.gbl.map.layer.observer.impl.ClickViewIdInfo;
import com.autonavi.gbl.map.layer.observer.impl.ILayerClickObserverImpl;
import java.lang.reflect.Method;
@IntfAuto(target = ILayerClickObserver.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class LayerClickObserverRouter extends ILayerClickObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(LayerClickObserverRouter.class);
    private static String PACKAGE = ReflexTool.PN(LayerClickObserverRouter.class);
    private TypeHelper mHelper;
    private ILayerClickObserver mObserver;
    private String mTargetId;

    private void $constructor(String str, ILayerClickObserver iLayerClickObserver) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ILayerClickObserverImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iLayerClickObserver;
    }

    protected LayerClickObserverRouter(String str, ILayerClickObserver iLayerClickObserver, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iLayerClickObserver);
    }

    protected LayerClickObserverRouter(String str, ILayerClickObserver iLayerClickObserver) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iLayerClickObserver);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.router.LayerClickObserverRouter.1
        });
        objArr[1] = String.valueOf(this.mHelper != null);
        DebugTool.d("%s: mHelper=%s", objArr);
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.observer.impl.ILayerClickObserverImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.router.LayerClickObserverRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.map.layer.observer.impl.ILayerClickObserverImpl
    public void onBeforeNotifyClick(BaseLayerImpl baseLayerImpl, LayerItemImpl layerItemImpl, ClickViewIdInfo clickViewIdInfo) {
        BaseLayer baseLayer;
        try {
            Method method = LayerClickObserverRouter.class.getMethod("onBeforeNotifyClick", BaseLayerImpl.class, LayerItemImpl.class, ClickViewIdInfo.class);
            if (baseLayerImpl != null) {
                TypeHelper typeHelper = this.mHelper;
                baseLayer = typeHelper != null ? (BaseLayer) typeHelper.transfer(method, 0, baseLayerImpl) : null;
                if (baseLayer == null) {
                    DebugTool.e("%s: $layer == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.router.LayerClickObserverRouter.3
                    }));
                }
            } else {
                baseLayer = null;
            }
            if (layerItemImpl != null) {
                TypeHelper typeHelper2 = this.mHelper;
                r1 = typeHelper2 != null ? (LayerItem) typeHelper2.transfer(method, 1, layerItemImpl) : null;
                if (r1 == null) {
                    DebugTool.e("%s: $pItem == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.router.LayerClickObserverRouter.4
                    }));
                }
            }
            ILayerClickObserver iLayerClickObserver = this.mObserver;
            if (iLayerClickObserver != null) {
                iLayerClickObserver.onBeforeNotifyClick(baseLayer, r1, clickViewIdInfo);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    @Override // com.autonavi.gbl.map.layer.observer.impl.ILayerClickObserverImpl
    public void onNotifyClick(BaseLayerImpl baseLayerImpl, LayerItemImpl layerItemImpl, ClickViewIdInfo clickViewIdInfo) {
        BaseLayer baseLayer;
        try {
            Method method = LayerClickObserverRouter.class.getMethod("onNotifyClick", BaseLayerImpl.class, LayerItemImpl.class, ClickViewIdInfo.class);
            if (baseLayerImpl != null) {
                TypeHelper typeHelper = this.mHelper;
                baseLayer = typeHelper != null ? (BaseLayer) typeHelper.transfer(method, 0, baseLayerImpl) : null;
                if (baseLayer == null) {
                    DebugTool.e("%s: $layer == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.router.LayerClickObserverRouter.5
                    }));
                }
            } else {
                baseLayer = null;
            }
            if (layerItemImpl != null) {
                TypeHelper typeHelper2 = this.mHelper;
                r1 = typeHelper2 != null ? (LayerItem) typeHelper2.transfer(method, 1, layerItemImpl) : null;
                if (r1 == null) {
                    DebugTool.e("%s: $pItem == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.router.LayerClickObserverRouter.6
                    }));
                }
            }
            ILayerClickObserver iLayerClickObserver = this.mObserver;
            if (iLayerClickObserver != null) {
                iLayerClickObserver.onNotifyClick(baseLayer, r1, clickViewIdInfo);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    @Override // com.autonavi.gbl.map.layer.observer.impl.ILayerClickObserverImpl
    public void onAfterNotifyClick(BaseLayerImpl baseLayerImpl, LayerItemImpl layerItemImpl, ClickViewIdInfo clickViewIdInfo) {
        BaseLayer baseLayer;
        try {
            Method method = LayerClickObserverRouter.class.getMethod("onAfterNotifyClick", BaseLayerImpl.class, LayerItemImpl.class, ClickViewIdInfo.class);
            if (baseLayerImpl != null) {
                TypeHelper typeHelper = this.mHelper;
                baseLayer = typeHelper != null ? (BaseLayer) typeHelper.transfer(method, 0, baseLayerImpl) : null;
                if (baseLayer == null) {
                    DebugTool.e("%s: $layer == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.router.LayerClickObserverRouter.7
                    }));
                }
            } else {
                baseLayer = null;
            }
            if (layerItemImpl != null) {
                TypeHelper typeHelper2 = this.mHelper;
                r1 = typeHelper2 != null ? (LayerItem) typeHelper2.transfer(method, 1, layerItemImpl) : null;
                if (r1 == null) {
                    DebugTool.e("%s: $pItem == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.router.LayerClickObserverRouter.8
                    }));
                }
            }
            ILayerClickObserver iLayerClickObserver = this.mObserver;
            if (iLayerClickObserver != null) {
                iLayerClickObserver.onAfterNotifyClick(baseLayer, r1, clickViewIdInfo);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }
}
