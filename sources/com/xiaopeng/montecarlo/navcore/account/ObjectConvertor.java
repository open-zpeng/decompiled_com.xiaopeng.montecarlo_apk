package com.xiaopeng.montecarlo.navcore.account;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.xiaopeng.montecarlo.navcore.bean.favorite.FavoriteAddress;
import com.xiaopeng.montecarlo.navcore.bean.favorite.HistoryRecordInfo;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import com.xiaopeng.montecarlo.navcore.bean.sync.AccountDataPullResponse;
import com.xiaopeng.montecarlo.navcore.bean.sync.AccountDataUploadResponse;
import com.xiaopeng.montecarlo.navcore.bean.sync.AccountDeleteUserDataResponse;
import com.xiaopeng.montecarlo.navcore.bean.sync.AccountSettingInfo;
import com.xiaopeng.montecarlo.navcore.bean.sync.IncrementDataRecord;
import com.xiaopeng.montecarlo.navcore.bean.sync.SessionFailResponse;
import com.xiaopeng.montecarlo.navcore.bean.sync.XPFavoriteItem;
import com.xiaopeng.montecarlo.navcore.bean.sync.XPHistoryRecordItem;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import com.xiaopeng.montecarlo.root.util.GsonUtil;
import com.xiaopeng.montecarlo.root.util.Md5Util;
import com.xiaopeng.montecarlo.root.util.RootUtil;
/* loaded from: classes2.dex */
public class ObjectConvertor {
    private static final String DATAID_CRUISE = "cruise";
    private static final String DATAID_NAVI = "navi";
    private static final String DATAID_SETTING_ACCOUNT = "account";
    private static final String DATAID_SETTING_GLOBAL = "global";
    private static final String DATAID_UNDERLINE = "_";
    private static final String DATAID_VOLUME = "volume";

    public static IncrementDataRecord toFavoriteDataOperation(@NonNull FavoriteAddress favoriteAddress, int i) {
        IncrementDataRecord incrementDataRecord = new IncrementDataRecord();
        incrementDataRecord.setDataId(toFavoriteDataId(favoriteAddress));
        incrementDataRecord.setDataType(1);
        incrementDataRecord.setOperationType(i);
        long currentTimeMillis = System.currentTimeMillis();
        incrementDataRecord.setCreateTime(currentTimeMillis);
        incrementDataRecord.setUpdateTime(currentTimeMillis);
        incrementDataRecord.setDataContent(GsonUtil.toJson(new XPFavoriteItem(favoriteAddress)));
        incrementDataRecord.setHistoryType(0);
        incrementDataRecord.setFavoriteType(favoriteAddress.getFavoriteType());
        return incrementDataRecord;
    }

    public static IncrementDataRecord toHistoryDataOperation(@NonNull HistoryRecordInfo historyRecordInfo, int i) {
        IncrementDataRecord incrementDataRecord = new IncrementDataRecord();
        incrementDataRecord.setDataId(toHistoryDataId(historyRecordInfo));
        incrementDataRecord.setDataType(2);
        incrementDataRecord.setOperationType(i);
        long currentTimeMillis = System.currentTimeMillis();
        incrementDataRecord.setCreateTime(currentTimeMillis);
        incrementDataRecord.setUpdateTime(currentTimeMillis);
        incrementDataRecord.setDataContent(GsonUtil.toJson(new XPHistoryRecordItem(historyRecordInfo)));
        incrementDataRecord.setHistoryType(historyRecordInfo.getHistoryType());
        incrementDataRecord.setFavoriteType(0);
        return incrementDataRecord;
    }

    public static IncrementDataRecord toSettingDataOperation(@NonNull AccountSettingInfo accountSettingInfo, boolean z, int i) {
        IncrementDataRecord incrementDataRecord = new IncrementDataRecord();
        incrementDataRecord.setDataId(toSettingDataId(accountSettingInfo, z));
        incrementDataRecord.setDataType(3);
        incrementDataRecord.setOperationType(i);
        long currentTimeMillis = System.currentTimeMillis();
        incrementDataRecord.setCreateTime(currentTimeMillis);
        incrementDataRecord.setUpdateTime(currentTimeMillis);
        incrementDataRecord.setDataContent(GsonUtil.toJson(accountSettingInfo));
        incrementDataRecord.setHistoryType(0);
        incrementDataRecord.setFavoriteType(0);
        return incrementDataRecord;
    }

    public static IncrementDataRecord toVolumeDataOperation(@NonNull AccountSettingInfo accountSettingInfo, int i) {
        IncrementDataRecord incrementDataRecord = new IncrementDataRecord();
        incrementDataRecord.setDataId(toVolumeDataId(accountSettingInfo));
        incrementDataRecord.setDataType(4);
        incrementDataRecord.setOperationType(i);
        long currentTimeMillis = System.currentTimeMillis();
        incrementDataRecord.setCreateTime(currentTimeMillis);
        incrementDataRecord.setUpdateTime(currentTimeMillis);
        incrementDataRecord.setDataContent(GsonUtil.toJson(accountSettingInfo));
        incrementDataRecord.setHistoryType(0);
        incrementDataRecord.setFavoriteType(0);
        return incrementDataRecord;
    }

    public static IncrementDataRecord toNavAngleDataOperation(@NonNull AccountSettingInfo accountSettingInfo, boolean z, int i) {
        IncrementDataRecord incrementDataRecord = new IncrementDataRecord();
        incrementDataRecord.setDataId(angleSettingInfoToDataId(accountSettingInfo, z));
        incrementDataRecord.setDataType(5);
        incrementDataRecord.setOperationType(i);
        long currentTimeMillis = System.currentTimeMillis();
        incrementDataRecord.setCreateTime(currentTimeMillis);
        incrementDataRecord.setUpdateTime(currentTimeMillis);
        incrementDataRecord.setDataContent(GsonUtil.toJson(accountSettingInfo));
        incrementDataRecord.setHistoryType(0);
        incrementDataRecord.setFavoriteType(0);
        return incrementDataRecord;
    }

