package com.xiaopeng.montecarlo.navcore.download.autodownload.strategy;

import androidx.annotation.NonNull;
import com.xiaopeng.montecarlo.navcore.account.XPAccountServiceWrapper;
import com.xiaopeng.montecarlo.navcore.bean.favorite.FavoriteAddress;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import com.xiaopeng.montecarlo.navcore.download.MapDataManager;
import com.xiaopeng.montecarlo.navcore.download.autodownload.profile.DownloadUserProfile;
import com.xiaopeng.montecarlo.navcore.download.bean.CityDataBean;
import com.xiaopeng.montecarlo.navcore.download.constant.OperationErrCodeEnum;
import com.xiaopeng.montecarlo.navcore.download.constant.OperationTypeEnum;
import com.xiaopeng.montecarlo.navcore.download.constant.TaskStatusCodeEnum;
import com.xiaopeng.montecarlo.navcore.favorite.FavoriteDataManager;
import com.xiaopeng.montecarlo.root.network.XPNetworkManager;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.RootUtil;
import com.xiaopeng.montecarlo.root.util.ioutil.FileUtil;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes2.dex */
public class DownloadStrategy4G implements IDownloadStartStrategy {
    private static final long ONE_DAY_MILLISECONDS = 86400000;
    private static final L.Tag TAG = new L.Tag("DownloadStrategy4G");
    private static final int UPDATE_INTERVAL = 90;
    private final LinkedList<Integer> mDownloadQueue = new LinkedList<Integer>() { // from class: com.xiaopeng.montecarlo.navcore.download.autodownload.strategy.DownloadStrategy4G.1
        @Override // java.util.LinkedList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List, java.util.Deque, java.util.Queue
        public boolean add(Integer num) {
            if (!contains(num)) {
                if (DownloadStrategy4G.this.isNeedUpdateAuto(num.intValue())) {
                    if (L.ENABLE) {
                        L.Tag tag = DownloadStrategy4G.TAG;
                        L.d(tag, "add " + num);
                    }
                    return super.add((AnonymousClass1) num);
                }
                if (L.ENABLE) {
                    L.Tag tag2 = DownloadStrategy4G.TAG;
                    L.d(tag2, "no need to update " + num);
                }
                return false;
            }
            if (L.ENABLE) {
                L.Tag tag3 = DownloadStrategy4G.TAG;
                L.d(tag3, "already exist " + num);
            }
            return false;
        }

        @Override // java.util.LinkedList, java.util.AbstractCollection, java.util.Collection, java.util.List, java.util.Deque
        public boolean contains(Object obj) {
            if (obj instanceof Integer) {
                Iterator it = iterator();
                while (it.hasNext()) {
                    if (obj.equals((Integer) it.next())) {
                        return true;
                    }
                }
                return false;
            }
            return super.contains(obj);
        }
    };
    private int mCurrentDownloadAdCode = -1;
    private final DownloadUserProfile mUserProfile = MapDataManager.getInstance().getMapDataOperator().getUserProfile();

    @Override // com.xiaopeng.montecarlo.navcore.download.autodownload.strategy.IDownloadStartStrategy
    public void onOperated(OperationTypeEnum operationTypeEnum, Integer num) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isNeedUpdateAuto(int i) {
        if (i < 0) {
            return false;
        }
        CityDataBean cityDataBean = MapDataManager.getInstance().getCityDataBean(i);
        if (cityDataBean == null) {
            L.Tag tag = TAG;
            L.i(tag, i + " is null");
            return false;
        }
        L.Tag tag2 = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        sb.append(" isFinish:");
        sb.append(!cityDataBean.isFinish());
        sb.append(" ");
        sb.append(getUpdateInterval(i));
        L.i(tag2, sb.toString());
        return !cityDataBean.isFinish() && getUpdateInterval(i) > 90;
    }

