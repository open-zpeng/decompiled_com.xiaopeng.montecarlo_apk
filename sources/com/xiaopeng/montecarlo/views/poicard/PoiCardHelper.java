package com.xiaopeng.montecarlo.views.poicard;

import android.view.ViewStub;
import androidx.annotation.NonNull;
import com.xiaopeng.montecarlo.base.BaseScene;
import com.xiaopeng.montecarlo.base.MainContext;
import com.xiaopeng.montecarlo.base.scene.IBaseScene;
import com.xiaopeng.montecarlo.mapoverlay.DecoratorManager;
import com.xiaopeng.montecarlo.mapoverlay.base.BaseMapDecorator;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import com.xiaopeng.montecarlo.navcore.state.StateManager;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.stat.PoiPopStatUtil;
import com.xiaopeng.montecarlo.util.NaviUtil;
import com.xiaopeng.montecarlo.util.Utils;
import com.xiaopeng.montecarlo.views.poicard.PoiCardHelper;
/* loaded from: classes3.dex */
public class PoiCardHelper {
    private static final L.Tag TAG = new L.Tag("POP=>PoiCardHelper");
    private PoiCardView mCardView;
    private ViewStub mCardViewStub;
    private final DecoratorCallback mDecoratorCallback;
    private final MainContext mMainContext;
    private final PoiCardManagerCallback mPoiCallback;
    private PoiCardPresenter mPresenter;
    private final BaseScene mScene;

    /* loaded from: classes3.dex */
    public interface PoiCardManagerCallback {
        void onPoiHide(PoiCardView poiCardView);

        void onPoiShow(PoiCardView poiCardView);

        void onPoiUpdate(PoiCardView poiCardView);
    }

