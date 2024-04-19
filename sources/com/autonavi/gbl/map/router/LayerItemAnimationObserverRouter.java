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
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.router.LayerItemAnimationObserverRouter.1
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
    @Override // com.autonavi.gbl.map.layer.observer.impl.ILayerItemAnimationObserverImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.router.LayerItemAnimationObserverRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.map.layer.observer.impl.ILayerItemAnimationObserverImpl
    public void onProcessAnimationEvent(BaseLayerImpl baseLayerImpl, LayerItemImpl layerItemImpl, AnimationEvent animationEvent) {
        BaseLayer baseLayer;
        try {
            Method method = LayerItemAnimationObserverRouter.class.getMethod("onProcessAnimationEvent", BaseLayerImpl.class, LayerItemImpl.class, AnimationEvent.class);
            if (baseLayerImpl != null) {
                TypeHelper typeHelper = this.mHelper;
                baseLayer = typeHelper != null ? (BaseLayer) typeHelper.transfer(method, 0, baseLayerImpl) : null;
                if (baseLayer == null) {
                    DebugTool.e("%s: $pLayer == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.router.LayerItemAnimationObserverRouter.3
                    }));
                }
            } else {
                baseLayer = null;
            }
            if (layerItemImpl != null) {
                TypeHelper typeHelper2 = this.mHelper;
                r1 = typeHelper2 != null ? (LayerItem) typeHelper2.transfer(method, 1, layerItemImpl) : null;
                if (r1 == null) {
                    DebugTool.e("%s: $pItem == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.router.LayerItemAnimationObserverRouter.4
                    }));
                }
            }
            ILayerItemAnimationObserver iLayerItemAnimationObserver = this.mObserver;
            if (iLayerItemAnimationObserver != null) {
                iLayerItemAnimationObserver.onProcessAnimationEvent(baseLayer, r1, animationEvent);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }
}