    private long getUpdateInterval(int i) {
        Date lastModifyTime = FileUtil.getLastModifyTime(getDownloadFilePath(i));
        if (lastModifyTime == null) {
            return -1L;
        }
        Date date = new Date();
        long time = (date.getTime() - lastModifyTime.getTime()) / 86400000;
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "days=" + time + " old:" + lastModifyTime + " new:" + date);
        }
        return time;
    }

    @NonNull
    private String getDownloadFilePath(int i) {
        CityDataBean cityDataBean;
        if (MapDataManager.getInstance().getCityDataBean(i) == null) {
            return "";
        }
        String str = RootUtil.DIR_OFFLINE_RELATIVE_PATH + "/a" + cityDataBean.getUrcode();
        if (L.ENABLE) {
            L.d(TAG, "filePath:" + str);
        }
        return str;
    }

    private boolean isContextReady() {
        return MapDataManager.getInstance().isCityListReady() && XPNetworkManager.INSTANCE.getNetworkType() == XPNetworkManager.XPNetworkType.NETWORK_TBOX;
    }

    private void prepareDownloadQueue() {
        if (this.mUserProfile == null) {
            return;
        }
        if (isLoginMode()) {
            prepareLoginInDownloadQueue();
        } else {
            prepareLoginOutDownloadQueue();
        }
    }

    private boolean isLoginMode() {
        return XPAccountServiceWrapper.getInstance().isLoginXp();
    }

    private void prepareLoginInDownloadQueue() {
        LinkedList<Integer> linkedList;
        XPPoiInfo xPPoiInfo;
        XPPoiInfo xPPoiInfo2;
        if (this.mUserProfile == null || (linkedList = this.mDownloadQueue) == null) {
            return;
        }
        linkedList.clear();
        this.mDownloadQueue.add(0);
        FavoriteAddress home = FavoriteDataManager.getInstance().getHome();
        if (home != null && (xPPoiInfo2 = home.getXPPoiInfo()) != null) {
            this.mDownloadQueue.add(Integer.valueOf((xPPoiInfo2.getAdCode() / 100) * 100));
        }
        FavoriteAddress company = FavoriteDataManager.getInstance().getCompany();
        if (company != null && (xPPoiInfo = company.getXPPoiInfo()) != null) {
            this.mDownloadQueue.add(Integer.valueOf((xPPoiInfo.getAdCode() / 100) * 100));
        }
        List<Integer> calculateRecentVisitedCity = this.mUserProfile.calculateRecentVisitedCity(10);
        if (calculateRecentVisitedCity == null) {
            return;
        }
        int currentCityAdCode = MapDataManager.getInstance().getCurrentCityAdCode();
        if (calculateRecentVisitedCity.contains(Integer.valueOf(currentCityAdCode))) {
            this.mDownloadQueue.add(Integer.valueOf(currentCityAdCode));
            List<Integer> nearbyCityAdCodeList = MapDataManager.getInstance().getNearbyCityAdCodeList();
            for (int i = 0; i < nearbyCityAdCodeList.size(); i++) {
                this.mDownloadQueue.add(nearbyCityAdCodeList.get(i));
            }
        }
    }

    private void prepareLoginOutDownloadQueue() {
        LinkedList<Integer> linkedList;
        if (this.mUserProfile == null || (linkedList = this.mDownloadQueue) == null) {
            return;
        }
        linkedList.clear();
        this.mDownloadQueue.add(0);
        List<Integer> calculateRecentVisitedCity = this.mUserProfile.calculateRecentVisitedCity(5);
        if (calculateRecentVisitedCity == null) {
            return;
        }
        int currentCityAdCode = MapDataManager.getInstance().getCurrentCityAdCode();
        if (calculateRecentVisitedCity.contains(Integer.valueOf(currentCityAdCode))) {
            this.mDownloadQueue.add(Integer.valueOf(currentCityAdCode));
            this.mDownloadQueue.addAll(MapDataManager.getInstance().getNearbyCityAdCodeList());
        }
    }

    private void executeDownloadQueue() {
        L.Tag tag = TAG;
        L.i(tag, "executeDownloadQueue: " + this.mDownloadQueue.size());
        LinkedList<Integer> linkedList = this.mDownloadQueue;
        if (linkedList == null || linkedList.isEmpty()) {
            return;
        }
        Integer poll = this.mDownloadQueue.poll();
        if (poll == null) {
            L.e(TAG, "executeDownloadQueue downloadAdCode is null!");
            return;
        }
        this.mCurrentDownloadAdCode = poll.intValue();
        L.Tag tag2 = TAG;
        L.i(tag2, "poll " + this.mCurrentDownloadAdCode + " remain: " + this.mDownloadQueue.size());
        if (isNeedUpdateAuto(this.mCurrentDownloadAdCode)) {
            MapDataManager.getInstance().startDownload(Integer.valueOf(this.mCurrentDownloadAdCode));
        } else {
            executeDownloadQueue();
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.download.autodownload.strategy.IDownloadStartStrategy
    public void execute() {
        L.i(TAG, "execute");
        if (isContextReady()) {
            prepareDownloadQueue();
            executeDownloadQueue();
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.download.autodownload.strategy.IDownloadStartStrategy
    public void onCityDataStatusChange(int i, TaskStatusCodeEnum taskStatusCodeEnum, OperationErrCodeEnum operationErrCodeEnum) {
        CityDataBean cityDataBean;
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "onCityDataStatusChange, adcode=" + i + " mCurrentDownloadAdCode=" + this.mCurrentDownloadAdCode);
        }
        if (isContextReady() && i == this.mCurrentDownloadAdCode && (cityDataBean = MapDataManager.getInstance().getCityDataBean(i)) != null) {
            if (L.ENABLE) {
                L.Tag tag2 = TAG;
                L.d(tag2, "onCityDataStatusChange cityDataBean " + cityDataBean.getTaskState());
            }
            if (cityDataBean.isFinish() || cityDataBean.isPaused() || cityDataBean.isError()) {
                executeDownloadQueue();
            }
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.download.autodownload.strategy.IDownloadStartStrategy
    public void interrupt() {
        L.i(TAG, "interrupt");
        MapDataManager.getInstance().pauseDownload(Integer.valueOf(this.mCurrentDownloadAdCode));
        LinkedList<Integer> linkedList = this.mDownloadQueue;
        if (linkedList != null) {
            linkedList.clear();
        }
        this.mCurrentDownloadAdCode = -1;
    }

    public String toString() {
        return getClass().getSimpleName();
    }
}
