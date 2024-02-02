package com.autonavi.gbl.map.layer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.layer.creflex.LayerItemCRfxProto;
import com.autonavi.gbl.map.impl.ICollisionItemImpl;
import com.autonavi.gbl.map.layer.LayerItem;
import com.autonavi.gbl.map.layer.model.LayerItemType;
import com.autonavi.gbl.map.layer.model.LayerScale;
import com.autonavi.gbl.map.layer.model.MapLayerPoiAnimation;
import com.autonavi.gbl.map.layer.observer.impl.IPrepareLayerStyleImpl;
import com.autonavi.gbl.map.model.PixelPoint;
import java.util.ArrayList;
@IntfAuto(enableCRfx = true, protoOfCRfx = LayerItemCRfxProto.class, target = LayerItem.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class LayerItemImpl extends ICollisionItemImpl {
    private static BindTable BIND_TABLE = new BindTable(LayerItemImpl.class);
    private transient long swigCPtr;

    private static native long LayerItemImpl_SWIGUpcast(long j);

    private static native void LayerItemImpl_change_ownership(LayerItemImpl layerItemImpl, long j, boolean z);

    private static native void LayerItemImpl_director_connect(LayerItemImpl layerItemImpl, long j, boolean z, boolean z2);

    private static native void addPoiFilterNative(long j, LayerItemImpl layerItemImpl);

    private static native void addPoiFilterSwigExplicitLayerItemImplNative(long j, LayerItemImpl layerItemImpl);

    private static native void clearStyleNative(long j, LayerItemImpl layerItemImpl);

    private static native void clearStyleSwigExplicitLayerItemImplNative(long j, LayerItemImpl layerItemImpl);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native double getAlphaNative(long j, LayerItemImpl layerItemImpl);

    private static native double getAlphaSwigExplicitLayerItemImplNative(long j, LayerItemImpl layerItemImpl);

    private static native double getAngleNative(long j, LayerItemImpl layerItemImpl);

    private static native double getAngleSwigExplicitLayerItemImplNative(long j, LayerItemImpl layerItemImpl);

    private static native ArrayList<PixelPoint> getBoundNative(long j, LayerItemImpl layerItemImpl);

    private static native ArrayList<PixelPoint> getBoundSwigExplicitLayerItemImplNative(long j, LayerItemImpl layerItemImpl);

    private static native int getBusinessTypeNative(long j, LayerItemImpl layerItemImpl);

    private static native int getBusinessTypeSwigExplicitLayerItemImplNative(long j, LayerItemImpl layerItemImpl);

    private static native String getClassTypeNameNative();

    private static native LayerScale getDisplayScaleNative(long j, LayerItemImpl layerItemImpl);

    private static native LayerScale getDisplayScaleSwigExplicitLayerItemImplNative(long j, LayerItemImpl layerItemImpl);

    private static native boolean getFocusNative(long j, LayerItemImpl layerItemImpl);

    private static native boolean getFocusSwigExplicitLayerItemImplNative(long j, LayerItemImpl layerItemImpl);

    private static native String getIDNative(long j, LayerItemImpl layerItemImpl);

    private static native String getIDSwigExplicitLayerItemImplNative(long j, LayerItemImpl layerItemImpl);

    private static native String getInfoNative(long j, LayerItemImpl layerItemImpl);

    private static native String getInfoSwigExplicitLayerItemImplNative(long j, LayerItemImpl layerItemImpl);

    private static native int getItemTypeNative(long j, LayerItemImpl layerItemImpl);

    private static native int getItemTypeSwigExplicitLayerItemImplNative(long j, LayerItemImpl layerItemImpl);

    private static native double getMaxPitchNative(long j, LayerItemImpl layerItemImpl);

    private static native double getMaxPitchSwigExplicitLayerItemImplNative(long j, LayerItemImpl layerItemImpl);

    private static native double getPitchNative(long j, LayerItemImpl layerItemImpl);

    private static native double getPitchSwigExplicitLayerItemImplNative(long j, LayerItemImpl layerItemImpl);

    private static native int getPriorityNative(long j, LayerItemImpl layerItemImpl);

    private static native int getPrioritySwigExplicitLayerItemImplNative(long j, LayerItemImpl layerItemImpl);

    private static native String getTypeIdNameNative(long j, LayerItemImpl layerItemImpl);

    private static native String getTypeIdNameSwigExplicitLayerItemImplNative(long j, LayerItemImpl layerItemImpl);

    private static native boolean getVisibleNative(long j, LayerItemImpl layerItemImpl);

    private static native boolean getVisibleSwigExplicitLayerItemImplNative(long j, LayerItemImpl layerItemImpl);

    private static native boolean isAreaCollisionNative(long j, LayerItemImpl layerItemImpl);

    private static native boolean isAreaCollisionSwigExplicitLayerItemImplNative(long j, LayerItemImpl layerItemImpl);

    private static native void onPaintNative(long j, LayerItemImpl layerItemImpl);

    private static native void onPaintSwigExplicitLayerItemImplNative(long j, LayerItemImpl layerItemImpl);

    private static native void onVisibleNative(long j, LayerItemImpl layerItemImpl, boolean z);

    private static native void onVisibleSwigExplicitLayerItemImplNative(long j, LayerItemImpl layerItemImpl, boolean z);

    private static native void removePoiFilterNative(long j, LayerItemImpl layerItemImpl);

    private static native void removePoiFilterSwigExplicitLayerItemImplNative(long j, LayerItemImpl layerItemImpl);

    private static native void setAlphaNative(long j, LayerItemImpl layerItemImpl, double d);

    private static native void setAlphaSwigExplicitLayerItemImplNative(long j, LayerItemImpl layerItemImpl, double d);

    private static native void setAngleNative(long j, LayerItemImpl layerItemImpl, double d);

    private static native void setAngleSwigExplicitLayerItemImplNative(long j, LayerItemImpl layerItemImpl, double d);

    private static native void setAnimationNative(long j, LayerItemImpl layerItemImpl, int i, int i2);

    private static native void setAnimationSwigExplicitLayerItemImplNative(long j, LayerItemImpl layerItemImpl, int i, int i2);

    private static native void setAreaCollisionNative(long j, LayerItemImpl layerItemImpl, boolean z);

    private static native void setAreaCollisionSwigExplicitLayerItemImplNative(long j, LayerItemImpl layerItemImpl, boolean z);

    private static native void setBusinessTypeNative(long j, LayerItemImpl layerItemImpl, int i);

    private static native void setBusinessTypeSwigExplicitLayerItemImplNative(long j, LayerItemImpl layerItemImpl, int i);

    private static native void setDisplayScaleNative(long j, LayerItemImpl layerItemImpl, long j2, LayerScale layerScale);

    private static native void setDisplayScaleSwigExplicitLayerItemImplNative(long j, LayerItemImpl layerItemImpl, long j2, LayerScale layerScale);

    private static native boolean setIDNative(long j, LayerItemImpl layerItemImpl, String str);

    private static native boolean setIDSwigExplicitLayerItemImplNative(long j, LayerItemImpl layerItemImpl, String str);

    private static native boolean setInfoNative(long j, LayerItemImpl layerItemImpl, String str);

    private static native boolean setInfoSwigExplicitLayerItemImplNative(long j, LayerItemImpl layerItemImpl, String str);

    private static native void setMaxPitchNative(long j, LayerItemImpl layerItemImpl, double d);

    private static native void setMaxPitchSwigExplicitLayerItemImplNative(long j, LayerItemImpl layerItemImpl, double d);

    private static native void setParentNative(long j, LayerItemImpl layerItemImpl, long j2, BaseLayerImpl baseLayerImpl);

    private static native void setParentSwigExplicitLayerItemImplNative(long j, LayerItemImpl layerItemImpl, long j2, BaseLayerImpl baseLayerImpl);

    private static native void setPitchNative(long j, LayerItemImpl layerItemImpl, double d);

    private static native void setPitchSwigExplicitLayerItemImplNative(long j, LayerItemImpl layerItemImpl, double d);

    private static native void setPriorityNative(long j, LayerItemImpl layerItemImpl, int i);

    private static native void setPrioritySwigExplicitLayerItemImplNative(long j, LayerItemImpl layerItemImpl, int i);

    private static native void setStyle1Native(long j, LayerItemImpl layerItemImpl, String str);

    private static native void setStyleNative(long j, LayerItemImpl layerItemImpl, long j2, IPrepareLayerStyleImpl iPrepareLayerStyleImpl);

    private static native void setStyleSwigExplicitLayerItemImpl1Native(long j, LayerItemImpl layerItemImpl, String str);

    private static native void setStyleSwigExplicitLayerItemImplNative(long j, LayerItemImpl layerItemImpl, long j2, IPrepareLayerStyleImpl iPrepareLayerStyleImpl);

    private static native void setVisibleNative(long j, LayerItemImpl layerItemImpl, boolean z);

    private static native void setVisibleSwigExplicitLayerItemImplNative(long j, LayerItemImpl layerItemImpl, boolean z);

    private static native void updateStyle1Native(long j, LayerItemImpl layerItemImpl, long j2, LayerItemImpl layerItemImpl2);

    private static native void updateStyleNative(long j, LayerItemImpl layerItemImpl);

    private static native void updateStyleSwigExplicitLayerItemImpl1Native(long j, LayerItemImpl layerItemImpl, long j2, LayerItemImpl layerItemImpl2);

    private static native void updateStyleSwigExplicitLayerItemImplNative(long j, LayerItemImpl layerItemImpl);

    public LayerItemImpl(long j, boolean z) {
        super(LayerItemImpl_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    @Override // com.autonavi.gbl.map.impl.ICollisionItemImpl
    public int hashCode() {
        return super.hashCode();
    }

    @Override // com.autonavi.gbl.map.impl.ICollisionItemImpl
    public boolean equals(Object obj) {
        if (obj instanceof LayerItemImpl) {
            return getUID(this) == getUID((LayerItemImpl) obj);
        }
        return super.equals(obj);
    }

    private static long getUID(LayerItemImpl layerItemImpl) {
        long cPtr = getCPtr(layerItemImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(LayerItemImpl layerItemImpl) {
        if (layerItemImpl == null) {
            return 0L;
        }
        return layerItemImpl.swigCPtr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.impl.ICollisionItemImpl
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

    @Override // com.autonavi.gbl.map.impl.ICollisionItemImpl
    protected void swigDirectorDisconnect() {
        this.swigCMemOwn = false;
        delete();
    }

    @Override // com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void swigReleaseOwnership() {
        this.swigCMemOwn = false;
        LayerItemImpl_change_ownership(this, this.swigCPtr, false);
    }

    @Override // com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        LayerItemImpl_change_ownership(this, this.swigCPtr, true);
    }

    public static String getClassTypeName() {
        return getClassTypeNameNative();
    }

    @LayerItemType.LayerItemType1
    public int getItemType() {
        return $explicit_getItemType();
    }

    @LayerItemType.LayerItemType1
    public int $explicit_getItemType() {
        if (this.swigCPtr != 0) {
            return getClass() == LayerItemImpl.class ? getItemTypeNative(this.swigCPtr, this) : getItemTypeSwigExplicitLayerItemImplNative(this.swigCPtr, this);
        }
        throw new NullPointerException();
    }

    public boolean setID(String str) {
        return $explicit_setID(str);
    }

    public boolean $explicit_setID(String str) {
        if (this.swigCPtr != 0) {
            return getClass() == LayerItemImpl.class ? setIDNative(this.swigCPtr, this, str) : setIDSwigExplicitLayerItemImplNative(this.swigCPtr, this, str);
        }
        throw new NullPointerException();
    }

    public String getID() {
        return $explicit_getID();
    }

    public String $explicit_getID() {
        if (this.swigCPtr != 0) {
            return getClass() == LayerItemImpl.class ? getIDNative(this.swigCPtr, this) : getIDSwigExplicitLayerItemImplNative(this.swigCPtr, this);
        }
        throw new NullPointerException();
    }

    public boolean setInfo(String str) {
        return $explicit_setInfo(str);
    }

    public boolean $explicit_setInfo(String str) {
        if (this.swigCPtr != 0) {
            return getClass() == LayerItemImpl.class ? setInfoNative(this.swigCPtr, this, str) : setInfoSwigExplicitLayerItemImplNative(this.swigCPtr, this, str);
        }
        throw new NullPointerException();
    }

    public String getInfo() {
        return $explicit_getInfo();
    }

    public String $explicit_getInfo() {
        if (this.swigCPtr != 0) {
            return getClass() == LayerItemImpl.class ? getInfoNative(this.swigCPtr, this) : getInfoSwigExplicitLayerItemImplNative(this.swigCPtr, this);
        }
        throw new NullPointerException();
    }

    public void setPriority(int i) {
        $explicit_setPriority(i);
    }

    public void $explicit_setPriority(int i) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == LayerItemImpl.class) {
            setPriorityNative(this.swigCPtr, this, i);
        } else {
            setPrioritySwigExplicitLayerItemImplNative(this.swigCPtr, this, i);
        }
    }

    @Override // com.autonavi.gbl.map.impl.ICollisionItemImpl
    public int getPriority() {
        return $explicit_getPriority();
    }

    public int $explicit_getPriority() {
        if (this.swigCPtr != 0) {
            return getClass() == LayerItemImpl.class ? getPriorityNative(this.swigCPtr, this) : getPrioritySwigExplicitLayerItemImplNative(this.swigCPtr, this);
        }
        throw new NullPointerException();
    }

    public void setVisible(boolean z) {
        $explicit_setVisible(z);
    }

    public void $explicit_setVisible(boolean z) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == LayerItemImpl.class) {
            setVisibleNative(this.swigCPtr, this, z);
        } else {
            setVisibleSwigExplicitLayerItemImplNative(this.swigCPtr, this, z);
        }
    }

    @Override // com.autonavi.gbl.map.impl.ICollisionItemImpl
    public boolean getVisible() {
        return $explicit_getVisible();
    }

    public boolean $explicit_getVisible() {
        if (this.swigCPtr != 0) {
            return getClass() == LayerItemImpl.class ? getVisibleNative(this.swigCPtr, this) : getVisibleSwigExplicitLayerItemImplNative(this.swigCPtr, this);
        }
        throw new NullPointerException();
    }

    public boolean getFocus() {
        return $explicit_getFocus();
    }

    public boolean $explicit_getFocus() {
        if (this.swigCPtr != 0) {
            return getClass() == LayerItemImpl.class ? getFocusNative(this.swigCPtr, this) : getFocusSwigExplicitLayerItemImplNative(this.swigCPtr, this);
        }
        throw new NullPointerException();
    }

    public void setAlpha(double d) {
        $explicit_setAlpha(d);
    }

    public void $explicit_setAlpha(double d) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == LayerItemImpl.class) {
            setAlphaNative(this.swigCPtr, this, d);
        } else {
            setAlphaSwigExplicitLayerItemImplNative(this.swigCPtr, this, d);
        }
    }

    public double getAlpha() {
        return $explicit_getAlpha();
    }

    public double $explicit_getAlpha() {
        if (this.swigCPtr != 0) {
            return getClass() == LayerItemImpl.class ? getAlphaNative(this.swigCPtr, this) : getAlphaSwigExplicitLayerItemImplNative(this.swigCPtr, this);
        }
        throw new NullPointerException();
    }

    public void setAngle(double d) {
        $explicit_setAngle(d);
    }

    public void $explicit_setAngle(double d) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == LayerItemImpl.class) {
            setAngleNative(this.swigCPtr, this, d);
        } else {
            setAngleSwigExplicitLayerItemImplNative(this.swigCPtr, this, d);
        }
    }

    public double getAngle() {
        return $explicit_getAngle();
    }

    public double $explicit_getAngle() {
        if (this.swigCPtr != 0) {
            return getClass() == LayerItemImpl.class ? getAngleNative(this.swigCPtr, this) : getAngleSwigExplicitLayerItemImplNative(this.swigCPtr, this);
        }
        throw new NullPointerException();
    }

    public void setPitch(double d) {
        $explicit_setPitch(d);
    }

    public void $explicit_setPitch(double d) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == LayerItemImpl.class) {
            setPitchNative(this.swigCPtr, this, d);
        } else {
            setPitchSwigExplicitLayerItemImplNative(this.swigCPtr, this, d);
        }
    }

    public double getPitch() {
        return $explicit_getPitch();
    }

    public double $explicit_getPitch() {
        if (this.swigCPtr != 0) {
            return getClass() == LayerItemImpl.class ? getPitchNative(this.swigCPtr, this) : getPitchSwigExplicitLayerItemImplNative(this.swigCPtr, this);
        }
        throw new NullPointerException();
    }

    public void setMaxPitch(double d) {
        $explicit_setMaxPitch(d);
    }

    public void $explicit_setMaxPitch(double d) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == LayerItemImpl.class) {
            setMaxPitchNative(this.swigCPtr, this, d);
        } else {
            setMaxPitchSwigExplicitLayerItemImplNative(this.swigCPtr, this, d);
        }
    }

    public double getMaxPitch() {
        return $explicit_getMaxPitch();
    }

    public double $explicit_getMaxPitch() {
        if (this.swigCPtr != 0) {
            return getClass() == LayerItemImpl.class ? getMaxPitchNative(this.swigCPtr, this) : getMaxPitchSwigExplicitLayerItemImplNative(this.swigCPtr, this);
        }
        throw new NullPointerException();
    }

    public void setDisplayScale(LayerScale layerScale) {
        $explicit_setDisplayScale(layerScale);
    }

    public void $explicit_setDisplayScale(LayerScale layerScale) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == LayerItemImpl.class) {
            setDisplayScaleNative(this.swigCPtr, this, 0L, layerScale);
        } else {
            setDisplayScaleSwigExplicitLayerItemImplNative(this.swigCPtr, this, 0L, layerScale);
        }
    }

    public LayerScale getDisplayScale() {
        return $explicit_getDisplayScale();
    }

    public LayerScale $explicit_getDisplayScale() {
        if (this.swigCPtr != 0) {
            return getClass() == LayerItemImpl.class ? getDisplayScaleNative(this.swigCPtr, this) : getDisplayScaleSwigExplicitLayerItemImplNative(this.swigCPtr, this);
        }
        throw new NullPointerException();
    }

    public void setAnimation(@MapLayerPoiAnimation.MapLayerPoiAnimation1 int i, int i2) {
        $explicit_setAnimation(i, i2);
    }

    public void $explicit_setAnimation(@MapLayerPoiAnimation.MapLayerPoiAnimation1 int i, int i2) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == LayerItemImpl.class) {
            setAnimationNative(this.swigCPtr, this, i, i2);
        } else {
            setAnimationSwigExplicitLayerItemImplNative(this.swigCPtr, this, i, i2);
        }
    }

    public void setStyle(IPrepareLayerStyleImpl iPrepareLayerStyleImpl) {
        $explicit_setStyle(iPrepareLayerStyleImpl);
    }

    public void $explicit_setStyle(IPrepareLayerStyleImpl iPrepareLayerStyleImpl) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == LayerItemImpl.class) {
            setStyleNative(this.swigCPtr, this, IPrepareLayerStyleImpl.getCPtr(iPrepareLayerStyleImpl), iPrepareLayerStyleImpl);
        } else {
            setStyleSwigExplicitLayerItemImplNative(this.swigCPtr, this, IPrepareLayerStyleImpl.getCPtr(iPrepareLayerStyleImpl), iPrepareLayerStyleImpl);
        }
    }

    public void setStyle(String str) {
        $explicit_setStyle(str);
    }

    public void $explicit_setStyle(String str) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == LayerItemImpl.class) {
            setStyle1Native(this.swigCPtr, this, str);
        } else {
            setStyleSwigExplicitLayerItemImpl1Native(this.swigCPtr, this, str);
        }
    }

    public void updateStyle() {
        $explicit_updateStyle();
    }

    public void $explicit_updateStyle() {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == LayerItemImpl.class) {
            updateStyleNative(this.swigCPtr, this);
        } else {
            updateStyleSwigExplicitLayerItemImplNative(this.swigCPtr, this);
        }
    }

    public void updateStyle(LayerItemImpl layerItemImpl) {
        $explicit_updateStyle(layerItemImpl);
    }

    public void $explicit_updateStyle(LayerItemImpl layerItemImpl) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == LayerItemImpl.class) {
            updateStyle1Native(this.swigCPtr, this, getCPtr(layerItemImpl), layerItemImpl);
        } else {
            updateStyleSwigExplicitLayerItemImpl1Native(this.swigCPtr, this, getCPtr(layerItemImpl), layerItemImpl);
        }
    }

    public void addPoiFilter() {
        $explicit_addPoiFilter();
    }

    public void $explicit_addPoiFilter() {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == LayerItemImpl.class) {
            addPoiFilterNative(this.swigCPtr, this);
        } else {
            addPoiFilterSwigExplicitLayerItemImplNative(this.swigCPtr, this);
        }
    }

    public void removePoiFilter() {
        $explicit_removePoiFilter();
    }

    public void $explicit_removePoiFilter() {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == LayerItemImpl.class) {
            removePoiFilterNative(this.swigCPtr, this);
        } else {
            removePoiFilterSwigExplicitLayerItemImplNative(this.swigCPtr, this);
        }
    }

    public void onPaint() {
        $explicit_onPaint();
    }

    public void $explicit_onPaint() {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == LayerItemImpl.class) {
            onPaintNative(this.swigCPtr, this);
        } else {
            onPaintSwigExplicitLayerItemImplNative(this.swigCPtr, this);
        }
    }

    public void setParent(BaseLayerImpl baseLayerImpl) {
        $explicit_setParent(baseLayerImpl);
    }

    public void $explicit_setParent(BaseLayerImpl baseLayerImpl) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == LayerItemImpl.class) {
            setParentNative(this.swigCPtr, this, BaseLayerImpl.getCPtr(baseLayerImpl), baseLayerImpl);
        } else {
            setParentSwigExplicitLayerItemImplNative(this.swigCPtr, this, BaseLayerImpl.getCPtr(baseLayerImpl), baseLayerImpl);
        }
    }

    public void setBusinessType(int i) {
        $explicit_setBusinessType(i);
    }

    public void $explicit_setBusinessType(int i) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == LayerItemImpl.class) {
            setBusinessTypeNative(this.swigCPtr, this, i);
        } else {
            setBusinessTypeSwigExplicitLayerItemImplNative(this.swigCPtr, this, i);
        }
    }

    public int getBusinessType() {
        return $explicit_getBusinessType();
    }

    public int $explicit_getBusinessType() {
        if (this.swigCPtr != 0) {
            return getClass() == LayerItemImpl.class ? getBusinessTypeNative(this.swigCPtr, this) : getBusinessTypeSwigExplicitLayerItemImplNative(this.swigCPtr, this);
        }
        throw new NullPointerException();
    }

    @Override // com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void onVisible(boolean z) {
        $explicit_onVisible(z);
    }

    public void $explicit_onVisible(boolean z) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == LayerItemImpl.class) {
            onVisibleNative(this.swigCPtr, this, z);
        } else {
            onVisibleSwigExplicitLayerItemImplNative(this.swigCPtr, this, z);
        }
    }

    @Override // com.autonavi.gbl.map.impl.ICollisionItemImpl
    public ArrayList<PixelPoint> getBound() {
        return $explicit_getBound();
    }

    public ArrayList<PixelPoint> $explicit_getBound() {
        if (this.swigCPtr != 0) {
            return getClass() == LayerItemImpl.class ? getBoundNative(this.swigCPtr, this) : getBoundSwigExplicitLayerItemImplNative(this.swigCPtr, this);
        }
        throw new NullPointerException();
    }

    @Override // com.autonavi.gbl.map.impl.ICollisionItemImpl
    public boolean isAreaCollision() {
        return $explicit_isAreaCollision();
    }

    public boolean $explicit_isAreaCollision() {
        if (this.swigCPtr != 0) {
            return getClass() == LayerItemImpl.class ? isAreaCollisionNative(this.swigCPtr, this) : isAreaCollisionSwigExplicitLayerItemImplNative(this.swigCPtr, this);
        }
        throw new NullPointerException();
    }

    @Override // com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void setAreaCollision(boolean z) {
        $explicit_setAreaCollision(z);
    }

    public void $explicit_setAreaCollision(boolean z) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == LayerItemImpl.class) {
            setAreaCollisionNative(this.swigCPtr, this, z);
        } else {
            setAreaCollisionSwigExplicitLayerItemImplNative(this.swigCPtr, this, z);
        }
    }

    public String getTypeIdName() {
        return $explicit_getTypeIdName();
    }

    public String $explicit_getTypeIdName() {
        if (this.swigCPtr != 0) {
            return getClass() == LayerItemImpl.class ? getTypeIdNameNative(this.swigCPtr, this) : getTypeIdNameSwigExplicitLayerItemImplNative(this.swigCPtr, this);
        }
        throw new NullPointerException();
    }

    public void clearStyle() {
        $explicit_clearStyle();
    }

    public void $explicit_clearStyle() {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == LayerItemImpl.class) {
            clearStyleNative(this.swigCPtr, this);
        } else {
            clearStyleSwigExplicitLayerItemImplNative(this.swigCPtr, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public LayerItemImpl() {
        this(createNativeObj(), true);
        MapLayerSvrJNI.swig_jni_init();
        LayerItemImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
