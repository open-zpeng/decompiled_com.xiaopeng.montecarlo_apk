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
import com.autonavi.gbl.map.layer.model.AnimationEvent;
import com.autonavi.gbl.map.layer.observer.ILayerItemAnimationObserver;
import com.autonavi.gbl.map.layer.observer.impl.ILayerItemAnimationObserverImpl;
import java.lang.reflect.Method;
@IntfAuto(target = ILayerItemAnimationObserver.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class LayerItemAnimationObserverRouter extends ILayerItemAnimationObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(LayerItemAnimationObserverRouter.class);
    private static String PACKAGE = ReflexTool.PN(LayerItemAnimationObserverRouter.class);
    private TypeHelper mHelper;
    private ILayerItemAnimationObserver mObserver;
    private String mTargetId;

    private void $constructor(String str, ILayerItemAnimationObserver iLayerItemAnimationObserver) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ILayerItemAnimationObserverImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iLayerItemAnimationObserver;
    }

    protected LayerItemAnimationObserverRouter(String str, ILayerItemAnimationObserver iLayerItemAnimationObserver, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iLayerItemAnimationObserver);
    }

    protected LayerItemAnimationObserverRouter(String str, ILayerItemAnimationObserver iLayerItemAnimationObserver) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iLayerItemAnimationObserver);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.observer.impl.ILayerItemAnimationObserverImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.map.layer.observer.impl.ILayerItemAnimationObserverImpl
    public void onProcessAnimationEvent(BaseLayerImpl baseLayerImpl, LayerItemImpl layerItemImpl, AnimationEvent animationEvent) {
        TypeHelper typeHelper;
        TypeHelper typeHelper2;
        try {
            Method method = LayerItemAnimationObserverRouter.class.getMethod("onProcessAnimationEvent", BaseLayerImpl.class, LayerItemImpl.class, AnimationEvent.class);
            LayerItem layerItem = null;
            BaseLayer baseLayer = (baseLayerImpl == null || (typeHelper2 = this.mHelper) == null) ? null : (BaseLayer) typeHelper2.transfer(method, 0, baseLayerImpl);
            if (layerItemImpl != null && (typeHelper = this.mHelper) != null) {
                layerItem = (LayerItem) typeHelper.transfer(method, 1, layerItemImpl);
            }
            ILayerItemAnimationObserver iLayerItemAnimationObserver = this.mObserver;
            if (iLayerItemAnimationObserver != null) {
                iLayerItemAnimationObserver.onProcessAnimationEvent(baseLayer, layerItem, animationEvent);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }
}
