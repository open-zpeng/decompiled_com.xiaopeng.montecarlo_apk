package com.autonavi.gbl.multi.observer;

import android.util.Log;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.common.model.Coord2DDouble;
import com.autonavi.gbl.multi.KldDisplay;
import com.autonavi.gbl.multi.impl.IKldDisplayImpl;
import com.autonavi.gbl.multi.model.DayNightModeConfig;
import com.autonavi.gbl.multi.model.MapScaleConfig;
import com.autonavi.gbl.multi.model.MapViewModeConfig;
import com.autonavi.gbl.multi.model.TmcConfig;
import com.autonavi.gbl.multi.observer.impl.MapConfigBaseImpl;
import com.autonavi.gbl.multi.router.MapConfigBaseRouter;
import java.lang.reflect.Method;
@IntfAuto(target = MapConfigBaseRouter.class, type = BuildType.JOBIMPL)
/* loaded from: classes2.dex */
public class MapConfigBase extends KldConfigItemBase implements IMapConfigBase {
    private static String PACKAGE = ReflexTool.PN(MapConfigBase.class);
    private boolean mHasDestroy;
    private MapConfigBaseImpl mService;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected MapConfigBase(long j, boolean z) {
        this(new MapConfigBaseRouter("MapConfigBase", null, j, z));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{IMapConfigBase.class}, new Object[]{this});
    }

    public MapConfigBase() {
        this(new MapConfigBaseRouter("MapConfigBase", null));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{IMapConfigBase.class}, new Object[]{this});
    }

    public MapConfigBase(MapConfigBaseImpl mapConfigBaseImpl) {
        super(mapConfigBaseImpl);
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mService = null;
        this.mHasDestroy = false;
        $constructor(mapConfigBaseImpl);
    }

    private void $constructor(MapConfigBaseImpl mapConfigBaseImpl) {
        if (mapConfigBaseImpl != null) {
            this.mService = mapConfigBaseImpl;
            this.mTargetId = String.format("MapConfigBase_%s_%d", String.valueOf(MapConfigBaseImpl.getCPtr(this.mService)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    @Override // com.autonavi.gbl.multi.observer.KldConfigItemBase
    public MapConfigBaseImpl getService() {
        return this.mService;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.multi.observer.KldConfigItemBase
    public void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.multi.observer.MapConfigBase.1
        });
        objArr[1] = String.valueOf(this.mTypeHelper != null);
        DebugTool.d("%s: mTypeHelper=%s", objArr);
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mTypeHelper = null;
        }
        super.unbind();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.multi.observer.KldConfigItemBase
    public void clean() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.multi.observer.MapConfigBase.2
        }));
        super.clean();
    }

    @Override // com.autonavi.gbl.multi.observer.KldConfigItemBase
    public void onDestroy() {
        this.mHasDestroy = true;
        clean();
    }

    @Override // com.autonavi.gbl.multi.observer.KldConfigItemBase
    public synchronized void delete() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.multi.observer.MapConfigBase.3
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
            ReflexTool.invokeDeclMethodSafe(this.mService, RequestParameters.SUBRESOURCE_DELETE, null, null);
            this.mService = null;
        }
        unbind();
    }

    public void setMapViewMode(@MapViewModeConfig.MapViewModeConfig1 int i) {
        MapConfigBaseImpl mapConfigBaseImpl = this.mService;
        if (mapConfigBaseImpl != null) {
            mapConfigBaseImpl.$explicit_setMapViewMode(i);
        }
    }

    public void setIsNeedJudgeAutoScale(boolean z) {
        MapConfigBaseImpl mapConfigBaseImpl = this.mService;
        if (mapConfigBaseImpl != null) {
            mapConfigBaseImpl.$explicit_setIsNeedJudgeAutoScale(z);
        }
    }

    public void setZoomEnable(boolean z) {
        MapConfigBaseImpl mapConfigBaseImpl = this.mService;
        if (mapConfigBaseImpl != null) {
            mapConfigBaseImpl.$explicit_setZoomEnable(z);
        }
    }

    public void setMapScaleConfig(@MapScaleConfig.MapScaleConfig1 int i) {
        MapConfigBaseImpl mapConfigBaseImpl = this.mService;
        if (mapConfigBaseImpl != null) {
            mapConfigBaseImpl.$explicit_setMapScaleConfig(i);
        }
    }

    public void setDefaultMapCenter(Coord2DDouble coord2DDouble) {
        MapConfigBaseImpl mapConfigBaseImpl = this.mService;
        if (mapConfigBaseImpl != null) {
            mapConfigBaseImpl.$explicit_setDefaultMapCenter(coord2DDouble);
        }
    }

    public void setMapDayNightMode(@DayNightModeConfig.DayNightModeConfig1 int i) {
        MapConfigBaseImpl mapConfigBaseImpl = this.mService;
        if (mapConfigBaseImpl != null) {
            mapConfigBaseImpl.$explicit_setMapDayNightMode(i);
        }
    }

    public void setSkyDayNightMode(@DayNightModeConfig.DayNightModeConfig1 int i) {
        MapConfigBaseImpl mapConfigBaseImpl = this.mService;
        if (mapConfigBaseImpl != null) {
            mapConfigBaseImpl.$explicit_setSkyDayNightMode(i);
        }
    }

    public void setMapFadeOut(boolean z) {
        MapConfigBaseImpl mapConfigBaseImpl = this.mService;
        if (mapConfigBaseImpl != null) {
            mapConfigBaseImpl.$explicit_setMapFadeOut(z);
        }
    }

    public void setMapStyleFileNameDay(String str) {
        MapConfigBaseImpl mapConfigBaseImpl = this.mService;
        if (mapConfigBaseImpl != null) {
            mapConfigBaseImpl.$explicit_setMapStyleFileNameDay(str);
        }
    }

    public void setMapStyleFileNameNight(String str) {
        MapConfigBaseImpl mapConfigBaseImpl = this.mService;
        if (mapConfigBaseImpl != null) {
            mapConfigBaseImpl.$explicit_setMapStyleFileNameNight(str);
        }
    }

    public void setTmcConfig(@TmcConfig.TmcConfig1 int i) {
        MapConfigBaseImpl mapConfigBaseImpl = this.mService;
        if (mapConfigBaseImpl != null) {
            mapConfigBaseImpl.$explicit_setTmcConfig(i);
        }
    }

    public void setIsBuildingTextureVisiable(boolean z) {
        MapConfigBaseImpl mapConfigBaseImpl = this.mService;
        if (mapConfigBaseImpl != null) {
            mapConfigBaseImpl.$explicit_setIsBuildingTextureVisiable(z);
        }
    }

    public void setIs3DBuildingVisiable(boolean z) {
        MapConfigBaseImpl mapConfigBaseImpl = this.mService;
        if (mapConfigBaseImpl != null) {
            mapConfigBaseImpl.$explicit_setIs3DBuildingVisiable(z);
        }
    }

    public void setIsSimple3DEnabled(boolean z) {
        MapConfigBaseImpl mapConfigBaseImpl = this.mService;
        if (mapConfigBaseImpl != null) {
            mapConfigBaseImpl.$explicit_setIsSimple3DEnabled(z);
        }
    }

    public void setLogoLeft(int i) {
        MapConfigBaseImpl mapConfigBaseImpl = this.mService;
        if (mapConfigBaseImpl != null) {
            mapConfigBaseImpl.$explicit_setLogoLeft(i);
        }
    }

    public void setLogoTop(int i) {
        MapConfigBaseImpl mapConfigBaseImpl = this.mService;
        if (mapConfigBaseImpl != null) {
            mapConfigBaseImpl.$explicit_setLogoTop(i);
        }
    }

    public void setPreviewScreenLeft(int i) {
        MapConfigBaseImpl mapConfigBaseImpl = this.mService;
        if (mapConfigBaseImpl != null) {
            mapConfigBaseImpl.$explicit_setPreviewScreenLeft(i);
        }
    }

    public void setPreviewScreenRight(int i) {
        MapConfigBaseImpl mapConfigBaseImpl = this.mService;
        if (mapConfigBaseImpl != null) {
            mapConfigBaseImpl.$explicit_setPreviewScreenRight(i);
        }
    }

    public void setPreviewScreenTop(int i) {
        MapConfigBaseImpl mapConfigBaseImpl = this.mService;
        if (mapConfigBaseImpl != null) {
            mapConfigBaseImpl.$explicit_setPreviewScreenTop(i);
        }
    }

    public void setPreviewScreenBottom(int i) {
        MapConfigBaseImpl mapConfigBaseImpl = this.mService;
        if (mapConfigBaseImpl != null) {
            mapConfigBaseImpl.$explicit_setPreviewScreenBottom(i);
        }
    }

    public void setAllowedTransAnimation(boolean z) {
        MapConfigBaseImpl mapConfigBaseImpl = this.mService;
        if (mapConfigBaseImpl != null) {
            mapConfigBaseImpl.$explicit_setAllowedTransAnimation(z);
        }
    }

    public void setAnimationTime(int i) {
        MapConfigBaseImpl mapConfigBaseImpl = this.mService;
        if (mapConfigBaseImpl != null) {
            mapConfigBaseImpl.$explicit_setAnimationTime(i);
        }
    }

    public void setAnimationId(int i) {
        MapConfigBaseImpl mapConfigBaseImpl = this.mService;
        if (mapConfigBaseImpl != null) {
            mapConfigBaseImpl.$explicit_setAnimationId(i);
        }
    }

    public void setCarPosition(float f) {
        MapConfigBaseImpl mapConfigBaseImpl = this.mService;
        if (mapConfigBaseImpl != null) {
            mapConfigBaseImpl.$explicit_setCarPosition(f);
        }
    }

    public void setCarPositionN(float f) {
        MapConfigBaseImpl mapConfigBaseImpl = this.mService;
        if (mapConfigBaseImpl != null) {
            mapConfigBaseImpl.$explicit_setCarPositionN(f);
        }
    }

    public void setCarPositionHoriz(float f) {
        MapConfigBaseImpl mapConfigBaseImpl = this.mService;
        if (mapConfigBaseImpl != null) {
            mapConfigBaseImpl.$explicit_setCarPositionHoriz(f);
        }
    }

    public void setIs2DCarMode(boolean z) {
        MapConfigBaseImpl mapConfigBaseImpl = this.mService;
        if (mapConfigBaseImpl != null) {
            mapConfigBaseImpl.$explicit_setIs2DCarMode(z);
        }
    }

    @Override // com.autonavi.gbl.multi.observer.KldConfigItemBase, com.autonavi.gbl.multi.observer.IKldConfigItemBase, com.autonavi.gbl.multi.observer.IDisplayConfigBase
    public int parseConfigString(String str) {
        MapConfigBaseImpl mapConfigBaseImpl = this.mService;
        if (mapConfigBaseImpl != null) {
            return mapConfigBaseImpl.$explicit_parseConfigString(str);
        }
        return 0;
    }

    @Override // com.autonavi.gbl.multi.observer.KldConfigItemBase, com.autonavi.gbl.multi.observer.IKldConfigItemBase, com.autonavi.gbl.multi.observer.IDisplayConfigBase
    public int applyConfig(KldDisplay kldDisplay) {
        try {
            Method method = MapConfigBase.class.getMethod("applyConfig", KldDisplay.class);
            if (kldDisplay != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r2 = typeHelper != null ? (IKldDisplayImpl) typeHelper.transfer(method, 0, kldDisplay) : null;
                if (r2 == null) {
                    DebugTool.e("%s: $display == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.multi.observer.MapConfigBase.4
                    }));
                }
            }
            MapConfigBaseImpl mapConfigBaseImpl = this.mService;
            if (mapConfigBaseImpl != null) {
                return mapConfigBaseImpl.$explicit_applyConfig(r2);
            }
            return 0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0;
        }
    }

    @Override // com.autonavi.gbl.multi.observer.IMapConfigBase
    @MapViewModeConfig.MapViewModeConfig1
    public int getMapViewMode() {
        MapConfigBaseImpl mapConfigBaseImpl = this.mService;
        if (mapConfigBaseImpl != null) {
            return mapConfigBaseImpl.$explicit_getMapViewMode();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.multi.observer.IMapConfigBase
    public boolean getIsNeedJudgeAutoScale() {
        MapConfigBaseImpl mapConfigBaseImpl = this.mService;
        if (mapConfigBaseImpl != null) {
            return mapConfigBaseImpl.$explicit_getIsNeedJudgeAutoScale();
        }
        return false;
    }

    @Override // com.autonavi.gbl.multi.observer.IMapConfigBase
    public boolean getZoomEnable() {
        MapConfigBaseImpl mapConfigBaseImpl = this.mService;
        if (mapConfigBaseImpl != null) {
            return mapConfigBaseImpl.$explicit_getZoomEnable();
        }
        return false;
    }

    @Override // com.autonavi.gbl.multi.observer.IMapConfigBase
    @MapScaleConfig.MapScaleConfig1
    public int getMapScaleConfig() {
        MapConfigBaseImpl mapConfigBaseImpl = this.mService;
        if (mapConfigBaseImpl != null) {
            return mapConfigBaseImpl.$explicit_getMapScaleConfig();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.multi.observer.IMapConfigBase
    public Coord2DDouble getDefaultMapCenter() {
        MapConfigBaseImpl mapConfigBaseImpl = this.mService;
        if (mapConfigBaseImpl != null) {
            return mapConfigBaseImpl.$explicit_getDefaultMapCenter();
        }
        return null;
    }

    @Override // com.autonavi.gbl.multi.observer.IMapConfigBase
    @DayNightModeConfig.DayNightModeConfig1
    public int getMapDayNightMode() {
        MapConfigBaseImpl mapConfigBaseImpl = this.mService;
        if (mapConfigBaseImpl != null) {
            return mapConfigBaseImpl.$explicit_getMapDayNightMode();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.multi.observer.IMapConfigBase
    @DayNightModeConfig.DayNightModeConfig1
    public int getSkyDayNightMode() {
        MapConfigBaseImpl mapConfigBaseImpl = this.mService;
        if (mapConfigBaseImpl != null) {
            return mapConfigBaseImpl.$explicit_getSkyDayNightMode();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.multi.observer.IMapConfigBase
    public boolean getMapFadeOut() {
        MapConfigBaseImpl mapConfigBaseImpl = this.mService;
        if (mapConfigBaseImpl != null) {
            return mapConfigBaseImpl.$explicit_getMapFadeOut();
        }
        return false;
    }

    @Override // com.autonavi.gbl.multi.observer.IMapConfigBase
    public String getMapStyleFileNameDay() {
        MapConfigBaseImpl mapConfigBaseImpl = this.mService;
        if (mapConfigBaseImpl != null) {
            return mapConfigBaseImpl.$explicit_getMapStyleFileNameDay();
        }
        return null;
    }

    @Override // com.autonavi.gbl.multi.observer.IMapConfigBase
    public String getMapStyleFileNameNight() {
        MapConfigBaseImpl mapConfigBaseImpl = this.mService;
        if (mapConfigBaseImpl != null) {
            return mapConfigBaseImpl.$explicit_getMapStyleFileNameNight();
        }
        return null;
    }

    @Override // com.autonavi.gbl.multi.observer.IMapConfigBase
    @TmcConfig.TmcConfig1
    public int getTmcConfig() {
        MapConfigBaseImpl mapConfigBaseImpl = this.mService;
        if (mapConfigBaseImpl != null) {
            return mapConfigBaseImpl.$explicit_getTmcConfig();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.multi.observer.IMapConfigBase
    public boolean getIsBuildingTextureVisiable() {
        MapConfigBaseImpl mapConfigBaseImpl = this.mService;
        if (mapConfigBaseImpl != null) {
            return mapConfigBaseImpl.$explicit_getIsBuildingTextureVisiable();
        }
        return false;
    }

    @Override // com.autonavi.gbl.multi.observer.IMapConfigBase
    public boolean getIs3DBuildingVisiable() {
        MapConfigBaseImpl mapConfigBaseImpl = this.mService;
        if (mapConfigBaseImpl != null) {
            return mapConfigBaseImpl.$explicit_getIs3DBuildingVisiable();
        }
        return false;
    }

    @Override // com.autonavi.gbl.multi.observer.IMapConfigBase
    public boolean getIsSimple3DEnabled() {
        MapConfigBaseImpl mapConfigBaseImpl = this.mService;
        if (mapConfigBaseImpl != null) {
            return mapConfigBaseImpl.$explicit_getIsSimple3DEnabled();
        }
        return false;
    }

    @Override // com.autonavi.gbl.multi.observer.IMapConfigBase
    public int getLogoLeft() {
        MapConfigBaseImpl mapConfigBaseImpl = this.mService;
        if (mapConfigBaseImpl != null) {
            return mapConfigBaseImpl.$explicit_getLogoLeft();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.multi.observer.IMapConfigBase
    public int getLogoTop() {
        MapConfigBaseImpl mapConfigBaseImpl = this.mService;
        if (mapConfigBaseImpl != null) {
            return mapConfigBaseImpl.$explicit_getLogoTop();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.multi.observer.IMapConfigBase
    public int getPreviewScreenLeft() {
        MapConfigBaseImpl mapConfigBaseImpl = this.mService;
        if (mapConfigBaseImpl != null) {
            return mapConfigBaseImpl.$explicit_getPreviewScreenLeft();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.multi.observer.IMapConfigBase
    public int getPreviewScreenRight() {
        MapConfigBaseImpl mapConfigBaseImpl = this.mService;
        if (mapConfigBaseImpl != null) {
            return mapConfigBaseImpl.$explicit_getPreviewScreenRight();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.multi.observer.IMapConfigBase
    public int getPreviewScreenTop() {
        MapConfigBaseImpl mapConfigBaseImpl = this.mService;
        if (mapConfigBaseImpl != null) {
            return mapConfigBaseImpl.$explicit_getPreviewScreenTop();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.multi.observer.IMapConfigBase
    public int getPreviewScreenBottom() {
        MapConfigBaseImpl mapConfigBaseImpl = this.mService;
        if (mapConfigBaseImpl != null) {
            return mapConfigBaseImpl.$explicit_getPreviewScreenBottom();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.multi.observer.IMapConfigBase
    public boolean getAllowedTransAnimation() {
        MapConfigBaseImpl mapConfigBaseImpl = this.mService;
        if (mapConfigBaseImpl != null) {
            return mapConfigBaseImpl.$explicit_getAllowedTransAnimation();
        }
        return false;
    }

    @Override // com.autonavi.gbl.multi.observer.IMapConfigBase
    public int getAnimationTime() {
        MapConfigBaseImpl mapConfigBaseImpl = this.mService;
        if (mapConfigBaseImpl != null) {
            return mapConfigBaseImpl.$explicit_getAnimationTime();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.multi.observer.IMapConfigBase
    public int getAnimationId() {
        MapConfigBaseImpl mapConfigBaseImpl = this.mService;
        if (mapConfigBaseImpl != null) {
            return mapConfigBaseImpl.$explicit_getAnimationId();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.multi.observer.IMapConfigBase
    public float getCarPosition() {
        MapConfigBaseImpl mapConfigBaseImpl = this.mService;
        if (mapConfigBaseImpl != null) {
            return mapConfigBaseImpl.$explicit_getCarPosition();
        }
        return 0.0f;
    }

    @Override // com.autonavi.gbl.multi.observer.IMapConfigBase
    public float getCarPositionN() {
        MapConfigBaseImpl mapConfigBaseImpl = this.mService;
        if (mapConfigBaseImpl != null) {
            return mapConfigBaseImpl.$explicit_getCarPositionN();
        }
        return 0.0f;
    }

    @Override // com.autonavi.gbl.multi.observer.IMapConfigBase
    public float getCarPositionHoriz() {
        MapConfigBaseImpl mapConfigBaseImpl = this.mService;
        if (mapConfigBaseImpl != null) {
            return mapConfigBaseImpl.$explicit_getCarPositionHoriz();
        }
        return 0.0f;
    }

    @Override // com.autonavi.gbl.multi.observer.IMapConfigBase
    public boolean getIs2DCarMode() {
        MapConfigBaseImpl mapConfigBaseImpl = this.mService;
        if (mapConfigBaseImpl != null) {
            return mapConfigBaseImpl.$explicit_getIs2DCarMode();
        }
        return false;
    }
}
