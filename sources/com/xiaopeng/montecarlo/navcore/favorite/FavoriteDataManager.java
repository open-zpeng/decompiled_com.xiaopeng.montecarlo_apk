package com.xiaopeng.montecarlo.navcore.favorite;

import android.app.Application;
import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.xiaopeng.montecarlo.navcore.bean.favorite.DataTransform;
import com.xiaopeng.montecarlo.navcore.bean.favorite.FavoriteAddress;
import com.xiaopeng.montecarlo.navcore.bean.favorite.HistoryRecordInfo;
import com.xiaopeng.montecarlo.navcore.bean.search.XPCoordinate2DDouble;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import com.xiaopeng.montecarlo.navcore.setting.SettingWrapper;
import com.xiaopeng.montecarlo.navcore.util.NavCoreUtil;
import com.xiaopeng.montecarlo.navcore.xptbt.TBTManager;
import com.xiaopeng.montecarlo.root.provider.dataset.DatabaseExceptionUtil;
import com.xiaopeng.montecarlo.root.provider.favorite.NavFavoriteProvider;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import com.xiaopeng.montecarlo.root.util.L;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes3.dex */
public class FavoriteDataManager {
    protected static final int DELETE = 3;
    protected static final int DELETE_ALL = 4;
    protected static final int DELETE_ALL_NORMAL_FAV = 5;
    protected static final int DELETE_LIST = 8;
    protected static final int DELETE_USER_DATA = 12;
    public static final int FAVORITE_HOME_DISTANCE = 25;
    public static final int FAVORITE_NORMAL_DISTANCE = 100;
    public static final int HISTORY_RECORD_DESTINATION_DISTANCE = 50;
    protected static final int INSERT = 1;
    protected static final int INSERT_LIST = 6;
    protected static final int INSERT_REPLACE_LIST = 9;
    protected static final int REPLACE = 10;
    protected static final int REPLACE_HOME_OR_COMPANY = 11;
    private static final int SUG_MAX_HISTORY_RECORDS = 3;
    protected static final int UPDATE = 2;
    protected static final int UPDATE_LIST = 7;
    private Application mContext;
    private static final FavoriteDataManager sInstance = new FavoriteDataManager();
    private static final L.Tag TAG = new L.Tag("FavoriteDataManager");
    private static FavoriteCache sFavoriteCache = null;
    protected OnFavoriteDataChangeListener mIncreSyncFavDataChangeListener = null;
    protected OnHistoryDataChangeListener mIncreSyncHistoryDataChangeListener = null;
    protected OnUserDataChangeListener mOnUserDataChangeListener = null;
    private List<OnFavoriteDataChangeListener> mOnFavDataChangeListenerList = new ArrayList();
    private List<OnHistoryDataChangeListener> mOnHistoryDataChangeListenerList = new ArrayList();

    /* loaded from: classes3.dex */
    public interface OnFavoriteDataChangeListener {
        void onFavClear(List<FavoriteAddress> list);

        void onFavItemAdded(FavoriteAddress favoriteAddress);

        void onFavItemRemoved(FavoriteAddress favoriteAddress);

        void onFavItemReplace(List<FavoriteAddress> list, List<FavoriteAddress> list2);

        void onFavItemUpdate(FavoriteAddress favoriteAddress);

        void onFavListAddOrUpdate(List<FavoriteAddress> list, List<FavoriteAddress> list2);

        void onFavListAdded(List<FavoriteAddress> list);

        void onFavListRemoved(List<FavoriteAddress> list);

        void onFavListUpdate(List<FavoriteAddress> list);

        void onNormalFavClear(List<FavoriteAddress> list);
    }

    /* loaded from: classes3.dex */
    public interface OnHistoryDataChangeListener {
        void onHistoryItemAdded(HistoryRecordInfo historyRecordInfo);

        void onHistoryItemRemoved(HistoryRecordInfo historyRecordInfo);

        void onHistoryItemUpdate(HistoryRecordInfo historyRecordInfo);

        void onHistoryListAddOrUpdate(List<HistoryRecordInfo> list, List<HistoryRecordInfo> list2);

        void onHistoryListAdded(List<HistoryRecordInfo> list);

        void onHistoryListRemoved(List<HistoryRecordInfo> list);

        void onHistoryListUpdate(List<HistoryRecordInfo> list);

        void onHistoryRecordInfoClear(List<HistoryRecordInfo> list);
    }

    /* loaded from: classes3.dex */
    public interface OnUserDataChangeListener {
        void onDeleteUserData(int i, int i2);
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface OperateType {
    }

    private int getLimitOffset(int i, int i2) {
        if (i > 0) {
            return (i - 1) * i2;
        }
        return 0;
    }

    public void setIncreSyncFavDataChangeListener(OnFavoriteDataChangeListener onFavoriteDataChangeListener) {
        this.mIncreSyncFavDataChangeListener = onFavoriteDataChangeListener;
    }

    public void setIncreSyncHistoryDataChangeListener(OnHistoryDataChangeListener onHistoryDataChangeListener) {
        this.mIncreSyncHistoryDataChangeListener = onHistoryDataChangeListener;
    }

    public void setOnUserDataChangeListener(OnUserDataChangeListener onUserDataChangeListener) {
        this.mOnUserDataChangeListener = onUserDataChangeListener;
    }

    public FavoriteDataManager() {
        checkCacheValid();
    }

