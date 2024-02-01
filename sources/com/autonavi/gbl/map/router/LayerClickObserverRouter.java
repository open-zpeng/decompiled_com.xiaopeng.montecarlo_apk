package com.autonavi.gbl.map.router;

import android.util.Log;
import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.map.layer.BaseLayer;
import com.autonavi.gbl.map.layer.LayerItem;
import com.autonavi.gbl.map.layer.impl.BaseLayerImpl;
import com.autonavi.gbl.map.layer.impl.LayerItemImpl;
import com.autonavi.gbl.map.layer.model.ClickViewIdInfo;
import com.autonavi.gbl.map.layer.observer.ILayerClickObserver;
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
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.observer.impl.ILayerClickObserverImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.map.layer.observer.impl.ILayerClickObserverImpl
    public void onBeforeNotifyClick(BaseLayerImpl baseLayerImpl, LayerItemImpl layerItemImpl, ClickViewIdInfo clickViewIdInfo) {
        TypeHelper typeHelper;
        TypeHelper typeHelper2;
        try {
            Method method = LayerClickObserverRouter.class.getMethod("onBeforeNotifyClick", BaseLayerImpl.class, LayerItemImpl.class, ClickViewIdInfo.class);
            LayerItem layerItem = null;
            BaseLayer baseLayer = (baseLayerImpl == null || (typeHelper2 = this.mHelper) == null) ? null : (BaseLayer) typeHelper2.transfer(method, 0, baseLayerImpl);
            if (layerItemImpl != null && (typeHelper = this.mHelper) != null) {
                layerItem = (LayerItem) typeHelper.transfer(method, 1, layerItemImpl);
            }
            ILayerClickObserver iLayerClickObserver = this.mObserver;
            if (iLayerClickObserver != null) {
                iLayerClickObserver.onBeforeNotifyClick(baseLayer, layerItem, clickViewIdInfo);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    @Override // com.autonavi.gbl.map.layer.observer.impl.ILayerClickObserverImpl
    public void onNotifyClick(BaseLayerImpl baseLayerImpl, LayerItemImpl layerItemImpl, ClickViewIdInfo clickViewIdInfo) {
        TypeHelper typeHelper;
        TypeHelper typeHelper2;
        try {
            Method method = LayerClickObserverRouter.class.getMethod("onNotifyClick", BaseLayerImpl.class, LayerItemImpl.class, ClickViewIdInfo.class);
            LayerItem layerItem = null;
            BaseLayer baseLayer = (baseLayerImpl == null || (typeHelper2 = this.mHelper) == null) ? null : (BaseLayer) typeHelper2.transfer(method, 0, baseLayerImpl);
            if (layerItemImpl != null && (typeHelper = this.mHelper) != null) {
                layerItem = (LayerItem) typeHelper.transfer(method, 1, layerItemImpl);
            }
            ILayerClickObserver iLayerClickObserver = this.mObserver;
            if (iLayerClickObserver != null) {
                iLayerClickObserver.onNotifyClick(baseLayer, layerItem, clickViewIdInfo);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    @Override // com.autonavi.gbl.map.layer.observer.impl.ILayerClickObserverImpl
    public void onAfterNotifyClick(BaseLayerImpl baseLayerImpl, LayerItemImpl layerItemImpl, ClickViewIdInfo clickViewIdInfo) {
        TypeHelper typeHelper;
        TypeHelper typeHelper2;
        try {
            Method method = LayerClickObserverRouter.class.getMethod("onAfterNotifyClick", BaseLayerImpl.class, LayerItemImpl.class, ClickViewIdInfo.class);
            LayerItem layerItem = null;
            BaseLayer baseLayer = (baseLayerImpl == null || (typeHelper2 = this.mHelper) == null) ? null : (BaseLayer) typeHelper2.transfer(method, 0, baseLayerImpl);
            if (layerItemImpl != null && (typeHelper = this.mHelper) != null) {
                layerItem = (LayerItem) typeHelper.transfer(method, 1, layerItemImpl);
            }
            ILayerClickObserver iLayerClickObserver = this.mObserver;
            if (iLayerClickObserver != null) {
                iLayerClickObserver.onAfterNotifyClick(baseLayer, layerItem, clickViewIdInfo);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }
}
