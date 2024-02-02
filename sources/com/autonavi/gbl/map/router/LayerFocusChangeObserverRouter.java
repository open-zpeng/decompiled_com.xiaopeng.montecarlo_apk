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
import com.autonavi.gbl.map.layer.observer.ILayerFocusChangeObserver;
import com.autonavi.gbl.map.layer.observer.impl.ILayerFocusChangeObserverImpl;
import java.lang.reflect.Method;
@IntfAuto(target = ILayerFocusChangeObserver.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class LayerFocusChangeObserverRouter extends ILayerFocusChangeObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(LayerFocusChangeObserverRouter.class);
    private static String PACKAGE = ReflexTool.PN(LayerFocusChangeObserverRouter.class);
    private TypeHelper mHelper;
    private ILayerFocusChangeObserver mObserver;
    private String mTargetId;

    private void $constructor(String str, ILayerFocusChangeObserver iLayerFocusChangeObserver) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ILayerFocusChangeObserverImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iLayerFocusChangeObserver;
    }

    protected LayerFocusChangeObserverRouter(String str, ILayerFocusChangeObserver iLayerFocusChangeObserver, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iLayerFocusChangeObserver);
    }

    protected LayerFocusChangeObserverRouter(String str, ILayerFocusChangeObserver iLayerFocusChangeObserver) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iLayerFocusChangeObserver);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.router.LayerFocusChangeObserverRouter.1
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
    @Override // com.autonavi.gbl.map.layer.observer.impl.ILayerFocusChangeObserverImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.router.LayerFocusChangeObserverRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.map.layer.observer.impl.ILayerFocusChangeObserverImpl
    public void onNotifyFocusChange(BaseLayerImpl baseLayerImpl, LayerItemImpl layerItemImpl, boolean z) {
        BaseLayer baseLayer;
        try {
            Method method = LayerFocusChangeObserverRouter.class.getMethod("onNotifyFocusChange", BaseLayerImpl.class, LayerItemImpl.class, Boolean.TYPE);
            if (baseLayerImpl != null) {
                TypeHelper typeHelper = this.mHelper;
                baseLayer = typeHelper != null ? (BaseLayer) typeHelper.transfer(method, 0, baseLayerImpl) : null;
                if (baseLayer == null) {
                    DebugTool.e("%s: $layer == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.router.LayerFocusChangeObserverRouter.3
                    }));
                }
            } else {
                baseLayer = null;
            }
            if (layerItemImpl != null) {
                TypeHelper typeHelper2 = this.mHelper;
                r1 = typeHelper2 != null ? (LayerItem) typeHelper2.transfer(method, 1, layerItemImpl) : null;
                if (r1 == null) {
                    DebugTool.e("%s: $pItem == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.router.LayerFocusChangeObserverRouter.4
                    }));
                }
            }
            ILayerFocusChangeObserver iLayerFocusChangeObserver = this.mObserver;
            if (iLayerFocusChangeObserver != null) {
                iLayerFocusChangeObserver.onNotifyFocusChange(baseLayer, r1, z);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }
}
