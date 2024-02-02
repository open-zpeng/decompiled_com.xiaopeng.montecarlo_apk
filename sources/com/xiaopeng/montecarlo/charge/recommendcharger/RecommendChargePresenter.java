package com.xiaopeng.montecarlo.charge.recommendcharger;

import com.xiaopeng.montecarlo.charge.recommendcharger.RecommendChargeModel;
import com.xiaopeng.montecarlo.navcore.bean.favorite.FavoriteAddress;
import com.xiaopeng.montecarlo.navcore.favorite.FavoriteDataManager;
import com.xiaopeng.montecarlo.navcore.search.charge.RecommendChargerBean;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import java.util.List;
/* loaded from: classes2.dex */
public class RecommendChargePresenter implements RecommendChargeModel.IRecommendDataListener, FavoriteDataManager.OnFavoriteDataChangeListener {
    private RecommendChargeModel mModel = new RecommendChargeModel();
    private List<RecommendChargerBean> mRecommendChargerBeanList;
    private IRecommendChargerView mView;

    @Override // com.xiaopeng.montecarlo.navcore.favorite.FavoriteDataManager.OnFavoriteDataChangeListener
    public void onFavItemUpdate(FavoriteAddress favoriteAddress) {
    }

    @Override // com.xiaopeng.montecarlo.navcore.favorite.FavoriteDataManager.OnFavoriteDataChangeListener
    public void onFavListUpdate(List<FavoriteAddress> list) {
    }

    @Override // com.xiaopeng.montecarlo.navcore.favorite.FavoriteDataManager.OnFavoriteDataChangeListener
    public void onNormalFavClear(List<FavoriteAddress> list) {
    }

    public RecommendChargePresenter(IRecommendChargerView iRecommendChargerView) {
        this.mView = iRecommendChargerView;
    }

    public void start() {
        this.mModel.setListener(this);
        this.mModel.start();
        FavoriteDataManager.getInstance().addOnFavDataChangeListener(this);
        onRecommendChargeUpdate(this.mRecommendChargerBeanList);
        this.mView.updateTypeIcon();
    }

    public void stop() {
        this.mModel.stop();
        this.mModel.setListener(null);
        FavoriteDataManager.getInstance().removeOnFavDataChangeListener(this);
    }

    @Override // com.xiaopeng.montecarlo.charge.recommendcharger.RecommendChargeModel.IRecommendDataListener
    public void onRecommendChargeUpdate(List<RecommendChargerBean> list) {
        this.mRecommendChargerBeanList = list;
        IRecommendChargerView iRecommendChargerView = this.mView;
        if (iRecommendChargerView == null) {
            return;
        }
        iRecommendChargerView.updateRecommendChargerView(list);
    }

    @Override // com.xiaopeng.montecarlo.navcore.favorite.FavoriteDataManager.OnFavoriteDataChangeListener
    public void onFavItemAdded(FavoriteAddress favoriteAddress) {
        handleFavoriteUpdate(favoriteAddress);
    }

    @Override // com.xiaopeng.montecarlo.navcore.favorite.FavoriteDataManager.OnFavoriteDataChangeListener
    public void onFavItemRemoved(FavoriteAddress favoriteAddress) {
        handleFavoriteUpdate(favoriteAddress);
    }

    @Override // com.xiaopeng.montecarlo.navcore.favorite.FavoriteDataManager.OnFavoriteDataChangeListener
    public void onFavClear(List<FavoriteAddress> list) {
        updateTypeIcon();
    }

    @Override // com.xiaopeng.montecarlo.navcore.favorite.FavoriteDataManager.OnFavoriteDataChangeListener
    public void onFavListAdded(List<FavoriteAddress> list) {
        handleFavoriteUpdate(list);
    }

    @Override // com.xiaopeng.montecarlo.navcore.favorite.FavoriteDataManager.OnFavoriteDataChangeListener
    public void onFavListRemoved(List<FavoriteAddress> list) {
        handleFavoriteUpdate(list);
    }

    @Override // com.xiaopeng.montecarlo.navcore.favorite.FavoriteDataManager.OnFavoriteDataChangeListener
    public void onFavListAddOrUpdate(List<FavoriteAddress> list, List<FavoriteAddress> list2) {
        handleFavoriteUpdate(list);
    }

    @Override // com.xiaopeng.montecarlo.navcore.favorite.FavoriteDataManager.OnFavoriteDataChangeListener
    public void onFavItemReplace(List<FavoriteAddress> list, List<FavoriteAddress> list2) {
        handleFavoriteUpdate(list);
    }

    private void handleFavoriteUpdate(List<FavoriteAddress> list) {
        if (CollectionUtils.isEmpty(list)) {
            return;
        }
        for (int i = 0; i < list.size() && !handleFavoriteUpdate(list.get(i)); i++) {
        }
    }

    private void updateTypeIcon() {
        IRecommendChargerView iRecommendChargerView = this.mView;
        if (iRecommendChargerView == null) {
            return;
        }
        iRecommendChargerView.updateTypeIcon();
    }

    private boolean handleFavoriteUpdate(FavoriteAddress favoriteAddress) {
        if (favoriteAddress != null) {
            if (2 == favoriteAddress.getFavoriteType() || 3 == favoriteAddress.getFavoriteType()) {
                updateTypeIcon();
                return true;
            }
            return false;
        }
        return false;
    }
}
