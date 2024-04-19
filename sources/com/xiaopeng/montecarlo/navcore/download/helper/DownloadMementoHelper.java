package com.xiaopeng.montecarlo.navcore.download.helper;

import com.xiaopeng.montecarlo.navcore.download.MapDataManager;
import com.xiaopeng.montecarlo.navcore.download.bean.CityDataBean;
import com.xiaopeng.montecarlo.navcore.download.bean.ProvinceDataBean;
import com.xiaopeng.montecarlo.navcore.download.constant.OperationTypeEnum;
import com.xiaopeng.montecarlo.navcore.setting.SettingWrapper;
import com.xiaopeng.montecarlo.root.network.XPNetworkManager;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import com.xiaopeng.montecarlo.root.util.L;
import java.util.ArrayList;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
/* loaded from: classes2.dex */
public class DownloadMementoHelper {
    private static final int MAX_RETRY_TIMES = 2;
    private static final L.Tag TAG = new L.Tag("DownloadMementoHelper");
    DownloadHashList mDownloadHashList = new DownloadHashList();

    public void recordDownload(OperationTypeEnum operationTypeEnum, ArrayList<Integer> arrayList) {
        if (CollectionUtils.isEmpty(arrayList)) {
            return;
        }
        int i = AnonymousClass1.$SwitchMap$com$xiaopeng$montecarlo$navcore$download$constant$OperationTypeEnum[operationTypeEnum.ordinal()];
        if (i == 1) {
            L.Tag tag = TAG;
            L.d(tag, "multi download start, size =" + arrayList.size());
            final DownloadHashList downloadHashList = this.mDownloadHashList;
            downloadHashList.getClass();
            arrayList.forEach(new Consumer() { // from class: com.xiaopeng.montecarlo.navcore.download.helper.-$$Lambda$hYwvHVNoI4tH9FpvFiMhaoZ5deE
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    DownloadHashList.this.addToTailIfNotExist((Integer) obj);
                }
            });
            L.Tag tag2 = TAG;
            L.d(tag2, "mDownloadHashList size = " + this.mDownloadHashList.size());
        } else if (i != 2) {
        } else {
            L.Tag tag3 = TAG;
            L.d(tag3, "multi download canceled, size=" + arrayList.size());
            final DownloadHashList downloadHashList2 = this.mDownloadHashList;
            downloadHashList2.getClass();
            arrayList.forEach(new Consumer() { // from class: com.xiaopeng.montecarlo.navcore.download.helper.-$$Lambda$ELOOyePmYDwA-DKSAX72Yb3umCs
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    DownloadHashList.this.remove((Integer) obj);
                }
            });
            L.Tag tag4 = TAG;
            L.d(tag4, "mDownloadHashList size = " + this.mDownloadHashList.size());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.xiaopeng.montecarlo.navcore.download.helper.DownloadMementoHelper$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$xiaopeng$montecarlo$navcore$download$constant$OperationTypeEnum = new int[OperationTypeEnum.values().length];

        static {
            try {
                $SwitchMap$com$xiaopeng$montecarlo$navcore$download$constant$OperationTypeEnum[OperationTypeEnum.OPERATION_TYPE_START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$xiaopeng$montecarlo$navcore$download$constant$OperationTypeEnum[OperationTypeEnum.OPERATION_TYPE_PAUSE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public void clear() {
        this.mDownloadHashList.clear();
    }

    public void retryDownload(Integer num) {
        if (num != null && isContextReady()) {
            L.Tag tag = TAG;
            L.i(tag, "download failed, addToTail: " + num);
            if (this.mDownloadHashList.addToTail(num).intValue() > 2) {
                L.Tag tag2 = TAG;
                L.w(tag2, "retry too many times: " + num + ", download canceled");
                this.mDownloadHashList.remove(num);
            }
        }
    }

    public void onDownloadFinish(Integer num) {
        if (num == null) {
            return;
        }
        this.mDownloadHashList.remove(num);
    }

    public Integer getNextDownloadAdcode() {
        Integer head = this.mDownloadHashList.getHead();
        while (head != null && !isNeedDownload(head)) {
            this.mDownloadHashList.remove(head);
            head = this.mDownloadHashList.getHead();
        }
        if (head == null) {
            L.Tag tag = TAG;
            L.i(tag, "getNextDownloadAdcode, download list size: " + this.mDownloadHashList.size());
            return null;
        }
        CityDataBean cityDataBean = MapDataManager.getInstance().getCityDataBean(head.intValue());
        L.Tag tag2 = TAG;
        L.i(tag2, "next download city is " + head + " " + ((String) Optional.ofNullable(cityDataBean).map(new Function() { // from class: com.xiaopeng.montecarlo.navcore.download.helper.-$$Lambda$QyALUgm71aZTj2YxNGZOH22j2VQ
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((CityDataBean) obj).getProvinceDataBean();
            }
        }).map(new Function() { // from class: com.xiaopeng.montecarlo.navcore.download.helper.-$$Lambda$3UyBDtdqKpJoei_rpYdRN6oqPU4
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((ProvinceDataBean) obj).getName();
            }
        }).orElse("")) + ((String) Optional.ofNullable(cityDataBean).map(new Function() { // from class: com.xiaopeng.montecarlo.navcore.download.helper.-$$Lambda$Q15IFPIst1xykG2JrRQoRzgikbM
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((CityDataBean) obj).getCityTitle();
            }
        }).orElse("")) + ", remain " + this.mDownloadHashList.size() + " waiting to download");
        return head;
    }

    private boolean isContextReady() {
        return XPNetworkManager.INSTANCE.getNetworkType() == XPNetworkManager.XPNetworkType.NETWORK_WIFI && isAutoDownloadOpen();
    }

    private boolean isAutoDownloadOpen() {
        return SettingWrapper.isAutoDataDownloadEnabled(SettingWrapper.getAllSettingValue());
    }

    private boolean isNeedDownload(Integer num) {
        CityDataBean cityDataBean;
        if (num == null || (cityDataBean = MapDataManager.getInstance().getCityDataBean(num.intValue())) == null) {
            return false;
        }
        return cityDataBean.isReady() || cityDataBean.isPaused() || cityDataBean.isError();
    }
}
