package com.autonavi.gbl.map.layer;

import android.util.Log;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.common.model.RectDouble;
import com.autonavi.gbl.map.CollisionGroup;
import com.autonavi.gbl.map.MapView;
import com.autonavi.gbl.map.impl.CollisionItemImpl;
import com.autonavi.gbl.map.impl.ICollisonRemoveObseverImpl;
import com.autonavi.gbl.map.impl.IMapViewImpl;
import com.autonavi.gbl.map.layer.impl.BaseLayerImpl;
import com.autonavi.gbl.map.layer.impl.LayerItemImpl;
import com.autonavi.gbl.map.layer.model.BGDClusterStrategy;
import com.autonavi.gbl.map.layer.model.Layer3DModel;
import com.autonavi.gbl.map.layer.model.LayerPriority;
import com.autonavi.gbl.map.layer.model.LayerScale;
import com.autonavi.gbl.map.layer.model.LayerTexture;
import com.autonavi.gbl.map.layer.model.OverlayGeometryType;
import com.autonavi.gbl.map.layer.model.UIRectRecord;
import com.autonavi.gbl.map.layer.observer.IBaseLayer;
import com.autonavi.gbl.map.layer.observer.ILayerClickObserver;
import com.autonavi.gbl.map.layer.observer.ILayerFocusChangeObserver;
import com.autonavi.gbl.map.layer.observer.IPrepareLayerStyle;
import com.autonavi.gbl.map.layer.observer.impl.ILayerClickObserverImpl;
import com.autonavi.gbl.map.layer.observer.impl.ILayerFocusChangeObserverImpl;
import com.autonavi.gbl.map.layer.observer.impl.IPrepareLayerStyleImpl;
import com.autonavi.gbl.map.observer.ICollisionItem;
import com.autonavi.gbl.map.observer.ICollisonRemoveObsever;
import com.autonavi.gbl.map.router.BaseLayerRouter;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
@IntfAuto(target = BaseLayerRouter.class, type = BuildType.JOBIMPL)
/* loaded from: classes2.dex */
public class BaseLayer extends CollisionGroup implements IBaseLayer {
    private static String PACKAGE = ReflexTool.PN(BaseLayer.class);
    private static TypeHelper gTypeHelper = new TypeHelper(PACKAGE);
    private boolean mHasDestroy;
    private BaseLayerImpl mService;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected BaseLayer(long j, boolean z) {
        this(new BaseLayerRouter("BaseLayer", (IBaseLayer) null, j, z));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{IBaseLayer.class}, new Object[]{this});
    }

    public BaseLayer(String str, MapView mapView) {
        this(new BaseLayerRouter("BaseLayer", (IBaseLayer) null, str, (IMapViewImpl) new TypeHelper(PACKAGE).transfer("com.autonavi.gbl.map.MapView", mapView)));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{IBaseLayer.class}, new Object[]{this});
    }

    public BaseLayer(String str, MapView mapView, @OverlayGeometryType.OverlayGeometryType1 int i) {
        this(new BaseLayerRouter("BaseLayer", null, str, (IMapViewImpl) new TypeHelper(PACKAGE).transfer("com.autonavi.gbl.map.MapView", mapView), i));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{IBaseLayer.class}, new Object[]{this});
    }

    public BaseLayer(BaseLayerImpl baseLayerImpl) {
        super(baseLayerImpl);
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mService = null;
        this.mHasDestroy = false;
        $constructor(baseLayerImpl);
    }

    private void $constructor(BaseLayerImpl baseLayerImpl) {
        if (baseLayerImpl != null) {
            this.mService = baseLayerImpl;
            this.mTargetId = String.format("BaseLayer_%s_%d", String.valueOf(BaseLayerImpl.getCPtr(this.mService)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.CollisionGroup
    public BaseLayerImpl getService() {
        return this.mService;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.CollisionGroup
    public void unbind() {
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mTypeHelper = null;
        }
        super.unbind();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.CollisionGroup
    public void clean() {
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            Iterator it = ((HashSet) typeHelper.getBindSet("com.autonavi.gbl.map.layer.observer.ILayerClickObserver")).iterator();
            while (it.hasNext()) {
                removeClickObserver((ILayerClickObserver) it.next());
            }
        }
        TypeHelper typeHelper2 = this.mTypeHelper;
        if (typeHelper2 != null) {
            Iterator it2 = ((HashSet) typeHelper2.getBindSet("com.autonavi.gbl.map.layer.observer.ILayerFocusChangeObserver")).iterator();
            while (it2.hasNext()) {
                removeFocusChangeObserver((ILayerFocusChangeObserver) it2.next());
            }
        }
        TypeHelper typeHelper3 = this.mTypeHelper;
        if (typeHelper3 != null) {
            Iterator it3 = ((HashSet) typeHelper3.getBindSet("com.autonavi.gbl.map.observer.ICollisonRemoveObsever")).iterator();
            while (it3.hasNext()) {
                removeCollisonRemoveObsever((ICollisonRemoveObsever) it3.next());
            }
        }
        super.clean();
    }

    @Override // com.autonavi.gbl.map.CollisionGroup
    public void onDestroy() {
        this.mHasDestroy = true;
        clean();
    }

    @Override // com.autonavi.gbl.map.CollisionGroup
    public synchronized void delete() {
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
        return BaseLayerImpl.getClassTypeName();
    }

    public String getTypeIdName() {
        BaseLayerImpl baseLayerImpl = this.mService;
        if (baseLayerImpl != null) {
            return baseLayerImpl.$explicit_getTypeIdName();
        }
        return null;
    }

    public void setName(String str) {
        BaseLayerImpl baseLayerImpl = this.mService;
        if (baseLayerImpl != null) {
            baseLayerImpl.$explicit_setName(str);
        }
    }

    public boolean addLayer3DModel(Layer3DModel layer3DModel) {
        BaseLayerImpl baseLayerImpl = this.mService;
        if (baseLayerImpl != null) {
            return baseLayerImpl.$explicit_addLayer3DModel(layer3DModel);
        }
        return false;
    }

    public boolean destroyLayer3DModel(int i) {
        BaseLayerImpl baseLayerImpl = this.mService;
        if (baseLayerImpl != null) {
            return baseLayerImpl.$explicit_destroyLayer3DModel(i);
        }
        return false;
    }

    public void addLayerTexture(LayerTexture layerTexture) {
        BaseLayerImpl baseLayerImpl = this.mService;
        if (baseLayerImpl != null) {
            baseLayerImpl.$explicit_addLayerTexture(layerTexture);
        }
    }

    public void removeLayerTexture(int i) {
        BaseLayerImpl baseLayerImpl = this.mService;
        if (baseLayerImpl != null) {
            baseLayerImpl.$explicit_removeLayerTexture(i);
        }
    }

    public boolean addItem(LayerItem layerItem) {
        TypeHelper typeHelper;
        try {
            Method method = BaseLayer.class.getMethod("addItem", LayerItem.class);
            LayerItemImpl layerItemImpl = null;
            if (layerItem != null && (typeHelper = this.mTypeHelper) != null) {
                layerItemImpl = (LayerItemImpl) typeHelper.transfer(method, 0, layerItem);
            }
            BaseLayerImpl baseLayerImpl = this.mService;
            if (baseLayerImpl != null) {
                return baseLayerImpl.$explicit_addItem(layerItemImpl);
            }
            return false;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return false;
        }
    }

    public void addItems(ArrayList<LayerItem> arrayList, boolean z) {
        TypeHelper typeHelper;
        try {
            Method method = BaseLayer.class.getMethod("addItems", ArrayList.class, Boolean.TYPE);
            ArrayList<LayerItemImpl> arrayList2 = null;
            if (arrayList != null && (typeHelper = this.mTypeHelper) != null) {
                arrayList2 = (ArrayList) typeHelper.transfer(method, 0, (ArrayList) arrayList);
            }
            BaseLayerImpl baseLayerImpl = this.mService;
            if (baseLayerImpl != null) {
                baseLayerImpl.$explicit_addItems(arrayList2, z);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public void addItems(ArrayList<LayerItem> arrayList) {
        TypeHelper typeHelper;
        try {
            Method method = BaseLayer.class.getMethod("addItems", ArrayList.class);
            ArrayList<LayerItemImpl> arrayList2 = null;
            if (arrayList != null && (typeHelper = this.mTypeHelper) != null) {
                arrayList2 = (ArrayList) typeHelper.transfer(method, 0, (ArrayList) arrayList);
            }
            BaseLayerImpl baseLayerImpl = this.mService;
            if (baseLayerImpl != null) {
                baseLayerImpl.$explicit_addItems(arrayList2);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public void removeItem(String str) {
        BaseLayerImpl baseLayerImpl = this.mService;
        if (baseLayerImpl != null) {
            baseLayerImpl.$explicit_removeItem(str);
        }
    }

    public void removeItems(String[] strArr) {
        BaseLayerImpl baseLayerImpl = this.mService;
        if (baseLayerImpl != null) {
            baseLayerImpl.$explicit_removeItems(strArr);
        }
    }

    public void clearAllItems() {
        BaseLayerImpl baseLayerImpl = this.mService;
        if (baseLayerImpl != null) {
            baseLayerImpl.$explicit_clearAllItems();
        }
    }

    public void setVisible(boolean z) {
        BaseLayerImpl baseLayerImpl = this.mService;
        if (baseLayerImpl != null) {
            baseLayerImpl.$explicit_setVisible(z);
        }
    }

    public void saveVisible() {
        BaseLayerImpl baseLayerImpl = this.mService;
        if (baseLayerImpl != null) {
            baseLayerImpl.$explicit_saveVisible();
        }
    }

    public void restoreVisible() {
        BaseLayerImpl baseLayerImpl = this.mService;
        if (baseLayerImpl != null) {
            baseLayerImpl.$explicit_restoreVisible();
        }
    }

    public void setClickable(boolean z) {
        BaseLayerImpl baseLayerImpl = this.mService;
        if (baseLayerImpl != null) {
            baseLayerImpl.$explicit_setClickable(z);
        }
    }

    public void addClickObserver(ILayerClickObserver iLayerClickObserver) {
        TypeHelper typeHelper;
        try {
            Method method = BaseLayer.class.getMethod("addClickObserver", ILayerClickObserver.class);
            ILayerClickObserverImpl iLayerClickObserverImpl = null;
            if (iLayerClickObserver != null && (typeHelper = this.mTypeHelper) != null) {
                iLayerClickObserverImpl = (ILayerClickObserverImpl) typeHelper.transfer(method, 0, iLayerClickObserver);
            }
            BaseLayerImpl baseLayerImpl = this.mService;
            if (baseLayerImpl != null) {
                baseLayerImpl.$explicit_addClickObserver(iLayerClickObserverImpl);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public void removeClickObserver(ILayerClickObserver iLayerClickObserver) {
        TypeHelper typeHelper;
        try {
            Method method = BaseLayer.class.getMethod("removeClickObserver", ILayerClickObserver.class);
            ILayerClickObserverImpl iLayerClickObserverImpl = null;
            if (iLayerClickObserver != null && (typeHelper = this.mTypeHelper) != null) {
                iLayerClickObserverImpl = (ILayerClickObserverImpl) typeHelper.transfer(method, 0, iLayerClickObserver);
            }
            BaseLayerImpl baseLayerImpl = this.mService;
            if (baseLayerImpl != null) {
                baseLayerImpl.$explicit_removeClickObserver(iLayerClickObserverImpl);
                TypeHelper typeHelper2 = this.mTypeHelper;
                if (typeHelper2 != null) {
                    typeHelper2.unbind(method, 0, iLayerClickObserver);
                }
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public void setDisplayScale(LayerScale layerScale) {
        BaseLayerImpl baseLayerImpl = this.mService;
        if (baseLayerImpl != null) {
            baseLayerImpl.$explicit_setDisplayScale(layerScale);
        }
    }

    public void setStyle(IPrepareLayerStyle iPrepareLayerStyle) {
        HashSet hashSet;
        TypeHelper typeHelper;
        try {
            Method method = BaseLayer.class.getMethod("setStyle", IPrepareLayerStyle.class);
            TypeHelper typeHelper2 = this.mTypeHelper;
            if (typeHelper2 != null) {
                hashSet = (HashSet) typeHelper2.getBindSet(method, 0);
            } else {
                hashSet = new HashSet();
            }
            hashSet.remove(iPrepareLayerStyle);
            IPrepareLayerStyleImpl iPrepareLayerStyleImpl = null;
            if (iPrepareLayerStyle != null && (typeHelper = this.mTypeHelper) != null) {
                iPrepareLayerStyleImpl = (IPrepareLayerStyleImpl) typeHelper.transfer(method, 0, iPrepareLayerStyle);
            }
            BaseLayerImpl baseLayerImpl = this.mService;
            if (baseLayerImpl != null) {
                baseLayerImpl.$explicit_setStyle(iPrepareLayerStyleImpl);
                TypeHelper typeHelper3 = this.mTypeHelper;
                if (typeHelper3 != null) {
                    typeHelper3.unbindSet(method, 0, hashSet);
                }
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public void updateStyle() {
        BaseLayerImpl baseLayerImpl = this.mService;
        if (baseLayerImpl != null) {
            baseLayerImpl.$explicit_updateStyle();
        }
    }

    public void setFocus(String str, boolean z) {
        BaseLayerImpl baseLayerImpl = this.mService;
        if (baseLayerImpl != null) {
            baseLayerImpl.$explicit_setFocus(str, z);
        }
    }

    public void clearFocus() {
        BaseLayerImpl baseLayerImpl = this.mService;
        if (baseLayerImpl != null) {
            baseLayerImpl.$explicit_clearFocus();
        }
    }

    public void addFocusChangeObserver(ILayerFocusChangeObserver iLayerFocusChangeObserver) {
        TypeHelper typeHelper;
        try {
            Method method = BaseLayer.class.getMethod("addFocusChangeObserver", ILayerFocusChangeObserver.class);
            ILayerFocusChangeObserverImpl iLayerFocusChangeObserverImpl = null;
            if (iLayerFocusChangeObserver != null && (typeHelper = this.mTypeHelper) != null) {
                iLayerFocusChangeObserverImpl = (ILayerFocusChangeObserverImpl) typeHelper.transfer(method, 0, iLayerFocusChangeObserver);
            }
            BaseLayerImpl baseLayerImpl = this.mService;
            if (baseLayerImpl != null) {
                baseLayerImpl.$explicit_addFocusChangeObserver(iLayerFocusChangeObserverImpl);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public void removeFocusChangeObserver(ILayerFocusChangeObserver iLayerFocusChangeObserver) {
        TypeHelper typeHelper;
        try {
            Method method = BaseLayer.class.getMethod("removeFocusChangeObserver", ILayerFocusChangeObserver.class);
            ILayerFocusChangeObserverImpl iLayerFocusChangeObserverImpl = null;
            if (iLayerFocusChangeObserver != null && (typeHelper = this.mTypeHelper) != null) {
                iLayerFocusChangeObserverImpl = (ILayerFocusChangeObserverImpl) typeHelper.transfer(method, 0, iLayerFocusChangeObserver);
            }
            BaseLayerImpl baseLayerImpl = this.mService;
            if (baseLayerImpl != null) {
                baseLayerImpl.$explicit_removeFocusChangeObserver(iLayerFocusChangeObserverImpl);
                TypeHelper typeHelper2 = this.mTypeHelper;
                if (typeHelper2 != null) {
                    typeHelper2.unbind(method, 0, iLayerFocusChangeObserver);
                }
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public void addCollisonRemoveObsever(ICollisonRemoveObsever iCollisonRemoveObsever) {
        TypeHelper typeHelper;
        try {
            Method method = BaseLayer.class.getMethod("addCollisonRemoveObsever", ICollisonRemoveObsever.class);
            ICollisonRemoveObseverImpl iCollisonRemoveObseverImpl = null;
            if (iCollisonRemoveObsever != null && (typeHelper = this.mTypeHelper) != null) {
                iCollisonRemoveObseverImpl = (ICollisonRemoveObseverImpl) typeHelper.transfer(method, 0, iCollisonRemoveObsever);
            }
            BaseLayerImpl baseLayerImpl = this.mService;
            if (baseLayerImpl != null) {
                baseLayerImpl.$explicit_addCollisonRemoveObsever(iCollisonRemoveObseverImpl);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public void removeCollisonRemoveObsever(ICollisonRemoveObsever iCollisonRemoveObsever) {
        TypeHelper typeHelper;
        try {
            Method method = BaseLayer.class.getMethod("removeCollisonRemoveObsever", ICollisonRemoveObsever.class);
            ICollisonRemoveObseverImpl iCollisonRemoveObseverImpl = null;
            if (iCollisonRemoveObsever != null && (typeHelper = this.mTypeHelper) != null) {
                iCollisonRemoveObseverImpl = (ICollisonRemoveObseverImpl) typeHelper.transfer(method, 0, iCollisonRemoveObsever);
            }
            BaseLayerImpl baseLayerImpl = this.mService;
            if (baseLayerImpl != null) {
                baseLayerImpl.$explicit_removeCollisonRemoveObsever(iCollisonRemoveObseverImpl);
                TypeHelper typeHelper2 = this.mTypeHelper;
                if (typeHelper2 != null) {
                    typeHelper2.unbind(method, 0, iCollisonRemoveObsever);
                }
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public void setPriority(LayerPriority layerPriority) {
        BaseLayerImpl baseLayerImpl = this.mService;
        if (baseLayerImpl != null) {
            baseLayerImpl.$explicit_setPriority(layerPriority);
        }
    }

    public void sort() {
        BaseLayerImpl baseLayerImpl = this.mService;
        if (baseLayerImpl != null) {
            baseLayerImpl.$explicit_sort();
        }
    }

    public boolean enableCluster(boolean z) {
        BaseLayerImpl baseLayerImpl = this.mService;
        if (baseLayerImpl != null) {
            return baseLayerImpl.$explicit_enableCluster(z);
        }
        return false;
    }

    public void setBGDClusterStrategy(BGDClusterStrategy bGDClusterStrategy) {
        BaseLayerImpl baseLayerImpl = this.mService;
        if (baseLayerImpl != null) {
            baseLayerImpl.$explicit_setBGDClusterStrategy(bGDClusterStrategy);
        }
    }

    public void enableItemsCollision(boolean z) {
        BaseLayerImpl baseLayerImpl = this.mService;
        if (baseLayerImpl != null) {
            baseLayerImpl.$explicit_enableItemsCollision(z);
        }
    }

    public boolean isItemsCollision() {
        BaseLayerImpl baseLayerImpl = this.mService;
        if (baseLayerImpl != null) {
            return baseLayerImpl.$explicit_isItemsCollision();
        }
        return false;
    }

    public void enablePoiFilter(boolean z) {
        BaseLayerImpl baseLayerImpl = this.mService;
        if (baseLayerImpl != null) {
            baseLayerImpl.$explicit_enablePoiFilter(z);
        }
    }

    public boolean isEnablePoiFilter() {
        BaseLayerImpl baseLayerImpl = this.mService;
        if (baseLayerImpl != null) {
            return baseLayerImpl.$explicit_isEnablePoiFilter();
        }
        return false;
    }

    public MapView getMapView() {
        IMapViewImpl $explicit_getMapView;
        TypeHelper typeHelper;
        try {
            Method method = BaseLayer.class.getMethod("getMapView", new Class[0]);
            BaseLayerImpl baseLayerImpl = this.mService;
            if (baseLayerImpl == null || ($explicit_getMapView = baseLayerImpl.$explicit_getMapView()) == null || (typeHelper = this.mTypeHelper) == null) {
                return null;
            }
            return (MapView) typeHelper.transfer(method, -1, (Object) $explicit_getMapView, true);
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    @Override // com.autonavi.gbl.map.CollisionGroup
    public boolean addCollisionItem(ICollisionItem iCollisionItem) {
        TypeHelper typeHelper;
        try {
            Method method = BaseLayer.class.getMethod("addCollisionItem", ICollisionItem.class);
            CollisionItemImpl collisionItemImpl = null;
            if (iCollisionItem != null && (typeHelper = this.mTypeHelper) != null) {
                collisionItemImpl = (CollisionItemImpl) typeHelper.transfer(method, 0, iCollisionItem);
            }
            BaseLayerImpl baseLayerImpl = this.mService;
            if (baseLayerImpl != null) {
                return baseLayerImpl.$explicit_addCollisionItem(collisionItemImpl);
            }
            return false;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return false;
        }
    }

    public void setFilterPoiType(int i) {
        BaseLayerImpl baseLayerImpl = this.mService;
        if (baseLayerImpl != null) {
            baseLayerImpl.$explicit_setFilterPoiType(i);
        }
    }

    public void resetOverlayType(int i) {
        BaseLayerImpl baseLayerImpl = this.mService;
        if (baseLayerImpl != null) {
            baseLayerImpl.$explicit_resetOverlayType(i);
        }
    }

    @Override // com.autonavi.gbl.map.layer.observer.IBaseLayer
    public String getName() {
        BaseLayerImpl baseLayerImpl = this.mService;
        if (baseLayerImpl != null) {
            return baseLayerImpl.$explicit_getName();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.observer.IBaseLayer
    public long getLayerID() {
        BaseLayerImpl baseLayerImpl = this.mService;
        if (baseLayerImpl != null) {
            return baseLayerImpl.$explicit_getLayerID();
        }
        return 0L;
    }

    @Override // com.autonavi.gbl.map.layer.observer.IBaseLayer
    public LayerItem getItem(String str) {
        LayerItemImpl $explicit_getItem;
        TypeHelper typeHelper;
        try {
            Method method = BaseLayer.class.getMethod("getItem", String.class);
            BaseLayerImpl baseLayerImpl = this.mService;
            if (baseLayerImpl == null || ($explicit_getItem = baseLayerImpl.$explicit_getItem(str)) == null || (typeHelper = this.mTypeHelper) == null) {
                return null;
            }
            return (LayerItem) typeHelper.transfer(method, -1, (Object) $explicit_getItem, true);
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    @Override // com.autonavi.gbl.map.layer.observer.IBaseLayer
    public ArrayList<LayerItem> getAllItems() {
        ArrayList<LayerItemImpl> $explicit_getAllItems;
        TypeHelper typeHelper;
        try {
            Method method = BaseLayer.class.getMethod("getAllItems", new Class[0]);
            BaseLayerImpl baseLayerImpl = this.mService;
            if (baseLayerImpl == null || ($explicit_getAllItems = baseLayerImpl.$explicit_getAllItems()) == null || (typeHelper = this.mTypeHelper) == null) {
                return null;
            }
            return (ArrayList) typeHelper.transfer(method, -1, (ArrayList) $explicit_getAllItems, true);
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    @Override // com.autonavi.gbl.map.layer.observer.IBaseLayer
    public int getCount() {
        BaseLayerImpl baseLayerImpl = this.mService;
        if (baseLayerImpl != null) {
            return baseLayerImpl.$explicit_getCount();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.observer.IBaseLayer
    public boolean getVisible() {
        BaseLayerImpl baseLayerImpl = this.mService;
        if (baseLayerImpl != null) {
            return baseLayerImpl.$explicit_getVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.observer.IBaseLayer
    public boolean getClickable() {
        BaseLayerImpl baseLayerImpl = this.mService;
        if (baseLayerImpl != null) {
            return baseLayerImpl.$explicit_getClickable();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.observer.IBaseLayer
    public LayerScale getDisplayScale() {
        LayerScale layerScale = new LayerScale();
        getDisplayScale(layerScale);
        return layerScale;
    }

    private void getDisplayScale(LayerScale layerScale) {
        BaseLayerImpl baseLayerImpl = this.mService;
        if (baseLayerImpl != null) {
            baseLayerImpl.$explicit_getDisplayScale(layerScale);
        }
    }

    @Override // com.autonavi.gbl.map.layer.observer.IBaseLayer
    public boolean getFocus(String str) {
        BaseLayerImpl baseLayerImpl = this.mService;
        if (baseLayerImpl != null) {
            return baseLayerImpl.$explicit_getFocus(str);
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.observer.IBaseLayer
    public RectDouble getBound() {
        BaseLayerImpl baseLayerImpl = this.mService;
        if (baseLayerImpl != null) {
            return baseLayerImpl.$explicit_getBound();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.CollisionGroup, com.autonavi.gbl.map.observer.ICollisionGroup
    public LayerPriority getPriority() {
        LayerPriority layerPriority = new LayerPriority();
        getPriority(layerPriority);
        return layerPriority;
    }

    private void getPriority(LayerPriority layerPriority) {
        BaseLayerImpl baseLayerImpl = this.mService;
        if (baseLayerImpl != null) {
            baseLayerImpl.$explicit_getPriority(layerPriority);
        }
    }

    @Override // com.autonavi.gbl.map.layer.observer.IBaseLayer
    public void onPaint() {
        BaseLayerImpl baseLayerImpl = this.mService;
        if (baseLayerImpl != null) {
            baseLayerImpl.$explicit_onPaint();
        }
    }

    @Override // com.autonavi.gbl.map.CollisionGroup, com.autonavi.gbl.map.observer.ICollisionGroup, com.autonavi.gbl.map.observer.ICollisionEntity
    public void enableCollision(boolean z) {
        BaseLayerImpl baseLayerImpl = this.mService;
        if (baseLayerImpl != null) {
            baseLayerImpl.$explicit_enableCollision(z);
        }
    }

    @Override // com.autonavi.gbl.map.CollisionGroup, com.autonavi.gbl.map.observer.ICollisionGroup
    public void updateQuadrantItems() {
        BaseLayerImpl baseLayerImpl = this.mService;
        if (baseLayerImpl != null) {
            baseLayerImpl.$explicit_updateQuadrantItems();
        }
    }

    @Override // com.autonavi.gbl.map.CollisionGroup, com.autonavi.gbl.map.observer.ICollisionGroup
    public void applyItemsOnVisible() {
        BaseLayerImpl baseLayerImpl = this.mService;
        if (baseLayerImpl != null) {
            baseLayerImpl.$explicit_applyItemsOnVisible();
        }
    }

    @Override // com.autonavi.gbl.map.CollisionGroup, com.autonavi.gbl.map.observer.ICollisionGroup
    public void intersectUI(ArrayList<UIRectRecord> arrayList) {
        BaseLayerImpl baseLayerImpl = this.mService;
        if (baseLayerImpl != null) {
            baseLayerImpl.$explicit_intersectUI(arrayList);
        }
    }

    @Override // com.autonavi.gbl.map.CollisionGroup, com.autonavi.gbl.map.observer.ICollisionGroup, com.autonavi.gbl.map.observer.ICollisionEntity
    public void lockItems() {
        BaseLayerImpl baseLayerImpl = this.mService;
        if (baseLayerImpl != null) {
            baseLayerImpl.$explicit_lockItems();
        }
    }

    @Override // com.autonavi.gbl.map.CollisionGroup, com.autonavi.gbl.map.observer.ICollisionGroup, com.autonavi.gbl.map.observer.ICollisionEntity
    public void unLockItems() {
        BaseLayerImpl baseLayerImpl = this.mService;
        if (baseLayerImpl != null) {
            baseLayerImpl.$explicit_unLockItems();
        }
    }

    @Override // com.autonavi.gbl.map.layer.observer.IBaseLayer
    public int getFilterPoiType() {
        BaseLayerImpl baseLayerImpl = this.mService;
        if (baseLayerImpl != null) {
            return baseLayerImpl.$explicit_getFilterPoiType();
        }
        return 0;
    }
}
