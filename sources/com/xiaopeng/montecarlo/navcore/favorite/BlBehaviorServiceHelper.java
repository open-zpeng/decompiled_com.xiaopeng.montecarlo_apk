package com.xiaopeng.montecarlo.navcore.favorite;

import com.autonavi.gbl.user.behavior.model.FavoriteBaseItem;
import com.autonavi.gbl.user.behavior.model.FavoriteItem;
import com.autonavi.gbl.user.behavior.model.SimpleFavoriteItem;
import com.xiaopeng.montecarlo.navcore.account.AccountBehaviorServiceWrapper;
import com.xiaopeng.montecarlo.navcore.bean.favorite.FavoriteAddress;
import com.xiaopeng.montecarlo.root.util.L;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class BlBehaviorServiceHelper {
    private static final L.Tag TAG = new L.Tag("BlBehaviorServiceHelper");

    public static boolean isSyncing() {
        int isSyncing = AccountBehaviorServiceWrapper.getInstance().isSyncing();
        L.Tag tag = TAG;
        L.i(tag, "isSyncing() isSyncing = " + isSyncing);
        return isSyncing == 0;
    }

    public static String insertOrReplaceFavorite(FavoriteAddress favoriteAddress) {
        if (favoriteAddress == null) {
            L.Tag tag = TAG;
            L.w(tag, "insertOrReplaceFavorite favoriteAddress = " + favoriteAddress);
            return "";
        } else if (!FavoriteUtil.needBlAccountSync()) {
            L.Tag tag2 = TAG;
            L.w(tag2, "insertOrReplaceFavorite favoriteAddress failed not needBlAccountSync = " + favoriteAddress.getXPPoiInfo().getPoiId());
            return "";
        } else {
            int favoriteType = favoriteAddress.getFavoriteType();
            if (favoriteType == 2) {
                return insertOrReplaceHome(favoriteAddress);
            }
            if (favoriteType == 3) {
                return insertOrReplaceCompany(favoriteAddress);
            }
            return insertOrReplaceNormalFavorite(favoriteAddress);
        }
    }

    private static String insertOrReplaceNormalFavorite(FavoriteAddress favoriteAddress) {
        FavoriteBaseItem transFavoriteItemToBase;
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "insertOrReplaceNormalFavorite favoriteAddress.poiid = " + favoriteAddress.getXPPoiInfo().getPoiId() + ", favoriteAddress.name = " + favoriteAddress.getXPPoiInfo().getName());
        }
        FavoriteItem transFavoriteAddressToFavoriteItem = FavoriteUtil.transFavoriteAddressToFavoriteItem(favoriteAddress);
        if (transFavoriteAddressToFavoriteItem == null || (transFavoriteItemToBase = FavoriteUtil.transFavoriteItemToBase(transFavoriteAddressToFavoriteItem)) == null) {
            return "";
        }
        FavoriteItem favorite = AccountBehaviorServiceWrapper.getInstance().getFavorite(transFavoriteItemToBase);
        if (favorite != null) {
            transFavoriteAddressToFavoriteItem.item_id = favorite.item_id;
            if (L.ENABLE) {
                L.Tag tag2 = TAG;
                L.d(tag2, "insertOrReplaceNormalFavorite favoriteItem.item_id = " + favorite.item_id);
            }
            return updateFavorite(transFavoriteAddressToFavoriteItem);
        }
        return addFavorite(transFavoriteAddressToFavoriteItem);
    }

    private static String insertOrReplaceHome(FavoriteAddress favoriteAddress) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "insertOrReplaceHome favoriteAddress.poiid = " + favoriteAddress.getXPPoiInfo().getPoiId() + ", favoriteAddress.name = " + favoriteAddress.getXPPoiInfo().getName());
        }
        FavoriteItem transFavoriteAddressToFavoriteItem = FavoriteUtil.transFavoriteAddressToFavoriteItem(favoriteAddress);
        if (transFavoriteAddressToFavoriteItem != null) {
            ArrayList<SimpleFavoriteItem> simpleHomeList = AccountBehaviorServiceWrapper.getInstance().getSimpleHomeList();
            if (simpleHomeList != null && simpleHomeList.size() > 0 && simpleHomeList.get(0) != null) {
                SimpleFavoriteItem simpleFavoriteItem = simpleHomeList.get(0);
                transFavoriteAddressToFavoriteItem.item_id = simpleFavoriteItem.item_id;
                if (L.ENABLE) {
                    L.Tag tag2 = TAG;
                    L.d(tag2, "insertOrReplaceHome simpleFavoriteItem.item_id = " + simpleFavoriteItem.item_id);
                }
                return updateFavorite(transFavoriteAddressToFavoriteItem);
            }
            return addFavorite(transFavoriteAddressToFavoriteItem);
        }
        return "";
    }

    private static String insertOrReplaceCompany(FavoriteAddress favoriteAddress) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "insertOrReplaceCompany favoriteAddress.poiid = " + favoriteAddress.getXPPoiInfo().getPoiId() + ", favoriteAddress.name = " + favoriteAddress.getXPPoiInfo().getName());
        }
        FavoriteItem transFavoriteAddressToFavoriteItem = FavoriteUtil.transFavoriteAddressToFavoriteItem(favoriteAddress);
        if (transFavoriteAddressToFavoriteItem != null) {
            ArrayList<SimpleFavoriteItem> simpleCompanyList = AccountBehaviorServiceWrapper.getInstance().getSimpleCompanyList();
            if (simpleCompanyList != null && simpleCompanyList.size() > 0 && simpleCompanyList.get(0) != null) {
                SimpleFavoriteItem simpleFavoriteItem = simpleCompanyList.get(0);
                transFavoriteAddressToFavoriteItem.item_id = simpleFavoriteItem.item_id;
                L.Tag tag2 = TAG;
                L.i(tag2, "insertOrReplaceCompany simpleFavoriteItem.item_id = " + simpleFavoriteItem.item_id);
                return updateFavorite(transFavoriteAddressToFavoriteItem);
            }
            return addFavorite(transFavoriteAddressToFavoriteItem);
        }
        return "";
    }

    public static String addFavorite(FavoriteItem favoriteItem) {
        if (favoriteItem == null) {
            L.Tag tag = TAG;
            L.w(tag, "addFavoriteForSync favoriteItem = " + favoriteItem);
            return "";
        } else if (FavoriteUtil.needBlAccountSync()) {
            String addFavorite = AccountBehaviorServiceWrapper.getInstance().addFavorite(favoriteItem, 0);
            if (L.ENABLE) {
                L.Tag tag2 = TAG;
                L.d(tag2, "addFavoriteForSync favoriteItem.poiid = " + favoriteItem.poiid + ", favoriteItem.name = " + favoriteItem.name + " isSyncing:" + isSyncing() + " addResult:" + addFavorite);
            }
            return addFavorite;
        } else {
            return "";
        }
    }

    private static String updateFavorite(FavoriteItem favoriteItem) {
        if (favoriteItem == null) {
            L.Tag tag = TAG;
            L.w(tag, "updateFavoriteForSync favoriteItem = " + favoriteItem);
            return "";
        } else if (FavoriteUtil.needBlAccountSync()) {
            L.Tag tag2 = TAG;
            L.i(tag2, "updateFavoriteForSync favoriteItem.poiid = " + favoriteItem.poiid + ", favoriteItem.name = " + favoriteItem.name);
            return AccountBehaviorServiceWrapper.getInstance().updateFavorite(favoriteItem, 0);
        } else {
            return "";
        }
    }

    public static String deleteFavorite(FavoriteAddress favoriteAddress) {
        FavoriteBaseItem transFavoriteAddressToFavoriteBaseItem;
        if (favoriteAddress == null) {
            L.Tag tag = TAG;
            L.w(tag, "deleteFavoriteForSync favoriteAddress = " + favoriteAddress);
            return "";
        } else if (FavoriteUtil.needBlAccountSync() && (transFavoriteAddressToFavoriteBaseItem = FavoriteUtil.transFavoriteAddressToFavoriteBaseItem(favoriteAddress)) != null) {
            if (favoriteAddress.getXPPoiInfo() != null && favoriteAddress.getXPPoiInfo().matchCustomPoiIdHeader()) {
                transFavoriteAddressToFavoriteBaseItem.poiid = null;
            }
            String delFavorite = AccountBehaviorServiceWrapper.getInstance().delFavorite(transFavoriteAddressToFavoriteBaseItem, 0);
            L.Tag tag2 = TAG;
            L.i(tag2, "deleteFavoriteForSync item.poiid = " + transFavoriteAddressToFavoriteBaseItem.poiid + ", item.city_name = " + transFavoriteAddressToFavoriteBaseItem.name + " isSyncing:" + isSyncing() + " delResult:" + delFavorite);
            return delFavorite;
        } else {
            return "";
        }
    }

    public static int clearFavorite() {
        if (FavoriteUtil.needBlAccountSync()) {
            return AccountBehaviorServiceWrapper.getInstance().clearAllFavorite(0);
        }
        return -1;
    }
}
