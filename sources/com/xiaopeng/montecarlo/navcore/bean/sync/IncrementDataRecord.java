package com.xiaopeng.montecarlo.navcore.bean.sync;

import android.content.ContentValues;
import android.database.Cursor;
import androidx.annotation.Nullable;
import com.google.gson.annotations.SerializedName;
import com.xiaopeng.montecarlo.navcore.httpclient.dto.DataOperation;
import com.xiaopeng.montecarlo.root.provider.favorite.NavFavoriteProvider;
/* loaded from: classes3.dex */
public class IncrementDataRecord extends DataOperation {
    @SerializedName("favoriteType")
    private int mFavoriteType;
    @SerializedName("historyType")
    private int mHistoryType;
    @SerializedName("reserveA")
    private String mReserveA;
    @SerializedName("reserveB")
    private String mReserveB;
    @SerializedName("reserveC")
    private String mReserveC;

    public void setHistoryType(int i) {
        this.mHistoryType = i;
    }

    public int getHistoryType() {
        return this.mHistoryType;
    }

    public void setFavoriteType(int i) {
        this.mFavoriteType = i;
    }

    public int getFavoriteType() {
        return this.mFavoriteType;
    }

    public void setReserveA(String str) {
        this.mReserveA = str;
    }

    public String getReserveA() {
        return this.mReserveA;
    }

    public void setReserveB(String str) {
        this.mReserveB = str;
    }

    public String getReserveB() {
        return this.mReserveB;
    }

    public void setReserveC(String str) {
        this.mReserveC = str;
    }

    public String getReserveC() {
        return this.mReserveC;
    }

    public IncrementDataRecord() {
    }

    public IncrementDataRecord(DataOperation dataOperation) {
        setDataId(dataOperation.getDataId());
        setDataType(dataOperation.getDataType());
        setDataContent(dataOperation.getDataContent());
        setOperationType(dataOperation.getOperationType());
        setCreateTime(dataOperation.getCreateTime());
        setUpdateTime(dataOperation.getUpdateTime());
        setVersion(dataOperation.getVersion());
        setPreVersion(dataOperation.getPreVersion());
        this.mFavoriteType = 0;
        this.mHistoryType = 0;
    }

    public DataOperation toDataOperation() {
        DataOperation dataOperation = new DataOperation();
        dataOperation.setDataId(getDataId());
        dataOperation.setDataType(getDataType());
        dataOperation.setDataContent(getDataContent());
        dataOperation.setOperationType(getOperationType());
        dataOperation.setCreateTime(getCreateTime());
        dataOperation.setUpdateTime(getUpdateTime());
        dataOperation.setVersion(getVersion());
        dataOperation.setPreVersion(getPreVersion());
        return dataOperation;
    }

    @Override // com.xiaopeng.montecarlo.navcore.httpclient.dto.DataOperation, com.xiaopeng.montecarlo.navcore.bean.favorite.DataTransform
    @Nullable
    public ContentValues toContentValues() {
        ContentValues contentValues = new ContentValues();
        try {
            String str = "";
            contentValues.put(NavFavoriteProvider.IncrementColumns.DATA_ID, getDataId() == null ? "" : getDataId());
            contentValues.put("data_type", Integer.valueOf(getDataType()));
            contentValues.put(NavFavoriteProvider.IncrementColumns.DATA_CONTENT, getDataContent() == null ? "" : getDataContent());
            contentValues.put(NavFavoriteProvider.IncrementColumns.CREATE_TIME, Long.valueOf(getCreateTime()));
            contentValues.put(NavFavoriteProvider.IncrementColumns.UPDATE_TIME, Long.valueOf(getUpdateTime()));
            contentValues.put(NavFavoriteProvider.IncrementColumns.OP_TYPE, Integer.valueOf(getOperationType()));
            contentValues.put("version", Integer.valueOf(getVersion()));
            contentValues.put(NavFavoriteProvider.IncrementColumns.PRE_VERSION, Integer.valueOf(getPreVersion()));
            contentValues.put("history_type", Integer.valueOf(getHistoryType()));
            contentValues.put("favorite_type", Integer.valueOf(getFavoriteType()));
            contentValues.put("reserve_a", getReserveA() == null ? "" : getReserveA());
            contentValues.put("reserve_b", getReserveB() == null ? "" : getReserveB());
            if (getReserveC() != null) {
                str = getReserveC();
            }
            contentValues.put("reserve_c", str);
            return contentValues;
        } catch (Exception e) {
            e.printStackTrace();
            return contentValues;
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.httpclient.dto.DataOperation, com.xiaopeng.montecarlo.navcore.bean.favorite.DataTransform
    public void bindContentValues(Cursor cursor) {
        try {
            setDataId(cursor.getString(cursor.getColumnIndexOrThrow(NavFavoriteProvider.IncrementColumns.DATA_ID)));
            setDataType(cursor.getInt(cursor.getColumnIndexOrThrow("data_type")));
            setDataContent(cursor.getString(cursor.getColumnIndexOrThrow(NavFavoriteProvider.IncrementColumns.DATA_CONTENT)));
            setCreateTime(cursor.getLong(cursor.getColumnIndexOrThrow(NavFavoriteProvider.IncrementColumns.CREATE_TIME)));
            setUpdateTime(cursor.getLong(cursor.getColumnIndexOrThrow(NavFavoriteProvider.IncrementColumns.UPDATE_TIME)));
            setOperationType(cursor.getInt(cursor.getColumnIndexOrThrow(NavFavoriteProvider.IncrementColumns.OP_TYPE)));
            setVersion(cursor.getInt(cursor.getColumnIndexOrThrow("version")));
            setPreVersion(cursor.getInt(cursor.getColumnIndexOrThrow(NavFavoriteProvider.IncrementColumns.PRE_VERSION)));
            setHistoryType(cursor.getInt(cursor.getColumnIndexOrThrow("history_type")));
            setFavoriteType(cursor.getInt(cursor.getColumnIndexOrThrow("favorite_type")));
            setReserveA(cursor.getString(cursor.getColumnIndexOrThrow("reserve_a")));
            setReserveB(cursor.getString(cursor.getColumnIndexOrThrow("reserve_b")));
            setReserveC(cursor.getString(cursor.getColumnIndexOrThrow("reserve_c")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
