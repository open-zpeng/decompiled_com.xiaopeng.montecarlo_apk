package com.autonavi.gbl.map.layer;

import android.util.Log;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.map.layer.impl.BaseLayerImpl;
import com.autonavi.gbl.map.layer.impl.LayerItemImpl;
import com.autonavi.gbl.map.layer.model.LayerItemType;
import com.autonavi.gbl.map.layer.model.LayerScale;
import com.autonavi.gbl.map.layer.model.MapLayerPoiAnimation;
import com.autonavi.gbl.map.layer.observer.ILayerItem;
import com.autonavi.gbl.map.layer.observer.IPrepareLayerStyle;
import com.autonavi.gbl.map.layer.observer.impl.IPrepareLayerStyleImpl;
import com.autonavi.gbl.map.model.PixelPoint;
import com.autonavi.gbl.map.router.LayerItemRouter;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
@IntfAuto(target = LayerItemRouter.class, type = BuildType.JOBIMPL)
/* loaded from: classes.dex */
public class LayerItem implements ILayerItem {
    private static String PACKAGE = ReflexTool.PN(LayerItem.class);
    private static TypeHelper gTypeHelper = new TypeHelper(PACKAGE);
    private boolean mHasDestroy;
    private LayerItemImpl mService;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    public LayerItemImpl getServiceEx() {
        return this.mService;
    }

