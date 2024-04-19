package com.autonavi.gbl.map.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.map.OperatorBusiness;
import com.autonavi.gbl.map.layer.model.OpenLayerID;
import com.autonavi.gbl.map.model.CustomStyleParam;
import com.autonavi.gbl.map.model.GetOpenlayerParam;
import com.autonavi.gbl.map.model.GuideRoadNameBoardParam;
import com.autonavi.gbl.map.model.Label3rd;
import com.autonavi.gbl.map.model.MapBusinessDataType;
import com.autonavi.gbl.map.model.MapParameter;
import com.autonavi.gbl.map.model.MapPoiCustomOperateType;
import com.autonavi.gbl.map.model.MapSkyboxParam;
import com.autonavi.gbl.map.model.MapStyleParam;
import com.autonavi.gbl.map.model.MapViewStateType;
import com.autonavi.gbl.map.model.MsgDataActiveIndoorBuilding;
import com.autonavi.gbl.map.model.MsgDataBuildingFocus;
import com.autonavi.gbl.map.model.MsgDataDynamicSky;
import com.autonavi.gbl.map.model.MsgDataInternalTexture;
import com.autonavi.gbl.map.model.MsgDataRemovePoiFilter;
import com.autonavi.gbl.map.model.MsgDataSetPointLight;
import com.autonavi.gbl.map.model.NakeEyeMapViewParam;
import com.autonavi.gbl.map.model.PoiFilter;
import com.autonavi.gbl.map.model.PoiLinearGradientParam;
import com.autonavi.gbl.map.model.ScenicFilterItem;
import com.autonavi.gbl.map.model.SelectPoiInfo;
import com.autonavi.gbl.map.model.SetOpenlayerParam;
import com.autonavi.gbl.map.observer.impl.ISelectPoiObserverImpl;
import java.util.ArrayList;
@IntfAuto(target = OperatorBusiness.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class OperatorBusinessImpl {
    private static BindTable BIND_TABLE = new BindTable(OperatorBusinessImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void addCustomStyleNative(long j, OperatorBusinessImpl operatorBusinessImpl, ArrayList<CustomStyleParam> arrayList, boolean z);

    private static native void addLabels3rdNative(long j, OperatorBusinessImpl operatorBusinessImpl, ArrayList<Label3rd> arrayList, boolean z);

    private static native void addPoiFilterNative(long j, OperatorBusinessImpl operatorBusinessImpl, long j2, PoiFilter poiFilter);

    private static native int appendOpenLayerNative(long j, OperatorBusinessImpl operatorBusinessImpl, byte[] bArr);

    private static native void clearCustomStyleNative(long j, OperatorBusinessImpl operatorBusinessImpl);

    private static native void clearHighlightSubwaysNative(long j, OperatorBusinessImpl operatorBusinessImpl);

    private static native void clearLabels3rdNative(long j, OperatorBusinessImpl operatorBusinessImpl, int i, boolean z);

    private static native void clearPoiFilterNative(long j, OperatorBusinessImpl operatorBusinessImpl);

    private static native void clearScenicSelectNative(long j, OperatorBusinessImpl operatorBusinessImpl);

    private static native int deleteOpenLayerNative(long j, OperatorBusinessImpl operatorBusinessImpl, int i);

    private static native void destroyNativeObj(long j);

    private static native void getGuideRoadNameBoardParamNative(long j, OperatorBusinessImpl operatorBusinessImpl, long j2, GuideRoadNameBoardParam guideRoadNameBoardParam);

    private static native void getMapBusinessDataParaNative(long j, OperatorBusinessImpl operatorBusinessImpl, int i, long j2, MapParameter mapParameter);

    private static native void getMapViewStateNative(long j, OperatorBusinessImpl operatorBusinessImpl, int i, boolean[] zArr);

    private static native int getOpenLayerParamNative(long j, OperatorBusinessImpl operatorBusinessImpl, int i, long j2, GetOpenlayerParam getOpenlayerParam);

    private static native boolean getRestoredMapModeStateNative(long j, OperatorBusinessImpl operatorBusinessImpl, long j2, MapStyleParam mapStyleParam);

    private static native int insertOpenLayerNative(long j, OperatorBusinessImpl operatorBusinessImpl, byte[] bArr, long j2);

    private static native void removePoiFilterNative(long j, OperatorBusinessImpl operatorBusinessImpl, long j2, MsgDataRemovePoiFilter msgDataRemovePoiFilter);

    private static native boolean selectPoiNative(long j, OperatorBusinessImpl operatorBusinessImpl, long j2, SelectPoiInfo selectPoiInfo, boolean z, long j3, ISelectPoiObserverImpl iSelectPoiObserverImpl);

    private static native void setBuildingAnimateAlphaNative(long j, OperatorBusinessImpl operatorBusinessImpl, boolean z, boolean z2, int i);

    private static native void setCustomLabelTypeVisableNative(long j, OperatorBusinessImpl operatorBusinessImpl, ArrayList<Integer> arrayList, int i);

    private static native boolean setDynamicSkyBoxNative(long j, OperatorBusinessImpl operatorBusinessImpl, long j2, MsgDataDynamicSky msgDataDynamicSky);

    private static native void setEnterFBOTickCountNative(long j, OperatorBusinessImpl operatorBusinessImpl, int i);

    private static native void setFBOEnableNative(long j, OperatorBusinessImpl operatorBusinessImpl, boolean z);

    private static native void setGuideRoadNameBoardParamNative(long j, OperatorBusinessImpl operatorBusinessImpl, long j2, GuideRoadNameBoardParam guideRoadNameBoardParam);

    private static native void setHightlightBuildingNative(long j, OperatorBusinessImpl operatorBusinessImpl, long j2, MsgDataBuildingFocus msgDataBuildingFocus);

    private static native void setIndoorBuildingShowNative(long j, OperatorBusinessImpl operatorBusinessImpl, boolean z);

    private static native void setIndoorBuildingToBeActiveNative(long j, OperatorBusinessImpl operatorBusinessImpl, long j2, MsgDataActiveIndoorBuilding msgDataActiveIndoorBuilding);

    private static native void setInternalTextureNative(long j, OperatorBusinessImpl operatorBusinessImpl, long j2, MsgDataInternalTexture msgDataInternalTexture);

    private static native void setLabelVisableNative(long j, OperatorBusinessImpl operatorBusinessImpl, boolean z);

    private static native void setLightPointNative(long j, OperatorBusinessImpl operatorBusinessImpl, long j2, MsgDataSetPointLight msgDataSetPointLight);

    private static native void setMapBusinessDataParaNative(long j, OperatorBusinessImpl operatorBusinessImpl, int i, long j2, MapParameter mapParameter);

    private static native void setMapHeatONNative(long j, OperatorBusinessImpl operatorBusinessImpl, boolean z);

    private static native void setMapHeatPOIIDNative(long j, OperatorBusinessImpl operatorBusinessImpl, byte[] bArr);

    private static native boolean setMapSkyboxParamNative(long j, OperatorBusinessImpl operatorBusinessImpl, long j2, MapSkyboxParam mapSkyboxParam);

    private static native void setMapTextScaleNative(long j, OperatorBusinessImpl operatorBusinessImpl, float f);

    private static native void setMapViewStateNative(long j, OperatorBusinessImpl operatorBusinessImpl, int i, boolean z);

    private static native void setMapZoomScaleAdaptiveNative(long j, OperatorBusinessImpl operatorBusinessImpl, int i, int i2, float f);

    private static native void setMapZoomScaleNative(long j, OperatorBusinessImpl operatorBusinessImpl, float f, float f2);

    private static native boolean setNakeEye3DNative(long j, OperatorBusinessImpl operatorBusinessImpl, long j2, NakeEyeMapViewParam nakeEyeMapViewParam);

    private static native int setOpenLayerParamNative(long j, OperatorBusinessImpl operatorBusinessImpl, long j2, SetOpenlayerParam setOpenlayerParam);

    private static native boolean setPoiLinearGradientNative(long j, OperatorBusinessImpl operatorBusinessImpl, long j2, PoiLinearGradientParam poiLinearGradientParam);

    private static native void setRealCityAnimationEnableNative(long j, OperatorBusinessImpl operatorBusinessImpl, boolean z);

    private static native void setRealCityEnableNative(long j, OperatorBusinessImpl operatorBusinessImpl, boolean z);

    private static native boolean setRestoredMapModeStateNative(long j, OperatorBusinessImpl operatorBusinessImpl, long j2, MapStyleParam mapStyleParam);

    private static native void setScenicFilterNative(long j, OperatorBusinessImpl operatorBusinessImpl, long j2, ScenicFilterItem scenicFilterItem);

    private static native boolean setShowBuildingCollisionNative(long j, OperatorBusinessImpl operatorBusinessImpl, boolean z);

    private static native void showBuilding3DNative(long j, OperatorBusinessImpl operatorBusinessImpl, boolean z);

    private static native void showBuildingNormalNative(long j, OperatorBusinessImpl operatorBusinessImpl, boolean z);

    private static native void showBuildingTextureNative(long j, OperatorBusinessImpl operatorBusinessImpl, boolean z);

    private static native void showMapRoadNative(long j, OperatorBusinessImpl operatorBusinessImpl, boolean z);

    private static native boolean showOpenLayer1Native(long j, OperatorBusinessImpl operatorBusinessImpl, int i, boolean z, long j2, SetOpenlayerParam setOpenlayerParam);

    private static native int showOpenLayerNative(long j, OperatorBusinessImpl operatorBusinessImpl, int i, boolean z);

    public OperatorBusinessImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof OperatorBusinessImpl) && getUID(this) == getUID((OperatorBusinessImpl) obj);
    }

    private static long getUID(OperatorBusinessImpl operatorBusinessImpl) {
        long cPtr = getCPtr(operatorBusinessImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(OperatorBusinessImpl operatorBusinessImpl) {
        if (operatorBusinessImpl == null) {
            return 0L;
        }
        return operatorBusinessImpl.swigCPtr;
    }

    public boolean isRecycled() {
        return this.swigCPtr == 0;
    }

    protected synchronized void delete() {
        LogUtils.d(String.format("swigCPtr=%%s, swigCMemOwn=%%s", String.valueOf(this.swigCPtr), String.valueOf(this.swigCMemOwn)));
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                destroyNativeObj(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
    }

    public int showOpenLayer(@OpenLayerID.OpenLayerID1 int i, boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return showOpenLayerNative(j, this, i, z);
    }

    public boolean showOpenLayer(@OpenLayerID.OpenLayerID1 int i, boolean z, SetOpenlayerParam setOpenlayerParam) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return showOpenLayer1Native(j, this, i, z, 0L, setOpenlayerParam);
    }

    public int deleteOpenLayer(@OpenLayerID.OpenLayerID1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return deleteOpenLayerNative(j, this, i);
    }

    public int appendOpenLayer(byte[] bArr) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return appendOpenLayerNative(j, this, bArr);
    }

    public int insertOpenLayer(byte[] bArr, long j) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        return insertOpenLayerNative(j2, this, bArr, j);
    }

    public int setOpenLayerParam(SetOpenlayerParam setOpenlayerParam) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return setOpenLayerParamNative(j, this, 0L, setOpenlayerParam);
    }

    public GetOpenlayerParam getOpenLayerParam(@OpenLayerID.OpenLayerID1 int i) {
        GetOpenlayerParam getOpenlayerParam = new GetOpenlayerParam();
        Integer.valueOf(getOpenLayerParam(i, getOpenlayerParam));
        return getOpenlayerParam;
    }

    private int getOpenLayerParam(@OpenLayerID.OpenLayerID1 int i, GetOpenlayerParam getOpenlayerParam) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getOpenLayerParamNative(j, this, i, 0L, getOpenlayerParam);
    }

    public void clearScenicSelect() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        clearScenicSelectNative(j, this);
    }

    public boolean selectPoi(SelectPoiInfo selectPoiInfo, boolean z, ISelectPoiObserverImpl iSelectPoiObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return selectPoiNative(j, this, 0L, selectPoiInfo, z, ISelectPoiObserverImpl.getCPtr(iSelectPoiObserverImpl), iSelectPoiObserverImpl);
    }

    public void setScenicFilter(ScenicFilterItem scenicFilterItem) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setScenicFilterNative(j, this, 0L, scenicFilterItem);
    }

    public void addPoiFilter(PoiFilter poiFilter) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        addPoiFilterNative(j, this, 0L, poiFilter);
    }

    public void removePoiFilter(MsgDataRemovePoiFilter msgDataRemovePoiFilter) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        removePoiFilterNative(j, this, 0L, msgDataRemovePoiFilter);
    }

    public void clearPoiFilter() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        clearPoiFilterNative(j, this);
    }

    public void clearHighlightSubways() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        clearHighlightSubwaysNative(j, this);
    }

    public void setIndoorBuildingToBeActive(MsgDataActiveIndoorBuilding msgDataActiveIndoorBuilding) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setIndoorBuildingToBeActiveNative(j, this, 0L, msgDataActiveIndoorBuilding);
    }

    public void setLightPoint(MsgDataSetPointLight msgDataSetPointLight) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setLightPointNative(j, this, 0L, msgDataSetPointLight);
    }

    public void setIndoorBuildingShow(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setIndoorBuildingShowNative(j, this, z);
    }

    public void showMapRoad(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        showMapRoadNative(j, this, z);
    }

    public void showBuilding3D(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        showBuilding3DNative(j, this, z);
    }

    public void showBuildingNormal(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        showBuildingNormalNative(j, this, z);
    }

    public void showBuildingTexture(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        showBuildingTextureNative(j, this, z);
    }

    public void setMapHeatON(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setMapHeatONNative(j, this, z);
    }

    public void setMapHeatPOIID(byte[] bArr) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setMapHeatPOIIDNative(j, this, bArr);
    }

    public void addLabels3rd(ArrayList<Label3rd> arrayList, boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        addLabels3rdNative(j, this, arrayList, z);
    }

    public void clearLabels3rd(int i, boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        clearLabels3rdNative(j, this, i, z);
    }

    public void addCustomStyle(ArrayList<CustomStyleParam> arrayList, boolean z) {
        if (arrayList == null) {
            return;
        }
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        addCustomStyleNative(j, this, arrayList, z);
    }

    public void clearCustomStyle() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        clearCustomStyleNative(j, this);
    }

    public void setInternalTexture(MsgDataInternalTexture msgDataInternalTexture) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setInternalTextureNative(j, this, 0L, msgDataInternalTexture);
    }

    public void setHightlightBuilding(MsgDataBuildingFocus msgDataBuildingFocus) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setHightlightBuildingNative(j, this, 0L, msgDataBuildingFocus);
    }

    public void setMapTextScale(float f) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setMapTextScaleNative(j, this, f);
    }

    public void setMapZoomScale(float f, float f2) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setMapZoomScaleNative(j, this, f, f2);
    }

    public void setMapZoomScaleAdaptive(int i, int i2, float f) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setMapZoomScaleAdaptiveNative(j, this, i, i2, f);
    }

    public void setRealCityEnable(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setRealCityEnableNative(j, this, z);
    }

    public void setRealCityAnimationEnable(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setRealCityAnimationEnableNative(j, this, z);
    }

    public void setLabelVisable(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setLabelVisableNative(j, this, z);
    }

    public void setCustomLabelTypeVisable(ArrayList<Integer> arrayList, @MapPoiCustomOperateType.MapPoiCustomOperateType1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setCustomLabelTypeVisableNative(j, this, arrayList, i);
    }

    public void setFBOEnable(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setFBOEnableNative(j, this, z);
    }

    public void setMapBusinessDataPara(@MapBusinessDataType.MapBusinessDataType1 int i, MapParameter mapParameter) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setMapBusinessDataParaNative(j, this, i, 0L, mapParameter);
    }

    public MapParameter getMapBusinessDataPara(@MapBusinessDataType.MapBusinessDataType1 int i) {
        MapParameter mapParameter = new MapParameter();
        getMapBusinessDataPara(i, mapParameter);
        return mapParameter;
    }

    private void getMapBusinessDataPara(@MapBusinessDataType.MapBusinessDataType1 int i, MapParameter mapParameter) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        getMapBusinessDataParaNative(j, this, i, 0L, mapParameter);
    }

    public void setGuideRoadNameBoardParam(GuideRoadNameBoardParam guideRoadNameBoardParam) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setGuideRoadNameBoardParamNative(j, this, 0L, guideRoadNameBoardParam);
    }

    public GuideRoadNameBoardParam getGuideRoadNameBoardParam() {
        GuideRoadNameBoardParam guideRoadNameBoardParam = new GuideRoadNameBoardParam();
        getGuideRoadNameBoardParam(guideRoadNameBoardParam);
        return guideRoadNameBoardParam;
    }

    private void getGuideRoadNameBoardParam(GuideRoadNameBoardParam guideRoadNameBoardParam) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        getGuideRoadNameBoardParamNative(j, this, 0L, guideRoadNameBoardParam);
    }

    public void setMapViewState(@MapViewStateType.MapViewStateType1 int i, boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setMapViewStateNative(j, this, i, z);
    }

    public boolean getMapViewState(@MapViewStateType.MapViewStateType1 int i) {
        boolean[] zArr = new boolean[1];
        getMapViewState(i, zArr);
        return zArr[0];
    }

    private void getMapViewState(@MapViewStateType.MapViewStateType1 int i, boolean[] zArr) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        getMapViewStateNative(j, this, i, zArr);
    }

    public boolean setMapSkyboxParam(MapSkyboxParam mapSkyboxParam) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return setMapSkyboxParamNative(j, this, 0L, mapSkyboxParam);
    }

    public void setEnterFBOTickCount(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setEnterFBOTickCountNative(j, this, i);
    }

    public boolean setShowBuildingCollision(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return setShowBuildingCollisionNative(j, this, z);
    }

    public boolean setRestoredMapModeState(MapStyleParam mapStyleParam) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return setRestoredMapModeStateNative(j, this, 0L, mapStyleParam);
    }

    public MapStyleParam getRestoredMapModeState() {
        MapStyleParam mapStyleParam = new MapStyleParam();
        if (Boolean.valueOf(getRestoredMapModeState(mapStyleParam)).booleanValue()) {
            return mapStyleParam;
        }
        return null;
    }

    private boolean getRestoredMapModeState(MapStyleParam mapStyleParam) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getRestoredMapModeStateNative(j, this, 0L, mapStyleParam);
    }

    public void setBuildingAnimateAlpha(boolean z, boolean z2, int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setBuildingAnimateAlphaNative(j, this, z, z2, i);
    }

    public boolean setPoiLinearGradient(PoiLinearGradientParam poiLinearGradientParam) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return setPoiLinearGradientNative(j, this, 0L, poiLinearGradientParam);
    }

    public boolean setDynamicSkyBox(MsgDataDynamicSky msgDataDynamicSky) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return setDynamicSkyBoxNative(j, this, 0L, msgDataDynamicSky);
    }

    public boolean setNakeEye3D(NakeEyeMapViewParam nakeEyeMapViewParam) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return setNakeEye3DNative(j, this, 0L, nakeEyeMapViewParam);
    }
}
