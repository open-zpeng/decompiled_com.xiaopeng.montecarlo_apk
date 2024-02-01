package com.autonavi.gbl.scene.model;

import android.util.Log;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.common.path.model.POIInfo;
import com.autonavi.gbl.common.path.model.PointType;
import com.autonavi.gbl.layer.model.BizUserFavoritePoint;
import com.autonavi.gbl.route.model.RouteRestorationOption;
import com.autonavi.gbl.route.model.impl.IRouteRestorationOptionImpl;
import com.autonavi.gbl.scene.model.impl.SceneDataToolImpl;
import com.autonavi.gbl.search.model.SearchPoiBase;
import com.autonavi.gbl.user.behavior.model.FavoriteBaseItem;
import com.autonavi.gbl.user.behavior.model.FavoriteItem;
import com.autonavi.gbl.user.msgpush.model.AimPoiPushMsg;
import com.autonavi.gbl.user.msgpush.model.AimRoutePushMsg;
import com.autonavi.gbl.user.usertrack.model.HistoryRouteItem;
import com.autonavi.gbl.user.usertrack.model.HistoryRoutePoiItem;
import com.autonavi.gbl.user.usertrack.model.SearchHistoryItem;
import java.lang.reflect.Method;
@IntfAuto(target = SceneDataToolImpl.class, type = BuildType.JCTRL)
/* loaded from: classes2.dex */
public class SceneDataTool {
    private static String PACKAGE = ReflexTool.PN(SceneDataTool.class);
    private static TypeHelper gTypeHelper = new TypeHelper(PACKAGE);
    private SceneDataToolImpl mControl;
    private boolean mHasDestroy;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected void clean() {
    }

    protected SceneDataTool(long j, boolean z) {
        this(new SceneDataToolImpl(j, z));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(SceneDataTool.class, this, this.mControl);
        }
    }

    public SceneDataTool() {
        this(new SceneDataToolImpl());
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(SceneDataTool.class, this, this.mControl);
        }
    }

    public SceneDataTool(SceneDataToolImpl sceneDataToolImpl) {
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mHasDestroy = false;
        this.mControl = null;
        $constructor(sceneDataToolImpl);
    }

    private void $constructor(SceneDataToolImpl sceneDataToolImpl) {
        if (sceneDataToolImpl != null) {
            this.mControl = sceneDataToolImpl;
            this.mTargetId = String.format("SceneDataTool_%s_%d", String.valueOf(SceneDataToolImpl.getCPtr(this.mControl)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    protected SceneDataToolImpl getControl() {
        return this.mControl;
    }

    public static RouteRestorationOption routePushMsgToRouteOption(AimRoutePushMsg aimRoutePushMsg) {
        TypeHelper typeHelper;
        try {
            Method method = SceneDataTool.class.getMethod("routePushMsgToRouteOption", AimRoutePushMsg.class);
            IRouteRestorationOptionImpl routePushMsgToRouteOption = SceneDataToolImpl.routePushMsgToRouteOption(aimRoutePushMsg);
            if (routePushMsgToRouteOption == null || (typeHelper = gTypeHelper) == null) {
                return null;
            }
            return (RouteRestorationOption) typeHelper.transfer(method, -1, (Object) routePushMsgToRouteOption, true);
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public static POIInfo poiPushMsgToPoiInfo(AimPoiPushMsg aimPoiPushMsg) {
        return SceneDataToolImpl.poiPushMsgToPoiInfo(aimPoiPushMsg);
    }

    public static POIInfo searchPoiBaseToPoiInfo(SearchPoiBase searchPoiBase, @PointType.PointType1 int i) {
        return SceneDataToolImpl.searchPoiBaseToPoiInfo(searchPoiBase, i);
    }

    public static BizUserFavoritePoint favoriteItemToBizUserFavoritePoint(FavoriteItem favoriteItem) {
        return SceneDataToolImpl.favoriteItemToBizUserFavoritePoint(favoriteItem);
    }

    public static POIInfo historyRouteItemToPoiInfo(HistoryRouteItem historyRouteItem) {
        return SceneDataToolImpl.historyRouteItemToPoiInfo(historyRouteItem);
    }

    public static HistoryRoutePoiItem poiInfoToHistoryRoutePoiItem(POIInfo pOIInfo) {
        return SceneDataToolImpl.poiInfoToHistoryRoutePoiItem(pOIInfo);
    }

    public static POIInfo searchHistoryItemToPoiInfo(SearchHistoryItem searchHistoryItem) {
        return SceneDataToolImpl.searchHistoryItemToPoiInfo(searchHistoryItem);
    }

    public static SearchHistoryItem poiInfoToSearchHistoryItem(POIInfo pOIInfo) {
        return SceneDataToolImpl.poiInfoToSearchHistoryItem(pOIInfo);
    }

    public static POIInfo favoriteBaseItemToPoiInfo(FavoriteBaseItem favoriteBaseItem) {
        return SceneDataToolImpl.favoriteBaseItemToPoiInfo(favoriteBaseItem);
    }

    public static FavoriteBaseItem poiInfoToFavoriteBaseItem(POIInfo pOIInfo) {
        return SceneDataToolImpl.poiInfoToFavoriteBaseItem(pOIInfo);
    }

    public static FavoriteItem poiInfoToFavoriteItem(POIInfo pOIInfo) {
        return SceneDataToolImpl.poiInfoToFavoriteItem(pOIInfo);
    }

    public static POIInfo favoriteItemToPoiInfo(FavoriteItem favoriteItem) {
        return SceneDataToolImpl.favoriteItemToPoiInfo(favoriteItem);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mTypeHelper = null;
        }
    }

    public void onDestroy() {
        this.mHasDestroy = true;
        clean();
    }

    public synchronized void delete() {
        if (!this.mHasDestroy) {
            onDestroy();
        }
        if (this.mTypeHelper != null) {
            TypeHelper typeHelper = this.mTypeHelper;
            TypeHelper.unbindAllTarget(PACKAGE, this);
        }
        if (this.mControl != null) {
            ReflexTool.invokeDeclMethodSafe(this.mControl, RequestParameters.SUBRESOURCE_DELETE, null, null);
            this.mControl = null;
        }
        unbind();
    }
}
