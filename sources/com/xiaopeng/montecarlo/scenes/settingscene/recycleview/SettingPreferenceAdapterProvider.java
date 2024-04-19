package com.xiaopeng.montecarlo.scenes.settingscene.recycleview;

import com.xiaopeng.montecarlo.navcore.setting.constant.MinimapTypeEnum;
import com.xiaopeng.montecarlo.navcore.setting.constant.NaviBroadcastTypeEnum;
/* loaded from: classes3.dex */
public class SettingPreferenceAdapterProvider {
    public String mInternetUnityMapContent;
    public String mLaneMapContent;
    public String mPublicationUnityMapContent;
    private boolean mIsAvoidCongestionEnable = false;
    private boolean mIsAvoidChargeEnable = false;
    private boolean mIsNoFreewaysEnable = false;
    private boolean mIsHighwayPriorityEnable = false;
    private NaviBroadcastTypeEnum mNaviBroadcastType = NaviBroadcastTypeEnum.NAVI_NORMAL_BROADCAST;
    private MinimapTypeEnum mMinimapTypeEnum = MinimapTypeEnum.MINIMAP_MAPMODE_3D_CAR;
    private boolean mIsCruiseAheadTrafficEnable = false;
    private boolean mIsCruiseSafetyBroadcastEnable = false;
    private boolean mIsCruiseElectronicEyeBroadcastEnable = false;
    private String mCarLogoHintTitle = "";
    private int mCurrentCarLogoSrc = -1;
    private boolean mIsRouteRadarEnable = true;
    private boolean mIsAvoidRestrictionRouteEnable = false;
    private String mLicensePlate = "";
    private boolean mIsChargingStationDisplayEnable = true;
    private boolean mIsRealTimeTrafficEnable = true;
    private boolean mIsScratchSpotEnable = true;
    private boolean mIsMapDynamicLevelEnable = true;
    private boolean mIsRecommendParkEnable = true;
    private boolean mIsXPAccountLoginIn = false;
    private boolean mIsAMapBinded = false;
    private long mMapDownloadSize = 0;
    private boolean mIsMapDataAutoUpdateEnable = false;
    private String mMapVersion = "";
    private String mMapVersionDescription = "";

