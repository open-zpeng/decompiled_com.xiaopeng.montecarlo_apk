package com.xiaopeng.montecarlo.scenes.routescene.routechargeplan.decorator;

import android.text.TextUtils;
import com.xiaopeng.montecarlo.navcore.bean.map.XPPointBaseData;
import com.xiaopeng.montecarlo.navcore.httpclient.dto.GeneralChargeInfo;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.scenes.routescene.routechargeplan.RouteChargeHelper;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
/* loaded from: classes3.dex */
public class RouteChargeDecoratorModel {
    private static final L.Tag TAG = new L.Tag("ROUTE_CHARGE_DecModel");
    public static final int TRANSFER_TYPE_INIT = 0;
    public static final int TRANSFER_TYPE_REMOVED = 3;
    public static final int TRANSFER_TYPE_SELECTED = 2;
    public static final int TRANSFER_TYPE_UPDATE = 1;
    private XPPointBaseData[] mBizData;
    private IRouteChargeDecoratorCallBack mCallBack;
    private int mLastReachableIndex = -1;
    private volatile boolean mIsStop = false;

    /* loaded from: classes3.dex */
    public interface IRouteChargeDecoratorCallBack {
        void removeDecorators(XPPointBaseData[] xPPointBaseDataArr);

        void updateDecorators(int i, XPPointBaseData[] xPPointBaseDataArr, int i2, int i3);
    }

