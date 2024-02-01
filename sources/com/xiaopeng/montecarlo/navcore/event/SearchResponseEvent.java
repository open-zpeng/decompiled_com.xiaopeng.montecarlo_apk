package com.xiaopeng.montecarlo.navcore.event;

import android.graphics.RectF;
import android.os.Parcel;
import android.os.Parcelable;
import com.autonavi.gbl.common.model.RectFloat;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class SearchResponseEvent implements Parcelable {
    public static final Parcelable.Creator<SearchResponseEvent> CREATOR = new Parcelable.Creator<SearchResponseEvent>() { // from class: com.xiaopeng.montecarlo.navcore.event.SearchResponseEvent.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SearchResponseEvent createFromParcel(Parcel parcel) {
            return new SearchResponseEvent(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SearchResponseEvent[] newArray(int i) {
            return new SearchResponseEvent[i];
        }
    };
    public static final int SEARCH_TYPE_ALONGWAY = 7;
    public static final int SEARCH_TYPE_AROUND_RECOMMEND = 10;
    public static final int SEARCH_TYPE_CAR_SERVER = 13;
    public static final int SEARCH_TYPE_CHARGE = 12;
    public static final int SEARCH_TYPE_KEYWORD = 3;
    public static final int SEARCH_TYPE_KEYWORD_AROUND = 4;
    public static final int SEARCH_TYPE_KEYWORD_POI = 5;
    public static final int SEARCH_TYPE_LOCATION_CITY = 11;
    public static final int SEARCH_TYPE_NEAREST = 6;
    public static final int SEARCH_TYPE_POI_DEEP = 9;
    public static final int SEARCH_TYPE_POI_DETAIL = 8;
    public static final int SEARCH_TYPE_SUGGEST = 1;
    public static final int SEARCH_TYPE_SUGGEST_AROUND = 2;
    private boolean mCityLocation = false;
    private int mErrorCode;
    private ArrayList<XPPoiInfo> mList;
    private RectFloat mRectFloat;
    private int mSearchType;
    private int mTaskId;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public SearchResponseEvent(int i, ArrayList<XPPoiInfo> arrayList, int i2, int i3) {
        this.mSearchType = i;
        this.mList = arrayList;
        this.mTaskId = i2;
        this.mErrorCode = i3;
    }

    public SearchResponseEvent(int i, ArrayList<XPPoiInfo> arrayList, RectFloat rectFloat, int i2, int i3) {
        this.mSearchType = i;
        this.mList = arrayList;
        this.mRectFloat = rectFloat;
        this.mTaskId = i2;
        this.mErrorCode = i3;
    }

    protected SearchResponseEvent(Parcel parcel) {
        this.mSearchType = parcel.readInt();
        this.mList = parcel.createTypedArrayList(XPPoiInfo.CREATOR);
        RectF rectF = (RectF) parcel.readParcelable(RectF.class.getClassLoader());
        if (rectF.bottom != -1.0f && rectF.left != -1.0f && rectF.top != -1.0f && rectF.right != -1.0f) {
            this.mRectFloat = new RectFloat(rectF.left, rectF.top, rectF.right, rectF.bottom);
        }
        this.mRectFloat = (RectFloat) parcel.readParcelable(RectFloat.class.getClassLoader());
        this.mTaskId = parcel.readInt();
        this.mErrorCode = parcel.readInt();
    }

    public boolean isCityLocation() {
        return this.mCityLocation;
    }

    public void setCityLocation(boolean z) {
        this.mCityLocation = z;
    }

    public int getSearchType() {
        return this.mSearchType;
    }

    public void setType(int i) {
        this.mSearchType = i;
    }

    public ArrayList<XPPoiInfo> getList() {
        return this.mList;
    }

    public void setList(ArrayList<XPPoiInfo> arrayList) {
        this.mList = arrayList;
    }

    public RectFloat getRectFloat() {
        return this.mRectFloat;
    }

    public void setRectFloat(RectFloat rectFloat) {
        this.mRectFloat = rectFloat;
    }

    public int getTaskId() {
        return this.mTaskId;
    }

    public void setTaskId(int i) {
        this.mTaskId = i;
    }

    public int getErrorCode() {
        return this.mErrorCode;
    }

    public void setErrorCode(int i) {
        this.mErrorCode = i;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mSearchType);
        parcel.writeTypedList(this.mList);
        RectF rectF = new RectF(-1.0f, -1.0f, -1.0f, -1.0f);
        RectFloat rectFloat = this.mRectFloat;
        if (rectFloat != null) {
            rectF = new RectF(rectFloat.left, this.mRectFloat.top, this.mRectFloat.right, this.mRectFloat.bottom);
        }
        parcel.writeParcelable(rectF, i);
        parcel.writeInt(this.mTaskId);
        parcel.writeInt(this.mErrorCode);
    }
}
