package com.xiaopeng.montecarlo.navcore.download.dataoperator.download;

import com.autonavi.common.tool.FDManager;
import com.xiaopeng.montecarlo.navcore.download.MapDataManager;
import com.xiaopeng.montecarlo.navcore.download.bean.CityDataBean;
import com.xiaopeng.montecarlo.navcore.download.dataoperator.MapDataOperator;
import com.xiaopeng.montecarlo.navcore.download.dataoperator.record.CityRecordBean;
import com.xiaopeng.montecarlo.root.carservice.CarServiceManager;
import com.xiaopeng.montecarlo.root.network.XPNetworkManager;
import com.xiaopeng.montecarlo.root.provider.dataset.DataSetHelper;
import com.xiaopeng.montecarlo.root.util.GsonUtil;
import com.xiaopeng.montecarlo.root.util.L;
import io.reactivex.annotations.NonNull;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public class MapDataDownloader extends AbstractMapDataDownloader {
    private int mCurrentDownloadAdCode;
    private final LinkedList<MapDataDownloadBean> mDownloadQueue;

    public MapDataDownloader(int i, @NonNull MapDataOperator mapDataOperator) {
        super(i, mapDataOperator);
        this.mDownloadQueue = new LinkedList<MapDataDownloadBean>() { // from class: com.xiaopeng.montecarlo.navcore.download.dataoperator.download.MapDataDownloader.1
            @Override // java.util.LinkedList, java.util.AbstractCollection, java.util.Collection, java.util.List, java.util.Deque
            public boolean contains(Object obj) {
                if (obj instanceof MapDataDownloadBean) {
                    Iterator it = iterator();
                    while (it.hasNext()) {
                        if (((MapDataDownloadBean) it.next()).equals(obj)) {
                            return true;
                        }
                    }
                    return false;
                }
                return super.contains(obj);
            }
        };
        this.mCurrentDownloadAdCode = -1;
    }

    @Override // com.xiaopeng.montecarlo.navcore.download.dataoperator.download.AbstractMapDataDownloader
    public void notifyCruiseCityDiff(int i) {
        if (addToQueue(i, 8)) {
            executeDownloadQueue();
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.download.dataoperator.download.AbstractMapDataDownloader
    void notifyNaviCityDownload(Long l) {
        MapDataDownloadBean mapDataDownloadBean;
        Iterator<MapDataDownloadBean> it = this.mDownloadQueue.iterator();
        while (true) {
            if (!it.hasNext()) {
                mapDataDownloadBean = null;
                break;
            }
            mapDataDownloadBean = it.next();
            if (mapDataDownloadBean.getPriority() == 9) {
                break;
            }
        }
        if (mapDataDownloadBean != null) {
            removeDownload(mapDataDownloadBean);
        }
        addToQueue(l.intValue(), 9);
        executeDownloadQueue();
    }

    @Override // com.xiaopeng.montecarlo.navcore.download.dataoperator.download.AbstractMapDataDownloader
    void removeAllNaviDownload() {
        ArrayList<MapDataDownloadBean> arrayList = new ArrayList();
        Iterator<MapDataDownloadBean> it = this.mDownloadQueue.iterator();
        while (it.hasNext()) {
            MapDataDownloadBean next = it.next();
            if (next.getPriority() == 9) {
                arrayList.add(next);
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        for (MapDataDownloadBean mapDataDownloadBean : arrayList) {
            removeDownload(mapDataDownloadBean);
        }
    }

    public void downloadPushMapData(int i) {
        addToQueue(i, 7);
        executeDownloadQueue();
    }

    public void onDownLoadStatusChange(int i) {
        CityDataBean cityDataBean;
        if (i != this.mCurrentDownloadAdCode || (cityDataBean = MapDataManager.getInstance().getCityDataBean(i)) == null) {
            return;
        }
        L.Tag tag = this.TAG;
        L.i(tag, "onDownLoadStatusChange , adcode= " + i + " getTaskState：" + cityDataBean.getTaskState());
        if (cityDataBean.isFinish()) {
            removeDownload(this.mCurrentDownloadAdCode);
            executeDownloadQueue();
        } else if (cityDataBean.isPaused() || cityDataBean.isError()) {
            executeDownloadQueue();
        }
    }

    public void prepareDownload() {
        startCityMonitorByMode();
    }

    public void startUpdate() {
        L.i(this.TAG, "startUpdate");
        List<CityRecordBean> mapDataRecordListDescByRecordCount = getMapDataOperator().getMapDataRecordListDescByRecordCount();
        Map<Integer, CityRecordBean> mapDataRecordInfo = getMapDataOperator().getMapDataRecordInfo();
        if (mapDataRecordListDescByRecordCount.isEmpty()) {
            return;
        }
        CityRecordBean cityRecordBean = null;
        CityRecordBean cityRecordBean2 = null;
        List<Integer> list = null;
        List<Integer> list2 = null;
        for (CityRecordBean cityRecordBean3 : mapDataRecordListDescByRecordCount) {
            L.i(this.TAG, "startUpdate bean:" + GsonUtil.toJson(cityRecordBean3));
            if (cityRecordBean3.getAdCode() != 0 && cityRecordBean3.getRecordCount() != 0) {
                if (cityRecordBean == null) {
                    addToQueue(cityRecordBean3.getAdCode(), 6);
                    list = MapDataManager.getInstance().getNearbyCityAdCodeList(cityRecordBean3.getAdCode());
                    cityRecordBean = cityRecordBean3;
                } else {
                    if (cityRecordBean2 != null) {
                        break;
                    }
                    addToQueue(cityRecordBean3.getAdCode(), 6);
                    list2 = MapDataManager.getInstance().getNearbyCityAdCodeList(cityRecordBean3.getAdCode());
                    cityRecordBean2 = cityRecordBean3;
                }
            }
        }
        if (cityRecordBean == null) {
            L.i(this.TAG, "startUpdate no city to update");
            return;
        }
        boolean z = DataSetHelper.GlobalSet.getBoolean(DataSetHelper.GlobalSet.KEY_IS_OOBE_NEARBY_DOWNLOAD, true);
        L.i(this.TAG, "start update maxUsedCityNearbyCodeList:" + list);
        for (Integer num : list) {
            if (z) {
                addToQueue(num.intValue(), 5);
            } else {
                CityRecordBean cityRecordBean4 = mapDataRecordInfo.get(num);
                if (cityRecordBean4 != null && cityRecordBean4.getLastUseTimeInMillis() > 0) {
                    addToQueue(num.intValue(), 5);
                }
            }
        }
        if (list2 != null) {
            L.i(this.TAG, "start update minorUsedCityNearByCodeList:" + list2);
            for (Integer num2 : list2) {
                if (z) {
                    addToQueue(num2.intValue(), 5);
                } else {
                    CityRecordBean cityRecordBean5 = mapDataRecordInfo.get(num2);
                    if (cityRecordBean5 != null && cityRecordBean5.getLastUseTimeInMillis() > 0) {
                        addToQueue(num2.intValue(), 5);
                    }
                }
            }
        }
        executeDownloadQueue();
        if (z) {
            DataSetHelper.GlobalSet.set(DataSetHelper.GlobalSet.KEY_IS_OOBE_NEARBY_DOWNLOAD, false);
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.download.dataoperator.download.AbstractMapDataDownloader
    public void onCurrentCityChanged(int i) {
        super.onCurrentCityChanged(i);
        if (i <= 0 || getCurrentCityAdCode() == i) {
            return;
        }
        removeDownload(getCurrentCityAdCode());
        setCurrentCityAdCode(i);
        addToQueue(getCurrentCityAdCode(), 10);
        executeDownloadQueue();
    }

    private boolean addToQueue(int i, int i2) {
        MapDataDownloadBean create = MapDataDownloadBean.create(i, i2);
        if (create != null) {
            L.Tag tag = this.TAG;
            L.i(tag, "addToQueue adCode:" + i + ",priority:" + i2 + ",urCode:" + create.getCityDataBean().getUrcode());
            if (this.mDownloadQueue.contains(create)) {
                L.Tag tag2 = this.TAG;
                L.i(tag2, "addToQueue adCode:" + i + " is already in queue!");
                return true;
            } else if (create.getCityDataBean().isFinish()) {
                L.Tag tag3 = this.TAG;
                L.i(tag3, "addToQueue adCode:" + i + " is already downloaded!");
                return true;
            } else {
                this.mDownloadQueue.add(create);
                this.mDownloadQueue.sort(MapDataDownloadBean.sComparator);
                return true;
            }
        }
        L.Tag tag4 = this.TAG;
        L.e(tag4, "addToQueue faile unKnown adCode:" + i);
        return false;
    }

    public void onInitDownload() {
        L.i(this.TAG, "onInitDownload");
        addToQueue(0, 11);
        if (getCurrentCityAdCode() > 0) {
            addToQueue(getCurrentCityAdCode(), 10);
        }
        executeDownloadQueue();
    }

    public void executeDownloadQueue() {
        if (!canDownload()) {
            L.e(this.TAG, "executeDownloadQueue fail! download is not available");
            return;
        }
        L.Tag tag = this.TAG;
        L.i(tag, "executeDownloadQueue queue size: " + this.mDownloadQueue.size());
        if (this.mDownloadQueue.isEmpty()) {
            return;
        }
        logDownloadQueue();
        MapDataDownloadBean peek = this.mDownloadQueue.peek();
        if (peek != null) {
            int adCode = peek.getAdCode();
            int i = this.mCurrentDownloadAdCode;
            if (adCode == i) {
                L.Tag tag2 = this.TAG;
                L.i(tag2, "executeDownloadQueue mCurrentDownloadAdCode is downloading:" + this.mCurrentDownloadAdCode);
                if (peek.getCityDataBean().isDownloading()) {
                    return;
                }
                L.i(this.TAG, "executeDownloadQueue mCurrentDownloadAdCode start download again ");
                MapDataManager.getInstance().startDownload(Integer.valueOf(this.mCurrentDownloadAdCode));
                return;
            }
            if (i >= 0 && i != peek.getAdCode()) {
                MapDataManager.getInstance().pauseDownload(Integer.valueOf(this.mCurrentDownloadAdCode));
                L.Tag tag3 = this.TAG;
                L.i(tag3, "executeDownloadQueue cancelDownload:" + this.mCurrentDownloadAdCode);
            }
            if (checkCanDownload(peek)) {
                this.mCurrentDownloadAdCode = peek.getAdCode();
                L.Tag tag4 = this.TAG;
                L.i(tag4, "executeDownloadQueue peek " + this.mCurrentDownloadAdCode + " remain: " + this.mDownloadQueue.size());
                MapDataManager.getInstance().startDownload(Integer.valueOf(this.mCurrentDownloadAdCode));
                return;
            }
            L.i(this.TAG, "executeDownloadQueue city data is downloaded ,ignore! ");
            removeDownload(peek);
            executeDownloadQueue();
        }
    }

    private boolean checkCanDownload(@NonNull MapDataDownloadBean mapDataDownloadBean) {
        if (mapDataDownloadBean.getCityDataBean().isFinish()) {
            return false;
        }
        if (mapDataDownloadBean.getPriority() == 8) {
            return isCityNeedCruiseDownload(mapDataDownloadBean.getAdCode());
        }
        return true;
    }

    private void removeDownload(int i) {
        MapDataDownloadBean findDownloadInfoInQueue;
        L.Tag tag = this.TAG;
        L.i(tag, "removeDownload: " + i);
        if (i < 0 || (findDownloadInfoInQueue = findDownloadInfoInQueue(i)) == null) {
            return;
        }
        removeDownload(findDownloadInfoInQueue);
    }

    private void removeDownload(@NonNull MapDataDownloadBean mapDataDownloadBean) {
        L.Tag tag = this.TAG;
        L.i(tag, "removeDownload: " + mapDataDownloadBean);
        this.mDownloadQueue.remove(mapDataDownloadBean);
        if (this.mCurrentDownloadAdCode == mapDataDownloadBean.getAdCode()) {
            MapDataManager.getInstance().pauseDownload(Integer.valueOf(mapDataDownloadBean.getAdCode()));
            this.mCurrentDownloadAdCode = -1;
        }
    }

    private MapDataDownloadBean findDownloadInfoInQueue(int i) {
        Iterator<MapDataDownloadBean> it = this.mDownloadQueue.iterator();
        while (it.hasNext()) {
            MapDataDownloadBean next = it.next();
            if (next.getAdCode() == i) {
                return next;
            }
        }
        return null;
    }

    private boolean canDownload() {
        return !CarServiceManager.getInstance().isFactoryMode() && XPNetworkManager.INSTANCE.isNetworkConnected() && MapDataManager.getInstance().isCompletedInitialized();
    }

    private void logDownloadQueue() {
        StringBuilder sb = new StringBuilder();
        Iterator<MapDataDownloadBean> it = this.mDownloadQueue.iterator();
        while (it.hasNext()) {
            MapDataDownloadBean next = it.next();
            sb.append(FDManager.LINE_SEPERATOR);
            sb.append("adCode:");
            sb.append(next.getAdCode());
            sb.append(",name:");
            sb.append(next.getCityDataBean().getCityTitle());
        }
        L.Tag tag = this.TAG;
        L.i(tag, "logDownloadQueue size:" + this.mDownloadQueue.size() + ",content:" + ((Object) sb));
    }
}
