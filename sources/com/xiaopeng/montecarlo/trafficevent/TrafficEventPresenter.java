package com.xiaopeng.montecarlo.trafficevent;

import android.graphics.Point;
import android.text.TextUtils;
import com.autonavi.common.tool.FDManager;
import com.autonavi.gbl.aosclient.model.GTraEventDetail;
import com.autonavi.gbl.common.model.Coord2DDouble;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.base.MainContext;
import com.xiaopeng.montecarlo.bean.traffic.TrafficEventData;
import com.xiaopeng.montecarlo.navcore.aos.TrafficEventServiceWrapper;
import com.xiaopeng.montecarlo.navcore.bean.search.XPCoordinate2DDouble;
import com.xiaopeng.montecarlo.navcore.location.LocationUtils;
import com.xiaopeng.montecarlo.navcore.util.NavCoreUtil;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.RootUtil;
import com.xiaopeng.montecarlo.root.util.TimeFormatUtil;
import com.xiaopeng.montecarlo.root.util.UiHandlerUtil;
import com.xiaopeng.montecarlo.trafficevent.ITrafficEventContract;
import com.xiaopeng.montecarlo.util.NaviUtil;
import com.xiaopeng.montecarlo.views.dialog.PicPopDialog;
import java.util.ArrayList;
import java.util.List;
import lombok.NonNull;
/* loaded from: classes3.dex */
public class TrafficEventPresenter implements ITrafficEventContract.ITrafficEventPresenter, TrafficEventServiceWrapper.ITrafficEventRequestCallback, ITrafficEventContract.ITrafficEventPopView.ICallBack {
    private static final L.Tag TAG = new L.Tag("TrafficEventPresenter");
    private MainContext mMainContext;
    private List<String> mPicUrls;
    private TrafficEventPopParam mRequestParam;
    private Coord2DDouble mTrafficEventLocation = new Coord2DDouble();
    private ITrafficEventContract.ITrafficEventPopView mTrafficEventPopView;
    private volatile long mTrafficReqHandle;

    public TrafficEventPresenter(ITrafficEventContract.ITrafficEventPopView iTrafficEventPopView, MainContext mainContext) {
        this.mTrafficEventPopView = iTrafficEventPopView;
        this.mMainContext = mainContext;
        this.mTrafficEventPopView.setPresenter(this);
    }

    @Override // com.xiaopeng.montecarlo.trafficevent.ITrafficEventContract.ITrafficEventPresenter
    public void showITrafficEventPopView(@NonNull TrafficEventPopParam trafficEventPopParam) {
        if (trafficEventPopParam == null) {
            throw new NullPointerException("param is marked non-null but is null");
        }
        this.mRequestParam = trafficEventPopParam;
        L.Tag tag = TAG;
        L.i(tag, "showITrafficEventPopView: " + this.mRequestParam.toString());
        if (RootUtil.compareDouble(this.mRequestParam.mLon, 0.0d) || RootUtil.compareDouble(this.mRequestParam.mLat, 0.0d)) {
            if (RootUtil.compareDouble(this.mRequestParam.mLoc.lon, 0.0d) || RootUtil.compareDouble(this.mRequestParam.mLoc.lat, 0.0d)) {
                if (L.ENABLE) {
                    L.d(TAG, "invalid traffic point");
                    return;
                }
                return;
            }
            this.mTrafficEventLocation.lon = this.mRequestParam.mLoc.lon;
            this.mTrafficEventLocation.lat = this.mRequestParam.mLoc.lat;
        } else {
            this.mTrafficEventLocation.lon = this.mRequestParam.mLon;
            this.mTrafficEventLocation.lat = this.mRequestParam.mLat;
        }
        this.mMainContext.getMapView().getBizControlManager().setFollowMode(false);
        ITrafficEventContract.ITrafficEventPopView iTrafficEventPopView = this.mTrafficEventPopView;
        if (iTrafficEventPopView != null) {
            iTrafficEventPopView.show();
        }
        if (this.mRequestParam.mIsZoom && this.mMainContext.getMapView().getMapLevel() < 15) {
            UiHandlerUtil.getInstance().postDelayed(new Runnable() { // from class: com.xiaopeng.montecarlo.trafficevent.TrafficEventPresenter.1
                @Override // java.lang.Runnable
                public void run() {
                    TrafficEventPresenter.this.mMainContext.getMapView().animateZoomTo(15.0f);
                }
            }, 500L);
        }
        ITrafficEventContract.ITrafficEventPopView iTrafficEventPopView2 = this.mTrafficEventPopView;
        if (iTrafficEventPopView2 != null) {
            iTrafficEventPopView2.showLoading();
        }
        int i = this.mRequestParam.mEventType;
        if (i != 0) {
            if (i == 1) {
                TrafficEventData.Builder builder = new TrafficEventData.Builder();
                builder.setIncidentTitle(ContextUtils.getString(R.string.road_info_congestion));
                builder.setLayerTag("11021");
                builder.setIncidentSubTitle(ContextUtils.getString(R.string.traffic_distance_ahead, NaviUtil.getDistanceString(LocationUtils.getDistanceFromCurrentPos(new XPCoordinate2DDouble(this.mTrafficEventLocation)))));
                builder.setIncidentDes1(this.mRequestParam.mJamRoadName + ContextUtils.getString(R.string.nearby));
                builder.setIncidentDes2(ContextUtils.getString(R.string.avoid_traffic_out_rout_tips_content, "", this.mRequestParam.mJamLen, this.mRequestParam.mJamETA));
                TrafficEventData build = builder.build();
                if (L.ENABLE) {
                    L.Tag tag2 = TAG;
                    L.d(tag2, "Click_Avoid_Jam:" + build.toString());
                }
                ITrafficEventContract.ITrafficEventPopView iTrafficEventPopView3 = this.mTrafficEventPopView;
                if (iTrafficEventPopView3 != null) {
                    iTrafficEventPopView3.showEventData(build);
                    return;
                }
                return;
            } else if (i != 2) {
                if (i != 3) {
                    return;
                }
                showScratchSpot();
                return;
            }
        }
        startRequestTrafficEvent();
    }

