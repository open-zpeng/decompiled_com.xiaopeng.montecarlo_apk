package com.autonavi.gbl.multi.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.common.model.Coord2DDouble;
import com.autonavi.gbl.multi.impl.IKldDisplayImpl;
import com.autonavi.gbl.multi.model.DayNightModeConfig;
import com.autonavi.gbl.multi.model.MapScaleConfig;
import com.autonavi.gbl.multi.model.MapViewModeConfig;
import com.autonavi.gbl.multi.model.TmcConfig;
import com.autonavi.gbl.multi.observer.MapConfigBase;
@IntfAuto(target = MapConfigBase.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class MapConfigBaseImpl extends IKldConfigItemBaseImpl {
    private static BindTable BIND_TABLE = new BindTable(MapConfigBaseImpl.class);
    private transient long swigCPtr;

    private static native long MapConfigBaseImpl_SWIGUpcast(long j);

    private static native void MapConfigBaseImpl_change_ownership(MapConfigBaseImpl mapConfigBaseImpl, long j, boolean z);

    private static native void MapConfigBaseImpl_director_connect(MapConfigBaseImpl mapConfigBaseImpl, long j, boolean z, boolean z2);

    private static native boolean allowedTransAnimationGetNative(long j, MapConfigBaseImpl mapConfigBaseImpl);

    private static native void allowedTransAnimationSetNative(long j, MapConfigBaseImpl mapConfigBaseImpl, boolean z);

    private static native int animationIdGetNative(long j, MapConfigBaseImpl mapConfigBaseImpl);

    private static native void animationIdSetNative(long j, MapConfigBaseImpl mapConfigBaseImpl, int i);

    private static native int animationTimeGetNative(long j, MapConfigBaseImpl mapConfigBaseImpl);

    private static native void animationTimeSetNative(long j, MapConfigBaseImpl mapConfigBaseImpl, int i);

    private static native int applyConfigNative(long j, MapConfigBaseImpl mapConfigBaseImpl, long j2, IKldDisplayImpl iKldDisplayImpl);

    private static native int applyConfigSwigExplicitMapConfigBaseImplNative(long j, MapConfigBaseImpl mapConfigBaseImpl, long j2, IKldDisplayImpl iKldDisplayImpl);

    private static native float carPositionGetNative(long j, MapConfigBaseImpl mapConfigBaseImpl);

    private static native float carPositionHorizGetNative(long j, MapConfigBaseImpl mapConfigBaseImpl);

    private static native void carPositionHorizSetNative(long j, MapConfigBaseImpl mapConfigBaseImpl, float f);

    private static native float carPositionNGetNative(long j, MapConfigBaseImpl mapConfigBaseImpl);

    private static native void carPositionNSetNative(long j, MapConfigBaseImpl mapConfigBaseImpl, float f);

    private static native void carPositionSetNative(long j, MapConfigBaseImpl mapConfigBaseImpl, float f);

    private static native long createNativeObj();

    private static native Coord2DDouble defaultMapCenterGetNative(long j, MapConfigBaseImpl mapConfigBaseImpl);

    private static native void defaultMapCenterSetNative(long j, MapConfigBaseImpl mapConfigBaseImpl, long j2, Coord2DDouble coord2DDouble);

    private static native void destroyNativeObj(long j);

    private static native boolean is2DCarModeGetNative(long j, MapConfigBaseImpl mapConfigBaseImpl);

    private static native void is2DCarModeSetNative(long j, MapConfigBaseImpl mapConfigBaseImpl, boolean z);

    private static native boolean is3DBuildingVisiableGetNative(long j, MapConfigBaseImpl mapConfigBaseImpl);

    private static native void is3DBuildingVisiableSetNative(long j, MapConfigBaseImpl mapConfigBaseImpl, boolean z);

    private static native boolean isBuildingTextureVisiableGetNative(long j, MapConfigBaseImpl mapConfigBaseImpl);

    private static native void isBuildingTextureVisiableSetNative(long j, MapConfigBaseImpl mapConfigBaseImpl, boolean z);

    private static native boolean isNeedJudgeAutoScaleGetNative(long j, MapConfigBaseImpl mapConfigBaseImpl);

    private static native void isNeedJudgeAutoScaleSetNative(long j, MapConfigBaseImpl mapConfigBaseImpl, boolean z);

    private static native boolean isSimple3DEnabledGetNative(long j, MapConfigBaseImpl mapConfigBaseImpl);

    private static native void isSimple3DEnabledSetNative(long j, MapConfigBaseImpl mapConfigBaseImpl, boolean z);

    private static native int logoLeftGetNative(long j, MapConfigBaseImpl mapConfigBaseImpl);

    private static native void logoLeftSetNative(long j, MapConfigBaseImpl mapConfigBaseImpl, int i);

    private static native int logoTopGetNative(long j, MapConfigBaseImpl mapConfigBaseImpl);

    private static native void logoTopSetNative(long j, MapConfigBaseImpl mapConfigBaseImpl, int i);

    private static native int mapDayNightModeGetNative(long j, MapConfigBaseImpl mapConfigBaseImpl);

    private static native void mapDayNightModeSetNative(long j, MapConfigBaseImpl mapConfigBaseImpl, int i);

    private static native boolean mapFadeOutGetNative(long j, MapConfigBaseImpl mapConfigBaseImpl);

    private static native void mapFadeOutSetNative(long j, MapConfigBaseImpl mapConfigBaseImpl, boolean z);

    private static native int mapScaleConfigGetNative(long j, MapConfigBaseImpl mapConfigBaseImpl);

    private static native void mapScaleConfigSetNative(long j, MapConfigBaseImpl mapConfigBaseImpl, int i);

    private static native String mapStyleFileNameDayGetNative(long j, MapConfigBaseImpl mapConfigBaseImpl);

    private static native void mapStyleFileNameDaySetNative(long j, MapConfigBaseImpl mapConfigBaseImpl, String str);

    private static native String mapStyleFileNameNightGetNative(long j, MapConfigBaseImpl mapConfigBaseImpl);

    private static native void mapStyleFileNameNightSetNative(long j, MapConfigBaseImpl mapConfigBaseImpl, String str);

    private static native int mapViewModeGetNative(long j, MapConfigBaseImpl mapConfigBaseImpl);

    private static native void mapViewModeSetNative(long j, MapConfigBaseImpl mapConfigBaseImpl, int i);

    private static native int parseConfigStringNative(long j, MapConfigBaseImpl mapConfigBaseImpl, String str);

    private static native int parseConfigStringSwigExplicitMapConfigBaseImplNative(long j, MapConfigBaseImpl mapConfigBaseImpl, String str);

    private static native int previewScreenBottomGetNative(long j, MapConfigBaseImpl mapConfigBaseImpl);

    private static native void previewScreenBottomSetNative(long j, MapConfigBaseImpl mapConfigBaseImpl, int i);

    private static native int previewScreenLeftGetNative(long j, MapConfigBaseImpl mapConfigBaseImpl);

    private static native void previewScreenLeftSetNative(long j, MapConfigBaseImpl mapConfigBaseImpl, int i);

    private static native int previewScreenRightGetNative(long j, MapConfigBaseImpl mapConfigBaseImpl);

    private static native void previewScreenRightSetNative(long j, MapConfigBaseImpl mapConfigBaseImpl, int i);

    private static native int previewScreenTopGetNative(long j, MapConfigBaseImpl mapConfigBaseImpl);

    private static native void previewScreenTopSetNative(long j, MapConfigBaseImpl mapConfigBaseImpl, int i);

    private static native int skyDayNightModeGetNative(long j, MapConfigBaseImpl mapConfigBaseImpl);

    private static native void skyDayNightModeSetNative(long j, MapConfigBaseImpl mapConfigBaseImpl, int i);

    private static native int tmcConfigGetNative(long j, MapConfigBaseImpl mapConfigBaseImpl);

    private static native void tmcConfigSetNative(long j, MapConfigBaseImpl mapConfigBaseImpl, int i);

    private static native boolean zoomEnableGetNative(long j, MapConfigBaseImpl mapConfigBaseImpl);

    private static native void zoomEnableSetNative(long j, MapConfigBaseImpl mapConfigBaseImpl, boolean z);

    public MapConfigBaseImpl(long j, boolean z) {
        super(MapConfigBaseImpl_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    @Override // com.autonavi.gbl.multi.observer.impl.IKldConfigItemBaseImpl
    public int hashCode() {
        return super.hashCode();
    }

    @Override // com.autonavi.gbl.multi.observer.impl.IKldConfigItemBaseImpl
    public boolean equals(Object obj) {
        if (obj instanceof MapConfigBaseImpl) {
            return getUID(this) == getUID((MapConfigBaseImpl) obj);
        }
        return super.equals(obj);
    }

    private static long getUID(MapConfigBaseImpl mapConfigBaseImpl) {
        long cPtr = getCPtr(mapConfigBaseImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(MapConfigBaseImpl mapConfigBaseImpl) {
        if (mapConfigBaseImpl == null) {
            return 0L;
        }
        return mapConfigBaseImpl.swigCPtr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.multi.observer.impl.IKldConfigItemBaseImpl
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

    @Override // com.autonavi.gbl.multi.observer.impl.IKldConfigItemBaseImpl
    protected void swigDirectorDisconnect() {
        this.swigCMemOwn = false;
        delete();
    }

    @Override // com.autonavi.gbl.multi.observer.impl.IKldConfigItemBaseImpl
    public void swigReleaseOwnership() {
        this.swigCMemOwn = false;
        MapConfigBaseImpl_change_ownership(this, this.swigCPtr, false);
    }

    @Override // com.autonavi.gbl.multi.observer.impl.IKldConfigItemBaseImpl
    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        MapConfigBaseImpl_change_ownership(this, this.swigCPtr, true);
    }

    public MapConfigBaseImpl() {
        this(createNativeObj(), true);
        MultiObserverJNI.swig_jni_init();
        MapConfigBaseImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }

    @Override // com.autonavi.gbl.multi.observer.impl.IKldConfigItemBaseImpl
    public int parseConfigString(String str) {
        return $explicit_parseConfigString(str);
    }

    @Override // com.autonavi.gbl.multi.observer.impl.IKldConfigItemBaseImpl
    public int $explicit_parseConfigString(String str) {
        if (this.swigCPtr != 0) {
            return getClass() == MapConfigBaseImpl.class ? parseConfigStringNative(this.swigCPtr, this, str) : parseConfigStringSwigExplicitMapConfigBaseImplNative(this.swigCPtr, this, str);
        }
        throw new NullPointerException();
    }

    @Override // com.autonavi.gbl.multi.observer.impl.IKldConfigItemBaseImpl
    public int applyConfig(IKldDisplayImpl iKldDisplayImpl) {
        return $explicit_applyConfig(iKldDisplayImpl);
    }

    @Override // com.autonavi.gbl.multi.observer.impl.IKldConfigItemBaseImpl
    public int $explicit_applyConfig(IKldDisplayImpl iKldDisplayImpl) {
        if (this.swigCPtr != 0) {
            return getClass() == MapConfigBaseImpl.class ? applyConfigNative(this.swigCPtr, this, IKldDisplayImpl.getCPtr(iKldDisplayImpl), iKldDisplayImpl) : applyConfigSwigExplicitMapConfigBaseImplNative(this.swigCPtr, this, IKldDisplayImpl.getCPtr(iKldDisplayImpl), iKldDisplayImpl);
        }
        throw new NullPointerException();
    }

    public void setMapViewMode(@MapViewModeConfig.MapViewModeConfig1 int i) {
        $explicit_setMapViewMode(i);
    }

    public void $explicit_setMapViewMode(@MapViewModeConfig.MapViewModeConfig1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        mapViewModeSetNative(j, this, i);
    }

    @MapViewModeConfig.MapViewModeConfig1
    public int getMapViewMode() {
        return $explicit_getMapViewMode();
    }

    @MapViewModeConfig.MapViewModeConfig1
    public int $explicit_getMapViewMode() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return mapViewModeGetNative(j, this);
    }

    public void setIsNeedJudgeAutoScale(boolean z) {
        $explicit_setIsNeedJudgeAutoScale(z);
    }

    public void $explicit_setIsNeedJudgeAutoScale(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        isNeedJudgeAutoScaleSetNative(j, this, z);
    }

    public boolean getIsNeedJudgeAutoScale() {
        return $explicit_getIsNeedJudgeAutoScale();
    }

    public boolean $explicit_getIsNeedJudgeAutoScale() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return isNeedJudgeAutoScaleGetNative(j, this);
    }

    public void setZoomEnable(boolean z) {
        $explicit_setZoomEnable(z);
    }

    public void $explicit_setZoomEnable(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        zoomEnableSetNative(j, this, z);
    }

    public boolean getZoomEnable() {
        return $explicit_getZoomEnable();
    }

    public boolean $explicit_getZoomEnable() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return zoomEnableGetNative(j, this);
    }

    public void setMapScaleConfig(@MapScaleConfig.MapScaleConfig1 int i) {
        $explicit_setMapScaleConfig(i);
    }

    public void $explicit_setMapScaleConfig(@MapScaleConfig.MapScaleConfig1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        mapScaleConfigSetNative(j, this, i);
    }

    @MapScaleConfig.MapScaleConfig1
    public int getMapScaleConfig() {
        return $explicit_getMapScaleConfig();
    }

    @MapScaleConfig.MapScaleConfig1
    public int $explicit_getMapScaleConfig() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return mapScaleConfigGetNative(j, this);
    }

    public void setDefaultMapCenter(Coord2DDouble coord2DDouble) {
        $explicit_setDefaultMapCenter(coord2DDouble);
    }

    public void $explicit_setDefaultMapCenter(Coord2DDouble coord2DDouble) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        defaultMapCenterSetNative(j, this, 0L, coord2DDouble);
    }

    public Coord2DDouble getDefaultMapCenter() {
        return $explicit_getDefaultMapCenter();
    }

    public Coord2DDouble $explicit_getDefaultMapCenter() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return defaultMapCenterGetNative(j, this);
    }

    public void setMapDayNightMode(@DayNightModeConfig.DayNightModeConfig1 int i) {
        $explicit_setMapDayNightMode(i);
    }

    public void $explicit_setMapDayNightMode(@DayNightModeConfig.DayNightModeConfig1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        mapDayNightModeSetNative(j, this, i);
    }

    @DayNightModeConfig.DayNightModeConfig1
    public int getMapDayNightMode() {
        return $explicit_getMapDayNightMode();
    }

    @DayNightModeConfig.DayNightModeConfig1
    public int $explicit_getMapDayNightMode() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return mapDayNightModeGetNative(j, this);
    }

    public void setSkyDayNightMode(@DayNightModeConfig.DayNightModeConfig1 int i) {
        $explicit_setSkyDayNightMode(i);
    }

    public void $explicit_setSkyDayNightMode(@DayNightModeConfig.DayNightModeConfig1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        skyDayNightModeSetNative(j, this, i);
    }

    @DayNightModeConfig.DayNightModeConfig1
    public int getSkyDayNightMode() {
        return $explicit_getSkyDayNightMode();
    }

    @DayNightModeConfig.DayNightModeConfig1
    public int $explicit_getSkyDayNightMode() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return skyDayNightModeGetNative(j, this);
    }

    public void setMapFadeOut(boolean z) {
        $explicit_setMapFadeOut(z);
    }

    public void $explicit_setMapFadeOut(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        mapFadeOutSetNative(j, this, z);
    }

    public boolean getMapFadeOut() {
        return $explicit_getMapFadeOut();
    }

    public boolean $explicit_getMapFadeOut() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return mapFadeOutGetNative(j, this);
    }

    public void setMapStyleFileNameDay(String str) {
        $explicit_setMapStyleFileNameDay(str);
    }

    public void $explicit_setMapStyleFileNameDay(String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        mapStyleFileNameDaySetNative(j, this, str);
    }

    public String getMapStyleFileNameDay() {
        return $explicit_getMapStyleFileNameDay();
    }

    public String $explicit_getMapStyleFileNameDay() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return mapStyleFileNameDayGetNative(j, this);
    }

    public void setMapStyleFileNameNight(String str) {
        $explicit_setMapStyleFileNameNight(str);
    }

    public void $explicit_setMapStyleFileNameNight(String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        mapStyleFileNameNightSetNative(j, this, str);
    }

    public String getMapStyleFileNameNight() {
        return $explicit_getMapStyleFileNameNight();
    }

    public String $explicit_getMapStyleFileNameNight() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return mapStyleFileNameNightGetNative(j, this);
    }

    public void setTmcConfig(@TmcConfig.TmcConfig1 int i) {
        $explicit_setTmcConfig(i);
    }

    public void $explicit_setTmcConfig(@TmcConfig.TmcConfig1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        tmcConfigSetNative(j, this, i);
    }

    @TmcConfig.TmcConfig1
    public int getTmcConfig() {
        return $explicit_getTmcConfig();
    }

    @TmcConfig.TmcConfig1
    public int $explicit_getTmcConfig() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return tmcConfigGetNative(j, this);
    }

    public void setIsBuildingTextureVisiable(boolean z) {
        $explicit_setIsBuildingTextureVisiable(z);
    }

    public void $explicit_setIsBuildingTextureVisiable(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        isBuildingTextureVisiableSetNative(j, this, z);
    }

    public boolean getIsBuildingTextureVisiable() {
        return $explicit_getIsBuildingTextureVisiable();
    }

    public boolean $explicit_getIsBuildingTextureVisiable() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return isBuildingTextureVisiableGetNative(j, this);
    }

    public void setIs3DBuildingVisiable(boolean z) {
        $explicit_setIs3DBuildingVisiable(z);
    }

    public void $explicit_setIs3DBuildingVisiable(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        is3DBuildingVisiableSetNative(j, this, z);
    }

    public boolean getIs3DBuildingVisiable() {
        return $explicit_getIs3DBuildingVisiable();
    }

    public boolean $explicit_getIs3DBuildingVisiable() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return is3DBuildingVisiableGetNative(j, this);
    }

    public void setIsSimple3DEnabled(boolean z) {
        $explicit_setIsSimple3DEnabled(z);
    }

    public void $explicit_setIsSimple3DEnabled(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        isSimple3DEnabledSetNative(j, this, z);
    }

    public boolean getIsSimple3DEnabled() {
        return $explicit_getIsSimple3DEnabled();
    }

    public boolean $explicit_getIsSimple3DEnabled() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return isSimple3DEnabledGetNative(j, this);
    }

    public void setLogoLeft(int i) {
        $explicit_setLogoLeft(i);
    }

    public void $explicit_setLogoLeft(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        logoLeftSetNative(j, this, i);
    }

    public int getLogoLeft() {
        return $explicit_getLogoLeft();
    }

    public int $explicit_getLogoLeft() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return logoLeftGetNative(j, this);
    }

    public void setLogoTop(int i) {
        $explicit_setLogoTop(i);
    }

    public void $explicit_setLogoTop(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        logoTopSetNative(j, this, i);
    }

    public int getLogoTop() {
        return $explicit_getLogoTop();
    }

    public int $explicit_getLogoTop() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return logoTopGetNative(j, this);
    }

    public void setPreviewScreenLeft(int i) {
        $explicit_setPreviewScreenLeft(i);
    }

    public void $explicit_setPreviewScreenLeft(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        previewScreenLeftSetNative(j, this, i);
    }

    public int getPreviewScreenLeft() {
        return $explicit_getPreviewScreenLeft();
    }

    public int $explicit_getPreviewScreenLeft() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return previewScreenLeftGetNative(j, this);
    }

    public void setPreviewScreenRight(int i) {
        $explicit_setPreviewScreenRight(i);
    }

    public void $explicit_setPreviewScreenRight(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        previewScreenRightSetNative(j, this, i);
    }

    public int getPreviewScreenRight() {
        return $explicit_getPreviewScreenRight();
    }

    public int $explicit_getPreviewScreenRight() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return previewScreenRightGetNative(j, this);
    }

    public void setPreviewScreenTop(int i) {
        $explicit_setPreviewScreenTop(i);
    }

    public void $explicit_setPreviewScreenTop(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        previewScreenTopSetNative(j, this, i);
    }

    public int getPreviewScreenTop() {
        return $explicit_getPreviewScreenTop();
    }

    public int $explicit_getPreviewScreenTop() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return previewScreenTopGetNative(j, this);
    }

    public void setPreviewScreenBottom(int i) {
        $explicit_setPreviewScreenBottom(i);
    }

    public void $explicit_setPreviewScreenBottom(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        previewScreenBottomSetNative(j, this, i);
    }

    public int getPreviewScreenBottom() {
        return $explicit_getPreviewScreenBottom();
    }

    public int $explicit_getPreviewScreenBottom() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return previewScreenBottomGetNative(j, this);
    }

    public void setAllowedTransAnimation(boolean z) {
        $explicit_setAllowedTransAnimation(z);
    }

    public void $explicit_setAllowedTransAnimation(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        allowedTransAnimationSetNative(j, this, z);
    }

    public boolean getAllowedTransAnimation() {
        return $explicit_getAllowedTransAnimation();
    }

    public boolean $explicit_getAllowedTransAnimation() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return allowedTransAnimationGetNative(j, this);
    }

    public void setAnimationTime(int i) {
        $explicit_setAnimationTime(i);
    }

    public void $explicit_setAnimationTime(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        animationTimeSetNative(j, this, i);
    }

    public int getAnimationTime() {
        return $explicit_getAnimationTime();
    }

    public int $explicit_getAnimationTime() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return animationTimeGetNative(j, this);
    }

    public void setAnimationId(int i) {
        $explicit_setAnimationId(i);
    }

    public void $explicit_setAnimationId(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        animationIdSetNative(j, this, i);
    }

    public int getAnimationId() {
        return $explicit_getAnimationId();
    }

    public int $explicit_getAnimationId() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return animationIdGetNative(j, this);
    }

    public void setCarPosition(float f) {
        $explicit_setCarPosition(f);
    }

    public void $explicit_setCarPosition(float f) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        carPositionSetNative(j, this, f);
    }

    public float getCarPosition() {
        return $explicit_getCarPosition();
    }

    public float $explicit_getCarPosition() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return carPositionGetNative(j, this);
    }

    public void setCarPositionN(float f) {
        $explicit_setCarPositionN(f);
    }

    public void $explicit_setCarPositionN(float f) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        carPositionNSetNative(j, this, f);
    }

    public float getCarPositionN() {
        return $explicit_getCarPositionN();
    }

    public float $explicit_getCarPositionN() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return carPositionNGetNative(j, this);
    }

    public void setCarPositionHoriz(float f) {
        $explicit_setCarPositionHoriz(f);
    }

    public void $explicit_setCarPositionHoriz(float f) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        carPositionHorizSetNative(j, this, f);
    }

    public float getCarPositionHoriz() {
        return $explicit_getCarPositionHoriz();
    }

    public float $explicit_getCarPositionHoriz() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return carPositionHorizGetNative(j, this);
    }

    public void setIs2DCarMode(boolean z) {
        $explicit_setIs2DCarMode(z);
    }

    public void $explicit_setIs2DCarMode(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        is2DCarModeSetNative(j, this, z);
    }

    public boolean getIs2DCarMode() {
        return $explicit_getIs2DCarMode();
    }

    public boolean $explicit_getIs2DCarMode() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return is2DCarModeGetNative(j, this);
    }
}