    @NonNull
    public static FavoriteDataManager getInstance() {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "getInstance sInstance:" + sInstance);
        }
        return sInstance;
    }

    public static void sortFavoriteList(List<FavoriteAddress> list) {
        Collections.sort(list, new Comparator<FavoriteAddress>() { // from class: com.xiaopeng.montecarlo.navcore.favorite.FavoriteDataManager.1
            @Override // java.util.Comparator
            public int compare(FavoriteAddress favoriteAddress, FavoriteAddress favoriteAddress2) {
                if (favoriteAddress.getBLCreateTime() < favoriteAddress2.getBLCreateTime()) {
                    return 1;
                }
                return (favoriteAddress.getBLCreateTime() != favoriteAddress2.getBLCreateTime() || favoriteAddress.getXPPoiInfo().getDistance() > favoriteAddress2.getXPPoiInfo().getDistance()) ? -1 : 1;
            }
        });
    }

    public void init(Application application) {
        this.mContext = application;
    }

    private void notifyProviderDataChange(Uri uri) {
        L.Tag tag = TAG;
        L.i(tag, "NavFavoriteProvider notifyProviderDataChange uri： " + uri);
        getContentResolver().notifyChange(uri, null);
    }

    private void notifyProviderDataChange(List<Uri> list) {
        if (list != null) {
            L.Tag tag = TAG;
            L.i(tag, "NavFavoriteProvider notifyProviderDataChange uri size： " + list.size());
            for (Uri uri : list) {
                getContentResolver().notifyChange(uri, null);
            }
        }
    }

    @Nullable
    private Uri getUriFromEntity(Object obj) {
        return getUriFromClass(obj.getClass().getName());
    }

    private Uri getUriFromClass(String str) {
        if (FavoriteAddress.class.getName().equals(str)) {
            return NavFavoriteProvider.FAVORITE_CONTENT_URI;
        }
        if (HistoryRecordInfo.class.getName().equals(str)) {
            return NavFavoriteProvider.HISTORY_CONTENT_URI;
        }
        new IllegalArgumentException("FavoriteDataManager unknown object type " + str).printStackTrace();
        return null;
    }

    private Uri getDeleteUriFromEntity(Object obj) {
        if (obj instanceof FavoriteAddress) {
            return NavFavoriteProvider.FAVORITE_DELETE_URI;
        }
        if (obj instanceof HistoryRecordInfo) {
            return NavFavoriteProvider.HISTORY_DELETE_URI;
        }
        new IllegalArgumentException("FavoriteDataManager unknown object type " + obj.getClass().getSimpleName()).printStackTrace();
        return null;
    }

    private Uri getUpdateUriFromEntity(Object obj) {
        if (obj instanceof FavoriteAddress) {
            return NavFavoriteProvider.FAVORITE_CONTENT_URI;
        }
        if (obj instanceof HistoryRecordInfo) {
            return NavFavoriteProvider.HISTORY_CONTENT_URI;
        }
        new IllegalArgumentException("FavoriteDataManager unknown object type " + obj.getClass().getSimpleName()).printStackTrace();
        return null;
    }

    public long isExist(@NonNull FavoriteAddress favoriteAddress) {
        int favoriteType = favoriteAddress.getFavoriteType();
        if (favoriteType == 2 || favoriteType == 3) {
            return isHomeOrCompanyExist(favoriteAddress);
        }
        return isFavoriteExist(favoriteAddress);
    }

    private long isFavoriteExist(@NonNull FavoriteAddress favoriteAddress) {
        List<Long> existIdList = getExistIdList(favoriteAddress);
        if (CollectionUtils.isEmpty(existIdList)) {
            return -1L;
        }
        return existIdList.get(0).longValue();
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x009c, code lost:
        if (r8 != null) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00a5, code lost:
        if (r8 == null) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00a7, code lost:
        r8.close();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.util.List<java.lang.Long> getExistIdList(@androidx.annotation.NonNull com.xiaopeng.montecarlo.navcore.bean.favorite.FavoriteAddress r11) {
        /*
            r10 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo r1 = r11.getXPPoiInfo()
            if (r1 == 0) goto Lb1
            com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo r1 = r11.getXPPoiInfo()
            java.lang.String r1 = r1.getName()
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 == 0) goto L1b
            goto Lb1
        L1b:
            android.net.Uri r3 = r10.getUriFromEntity(r11)
            if (r3 == 0) goto Lb1
            android.app.Application r1 = r10.mContext
            android.content.ContentResolver r2 = r1.getContentResolver()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r4 = ""
            r1.<init>(r4)
            java.lang.String r5 = "favorite_type = ?"
            r1.append(r5)
            java.lang.String r5 = " and "
            r1.append(r5)
            java.lang.String r5 = "name = ?"
            r1.append(r5)
            r8 = 0
            r5 = 0
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L9f java.lang.Exception -> La1
            r6 = 2
            java.lang.String[] r6 = new java.lang.String[r6]     // Catch: java.lang.Throwable -> L9f java.lang.Exception -> La1
            r7 = 0
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L9f java.lang.Exception -> La1
            r9.<init>()     // Catch: java.lang.Throwable -> L9f java.lang.Exception -> La1
            r9.append(r4)     // Catch: java.lang.Throwable -> L9f java.lang.Exception -> La1
            int r4 = r11.getFavoriteType()     // Catch: java.lang.Throwable -> L9f java.lang.Exception -> La1
            r9.append(r4)     // Catch: java.lang.Throwable -> L9f java.lang.Exception -> La1
            java.lang.String r4 = r9.toString()     // Catch: java.lang.Throwable -> L9f java.lang.Exception -> La1
            r6[r7] = r4     // Catch: java.lang.Throwable -> L9f java.lang.Exception -> La1
            r4 = 1
            com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo r7 = r11.getXPPoiInfo()     // Catch: java.lang.Throwable -> L9f java.lang.Exception -> La1
            java.lang.String r7 = r7.getName()     // Catch: java.lang.Throwable -> L9f java.lang.Exception -> La1
            r6[r4] = r7     // Catch: java.lang.Throwable -> L9f java.lang.Exception -> La1
            r7 = 0
            r4 = r5
            r5 = r1
            android.database.Cursor r8 = r2.query(r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L9f java.lang.Exception -> La1
            if (r8 == 0) goto L9c
            int r1 = r8.getCount()     // Catch: java.lang.Throwable -> L9f java.lang.Exception -> La1
            if (r1 <= 0) goto L9c
            r8.moveToFirst()     // Catch: java.lang.Throwable -> L9f java.lang.Exception -> La1
        L79:
            boolean r1 = r8.isAfterLast()     // Catch: java.lang.Throwable -> L9f java.lang.Exception -> La1
            if (r1 != 0) goto L9c
            com.xiaopeng.montecarlo.navcore.bean.favorite.FavoriteAddress r1 = new com.xiaopeng.montecarlo.navcore.bean.favorite.FavoriteAddress     // Catch: java.lang.Throwable -> L9f java.lang.Exception -> La1
            r1.<init>()     // Catch: java.lang.Throwable -> L9f java.lang.Exception -> La1
            r1.bindContentValues(r8)     // Catch: java.lang.Throwable -> L9f java.lang.Exception -> La1
            boolean r2 = com.xiaopeng.montecarlo.navcore.favorite.FavoriteUtil.favoriteEqual(r11, r1)     // Catch: java.lang.Throwable -> L9f java.lang.Exception -> La1
            if (r2 == 0) goto L98
            long r1 = r1.getId()     // Catch: java.lang.Throwable -> L9f java.lang.Exception -> La1
            java.lang.Long r1 = java.lang.Long.valueOf(r1)     // Catch: java.lang.Throwable -> L9f java.lang.Exception -> La1
            r0.add(r1)     // Catch: java.lang.Throwable -> L9f java.lang.Exception -> La1
        L98:
            r8.moveToNext()     // Catch: java.lang.Throwable -> L9f java.lang.Exception -> La1
            goto L79
        L9c:
            if (r8 == 0) goto Lb1
            goto La7
        L9f:
            r11 = move-exception
            goto Lab
        La1:
            r11 = move-exception
            com.xiaopeng.montecarlo.root.provider.dataset.DatabaseExceptionUtil.handleException(r11)     // Catch: java.lang.Throwable -> L9f
            if (r8 == 0) goto Lb1
        La7:
            r8.close()
            goto Lb1
        Lab:
            if (r8 == 0) goto Lb0
            r8.close()
        Lb0:
            throw r11
        Lb1:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaopeng.montecarlo.navcore.favorite.FavoriteDataManager.getExistIdList(com.xiaopeng.montecarlo.navcore.bean.favorite.FavoriteAddress):java.util.List");
    }

    public long isHomeOrCompanyExist(@NonNull FavoriteAddress favoriteAddress) {
        if (favoriteAddress.getXPPoiInfo() == null) {
            return -1L;
        }
        int favoriteType = favoriteAddress.getFavoriteType();
        if (favoriteType == 2 || favoriteType == 3) {
            FavoriteAddress favoriteAddress2 = null;
            if (favoriteType == 2) {
                favoriteAddress2 = getHomeCache();
            } else if (favoriteType == 3) {
                favoriteAddress2 = getCompanyCache();
            }
            if (favoriteAddress2 != null && FavoriteUtil.favoriteEqual(favoriteAddress, favoriteAddress2)) {
                long id = favoriteAddress2.getId();
                if (id > 0) {
                    return id;
                }
                return 1L;
            }
        }
        return -1L;
    }

    public long isExist(@NonNull HistoryRecordInfo historyRecordInfo) {
        List<Long> existIdList = getExistIdList(historyRecordInfo);
        if (CollectionUtils.isEmpty(existIdList)) {
            return -1L;
        }
        return existIdList.get(0).longValue();
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0083, code lost:
        if (r2 == null) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x008f, code lost:
        if (r2 != null) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0091, code lost:
        r2.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0098, code lost:
        if (r0.isEmpty() != false) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x009e, code lost:
        if (r0.size() <= 1) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00a0, code lost:
        com.xiaopeng.montecarlo.root.util.L.e(com.xiaopeng.montecarlo.navcore.favorite.FavoriteDataManager.TAG, "history record has multi local record!!");
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00ad, code lost:
        return (com.xiaopeng.montecarlo.navcore.bean.favorite.HistoryRecordInfo) r0.get(0);
     */
    /* JADX WARN: Not initialized variable reg: 2, insn: 0x0087: MOVE  (r1 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:31:0x0087 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private com.xiaopeng.montecarlo.navcore.bean.favorite.HistoryRecordInfo getExistHistoryRecord(@androidx.annotation.NonNull com.xiaopeng.montecarlo.navcore.bean.favorite.HistoryRecordInfo r12) {
        /*
            r11 = this;
            com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo r0 = r12.getXPPoiInfo()
            r1 = 0
            if (r0 == 0) goto Lae
            com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo r0 = r12.getXPPoiInfo()
            java.lang.String r0 = r0.getName()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L17
            goto Lae
        L17:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            android.net.Uri r3 = r11.getUriFromEntity(r12)
            r8 = 0
            r9 = 1
            if (r3 == 0) goto L8e
            android.content.ContentResolver r2 = r11.getContentResolver()     // Catch: java.lang.Throwable -> L7c java.lang.Exception -> L7e
            java.lang.String r5 = "history_type = ? and name = ?"
            r4 = 0
            r6 = 2
            java.lang.String[] r6 = new java.lang.String[r6]     // Catch: java.lang.Throwable -> L7c java.lang.Exception -> L7e
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L7c java.lang.Exception -> L7e
            r7.<init>()     // Catch: java.lang.Throwable -> L7c java.lang.Exception -> L7e
            java.lang.String r10 = ""
            r7.append(r10)     // Catch: java.lang.Throwable -> L7c java.lang.Exception -> L7e
            int r10 = r12.getHistoryType()     // Catch: java.lang.Throwable -> L7c java.lang.Exception -> L7e
            r7.append(r10)     // Catch: java.lang.Throwable -> L7c java.lang.Exception -> L7e
            java.lang.String r7 = r7.toString()     // Catch: java.lang.Throwable -> L7c java.lang.Exception -> L7e
            r6[r8] = r7     // Catch: java.lang.Throwable -> L7c java.lang.Exception -> L7e
            com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo r7 = r12.getXPPoiInfo()     // Catch: java.lang.Throwable -> L7c java.lang.Exception -> L7e
            java.lang.String r7 = r7.getName()     // Catch: java.lang.Throwable -> L7c java.lang.Exception -> L7e
            r6[r9] = r7     // Catch: java.lang.Throwable -> L7c java.lang.Exception -> L7e
            r7 = 0
            android.database.Cursor r2 = r2.query(r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L7c java.lang.Exception -> L7e
            if (r2 == 0) goto L8f
            int r3 = r2.getCount()     // Catch: java.lang.Exception -> L7a java.lang.Throwable -> L86
            if (r3 <= 0) goto L8f
            r2.moveToFirst()     // Catch: java.lang.Exception -> L7a java.lang.Throwable -> L86
        L5f:
            boolean r3 = r2.isAfterLast()     // Catch: java.lang.Exception -> L7a java.lang.Throwable -> L86
            if (r3 != 0) goto L8f
            com.xiaopeng.montecarlo.navcore.bean.favorite.HistoryRecordInfo r3 = new com.xiaopeng.montecarlo.navcore.bean.favorite.HistoryRecordInfo     // Catch: java.lang.Exception -> L7a java.lang.Throwable -> L86
            r3.<init>()     // Catch: java.lang.Exception -> L7a java.lang.Throwable -> L86
            r3.bindContentValues(r2)     // Catch: java.lang.Exception -> L7a java.lang.Throwable -> L86
            boolean r4 = com.xiaopeng.montecarlo.navcore.favorite.FavoriteUtil.historyRecordEqual(r12, r3)     // Catch: java.lang.Exception -> L7a java.lang.Throwable -> L86
            if (r4 == 0) goto L76
            r0.add(r3)     // Catch: java.lang.Exception -> L7a java.lang.Throwable -> L86
        L76:
            r2.moveToNext()     // Catch: java.lang.Exception -> L7a java.lang.Throwable -> L86
            goto L5f
        L7a:
            r12 = move-exception
            goto L80
        L7c:
            r12 = move-exception
            goto L88
        L7e:
            r12 = move-exception
            r2 = r1
        L80:
            com.xiaopeng.montecarlo.root.provider.dataset.DatabaseExceptionUtil.handleException(r12)     // Catch: java.lang.Throwable -> L86
            if (r2 == 0) goto L94
            goto L91
        L86:
            r12 = move-exception
            r1 = r2
        L88:
            if (r1 == 0) goto L8d
            r1.close()
        L8d:
            throw r12
        L8e:
            r2 = r1
        L8f:
            if (r2 == 0) goto L94
        L91:
            r2.close()
        L94:
            boolean r12 = r0.isEmpty()
            if (r12 != 0) goto Lae
            int r12 = r0.size()
            if (r12 <= r9) goto La7
            com.xiaopeng.montecarlo.root.util.L$Tag r12 = com.xiaopeng.montecarlo.navcore.favorite.FavoriteDataManager.TAG
            java.lang.String r1 = "history record has multi local record!!"
            com.xiaopeng.montecarlo.root.util.L.e(r12, r1)
        La7:
            java.lang.Object r12 = r0.get(r8)
            com.xiaopeng.montecarlo.navcore.bean.favorite.HistoryRecordInfo r12 = (com.xiaopeng.montecarlo.navcore.bean.favorite.HistoryRecordInfo) r12
            return r12
        Lae:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaopeng.montecarlo.navcore.favorite.FavoriteDataManager.getExistHistoryRecord(com.xiaopeng.montecarlo.navcore.bean.favorite.HistoryRecordInfo):com.xiaopeng.montecarlo.navcore.bean.favorite.HistoryRecordInfo");
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x00a2, code lost:
        if (r2 == null) goto L34;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.util.List<java.lang.Long> getExistIdList(@androidx.annotation.NonNull com.xiaopeng.montecarlo.navcore.bean.favorite.HistoryRecordInfo r11) {
        /*
            r10 = this;
            java.lang.String r0 = ""
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo r2 = r11.getXPPoiInfo()
            if (r2 == 0) goto Lb0
            com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo r2 = r11.getXPPoiInfo()
            java.lang.String r2 = r2.getName()
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 == 0) goto L1d
            goto Lb0
        L1d:
            android.net.Uri r4 = r10.getUriFromEntity(r11)
            r2 = 0
            if (r4 == 0) goto Lab
            android.content.ContentResolver r3 = r10.getContentResolver()     // Catch: java.lang.Throwable -> L9c java.lang.Exception -> L9e
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L9c java.lang.Exception -> L9e
            r5.<init>(r0)     // Catch: java.lang.Throwable -> L9c java.lang.Exception -> L9e
            java.lang.String r6 = "history_type = ?"
            r5.append(r6)     // Catch: java.lang.Throwable -> L9c java.lang.Exception -> L9e
            java.lang.String r6 = " and "
            r5.append(r6)     // Catch: java.lang.Throwable -> L9c java.lang.Exception -> L9e
            java.lang.String r6 = "name = ?"
            r5.append(r6)     // Catch: java.lang.Throwable -> L9c java.lang.Exception -> L9e
            r6 = 0
            java.lang.String r7 = r5.toString()     // Catch: java.lang.Throwable -> L9c java.lang.Exception -> L9e
            r5 = 2
            java.lang.String[] r8 = new java.lang.String[r5]     // Catch: java.lang.Throwable -> L9c java.lang.Exception -> L9e
            r5 = 0
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L9c java.lang.Exception -> L9e
            r9.<init>()     // Catch: java.lang.Throwable -> L9c java.lang.Exception -> L9e
            r9.append(r0)     // Catch: java.lang.Throwable -> L9c java.lang.Exception -> L9e
            int r0 = r11.getHistoryType()     // Catch: java.lang.Throwable -> L9c java.lang.Exception -> L9e
            r9.append(r0)     // Catch: java.lang.Throwable -> L9c java.lang.Exception -> L9e
            java.lang.String r0 = r9.toString()     // Catch: java.lang.Throwable -> L9c java.lang.Exception -> L9e
            r8[r5] = r0     // Catch: java.lang.Throwable -> L9c java.lang.Exception -> L9e
            r0 = 1
            com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo r5 = r11.getXPPoiInfo()     // Catch: java.lang.Throwable -> L9c java.lang.Exception -> L9e
            java.lang.String r5 = r5.getName()     // Catch: java.lang.Throwable -> L9c java.lang.Exception -> L9e
            r8[r0] = r5     // Catch: java.lang.Throwable -> L9c java.lang.Exception -> L9e
            r0 = 0
            r5 = r6
            r6 = r7
            r7 = r8
            r8 = r0
            android.database.Cursor r2 = r3.query(r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L9c java.lang.Exception -> L9e
            if (r2 == 0) goto Lab
            int r0 = r2.getCount()     // Catch: java.lang.Throwable -> L9c java.lang.Exception -> L9e
            if (r0 <= 0) goto Lab
            r2.moveToFirst()     // Catch: java.lang.Throwable -> L9c java.lang.Exception -> L9e
        L79:
            boolean r0 = r2.isAfterLast()     // Catch: java.lang.Throwable -> L9c java.lang.Exception -> L9e
            if (r0 != 0) goto Lab
            com.xiaopeng.montecarlo.navcore.bean.favorite.HistoryRecordInfo r0 = new com.xiaopeng.montecarlo.navcore.bean.favorite.HistoryRecordInfo     // Catch: java.lang.Throwable -> L9c java.lang.Exception -> L9e
            r0.<init>()     // Catch: java.lang.Throwable -> L9c java.lang.Exception -> L9e
            r0.bindContentValues(r2)     // Catch: java.lang.Throwable -> L9c java.lang.Exception -> L9e
            boolean r3 = com.xiaopeng.montecarlo.navcore.favorite.FavoriteUtil.historyRecordEqual(r11, r0)     // Catch: java.lang.Throwable -> L9c java.lang.Exception -> L9e
            if (r3 == 0) goto L98
            long r3 = r0.getId()     // Catch: java.lang.Throwable -> L9c java.lang.Exception -> L9e
            java.lang.Long r0 = java.lang.Long.valueOf(r3)     // Catch: java.lang.Throwable -> L9c java.lang.Exception -> L9e
            r1.add(r0)     // Catch: java.lang.Throwable -> L9c java.lang.Exception -> L9e
        L98:
            r2.moveToNext()     // Catch: java.lang.Throwable -> L9c java.lang.Exception -> L9e
            goto L79
        L9c:
            r11 = move-exception
            goto La5
        L9e:
            r11 = move-exception
            com.xiaopeng.montecarlo.root.provider.dataset.DatabaseExceptionUtil.handleException(r11)     // Catch: java.lang.Throwable -> L9c
            if (r2 == 0) goto Lb0
            goto Lad
        La5:
            if (r2 == 0) goto Laa
            r2.close()
        Laa:
            throw r11
        Lab:
            if (r2 == 0) goto Lb0
        Lad:
            r2.close()
        Lb0:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaopeng.montecarlo.navcore.favorite.FavoriteDataManager.getExistIdList(com.xiaopeng.montecarlo.navcore.bean.favorite.HistoryRecordInfo):java.util.List");
    }

    private long isExist(DataTransform dataTransform) {
        if (dataTransform instanceof FavoriteAddress) {
            return isExist((FavoriteAddress) dataTransform);
        }
        if (dataTransform instanceof HistoryRecordInfo) {
            return isExist((HistoryRecordInfo) dataTransform);
        }
        return -1L;
    }

    public void insertOrReplaceHistoryKeyword(@NonNull String str) {
        HistoryRecordInfo historyRecordInfo = new HistoryRecordInfo();
        historyRecordInfo.setHistoryType(1);
        historyRecordInfo.getXPPoiInfo().setName(str);
        String generateKeywordPoiId = XPPoiInfo.generateKeywordPoiId(historyRecordInfo.getXPPoiInfo());
        if (!TextUtils.isEmpty(generateKeywordPoiId)) {
            historyRecordInfo.getXPPoiInfo().setPoiId(generateKeywordPoiId);
        }
        historyRecordInfo.setCreateTime(System.currentTimeMillis());
        insertOrReplace(historyRecordInfo);
    }

    public boolean insertOrReplace(@NonNull FavoriteAddress favoriteAddress) {
        long isExist = isExist(favoriteAddress);
        long accountMaxFavoriteVersion = SettingWrapper.getAccountMaxFavoriteVersion() + 1;
        favoriteAddress.setDataVersion(accountMaxFavoriteVersion);
        if (isExist < 0) {
            Uri commonInsert = commonInsert(favoriteAddress);
            if (commonInsert == null || ContentUris.parseId(commonInsert) < 0) {
                return false;
            }
            SettingWrapper.saveAccountMaxFavoriteVersion(accountMaxFavoriteVersion);
            return true;
        } else if (update(favoriteAddress, isExist) > 0) {
            SettingWrapper.saveAccountMaxFavoriteVersion(accountMaxFavoriteVersion);
            return true;
        } else {
            return false;
        }
    }

    public boolean insertOrReplace(@NonNull HistoryRecordInfo historyRecordInfo) {
        HistoryRecordInfo existHistoryRecord = getExistHistoryRecord(historyRecordInfo);
        long accountMaxHistoryVersion = SettingWrapper.getAccountMaxHistoryVersion() + 1;
        historyRecordInfo.setDataVersion(accountMaxHistoryVersion);
        if (existHistoryRecord == null) {
            historyRecordInfo.setUpdateCount(historyRecordInfo.getUpdateCount() + 1);
            Uri commonInsert = commonInsert(historyRecordInfo);
            if (commonInsert == null || ContentUris.parseId(commonInsert) < 0) {
                return false;
            }
            SettingWrapper.saveAccountMaxHistoryVersion(accountMaxHistoryVersion);
            return true;
        }
        historyRecordInfo.setUpdateCount(existHistoryRecord.getUpdateCount() + 1);
        if (update(historyRecordInfo, existHistoryRecord.getId()) > 0) {
            SettingWrapper.saveAccountMaxHistoryVersion(accountMaxHistoryVersion);
            return true;
        }
        return false;
    }

    @Nullable
    private Uri commonInsert(@NonNull DataTransform dataTransform) {
        try {
            Uri insert = getContentResolver().insert(getUriFromEntity(dataTransform), dataTransform.toInsertContentValues());
            if (insert == null || ContentUris.parseId(insert) < 0) {
                return null;
            }
            notifyProviderDataChange(insert);
            notifyDataChange(1, dataTransform);
            return insert;
        } catch (Exception e) {
            DatabaseExceptionUtil.handleException(e);
            return null;
        }
    }

    @Deprecated
    public int updateFavoriteList(List<FavoriteAddress> list) {
        List<DataTransform> arrayList = new ArrayList<>();
        int size = list.size();
        long[] jArr = new long[size];
        for (int i = 0; i < size; i++) {
            FavoriteAddress favoriteAddress = list.get(i);
            arrayList.add(favoriteAddress);
            long isExist = isExist(favoriteAddress);
            if (isExist >= 0) {
                jArr[i] = isExist;
            }
        }
        if (jArr.length != size) {
            return 0;
        }
        return applyUpdateBatch(jArr, arrayList);
    }

    @Deprecated
    public int updateHistoryList(List<HistoryRecordInfo> list) {
        List<DataTransform> arrayList = new ArrayList<>();
        int size = list.size();
        long[] jArr = new long[size];
        for (int i = 0; i < size; i++) {
            HistoryRecordInfo historyRecordInfo = list.get(i);
            arrayList.add(historyRecordInfo);
            long isExist = isExist(historyRecordInfo);
            if (isExist >= 0) {
                jArr[i] = isExist;
            }
        }
        if (jArr.length != size) {
            return 0;
        }
        return applyUpdateBatch(jArr, arrayList);
    }

    public int update(@NonNull FavoriteAddress favoriteAddress) {
        long accountMaxFavoriteVersion = SettingWrapper.getAccountMaxFavoriteVersion() + 1;
        favoriteAddress.setDataVersion(accountMaxFavoriteVersion);
        int update = update(favoriteAddress, favoriteAddress.getId());
        if (update > 0) {
            SettingWrapper.saveAccountMaxFavoriteVersion(accountMaxFavoriteVersion);
        }
        return update;
    }

    private int update(@NonNull DataTransform dataTransform, long j) {
        ContentResolver contentResolver = getContentResolver();
        Uri uriFromEntity = getUriFromEntity(dataTransform);
        if (j <= 0) {
            j = isExist(dataTransform);
        }
        if (j > 0) {
            try {
                Uri withAppendedId = ContentUris.withAppendedId(uriFromEntity, j);
                int update = contentResolver.update(withAppendedId, dataTransform.toUpdateContentValues(), null, null);
                if (update > 0) {
                    notifyProviderDataChange(withAppendedId);
                    notifyDataChange(2, dataTransform);
                }
                return update;
            } catch (Exception e) {
                DatabaseExceptionUtil.handleException(e);
                return 0;
            }
        }
        return 0;
    }

    private int applyUpdateBatch(@NonNull long[] jArr, @NonNull List<DataTransform> list) {
        if (CollectionUtils.isEmpty(list)) {
            return 0;
        }
        try {
            ContentResolver contentResolver = getContentResolver();
            int size = list.size();
            Uri uriFromEntity = getUriFromEntity(list.get(0));
            ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                ContentProviderOperation.Builder newUpdate = ContentProviderOperation.newUpdate(ContentUris.withAppendedId(uriFromEntity, jArr[i]));
                newUpdate.withValues(list.get(i).toUpdateContentValues());
                arrayList.add(newUpdate.build());
            }
            ContentProviderResult[] applyBatch = contentResolver.applyBatch(NavFavoriteProvider.AUTHORITY, arrayList);
            int i2 = 0;
            for (ContentProviderResult contentProviderResult : applyBatch) {
                i2 += contentProviderResult.count.intValue();
            }
            if (i2 == size) {
                notifyDataChange(7, list);
                return i2;
            }
        } catch (Exception e) {
            DatabaseExceptionUtil.handleException(e);
        }
        return 0;
    }

    public int deleteFavoriteList(@NonNull List<FavoriteAddress> list) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(list);
        int size = list.size();
        HashSet hashSet = new HashSet();
        for (int i = 0; i < size; i++) {
            FavoriteAddress favoriteAddress = list.get(i);
            List<Long> existIdList = getExistIdList(favoriteAddress);
            if (CollectionUtils.isNotEmpty(existIdList)) {
                hashSet.addAll(existIdList);
            } else {
                arrayList.remove(favoriteAddress);
                if (L.ENABLE) {
                    L.Tag tag = TAG;
                    L.d(tag, " deleteFavoriteList favoriteAddress not exist name:" + favoriteAddress.getXPPoiInfo().getName() + "  fav type:" + favoriteAddress.getFavoriteType());
                }
            }
        }
        return applyDeleteBatch(new ArrayList(hashSet), arrayList);
    }

    public int deleteHistoryList(@NonNull List<HistoryRecordInfo> list) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(list);
        int size = list.size();
        HashSet hashSet = new HashSet();
        for (int i = 0; i < size; i++) {
            HistoryRecordInfo historyRecordInfo = list.get(i);
            List<Long> existIdList = getExistIdList(historyRecordInfo);
            if (CollectionUtils.isNotEmpty(existIdList)) {
                hashSet.addAll(existIdList);
            } else {
                arrayList.remove(historyRecordInfo);
                if (L.ENABLE) {
                    L.Tag tag = TAG;
                    L.d(tag, " deleteHistoryList historyRecordInfo not exist name:" + historyRecordInfo.getXPPoiInfo().getName() + "  historyType:" + historyRecordInfo.getHistoryType());
                }
            }
        }
        return applyDeleteBatch(new ArrayList(hashSet), arrayList);
    }

    private int applyDeleteBatch(@NonNull List<Long> list, @NonNull List<DataTransform> list2) {
        if (!CollectionUtils.isEmpty(list) && !CollectionUtils.isEmpty(list2)) {
            try {
                ContentResolver contentResolver = getContentResolver();
                Uri uriFromEntity = getUriFromEntity(list2.get(0));
                Uri deleteUriFromEntity = getDeleteUriFromEntity(list2.get(0));
                int size = list.size();
                ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
                ArrayList arrayList2 = new ArrayList();
                for (int i = 0; i < size; i++) {
                    arrayList2.add(ContentUris.withAppendedId(deleteUriFromEntity, list.get(i).longValue()));
                    arrayList.add(ContentProviderOperation.newDelete(ContentUris.withAppendedId(uriFromEntity, list.get(i).longValue())).build());
                }
                ContentProviderResult[] applyBatch = contentResolver.applyBatch(NavFavoriteProvider.AUTHORITY, arrayList);
                int i2 = 0;
                for (int i3 = 0; i3 < applyBatch.length; i3++) {
                    i2 += applyBatch[i3].count.intValue();
                    if (applyBatch[i3].count.intValue() != 1) {
                        L.i(TAG, "applyDeleteBatch id:" + list.get(i3));
                    }
                }
                L.i(TAG, " applyDeleteBatch size:" + size + " count:" + i2);
                if (i2 == size) {
                    notifyDataChange(8, list2);
                    notifyProviderDataChange(arrayList2);
                    return i2;
                }
            } catch (Exception e) {
                DatabaseExceptionUtil.handleException(e);
            }
        }
        return 0;
    }

    public int delete(@NonNull FavoriteAddress favoriteAddress) {
        return delete(favoriteAddress, favoriteAddress.getId());
    }

    public int delete(@NonNull HistoryRecordInfo historyRecordInfo) {
        return delete(historyRecordInfo, historyRecordInfo.getId());
    }

    private int delete(@NonNull DataTransform dataTransform, long j) {
        ContentResolver contentResolver = getContentResolver();
        Uri uriFromEntity = getUriFromEntity(dataTransform);
        if (j < 0) {
            j = isExist(dataTransform);
        }
        if (j >= 0) {
            try {
                int delete = contentResolver.delete(ContentUris.withAppendedId(uriFromEntity, j), null, null);
                if (delete > 0) {
                    notifyProviderDataChange(ContentUris.withAppendedId(getDeleteUriFromEntity(dataTransform), j));
                    notifyDataChange(3, dataTransform);
                }
                return delete;
            } catch (Exception e) {
                DatabaseExceptionUtil.handleException(e);
                return 0;
            }
        }
        return 0;
    }

    public int deleteUserData() {
        try {
            ContentResolver contentResolver = getContentResolver();
            ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
            arrayList.add(ContentProviderOperation.newDelete(NavFavoriteProvider.HISTORY_CONTENT_URI).build());
            arrayList.add(ContentProviderOperation.newDelete(NavFavoriteProvider.FAVORITE_CONTENT_URI).build());
            arrayList.add(ContentProviderOperation.newDelete(NavFavoriteProvider.XPINCRE_CONTENT_URI).build());
            ContentProviderResult[] applyBatch = contentResolver.applyBatch(NavFavoriteProvider.AUTHORITY, arrayList);
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            for (int i4 = 0; i4 < applyBatch.length; i4++) {
                if (i4 == 0) {
                    i3 = applyBatch[i4].count.intValue();
                }
                if (i4 == 1) {
                    i2 = applyBatch[i4].count.intValue();
                }
                i += applyBatch[i4].count.intValue();
            }
            L.i(TAG, "del_user_data  del count: " + i);
            if (i > 0) {
                notifyProviderDataChange(NavFavoriteProvider.HISTORY_DELETE_URI);
                notifyProviderDataChange(NavFavoriteProvider.FAVORITE_DELETE_URI);
                SettingWrapper.saveAccountMaxHistoryVersion(0L);
                SettingWrapper.saveAccountMaxFavoriteVersion(0L);
                clearFavoriteCache(false);
                this.mOnUserDataChangeListener.onDeleteUserData(i2, i3);
                notifyFavDataChangeToExternal(4, null, null, null);
                return i;
            }
            return i;
        } catch (Exception e) {
            DatabaseExceptionUtil.handleException(e);
            L.i(TAG, "del_user_data  deleteUserData fail");
            return -1;
        }
    }

    public int deleteAllFavorites() {
        List<FavoriteAddress> listFavorites = listFavorites();
        if (CollectionUtils.isEmpty(listFavorites)) {
            return 0;
        }
        int deleteFavorites = deleteFavorites(null, null);
        if (deleteFavorites > 0) {
            ArrayList arrayList = new ArrayList();
            for (FavoriteAddress favoriteAddress : listFavorites) {
                arrayList.add(favoriteAddress);
            }
            notifyDataChange(4, arrayList);
        } else {
            clearFavoriteCache(false);
        }
        return deleteFavorites;
    }

    public int deleteAllNormalFavorites() {
        List<FavoriteAddress> listNormalFavorites = listNormalFavorites();
        if (CollectionUtils.isEmpty(listNormalFavorites)) {
            return 0;
        }
        int deleteFavorites = deleteFavorites("favorite_type = ?", new String[]{"1"});
        if (deleteFavorites > 0) {
            ArrayList arrayList = new ArrayList();
            for (FavoriteAddress favoriteAddress : listNormalFavorites) {
                arrayList.add(favoriteAddress);
            }
            notifyProviderDataChange(NavFavoriteProvider.FAVORITE_DELETE_URI);
            notifyDataChange(5, arrayList);
        } else {
            clearFavoriteCache(true);
        }
        return deleteFavorites;
    }

    private int deleteFavorites(@Nullable String str, @Nullable String[] strArr) {
        try {
            return getContentResolver().delete(NavFavoriteProvider.FAVORITE_CONTENT_URI, str, strArr);
        } catch (Exception e) {
            DatabaseExceptionUtil.handleException(e);
            return -1;
        }
    }

    public int deleteAllHistories() {
        List<HistoryRecordInfo> listHistoryRecords = listHistoryRecords();
        if (CollectionUtils.isEmpty(listHistoryRecords)) {
            return 0;
        }
        int deleteHistories = deleteHistories(null, null);
        L.Tag tag = TAG;
        L.i(tag, "deleteAllHistories count:" + deleteHistories);
        if (deleteHistories > 0) {
            ArrayList arrayList = new ArrayList();
            for (HistoryRecordInfo historyRecordInfo : listHistoryRecords) {
                arrayList.add(historyRecordInfo);
            }
            notifyProviderDataChange(NavFavoriteProvider.HISTORY_DELETE_URI);
            notifyDataChange(4, arrayList);
        }
        return deleteHistories;
    }

    private int deleteHistories(@Nullable String str, @Nullable String[] strArr) {
        try {
            return getContentResolver().delete(NavFavoriteProvider.HISTORY_CONTENT_URI, str, strArr);
        } catch (Exception e) {
            DatabaseExceptionUtil.handleException(e);
            return -1;
        }
    }

    public List<FavoriteAddress> listNormalFavoritesList(long j, long j2, List<String> list, int i) {
        L.i(TAG, "listNormalFavoritesList showTime = " + j + ", updateTime = " + j2 + ", poiIdList.size = " + (list == null ? 0 : list.size()));
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        sb.append("reserve_c is NULL");
        sb.append(" or ");
        sb.append("reserve_c <= ?");
        sb.append(")");
        sb.append(" and ");
        sb.append("(");
        boolean isNotEmpty = CollectionUtils.isNotEmpty(list);
        if (isNotEmpty) {
            sb.append("cast(bl_createtime as BIGINT) < ?");
            sb.append(" or ");
            sb.append("(");
            sb.append("cast(bl_createtime as BIGINT) == ?");
            sb.append(" and ");
            sb.append("poiid not in(");
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                sb.append("'");
                sb.append(list.get(i2));
                sb.append("'");
                if (i2 != size - 1) {
                    sb.append(",");
                }
            }
            sb.append("))");
        } else {
            sb.append("cast(bl_createtime as BIGINT) <= ?");
        }
        sb.append(")");
        String[] strArr = isNotEmpty ? new String[]{"" + j, "" + j2, "" + j2} : new String[]{"" + j, "" + j2};
        XPCoordinate2DDouble currentLocation = TBTManager.getInstance().getPosServiceWrapper().getCurrentLocation();
        int limitOffset = getLimitOffset(1, i);
        if (currentLocation != null) {
            return listNormalFavoritesWithDistance(sb.toString(), strArr, "cast(bl_createtime as BIGINT) DESC", i, limitOffset, currentLocation);
        }
        return listNormalFavorites(sb.toString(), strArr, "cast(bl_createtime as BIGINT) DESC", i, limitOffset);
    }

    @Nullable
    private List<FavoriteAddress> listFavorites(Cursor cursor, boolean z, XPCoordinate2DDouble xPCoordinate2DDouble) {
        if (cursor == null || cursor.getCount() <= 0) {
            return null;
        }
        if (z && xPCoordinate2DDouble == null) {
            z = false;
        }
        ArrayList arrayList = new ArrayList();
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            FavoriteAddress favoriteAddress = new FavoriteAddress();
            favoriteAddress.bindContentValues(cursor);
            if (z) {
                favoriteAddress.getXPPoiInfo().setDistance(NavCoreUtil.calcuCarLocationDistance(favoriteAddress.getXPPoiInfo(), xPCoordinate2DDouble));
            }
            arrayList.add(favoriteAddress);
            cursor.moveToNext();
        }
        return arrayList;
    }

    @Nullable
    public List<FavoriteAddress> listFavorites() {
        return listFavorites((String) null, (String[]) null, (String) null);
    }

    @Nullable
    private List<FavoriteAddress> listFavorites(@Nullable String str, @Nullable String[] strArr, @Nullable String str2) {
        return listFavorites(str, strArr, str2, 0, 0, false, null);
    }

    @Nullable
    private List<FavoriteAddress> listFavorites(@Nullable String str, @Nullable String[] strArr, @Nullable String str2, int i, int i2) {
        return listFavorites(str, strArr, str2, i, i2, false, null);
    }

    @Nullable
    private List<FavoriteAddress> listFavoritesWithDistance(@Nullable String str, @Nullable String[] strArr, @Nullable String str2, int i, int i2, XPCoordinate2DDouble xPCoordinate2DDouble) {
        return listFavorites(str, strArr, str2, i, i2, true, xPCoordinate2DDouble);
    }

    @Nullable
    public List<FavoriteAddress> listNormalFavorites() {
        return listFavorites(concatNormalFavorite(null), (String[]) null, (String) null);
    }

    @Nullable
    private List<FavoriteAddress> listNormalFavorites(@Nullable String str, @Nullable String[] strArr, @Nullable String str2) {
        return listFavorites(concatNormalFavorite(str), strArr, str2, 0, 0, false, null);
    }

    @Nullable
    private List<FavoriteAddress> listNormalFavorites(@Nullable String str, @Nullable String[] strArr, @Nullable String str2, int i, int i2) {
        return listFavorites(concatNormalFavorite(str), strArr, str2, i, i2, false, null);
    }

    @Nullable
    private List<FavoriteAddress> listNormalFavoritesWithDistance(@Nullable String str, @Nullable String[] strArr, @Nullable String str2, int i, int i2, XPCoordinate2DDouble xPCoordinate2DDouble) {
        return listFavorites(concatNormalFavorite(str), strArr, str2, i, i2, true, xPCoordinate2DDouble);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x003c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.util.List<com.xiaopeng.montecarlo.navcore.bean.favorite.FavoriteAddress> listFavorites(@androidx.annotation.Nullable java.lang.String r7, @androidx.annotation.Nullable java.lang.String[] r8, @androidx.annotation.Nullable java.lang.String r9, int r10, int r11, boolean r12, com.xiaopeng.montecarlo.navcore.bean.search.XPCoordinate2DDouble r13) {
        /*
            r6 = this;
            android.content.ContentResolver r0 = r6.getContentResolver()
            java.lang.Class<com.xiaopeng.montecarlo.navcore.bean.favorite.FavoriteAddress> r1 = com.xiaopeng.montecarlo.navcore.bean.favorite.FavoriteAddress.class
            java.lang.String r1 = r1.getName()
            android.net.Uri r1 = r6.getUriFromClass(r1)
            if (r10 <= 0) goto L15
            android.net.Uri r10 = r6.concatLimitArgs(r1, r10, r11)
            r1 = r10
        L15:
            r2 = 0
            r10 = 0
            r3 = r7
            r4 = r8
            r5 = r9
            android.database.Cursor r7 = r0.query(r1, r2, r3, r4, r5)     // Catch: java.lang.Throwable -> L2c java.lang.Exception -> L2f
            java.util.List r8 = r6.listFavorites(r7, r12, r13)     // Catch: java.lang.Throwable -> L28 java.lang.Exception -> L2a
            if (r7 == 0) goto L27
            r7.close()
        L27:
            return r8
        L28:
            r8 = move-exception
            goto L3a
        L2a:
            r8 = move-exception
            goto L31
        L2c:
            r8 = move-exception
            r7 = r10
            goto L3a
        L2f:
            r8 = move-exception
            r7 = r10
        L31:
            com.xiaopeng.montecarlo.root.provider.dataset.DatabaseExceptionUtil.handleException(r8)     // Catch: java.lang.Throwable -> L28
            if (r7 == 0) goto L39
            r7.close()
        L39:
            return r10
        L3a:
            if (r7 == 0) goto L3f
            r7.close()
        L3f:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaopeng.montecarlo.navcore.favorite.FavoriteDataManager.listFavorites(java.lang.String, java.lang.String[], java.lang.String, int, int, boolean, com.xiaopeng.montecarlo.navcore.bean.search.XPCoordinate2DDouble):java.util.List");
    }

    @Nullable
    public FavoriteAddress getHome() {
        FavoriteAddress homeCache = getHomeCache();
        if (homeCache != null) {
            return homeCache;
        }
        List<FavoriteAddress> listFavorites = listFavorites("favorite_type = ?", new String[]{"2"}, null, 0, 0);
        if (CollectionUtils.isNotEmpty(listFavorites)) {
            attachToFavoriteCache(listFavorites.get(0));
            return listFavorites.get(0);
        }
        return null;
    }

    @Nullable
    public FavoriteAddress getCompany() {
        FavoriteAddress companyCache = getCompanyCache();
        if (companyCache != null) {
            return companyCache;
        }
        List<FavoriteAddress> listFavorites = listFavorites("favorite_type = ?", new String[]{"3"}, (String) null);
        if (CollectionUtils.isNotEmpty(listFavorites)) {
            attachToFavoriteCache(listFavorites.get(0));
            return listFavorites.get(0);
        }
        return null;
    }

    public boolean isHome(@NonNull FavoriteAddress favoriteAddress) {
        favoriteAddress.setFavoriteType(2);
        return isHomeOrCompany(favoriteAddress);
    }

    public boolean isHome(@NonNull XPPoiInfo xPPoiInfo) {
        FavoriteAddress favoriteAddress = new FavoriteAddress(xPPoiInfo);
        favoriteAddress.setFavoriteType(2);
        return isHomeOrCompany(favoriteAddress);
    }

    public boolean isCompany(@NonNull FavoriteAddress favoriteAddress) {
        favoriteAddress.setFavoriteType(3);
        return isHomeOrCompany(favoriteAddress);
    }

    public boolean isCompany(@NonNull XPPoiInfo xPPoiInfo) {
        FavoriteAddress favoriteAddress = new FavoriteAddress(xPPoiInfo);
        favoriteAddress.setFavoriteType(3);
        return isHomeOrCompany(favoriteAddress);
    }

    public boolean isHomeOrCompany(@NonNull FavoriteAddress favoriteAddress) {
        return isHomeOrCompanyExist(favoriteAddress) >= 0;
    }

    public List<HistoryRecordInfo> getSuggestHistoryRecords(String str, boolean z) {
        if (str == null) {
            throw new IllegalArgumentException("getSuggestSearchKeywords key is invalid");
        }
        String str2 = "'%" + str + "%'";
        StringBuilder sb = new StringBuilder();
        sb.append("select * from (");
        sb.append("select * from historyrecord");
        sb.append(" where history_type = 1");
        sb.append(" and name like " + str2);
        sb.append(" order by createtime desc");
        sb.append(" limit 3");
        sb.append(")");
        sb.append(" union ");
        sb.append("select * from (");
        sb.append("select * from historyrecord");
        sb.append(" where history_type = 2");
        sb.append(" and (name like " + str2);
        sb.append(" or address like " + str2);
        sb.append(" or districtname like " + str2);
        sb.append(") order by createtime desc");
        sb.append(" limit 3");
        sb.append(")");
        if (z) {
            sb.append(" union ");
            sb.append("select * from (");
            sb.append("select * from historyrecord");
            sb.append(" where history_type = 3");
            sb.append(" and (name like " + str2);
            sb.append(" or address like " + str2);
            sb.append(" or districtname like " + str2);
            sb.append(" or path_vias like " + str2);
            sb.append(") order by createtime desc");
            sb.append(" limit 3");
            sb.append(")");
        }
        sb.append(" order by createtime DESC");
        XPCoordinate2DDouble currentLocation = TBTManager.getInstance().getPosServiceWrapper().getCurrentLocation();
        if (currentLocation != null) {
            return listHistoryRecordsWithDistance(null, null, null, sb.toString(), currentLocation);
        }
        return listHistoryRecords(null, null, null, sb.toString());
    }

    public List<HistoryRecordInfo> getLastestHistoryRecords(long j, long j2, List<String> list, int i, boolean z) {
        L.i(TAG, "getLastestHistoryRecords showTime = " + j + ", updateTime = " + j2);
        StringBuilder sb = new StringBuilder();
        if (!z) {
            sb.append("history_type != 3");
            sb.append(" and ");
        }
        sb.append("(");
        sb.append("reserve_c is NULL");
        sb.append(" or ");
        sb.append("reserve_c <= ?");
        sb.append(")");
        sb.append(" and ");
        boolean isNotEmpty = CollectionUtils.isNotEmpty(list);
        if (isNotEmpty) {
            sb.append("(cast(createtime as BIGINT) < ?");
            sb.append(" or ");
            sb.append("(cast(createtime as BIGINT) == ?");
            sb.append(" and ");
            sb.append("poiid not in(");
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                sb.append("'");
                sb.append(list.get(i2));
                sb.append("'");
                if (i2 != size - 1) {
                    sb.append(",");
                }
            }
            sb.append("))");
        } else {
            sb.append("(cast(createtime as BIGINT) <= ?");
        }
        sb.append(")");
        String[] strArr = isNotEmpty ? new String[]{"" + j, "" + j2, "" + j2} : new String[]{"" + j, "" + j2};
        XPCoordinate2DDouble currentLocation = TBTManager.getInstance().getPosServiceWrapper().getCurrentLocation();
        int limitOffset = getLimitOffset(1, i);
        if (currentLocation != null) {
            return listHistoryRecordsWithDistance(sb.toString(), strArr, "cast(createtime as BIGINT) DESC", i, limitOffset, currentLocation);
        }
        return listHistoryRecords(sb.toString(), strArr, "cast(createtime as BIGINT) DESC", i, limitOffset);
    }

    @Nullable
    private List<HistoryRecordInfo> listHistoryRecords(Cursor cursor, boolean z, XPCoordinate2DDouble xPCoordinate2DDouble) {
        if (cursor == null || cursor.getCount() <= 0) {
            return null;
        }
        if (z && xPCoordinate2DDouble == null) {
            z = false;
        }
        ArrayList arrayList = new ArrayList();
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            HistoryRecordInfo historyRecordInfo = new HistoryRecordInfo();
            historyRecordInfo.bindContentValues(cursor);
            if (z) {
                historyRecordInfo.getXPPoiInfo().setDistance(NavCoreUtil.calcuCarLocationDistance(historyRecordInfo.getXPPoiInfo(), xPCoordinate2DDouble));
            }
            arrayList.add(historyRecordInfo);
            cursor.moveToNext();
        }
        return arrayList;
    }

    @Nullable
    public List<HistoryRecordInfo> listHistoryRecords() {
        return listHistoryRecords((String) null, (String[]) null, (String) null);
    }

    @Nullable
    private List<HistoryRecordInfo> listHistoryRecords(@Nullable String str, @Nullable String[] strArr, @Nullable String str2) {
        return listHistoryRecordsWithDistance(str, strArr, str2, null, 0, 0, false, null);
    }

    @Nullable
    private List<HistoryRecordInfo> listHistoryRecords(@Nullable String str, @Nullable String[] strArr, @Nullable String str2, int i, int i2) {
        return listHistoryRecordsWithDistance(str, strArr, str2, null, i, i2, false, null);
    }

    @Nullable
    private List<HistoryRecordInfo> listHistoryRecords(@Nullable String str, @Nullable String[] strArr, @Nullable String str2, String str3) {
        return listHistoryRecordsWithDistance(str, strArr, str2, str3, 0, 0, false, null);
    }

    @Nullable
    public List<HistoryRecordInfo> listHistoryRecordsWithDistance(XPCoordinate2DDouble xPCoordinate2DDouble) {
        return listHistoryRecordsWithDistance(null, null, null, xPCoordinate2DDouble);
    }

    @Nullable
    private List<HistoryRecordInfo> listHistoryRecordsWithDistance(@Nullable String str, @Nullable String[] strArr, @Nullable String str2, XPCoordinate2DDouble xPCoordinate2DDouble) {
        return listHistoryRecordsWithDistance(str, strArr, str2, null, 0, 0, true, xPCoordinate2DDouble);
    }

    @Nullable
    private List<HistoryRecordInfo> listHistoryRecordsWithDistance(@Nullable String str, @Nullable String[] strArr, @Nullable String str2, int i, int i2, XPCoordinate2DDouble xPCoordinate2DDouble) {
        return listHistoryRecordsWithDistance(str, strArr, str2, null, i, i2, true, xPCoordinate2DDouble);
    }

    @Nullable
    private List<HistoryRecordInfo> listHistoryRecordsWithDistance(@Nullable String str, @Nullable String[] strArr, @Nullable String str2, String str3, XPCoordinate2DDouble xPCoordinate2DDouble) {
        return listHistoryRecordsWithDistance(str, strArr, str2, str3, 0, 0, true, xPCoordinate2DDouble);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002f A[Catch: all -> 0x004a, Exception -> 0x004c, TRY_LEAVE, TryCatch #4 {Exception -> 0x004c, all -> 0x004a, blocks: (B:11:0x002a, B:12:0x002f), top: B:38:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x005b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.util.List<com.xiaopeng.montecarlo.navcore.bean.favorite.HistoryRecordInfo> listHistoryRecordsWithDistance(@androidx.annotation.Nullable java.lang.String r8, @androidx.annotation.Nullable java.lang.String[] r9, @androidx.annotation.Nullable java.lang.String r10, java.lang.String r11, int r12, int r13, boolean r14, @androidx.annotation.Nullable com.xiaopeng.montecarlo.navcore.bean.search.XPCoordinate2DDouble r15) {
        /*
            r7 = this;
            android.content.ContentResolver r0 = r7.getContentResolver()
            java.lang.Class<com.xiaopeng.montecarlo.navcore.bean.favorite.HistoryRecordInfo> r1 = com.xiaopeng.montecarlo.navcore.bean.favorite.HistoryRecordInfo.class
            java.lang.String r1 = r1.getName()
            android.net.Uri r1 = r7.getUriFromClass(r1)
            boolean r2 = android.text.TextUtils.isEmpty(r11)
            r2 = r2 ^ 1
            if (r2 == 0) goto L1c
            android.net.Uri r12 = r7.concatRawSqlArgs(r1)
        L1a:
            r1 = r12
            goto L23
        L1c:
            if (r12 <= 0) goto L23
            android.net.Uri r12 = r7.concatLimitArgs(r1, r12, r13)
            goto L1a
        L23:
            r12 = 0
            if (r2 == 0) goto L2f
            r2 = 0
            r3 = r11
            r4 = r9
            r5 = r10
            android.database.Cursor r8 = r0.query(r1, r2, r3, r4, r5)     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L4c
            goto L37
        L2f:
            r2 = 0
            r3 = r8
            r4 = r9
            r5 = r10
            android.database.Cursor r8 = r0.query(r1, r2, r3, r4, r5)     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L4c
        L37:
            java.util.List r9 = r7.listHistoryRecords(r8, r14, r15)     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L45
            if (r8 == 0) goto L40
            r8.close()
        L40:
            return r9
        L41:
            r9 = move-exception
            r12 = r8
            r8 = r9
            goto L59
        L45:
            r9 = move-exception
            r6 = r9
            r9 = r8
            r8 = r6
            goto L4e
        L4a:
            r8 = move-exception
            goto L59
        L4c:
            r8 = move-exception
            r9 = r12
        L4e:
            com.xiaopeng.montecarlo.root.provider.dataset.DatabaseExceptionUtil.handleException(r8)     // Catch: java.lang.Throwable -> L57
            if (r9 == 0) goto L56
            r9.close()
        L56:
            return r12
        L57:
            r8 = move-exception
            r12 = r9
        L59:
            if (r12 == 0) goto L5e
            r12.close()
        L5e:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaopeng.montecarlo.navcore.favorite.FavoriteDataManager.listHistoryRecordsWithDistance(java.lang.String, java.lang.String[], java.lang.String, java.lang.String, int, int, boolean, com.xiaopeng.montecarlo.navcore.bean.search.XPCoordinate2DDouble):java.util.List");
    }

    @Nullable
    private List<HistoryRecordInfo> listDestination(@Nullable String str, @Nullable String[] strArr, @Nullable String str2) {
        String str3 = "history_type = 2";
        if (!TextUtils.isEmpty(str)) {
            str3 = "history_type = 2 and (" + str + ")";
        }
        return listHistoryRecords(str3, strArr, str2);
    }

    @Nullable
    private List<HistoryRecordInfo> listDestinationWidthDistance(@Nullable String str, @Nullable String[] strArr, @Nullable String str2, @NonNull XPCoordinate2DDouble xPCoordinate2DDouble) {
        String str3 = "history_type = 2";
        if (!TextUtils.isEmpty(str)) {
            str3 = "history_type = 2 and (" + str + ")";
        }
        return listHistoryRecordsWithDistance(str3, strArr, str2, null, 0, 0, true, xPCoordinate2DDouble);
    }

    @Nullable
    public List<HistoryRecordInfo> listKeyword(@NonNull Context context) {
        return listKeyword(null, null, null);
    }

    @Nullable
    private List<HistoryRecordInfo> listKeyword(@Nullable String str, @Nullable String[] strArr, @Nullable String str2) {
        String str3 = "history_type = 1";
        if (!TextUtils.isEmpty(str)) {
            str3 = "history_type = 1 and (" + str + ")";
        }
        return listHistoryRecords(str3, strArr, str2);
    }

    @Nullable
    private List<HistoryRecordInfo> listKeywordWithDistance(@Nullable String str, @Nullable String[] strArr, @Nullable String str2, XPCoordinate2DDouble xPCoordinate2DDouble) {
        String str3 = "history_type = 1";
        if (!TextUtils.isEmpty(str)) {
            str3 = "history_type = 1 and (" + str + ")";
        }
        return listHistoryRecordsWithDistance(str3, strArr, str2, null, 0, 0, true, xPCoordinate2DDouble);
    }

    private String concatNormalFavorite(String str) {
        if (TextUtils.isEmpty(str)) {
            return "favorite_type = 1";
        }
        return "favorite_type = 1 and " + str;
    }

    private Uri concatLimitArgs(Uri uri, int i, int i2) {
        StringBuilder sb = new StringBuilder();
        sb.append(NavFavoriteProvider.LIMIT_ARG);
        sb.append("" + i);
        sb.append(",");
        sb.append("" + i2);
        return Uri.withAppendedPath(uri, sb.toString());
    }

    private Uri concatRawSqlArgs(Uri uri) {
        return Uri.withAppendedPath(uri, NavFavoriteProvider.RAW_SQL_ARG);
    }

    public int getHistoryCount() {
        return getCount(NavFavoriteProvider.HISTORY_CONTENT_URI, null, null);
    }

    public int getFavoriteCount() {
        return getCount(NavFavoriteProvider.FAVORITE_CONTENT_URI, null, null);
    }

    public int getNormalFavoriteCount() {
        return getCount(NavFavoriteProvider.FAVORITE_CONTENT_URI, concatNormalFavorite(null), null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0029, code lost:
        if (r6 != null) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0032, code lost:
        if (r6 == null) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0034, code lost:
        r6.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0037, code lost:
        return 0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private int getCount(android.net.Uri r8, java.lang.String r9, java.lang.String r10) {
        /*
            r7 = this;
            java.lang.String r10 = "count(_id)"
            java.lang.String[] r2 = new java.lang.String[]{r10}
            r10 = 0
            r6 = 0
            android.content.ContentResolver r0 = r7.getContentResolver()     // Catch: java.lang.Throwable -> L2c java.lang.Exception -> L2e
            r4 = 0
            r5 = 0
            r1 = r8
            r3 = r9
            android.database.Cursor r6 = r0.query(r1, r2, r3, r4, r5)     // Catch: java.lang.Throwable -> L2c java.lang.Exception -> L2e
            if (r6 == 0) goto L29
            int r8 = r6.getCount()     // Catch: java.lang.Throwable -> L2c java.lang.Exception -> L2e
            if (r8 <= 0) goto L29
            r6.moveToFirst()     // Catch: java.lang.Throwable -> L2c java.lang.Exception -> L2e
            int r8 = r6.getInt(r10)     // Catch: java.lang.Throwable -> L2c java.lang.Exception -> L2e
            if (r6 == 0) goto L28
            r6.close()
        L28:
            return r8
        L29:
            if (r6 == 0) goto L37
            goto L34
        L2c:
            r8 = move-exception
            goto L38
        L2e:
            r8 = move-exception
            com.xiaopeng.montecarlo.root.provider.dataset.DatabaseExceptionUtil.handleException(r8)     // Catch: java.lang.Throwable -> L2c
            if (r6 == 0) goto L37
        L34:
            r6.close()
        L37:
            return r10
        L38:
            if (r6 == 0) goto L3d
            r6.close()
        L3d:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaopeng.montecarlo.navcore.favorite.FavoriteDataManager.getCount(android.net.Uri, java.lang.String, java.lang.String):int");
    }

    public boolean setHome(@NonNull FavoriteAddress favoriteAddress) {
        favoriteAddress.setFavoriteType(2);
        ArrayList arrayList = new ArrayList();
        arrayList.add(favoriteAddress);
        return insertOrReplaceHomeCompany(arrayList);
    }

    public boolean setCompany(@NonNull FavoriteAddress favoriteAddress) {
        favoriteAddress.setFavoriteType(3);
        ArrayList arrayList = new ArrayList();
        arrayList.add(favoriteAddress);
        return insertOrReplaceHomeCompany(arrayList);
    }

    public void setHomeCompany(FavoriteAddress favoriteAddress, FavoriteAddress favoriteAddress2) {
        ArrayList arrayList = new ArrayList();
        if (favoriteAddress != null) {
            favoriteAddress.setFavoriteType(2);
            arrayList.add(favoriteAddress);
        }
        if (favoriteAddress2 != null) {
            favoriteAddress2.setFavoriteType(3);
            arrayList.add(favoriteAddress2);
        }
        if (CollectionUtils.isNotEmpty(arrayList)) {
            insertOrReplaceHomeCompany(arrayList);
        }
    }

    private boolean insertOrReplaceHomeCompany(@NonNull List<FavoriteAddress> list) {
        FavoriteAddress company;
        ArrayList arrayList;
        long j;
        int i;
        if (CollectionUtils.isEmpty(list)) {
            return false;
        }
        try {
            ContentResolver contentResolver = getContentResolver();
            int size = list.size();
            Uri uriFromClass = getUriFromClass(FavoriteAddress.class.getName());
            ArrayList<ContentProviderOperation> arrayList2 = new ArrayList<>();
            ArrayList arrayList3 = new ArrayList();
            ArrayList arrayList4 = new ArrayList();
            ArrayList arrayList5 = new ArrayList();
            ArrayList arrayList6 = new ArrayList();
            long accountMaxFavoriteVersion = SettingWrapper.getAccountMaxFavoriteVersion() + 1;
            int i2 = 0;
            while (true) {
                if (i2 < size) {
                    FavoriteAddress favoriteAddress = list.get(i2);
                    if (favoriteAddress == null) {
                        L.e(TAG, "insertOrReplaceHomeCompany newAddress == null");
                        break;
                    } else if (favoriteAddress.getFavoriteType() != 2 && favoriteAddress.getFavoriteType() != 3) {
                        L.e(TAG, "insertOrReplaceHomeCompany newAddress is not home or company");
                        break;
                    } else {
                        if (favoriteAddress.getFavoriteType() == 2) {
                            company = getHome();
                        } else {
                            company = favoriteAddress.getFavoriteType() == 3 ? getCompany() : null;
                        }
                        int i3 = i2;
                        long id = company != null ? company.getId() : -1L;
                        arrayList2.clear();
                        favoriteAddress.setDataVersion(accountMaxFavoriteVersion);
                        int i4 = size;
                        if (id >= 0) {
                            arrayList = arrayList5;
                            Uri withAppendedId = ContentUris.withAppendedId(uriFromClass, id);
                            i = i3;
                            ContentProviderOperation.Builder newUpdate = ContentProviderOperation.newUpdate(withAppendedId);
                            j = accountMaxFavoriteVersion;
                            newUpdate.withValues(favoriteAddress.toUpdateContentValues());
                            arrayList2.add(newUpdate.build());
                            if (contentResolver.applyBatch(NavFavoriteProvider.AUTHORITY, arrayList2).length == arrayList2.size()) {
                                arrayList6.add(withAppendedId);
                                arrayList3.add(company);
                                favoriteAddress.setId(id);
                                arrayList4.add(favoriteAddress);
                            }
                        } else {
                            arrayList = arrayList5;
                            j = accountMaxFavoriteVersion;
                            i = i3;
                            ContentProviderOperation.Builder newInsert = ContentProviderOperation.newInsert(uriFromClass);
                            newInsert.withValues(favoriteAddress.toContentValues());
                            arrayList2.add(newInsert.build());
                            ContentProviderResult[] applyBatch = contentResolver.applyBatch(NavFavoriteProvider.AUTHORITY, arrayList2);
                            if (applyBatch.length == arrayList2.size() && applyBatch.length > 0 && applyBatch[0].uri != null) {
                                long parseId = ContentUris.parseId(applyBatch[0].uri);
                                arrayList6.add(applyBatch[0].uri);
                                if (L.ENABLE) {
                                    L.d(TAG, "insert home or compnay addressId = " + parseId);
                                }
                                favoriteAddress.setId(parseId);
                                arrayList4.add(favoriteAddress);
                            }
                        }
                        int i5 = i;
                        notifyDataChange(11, CollectionUtils.isIndexLegal(i5, arrayList4) ? arrayList4.subList(i5, i5 + 1) : arrayList, CollectionUtils.isIndexLegal(i5, arrayList3) ? arrayList3.subList(i5, i5 + 1) : arrayList);
                        i2 = i5 + 1;
                        arrayList5 = arrayList;
                        size = i4;
                        accountMaxFavoriteVersion = j;
                    }
                } else {
                    break;
                }
            }
            long j2 = accountMaxFavoriteVersion;
            if (arrayList4.isEmpty()) {
                return true;
            }
            notifyProviderDataChange(arrayList6);
            SettingWrapper.saveAccountMaxFavoriteVersion(j2);
            return true;
        } catch (Exception e) {
            DatabaseExceptionUtil.handleException(e);
            return false;
        }
    }

    @Nullable
    private int applyInsertBatch(@NonNull List<DataTransform> list) {
        if (CollectionUtils.isEmpty(list)) {
            return 0;
        }
        try {
            Uri uriFromEntity = getUriFromEntity(list.get(0));
            ContentResolver contentResolver = getContentResolver();
            ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                ContentProviderOperation.Builder newInsert = ContentProviderOperation.newInsert(uriFromEntity);
                newInsert.withValues(list.get(i).toContentValues());
                arrayList.add(newInsert.build());
            }
            ContentProviderResult[] applyBatch = contentResolver.applyBatch(NavFavoriteProvider.AUTHORITY, arrayList);
            if (applyBatch.length == list.size()) {
                notifyDataChange(6, list);
                return applyBatch.length;
            }
        } catch (Exception e) {
            DatabaseExceptionUtil.handleException(e);
        }
        return 0;
    }

    public int insertOrReplaceFavoriteList(@NonNull List<FavoriteAddress> list) {
        List<DataTransform> arrayList = new ArrayList<>();
        long currentTimeMillis = System.currentTimeMillis();
        long accountMaxFavoriteVersion = SettingWrapper.getAccountMaxFavoriteVersion() + 1;
        for (int i = 0; i < list.size(); i++) {
            FavoriteAddress favoriteAddress = list.get(i);
            XPPoiInfo xPPoiInfo = favoriteAddress.getXPPoiInfo();
            xPPoiInfo.setReserveC("" + currentTimeMillis);
            favoriteAddress.setDataVersion(accountMaxFavoriteVersion);
            arrayList.add(favoriteAddress);
            currentTimeMillis += 2;
        }
        int insertOrReplaceList = insertOrReplaceList(arrayList);
        if (insertOrReplaceList > 0) {
            SettingWrapper.saveAccountMaxFavoriteVersion(accountMaxFavoriteVersion);
        }
        return insertOrReplaceList;
    }

    public int insertOrReplaceHistoryList(@NonNull List<HistoryRecordInfo> list) {
        List<DataTransform> arrayList = new ArrayList<>();
        long currentTimeMillis = System.currentTimeMillis();
        long accountMaxHistoryVersion = SettingWrapper.getAccountMaxHistoryVersion() + 1;
        for (int i = 0; i < list.size(); i++) {
            HistoryRecordInfo historyRecordInfo = list.get(i);
            XPPoiInfo xPPoiInfo = historyRecordInfo.getXPPoiInfo();
            xPPoiInfo.setReserveC("" + currentTimeMillis);
            historyRecordInfo.setDataVersion(accountMaxHistoryVersion);
            historyRecordInfo.setUpdateCount(historyRecordInfo.getUpdateCount() + 1);
            arrayList.add(historyRecordInfo);
            currentTimeMillis += 2;
        }
        int insertOrReplaceList = insertOrReplaceList(arrayList);
        if (insertOrReplaceList > 0) {
            SettingWrapper.saveAccountMaxHistoryVersion(accountMaxHistoryVersion);
        }
        return insertOrReplaceList;
    }

    private int insertOrReplaceList(@NonNull List<DataTransform> list) {
        ContentProviderOperation.Builder newInsert;
        if (CollectionUtils.isEmpty(list)) {
            return 0;
        }
        try {
            ContentResolver contentResolver = getContentResolver();
            int size = list.size();
            Uri uriFromEntity = getUriFromEntity(list.get(0));
            Uri updateUriFromEntity = getUpdateUriFromEntity(list.get(0));
            ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            for (int i = 0; i < size; i++) {
                long isExist = isExist(list.get(i));
                if (isExist >= 0) {
                    newInsert = ContentProviderOperation.newUpdate(ContentUris.withAppendedId(uriFromEntity, isExist));
                    newInsert.withValues(list.get(i).toUpdateContentValues());
                    arrayList3.add(list.get(i));
                } else {
                    newInsert = ContentProviderOperation.newInsert(uriFromEntity);
                    newInsert.withValues(list.get(i).toContentValues());
                    arrayList2.add(list.get(i));
                }
                if (newInsert == null) {
                    return 0;
                }
                arrayList.add(newInsert.build());
            }
            ContentProviderResult[] applyBatch = contentResolver.applyBatch(NavFavoriteProvider.AUTHORITY, arrayList);
            if (applyBatch.length == size) {
                notifyProviderDataChange(updateUriFromEntity);
                notifyDataChange(9, arrayList2, arrayList3);
                return applyBatch.length;
            }
        } catch (Exception e) {
            DatabaseExceptionUtil.handleException(e);
        }
        return 0;
    }

    private ContentResolver getContentResolver() {
        if (this.mContext == null) {
            L.e(TAG, "FavoriteDataManager not init exception");
        }
        return this.mContext.getContentResolver();
    }

    private void notifyDataChange(int i, DataTransform dataTransform) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(dataTransform);
        notifyDataChange(i, arrayList);
    }

    private void notifyDataChange(int i, List<DataTransform> list) {
        notifyDataChange(i, list, null);
    }

    private void updateFavCache(int i, DataTransform dataTransform, List<DataTransform> list, List<DataTransform> list2) {
        if (i == 1) {
            attachToFavoriteCache((FavoriteAddress) dataTransform);
        } else if (i == 2) {
            attachToFavoriteCache((FavoriteAddress) dataTransform);
        } else if (i == 3) {
            detachFromFavoriteCache((FavoriteAddress) dataTransform);
        } else if (i == 4) {
            clearFavoriteCache(false);
        } else if (i == 5) {
            clearFavoriteCache(true);
        } else if (i == 6) {
            attachToFavoriteCache(transform(list));
        } else if (i == 7) {
            attachToFavoriteCache(transform(list));
        } else if (i == 8) {
            detachFromFavoriteCache(transform(list));
        } else if (i == 9) {
            attachToFavoriteCache(transform(list));
            attachToFavoriteCache(transform(list2));
        } else if (i == 10 || i == 11) {
            detachFromFavoriteCache(transform(list2));
            attachToFavoriteCache(transform(list));
        }
    }

    private void notifyDataChange(int i, List<DataTransform> list, List<DataTransform> list2) {
        boolean isEmpty = CollectionUtils.isEmpty(list);
        boolean isEmpty2 = CollectionUtils.isEmpty(list2);
        if (isEmpty && isEmpty2) {
            return;
        }
        DataTransform dataTransform = null;
        if (!isEmpty) {
            dataTransform = list.get(0);
        } else if (!isEmpty2) {
            dataTransform = list2.get(0);
        }
        if (dataTransform != null) {
            if (dataTransform instanceof FavoriteAddress) {
                updateFavCache(i, dataTransform, list, list2);
                notifyFavDataChange(i, dataTransform, list, list2);
            } else if (dataTransform instanceof HistoryRecordInfo) {
                notifyHistoryDataChange(i, dataTransform, list, list2);
            }
        }
    }

    protected void notifyFavDataChange(int i, DataTransform dataTransform, List<DataTransform> list, List<DataTransform> list2) {
        notifyFavDataChangeToExternal(i, dataTransform, list, list2);
        notifyFavDataChangeToSync(i, dataTransform, list, list2);
    }

    public void notifyFavDataChangeToExternal(int i, DataTransform dataTransform, List<DataTransform> list, List<DataTransform> list2) {
        if (i == 1) {
            for (OnFavoriteDataChangeListener onFavoriteDataChangeListener : this.mOnFavDataChangeListenerList) {
                onFavoriteDataChangeListener.onFavItemAdded((FavoriteAddress) dataTransform);
            }
        } else if (i == 2) {
            for (OnFavoriteDataChangeListener onFavoriteDataChangeListener2 : this.mOnFavDataChangeListenerList) {
                onFavoriteDataChangeListener2.onFavItemUpdate((FavoriteAddress) dataTransform);
            }
        } else if (i == 3) {
            for (OnFavoriteDataChangeListener onFavoriteDataChangeListener3 : this.mOnFavDataChangeListenerList) {
                onFavoriteDataChangeListener3.onFavItemRemoved((FavoriteAddress) dataTransform);
            }
        } else if (i == 4) {
            for (OnFavoriteDataChangeListener onFavoriteDataChangeListener4 : this.mOnFavDataChangeListenerList) {
                onFavoriteDataChangeListener4.onFavClear(transform(list));
            }
        } else if (i == 5) {
            for (OnFavoriteDataChangeListener onFavoriteDataChangeListener5 : this.mOnFavDataChangeListenerList) {
                onFavoriteDataChangeListener5.onNormalFavClear(transform(list));
            }
        } else if (i == 6) {
            for (OnFavoriteDataChangeListener onFavoriteDataChangeListener6 : this.mOnFavDataChangeListenerList) {
                onFavoriteDataChangeListener6.onFavListAdded(transform(list));
            }
        } else if (i == 7) {
            for (OnFavoriteDataChangeListener onFavoriteDataChangeListener7 : this.mOnFavDataChangeListenerList) {
                onFavoriteDataChangeListener7.onFavListUpdate(transform(list));
            }
        } else if (i == 8) {
            for (OnFavoriteDataChangeListener onFavoriteDataChangeListener8 : this.mOnFavDataChangeListenerList) {
                onFavoriteDataChangeListener8.onFavListRemoved(transform(list));
            }
        } else if (i == 9) {
            for (OnFavoriteDataChangeListener onFavoriteDataChangeListener9 : this.mOnFavDataChangeListenerList) {
                onFavoriteDataChangeListener9.onFavListAddOrUpdate(transform(list), transform(list2));
            }
        } else if (i == 10 || i == 11) {
            if (CollectionUtils.isNotEmpty(list) || CollectionUtils.isNotEmpty(list2)) {
                for (OnFavoriteDataChangeListener onFavoriteDataChangeListener10 : this.mOnFavDataChangeListenerList) {
                    onFavoriteDataChangeListener10.onFavItemReplace(transform(list), transform(list2));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void notifyFavDataChangeToSync(int i, DataTransform dataTransform, List<DataTransform> list, List<DataTransform> list2) {
        OnFavoriteDataChangeListener onFavoriteDataChangeListener = this.mIncreSyncFavDataChangeListener;
        if (onFavoriteDataChangeListener == null) {
            return;
        }
        if (i == 1) {
            onFavoriteDataChangeListener.onFavItemAdded((FavoriteAddress) dataTransform);
        } else if (i == 2) {
            onFavoriteDataChangeListener.onFavItemUpdate((FavoriteAddress) dataTransform);
        } else if (i == 3) {
            onFavoriteDataChangeListener.onFavItemRemoved((FavoriteAddress) dataTransform);
        } else if (i == 4) {
            onFavoriteDataChangeListener.onFavClear(transform(list));
        } else if (i == 5) {
            onFavoriteDataChangeListener.onNormalFavClear(transform(list));
        } else if (i == 6) {
            onFavoriteDataChangeListener.onFavListAdded(transform(list));
        } else if (i == 7) {
            onFavoriteDataChangeListener.onFavListUpdate(transform(list));
        } else if (i == 8) {
            onFavoriteDataChangeListener.onFavListRemoved(transform(list));
        } else if (i == 9) {
            onFavoriteDataChangeListener.onFavListAddOrUpdate(transform(list), transform(list2));
        } else if (i == 10 || i == 11) {
            if (CollectionUtils.isNotEmpty(list) || CollectionUtils.isNotEmpty(list2)) {
                this.mIncreSyncFavDataChangeListener.onFavItemReplace(transform(list), transform(list2));
            }
        }
    }

    protected List<FavoriteAddress> transform(List<DataTransform> list) {
        ArrayList arrayList = new ArrayList();
        if (CollectionUtils.isNotEmpty(list)) {
            for (int i = 0; i < list.size(); i++) {
                arrayList.add((FavoriteAddress) list.get(i));
            }
        }
        return arrayList;
    }

    private List<HistoryRecordInfo> transformHistory(List<DataTransform> list) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            arrayList.add((HistoryRecordInfo) list.get(i));
        }
        return arrayList;
    }

    protected void notifyHistoryDataChange(int i, DataTransform dataTransform, List<DataTransform> list, List<DataTransform> list2) {
        notifyHistoryDataChangeToExternal(i, dataTransform, list, list2);
        notifyHistoryDataChangeToSync(i, dataTransform, list, list2);
    }

    public void notifyHistoryDataChangeToExternal(int i, DataTransform dataTransform, List<DataTransform> list, List<DataTransform> list2) {
        if (i == 1) {
            for (OnHistoryDataChangeListener onHistoryDataChangeListener : this.mOnHistoryDataChangeListenerList) {
                onHistoryDataChangeListener.onHistoryItemAdded((HistoryRecordInfo) dataTransform);
            }
        } else if (i == 2) {
            for (OnHistoryDataChangeListener onHistoryDataChangeListener2 : this.mOnHistoryDataChangeListenerList) {
                onHistoryDataChangeListener2.onHistoryItemUpdate((HistoryRecordInfo) dataTransform);
            }
        } else if (i == 3) {
            for (OnHistoryDataChangeListener onHistoryDataChangeListener3 : this.mOnHistoryDataChangeListenerList) {
                onHistoryDataChangeListener3.onHistoryItemRemoved((HistoryRecordInfo) dataTransform);
            }
        } else if (i == 4) {
            for (OnHistoryDataChangeListener onHistoryDataChangeListener4 : this.mOnHistoryDataChangeListenerList) {
                onHistoryDataChangeListener4.onHistoryRecordInfoClear(transformHistory(list));
            }
        } else {
            int i2 = 0;
            if (i == 6) {
                ArrayList arrayList = new ArrayList();
                while (i2 < list.size()) {
                    arrayList.add((HistoryRecordInfo) list.get(i2));
                    i2++;
                }
                for (OnHistoryDataChangeListener onHistoryDataChangeListener5 : this.mOnHistoryDataChangeListenerList) {
                    onHistoryDataChangeListener5.onHistoryListAdded(arrayList);
                }
            } else if (i == 7) {
                ArrayList arrayList2 = new ArrayList();
                while (i2 < list.size()) {
                    arrayList2.add((HistoryRecordInfo) list.get(i2));
                    i2++;
                }
                for (OnHistoryDataChangeListener onHistoryDataChangeListener6 : this.mOnHistoryDataChangeListenerList) {
                    onHistoryDataChangeListener6.onHistoryListUpdate(arrayList2);
                }
            } else if (i == 8) {
                ArrayList arrayList3 = new ArrayList();
                while (i2 < list.size()) {
                    arrayList3.add((HistoryRecordInfo) list.get(i2));
                    i2++;
                }
                for (OnHistoryDataChangeListener onHistoryDataChangeListener7 : this.mOnHistoryDataChangeListenerList) {
                    onHistoryDataChangeListener7.onHistoryListRemoved(arrayList3);
                }
            } else if (i == 9) {
                ArrayList arrayList4 = new ArrayList();
                for (int i3 = 0; i3 < list.size(); i3++) {
                    arrayList4.add((HistoryRecordInfo) list.get(i3));
                }
                ArrayList arrayList5 = new ArrayList();
                while (i2 < list2.size()) {
                    arrayList5.add((HistoryRecordInfo) list2.get(i2));
                    i2++;
                }
                for (OnHistoryDataChangeListener onHistoryDataChangeListener8 : this.mOnHistoryDataChangeListenerList) {
                    onHistoryDataChangeListener8.onHistoryListAddOrUpdate(arrayList4, arrayList5);
                }
            }
        }
    }

    protected void notifyHistoryDataChangeToSync(int i, DataTransform dataTransform, List<DataTransform> list, List<DataTransform> list2) {
        OnHistoryDataChangeListener onHistoryDataChangeListener = this.mIncreSyncHistoryDataChangeListener;
        if (onHistoryDataChangeListener == null) {
            return;
        }
        if (i == 1) {
            onHistoryDataChangeListener.onHistoryItemAdded((HistoryRecordInfo) dataTransform);
        } else if (i == 2) {
            onHistoryDataChangeListener.onHistoryItemUpdate((HistoryRecordInfo) dataTransform);
        } else if (i == 3) {
            onHistoryDataChangeListener.onHistoryItemRemoved((HistoryRecordInfo) dataTransform);
        } else if (i == 4) {
            onHistoryDataChangeListener.onHistoryRecordInfoClear(transformHistory(list));
        } else {
            int i2 = 0;
            if (i == 6) {
                ArrayList arrayList = new ArrayList();
                while (i2 < list.size()) {
                    arrayList.add((HistoryRecordInfo) list.get(i2));
                    i2++;
                }
                this.mIncreSyncHistoryDataChangeListener.onHistoryListAdded(arrayList);
            } else if (i == 7) {
                ArrayList arrayList2 = new ArrayList();
                while (i2 < list.size()) {
                    arrayList2.add((HistoryRecordInfo) list.get(i2));
                    i2++;
                }
                this.mIncreSyncHistoryDataChangeListener.onHistoryListUpdate(arrayList2);
            } else if (i == 8) {
                ArrayList arrayList3 = new ArrayList();
                while (i2 < list.size()) {
                    arrayList3.add((HistoryRecordInfo) list.get(i2));
                    i2++;
                }
                this.mIncreSyncHistoryDataChangeListener.onHistoryListRemoved(arrayList3);
            } else if (i == 9) {
                ArrayList arrayList4 = new ArrayList();
                for (int i3 = 0; i3 < list.size(); i3++) {
                    arrayList4.add((HistoryRecordInfo) list.get(i3));
                }
                ArrayList arrayList5 = new ArrayList();
                while (i2 < list2.size()) {
                    arrayList5.add((HistoryRecordInfo) list2.get(i2));
                    i2++;
                }
                this.mIncreSyncHistoryDataChangeListener.onHistoryListAddOrUpdate(arrayList4, arrayList5);
            }
        }
    }

    public void addOnFavDataChangeListener(OnFavoriteDataChangeListener onFavoriteDataChangeListener) {
        if (onFavoriteDataChangeListener == null || this.mOnFavDataChangeListenerList.contains(onFavoriteDataChangeListener)) {
            return;
        }
        this.mOnFavDataChangeListenerList.add(onFavoriteDataChangeListener);
    }

    public void removeOnFavDataChangeListener(OnFavoriteDataChangeListener onFavoriteDataChangeListener) {
        if (onFavoriteDataChangeListener != null) {
            this.mOnFavDataChangeListenerList.remove(onFavoriteDataChangeListener);
        }
    }

    public void addOnHistoryDataChangeListener(OnHistoryDataChangeListener onHistoryDataChangeListener) {
        if (onHistoryDataChangeListener == null || this.mOnHistoryDataChangeListenerList.contains(onHistoryDataChangeListener)) {
            return;
        }
        this.mOnHistoryDataChangeListenerList.add(onHistoryDataChangeListener);
    }

    public void removeOnHistoryDataChangeListener(OnHistoryDataChangeListener onHistoryDataChangeListener) {
        if (onHistoryDataChangeListener != null) {
            this.mOnHistoryDataChangeListenerList.remove(onHistoryDataChangeListener);
        }
    }

    public long[] getMaxNormalFavTime() {
        return getMaxInsertUpdateTime(getUriFromClass(FavoriteAddress.class.getName()), new String[]{"max(cast(reserve_c as BIGINT))", "max(cast(bl_createtime as BIGINT))"}, concatNormalFavorite(null));
    }

    public long[] getMaxHistoryTime() {
        return getMaxInsertUpdateTime(getUriFromClass(HistoryRecordInfo.class.getName()), new String[]{"max(cast(reserve_c as BIGINT))", "max(cast(createtime as BIGINT))"}, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0055, code lost:
        if (r7 != null) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0057, code lost:
        r7.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0061, code lost:
        if (r7 == null) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0064, code lost:
        return r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private long[] getMaxInsertUpdateTime(android.net.Uri r9, java.lang.String[] r10, java.lang.String r11) {
        /*
            r8 = this;
            r0 = 2
            long[] r0 = new long[r0]
            r0 = {x006c: FILL_ARRAY_DATA  , data: [0, 0} // fill-array
            android.content.ContentResolver r1 = r8.getContentResolver()
            r5 = 0
            r6 = 0
            r7 = 0
            r2 = r9
            r3 = r10
            r4 = r11
            android.database.Cursor r7 = r1.query(r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L5b java.lang.Exception -> L5d
            if (r7 == 0) goto L55
            int r9 = r7.getCount()     // Catch: java.lang.Throwable -> L5b java.lang.Exception -> L5d
            if (r9 <= 0) goto L55
            r7.moveToFirst()     // Catch: java.lang.Throwable -> L5b java.lang.Exception -> L5d
            r9 = 0
            long r10 = r7.getLong(r9)     // Catch: java.lang.Throwable -> L5b java.lang.Exception -> L5d
            r0[r9] = r10     // Catch: java.lang.Throwable -> L5b java.lang.Exception -> L5d
            r10 = 1
            long r1 = r7.getLong(r10)     // Catch: java.lang.Throwable -> L5b java.lang.Exception -> L5d
            r0[r10] = r1     // Catch: java.lang.Throwable -> L5b java.lang.Exception -> L5d
            com.xiaopeng.montecarlo.root.util.L$Tag r11 = com.xiaopeng.montecarlo.navcore.favorite.FavoriteDataManager.TAG     // Catch: java.lang.Throwable -> L5b java.lang.Exception -> L5d
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L5b java.lang.Exception -> L5d
            r1.<init>()     // Catch: java.lang.Throwable -> L5b java.lang.Exception -> L5d
            java.lang.String r2 = "getMaxInsertUpdateTime times[0] = "
            r1.append(r2)     // Catch: java.lang.Throwable -> L5b java.lang.Exception -> L5d
            r2 = r0[r9]     // Catch: java.lang.Throwable -> L5b java.lang.Exception -> L5d
            r1.append(r2)     // Catch: java.lang.Throwable -> L5b java.lang.Exception -> L5d
            java.lang.String r9 = ", times[1] = "
            r1.append(r9)     // Catch: java.lang.Throwable -> L5b java.lang.Exception -> L5d
            r9 = r0[r10]     // Catch: java.lang.Throwable -> L5b java.lang.Exception -> L5d
            r1.append(r9)     // Catch: java.lang.Throwable -> L5b java.lang.Exception -> L5d
            java.lang.String r9 = r1.toString()     // Catch: java.lang.Throwable -> L5b java.lang.Exception -> L5d
            com.xiaopeng.montecarlo.root.util.L.i(r11, r9)     // Catch: java.lang.Throwable -> L5b java.lang.Exception -> L5d
            if (r7 == 0) goto L54
            r7.close()
        L54:
            return r0
        L55:
            if (r7 == 0) goto L64
        L57:
            r7.close()
            goto L64
        L5b:
            r9 = move-exception
            goto L65
        L5d:
            r9 = move-exception
            com.xiaopeng.montecarlo.root.provider.dataset.DatabaseExceptionUtil.handleException(r9)     // Catch: java.lang.Throwable -> L5b
            if (r7 == 0) goto L64
            goto L57
        L64:
            return r0
        L65:
            if (r7 == 0) goto L6a
            r7.close()
        L6a:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaopeng.montecarlo.navcore.favorite.FavoriteDataManager.getMaxInsertUpdateTime(android.net.Uri, java.lang.String[], java.lang.String):long[]");
    }

    private void checkCacheValid() {
        if (sFavoriteCache == null) {
            sFavoriteCache = new FavoriteCache();
        }
    }

    private void attachToFavoriteCache(FavoriteAddress favoriteAddress) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(favoriteAddress);
        attachToFavoriteCache(arrayList);
    }

    private void detachFromFavoriteCache(FavoriteAddress favoriteAddress) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(favoriteAddress);
        detachFromFavoriteCache(arrayList);
    }

    private void attachToFavoriteCache(List<FavoriteAddress> list) {
        if (CollectionUtils.isEmpty(list)) {
            return;
        }
        checkCacheValid();
        for (int i = 0; i < list.size(); i++) {
            FavoriteAddress favoriteAddress = list.get(i);
            if (2 == favoriteAddress.getFavoriteType()) {
                if (L.ENABLE) {
                    L.Tag tag = TAG;
                    L.d(tag, "attachToFavoriteCache home address name = " + favoriteAddress.getXPPoiInfo().getName());
                }
                sFavoriteCache.setHomeAddress(favoriteAddress);
            } else if (3 == favoriteAddress.getFavoriteType()) {
                if (L.ENABLE) {
                    L.Tag tag2 = TAG;
                    L.d(tag2, "attachToFavoriteCache company address name = " + favoriteAddress.getXPPoiInfo().getName());
                }
                sFavoriteCache.setCompanyAddress(favoriteAddress);
            }
        }
    }

    private void detachFromFavoriteCache(List<FavoriteAddress> list) {
        if (CollectionUtils.isEmpty(list)) {
            return;
        }
        checkCacheValid();
        for (int i = 0; i < list.size(); i++) {
            FavoriteAddress favoriteAddress = list.get(i);
            if (2 == favoriteAddress.getFavoriteType()) {
                if (L.ENABLE) {
                    L.Tag tag = TAG;
                    L.d(tag, "detachFromFavoriteCache home address name = " + favoriteAddress.getXPPoiInfo().getName());
                }
                sFavoriteCache.setHomeAddress(null);
            } else if (3 == favoriteAddress.getFavoriteType()) {
                if (L.ENABLE) {
                    L.Tag tag2 = TAG;
                    L.d(tag2, "detachFromFavoriteCache company address name = " + favoriteAddress.getXPPoiInfo().getName());
                }
                sFavoriteCache.setCompanyAddress(null);
            }
        }
    }

    private void clearFavoriteCache(boolean z) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "clearFavoriteCache onlyCommon = " + z);
        }
        checkCacheValid();
        if (z) {
            sFavoriteCache.clearCommonFavoriteCache();
        } else {
            sFavoriteCache.clearFavoriteCache();
        }
    }

    private FavoriteAddress getHomeCache() {
        checkCacheValid();
        FavoriteAddress homeAddress = sFavoriteCache.getHomeAddress();
        if (L.ENABLE && homeAddress != null) {
            L.Tag tag = TAG;
            L.d(tag, "getHomeCache home Address name = " + homeAddress.getXPPoiInfo().getName());
        }
        return homeAddress;
    }

    private FavoriteAddress getCompanyCache() {
        checkCacheValid();
        FavoriteAddress companyAddress = sFavoriteCache.getCompanyAddress();
        if (L.ENABLE && companyAddress != null) {
            L.Tag tag = TAG;
            L.d(tag, "getCompanyCache company Address name = " + companyAddress.getXPPoiInfo().getName());
        }
        return companyAddress;
    }

    public void clearAllCache() {
        clearFavoriteCache(false);
    }
}
