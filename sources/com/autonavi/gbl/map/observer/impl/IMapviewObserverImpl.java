package com.autonavi.gbl.map.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.map.model.GuideRoadNameBoardParam;
import com.autonavi.gbl.map.model.IndoorBuilding;
import com.autonavi.gbl.map.model.MapLabelItem;
import com.autonavi.gbl.map.model.MapRoadTip;
import com.autonavi.gbl.map.model.MapviewMode;
import com.autonavi.gbl.map.model.RenderMapType;
import com.autonavi.gbl.map.model.ScenicInfo;
import com.autonavi.gbl.map.observer.IMapviewObserver;
import java.util.ArrayList;
@IntfAuto(target = IMapviewObserver.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class IMapviewObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(IMapviewObserverImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void IMapviewObserverImpl_change_ownership(IMapviewObserverImpl iMapviewObserverImpl, long j, boolean z);

    private static native void IMapviewObserverImpl_director_connect(IMapviewObserverImpl iMapviewObserverImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void onCheckIngDataRenderCompleteNative(long j, IMapviewObserverImpl iMapviewObserverImpl, long j2, long j3);

    private static native void onClickBlankNative(long j, IMapviewObserverImpl iMapviewObserverImpl, long j2, float f, float f2);

    private static native void onClickLabelNative(long j, IMapviewObserverImpl iMapviewObserverImpl, long j2, ArrayList<MapLabelItem> arrayList);

    private static native void onGuideRoadBoardNameProcessedNative(long j, IMapviewObserverImpl iMapviewObserverImpl, long j2, long j3, GuideRoadNameBoardParam guideRoadNameBoardParam);

    private static native void onIndoorBuildingActivityNative(long j, IMapviewObserverImpl iMapviewObserverImpl, long j2, long j3, IndoorBuilding indoorBuilding);

    private static native void onMapAnimationFinishedNative(long j, IMapviewObserverImpl iMapviewObserverImpl, long j2, long j3);

    private static native void onMapCenterChangedNative(long j, IMapviewObserverImpl iMapviewObserverImpl, long j2, double d, double d2);

    private static native void onMapHeatActiveNative(long j, IMapviewObserverImpl iMapviewObserverImpl, long j2, boolean z);

    private static native void onMapLevelChangedNative(long j, IMapviewObserverImpl iMapviewObserverImpl, long j2, boolean z);

    private static native void onMapModeChangedNative(long j, IMapviewObserverImpl iMapviewObserverImpl, long j2, int i);

    private static native void onMapPreviewEnterNative(long j, IMapviewObserverImpl iMapviewObserverImpl, long j2);

    private static native void onMapPreviewExitNative(long j, IMapviewObserverImpl iMapviewObserverImpl, long j2);

    private static native void onMapSizeChangedNative(long j, IMapviewObserverImpl iMapviewObserverImpl, long j2);

    private static native void onMapViewDestoryNative(long j, IMapviewObserverImpl iMapviewObserverImpl, long j2);

    private static native void onMapVisibleIndoorNative(long j, IMapviewObserverImpl iMapviewObserverImpl, long j2, ArrayList<IndoorBuilding> arrayList, ArrayList<IndoorBuilding> arrayList2);

    private static native void onMotionFinishedNative(long j, IMapviewObserverImpl iMapviewObserverImpl, long j2, int i);

    private static native void onPitchAngleNative(long j, IMapviewObserverImpl iMapviewObserverImpl, long j2, float f);

    private static native void onPreDrawFrameNative(long j, IMapviewObserverImpl iMapviewObserverImpl, long j2);

    private static native void onRealCityAnimationFinishedNative(long j, IMapviewObserverImpl iMapviewObserverImpl, long j2);

    private static native void onRenderEnterNative(long j, IMapviewObserverImpl iMapviewObserverImpl, long j2);

    private static native void onRenderMapNative(long j, IMapviewObserverImpl iMapviewObserverImpl, long j2, int i);

    private static native void onRollAngleNative(long j, IMapviewObserverImpl iMapviewObserverImpl, long j2, float f);

    private static native void onRouteBoardDataNative(long j, IMapviewObserverImpl iMapviewObserverImpl, long j2, ArrayList<MapRoadTip> arrayList);

    private static native void onScenicActiveNative(long j, IMapviewObserverImpl iMapviewObserverImpl, long j2, long j3, ScenicInfo scenicInfo);

    private static native void onSelectSubWayActiveNative(long j, IMapviewObserverImpl iMapviewObserverImpl, long j2, long[] jArr);

    public IMapviewObserverImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IMapviewObserverImpl) && getUID(this) == getUID((IMapviewObserverImpl) obj);
    }

    private static long getUID(IMapviewObserverImpl iMapviewObserverImpl) {
        long cPtr = getCPtr(iMapviewObserverImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IMapviewObserverImpl iMapviewObserverImpl) {
        if (iMapviewObserverImpl == null) {
            return 0L;
        }
        return iMapviewObserverImpl.swigCPtr;
    }

    public boolean isRecycled() {
        return this.swigCPtr == 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void delete() {
        LogUtils.d(String.format("swigCPtr=%%s, swigCMemOwn=%%s", String.valueOf(this.swigCPtr), String.valueOf(this.swigCMemOwn)));
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                destroyNativeObj(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
    }

    protected void swigDirectorDisconnect() {
        this.swigCMemOwn = false;
        delete();
    }

    public void swigReleaseOwnership() {
        this.swigCMemOwn = false;
        IMapviewObserverImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        IMapviewObserverImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void onMapCenterChanged(long j, double d, double d2) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        onMapCenterChangedNative(j2, this, j, d, d2);
    }

    public void onMapSizeChanged(long j) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        onMapSizeChangedNative(j2, this, j);
    }

    public void onMapLevelChanged(long j, boolean z) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        onMapLevelChangedNative(j2, this, j, z);
    }

    public void onMapModeChanged(long j, @MapviewMode.MapviewMode1 int i) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        onMapModeChangedNative(j2, this, j, i);
    }

    public void onMapPreviewEnter(long j) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        onMapPreviewEnterNative(j2, this, j);
    }

    public void onMapPreviewExit(long j) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        onMapPreviewExitNative(j2, this, j);
    }

    public void onClickLabel(long j, ArrayList<MapLabelItem> arrayList) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        onClickLabelNative(j2, this, j, arrayList);
    }

    public void onClickBlank(long j, float f, float f2) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        onClickBlankNative(j2, this, j, f, f2);
    }

    public void onRenderMap(long j, @RenderMapType.RenderMapType1 int i) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        onRenderMapNative(j2, this, j, i);
    }

    public void onRealCityAnimationFinished(long j) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        onRealCityAnimationFinishedNative(j2, this, j);
    }

    public void onMapAnimationFinished(long j, long j2) {
        long j3 = this.swigCPtr;
        if (j3 == 0) {
            throw new NullPointerException();
        }
        onMapAnimationFinishedNative(j3, this, j, j2);
    }

    public void onRouteBoardData(long j, ArrayList<MapRoadTip> arrayList) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        onRouteBoardDataNative(j2, this, j, arrayList);
    }

    public void onMapHeatActive(long j, boolean z) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        onMapHeatActiveNative(j2, this, j, z);
    }

    public void onScenicActive(long j, ScenicInfo scenicInfo) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        onScenicActiveNative(j2, this, j, 0L, scenicInfo);
    }

    public void onIndoorBuildingActivity(long j, IndoorBuilding indoorBuilding) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        onIndoorBuildingActivityNative(j2, this, j, 0L, indoorBuilding);
    }

    public void onSelectSubWayActive(long j, long[] jArr) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        onSelectSubWayActiveNative(j2, this, j, jArr);
    }

    public void onMotionFinished(long j, int i) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        onMotionFinishedNative(j2, this, j, i);
    }

    public void onPreDrawFrame(long j) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        onPreDrawFrameNative(j2, this, j);
    }

    public void onRenderEnter(long j) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        onRenderEnterNative(j2, this, j);
    }

    public void onMapViewDestory(long j) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        onMapViewDestoryNative(j2, this, j);
    }

    public void onRollAngle(long j, float f) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        onRollAngleNative(j2, this, j, f);
    }

    public void onPitchAngle(long j, float f) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        onPitchAngleNative(j2, this, j, f);
    }

    public void onCheckIngDataRenderComplete(long j, long j2) {
        long j3 = this.swigCPtr;
        if (j3 == 0) {
            throw new NullPointerException();
        }
        onCheckIngDataRenderCompleteNative(j3, this, j, j2);
    }

    public void onGuideRoadBoardNameProcessed(long j, GuideRoadNameBoardParam guideRoadNameBoardParam) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        onGuideRoadBoardNameProcessedNative(j2, this, j, 0L, guideRoadNameBoardParam);
    }

    public void onMapVisibleIndoor(long j, ArrayList<IndoorBuilding> arrayList, ArrayList<IndoorBuilding> arrayList2) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        onMapVisibleIndoorNative(j2, this, j, arrayList, arrayList2);
    }

    public IMapviewObserverImpl() {
        this(createNativeObj(), true);
        MapObserverJNI.swig_jni_init();
        IMapviewObserverImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