    @Override // com.xiaopeng.montecarlo.trafficevent.ITrafficEventContract.ITrafficEventPopView.ICallBack
    public void onShowLargePic() {
        if (CollectionUtils.isEmpty(this.mPicUrls)) {
            return;
        }
        new PicPopDialog(ContextUtils.getActivity(), this.mPicUrls).show();
    }

    @Override // com.xiaopeng.montecarlo.trafficevent.ITrafficEventContract.ITrafficEventPresenter
    public void closeITrafficEventPopView() {
        if (this.mTrafficReqHandle > -1) {
            TrafficEventServiceWrapper.getInstance().cancel(this.mTrafficReqHandle);
            this.mTrafficReqHandle = -1L;
        }
        ITrafficEventContract.ITrafficEventPopView iTrafficEventPopView = this.mTrafficEventPopView;
        if (iTrafficEventPopView != null) {
            iTrafficEventPopView.close();
        }
        if (CollectionUtils.isNotEmpty(this.mPicUrls)) {
            this.mPicUrls = null;
        }
    }

    public boolean isTrafficEventPopViewShown() {
        ITrafficEventContract.ITrafficEventPopView iTrafficEventPopView = this.mTrafficEventPopView;
        return iTrafficEventPopView != null && iTrafficEventPopView.isVisible();
    }

