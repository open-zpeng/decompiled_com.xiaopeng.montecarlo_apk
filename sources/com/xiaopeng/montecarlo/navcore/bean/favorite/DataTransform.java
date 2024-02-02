package com.xiaopeng.montecarlo.navcore.bean.favorite;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.gson.reflect.TypeToken;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import com.xiaopeng.montecarlo.root.util.GsonUtil;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class DataTransform implements Parcelable {
    public static final Parcelable.Creator<DataTransform> CREATOR = new Parcelable.Creator<DataTransform>() { // from class: com.xiaopeng.montecarlo.navcore.bean.favorite.DataTransform.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DataTransform createFromParcel(Parcel parcel) {
            return new DataTransform(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DataTransform[] newArray(int i) {
            return new DataTransform[i];
        }
    };

    public void bindContentValues(Cursor cursor) {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public ContentValues toContentValues() {
        return null;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
    }

    public DataTransform() {
    }

    protected DataTransform(Parcel parcel) {
    }

    @Nullable
    public ContentValues toInsertContentValues() {
        return toContentValues();
    }

    public ContentValues toUpdateContentValues() {
        return toContentValues();
    }

    public String toSimplePoiJson(List<XPPoiInfo> list) {
        if (CollectionUtils.isNotEmpty(list)) {
            int size = list.size();
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < size; i++) {
                ChildPoiSimpleInfo childPoiSimpleInfo = new ChildPoiSimpleInfo();
                XPPoiInfo xPPoiInfo = list.get(i);
                childPoiSimpleInfo.setPoiId(xPPoiInfo.getPoiId());
                childPoiSimpleInfo.setPoiName(xPPoiInfo.getName());
                childPoiSimpleInfo.setPoiAddress(xPPoiInfo.getAddress());
                childPoiSimpleInfo.setPoiDistrictName(xPPoiInfo.getDistrictName());
                childPoiSimpleInfo.setPoiLat(xPPoiInfo.getDisplayLat());
                childPoiSimpleInfo.setPoiLon(xPPoiInfo.getDisplayLon());
                childPoiSimpleInfo.setPoiNavLat(xPPoiInfo.getNaviLat());
                childPoiSimpleInfo.setPoiNavLon(xPPoiInfo.getNaviLon());
                childPoiSimpleInfo.setPoiSource(xPPoiInfo.getPoiSource());
                childPoiSimpleInfo.setCategory(xPPoiInfo.getCategory());
                childPoiSimpleInfo.setBlCategory(xPPoiInfo.getBlCategory());
                arrayList.add(childPoiSimpleInfo);
            }
            return GsonUtil.toJson(arrayList);
        }
        return "";
    }

    @Nullable
    public ArrayList<XPPoiInfo> parseSimplePoisJson(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            List list = (List) GsonUtil.fromJson(str, new TypeToken<List<ChildPoiSimpleInfo>>() { // from class: com.xiaopeng.montecarlo.navcore.bean.favorite.DataTransform.2
            }.getType());
            if (CollectionUtils.isNotEmpty(list)) {
                ArrayList<XPPoiInfo> arrayList = new ArrayList<>();
                for (int i = 0; i < list.size(); i++) {
                    XPPoiInfo xPPoiInfo = new XPPoiInfo();
                    ChildPoiSimpleInfo childPoiSimpleInfo = (ChildPoiSimpleInfo) list.get(i);
                    xPPoiInfo.setPoiId(childPoiSimpleInfo.getPoiId());
                    xPPoiInfo.setName(childPoiSimpleInfo.getPoiName());
                    xPPoiInfo.setAddress(childPoiSimpleInfo.getPoiAddress());
                    xPPoiInfo.setDistrictName(childPoiSimpleInfo.getPoiDistrictName());
                    xPPoiInfo.setDisplayLat(childPoiSimpleInfo.getPoiLat());
                    xPPoiInfo.setDisplayLon(childPoiSimpleInfo.getPoiLon());
                    xPPoiInfo.setNaviLat(childPoiSimpleInfo.getPoiNavLat());
                    xPPoiInfo.setNaviLon(childPoiSimpleInfo.getPoiNavLon());
                    xPPoiInfo.setPoiSource(childPoiSimpleInfo.getPoiSource());
                    xPPoiInfo.setCategory(childPoiSimpleInfo.getCategory());
                    xPPoiInfo.setBlCategory(childPoiSimpleInfo.getBlCategory());
                    arrayList.add(xPPoiInfo);
                }
                return arrayList;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
