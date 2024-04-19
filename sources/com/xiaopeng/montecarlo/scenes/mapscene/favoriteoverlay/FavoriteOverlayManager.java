package com.xiaopeng.montecarlo.scenes.mapscene.favoriteoverlay;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.xiaopeng.montecarlo.base.MainContext;
import com.xiaopeng.montecarlo.mapoverlay.DecoratorType;
import com.xiaopeng.montecarlo.mapoverlay.base.BaseMapDecorator;
import com.xiaopeng.montecarlo.mapoverlay.favorite.FavoriteDecorator;
import com.xiaopeng.montecarlo.navcore.account.XPAccountServiceWrapper;
import com.xiaopeng.montecarlo.navcore.bean.favorite.FavoriteAddress;
import com.xiaopeng.montecarlo.navcore.favorite.FavoriteDataManager;
import com.xiaopeng.montecarlo.navcore.mapdisplay.MapViewWrapper;
import com.xiaopeng.montecarlo.root.account.AccountObservable;
import com.xiaopeng.montecarlo.root.account.UserInfo;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.UiHandlerUtil;
import com.xiaopeng.montecarlo.root.util.WorkThreadUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
/* loaded from: classes3.dex */
public class FavoriteOverlayManager {
    private static final L.Tag TAG = new L.Tag("POP=>FavoriteOverlay");
    private FavoriteAddress mFavoriteAddress;
    private final MainContext mMainContext;
    private final MapViewWrapper mMapViewWrapper;
    private final FavoriteDataManager.OnFavoriteDataChangeListener mOnDataChangeListener = new FavoriteDataManager.OnFavoriteDataChangeListener() { // from class: com.xiaopeng.montecarlo.scenes.mapscene.favoriteoverlay.FavoriteOverlayManager.1
        @Override // com.xiaopeng.montecarlo.navcore.favorite.FavoriteDataManager.OnFavoriteDataChangeListener
        public void onFavItemUpdate(FavoriteAddress favoriteAddress) {
            L.Tag tag = FavoriteOverlayManager.TAG;
            L.d(tag, "onFavItemUpdate---favoriteAddress：" + favoriteAddress);
            FavoriteOverlayManager.this.updateFavoriteOverlay();
        }

        @Override // com.xiaopeng.montecarlo.navcore.favorite.FavoriteDataManager.OnFavoriteDataChangeListener
        public void onFavItemAdded(FavoriteAddress favoriteAddress) {
            if (favoriteAddress != null) {
                L.Tag tag = FavoriteOverlayManager.TAG;
                L.d(tag, "onFavItemAdded---favoriteAddress：" + favoriteAddress);
                FavoriteOverlayManager.this.mFavoriteAddress = favoriteAddress;
                FavoriteOverlayManager.this.updateFavoriteOverlay();
                return;
            }
            L.e(FavoriteOverlayManager.TAG, "onFavItemAdded---favoriteAddres is null");
        }

        @Override // com.xiaopeng.montecarlo.navcore.favorite.FavoriteDataManager.OnFavoriteDataChangeListener
        public void onFavItemRemoved(FavoriteAddress favoriteAddress) {
            L.Tag tag = FavoriteOverlayManager.TAG;
            L.d(tag, "onFavItemRemoved---favoriteAddress：" + favoriteAddress);
            FavoriteOverlayManager.this.mFavoriteAddress = null;
            FavoriteOverlayManager.this.updateFavoriteOverlay();
        }

        @Override // com.xiaopeng.montecarlo.navcore.favorite.FavoriteDataManager.OnFavoriteDataChangeListener
        public void onNormalFavClear(List<FavoriteAddress> list) {
            L.d(FavoriteOverlayManager.TAG, "onFavNormalListClear---");
            FavoriteOverlayManager.this.mFavoriteAddress = null;
            FavoriteOverlayManager.this.updateFavoriteOverlay();
        }

        @Override // com.xiaopeng.montecarlo.navcore.favorite.FavoriteDataManager.OnFavoriteDataChangeListener
        public void onFavClear(List<FavoriteAddress> list) {
            L.d(FavoriteOverlayManager.TAG, "onFavClear---");
            FavoriteOverlayManager.this.mFavoriteAddress = null;
            FavoriteOverlayManager.this.updateFavoriteOverlay();
        }

        @Override // com.xiaopeng.montecarlo.navcore.favorite.FavoriteDataManager.OnFavoriteDataChangeListener
        public void onFavListAdded(List<FavoriteAddress> list) {
            L.Tag tag = FavoriteOverlayManager.TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("onFavListAdded---list.size() = ");
            sb.append(list == null ? 0 : list.size());
            L.d(tag, sb.toString());
            FavoriteOverlayManager.this.mFavoriteAddress = null;
            FavoriteOverlayManager.this.updateFavoriteOverlay();
        }

        @Override // com.xiaopeng.montecarlo.navcore.favorite.FavoriteDataManager.OnFavoriteDataChangeListener
        public void onFavListUpdate(List<FavoriteAddress> list) {
            L.Tag tag = FavoriteOverlayManager.TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("onFavListUpdate---list.size() = ");
            sb.append(list == null ? 0 : list.size());
            L.d(tag, sb.toString());
            FavoriteOverlayManager.this.mFavoriteAddress = null;
            FavoriteOverlayManager.this.updateFavoriteOverlay();
        }

        @Override // com.xiaopeng.montecarlo.navcore.favorite.FavoriteDataManager.OnFavoriteDataChangeListener
        public void onFavListRemoved(List<FavoriteAddress> list) {
            L.Tag tag = FavoriteOverlayManager.TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("onFavListRemoved---list.size() = ");
            sb.append(list == null ? 0 : list.size());
            L.d(tag, sb.toString());
            FavoriteOverlayManager.this.mFavoriteAddress = null;
            FavoriteOverlayManager.this.updateFavoriteOverlay();
        }

        @Override // com.xiaopeng.montecarlo.navcore.favorite.FavoriteDataManager.OnFavoriteDataChangeListener
        public void onFavListAddOrUpdate(List<FavoriteAddress> list, List<FavoriteAddress> list2) {
            L.Tag tag = FavoriteOverlayManager.TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("onFavListAddOrUpdate---addList.size() = ");
            sb.append(list == null ? 0 : list.size());
            sb.append(", updateList.size() = ");
            sb.append(list2 != null ? list2.size() : 0);
            L.d(tag, sb.toString());
            FavoriteOverlayManager.this.mFavoriteAddress = null;
            FavoriteOverlayManager.this.updateFavoriteOverlay();
        }

        @Override // com.xiaopeng.montecarlo.navcore.favorite.FavoriteDataManager.OnFavoriteDataChangeListener
        public void onFavItemReplace(List<FavoriteAddress> list, List<FavoriteAddress> list2) {
            L.Tag tag = FavoriteOverlayManager.TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("onFavItemReplace---addList.size() = ");
            sb.append(list == null ? 0 : list.size());
            sb.append(", deleteList.size() = ");
            sb.append(list2 != null ? list2.size() : 0);
            L.i(tag, sb.toString());
            FavoriteOverlayManager.this.mFavoriteAddress = null;
            FavoriteOverlayManager.this.updateFavoriteOverlay();
        }
    };
    private final Observer mObserver = new Observer() { // from class: com.xiaopeng.montecarlo.scenes.mapscene.favoriteoverlay.-$$Lambda$FavoriteOverlayManager$ZMt1WbwVwExRgUzcRJy0T3lPt1Q
        @Override // java.util.Observer
        public final void update(Observable observable, Object obj) {
            FavoriteOverlayManager.this.lambda$new$0$FavoriteOverlayManager(observable, obj);
        }
    };

