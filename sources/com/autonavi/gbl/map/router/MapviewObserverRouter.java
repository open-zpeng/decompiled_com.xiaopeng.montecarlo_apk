package com.autonavi.gbl.map.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.map.model.GuideRoadNameBoardParam;
import com.autonavi.gbl.map.model.IndoorBuilding;
import com.autonavi.gbl.map.model.MapLabelItem;
import com.autonavi.gbl.map.model.MapRoadTip;
import com.autonavi.gbl.map.model.MapviewMode;
import com.autonavi.gbl.map.model.RenderMapType;
import com.autonavi.gbl.map.model.ScenicInfo;
import com.autonavi.gbl.map.observer.IMapviewObserver;
import com.autonavi.gbl.map.observer.impl.IMapviewObserverImpl;
import java.util.ArrayList;
@IntfAuto(target = IMapviewObserver.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class MapviewObserverRouter extends IMapviewObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(MapviewObserverRouter.class);
    private static String PACKAGE = ReflexTool.PN(MapviewObserverRouter.class);
    private TypeHelper mHelper;
    private IMapviewObserver mObserver;
    private String mTargetId;

    private void $constructor(String str, IMapviewObserver iMapviewObserver) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(IMapviewObserverImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iMapviewObserver;
    }

    protected MapviewObserverRouter(String str, IMapviewObserver iMapviewObserver, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iMapviewObserver);
    }

    protected MapviewObserverRouter(String str, IMapviewObserver iMapviewObserver) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iMapviewObserver);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.observer.impl.IMapviewObserverImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.map.observer.impl.IMapviewObserverImpl
    public void onMapCenterChanged(long j, double d, double d2) {
        IMapviewObserver iMapviewObserver = this.mObserver;
        if (iMapviewObserver != null) {
            iMapviewObserver.onMapCenterChanged(j, d, d2);
        }
    }

    @Override // com.autonavi.gbl.map.observer.impl.IMapviewObserverImpl
    public void onMapSizeChanged(long j) {
        IMapviewObserver iMapviewObserver = this.mObserver;
        if (iMapviewObserver != null) {
            iMapviewObserver.onMapSizeChanged(j);
        }
    }

    @Override // com.autonavi.gbl.map.observer.impl.IMapviewObserverImpl
    public void onMapLevelChanged(long j, boolean z) {
        IMapviewObserver iMapviewObserver = this.mObserver;
        if (iMapviewObserver != null) {
            iMapviewObserver.onMapLevelChanged(j, z);
        }
    }

    @Override // com.autonavi.gbl.map.observer.impl.IMapviewObserverImpl
    public void onMapModeChanged(long j, @MapviewMode.MapviewMode1 int i) {
        IMapviewObserver iMapviewObserver = this.mObserver;
        if (iMapviewObserver != null) {
            iMapviewObserver.onMapModeChanged(j, i);
        }
    }

    @Override // com.autonavi.gbl.map.observer.impl.IMapviewObserverImpl
    public void onMapPreviewEnter(long j) {
        IMapviewObserver iMapviewObserver = this.mObserver;
        if (iMapviewObserver != null) {
            iMapviewObserver.onMapPreviewEnter(j);
        }
    }

    @Override // com.autonavi.gbl.map.observer.impl.IMapviewObserverImpl
    public void onMapPreviewExit(long j) {
        IMapviewObserver iMapviewObserver = this.mObserver;
        if (iMapviewObserver != null) {
            iMapviewObserver.onMapPreviewExit(j);
        }
    }

    @Override // com.autonavi.gbl.map.observer.impl.IMapviewObserverImpl
    public void onClickLabel(long j, ArrayList<MapLabelItem> arrayList) {
        IMapviewObserver iMapviewObserver = this.mObserver;
        if (iMapviewObserver != null) {
            iMapviewObserver.onClickLabel(j, arrayList);
        }
    }

    @Override // com.autonavi.gbl.map.observer.impl.IMapviewObserverImpl
    public void onClickBlank(long j, float f, float f2) {
        IMapviewObserver iMapviewObserver = this.mObserver;
        if (iMapviewObserver != null) {
            iMapviewObserver.onClickBlank(j, f, f2);
        }
    }

    @Override // com.autonavi.gbl.map.observer.impl.IMapviewObserverImpl
    public void onRenderMap(long j, @RenderMapType.RenderMapType1 int i) {
        IMapviewObserver iMapviewObserver = this.mObserver;
        if (iMapviewObserver != null) {
            iMapviewObserver.onRenderMap(j, i);
        }
    }

    @Override // com.autonavi.gbl.map.observer.impl.IMapviewObserverImpl
    public void onRealCityAnimationFinished(long j) {
        IMapviewObserver iMapviewObserver = this.mObserver;
        if (iMapviewObserver != null) {
            iMapviewObserver.onRealCityAnimationFinished(j);
        }
    }

    @Override // com.autonavi.gbl.map.observer.impl.IMapviewObserverImpl
    public void onMapAnimationFinished(long j, long j2) {
        IMapviewObserver iMapviewObserver = this.mObserver;
        if (iMapviewObserver != null) {
            iMapviewObserver.onMapAnimationFinished(j, j2);
        }
    }

    @Override // com.autonavi.gbl.map.observer.impl.IMapviewObserverImpl
    public void onRouteBoardData(long j, ArrayList<MapRoadTip> arrayList) {
        IMapviewObserver iMapviewObserver = this.mObserver;
        if (iMapviewObserver != null) {
            iMapviewObserver.onRouteBoardData(j, arrayList);
        }
    }

    @Override // com.autonavi.gbl.map.observer.impl.IMapviewObserverImpl
    public void onMapHeatActive(long j, boolean z) {
        IMapviewObserver iMapviewObserver = this.mObserver;
        if (iMapviewObserver != null) {
            iMapviewObserver.onMapHeatActive(j, z);
        }
    }

    @Override // com.autonavi.gbl.map.observer.impl.IMapviewObserverImpl
    public void onScenicActive(long j, ScenicInfo scenicInfo) {
        IMapviewObserver iMapviewObserver = this.mObserver;
        if (iMapviewObserver != null) {
            iMapviewObserver.onScenicActive(j, scenicInfo);
        }
    }

    @Override // com.autonavi.gbl.map.observer.impl.IMapviewObserverImpl
    public void onIndoorBuildingActivity(long j, IndoorBuilding indoorBuilding) {
        IMapviewObserver iMapviewObserver = this.mObserver;
        if (iMapviewObserver != null) {
            iMapviewObserver.onIndoorBuildingActivity(j, indoorBuilding);
        }
    }

    @Override // com.autonavi.gbl.map.observer.impl.IMapviewObserverImpl
    public void onSelectSubWayActive(long j, long[] jArr) {
        IMapviewObserver iMapviewObserver = this.mObserver;
        if (iMapviewObserver != null) {
            iMapviewObserver.onSelectSubWayActive(j, jArr);
        }
    }

    @Override // com.autonavi.gbl.map.observer.impl.IMapviewObserverImpl
    public void onMotionFinished(long j, int i) {
        IMapviewObserver iMapviewObserver = this.mObserver;
        if (iMapviewObserver != null) {
            iMapviewObserver.onMotionFinished(j, i);
        }
    }

    @Override // com.autonavi.gbl.map.observer.impl.IMapviewObserverImpl
    public void onPreDrawFrame(long j) {
        IMapviewObserver iMapviewObserver = this.mObserver;
        if (iMapviewObserver != null) {
            iMapviewObserver.onPreDrawFrame(j);
        }
    }

    @Override // com.autonavi.gbl.map.observer.impl.IMapviewObserverImpl
    public void onRenderEnter(long j) {
        IMapviewObserver iMapviewObserver = this.mObserver;
        if (iMapviewObserver != null) {
            iMapviewObserver.onRenderEnter(j);
        }
    }

    @Override // com.autonavi.gbl.map.observer.impl.IMapviewObserverImpl
    public void onMapViewDestory(long j) {
        IMapviewObserver iMapviewObserver = this.mObserver;
        if (iMapviewObserver != null) {
            iMapviewObserver.onMapViewDestory(j);
        }
    }

    @Override // com.autonavi.gbl.map.observer.impl.IMapviewObserverImpl
    public void onRollAngle(long j, float f) {
        IMapviewObserver iMapviewObserver = this.mObserver;
        if (iMapviewObserver != null) {
            iMapviewObserver.onRollAngle(j, f);
        }
    }

    @Override // com.autonavi.gbl.map.observer.impl.IMapviewObserverImpl
    public void onPitchAngle(long j, float f) {
        IMapviewObserver iMapviewObserver = this.mObserver;
        if (iMapviewObserver != null) {
            iMapviewObserver.onPitchAngle(j, f);
        }
    }

    @Override // com.autonavi.gbl.map.observer.impl.IMapviewObserverImpl
    public void onCheckIngDataRenderComplete(long j, long j2) {
        IMapviewObserver iMapviewObserver = this.mObserver;
        if (iMapviewObserver != null) {
            iMapviewObserver.onCheckIngDataRenderComplete(j, j2);
        }
    }

    @Override // com.autonavi.gbl.map.observer.impl.IMapviewObserverImpl
    public void onGuideRoadBoardNameProcessed(long j, GuideRoadNameBoardParam guideRoadNameBoardParam) {
        IMapviewObserver iMapviewObserver = this.mObserver;
        if (iMapviewObserver != null) {
            iMapviewObserver.onGuideRoadBoardNameProcessed(j, guideRoadNameBoardParam);
        }
    }

    @Override // com.autonavi.gbl.map.observer.impl.IMapviewObserverImpl
    public void onMapVisibleIndoor(long j, ArrayList<IndoorBuilding> arrayList, ArrayList<IndoorBuilding> arrayList2) {
        IMapviewObserver iMapviewObserver = this.mObserver;
        if (iMapviewObserver != null) {
            iMapviewObserver.onMapVisibleIndoor(j, arrayList, arrayList2);
        }
    }
}
