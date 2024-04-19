package com.autonavi.gbl.multi.router;

import android.util.Log;
import com.autonavi.auto.intfauto.BindTable;
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
import com.autonavi.gbl.multi.observer.IMapConfigBase;
import com.autonavi.gbl.multi.observer.MapConfigBase;
import com.autonavi.gbl.multi.observer.impl.MapConfigBaseImpl;
import java.lang.reflect.Method;
@IntfAuto(target = MapConfigBase.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class MapConfigBaseRouter extends MapConfigBaseImpl {
    private static BindTable BIND_TABLE = new BindTable(MapConfigBaseRouter.class);
    private static String PACKAGE = ReflexTool.PN(MapConfigBaseRouter.class);
    private TypeHelper mHelper;
    private IMapConfigBase mObserver;
    private String mTargetId;

    protected Object getObserver() {
        return this.mObserver;
    }

    protected void bindObserver(IMapConfigBase iMapConfigBase) {
        if (iMapConfigBase != null) {
            this.mObserver = iMapConfigBase;
            TypeHelper typeHelper = this.mHelper;
            if (typeHelper != null) {
                typeHelper.bind(MapConfigBase.class, iMapConfigBase, this);
            }
        }
    }

    private void $constructor(String str, IMapConfigBase iMapConfigBase) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(MapConfigBaseImpl.getCPtr((MapConfigBaseImpl) this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        bindObserver(iMapConfigBase);
    }

    public MapConfigBaseRouter(String str, IMapConfigBase iMapConfigBase, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iMapConfigBase);
    }

    public MapConfigBaseRouter(String str, IMapConfigBase iMapConfigBase) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iMapConfigBase);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.multi.router.MapConfigBaseRouter.1
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
    @Override // com.autonavi.gbl.multi.observer.impl.MapConfigBaseImpl, com.autonavi.gbl.multi.observer.impl.IKldConfigItemBaseImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.multi.router.MapConfigBaseRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.multi.observer.impl.MapConfigBaseImpl, com.autonavi.gbl.multi.observer.impl.IKldConfigItemBaseImpl
    public int parseConfigString(String str) {
        IMapConfigBase iMapConfigBase = this.mObserver;
        if (iMapConfigBase != null) {
            return iMapConfigBase.parseConfigString(str);
        }
        return 0;
    }

    @Override // com.autonavi.gbl.multi.observer.impl.MapConfigBaseImpl, com.autonavi.gbl.multi.observer.impl.IKldConfigItemBaseImpl
    public int applyConfig(IKldDisplayImpl iKldDisplayImpl) {
        try {
            Method method = MapConfigBaseRouter.class.getMethod("applyConfig", IKldDisplayImpl.class);
            if (iKldDisplayImpl != null) {
                TypeHelper typeHelper = this.mHelper;
                r2 = typeHelper != null ? (KldDisplay) typeHelper.transfer(method, 0, iKldDisplayImpl) : null;
                if (r2 == null) {
                    DebugTool.e("%s: $display == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.multi.router.MapConfigBaseRouter.3
                    }));
                }
            }
            IMapConfigBase iMapConfigBase = this.mObserver;
            if (iMapConfigBase != null) {
                return iMapConfigBase.applyConfig(r2);
            }
            return 0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0;
        }
    }

    @Override // com.autonavi.gbl.multi.observer.impl.MapConfigBaseImpl
    @MapViewModeConfig.MapViewModeConfig1
    public int getMapViewMode() {
        IMapConfigBase iMapConfigBase = this.mObserver;
        if (iMapConfigBase != null) {
            return iMapConfigBase.getMapViewMode();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.multi.observer.impl.MapConfigBaseImpl
    public boolean getIsNeedJudgeAutoScale() {
        IMapConfigBase iMapConfigBase = this.mObserver;
        if (iMapConfigBase != null) {
            return iMapConfigBase.getIsNeedJudgeAutoScale();
        }
        return false;
    }

    @Override // com.autonavi.gbl.multi.observer.impl.MapConfigBaseImpl
    public boolean getZoomEnable() {
        IMapConfigBase iMapConfigBase = this.mObserver;
        if (iMapConfigBase != null) {
            return iMapConfigBase.getZoomEnable();
        }
        return false;
    }

    @Override // com.autonavi.gbl.multi.observer.impl.MapConfigBaseImpl
    @MapScaleConfig.MapScaleConfig1
    public int getMapScaleConfig() {
        IMapConfigBase iMapConfigBase = this.mObserver;
        if (iMapConfigBase != null) {
            return iMapConfigBase.getMapScaleConfig();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.multi.observer.impl.MapConfigBaseImpl
    public Coord2DDouble getDefaultMapCenter() {
        IMapConfigBase iMapConfigBase = this.mObserver;
        if (iMapConfigBase != null) {
            return iMapConfigBase.getDefaultMapCenter();
        }
        return null;
    }

    @Override // com.autonavi.gbl.multi.observer.impl.MapConfigBaseImpl
    @DayNightModeConfig.DayNightModeConfig1
    public int getMapDayNightMode() {
        IMapConfigBase iMapConfigBase = this.mObserver;
        if (iMapConfigBase != null) {
            return iMapConfigBase.getMapDayNightMode();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.multi.observer.impl.MapConfigBaseImpl
    @DayNightModeConfig.DayNightModeConfig1
    public int getSkyDayNightMode() {
        IMapConfigBase iMapConfigBase = this.mObserver;
        if (iMapConfigBase != null) {
            return iMapConfigBase.getSkyDayNightMode();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.multi.observer.impl.MapConfigBaseImpl
    public boolean getMapFadeOut() {
        IMapConfigBase iMapConfigBase = this.mObserver;
        if (iMapConfigBase != null) {
            return iMapConfigBase.getMapFadeOut();
        }
        return false;
    }

    @Override // com.autonavi.gbl.multi.observer.impl.MapConfigBaseImpl
    public String getMapStyleFileNameDay() {
        IMapConfigBase iMapConfigBase = this.mObserver;
        if (iMapConfigBase != null) {
            return iMapConfigBase.getMapStyleFileNameDay();
        }
        return null;
    }

    @Override // com.autonavi.gbl.multi.observer.impl.MapConfigBaseImpl
    public String getMapStyleFileNameNight() {
        IMapConfigBase iMapConfigBase = this.mObserver;
        if (iMapConfigBase != null) {
            return iMapConfigBase.getMapStyleFileNameNight();
        }
        return null;
    }

    @Override // com.autonavi.gbl.multi.observer.impl.MapConfigBaseImpl
    @TmcConfig.TmcConfig1
    public int getTmcConfig() {
        IMapConfigBase iMapConfigBase = this.mObserver;
        if (iMapConfigBase != null) {
            return iMapConfigBase.getTmcConfig();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.multi.observer.impl.MapConfigBaseImpl
    public boolean getIsBuildingTextureVisiable() {
        IMapConfigBase iMapConfigBase = this.mObserver;
        if (iMapConfigBase != null) {
            return iMapConfigBase.getIsBuildingTextureVisiable();
        }
        return false;
    }

    @Override // com.autonavi.gbl.multi.observer.impl.MapConfigBaseImpl
    public boolean getIs3DBuildingVisiable() {
        IMapConfigBase iMapConfigBase = this.mObserver;
        if (iMapConfigBase != null) {
            return iMapConfigBase.getIs3DBuildingVisiable();
        }
        return false;
    }

    @Override // com.autonavi.gbl.multi.observer.impl.MapConfigBaseImpl
    public boolean getIsSimple3DEnabled() {
        IMapConfigBase iMapConfigBase = this.mObserver;
        if (iMapConfigBase != null) {
            return iMapConfigBase.getIsSimple3DEnabled();
        }
        return false;
    }

    @Override // com.autonavi.gbl.multi.observer.impl.MapConfigBaseImpl
    public int getLogoLeft() {
        IMapConfigBase iMapConfigBase = this.mObserver;
        if (iMapConfigBase != null) {
            return iMapConfigBase.getLogoLeft();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.multi.observer.impl.MapConfigBaseImpl
    public int getLogoTop() {
        IMapConfigBase iMapConfigBase = this.mObserver;
        if (iMapConfigBase != null) {
            return iMapConfigBase.getLogoTop();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.multi.observer.impl.MapConfigBaseImpl
    public int getPreviewScreenLeft() {
        IMapConfigBase iMapConfigBase = this.mObserver;
        if (iMapConfigBase != null) {
            return iMapConfigBase.getPreviewScreenLeft();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.multi.observer.impl.MapConfigBaseImpl
    public int getPreviewScreenRight() {
        IMapConfigBase iMapConfigBase = this.mObserver;
        if (iMapConfigBase != null) {
            return iMapConfigBase.getPreviewScreenRight();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.multi.observer.impl.MapConfigBaseImpl
    public int getPreviewScreenTop() {
        IMapConfigBase iMapConfigBase = this.mObserver;
        if (iMapConfigBase != null) {
            return iMapConfigBase.getPreviewScreenTop();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.multi.observer.impl.MapConfigBaseImpl
    public int getPreviewScreenBottom() {
        IMapConfigBase iMapConfigBase = this.mObserver;
        if (iMapConfigBase != null) {
            return iMapConfigBase.getPreviewScreenBottom();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.multi.observer.impl.MapConfigBaseImpl
    public boolean getAllowedTransAnimation() {
        IMapConfigBase iMapConfigBase = this.mObserver;
        if (iMapConfigBase != null) {
            return iMapConfigBase.getAllowedTransAnimation();
        }
        return false;
    }

    @Override // com.autonavi.gbl.multi.observer.impl.MapConfigBaseImpl
    public int getAnimationTime() {
        IMapConfigBase iMapConfigBase = this.mObserver;
        if (iMapConfigBase != null) {
            return iMapConfigBase.getAnimationTime();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.multi.observer.impl.MapConfigBaseImpl
    public int getAnimationId() {
        IMapConfigBase iMapConfigBase = this.mObserver;
        if (iMapConfigBase != null) {
            return iMapConfigBase.getAnimationId();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.multi.observer.impl.MapConfigBaseImpl
    public float getCarPosition() {
        IMapConfigBase iMapConfigBase = this.mObserver;
        if (iMapConfigBase != null) {
            return iMapConfigBase.getCarPosition();
        }
        return 0.0f;
    }

    @Override // com.autonavi.gbl.multi.observer.impl.MapConfigBaseImpl
    public float getCarPositionN() {
        IMapConfigBase iMapConfigBase = this.mObserver;
        if (iMapConfigBase != null) {
            return iMapConfigBase.getCarPositionN();
        }
        return 0.0f;
    }

    @Override // com.autonavi.gbl.multi.observer.impl.MapConfigBaseImpl
    public float getCarPositionHoriz() {
        IMapConfigBase iMapConfigBase = this.mObserver;
        if (iMapConfigBase != null) {
            return iMapConfigBase.getCarPositionHoriz();
        }
        return 0.0f;
    }

    @Override // com.autonavi.gbl.multi.observer.impl.MapConfigBaseImpl
    public boolean getIs2DCarMode() {
        IMapConfigBase iMapConfigBase = this.mObserver;
        if (iMapConfigBase != null) {
            return iMapConfigBase.getIs2DCarMode();
        }
        return false;
    }

    @Override // com.autonavi.gbl.multi.observer.impl.IKldConfigItemBaseImpl
    public String getTypeName() {
        IMapConfigBase iMapConfigBase = this.mObserver;
        if (iMapConfigBase != null) {
            return iMapConfigBase.getTypeName();
        }
        return null;
    }

    @Override // com.autonavi.gbl.multi.observer.impl.IKldConfigItemBaseImpl
    public void getTypeName(String[] strArr) {
        IMapConfigBase iMapConfigBase = this.mObserver;
        if (iMapConfigBase != null) {
            iMapConfigBase.getTypeName(strArr);
        }
    }

    @Override // com.autonavi.gbl.multi.observer.impl.IKldConfigItemBaseImpl
    public String getConfigName() {
        IMapConfigBase iMapConfigBase = this.mObserver;
        if (iMapConfigBase != null) {
            return iMapConfigBase.getConfigName();
        }
        return null;
    }

    @Override // com.autonavi.gbl.multi.observer.impl.IKldConfigItemBaseImpl
    public void getConfigName(String[] strArr) {
        IMapConfigBase iMapConfigBase = this.mObserver;
        if (iMapConfigBase != null) {
            iMapConfigBase.getConfigName(strArr);
        }
    }
}
