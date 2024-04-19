package com.xiaopeng.montecarlo.scenes.downloadscene.recycleview.util;

import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.navcore.download.MapDataManager;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.RootUtil;
import com.xiaopeng.montecarlo.scenes.downloadscene.bean.CityItem;
import com.xiaopeng.montecarlo.scenes.downloadscene.bean.ProvinceItem;
/* loaded from: classes3.dex */
public class DownloadUtils {
    private static final String INVALID_STRING = "";

    public static String getProvinceState(ProvinceItem provinceItem) {
        if (MapDataManager.getInstance().isCompletedInitialized()) {
            return provinceItem != null ? provinceItem.isAllCityUpToDate() ? String.format(ContextUtils.getString(R.string.download_province_status_all_done), RootUtil.getFormatSize(provinceItem.getTotalSize())) : String.format(ContextUtils.getString(R.string.download_province_status_need_update), RootUtil.getFormatSize(provinceItem.getRemainSize())) : "";
        }
        return ContextUtils.getString(R.string.download_data_not_ready);
    }

    public static String getCityTaskStatus(CityItem cityItem) {
        if (cityItem != null) {
            if (!MapDataManager.getInstance().isCompletedInitialized()) {
                return ContextUtils.getString(R.string.download_data_not_ready);
            }
            if (cityItem.isReady()) {
                return String.format(ContextUtils.getString(R.string.download_task_status_code_ready), RootUtil.getFormatSize(cityItem.getDataPatchSize()));
            }
            if (cityItem.isWaiting()) {
                return ContextUtils.getString(R.string.download_task_status_code_waiting);
            }
            if (cityItem.isDownloading()) {
                return String.format(ContextUtils.getString(R.string.download_task_status_code_doing), RootUtil.getFormatSize((cityItem.getDataPatchSize() * cityItem.getDownloadPercent()) / 100));
            }
            if (cityItem.isPaused()) {
                return String.format(ContextUtils.getString(R.string.download_task_status_code_pause), RootUtil.getFormatSize((cityItem.getDataPatchSize() * cityItem.getDownloadPercent()) / 100));
            }
            if (cityItem.isFinish()) {
                return String.format(ContextUtils.getString(R.string.download_task_status_code_done), RootUtil.getFormatSize(cityItem.getDataFullSize()));
            }
            if (cityItem.isUnZipping()) {
                return ContextUtils.getString(R.string.download_task_status_code_unzipping);
            }
            if (cityItem.isUnZipped()) {
                return ContextUtils.getString(R.string.download_task_status_code_unzipped);
            }
            if (cityItem.isError()) {
                return ContextUtils.getString(R.string.download_task_status_code_err);
            }
            return ContextUtils.getString(R.string.download_task_status_code_err);
        }
        return "";
    }
}
