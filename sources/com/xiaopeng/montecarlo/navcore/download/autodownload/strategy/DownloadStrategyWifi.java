package com.xiaopeng.montecarlo.navcore.download.autodownload.strategy;

import com.xiaopeng.montecarlo.navcore.download.MapDataManager;
import com.xiaopeng.montecarlo.navcore.download.bean.CityDataBean;
import com.xiaopeng.montecarlo.navcore.download.bean.ProvinceDataBean;
import com.xiaopeng.montecarlo.navcore.download.constant.OperationErrCodeEnum;
import com.xiaopeng.montecarlo.navcore.download.constant.OperationTypeEnum;
import com.xiaopeng.montecarlo.navcore.download.constant.TaskStatusCodeEnum;
import com.xiaopeng.montecarlo.navcore.setting.SettingWrapper;
import com.xiaopeng.montecarlo.root.network.XPNetworkManager;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import com.xiaopeng.montecarlo.root.util.L;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;
/* loaded from: classes3.dex */
public class DownloadStrategyWifi implements IDownloadStartStrategy {
    private static final L.Tag TAG = new L.Tag("DownloadStrategyWifi");
    private ArrayList<Integer> mDownloadList = new ArrayList<>();

    @Override // com.xiaopeng.montecarlo.navcore.download.autodownload.strategy.IDownloadStartStrategy
    public void onOperated(OperationTypeEnum operationTypeEnum, Integer num) {
    }

