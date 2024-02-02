package com.xiaopeng.montecarlo.navcore.sr.data;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.xiaopeng.montecarlo.navcore.download.MapDataManager;
import com.xiaopeng.montecarlo.navcore.download.bean.CityDataBean;
import com.xiaopeng.montecarlo.root.datalog.BtnType;
import com.xiaopeng.montecarlo.root.datalog.DataLogUtil;
import com.xiaopeng.montecarlo.root.datalog.PageType;
import com.xiaopeng.montecarlo.root.util.L;
/* loaded from: classes2.dex */
public class LaneDataLogHelper {
    private static final L.Tag TAG = new L.Tag(LaneDataLogHelper.class.getSimpleName());
    private CityDataBean mCurrentDownloadCity;
    private String mDownloadDataVersion;
    private long mDownloadTaskTotalSize;

    public void sendDataLogFromLaneDataAction(@NonNull LaneDataAction laneDataAction) {
        int actionCode = laneDataAction.getActionCode();
        if (actionCode == 2) {
            this.mDownloadDataVersion = laneDataAction.getDownloadTaskVersion();
        } else if (actionCode != 3) {
            if (actionCode == 4) {
                handleLaneDataUpdateFail(laneDataAction);
            } else if (actionCode != 5) {
            } else {
                this.mDownloadTaskTotalSize = laneDataAction.getDownloadTaskTotalSize();
                handleLaneDataDownloadStart(laneDataAction);
            }
        } else {
            L.Tag tag = TAG;
            L.i(tag, "getDownloadTaskStatus：" + laneDataAction.getDownloadTaskStatus());
            if (laneDataAction.getDownloadTaskStatus() == LaneDownloadTaskStatusCodeEnum.TASK_STATUS_CODE_DONE.getStatusCode()) {
                handleLaneDataDownloadSuccess(laneDataAction);
            } else if (laneDataAction.getDownloadTaskStatus() == LaneDownloadTaskStatusCodeEnum.TASK_STATUS_CODE_SUCCESS.getStatusCode()) {
                handleLaneDataMergeSuccess(laneDataAction);
            }
        }
    }

    private void handleLaneDataDownloadStart(@NonNull LaneDataAction laneDataAction) {
        if (TextUtils.isEmpty(this.mDownloadDataVersion)) {
            return;
        }
        DataLogUtil.sendStatData(PageType.NAVI_LANE_DATA_DOWNLOAD, BtnType.LANE_DATA_START_DOWNLOAD, this.mDownloadDataVersion, Integer.valueOf(getAdCodeByUrID(laneDataAction.getDownloadTaskUrId())), Long.valueOf(laneDataAction.getDownloadTaskTotalSize()));
        this.mDownloadDataVersion = null;
    }

    private void handleLaneDataDownloadSuccess(@NonNull LaneDataAction laneDataAction) {
        DataLogUtil.sendStatData(PageType.NAVI_LANE_DATA_DOWNLOAD, BtnType.LANE_DATA_DOWNLOAD_SUCCESS, Integer.valueOf(getAdCodeByUrID(laneDataAction.getDownloadTaskUrId())), Long.valueOf(this.mDownloadTaskTotalSize));
    }

    private void handleLaneDataUpdateFail(@NonNull LaneDataAction laneDataAction) {
        DataLogUtil.sendStatData(PageType.NAVI_LANE_DATA_DOWNLOAD, BtnType.LANE_DATA_UPDATE_FAIL, Integer.valueOf(getAdCodeByUrID(laneDataAction.getDownloadTaskUrId())), Integer.valueOf(laneDataAction.getDownloadTaskErrorCode()));
    }

    private void handleLaneDataMergeSuccess(@NonNull LaneDataAction laneDataAction) {
        DataLogUtil.sendStatData(PageType.NAVI_LANE_DATA_DOWNLOAD, BtnType.LANE_DATA_MERGE_SUCCESS, Integer.valueOf(getAdCodeByUrID(laneDataAction.getDownloadTaskUrId())));
    }

    private int getAdCodeByUrID(int i) {
        CityDataBean cityDataByUrId = getCityDataByUrId(i);
        if (cityDataByUrId != null) {
            return cityDataByUrId.getAdcode();
        }
        return -1;
    }

    private CityDataBean getCityDataByUrId(int i) {
        CityDataBean cityDataBean = this.mCurrentDownloadCity;
        if (cityDataBean != null && cityDataBean.getUrcode() == i) {
            return this.mCurrentDownloadCity;
        }
        this.mCurrentDownloadCity = MapDataManager.getInstance().getCityDataBeanByUrID(i);
        return this.mCurrentDownloadCity;
    }
}