    public RouteChargeDecoratorModel(IRouteChargeDecoratorCallBack iRouteChargeDecoratorCallBack) {
        this.mCallBack = iRouteChargeDecoratorCallBack;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public XPPointBaseData[] doAction(DecoratorTransferParam decoratorTransferParam) {
        if (this.mIsStop) {
            return null;
        }
        int i = decoratorTransferParam.mType;
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        return removeChargesInternal(decoratorTransferParam.mCharges, decoratorTransferParam.mSelectedCharges, decoratorTransferParam.mRemovedCharges, decoratorTransferParam.mDestinationArrival);
                    }
                    return this.mBizData;
                }
                return addSelectedChargeInternal(decoratorTransferParam.mCharges, decoratorTransferParam.mSelected, decoratorTransferParam.mSelectedCharges, decoratorTransferParam.mDestinationArrival);
            }
            return updateChargesInternal(decoratorTransferParam.mCharges, decoratorTransferParam.mSelectedCharges, decoratorTransferParam.mDestinationArrival);
        }
        return updateChargesInternal(decoratorTransferParam.mCharges, null, decoratorTransferParam.mDestinationArrival);
    }

    private void doTransferData(final DecoratorTransferParam decoratorTransferParam) {
        Observable.create(new ObservableOnSubscribe<DecoratorTransferParam>() { // from class: com.xiaopeng.montecarlo.scenes.routescene.routechargeplan.decorator.RouteChargeDecoratorModel.3
            @Override // io.reactivex.ObservableOnSubscribe
            public void subscribe(ObservableEmitter<DecoratorTransferParam> observableEmitter) throws Exception {
                observableEmitter.onNext(decoratorTransferParam);
                observableEmitter.onComplete();
            }
        }).map(new Function<DecoratorTransferParam, XPPointBaseData[]>() { // from class: com.xiaopeng.montecarlo.scenes.routescene.routechargeplan.decorator.RouteChargeDecoratorModel.2
            @Override // io.reactivex.functions.Function
            public XPPointBaseData[] apply(DecoratorTransferParam decoratorTransferParam2) throws Exception {
                return RouteChargeDecoratorModel.this.doAction(decoratorTransferParam2);
            }
        }).subscribeOn(Schedulers.computation()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<XPPointBaseData[]>() { // from class: com.xiaopeng.montecarlo.scenes.routescene.routechargeplan.decorator.RouteChargeDecoratorModel.1
            @Override // io.reactivex.Observer
            public void onComplete() {
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
            }

            @Override // io.reactivex.Observer
            public void onSubscribe(Disposable disposable) {
            }

            @Override // io.reactivex.Observer
            public void onNext(XPPointBaseData[] xPPointBaseDataArr) {
                if (RouteChargeDecoratorModel.this.mIsStop) {
                    return;
                }
                RouteChargeDecoratorModel.this.mBizData = xPPointBaseDataArr;
                RouteChargeDecoratorModel.this.mCallBack.updateDecorators(decoratorTransferParam.mType, xPPointBaseDataArr, RouteChargeDecoratorModel.this.mLastReachableIndex, decoratorTransferParam.mFocusIndex);
            }
        });
    }

    public void initCharges(List<GeneralChargeInfo> list, boolean z) {
        this.mIsStop = false;
        DecoratorTransferParam decoratorTransferParam = new DecoratorTransferParam(0);
        decoratorTransferParam.mCharges = list;
        decoratorTransferParam.mDestinationArrival = z;
        doTransferData(decoratorTransferParam);
    }

    public void removeAllCharges() {
        L.i(TAG, "removeAllCharges");
        this.mIsStop = true;
        IRouteChargeDecoratorCallBack iRouteChargeDecoratorCallBack = this.mCallBack;
        if (iRouteChargeDecoratorCallBack != null) {
            iRouteChargeDecoratorCallBack.removeDecorators(this.mBizData);
        }
        this.mBizData = null;
    }

    public void unInit() {
        removeAllCharges();
        this.mCallBack = null;
    }

    public void updateCharges(List<GeneralChargeInfo> list, TreeSet<GeneralChargeInfo> treeSet, boolean z) {
        this.mIsStop = false;
        DecoratorTransferParam decoratorTransferParam = new DecoratorTransferParam(1);
        decoratorTransferParam.mCharges = list;
        decoratorTransferParam.mSelectedCharges = treeSet;
        decoratorTransferParam.mDestinationArrival = z;
        doTransferData(decoratorTransferParam);
    }

    private synchronized XPPointBaseData[] updateChargesInternal(List<GeneralChargeInfo> list, TreeSet<GeneralChargeInfo> treeSet, boolean z) {
        return initBizData(list, treeSet, z);
    }

    public void addSelectedCharge(List<GeneralChargeInfo> list, GeneralChargeInfo generalChargeInfo, TreeSet<GeneralChargeInfo> treeSet, boolean z) {
        this.mIsStop = false;
        DecoratorTransferParam decoratorTransferParam = new DecoratorTransferParam(2);
        decoratorTransferParam.mCharges = list;
        decoratorTransferParam.mSelected = generalChargeInfo;
        decoratorTransferParam.mSelectedCharges = treeSet;
        decoratorTransferParam.mFocusIndex = list.indexOf(generalChargeInfo);
        decoratorTransferParam.mDestinationArrival = z;
        doTransferData(decoratorTransferParam);
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x00a6, code lost:
        updateLastReachable(r8.mBizData, r0, r12);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private synchronized com.xiaopeng.montecarlo.navcore.bean.map.XPPointBaseData[] addSelectedChargeInternal(java.util.List<com.xiaopeng.montecarlo.navcore.httpclient.dto.GeneralChargeInfo> r9, com.xiaopeng.montecarlo.navcore.httpclient.dto.GeneralChargeInfo r10, java.util.TreeSet<com.xiaopeng.montecarlo.navcore.httpclient.dto.GeneralChargeInfo> r11, boolean r12) {
        /*
            r8 = this;
            monitor-enter(r8)
            boolean r0 = r8.mIsStop     // Catch: java.lang.Throwable -> Laf
            if (r0 == 0) goto L8
            r9 = 0
            monitor-exit(r8)
            return r9
        L8:
            int r0 = r9.indexOf(r10)     // Catch: java.lang.Throwable -> Laf
            com.xiaopeng.montecarlo.navcore.bean.map.XPPointBaseData[] r1 = r8.mBizData     // Catch: java.lang.Throwable -> Laf
            if (r1 == 0) goto Lab
            com.xiaopeng.montecarlo.navcore.bean.map.XPPointBaseData[] r1 = r8.mBizData     // Catch: java.lang.Throwable -> Laf
            int r1 = r1.length     // Catch: java.lang.Throwable -> Laf
            if (r0 >= r1) goto Lab
            r1 = -1
            if (r0 <= r1) goto Lab
            com.xiaopeng.montecarlo.navcore.bean.map.XPPointBaseData[] r2 = r8.mBizData     // Catch: java.lang.Throwable -> Laf
            r2 = r2[r0]     // Catch: java.lang.Throwable -> Laf
            java.lang.String r2 = r2.id     // Catch: java.lang.Throwable -> Laf
            int r2 = com.xiaopeng.montecarlo.scenes.routescene.routechargeplan.decorator.RouteChargeDecorator.parseBizType(r2)     // Catch: java.lang.Throwable -> Laf
            r3 = 16
            int r3 = com.xiaopeng.montecarlo.scenes.routescene.routechargeplan.decorator.RouteChargeDecorator.addType(r2, r3)     // Catch: java.lang.Throwable -> Laf
            com.xiaopeng.montecarlo.root.util.L$Tag r4 = com.xiaopeng.montecarlo.scenes.routescene.routechargeplan.decorator.RouteChargeDecoratorModel.TAG     // Catch: java.lang.Throwable -> Laf
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Laf
            r5.<init>()     // Catch: java.lang.Throwable -> Laf
            java.lang.String r6 = "add charge decorator, init type: "
            r5.append(r6)     // Catch: java.lang.Throwable -> Laf
            r5.append(r2)     // Catch: java.lang.Throwable -> Laf
            java.lang.String r2 = ", new type: "
            r5.append(r2)     // Catch: java.lang.Throwable -> Laf
            r5.append(r3)     // Catch: java.lang.Throwable -> Laf
            java.lang.String r2 = ", mLastReachableIndex: "
            r5.append(r2)     // Catch: java.lang.Throwable -> Laf
            int r2 = r8.mLastReachableIndex     // Catch: java.lang.Throwable -> Laf
            r5.append(r2)     // Catch: java.lang.Throwable -> Laf
            java.lang.String r2 = r5.toString()     // Catch: java.lang.Throwable -> Laf
            com.xiaopeng.montecarlo.root.util.L.i(r4, r2)     // Catch: java.lang.Throwable -> Laf
            com.xiaopeng.montecarlo.navcore.bean.map.XPPointBaseData[] r2 = r8.mBizData     // Catch: java.lang.Throwable -> Laf
            r0 = r2[r0]     // Catch: java.lang.Throwable -> Laf
            java.lang.String r10 = r10.getStationId()     // Catch: java.lang.Throwable -> Laf
            java.lang.String r10 = r8.buildBizId(r3, r10)     // Catch: java.lang.Throwable -> Laf
            r0.id = r10     // Catch: java.lang.Throwable -> Laf
            r10 = 0
            int r0 = r8.mLastReachableIndex     // Catch: java.lang.Throwable -> Laf
            int r10 = java.lang.Math.max(r10, r0)     // Catch: java.lang.Throwable -> Laf
            r0 = r1
        L66:
            boolean r2 = r8.mIsStop     // Catch: java.lang.Throwable -> Laf
            if (r2 != 0) goto La4
            com.xiaopeng.montecarlo.navcore.bean.map.XPPointBaseData[] r2 = r8.mBizData     // Catch: java.lang.Throwable -> Laf
            int r2 = r2.length     // Catch: java.lang.Throwable -> Laf
            if (r10 >= r2) goto La4
            java.lang.Object r2 = r9.get(r10)     // Catch: java.lang.Throwable -> Laf
            com.xiaopeng.montecarlo.navcore.httpclient.dto.GeneralChargeInfo r2 = (com.xiaopeng.montecarlo.navcore.httpclient.dto.GeneralChargeInfo) r2     // Catch: java.lang.Throwable -> Laf
            boolean r2 = com.xiaopeng.montecarlo.scenes.routescene.routechargeplan.RouteChargeHelper.isChargeArrival(r2, r11)     // Catch: java.lang.Throwable -> Laf
            if (r2 == 0) goto La4
            com.xiaopeng.montecarlo.navcore.bean.map.XPPointBaseData[] r0 = r8.mBizData     // Catch: java.lang.Throwable -> Laf
            r0 = r0[r10]     // Catch: java.lang.Throwable -> Laf
            java.lang.String r0 = r0.id     // Catch: java.lang.Throwable -> Laf
            int r0 = com.xiaopeng.montecarlo.scenes.routescene.routechargeplan.decorator.RouteChargeDecorator.parseBizType(r0)     // Catch: java.lang.Throwable -> Laf
            r2 = 1
            int r0 = com.xiaopeng.montecarlo.scenes.routescene.routechargeplan.decorator.RouteChargeDecorator.addType(r0, r2)     // Catch: java.lang.Throwable -> Laf
            com.xiaopeng.montecarlo.navcore.bean.map.XPPointBaseData[] r2 = r8.mBizData     // Catch: java.lang.Throwable -> Laf
            r2 = r2[r10]     // Catch: java.lang.Throwable -> Laf
            java.lang.Object r3 = r9.get(r10)     // Catch: java.lang.Throwable -> Laf
            com.xiaopeng.montecarlo.navcore.httpclient.dto.GeneralChargeInfo r3 = (com.xiaopeng.montecarlo.navcore.httpclient.dto.GeneralChargeInfo) r3     // Catch: java.lang.Throwable -> Laf
            java.lang.String r3 = r3.getStationId()     // Catch: java.lang.Throwable -> Laf
            java.lang.String r0 = r8.buildBizId(r0, r3)     // Catch: java.lang.Throwable -> Laf
            r2.id = r0     // Catch: java.lang.Throwable -> Laf
            int r0 = r10 + 1
            r7 = r0
            r0 = r10
            r10 = r7
            goto L66
        La4:
            if (r0 <= r1) goto Lab
            com.xiaopeng.montecarlo.navcore.bean.map.XPPointBaseData[] r9 = r8.mBizData     // Catch: java.lang.Throwable -> Laf
            r8.updateLastReachable(r9, r0, r12)     // Catch: java.lang.Throwable -> Laf
        Lab:
            com.xiaopeng.montecarlo.navcore.bean.map.XPPointBaseData[] r9 = r8.mBizData     // Catch: java.lang.Throwable -> Laf
            monitor-exit(r8)
            return r9
        Laf:
            r9 = move-exception
            monitor-exit(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaopeng.montecarlo.scenes.routescene.routechargeplan.decorator.RouteChargeDecoratorModel.addSelectedChargeInternal(java.util.List, com.xiaopeng.montecarlo.navcore.httpclient.dto.GeneralChargeInfo, java.util.TreeSet, boolean):com.xiaopeng.montecarlo.navcore.bean.map.XPPointBaseData[]");
    }

    public void removeSelectedCharges(List<GeneralChargeInfo> list, TreeSet<GeneralChargeInfo> treeSet, TreeSet<GeneralChargeInfo> treeSet2, boolean z) {
        this.mIsStop = false;
        DecoratorTransferParam decoratorTransferParam = new DecoratorTransferParam(3);
        decoratorTransferParam.mCharges = list;
        decoratorTransferParam.mSelectedCharges = treeSet;
        decoratorTransferParam.mRemovedCharges = treeSet2;
        decoratorTransferParam.mFocusIndex = list.indexOf(treeSet2.first());
        decoratorTransferParam.mDestinationArrival = z;
        doTransferData(decoratorTransferParam);
    }

    private synchronized XPPointBaseData[] removeChargesInternal(List<GeneralChargeInfo> list, TreeSet<GeneralChargeInfo> treeSet, TreeSet<GeneralChargeInfo> treeSet2, boolean z) {
        if (this.mIsStop) {
            return null;
        }
        int indexOf = list.indexOf(treeSet2.first());
        if (this.mBizData != null && indexOf < this.mBizData.length) {
            int i = -1;
            if (indexOf > -1) {
                boolean z2 = false;
                L.i(TAG, "remove charge decorator, removedIndex: " + indexOf + ", mLastReachableIndex: " + this.mLastReachableIndex);
                while (!this.mIsStop && indexOf <= this.mLastReachableIndex) {
                    String parseBizStationId = RouteChargeDecorator.parseBizStationId(this.mBizData[indexOf].id);
                    GeneralChargeInfo chargeByStationId = getChargeByStationId(treeSet2, parseBizStationId);
                    int parseBizType = RouteChargeDecorator.parseBizType(this.mBizData[indexOf].id);
                    if (chargeByStationId != null) {
                        parseBizType = RouteChargeDecorator.eraseType(parseBizType, 16);
                    }
                    if (!RouteChargeHelper.isChargeArrival(list.get(indexOf), treeSet)) {
                        if (!z2) {
                            i = indexOf - 1;
                            z2 = true;
                        }
                        parseBizType = RouteChargeDecorator.addType(parseBizType, 4);
                    }
                    this.mBizData[indexOf].id = buildBizId(parseBizType, parseBizStationId);
                    indexOf++;
                }
                if (!z2) {
                    i = this.mLastReachableIndex;
                }
                updateLastReachable(this.mBizData, i, z);
            }
        }
        return this.mBizData;
    }

    private GeneralChargeInfo getChargeByStationId(Set<GeneralChargeInfo> set, String str) {
        if (!CollectionUtils.isEmpty(set) && !TextUtils.isEmpty(str)) {
            for (GeneralChargeInfo generalChargeInfo : set) {
                if (generalChargeInfo.getStationId().equals(str)) {
                    return generalChargeInfo;
                }
            }
        }
        return null;
    }

    private XPPointBaseData[] initBizData(List<GeneralChargeInfo> list, TreeSet<GeneralChargeInfo> treeSet, boolean z) {
        int i;
        int i2;
        if (this.mIsStop) {
            return null;
        }
        XPPointBaseData[] xPPointBaseDataArr = new XPPointBaseData[list.size()];
        int i3 = -1;
        int i4 = 0;
        while (!this.mIsStop && i4 < list.size()) {
            GeneralChargeInfo generalChargeInfo = list.get(i4);
            XPPointBaseData xPPointBaseData = new XPPointBaseData();
            if (RouteChargeHelper.isChargeArrival(generalChargeInfo, treeSet)) {
                i2 = (CollectionUtils.isEmpty(treeSet) || getChargeByStationId(treeSet, generalChargeInfo.getStationId()) == null) ? 1 : 17;
                i = i4;
            } else {
                i = i3;
                i2 = 4;
            }
            xPPointBaseData.id = buildBizId(i2, generalChargeInfo.getStationId());
            xPPointBaseData.position.lat = Double.parseDouble(generalChargeInfo.getLat());
            xPPointBaseData.position.lon = Double.parseDouble(generalChargeInfo.getLon());
            xPPointBaseDataArr[i4] = xPPointBaseData;
            i4++;
            i3 = i;
        }
        updateLastReachable(xPPointBaseDataArr, i3, z);
        return xPPointBaseDataArr;
    }

    private void updateLastReachable(XPPointBaseData[] xPPointBaseDataArr, int i, boolean z) {
        this.mLastReachableIndex = i;
        L.Tag tag = TAG;
        L.i(tag, "updateLastReachable: " + this.mLastReachableIndex);
        int i2 = this.mLastReachableIndex;
        if (i2 < 0 || i2 >= xPPointBaseDataArr.length) {
            return;
        }
        XPPointBaseData xPPointBaseData = xPPointBaseDataArr[i2];
        int i3 = 1;
        xPPointBaseData.id = buildBizId(RouteChargeDecorator.addType(RouteChargeDecorator.parseBizType(xPPointBaseData.id), (z && this.mLastReachableIndex == xPPointBaseDataArr.length - 1) ? 2 : 2), RouteChargeDecorator.parseBizStationId(xPPointBaseData.id));
    }

    private String buildBizId(int i, String str) {
        if (TextUtils.isEmpty(str) || i <= -1) {
            return "";
        }
        return RouteChargeDecorator.ROUTE_CHARGE_PRE + i + RouteChargeDecorator.ROUTE_CHARGE_POST + str;
    }

    public String getNextSelectCharge(int i) {
        if (i >= 0 && i < this.mBizData.length - 1) {
            int i2 = i + 1;
            while (true) {
                XPPointBaseData[] xPPointBaseDataArr = this.mBizData;
                if (i2 >= xPPointBaseDataArr.length) {
                    break;
                } else if (RouteChargeDecorator.isSelected(RouteChargeDecorator.parseBizType(xPPointBaseDataArr[i].id))) {
                    return RouteChargeDecorator.parseBizStationId(this.mBizData[i].id);
                } else {
                    i2++;
                }
            }
        }
        return "";
    }

    public XPPointBaseData[] getBizData() {
        return this.mBizData;
    }

    public void stop() {
        L.i(TAG, "stop");
        this.mIsStop = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class DecoratorTransferParam {
        boolean mDestinationArrival;
        GeneralChargeInfo mSelected;
        int mType;
        List<GeneralChargeInfo> mCharges = new ArrayList();
        TreeSet<GeneralChargeInfo> mSelectedCharges = new TreeSet<>();
        TreeSet<GeneralChargeInfo> mRemovedCharges = new TreeSet<>();
        int mFocusIndex = -1;

        DecoratorTransferParam(int i) {
            this.mType = i;
        }
    }
}
