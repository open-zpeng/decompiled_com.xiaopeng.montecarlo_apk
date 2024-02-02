package com.autonavi.gbl.map.layer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.common.model.RectDouble;
import com.autonavi.gbl.map.creflex.BaseLayerCRfxProto;
import com.autonavi.gbl.map.impl.CollisionGroupImpl;
import com.autonavi.gbl.map.impl.ICollisionItemImpl;
import com.autonavi.gbl.map.impl.ICollisonRemoveObseverImpl;
import com.autonavi.gbl.map.impl.MapViewImpl;
import com.autonavi.gbl.map.layer.BaseLayer;
import com.autonavi.gbl.map.layer.model.BGDClusterStrategy;
import com.autonavi.gbl.map.layer.model.Layer3DModel;
import com.autonavi.gbl.map.layer.model.LayerPriority;
import com.autonavi.gbl.map.layer.model.LayerScale;
import com.autonavi.gbl.map.layer.model.LayerTexture;
import com.autonavi.gbl.map.layer.observer.impl.ILayerClickObserverImpl;
import com.autonavi.gbl.map.layer.observer.impl.ILayerFocusChangeObserverImpl;
import com.autonavi.gbl.map.layer.observer.impl.IPrepareLayerStyleImpl;
import java.util.ArrayList;
@IntfAuto(enableCRfx = true, protoOfCRfx = BaseLayerCRfxProto.class, target = BaseLayer.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class BaseLayerImpl extends CollisionGroupImpl {
    private static BindTable BIND_TABLE = new BindTable(BaseLayerImpl.class);
    private transient long swigCPtr;

    private static native long BaseLayerImpl_SWIGUpcast(long j);

    private static native void BaseLayerImpl_change_ownership(BaseLayerImpl baseLayerImpl, long j, boolean z);

    private static native void BaseLayerImpl_director_connect(BaseLayerImpl baseLayerImpl, long j, boolean z, boolean z2);

    private static native void addClickObserverNative(long j, BaseLayerImpl baseLayerImpl, long j2, ILayerClickObserverImpl iLayerClickObserverImpl);

    private static native void addClickObserverSwigExplicitBaseLayerImplNative(long j, BaseLayerImpl baseLayerImpl, long j2, ILayerClickObserverImpl iLayerClickObserverImpl);

    private static native boolean addCollisionItemNative(long j, BaseLayerImpl baseLayerImpl, long j2, ICollisionItemImpl iCollisionItemImpl);

    private static native boolean addCollisionItemSwigExplicitBaseLayerImplNative(long j, BaseLayerImpl baseLayerImpl, long j2, ICollisionItemImpl iCollisionItemImpl);

    private static native void addCollisonRemoveObseverNative(long j, BaseLayerImpl baseLayerImpl, long j2, ICollisonRemoveObseverImpl iCollisonRemoveObseverImpl);

    private static native void addCollisonRemoveObseverSwigExplicitBaseLayerImplNative(long j, BaseLayerImpl baseLayerImpl, long j2, ICollisonRemoveObseverImpl iCollisonRemoveObseverImpl);

    private static native void addFocusChangeObserverNative(long j, BaseLayerImpl baseLayerImpl, long j2, ILayerFocusChangeObserverImpl iLayerFocusChangeObserverImpl);

    private static native void addFocusChangeObserverSwigExplicitBaseLayerImplNative(long j, BaseLayerImpl baseLayerImpl, long j2, ILayerFocusChangeObserverImpl iLayerFocusChangeObserverImpl);

    private static native boolean addItemNative(long j, BaseLayerImpl baseLayerImpl, long j2, LayerItemImpl layerItemImpl);

    private static native boolean addItemSwigExplicitBaseLayerImplNative(long j, BaseLayerImpl baseLayerImpl, long j2, LayerItemImpl layerItemImpl);

    private static native void addItems1Native(long j, BaseLayerImpl baseLayerImpl, long[] jArr);

    private static native void addItemsNative(long j, BaseLayerImpl baseLayerImpl, long[] jArr, boolean z);

    private static native void addItemsSwigExplicitBaseLayerImpl1Native(long j, BaseLayerImpl baseLayerImpl, long[] jArr);

    private static native void addItemsSwigExplicitBaseLayerImplNative(long j, BaseLayerImpl baseLayerImpl, long[] jArr, boolean z);

    private static native boolean addLayer3DModelNative(long j, BaseLayerImpl baseLayerImpl, long j2, Layer3DModel layer3DModel);

    private static native boolean addLayer3DModelSwigExplicitBaseLayerImplNative(long j, BaseLayerImpl baseLayerImpl, long j2, Layer3DModel layer3DModel);

    private static native void addLayerTextureNative(long j, BaseLayerImpl baseLayerImpl, long j2, LayerTexture layerTexture);

    private static native void addLayerTextureSwigExplicitBaseLayerImplNative(long j, BaseLayerImpl baseLayerImpl, long j2, LayerTexture layerTexture);

    private static native void clearAllItemsNative(long j, BaseLayerImpl baseLayerImpl);

    private static native void clearAllItemsSwigExplicitBaseLayerImplNative(long j, BaseLayerImpl baseLayerImpl);

    private static native void clearFocusNative(long j, BaseLayerImpl baseLayerImpl);

    private static native void clearFocusSwigExplicitBaseLayerImplNative(long j, BaseLayerImpl baseLayerImpl);

    private static native long createNativeObj(String str, long j, MapViewImpl mapViewImpl);

    private static native boolean destroyLayer3DModelNative(long j, BaseLayerImpl baseLayerImpl, int i);

    private static native boolean destroyLayer3DModelSwigExplicitBaseLayerImplNative(long j, BaseLayerImpl baseLayerImpl, int i);

    private static native void destroyNativeObj(long j);

    private static native boolean enableClusterNative(long j, BaseLayerImpl baseLayerImpl, boolean z);

    private static native boolean enableClusterSwigExplicitBaseLayerImplNative(long j, BaseLayerImpl baseLayerImpl, boolean z);

    private static native void enableCollisionNative(long j, BaseLayerImpl baseLayerImpl, boolean z);

    private static native void enableCollisionSwigExplicitBaseLayerImplNative(long j, BaseLayerImpl baseLayerImpl, boolean z);

    private static native void enableItemsCollisionNative(long j, BaseLayerImpl baseLayerImpl, boolean z);

    private static native void enableItemsCollisionSwigExplicitBaseLayerImplNative(long j, BaseLayerImpl baseLayerImpl, boolean z);

    private static native void enablePoiFilterNative(long j, BaseLayerImpl baseLayerImpl, boolean z);

    private static native void enablePoiFilterSwigExplicitBaseLayerImplNative(long j, BaseLayerImpl baseLayerImpl, boolean z);

    private static native ArrayList<LayerItemImpl> getAllItemsNative(long j, BaseLayerImpl baseLayerImpl);

    private static native ArrayList<LayerItemImpl> getAllItemsSwigExplicitBaseLayerImplNative(long j, BaseLayerImpl baseLayerImpl);

    private static native RectDouble getBoundNative(long j, BaseLayerImpl baseLayerImpl);

    private static native RectDouble getBoundSwigExplicitBaseLayerImplNative(long j, BaseLayerImpl baseLayerImpl);

    private static native String getClassTypeNameNative();

    private static native boolean getClickableNative(long j, BaseLayerImpl baseLayerImpl);

    private static native boolean getClickableSwigExplicitBaseLayerImplNative(long j, BaseLayerImpl baseLayerImpl);

    private static native int getCountNative(long j, BaseLayerImpl baseLayerImpl);

    private static native int getCountSwigExplicitBaseLayerImplNative(long j, BaseLayerImpl baseLayerImpl);

    private static native void getDisplayScaleNative(long j, BaseLayerImpl baseLayerImpl, long j2, LayerScale layerScale);

    private static native void getDisplayScaleSwigExplicitBaseLayerImplNative(long j, BaseLayerImpl baseLayerImpl, long j2, LayerScale layerScale);

    private static native int getFilterPoiTypeNative(long j, BaseLayerImpl baseLayerImpl);

    private static native int getFilterPoiTypeSwigExplicitBaseLayerImplNative(long j, BaseLayerImpl baseLayerImpl);

    private static native long getItemNative(long j, BaseLayerImpl baseLayerImpl, String str);

    private static native long getItemSwigExplicitBaseLayerImplNative(long j, BaseLayerImpl baseLayerImpl, String str);

    private static native long getLayerIDNative(long j, BaseLayerImpl baseLayerImpl);

    private static native long getLayerIDSwigExplicitBaseLayerImplNative(long j, BaseLayerImpl baseLayerImpl);

    private static native long getMapViewNative(long j, BaseLayerImpl baseLayerImpl);

    private static native String getNameNative(long j, BaseLayerImpl baseLayerImpl);

    private static native String getNameSwigExplicitBaseLayerImplNative(long j, BaseLayerImpl baseLayerImpl);

    private static native void getPriorityNative(long j, BaseLayerImpl baseLayerImpl, long j2, LayerPriority layerPriority);

    private static native void getPrioritySwigExplicitBaseLayerImplNative(long j, BaseLayerImpl baseLayerImpl, long j2, LayerPriority layerPriority);

    private static native String getTypeIdNameNative(long j, BaseLayerImpl baseLayerImpl);

    private static native String getTypeIdNameSwigExplicitBaseLayerImplNative(long j, BaseLayerImpl baseLayerImpl);

    private static native boolean getVisibleNative(long j, BaseLayerImpl baseLayerImpl);

    private static native boolean getVisibleSwigExplicitBaseLayerImplNative(long j, BaseLayerImpl baseLayerImpl);

    private static native void intersectUINative(long j, BaseLayerImpl baseLayerImpl, ArrayList<RectDouble> arrayList);

    private static native void intersectUISwigExplicitBaseLayerImplNative(long j, BaseLayerImpl baseLayerImpl, ArrayList<RectDouble> arrayList);

    private static native void lockItemsNative(long j, BaseLayerImpl baseLayerImpl);

    private static native void lockItemsSwigExplicitBaseLayerImplNative(long j, BaseLayerImpl baseLayerImpl);

    private static native void onPaintNative(long j, BaseLayerImpl baseLayerImpl);

    private static native void onPaintSwigExplicitBaseLayerImplNative(long j, BaseLayerImpl baseLayerImpl);

    private static native void removeClickObserverNative(long j, BaseLayerImpl baseLayerImpl, long j2, ILayerClickObserverImpl iLayerClickObserverImpl);

    private static native void removeClickObserverSwigExplicitBaseLayerImplNative(long j, BaseLayerImpl baseLayerImpl, long j2, ILayerClickObserverImpl iLayerClickObserverImpl);

    private static native void removeCollisonRemoveObseverNative(long j, BaseLayerImpl baseLayerImpl, long j2, ICollisonRemoveObseverImpl iCollisonRemoveObseverImpl);

    private static native void removeCollisonRemoveObseverSwigExplicitBaseLayerImplNative(long j, BaseLayerImpl baseLayerImpl, long j2, ICollisonRemoveObseverImpl iCollisonRemoveObseverImpl);

    private static native void removeFocusChangeObserverNative(long j, BaseLayerImpl baseLayerImpl, long j2, ILayerFocusChangeObserverImpl iLayerFocusChangeObserverImpl);

    private static native void removeFocusChangeObserverSwigExplicitBaseLayerImplNative(long j, BaseLayerImpl baseLayerImpl, long j2, ILayerFocusChangeObserverImpl iLayerFocusChangeObserverImpl);

    private static native void removeItemNative(long j, BaseLayerImpl baseLayerImpl, String str);

    private static native void removeItemSwigExplicitBaseLayerImplNative(long j, BaseLayerImpl baseLayerImpl, String str);

    private static native void removeItemsNative(long j, BaseLayerImpl baseLayerImpl, String[] strArr);

    private static native void removeItemsSwigExplicitBaseLayerImplNative(long j, BaseLayerImpl baseLayerImpl, String[] strArr);

    private static native void removeLayerTextureNative(long j, BaseLayerImpl baseLayerImpl, int i);

    private static native void removeLayerTextureSwigExplicitBaseLayerImplNative(long j, BaseLayerImpl baseLayerImpl, int i);

    private static native void setBGDClusterStrategyNative(long j, BaseLayerImpl baseLayerImpl, long j2, BGDClusterStrategy bGDClusterStrategy);

    private static native void setBGDClusterStrategySwigExplicitBaseLayerImplNative(long j, BaseLayerImpl baseLayerImpl, long j2, BGDClusterStrategy bGDClusterStrategy);

    private static native void setClickableNative(long j, BaseLayerImpl baseLayerImpl, boolean z);

    private static native void setClickableSwigExplicitBaseLayerImplNative(long j, BaseLayerImpl baseLayerImpl, boolean z);

    private static native void setDisplayScaleNative(long j, BaseLayerImpl baseLayerImpl, long j2, LayerScale layerScale);

    private static native void setDisplayScaleSwigExplicitBaseLayerImplNative(long j, BaseLayerImpl baseLayerImpl, long j2, LayerScale layerScale);

    private static native void setFilterPoiTypeNative(long j, BaseLayerImpl baseLayerImpl, int i);

    private static native void setFilterPoiTypeSwigExplicitBaseLayerImplNative(long j, BaseLayerImpl baseLayerImpl, int i);

    private static native void setFocusNative(long j, BaseLayerImpl baseLayerImpl, String str, boolean z);

    private static native void setFocusSwigExplicitBaseLayerImplNative(long j, BaseLayerImpl baseLayerImpl, String str, boolean z);

    private static native void setNameNative(long j, BaseLayerImpl baseLayerImpl, String str);

    private static native void setNameSwigExplicitBaseLayerImplNative(long j, BaseLayerImpl baseLayerImpl, String str);

    private static native void setPriorityNative(long j, BaseLayerImpl baseLayerImpl, long j2, LayerPriority layerPriority);

    private static native void setPrioritySwigExplicitBaseLayerImplNative(long j, BaseLayerImpl baseLayerImpl, long j2, LayerPriority layerPriority);

    private static native void setStyleNative(long j, BaseLayerImpl baseLayerImpl, long j2, IPrepareLayerStyleImpl iPrepareLayerStyleImpl);

    private static native void setStyleSwigExplicitBaseLayerImplNative(long j, BaseLayerImpl baseLayerImpl, long j2, IPrepareLayerStyleImpl iPrepareLayerStyleImpl);

    private static native void setVisibleNative(long j, BaseLayerImpl baseLayerImpl, boolean z);

    private static native void setVisibleSwigExplicitBaseLayerImplNative(long j, BaseLayerImpl baseLayerImpl, boolean z);

    private static native void sortNative(long j, BaseLayerImpl baseLayerImpl);

    private static native void sortSwigExplicitBaseLayerImplNative(long j, BaseLayerImpl baseLayerImpl);

    private static native void unLockItemsNative(long j, BaseLayerImpl baseLayerImpl);

    private static native void unLockItemsSwigExplicitBaseLayerImplNative(long j, BaseLayerImpl baseLayerImpl);

    private static native void updateQuadrantItemsNative(long j, BaseLayerImpl baseLayerImpl);

    private static native void updateQuadrantItemsSwigExplicitBaseLayerImplNative(long j, BaseLayerImpl baseLayerImpl);

    private static native void updateStyleNative(long j, BaseLayerImpl baseLayerImpl);

    private static native void updateStyleSwigExplicitBaseLayerImplNative(long j, BaseLayerImpl baseLayerImpl);

    public BaseLayerImpl(long j, boolean z) {
        super(BaseLayerImpl_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    @Override // com.autonavi.gbl.map.impl.CollisionGroupImpl, com.autonavi.gbl.map.impl.ICollisionEntityImpl
    public int hashCode() {
        return super.hashCode();
    }

    @Override // com.autonavi.gbl.map.impl.CollisionGroupImpl, com.autonavi.gbl.map.impl.ICollisionEntityImpl
    public boolean equals(Object obj) {
        if (obj instanceof BaseLayerImpl) {
            return getUID(this) == getUID((BaseLayerImpl) obj);
        }
        return super.equals(obj);
    }

    private static long getUID(BaseLayerImpl baseLayerImpl) {
        long cPtr = getCPtr(baseLayerImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(BaseLayerImpl baseLayerImpl) {
        if (baseLayerImpl == null) {
            return 0L;
        }
        return baseLayerImpl.swigCPtr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.impl.CollisionGroupImpl, com.autonavi.gbl.map.impl.ICollisionEntityImpl
    public synchronized void delete() {
        LogUtils.d(String.format("swigCPtr=%%s, swigCMemOwn=%%s", String.valueOf(this.swigCPtr), String.valueOf(this.swigCMemOwn)));
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                destroyNativeObj(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
        super.delete();
    }

    @Override // com.autonavi.gbl.map.impl.CollisionGroupImpl, com.autonavi.gbl.map.impl.ICollisionEntityImpl
    protected void swigDirectorDisconnect() {
        this.swigCMemOwn = false;
        delete();
    }

    @Override // com.autonavi.gbl.map.impl.CollisionGroupImpl, com.autonavi.gbl.map.impl.ICollisionEntityImpl
    public void swigReleaseOwnership() {
        this.swigCMemOwn = false;
        BaseLayerImpl_change_ownership(this, this.swigCPtr, false);
    }

    @Override // com.autonavi.gbl.map.impl.CollisionGroupImpl, com.autonavi.gbl.map.impl.ICollisionEntityImpl
    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        BaseLayerImpl_change_ownership(this, this.swigCPtr, true);
    }

    public static String getClassTypeName() {
        return getClassTypeNameNative();
    }

    public BaseLayerImpl(String str, MapViewImpl mapViewImpl) {
        this(createNativeObj(str, MapViewImpl.getCPtr(mapViewImpl), mapViewImpl), true);
        MapLayerSvrJNI.swig_jni_init();
        BaseLayerImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }

    public void setName(String str) {
        $explicit_setName(str);
    }

    public void $explicit_setName(String str) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == BaseLayerImpl.class) {
            setNameNative(this.swigCPtr, this, str);
        } else {
            setNameSwigExplicitBaseLayerImplNative(this.swigCPtr, this, str);
        }
    }

    public String getName() {
        return $explicit_getName();
    }

    public String $explicit_getName() {
        if (this.swigCPtr == 0) {
            return null;
        }
        return getClass() == BaseLayerImpl.class ? getNameNative(this.swigCPtr, this) : getNameSwigExplicitBaseLayerImplNative(this.swigCPtr, this);
    }

    public long getLayerID() {
        return $explicit_getLayerID();
    }

    public long $explicit_getLayerID() {
        if (this.swigCPtr == 0) {
            return 0L;
        }
        return getClass() == BaseLayerImpl.class ? getLayerIDNative(this.swigCPtr, this) : getLayerIDSwigExplicitBaseLayerImplNative(this.swigCPtr, this);
    }

    public boolean addLayer3DModel(Layer3DModel layer3DModel) {
        return $explicit_addLayer3DModel(layer3DModel);
    }

    public boolean $explicit_addLayer3DModel(Layer3DModel layer3DModel) {
        if (this.swigCPtr == 0) {
            return false;
        }
        return getClass() == BaseLayerImpl.class ? addLayer3DModelNative(this.swigCPtr, this, 0L, layer3DModel) : addLayer3DModelSwigExplicitBaseLayerImplNative(this.swigCPtr, this, 0L, layer3DModel);
    }

    public boolean destroyLayer3DModel(int i) {
        return $explicit_destroyLayer3DModel(i);
    }

    public boolean $explicit_destroyLayer3DModel(int i) {
        if (this.swigCPtr == 0) {
            return false;
        }
        return getClass() == BaseLayerImpl.class ? destroyLayer3DModelNative(this.swigCPtr, this, i) : destroyLayer3DModelSwigExplicitBaseLayerImplNative(this.swigCPtr, this, i);
    }

    public void addLayerTexture(LayerTexture layerTexture) {
        $explicit_addLayerTexture(layerTexture);
    }

    public void $explicit_addLayerTexture(LayerTexture layerTexture) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == BaseLayerImpl.class) {
            addLayerTextureNative(this.swigCPtr, this, 0L, layerTexture);
        } else {
            addLayerTextureSwigExplicitBaseLayerImplNative(this.swigCPtr, this, 0L, layerTexture);
        }
    }

    public void removeLayerTexture(int i) {
        $explicit_removeLayerTexture(i);
    }

    public void $explicit_removeLayerTexture(int i) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == BaseLayerImpl.class) {
            removeLayerTextureNative(this.swigCPtr, this, i);
        } else {
            removeLayerTextureSwigExplicitBaseLayerImplNative(this.swigCPtr, this, i);
        }
    }

    public boolean addItem(LayerItemImpl layerItemImpl) {
        return $explicit_addItem(layerItemImpl);
    }

    public boolean $explicit_addItem(LayerItemImpl layerItemImpl) {
        if (this.swigCPtr == 0) {
            return false;
        }
        return getClass() == BaseLayerImpl.class ? addItemNative(this.swigCPtr, this, LayerItemImpl.getCPtr(layerItemImpl), layerItemImpl) : addItemSwigExplicitBaseLayerImplNative(this.swigCPtr, this, LayerItemImpl.getCPtr(layerItemImpl), layerItemImpl);
    }

    public void addItems(ArrayList<LayerItemImpl> arrayList, boolean z) {
        $explicit_addItems(arrayList, z);
    }

    public void $explicit_addItems(ArrayList<LayerItemImpl> arrayList, boolean z) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        long[] jArr = null;
        if (arrayList != null) {
            int size = arrayList.size();
            long[] jArr2 = new long[size];
            for (int i = 0; i < size; i++) {
                jArr2[i] = LayerItemImpl.getCPtr(arrayList.get(i));
            }
            jArr = jArr2;
        }
        if (getClass() == BaseLayerImpl.class) {
            addItemsNative(this.swigCPtr, this, jArr, z);
        } else {
            addItemsSwigExplicitBaseLayerImplNative(this.swigCPtr, this, jArr, z);
        }
    }

    public void addItems(ArrayList<LayerItemImpl> arrayList) {
        $explicit_addItems(arrayList);
    }

    public void $explicit_addItems(ArrayList<LayerItemImpl> arrayList) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        long[] jArr = null;
        if (arrayList != null) {
            int size = arrayList.size();
            long[] jArr2 = new long[size];
            for (int i = 0; i < size; i++) {
                jArr2[i] = LayerItemImpl.getCPtr(arrayList.get(i));
            }
            jArr = jArr2;
        }
        if (getClass() == BaseLayerImpl.class) {
            addItems1Native(this.swigCPtr, this, jArr);
        } else {
            addItemsSwigExplicitBaseLayerImpl1Native(this.swigCPtr, this, jArr);
        }
    }

    public void removeItem(String str) {
        $explicit_removeItem(str);
    }

    public void $explicit_removeItem(String str) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == BaseLayerImpl.class) {
            removeItemNative(this.swigCPtr, this, str);
        } else {
            removeItemSwigExplicitBaseLayerImplNative(this.swigCPtr, this, str);
        }
    }

    public void removeItems(String[] strArr) {
        $explicit_removeItems(strArr);
    }

    public void $explicit_removeItems(String[] strArr) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == BaseLayerImpl.class) {
            removeItemsNative(this.swigCPtr, this, strArr);
        } else {
            removeItemsSwigExplicitBaseLayerImplNative(this.swigCPtr, this, strArr);
        }
    }

    public LayerItemImpl getItem(String str) {
        return $explicit_getItem(str);
    }

    public LayerItemImpl $explicit_getItem(String str) {
        if (this.swigCPtr == 0) {
            return null;
        }
        long itemNative = getClass() == BaseLayerImpl.class ? getItemNative(this.swigCPtr, this, str) : getItemSwigExplicitBaseLayerImplNative(this.swigCPtr, this, str);
        if (itemNative == 0) {
            return null;
        }
        return new LayerItemImpl(itemNative, false);
    }

    public ArrayList<LayerItemImpl> getAllItems() {
        return $explicit_getAllItems();
    }

    public ArrayList<LayerItemImpl> $explicit_getAllItems() {
        if (this.swigCPtr == 0) {
            return null;
        }
        return getClass() == BaseLayerImpl.class ? getAllItemsNative(this.swigCPtr, this) : getAllItemsSwigExplicitBaseLayerImplNative(this.swigCPtr, this);
    }

    public int getCount() {
        return $explicit_getCount();
    }

    public int $explicit_getCount() {
        if (this.swigCPtr == 0) {
            return 0;
        }
        return getClass() == BaseLayerImpl.class ? getCountNative(this.swigCPtr, this) : getCountSwigExplicitBaseLayerImplNative(this.swigCPtr, this);
    }

    public void clearAllItems() {
        $explicit_clearAllItems();
    }

    public void $explicit_clearAllItems() {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == BaseLayerImpl.class) {
            clearAllItemsNative(this.swigCPtr, this);
        } else {
            clearAllItemsSwigExplicitBaseLayerImplNative(this.swigCPtr, this);
        }
    }

    public void setVisible(boolean z) {
        $explicit_setVisible(z);
    }

    public void $explicit_setVisible(boolean z) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == BaseLayerImpl.class) {
            setVisibleNative(this.swigCPtr, this, z);
        } else {
            setVisibleSwigExplicitBaseLayerImplNative(this.swigCPtr, this, z);
        }
    }

    public boolean getVisible() {
        return $explicit_getVisible();
    }

    public boolean $explicit_getVisible() {
        if (this.swigCPtr == 0) {
            return false;
        }
        return getClass() == BaseLayerImpl.class ? getVisibleNative(this.swigCPtr, this) : getVisibleSwigExplicitBaseLayerImplNative(this.swigCPtr, this);
    }

    public void setClickable(boolean z) {
        $explicit_setClickable(z);
    }

    public void $explicit_setClickable(boolean z) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == BaseLayerImpl.class) {
            setClickableNative(this.swigCPtr, this, z);
        } else {
            setClickableSwigExplicitBaseLayerImplNative(this.swigCPtr, this, z);
        }
    }

    public boolean getClickable() {
        return $explicit_getClickable();
    }

    public boolean $explicit_getClickable() {
        if (this.swigCPtr == 0) {
            return false;
        }
        return getClass() == BaseLayerImpl.class ? getClickableNative(this.swigCPtr, this) : getClickableSwigExplicitBaseLayerImplNative(this.swigCPtr, this);
    }

    public void addClickObserver(ILayerClickObserverImpl iLayerClickObserverImpl) {
        $explicit_addClickObserver(iLayerClickObserverImpl);
    }

    public void $explicit_addClickObserver(ILayerClickObserverImpl iLayerClickObserverImpl) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == BaseLayerImpl.class) {
            addClickObserverNative(this.swigCPtr, this, ILayerClickObserverImpl.getCPtr(iLayerClickObserverImpl), iLayerClickObserverImpl);
        } else {
            addClickObserverSwigExplicitBaseLayerImplNative(this.swigCPtr, this, ILayerClickObserverImpl.getCPtr(iLayerClickObserverImpl), iLayerClickObserverImpl);
        }
    }

    public void removeClickObserver(ILayerClickObserverImpl iLayerClickObserverImpl) {
        $explicit_removeClickObserver(iLayerClickObserverImpl);
    }

    public void $explicit_removeClickObserver(ILayerClickObserverImpl iLayerClickObserverImpl) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == BaseLayerImpl.class) {
            removeClickObserverNative(this.swigCPtr, this, ILayerClickObserverImpl.getCPtr(iLayerClickObserverImpl), iLayerClickObserverImpl);
        } else {
            removeClickObserverSwigExplicitBaseLayerImplNative(this.swigCPtr, this, ILayerClickObserverImpl.getCPtr(iLayerClickObserverImpl), iLayerClickObserverImpl);
        }
    }

    public void setDisplayScale(LayerScale layerScale) {
        $explicit_setDisplayScale(layerScale);
    }

    public void $explicit_setDisplayScale(LayerScale layerScale) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == BaseLayerImpl.class) {
            setDisplayScaleNative(this.swigCPtr, this, 0L, layerScale);
        } else {
            setDisplayScaleSwigExplicitBaseLayerImplNative(this.swigCPtr, this, 0L, layerScale);
        }
    }

    public void getDisplayScale(LayerScale layerScale) {
        $explicit_getDisplayScale(layerScale);
    }

    public void $explicit_getDisplayScale(LayerScale layerScale) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == BaseLayerImpl.class) {
            getDisplayScaleNative(this.swigCPtr, this, 0L, layerScale);
        } else {
            getDisplayScaleSwigExplicitBaseLayerImplNative(this.swigCPtr, this, 0L, layerScale);
        }
    }

    public void setStyle(IPrepareLayerStyleImpl iPrepareLayerStyleImpl) {
        $explicit_setStyle(iPrepareLayerStyleImpl);
    }

    public void $explicit_setStyle(IPrepareLayerStyleImpl iPrepareLayerStyleImpl) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == BaseLayerImpl.class) {
            setStyleNative(this.swigCPtr, this, IPrepareLayerStyleImpl.getCPtr(iPrepareLayerStyleImpl), iPrepareLayerStyleImpl);
        } else {
            setStyleSwigExplicitBaseLayerImplNative(this.swigCPtr, this, IPrepareLayerStyleImpl.getCPtr(iPrepareLayerStyleImpl), iPrepareLayerStyleImpl);
        }
    }

    public void updateStyle() {
        $explicit_updateStyle();
    }

    public void $explicit_updateStyle() {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == BaseLayerImpl.class) {
            updateStyleNative(this.swigCPtr, this);
        } else {
            updateStyleSwigExplicitBaseLayerImplNative(this.swigCPtr, this);
        }
    }

    public void setFocus(String str, boolean z) {
        $explicit_setFocus(str, z);
    }

    public void $explicit_setFocus(String str, boolean z) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == BaseLayerImpl.class) {
            setFocusNative(this.swigCPtr, this, str, z);
        } else {
            setFocusSwigExplicitBaseLayerImplNative(this.swigCPtr, this, str, z);
        }
    }

    public void clearFocus() {
        $explicit_clearFocus();
    }

    public void $explicit_clearFocus() {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == BaseLayerImpl.class) {
            clearFocusNative(this.swigCPtr, this);
        } else {
            clearFocusSwigExplicitBaseLayerImplNative(this.swigCPtr, this);
        }
    }

    public void addFocusChangeObserver(ILayerFocusChangeObserverImpl iLayerFocusChangeObserverImpl) {
        $explicit_addFocusChangeObserver(iLayerFocusChangeObserverImpl);
    }

    public void $explicit_addFocusChangeObserver(ILayerFocusChangeObserverImpl iLayerFocusChangeObserverImpl) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == BaseLayerImpl.class) {
            addFocusChangeObserverNative(this.swigCPtr, this, ILayerFocusChangeObserverImpl.getCPtr(iLayerFocusChangeObserverImpl), iLayerFocusChangeObserverImpl);
        } else {
            addFocusChangeObserverSwigExplicitBaseLayerImplNative(this.swigCPtr, this, ILayerFocusChangeObserverImpl.getCPtr(iLayerFocusChangeObserverImpl), iLayerFocusChangeObserverImpl);
        }
    }

    public void removeFocusChangeObserver(ILayerFocusChangeObserverImpl iLayerFocusChangeObserverImpl) {
        $explicit_removeFocusChangeObserver(iLayerFocusChangeObserverImpl);
    }

    public void $explicit_removeFocusChangeObserver(ILayerFocusChangeObserverImpl iLayerFocusChangeObserverImpl) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == BaseLayerImpl.class) {
            removeFocusChangeObserverNative(this.swigCPtr, this, ILayerFocusChangeObserverImpl.getCPtr(iLayerFocusChangeObserverImpl), iLayerFocusChangeObserverImpl);
        } else {
            removeFocusChangeObserverSwigExplicitBaseLayerImplNative(this.swigCPtr, this, ILayerFocusChangeObserverImpl.getCPtr(iLayerFocusChangeObserverImpl), iLayerFocusChangeObserverImpl);
        }
    }

    public void addCollisonRemoveObsever(ICollisonRemoveObseverImpl iCollisonRemoveObseverImpl) {
        $explicit_addCollisonRemoveObsever(iCollisonRemoveObseverImpl);
    }

    public void $explicit_addCollisonRemoveObsever(ICollisonRemoveObseverImpl iCollisonRemoveObseverImpl) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == BaseLayerImpl.class) {
            addCollisonRemoveObseverNative(this.swigCPtr, this, ICollisonRemoveObseverImpl.getCPtr(iCollisonRemoveObseverImpl), iCollisonRemoveObseverImpl);
        } else {
            addCollisonRemoveObseverSwigExplicitBaseLayerImplNative(this.swigCPtr, this, ICollisonRemoveObseverImpl.getCPtr(iCollisonRemoveObseverImpl), iCollisonRemoveObseverImpl);
        }
    }

    public void removeCollisonRemoveObsever(ICollisonRemoveObseverImpl iCollisonRemoveObseverImpl) {
        $explicit_removeCollisonRemoveObsever(iCollisonRemoveObseverImpl);
    }

    public void $explicit_removeCollisonRemoveObsever(ICollisonRemoveObseverImpl iCollisonRemoveObseverImpl) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == BaseLayerImpl.class) {
            removeCollisonRemoveObseverNative(this.swigCPtr, this, ICollisonRemoveObseverImpl.getCPtr(iCollisonRemoveObseverImpl), iCollisonRemoveObseverImpl);
        } else {
            removeCollisonRemoveObseverSwigExplicitBaseLayerImplNative(this.swigCPtr, this, ICollisonRemoveObseverImpl.getCPtr(iCollisonRemoveObseverImpl), iCollisonRemoveObseverImpl);
        }
    }

    public RectDouble getBound() {
        return $explicit_getBound();
    }

    public RectDouble $explicit_getBound() {
        if (this.swigCPtr == 0) {
            return null;
        }
        return getClass() == BaseLayerImpl.class ? getBoundNative(this.swigCPtr, this) : getBoundSwigExplicitBaseLayerImplNative(this.swigCPtr, this);
    }

    public void setPriority(LayerPriority layerPriority) {
        $explicit_setPriority(layerPriority);
    }

    public void $explicit_setPriority(LayerPriority layerPriority) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == BaseLayerImpl.class) {
            setPriorityNative(this.swigCPtr, this, 0L, layerPriority);
        } else {
            setPrioritySwigExplicitBaseLayerImplNative(this.swigCPtr, this, 0L, layerPriority);
        }
    }

    public void getPriority(LayerPriority layerPriority) {
        $explicit_getPriority(layerPriority);
    }

    public void $explicit_getPriority(LayerPriority layerPriority) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == BaseLayerImpl.class) {
            getPriorityNative(this.swigCPtr, this, 0L, layerPriority);
        } else {
            getPrioritySwigExplicitBaseLayerImplNative(this.swigCPtr, this, 0L, layerPriority);
        }
    }

    public void sort() {
        $explicit_sort();
    }

    public void $explicit_sort() {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == BaseLayerImpl.class) {
            sortNative(this.swigCPtr, this);
        } else {
            sortSwigExplicitBaseLayerImplNative(this.swigCPtr, this);
        }
    }

    public void onPaint() {
        $explicit_onPaint();
    }

    public void $explicit_onPaint() {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == BaseLayerImpl.class) {
            onPaintNative(this.swigCPtr, this);
        } else {
            onPaintSwigExplicitBaseLayerImplNative(this.swigCPtr, this);
        }
    }

    public boolean enableCluster(boolean z) {
        return $explicit_enableCluster(z);
    }

    public boolean $explicit_enableCluster(boolean z) {
        if (this.swigCPtr == 0) {
            return false;
        }
        return getClass() == BaseLayerImpl.class ? enableClusterNative(this.swigCPtr, this, z) : enableClusterSwigExplicitBaseLayerImplNative(this.swigCPtr, this, z);
    }

    public void setBGDClusterStrategy(BGDClusterStrategy bGDClusterStrategy) {
        $explicit_setBGDClusterStrategy(bGDClusterStrategy);
    }

    public void $explicit_setBGDClusterStrategy(BGDClusterStrategy bGDClusterStrategy) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == BaseLayerImpl.class) {
            setBGDClusterStrategyNative(this.swigCPtr, this, 0L, bGDClusterStrategy);
        } else {
            setBGDClusterStrategySwigExplicitBaseLayerImplNative(this.swigCPtr, this, 0L, bGDClusterStrategy);
        }
    }

    public void enableCollision(boolean z) {
        $explicit_enableCollision(z);
    }

    public void $explicit_enableCollision(boolean z) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == BaseLayerImpl.class) {
            enableCollisionNative(this.swigCPtr, this, z);
        } else {
            enableCollisionSwigExplicitBaseLayerImplNative(this.swigCPtr, this, z);
        }
    }

    public void enableItemsCollision(boolean z) {
        $explicit_enableItemsCollision(z);
    }

    public void $explicit_enableItemsCollision(boolean z) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == BaseLayerImpl.class) {
            enableItemsCollisionNative(this.swigCPtr, this, z);
        } else {
            enableItemsCollisionSwigExplicitBaseLayerImplNative(this.swigCPtr, this, z);
        }
    }

    public void enablePoiFilter(boolean z) {
        $explicit_enablePoiFilter(z);
    }

    public void $explicit_enablePoiFilter(boolean z) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == BaseLayerImpl.class) {
            enablePoiFilterNative(this.swigCPtr, this, z);
        } else {
            enablePoiFilterSwigExplicitBaseLayerImplNative(this.swigCPtr, this, z);
        }
    }

    @Override // com.autonavi.gbl.map.impl.CollisionGroupImpl
    public void updateQuadrantItems() {
        $explicit_updateQuadrantItems();
    }

    @Override // com.autonavi.gbl.map.impl.CollisionGroupImpl
    public void $explicit_updateQuadrantItems() {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == BaseLayerImpl.class) {
            updateQuadrantItemsNative(this.swigCPtr, this);
        } else {
            updateQuadrantItemsSwigExplicitBaseLayerImplNative(this.swigCPtr, this);
        }
    }

    @Override // com.autonavi.gbl.map.impl.CollisionGroupImpl
    public void intersectUI(ArrayList<RectDouble> arrayList) {
        $explicit_intersectUI(arrayList);
    }

    @Override // com.autonavi.gbl.map.impl.CollisionGroupImpl
    public void $explicit_intersectUI(ArrayList<RectDouble> arrayList) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == BaseLayerImpl.class) {
            intersectUINative(this.swigCPtr, this, arrayList);
        } else {
            intersectUISwigExplicitBaseLayerImplNative(this.swigCPtr, this, arrayList);
        }
    }

    @Override // com.autonavi.gbl.map.impl.CollisionGroupImpl, com.autonavi.gbl.map.impl.ICollisionEntityImpl
    public void lockItems() {
        $explicit_lockItems();
    }

    @Override // com.autonavi.gbl.map.impl.CollisionGroupImpl
    public void $explicit_lockItems() {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == BaseLayerImpl.class) {
            lockItemsNative(this.swigCPtr, this);
        } else {
            lockItemsSwigExplicitBaseLayerImplNative(this.swigCPtr, this);
        }
    }

    @Override // com.autonavi.gbl.map.impl.CollisionGroupImpl, com.autonavi.gbl.map.impl.ICollisionEntityImpl
    public void unLockItems() {
        $explicit_unLockItems();
    }

    @Override // com.autonavi.gbl.map.impl.CollisionGroupImpl
    public void $explicit_unLockItems() {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == BaseLayerImpl.class) {
            unLockItemsNative(this.swigCPtr, this);
        } else {
            unLockItemsSwigExplicitBaseLayerImplNative(this.swigCPtr, this);
        }
    }

    public String getTypeIdName() {
        return $explicit_getTypeIdName();
    }

    public String $explicit_getTypeIdName() {
        if (this.swigCPtr == 0) {
            return null;
        }
        return getClass() == BaseLayerImpl.class ? getTypeIdNameNative(this.swigCPtr, this) : getTypeIdNameSwigExplicitBaseLayerImplNative(this.swigCPtr, this);
    }

    public MapViewImpl getMapView() {
        return $explicit_getMapView();
    }

    public MapViewImpl $explicit_getMapView() {
        long j = this.swigCPtr;
        if (j == 0) {
            return null;
        }
        long mapViewNative = getMapViewNative(j, this);
        if (mapViewNative == 0) {
            return null;
        }
        return new MapViewImpl(mapViewNative, false);
    }

    @Override // com.autonavi.gbl.map.impl.CollisionGroupImpl
    public boolean addCollisionItem(ICollisionItemImpl iCollisionItemImpl) {
        return $explicit_addCollisionItem(iCollisionItemImpl);
    }

    @Override // com.autonavi.gbl.map.impl.CollisionGroupImpl
    public boolean $explicit_addCollisionItem(ICollisionItemImpl iCollisionItemImpl) {
        if (this.swigCPtr == 0) {
            return false;
        }
        return getClass() == BaseLayerImpl.class ? addCollisionItemNative(this.swigCPtr, this, ICollisionItemImpl.getCPtr(iCollisionItemImpl), iCollisionItemImpl) : addCollisionItemSwigExplicitBaseLayerImplNative(this.swigCPtr, this, ICollisionItemImpl.getCPtr(iCollisionItemImpl), iCollisionItemImpl);
    }

    public void setFilterPoiType(int i) {
        $explicit_setFilterPoiType(i);
    }

    public void $explicit_setFilterPoiType(int i) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == BaseLayerImpl.class) {
            setFilterPoiTypeNative(this.swigCPtr, this, i);
        } else {
            setFilterPoiTypeSwigExplicitBaseLayerImplNative(this.swigCPtr, this, i);
        }
    }

    public int getFilterPoiType() {
        return $explicit_getFilterPoiType();
    }

    public int $explicit_getFilterPoiType() {
        if (this.swigCPtr == 0) {
            return 0;
        }
        return getClass() == BaseLayerImpl.class ? getFilterPoiTypeNative(this.swigCPtr, this) : getFilterPoiTypeSwigExplicitBaseLayerImplNative(this.swigCPtr, this);
    }
}