    public /* synthetic */ void lambda$new$0$FavoriteOverlayManager(Observable observable, Object obj) {
        if (L.ENABLE) {
            L.d(TAG, "Observer update() ---");
        }
        if (obj instanceof UserInfo) {
            UserInfo userInfo = (UserInfo) obj;
            UserInfo.InfoType infoType = userInfo.getInfoType();
            UserInfo.UserType userType = userInfo.getUserType();
            L.Tag tag = TAG;
            L.i(tag, "update infoType = " + infoType + ", userType = " + userType);
            updateFavoriteOverlay();
        }
    }

    public FavoriteOverlayManager(MainContext mainContext, MapViewWrapper mapViewWrapper) {
        this.mMapViewWrapper = mapViewWrapper;
        this.mMainContext = mainContext;
        FavoriteDataManager.getInstance().addOnFavDataChangeListener(this.mOnDataChangeListener);
        AccountObservable.getInstance().addObserver(this.mObserver);
        updateFavoriteOverlay();
    }

    public void updateFavoriteOverlay() {
        if (L.ENABLE) {
            L.d(TAG, "updateFavoriteOverlay");
        }
        UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.mapscene.favoriteoverlay.-$$Lambda$FavoriteOverlayManager$BuVDEa-ToQ5NqZM1__TnNwJVyOE
            @Override // java.lang.Runnable
            public final void run() {
                FavoriteOverlayManager.this.lambda$updateFavoriteOverlay$1$FavoriteOverlayManager();
            }
        });
    }

    public /* synthetic */ void lambda$updateFavoriteOverlay$1$FavoriteOverlayManager() {
        if (isMapInValid()) {
            if (L.ENABLE) {
                L.Tag tag = TAG;
                L.d(tag, "isMapInValid mFavoriteAddress = " + this.mFavoriteAddress);
            }
            this.mMainContext.getDecoratorManager().hide(this.mMainContext.getCurrentScene(), DecoratorType.FAVORITE);
            return;
        }
        showFavoriteOverlay();
    }

    private boolean isShowFavorite() {
        return this.mMainContext.getCurrentScene().isShowFavorite();
    }

    public void destroy() {
        FavoriteDataManager.getInstance().removeOnFavDataChangeListener(this.mOnDataChangeListener);
        AccountObservable.getInstance().deleteObserver(this.mObserver);
    }

    private boolean isAccountGuest() {
        return XPAccountServiceWrapper.getInstance().getUserType() == UserInfo.UserType.TEMP;
    }

    private boolean isMapInValid() {
        int mapLevel;
        return !isShowFavorite() || (mapLevel = this.mMapViewWrapper.getMapLevel()) < 10 || mapLevel > 19;
    }

    private void showFavoriteOverlay() {
        if (L.ENABLE) {
            L.d(TAG, "showFavoriteOverlay");
        }
        WorkThreadUtil.getInstance().executeIOTask(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.mapscene.favoriteoverlay.-$$Lambda$FavoriteOverlayManager$peTYE3eOpcE3GoVd6GGxsJA8yi4
            @Override // java.lang.Runnable
            public final void run() {
                FavoriteOverlayManager.this.lambda$showFavoriteOverlay$3$FavoriteOverlayManager();
            }
        });
    }

    public /* synthetic */ void lambda$showFavoriteOverlay$3$FavoriteOverlayManager() {
        final List<FavoriteAddress> listFavorites = FavoriteDataManager.getInstance().listFavorites();
        UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.mapscene.favoriteoverlay.-$$Lambda$FavoriteOverlayManager$wYkrKin9lvf_pbg2TM1Kdas6uig
            @Override // java.lang.Runnable
            public final void run() {
                FavoriteOverlayManager.this.lambda$null$2$FavoriteOverlayManager(listFavorites);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: updateDecorator */
    public void lambda$null$2$FavoriteOverlayManager(List<FavoriteAddress> list) {
        FavoriteAddress favoriteAddress;
        if (CollectionUtils.isEmpty(list)) {
            if (L.ENABLE) {
                L.d(TAG, "updateDecorator list isEmpty");
            }
            this.mMainContext.getDecoratorManager().removeMapDecorator(DecoratorType.FAVORITE);
            return;
        }
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
        ArrayList<Integer> arrayList2 = new ArrayList<>();
        boolean z = false;
        for (int i = 0; i < list.size(); i++) {
            FavoriteAddress favoriteAddress2 = list.get(i);
            if (favoriteAddress2 != null && favoriteAddress2.getXPPoiInfo() != null) {
                if (!z && (favoriteAddress = this.mFavoriteAddress) != null && favoriteAddress.getXPPoiInfo() != null && TextUtils.equals(favoriteAddress2.getXPPoiInfo().getPoiId(), this.mFavoriteAddress.getXPPoiInfo().getPoiId())) {
                    arrayList.add(this.mFavoriteAddress.getXPPoiInfo());
                    z = true;
                } else {
                    arrayList.add(favoriteAddress2.getXPPoiInfo());
                }
                arrayList2.add(Integer.valueOf(favoriteAddress2.getFavoriteType()));
            }
        }
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList(BaseMapDecorator.KEY_POI_LIST, arrayList);
        bundle.putIntegerArrayList(FavoriteDecorator.KEY_FAVORITE_TYPE_LIST, arrayList2);
        this.mMainContext.getDecoratorManager().showMapDecorator(this.mMainContext.getCurrentScene(), DecoratorType.FAVORITE, bundle);
        if (this.mFavoriteAddress != null) {
            if (L.ENABLE) {
                L.d(TAG, "updateDecorator mFavoriteAddress = " + this.mFavoriteAddress + ", inList = " + z);
            }
            if (this.mMainContext.getDecoratorManager().isCardShowing()) {
                this.mMainContext.getDecoratorManager().focusByPriority(this.mMainContext.getCurrentScene(), this.mFavoriteAddress.getXPPoiInfo(), new DecoratorType[0]);
            }
            this.mFavoriteAddress = null;
        }
    }
}