    public static String toFavoriteDataId(FavoriteAddress favoriteAddress) {
        return (favoriteAddress == null || favoriteAddress.getXPPoiInfo() == null) ? "" : poiInfoToDataId(1, favoriteAddress.getFavoriteType(), favoriteAddress.getXPPoiInfo());
    }

    public static String toHistoryDataId(HistoryRecordInfo historyRecordInfo) {
        String str = "";
        if (historyRecordInfo == null || historyRecordInfo.getXPPoiInfo() == null) {
            return "";
        }
        if (historyRecordInfo.getHistoryType() == 3 && CollectionUtils.isNotEmpty(historyRecordInfo.getViaPois())) {
            str = historyRecordInfo.toSimplePoiJson(historyRecordInfo.getViaPois());
        }
        return poiInfoToDataId(2, historyRecordInfo.getHistoryType(), historyRecordInfo.getXPPoiInfo(), str);
    }

    public static String toSettingDataId(AccountSettingInfo accountSettingInfo, boolean z) {
        return accountSettingInfo == null ? "" : settingInfoToDataId(3, accountSettingInfo, z);
    }

    public static String toVolumeDataId(AccountSettingInfo accountSettingInfo) {
        return accountSettingInfo == null ? "" : volumeInfoToDataId(4, accountSettingInfo);
    }

    private static String settingInfoToDataId(int i, @NonNull AccountSettingInfo accountSettingInfo, boolean z) {
        String formatIntegerToString = RootUtil.formatIntegerToString(i, 2);
        StringBuilder sb = new StringBuilder();
        sb.append(formatIntegerToString);
        sb.append("_");
        if (z) {
            sb.append("global");
        } else {
            sb.append(DATAID_SETTING_ACCOUNT);
        }
        sb.append("_");
        sb.append(accountSettingInfo.getName());
        return sb.toString();
    }

    private static String poiInfoToDataId(int i, int i2, @NonNull XPPoiInfo xPPoiInfo) {
        return poiInfoToDataId(i, i2, xPPoiInfo, null);
    }

    private static String poiInfoToDataId(int i, int i2, @NonNull XPPoiInfo xPPoiInfo, String str) {
        String formatIntegerToString = RootUtil.formatIntegerToString(i2, 2);
        String formatIntegerToString2 = RootUtil.formatIntegerToString(xPPoiInfo.getPoiSource(), 2);
        String str2 = xPPoiInfo.getPoiId() + formatIntegerToString2;
        if (!TextUtils.isEmpty(str)) {
            str2 = formatIntegerToString2 + str;
        }
        String bit16Md5Hex = Md5Util.toBit16Md5Hex(str2);
        double displayLon = xPPoiInfo.getDisplayLon();
        double displayLat = xPPoiInfo.getDisplayLat();
        String str3 = bit16Md5Hex + formatIntegerToString + RootUtil.getDoubleDecimal(displayLon, 5) + RootUtil.getDoubleDecimal(displayLat, 5);
        return RootUtil.formatIntegerToString(i, 2) + "_" + str3;
    }

    private static String volumeInfoToDataId(int i, @NonNull AccountSettingInfo accountSettingInfo) {
        String formatIntegerToString = RootUtil.formatIntegerToString(i, 2);
        return formatIntegerToString + "_" + DATAID_VOLUME + "_" + accountSettingInfo.getName();
    }

    private static String angleSettingInfoToDataId(@NonNull AccountSettingInfo accountSettingInfo, boolean z) {
        String formatIntegerToString = RootUtil.formatIntegerToString(5, 2);
        StringBuilder sb = new StringBuilder();
        sb.append(formatIntegerToString);
        sb.append("_");
        if (z) {
            sb.append("navi");
        } else {
            sb.append(DATAID_CRUISE);
        }
        sb.append("_");
        sb.append(accountSettingInfo.getName());
        return sb.toString();
    }

    public static AccountDataPullResponse jsonToPullResponse(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return (AccountDataPullResponse) GsonUtil.fromJson(str, (Class<Object>) AccountDataPullResponse.class);
    }

    public static AccountDataUploadResponse jsonToUploadResponse(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return (AccountDataUploadResponse) GsonUtil.fromJson(str, (Class<Object>) AccountDataUploadResponse.class);
    }

    public static XPFavoriteItem jsonToXPFavoriteItem(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return (XPFavoriteItem) GsonUtil.fromJson(str, (Class<Object>) XPFavoriteItem.class);
    }

    public static XPHistoryRecordItem jsonToXPHistoryRecordItem(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return (XPHistoryRecordItem) GsonUtil.fromJson(str, (Class<Object>) XPHistoryRecordItem.class);
    }

    public static AccountSettingInfo jsonToSettingInfo(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return (AccountSettingInfo) GsonUtil.fromJson(str, (Class<Object>) AccountSettingInfo.class);
    }

    public static SessionFailResponse jsonToSessionFailResponse(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return (SessionFailResponse) GsonUtil.fromJson(str, (Class<Object>) SessionFailResponse.class);
    }

    public static AccountDeleteUserDataResponse jsonToAccountDataClearResponse(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return (AccountDeleteUserDataResponse) GsonUtil.fromJson(str, (Class<Object>) AccountDeleteUserDataResponse.class);
    }
}