    protected boolean canEqual(Object obj) {
        return obj instanceof SettingPreferenceAdapterProvider;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof SettingPreferenceAdapterProvider) {
            SettingPreferenceAdapterProvider settingPreferenceAdapterProvider = (SettingPreferenceAdapterProvider) obj;
            if (settingPreferenceAdapterProvider.canEqual(this) && isAvoidCongestionEnable() == settingPreferenceAdapterProvider.isAvoidCongestionEnable() && isAvoidChargeEnable() == settingPreferenceAdapterProvider.isAvoidChargeEnable() && isNoFreewaysEnable() == settingPreferenceAdapterProvider.isNoFreewaysEnable() && isHighwayPriorityEnable() == settingPreferenceAdapterProvider.isHighwayPriorityEnable() && isCruiseAheadTrafficEnable() == settingPreferenceAdapterProvider.isCruiseAheadTrafficEnable() && isCruiseSafetyBroadcastEnable() == settingPreferenceAdapterProvider.isCruiseSafetyBroadcastEnable() && isCruiseElectronicEyeBroadcastEnable() == settingPreferenceAdapterProvider.isCruiseElectronicEyeBroadcastEnable() && getCurrentCarLogoSrc() == settingPreferenceAdapterProvider.getCurrentCarLogoSrc() && isRouteRadarEnable() == settingPreferenceAdapterProvider.isRouteRadarEnable() && isAvoidRestrictionRouteEnable() == settingPreferenceAdapterProvider.isAvoidRestrictionRouteEnable() && isChargingStationDisplayEnable() == settingPreferenceAdapterProvider.isChargingStationDisplayEnable() && isRealTimeTrafficEnable() == settingPreferenceAdapterProvider.isRealTimeTrafficEnable() && isScratchSpotEnable() == settingPreferenceAdapterProvider.isScratchSpotEnable() && isMapDynamicLevelEnable() == settingPreferenceAdapterProvider.isMapDynamicLevelEnable() && isRecommendParkEnable() == settingPreferenceAdapterProvider.isRecommendParkEnable() && isXPAccountLoginIn() == settingPreferenceAdapterProvider.isXPAccountLoginIn() && isAMapBinded() == settingPreferenceAdapterProvider.isAMapBinded() && getMapDownloadSize() == settingPreferenceAdapterProvider.getMapDownloadSize() && isMapDataAutoUpdateEnable() == settingPreferenceAdapterProvider.isMapDataAutoUpdateEnable()) {
                NaviBroadcastTypeEnum naviBroadcastType = getNaviBroadcastType();
                NaviBroadcastTypeEnum naviBroadcastType2 = settingPreferenceAdapterProvider.getNaviBroadcastType();
                if (naviBroadcastType != null ? naviBroadcastType.equals(naviBroadcastType2) : naviBroadcastType2 == null) {
                    MinimapTypeEnum minimapTypeEnum = getMinimapTypeEnum();
                    MinimapTypeEnum minimapTypeEnum2 = settingPreferenceAdapterProvider.getMinimapTypeEnum();
                    if (minimapTypeEnum != null ? minimapTypeEnum.equals(minimapTypeEnum2) : minimapTypeEnum2 == null) {
                        String carLogoHintTitle = getCarLogoHintTitle();
                        String carLogoHintTitle2 = settingPreferenceAdapterProvider.getCarLogoHintTitle();
                        if (carLogoHintTitle != null ? carLogoHintTitle.equals(carLogoHintTitle2) : carLogoHintTitle2 == null) {
                            String licensePlate = getLicensePlate();
                            String licensePlate2 = settingPreferenceAdapterProvider.getLicensePlate();
                            if (licensePlate != null ? licensePlate.equals(licensePlate2) : licensePlate2 == null) {
                                String mapVersion = getMapVersion();
                                String mapVersion2 = settingPreferenceAdapterProvider.getMapVersion();
                                if (mapVersion != null ? mapVersion.equals(mapVersion2) : mapVersion2 == null) {
                                    String mapVersionDescription = getMapVersionDescription();
                                    String mapVersionDescription2 = settingPreferenceAdapterProvider.getMapVersionDescription();
                                    if (mapVersionDescription != null ? mapVersionDescription.equals(mapVersionDescription2) : mapVersionDescription2 == null) {
                                        String publicationUnityMapContent = getPublicationUnityMapContent();
                                        String publicationUnityMapContent2 = settingPreferenceAdapterProvider.getPublicationUnityMapContent();
                                        if (publicationUnityMapContent != null ? publicationUnityMapContent.equals(publicationUnityMapContent2) : publicationUnityMapContent2 == null) {
                                            String internetUnityMapContent = getInternetUnityMapContent();
                                            String internetUnityMapContent2 = settingPreferenceAdapterProvider.getInternetUnityMapContent();
                                            if (internetUnityMapContent != null ? internetUnityMapContent.equals(internetUnityMapContent2) : internetUnityMapContent2 == null) {
                                                String laneMapContent = getLaneMapContent();
                                                String laneMapContent2 = settingPreferenceAdapterProvider.getLaneMapContent();
                                                return laneMapContent != null ? laneMapContent.equals(laneMapContent2) : laneMapContent2 == null;
                                            }
                                            return false;
                                        }
                                        return false;
                                    }
                                    return false;
                                }
                                return false;
                            }
                            return false;
                        }
                        return false;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        int currentCarLogoSrc = (((((((((((((((((((((((((((((((((isAvoidCongestionEnable() ? 79 : 97) + 59) * 59) + (isAvoidChargeEnable() ? 79 : 97)) * 59) + (isNoFreewaysEnable() ? 79 : 97)) * 59) + (isHighwayPriorityEnable() ? 79 : 97)) * 59) + (isCruiseAheadTrafficEnable() ? 79 : 97)) * 59) + (isCruiseSafetyBroadcastEnable() ? 79 : 97)) * 59) + (isCruiseElectronicEyeBroadcastEnable() ? 79 : 97)) * 59) + getCurrentCarLogoSrc()) * 59) + (isRouteRadarEnable() ? 79 : 97)) * 59) + (isAvoidRestrictionRouteEnable() ? 79 : 97)) * 59) + (isChargingStationDisplayEnable() ? 79 : 97)) * 59) + (isRealTimeTrafficEnable() ? 79 : 97)) * 59) + (isScratchSpotEnable() ? 79 : 97)) * 59) + (isMapDynamicLevelEnable() ? 79 : 97)) * 59) + (isRecommendParkEnable() ? 79 : 97)) * 59) + (isXPAccountLoginIn() ? 79 : 97)) * 59) + (isAMapBinded() ? 79 : 97);
        long mapDownloadSize = getMapDownloadSize();
        int i = (((currentCarLogoSrc * 59) + ((int) (mapDownloadSize ^ (mapDownloadSize >>> 32)))) * 59) + (isMapDataAutoUpdateEnable() ? 79 : 97);
        NaviBroadcastTypeEnum naviBroadcastType = getNaviBroadcastType();
        int hashCode = (i * 59) + (naviBroadcastType == null ? 43 : naviBroadcastType.hashCode());
        MinimapTypeEnum minimapTypeEnum = getMinimapTypeEnum();
        int hashCode2 = (hashCode * 59) + (minimapTypeEnum == null ? 43 : minimapTypeEnum.hashCode());
        String carLogoHintTitle = getCarLogoHintTitle();
        int hashCode3 = (hashCode2 * 59) + (carLogoHintTitle == null ? 43 : carLogoHintTitle.hashCode());
        String licensePlate = getLicensePlate();
        int hashCode4 = (hashCode3 * 59) + (licensePlate == null ? 43 : licensePlate.hashCode());
        String mapVersion = getMapVersion();
        int hashCode5 = (hashCode4 * 59) + (mapVersion == null ? 43 : mapVersion.hashCode());
        String mapVersionDescription = getMapVersionDescription();
        int hashCode6 = (hashCode5 * 59) + (mapVersionDescription == null ? 43 : mapVersionDescription.hashCode());
        String publicationUnityMapContent = getPublicationUnityMapContent();
        int hashCode7 = (hashCode6 * 59) + (publicationUnityMapContent == null ? 43 : publicationUnityMapContent.hashCode());
        String internetUnityMapContent = getInternetUnityMapContent();
        int hashCode8 = (hashCode7 * 59) + (internetUnityMapContent == null ? 43 : internetUnityMapContent.hashCode());
        String laneMapContent = getLaneMapContent();
        return (hashCode8 * 59) + (laneMapContent != null ? laneMapContent.hashCode() : 43);
    }

    public void setAMapBinded(boolean z) {
        this.mIsAMapBinded = z;
    }

    public void setAvoidChargeEnable(boolean z) {
        this.mIsAvoidChargeEnable = z;
    }

    public void setAvoidRestrictionRouteEnable(boolean z) {
        this.mIsAvoidRestrictionRouteEnable = z;
    }

    public void setCarLogoHintTitle(String str) {
        this.mCarLogoHintTitle = str;
    }

    public void setChargingStationDisplayEnable(boolean z) {
        this.mIsChargingStationDisplayEnable = z;
    }

    public void setCruiseAheadTrafficEnable(boolean z) {
        this.mIsCruiseAheadTrafficEnable = z;
    }

    public void setCruiseElectronicEyeBroadcastEnable(boolean z) {
        this.mIsCruiseElectronicEyeBroadcastEnable = z;
    }

    public void setCruiseSafetyBroadcastEnable(boolean z) {
        this.mIsCruiseSafetyBroadcastEnable = z;
    }

    public void setCurrentCarLogoSrc(int i) {
        this.mCurrentCarLogoSrc = i;
    }

    public void setHighwayPriorityEnable(boolean z) {
        this.mIsHighwayPriorityEnable = z;
    }

    public void setInternetUnityMapContent(String str) {
        this.mInternetUnityMapContent = str;
    }

    public void setLaneMapContent(String str) {
        this.mLaneMapContent = str;
    }

    public void setLicensePlate(String str) {
        this.mLicensePlate = str;
    }

    public void setMapDataAutoUpdateEnable(boolean z) {
        this.mIsMapDataAutoUpdateEnable = z;
    }

    public void setMapDownloadSize(long j) {
        this.mMapDownloadSize = j;
    }

    public void setMapDynamicLevelEnable(boolean z) {
        this.mIsMapDynamicLevelEnable = z;
    }

    public void setMapVersion(String str) {
        this.mMapVersion = str;
    }

    public void setMapVersionDescription(String str) {
        this.mMapVersionDescription = str;
    }

    public void setMinimapTypeEnum(MinimapTypeEnum minimapTypeEnum) {
        this.mMinimapTypeEnum = minimapTypeEnum;
    }

    public void setNaviBroadcastType(NaviBroadcastTypeEnum naviBroadcastTypeEnum) {
        this.mNaviBroadcastType = naviBroadcastTypeEnum;
    }

    public void setNoFreewaysEnable(boolean z) {
        this.mIsNoFreewaysEnable = z;
    }

    public void setPublicationUnityMapContent(String str) {
        this.mPublicationUnityMapContent = str;
    }

    public void setRealTimeTrafficEnable(boolean z) {
        this.mIsRealTimeTrafficEnable = z;
    }

    public void setRecommendParkEnable(boolean z) {
        this.mIsRecommendParkEnable = z;
    }

    public void setRouteRadarEnable(boolean z) {
        this.mIsRouteRadarEnable = z;
    }

    public void setScratchSpotEnable(boolean z) {
        this.mIsScratchSpotEnable = z;
    }

    public void setXPAccountLoginIn(boolean z) {
        this.mIsXPAccountLoginIn = z;
    }

    public String toString() {
        return "SettingPreferenceAdapterProvider(mIsAvoidCongestionEnable=" + isAvoidCongestionEnable() + ", mIsAvoidChargeEnable=" + isAvoidChargeEnable() + ", mIsNoFreewaysEnable=" + isNoFreewaysEnable() + ", mIsHighwayPriorityEnable=" + isHighwayPriorityEnable() + ", mNaviBroadcastType=" + getNaviBroadcastType() + ", mMinimapTypeEnum=" + getMinimapTypeEnum() + ", mIsCruiseAheadTrafficEnable=" + isCruiseAheadTrafficEnable() + ", mIsCruiseSafetyBroadcastEnable=" + isCruiseSafetyBroadcastEnable() + ", mIsCruiseElectronicEyeBroadcastEnable=" + isCruiseElectronicEyeBroadcastEnable() + ", mCarLogoHintTitle=" + getCarLogoHintTitle() + ", mCurrentCarLogoSrc=" + getCurrentCarLogoSrc() + ", mIsRouteRadarEnable=" + isRouteRadarEnable() + ", mIsAvoidRestrictionRouteEnable=" + isAvoidRestrictionRouteEnable() + ", mLicensePlate=" + getLicensePlate() + ", mIsChargingStationDisplayEnable=" + isChargingStationDisplayEnable() + ", mIsRealTimeTrafficEnable=" + isRealTimeTrafficEnable() + ", mIsScratchSpotEnable=" + isScratchSpotEnable() + ", mIsMapDynamicLevelEnable=" + isMapDynamicLevelEnable() + ", mIsRecommendParkEnable=" + isRecommendParkEnable() + ", mIsXPAccountLoginIn=" + isXPAccountLoginIn() + ", mIsAMapBinded=" + isAMapBinded() + ", mMapDownloadSize=" + getMapDownloadSize() + ", mIsMapDataAutoUpdateEnable=" + isMapDataAutoUpdateEnable() + ", mMapVersion=" + getMapVersion() + ", mMapVersionDescription=" + getMapVersionDescription() + ", mPublicationUnityMapContent=" + getPublicationUnityMapContent() + ", mInternetUnityMapContent=" + getInternetUnityMapContent() + ", mLaneMapContent=" + getLaneMapContent() + ")";
    }

    public void setAvoidCongestionEnable(boolean z) {
        this.mIsAvoidCongestionEnable = z;
    }

    public boolean isAvoidCongestionEnable() {
        return this.mIsAvoidCongestionEnable;
    }

    public boolean isAvoidChargeEnable() {
        return this.mIsAvoidChargeEnable;
    }

    public boolean isNoFreewaysEnable() {
        return this.mIsNoFreewaysEnable;
    }

    public boolean isHighwayPriorityEnable() {
        return this.mIsHighwayPriorityEnable;
    }

    public NaviBroadcastTypeEnum getNaviBroadcastType() {
        return this.mNaviBroadcastType;
    }

    public MinimapTypeEnum getMinimapTypeEnum() {
        return this.mMinimapTypeEnum;
    }

    public boolean isCruiseAheadTrafficEnable() {
        return this.mIsCruiseAheadTrafficEnable;
    }

    public boolean isCruiseSafetyBroadcastEnable() {
        return this.mIsCruiseSafetyBroadcastEnable;
    }

    public boolean isCruiseElectronicEyeBroadcastEnable() {
        return this.mIsCruiseElectronicEyeBroadcastEnable;
    }

    public String getCarLogoHintTitle() {
        return this.mCarLogoHintTitle;
    }

    public int getCurrentCarLogoSrc() {
        return this.mCurrentCarLogoSrc;
    }

    public boolean isRouteRadarEnable() {
        return this.mIsRouteRadarEnable;
    }

    public boolean isAvoidRestrictionRouteEnable() {
        return this.mIsAvoidRestrictionRouteEnable;
    }

    public String getLicensePlate() {
        return this.mLicensePlate;
    }

    public boolean isChargingStationDisplayEnable() {
        return this.mIsChargingStationDisplayEnable;
    }

    public boolean isRealTimeTrafficEnable() {
        return this.mIsRealTimeTrafficEnable;
    }

    public boolean isScratchSpotEnable() {
        return this.mIsScratchSpotEnable;
    }

    public boolean isMapDynamicLevelEnable() {
        return this.mIsMapDynamicLevelEnable;
    }

    public boolean isRecommendParkEnable() {
        return this.mIsRecommendParkEnable;
    }

    public boolean isXPAccountLoginIn() {
        return this.mIsXPAccountLoginIn;
    }

    public boolean isAMapBinded() {
        return this.mIsAMapBinded;
    }

    public long getMapDownloadSize() {
        return this.mMapDownloadSize;
    }

    public boolean isMapDataAutoUpdateEnable() {
        return this.mIsMapDataAutoUpdateEnable;
    }

    public String getMapVersion() {
        return this.mMapVersion;
    }

    public String getMapVersionDescription() {
        return this.mMapVersionDescription;
    }

    public String getPublicationUnityMapContent() {
        return this.mPublicationUnityMapContent;
    }

    public String getInternetUnityMapContent() {
        return this.mInternetUnityMapContent;
    }

    public String getLaneMapContent() {
        return this.mLaneMapContent;
    }
}
