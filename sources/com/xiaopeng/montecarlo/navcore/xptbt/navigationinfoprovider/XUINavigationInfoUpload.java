package com.xiaopeng.montecarlo.navcore.xptbt.navigationinfoprovider;

import android.text.TextUtils;
import android.util.Base64;
import androidx.annotation.NonNull;
import com.xiaopeng.montecarlo.navcore.R;
import com.xiaopeng.montecarlo.navcore.bean.location.XPLocInfo;
import com.xiaopeng.montecarlo.navcore.util.NavCoreUtil;
import com.xiaopeng.montecarlo.navcore.xptbt.TBTManager;
import com.xiaopeng.montecarlo.navcore.xptbt.XUIServiceManager;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPCameraInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPCrossImageInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPExitDirectionInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPFacilityInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPLaneInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPManeuverInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPNaviInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPObtainInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPTollGateInfo;
import com.xiaopeng.montecarlo.root.carservice.CarServiceManager;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.StatisticDataUtil;
import com.xiaopeng.montecarlo.root.util.logcat.LogHelper;
import com.xiaopeng.montecarlo.util.uirelationship.UIRelationshipConfig;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.zip.GZIPInputStream;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class XUINavigationInfoUpload implements INavigationInfoUploadStrategy, CarServiceManager.IXPCarStateListener {
    private static final int LANE_MAX = 7;
    private static final String MSG_VERSION = "V1.0.10";
    private static final L.Tag TAG = new L.Tag("XUINavigationInfoUpload");
    private int mCurrentSegIndex = 0;
    private long mCurrentPathID = 0;
    private String mNaviExitNum = new String("");
    private String mNaviExitDirectionName = new String("");
    private int mNaviExitType = 1;
    private long mNextManeuverId = 0;
    private int mNextManeuverDist = 0;

    private int getDistanceUnit(double d) {
        return d >= 1000.0d ? 1 : 0;
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onBCMDriveSeatStateChange(int i) {
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onCarSpeedChange(float f) {
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onDrivingModeChange(int i) {
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onEnduranceMileageModeChange(int i) {
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onEnergyRecycleLevelChange(int i) {
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onGearLevelChange(int i) {
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onHVACPowerModeChange(boolean z) {
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onIcmConnectionStateChange(boolean z) {
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onIcmMapFpsChange(int i) {
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onIcmMapSizeChange(int i, int i2) {
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onImuNavDataChange(float[] fArr) {
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onRawCarSpeedChange(float f) {
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onScuCarSpeedChange(float f) {
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onXPolitDriveModeStatusChange(CarServiceManager.XPolitDriveMode xPolitDriveMode) {
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onXpuNedcStatusChange(int i) {
    }

    public XUINavigationInfoUpload() {
        CarServiceManager.getInstance().addCarStateListener(this);
    }

    public static String getDistanceDisplay(double d, boolean z) {
        if (d < 1000.0d) {
            return String.format("%d", Integer.valueOf((int) d));
        }
        if (z || d > 10000.0d) {
            return String.format("%d", Integer.valueOf(((int) d) / 1000));
        }
        double round = ((float) Math.round((d / 1000.0d) * 10.0d)) / 10.0f;
        return (round * 10.0d) % 10.0d == 0.0d ? String.format("%d", Integer.valueOf((int) round)) : String.format("%1$.1f", Double.valueOf(round));
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.navigationinfoprovider.INavigationInfoUploadStrategy
    public void updateLocInfo(XPLocInfo xPLocInfo) {
        if (xPLocInfo == null || CollectionUtils.isEmpty(xPLocInfo.getMatchInfoList())) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("carDir", (int) xPLocInfo.getMatchInfoList().get(0).getCourse());
            jSONObject2.put("formway", xPLocInfo.getMatchInfoList().get(0).getFormway());
            jSONObject2.put("linkType", xPLocInfo.getMatchInfoList().get(0).getLinkType());
            jSONObject2.put("roadClass", xPLocInfo.getMatchInfoList().get(0).getRoadClass());
            jSONObject2.put("carLon", xPLocInfo.getMatchInfoList().get(0).getStPos().mLon);
            jSONObject2.put("carLat", xPLocInfo.getMatchInfoList().get(0).getStPos().mLat);
            jSONObject.put("locInfo", jSONObject2);
            jSONObject.put("msgType", TBTManager.getInstance().getCurrentStatus());
            jSONObject.put("msgVersion", MSG_VERSION);
        } catch (JSONException e) {
            jSONObject = null;
            L.i(TAG, "updateLocInfo to json failed");
            e.printStackTrace();
        }
        if (jSONObject != null) {
            if (L.ENABLE) {
                L.Tag tag = TAG;
                L.d(tag, "updateLocInfo data=" + jSONObject.toString());
            }
            sendNavigationInfo(jSONObject.toString());
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.navigationinfoprovider.INavigationInfoUploadStrategy
    public void updateManeuverInfo(XPManeuverInfo xPManeuverInfo, XPObtainInfo xPObtainInfo) {
        if (isNavi()) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            try {
                StringBuilder sb = new StringBuilder();
                if (xPObtainInfo != null && xPObtainInfo.mData != null && xPObtainInfo.mData.length > 0) {
                    sb.append("maneuverData:");
                    String encodeToString = Base64.encodeToString(xPObtainInfo.mData, 2);
                    jSONObject2.put("maneuverData", encodeToString);
                    sb.append(LogHelper.getLogHead(encodeToString));
                }
                if (xPManeuverInfo != null) {
                    jSONObject2.put("maneuverID", xPManeuverInfo.mManeuverID);
                    sb.append(" maneuverID:" + xPManeuverInfo.mManeuverID);
                }
                jSONObject.put("maneuver", jSONObject2);
                int currentStatus = TBTManager.getInstance().getCurrentStatus();
                jSONObject.put("msgType", currentStatus);
                sb.append(" msgType:" + currentStatus);
                jSONObject.put("msgVersion", MSG_VERSION);
                sb.append(" msgVersion:V1.0.10");
                String jSONObject3 = jSONObject.toString();
                L.Tag tag = TAG;
                L.i(tag, "updateManeuverInfo data=" + sb.toString() + " len:" + jSONObject3.length());
                sendNavigationInfo(jSONObject3);
            } catch (JSONException e) {
                L.i(TAG, "updateManeuverInfo to json failed");
                e.printStackTrace();
            }
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.navigationinfoprovider.INavigationInfoUploadStrategy
    public void updateNaviInfo(XPNaviInfo xPNaviInfo, XPExitDirectionInfo xPExitDirectionInfo) {
        if (xPNaviInfo == null || !isNavi()) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            if (this.mCurrentSegIndex != xPNaviInfo.mCurSegIdx || this.mCurrentPathID != xPNaviInfo.mPathID) {
                TBTManager.getInstance().setNaviExitDirectionInfo(null);
                xPExitDirectionInfo = null;
            }
            this.mCurrentSegIndex = xPNaviInfo.mCurSegIdx;
            this.mCurrentPathID = xPNaviInfo.mPathID;
            jSONObject2.put("curRouteName", xPNaviInfo.mCurRouteName);
            jSONObject2.put("routeRemainDist", xPNaviInfo.mRouteRemainDist);
            jSONObject2.put("routeRemainDistDisplay", getDistanceString(xPNaviInfo.mRouteRemainDist));
            jSONObject2.put("routeRemainDistUnitDisplay", getDistanceUnit(xPNaviInfo.mRouteRemainDist));
            jSONObject2.put("routeRemainTime", getTimeSeconds(xPNaviInfo.mRouteRemainTime, (int) xPNaviInfo.mRouteRemainDist));
            if (xPNaviInfo.mViaRemainTime != null && xPNaviInfo.mViaRemainTime.length > 0) {
                jSONObject2.put("viaRemainTime", getTimeSeconds(xPNaviInfo.mViaRemainTime[0], (int) xPNaviInfo.mRouteRemainDist));
            }
            boolean isExitInfoShow = isExitInfoShow(xPExitDirectionInfo);
            jSONObject2.put("isShowExitInfo", isExitInfoShow);
            jSONObject2.put("exitInfo", this.mNaviExitNum);
            jSONObject2.put("exitInfoType", this.mNaviExitType);
            if (isExitInfoShow) {
                jSONObject2.put("nextRouteName", this.mNaviExitDirectionName);
            }
            if (xPNaviInfo.mNaviInfoData != null && xPNaviInfo.mNaviInfoData.length > 0) {
                if (!isExitInfoShow) {
                    jSONObject2.put("nextRouteName", xPNaviInfo.mNaviInfoData[xPNaviInfo.mNaviInfoFlag].mNextRouteName);
                }
                jSONObject2.put("segmentRemainDist", xPNaviInfo.mNaviInfoData[xPNaviInfo.mNaviInfoFlag].mSegmentRemainDist);
                jSONObject2.put("segmentRemainDistDisplay", getDistanceToTurn(xPNaviInfo));
                jSONObject2.put("segmentRemainDistUnitDisplay", getDistanceUnit(xPNaviInfo.mNaviInfoData[xPNaviInfo.mNaviInfoFlag].mSegmentRemainDist));
                jSONObject2.put("segmentRemainProgress", getSegmentRemainProgress(xPNaviInfo.mNaviInfoData[xPNaviInfo.mNaviInfoFlag].mSegmentRemainDist, xPNaviInfo.mCurRoadClass));
                jSONObject2.put("isTightTurnShow", isTightTurnShow(xPNaviInfo));
                jSONObject2.put("nextManeuverID", this.mNextManeuverId);
                jSONObject2.put("nextManeuverDist", this.mNextManeuverDist);
                jSONObject2.put("nextManeuverDistDisplay", getDistanceDisplay(this.mNextManeuverDist, false));
                jSONObject2.put("nextManeuverDistUnitDisplay", getDistanceUnit(this.mNextManeuverDist));
            }
            jSONObject.put("navi", jSONObject2);
            jSONObject.put("msgType", TBTManager.getInstance().getCurrentStatus());
            jSONObject.put("msgVersion", MSG_VERSION);
        } catch (JSONException e) {
            L.i(TAG, "updateNaviInfo to json failed");
            e.printStackTrace();
            jSONObject = null;
        }
        if (jSONObject != null) {
            if (StatisticDataUtil.needOutputNaviInfo()) {
                L.i(TAG, "updateNaviInfo data=" + LogHelper.appendLogLength(jSONObject.toString()));
            }
            sendNavigationInfo(jSONObject.toString());
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.navigationinfoprovider.INavigationInfoUploadStrategy
    public void updateLaneInfo(XPLaneInfo xPLaneInfo, XPTollGateInfo xPTollGateInfo, boolean z) {
        if (isNavi()) {
            refreshLaneInfo(xPLaneInfo, xPTollGateInfo, z);
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.navigationinfoprovider.INavigationInfoUploadStrategy
    public void updateCruiseLaneInfo(XPLaneInfo xPLaneInfo, boolean z) {
        if (isNavi()) {
            return;
        }
        refreshLaneInfo(xPLaneInfo, null, z);
    }

    private void refreshLaneInfo(XPLaneInfo xPLaneInfo, XPTollGateInfo xPTollGateInfo, boolean z) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("isLaneShow", z);
            if (xPLaneInfo != null) {
                if (xPLaneInfo.mBackLane != null && xPLaneInfo.mBackLane.length > 7) {
                    L.i(TAG, "updateLaneInfo have lane but size more than 7");
                    jSONObject2.put("isLaneShow", false);
                } else {
                    jSONObject2.put("laneType", 0);
                    jSONObject2.put("backLane", new JSONArray(xPLaneInfo.mBackLane));
                    jSONObject2.put("frontLane", new JSONArray(xPLaneInfo.mFrontLane));
                }
            } else if (xPTollGateInfo != null) {
                if (xPTollGateInfo.mLaneTypes != null && xPTollGateInfo.mLaneTypes.size() > 7) {
                    L.i(TAG, "updateLaneInfo have toll lane but size more than 7");
                    jSONObject2.put("isLaneShow", false);
                } else {
                    jSONObject2.put("laneType", 1);
                    ArrayList arrayList = new ArrayList();
                    for (Integer num : xPTollGateInfo.mLaneTypes) {
                        if (num.intValue() == 1) {
                            arrayList.add(0);
                        } else if (num.intValue() == 2) {
                            arrayList.add(1);
                        } else if (num.intValue() == 4) {
                            arrayList.add(2);
                        } else {
                            arrayList.add(-1);
                        }
                    }
                    jSONObject2.put("tollGateInfo", new JSONArray((Collection) arrayList));
                }
            }
            jSONObject.put("lane", jSONObject2);
            jSONObject.put("msgType", TBTManager.getInstance().getCurrentStatus());
            jSONObject.put("msgVersion", MSG_VERSION);
        } catch (JSONException e) {
            jSONObject = null;
            L.i(TAG, "updateLaneInfo to json failed");
            e.printStackTrace();
        }
        if (jSONObject != null) {
            L.Tag tag = TAG;
            L.i(tag, "updateLaneInfo data=" + LogHelper.appendLogLength(jSONObject.toString()));
            sendNavigationInfo(jSONObject.toString());
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.navigationinfoprovider.INavigationInfoUploadStrategy
    public void updateNormalCameraInfo(List<XPCameraInfo> list) {
        JSONObject jSONObject;
        if (isNavi()) {
            JSONObject jSONObject2 = new JSONObject();
            JSONObject jSONObject3 = new JSONObject();
            try {
                boolean isEmpty = CollectionUtils.isEmpty(list);
                jSONObject3.put("isCameraShow", !isEmpty);
                if (!isEmpty) {
                    JSONArray jSONArray = new JSONArray();
                    for (XPCameraInfo xPCameraInfo : list) {
                        if (xPCameraInfo != null) {
                            JSONObject jSONObject4 = new JSONObject();
                            jSONObject4.put("cameraType", xPCameraInfo.mType);
                            jSONObject4.put("cameraDist", xPCameraInfo.mDistance);
                            jSONObject4.put("cameraDistDisplay", getDistanceDisplay(xPCameraInfo.mDistance, false));
                            jSONObject4.put("cameraDistUnitDisplay", getDistanceUnit(xPCameraInfo.mDistance));
                            if (!CollectionUtils.isEmpty(xPCameraInfo.mSpeed) && xPCameraInfo.mSpeed[0] != 0 && xPCameraInfo.mSpeed[0] != 255) {
                                jSONObject4.put("cameraSpeed", xPCameraInfo.mSpeed[0]);
                                jSONArray.put(jSONObject4);
                            }
                            jSONObject4.put("cameraSpeed", 0);
                            jSONArray.put(jSONObject4);
                        }
                    }
                    jSONObject3.put("cameraInfo", jSONArray);
                }
                jSONObject2.put("camera", jSONObject3);
                jSONObject2.put("msgType", TBTManager.getInstance().getCurrentStatus());
                jSONObject2.put("msgVersion", MSG_VERSION);
                jSONObject = jSONObject2;
            } catch (JSONException e) {
                jSONObject = null;
                L.i(TAG, "updateNormalCameraInfo to json failed");
                e.printStackTrace();
            }
            if (jSONObject != null) {
                L.Tag tag = TAG;
                L.i(tag, "updateNormalCameraInfo data=" + LogHelper.appendLogLength(jSONObject.toString()));
                sendNavigationInfo(jSONObject.toString());
            }
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.navigationinfoprovider.INavigationInfoUploadStrategy
    public void updateIntervalCameraInfo(List<XPCameraInfo> list) {
        JSONObject jSONObject;
        if (isNavi()) {
            JSONObject jSONObject2 = new JSONObject();
            JSONObject jSONObject3 = new JSONObject();
            try {
                boolean isEmpty = CollectionUtils.isEmpty(list);
                jSONObject3.put("isIntervalCameraShow", !isEmpty);
                if (!isEmpty) {
                    JSONArray jSONArray = new JSONArray();
                    for (XPCameraInfo xPCameraInfo : list) {
                        if (xPCameraInfo != null) {
                            JSONObject jSONObject4 = new JSONObject();
                            jSONObject4.put("cameraType", xPCameraInfo.mType);
                            jSONObject4.put("cameraDist", xPCameraInfo.mDistance);
                            jSONObject4.put("cameraDistDisplay", getDistanceDisplay(xPCameraInfo.mDistance, false));
                            jSONObject4.put("cameraDistUnitDisplay", getDistanceUnit(xPCameraInfo.mDistance));
                            jSONObject4.put("cameraSpeed", xPCameraInfo.mSpeed[0]);
                            jSONObject4.put("remainDistance", xPCameraInfo.mRemainDistance);
                            jSONObject4.put("averageSpeed", xPCameraInfo.mAverageSpeed);
                            jSONObject4.put("reasonableSpeedInRemainDist", xPCameraInfo.mReasonableSpeedInRemainDist);
                            jSONArray.put(jSONObject4);
                        }
                    }
                    jSONObject3.put("cameraInfo", jSONArray);
                }
                jSONObject2.put("intervalCamera", jSONObject3);
                jSONObject2.put("msgType", TBTManager.getInstance().getCurrentStatus());
                jSONObject2.put("msgVersion", MSG_VERSION);
                jSONObject = jSONObject2;
            } catch (JSONException e) {
                jSONObject = null;
                L.i(TAG, "updateIntervalCameraInfo to json failed");
                e.printStackTrace();
            }
            if (jSONObject != null) {
                L.Tag tag = TAG;
                L.i(tag, "updateIntervalCameraInfo data=" + LogHelper.appendLogLength(jSONObject.toString()));
                sendNavigationInfo(jSONObject.toString());
            }
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.navigationinfoprovider.INavigationInfoUploadStrategy
    public void updateSapaInfo(List<XPFacilityInfo> list) {
        JSONObject jSONObject;
        if (isNavi()) {
            JSONObject jSONObject2 = new JSONObject();
            JSONObject jSONObject3 = new JSONObject();
            try {
                boolean isNotEmpty = CollectionUtils.isNotEmpty(list);
                jSONObject3.put("isSapaShow", isNotEmpty);
                if (isNotEmpty) {
                    JSONArray jSONArray = new JSONArray();
                    for (XPFacilityInfo xPFacilityInfo : list) {
                        if (xPFacilityInfo != null) {
                            JSONObject jSONObject4 = new JSONObject();
                            jSONObject4.put("remainDist", xPFacilityInfo.mRemainDist);
                            jSONObject4.put("remainDistDisplay", getDistanceDisplay(xPFacilityInfo.mRemainDist, false));
                            jSONObject4.put("remainDistUnitDisplay", getDistanceUnit(xPFacilityInfo.mRemainDist));
                            jSONObject4.put("type", xPFacilityInfo.mType);
                            jSONObject4.put("name", xPFacilityInfo.mName);
                            jSONObject4.put("sapaDetail", xPFacilityInfo.mSapaDetail);
                            jSONArray.put(jSONObject4);
                        }
                    }
                    jSONObject3.put("sapaInfo", jSONArray);
                }
                jSONObject2.put(UIRelationshipConfig.ELEMENT_SAPA, jSONObject3);
                jSONObject2.put("msgType", TBTManager.getInstance().getCurrentStatus());
                jSONObject2.put("msgVersion", MSG_VERSION);
                jSONObject = jSONObject2;
            } catch (JSONException e) {
                jSONObject = null;
                L.i(TAG, "updateSapaInfo to json failed");
                e.printStackTrace();
            }
            if (jSONObject != null) {
                L.Tag tag = TAG;
                L.i(tag, "updateSapaInfo data=" + LogHelper.appendLogLength(jSONObject.toString()));
                sendNavigationInfo(jSONObject.toString());
            }
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.navigationinfoprovider.INavigationInfoUploadStrategy
    public void updateCrossInfo(XPCrossImageInfo xPCrossImageInfo, int i, boolean z) {
        if (isNavi()) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            try {
                StringBuilder sb = new StringBuilder();
                jSONObject2.put("isCrossShow", z);
                sb.append("isCrossShow:" + z);
                if (!z) {
                    jSONObject2.put("crossType", i);
                    sb.append(" crossType:" + i);
                } else if (xPCrossImageInfo != null) {
                    jSONObject2.put("crossType", xPCrossImageInfo.mType);
                    if (xPCrossImageInfo.mDataBuf != null && xPCrossImageInfo.mDataBuf.length > 0) {
                        String encodeToString = Base64.encodeToString(xPCrossImageInfo.mDataBuf, 2);
                        jSONObject2.put("dataBuffer", encodeToString);
                        sb.append(" dataBuffer:" + LogHelper.getLogHead(encodeToString));
                    }
                    if (xPCrossImageInfo.mArrowDataBuf != null && xPCrossImageInfo.mArrowDataBuf.length > 0) {
                        String encodeToString2 = Base64.encodeToString(xPCrossImageInfo.mArrowDataBuf, 2);
                        jSONObject2.put("arrowDataBuffer", encodeToString2);
                        sb.append(" arrowDataBuffer:" + LogHelper.getLogHead(encodeToString2));
                    }
                }
                jSONObject.put(UIRelationshipConfig.TYPE_CROSS, jSONObject2);
                int currentStatus = TBTManager.getInstance().getCurrentStatus();
                jSONObject.put("msgType", currentStatus);
                sb.append(" msgType:" + currentStatus);
                jSONObject.put("msgVersion", MSG_VERSION);
                sb.append(" msgVersion:V1.0.10");
                String jSONObject3 = jSONObject.toString();
                L.Tag tag = TAG;
                L.i(tag, "updateCrossInfo data=" + sb.toString() + " len:" + jSONObject3.length());
                sendNavigationInfo(jSONObject3);
            } catch (JSONException e) {
                L.i(TAG, "updateCrossInfo to json failed");
                e.printStackTrace();
            }
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.navigationinfoprovider.INavigationInfoUploadStrategy
    public void updateCruiseCameraInfo(List<XPFacilityInfo> list) {
        JSONObject jSONObject;
        if (isNavi()) {
            return;
        }
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            boolean hasCruiseCamera = hasCruiseCamera(list);
            jSONObject3.put("isCameraShow", hasCruiseCamera);
            if (hasCruiseCamera) {
                JSONArray jSONArray = new JSONArray();
                for (XPFacilityInfo xPFacilityInfo : list) {
                    if (isCruiseCamera(xPFacilityInfo)) {
                        JSONObject jSONObject4 = new JSONObject();
                        jSONObject4.put("cameraType", xPFacilityInfo.mType);
                        jSONObject4.put("cameraDist", xPFacilityInfo.mRemainDist);
                        jSONObject4.put("cameraDistDisplay", getDistanceDisplay(xPFacilityInfo.mRemainDist, false));
                        jSONObject4.put("cameraDistUnitDisplay", getDistanceUnit(xPFacilityInfo.mRemainDist));
                        jSONObject4.put("cameraSpeed", xPFacilityInfo.mLimitSpeed);
                        jSONArray.put(jSONObject4);
                    }
                }
                jSONObject3.put("cameraInfo", jSONArray);
            }
            jSONObject2.put("camera", jSONObject3);
            jSONObject2.put("msgType", TBTManager.getInstance().getCurrentStatus());
            jSONObject2.put("msgVersion", MSG_VERSION);
            jSONObject = jSONObject2;
        } catch (JSONException e) {
            jSONObject = null;
            L.i(TAG, "updateCruiseCameraInfo to json failed");
            e.printStackTrace();
        }
        if (jSONObject != null) {
            L.Tag tag = TAG;
            L.i(tag, "updateCruiseCameraInfo data=" + LogHelper.appendLogLength(jSONObject.toString()));
            sendNavigationInfo(jSONObject.toString());
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.navigationinfoprovider.INavigationInfoUploadStrategy
    public void updateNaviStop() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("msgType", 0);
            jSONObject.put("msgVersion", MSG_VERSION);
        } catch (JSONException e) {
            L.i(TAG, "updateNaviStop to json failed");
            e.printStackTrace();
            jSONObject = null;
        }
        this.mCurrentSegIndex = 0;
        this.mCurrentPathID = 0L;
        if (jSONObject != null) {
            L.i(TAG, "updateNaviStop data=" + jSONObject.toString());
            sendNavigationInfo(jSONObject.toString());
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.navigationinfoprovider.INavigationInfoUploadStrategy
    public void updateNaviRemainDistInfo(int i, int i2, int i3) {
        if (isNavi()) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("routeRemainDist", i);
                double d = i;
                jSONObject2.put("routeRemainDistDisplay", getDistanceDisplay(d, true));
                jSONObject2.put("routeRemainDistUnitDisplay", getDistanceUnit(d));
                jSONObject2.put("carRemainDist", i2);
                double d2 = i2;
                jSONObject2.put("carRemainDistDisplay", getDistanceDisplay(d2, true));
                jSONObject2.put("carRemainDistUnitDisplay", getDistanceUnit(d2));
                jSONObject2.put("distType", i3);
                jSONObject.put("remainInfo", jSONObject2);
                jSONObject.put("msgType", TBTManager.getInstance().getCurrentStatus());
                jSONObject.put("msgVersion", MSG_VERSION);
            } catch (JSONException e) {
                jSONObject = null;
                L.i(TAG, "updateNaviRemainDistInfo to json failed");
                e.printStackTrace();
            }
            if (jSONObject != null) {
                L.i(TAG, "updateNaviRemainDistInfo data=" + LogHelper.appendLogLength(jSONObject.toString()));
                sendNavigationInfo(jSONObject.toString());
            }
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.navigationinfoprovider.INavigationInfoUploadStrategy
    public void resetNavi() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("msgType", 255);
            jSONObject.put("msgVersion", MSG_VERSION);
        } catch (JSONException e) {
            L.i(TAG, "resetNavi to json failed");
            e.printStackTrace();
            jSONObject = null;
        }
        this.mCurrentSegIndex = 0;
        this.mCurrentPathID = 0L;
        if (jSONObject != null) {
            L.i(TAG, "resetNavi data=" + LogHelper.appendLogLength(jSONObject.toString()));
            sendNavigationInfo(jSONObject.toString());
        }
    }

    private boolean isExitInfoShow(XPExitDirectionInfo xPExitDirectionInfo) {
        if (xPExitDirectionInfo != null && xPExitDirectionInfo.mDirectionInfo != null) {
            this.mNaviExitType = (TextUtils.isEmpty(xPExitDirectionInfo.mEntranceExit) || ContextUtils.getString(R.string.icm_navi_exit_name).equals(xPExitDirectionInfo.mEntranceExit)) ? 1 : 2;
            List<String> list = xPExitDirectionInfo.mExitNameInfo;
            if (list != null && list.size() == 1) {
                this.mNaviExitNum = list.get(0);
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < xPExitDirectionInfo.mDirectionInfo.size(); i++) {
                String str = xPExitDirectionInfo.mDirectionInfo.get(i);
                if (!TextUtils.isEmpty(str)) {
                    if (sb.length() == 0) {
                        sb.append(str);
                    } else {
                        sb.append(" ");
                        sb.append(str);
                    }
                }
            }
            this.mNaviExitDirectionName = sb.toString();
            return true;
        }
        this.mNaviExitNum = "";
        this.mNaviExitDirectionName = "";
        this.mNaviExitType = 1;
        return false;
    }

    private boolean isTightTurnShow(XPNaviInfo xPNaviInfo) {
        if (xPNaviInfo != null && xPNaviInfo.mNextCrossInfo != null && xPNaviInfo.mNextCrossInfo.length > 0 && xPNaviInfo.mNextCrossInfo[0] != null && NavCoreUtil.doesTightTurnExist(xPNaviInfo)) {
            this.mNextManeuverId = xPNaviInfo.mNextCrossInfo[0].mManeuverID;
            this.mNextManeuverDist = xPNaviInfo.mNextCrossInfo[0].mCurToSegmentDist;
            return true;
        }
        this.mNextManeuverId = 0L;
        this.mNextManeuverDist = 0;
        return false;
    }

    private boolean hasCruiseCamera(List<XPFacilityInfo> list) {
        if (CollectionUtils.isEmpty(list)) {
            return false;
        }
        for (XPFacilityInfo xPFacilityInfo : list) {
            if (isCruiseCamera(xPFacilityInfo)) {
                return true;
            }
        }
        return false;
    }

    private boolean isCruiseCamera(XPFacilityInfo xPFacilityInfo) {
        if (xPFacilityInfo != null) {
            return 4 == xPFacilityInfo.mType || 28 == xPFacilityInfo.mType || 92 == xPFacilityInfo.mType || 5 == xPFacilityInfo.mType || 29 == xPFacilityInfo.mType || 93 == xPFacilityInfo.mType || 94 == xPFacilityInfo.mType;
        }
        return false;
    }

    private int getSegmentRemainProgress(int i, int i2) {
        if (i2 == 0 || 6 == i2) {
            if (i <= 250) {
                return (i * 100) / 250;
            }
        } else if (i <= 150) {
            return (i * 100) / 150;
        }
        return -1;
    }

    private void sendNavigationInfo(@NonNull String str) {
        if (!TextUtils.isEmpty(str)) {
            XUIServiceManager.getInstance().updateNavigationInfo(str.replace("\\/", MqttTopic.TOPIC_LEVEL_SEPARATOR));
        } else {
            L.i(TAG, ">>> sendNavigationInfo fail zip data was null");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x004c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.lang.String compressData(java.lang.String r4) {
        /*
            r3 = this;
            boolean r0 = android.text.TextUtils.isEmpty(r4)
            r1 = 0
            if (r0 == 0) goto L8
            return r1
        L8:
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L36 java.io.IOException -> L39
            r0.<init>()     // Catch: java.lang.Throwable -> L36 java.io.IOException -> L39
            java.util.zip.GZIPOutputStream r2 = new java.util.zip.GZIPOutputStream     // Catch: java.io.IOException -> L34 java.lang.Throwable -> L49
            r2.<init>(r0)     // Catch: java.io.IOException -> L34 java.lang.Throwable -> L49
            byte[] r4 = r4.getBytes()     // Catch: java.io.IOException -> L34 java.lang.Throwable -> L49
            r2.write(r4)     // Catch: java.io.IOException -> L34 java.lang.Throwable -> L49
            r2.close()     // Catch: java.io.IOException -> L34 java.lang.Throwable -> L49
            byte[] r4 = r0.toByteArray()     // Catch: java.io.IOException -> L34 java.lang.Throwable -> L49
            r0.flush()     // Catch: java.io.IOException -> L34 java.lang.Throwable -> L49
            r0.close()     // Catch: java.io.IOException -> L34 java.lang.Throwable -> L49
            r2 = 2
            java.lang.String r4 = android.util.Base64.encodeToString(r4, r2)     // Catch: java.io.IOException -> L34 java.lang.Throwable -> L49
            r0.close()     // Catch: java.io.IOException -> L2f
            goto L33
        L2f:
            r0 = move-exception
            r0.printStackTrace()
        L33:
            return r4
        L34:
            r4 = move-exception
            goto L3b
        L36:
            r4 = move-exception
            r0 = r1
            goto L4a
        L39:
            r4 = move-exception
            r0 = r1
        L3b:
            r4.printStackTrace()     // Catch: java.lang.Throwable -> L49
            if (r0 == 0) goto L48
            r0.close()     // Catch: java.io.IOException -> L44
            goto L48
        L44:
            r4 = move-exception
            r4.printStackTrace()
        L48:
            return r1
        L49:
            r4 = move-exception
        L4a:
            if (r0 == 0) goto L54
            r0.close()     // Catch: java.io.IOException -> L50
            goto L54
        L50:
            r0 = move-exception
            r0.printStackTrace()
        L54:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaopeng.montecarlo.navcore.xptbt.navigationinfoprovider.XUINavigationInfoUpload.compressData(java.lang.String):java.lang.String");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r0v7, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r0v8, types: [java.io.ByteArrayOutputStream] */
    private String decompress(String str) {
        ByteArrayInputStream byteArrayInputStream;
        ByteArrayInputStream byteArrayInputStream2;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ?? r0 = 2;
        byte[] decode = Base64.decode(str, 2);
        try {
            try {
                r0 = new ByteArrayOutputStream();
            } catch (Throwable th) {
                th = th;
            }
        } catch (IOException e) {
            e = e;
            r0 = 0;
            byteArrayInputStream2 = null;
        } catch (Throwable th2) {
            th = th2;
            r0 = 0;
            byteArrayInputStream = null;
        }
        try {
            byteArrayInputStream2 = new ByteArrayInputStream(decode);
            try {
                GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream2);
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = gZIPInputStream.read(bArr, 0, bArr.length);
                    if (read <= 0) {
                        break;
                    }
                    r0.write(bArr, 0, read);
                }
                gZIPInputStream.close();
                byteArrayInputStream2.close();
                r0.close();
                String byteArrayOutputStream = r0.toString();
                try {
                    r0.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
                try {
                    byteArrayInputStream2.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
                return byteArrayOutputStream;
            } catch (IOException e4) {
                e = e4;
                e.printStackTrace();
                if (r0 != 0) {
                    try {
                        r0.close();
                    } catch (IOException e5) {
                        e5.printStackTrace();
                    }
                }
                if (byteArrayInputStream2 != null) {
                    try {
                        byteArrayInputStream2.close();
                    } catch (IOException e6) {
                        e6.printStackTrace();
                    }
                }
                return null;
            }
        } catch (IOException e7) {
            e = e7;
            byteArrayInputStream2 = null;
        } catch (Throwable th3) {
            th = th3;
            byteArrayInputStream = null;
            if (r0 != 0) {
                try {
                    r0.close();
                } catch (IOException e8) {
                    e8.printStackTrace();
                }
            }
            if (byteArrayInputStream != null) {
                try {
                    byteArrayInputStream.close();
                } catch (IOException e9) {
                    e9.printStackTrace();
                }
            }
            throw th;
        }
    }

    private boolean isNavi() {
        int currentStatus = TBTManager.getInstance().getCurrentStatus();
        return 1 == currentStatus || 2 == currentStatus;
    }

    private String getDistanceToTurn(XPNaviInfo xPNaviInfo) {
        return NavCoreUtil.getDistanceArray(xPNaviInfo.mNaviInfoData[xPNaviInfo.mNaviInfoFlag].mSegmentRemainDist)[0];
    }

    private String getDistanceString(double d) {
        return NavCoreUtil.getDistanceArray(d)[0];
    }

    private double getTimeSeconds(double d, int i) {
        return ContextUtils.isPortrait() ? NavCoreUtil.getCompleteTimeSeconds(d, i) : d;
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onIcmMapDisplayStateChange(boolean z) {
        if (z) {
            if (isNavi()) {
                L.i(TAG, "onIcmMapDisplayStateChange current is navi, need send navi info to icm");
                updateNaviInfo(TBTManager.getInstance().getNaviInfo(), TBTManager.getInstance().getNaviExitDirectionInfo());
                XPManeuverInfo naviManeuverInfo = TBTManager.getInstance().getNaviManeuverInfo();
                if (naviManeuverInfo != null) {
                    TBTManager.getInstance().asyncManeuverInfo(naviManeuverInfo);
                }
                XPLaneInfo naviLaneInfo = TBTManager.getInstance().getNaviLaneInfo();
                XPTollGateInfo xPTollGateInfo = TBTManager.getInstance().getXPTollGateInfo();
                if (naviLaneInfo != null) {
                    updateLaneInfo(naviLaneInfo, null, true);
                } else if (xPTollGateInfo != null) {
                    updateLaneInfo(null, xPTollGateInfo, true);
                }
                List<XPCameraInfo> naviCamera = TBTManager.getInstance().getNaviCamera();
                if (naviCamera != null) {
                    updateNormalCameraInfo(naviCamera);
                }
                List<XPCameraInfo> naviIntervalDynamicCameras = TBTManager.getInstance().getNaviIntervalDynamicCameras();
                if (naviIntervalDynamicCameras != null) {
                    updateIntervalCameraInfo(naviIntervalDynamicCameras);
                }
                List<XPFacilityInfo> naviSapas = TBTManager.getInstance().getNaviSapas();
                if (naviSapas != null) {
                    updateSapaInfo(naviSapas);
                }
                XPCrossImageInfo naviCrossImageInfo = TBTManager.getInstance().getNaviCrossImageInfo();
                if (naviCrossImageInfo != null) {
                    updateCrossInfo(naviCrossImageInfo, naviCrossImageInfo.mType, true);
                    return;
                }
                return;
            }
            L.i(TAG, "onIcmMapDisplayStateChange current is cruise, need send cruise info to icm");
            updateNaviStop();
            List<XPFacilityInfo> xPFacilityInfos = TBTManager.getInstance().getXPFacilityInfos();
            if (xPFacilityInfos != null) {
                updateCruiseCameraInfo(xPFacilityInfos);
            }
            XPLaneInfo cruiseLaneInfo = TBTManager.getInstance().getCruiseLaneInfo();
            if (cruiseLaneInfo != null) {
                updateCruiseLaneInfo(cruiseLaneInfo, true);
            }
        }
    }
}