    public PoiCardHelper(@NonNull BaseScene baseScene, @NonNull ViewStub viewStub, @NonNull MainContext mainContext, @NonNull PoiCardManagerCallback poiCardManagerCallback) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "init cardView:" + viewStub + ",scene:" + baseScene);
        }
        this.mScene = baseScene;
        this.mCardViewStub = viewStub;
        this.mMainContext = mainContext;
        this.mPoiCallback = poiCardManagerCallback;
        this.mDecoratorCallback = new DecoratorCallback();
        this.mMainContext.getDecoratorManager().addDecoratorCallback(this.mDecoratorCallback);
    }

    public void release() {
        if (L.ENABLE) {
            L.d(TAG, "release");
        }
        this.mMainContext.getDecoratorManager().removeDecoratorCallback(this.mDecoratorCallback);
        PoiCardPresenter poiCardPresenter = this.mPresenter;
        if (poiCardPresenter != null) {
            poiCardPresenter.resetCard();
            this.mPresenter = null;
        }
        this.mCardView = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkCardView() {
        String str;
        if (this.mCardViewStub != null) {
            BaseScene baseScene = this.mScene;
            if (baseScene == null || !baseScene.isAdded() || this.mScene.isDetached()) {
                return true;
            }
            this.mCardView = (PoiCardView) this.mCardViewStub.inflate();
            if (Utils.isLandscape()) {
                this.mCardView.setVuiFatherElementId("id/stub_container");
            } else {
                this.mCardView.setVuiFatherElementId("id/scene_container");
            }
            this.mPresenter = new PoiCardPresenter(this.mScene, this.mCardView, this.mMainContext);
            this.mCardView.init(this.mPresenter, this.mPoiCallback);
            this.mCardViewStub = null;
        }
        if (L.ENABLE) {
            L.Tag tag = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("checkCardView mScene = ");
            sb.append(this.mScene);
            if (this.mScene == null) {
                str = "";
            } else {
                str = ", mScene.isAdded() = " + this.mScene.isAdded() + ", mScene.isDetached() = " + this.mScene.isDetached();
            }
            sb.append(str);
            sb.append(", mCardView = ");
            sb.append(this.mCardView);
            sb.append(", mPresenter = ");
            sb.append(this.mPresenter);
            L.d(tag, sb.toString());
        }
        return this.mCardView == null || this.mPresenter == null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSearchDestForDecorator(BaseMapDecorator baseMapDecorator) {
        if (baseMapDecorator == null) {
            if (L.ENABLE) {
                L.d(TAG, "setSearchDestForDecorator decorator is null");
                return;
            }
            return;
        }
        int i = 1000;
        int i2 = 100;
        IBaseScene currentScene = this.mMainContext.getCurrentScene();
        if (currentScene != null) {
            i = currentScene.getSearchDest();
            i2 = currentScene.getSearchMode();
            if (L.ENABLE) {
                L.Tag tag = TAG;
                L.d(tag, "setSearchDestForDecorator searchDest:" + i);
            }
        }
        baseMapDecorator.setSearchDest(i);
        baseMapDecorator.setSearchMode(i2);
    }

    public boolean isPoiPopup() {
        PoiCardView poiCardView = this.mCardView;
        return poiCardView != null && poiCardView.getVisibility() == 0;
    }

    public PoiCardView getCardView() {
        return this.mCardView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public final class DecoratorCallback implements DecoratorManager.IDecoratorCallback {
        private DecoratorCallback() {
        }

        @Override // com.xiaopeng.montecarlo.mapoverlay.DecoratorManager.IDecoratorCallback
        public void hidePop(final BaseMapDecorator baseMapDecorator) {
            if (L.ENABLE) {
                L.Tag tag = PoiCardHelper.TAG;
                L.d(tag, "hidePop " + baseMapDecorator.getDecoratorType() + ",scene:" + getClass().getSimpleName());
            }
            PoiCardHelper.this.mScene.runOnUiThread(new Runnable() { // from class: com.xiaopeng.montecarlo.views.poicard.-$$Lambda$PoiCardHelper$DecoratorCallback$GFyxcQBK_WqTm_21uCGvfo62Bu8
                @Override // java.lang.Runnable
                public final void run() {
                    PoiCardHelper.DecoratorCallback.this.lambda$hidePop$0$PoiCardHelper$DecoratorCallback(baseMapDecorator);
                }
            });
        }

        public /* synthetic */ void lambda$hidePop$0$PoiCardHelper$DecoratorCallback(BaseMapDecorator baseMapDecorator) {
            if (PoiCardHelper.this.checkCardView()) {
                L.w(PoiCardHelper.TAG, "checkCardView is true");
                return;
            }
            PoiPopStatUtil.sendStatDataWhenPoiDismiss(PoiCardHelper.this.mMainContext);
            if (!baseMapDecorator.isHideByChange()) {
                PoiCardHelper.this.mPresenter.hideCard();
            } else if (L.ENABLE) {
                L.Tag tag = PoiCardHelper.TAG;
                L.d(tag, "hidePop isHideByChange" + baseMapDecorator.getDecoratorType() + ",scene:" + getClass().getSimpleName());
            }
        }

        @Override // com.xiaopeng.montecarlo.mapoverlay.DecoratorManager.IDecoratorCallback
        public void preparePop(final BaseMapDecorator baseMapDecorator, final boolean z) {
            if (L.ENABLE) {
                L.Tag tag = PoiCardHelper.TAG;
                L.d(tag, "preparePop decorator:" + baseMapDecorator + ",isShowing:" + z);
            }
            PoiCardHelper.this.mScene.runOnUiThread(new Runnable() { // from class: com.xiaopeng.montecarlo.views.poicard.-$$Lambda$PoiCardHelper$DecoratorCallback$DDcxwucWciW8IcZp2QP8QGgjC-8
                @Override // java.lang.Runnable
                public final void run() {
                    PoiCardHelper.DecoratorCallback.this.lambda$preparePop$1$PoiCardHelper$DecoratorCallback(baseMapDecorator, z);
                }
            });
        }

        public /* synthetic */ void lambda$preparePop$1$PoiCardHelper$DecoratorCallback(BaseMapDecorator baseMapDecorator, boolean z) {
            if (PoiCardHelper.this.checkCardView()) {
                L.w(PoiCardHelper.TAG, "checkCardView is true");
            } else {
                PoiCardHelper.this.mPresenter.showLoading(baseMapDecorator, z);
            }
        }

        @Override // com.xiaopeng.montecarlo.mapoverlay.DecoratorManager.IDecoratorCallback
        public void showPop(final BaseMapDecorator baseMapDecorator) {
            if (L.ENABLE) {
                L.Tag tag = PoiCardHelper.TAG;
                L.d(tag, "showPop " + baseMapDecorator.getDecoratorType());
            }
            PoiCardHelper.this.mScene.runOnUiThread(new Runnable() { // from class: com.xiaopeng.montecarlo.views.poicard.-$$Lambda$PoiCardHelper$DecoratorCallback$PAL1nLwtCuMWYEdJqhSgr7QVxDU
                @Override // java.lang.Runnable
                public final void run() {
                    PoiCardHelper.DecoratorCallback.this.lambda$showPop$2$PoiCardHelper$DecoratorCallback(baseMapDecorator);
                }
            });
        }

        public /* synthetic */ void lambda$showPop$2$PoiCardHelper$DecoratorCallback(BaseMapDecorator baseMapDecorator) {
            if (PoiCardHelper.this.checkCardView()) {
                L.w(PoiCardHelper.TAG, "checkCardView is true");
                return;
            }
            PoiCardHelper.this.setSearchDestForDecorator(baseMapDecorator);
            XPPoiInfo currentExpandedPoi = baseMapDecorator.getCurrentExpandedPoi();
            if (currentExpandedPoi == null) {
                return;
            }
            if (L.ENABLE) {
                L.Tag tag = PoiCardHelper.TAG;
                L.d(tag, "showPop poiInfo = " + currentExpandedPoi.dumpXPPoiInfo());
            }
            XPPoiInfo favoritePoi = baseMapDecorator.getFavoritePoi();
            if (favoritePoi != null) {
                currentExpandedPoi.setName(favoritePoi.getName());
                currentExpandedPoi.setAddress(favoritePoi.getAddress());
                currentExpandedPoi.setNaviLon(favoritePoi.getNaviLon());
                currentExpandedPoi.setNaviLat(favoritePoi.getNaviLat());
                currentExpandedPoi.setDisplayLat(favoritePoi.getDisplayLat());
                currentExpandedPoi.setDisplayLon(favoritePoi.getDisplayLon());
                currentExpandedPoi.setPoiSource(favoritePoi.getPoiSource());
                currentExpandedPoi.setBlCategory(favoritePoi.getBlCategory());
            }
            XPPoiInfo currentShowPoiInfo = PoiCardHelper.this.mPresenter.getCurrentShowPoiInfo();
            boolean z = currentShowPoiInfo != null ? !NaviUtil.isSamePOI(currentShowPoiInfo, currentExpandedPoi) : false;
            PoiCardHelper.this.mMainContext.getMapView().getBizControlManager().setFollowMode(false);
            if (StateManager.getInstance().getState() == 1) {
                StateManager.getInstance().switchActiveState();
            }
            if (PoiCardHelper.this.mCardView.getVisibility() == 0 && PoiCardHelper.this.mCardView.getBodyVisibility() == 0 && !z) {
                PoiCardHelper.this.mPresenter.updateCard(currentExpandedPoi, baseMapDecorator);
                return;
            }
            if (L.ENABLE) {
                L.d(PoiCardHelper.TAG, "show card or show sub card");
            }
            PoiPopStatUtil.sendStatDataWhenPoiPop(currentExpandedPoi, PoiCardHelper.this.mMainContext);
            PoiCardHelper.this.mPresenter.showCard(currentExpandedPoi, baseMapDecorator);
        }

        @Override // com.xiaopeng.montecarlo.mapoverlay.DecoratorManager.IDecoratorCallback
        public void updatePop(final BaseMapDecorator baseMapDecorator, final XPPoiInfo xPPoiInfo) {
            if (L.ENABLE) {
                L.Tag tag = PoiCardHelper.TAG;
                StringBuilder sb = new StringBuilder();
                sb.append("updatePop ");
                sb.append(baseMapDecorator.getDecoratorType());
                sb.append(", poiInfo = ");
                sb.append(xPPoiInfo == null ? "" : xPPoiInfo.dumpXPPoiInfo());
                L.d(tag, sb.toString());
            }
            PoiCardHelper.this.mScene.runOnUiThread(new Runnable() { // from class: com.xiaopeng.montecarlo.views.poicard.-$$Lambda$PoiCardHelper$DecoratorCallback$hqkAkl1c4qQnKf7tbiffUzurDUE
                @Override // java.lang.Runnable
                public final void run() {
                    PoiCardHelper.DecoratorCallback.this.lambda$updatePop$3$PoiCardHelper$DecoratorCallback(xPPoiInfo, baseMapDecorator);
                }
            });
        }

        public /* synthetic */ void lambda$updatePop$3$PoiCardHelper$DecoratorCallback(XPPoiInfo xPPoiInfo, BaseMapDecorator baseMapDecorator) {
            if (PoiCardHelper.this.checkCardView()) {
                L.w(PoiCardHelper.TAG, "checkCardView is true");
            } else if (PoiCardHelper.this.isPoiPopup()) {
                PoiCardHelper.this.mPresenter.updateCard(xPPoiInfo, baseMapDecorator);
            } else {
                L.e(PoiCardHelper.TAG, "updatePop isPoiPopup = false");
            }
        }
    }
}
