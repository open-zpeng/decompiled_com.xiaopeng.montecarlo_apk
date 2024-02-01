package com.xiaopeng.montecarlo.mapoverlay.base;

import android.os.Bundle;
import androidx.annotation.NonNull;
import com.autonavi.gbl.map.layer.BaseLayer;
import com.autonavi.gbl.map.layer.LayerItem;
import com.autonavi.gbl.map.layer.model.ClickViewIdInfo;
import com.xiaopeng.montecarlo.base.MainContext;
import com.xiaopeng.montecarlo.base.scene.IBaseScene;
import com.xiaopeng.montecarlo.mapoverlay.DecoratorType;
import com.xiaopeng.montecarlo.mapoverlay.base.BaseMapDecorator;
import com.xiaopeng.montecarlo.mapoverlay.base.control.IDecoratorOverlayItemOperation;
import com.xiaopeng.montecarlo.mapoverlay.base.control.XpOverlayControlModule;
import com.xiaopeng.montecarlo.navcore.bean.favorite.FavoriteAddress;
import com.xiaopeng.montecarlo.navcore.bean.map.XPPointBaseData;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiCategory;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import com.xiaopeng.montecarlo.navcore.favorite.FavoriteDataManager;
import com.xiaopeng.montecarlo.navcore.mapdisplay.IXpLayerClickObserver;
import com.xiaopeng.montecarlo.navcore.mapdisplay.MapViewWrapper;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.UiHandlerUtil;
import java.util.List;
/* loaded from: classes.dex */
public abstract class BaseMapDecorator {
    public static final String KEY_FAVORITE_POI = "favorite_poi";
    public static final String KEY_POI_LIST = "poi_list";
    private static final int STATUS_HIDE = 1;
    private static final int STATUS_REMOVED = 0;
    private static final int STATUS_SHOW = 2;
    protected IMapDecoratorStatusListener mDecoratorStatusListener;
    protected DecoratorType mDecoratorType;
    protected MainContext mMainContext;
    private final IDecoratorOverlayItemOperation mOverlayControlProxy;
    protected int mOverlayType;
    protected BaseDecoratorPresenter mPresenter;
    private final L.Tag mTag = new L.Tag("POP=>" + getClass().getSimpleName());
    private int mSearchDest = 1000;
    private int mSearchMode = 100;
    private int mStatus = 0;
    private boolean mIsHideByChange = false;
    private IBaseScene mExpandInScene = null;
    protected final BaseDecoratorCallback mDecoratorCallback = new BaseDecoratorCallback() { // from class: com.xiaopeng.montecarlo.mapoverlay.base.BaseMapDecorator.1
        private boolean mLazy = false;

        @Override // com.xiaopeng.montecarlo.mapoverlay.base.BaseDecoratorCallback
        public MainContext getMainContext() {
            return BaseMapDecorator.this.mMainContext;
        }

        @Override // com.xiaopeng.montecarlo.mapoverlay.base.BaseDecoratorCallback
        public void onLoad() {
            if (L.ENABLE) {
                L.Tag tag = BaseMapDecorator.this.mTag;
                L.d(tag, "onLoad " + BaseMapDecorator.this.mDecoratorType);
            }
            if (BaseMapDecorator.this.mDecoratorStatusListener == null || !this.mLazy) {
                return;
            }
            this.mLazy = false;
            if (BaseMapDecorator.this.isFocus()) {
                BaseMapDecorator.this.mDecoratorStatusListener.onDecoratorExpand(BaseMapDecorator.this);
                IMapDecoratorStatusListener iMapDecoratorStatusListener = BaseMapDecorator.this.mDecoratorStatusListener;
                BaseMapDecorator baseMapDecorator = BaseMapDecorator.this;
                iMapDecoratorStatusListener.onDecoratorUpdated(baseMapDecorator, baseMapDecorator.mPresenter.getCurrentExpandedPoint());
                return;
            }
            BaseMapDecorator.this.mDecoratorStatusListener.onDecoratorCollapse(BaseMapDecorator.this);
            BaseMapDecorator.this.mDecoratorStatusListener.onDecoratorLoading(BaseMapDecorator.this, false);
        }

        @Override // com.xiaopeng.montecarlo.mapoverlay.base.BaseDecoratorCallback
        public void onPointUpdate(@NonNull List<XPPointBaseData> list, @NonNull List<XPPointBaseData> list2, @NonNull List<XPPointBaseData> list3) {
            if (L.ENABLE) {
                L.Tag tag = BaseMapDecorator.this.mTag;
                L.d(tag, "onPointUpdate " + BaseMapDecorator.this.mDecoratorType + ", update.size() = " + list.size() + ", add.size() = " + list2.size() + ", remove.size() = " + list3.size());
            }
            if (BaseMapDecorator.this.mPresenter == null || BaseMapDecorator.this.mDecoratorStatusListener == null) {
                return;
            }
            BaseMapDecorator.this.mOverlayControlProxy.removeOverlayItems(list3);
            BaseMapDecorator.this.mOverlayControlProxy.addOverlayItems(list2);
            BaseMapDecorator.this.mOverlayControlProxy.updateOverlayItems(list);
            if (L.ENABLE) {
                L.Tag tag2 = BaseMapDecorator.this.mTag;
                L.d(tag2, "onPointUpdate isFocus = " + BaseMapDecorator.this.isFocus());
            }
            if (BaseMapDecorator.this.isFocus()) {
                if (BaseMapDecorator.this.mExpandInScene == null || BaseMapDecorator.this.mExpandInScene == BaseMapDecorator.this.mMainContext.getCurrentScene()) {
                    BaseMapDecorator.this.mOverlayControlProxy.setOverlayItemFocusStatus(BaseMapDecorator.this.mPresenter.getCurrentExpandedBizPoint(), true);
                    if (BaseMapDecorator.this.mDecoratorStatusListener == null || this.mLazy) {
                        return;
                    }
                    IMapDecoratorStatusListener iMapDecoratorStatusListener = BaseMapDecorator.this.mDecoratorStatusListener;
                    BaseMapDecorator baseMapDecorator = BaseMapDecorator.this;
                    iMapDecoratorStatusListener.onDecoratorUpdated(baseMapDecorator, baseMapDecorator.mPresenter.getCurrentExpandedPoint());
                }
            }
        }

        @Override // com.xiaopeng.montecarlo.mapoverlay.base.BaseDecoratorCallback
        public void onClearFocus(XPPointBaseData xPPointBaseData) {
            if (L.ENABLE) {
                L.Tag tag = BaseMapDecorator.this.mTag;
                L.d(tag, "onClearFocus " + BaseMapDecorator.this.mDecoratorType + ", pointBaseData = " + xPPointBaseData);
            }
            if (BaseMapDecorator.this.mPresenter == null || BaseMapDecorator.this.mDecoratorStatusListener == null) {
                return;
            }
            BaseMapDecorator.this.mExpandInScene = null;
            BaseMapDecorator.this.mOverlayControlProxy.setOverlayItemFocusStatus(xPPointBaseData, false);
            BaseMapDecorator.this.mDecoratorStatusListener.onDecoratorCollapse(BaseMapDecorator.this);
        }

        @Override // com.xiaopeng.montecarlo.mapoverlay.base.BaseDecoratorCallback
        public void onFocus(boolean z) {
            BaseMapDecorator.this.setHideByChange(false);
            this.mLazy = z;
            if (L.ENABLE) {
                L.Tag tag = BaseMapDecorator.this.mTag;
                L.d(tag, "onFocus " + BaseMapDecorator.this.mDecoratorType);
            }
            if (BaseMapDecorator.this.mPresenter == null || BaseMapDecorator.this.mDecoratorStatusListener == null) {
                return;
            }
            BaseMapDecorator baseMapDecorator = BaseMapDecorator.this;
            baseMapDecorator.mExpandInScene = baseMapDecorator.mMainContext.getCurrentScene();
            if (L.ENABLE) {
                L.Tag tag2 = BaseMapDecorator.this.mTag;
                L.d(tag2, "onFocus mExpandInScene = " + BaseMapDecorator.this.mExpandInScene);
            }
            BaseMapDecorator.this.mOverlayControlProxy.setOverlayItemFocusStatus(BaseMapDecorator.this.mPresenter.getCurrentExpandedBizPoint(), true);
            if (z) {
                BaseMapDecorator.this.mDecoratorStatusListener.onDecoratorLoading(BaseMapDecorator.this, true);
            } else {
                BaseMapDecorator.this.mDecoratorStatusListener.onDecoratorExpand(BaseMapDecorator.this);
            }
        }
    };
    private boolean mIsAoiRefreshed = false;
    private final IXpLayerClickObserver mClickObserver = new AnonymousClass2();

