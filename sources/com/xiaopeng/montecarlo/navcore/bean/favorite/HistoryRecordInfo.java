package com.xiaopeng.montecarlo.navcore.bean.favorite;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.xiaopeng.montecarlo.navcore.account.ObjectConvertor;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiCategory;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import com.xiaopeng.montecarlo.navcore.bean.sync.XPHistoryRecordItem;
import com.xiaopeng.montecarlo.navcore.util.NavCoreUtil;
import com.xiaopeng.montecarlo.navcore.util.NaviLogUtil;
import com.xiaopeng.montecarlo.root.provider.favorite.NavFavoriteProvider;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import com.xiaopeng.montecarlo.root.util.L;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class HistoryRecordInfo extends DataTransform implements Parcelable {
    public static final int HISTORY_DESTINATION = 2;
    public static final int HISTORY_KEYWORD = 1;
    public static final int HISTORY_NONE = 0;
    public static final int HISTORY_PATH = 3;
    private long mCreateTime;
    private long mDataVersion;
    private boolean mHasChildPois;
    private int mHistoryType;
    private long mId;
    private int mUpdateCount;
    private List<XPPoiInfo> mViaPois;
    private XPPoiInfo mXPPoiInfo;
    public static final Parcelable.Creator<HistoryRecordInfo> CREATOR = new Parcelable.Creator<HistoryRecordInfo>() { // from class: com.xiaopeng.montecarlo.navcore.bean.favorite.HistoryRecordInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public HistoryRecordInfo createFromParcel(Parcel parcel) {
            return new HistoryRecordInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public HistoryRecordInfo[] newArray(int i) {
            return new HistoryRecordInfo[i];
        }
    };
    private static final L.Tag TAG = new L.Tag("HistoryRecordInfo");

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes2.dex */
    public @interface HistoryType {
    }

    @Override // com.xiaopeng.montecarlo.navcore.bean.favorite.DataTransform, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void setXPPoiInfo(XPPoiInfo xPPoiInfo) {
        this.mXPPoiInfo = xPPoiInfo;
    }

    public XPPoiInfo getXPPoiInfo() {
        return this.mXPPoiInfo;
    }

    public void setId(long j) {
        this.mId = j;
    }

    public long getId() {
        return this.mId;
    }

    public void setCreateTime(long j) {
        this.mCreateTime = j;
    }

    public long getCreateTime() {
        return this.mCreateTime;
    }

    public void setHasChildPois(boolean z) {
        this.mHasChildPois = z;
    }

    public boolean isHasChildPois() {
        return this.mHasChildPois;
    }

    public void setViaPois(List<XPPoiInfo> list) {
        this.mViaPois = list;
    }

    public List<XPPoiInfo> getViaPois() {
        return this.mViaPois;
    }

    public void setDataVersion(long j) {
        this.mDataVersion = j;
    }

    public long getDataVersion() {
        return this.mDataVersion;
    }

    public void setUpdateCount(int i) {
        this.mUpdateCount = i;
    }

    public int getUpdateCount() {
        return this.mUpdateCount;
    }

    public HistoryRecordInfo() {
        this.mXPPoiInfo = new XPPoiInfo();
        this.mHistoryType = 1;
    }

    public HistoryRecordInfo(String str, XPHistoryRecordItem xPHistoryRecordItem) {
        this.mXPPoiInfo = new XPPoiInfo();
        this.mHistoryType = 1;
        if (xPHistoryRecordItem != null) {
            try {
                if (this.mXPPoiInfo != null) {
                    this.mXPPoiInfo.setDisplayLon(Double.parseDouble(xPHistoryRecordItem.getLon()));
                    this.mXPPoiInfo.setDisplayLat(Double.parseDouble(xPHistoryRecordItem.getLat()));
                    this.mXPPoiInfo.setNaviLon(Double.parseDouble(xPHistoryRecordItem.getNavLon()));
                    this.mXPPoiInfo.setNaviLat(Double.parseDouble(xPHistoryRecordItem.getNavLat()));
                    this.mXPPoiInfo.setPoiId(xPHistoryRecordItem.getPoiId());
                    this.mXPPoiInfo.setCityCode(xPHistoryRecordItem.getCityCode());
                    this.mXPPoiInfo.setCityName(xPHistoryRecordItem.getCityName());
                    this.mXPPoiInfo.setTel(xPHistoryRecordItem.getPhoneNumbers());
                    this.mXPPoiInfo.setTag(xPHistoryRecordItem.getTag());
                    this.mXPPoiInfo.setOpenTime(xPHistoryRecordItem.getOpenTime());
                    this.mXPPoiInfo.setPrice(xPHistoryRecordItem.getPrice());
                    String name = xPHistoryRecordItem.getName();
                    String address = xPHistoryRecordItem.getAddress();
                    if (TextUtils.isEmpty(name) && !TextUtils.isEmpty(address)) {
                        L.Tag tag = TAG;
                        L.w(tag, "swtich address:" + address);
                        this.mXPPoiInfo.setName(xPHistoryRecordItem.getAddress());
                        this.mXPPoiInfo.setAddress("");
                    } else {
                        this.mXPPoiInfo.setName(xPHistoryRecordItem.getName());
                        this.mXPPoiInfo.setAddress(xPHistoryRecordItem.getAddress());
                    }
                    this.mXPPoiInfo.setType(Integer.parseInt(xPHistoryRecordItem.getType()));
                    this.mXPPoiInfo.setCategory(Integer.parseInt(xPHistoryRecordItem.getCategory()));
                    this.mXPPoiInfo.setOffline(xPHistoryRecordItem.getIsOffline().equals("1"));
                    this.mXPPoiInfo.setAdCode(Integer.parseInt(xPHistoryRecordItem.getAdCode()));
                    this.mXPPoiInfo.setProvinceName(xPHistoryRecordItem.getProvinceName());
                    this.mXPPoiInfo.setDistrictName(xPHistoryRecordItem.getDistrictName());
                    this.mXPPoiInfo.setIconType(xPHistoryRecordItem.getIconType());
                    this.mXPPoiInfo.setIconUrl(xPHistoryRecordItem.getIconUrl());
                    this.mXPPoiInfo.setParentID(xPHistoryRecordItem.getParentID());
                    this.mXPPoiInfo.setParentName(xPHistoryRecordItem.getParentName());
                    this.mXPPoiInfo.setParentSimpleName(xPHistoryRecordItem.getParentSimpleName());
                    this.mXPPoiInfo.setTypeCode(xPHistoryRecordItem.getTypeCode());
                    this.mXPPoiInfo.setOverhead(Short.parseShort(xPHistoryRecordItem.getOverHead()));
                    this.mXPPoiInfo.setHasPark("1".equals(xPHistoryRecordItem.getHasParkPois()));
                    this.mXPPoiInfo.setPoiSource(Integer.parseInt(xPHistoryRecordItem.getPoiSource()));
                    this.mXPPoiInfo.setBlCategory(xPHistoryRecordItem.getReserveA());
                    this.mXPPoiInfo.setReserveB(xPHistoryRecordItem.getReserveB());
                    this.mXPPoiInfo.setReserveC(xPHistoryRecordItem.getReserveC());
                    String childPoisJson = xPHistoryRecordItem.getChildPoisJson();
                    if (!TextUtils.isEmpty(childPoisJson)) {
                        ArrayList<XPPoiInfo> parseSimplePoisJson = parseSimplePoisJson(childPoisJson);
                        if (CollectionUtils.isNotEmpty(parseSimplePoisJson)) {
                            this.mXPPoiInfo.setChild(parseSimplePoisJson);
                        }
                    }
                    this.mXPPoiInfo.setReserveB(str);
                }
                this.mHasChildPois = "1".equals(xPHistoryRecordItem.getHasChildPois());
                this.mCreateTime = Long.parseLong(xPHistoryRecordItem.getCreateTime());
                this.mHistoryType = Integer.parseInt(xPHistoryRecordItem.getHistoryType());
                this.mDataVersion = xPHistoryRecordItem.getDataVersion();
                this.mUpdateCount = xPHistoryRecordItem.getUpdateCount();
                String viaPoisJson = xPHistoryRecordItem.getViaPoisJson();
                if (TextUtils.isEmpty(viaPoisJson)) {
                    return;
                }
                ArrayList<XPPoiInfo> parseSimplePoisJson2 = parseSimplePoisJson(viaPoisJson);
                if (CollectionUtils.isNotEmpty(parseSimplePoisJson2)) {
                    this.mViaPois = parseSimplePoisJson2;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public HistoryRecordInfo(@NonNull XPPoiInfo xPPoiInfo, int i) {
        this.mXPPoiInfo = new XPPoiInfo();
        this.mHistoryType = 1;
        this.mXPPoiInfo = xPPoiInfo;
        this.mCreateTime = System.currentTimeMillis();
        this.mHistoryType = i;
        if (CollectionUtils.isNotEmpty(this.mXPPoiInfo.getChild())) {
            this.mHasChildPois = true;
        } else {
            this.mHasChildPois = false;
        }
        if (this.mXPPoiInfo != null) {
            if (L.ENABLE) {
                L.d(TAG, NaviLogUtil.dumpXPPOIInfo(this.mXPPoiInfo));
            }
            NavCoreUtil.setNavPositionWithEnters(this.mXPPoiInfo);
            if (TextUtils.isEmpty(this.mXPPoiInfo.getReserveB())) {
                this.mXPPoiInfo.setReserveB(ObjectConvertor.toHistoryDataId(this));
            }
        }
    }

    public HistoryRecordInfo(@NonNull XPPoiInfo xPPoiInfo, int i, List<XPPoiInfo> list) {
        this.mXPPoiInfo = new XPPoiInfo();
        this.mHistoryType = 1;
        this.mXPPoiInfo = xPPoiInfo;
        this.mCreateTime = System.currentTimeMillis();
        this.mHistoryType = i;
        if (CollectionUtils.isNotEmpty(this.mXPPoiInfo.getChild())) {
            this.mHasChildPois = true;
        } else {
            this.mHasChildPois = false;
        }
        if (this.mXPPoiInfo != null) {
            if (L.ENABLE) {
                L.d(TAG, NaviLogUtil.dumpXPPOIInfo(this.mXPPoiInfo));
            }
            NavCoreUtil.setNavPositionWithEnters(this.mXPPoiInfo);
            if (TextUtils.isEmpty(this.mXPPoiInfo.getReserveB())) {
                this.mXPPoiInfo.setReserveB(ObjectConvertor.toHistoryDataId(this));
            }
        }
        if (CollectionUtils.isNotEmpty(list)) {
            List<XPPoiInfo> list2 = this.mViaPois;
            if (list2 != null) {
                list2.clear();
            } else {
                this.mViaPois = new ArrayList();
            }
            for (XPPoiInfo xPPoiInfo2 : list) {
                XPPoiInfo deepClone = xPPoiInfo2.deepClone();
                if (deepClone != null) {
                    this.mViaPois.add(deepClone);
                }
            }
        }
    }

    protected HistoryRecordInfo(Parcel parcel) {
        this.mXPPoiInfo = new XPPoiInfo();
        this.mHistoryType = 1;
        this.mXPPoiInfo = (XPPoiInfo) parcel.readParcelable(XPPoiInfo.class.getClassLoader());
        this.mId = parcel.readLong();
        this.mCreateTime = parcel.readLong();
        this.mHasChildPois = parcel.readByte() != 0;
        this.mHistoryType = parcel.readInt();
        this.mViaPois = parcel.createTypedArrayList(XPPoiInfo.CREATOR);
        this.mDataVersion = parcel.readLong();
        this.mUpdateCount = parcel.readInt();
    }

    @Override // com.xiaopeng.montecarlo.navcore.bean.favorite.DataTransform, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.mXPPoiInfo, i);
        parcel.writeLong(this.mId);
        parcel.writeLong(this.mCreateTime);
        parcel.writeByte(this.mHasChildPois ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.mHistoryType);
        parcel.writeTypedList(this.mViaPois);
        parcel.writeLong(this.mDataVersion);
        parcel.writeInt(this.mUpdateCount);
    }

    @Override // com.xiaopeng.montecarlo.navcore.bean.favorite.DataTransform
    @NonNull
    public ContentValues toContentValues() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("latitude", Double.valueOf(this.mXPPoiInfo.getDisplayLat() < 0.0d ? 0.0d : this.mXPPoiInfo.getDisplayLat()));
        contentValues.put("longitude", Double.valueOf(this.mXPPoiInfo.getDisplayLon() < 0.0d ? 0.0d : this.mXPPoiInfo.getDisplayLon()));
        contentValues.put("naviLat", Double.valueOf(this.mXPPoiInfo.getNaviLat() < 0.0d ? 0.0d : this.mXPPoiInfo.getNaviLat()));
        contentValues.put("naviLon", Double.valueOf(this.mXPPoiInfo.getNaviLon() >= 0.0d ? this.mXPPoiInfo.getNaviLon() : 0.0d));
        contentValues.put("poiid", this.mXPPoiInfo.getPoiId() == null ? "" : this.mXPPoiInfo.getPoiId());
        contentValues.put("citycode", this.mXPPoiInfo.getCityCode() == null ? "" : this.mXPPoiInfo.getCityCode());
        contentValues.put("cityname", this.mXPPoiInfo.getCityName() == null ? "" : this.mXPPoiInfo.getCityName());
        contentValues.put("phonenumbers", this.mXPPoiInfo.getTel() == null ? "" : this.mXPPoiInfo.getTel());
        contentValues.put("tag", this.mXPPoiInfo.getTag() == null ? "" : this.mXPPoiInfo.getTag());
        contentValues.put("opentime", this.mXPPoiInfo.getOpenTime() == null ? "" : this.mXPPoiInfo.getOpenTime());
        contentValues.put("price", this.mXPPoiInfo.getPrice() == null ? "" : this.mXPPoiInfo.getPrice());
        contentValues.put("name", this.mXPPoiInfo.getName() == null ? "" : this.mXPPoiInfo.getName());
        contentValues.put("type", Integer.valueOf(this.mXPPoiInfo.getType()));
        if (this.mXPPoiInfo.getCategory() == 100) {
            contentValues.put("category", "");
        } else {
            contentValues.put("category", Integer.valueOf(this.mXPPoiInfo.getCategory()));
        }
        contentValues.put("address", this.mXPPoiInfo.getAddress() == null ? "" : this.mXPPoiInfo.getAddress());
        contentValues.put("has_child_pois", Integer.valueOf(this.mHasChildPois ? 1 : 0));
        if (CollectionUtils.isNotEmpty(this.mXPPoiInfo.getChild())) {
            contentValues.put("child_pois_json", toSimplePoiJson(this.mXPPoiInfo.getChild()));
        } else {
            contentValues.put("child_pois_json", "");
        }
        contentValues.put("offline", Boolean.valueOf(this.mXPPoiInfo.isOffline()));
        contentValues.put("adcode", Integer.valueOf(this.mXPPoiInfo.getAdCode()));
        contentValues.put("provincename", this.mXPPoiInfo.getProvinceName() == null ? "" : this.mXPPoiInfo.getProvinceName());
        contentValues.put("districtname", this.mXPPoiInfo.getDistrictName() == null ? "" : this.mXPPoiInfo.getDistrictName());
        contentValues.put("icontype", this.mXPPoiInfo.getIconType() == null ? "" : this.mXPPoiInfo.getIconType());
        contentValues.put("iconurl", this.mXPPoiInfo.getIconUrl() == null ? "" : this.mXPPoiInfo.getIconUrl());
        contentValues.put("parentid", this.mXPPoiInfo.getParentID() == null ? "" : this.mXPPoiInfo.getParentID());
        contentValues.put("parentname", this.mXPPoiInfo.getParentName() == null ? "" : this.mXPPoiInfo.getParentName());
        contentValues.put("parent_simple_name", this.mXPPoiInfo.getParentSimpleName() == null ? "" : this.mXPPoiInfo.getParentSimpleName());
        contentValues.put("typecode", this.mXPPoiInfo.getTypeCode() == null ? "" : this.mXPPoiInfo.getTypeCode());
        contentValues.put("overhead", Short.valueOf(this.mXPPoiInfo.getOverhead()));
        contentValues.put("has_park_pois", Boolean.valueOf(this.mXPPoiInfo.isHasPark()));
        long j = this.mCreateTime;
        if (j < 0) {
            j = 0;
        }
        contentValues.put(NavFavoriteProvider.HistoryColumns.CREATETIME, Long.valueOf(j));
        contentValues.put("history_type", Integer.valueOf(this.mHistoryType));
        contentValues.put("poi_source", Integer.valueOf(this.mXPPoiInfo.getPoiSource()));
        contentValues.put("reserve_a", XPPoiCategory.isValidBLPoi(this.mXPPoiInfo.getBlCategory()) ? this.mXPPoiInfo.getBlCategory() : "");
        contentValues.put("reserve_b", this.mXPPoiInfo.getReserveB() == null ? "" : this.mXPPoiInfo.getReserveB());
        contentValues.put("reserve_c", this.mXPPoiInfo.getReserveC() == null ? "" : this.mXPPoiInfo.getReserveC());
        if (CollectionUtils.isNotEmpty(this.mViaPois)) {
            contentValues.put(NavFavoriteProvider.HistoryColumns.PATH_VIAS, toSimplePoiJson(this.mViaPois));
        } else {
            contentValues.put(NavFavoriteProvider.HistoryColumns.PATH_VIAS, "");
        }
        contentValues.put("data_version", Long.valueOf(this.mDataVersion));
        contentValues.put(NavFavoriteProvider.HistoryColumns.UPDATE_COUNT, Integer.valueOf(this.mUpdateCount));
        return contentValues;
    }

    @Override // com.xiaopeng.montecarlo.navcore.bean.favorite.DataTransform
    public void bindContentValues(@NonNull Cursor cursor) {
        try {
            this.mId = cursor.getLong(cursor.getColumnIndexOrThrow("_id"));
            this.mXPPoiInfo.setDisplayLat(Double.parseDouble(cursor.getString(cursor.getColumnIndexOrThrow("latitude"))));
            this.mXPPoiInfo.setDisplayLon(Double.parseDouble(cursor.getString(cursor.getColumnIndexOrThrow("longitude"))));
            this.mXPPoiInfo.setNaviLat(Double.parseDouble(cursor.getString(cursor.getColumnIndexOrThrow("naviLat"))));
            this.mXPPoiInfo.setNaviLon(Double.parseDouble(cursor.getString(cursor.getColumnIndexOrThrow("naviLon"))));
            this.mXPPoiInfo.setPoiId(cursor.getString(cursor.getColumnIndexOrThrow("poiid")));
            this.mXPPoiInfo.setCityCode(cursor.getString(cursor.getColumnIndexOrThrow("citycode")));
            this.mXPPoiInfo.setCityName(cursor.getString(cursor.getColumnIndexOrThrow("cityname")));
            this.mXPPoiInfo.setTel(cursor.getString(cursor.getColumnIndexOrThrow("phonenumbers")));
            this.mXPPoiInfo.setTag(cursor.getString(cursor.getColumnIndexOrThrow("tag")));
            this.mXPPoiInfo.setOpenTime(cursor.getString(cursor.getColumnIndexOrThrow("opentime")));
            this.mXPPoiInfo.setPrice(cursor.getString(cursor.getColumnIndexOrThrow("price")));
            this.mXPPoiInfo.setName(cursor.getString(cursor.getColumnIndexOrThrow("name")));
            this.mXPPoiInfo.setType(cursor.getInt(cursor.getColumnIndexOrThrow("type")));
            this.mXPPoiInfo.setAddress(cursor.getString(cursor.getColumnIndexOrThrow("address")));
            this.mHasChildPois = cursor.getInt(cursor.getColumnIndexOrThrow("has_child_pois")) == 1;
            String string = cursor.getString(cursor.getColumnIndexOrThrow("child_pois_json"));
            if (!TextUtils.isEmpty(string)) {
                ArrayList<XPPoiInfo> parseSimplePoisJson = parseSimplePoisJson(string);
                if (CollectionUtils.isNotEmpty(parseSimplePoisJson)) {
                    this.mXPPoiInfo.setChild(parseSimplePoisJson);
                }
            }
            this.mXPPoiInfo.setOffline(cursor.getInt(cursor.getColumnIndexOrThrow("offline")) == 1);
            this.mXPPoiInfo.setAdCode(cursor.getInt(cursor.getColumnIndexOrThrow("adcode")));
            this.mXPPoiInfo.setProvinceName(cursor.getString(cursor.getColumnIndexOrThrow("provincename")));
            this.mXPPoiInfo.setDistrictName(cursor.getString(cursor.getColumnIndexOrThrow("districtname")));
            this.mXPPoiInfo.setIconType(cursor.getString(cursor.getColumnIndexOrThrow("icontype")));
            this.mXPPoiInfo.setIconUrl(cursor.getString(cursor.getColumnIndexOrThrow("iconurl")));
            this.mXPPoiInfo.setParentID(cursor.getString(cursor.getColumnIndexOrThrow("parentid")));
            this.mXPPoiInfo.setParentName(cursor.getString(cursor.getColumnIndexOrThrow("parentname")));
            this.mXPPoiInfo.setParentSimpleName(cursor.getString(cursor.getColumnIndexOrThrow("parent_simple_name")));
            this.mXPPoiInfo.setTypeCode(cursor.getString(cursor.getColumnIndexOrThrow("typecode")));
            this.mXPPoiInfo.setOverhead(cursor.getShort(cursor.getColumnIndexOrThrow("overhead")));
            this.mXPPoiInfo.setHasPark(cursor.getInt(cursor.getColumnIndexOrThrow("has_park_pois")) == 1);
            this.mCreateTime = Long.parseLong(cursor.getString(cursor.getColumnIndexOrThrow(NavFavoriteProvider.HistoryColumns.CREATETIME)));
            this.mHistoryType = cursor.getInt(cursor.getColumnIndexOrThrow("history_type"));
            this.mXPPoiInfo.setPoiSource(cursor.getInt(cursor.getColumnIndexOrThrow("poi_source")));
            String string2 = cursor.getString(cursor.getColumnIndexOrThrow("reserve_a"));
            if (XPPoiCategory.isValidBLPoi(string2)) {
                this.mXPPoiInfo.setBlCategory(string2);
                this.mXPPoiInfo.setCategory(XPPoiCategory.transformCategory(string2));
            } else {
                this.mXPPoiInfo.setBlCategory("");
                String string3 = cursor.getString(cursor.getColumnIndexOrThrow("category"));
                if (TextUtils.isEmpty(string3)) {
                    this.mXPPoiInfo.setCategory(100);
                } else {
                    this.mXPPoiInfo.setCategory(Integer.valueOf(string3).intValue());
                }
            }
            this.mXPPoiInfo.setReserveB(cursor.getString(cursor.getColumnIndexOrThrow("reserve_b")));
            this.mXPPoiInfo.setReserveC(cursor.getString(cursor.getColumnIndexOrThrow("reserve_c")));
            String string4 = cursor.getString(cursor.getColumnIndexOrThrow(NavFavoriteProvider.HistoryColumns.PATH_VIAS));
            if (!TextUtils.isEmpty(string4)) {
                ArrayList<XPPoiInfo> parseSimplePoisJson2 = parseSimplePoisJson(string4);
                if (CollectionUtils.isNotEmpty(parseSimplePoisJson2)) {
                    this.mViaPois = parseSimplePoisJson2;
                }
            }
            this.mDataVersion = cursor.getLong(cursor.getColumnIndexOrThrow("data_version"));
            this.mUpdateCount = cursor.getInt(cursor.getColumnIndexOrThrow(NavFavoriteProvider.HistoryColumns.UPDATE_COUNT));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.bean.favorite.DataTransform
    public ContentValues toUpdateContentValues() {
        ContentValues contentValues = toContentValues();
        contentValues.remove("reserve_c");
        return contentValues;
    }

    @Override // com.xiaopeng.montecarlo.navcore.bean.favorite.DataTransform
    @Nullable
    public ContentValues toInsertContentValues() {
        ContentValues contentValues = toContentValues();
        contentValues.put("reserve_c", Long.valueOf(System.currentTimeMillis()));
        return contentValues;
    }

    public int getHistoryType() {
        return this.mHistoryType;
    }

    public void setHistoryType(int i) {
        this.mHistoryType = i;
    }
}
