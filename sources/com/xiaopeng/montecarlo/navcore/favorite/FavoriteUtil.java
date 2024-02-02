package com.xiaopeng.montecarlo.navcore.favorite;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.autonavi.gbl.common.model.Coord2DDouble;
import com.autonavi.gbl.common.model.Coord2DInt32;
import com.autonavi.gbl.user.behavior.model.FavoriteBaseItem;
import com.autonavi.gbl.user.behavior.model.FavoriteItem;
import com.autonavi.gbl.user.behavior.model.SimpleFavoriteItem;
import com.xiaopeng.montecarlo.navcore.account.AccountBehaviorServiceWrapper;
import com.xiaopeng.montecarlo.navcore.account.AccountContext;
import com.xiaopeng.montecarlo.navcore.account.ObjectConvertor;
import com.xiaopeng.montecarlo.navcore.account.XPAccountServiceWrapper;
import com.xiaopeng.montecarlo.navcore.bean.favorite.FavoriteAddress;
import com.xiaopeng.montecarlo.navcore.bean.favorite.HistoryRecordInfo;
import com.xiaopeng.montecarlo.navcore.bean.search.XPCoordinate2DDouble;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import com.xiaopeng.montecarlo.navcore.location.LocationUtils;
import com.xiaopeng.montecarlo.navcore.setting.SettingWrapper;
import com.xiaopeng.montecarlo.navcore.util.NavCoreUtil;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import com.xiaopeng.montecarlo.root.util.L;
/* loaded from: classes2.dex */
public class FavoriteUtil {
    private static final L.Tag TAG = new L.Tag("FavoriteUtil");

    public static boolean favoriteEqual(@NonNull FavoriteAddress favoriteAddress, @NonNull FavoriteAddress favoriteAddress2) {
        if (favoriteAddress.getFavoriteType() == favoriteAddress2.getFavoriteType()) {
            if (!TextUtils.isEmpty(favoriteAddress.getBLItemId()) && TextUtils.equals(favoriteAddress.getBLItemId(), favoriteAddress2.getBLItemId())) {
                return true;
            }
            String address = favoriteAddress.getXPPoiInfo().getAddress();
            String address2 = favoriteAddress2.getXPPoiInfo().getAddress();
            if (address != null && address2 != null && (address.endsWith(address2) || address2.endsWith(address))) {
                if (favoriteAddress.getFavoriteType() == 2 || favoriteAddress.getFavoriteType() == 3) {
                    return matchFavoriteDistance(favoriteAddress, favoriteAddress2, 25);
                }
                String name = favoriteAddress.getXPPoiInfo().getName();
                String name2 = favoriteAddress2.getXPPoiInfo().getName();
                if (name == null || name2 == null || !name.equals(name2)) {
                    return false;
                }
                return matchFavoriteDistance(favoriteAddress, favoriteAddress2, 100);
            }
        }
        return false;
    }

