package com.xiaopeng.montecarlo.scenes.navi.guidescene;

import android.text.TextUtils;
import com.xiaopeng.montecarlo.navcore.bean.direction.XPViaPoint;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiCategory;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import com.xiaopeng.montecarlo.navcore.httpclient.HttpClientManager;
import com.xiaopeng.montecarlo.navcore.httpclient.interfaces.IChargeGatewayService;
import com.xiaopeng.montecarlo.navcore.httpclient.requests.NavigateStationRemindRequest;
import com.xiaopeng.montecarlo.navcore.xptbt.TBTManager;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.RouteDataModel;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.RouteResult;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPNaviInfo;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import com.xiaopeng.montecarlo.root.util.GsonUtil;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.RootUtil;
import com.xiaopeng.montecarlo.root.util.WorkThreadUtil;
import com.xiaopeng.speech.jarvisproto.DMWait;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class PostChargeStationStatus {
    private IChargeGatewayService mChargeGatewayService = (IChargeGatewayService) HttpClientManager.getInstance().getService(IChargeGatewayService.class);
    private List<XPViaPoint> mCurrentVias;
    private XPPoiInfo mEndInfo;
    private String mLastStationId;
    private static final PostChargeStationStatus sOurInstance = new PostChargeStationStatus();
    private static final L.Tag TAG = new L.Tag("PostCS");

    private PostChargeStationStatus() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static PostChargeStationStatus getInstance() {
        return sOurInstance;
    }

    private void postNaviStatusEvent(final String str, final String str2, final boolean z) {
        L.Tag tag = TAG;
        L.i(tag, "postNaviStatusEvent stationId = [" + str + "], remainTime = [" + str2 + "], isStart = [" + z + "]");
        if (z) {
            this.mLastStationId = str;
        }
        WorkThreadUtil.getInstance().executeCachedTask(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.navi.guidescene.-$$Lambda$PostChargeStationStatus$-BsB_1Ci23qxOAFsia_ufQ-TrLs
            @Override // java.lang.Runnable
            public final void run() {
                PostChargeStationStatus.this.lambda$postNaviStatusEvent$0$PostChargeStationStatus(str, z, str2);
            }
        });
    }

    public /* synthetic */ void lambda$postNaviStatusEvent$0$PostChargeStationStatus(String str, boolean z, String str2) {
        String str3;
        NavigateStationRemindRequest vin = new NavigateStationRemindRequest().setStationId(str).setVin(RootUtil.getVin());
        if (z) {
            vin.setRemainTime(str2);
            str3 = "start";
        } else {
            str3 = DMWait.STATUS_END;
        }
        vin.setOperType(str3);
        L.Tag tag = TAG;
        L.i(tag, "postNaviStatus2ChargePlat <<< request=" + GsonUtil.toJson(vin));
        if (this.mChargeGatewayService.navigateStationRemind(vin).getCode() == 200) {
            L.i(TAG, "postNaviStatus2ChargePlat onSuccess");
        } else {
            L.i(TAG, "postNaviStatus2ChargePlat onFailure");
        }
    }

    public void postStopNaviStatus() {
        L.Tag tag = TAG;
        L.i(tag, "postStopNaviStatus stopStationId=" + this.mLastStationId);
        if (TextUtils.isEmpty(this.mLastStationId)) {
            return;
        }
        postNaviStatusEvent(this.mLastStationId, "", false);
        this.mEndInfo = null;
        this.mLastStationId = "";
        List<XPViaPoint> list = this.mCurrentVias;
        if (list != null) {
            list.clear();
            this.mCurrentVias = null;
        }
    }

    public void postStartNaviStatus() {
        RouteResult.RouteInfo routeInfo;
        XPPoiInfo poiPoint;
        L.i(TAG, "postStartNaviStatus");
        int currentNaviPathIndex = TBTManager.getInstance().getCurrentNaviPathIndex();
        List<XPViaPoint> unPassedViasPoiInfo = TBTManager.getInstance().getUnPassedViasPoiInfo(TBTManager.getInstance().getCurrentNaviId());
        if (CollectionUtils.isNotEmpty(unPassedViasPoiInfo)) {
            int size = unPassedViasPoiInfo.size();
            for (int i = 0; i < size; i++) {
                XPViaPoint xPViaPoint = unPassedViasPoiInfo.get(i);
                if (xPViaPoint != null && (poiPoint = xPViaPoint.getPoiPoint()) != null && XPPoiCategory.isCharge(poiPoint.getCategory())) {
                    postNaviStatusEvent(poiPoint.getPoiId(), "", true);
                    return;
                }
            }
        }
        long j = 0;
        long currentNaviId = TBTManager.getInstance().getCurrentNaviId();
        XPNaviInfo naviInfo = TBTManager.getInstance().getNaviInfo();
        if (naviInfo != null) {
            j = (long) naviInfo.mRouteRemainTime;
        } else {
            RouteDataModel routeData = TBTManager.getInstance().getRouteData(currentNaviId);
            if (routeData != null && routeData.mRouteResult != null && (routeInfo = routeData.mRouteResult.getRouteInfo(currentNaviPathIndex)) != null) {
                j = routeInfo.mTravelTime;
            }
        }
        XPPoiInfo endInfo = TBTManager.getInstance().getEndInfo(currentNaviId);
        if (endInfo == null || !XPPoiCategory.isCharge(endInfo.getCategory())) {
            return;
        }
        this.mEndInfo = endInfo;
        List<XPViaPoint> list = this.mCurrentVias;
        if (list != null) {
            list.clear();
        } else {
            this.mCurrentVias = new ArrayList();
        }
        postNaviStatusEvent(endInfo.getPoiId(), String.valueOf(j), true);
    }

    public void postUpdateRouteStatus() {
        L.i(TAG, "postUpdateRouteStatus");
        if (TBTManager.getInstance().isNaviStop()) {
            return;
        }
        long currentNaviId = TBTManager.getInstance().getCurrentNaviId();
        checkoutDelVia(currentNaviId);
        if (this.mCurrentVias.size() == 0) {
            L.i(TAG, "postUpdateRouteStatus  not del via ,restart end station");
            XPPoiInfo endInfo = TBTManager.getInstance().getEndInfo(currentNaviId);
            if (endInfo != null && this.mEndInfo != null && endInfo.getPoiId() != this.mEndInfo.getPoiId()) {
                cancelEndPost();
            }
            postStartNaviStatus();
            return;
        }
        List<XPViaPoint> passedViasPoiInfo = TBTManager.getInstance().getPassedViasPoiInfo(currentNaviId);
        List<XPViaPoint> viaInfos = TBTManager.getInstance().getViaInfos(currentNaviId);
        if (CollectionUtils.isNotEmpty(passedViasPoiInfo)) {
            for (int i = 0; i < passedViasPoiInfo.size(); i++) {
                XPViaPoint xPViaPoint = passedViasPoiInfo.get(i);
                if (xPViaPoint != null && xPViaPoint.getPoiPoint() != null) {
                    L.i(TAG, "passed via =" + GsonUtil.toJson(xPViaPoint.getPoiPoint().getName()));
                    if (XPPoiCategory.isCharge(xPViaPoint.getPoiPoint().getCategory())) {
                        XPPoiInfo poiPoint = xPViaPoint.getPoiPoint();
                        L.i(TAG, "postUpdateRouteStatus end passed via");
                        postNaviStatusEvent(poiPoint.getPoiId(), "", false);
                    }
                }
            }
        }
        if (viaInfos != null && passedViasPoiInfo != null && viaInfos.size() == passedViasPoiInfo.size()) {
            restartEndPost();
            return;
        }
        List<XPViaPoint> unPassedViasPoiInfo = TBTManager.getInstance().getUnPassedViasPoiInfo(currentNaviId);
        if (CollectionUtils.isNotEmpty(unPassedViasPoiInfo)) {
            boolean z = false;
            for (int i2 = 0; i2 < unPassedViasPoiInfo.size(); i2++) {
                XPViaPoint xPViaPoint2 = unPassedViasPoiInfo.get(i2);
                if (xPViaPoint2 != null && xPViaPoint2.getPoiPoint() != null) {
                    L.i(TAG, "unpass via=" + GsonUtil.toJson(xPViaPoint2.getPoiPoint().getName()));
                    if (XPPoiCategory.isCharge(xPViaPoint2.getPoiPoint().getCategory())) {
                        XPPoiInfo poiPoint2 = xPViaPoint2.getPoiPoint();
                        if (!z) {
                            L.i(TAG, "postUpdateRouteStatus start unpassed via");
                            postNaviStatusEvent(poiPoint2.getPoiId(), "", true);
                            cancelEndPost();
                            z = true;
                        } else {
                            postNaviStatusEvent(poiPoint2.getPoiId(), "", false);
                        }
                    }
                }
            }
        }
    }

    private void cancelEndPost() {
        XPPoiInfo xPPoiInfo = this.mEndInfo;
        if (xPPoiInfo == null || !XPPoiCategory.isCharge(xPPoiInfo.getCategory())) {
            return;
        }
        L.i(TAG, "cancelEndPost  end is charge station");
        postNaviStatusEvent(this.mEndInfo.getPoiId(), "", false);
    }

    private void restartEndPost() {
        if (this.mEndInfo == null) {
            XPPoiInfo endInfo = TBTManager.getInstance().getEndInfo(TBTManager.getInstance().getCurrentNaviId());
            if (endInfo != null && XPPoiCategory.isCharge(endInfo.getCategory())) {
                this.mEndInfo = endInfo;
            }
        }
        XPPoiInfo xPPoiInfo = this.mEndInfo;
        if (xPPoiInfo == null || !XPPoiCategory.isCharge(xPPoiInfo.getCategory())) {
            return;
        }
        L.i(TAG, "restartEndPost  end is charge station");
        XPNaviInfo naviInfo = TBTManager.getInstance().getNaviInfo();
        postNaviStatusEvent(this.mEndInfo.getPoiId(), String.valueOf(naviInfo != null ? naviInfo.mRouteRemainTime : 0.0d), true);
    }

    private boolean checkoutDelVia(long j) {
        List<XPViaPoint> viaInfos = TBTManager.getInstance().getViaInfos(j);
        List<XPViaPoint> list = this.mCurrentVias;
        boolean z = false;
        if (list != null && viaInfos != null && list.size() > viaInfos.size()) {
            this.mCurrentVias.removeAll(viaInfos);
            if (this.mCurrentVias.size() > 0) {
                boolean z2 = false;
                for (int i = 0; i < this.mCurrentVias.size(); i++) {
                    XPViaPoint xPViaPoint = this.mCurrentVias.get(i);
                    if (xPViaPoint != null && xPViaPoint.getPoiPoint() != null && XPPoiCategory.isCharge(xPViaPoint.getPoiPoint().getCategory())) {
                        postNaviStatusEvent(xPViaPoint.getPoiPoint().getPoiId(), "", false);
                        L.i(TAG, "checkoutDelVia " + xPViaPoint.getPoiPoint().getName());
                        z2 = true;
                    }
                }
                z = z2;
            }
        }
        List<XPViaPoint> list2 = this.mCurrentVias;
        if (list2 == null) {
            this.mCurrentVias = new ArrayList();
        } else {
            list2.clear();
        }
        if (CollectionUtils.isNotEmpty(viaInfos)) {
            this.mCurrentVias.addAll(viaInfos);
        }
        if (z) {
            L.i(TAG, "checkout success del via");
        } else {
            L.i(TAG, "not find del via");
        }
        return z;
    }
}
