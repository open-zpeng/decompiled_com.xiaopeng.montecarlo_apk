package com.autonavi.gbl.map;

import android.util.Log;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.map.impl.IOperatorBusinessImpl;
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
import com.autonavi.gbl.map.model.MsgIndoorParkBuildingShowLevel;
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
@IntfAuto(target = IOperatorBusinessImpl.class, type = BuildType.JCTRL)
/* loaded from: classes2.dex */
public class OperatorBusiness {
    private static String PACKAGE = ReflexTool.PN(OperatorBusiness.class);
    private IOperatorBusinessImpl mControl;
    private boolean mHasDestroy;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected void clean() {
    }

    protected OperatorBusiness(long j, boolean z) {
        this(new IOperatorBusinessImpl(j, z));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(OperatorBusiness.class, this, this.mControl);
        }
    }

    public OperatorBusiness(IOperatorBusinessImpl iOperatorBusinessImpl) {
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mHasDestroy = false;
        this.mControl = null;
        $constructor(iOperatorBusinessImpl);
    }

    private void $constructor(IOperatorBusinessImpl iOperatorBusinessImpl) {
        if (iOperatorBusinessImpl != null) {
            this.mControl = iOperatorBusinessImpl;
            this.mTargetId = String.format("OperatorBusiness_%s_%d", String.valueOf(IOperatorBusinessImpl.getCPtr(this.mControl)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    protected IOperatorBusinessImpl getControl() {
        return this.mControl;
    }

    public int showOpenLayer(@OpenLayerID.OpenLayerID1 int i, boolean z) {
        IOperatorBusinessImpl iOperatorBusinessImpl = this.mControl;
        if (iOperatorBusinessImpl != null) {
            return iOperatorBusinessImpl.showOpenLayer(i, z);
        }
        return 0;
    }

    public boolean showOpenLayer(@OpenLayerID.OpenLayerID1 int i, boolean z, SetOpenlayerParam setOpenlayerParam) {
        IOperatorBusinessImpl iOperatorBusinessImpl = this.mControl;
        if (iOperatorBusinessImpl != null) {
            return iOperatorBusinessImpl.showOpenLayer(i, z, setOpenlayerParam);
        }
        return false;
    }

    public int deleteOpenLayer(@OpenLayerID.OpenLayerID1 int i) {
        IOperatorBusinessImpl iOperatorBusinessImpl = this.mControl;
        if (iOperatorBusinessImpl != null) {
            return iOperatorBusinessImpl.deleteOpenLayer(i);
        }
        return 0;
    }

    public int appendOpenLayer(byte[] bArr) {
        if (bArr != null && bArr.length == 0) {
            bArr = null;
        }
        IOperatorBusinessImpl iOperatorBusinessImpl = this.mControl;
        if (iOperatorBusinessImpl != null) {
            return iOperatorBusinessImpl.appendOpenLayer(bArr);
        }
        return 0;
    }

    public int insertOpenLayer(byte[] bArr, long j) {
        if (bArr != null && bArr.length == 0) {
            bArr = null;
        }
        IOperatorBusinessImpl iOperatorBusinessImpl = this.mControl;
        if (iOperatorBusinessImpl != null) {
            return iOperatorBusinessImpl.insertOpenLayer(bArr, j);
        }
        return 0;
    }

    public int setOpenLayerParam(SetOpenlayerParam setOpenlayerParam) {
        IOperatorBusinessImpl iOperatorBusinessImpl = this.mControl;
        if (iOperatorBusinessImpl != null) {
            return iOperatorBusinessImpl.setOpenLayerParam(setOpenlayerParam);
        }
        return 0;
    }

    public GetOpenlayerParam getOpenLayerParam(@OpenLayerID.OpenLayerID1 int i) {
        IOperatorBusinessImpl iOperatorBusinessImpl = this.mControl;
        if (iOperatorBusinessImpl != null) {
            return iOperatorBusinessImpl.getOpenLayerParam(i);
        }
        return null;
    }

    public void clearScenicSelect() {
        IOperatorBusinessImpl iOperatorBusinessImpl = this.mControl;
        if (iOperatorBusinessImpl != null) {
            iOperatorBusinessImpl.clearScenicSelect();
        }
    }

    public boolean selectPoi(SelectPoiInfo selectPoiInfo, boolean z, ISelectPoiObserver iSelectPoiObserver) {
        HashSet hashSet;
        TypeHelper typeHelper;
        try {
            Method method = OperatorBusiness.class.getMethod("selectPoi", SelectPoiInfo.class, Boolean.TYPE, ISelectPoiObserver.class);
            TypeHelper typeHelper2 = this.mTypeHelper;
            if (typeHelper2 != null) {
                hashSet = (HashSet) typeHelper2.getBindSet(method, 2);
            } else {
                hashSet = new HashSet();
            }
            hashSet.remove(iSelectPoiObserver);
            ISelectPoiObserverImpl iSelectPoiObserverImpl = null;
            if (iSelectPoiObserver != null && (typeHelper = this.mTypeHelper) != null) {
                iSelectPoiObserverImpl = (ISelectPoiObserverImpl) typeHelper.transfer(method, 2, iSelectPoiObserver);
            }
            IOperatorBusinessImpl iOperatorBusinessImpl = this.mControl;
            if (iOperatorBusinessImpl != null) {
                boolean selectPoi = iOperatorBusinessImpl.selectPoi(selectPoiInfo, z, iSelectPoiObserverImpl);
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

    @Deprecated
    public void setScenicFilter(ScenicFilterItem scenicFilterItem) {
        IOperatorBusinessImpl iOperatorBusinessImpl = this.mControl;
        if (iOperatorBusinessImpl != null) {
            iOperatorBusinessImpl.setScenicFilter(scenicFilterItem);
        }
    }

    public void addPoiFilter(PoiFilter poiFilter) {
        IOperatorBusinessImpl iOperatorBusinessImpl = this.mControl;
        if (iOperatorBusinessImpl != null) {
            iOperatorBusinessImpl.addPoiFilter(poiFilter);
        }
    }

    public void removePoiFilter(MsgDataRemovePoiFilter msgDataRemovePoiFilter) {
        IOperatorBusinessImpl iOperatorBusinessImpl = this.mControl;
        if (iOperatorBusinessImpl != null) {
            iOperatorBusinessImpl.removePoiFilter(msgDataRemovePoiFilter);
        }
    }

    public void clearPoiFilter() {
        IOperatorBusinessImpl iOperatorBusinessImpl = this.mControl;
        if (iOperatorBusinessImpl != null) {
            iOperatorBusinessImpl.clearPoiFilter();
        }
    }

    public void clearHighlightSubways() {
        IOperatorBusinessImpl iOperatorBusinessImpl = this.mControl;
        if (iOperatorBusinessImpl != null) {
            iOperatorBusinessImpl.clearHighlightSubways();
        }
    }

    public void setIndoorBuildingToBeActive(MsgDataActiveIndoorBuilding msgDataActiveIndoorBuilding) {
        IOperatorBusinessImpl iOperatorBusinessImpl = this.mControl;
        if (iOperatorBusinessImpl != null) {
            iOperatorBusinessImpl.setIndoorBuildingToBeActive(msgDataActiveIndoorBuilding);
        }
    }

    public void setLightPoint(MsgDataSetPointLight msgDataSetPointLight) {
        IOperatorBusinessImpl iOperatorBusinessImpl = this.mControl;
        if (iOperatorBusinessImpl != null) {
            iOperatorBusinessImpl.setLightPoint(msgDataSetPointLight);
        }
    }

    public void setIndoorBuildingShow(boolean z) {
        IOperatorBusinessImpl iOperatorBusinessImpl = this.mControl;
        if (iOperatorBusinessImpl != null) {
            iOperatorBusinessImpl.setIndoorBuildingShow(z);
        }
    }

    public void showMapRoad(boolean z) {
        IOperatorBusinessImpl iOperatorBusinessImpl = this.mControl;
        if (iOperatorBusinessImpl != null) {
            iOperatorBusinessImpl.showMapRoad(z);
        }
    }

    public void showBuilding3D(boolean z) {
        IOperatorBusinessImpl iOperatorBusinessImpl = this.mControl;
        if (iOperatorBusinessImpl != null) {
            iOperatorBusinessImpl.showBuilding3D(z);
        }
    }

    public void showBuildingNormal(boolean z) {
        IOperatorBusinessImpl iOperatorBusinessImpl = this.mControl;
        if (iOperatorBusinessImpl != null) {
            iOperatorBusinessImpl.showBuildingNormal(z);
        }
    }

    public void showBuildingTexture(boolean z) {
        IOperatorBusinessImpl iOperatorBusinessImpl = this.mControl;
        if (iOperatorBusinessImpl != null) {
            iOperatorBusinessImpl.showBuildingTexture(z);
        }
    }

    @Deprecated
    public void setMapHeatON(boolean z) {
        IOperatorBusinessImpl iOperatorBusinessImpl = this.mControl;
        if (iOperatorBusinessImpl != null) {
            iOperatorBusinessImpl.setMapHeatON(z);
        }
    }

    @Deprecated
    public void setMapHeatPOIID(byte[] bArr) {
        if (bArr != null && bArr.length == 0) {
            bArr = null;
        }
        IOperatorBusinessImpl iOperatorBusinessImpl = this.mControl;
        if (iOperatorBusinessImpl != null) {
            iOperatorBusinessImpl.setMapHeatPOIID(bArr);
        }
    }

    public void addLabels3rd(ArrayList<Label3rd> arrayList, boolean z) {
        IOperatorBusinessImpl iOperatorBusinessImpl = this.mControl;
        if (iOperatorBusinessImpl != null) {
            iOperatorBusinessImpl.addLabels3rd(arrayList, z);
        }
    }

    public void clearLabels3rd(int i, boolean z) {
        IOperatorBusinessImpl iOperatorBusinessImpl = this.mControl;
        if (iOperatorBusinessImpl != null) {
            iOperatorBusinessImpl.clearLabels3rd(i, z);
        }
    }

    public void addCustomStyle(ArrayList<CustomStyleParam> arrayList, boolean z) {
        IOperatorBusinessImpl iOperatorBusinessImpl = this.mControl;
        if (iOperatorBusinessImpl != null) {
            iOperatorBusinessImpl.addCustomStyle(arrayList, z);
        }
    }

    public void clearCustomStyle() {
        IOperatorBusinessImpl iOperatorBusinessImpl = this.mControl;
        if (iOperatorBusinessImpl != null) {
            iOperatorBusinessImpl.clearCustomStyle();
        }
    }

    public void setInternalTexture(MsgDataInternalTexture msgDataInternalTexture) {
        IOperatorBusinessImpl iOperatorBusinessImpl = this.mControl;
        if (iOperatorBusinessImpl != null) {
            iOperatorBusinessImpl.setInternalTexture(msgDataInternalTexture);
        }
    }

    public void setHightlightBuilding(MsgDataBuildingFocus msgDataBuildingFocus) {
        IOperatorBusinessImpl iOperatorBusinessImpl = this.mControl;
        if (iOperatorBusinessImpl != null) {
            iOperatorBusinessImpl.setHightlightBuilding(msgDataBuildingFocus);
        }
    }

    public void setMapTextScale(float f) {
        IOperatorBusinessImpl iOperatorBusinessImpl = this.mControl;
        if (iOperatorBusinessImpl != null) {
            iOperatorBusinessImpl.setMapTextScale(f);
        }
    }

    public void setMapZoomScale(float f, float f2) {
        IOperatorBusinessImpl iOperatorBusinessImpl = this.mControl;
        if (iOperatorBusinessImpl != null) {
            iOperatorBusinessImpl.setMapZoomScale(f, f2);
        }
    }

    public void setMapZoomScaleAdaptive(int i, int i2, float f) {
        IOperatorBusinessImpl iOperatorBusinessImpl = this.mControl;
        if (iOperatorBusinessImpl != null) {
            iOperatorBusinessImpl.setMapZoomScaleAdaptive(i, i2, f);
        }
    }

    public void setRealCityEnable(boolean z) {
        IOperatorBusinessImpl iOperatorBusinessImpl = this.mControl;
        if (iOperatorBusinessImpl != null) {
            iOperatorBusinessImpl.setRealCityEnable(z);
        }
    }

    public void setRealCityAnimationEnable(boolean z) {
        IOperatorBusinessImpl iOperatorBusinessImpl = this.mControl;
        if (iOperatorBusinessImpl != null) {
            iOperatorBusinessImpl.setRealCityAnimationEnable(z);
        }
    }

    public void setLabelVisable(boolean z) {
        IOperatorBusinessImpl iOperatorBusinessImpl = this.mControl;
        if (iOperatorBusinessImpl != null) {
            iOperatorBusinessImpl.setLabelVisable(z);
        }
    }

    public void setCustomLabelTypeVisable(ArrayList<Integer> arrayList, @MapPoiCustomOperateType.MapPoiCustomOperateType1 int i) {
        IOperatorBusinessImpl iOperatorBusinessImpl = this.mControl;
        if (iOperatorBusinessImpl != null) {
            iOperatorBusinessImpl.setCustomLabelTypeVisable(arrayList, i);
        }
    }

    public void setFBOEnable(boolean z) {
        IOperatorBusinessImpl iOperatorBusinessImpl = this.mControl;
        if (iOperatorBusinessImpl != null) {
            iOperatorBusinessImpl.setFBOEnable(z);
        }
    }

    public void setMapBusinessDataPara(@MapBusinessDataType.MapBusinessDataType1 int i, MapParameter mapParameter) {
        IOperatorBusinessImpl iOperatorBusinessImpl = this.mControl;
        if (iOperatorBusinessImpl != null) {
            iOperatorBusinessImpl.setMapBusinessDataPara(i, mapParameter);
        }
    }

    public MapParameter getMapBusinessDataPara(@MapBusinessDataType.MapBusinessDataType1 int i) {
        IOperatorBusinessImpl iOperatorBusinessImpl = this.mControl;
        if (iOperatorBusinessImpl != null) {
            return iOperatorBusinessImpl.getMapBusinessDataPara(i);
        }
        return null;
    }

    public void setGuideRoadNameBoardParam(GuideRoadNameBoardParam guideRoadNameBoardParam) {
        IOperatorBusinessImpl iOperatorBusinessImpl = this.mControl;
        if (iOperatorBusinessImpl != null) {
            iOperatorBusinessImpl.setGuideRoadNameBoardParam(guideRoadNameBoardParam);
        }
    }

    public GuideRoadNameBoardParam getGuideRoadNameBoardParam() {
        IOperatorBusinessImpl iOperatorBusinessImpl = this.mControl;
        if (iOperatorBusinessImpl != null) {
            return iOperatorBusinessImpl.getGuideRoadNameBoardParam();
        }
        return null;
    }

    public void setMapViewState(@MapViewStateType.MapViewStateType1 int i, boolean z) {
        IOperatorBusinessImpl iOperatorBusinessImpl = this.mControl;
        if (iOperatorBusinessImpl != null) {
            iOperatorBusinessImpl.setMapViewState(i, z);
        }
    }

    public boolean getMapViewState(@MapViewStateType.MapViewStateType1 int i) {
        IOperatorBusinessImpl iOperatorBusinessImpl = this.mControl;
        if (iOperatorBusinessImpl != null) {
            return iOperatorBusinessImpl.getMapViewState(i);
        }
        return false;
    }

    public boolean setMapSkyboxParam(MapSkyboxParam mapSkyboxParam) {
        IOperatorBusinessImpl iOperatorBusinessImpl = this.mControl;
        if (iOperatorBusinessImpl != null) {
            return iOperatorBusinessImpl.setMapSkyboxParam(mapSkyboxParam);
        }
        return false;
    }

    public void setEnterFBOTickCount(int i) {
        IOperatorBusinessImpl iOperatorBusinessImpl = this.mControl;
        if (iOperatorBusinessImpl != null) {
            iOperatorBusinessImpl.setEnterFBOTickCount(i);
        }
    }

    public boolean setShowBuildingCollision(boolean z) {
        IOperatorBusinessImpl iOperatorBusinessImpl = this.mControl;
        if (iOperatorBusinessImpl != null) {
            return iOperatorBusinessImpl.setShowBuildingCollision(z);
        }
        return false;
    }

    public boolean setRestoredMapModeState(MapStyleParam mapStyleParam) {
        IOperatorBusinessImpl iOperatorBusinessImpl = this.mControl;
        if (iOperatorBusinessImpl != null) {
            return iOperatorBusinessImpl.setRestoredMapModeState(mapStyleParam);
        }
        return false;
    }

    public MapStyleParam getRestoredMapModeState() {
        IOperatorBusinessImpl iOperatorBusinessImpl = this.mControl;
        if (iOperatorBusinessImpl != null) {
            return iOperatorBusinessImpl.getRestoredMapModeState();
        }
        return null;
    }

    public void setBuildingAnimateAlpha(boolean z, boolean z2, int i) {
        IOperatorBusinessImpl iOperatorBusinessImpl = this.mControl;
        if (iOperatorBusinessImpl != null) {
            iOperatorBusinessImpl.setBuildingAnimateAlpha(z, z2, i);
        }
    }

    public boolean setPoiLinearGradient(PoiLinearGradientParam poiLinearGradientParam) {
        IOperatorBusinessImpl iOperatorBusinessImpl = this.mControl;
        if (iOperatorBusinessImpl != null) {
            return iOperatorBusinessImpl.setPoiLinearGradient(poiLinearGradientParam);
        }
        return false;
    }

    public boolean setDynamicSkyBox(MsgDataDynamicSky msgDataDynamicSky) {
        IOperatorBusinessImpl iOperatorBusinessImpl = this.mControl;
        if (iOperatorBusinessImpl != null) {
            return iOperatorBusinessImpl.setDynamicSkyBox(msgDataDynamicSky);
        }
        return false;
    }

    public boolean setIndoorParkShowLevel(MsgIndoorParkBuildingShowLevel msgIndoorParkBuildingShowLevel) {
        IOperatorBusinessImpl iOperatorBusinessImpl = this.mControl;
        if (iOperatorBusinessImpl != null) {
            return iOperatorBusinessImpl.setIndoorParkShowLevel(msgIndoorParkBuildingShowLevel);
        }
        return false;
    }

    public boolean setNakeEye3D(NakeEyeMapViewParam nakeEyeMapViewParam) {
        IOperatorBusinessImpl iOperatorBusinessImpl = this.mControl;
        if (iOperatorBusinessImpl != null) {
            return iOperatorBusinessImpl.setNakeEye3D(nakeEyeMapViewParam);
        }
        return false;
    }

    protected void unbind() {
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

    protected synchronized void delete() {
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
