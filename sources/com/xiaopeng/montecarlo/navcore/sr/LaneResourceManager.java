package com.xiaopeng.montecarlo.navcore.sr;

import android.text.TextUtils;
import android.util.SparseArray;
import com.autonavi.gbl.lane.model.LaneModelDtoConstants;
import com.autonavi.gbl.lane.model.LaneResourceRequest;
import com.autonavi.gbl.lane.model.LaneResourceRequestFile;
import com.autonavi.gbl.lane.model.LaneResourceResponse;
import com.autonavi.gbl.lane.model.SRObject;
import com.autonavi.gbl.lane.model.SRPartsStyle;
import com.autonavi.gbl.lane.observer.ILaneResourceProxy;
import com.autonavi.gbl.util.model.BinaryStream;
import com.xiaopeng.montecarlo.navcore.setting.SettingWrapper;
import com.xiaopeng.montecarlo.navcore.util.NavCoreUtil;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.RootUtil;
import com.xiaopeng.montecarlo.root.util.ioutil.FileUtil;
import java.io.File;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes3.dex */
public class LaneResourceManager {
    public static final int TEXTURE_CONFIGURABLE_COUNT = 11;
    public static final int TEXTURE_CONFIGURABLE_START = 157;
    public static final int TEXTURE_ID_BICYCLE_BLUE = 16;
    public static final int TEXTURE_ID_BICYCLE_BLUE_NIGHT = 17;
    public static final int TEXTURE_ID_BICYCLE_DEFAULT = 14;
    public static final int TEXTURE_ID_BICYCLE_DEFAULT_NIGHT = 15;
    public static final int TEXTURE_ID_BICYCLE_GRAY = 18;
    public static final int TEXTURE_ID_BICYCLE_GRAY_NIGHT = 19;
    public static final int TEXTURE_ID_BICYCLE_MODEL = 13;
    public static final int TEXTURE_ID_BICYCLE_RED = 20;
    public static final int TEXTURE_ID_BICYCLE_RED_NIGHT = 21;
    public static final int TEXTURE_ID_BICYCLE_SHADOW = 22;
    public static final int TEXTURE_ID_BUS_BLUE = 59;
    public static final int TEXTURE_ID_BUS_BLUE_NIGHT = 60;
    public static final int TEXTURE_ID_BUS_DEFAULT = 57;
    public static final int TEXTURE_ID_BUS_DEFAULT_NIGHT = 58;
    public static final int TEXTURE_ID_BUS_GRAY = 61;
    public static final int TEXTURE_ID_BUS_GRAY_NIGHT = 62;
    public static final int TEXTURE_ID_BUS_LDIRECTION = 66;
    public static final int TEXTURE_ID_BUS_MODEL = 56;
    public static final int TEXTURE_ID_BUS_RDIRECTION = 67;
    public static final int TEXTURE_ID_BUS_RED = 63;
    public static final int TEXTURE_ID_BUS_RED_NIGHT = 64;
    public static final int TEXTURE_ID_BUS_SHADOW = 65;
    public static final int TEXTURE_ID_BUS_STOP = 68;
    public static final int TEXTURE_ID_CAR_BLUE = 111;
    public static final int TEXTURE_ID_CAR_BLUE_NIGHT = 112;
    public static final int TEXTURE_ID_CAR_DEFAULT = 109;
    public static final int TEXTURE_ID_CAR_DEFAULT_NIGHT = 110;
    public static final int TEXTURE_ID_CAR_GRAY = 113;
    public static final int TEXTURE_ID_CAR_GRAY_NIGHT = 114;
    public static final int TEXTURE_ID_CAR_LDIRECTION = 118;
    public static final int TEXTURE_ID_CAR_MODEL = 108;
    public static final int TEXTURE_ID_CAR_RDIRECTION = 119;
    public static final int TEXTURE_ID_CAR_RED = 115;
    public static final int TEXTURE_ID_CAR_RED_NIGHT = 116;
    public static final int TEXTURE_ID_CAR_SHADOW = 117;
    public static final int TEXTURE_ID_CAR_STOP = 120;
    public static final int TEXTURE_ID_CHEWEI = 9;
    public static final int TEXTURE_ID_CHEWEI_NIGHT = 10;
    public static final int TEXTURE_ID_CS_EMERGENCY = 165;
    public static final int TEXTURE_ID_CS_FRAME = 159;
    public static final int TEXTURE_ID_CS_FRAME_NIGHT = 160;
    public static final int TEXTURE_ID_CS_HIGH = 168;
    public static final int TEXTURE_ID_CS_LDIRECTION = 163;
    public static final int TEXTURE_ID_CS_LOWER = 167;
    public static final int TEXTURE_ID_CS_MODEL = 158;
    public static final int TEXTURE_ID_CS_RDIRECTION = 164;
    public static final int TEXTURE_ID_CS_SHADOW = 161;
    public static final int TEXTURE_ID_CS_SHADOW_NIGHT = 162;
    public static final int TEXTURE_ID_CS_STOP = 166;
    public static final int TEXTURE_ID_DENGDAI = 1;
    public static final int TEXTURE_ID_DENGDAI_NIGHT = 2;
    public static final int TEXTURE_ID_DRUM = 128;
    public static final int TEXTURE_ID_DRUM_MODEL = 127;
    public static final int TEXTURE_ID_DRUM_NIGHT = 129;
    public static final int TEXTURE_ID_DRUM_SHADOW = 130;
    public static final int TEXTURE_ID_GUIDE = 5;
    public static final int TEXTURE_ID_GUIDE_NIGHT = 6;
    public static final int TEXTURE_ID_HIGHLIGHT = 3;
    public static final int TEXTURE_ID_HIGHLIGHT_NIGHT = 4;
    public static final int TEXTURE_ID_INVALID = 0;
    public static final int TEXTURE_ID_LCC = 11;
    public static final int TEXTURE_ID_LCC_NIGHT = 12;
    public static final int TEXTURE_ID_MIAOBIAN = 7;
    public static final int TEXTURE_ID_MIAOBIAN_NIGHT = 8;
    public static final int TEXTURE_ID_MOTORCYCLE_BLUE = 26;
    public static final int TEXTURE_ID_MOTORCYCLE_BLUE_NIGHT = 27;
    public static final int TEXTURE_ID_MOTORCYCLE_DEFAULT = 24;
    public static final int TEXTURE_ID_MOTORCYCLE_DEFAULT_NIGHT = 25;
    public static final int TEXTURE_ID_MOTORCYCLE_GRAY = 28;
    public static final int TEXTURE_ID_MOTORCYCLE_GRAY_NIGHT = 29;
    public static final int TEXTURE_ID_MOTORCYCLE_MODEL = 23;
    public static final int TEXTURE_ID_MOTORCYCLE_RED = 30;
    public static final int TEXTURE_ID_MOTORCYCLE_RED_NIGHT = 31;
    public static final int TEXTURE_ID_MOTORCYCLE_SHADOW = 32;
    public static final int TEXTURE_ID_PEDDESTRIAN_BLUE = 36;
    public static final int TEXTURE_ID_PEDDESTRIAN_BLUE_NIGHT = 37;
    public static final int TEXTURE_ID_PEDDESTRIAN_DEFAULT = 34;
    public static final int TEXTURE_ID_PEDDESTRIAN_DEFAULT_NIGHT = 35;
    public static final int TEXTURE_ID_PEDDESTRIAN_GRAY = 38;
    public static final int TEXTURE_ID_PEDDESTRIAN_GRAY_NIGHT = 39;
    public static final int TEXTURE_ID_PEDDESTRIAN_MODEL = 33;
    public static final int TEXTURE_ID_PEDDESTRIAN_RED = 40;
    public static final int TEXTURE_ID_PEDDESTRIAN_RED_NIGHT = 41;
    public static final int TEXTURE_ID_PEDDESTRIAN_SHADOW = 42;
    public static final int TEXTURE_ID_PICKUP_BLUE = 72;
    public static final int TEXTURE_ID_PICKUP_BLUE_NIGHT = 73;
    public static final int TEXTURE_ID_PICKUP_DEFAULT = 70;
    public static final int TEXTURE_ID_PICKUP_DEFAULT_NIGHT = 71;
    public static final int TEXTURE_ID_PICKUP_GRAY = 74;
    public static final int TEXTURE_ID_PICKUP_GRAY_NIGHT = 75;
    public static final int TEXTURE_ID_PICKUP_LDIRECTION = 79;
    public static final int TEXTURE_ID_PICKUP_MODEL = 69;
    public static final int TEXTURE_ID_PICKUP_RDIRECTION = 80;
    public static final int TEXTURE_ID_PICKUP_RED = 76;
    public static final int TEXTURE_ID_PICKUP_RED_NIGHT = 77;
    public static final int TEXTURE_ID_PICKUP_SHADOW = 78;
    public static final int TEXTURE_ID_PICKUP_STOP = 81;
    public static final int TEXTURE_ID_POLICE_DEFAULT = 44;
    public static final int TEXTURE_ID_POLICE_MODEL = 43;
    public static final int TEXTURE_ID_POLICE_SHADOW = 45;
    public static final int TEXTURE_ID_SUV_BLUE = 85;
    public static final int TEXTURE_ID_SUV_BLUE_NIGHT = 86;
    public static final int TEXTURE_ID_SUV_DEFAULT = 83;
    public static final int TEXTURE_ID_SUV_DEFAULT_NIGHT = 84;
    public static final int TEXTURE_ID_SUV_GRAY = 87;
    public static final int TEXTURE_ID_SUV_GRAY_NIGHT = 88;
    public static final int TEXTURE_ID_SUV_LDIRECTION = 92;
    public static final int TEXTURE_ID_SUV_MODEL = 82;
    public static final int TEXTURE_ID_SUV_RDIRECTION = 93;
    public static final int TEXTURE_ID_SUV_RED = 89;
    public static final int TEXTURE_ID_SUV_RED_NIGHT = 90;
    public static final int TEXTURE_ID_SUV_SHADOW = 91;
    public static final int TEXTURE_ID_SUV_STOP = 94;
    public static final int TEXTURE_ID_TRAFFIC_CONE_GREEN = 124;
    public static final int TEXTURE_ID_TRAFFIC_CONE_GREEN_NIGHT = 125;
    public static final int TEXTURE_ID_TRAFFIC_CONE_MODEL = 121;
    public static final int TEXTURE_ID_TRAFFIC_CONE_RED = 122;
    public static final int TEXTURE_ID_TRAFFIC_CONE_RED_NIGHT = 123;
    public static final int TEXTURE_ID_TRAFFIC_CONE_SHADOW = 126;
    public static final int TEXTURE_ID_TRICYCLE_BLUE = 49;
    public static final int TEXTURE_ID_TRICYCLE_BLUE_NIGHT = 50;
    public static final int TEXTURE_ID_TRICYCLE_DEFAULT = 47;
    public static final int TEXTURE_ID_TRICYCLE_DEFAULT_NIGHT = 48;
    public static final int TEXTURE_ID_TRICYCLE_GRAY = 51;
    public static final int TEXTURE_ID_TRICYCLE_GRAY_NIGHT = 52;
    public static final int TEXTURE_ID_TRICYCLE_MODEL = 46;
    public static final int TEXTURE_ID_TRICYCLE_RED = 53;
    public static final int TEXTURE_ID_TRICYCLE_RED_NIGHT = 54;
    public static final int TEXTURE_ID_TRICYCLE_SHADOW = 55;
    public static final int TEXTURE_ID_VAN_BLUE = 98;
    public static final int TEXTURE_ID_VAN_BLUE_NIGHT = 99;
    public static final int TEXTURE_ID_VAN_DEFAULT = 96;
    public static final int TEXTURE_ID_VAN_DEFAULT_NIGHT = 97;
    public static final int TEXTURE_ID_VAN_GRAY = 100;
    public static final int TEXTURE_ID_VAN_GRAY_NIGHT = 101;
    public static final int TEXTURE_ID_VAN_LDIRECTION = 105;
    public static final int TEXTURE_ID_VAN_MODEL = 95;
    public static final int TEXTURE_ID_VAN_RDIRECTION = 106;
    public static final int TEXTURE_ID_VAN_RED = 102;
    public static final int TEXTURE_ID_VAN_RED_NIGHT = 103;
    public static final int TEXTURE_ID_VAN_SHADOW = 104;
    public static final int TEXTURE_ID_VAN_STOP = 107;
    public static final int TEXTURE_ID_WARN_AEB = 140;
    public static final int TEXTURE_ID_WARN_AEB_NIGHT = 141;
    public static final int TEXTURE_ID_WARN_BSD_LEFT_LEVEL1 = 146;
    public static final int TEXTURE_ID_WARN_BSD_LEFT_LEVEL1_NIGHT = 147;
    public static final int TEXTURE_ID_WARN_BSD_LEFT_LEVEL2 = 148;
    public static final int TEXTURE_ID_WARN_BSD_LEFT_LEVEL2_NIGHT = 149;
    public static final int TEXTURE_ID_WARN_BSD_RIGHT_LEVEL1 = 150;
    public static final int TEXTURE_ID_WARN_BSD_RIGHT_LEVEL1_NIGHT = 151;
    public static final int TEXTURE_ID_WARN_BSD_RIGHT_LEVEL2 = 152;
    public static final int TEXTURE_ID_WARN_BSD_RIGHT_LEVEL2_NIGHT = 153;
    public static final int TEXTURE_ID_WARN_FCW = 142;
    public static final int TEXTURE_ID_WARN_FCW_NIGHT = 143;
    public static final int TEXTURE_ID_WARN_LDW = 154;
    public static final int TEXTURE_ID_WARN_LDW_NIGHT = 155;
    public static final int TEXTURE_ID_WARN_LKA = 156;
    public static final int TEXTURE_ID_WARN_LKA_NIGHT = 157;
    public static final int TEXTURE_ID_WARN_MODEL = 139;
    public static final int TEXTURE_ID_WARN_RCW = 144;
    public static final int TEXTURE_ID_WARN_RCW_NIGHT = 145;
    public static final int TEXTURE_ID_WARN_TRIANGLE = 136;
    public static final int TEXTURE_ID_WARN_TRIANGLE_MODEL = 135;
    public static final int TEXTURE_ID_WARN_TRIANGLE_NIGHT = 137;
    public static final int TEXTURE_ID_WARN_TRIANGLE_SHADOW = 138;
    public static final int TEXTURE_ID_WATER_BARRIER = 132;
    public static final int TEXTURE_ID_WATER_BARRIER_MODEL = 131;
    public static final int TEXTURE_ID_WATER_BARRIER_NIGHT = 133;
    public static final int TEXTURE_ID_WATER_BARRIER_SHADOW = 134;
    private static final L.Tag TAG = new L.Tag("LaneResourceManager");
    private static final AtomicInteger mUpdateTimes = new AtomicInteger(0);
    private static int mOffset = 0;
    private final SparseArray<String> mResourceList = new SparseArray<>();
    private final ILaneResourceProxy mILaneResourceProxy = new ILaneResourceProxy() { // from class: com.xiaopeng.montecarlo.navcore.sr.LaneResourceManager.1
        @Override // com.autonavi.gbl.lane.observer.ILaneResourceProxy
        public LaneResourceResponse onRequestResource(LaneResourceRequest laneResourceRequest) {
            String str;
            LaneResourceResponse laneResourceResponse = new LaneResourceResponse();
            int i = laneResourceRequest.resID;
            if (i <= 0) {
                return laneResourceResponse;
            }
            if (i > 157) {
                i -= LaneResourceManager.mOffset;
                if (L.ENABLE) {
                    L.d(LaneResourceManager.TAG, "ILaneResourceProxy  resID = " + laneResourceRequest.resID + ", mOffset = " + LaneResourceManager.mOffset + " , id = " + i);
                }
                if (!TextUtils.isEmpty((String) LaneResourceManager.this.mResourceList.get(i))) {
                    String str2 = RootUtil.getDataPath() + RootUtil.SD_CARD_DIR_SR_CAR_MODEL_DATA_PATH + File.separator + SettingWrapper.getSRCarModelVersion() + File.separator + str.replace(NavCoreUtil.LANE_CAR_PATH, "");
                    byte[] file2byte = FileUtil.file2byte(str2);
                    if (file2byte == null) {
                        L.w(LaneResourceManager.TAG, "loadDataFromConfigurableResFile data is null resID = " + laneResourceRequest.resID + ", path = " + str2 + " , id = " + i);
                    } else {
                        laneResourceResponse.resource.buffer = new BinaryStream(file2byte);
                        if (L.ENABLE) {
                            L.d(LaneResourceManager.TAG, "loadDataFromConfigurableResFile path = " + str2 + " , id = " + i);
                        }
                        return laneResourceResponse;
                    }
                }
            }
            String str3 = (String) LaneResourceManager.this.mResourceList.get(i);
            if (TextUtils.isEmpty(str3)) {
                L.w(LaneResourceManager.TAG, "mResourceList not contain id " + i);
            } else {
                String str4 = RootUtil.LAN_NAVI_ASSERT_RES_PATH + File.separator + str3;
                byte[] loadDataFromAssets = FileUtil.loadDataFromAssets(str4);
                if (loadDataFromAssets == null && str4.contains(NavCoreUtil.LANE_CAR_PATH)) {
                    str4 = str4.replace(NavCoreUtil.LANE_CAR_PATH, "");
                    if (L.ENABLE) {
                        L.d(LaneResourceManager.TAG, "loadDataFromAssets  fileName = " + str3 + " is not in assets, use default file in " + str4);
                    }
                    loadDataFromAssets = FileUtil.loadDataFromAssets(str4);
                }
                if (loadDataFromAssets == null) {
                    L.w(LaneResourceManager.TAG, "loadDataFromAssets data is null resID = " + i + ", path = " + str4 + " , fileName = " + str3);
                } else {
                    laneResourceResponse.resource.buffer = new BinaryStream(loadDataFromAssets);
                    if (L.ENABLE) {
                        L.d(LaneResourceManager.TAG, "loadDataFromAssets resID = " + i + ", path = " + str4 + " , fileName = " + str3);
                    }
                }
            }
            return laneResourceResponse;
        }

        @Override // com.autonavi.gbl.lane.observer.ILaneResourceProxy
        public LaneResourceResponse onRequestResourceFile(LaneResourceRequestFile laneResourceRequestFile) {
            String str;
            LaneResourceResponse laneResourceResponse = new LaneResourceResponse();
            String str2 = RootUtil.SD_CARD_NAVI_PATH + "/LaneResource/";
            if (laneResourceRequestFile.requestSource == 0) {
                str = str2 + laneResourceRequestFile.resourceFile;
            } else if (laneResourceRequestFile.requestSource == 1) {
                str = str2 + laneResourceRequestFile.resourceFile;
            } else {
                str = str2 + "lane/" + laneResourceRequestFile.resourceFile;
            }
            try {
                byte[] file2byte = FileUtil.file2byte(str);
                int length = file2byte == null ? 0 : file2byte.length;
                L.d(LaneResourceManager.TAG, "path=" + str + ",bufferLen=" + length + ",resFile=" + laneResourceRequestFile.resourceFile + ",requestSource=" + laneResourceRequestFile.requestSource);
                if (length > 0) {
                    laneResourceResponse.resource.buffer = new BinaryStream(file2byte);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return laneResourceResponse;
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getModelResId(int i) {
        if (i != 21) {
            switch (i) {
                case 1:
                    return 33;
                case 2:
                    return -1;
                case 3:
                    return 108;
                case 4:
                    return 82;
                case 5:
                case 9:
                    return 95;
                case 6:
                    return 13;
                case 7:
                    return 46;
                case 8:
                    return 23;
                case 10:
                    return 56;
                case 11:
                    return 69;
                default:
                    switch (i) {
                        case 80:
                            return 127;
                        case 81:
                            return 131;
                        case 82:
                            return 121;
                        default:
                            return -1;
                    }
            }
        }
        return 43;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LaneResourceManager() {
        initRes();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ILaneResourceProxy getILaneResourceProxy() {
        return this.mILaneResourceProxy;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void updateResOffset() {
        mOffset = mUpdateTimes.incrementAndGet() * 11;
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "updateCarStyleInfo mOffset = " + mOffset);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getOffset() {
        return mOffset;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void fillPartsStyle(int i, SRObject sRObject, boolean z) {
        if (sRObject == null) {
            return;
        }
        int i2 = sRObject.srType;
        if (i2 != 21) {
            switch (i2) {
                case 1:
                    fillPersonPartsStyle(i, z, sRObject);
                    return;
                case 2:
                    return;
                case 3:
                    fillSedanPartsStyle(i, z, sRObject);
                    return;
                case 4:
                    fillSUVPartsStyle(i, z, sRObject);
                    return;
                case 5:
                case 9:
                    fillVanPartsStyle(i, z, sRObject);
                    return;
                case 6:
                    fillBicyclePartsStyle(i, z, sRObject);
                    return;
                case 7:
                    fillTricyclePartsStyle(i, z, sRObject);
                    return;
                case 8:
                    fillMotorcyclePartsStyle(i, z, sRObject);
                    return;
                case 10:
                    fillBusPartsStyle(i, z, sRObject);
                    return;
                case 11:
                    fillPickupPartsStyle(i, z, sRObject);
                    return;
                default:
                    switch (i2) {
                        case 80:
                            fillDrumPartsStyle(z, sRObject);
                            return;
                        case 81:
                            fillWaterBarrierPartsStyle(z, sRObject);
                            return;
                        case 82:
                            fillTrafficConePartsStyle(z, sRObject);
                            return;
                        default:
                            return;
                    }
            }
        }
        fillPolicePartsStyle(i, z, sRObject);
    }

    private void initRes() {
        this.mResourceList.put(1, "Decision/Texture/Waiting_day.png");
        this.mResourceList.put(2, "Decision/Texture/Waiting_night.png");
        this.mResourceList.put(3, "Decision/Texture/TargetLane_day.png");
        this.mResourceList.put(4, "Decision/Texture/TargetLane_night.png");
        this.mResourceList.put(5, "Decision/Texture/GuideLine_day.png");
        this.mResourceList.put(6, "Decision/Texture/GuideLine_night.png");
        this.mResourceList.put(7, "Decision/Texture/Outline_day.png");
        this.mResourceList.put(8, "Decision/Texture/Outline_night.png");
        this.mResourceList.put(9, "Decision/Texture/TargetLocation_day.png");
        this.mResourceList.put(10, "Decision/Texture/TargetLocation_night.png");
        this.mResourceList.put(11, "Decision/Texture/LCC_day.png");
        this.mResourceList.put(12, "Decision/Texture/LCC_night.png");
        this.mResourceList.put(13, "HumanAnimal/Bicycle/Bicycle.ske");
        this.mResourceList.put(14, "HumanAnimal/Bicycle/Texture/Bic_1.png");
        this.mResourceList.put(15, "HumanAnimal/Bicycle/Texture/Bic_2.png");
        this.mResourceList.put(16, "HumanAnimal/Bicycle/Texture/Bic_9.png");
        this.mResourceList.put(17, "HumanAnimal/Bicycle/Texture/Bic_10.png");
        this.mResourceList.put(18, "HumanAnimal/Bicycle/Texture/Bic_7.png");
        this.mResourceList.put(19, "HumanAnimal/Bicycle/Texture/Bic_8.png");
        this.mResourceList.put(20, "HumanAnimal/Bicycle/Texture/Bic_13.png");
        this.mResourceList.put(21, "HumanAnimal/Bicycle/Texture/Bic_14.png");
        this.mResourceList.put(22, "HumanAnimal/Bicycle/Texture/Bic_Shadow.png");
        this.mResourceList.put(23, "HumanAnimal/Motorcycle/Motorcycle.ske");
        this.mResourceList.put(24, "HumanAnimal/Motorcycle/Texture/Mot_1.png");
        this.mResourceList.put(25, "HumanAnimal/Motorcycle/Texture/Mot_2.png");
        this.mResourceList.put(26, "HumanAnimal/Motorcycle/Texture/Mot_9.png");
        this.mResourceList.put(27, "HumanAnimal/Motorcycle/Texture/Mot_10.png");
        this.mResourceList.put(28, "HumanAnimal/Motorcycle/Texture/Mot_7.png");
        this.mResourceList.put(29, "HumanAnimal/Motorcycle/Texture/Mot_8.png");
        this.mResourceList.put(30, "HumanAnimal/Motorcycle/Texture/Mot_13.png");
        this.mResourceList.put(31, "HumanAnimal/Motorcycle/Texture/Mot_14.png");
        this.mResourceList.put(32, "HumanAnimal/Motorcycle/Texture/Mot_Shadow.png");
        this.mResourceList.put(33, "HumanAnimal/Pedestrian/Pedestrian.ske");
        this.mResourceList.put(34, "HumanAnimal/Pedestrian/Texture/Ped_1.png");
        this.mResourceList.put(35, "HumanAnimal/Pedestrian/Texture/Ped_2.png");
        this.mResourceList.put(36, "HumanAnimal/Pedestrian/Texture/Ped_9.png");
        this.mResourceList.put(37, "HumanAnimal/Pedestrian/Texture/Ped_10.png");
        this.mResourceList.put(38, "HumanAnimal/Pedestrian/Texture/Ped_7.png");
        this.mResourceList.put(39, "HumanAnimal/Pedestrian/Texture/Ped_8.png");
        this.mResourceList.put(40, "HumanAnimal/Pedestrian/Texture/Ped_13.png");
        this.mResourceList.put(41, "HumanAnimal/Pedestrian/Texture/Ped_14.png");
        this.mResourceList.put(42, "HumanAnimal/Pedestrian/Texture/Ped_Shadow.png");
        this.mResourceList.put(43, "HumanAnimal/Police/Police.ske");
        this.mResourceList.put(44, "HumanAnimal/Police/Texture/Police.png");
        this.mResourceList.put(45, "HumanAnimal/Police/Texture/Police_Shadow.png");
        this.mResourceList.put(46, "HumanAnimal/Tricycle/Tricycle.ske");
        this.mResourceList.put(47, "HumanAnimal/Tricycle/Texture/Tri_1.png");
        this.mResourceList.put(48, "HumanAnimal/Tricycle/Texture/Tri_2.png");
        this.mResourceList.put(49, "HumanAnimal/Tricycle/Texture/Tri_9.png");
        this.mResourceList.put(50, "HumanAnimal/Tricycle/Texture/Tri_10.png");
        this.mResourceList.put(51, "HumanAnimal/Tricycle/Texture/Tri_7.png");
        this.mResourceList.put(52, "HumanAnimal/Tricycle/Texture/Tri_8.png");
        this.mResourceList.put(53, "HumanAnimal/Tricycle/Texture/Tri_13.png");
        this.mResourceList.put(54, "HumanAnimal/Tricycle/Texture/Tri_14.png");
        this.mResourceList.put(55, "HumanAnimal/Tricycle/Texture/Tri_Shadow.png");
        this.mResourceList.put(56, "CarAround/BUS/BUS.ske");
        this.mResourceList.put(57, "CarAround/BUS/Texture/CA_Main_1.png");
        this.mResourceList.put(58, "CarAround/BUS/Texture/CA_Main_2.png");
        this.mResourceList.put(59, "CarAround/BUS/Texture/CA_Main_9.png");
        this.mResourceList.put(60, "CarAround/BUS/Texture/CA_Main_10.png");
        this.mResourceList.put(61, "CarAround/BUS/Texture/CA_Main_7.png");
        this.mResourceList.put(62, "CarAround/BUS/Texture/CA_Main_8.png");
        this.mResourceList.put(63, "CarAround/BUS/Texture/CA_Main_13.png");
        this.mResourceList.put(64, "CarAround/BUS/Texture/CA_Main_14.png");
        this.mResourceList.put(65, "CarAround/BUS/Texture/CA_Shadow.png");
        this.mResourceList.put(66, "CarAround/BUS/Texture/CA_LDirection.png");
        this.mResourceList.put(67, "CarAround/BUS/Texture/CA_RDirection.png");
        this.mResourceList.put(68, "CarAround/BUS/Texture/CA_Stop.png");
        this.mResourceList.put(69, "CarAround/Pickup/Pickup.ske");
        this.mResourceList.put(70, "CarAround/Pickup/Texture/CA_Main_1.png");
        this.mResourceList.put(71, "CarAround/Pickup/Texture/CA_Main_2.png");
        this.mResourceList.put(72, "CarAround/Pickup/Texture/CA_Main_9.png");
        this.mResourceList.put(73, "CarAround/Pickup/Texture/CA_Main_10.png");
        this.mResourceList.put(74, "CarAround/Pickup/Texture/CA_Main_7.png");
        this.mResourceList.put(75, "CarAround/Pickup/Texture/CA_Main_8.png");
        this.mResourceList.put(76, "CarAround/Pickup/Texture/CA_Main_13.png");
        this.mResourceList.put(77, "CarAround/Pickup/Texture/CA_Main_14.png");
        this.mResourceList.put(78, "CarAround/Pickup/Texture/CA_Shadow.png");
        this.mResourceList.put(79, "CarAround/Pickup/Texture/CA_LDirection.png");
        this.mResourceList.put(80, "CarAround/Pickup/Texture/CA_RDirection.png");
        this.mResourceList.put(81, "CarAround/Pickup/Texture/CA_Stop.png");
        this.mResourceList.put(82, "CarAround/SUV/SUV.ske");
        this.mResourceList.put(83, "CarAround/SUV/Texture/CA_Main_1.png");
        this.mResourceList.put(84, "CarAround/SUV/Texture/CA_Main_2.png");
        this.mResourceList.put(85, "CarAround/SUV/Texture/CA_Main_9.png");
        this.mResourceList.put(86, "CarAround/SUV/Texture/CA_Main_10.png");
        this.mResourceList.put(87, "CarAround/SUV/Texture/CA_Main_7.png");
        this.mResourceList.put(88, "CarAround/SUV/Texture/CA_Main_8.png");
        this.mResourceList.put(89, "CarAround/SUV/Texture/CA_Main_13.png");
        this.mResourceList.put(90, "CarAround/SUV/Texture/CA_Main_14.png");
        this.mResourceList.put(91, "CarAround/SUV/Texture/CA_Shadow.png");
        this.mResourceList.put(92, "CarAround/SUV/Texture/CA_LDirection.png");
        this.mResourceList.put(93, "CarAround/SUV/Texture/CA_RDirection.png");
        this.mResourceList.put(94, "CarAround/SUV/Texture/CA_Stop.png");
        this.mResourceList.put(95, "CarAround/VAN/VAN.ske");
        this.mResourceList.put(96, "CarAround/VAN/Texture/CA_Main_1.png");
        this.mResourceList.put(97, "CarAround/VAN/Texture/CA_Main_2.png");
        this.mResourceList.put(98, "CarAround/VAN/Texture/CA_Main_9.png");
        this.mResourceList.put(99, "CarAround/VAN/Texture/CA_Main_10.png");
        this.mResourceList.put(100, "CarAround/VAN/Texture/CA_Main_7.png");
        this.mResourceList.put(101, "CarAround/VAN/Texture/CA_Main_8.png");
        this.mResourceList.put(102, "CarAround/VAN/Texture/CA_Main_13.png");
        this.mResourceList.put(103, "CarAround/VAN/Texture/CA_Main_14.png");
        this.mResourceList.put(104, "CarAround/VAN/Texture/CA_Shadow.png");
        this.mResourceList.put(105, "CarAround/VAN/Texture/CA_LDirection.png");
        this.mResourceList.put(106, "CarAround/VAN/Texture/CA_RDirection.png");
        this.mResourceList.put(107, "CarAround/VAN/Texture/CA_Stop.png");
        this.mResourceList.put(108, "CarAround/Sedan/Sedan.ske");
        this.mResourceList.put(109, "CarAround/Sedan/Texture/CA_Main_1.png");
        this.mResourceList.put(110, "CarAround/Sedan/Texture/CA_Main_2.png");
        this.mResourceList.put(111, "CarAround/Sedan/Texture/CA_Main_9.png");
        this.mResourceList.put(112, "CarAround/Sedan/Texture/CA_Main_10.png");
        this.mResourceList.put(113, "CarAround/Sedan/Texture/CA_Main_7.png");
        this.mResourceList.put(114, "CarAround/Sedan/Texture/CA_Main_8.png");
        this.mResourceList.put(115, "CarAround/Sedan/Texture/CA_Main_13.png");
        this.mResourceList.put(116, "CarAround/Sedan/Texture/CA_Main_14.png");
        this.mResourceList.put(117, "CarAround/Sedan/Texture/CA_Shadow.png");
        this.mResourceList.put(118, "CarAround/Sedan/Texture/CA_LDirection.png");
        this.mResourceList.put(119, "CarAround/Sedan/Texture/CA_RDirection.png");
        this.mResourceList.put(120, "CarAround/Sedan/Texture/CA_Stop.png");
        this.mResourceList.put(121, "StaticTrafficFacilities/TrafficCone/TrafficCone.ske");
        this.mResourceList.put(122, "StaticTrafficFacilities/TrafficCone/Texture/TrafficCone_13.png");
        this.mResourceList.put(123, "StaticTrafficFacilities/TrafficCone/Texture/TrafficCone_14.png");
        this.mResourceList.put(124, "StaticTrafficFacilities/TrafficCone/Texture/TrafficCone_11.png");
        this.mResourceList.put(125, "StaticTrafficFacilities/TrafficCone/Texture/TrafficCone_12.png");
        this.mResourceList.put(127, "StaticTrafficFacilities/Drum/Drum.ske");
        this.mResourceList.put(128, "StaticTrafficFacilities/Drum/Texture/Drum_1.png");
        this.mResourceList.put(129, "StaticTrafficFacilities/Drum/Texture/Drum_2.png");
        this.mResourceList.put(130, "StaticTrafficFacilities/Drum/Texture/Drum_Shadow.png");
        this.mResourceList.put(131, "StaticTrafficFacilities/WaterBarrier/WaterBarrier.ske");
        this.mResourceList.put(132, "StaticTrafficFacilities/WaterBarrier/Texture/WaterBarrier.png");
        this.mResourceList.put(133, "StaticTrafficFacilities/WaterBarrier/Texture/WaterBarrier.png");
        this.mResourceList.put(134, "StaticTrafficFacilities/WaterBarrier/Texture/WaterBarrier_Shadow.png");
        this.mResourceList.put(135, "StaticTrafficFacilities/WarnTriangle/WarnTriangle.ske");
        this.mResourceList.put(136, "StaticTrafficFacilities/WarnTriangle/Texture/WarnTriangle.png");
        this.mResourceList.put(137, "StaticTrafficFacilities/WarnTriangle/Texture/WarnTriangle.png");
        this.mResourceList.put(138, "StaticTrafficFacilities/WarnTriangle/Texture/WarnTriangle_Shadow.png");
        this.mResourceList.put(139, "Warning/Warning.ske");
        this.mResourceList.put(140, "Warning/Texture/Warn_F_1.png");
        this.mResourceList.put(141, "Warning/Texture/Warn_F_2.png");
        this.mResourceList.put(142, "Warning/Texture/Warn_F_3.png");
        this.mResourceList.put(143, "Warning/Texture/Warn_F_4.png");
        this.mResourceList.put(144, "Warning/Texture/Warn_B_1.png");
        this.mResourceList.put(145, "Warning/Texture/Warn_B_2.png");
        this.mResourceList.put(146, "Warning/Texture/Warn_LB_1.png");
        this.mResourceList.put(147, "Warning/Texture/Warn_LB_2.png");
        this.mResourceList.put(148, "Warning/Texture/Warn_LB_3.png");
        this.mResourceList.put(149, "Warning/Texture/Warn_LB_4.png");
        this.mResourceList.put(150, "Warning/Texture/Warn_RB_1.png");
        this.mResourceList.put(151, "Warning/Texture/Warn_RB_2.png");
        this.mResourceList.put(152, "Warning/Texture/Warn_RB_3.png");
        this.mResourceList.put(153, "Warning/Texture/Warn_RB_4.png");
        this.mResourceList.put(154, "Decision/Texture/LDW_day.png");
        this.mResourceList.put(155, "Decision/Texture/LDW_night.png");
        this.mResourceList.put(156, "Decision/Texture/LKA_day.png");
        this.mResourceList.put(157, "Decision/Texture/LKA_night.png");
        this.mResourceList.put(158, "CarSelf.ske");
        SparseArray<String> sparseArray = this.mResourceList;
        sparseArray.put(159, "Texture" + NavCoreUtil.LANE_CAR_PATH + "/CarSelf_Main.png");
        SparseArray<String> sparseArray2 = this.mResourceList;
        sparseArray2.put(160, "Texture" + NavCoreUtil.LANE_CAR_PATH + "/CarSelf_Main_night.png");
        this.mResourceList.put(161, "Texture/CS_Shadow_1.png");
        this.mResourceList.put(162, "Texture/CS_Shadow_2.png");
        this.mResourceList.put(163, "Texture/CS_LDirection.png");
        this.mResourceList.put(164, "Texture/CS_RDirection.png");
        this.mResourceList.put(165, "Texture/CS_Emergency.png");
        this.mResourceList.put(166, "Texture/CS_Stop.png");
        this.mResourceList.put(167, "Texture/CS_Lower.png");
        this.mResourceList.put(168, "Texture/CS_High.png");
    }

    private void fillSedanPartsStyle(int i, boolean z, SRObject sRObject) {
        fillCommonPartsStyle(i != 3 ? (i == 4 || i == 5) ? z ? 111 : 112 : i != 6 ? z ? 109 : 110 : z ? 113 : 114 : z ? 115 : 116, 117, -1, -1, sRObject);
    }

    private void fillSUVPartsStyle(int i, boolean z, SRObject sRObject) {
        fillCommonPartsStyle(i != 3 ? (i == 4 || i == 5) ? z ? 85 : 86 : i != 6 ? z ? 83 : 84 : z ? 87 : 88 : z ? 89 : 90, 91, -1, -1, sRObject);
    }

    private void fillVanPartsStyle(int i, boolean z, SRObject sRObject) {
        fillCommonPartsStyle(i != 3 ? (i == 4 || i == 5) ? z ? 98 : 99 : i != 6 ? z ? 96 : 97 : z ? 100 : 101 : z ? 102 : 103, 104, -1, -1, sRObject);
    }

    private void fillBusPartsStyle(int i, boolean z, SRObject sRObject) {
        fillCommonPartsStyle(i != 3 ? (i == 4 || i == 5) ? z ? 59 : 60 : i != 6 ? z ? 57 : 58 : z ? 61 : 62 : z ? 63 : 64, 65, -1, -1, sRObject);
    }

    private void fillPickupPartsStyle(int i, boolean z, SRObject sRObject) {
        fillCommonPartsStyle(i != 3 ? (i == 4 || i == 5) ? z ? 72 : 73 : i != 6 ? z ? 70 : 71 : z ? 74 : 75 : z ? 76 : 77, 78, -1, -1, sRObject);
    }

    private void fillCommonPartsStyle(int i, int i2, int i3, int i4, SRObject sRObject) {
        SRPartsStyle sRPartsStyle = new SRPartsStyle();
        sRPartsStyle.name = LaneModelDtoConstants.PARTS_CAR_AROUND_MAIN;
        sRPartsStyle.textureId = i;
        sRObject.partsStyle.add(sRPartsStyle);
        SRPartsStyle sRPartsStyle2 = new SRPartsStyle();
        sRPartsStyle2.name = LaneModelDtoConstants.PARTS_CAR_AROUND_LAMP_LEFT;
        sRPartsStyle2.textureId = i3;
        sRObject.partsStyle.add(sRPartsStyle2);
        SRPartsStyle sRPartsStyle3 = new SRPartsStyle();
        sRPartsStyle3.name = LaneModelDtoConstants.PARTS_CAR_AROUND_LAMP_RIGHT;
        sRPartsStyle3.textureId = i4;
        sRObject.partsStyle.add(sRPartsStyle3);
        SRPartsStyle sRPartsStyle4 = new SRPartsStyle();
        sRPartsStyle4.name = LaneModelDtoConstants.PARTS_CAR_AROUND_SHADOW;
        sRPartsStyle4.textureId = i2;
        sRObject.partsStyle.add(sRPartsStyle4);
    }

    private void fillPersonPartsStyle(int i, boolean z, SRObject sRObject) {
        int i2 = i != 3 ? (i == 4 || i == 5) ? z ? 36 : 37 : i != 6 ? z ? 34 : 35 : z ? 38 : 39 : z ? 40 : 41;
        SRPartsStyle sRPartsStyle = new SRPartsStyle();
        sRPartsStyle.name = LaneModelDtoConstants.PARTS_PEDESTRIAN_MAIN;
        sRPartsStyle.textureId = i2;
        sRObject.partsStyle.add(sRPartsStyle);
        SRPartsStyle sRPartsStyle2 = new SRPartsStyle();
        sRPartsStyle2.name = LaneModelDtoConstants.PARTS_PEDESTRIAN_SHADOW;
        sRPartsStyle2.textureId = 42;
        sRObject.partsStyle.add(sRPartsStyle2);
    }

    private void fillBicyclePartsStyle(int i, boolean z, SRObject sRObject) {
        int i2 = i != 3 ? (i == 4 || i == 5) ? z ? 16 : 17 : i != 6 ? z ? 14 : 15 : z ? 18 : 19 : z ? 20 : 21;
        SRPartsStyle sRPartsStyle = new SRPartsStyle();
        sRPartsStyle.name = LaneModelDtoConstants.PARTS_BICYCLE_BODY;
        sRPartsStyle.textureId = i2;
        sRObject.partsStyle.add(sRPartsStyle);
        SRPartsStyle sRPartsStyle2 = new SRPartsStyle();
        sRPartsStyle2.name = LaneModelDtoConstants.PARTS_BICYCLE_HUMAN;
        sRPartsStyle2.textureId = i2;
        sRObject.partsStyle.add(sRPartsStyle2);
        SRPartsStyle sRPartsStyle3 = new SRPartsStyle();
        sRPartsStyle3.name = LaneModelDtoConstants.PARTS_BICYCLE_WHEEL_FRONT;
        sRPartsStyle3.textureId = i2;
        sRObject.partsStyle.add(sRPartsStyle3);
        SRPartsStyle sRPartsStyle4 = new SRPartsStyle();
        sRPartsStyle4.name = LaneModelDtoConstants.PARTS_BICYCLE_WHEEL_BEHIND;
        sRPartsStyle4.textureId = i2;
        sRObject.partsStyle.add(sRPartsStyle4);
        SRPartsStyle sRPartsStyle5 = new SRPartsStyle();
        sRPartsStyle5.name = LaneModelDtoConstants.PARTS_BICYCLE_SHADOW;
        sRPartsStyle5.textureId = 22;
        sRObject.partsStyle.add(sRPartsStyle5);
    }

    private void fillTricyclePartsStyle(int i, boolean z, SRObject sRObject) {
        int i2 = i != 3 ? (i == 4 || i == 5) ? z ? 49 : 50 : i != 6 ? z ? 47 : 48 : z ? 51 : 52 : z ? 53 : 54;
        SRPartsStyle sRPartsStyle = new SRPartsStyle();
        sRPartsStyle.name = LaneModelDtoConstants.PARTS_TRICYCLE_BODY;
        sRPartsStyle.textureId = i2;
        sRObject.partsStyle.add(sRPartsStyle);
        SRPartsStyle sRPartsStyle2 = new SRPartsStyle();
        sRPartsStyle2.name = LaneModelDtoConstants.PARTS_TRICYCLE_HUMAN;
        sRPartsStyle2.textureId = i2;
        sRObject.partsStyle.add(sRPartsStyle2);
        SRPartsStyle sRPartsStyle3 = new SRPartsStyle();
        sRPartsStyle3.name = LaneModelDtoConstants.PARTS_TRICYCLE_WHEEL_FRONT;
        sRPartsStyle3.textureId = i2;
        sRObject.partsStyle.add(sRPartsStyle3);
        SRPartsStyle sRPartsStyle4 = new SRPartsStyle();
        sRPartsStyle4.name = LaneModelDtoConstants.PARTS_TRICYCLE_WHEEL_BEHIND;
        sRPartsStyle4.textureId = i2;
        sRObject.partsStyle.add(sRPartsStyle4);
        SRPartsStyle sRPartsStyle5 = new SRPartsStyle();
        sRPartsStyle5.name = LaneModelDtoConstants.PARTS_TRICYCLE_SHADOW;
        sRPartsStyle5.textureId = 55;
        sRObject.partsStyle.add(sRPartsStyle5);
    }

    private void fillMotorcyclePartsStyle(int i, boolean z, SRObject sRObject) {
        int i2 = i != 3 ? (i == 4 || i == 5) ? z ? 26 : 27 : i != 6 ? z ? 24 : 25 : z ? 28 : 29 : z ? 30 : 31;
        SRPartsStyle sRPartsStyle = new SRPartsStyle();
        sRPartsStyle.name = LaneModelDtoConstants.PARTS_MOTOCYCLE_BODY;
        sRPartsStyle.textureId = i2;
        sRObject.partsStyle.add(sRPartsStyle);
        SRPartsStyle sRPartsStyle2 = new SRPartsStyle();
        sRPartsStyle2.name = LaneModelDtoConstants.PARTS_MOTOCYCLE_HUMAN;
        sRPartsStyle2.textureId = i2;
        sRObject.partsStyle.add(sRPartsStyle2);
        SRPartsStyle sRPartsStyle3 = new SRPartsStyle();
        sRPartsStyle3.name = LaneModelDtoConstants.PARTS_MOTOCYCLE_WHEEL_FRONT;
        sRPartsStyle3.textureId = i2;
        sRObject.partsStyle.add(sRPartsStyle3);
        SRPartsStyle sRPartsStyle4 = new SRPartsStyle();
        sRPartsStyle4.name = LaneModelDtoConstants.PARTS_MOTOCYCLE_WHEEL_BACK;
        sRPartsStyle4.textureId = i2;
        sRObject.partsStyle.add(sRPartsStyle4);
        SRPartsStyle sRPartsStyle5 = new SRPartsStyle();
        sRPartsStyle5.name = LaneModelDtoConstants.PARTS_MOTOCYCLE_SHADOW;
        sRPartsStyle5.textureId = 32;
        sRObject.partsStyle.add(sRPartsStyle5);
    }

    private void fillPolicePartsStyle(int i, boolean z, SRObject sRObject) {
        SRPartsStyle sRPartsStyle = new SRPartsStyle();
        sRPartsStyle.name = LaneModelDtoConstants.PARTS_POLICE_MAIN;
        sRPartsStyle.textureId = 44;
        sRObject.partsStyle.add(sRPartsStyle);
        SRPartsStyle sRPartsStyle2 = new SRPartsStyle();
        sRPartsStyle2.name = LaneModelDtoConstants.PARTS_POLICE_SHADOW;
        sRPartsStyle2.textureId = 45;
        sRObject.partsStyle.add(sRPartsStyle2);
    }

    private void fillDrumPartsStyle(boolean z, SRObject sRObject) {
        int i = z ? 128 : 129;
        SRPartsStyle sRPartsStyle = new SRPartsStyle();
        sRPartsStyle.name = LaneModelDtoConstants.PARTS_DRUM_MAIN;
        sRPartsStyle.textureId = i;
        sRObject.partsStyle.add(sRPartsStyle);
        SRPartsStyle sRPartsStyle2 = new SRPartsStyle();
        sRPartsStyle2.name = LaneModelDtoConstants.PARTS_DRUM_SHADOW;
        sRPartsStyle2.textureId = 130;
        sRObject.partsStyle.add(sRPartsStyle2);
    }

    private void fillWaterBarrierPartsStyle(boolean z, SRObject sRObject) {
        int i = z ? 132 : 133;
        SRPartsStyle sRPartsStyle = new SRPartsStyle();
        sRPartsStyle.name = LaneModelDtoConstants.PARTS_BARRICADE_MAIN;
        sRPartsStyle.textureId = i;
        sRObject.partsStyle.add(sRPartsStyle);
        SRPartsStyle sRPartsStyle2 = new SRPartsStyle();
        sRPartsStyle2.name = LaneModelDtoConstants.PARTS_BARRICADE_SHADOW;
        sRPartsStyle2.textureId = 134;
        sRObject.partsStyle.add(sRPartsStyle2);
    }

    private void fillTrafficConePartsStyle(boolean z, SRObject sRObject) {
        int i = z ? 122 : 123;
        SRPartsStyle sRPartsStyle = new SRPartsStyle();
        sRPartsStyle.name = LaneModelDtoConstants.PARTS_TRAFFIC_CONE_MAIN;
        sRPartsStyle.textureId = i;
        sRObject.partsStyle.add(sRPartsStyle);
    }
}
