package com.xiaopeng.montecarlo.navcore.bean.favorite;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.autonavi.gbl.user.behavior.model.FavoriteItem;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.xiaopeng.montecarlo.navcore.account.ObjectConvertor;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import com.xiaopeng.montecarlo.navcore.bean.sync.XPFavoriteItem;
import com.xiaopeng.montecarlo.navcore.favorite.FavoriteUtil;
import com.xiaopeng.montecarlo.navcore.util.NavCoreUtil;
import com.xiaopeng.montecarlo.navcore.util.NaviLogUtil;
import com.xiaopeng.montecarlo.root.provider.favorite.NavFavoriteProvider;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import com.xiaopeng.montecarlo.root.util.GsonUtil;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.speech.protocol.node.navi.bean.PoiBean;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class FavoriteAddress extends DataTransform implements Parcelable {
    private static final double ERROR_CREATE_TIME = 1.0E-10d;
    public static final int FAVORITE_TYPE_COMPANY = 3;
    public static final int FAVORITE_TYPE_COMPANY_BL = 2;
    public static final int FAVORITE_TYPE_HOME = 2;
    public static final int FAVORITE_TYPE_HOME_BL = 1;
    public static final int FAVORITE_TYPE_NONE = 0;
    public static final int FAVORITE_TYPE_NORMAL = 1;
    public static final int FAVORITE_TYPE_NORMAL_BL = 0;
    @SerializedName("mBLClassification")
    private String mBLClassification;
    @SerializedName("mBLCreateTime")
    private long mBLCreateTime;
    @SerializedName("mBLCustomName")
    private String mBLCustomName;
    @SerializedName("mBLItemId")
    private String mBLItemId;
    @SerializedName("mBLNewType")
    private String mBLNewType;
    @SerializedName("mBLPoiType")
    private String mBLPoiType;
    @SerializedName("mBLTopTime")
    private long mBLTopTime;
    @SerializedName("mBLType")
    private String mBLType;
    @SerializedName("mBLVersion")
    private String mBLVersion;
    private long mDataVersion;
    @SerializedName("mFavoriteType")
    private int mFavoriteType;
    @SerializedName("mHasChildPois")
    private boolean mHasChildPois;
    @Expose(deserialize = false, serialize = false)
    private boolean mHasClicked;
    @SerializedName("mId")
    private long mId;
    @Expose(deserialize = false, serialize = false)
    private boolean mIsCancelFavorite;
    @Expose(deserialize = false, serialize = false)
    private boolean mIsCreateFromFavoriteItem;
    @SerializedName("mXPPoiInfo")
    private XPPoiInfo mXPPoiInfo;
    public static final Parcelable.Creator<FavoriteAddress> CREATOR = new Parcelable.Creator<FavoriteAddress>() { // from class: com.xiaopeng.montecarlo.navcore.bean.favorite.FavoriteAddress.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public FavoriteAddress createFromParcel(@NonNull Parcel parcel) {
            return new FavoriteAddress(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public FavoriteAddress[] newArray(int i) {
            return new FavoriteAddress[i];
        }
    };
    private static final L.Tag TAG = new L.Tag("FavoriteAddress");

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes2.dex */
    public @interface FavoriteType {
    }

    @Override // com.xiaopeng.montecarlo.navcore.bean.favorite.DataTransform, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public int getBlTypeByFavorite(int i) {
        if (2 == i) {
            return 1;
        }
        if (3 == i) {
            return 2;
        }
        return 1 == i ? 0 : -1;
    }

    public int getFavoriteTypeByBl(int i) {
        if (1 == i) {
            return 2;
        }
        if (2 == i) {
            return 3;
        }
        return i == 0 ? 1 : 0;
    }

    public void setId(long j) {
        this.mId = j;
    }

    public long getId() {
        return this.mId;
    }

    public void setBLItemId(String str) {
        this.mBLItemId = str;
    }

    public String getBLItemId() {
        return this.mBLItemId;
    }

    public void setBLType(String str) {
        this.mBLType = str;
    }

    public String getBLType() {
        return this.mBLType;
    }

    public void setBLNewType(String str) {
        this.mBLNewType = str;
    }

    public String getBLNewType() {
        return this.mBLNewType;
    }

    public void setBLCustomName(String str) {
        this.mBLCustomName = str;
    }

    public String getBLCustomName() {
        return this.mBLCustomName;
    }

    public void setBLClassification(String str) {
        this.mBLClassification = str;
    }

    public String getBLClassification() {
        return this.mBLClassification;
    }

    public void setBLPoiType(String str) {
        this.mBLPoiType = str;
    }

    public String getBLPoiType() {
        return this.mBLPoiType;
    }

    public void setBLCreateTime(long j) {
        this.mBLCreateTime = j;
    }

    public long getBLCreateTime() {
        return this.mBLCreateTime;
    }

    public void setBLTopTime(long j) {
        this.mBLTopTime = j;
    }

    public long getBLTopTime() {
        return this.mBLTopTime;
    }

    public void setBLVersion(String str) {
        this.mBLVersion = str;
    }

    public String getBLVersion() {
        return this.mBLVersion;
    }

    public void setFavoriteType(int i) {
        this.mFavoriteType = i;
    }

    public int getFavoriteType() {
        return this.mFavoriteType;
    }

    public void setHasChildPois(boolean z) {
        this.mHasChildPois = z;
    }

    public boolean isHasChildPois() {
        return this.mHasChildPois;
    }

    public void setHasClicked(boolean z) {
        this.mHasClicked = z;
    }

    public boolean isHasClicked() {
        return this.mHasClicked;
    }

    public void setXPPoiInfo(XPPoiInfo xPPoiInfo) {
        this.mXPPoiInfo = xPPoiInfo;
    }

    public XPPoiInfo getXPPoiInfo() {
        return this.mXPPoiInfo;
    }

    public void setDataVersion(long j) {
        this.mDataVersion = j;
    }

    public long getDataVersion() {
        return this.mDataVersion;
    }

    public void setCancelFavorite(boolean z) {
        this.mIsCancelFavorite = z;
    }

    public boolean isCancelFavorite() {
        return this.mIsCancelFavorite;
    }

    public FavoriteAddress() {
        this.mId = -1L;
        this.mHasClicked = false;
        this.mXPPoiInfo = new XPPoiInfo();
        this.mIsCancelFavorite = false;
        this.mIsCreateFromFavoriteItem = false;
    }

    public FavoriteAddress(@NonNull XPPoiInfo xPPoiInfo) {
        this.mId = -1L;
        this.mHasClicked = false;
        this.mXPPoiInfo = new XPPoiInfo();
        this.mIsCancelFavorite = false;
        this.mIsCreateFromFavoriteItem = false;
        this.mXPPoiInfo = xPPoiInfo;
        this.mBLItemId = xPPoiInfo.getBlFavoriteItemId();
        this.mBLCreateTime = System.currentTimeMillis();
        this.mFavoriteType = 1;
        if (CollectionUtils.isNotEmpty(xPPoiInfo.getChild())) {
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
                this.mXPPoiInfo.setReserveB(ObjectConvertor.toFavoriteDataId(this));
            }
        }
    }

    public FavoriteAddress(FavoriteItem favoriteItem) {
        this.mId = -1L;
        this.mHasClicked = false;
        this.mXPPoiInfo = new XPPoiInfo();
        this.mIsCancelFavorite = false;
        this.mIsCreateFromFavoriteItem = false;
        XPPoiInfo xPPoiInfo = this.mXPPoiInfo;
        if (xPPoiInfo != null) {
            xPPoiInfo.setPoiId(favoriteItem.poiid);
            this.mXPPoiInfo.setName(favoriteItem.name);
            this.mXPPoiInfo.setDisplayLon(favoriteItem.point_x);
            this.mXPPoiInfo.setDisplayLat(favoriteItem.point_y);
            this.mXPPoiInfo.setNaviLon(favoriteItem.point_x_arrive);
            this.mXPPoiInfo.setNaviLat(favoriteItem.point_y_arrive);
            this.mXPPoiInfo.setAddress(favoriteItem.address);
            this.mXPPoiInfo.setCityName(favoriteItem.city_name);
            this.mXPPoiInfo.setCityCode(favoriteItem.city_code);
            this.mXPPoiInfo.setTel(favoriteItem.phone_numbers);
            this.mXPPoiInfo.setTag(favoriteItem.tag);
            this.mXPPoiInfo.setBlFavoriteItemId(favoriteItem.item_id);
        }
        this.mBLItemId = favoriteItem.item_id;
        this.mBLType = favoriteItem.type;
        this.mBLNewType = favoriteItem.newType;
        this.mBLCustomName = favoriteItem.custom_name;
        this.mBLClassification = favoriteItem.classification;
        this.mBLPoiType = favoriteItem.poi_type;
        long currentTimeMillis = System.currentTimeMillis();
        long j = (int) (currentTimeMillis / 1000);
        if (favoriteItem.create_time > j || favoriteItem.create_time < ERROR_CREATE_TIME) {
            this.mBLCreateTime = currentTimeMillis;
        } else {
            this.mBLCreateTime = favoriteItem.create_time * 1000;
        }
        if (favoriteItem.top_time > 0) {
            if (favoriteItem.top_time > j || favoriteItem.top_time < ERROR_CREATE_TIME) {
                this.mBLTopTime = currentTimeMillis;
            } else {
                this.mBLTopTime = favoriteItem.top_time * 1000;
            }
        }
        this.mBLVersion = favoriteItem.version;
        if (favoriteItem.common_name == 0) {
            this.mFavoriteType = 1;
        } else if (1 == favoriteItem.common_name) {
            this.mFavoriteType = 2;
        } else if (2 == favoriteItem.common_name) {
            this.mFavoriteType = 3;
        }
        this.mHasChildPois = false;
        this.mIsCancelFavorite = false;
        this.mIsCreateFromFavoriteItem = true;
    }

    public FavoriteAddress(String str, XPFavoriteItem xPFavoriteItem) {
        this.mId = -1L;
        this.mHasClicked = false;
        this.mXPPoiInfo = new XPPoiInfo();
        this.mIsCancelFavorite = false;
        this.mIsCreateFromFavoriteItem = false;
        if (xPFavoriteItem != null) {
            try {
                boolean z = true;
                if (this.mXPPoiInfo != null) {
                    this.mXPPoiInfo.setDisplayLon(Double.parseDouble(xPFavoriteItem.getLon()));
                    this.mXPPoiInfo.setDisplayLat(Double.parseDouble(xPFavoriteItem.getLat()));
                    this.mXPPoiInfo.setNaviLon(Double.parseDouble(xPFavoriteItem.getNavLon()));
                    this.mXPPoiInfo.setNaviLat(Double.parseDouble(xPFavoriteItem.getNavLat()));
                    this.mXPPoiInfo.setPoiId(xPFavoriteItem.getPoiId());
                    this.mXPPoiInfo.setCityCode(xPFavoriteItem.getCityCode());
                    this.mXPPoiInfo.setCityName(xPFavoriteItem.getCityName());
                    this.mXPPoiInfo.setTel(xPFavoriteItem.getPhoneNumbers());
                    this.mXPPoiInfo.setTag(xPFavoriteItem.getTag());
                    this.mXPPoiInfo.setOpenTime(xPFavoriteItem.getOpenTime());
                    this.mXPPoiInfo.setPrice(xPFavoriteItem.getPrice());
                    this.mXPPoiInfo.setName(xPFavoriteItem.getName());
                    this.mXPPoiInfo.setType(Integer.parseInt(xPFavoriteItem.getType()));
                    this.mXPPoiInfo.setCategory(Integer.parseInt(xPFavoriteItem.getCategory()));
                    this.mXPPoiInfo.setAddress(xPFavoriteItem.getAddress());
                    this.mXPPoiInfo.setOffline(Integer.parseInt(xPFavoriteItem.getIsOffline()) > 0);
                    this.mXPPoiInfo.setAdCode(Integer.parseInt(xPFavoriteItem.getAdCode()));
                    this.mXPPoiInfo.setProvinceName(xPFavoriteItem.getProvinceName());
                    this.mXPPoiInfo.setDistrictName(xPFavoriteItem.getDistrictName());
                    this.mXPPoiInfo.setIconType(xPFavoriteItem.getIconType());
                    this.mXPPoiInfo.setIconUrl(xPFavoriteItem.getIconUrl());
                    this.mXPPoiInfo.setParentID(xPFavoriteItem.getParentID());
                    this.mXPPoiInfo.setParentName(xPFavoriteItem.getParentName());
                    this.mXPPoiInfo.setParentSimpleName(xPFavoriteItem.getParentSimpleName());
                    this.mXPPoiInfo.setTypeCode(xPFavoriteItem.getTypeCode());
                    this.mXPPoiInfo.setOverhead(Short.parseShort(xPFavoriteItem.getOverHead()));
                    this.mXPPoiInfo.setHasPark(Integer.parseInt(xPFavoriteItem.getHasParkPois()) > 0);
                    this.mXPPoiInfo.setPoiSource(Integer.parseInt(xPFavoriteItem.getPoiSource()));
                    this.mXPPoiInfo.setBlCategory(xPFavoriteItem.getReserveA());
                    this.mXPPoiInfo.setReserveB(xPFavoriteItem.getReserveB());
                    this.mXPPoiInfo.setReserveC(xPFavoriteItem.getReserveC());
                    String childPoisJson = xPFavoriteItem.getChildPoisJson();
                    if (!TextUtils.isEmpty(childPoisJson)) {
                        ArrayList<XPPoiInfo> parseSimplePoisJson = parseSimplePoisJson(childPoisJson);
                        if (CollectionUtils.isNotEmpty(parseSimplePoisJson)) {
                            this.mXPPoiInfo.setChild(parseSimplePoisJson);
                        }
                    }
                    this.mXPPoiInfo.setReserveB(str);
                    this.mXPPoiInfo.setBlFavoriteItemId(xPFavoriteItem.getBLItemId());
                }
                this.mFavoriteType = Integer.parseInt(xPFavoriteItem.getFavoriteType());
                if (Integer.parseInt(xPFavoriteItem.getHasChildPois()) <= 0) {
                    z = false;
                }
                this.mHasChildPois = z;
                this.mBLItemId = xPFavoriteItem.getBLItemId();
                this.mBLType = xPFavoriteItem.getBLType();
                this.mBLNewType = xPFavoriteItem.getBLNewType();
                this.mBLCustomName = xPFavoriteItem.getBLCustomName();
                this.mBLClassification = xPFavoriteItem.getBLClassification();
                this.mBLPoiType = xPFavoriteItem.getBLPoiType();
                this.mBLCreateTime = Long.parseLong(xPFavoriteItem.getBLCreateTime());
                this.mBLTopTime = Long.parseLong(xPFavoriteItem.getBLTopTime());
                this.mBLVersion = xPFavoriteItem.getBLVersion();
                this.mIsCancelFavorite = false;
                this.mDataVersion = xPFavoriteItem.getDataVersion();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    protected FavoriteAddress(Parcel parcel) {
        this.mId = -1L;
        this.mHasClicked = false;
        this.mXPPoiInfo = new XPPoiInfo();
        this.mIsCancelFavorite = false;
        this.mIsCreateFromFavoriteItem = false;
        this.mId = parcel.readLong();
        this.mBLItemId = parcel.readString();
        this.mBLType = parcel.readString();
        this.mBLNewType = parcel.readString();
        this.mBLCustomName = parcel.readString();
        this.mBLClassification = parcel.readString();
        this.mBLPoiType = parcel.readString();
        this.mDataVersion = parcel.readLong();
        this.mBLCreateTime = parcel.readLong();
        this.mBLTopTime = parcel.readLong();
        this.mBLVersion = parcel.readString();
        this.mFavoriteType = parcel.readInt();
        this.mHasChildPois = parcel.readByte() != 0;
        this.mHasClicked = parcel.readByte() != 0;
        this.mXPPoiInfo = (XPPoiInfo) parcel.readParcelable(XPPoiInfo.class.getClassLoader());
        this.mIsCancelFavorite = parcel.readByte() != 0;
    }

    @Override // com.xiaopeng.montecarlo.navcore.bean.favorite.DataTransform, android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeLong(this.mId);
        parcel.writeString(this.mBLItemId);
        parcel.writeString(this.mBLType);
        parcel.writeString(this.mBLNewType);
        parcel.writeString(this.mBLCustomName);
        parcel.writeString(this.mBLClassification);
        parcel.writeString(this.mBLPoiType);
        parcel.writeLong(this.mDataVersion);
        parcel.writeLong(this.mBLCreateTime);
        parcel.writeLong(this.mBLTopTime);
        parcel.writeString(this.mBLVersion);
        parcel.writeInt(this.mFavoriteType);
        parcel.writeByte(this.mHasChildPois ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.mHasClicked ? (byte) 1 : (byte) 0);
        parcel.writeParcelable(this.mXPPoiInfo, i);
        parcel.writeByte(this.mIsCancelFavorite ? (byte) 1 : (byte) 0);
    }

    public FavoriteAddress deepClone() {
        Parcel obtain = Parcel.obtain();
        writeToParcel(obtain, 0);
        obtain.setDataPosition(0);
        FavoriteAddress createFromParcel = CREATOR.createFromParcel(obtain);
        obtain.recycle();
        return createFromParcel;
    }

    public String toString() {
        return GsonUtil.toJson(this);
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
        int i = this.mFavoriteType;
        if (i < 0) {
            i = 0;
        }
        contentValues.put("favorite_type", Integer.valueOf(i));
        contentValues.put("has_child_pois", Boolean.valueOf(this.mHasChildPois));
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
        contentValues.put("poi_source", Integer.valueOf(this.mXPPoiInfo.getPoiSource()));
        contentValues.put("reserve_a", this.mXPPoiInfo.getBlCategory() == null ? "" : this.mXPPoiInfo.getBlCategory());
        contentValues.put("reserve_b", this.mXPPoiInfo.getReserveB() == null ? "" : this.mXPPoiInfo.getReserveB());
        contentValues.put("reserve_c", this.mXPPoiInfo.getReserveC() == null ? "" : this.mXPPoiInfo.getReserveC());
        String str = this.mBLItemId;
        if (str == null) {
            str = "";
        }
        contentValues.put(NavFavoriteProvider.FavoriteColumns.BL_ITEM_ID, str);
        String str2 = this.mBLType;
        if (str2 == null) {
            str2 = "";
        }
        contentValues.put(NavFavoriteProvider.FavoriteColumns.BL_TYPE, str2);
        String str3 = this.mBLNewType;
        if (str3 == null) {
            str3 = "";
        }
        contentValues.put(NavFavoriteProvider.FavoriteColumns.BL_NEWTYPE, str3);
        String str4 = this.mBLCustomName;
        if (str4 == null) {
            str4 = "";
        }
        contentValues.put(NavFavoriteProvider.FavoriteColumns.BL_CUSTOMNAME, str4);
        String str5 = this.mBLClassification;
        if (str5 == null) {
            str5 = "";
        }
        contentValues.put(NavFavoriteProvider.FavoriteColumns.BL_CLASSIFICATION, str5);
        String str6 = this.mBLPoiType;
        if (str6 == null) {
            str6 = "";
        }
        contentValues.put(NavFavoriteProvider.FavoriteColumns.BL_POITYPE, str6);
        long j = this.mBLCreateTime;
        if (j < 0) {
            j = 0;
        }
        contentValues.put(NavFavoriteProvider.FavoriteColumns.BL_CREATETIME, Long.valueOf(j));
        long j2 = this.mBLTopTime;
        if (j2 < 0) {
            j2 = 0;
        }
        contentValues.put(NavFavoriteProvider.FavoriteColumns.BL_TOPTIME, Long.valueOf(j2));
        String str7 = this.mBLVersion;
        if (str7 == null) {
            str7 = "";
        }
        contentValues.put(NavFavoriteProvider.FavoriteColumns.BL_VERSION, str7);
        contentValues.put("data_version", Long.valueOf(this.mDataVersion));
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
            String string = cursor.getString(cursor.getColumnIndexOrThrow("category"));
            if (TextUtils.isEmpty(string)) {
                this.mXPPoiInfo.setCategory(100);
            } else {
                this.mXPPoiInfo.setCategory(Integer.valueOf(string).intValue());
            }
            this.mXPPoiInfo.setAddress(cursor.getString(cursor.getColumnIndexOrThrow("address")));
            this.mFavoriteType = cursor.getInt(cursor.getColumnIndexOrThrow("favorite_type"));
            this.mHasChildPois = cursor.getInt(cursor.getColumnIndexOrThrow("has_child_pois")) == 1;
            String string2 = cursor.getString(cursor.getColumnIndexOrThrow("child_pois_json"));
            if (!TextUtils.isEmpty(string2)) {
                ArrayList<XPPoiInfo> parseSimplePoisJson = parseSimplePoisJson(string2);
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
            this.mXPPoiInfo.setPoiSource(cursor.getInt(cursor.getColumnIndexOrThrow("poi_source")));
            this.mXPPoiInfo.setBlCategory(cursor.getString(cursor.getColumnIndexOrThrow("reserve_a")));
            this.mXPPoiInfo.setReserveB(cursor.getString(cursor.getColumnIndexOrThrow("reserve_b")));
            this.mXPPoiInfo.setReserveC(cursor.getString(cursor.getColumnIndexOrThrow("reserve_c")));
            this.mBLItemId = cursor.getString(cursor.getColumnIndexOrThrow(NavFavoriteProvider.FavoriteColumns.BL_ITEM_ID));
            this.mXPPoiInfo.setBlFavoriteItemId(this.mBLItemId);
            this.mBLType = cursor.getString(cursor.getColumnIndexOrThrow(NavFavoriteProvider.FavoriteColumns.BL_TYPE));
            this.mBLNewType = cursor.getString(cursor.getColumnIndexOrThrow(NavFavoriteProvider.FavoriteColumns.BL_NEWTYPE));
            this.mBLCustomName = cursor.getString(cursor.getColumnIndexOrThrow(NavFavoriteProvider.FavoriteColumns.BL_CUSTOMNAME));
            this.mBLClassification = cursor.getString(cursor.getColumnIndexOrThrow(NavFavoriteProvider.FavoriteColumns.BL_CLASSIFICATION));
            this.mBLPoiType = cursor.getString(cursor.getColumnIndexOrThrow(NavFavoriteProvider.FavoriteColumns.BL_POITYPE));
            this.mBLCreateTime = Long.parseLong(cursor.getString(cursor.getColumnIndexOrThrow(NavFavoriteProvider.FavoriteColumns.BL_CREATETIME)));
            this.mBLTopTime = Long.parseLong(cursor.getString(cursor.getColumnIndexOrThrow(NavFavoriteProvider.FavoriteColumns.BL_TOPTIME)));
            this.mBLVersion = cursor.getString(cursor.getColumnIndexOrThrow(NavFavoriteProvider.FavoriteColumns.BL_VERSION));
            this.mDataVersion = cursor.getLong(cursor.getColumnIndexOrThrow("data_version"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.bean.favorite.DataTransform
    public ContentValues toUpdateContentValues() {
        ContentValues contentValues = toContentValues();
        contentValues.remove("reserve_c");
        if (this.mIsCreateFromFavoriteItem) {
            contentValues.remove("poi_source");
        }
        return contentValues;
    }

    @Override // com.xiaopeng.montecarlo.navcore.bean.favorite.DataTransform
    @Nullable
    public ContentValues toInsertContentValues() {
        ContentValues contentValues = toContentValues();
        contentValues.put("reserve_c", Long.valueOf(System.currentTimeMillis()));
        return contentValues;
    }

    @NonNull
    public PoiBean toPoiBean() {
        return this.mXPPoiInfo.toPoiBean();
    }

    public FavoriteItem toFavoriteItem() {
        FavoriteItem favoriteItem = new FavoriteItem();
        favoriteItem.poiid = this.mXPPoiInfo.getPoiId();
        favoriteItem.name = this.mXPPoiInfo.getName();
        int i = this.mFavoriteType;
        if (i == 2) {
            favoriteItem.common_name = 1;
        } else if (i == 3) {
            favoriteItem.common_name = 2;
        } else {
            favoriteItem.common_name = 0;
        }
        favoriteItem.point_x = (int) this.mXPPoiInfo.getDisplayLon();
        favoriteItem.point_y = (int) this.mXPPoiInfo.getDisplayLat();
        favoriteItem.point_x_arrive = (int) this.mXPPoiInfo.getNaviLon();
        favoriteItem.point_y_arrive = (int) this.mXPPoiInfo.getNaviLat();
        if (!TextUtils.isEmpty(this.mBLItemId)) {
            favoriteItem.item_id = this.mBLItemId;
        }
        favoriteItem.city_name = this.mXPPoiInfo.getCityName();
        favoriteItem.city_code = this.mXPPoiInfo.getCityCode();
        favoriteItem.phone_numbers = this.mXPPoiInfo.getTel();
        favoriteItem.tag = this.mXPPoiInfo.getTag();
        favoriteItem.type = this.mBLType;
        favoriteItem.newType = this.mBLNewType;
        favoriteItem.custom_name = this.mBLCustomName;
        favoriteItem.address = this.mXPPoiInfo.getAddress();
        favoriteItem.classification = this.mBLClassification;
        favoriteItem.poi_type = this.mBLPoiType;
        long currentTimeMillis = System.currentTimeMillis();
        long j = this.mBLCreateTime;
        if (j > currentTimeMillis || j < ERROR_CREATE_TIME) {
            favoriteItem.create_time = (int) (currentTimeMillis / 1000);
        } else {
            favoriteItem.create_time = (int) (j / 1000);
        }
        long j2 = this.mBLTopTime;
        if (j2 > 0) {
            if (j2 > currentTimeMillis || j2 < ERROR_CREATE_TIME) {
                favoriteItem.top_time = (int) (currentTimeMillis / 1000);
            } else {
                favoriteItem.top_time = (int) (j2 / 1000);
            }
        }
        if (!TextUtils.isEmpty(this.mBLVersion)) {
            favoriteItem.version = this.mBLVersion;
        }
        return favoriteItem;
    }

    public boolean equals(Object obj) {
        if (obj instanceof FavoriteAddress) {
            return FavoriteUtil.favoriteEqual(this, (FavoriteAddress) obj);
        }
        return false;
    }
}
