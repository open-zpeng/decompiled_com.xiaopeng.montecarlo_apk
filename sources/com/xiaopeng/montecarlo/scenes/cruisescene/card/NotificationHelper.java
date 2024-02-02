package com.xiaopeng.montecarlo.scenes.cruisescene.card;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Base64;
import androidx.annotation.NonNull;
import com.xiaopeng.montecarlo.MainActivity;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.base.scene.IBaseScene;
import com.xiaopeng.montecarlo.bridge.StatusConst;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiCategory;
import com.xiaopeng.montecarlo.navcore.util.BMPDataUtil;
import com.xiaopeng.montecarlo.navcore.xptbt.INaviListener;
import com.xiaopeng.montecarlo.navcore.xptbt.TBTManager;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.ILightBarInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.RouteParams;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPCameraInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPCrossImageInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPExitDirectionInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPFacilityInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPLaneInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPManeuverInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPNaviCongestionInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPNaviInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPObtainInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPPathTrafficEventInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPRouteTrafficEventInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPTollGateInfo;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.GsonUtil;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.WorkThreadUtil;
import com.xiaopeng.montecarlo.root.util.logcat.LogHelper;
import com.xiaopeng.montecarlo.service.navi.request.CategoryRequest;
import com.xiaopeng.montecarlo.service.navi.type.Request;
import com.xiaopeng.montecarlo.theme.IThemeSwitchListener;
import com.xiaopeng.montecarlo.util.ActivityLifecycleHelper;
import com.xiaopeng.montecarlo.util.ThemeWatcherUtil;
import com.xiaopeng.montecarlo.util.Utils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class NotificationHelper implements INaviListener, ActivityLifecycleHelper.ActivityLifecycleListener {
    private static final String CHANNEL_ID = "CRUISE_CARD";
    private static final String CHANNEL_NAME = "CRUISE_CARD";
    private static final int FLAG_DISPLAY_INFOFLOW = 32;
    private static final int INFOFLOW_CARD_TYPE_CRUISE = 25;
    private static final String KEY_EXTRA_DATA = "extraData";
    private static final String KEY_EXTRA_DISPLAY_FLAG = "android.displayFlag";
    private static final String KEY_INFOFLOW_CARD_TYPE = "cardType";
    private static final int NOTIFICATION_ID = 256;
    private static final L.Tag TAG = new L.Tag("NotificationHelper");
    private static final NotificationHelper sNotificationHelper = new NotificationHelper();
    private Context mContext;
    private NotificationManager mNotificationManager;
    private boolean mIsBackstage = false;
    private Handler mHandle = new Handler(WorkThreadUtil.getInstance().getSpeechAndAiThreadLooper());
    private IThemeSwitchListener mThemeSwitchListener = new IThemeSwitchListener() { // from class: com.xiaopeng.montecarlo.scenes.cruisescene.card.NotificationHelper.1
        @Override // com.xiaopeng.montecarlo.theme.IThemeSwitchListener
        public void onSwitchTheme(String str, boolean z) {
            IBaseScene currentScene;
            Activity activity = ContextUtils.getActivity();
            if (!(activity instanceof MainActivity) || (currentScene = ((MainActivity) activity).getCurrentScene()) == null || (StatusConst.Mode.NAVI != currentScene.getMode() && StatusConst.Mode.EXPLORE != currentScene.getMode())) {
                NotificationHelper.this.mHandle.post(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.cruisescene.card.NotificationHelper.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        NotificationHelper.this.sendCruiseCardRefresh();
                    }
                });
                return;
            }
            L.Tag tag = NotificationHelper.TAG;
            L.i(tag, "on theme switch current scene mode : " + currentScene.getMode());
        }
    };

    @Override // com.xiaopeng.montecarlo.util.ActivityLifecycleHelper.ActivityLifecycleListener
    public void onActivityStopped() {
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.INaviListener
    public void onBeforePathChanged(boolean z) {
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.INaviListener
    public void onChangeNaviPath(long j) {
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.INaviListener
    public void onDeletePath(List<Long> list, long j, boolean z) {
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.INaviListener
    public void onMainPathChanged() {
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.INaviListener
    public void onNaviStop(int i, boolean z) {
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.INaviListener
    public void onObtainAsyncInfo(XPObtainInfo xPObtainInfo) {
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.INaviListener
    public void onReroute(RouteParams routeParams) {
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.INaviListener
    public void onSelectMainPathStatus(long j, int i) {
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.INaviListener
    public void onShowNaviCamera(List<XPCameraInfo> list) {
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.INaviListener
    public void onShowNaviIntervalCamera(List<XPCameraInfo> list) {
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.INaviListener
    public void onShowNaviManeuver(XPManeuverInfo xPManeuverInfo) {
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.INaviListener
    public void onShowTollGateLane(XPTollGateInfo xPTollGateInfo) {
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.INaviListener
    public void onSuggestChangePath(long j, long j2, long j3) {
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.INaviListener
    public void onUpdateCrossImage(XPCrossImageInfo xPCrossImageInfo, int i, boolean z) {
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.INaviListener
    public void onUpdateExitDirectionInfo(XPExitDirectionInfo xPExitDirectionInfo) {
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.INaviListener
    public void onUpdateIntervalCameraDynamicInfo(List<XPCameraInfo> list) {
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.INaviListener
    public void onUpdateNaviInfo(List<XPNaviInfo> list) {
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.INaviListener
    public void onUpdateNaviLaneInfo(XPLaneInfo xPLaneInfo, boolean z) {
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.INaviListener
    public void onUpdateRemainDis(long j, int i, int i2) {
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.INaviListener
    public void onUpdateSAPA(List<XPFacilityInfo> list) {
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.INaviListener
    public void onUpdateTMCCongestionInfo(XPNaviCongestionInfo xPNaviCongestionInfo) {
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.INaviListener
    public void onUpdateTMCLightBar(List<ILightBarInfo> list, int i, boolean z) {
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.INaviListener
    public void onUpdateTREvent(List<XPPathTrafficEventInfo> list, int i) {
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.INaviListener
    public void onUpdateTRPlayView(XPRouteTrafficEventInfo xPRouteTrafficEventInfo) {
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.INaviListener
    public void onUpdateViaPass(long j) {
    }

    private NotificationHelper() {
        ActivityLifecycleHelper.getInstance().registerActivityLifecycleListener(this);
    }

    @NonNull
    public static NotificationHelper getInstance() {
        return sNotificationHelper;
    }

    public void addNaviListener() {
        TBTManager.getInstance().addNaviListener(this);
    }

    private void sendCruisetCardFront() {
        L.i(TAG, "send cruise card front");
        Notification.Builder builder = new Notification.Builder(this.mContext, "CRUISE_CARD");
        builder.setSmallIcon(R.drawable.png_ic_mid_location_blue).setWhen(System.currentTimeMillis()).setContentTitle(this.mContext.getString(R.string.cruise_infoflow_card_search));
        builder.getExtras().putInt("cardType", 25);
        builder.getExtras().putInt(KEY_EXTRA_DISPLAY_FLAG, 32);
        ActionList actionList = new ActionList();
        ArrayList arrayList = new ArrayList();
        arrayList.add(buildSearchAction());
        arrayList.add(buildCategorySearchAction(this.mContext.getString(R.string.search_category_park), XPPoiCategory.SEARCH_CATEGORY_PARK));
        arrayList.add(buildCategorySearchAction(this.mContext.getString(R.string.search_category_food), XPPoiCategory.SEARCH_CATEGORY_FOOD));
        actionList.actions = arrayList;
        builder.getExtras().putString(KEY_EXTRA_DATA, GsonUtil.toJson(actionList));
        try {
            this.mNotificationManager.notify(256, builder.build());
        } catch (Exception e) {
            L.e(TAG, "sendCruisetCardFront error");
            e.printStackTrace();
        }
    }

    private void sendCruisetCardBackstage() {
        L.i(TAG, "send cruise card backstage");
        Notification.Builder builder = new Notification.Builder(this.mContext, "CRUISE_CARD");
        builder.setSmallIcon(R.drawable.icon_32_normal_ic_food).setWhen(System.currentTimeMillis()).setContentTitle(this.mContext.getString(R.string.cruise_infoflow_card_browser));
        builder.getExtras().putInt("cardType", 25);
        builder.getExtras().putInt(KEY_EXTRA_DISPLAY_FLAG, 32);
        ActionList actionList = new ActionList();
        ArrayList arrayList = new ArrayList();
        arrayList.add(buildLaunchMapAction());
        arrayList.add(buildCategorySearchAction(this.mContext.getString(R.string.search_category_park), XPPoiCategory.SEARCH_CATEGORY_PARK));
        arrayList.add(buildCategorySearchAction(this.mContext.getString(R.string.search_category_food), XPPoiCategory.SEARCH_CATEGORY_FOOD));
        actionList.actions = arrayList;
        builder.getExtras().putString(KEY_EXTRA_DATA, GsonUtil.toJson(actionList));
        try {
            this.mNotificationManager.notify(256, builder.build());
        } catch (Exception e) {
            L.e(TAG, "sendCruisetCardBackstage error");
            e.printStackTrace();
        }
    }

    public void sendCruiseCardRefresh() {
        if (Utils.isLandscape()) {
            this.mContext = ContextUtils.getContext();
            if (this.mContext == null) {
                L.i(TAG, "show cruise card context is null");
                return;
            }
            if (this.mNotificationManager == null) {
                L.i(TAG, "sendCruiseCardRefresh notificationManager need init");
                this.mNotificationManager = (NotificationManager) this.mContext.getSystemService("notification");
                this.mNotificationManager.createNotificationChannel(new NotificationChannel("CRUISE_CARD", "CRUISE_CARD", 4));
            }
            ThemeWatcherUtil.addThemeListener(this.mThemeSwitchListener);
            if (this.mIsBackstage) {
                sendCruisetCardBackstage();
            } else {
                sendCruisetCardFront();
            }
        }
    }

    public void sendCruiseCardDismiss() {
        if (Utils.isLandscape()) {
            L.i(TAG, "send cruise card dismiss");
            NotificationManager notificationManager = this.mNotificationManager;
            if (notificationManager != null) {
                try {
                    notificationManager.cancel(256);
                } catch (Exception e) {
                    L.e(TAG, "sendCruiseCardDismiss error");
                    e.printStackTrace();
                }
            } else {
                L.w(TAG, "null == mNotificationManager !!");
            }
            ThemeWatcherUtil.removeThemeListener(this.mThemeSwitchListener);
        }
    }

    private Action buildLaunchMapAction() {
        Action action = new Action();
        action.actionType = Action.TYPE_START_SERVICE;
        action.actionName = Action.ACTION_NAVI_SERVICE;
        Request request = new Request();
        request.setApp_id(ContextUtils.getContext().getPackageName());
        request.setWhat(7);
        request.setBack_type(3);
        request.setContent("launch map");
        action.datas = request;
        return action;
    }

    private Action buildSearchAction() {
        Action action = new Action();
        action.actionType = Action.TYPE_START_SERVICE;
        action.actionName = Action.ACTION_NAVI_SERVICE;
        Request request = new Request();
        request.setApp_id(ContextUtils.getContext().getPackageName());
        request.setWhat(5);
        request.setBack_type(3);
        request.setContent("search main");
        action.datas = request;
        return action;
    }

    private Action buildCategorySearchAction(String str, String str2) {
        Action action = new Action();
        action.actionType = Action.TYPE_START_SERVICE;
        action.actionName = Action.ACTION_NAVI_SERVICE;
        action.actionImg = getActionIconBase64(str2);
        Request request = new Request();
        request.setApp_id(ContextUtils.getContext().getPackageName());
        request.setBack_type(3);
        request.setWhat(6);
        CategoryRequest categoryRequest = new CategoryRequest();
        categoryRequest.mKeyword = str;
        categoryRequest.mCategory = str2;
        request.setContent(GsonUtil.toJson(categoryRequest));
        action.datas = request;
        int length = TextUtils.isEmpty(action.actionImg) ? 0 : action.actionImg.length();
        L.Tag tag = TAG;
        L.i(tag, "buildCategorySearchAction keyword:" + str + " category:" + str2 + " img:" + LogHelper.getLogHead(action.actionImg) + " length:" + length);
        return action;
    }

    private String getActionIconBase64(String str) {
        char c;
        Bitmap decodeResource = BitmapFactory.decodeResource(this.mContext.getResources(), R.drawable.png_action_chargingstation);
        int hashCode = str.hashCode();
        if (hashCode == 1541) {
            if (str.equals(XPPoiCategory.SEARCH_CATEGORY_FOOD)) {
                c = 2;
            }
            c = 65535;
        } else if (hashCode != 1478625) {
            if (hashCode == 1512237 && str.equals(XPPoiCategory.SEARCH_CATEGORY_PARK)) {
                c = 1;
            }
            c = 65535;
        } else {
            if (str.equals(XPPoiCategory.SEARCH_CATEGORY_CHARGE)) {
                c = 0;
            }
            c = 65535;
        }
        if (c == 0) {
            decodeResource = BitmapFactory.decodeResource(this.mContext.getResources(), R.drawable.png_action_chargingstation);
        } else if (c == 1) {
            decodeResource = BitmapFactory.decodeResource(this.mContext.getResources(), R.drawable.png_action_park);
        } else if (c == 2) {
            decodeResource = BitmapFactory.decodeResource(this.mContext.getResources(), R.drawable.png_action_food);
        }
        byte[] bitmap2PngData = BMPDataUtil.bitmap2PngData(decodeResource);
        if (bitmap2PngData == null || bitmap2PngData.length <= 0) {
            return null;
        }
        return Base64.encodeToString(bitmap2PngData, 2);
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.INaviListener
    public void onNaviStart(final int i) {
        this.mHandle.post(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.cruisescene.card.NotificationHelper.2
            @Override // java.lang.Runnable
            public void run() {
                if (2 != i) {
                    NotificationHelper.this.sendCruiseCardDismiss();
                } else {
                    NotificationHelper.this.sendCruiseCardRefresh();
                }
            }
        });
    }

    @Override // com.xiaopeng.montecarlo.util.ActivityLifecycleHelper.ActivityLifecycleListener
    public void onActivityCovered(boolean z) {
        this.mHandle.post(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.cruisescene.card.NotificationHelper.3
            @Override // java.lang.Runnable
            public void run() {
                NotificationHelper.this.mIsBackstage = true;
                int currentStatus = TBTManager.getInstance().getCurrentStatus();
                if (2 == currentStatus || 1 == currentStatus) {
                    return;
                }
                NotificationHelper.this.sendCruiseCardRefresh();
            }
        });
    }

    @Override // com.xiaopeng.montecarlo.util.ActivityLifecycleHelper.ActivityLifecycleListener
    public void onActivityResumed() {
        this.mHandle.post(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.cruisescene.card.NotificationHelper.4
            @Override // java.lang.Runnable
            public void run() {
                NotificationHelper.this.mIsBackstage = false;
                int currentStatus = TBTManager.getInstance().getCurrentStatus();
                if (2 == currentStatus || 1 == currentStatus) {
                    return;
                }
                NotificationHelper.this.sendCruiseCardRefresh();
            }
        });
    }
}
