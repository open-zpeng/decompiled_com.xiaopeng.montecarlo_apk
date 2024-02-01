package com.xiaopeng.montecarlo.mapoverlay;

import android.os.Bundle;
import android.util.SparseArray;
import androidx.annotation.MainThread;
import com.xiaopeng.montecarlo.base.MainContext;
import com.xiaopeng.montecarlo.base.scene.IBaseScene;
import com.xiaopeng.montecarlo.mapoverlay.base.BaseMapDecorator;
import com.xiaopeng.montecarlo.mapoverlay.base.control.XpOverlayControlModule;
import com.xiaopeng.montecarlo.mapoverlay.charge.ChargeDecorator;
import com.xiaopeng.montecarlo.mapoverlay.favorite.FavoriteDecorator;
import com.xiaopeng.montecarlo.mapoverlay.mark.MarkPointDecorator;
import com.xiaopeng.montecarlo.mapoverlay.poidetail.PoiDetailDecorator;
import com.xiaopeng.montecarlo.mapoverlay.poidetail.RecommendChargeDecorator;
import com.xiaopeng.montecarlo.mapoverlay.rgc.RgcDecorator;
import com.xiaopeng.montecarlo.mapoverlay.search.SearchDecorator;
import com.xiaopeng.montecarlo.mapoverlay.vpa.VPADecorator;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.scenes.popdialogscene.PopDialogFragment;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class DecoratorManager {
    private static final L.Tag TAG = new L.Tag("POP=>DecoratorManager");
    private BaseMapDecorator mCurrentActiveDecorator;
    private final MainContext mMainContext;
    private final HashMap<IBaseScene, List<BaseMapDecorator>> mSceneDecorator = new HashMap<>();
    private final SparseArray<BaseMapDecorator> mGlobalDecorator = new SparseArray<>();
    private final List<IDecoratorCallback> mDecoratorCallbacks = new ArrayList();
    private final BaseMapDecorator.IMapDecoratorStatusListener mMapDecoratorListener = new MapDecoratorListener();

    /* loaded from: classes.dex */
    public interface IDecoratorCallback {
        void hidePop(BaseMapDecorator baseMapDecorator);

        void preparePop(BaseMapDecorator baseMapDecorator, boolean z);

        void showPop(BaseMapDecorator baseMapDecorator);

        void updatePop(BaseMapDecorator baseMapDecorator, XPPoiInfo xPPoiInfo);
    }

    public DecoratorManager(MainContext mainContext) {
        this.mMainContext = mainContext;
        XpOverlayControlModule.init(mainContext);
    }

    public void addDecoratorCallback(IDecoratorCallback iDecoratorCallback) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "addDecoratorCallback decoratorCallback:" + iDecoratorCallback);
        }
        if (this.mDecoratorCallbacks.contains(iDecoratorCallback)) {
            return;
        }
        this.mDecoratorCallbacks.add(iDecoratorCallback);
    }

    public void removeDecoratorCallback(IDecoratorCallback iDecoratorCallback) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "removeDecoratorCallback decoratorCallback:" + iDecoratorCallback);
        }
        this.mDecoratorCallbacks.remove(iDecoratorCallback);
    }

    public boolean isCardShowing() {
        return this.mCurrentActiveDecorator != null;
    }

    @MainThread
    public void showMapDecorator(IBaseScene iBaseScene, DecoratorType decoratorType, Bundle bundle) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "showMapDecorator scene:" + iBaseScene + ",type:" + decoratorType + ",bundle:" + bundle);
        }
        BaseMapDecorator findDecorator = findDecorator(iBaseScene, decoratorType);
        if (findDecorator == null) {
            findDecorator = createMapDecorator(iBaseScene, decoratorType);
        }
        if (findDecorator != null) {
            findDecorator.update(bundle);
            findDecorator.show();
        }
    }

    @MainThread
    public void show(IBaseScene iBaseScene, DecoratorType decoratorType) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "show scene:" + iBaseScene + ", decoratorType = " + decoratorType);
        }
        BaseMapDecorator findDecorator = findDecorator(iBaseScene, decoratorType);
        if (findDecorator != null) {
            findDecorator.show();
        }
    }

    @MainThread
    public void hide(IBaseScene iBaseScene, DecoratorType decoratorType) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "hide scene:" + iBaseScene + ", decoratorType = " + decoratorType);
        }
        BaseMapDecorator baseMapDecorator = this.mCurrentActiveDecorator;
        if (baseMapDecorator != null && decoratorType == baseMapDecorator.getDecoratorType()) {
            clearFocus(iBaseScene);
        }
        BaseMapDecorator findDecorator = findDecorator(iBaseScene, decoratorType);
        if (findDecorator != null) {
            findDecorator.hide();
        }
    }

    @MainThread
    public void resumeMapDecorator(IBaseScene iBaseScene) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "resumeMapDecorator scene:" + iBaseScene);
        }
        if (iBaseScene instanceof PopDialogFragment) {
            if (L.ENABLE) {
                L.d(TAG, "resumeMapDecorator scene is PopDialogFragment ,so return it");
                return;
            }
            return;
        }
        List<BaseMapDecorator> list = this.mSceneDecorator.get(iBaseScene);
        if (!CollectionUtils.isEmpty(list)) {
            for (BaseMapDecorator baseMapDecorator : list) {
                if (baseMapDecorator != null) {
                    baseMapDecorator.resume(iBaseScene);
                }
            }
        }
        if (CollectionUtils.isEmpty(this.mGlobalDecorator)) {
            return;
        }
        for (int i = 0; i < this.mGlobalDecorator.size(); i++) {
            BaseMapDecorator valueAt = this.mGlobalDecorator.valueAt(i);
            if (valueAt != null) {
                valueAt.resume(iBaseScene);
            }
        }
    }

    @MainThread
    public void pauseMapDecorator(IBaseScene iBaseScene) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "pauseMapDecorator scene:" + iBaseScene);
        }
        if (iBaseScene instanceof PopDialogFragment) {
            if (L.ENABLE) {
                L.d(TAG, "pauseMapDecorator scene is PopDialogFragment ,so return it");
                return;
            }
            return;
        }
        List<BaseMapDecorator> list = this.mSceneDecorator.get(iBaseScene);
        if (!CollectionUtils.isEmpty(list)) {
            for (BaseMapDecorator baseMapDecorator : list) {
                if (baseMapDecorator != null) {
                    baseMapDecorator.pause(iBaseScene);
                }
            }
        }
        if (CollectionUtils.isEmpty(this.mGlobalDecorator)) {
            return;
        }
        for (int i = 0; i < this.mGlobalDecorator.size(); i++) {
            BaseMapDecorator valueAt = this.mGlobalDecorator.valueAt(i);
            if (valueAt != null) {
                valueAt.pause(iBaseScene);
            }
        }
    }

    @MainThread
    public void removeMapDecorator(DecoratorType decoratorType) {
        BaseMapDecorator baseMapDecorator;
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "removeMapDecorator type: " + decoratorType);
        }
        if (CollectionUtils.isEmpty(this.mGlobalDecorator) || (baseMapDecorator = this.mGlobalDecorator.get(decoratorType.ordinal())) == null) {
            return;
        }
        this.mGlobalDecorator.remove(decoratorType.ordinal());
        baseMapDecorator.remove();
    }

    @MainThread
    public void removeMapDecorator(IBaseScene iBaseScene) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "removeMapDecorator scene:" + iBaseScene);
        }
        if (iBaseScene == null) {
            return;
        }
        List<BaseMapDecorator> remove = this.mSceneDecorator.remove(iBaseScene);
        if (CollectionUtils.isEmpty(remove)) {
            return;
        }
        for (BaseMapDecorator baseMapDecorator : remove) {
            if (baseMapDecorator != null) {
                baseMapDecorator.remove();
            }
        }
        BaseMapDecorator baseMapDecorator2 = this.mCurrentActiveDecorator;
        if (baseMapDecorator2 == null || !baseMapDecorator2.isGlobalDecorator()) {
            return;
        }
        if (iBaseScene == this.mCurrentActiveDecorator.getExpandInScene()) {
            clearFocus();
        }
        if (L.ENABLE) {
            L.Tag tag2 = TAG;
            L.d(tag2, "removeMapDecorator global scene:" + iBaseScene + ",decorator:" + this.mCurrentActiveDecorator);
        }
    }

    public void focusByPriority(IBaseScene iBaseScene, XPPoiInfo xPPoiInfo, DecoratorType... decoratorTypeArr) {
        if (L.ENABLE) {
            L.d(TAG, "POP=> focusByPriority poiInfo = " + xPPoiInfo);
        }
        if (xPPoiInfo != null) {
            if (decoratorTypeArr == null || decoratorTypeArr.length == 0) {
                decoratorTypeArr = DecoratorType.values();
            }
            for (DecoratorType decoratorType : decoratorTypeArr) {
                if (L.ENABLE) {
                    L.d(TAG, "POP=> focusByPriority showMapDecorator type = " + decoratorType);
                }
                if (decoratorType == DecoratorType.POI_DETAIL) {
                    Bundle bundle = new Bundle();
                    bundle.putParcelable(PoiDetailDecorator.POI_INFO, xPPoiInfo);
                    showMapDecorator(iBaseScene, decoratorType, bundle);
                }
                if (focus(iBaseScene, decoratorType, xPPoiInfo)) {
                    if (L.ENABLE) {
                        L.d(TAG, "POP=> focusByPriority focus type = " + decoratorType);
                        return;
                    }
                    return;
                }
            }
        }
        if (L.ENABLE) {
            L.e(TAG, "focusByPriority  can't find point :" + xPPoiInfo);
        }
    }

    @MainThread
    public boolean focus(IBaseScene iBaseScene, DecoratorType decoratorType, XPPoiInfo xPPoiInfo) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("focus scene:");
            sb.append(iBaseScene);
            sb.append(", type:");
            sb.append(decoratorType);
            sb.append(", xpPoiInfo:");
            sb.append(xPPoiInfo == null ? "null" : xPPoiInfo.dumpXPPoiInfo());
            L.d(tag, sb.toString());
        }
        BaseMapDecorator findDecorator = findDecorator(iBaseScene, decoratorType);
        if (findDecorator == null || !findDecorator.isShowing()) {
            return false;
        }
        return findDecorator.focus(xPPoiInfo);
    }

    @MainThread
    public void clearFocus(IBaseScene iBaseScene) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "clearFocus scene = " + iBaseScene + ", mCurrentActiveDecorator = " + this.mCurrentActiveDecorator);
        }
        if (this.mCurrentActiveDecorator == null || getCurrentExpandedDecorator(iBaseScene) != this.mCurrentActiveDecorator) {
            return;
        }
        clearFocus();
    }

    @MainThread
    public void clearFocus() {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "clearFocus mCurrentActiveDecorator = " + this.mCurrentActiveDecorator);
        }
        BaseMapDecorator baseMapDecorator = this.mCurrentActiveDecorator;
        if (baseMapDecorator != null) {
            if (baseMapDecorator.isFocus()) {
                this.mCurrentActiveDecorator.setHideByChange(false);
                this.mCurrentActiveDecorator.clearFocus();
                return;
            }
            L.Tag tag2 = TAG;
            L.e(tag2, "clearFocus mCurrentActiveDecorator = " + this.mCurrentActiveDecorator);
        }
    }

    @MainThread
    public void changeFocus() {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "changeFocus mCurrentActiveDecorator = " + this.mCurrentActiveDecorator);
        }
        BaseMapDecorator baseMapDecorator = this.mCurrentActiveDecorator;
        if (baseMapDecorator != null) {
            if (baseMapDecorator.isFocus()) {
                this.mCurrentActiveDecorator.setHideByChange(this.mMainContext.getCurrentScene() == this.mCurrentActiveDecorator.getExpandInScene());
                this.mCurrentActiveDecorator.clearFocus();
                return;
            }
            L.Tag tag2 = TAG;
            L.e(tag2, "clearFocus mCurrentActiveDecorator = " + this.mCurrentActiveDecorator);
        }
    }

    @MainThread
    public void unInit() {
        if (CollectionUtils.isEmpty(this.mGlobalDecorator)) {
            return;
        }
        for (int i = 0; i < this.mGlobalDecorator.size(); i++) {
            BaseMapDecorator valueAt = this.mGlobalDecorator.valueAt(i);
            if (valueAt != null) {
                valueAt.remove();
            }
        }
        this.mGlobalDecorator.clear();
    }

    private BaseMapDecorator getCurrentExpandedDecorator(IBaseScene iBaseScene) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "getCurrentExpandedDecorator scene:" + iBaseScene);
        }
        BaseMapDecorator baseMapDecorator = this.mCurrentActiveDecorator;
        if (baseMapDecorator != null) {
            if (baseMapDecorator.isGlobalDecorator()) {
                r2 = iBaseScene == this.mCurrentActiveDecorator.getExpandInScene() ? this.mCurrentActiveDecorator : null;
                if (L.ENABLE) {
                    L.Tag tag2 = TAG;
                    L.d(tag2, "getCurrentExpandedDecorator global scene:" + iBaseScene + ",decorator:" + r2);
                }
            } else {
                BaseMapDecorator findDecorator = findDecorator(iBaseScene, this.mCurrentActiveDecorator.getDecoratorType());
                r2 = findDecorator == this.mCurrentActiveDecorator ? findDecorator : null;
                if (L.ENABLE) {
                    L.Tag tag3 = TAG;
                    L.d(tag3, "getCurrentExpandedDecorator scene:" + iBaseScene + ",decorator:" + r2);
                }
            }
        }
        return r2;
    }

    private BaseMapDecorator createMapDecorator(IBaseScene iBaseScene, DecoratorType decoratorType) {
        BaseMapDecorator rgcDecorator;
        if (L.ENABLE) {
            L.d(TAG, "createMapDecorator scene:" + iBaseScene + ", type: " + decoratorType);
        }
        switch (decoratorType) {
            case RGC:
                rgcDecorator = new RgcDecorator(decoratorType, this.mMainContext, this.mMapDecoratorListener);
                break;
            case START_POINT:
                rgcDecorator = new StartPointDecorator(decoratorType, this.mMainContext, this.mMapDecoratorListener);
                break;
            case WAY_POINT:
                rgcDecorator = new WayPointDecorator(decoratorType, this.mMainContext, this.mMapDecoratorListener);
                break;
            case END_POINT:
                rgcDecorator = new EndPointDecorator(decoratorType, this.mMainContext, this.mMapDecoratorListener);
                break;
            case SEARCH:
                rgcDecorator = new SearchDecorator(decoratorType, this.mMainContext, this.mMapDecoratorListener);
                break;
            case CHARGE:
                rgcDecorator = new ChargeDecorator(decoratorType, this.mMainContext, this.mMapDecoratorListener);
                break;
            case FAVORITE:
                rgcDecorator = new FavoriteDecorator(decoratorType, this.mMainContext, this.mMapDecoratorListener);
                break;
            case POI_DETAIL:
                rgcDecorator = new PoiDetailDecorator(decoratorType, this.mMainContext, this.mMapDecoratorListener);
                break;
            case RECOMMEND_CHARGE:
                rgcDecorator = new RecommendChargeDecorator(decoratorType, this.mMainContext, this.mMapDecoratorListener);
                break;
            case MARK:
                rgcDecorator = new MarkPointDecorator(decoratorType, this.mMainContext, this.mMapDecoratorListener);
                break;
            case VPA:
                rgcDecorator = new VPADecorator(decoratorType, this.mMainContext, this.mMapDecoratorListener);
                break;
            default:
                rgcDecorator = null;
                break;
        }
        if (rgcDecorator == null) {
            return null;
        }
        if (rgcDecorator.isGlobalDecorator()) {
            this.mGlobalDecorator.put(decoratorType.ordinal(), rgcDecorator);
        } else if (iBaseScene == null) {
            L.e(TAG, "decorator isAutoRemoveWithScene need a scene: " + decoratorType);
            return null;
        } else {
            List<BaseMapDecorator> list = this.mSceneDecorator.get(iBaseScene);
            if (CollectionUtils.isEmpty(list)) {
                list = new ArrayList<>();
                this.mSceneDecorator.put(iBaseScene, list);
            }
            list.add(rgcDecorator);
        }
        return rgcDecorator;
    }

    private BaseMapDecorator findDecorator(IBaseScene iBaseScene, DecoratorType decoratorType) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "findDecorator scene:" + iBaseScene + ", type: " + decoratorType);
        }
        if (iBaseScene != null) {
            List<BaseMapDecorator> list = this.mSceneDecorator.get(iBaseScene);
            if (!CollectionUtils.isEmpty(list)) {
                for (BaseMapDecorator baseMapDecorator : list) {
                    if (baseMapDecorator.getDecoratorType() == decoratorType) {
                        return baseMapDecorator;
                    }
                }
            }
        }
        if (CollectionUtils.isEmpty(this.mGlobalDecorator)) {
            return null;
        }
        for (int i = 0; i < this.mGlobalDecorator.size(); i++) {
            BaseMapDecorator valueAt = this.mGlobalDecorator.valueAt(i);
            if (valueAt != null && valueAt.getDecoratorType() == decoratorType) {
                return valueAt;
            }
        }
        return null;
    }

    /* loaded from: classes.dex */
    private class MapDecoratorListener implements BaseMapDecorator.IMapDecoratorStatusListener {
        private MapDecoratorListener() {
        }

        @Override // com.xiaopeng.montecarlo.mapoverlay.base.BaseMapDecorator.IMapDecoratorStatusListener
        public void onDecoratorExpand(BaseMapDecorator baseMapDecorator) {
            if (L.ENABLE) {
                L.Tag tag = DecoratorManager.TAG;
                L.d(tag, "onDecoratorExpand decorator:" + baseMapDecorator + ",mCurrentActiveDecorator:" + DecoratorManager.this.mCurrentActiveDecorator);
            }
            DecoratorManager.this.mCurrentActiveDecorator = baseMapDecorator;
            for (IDecoratorCallback iDecoratorCallback : DecoratorManager.this.mDecoratorCallbacks) {
                if (iDecoratorCallback != null) {
                    iDecoratorCallback.showPop(baseMapDecorator);
                }
            }
        }

        @Override // com.xiaopeng.montecarlo.mapoverlay.base.BaseMapDecorator.IMapDecoratorStatusListener
        public void onDecoratorCollapse(BaseMapDecorator baseMapDecorator) {
            if (L.ENABLE) {
                L.Tag tag = DecoratorManager.TAG;
                L.d(tag, "onDecoratorCollapse decorator:" + baseMapDecorator + ",mCurrentActiveDecorator:" + DecoratorManager.this.mCurrentActiveDecorator);
            }
            if (DecoratorManager.this.mCurrentActiveDecorator == baseMapDecorator) {
                for (IDecoratorCallback iDecoratorCallback : DecoratorManager.this.mDecoratorCallbacks) {
                    if (iDecoratorCallback != null) {
                        iDecoratorCallback.hidePop(baseMapDecorator);
                    }
                }
                DecoratorManager.this.mCurrentActiveDecorator = null;
                return;
            }
            L.Tag tag2 = DecoratorManager.TAG;
            L.e(tag2, "onDecoratorCollapse decorator:" + baseMapDecorator + ",mCurrentActiveDecorator:" + DecoratorManager.this.mCurrentActiveDecorator);
        }

        @Override // com.xiaopeng.montecarlo.mapoverlay.base.BaseMapDecorator.IMapDecoratorStatusListener
        public void onDecoratorRemoved(BaseMapDecorator baseMapDecorator) {
            if (L.ENABLE) {
                L.Tag tag = DecoratorManager.TAG;
                L.d(tag, "onDecoratorRemoved decorator:" + baseMapDecorator + ",mCurrentActiveDecorator:" + DecoratorManager.this.mCurrentActiveDecorator);
            }
            if (baseMapDecorator == null) {
                return;
            }
            if (baseMapDecorator.isGlobalDecorator()) {
                int indexOfValue = DecoratorManager.this.mGlobalDecorator.indexOfValue(baseMapDecorator);
                if (indexOfValue <= -1 || indexOfValue >= DecoratorManager.this.mGlobalDecorator.size()) {
                    return;
                }
                DecoratorManager.this.mGlobalDecorator.removeAt(indexOfValue);
                return;
            }
            Iterator it = DecoratorManager.this.mSceneDecorator.values().iterator();
            while (it.hasNext() && !((List) it.next()).remove(baseMapDecorator)) {
            }
        }

        @Override // com.xiaopeng.montecarlo.mapoverlay.base.BaseMapDecorator.IMapDecoratorStatusListener
        public void onDecoratorUpdated(BaseMapDecorator baseMapDecorator, XPPoiInfo xPPoiInfo) {
            if (L.ENABLE) {
                L.Tag tag = DecoratorManager.TAG;
                StringBuilder sb = new StringBuilder();
                sb.append("onDecoratorUpdated decorator:");
                sb.append(baseMapDecorator);
                sb.append(",mCurrentActiveDecorator:");
                sb.append(DecoratorManager.this.mCurrentActiveDecorator);
                sb.append(", xpPoiInfo = ");
                sb.append(xPPoiInfo == null ? "null" : xPPoiInfo.dumpXPPoiInfo());
                L.d(tag, sb.toString());
            }
            if (DecoratorManager.this.mCurrentActiveDecorator == baseMapDecorator) {
                for (IDecoratorCallback iDecoratorCallback : DecoratorManager.this.mDecoratorCallbacks) {
                    if (iDecoratorCallback != null) {
                        iDecoratorCallback.updatePop(baseMapDecorator, xPPoiInfo);
                    }
                }
                return;
            }
            L.Tag tag2 = DecoratorManager.TAG;
            L.e(tag2, "onDecoratorUpdated decorator:" + baseMapDecorator + ",mCurrentActiveDecorator:" + DecoratorManager.this.mCurrentActiveDecorator);
        }

        @Override // com.xiaopeng.montecarlo.mapoverlay.base.BaseMapDecorator.IMapDecoratorStatusListener
        public void onDecoratorLoading(BaseMapDecorator baseMapDecorator, boolean z) {
            if (L.ENABLE) {
                L.Tag tag = DecoratorManager.TAG;
                L.d(tag, "onDecoratorUpdated decorator:" + baseMapDecorator + ",mCurrentActiveDecorator:" + DecoratorManager.this.mCurrentActiveDecorator + ",isShowing:" + z);
            }
            if (z) {
                if (DecoratorManager.this.mCurrentActiveDecorator != baseMapDecorator) {
                    DecoratorManager.this.mCurrentActiveDecorator = baseMapDecorator;
                } else {
                    L.Tag tag2 = DecoratorManager.TAG;
                    L.e(tag2, "onDecoratorUpdated decorator:" + baseMapDecorator + ",mCurrentActiveDecorator:" + DecoratorManager.this.mCurrentActiveDecorator + ",isShowing:" + z);
                }
            }
            for (IDecoratorCallback iDecoratorCallback : DecoratorManager.this.mDecoratorCallbacks) {
                if (iDecoratorCallback != null) {
                    iDecoratorCallback.preparePop(baseMapDecorator, z);
                }
            }
        }
    }
}
