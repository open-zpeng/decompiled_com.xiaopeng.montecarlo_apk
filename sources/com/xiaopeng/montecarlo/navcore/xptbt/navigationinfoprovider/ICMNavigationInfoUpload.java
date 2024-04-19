package com.xiaopeng.montecarlo.navcore.xptbt.navigationinfoprovider;

import android.text.TextUtils;
import com.xiaopeng.montecarlo.navcore.R;
import com.xiaopeng.montecarlo.navcore.bean.location.XPLocInfo;
import com.xiaopeng.montecarlo.navcore.util.NavCoreUtil;
import com.xiaopeng.montecarlo.navcore.xptbt.TBTManager;
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
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.StatisticDataUtil;
import java.io.UnsupportedEncodingException;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ICMNavigationInfoUpload implements INavigationInfoUploadStrategy, CarServiceManager.IXPCarStateListener {
    private static final L.Tag TAG = new L.Tag("ICMNavigationInfoUpload");
    private String mIcmString;
    private int mCurrentSegIndex = 0;
    private long mLastPathID = -1;
    private boolean mIsIcmConnected = true;

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
    public void onIcmMapDisplayStateChange(boolean z) {
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

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.navigationinfoprovider.INavigationInfoUploadStrategy
    public void resetNavi() {
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.navigationinfoprovider.INavigationInfoUploadStrategy
    public void updateCrossInfo(XPCrossImageInfo xPCrossImageInfo, int i, boolean z) {
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.navigationinfoprovider.INavigationInfoUploadStrategy
    public void updateCruiseCameraInfo(List<XPFacilityInfo> list) {
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.navigationinfoprovider.INavigationInfoUploadStrategy
    public void updateCruiseLaneInfo(XPLaneInfo xPLaneInfo, boolean z) {
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.navigationinfoprovider.INavigationInfoUploadStrategy
    public void updateIntervalCameraInfo(List<XPCameraInfo> list) {
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.navigationinfoprovider.INavigationInfoUploadStrategy
    public void updateLaneInfo(XPLaneInfo xPLaneInfo, XPTollGateInfo xPTollGateInfo, boolean z) {
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.navigationinfoprovider.INavigationInfoUploadStrategy
    public void updateLocInfo(XPLocInfo xPLocInfo) {
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.navigationinfoprovider.INavigationInfoUploadStrategy
    public void updateManeuverInfo(XPManeuverInfo xPManeuverInfo, XPObtainInfo xPObtainInfo) {
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.navigationinfoprovider.INavigationInfoUploadStrategy
    public void updateNaviRemainDistInfo(int i, int i2, int i3) {
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.navigationinfoprovider.INavigationInfoUploadStrategy
    public void updateNormalCameraInfo(List<XPCameraInfo> list) {
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.navigationinfoprovider.INavigationInfoUploadStrategy
    public void updateSRInfo(boolean z) {
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.navigationinfoprovider.INavigationInfoUploadStrategy
    public void updateSRTraffic(int i) {
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.navigationinfoprovider.INavigationInfoUploadStrategy
    public void updateSapaInfo(List<XPFacilityInfo> list) {
    }

    public ICMNavigationInfoUpload() {
        CarServiceManager.getInstance().addCarStateListener(this);
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.navigationinfoprovider.INavigationInfoUploadStrategy
    public void updateNaviInfo(XPNaviInfo xPNaviInfo, XPExitDirectionInfo xPExitDirectionInfo) {
        if (xPNaviInfo == null || !isNavi()) {
            return;
        }
        if (this.mCurrentSegIndex != xPNaviInfo.mCurSegIdx) {
            TBTManager.getInstance().setNaviExitDirectionInfo(null);
            xPExitDirectionInfo = null;
        }
        this.mCurrentSegIndex = xPNaviInfo.mCurSegIdx;
        if (xPExitDirectionInfo != null && this.mLastPathID != xPNaviInfo.mPathID) {
            TBTManager.getInstance().setNaviExitDirectionInfo(null);
            xPExitDirectionInfo = null;
        }
        this.mLastPathID = xPNaviInfo.mPathID;
        JSONObject constructNaviInfoForICM = NavCoreUtil.constructNaviInfoForICM(xPNaviInfo, getXpExitDirectionInfo(xPExitDirectionInfo));
        if (constructNaviInfoForICM == null) {
            L.i(TAG, ">>> updateNaviInfo fail data is null");
            return;
        }
        this.mIcmString = constructNaviInfoForICM.toString();
        if (this.mIcmString == null) {
            L.i(TAG, ">>> updateNaviInfo fail str is null");
            return;
        }
        if (this.mIsIcmConnected) {
            try {
                TBTManager.getInstance().setNavigationInfo(this.mIcmString.getBytes("UTF-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                L.w(TAG, ">>> updateNaviInfo getBytes fail");
            }
        }
        if (StatisticDataUtil.needOutputNaviInfo()) {
            L.i(TAG, ">>>ICM Connect:" + this.mIsIcmConnected + " updateNaviInfo: " + this.mIcmString);
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.navigationinfoprovider.INavigationInfoUploadStrategy
    public void updateNaviStop() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("enable", "0");
            jSONObject.put("msgtype", "1");
            TBTManager.getInstance().setNavigationInfo(jSONObject.toString().getBytes("UTF-8"));
            L.i(TAG, ">>> updateNaviStop");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            L.i(TAG, ">>> updateNaviStop fail");
        } catch (JSONException e2) {
            e2.printStackTrace();
            L.i(TAG, ">>> updateNaviStop fail");
        }
    }

    private String getXpExitDirectionInfo(XPExitDirectionInfo xPExitDirectionInfo) {
        if (xPExitDirectionInfo != null && xPExitDirectionInfo.mDirectionInfo != null) {
            List<String> list = xPExitDirectionInfo.mExitNameInfo;
            L.Tag tag = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("getXpExitDirectionInfo exitNameInfo =");
            sb.append(list == null ? "is null" : Integer.valueOf(list.size()));
            L.i(tag, sb.toString());
            String str = (list == null || list.size() != 1) ? "" : list.get(0);
            String string = TextUtils.isEmpty(xPExitDirectionInfo.mEntranceExit) ? ContextUtils.getString(R.string.icm_navi_exit_name) : xPExitDirectionInfo.mEntranceExit;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(string);
            sb2.append(str);
            for (int i = 0; i < xPExitDirectionInfo.mDirectionInfo.size(); i++) {
                String str2 = xPExitDirectionInfo.mDirectionInfo.get(i);
                if (!TextUtils.isEmpty(str2)) {
                    if (sb2.length() == 0) {
                        sb2.append(str2);
                    } else {
                        sb2.append(" ");
                        sb2.append(str2);
                    }
                }
            }
            L.Tag tag2 = TAG;
            L.i(tag2, "getXpExitDirectionInfo exitDirectionInfo direction = " + sb2.toString());
            if (!TextUtils.isEmpty(sb2.toString())) {
                return sb2.toString();
            }
        }
        return null;
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onIcmConnectionStateChange(boolean z) {
        if (z) {
            if (isNavi()) {
                if (this.mIcmString == null) {
                    L.i(TAG, ">>> callback updateNaviInfo fail str is null");
                    return;
                }
                try {
                    L.Tag tag = TAG;
                    L.i(tag, "callback updateNaviInfo str = " + this.mIcmString);
                    TBTManager.getInstance().setNavigationInfo(this.mIcmString.getBytes("UTF-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                    L.i(TAG, ">>>callback updateNaviInfo getBytes fail");
                }
            } else {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("enable", "0");
                    jSONObject.put("msgtype", "1");
                    TBTManager.getInstance().setNavigationInfo(jSONObject.toString().getBytes("UTF-8"));
                    L.i(TAG, ">>> callback updateNaviStop");
                } catch (UnsupportedEncodingException e2) {
                    e2.printStackTrace();
                    L.i(TAG, ">>> callback updateNaviStop fail");
                } catch (JSONException e3) {
                    e3.printStackTrace();
                    L.i(TAG, ">>> callback updateNaviStop fail");
                }
            }
        } else {
            L.w(TAG, "callback ICM is disconnected");
        }
        this.mIsIcmConnected = z;
    }

    private boolean isNavi() {
        int currentStatus = TBTManager.getInstance().getCurrentStatus();
        return 1 == currentStatus || 2 == currentStatus;
    }
}