    public static boolean historyRecordEqual(@NonNull HistoryRecordInfo historyRecordInfo, @NonNull HistoryRecordInfo historyRecordInfo2) {
        if (historyRecordInfo.getHistoryType() == historyRecordInfo2.getHistoryType()) {
            if (historyRecordInfo.getHistoryType() == 2) {
                return NavCoreUtil.isSamePOI(historyRecordInfo.getXPPoiInfo(), historyRecordInfo2.getXPPoiInfo());
            }
            if (historyRecordInfo.getHistoryType() == 1) {
                String name = historyRecordInfo.getXPPoiInfo().getName();
                String name2 = historyRecordInfo2.getXPPoiInfo().getName();
                return (TextUtils.isEmpty(name) || TextUtils.isEmpty(name2) || !name.equals(name2)) ? false : true;
            } else if (historyRecordInfo.getHistoryType() == 3 && NavCoreUtil.isSamePOI(historyRecordInfo.getXPPoiInfo(), historyRecordInfo2.getXPPoiInfo())) {
                int size = CollectionUtils.isEmpty(historyRecordInfo.getViaPois()) ? 0 : historyRecordInfo.getViaPois().size();
                int size2 = CollectionUtils.isEmpty(historyRecordInfo2.getViaPois()) ? 0 : historyRecordInfo2.getViaPois().size();
                if (size == 0 && size2 == 0) {
                    L.w(TAG, "historyRecordEqual HistoryRecordInfo.HISTORY_PATH but has no viaPois");
                    return true;
                } else if (size > 0 && size2 > 0 && size == size2) {
                    for (int i = 0; i < size; i++) {
                        if (!NavCoreUtil.isSamePOI(historyRecordInfo.getViaPois().get(i), historyRecordInfo2.getViaPois().get(i))) {
                            return false;
                        }
                    }
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean matchFavoriteDistance(@NonNull FavoriteAddress favoriteAddress, @NonNull FavoriteAddress favoriteAddress2, int i) {
        return LocationUtils.getDistance(new XPCoordinate2DDouble(favoriteAddress.getXPPoiInfo()), new XPCoordinate2DDouble(favoriteAddress2.getXPPoiInfo())) < ((double) i);
    }

    public static boolean isLoginXp() {
        return XPAccountServiceWrapper.getInstance().isLoginXp();
    }

    public static boolean needBlAccountSync() {
        return isLoginXp() && SettingWrapper.getAmapLoginStatus();
    }

    public static FavoriteBaseItem transSimpleToBase(SimpleFavoriteItem simpleFavoriteItem) {
        FavoriteBaseItem favoriteBaseItem = new FavoriteBaseItem();
        favoriteBaseItem.item_id = simpleFavoriteItem.item_id;
        favoriteBaseItem.name = simpleFavoriteItem.name;
        favoriteBaseItem.point_x = simpleFavoriteItem.point_x;
        favoriteBaseItem.point_y = simpleFavoriteItem.point_y;
        return favoriteBaseItem;
    }

    public static FavoriteBaseItem transFavoriteItemToBase(FavoriteItem favoriteItem) {
        FavoriteBaseItem favoriteBaseItem = new FavoriteBaseItem();
        favoriteBaseItem.item_id = favoriteItem.item_id;
        favoriteBaseItem.name = favoriteItem.name;
        favoriteBaseItem.point_x = favoriteItem.point_x;
        favoriteBaseItem.point_y = favoriteItem.point_y;
        favoriteBaseItem.poiid = favoriteItem.poiid;
        return favoriteBaseItem;
    }

    public static FavoriteItem transFavoriteAddressToFavoriteItem(FavoriteAddress favoriteAddress) {
        FavoriteItem favoriteItem;
        int i;
        int i2;
        int i3;
        Coord2DInt32 transLonLatToP20;
        Coord2DInt32 transLonLatToP202;
        if (favoriteAddress == null || (favoriteItem = favoriteAddress.toFavoriteItem()) == null) {
            return null;
        }
        double displayLon = favoriteAddress.getXPPoiInfo().getDisplayLon();
        double displayLat = favoriteAddress.getXPPoiInfo().getDisplayLat();
        int i4 = 0;
        if (Double.compare(displayLon, 0.0d) == 0 || Double.compare(displayLat, 0.0d) == 0 || (transLonLatToP202 = transLonLatToP20(displayLon, displayLat)) == null) {
            i = 0;
            i2 = 0;
        } else {
            i2 = transLonLatToP202.lon;
            i = transLonLatToP202.lat;
        }
        favoriteItem.point_x = i2;
        favoriteItem.point_y = i;
        double naviLon = favoriteAddress.getXPPoiInfo().getNaviLon();
        double naviLat = favoriteAddress.getXPPoiInfo().getNaviLat();
        if (Double.compare(displayLon, 0.0d) == 0 || Double.compare(displayLat, 0.0d) == 0 || (transLonLatToP20 = transLonLatToP20(naviLon, naviLat)) == null) {
            i3 = 0;
        } else {
            i4 = transLonLatToP20.lon;
            i3 = transLonLatToP20.lat;
        }
        favoriteItem.point_x_arrive = i4;
        favoriteItem.point_y_arrive = i3;
        return favoriteItem;
    }

    public static FavoriteBaseItem transFavoriteAddressToFavoriteBaseItem(FavoriteAddress favoriteAddress) {
        FavoriteItem transFavoriteAddressToFavoriteItem;
        if (favoriteAddress == null || (transFavoriteAddressToFavoriteItem = transFavoriteAddressToFavoriteItem(favoriteAddress)) == null) {
            return null;
        }
        return transFavoriteItemToBase(transFavoriteAddressToFavoriteItem);
    }

    public static FavoriteAddress transFavoriteItemToFavoriteAddress(FavoriteItem favoriteItem) {
        double d;
        double d2;
        double d3;
        Coord2DDouble transP20ToLonLat;
        if (favoriteItem == null) {
            return null;
        }
        FavoriteAddress favoriteAddress = new FavoriteAddress(favoriteItem);
        if (favoriteAddress.getXPPoiInfo() == null) {
            return null;
        }
        double d4 = 0.0d;
        if (favoriteItem.point_x == 0 || favoriteItem.point_y == 0) {
            d = 0.0d;
            d2 = 0.0d;
        } else {
            Coord2DDouble transP20ToLonLat2 = transP20ToLonLat(favoriteItem.point_x, favoriteItem.point_y);
            if (transP20ToLonLat2 == null) {
                return null;
            }
            d = transP20ToLonLat2.lon;
            d2 = transP20ToLonLat2.lat;
        }
        favoriteAddress.getXPPoiInfo().setDisplayLon(d);
        favoriteAddress.getXPPoiInfo().setDisplayLat(d2);
        if (favoriteItem.point_x_arrive == 0 || favoriteItem.point_y_arrive == 0 || (transP20ToLonLat = transP20ToLonLat(favoriteItem.point_x_arrive, favoriteItem.point_y_arrive)) == null) {
            d3 = 0.0d;
        } else {
            d4 = transP20ToLonLat.lon;
            d3 = transP20ToLonLat.lat;
        }
        favoriteAddress.getXPPoiInfo().setNaviLon(d4);
        favoriteAddress.getXPPoiInfo().setNaviLat(d3);
        XPPoiInfo.generatePoiIdIfEmpty(favoriteAddress.getXPPoiInfo(), 1);
        if (favoriteAddress.getXPPoiInfo() != null) {
            favoriteAddress.getXPPoiInfo().setReserveB(ObjectConvertor.toFavoriteDataId(favoriteAddress));
        }
        return favoriteAddress;
    }

    public static FavoriteItem getFavoriteItem(SimpleFavoriteItem simpleFavoriteItem) {
        return AccountBehaviorServiceWrapper.getInstance().getFavorite(transSimpleToBase(simpleFavoriteItem));
    }

    public static Coord2DDouble transP20ToLonLat(int i, int i2) {
        return AccountContext.getInstance().transP20ToLonLat(i, i2);
    }

    public static Coord2DInt32 transLonLatToP20(double d, double d2) {
        return AccountContext.getInstance().transLonLatToP20(d, d2);
    }
}
