package com.autonavi.gbl.map;

import android.util.Log;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.map.impl.OperatorBusinessImpl;
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
import com.autonavi.gbl.map.observer.ISelectPoiObserver;
import com.autonavi.gbl.map.observer.impl.ISelectPoiObserverImpl;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
@IntfAuto(target = OperatorBusinessImpl.class, type = BuildType.JCTRL)
/* loaded from: classes2.dex */
public class OperatorBusiness {
    private static String PACKAGE = ReflexTool.PN(OperatorBusiness.class);
    private OperatorBusinessImpl mControl;
    private boolean mHasDestroy;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected OperatorBusiness(long j, boolean z) {
        this(new OperatorBusinessImpl(j, z));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(OperatorBusiness.class, this, this.mControl);
        }
    }

    public OperatorBusiness(OperatorBusinessImpl operatorBusinessImpl) {
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mHasDestroy = false;
        this.mControl = null;
        $constructor(operatorBusinessImpl);
    }

    private void $constructor(OperatorBusinessImpl operatorBusinessImpl) {
        if (operatorBusinessImpl != null) {
            this.mControl = operatorBusinessImpl;
            this.mTargetId = String.format("OperatorBusiness_%s_%d", String.valueOf(OperatorBusinessImpl.getCPtr(this.mControl)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    protected OperatorBusinessImpl getControl() {
        return this.mControl;
    }

    public int showOpenLayer(@OpenLayerID.OpenLayerID1 int i, boolean z) {
        OperatorBusinessImpl operatorBusinessImpl = this.mControl;
        if (operatorBusinessImpl != null) {
            return operatorBusinessImpl.showOpenLayer(i, z);
        }
        return 0;
    }

    public boolean showOpenLayer(@OpenLayerID.OpenLayerID1 int i, boolean z, SetOpenlayerParam setOpenlayerParam) {
        OperatorBusinessImpl operatorBusinessImpl = this.mControl;
        if (operatorBusinessImpl != null) {
            return operatorBusinessImpl.showOpenLayer(i, z, setOpenlayerParam);
        }
        return false;
    }

    public int deleteOpenLayer(@OpenLayerID.OpenLayerID1 int i) {
        OperatorBusinessImpl operatorBusinessImpl = this.mControl;
        if (operatorBusinessImpl != null) {
            return operatorBusinessImpl.deleteOpenLayer(i);
        }
        return 0;
    }

    public int appendOpenLayer(byte[] bArr) {
        if (bArr != null && bArr.length == 0) {
            bArr = null;
        }
        OperatorBusinessImpl operatorBusinessImpl = this.mControl;
        if (operatorBusinessImpl != null) {
            return operatorBusinessImpl.appendOpenLayer(bArr);
        }
        return 0;
    }

    public int insertOpenLayer(byte[] bArr, long j) {
        if (bArr != null && bArr.length == 0) {
            bArr = null;
        }
        OperatorBusinessImpl operatorBusinessImpl = this.mControl;
        if (operatorBusinessImpl != null) {
            return operatorBusinessImpl.insertOpenLayer(bArr, j);
        }
        return 0;
    }

    public int setOpenLayerParam(SetOpenlayerParam setOpenlayerParam) {
        OperatorBusinessImpl operatorBusinessImpl = this.mControl;
        if (operatorBusinessImpl != null) {
            return operatorBusinessImpl.setOpenLayerParam(setOpenlayerParam);
        }
        return 0;
    }

    public GetOpenlayerParam getOpenLayerParam(@OpenLayerID.OpenLayerID1 int i) {
        OperatorBusinessImpl operatorBusinessImpl = this.mControl;
        if (operatorBusinessImpl != null) {
            return operatorBusinessImpl.getOpenLayerParam(i);
        }
        return null;
    }

    public void clearScenicSelect() {
        OperatorBusinessImpl operatorBusinessImpl = this.mControl;
        if (operatorBusinessImpl != null) {
            operatorBusinessImpl.clearScenicSelect();
        }
    }

    public boolean selectPoi(SelectPoiInfo selectPoiInfo, boolean z, ISelectPoiObserver iSelectPoiObserver) {
        HashSet hashSet;
        try {
            Method method = OperatorBusiness.class.getMethod("selectPoi", SelectPoiInfo.class, Boolean.TYPE, ISelectPoiObserver.class);
            TypeHelper typeHelper = this.mTypeHelper;
            if (typeHelper != null) {
                hashSet = (HashSet) typeHelper.getBindSet(method, 2);
            } else {
                hashSet = new HashSet();
            }
            hashSet.remove(iSelectPoiObserver);
            if (iSelectPoiObserver != null) {
                TypeHelper typeHelper2 = this.mTypeHelper;
                r3 = typeHelper2 != null ? (ISelectPoiObserverImpl) typeHelper2.transfer(method, 2, iSelectPoiObserver) : null;
                if (r3 == null) {
                    DebugTool.e("%s: $pObserver == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.OperatorBusiness.1
                    }));
                    return false;
                }
            }
            OperatorBusinessImpl operatorBusinessImpl = this.mControl;
            if (operatorBusinessImpl != null) {
                boolean selectPoi = operatorBusinessImpl.selectPoi(selectPoiInfo, z, r3);
                TypeHelper typeHelper3 = this.mTypeHelper;
                if (typeHelper3 != null) {
                    typeHelper3.unbindSet(method, 2, hashSet);
                }
                return selectPoi;
            }
            return false;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return false;
        }
    }

    public void setScenicFilter(ScenicFilterItem scenicFilterItem) {
        OperatorBusinessImpl operatorBusinessImpl = this.mControl;
        if (operatorBusinessImpl != null) {
            operatorBusinessImpl.setScenicFilter(scenicFilterItem);
        }
    }

    public void addPoiFilter(PoiFilter poiFilter) {
        OperatorBusinessImpl operatorBusinessImpl = this.mControl;
        if (operatorBusinessImpl != null) {
            operatorBusinessImpl.addPoiFilter(poiFilter);
        }
    }

    public void removePoiFilter(MsgDataRemovePoiFilter msgDataRemovePoiFilter) {
        OperatorBusinessImpl operatorBusinessImpl = this.mControl;
        if (operatorBusinessImpl != null) {
            operatorBusinessImpl.removePoiFilter(msgDataRemovePoiFilter);
        }
    }

    public void clearPoiFilter() {
        OperatorBusinessImpl operatorBusinessImpl = this.mControl;
        if (operatorBusinessImpl != null) {
            operatorBusinessImpl.clearPoiFilter();
        }
    }

    public void clearHighlightSubways() {
        OperatorBusinessImpl operatorBusinessImpl = this.mControl;
        if (operatorBusinessImpl != null) {
            operatorBusinessImpl.clearHighlightSubways();
        }
    }

    public void setIndoorBuildingToBeActive(MsgDataActiveIndoorBuilding msgDataActiveIndoorBuilding) {
        OperatorBusinessImpl operatorBusinessImpl = this.mControl;
        if (operatorBusinessImpl != null) {
            operatorBusinessImpl.setIndoorBuildingToBeActive(msgDataActiveIndoorBuilding);
        }
    }

    public void setLightPoint(MsgDataSetPointLight msgDataSetPointLight) {
        OperatorBusinessImpl operatorBusinessImpl = this.mControl;
        if (operatorBusinessImpl != null) {
            operatorBusinessImpl.setLightPoint(msgDataSetPointLight);
        }
    }

    public void setIndoorBuildingShow(boolean z) {
        OperatorBusinessImpl operatorBusinessImpl = this.mControl;
        if (operatorBusinessImpl != null) {
            operatorBusinessImpl.setIndoorBuildingShow(z);
        }
    }

    public void showMapRoad(boolean z) {
        OperatorBusinessImpl operatorBusinessImpl = this.mControl;
        if (operatorBusinessImpl != null) {
            operatorBusinessImpl.showMapRoad(z);
        }
    }

    public void showBuilding3D(boolean z) {
        OperatorBusinessImpl operatorBusinessImpl = this.mControl;
        if (operatorBusinessImpl != null) {
            operatorBusinessImpl.showBuilding3D(z);
        }
    }

    public void showBuildingNormal(boolean z) {
        OperatorBusinessImpl operatorBusinessImpl = this.mControl;
        if (operatorBusinessImpl != null) {
            operatorBusinessImpl.showBuildingNormal(z);
        }
    }

    public void showBuildingTexture(boolean z) {
        OperatorBusinessImpl operatorBusinessImpl = this.mControl;
        if (operatorBusinessImpl != null) {
            operatorBusinessImpl.showBuildingTexture(z);
        }
    }

    public void setMapHeatON(boolean z) {
        OperatorBusinessImpl operatorBusinessImpl = this.mControl;
        if (operatorBusinessImpl != null) {
            operatorBusinessImpl.setMapHeatON(z);
        }
    }

    public void setMapHeatPOIID(byte[] bArr) {
        if (bArr != null && bArr.length == 0) {
            bArr = null;
        }
        OperatorBusinessImpl operatorBusinessImpl = this.mControl;
        if (operatorBusinessImpl != null) {
            operatorBusinessImpl.setMapHeatPOIID(bArr);
        }
    }

    public void addLabels3rd(ArrayList<Label3rd> arrayList, boolean z) {
        OperatorBusinessImpl operatorBusinessImpl = this.mControl;
        if (operatorBusinessImpl != null) {
            operatorBusinessImpl.addLabels3rd(arrayList, z);
        }
    }

    public void clearLabels3rd(int i, boolean z) {
        OperatorBusinessImpl operatorBusinessImpl = this.mControl;
        if (operatorBusinessImpl != null) {
            operatorBusinessImpl.clearLabels3rd(i, z);
        }
    }

    public void addCustomStyle(ArrayList<CustomStyleParam> arrayList, boolean z) {
        OperatorBusinessImpl operatorBusinessImpl = this.mControl;
        if (operatorBusinessImpl != null) {
            operatorBusinessImpl.addCustomStyle(arrayList, z);
        }
    }

    public void clearCustomStyle() {
        OperatorBusinessImpl operatorBusinessImpl = this.mControl;
        if (operatorBusinessImpl != null) {
            operatorBusinessImpl.clearCustomStyle();
        }
    }

    public void setInternalTexture(MsgDataInternalTexture msgDataInternalTexture) {
        OperatorBusinessImpl operatorBusinessImpl = this.mControl;
        if (operatorBusinessImpl != null) {
            operatorBusinessImpl.setInternalTexture(msgDataInternalTexture);
        }
    }

    public void setHightlightBuilding(MsgDataBuildingFocus msgDataBuildingFocus) {
        OperatorBusinessImpl operatorBusinessImpl = this.mControl;
        if (operatorBusinessImpl != null) {
            operatorBusinessImpl.setHightlightBuilding(msgDataBuildingFocus);
        }
    }

    public void setMapTextScale(float f) {
        OperatorBusinessImpl operatorBusinessImpl = this.mControl;
        if (operatorBusinessImpl != null) {
            operatorBusinessImpl.setMapTextScale(f);
        }
    }

    public void setMapZoomScale(float f, float f2) {
        OperatorBusinessImpl operatorBusinessImpl = this.mControl;
        if (operatorBusinessImpl != null) {
            operatorBusinessImpl.setMapZoomScale(f, f2);
        }
    }

    public void setMapZoomScaleAdaptive(int i, int i2, float f) {
        OperatorBusinessImpl operatorBusinessImpl = this.mControl;
        if (operatorBusinessImpl != null) {
            operatorBusinessImpl.setMapZoomScaleAdaptive(i, i2, f);
        }
    }

    public void setRealCityEnable(boolean z) {
        OperatorBusinessImpl operatorBusinessImpl = this.mControl;
        if (operatorBusinessImpl != null) {
            operatorBusinessImpl.setRealCityEnable(z);
        }
    }

    public void setRealCityAnimationEnable(boolean z) {
        OperatorBusinessImpl operatorBusinessImpl = this.mControl;
        if (operatorBusinessImpl != null) {
            operatorBusinessImpl.setRealCityAnimationEnable(z);
        }
    }

    public void setLabelVisable(boolean z) {
        OperatorBusinessImpl operatorBusinessImpl = this.mControl;
        if (operatorBusinessImpl != null) {
            operatorBusinessImpl.setLabelVisable(z);
        }
    }

    public void setCustomLabelTypeVisable(ArrayList<Integer> arrayList, @MapPoiCustomOperateType.MapPoiCustomOperateType1 int i) {
        OperatorBusinessImpl operatorBusinessImpl = this.mControl;
        if (operatorBusinessImpl != null) {
            operatorBusinessImpl.setCustomLabelTypeVisable(arrayList, i);
        }
    }

    public void setFBOEnable(boolean z) {
        OperatorBusinessImpl operatorBusinessImpl = this.mControl;
        if (operatorBusinessImpl != null) {
            operatorBusinessImpl.setFBOEnable(z);
        }
    }

    public void setMapBusinessDataPara(@MapBusinessDataType.MapBusinessDataType1 int i, MapParameter mapParameter) {
        OperatorBusinessImpl operatorBusinessImpl = this.mControl;
        if (operatorBusinessImpl != null) {
            operatorBusinessImpl.setMapBusinessDataPara(i, mapParameter);
        }
    }

    public MapParameter getMapBusinessDataPara(@MapBusinessDataType.MapBusinessDataType1 int i) {
        OperatorBusinessImpl operatorBusinessImpl = this.mControl;
        if (operatorBusinessImpl != null) {
            return operatorBusinessImpl.getMapBusinessDataPara(i);
        }
        return null;
    }

    public void setGuideRoadNameBoardParam(GuideRoadNameBoardParam guideRoadNameBoardParam) {
        OperatorBusinessImpl operatorBusinessImpl = this.mControl;
        if (operatorBusinessImpl != null) {
            operatorBusinessImpl.setGuideRoadNameBoardParam(guideRoadNameBoardParam);
        }
    }

    public GuideRoadNameBoardParam getGuideRoadNameBoardParam() {
        OperatorBusinessImpl operatorBusinessImpl = this.mControl;
        if (operatorBusinessImpl != null) {
            return operatorBusinessImpl.getGuideRoadNameBoardParam();
        }
        return null;
    }

    public void setMapViewState(@MapViewStateType.MapViewStateType1 int i, boolean z) {
        OperatorBusinessImpl operatorBusinessImpl = this.mControl;
        if (operatorBusinessImpl != null) {
            operatorBusinessImpl.setMapViewState(i, z);
        }
    }

    public boolean getMapViewState(@MapViewStateType.MapViewStateType1 int i) {
        OperatorBusinessImpl operatorBusinessImpl = this.mControl;
        if (operatorBusinessImpl != null) {
            return operatorBusinessImpl.getMapViewState(i);
        }
        return false;
    }

    public boolean setMapSkyboxParam(MapSkyboxParam mapSkyboxParam) {
        OperatorBusinessImpl operatorBusinessImpl = this.mControl;
        if (operatorBusinessImpl != null) {
            return operatorBusinessImpl.setMapSkyboxParam(mapSkyboxParam);
        }
        return false;
    }

    public void setEnterFBOTickCount(int i) {
        OperatorBusinessImpl operatorBusinessImpl = this.mControl;
        if (operatorBusinessImpl != null) {
            operatorBusinessImpl.setEnterFBOTickCount(i);
        }
    }

    public boolean setShowBuildingCollision(boolean z) {
        OperatorBusinessImpl operatorBusinessImpl = this.mControl;
        if (operatorBusinessImpl != null) {
            return operatorBusinessImpl.setShowBuildingCollision(z);
        }
        return false;
    }

    public boolean setRestoredMapModeState(MapStyleParam mapStyleParam) {
        OperatorBusinessImpl operatorBusinessImpl = this.mControl;
        if (operatorBusinessImpl != null) {
            return operatorBusinessImpl.setRestoredMapModeState(mapStyleParam);
        }
        return false;
    }

    public MapStyleParam getRestoredMapModeState() {
        OperatorBusinessImpl operatorBusinessImpl = this.mControl;
        if (operatorBusinessImpl != null) {
            return operatorBusinessImpl.getRestoredMapModeState();
        }
        return null;
    }

    public void setBuildingAnimateAlpha(boolean z, boolean z2, int i) {
        OperatorBusinessImpl operatorBusinessImpl = this.mControl;
        if (operatorBusinessImpl != null) {
            operatorBusinessImpl.setBuildingAnimateAlpha(z, z2, i);
        }
    }

    public boolean setPoiLinearGradient(PoiLinearGradientParam poiLinearGradientParam) {
        OperatorBusinessImpl operatorBusinessImpl = this.mControl;
        if (operatorBusinessImpl != null) {
            return operatorBusinessImpl.setPoiLinearGradient(poiLinearGradientParam);
        }
        return false;
    }

    public boolean setDynamicSkyBox(MsgDataDynamicSky msgDataDynamicSky) {
        OperatorBusinessImpl operatorBusinessImpl = this.mControl;
        if (operatorBusinessImpl != null) {
            return operatorBusinessImpl.setDynamicSkyBox(msgDataDynamicSky);
        }
        return false;
    }

    public boolean setNakeEye3D(NakeEyeMapViewParam nakeEyeMapViewParam) {
        OperatorBusinessImpl operatorBusinessImpl = this.mControl;
        if (operatorBusinessImpl != null) {
            return operatorBusinessImpl.setNakeEye3D(nakeEyeMapViewParam);
        }
        return false;
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.OperatorBusiness.2
        });
        objArr[1] = String.valueOf(this.mTypeHelper != null);
        DebugTool.d("%s: mTypeHelper=%s", objArr);
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mTypeHelper = null;
        }
    }

    public void onDestroy() {
        this.mHasDestroy = true;
        clean();
    }

    protected void clean() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.OperatorBusiness.3
        }));
    }

    protected synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.OperatorBusiness.4
        }));
        if (!this.mHasDestroy) {
            onDestroy();
        }
        if (this.mTypeHelper != null) {
            TypeHelper typeHelper = this.mTypeHelper;
            TypeHelper.unbindAllTarget(PACKAGE, this);
        }
        if (this.mControl != null) {
            this.mControl = null;
        }
        unbind();
    }
}
