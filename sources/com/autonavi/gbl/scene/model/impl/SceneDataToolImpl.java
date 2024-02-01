package com.autonavi.gbl.scene.model.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.common.path.model.POIInfo;
import com.autonavi.gbl.common.path.model.PointType;
import com.autonavi.gbl.layer.model.BizUserFavoritePoint;
import com.autonavi.gbl.route.model.impl.IRouteRestorationOptionImpl;
import com.autonavi.gbl.scene.model.SceneDataTool;
import com.autonavi.gbl.search.model.SearchPoiBase;
import com.autonavi.gbl.user.behavior.model.FavoriteBaseItem;
import com.autonavi.gbl.user.behavior.model.FavoriteItem;
import com.autonavi.gbl.user.msgpush.model.AimPoiPushMsg;
import com.autonavi.gbl.user.msgpush.model.AimRoutePushMsg;
import com.autonavi.gbl.user.usertrack.model.HistoryRouteItem;
import com.autonavi.gbl.user.usertrack.model.HistoryRoutePoiItem;
import com.autonavi.gbl.user.usertrack.model.SearchHistoryItem;
@IntfAuto(target = SceneDataTool.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class SceneDataToolImpl {
    private static BindTable BIND_TABLE = new BindTable(SceneDataToolImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native int favoriteBaseItemToPoiInfoNative(long j, FavoriteBaseItem favoriteBaseItem, long j2, POIInfo pOIInfo);

    private static native int favoriteItemToBizUserFavoritePointNative(long j, FavoriteItem favoriteItem, long j2, BizUserFavoritePoint bizUserFavoritePoint);

    private static native int favoriteItemToPoiInfoNative(long j, FavoriteItem favoriteItem, long j2, POIInfo pOIInfo);

    private static native int historyRouteItemToPoiInfoNative(long j, HistoryRouteItem historyRouteItem, long j2, POIInfo pOIInfo);

    private static native int poiInfoToFavoriteBaseItemNative(long j, POIInfo pOIInfo, long j2, FavoriteBaseItem favoriteBaseItem);

    private static native int poiInfoToFavoriteItemNative(long j, POIInfo pOIInfo, long j2, FavoriteItem favoriteItem);

    private static native int poiInfoToHistoryRoutePoiItemNative(long j, POIInfo pOIInfo, long j2, HistoryRoutePoiItem historyRoutePoiItem);

    private static native int poiInfoToSearchHistoryItemNative(long j, POIInfo pOIInfo, long j2, SearchHistoryItem searchHistoryItem);

    private static native int poiPushMsgToPoiInfoNative(long j, AimPoiPushMsg aimPoiPushMsg, long j2, POIInfo pOIInfo);

    private static native int routePushMsgToRouteOptionNative(long j, AimRoutePushMsg aimRoutePushMsg, long j2, IRouteRestorationOptionImpl iRouteRestorationOptionImpl);

    private static native int searchHistoryItemToPoiInfoNative(long j, SearchHistoryItem searchHistoryItem, long j2, POIInfo pOIInfo);

    private static native int searchPoiBaseToPoiInfoNative(long j, SearchPoiBase searchPoiBase, int i, long j2, POIInfo pOIInfo);

    public SceneDataToolImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof SceneDataToolImpl) && getUID(this) == getUID((SceneDataToolImpl) obj);
    }

    private static long getUID(SceneDataToolImpl sceneDataToolImpl) {
        long cPtr = getCPtr(sceneDataToolImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(SceneDataToolImpl sceneDataToolImpl) {
        if (sceneDataToolImpl == null) {
            return 0L;
        }
        return sceneDataToolImpl.swigCPtr;
    }

    public boolean isRecycled() {
        return this.swigCPtr == 0;
    }

    public boolean isCMemOwn() {
        return this.swigCMemOwn;
    }

    protected synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                destroyNativeObj(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
    }

    public static IRouteRestorationOptionImpl routePushMsgToRouteOption(AimRoutePushMsg aimRoutePushMsg) {
        IRouteRestorationOptionImpl create = IRouteRestorationOptionImpl.create();
        if (Integer.valueOf(routePushMsgToRouteOption(aimRoutePushMsg, create)).intValue() == 0) {
            return create;
        }
        return null;
    }

    private static int routePushMsgToRouteOption(AimRoutePushMsg aimRoutePushMsg, IRouteRestorationOptionImpl iRouteRestorationOptionImpl) {
        return routePushMsgToRouteOptionNative(0L, aimRoutePushMsg, IRouteRestorationOptionImpl.getCPtr(iRouteRestorationOptionImpl), iRouteRestorationOptionImpl);
    }

    public static POIInfo poiPushMsgToPoiInfo(AimPoiPushMsg aimPoiPushMsg) {
        POIInfo pOIInfo = new POIInfo();
        if (Integer.valueOf(poiPushMsgToPoiInfo(aimPoiPushMsg, pOIInfo)).intValue() == 0) {
            return pOIInfo;
        }
        return null;
    }

    private static int poiPushMsgToPoiInfo(AimPoiPushMsg aimPoiPushMsg, POIInfo pOIInfo) {
        return poiPushMsgToPoiInfoNative(0L, aimPoiPushMsg, 0L, pOIInfo);
    }

    public static POIInfo searchPoiBaseToPoiInfo(SearchPoiBase searchPoiBase, @PointType.PointType1 int i) {
        POIInfo pOIInfo = new POIInfo();
        if (Integer.valueOf(searchPoiBaseToPoiInfo(searchPoiBase, i, pOIInfo)).intValue() == 0) {
            return pOIInfo;
        }
        return null;
    }

    private static int searchPoiBaseToPoiInfo(SearchPoiBase searchPoiBase, @PointType.PointType1 int i, POIInfo pOIInfo) {
        return searchPoiBaseToPoiInfoNative(0L, searchPoiBase, i, 0L, pOIInfo);
    }

    public static BizUserFavoritePoint favoriteItemToBizUserFavoritePoint(FavoriteItem favoriteItem) {
        BizUserFavoritePoint bizUserFavoritePoint = new BizUserFavoritePoint();
        if (Integer.valueOf(favoriteItemToBizUserFavoritePoint(favoriteItem, bizUserFavoritePoint)).intValue() == 0) {
            return bizUserFavoritePoint;
        }
        return null;
    }

    private static int favoriteItemToBizUserFavoritePoint(FavoriteItem favoriteItem, BizUserFavoritePoint bizUserFavoritePoint) {
        return favoriteItemToBizUserFavoritePointNative(0L, favoriteItem, 0L, bizUserFavoritePoint);
    }

    public static POIInfo historyRouteItemToPoiInfo(HistoryRouteItem historyRouteItem) {
        POIInfo pOIInfo = new POIInfo();
        if (Integer.valueOf(historyRouteItemToPoiInfo(historyRouteItem, pOIInfo)).intValue() == 0) {
            return pOIInfo;
        }
        return null;
    }

    private static int historyRouteItemToPoiInfo(HistoryRouteItem historyRouteItem, POIInfo pOIInfo) {
        return historyRouteItemToPoiInfoNative(0L, historyRouteItem, 0L, pOIInfo);
    }

    public static HistoryRoutePoiItem poiInfoToHistoryRoutePoiItem(POIInfo pOIInfo) {
        HistoryRoutePoiItem historyRoutePoiItem = new HistoryRoutePoiItem();
        if (Integer.valueOf(poiInfoToHistoryRoutePoiItem(pOIInfo, historyRoutePoiItem)).intValue() == 0) {
            return historyRoutePoiItem;
        }
        return null;
    }

    private static int poiInfoToHistoryRoutePoiItem(POIInfo pOIInfo, HistoryRoutePoiItem historyRoutePoiItem) {
        return poiInfoToHistoryRoutePoiItemNative(0L, pOIInfo, 0L, historyRoutePoiItem);
    }

    public static POIInfo searchHistoryItemToPoiInfo(SearchHistoryItem searchHistoryItem) {
        POIInfo pOIInfo = new POIInfo();
        if (Integer.valueOf(searchHistoryItemToPoiInfo(searchHistoryItem, pOIInfo)).intValue() == 0) {
            return pOIInfo;
        }
        return null;
    }

    private static int searchHistoryItemToPoiInfo(SearchHistoryItem searchHistoryItem, POIInfo pOIInfo) {
        return searchHistoryItemToPoiInfoNative(0L, searchHistoryItem, 0L, pOIInfo);
    }

    public static SearchHistoryItem poiInfoToSearchHistoryItem(POIInfo pOIInfo) {
        SearchHistoryItem searchHistoryItem = new SearchHistoryItem();
        if (Integer.valueOf(poiInfoToSearchHistoryItem(pOIInfo, searchHistoryItem)).intValue() == 0) {
            return searchHistoryItem;
        }
        return null;
    }

    private static int poiInfoToSearchHistoryItem(POIInfo pOIInfo, SearchHistoryItem searchHistoryItem) {
        return poiInfoToSearchHistoryItemNative(0L, pOIInfo, 0L, searchHistoryItem);
    }

    public static POIInfo favoriteBaseItemToPoiInfo(FavoriteBaseItem favoriteBaseItem) {
        POIInfo pOIInfo = new POIInfo();
        if (Integer.valueOf(favoriteBaseItemToPoiInfo(favoriteBaseItem, pOIInfo)).intValue() == 0) {
            return pOIInfo;
        }
        return null;
    }

    private static int favoriteBaseItemToPoiInfo(FavoriteBaseItem favoriteBaseItem, POIInfo pOIInfo) {
        return favoriteBaseItemToPoiInfoNative(0L, favoriteBaseItem, 0L, pOIInfo);
    }

    public static FavoriteBaseItem poiInfoToFavoriteBaseItem(POIInfo pOIInfo) {
        FavoriteBaseItem favoriteBaseItem = new FavoriteBaseItem();
        if (Integer.valueOf(poiInfoToFavoriteBaseItem(pOIInfo, favoriteBaseItem)).intValue() == 0) {
            return favoriteBaseItem;
        }
        return null;
    }

    private static int poiInfoToFavoriteBaseItem(POIInfo pOIInfo, FavoriteBaseItem favoriteBaseItem) {
        return poiInfoToFavoriteBaseItemNative(0L, pOIInfo, 0L, favoriteBaseItem);
    }

    public static FavoriteItem poiInfoToFavoriteItem(POIInfo pOIInfo) {
        FavoriteItem favoriteItem = new FavoriteItem();
        if (Integer.valueOf(poiInfoToFavoriteItem(pOIInfo, favoriteItem)).intValue() == 0) {
            return favoriteItem;
        }
        return null;
    }

    private static int poiInfoToFavoriteItem(POIInfo pOIInfo, FavoriteItem favoriteItem) {
        return poiInfoToFavoriteItemNative(0L, pOIInfo, 0L, favoriteItem);
    }

    public static POIInfo favoriteItemToPoiInfo(FavoriteItem favoriteItem) {
        POIInfo pOIInfo = new POIInfo();
        if (Integer.valueOf(favoriteItemToPoiInfo(favoriteItem, pOIInfo)).intValue() == 0) {
            return pOIInfo;
        }
        return null;
    }

    private static int favoriteItemToPoiInfo(FavoriteItem favoriteItem, POIInfo pOIInfo) {
        return favoriteItemToPoiInfoNative(0L, favoriteItem, 0L, pOIInfo);
    }

    public SceneDataToolImpl() {
        this(createNativeObj(), true);
    }
}