    protected LayerItem(long j, boolean z) {
        this(new LayerItemRouter("LayerItem", null, j, z));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{ILayerItem.class}, new Object[]{this});
    }

    protected LayerItem() {
        this(new LayerItemRouter("LayerItem", null));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{ILayerItem.class}, new Object[]{this});
    }

    public LayerItem(LayerItemImpl layerItemImpl) {
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mService = null;
        this.mHasDestroy = false;
        $constructor(layerItemImpl);
    }

    private void $constructor(LayerItemImpl layerItemImpl) {
        if (layerItemImpl != null) {
            this.mService = layerItemImpl;
            this.mTargetId = String.format("LayerItem_%s_%d", String.valueOf(LayerItemImpl.getCPtr(this.mService)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    public LayerItemImpl getService() {
        return this.mService;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.layer.LayerItem.1
        });
        objArr[1] = String.valueOf(this.mTypeHelper != null);
        DebugTool.d("%s: mTypeHelper=%s", objArr);
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mTypeHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void clean() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.layer.LayerItem.2
        }));
    }

    public void onDestroy() {
        this.mHasDestroy = true;
        clean();
    }

    public synchronized void delete() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.layer.LayerItem.3
        });
        objArr[1] = String.valueOf(this.mService != null);
        DebugTool.d("%s: mService=%s", objArr);
        if (!this.mHasDestroy) {
            onDestroy();
        }
        if (this.mService != null) {
            if (this.mTypeHelper != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                TypeHelper.unbindAllTarget(ReflexTool.PN(this.mService.getClass()), this.mService);
            }
            this.mService = null;
        }
        unbind();
    }

    public static String getClassTypeName() {
        return LayerItemImpl.getClassTypeName();
    }

    public boolean setID(String str) {
        LayerItemImpl layerItemImpl = this.mService;
        if (layerItemImpl != null) {
            return layerItemImpl.$explicit_setID(str);
        }
        return false;
    }

    public boolean setInfo(String str) {
        LayerItemImpl layerItemImpl = this.mService;
        if (layerItemImpl != null) {
            return layerItemImpl.$explicit_setInfo(str);
        }
        return false;
    }

    public void setPriority(int i) {
        LayerItemImpl layerItemImpl = this.mService;
        if (layerItemImpl != null) {
            layerItemImpl.$explicit_setPriority(i);
        }
    }

    public void setVisible(boolean z) {
        LayerItemImpl layerItemImpl = this.mService;
        if (layerItemImpl != null) {
            layerItemImpl.$explicit_setVisible(z);
        }
    }

    public void setAlpha(double d) {
        LayerItemImpl layerItemImpl = this.mService;
        if (layerItemImpl != null) {
            layerItemImpl.$explicit_setAlpha(d);
        }
    }

    public void setAngle(double d) {
        LayerItemImpl layerItemImpl = this.mService;
        if (layerItemImpl != null) {
            layerItemImpl.$explicit_setAngle(d);
        }
    }

    public void setPitch(double d) {
        LayerItemImpl layerItemImpl = this.mService;
        if (layerItemImpl != null) {
            layerItemImpl.$explicit_setPitch(d);
        }
    }

    public void setMaxPitch(double d) {
        LayerItemImpl layerItemImpl = this.mService;
        if (layerItemImpl != null) {
            layerItemImpl.$explicit_setMaxPitch(d);
        }
    }

    public void setDisplayScale(LayerScale layerScale) {
        LayerItemImpl layerItemImpl = this.mService;
        if (layerItemImpl != null) {
            layerItemImpl.$explicit_setDisplayScale(layerScale);
        }
    }

    public void setAnimation(@MapLayerPoiAnimation.MapLayerPoiAnimation1 int i, int i2) {
        LayerItemImpl layerItemImpl = this.mService;
        if (layerItemImpl != null) {
            layerItemImpl.$explicit_setAnimation(i, i2);
        }
    }

    public void setStyle(IPrepareLayerStyle iPrepareLayerStyle) {
        HashSet hashSet;
        try {
            Method method = LayerItem.class.getMethod("setStyle", IPrepareLayerStyle.class);
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
                    DebugTool.e("%s: $pStyle == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.layer.LayerItem.4
                    }));
                }
            }
            LayerItemImpl layerItemImpl = this.mService;
            if (layerItemImpl != null) {
                layerItemImpl.$explicit_setStyle(r3);
                TypeHelper typeHelper3 = this.mTypeHelper;
                if (typeHelper3 != null) {
                    typeHelper3.unbindSet(method, 0, hashSet);
                }
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public void setStyle(String str) {
        LayerItemImpl layerItemImpl = this.mService;
        if (layerItemImpl != null) {
            layerItemImpl.$explicit_setStyle(str);
        }
    }

    public void updateStyle() {
        LayerItemImpl layerItemImpl = this.mService;
        if (layerItemImpl != null) {
            layerItemImpl.$explicit_updateStyle();
        }
    }

    public void updateStyle(LayerItem layerItem) {
        try {
            Method method = LayerItem.class.getMethod("updateStyle", LayerItem.class);
            if (layerItem != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r1 = typeHelper != null ? (LayerItemImpl) typeHelper.transfer(method, 0, layerItem) : null;
                if (r1 == null) {
                    DebugTool.e("%s: $pItem == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.layer.LayerItem.5
                    }));
                }
            }
            LayerItemImpl layerItemImpl = this.mService;
            if (layerItemImpl != null) {
                layerItemImpl.$explicit_updateStyle(r1);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public void addPoiFilter() {
        LayerItemImpl layerItemImpl = this.mService;
        if (layerItemImpl != null) {
            layerItemImpl.$explicit_addPoiFilter();
        }
    }

    public void removePoiFilter() {
        LayerItemImpl layerItemImpl = this.mService;
        if (layerItemImpl != null) {
            layerItemImpl.$explicit_removePoiFilter();
        }
    }

    public void setParent(BaseLayer baseLayer) {
        try {
            Method method = LayerItem.class.getMethod("setParent", BaseLayer.class);
            if (baseLayer != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r1 = typeHelper != null ? (BaseLayerImpl) typeHelper.transfer(method, 0, baseLayer) : null;
                if (r1 == null) {
                    DebugTool.e("%s: $pLayer == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.layer.LayerItem.6
                    }));
                }
            }
            LayerItemImpl layerItemImpl = this.mService;
            if (layerItemImpl != null) {
                layerItemImpl.$explicit_setParent(r1);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public void setBusinessType(int i) {
        LayerItemImpl layerItemImpl = this.mService;
        if (layerItemImpl != null) {
            layerItemImpl.$explicit_setBusinessType(i);
        }
    }

    @Override // com.autonavi.gbl.map.observer.ICollisionItem
    public boolean isAreaCollision() {
        LayerItemImpl layerItemImpl = this.mService;
        if (layerItemImpl != null) {
            return layerItemImpl.$explicit_isAreaCollision();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.observer.ICollisionItem
    public void setAreaCollision(boolean z) {
        LayerItemImpl layerItemImpl = this.mService;
        if (layerItemImpl != null) {
            layerItemImpl.$explicit_setAreaCollision(z);
        }
    }

    public String getTypeIdName() {
        LayerItemImpl layerItemImpl = this.mService;
        if (layerItemImpl != null) {
            return layerItemImpl.$explicit_getTypeIdName();
        }
        return null;
    }

    public void clearStyle() {
        LayerItemImpl layerItemImpl = this.mService;
        if (layerItemImpl != null) {
            layerItemImpl.$explicit_clearStyle();
        }
    }

    @Override // com.autonavi.gbl.map.layer.observer.ILayerItem, com.autonavi.gbl.map.layer.observer.IArrowLayerItem
    @LayerItemType.LayerItemType1
    public int getItemType() {
        LayerItemImpl layerItemImpl = this.mService;
        if (layerItemImpl != null) {
            return layerItemImpl.$explicit_getItemType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.map.layer.observer.ILayerItem
    public String getID() {
        LayerItemImpl layerItemImpl = this.mService;
        if (layerItemImpl != null) {
            return layerItemImpl.$explicit_getID();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.observer.ILayerItem
    public String getInfo() {
        LayerItemImpl layerItemImpl = this.mService;
        if (layerItemImpl != null) {
            return layerItemImpl.$explicit_getInfo();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.observer.ILayerItem, com.autonavi.gbl.map.observer.ICollisionItem
    public int getPriority() {
        LayerItemImpl layerItemImpl = this.mService;
        if (layerItemImpl != null) {
            return layerItemImpl.$explicit_getPriority();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.observer.ILayerItem, com.autonavi.gbl.map.observer.ICollisionItem
    public boolean getVisible() {
        LayerItemImpl layerItemImpl = this.mService;
        if (layerItemImpl != null) {
            return layerItemImpl.$explicit_getVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.observer.ILayerItem
    public boolean getFocus() {
        LayerItemImpl layerItemImpl = this.mService;
        if (layerItemImpl != null) {
            return layerItemImpl.$explicit_getFocus();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.observer.ILayerItem
    public double getAlpha() {
        LayerItemImpl layerItemImpl = this.mService;
        if (layerItemImpl != null) {
            return layerItemImpl.$explicit_getAlpha();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.observer.ILayerItem
    public double getAngle() {
        LayerItemImpl layerItemImpl = this.mService;
        if (layerItemImpl != null) {
            return layerItemImpl.$explicit_getAngle();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.observer.ILayerItem
    public double getPitch() {
        LayerItemImpl layerItemImpl = this.mService;
        if (layerItemImpl != null) {
            return layerItemImpl.$explicit_getPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.observer.ILayerItem
    public double getMaxPitch() {
        LayerItemImpl layerItemImpl = this.mService;
        if (layerItemImpl != null) {
            return layerItemImpl.$explicit_getMaxPitch();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.observer.ILayerItem
    public LayerScale getDisplayScale() {
        LayerItemImpl layerItemImpl = this.mService;
        if (layerItemImpl != null) {
            return layerItemImpl.$explicit_getDisplayScale();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.observer.ILayerItem
    public void onPaint() {
        LayerItemImpl layerItemImpl = this.mService;
        if (layerItemImpl != null) {
            layerItemImpl.$explicit_onPaint();
        }
    }

    @Override // com.autonavi.gbl.map.layer.observer.ILayerItem
    public int getBusinessType() {
        LayerItemImpl layerItemImpl = this.mService;
        if (layerItemImpl != null) {
            return layerItemImpl.$explicit_getBusinessType();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.observer.ILayerItem, com.autonavi.gbl.map.observer.ICollisionItem, com.autonavi.gbl.map.layer.observer.IQuadrantLayerItem, com.autonavi.gbl.layer.observer.IGuideLabelLayerItem
    public void onVisible(boolean z) {
        LayerItemImpl layerItemImpl = this.mService;
        if (layerItemImpl != null) {
            layerItemImpl.$explicit_onVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.observer.ILayerItem, com.autonavi.gbl.map.observer.ICollisionItem
    public ArrayList<PixelPoint> getBound() {
        LayerItemImpl layerItemImpl = this.mService;
        if (layerItemImpl != null) {
            return layerItemImpl.$explicit_getBound();
        }
        return null;
    }
}