    /* loaded from: classes.dex */
    public interface IMapDecoratorRouteUpdateListener {
        void onDestinationUpdate(DecoratorType decoratorType, Bundle bundle);

        void onRouteUpdate(DecoratorType decoratorType, Bundle bundle);
    }

    /* loaded from: classes.dex */
    public interface IMapDecoratorStatusListener {
        void onDecoratorCollapse(BaseMapDecorator baseMapDecorator);

        void onDecoratorExpand(BaseMapDecorator baseMapDecorator);

        void onDecoratorLoading(BaseMapDecorator baseMapDecorator, boolean z);

        void onDecoratorRemoved(BaseMapDecorator baseMapDecorator);

        void onDecoratorUpdated(BaseMapDecorator baseMapDecorator, XPPoiInfo xPPoiInfo);
    }

    public abstract int getOverlayType();

    public boolean isGlobalDecorator() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.xiaopeng.montecarlo.mapoverlay.base.BaseMapDecorator$2  reason: invalid class name */
    /* loaded from: classes.dex */
    public class AnonymousClass2 implements IXpLayerClickObserver {
        AnonymousClass2() {
        }

        @Override // com.autonavi.gbl.map.layer.observer.ILayerClickObserver
        public void onNotifyClick(BaseLayer baseLayer, LayerItem layerItem, ClickViewIdInfo clickViewIdInfo) {
            if (layerItem == null) {
                return;
            }
            if (L.ENABLE) {
                L.Tag tag = BaseMapDecorator.this.mTag;
                L.d(tag, "decorator on click :" + layerItem.getID());
            }
            final int businessType = layerItem.getBusinessType();
            final String id = layerItem.getID();
            UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.mapoverlay.base.-$$Lambda$BaseMapDecorator$2$DqjrUxJLWDOmAtT8TeEsBwZn-5w
                @Override // java.lang.Runnable
                public final void run() {
                    BaseMapDecorator.AnonymousClass2.this.lambda$onNotifyClick$0$BaseMapDecorator$2(businessType, id);
                }
            });
        }

        public /* synthetic */ void lambda$onNotifyClick$0$BaseMapDecorator$2(int i, String str) {
            if (BaseMapDecorator.this.mPresenter != null) {
                if (L.ENABLE) {
                    L.Tag tag = BaseMapDecorator.this.mTag;
                    L.d(tag, "onNotifyClick businessType = " + i + ", getOverlayType()= " + BaseMapDecorator.this.getOverlayType());
                }
                if (i != BaseMapDecorator.this.getOverlayType()) {
                    return;
                }
                XPPointBaseData xPPointBaseData = new XPPointBaseData();
                xPPointBaseData.id = str;
                BaseMapDecorator.this.onClick(xPPointBaseData);
            }
        }
    }

    public BaseMapDecorator(@NonNull DecoratorType decoratorType, @NonNull MainContext mainContext, IMapDecoratorStatusListener iMapDecoratorStatusListener) {
        if (L.ENABLE) {
            L.d(this.mTag, "BaseMapDecorator create");
        }
        this.mDecoratorType = decoratorType;
        this.mDecoratorStatusListener = iMapDecoratorStatusListener;
        this.mMainContext = mainContext;
        this.mOverlayType = getOverlayType();
        this.mPresenter = createPresenter();
        this.mOverlayControlProxy = XpOverlayControlModule.get(Integer.valueOf(this.mOverlayType));
    }

    public IBaseScene getExpandInScene() {
        return this.mExpandInScene;
    }

    public boolean isAoiRefreshed() {
        return this.mIsAoiRefreshed;
    }

    public void setAoiRefreshed(boolean z) {
        this.mIsAoiRefreshed = z;
    }

    protected BaseDecoratorPresenter createPresenter() {
        return new BaseDecoratorPresenter(this.mDecoratorCallback);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onDecoratorRemove() {
        if (L.ENABLE) {
            L.Tag tag = this.mTag;
            L.d(tag, "onDecoratorRemove " + this.mDecoratorType);
        }
    }

    public int getSearchMode() {
        return this.mSearchMode;
    }

    public void setSearchMode(int i) {
        this.mSearchMode = i;
    }

    public boolean isHideByChange() {
        if (L.ENABLE) {
            L.Tag tag = this.mTag;
            L.d(tag, "isHideByChange = " + this.mIsHideByChange);
        }
        return this.mIsHideByChange;
    }

    public void setHideByChange(boolean z) {
        this.mIsHideByChange = z;
    }

    public boolean isShowing() {
        if (L.ENABLE) {
            L.Tag tag = this.mTag;
            StringBuilder sb = new StringBuilder();
            sb.append("isShowing = ");
            sb.append(this.mStatus == 2);
            L.d(tag, sb.toString());
        }
        return this.mStatus == 2;
    }

    public int getCardType() {
        XPPoiInfo currentExpandedPoint = this.mPresenter.getCurrentExpandedPoint();
        if (currentExpandedPoint != null) {
            FavoriteAddress home = FavoriteDataManager.getInstance().getHome();
            if (home != null && home.getXPPoiInfo().getPoiId().equals(currentExpandedPoint.getPoiId())) {
                return 2;
            }
            FavoriteAddress company = FavoriteDataManager.getInstance().getCompany();
            if (company != null && company.getXPPoiInfo().getPoiId().equals(currentExpandedPoint.getPoiId())) {
                return 3;
            }
            if (XPPoiCategory.isCharge(currentExpandedPoint.getCategory()) && !XPPoiCategory.isBLCharge(currentExpandedPoint.getCategory())) {
                return 1;
            }
            if (FavoriteDataManager.getInstance().isExist(new FavoriteAddress(currentExpandedPoint)) >= 0) {
                return 4;
            }
        }
        int i = AnonymousClass3.$SwitchMap$com$xiaopeng$montecarlo$mapoverlay$DecoratorType[this.mDecoratorType.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    return i != 4 ? 0 : 1;
                }
                return 4;
            }
            return 0;
        }
        return 5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.xiaopeng.montecarlo.mapoverlay.base.BaseMapDecorator$3  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$com$xiaopeng$montecarlo$mapoverlay$DecoratorType = new int[DecoratorType.values().length];

        static {
            try {
                $SwitchMap$com$xiaopeng$montecarlo$mapoverlay$DecoratorType[DecoratorType.RGC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$xiaopeng$montecarlo$mapoverlay$DecoratorType[DecoratorType.POI_DETAIL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$xiaopeng$montecarlo$mapoverlay$DecoratorType[DecoratorType.FAVORITE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$xiaopeng$montecarlo$mapoverlay$DecoratorType[DecoratorType.RECOMMEND_CHARGE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$xiaopeng$montecarlo$mapoverlay$DecoratorType[DecoratorType.END_POINT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$xiaopeng$montecarlo$mapoverlay$DecoratorType[DecoratorType.WAY_POINT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$xiaopeng$montecarlo$mapoverlay$DecoratorType[DecoratorType.START_POINT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$xiaopeng$montecarlo$mapoverlay$DecoratorType[DecoratorType.SEARCH.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$xiaopeng$montecarlo$mapoverlay$DecoratorType[DecoratorType.CHARGE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$xiaopeng$montecarlo$mapoverlay$DecoratorType[DecoratorType.VPA.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    public final void resume(IBaseScene iBaseScene) {
        XPPointBaseData currentExpandedBizPoint;
        if (L.ENABLE) {
            L.Tag tag = this.mTag;
            L.d(tag, "resume " + this.mDecoratorType + ", scene = " + iBaseScene);
        }
        if (!isGlobalDecorator()) {
            this.mPresenter.refresh();
        } else if (isFocus()) {
            if (L.ENABLE) {
                L.Tag tag2 = this.mTag;
                L.d(tag2, "resume mExpandInScene = " + this.mExpandInScene);
            }
            if (this.mExpandInScene != iBaseScene || (currentExpandedBizPoint = this.mPresenter.getCurrentExpandedBizPoint()) == null) {
                return;
            }
            this.mOverlayControlProxy.setOverlayItemFocusStatus(currentExpandedBizPoint, true);
            IMapDecoratorStatusListener iMapDecoratorStatusListener = this.mDecoratorStatusListener;
            if (iMapDecoratorStatusListener != null) {
                iMapDecoratorStatusListener.onDecoratorUpdated(this, this.mPresenter.getCurrentExpandedPoint());
            }
        }
    }

    public final void pause(IBaseScene iBaseScene) {
        XPPointBaseData currentExpandedBizPoint;
        if (L.ENABLE) {
            L.Tag tag = this.mTag;
            L.d(tag, "pause " + this.mDecoratorType + ", scene = " + iBaseScene);
        }
        if (!isGlobalDecorator()) {
            this.mOverlayControlProxy.clearOverlay();
            clearAOIPolygon();
        } else if (isFocus()) {
            if (L.ENABLE) {
                L.Tag tag2 = this.mTag;
                L.d(tag2, "pause mExpandInScene = " + this.mExpandInScene);
            }
            if (this.mExpandInScene != iBaseScene || (currentExpandedBizPoint = this.mPresenter.getCurrentExpandedBizPoint()) == null) {
                return;
            }
            this.mOverlayControlProxy.setOverlayItemFocusStatus(currentExpandedBizPoint, false);
            clearAOIPolygon();
        }
    }

    public final void update(Bundle bundle) {
        if (L.ENABLE) {
            L.Tag tag = this.mTag;
            L.d(tag, "update " + this.mDecoratorType);
        }
        BaseDecoratorPresenter baseDecoratorPresenter = this.mPresenter;
        if (baseDecoratorPresenter == null || bundle == null) {
            return;
        }
        baseDecoratorPresenter.update(bundle);
    }

    public final void show() {
        if (L.ENABLE) {
            L.Tag tag = this.mTag;
            L.d(tag, "show " + this.mDecoratorType);
        }
        if (this.mStatus == 2) {
            if (L.ENABLE) {
                L.d(this.mTag, "The status is already show.");
                return;
            }
            return;
        }
        this.mStatus = 2;
        this.mOverlayControlProxy.removeOverlayObserver(this.mOverlayType, this.mClickObserver);
        this.mOverlayControlProxy.addOverlayObserver(this.mOverlayType, this.mClickObserver);
        this.mOverlayControlProxy.setOverlayVisible(true);
    }

    public final void hide() {
        if (L.ENABLE) {
            L.Tag tag = this.mTag;
            L.d(tag, "hide " + this.mDecoratorType);
        }
        if (this.mStatus == 1) {
            if (L.ENABLE) {
                L.d(this.mTag, "The status is already hide.");
                return;
            }
            return;
        }
        this.mStatus = 1;
        this.mOverlayControlProxy.removeOverlayObserver(this.mOverlayType, this.mClickObserver);
        this.mOverlayControlProxy.setOverlayVisible(false);
    }

    public final void remove() {
        if (L.ENABLE) {
            L.Tag tag = this.mTag;
            L.d(tag, "remove " + this.mDecoratorType);
        }
        if (isFocus()) {
            clearFocus();
        }
        if (this.mStatus == 2) {
            if (L.ENABLE) {
                L.Tag tag2 = this.mTag;
                L.d(tag2, "remove -->removeOverlayObserver " + this.mDecoratorType);
            }
            this.mOverlayControlProxy.removeOverlayObserver(this.mOverlayType, this.mClickObserver);
        }
        BaseDecoratorPresenter baseDecoratorPresenter = this.mPresenter;
        if (baseDecoratorPresenter != null) {
            baseDecoratorPresenter.remove();
        }
        if (this.mStatus > 0) {
            this.mDecoratorStatusListener.onDecoratorRemoved(this);
        }
        this.mStatus = 0;
        this.mOverlayControlProxy.clearOverlay();
        onDecoratorRemove();
    }

    public final boolean focus(XPPoiInfo xPPoiInfo) {
        if (L.ENABLE) {
            L.Tag tag = this.mTag;
            L.d(tag, "focus " + this.mDecoratorType + ",xpPoiInfo: " + xPPoiInfo + ", mPresenter = " + this.mPresenter);
        }
        BaseDecoratorPresenter baseDecoratorPresenter = this.mPresenter;
        if (baseDecoratorPresenter != null) {
            return baseDecoratorPresenter.focus(xPPoiInfo);
        }
        return false;
    }

    public final void clearFocus() {
        if (L.ENABLE) {
            L.Tag tag = this.mTag;
            L.d(tag, "clearFocus " + this.mDecoratorType);
        }
        BaseDecoratorPresenter baseDecoratorPresenter = this.mPresenter;
        if (baseDecoratorPresenter != null) {
            baseDecoratorPresenter.clearFocus();
        }
    }

    public final boolean isFocus() {
        if (this.mPresenter != null) {
            if (L.ENABLE) {
                L.Tag tag = this.mTag;
                L.d(tag, "isFocus " + this.mPresenter.isExpanded());
            }
            return this.mPresenter.isExpanded();
        }
        return false;
    }

    public void onClick(XPPointBaseData xPPointBaseData) {
        if (L.ENABLE) {
            L.Tag tag = this.mTag;
            L.d(tag, "onClick " + this.mDecoratorType);
        }
        if (getMainContext() == null || getMainContext().isMapPoiLocked()) {
            if (L.ENABLE) {
                L.d(this.mTag, "onClick isMapPoiLocked return");
            }
            this.mOverlayControlProxy.setOverlayItemFocusStatus(xPPointBaseData, false);
            clearAOIPolygon();
            return;
        }
        BaseDecoratorPresenter baseDecoratorPresenter = this.mPresenter;
        if (baseDecoratorPresenter != null) {
            baseDecoratorPresenter.onClick(xPPointBaseData);
        }
        sendClickEvent(xPPointBaseData);
    }

    public final XPPoiInfo getFavoritePoi() {
        BaseDecoratorPresenter baseDecoratorPresenter = this.mPresenter;
        if (baseDecoratorPresenter != null) {
            return baseDecoratorPresenter.getFavoritePoi();
        }
        return null;
    }

    public final DecoratorType getDecoratorType() {
        return this.mDecoratorType;
    }

    public final XPPoiInfo getCurrentExpandedPoi() {
        return this.mPresenter.getCurrentExpandedPoint();
    }

    public final MainContext getMainContext() {
        return this.mMainContext;
    }

    public final int getSearchDest() {
        return this.mSearchDest;
    }

    public final void setSearchDest(int i) {
        this.mSearchDest = i;
    }

    public final MapViewWrapper getMapView() {
        return this.mMainContext.getMapView();
    }

    private void clearAOIPolygon() {
        this.mMainContext.getMapView().getBizControlManager().clearAOIPolygon();
        this.mIsAoiRefreshed = false;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0015  */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void sendClickEvent(com.xiaopeng.montecarlo.navcore.bean.map.XPPointBaseData r11) {
        /*
            r10 = this;
            int r0 = r10.getOverlayType()
            r1 = 8005(0x1f45, float:1.1217E-41)
            r2 = -1
            if (r0 == r1) goto L11
            r1 = 20001(0x4e21, float:2.8027E-41)
            if (r0 == r1) goto Lf
            r5 = r2
            goto L13
        Lf:
            r0 = 1
            goto L12
        L11:
            r0 = 3
        L12:
            r5 = r0
        L13:
            if (r5 == r2) goto L34
            com.autonavi.gbl.common.model.Coord3DDouble r0 = r11.position
            double r6 = r0.lon
            com.autonavi.gbl.common.model.Coord3DDouble r11 = r11.position
            double r8 = r11.lat
            r0 = 0
            boolean r11 = com.xiaopeng.montecarlo.root.util.RootUtil.compareDouble(r6, r0)
            if (r11 != 0) goto L34
            boolean r11 = com.xiaopeng.montecarlo.root.util.RootUtil.compareDouble(r8, r0)
            if (r11 != 0) goto L34
            com.xiaopeng.montecarlo.base.MainContext r3 = r10.mMainContext
            int r4 = r10.getOverlayType()
            com.xiaopeng.montecarlo.stat.MapOpStatUtil.sendStatDataWhenMapClick(r3, r4, r5, r6, r8)
        L34:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaopeng.montecarlo.mapoverlay.base.BaseMapDecorator.sendClickEvent(com.xiaopeng.montecarlo.navcore.bean.map.XPPointBaseData):void");
    }

    public int getCurrentExpandedIndex() {
        BaseDecoratorPresenter baseDecoratorPresenter = this.mPresenter;
        if (baseDecoratorPresenter != null) {
            return baseDecoratorPresenter.getCurrentExpandedIndex();
        }
        return -1;
    }
}
