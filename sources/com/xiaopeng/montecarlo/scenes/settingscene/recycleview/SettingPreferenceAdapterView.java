package com.xiaopeng.montecarlo.scenes.settingscene.recycleview;

import android.content.Context;
import android.content.res.TypedArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.base.BaseBridge;
import com.xiaopeng.montecarlo.navcore.util.CommonUtil;
import com.xiaopeng.montecarlo.navcore.xptbt.TBTManager;
import com.xiaopeng.montecarlo.root.carfeature.CarFeatureManager;
import com.xiaopeng.montecarlo.root.provider.dataset.DataSetHelper;
import com.xiaopeng.montecarlo.root.util.DebugCacheConsts;
import com.xiaopeng.montecarlo.scenes.settingscene.ISettingCallback;
import com.xiaopeng.montecarlo.scenes.settingscene.ISettingContract;
import com.xiaopeng.montecarlo.scenes.settingscene.recycleview.viewholder.AvoidLimitRouteLicensePlateViewHolder;
import com.xiaopeng.montecarlo.scenes.settingscene.recycleview.viewholder.AvoidLimitRouteViewHolder;
import com.xiaopeng.montecarlo.scenes.settingscene.recycleview.viewholder.BaseSettingViewHolder;
import com.xiaopeng.montecarlo.scenes.settingscene.recycleview.viewholder.CarLogoViewHolder;
import com.xiaopeng.montecarlo.scenes.settingscene.recycleview.viewholder.ChargingStationViewHolder;
import com.xiaopeng.montecarlo.scenes.settingscene.recycleview.viewholder.CruiseBroadcastViewHolder;
import com.xiaopeng.montecarlo.scenes.settingscene.recycleview.viewholder.DataResetViewHolder;
import com.xiaopeng.montecarlo.scenes.settingscene.recycleview.viewholder.DynamicLevelViewHolder;
import com.xiaopeng.montecarlo.scenes.settingscene.recycleview.viewholder.MapSeamlessNaviViewHolder;
import com.xiaopeng.montecarlo.scenes.settingscene.recycleview.viewholder.MapVersionViewHolder;
import com.xiaopeng.montecarlo.scenes.settingscene.recycleview.viewholder.MinimapViewHolder;
import com.xiaopeng.montecarlo.scenes.settingscene.recycleview.viewholder.NaviBroadcastViewHolder;
import com.xiaopeng.montecarlo.scenes.settingscene.recycleview.viewholder.OfflineMapAutoUpdateViewHolder;
import com.xiaopeng.montecarlo.scenes.settingscene.recycleview.viewholder.OfflineMapViewHolder;
import com.xiaopeng.montecarlo.scenes.settingscene.recycleview.viewholder.RealTimeTrafficViewHolder;
import com.xiaopeng.montecarlo.scenes.settingscene.recycleview.viewholder.RecommendParkViewHolder;
import com.xiaopeng.montecarlo.scenes.settingscene.recycleview.viewholder.RoutePreferenceViewHolder;
import com.xiaopeng.montecarlo.scenes.settingscene.recycleview.viewholder.RouteRadarViewHolder;
import com.xiaopeng.montecarlo.scenes.settingscene.recycleview.viewholder.ScratchSpotViewHolder;
import com.xiaopeng.montecarlo.scenes.settingscene.recycleview.viewholder.UserDataDeleteViewHolder;
import com.xiaopeng.xui.utils.XTouchAreaUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class SettingPreferenceAdapterView extends RecyclerView.Adapter {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private CharSequence[] mCarLogoKeyList;
    private CharSequence[] mCarLogoNameList;
    private Context mContext;
    private LayoutInflater mInflater;
    private TypedArray mLogoCarIconList;
    private int mOtherTabPosition;
    private ISettingContract.LogicView mSettingView;
    private List<SettingPreferenceTypeEnum> mRecycleViewDataList = new ArrayList();
    private SettingPreferenceAdapterProvider mProvider = new SettingPreferenceAdapterProvider();

    public SettingPreferenceAdapterProvider getProvider() {
        return this.mProvider;
    }

    public SettingPreferenceAdapterView(Context context, ISettingContract.LogicView logicView) {
        this.mContext = context;
        this.mInflater = LayoutInflater.from(context);
        this.mSettingView = logicView;
        createRecycleViewDataList();
        this.mCarLogoNameList = this.mContext.getResources().getTextArray(R.array.set_car_logo_title_arr);
        this.mLogoCarIconList = this.mContext.getResources().obtainTypedArray(R.array.set_car_logo_scr_arr);
        this.mCarLogoKeyList = this.mContext.getResources().getTextArray(R.array.set_car_logo_key_arr);
        this.mOtherTabPosition = this.mRecycleViewDataList.indexOf(SettingPreferenceTypeEnum.SETTING_PREFERENCE_AVOID_LIMIT_ROUTE);
    }

    public Context getContext() {
        return this.mContext;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(@NonNull RecyclerView.ViewHolder viewHolder) {
        if (viewHolder instanceof BaseSettingViewHolder) {
            XTouchAreaUtils.extendTouchAreaAsParentSameSize(((BaseSettingViewHolder) viewHolder).getXSwitch(), (ViewGroup) viewHolder.itemView);
        }
        super.onViewAttachedToWindow(viewHolder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        switch (SettingPreferenceTypeEnum.parse(i)) {
            case SETTING_PREFERENCE_ROUTE_PREFERENCE:
                return new RoutePreferenceViewHolder(this.mInflater.inflate(R.layout.layout_item_setting_route_preference, viewGroup, false), this);
            case SETTING_PREFERENCE_NAVI_BROADCAST:
                return new NaviBroadcastViewHolder(this.mInflater.inflate(R.layout.layout_item_setting_navi_broadcast, viewGroup, false), this);
            case SETTING_PREFERENCE_MINIMAP:
                return new MinimapViewHolder(this.mInflater.inflate(R.layout.layout_item_setting_minimap, viewGroup, false), this);
            case SETTING_PREFERENCE_CRUISE_BROADCAST:
                return new CruiseBroadcastViewHolder(this.mInflater.inflate(R.layout.layout_item_setting_cruise_broadcast, viewGroup, false), this);
            case SETTING_PREFERENCE_ROUTE_RADAR:
                return new RouteRadarViewHolder(this.mInflater.inflate(R.layout.layout_item_setting_route_radar, viewGroup, false), this);
            case SETTING_PREFERENCE_CAR_LOGO:
                return new CarLogoViewHolder(this.mInflater.inflate(R.layout.layout_item_setting_car_logo, viewGroup, false), this);
            case SETTING_PREFERENCE_AVOID_LIMIT_ROUTE:
                return new AvoidLimitRouteViewHolder(this.mInflater.inflate(R.layout.layout_item_setting_avoid_limit_route, viewGroup, false), this);
            case SETTING_PREFERENCE_AVOID_LIMIT_ROUTE_LICENSE_PLATE:
                return new AvoidLimitRouteLicensePlateViewHolder(this.mInflater.inflate(R.layout.layout_item_setting_avoid_limit_route_license_plate, viewGroup, false), this);
            case SETTING_PREFERENCE_CHARGING_STATION:
                return new ChargingStationViewHolder(this.mInflater.inflate(R.layout.layout_item_setting_charging_station, viewGroup, false), this);
            case SETTING_PREFERENCE_REAL_TIME_TRAFFIC:
                return new RealTimeTrafficViewHolder(this.mInflater.inflate(R.layout.layout_item_setting_real_time_traffic, viewGroup, false), this);
            case SETTING_PREFERENCE_SCRATCH_SPOT:
                return new ScratchSpotViewHolder(this.mInflater.inflate(R.layout.layout_item_setting_scratch_spot, viewGroup, false), this);
            case SETTING_PREFERENCE_DYNAMIC_LEVEL:
                return new DynamicLevelViewHolder(this.mInflater.inflate(R.layout.layout_item_setting_dynamic_level, viewGroup, false), this);
            case SETTING_PREFERENCE_RECOMMEND_PARK:
                return new RecommendParkViewHolder(this.mInflater.inflate(R.layout.layout_item_setting_recommend_park, viewGroup, false), this);
            case SETTING_PREFERENCE_MAP_SEAMLESS_NAVI:
                return new MapSeamlessNaviViewHolder(this.mInflater.inflate(R.layout.layout_item_setting_map_seamless_navi, viewGroup, false), this);
            case SETTING_PREFERENCE_OFFLINE_MAP:
                return new OfflineMapViewHolder(this.mInflater.inflate(R.layout.layout_item_setting_offline_map, viewGroup, false), this);
            case SETTING_PREFERENCE_OFFLINE_MAP_AUTO_UPDATE:
                return new OfflineMapAutoUpdateViewHolder(this.mInflater.inflate(R.layout.layout_item_setting_offline_map_auto_update, viewGroup, false), this);
            case SETTING_PREFERENCE_USER_DATA_DELETE:
                return new UserDataDeleteViewHolder(this.mInflater.inflate(R.layout.layout_item_setting_user_data_delete, viewGroup, false), this);
            case SETTING_PREFERENCE_DATA_RESET:
                return new DataResetViewHolder(this.mInflater.inflate(R.layout.layout_item_setting_data_reset, viewGroup, false), this);
            case SETTING_PREFERENCE_MAP_VERSION:
                return new MapVersionViewHolder(this.mInflater.inflate(R.layout.layout_item_setting_map_version, viewGroup, false), this);
            default:
                return null;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if (viewHolder instanceof BaseSettingViewHolder) {
            ((BaseSettingViewHolder) viewHolder).refreshViewFromData();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i, @NonNull List list) {
        if (viewHolder instanceof BaseSettingViewHolder) {
            ((BaseSettingViewHolder) viewHolder).refreshViewFromData();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return this.mRecycleViewDataList.get(i).getId();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.mRecycleViewDataList.size();
    }

    private void createRecycleViewDataList() {
        this.mRecycleViewDataList.clear();
        this.mRecycleViewDataList.add(SettingPreferenceTypeEnum.SETTING_PREFERENCE_ROUTE_PREFERENCE);
        this.mRecycleViewDataList.add(SettingPreferenceTypeEnum.SETTING_PREFERENCE_NAVI_BROADCAST);
        if (TBTManager.getInstance().isMiniMapEnable()) {
            this.mRecycleViewDataList.add(SettingPreferenceTypeEnum.SETTING_PREFERENCE_MINIMAP);
        }
        this.mRecycleViewDataList.add(SettingPreferenceTypeEnum.SETTING_PREFERENCE_CRUISE_BROADCAST);
        this.mRecycleViewDataList.add(SettingPreferenceTypeEnum.SETTING_PREFERENCE_ROUTE_RADAR);
        this.mRecycleViewDataList.add(SettingPreferenceTypeEnum.SETTING_PREFERENCE_CAR_LOGO);
        this.mRecycleViewDataList.add(SettingPreferenceTypeEnum.SETTING_PREFERENCE_AVOID_LIMIT_ROUTE);
        this.mRecycleViewDataList.add(SettingPreferenceTypeEnum.SETTING_PREFERENCE_AVOID_LIMIT_ROUTE_LICENSE_PLATE);
        this.mRecycleViewDataList.add(SettingPreferenceTypeEnum.SETTING_PREFERENCE_CHARGING_STATION);
        this.mRecycleViewDataList.add(SettingPreferenceTypeEnum.SETTING_PREFERENCE_REAL_TIME_TRAFFIC);
        if (CommonUtil.isScratchSpotEnable()) {
            this.mRecycleViewDataList.add(SettingPreferenceTypeEnum.SETTING_PREFERENCE_SCRATCH_SPOT);
        }
        this.mRecycleViewDataList.add(SettingPreferenceTypeEnum.SETTING_PREFERENCE_DYNAMIC_LEVEL);
        if (CarFeatureManager.INSTANCE.isRecommendParkSwitchEnable()) {
            this.mRecycleViewDataList.add(SettingPreferenceTypeEnum.SETTING_PREFERENCE_RECOMMEND_PARK);
        }
        this.mRecycleViewDataList.add(SettingPreferenceTypeEnum.SETTING_PREFERENCE_MAP_SEAMLESS_NAVI);
        boolean z = DataSetHelper.GlobalSet.getBoolean(DataSetHelper.GlobalSet.CACHE_IS_SHOW_OFFLINE_MAP, DebugCacheConsts.DEFAULT_VALUE_CACHE_IS_SHOW_OFFLINE_MAP);
        if (CarFeatureManager.INSTANCE.isMapDataPreInstalled() || z) {
            this.mRecycleViewDataList.add(SettingPreferenceTypeEnum.SETTING_PREFERENCE_OFFLINE_MAP);
            this.mRecycleViewDataList.add(SettingPreferenceTypeEnum.SETTING_PREFERENCE_OFFLINE_MAP_AUTO_UPDATE);
        }
        this.mRecycleViewDataList.add(SettingPreferenceTypeEnum.SETTING_PREFERENCE_USER_DATA_DELETE);
        this.mRecycleViewDataList.add(SettingPreferenceTypeEnum.SETTING_PREFERENCE_DATA_RESET);
        this.mRecycleViewDataList.add(SettingPreferenceTypeEnum.SETTING_PREFERENCE_MAP_VERSION);
    }

    public int getOtherTabPosition() {
        return this.mOtherTabPosition;
    }

    public void updateSceneWithView(View view) {
        ISettingContract.LogicView logicView = this.mSettingView;
        if (logicView != null) {
            logicView.updateSceneWithView(view);
        }
    }

    public void startScene(BaseBridge baseBridge) {
        ISettingContract.LogicView logicView = this.mSettingView;
        if (logicView != null) {
            logicView.startScene(baseBridge);
        }
    }

    public void startScene(BaseBridge baseBridge, int i) {
        ISettingContract.LogicView logicView = this.mSettingView;
        if (logicView != null) {
            logicView.startScene(baseBridge, i);
        }
    }

    public void enableCharge(boolean z) {
        ISettingContract.LogicView logicView = this.mSettingView;
        if (logicView != null) {
            logicView.enableCharge(z);
        }
    }

    public void enableScratchSpot(boolean z) {
        ISettingContract.LogicView logicView = this.mSettingView;
        if (logicView != null) {
            logicView.enableScratchSpot(z);
        }
    }

    public void goBack() {
        ISettingContract.LogicView logicView = this.mSettingView;
        if (logicView != null) {
            logicView.goBack();
        }
    }

    public void modifySettingPreference(int i, boolean z) {
        ISettingContract.LogicView logicView = this.mSettingView;
        if (logicView != null) {
            logicView.modifySettingPreference(i, z);
        }
    }

    public void saveSettingPreference() {
        ISettingContract.LogicView logicView = this.mSettingView;
        if (logicView != null) {
            logicView.saveSettingPreference();
        }
    }

    public void saveSettingPreference(ISettingCallback iSettingCallback) {
        ISettingContract.LogicView logicView = this.mSettingView;
        if (logicView != null) {
            logicView.saveSettingPreference(iSettingCallback);
        }
    }

    public void delUserData() {
        ISettingContract.LogicView logicView = this.mSettingView;
        if (logicView != null) {
            logicView.delUserData();
        }
    }

    public void restoreDefaultData(boolean z) {
        ISettingContract.LogicView logicView = this.mSettingView;
        if (logicView != null) {
            logicView.restoreDefaultData(z);
        }
    }

    public void switchXpengGuideIcon(boolean z) {
        this.mProvider.setXPAccountLoginIn(z);
        notifyDataSetChanged();
    }

    public void switchMapBindGuideIcon(boolean z) {
        this.mProvider.setAMapBinded(z);
        notifyDataSetChanged();
    }

    public void updateMapDownloadSize(long j) {
        this.mProvider.setMapDownloadSize(j);
        notifyDataSetChanged();
    }

    public void setLicencePlate(String str) {
        this.mProvider.setLicensePlate(str);
        notifyDataSetChanged();
    }

    public void updateCarLogo(String str) {
        int i = 0;
        while (true) {
            CharSequence[] charSequenceArr = this.mCarLogoKeyList;
            if (i >= charSequenceArr.length) {
                return;
            }
            if (charSequenceArr[i].equals(str)) {
                String charSequence = this.mCarLogoNameList[i].toString();
                int resourceId = this.mLogoCarIconList.getResourceId(i, -1);
                this.mProvider.setCarLogoHintTitle(charSequence);
                this.mProvider.setCurrentCarLogoSrc(resourceId);
                notifyDataSetChanged();
            }
            i++;
        }
    }

    public void switchAvoidLimitRoute(boolean z) {
        this.mProvider.setAvoidRestrictionRouteEnable(z);
        notifyDataSetChanged();
    }

    public void scrollToEnd() {
        this.mSettingView.scrollToEnd();
    }

    public void showSettingToast(String str) {
        ISettingContract.LogicView logicView = this.mSettingView;
        if (logicView != null) {
            logicView.showSettingToast(str);
        }
    }

    public void release() {
        if (this.mSettingView != null) {
            this.mSettingView = null;
        }
    }
}
