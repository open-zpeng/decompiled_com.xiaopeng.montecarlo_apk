package com.xiaopeng.montecarlo.account.sync;

import android.text.TextUtils;
import com.autonavi.gbl.user.behavior.model.FavoriteItem;
import com.google.gson.JsonSyntaxException;
import com.xiaopeng.montecarlo.navcore.bean.favorite.FavoriteAddress;
import com.xiaopeng.montecarlo.navcore.favorite.FavoriteUtil;
import com.xiaopeng.montecarlo.navcore.setting.SettingWrapper;
import com.xiaopeng.montecarlo.root.util.GsonUtil;
import com.xiaopeng.montecarlo.root.util.L;
/* loaded from: classes2.dex */
public class FavoriteSyncUtil {
    private static final L.Tag TAG = new L.Tag("FavoriteSyncUtil");

    public static String favoriteItemToJson(FavoriteItem favoriteItem) {
        return GsonUtil.toJson(favoriteItem);
    }

    public static FavoriteItem parseFavoriteItemJson(String str) {
        try {
            return (FavoriteItem) GsonUtil.fromJson(str, (Class<Object>) FavoriteItem.class);
        } catch (JsonSyntaxException e) {
            L.Tag tag = TAG;
            L.e(tag, "parseFavoriteItemJson jsonsyntaxexception json = " + str);
            e.printStackTrace();
            return null;
        }
    }

    public static void setAmapHomeConflictStatus(boolean z, FavoriteItem favoriteItem) {
        SettingWrapper.setAmapHomeConflictStatus(z);
        SettingWrapper.setAmapHomeConflictAddress(favoriteItemToJson(favoriteItem));
    }

    public static void setAmapCompanyConflictStatus(boolean z, FavoriteItem favoriteItem) {
        SettingWrapper.setAMapCompanyConflictStatus(z);
        SettingWrapper.setAMapCompanyConflictAddress(favoriteItemToJson(favoriteItem));
    }

    public static FavoriteItem getAmapHomeConflictFavoriteItem() {
        String aMapHomeConflictAddress = SettingWrapper.getAMapHomeConflictAddress();
        if (TextUtils.isEmpty(aMapHomeConflictAddress)) {
            return null;
        }
        return parseFavoriteItemJson(aMapHomeConflictAddress);
    }

    public static FavoriteItem getAmapCompanyConflictFavoriteItem() {
        String aMapCompanyConflictAddress = SettingWrapper.getAMapCompanyConflictAddress();
        if (TextUtils.isEmpty(aMapCompanyConflictAddress)) {
            return null;
        }
        return parseFavoriteItemJson(aMapCompanyConflictAddress);
    }

    public static void resetHomeCompanyConflictStatus() {
        resetHomeConflictStatus();
        resetCompanyConflictStatus();
    }

    public static void resetHomeConflictStatus() {
        SettingWrapper.setAmapHomeConflictStatus(false);
        SettingWrapper.setAmapHomeConflictAddress("");
    }

    public static void resetCompanyConflictStatus() {
        SettingWrapper.setAMapCompanyConflictStatus(false);
        SettingWrapper.setAMapCompanyConflictAddress("");
    }

    public static boolean bindAmapSuccess() {
        boolean bindAMapStatus = SettingWrapper.getBindAMapStatus();
        L.Tag tag = TAG;
        L.i(tag, "bindAmapSuccess() hasBinded = " + bindAMapStatus);
        return bindAMapStatus;
    }

    public static FavoriteAddress getAmapHomeConflictAddress() {
        FavoriteItem amapHomeConflictFavoriteItem = getAmapHomeConflictFavoriteItem();
        if (amapHomeConflictFavoriteItem != null) {
            return FavoriteUtil.transFavoriteItemToFavoriteAddress(amapHomeConflictFavoriteItem);
        }
        return null;
    }

    public static FavoriteAddress getAmapCompanyConflictAddress() {
        FavoriteItem amapCompanyConflictFavoriteItem = getAmapCompanyConflictFavoriteItem();
        if (amapCompanyConflictFavoriteItem != null) {
            return FavoriteUtil.transFavoriteItemToFavoriteAddress(amapCompanyConflictFavoriteItem);
        }
        return null;
    }
}