    @Override // com.xiaopeng.montecarlo.trafficevent.ITrafficEventContract.ITrafficEventPresenter
    public void moveITrafficEventPopView() {
        ITrafficEventContract.ITrafficEventPopView iTrafficEventPopView = this.mTrafficEventPopView;
        if (iTrafficEventPopView == null || !iTrafficEventPopView.isVisible()) {
            return;
        }
        UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.trafficevent.TrafficEventPresenter.2
            @Override // java.lang.Runnable
            public void run() {
                if (TrafficEventPresenter.this.mTrafficEventPopView == null || !TrafficEventPresenter.this.mTrafficEventPopView.isVisible()) {
                    return;
                }
                TrafficEventPresenter.this.setTrafficPopViewLocation();
            }
        });
    }

    @Override // com.xiaopeng.montecarlo.trafficevent.ITrafficEventContract.ITrafficEventPresenter
    public Coord2DDouble getLocation() {
        return this.mTrafficEventLocation;
    }

    @Override // com.xiaopeng.montecarlo.navcore.aos.TrafficEventServiceWrapper.ITrafficEventRequestCallback
    public void onTrafficResponse(long j, GTraEventDetail gTraEventDetail) {
        L.Tag tag = TAG;
        L.i(tag, "onTrafficResponse, handle: " + j + ", current handle: " + this.mTrafficReqHandle);
        if (this.mTrafficReqHandle == j) {
            final TrafficEventData.Builder builder = new TrafficEventData.Builder();
            builder.setLayerTag(Integer.toString(gTraEventDetail.layertag));
            if (!TextUtils.isEmpty(gTraEventDetail.address)) {
                builder.setIncidentSubTitle(gTraEventDetail.address);
            } else {
                builder.setIncidentSubTitle(ContextUtils.getString(R.string.traffic_distance_ahead, NaviUtil.getDistanceString(LocationUtils.getDistanceFromCurrentPos(new XPCoordinate2DDouble(this.mTrafficEventLocation)))));
            }
            builder.setIncidentDes1(!TextUtils.isEmpty(gTraEventDetail.head) ? gTraEventDetail.head : gTraEventDetail.title);
            String str = "";
            if (!TextUtils.isEmpty(gTraEventDetail.infoenddate) || !TextUtils.isEmpty(gTraEventDetail.infostartdate) || !TextUtils.isEmpty(gTraEventDetail.infotimeseg)) {
                StringBuilder sb = new StringBuilder("");
                if (!TextUtils.isEmpty(gTraEventDetail.infostartdate)) {
                    sb.append(ContextUtils.getString(R.string.traffic_start_date, gTraEventDetail.infostartdate));
                }
                if (!TextUtils.isEmpty(gTraEventDetail.infoenddate)) {
                    sb.append(FDManager.LINE_SEPERATOR);
                    sb.append(ContextUtils.getString(R.string.traffic_end_date, gTraEventDetail.infoenddate));
                }
                if (!TextUtils.isEmpty(gTraEventDetail.infotimeseg)) {
                    sb.append(FDManager.LINE_SEPERATOR);
                    sb.append(ContextUtils.getString(R.string.traffic_time_segment, gTraEventDetail.infotimeseg));
                }
                builder.setIncidentDes2(sb.toString());
            }
            if (!TextUtils.isEmpty(gTraEventDetail.nick) || !TextUtils.isEmpty(gTraEventDetail.lastupdate)) {
                StringBuilder sb2 = new StringBuilder(gTraEventDetail.nick);
                if (!TextUtils.isEmpty(gTraEventDetail.lastupdate)) {
                    long parseLong = Long.parseLong(gTraEventDetail.lastupdate) * 1000;
                    long currentTimeMillis = (System.currentTimeMillis() - parseLong) / 1000;
                    sb2.append(" ");
                    if (currentTimeMillis / TimeFormatUtil.ONE_DAY > 0) {
                        sb2.append(ContextUtils.getString(R.string.traffic_last_update_time, TimeFormatUtil.formatTime(parseLong, TimeFormatUtil.DATE_PATTERN_FORMAT_CN)));
                    } else {
                        long j2 = currentTimeMillis / TimeFormatUtil.ONE_HOUR;
                        if (j2 > 0) {
                            sb2.append(ContextUtils.getString(R.string.traffic_last_update_time_ago, NaviUtil.getTimeString(j2 * TimeFormatUtil.ONE_HOUR)));
                        } else {
                            long j3 = currentTimeMillis / 60;
                            if (j3 > 0) {
                                sb2.append(ContextUtils.getString(R.string.traffic_last_update_time_ago, NaviUtil.getTimeString(j3 * 60)));
                            } else {
                                sb2.append(ContextUtils.getString(R.string.traffic_last_update_time_ago, NaviUtil.getTimeString(currentTimeMillis)));
                            }
                        }
                    }
                }
                builder.setIncidentDes3(sb2.toString());
                builder.setIsOfficial((gTraEventDetail.official == 0 || gTraEventDetail.official == 1) && TextUtils.equals(gTraEventDetail.nick, ContextUtils.getString(R.string.traffic_event_source_official)));
            }
            if (!TextUtils.isEmpty(gTraEventDetail.picurl)) {
                str = gTraEventDetail.picurl;
            } else if (gTraEventDetail.socol_picture != null && !TextUtils.isEmpty(gTraEventDetail.socol_picture.socol_picture)) {
                str = gTraEventDetail.socol_picture.socol_picture;
            }
            ArrayList arrayList = new ArrayList();
            if (!TextUtils.isEmpty(str)) {
                String[] split = str.split("[,;\\s]");
                for (int i = 0; i < split.length; i++) {
                    if (!TextUtils.isEmpty(split[i])) {
                        arrayList.add(split[i].trim());
                    }
                }
            }
            this.mPicUrls = arrayList;
            builder.addIconUrls(arrayList);
            UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.trafficevent.TrafficEventPresenter.3
                @Override // java.lang.Runnable
                public void run() {
                    if (TrafficEventPresenter.this.mTrafficEventPopView != null) {
                        TrafficEventPresenter.this.mTrafficEventPopView.showEventData(builder.build());
                    }
                }
            });
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.aos.TrafficEventServiceWrapper.ITrafficEventRequestCallback
    public void onTrafficRequestFailed(final long j, final int i, final int i2) {
        UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.trafficevent.TrafficEventPresenter.4
            @Override // java.lang.Runnable
            public void run() {
                L.Tag tag = TrafficEventPresenter.TAG;
                L.i(tag, "onTrafficRequestFailed, handle: " + j + ", current handle: " + TrafficEventPresenter.this.mTrafficReqHandle);
                if (TrafficEventPresenter.this.mTrafficReqHandle != j || TrafficEventPresenter.this.mTrafficEventPopView == null) {
                    return;
                }
                if (i != 11 || i2 != 7) {
                    TrafficEventPresenter.this.mTrafficEventPopView.showFailed();
                    return;
                }
                TrafficEventPresenter.this.closeITrafficEventPopView();
                TrafficEventPresenter.this.mMainContext.showPrompt(ContextUtils.getContext().getResources().getString(R.string.traffic_event_expire_msg));
            }
        });
    }

    @Override // com.xiaopeng.montecarlo.trafficevent.ITrafficEventContract.ITrafficEventPopView.ICallBack
    public void onReload() {
        L.Tag tag = TAG;
        L.i(tag, "onReload: " + this.mTrafficReqHandle);
        startRequestTrafficEvent();
    }

    @Override // com.xiaopeng.montecarlo.trafficevent.ITrafficEventContract.ITrafficEventPopView.ICallBack
    public void onClose() {
        L.Tag tag = TAG;
        L.i(tag, "onClose: " + this.mTrafficReqHandle);
        if (this.mTrafficReqHandle > -1) {
            TrafficEventServiceWrapper.getInstance().cancel(this.mTrafficReqHandle);
            this.mTrafficReqHandle = -1L;
        }
    }

    public void setTrafficPopViewLocation() {
        if (this.mTrafficEventLocation == null) {
            return;
        }
        Point lonLatToPixel = this.mMainContext.getMapView().lonLatToPixel(new XPCoordinate2DDouble(this.mTrafficEventLocation));
        if (lonLatToPixel == null) {
            L.e(TAG, "moveITrafficEventPopView point is null.");
            return;
        }
        ITrafficEventContract.ITrafficEventPopView iTrafficEventPopView = this.mTrafficEventPopView;
        if (iTrafficEventPopView != null) {
            iTrafficEventPopView.move(lonLatToPixel.x, lonLatToPixel.y);
        }
    }

    private void startRequestTrafficEvent() {
        String eventID;
        TrafficEventPopParam trafficEventPopParam = this.mRequestParam;
        if (trafficEventPopParam == null) {
            L.e(TAG, "request param is null !");
            return;
        }
        if (trafficEventPopParam.mEventType == 0) {
            eventID = NavCoreUtil.getEventID(this.mRequestParam.mEventId);
        } else {
            eventID = this.mRequestParam.mEventType == 2 ? NavCoreUtil.getEventID(Long.toString(Long.parseLong(this.mRequestParam.mEventId), 36).toUpperCase()) : "";
        }
        if (TextUtils.isEmpty(eventID)) {
            return;
        }
        if (this.mTrafficReqHandle > -1) {
            TrafficEventServiceWrapper.getInstance().cancel(this.mTrafficReqHandle);
        }
        this.mTrafficReqHandle = TrafficEventServiceWrapper.getInstance().requestTrafficIncident(eventID, this);
        L.Tag tag = TAG;
        L.i(tag, "startRequestTrafficEvent: " + this.mTrafficReqHandle);
    }

    private void showScratchSpot() {
        TrafficEventData.Builder builder = new TrafficEventData.Builder();
        builder.setTrafficIconId(R.drawable.vector_ic_mid_normal_traffic_scratch_spot);
        builder.setIncidentTitle(ContextUtils.getString(R.string.scratch_spot_title));
        builder.setIncidentSubTitle(this.mRequestParam.mJamRoadName);
        builder.setIncidentDes1(this.mRequestParam.mDes);
        if (this.mRequestParam.mUpdateTime != null && this.mRequestParam.mUpdateTime.trim().length() > 0) {
            builder.setIncidentDes2(ContextUtils.getString(R.string.scratch_spot_update_time, this.mRequestParam.mUpdateTime));
        }
        if (CollectionUtils.isNotEmpty(this.mRequestParam.mImages)) {
            this.mPicUrls = this.mRequestParam.mImages;
            builder.addIconUrls(this.mRequestParam.mImages);
        }
        TrafficEventData build = builder.build();
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "showScratchSpot:" + build.toString());
        }
        ITrafficEventContract.ITrafficEventPopView iTrafficEventPopView = this.mTrafficEventPopView;
        if (iTrafficEventPopView != null) {
            iTrafficEventPopView.showEventData(build);
        }
    }
}