    private synchronized void prepareDownloadQueue() {
        L.i(TAG, "prepareDownloadQueue");
        this.mDownloadList.clear();
        CityDataBean cityDataBean = MapDataManager.getInstance().getCityDataBean(0);
        if (cityDataBean != null && !cityDataBean.isFinish()) {
            this.mDownloadList.add(Integer.valueOf(cityDataBean.getAdcode()));
            L.i(TAG, "add base package");
        }
        CityDataBean cityDataBean2 = MapDataManager.getInstance().getCityDataBean(MapDataManager.getInstance().getCurrentCityAdCode());
        if (cityDataBean2 != null && !cityDataBean2.isFinish()) {
            this.mDownloadList.add(Integer.valueOf(cityDataBean2.getAdcode()));
        }
        L.Tag tag = TAG;
        L.i(tag, "current city=" + cityDataBean2);
        Stream stream = ((List) Optional.ofNullable(MapDataManager.getInstance().getNearbyCityAdCodeList()).orElse(Collections.emptyList())).stream();
        final MapDataManager mapDataManager = MapDataManager.getInstance();
        mapDataManager.getClass();
        List list = (List) stream.map(new Function() { // from class: com.xiaopeng.montecarlo.navcore.download.autodownload.strategy.-$$Lambda$DYaGluDu5oxUZFn4YZNlCcjtrG0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return MapDataManager.this.getCityDataBean(((Integer) obj).intValue());
            }
        }).filter(new Predicate() { // from class: com.xiaopeng.montecarlo.navcore.download.autodownload.strategy.-$$Lambda$qRBVtvAYnDDljMDqhMYo8lNz7DA
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return Objects.nonNull((CityDataBean) obj);
            }
        }).filter(new Predicate() { // from class: com.xiaopeng.montecarlo.navcore.download.autodownload.strategy.-$$Lambda$DownloadStrategyWifi$pDjdhZIqtNQ_JQlE9YAO7NaTWtE
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return DownloadStrategyWifi.lambda$prepareDownloadQueue$0((CityDataBean) obj);
            }
        }).map(new Function() { // from class: com.xiaopeng.montecarlo.navcore.download.autodownload.strategy.-$$Lambda$Eb5Z0AmnOwGEcs2GKLfi96yc5Sk
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Integer.valueOf(((CityDataBean) obj).getAdcode());
            }
        }).collect(Collectors.toList());
        this.mDownloadList.addAll(list);
        L.Tag tag2 = TAG;
        L.i(tag2, "nearbyCityDownloadList size=" + list.size());
        Stream stream2 = ((List) Optional.ofNullable(MapDataManager.getInstance().getDirectCityAdCodeList()).orElse(Collections.emptyList())).stream();
        final MapDataManager mapDataManager2 = MapDataManager.getInstance();
        mapDataManager2.getClass();
        List list2 = (List) stream2.map(new Function() { // from class: com.xiaopeng.montecarlo.navcore.download.autodownload.strategy.-$$Lambda$DYaGluDu5oxUZFn4YZNlCcjtrG0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return MapDataManager.this.getCityDataBean(((Integer) obj).intValue());
            }
        }).filter(new Predicate() { // from class: com.xiaopeng.montecarlo.navcore.download.autodownload.strategy.-$$Lambda$qRBVtvAYnDDljMDqhMYo8lNz7DA
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return Objects.nonNull((CityDataBean) obj);
            }
        }).filter(new Predicate() { // from class: com.xiaopeng.montecarlo.navcore.download.autodownload.strategy.-$$Lambda$DownloadStrategyWifi$zBF7DvpsYKfU3WJvcw74-quUJoE
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return DownloadStrategyWifi.lambda$prepareDownloadQueue$1((CityDataBean) obj);
            }
        }).map(new Function() { // from class: com.xiaopeng.montecarlo.navcore.download.autodownload.strategy.-$$Lambda$Eb5Z0AmnOwGEcs2GKLfi96yc5Sk
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Integer.valueOf(((CityDataBean) obj).getAdcode());
            }
        }).collect(Collectors.toList());
        this.mDownloadList.addAll(list2);
        L.Tag tag3 = TAG;
        L.i(tag3, "directCityDownloadList size=" + list2.size());
        Collection values = ((Map) Optional.ofNullable(MapDataManager.getInstance().getProvinceDataBeanList()).orElse(new HashMap())).values();
        if (CollectionUtils.isNotEmpty(values)) {
            ArrayList arrayList = (ArrayList) values.stream().filter(new Predicate() { // from class: com.xiaopeng.montecarlo.navcore.download.autodownload.strategy.-$$Lambda$hOJaAhax1MZs9Qf3-IcXN7d8HCM
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return Objects.nonNull((ProvinceDataBean) obj);
                }
            }).map(new Function() { // from class: com.xiaopeng.montecarlo.navcore.download.autodownload.strategy.-$$Lambda$NaVYAFmkm1RtTzkUCGP4vvkdXeI
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return ((ProvinceDataBean) obj).getContainCityList();
                }
            }).filter(new Predicate() { // from class: com.xiaopeng.montecarlo.navcore.download.autodownload.strategy.-$$Lambda$uaJ7C34WElFvgU7o6yo-MrQpCqg
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return CollectionUtils.isNotEmpty((ArrayList) obj);
                }
            }).flatMap(new Function() { // from class: com.xiaopeng.montecarlo.navcore.download.autodownload.strategy.-$$Lambda$JdUL9ZP9AzcttUlxZCHq6-pfTzU
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return ((ArrayList) obj).stream();
                }
            }).filter(new Predicate() { // from class: com.xiaopeng.montecarlo.navcore.download.autodownload.strategy.-$$Lambda$qRBVtvAYnDDljMDqhMYo8lNz7DA
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return Objects.nonNull((CityDataBean) obj);
                }
            }).filter(new Predicate() { // from class: com.xiaopeng.montecarlo.navcore.download.autodownload.strategy.-$$Lambda$DownloadStrategyWifi$WzeJn9hEstj1KcN-BTrd5IfWiYk
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return DownloadStrategyWifi.lambda$prepareDownloadQueue$2((CityDataBean) obj);
                }
            }).map(new Function() { // from class: com.xiaopeng.montecarlo.navcore.download.autodownload.strategy.-$$Lambda$Eb5Z0AmnOwGEcs2GKLfi96yc5Sk
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return Integer.valueOf(((CityDataBean) obj).getAdcode());
                }
            }).collect(Collectors.toCollection(new Supplier() { // from class: com.xiaopeng.montecarlo.navcore.download.autodownload.strategy.-$$Lambda$OGSS2qx6njxlnp0dnKb4lA3jnw8
                @Override // java.util.function.Supplier
                public final Object get() {
                    return new ArrayList();
                }
            }));
            arrayList.removeAll(list2);
            arrayList.removeAll(list);
            this.mDownloadList.addAll(arrayList);
            L.Tag tag4 = TAG;
            L.i(tag4, "otherCityDownloadList not finish size=" + arrayList.size());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean lambda$prepareDownloadQueue$0(CityDataBean cityDataBean) {
        return !cityDataBean.isFinish();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean lambda$prepareDownloadQueue$1(CityDataBean cityDataBean) {
        return !cityDataBean.isFinish();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean lambda$prepareDownloadQueue$2(CityDataBean cityDataBean) {
        return !cityDataBean.isFinish();
    }

    private void executeDownloadQueue() {
        if (CollectionUtils.isNotEmpty(this.mDownloadList)) {
            MapDataManager.getInstance().multiDownload(this.mDownloadList);
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.download.autodownload.strategy.IDownloadStartStrategy
    public void onCityDataStatusChange(int i, TaskStatusCodeEnum taskStatusCodeEnum, OperationErrCodeEnum operationErrCodeEnum) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "onCityDataStatusChange " + i);
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
    public void interrupt() {
        L.i(TAG, "interrupt");
        MapDataManager.getInstance().multiPause(this.mDownloadList);
    }

    private boolean isContextReady() {
        if (XPNetworkManager.INSTANCE.getNetworkType() != XPNetworkManager.XPNetworkType.NETWORK_WIFI) {
            if (L.ENABLE) {
                L.d(TAG, "isContextReady, not wifi status");
            }
            return false;
        } else if (!MapDataManager.getInstance().isCityListReady()) {
            if (L.ENABLE) {
                L.d(TAG, "isContextReady, BL not init");
            }
            return false;
        } else if (!isAutoDownloadOpen()) {
            if (L.ENABLE) {
                L.d(TAG, "isContextReady, auto download switch not open");
            }
            return false;
        } else if (isAllProvinceUpToDate()) {
            if (L.ENABLE) {
                L.d(TAG, "isContextReady, all data updated");
            }
            return false;
        } else {
            return true;
        }
    }

    public boolean isAllProvinceUpToDate() {
        return 0 == MapDataManager.getInstance().getAllProvinceDataSize();
    }

    private boolean isAutoDownloadOpen() {
        int allSettingValue = SettingWrapper.getAllSettingValue();
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.v(tag, "isAutoDownloadOpen " + SettingWrapper.isAutoDataDownloadEnabled(allSettingValue));
        }
        return SettingWrapper.isAutoDataDownloadEnabled(allSettingValue);
    }

    public String toString() {
        return getClass().getSimpleName();
    }
}
