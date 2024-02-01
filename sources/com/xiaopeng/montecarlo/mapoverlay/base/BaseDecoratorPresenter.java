package com.xiaopeng.montecarlo.mapoverlay.base;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.navcore.bean.map.XPPointBaseData;
import com.xiaopeng.montecarlo.navcore.bean.search.XPCarServiceInfo;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiCategory;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import com.xiaopeng.montecarlo.navcore.util.NavCoreUtil;
import com.xiaopeng.montecarlo.root.dataprovider.BaseCallBack;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.RootUtil;
import com.xiaopeng.montecarlo.util.NaviUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
/* loaded from: classes.dex */
public class BaseDecoratorPresenter {
    private static final int INVALID_INDEX = -1;
    private DecoratorDataProvider mDataProvider;
    protected BaseDecoratorCallback mDecoratorCallback;
    private boolean mIsRemoved;
    protected final List<XPPoiInfo> mXPPointList = new ArrayList();
    protected final List<XPPointBaseData> mXPBizPointList = new ArrayList();
    private final L.Tag mTag = new L.Tag("POP=>" + getClass().getSimpleName());
    private XPPoiInfo mFavoritePoi = null;
    private int mCurrentExpandedPosition = -1;

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean lazyLoad() {
        return false;
    }

    public BaseDecoratorPresenter(BaseDecoratorCallback baseDecoratorCallback) {
        this.mDecoratorCallback = baseDecoratorCallback;
    }

    public void onClick(XPPointBaseData xPPointBaseData) {
        BaseDecoratorCallback baseDecoratorCallback;
        if (L.ENABLE) {
            L.Tag tag = this.mTag;
            L.d(tag, "onClick pointBaseData:" + xPPointBaseData);
        }
        if (isSamePoint(xPPointBaseData, getCurrentExpandedBizPoint()) || (baseDecoratorCallback = this.mDecoratorCallback) == null) {
            return;
        }
        baseDecoratorCallback.getMainContext().getDecoratorManager().changeFocus();
        this.mCurrentExpandedPosition = findBizPoint(xPPointBaseData);
        if (isExpanded()) {
            if (L.ENABLE) {
                L.Tag tag2 = this.mTag;
                L.d(tag2, "onClick isExpanded, mCurrentExpandedPosition :" + this.mCurrentExpandedPosition);
            }
            this.mDecoratorCallback.onFocus(lazyLoad());
            refreshPoiInfo(getCurrentExpandedPoint());
            return;
        }
        L.Tag tag3 = this.mTag;
        L.e(tag3, "onClick can't find point :" + xPPointBaseData + " in " + this.mXPBizPointList.toString());
    }

    public boolean focus(XPPoiInfo xPPoiInfo) {
        if (L.ENABLE) {
            L.Tag tag = this.mTag;
            StringBuilder sb = new StringBuilder();
            sb.append("focus xpPoiInfo：");
            sb.append(xPPoiInfo == null ? "null" : xPPoiInfo.dumpXPPoiInfo());
            L.d(tag, sb.toString());
        }
        if (isSamePoint(xPPoiInfo, getCurrentExpandedPoint()) || this.mDecoratorCallback == null) {
            if (L.ENABLE) {
                L.Tag tag2 = this.mTag;
                L.d(tag2, "focus xpPoiInfo isSamePoint or mDecoratorCallback == null , mDecoratorCallback = " + this.mDecoratorCallback);
            }
            return true;
        }
        int findPoint = findPoint(xPPoiInfo);
        if (findPoint == -1) {
            if (L.ENABLE) {
                L.d(this.mTag, "focus xpPoiInfo position ==  INVALID_INDEX");
            }
            return false;
        }
        this.mDecoratorCallback.getMainContext().getDecoratorManager().changeFocus();
        this.mCurrentExpandedPosition = findPoint;
        if (isExpanded()) {
            if (L.ENABLE) {
                L.Tag tag3 = this.mTag;
                L.d(tag3, "focus isExpanded, mCurrentExpandedPosition :" + this.mCurrentExpandedPosition);
            }
            this.mDecoratorCallback.onFocus(lazyLoad());
            refreshPoiInfo(getCurrentExpandedPoint());
            return true;
        }
        L.Tag tag4 = this.mTag;
        L.e(tag4, "focus can't find point :" + xPPoiInfo + " in " + this.mXPPointList.toString());
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void updateFocusedPoint(DecoratorResponseData decoratorResponseData) {
        if (L.ENABLE) {
            L.d(this.mTag, "updateFocusedPoint");
        }
        if (decoratorResponseData == null || decoratorResponseData.getList() == null || decoratorResponseData.getList().isEmpty()) {
            L.e(this.mTag, "updateFocusedPoint data.isEmpty");
            return;
        }
        XPPoiInfo xPPoiInfo = decoratorResponseData.getList().get(0);
        if (L.ENABLE && xPPoiInfo != null) {
            L.Tag tag = this.mTag;
            L.d(tag, "updateFocusedPoint newPoint = " + xPPoiInfo.dumpXPPoiInfo());
        }
        XPPoiInfo currentExpandedPoint = getCurrentExpandedPoint();
        if (L.ENABLE && currentExpandedPoint != null) {
            L.Tag tag2 = this.mTag;
            L.d(tag2, "updateFocusedPoint focusedPoint = " + currentExpandedPoint.dumpXPPoiInfo());
        }
        if (isSamePoint(xPPoiInfo, currentExpandedPoint)) {
            if (L.ENABLE) {
                L.Tag tag3 = this.mTag;
                L.d(tag3, "updateFocusedPoint newPoint:" + xPPoiInfo + ",  focusedPoint:" + currentExpandedPoint);
            }
            ArrayList arrayList = new ArrayList(this.mXPPointList);
            arrayList.set(this.mCurrentExpandedPosition, xPPoiInfo);
            updateXPPoiInfoList(arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NonNull
    public XPPointBaseData generateBizPoint(int i, int i2, @NonNull XPPoiInfo xPPoiInfo) {
        return NaviUtil.transformXPPOIToBizPoint(xPPoiInfo);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public DecoratorDataProvider getDataProvider() {
        if (this.mDataProvider == null) {
            this.mDataProvider = new DecoratorDataProvider(new BaseCallBack<DecoratorRequestParam, DecoratorResponseData>() { // from class: com.xiaopeng.montecarlo.mapoverlay.base.BaseDecoratorPresenter.1
                @Override // com.xiaopeng.montecarlo.root.dataprovider.BaseCallBack
                public boolean isLegal() {
                    return true;
                }

                @Override // com.xiaopeng.montecarlo.root.dataprovider.BaseCallBack
                public void onDataFetched(@NonNull DecoratorResponseData decoratorResponseData) {
                    if (BaseDecoratorPresenter.this.mIsRemoved) {
                        return;
                    }
                    if (L.ENABLE) {
                        L.d(BaseDecoratorPresenter.this.mTag, "onDataFetched");
                    }
                    BaseDecoratorPresenter.this.updateFocusedPoint(decoratorResponseData);
                }

                @Override // com.xiaopeng.montecarlo.root.dataprovider.BaseCallBack
                public void onDataCache(@NonNull DecoratorResponseData decoratorResponseData) {
                    if (L.ENABLE) {
                        L.d(BaseDecoratorPresenter.this.mTag, "onDataCache");
                    }
                }

                @Override // com.xiaopeng.montecarlo.root.dataprovider.BaseCallBack
                public void onError(int i, @NonNull String str) {
                    if (L.ENABLE) {
                        L.Tag tag = BaseDecoratorPresenter.this.mTag;
                        L.d(tag, "onError errorCode:" + i + ",errorMessage:" + str);
                    }
                    if (BaseDecoratorPresenter.this.mIsRemoved) {
                        return;
                    }
                    if (i == 600) {
                        BaseDecoratorPresenter.this.mDecoratorCallback.getMainContext().showPrompt(R.string.offline_pop_toast);
                    }
                    BaseDecoratorPresenter.this.mDecoratorCallback.onLoad();
                }

                @Override // com.xiaopeng.montecarlo.root.dataprovider.BaseCallBack
                public void onFetchStart(DecoratorRequestParam decoratorRequestParam) {
                    if (L.ENABLE) {
                        L.d(BaseDecoratorPresenter.this.mTag, "onFetchStart");
                    }
                }

                @Override // com.xiaopeng.montecarlo.root.dataprovider.BaseCallBack
                public void onFetchComplete(DecoratorRequestParam decoratorRequestParam) {
                    if (L.ENABLE) {
                        L.d(BaseDecoratorPresenter.this.mTag, "onFetchComplete");
                    }
                    if (BaseDecoratorPresenter.this.mIsRemoved) {
                        return;
                    }
                    BaseDecoratorPresenter.this.mDecoratorCallback.onLoad();
                }
            });
        }
        return this.mDataProvider;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void refreshPoiInfo(XPPoiInfo xPPoiInfo) {
        if (xPPoiInfo == null) {
            if (L.ENABLE) {
                L.d(this.mTag, "refreshPoiInfo poiInfo：null");
                return;
            }
            return;
        }
        if (L.ENABLE) {
            L.Tag tag = this.mTag;
            L.d(tag, "refreshPoiInfo poiInfo：" + xPPoiInfo.dumpXPPoiInfo());
        }
        if (XPPoiCategory.isCharge(xPPoiInfo.getCategory()) && !XPPoiCategory.isBLCharge(xPPoiInfo.getCategory())) {
            getDataProvider().cpSearchById(xPPoiInfo.getPoiId(), xPPoiInfo.getBlCategory());
        } else if (118 == xPPoiInfo.getCategory() || XPPoiCategory.isBLCarService(xPPoiInfo.getBlCategory())) {
            getDataProvider().carCenterSearchById(xPPoiInfo.getPoiId());
        } else if (NavCoreUtil.isBlValidPoiId(xPPoiInfo)) {
            getDataProvider().keywordPoiSearch(xPPoiInfo);
        }
    }

    public void clearFocus() {
        if (L.ENABLE) {
            L.d(this.mTag, "clearFocus");
        }
        BaseDecoratorCallback baseDecoratorCallback = this.mDecoratorCallback;
        if (baseDecoratorCallback != null) {
            baseDecoratorCallback.onClearFocus(getCurrentExpandedBizPoint());
        }
        this.mCurrentExpandedPosition = -1;
    }

    public void refresh() {
        if (L.ENABLE) {
            L.d(this.mTag, "refresh ");
        }
        BaseDecoratorCallback baseDecoratorCallback = this.mDecoratorCallback;
        if (baseDecoratorCallback != null) {
            ArrayList arrayList = new ArrayList();
            List<XPPointBaseData> list = this.mXPBizPointList;
            baseDecoratorCallback.onPointUpdate(arrayList, list, list);
        }
    }

    @CallSuper
    public void update(Bundle bundle) {
        if (L.ENABLE) {
            L.d(this.mTag, "update");
        }
        if (bundle != null) {
            this.mFavoritePoi = (XPPoiInfo) bundle.getParcelable(BaseMapDecorator.KEY_FAVORITE_POI);
            ArrayList parcelableArrayList = bundle.getParcelableArrayList(BaseMapDecorator.KEY_POI_LIST);
            if (parcelableArrayList != null) {
                if (isExpanded()) {
                    XPPoiInfo currentExpandedPoint = getCurrentExpandedPoint();
                    for (int i = 0; i < parcelableArrayList.size(); i++) {
                        if (isSamePoint(currentExpandedPoint, parcelableArrayList.get(i))) {
                            parcelableArrayList.set(i, currentExpandedPoint);
                            if (L.ENABLE) {
                                L.Tag tag = this.mTag;
                                L.d(tag, "update isSamePoint xpPoiInfo = " + currentExpandedPoint.dumpXPPoiInfo() + " , poiInfoList.get(" + i + ") = " + parcelableArrayList.get(i));
                            }
                        }
                    }
                }
                updateXPPoiInfoList(parcelableArrayList);
            }
        }
    }

    public final void remove() {
        if (L.ENABLE) {
            L.d(this.mTag, "remove");
        }
        if (this.mDecoratorCallback != null) {
            this.mDecoratorCallback = null;
        }
        DecoratorDataProvider decoratorDataProvider = this.mDataProvider;
        if (decoratorDataProvider != null) {
            decoratorDataProvider.setCallback(null);
            this.mDataProvider = null;
        }
        this.mXPPointList.clear();
        this.mXPBizPointList.clear();
        this.mCurrentExpandedPosition = -1;
        this.mIsRemoved = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final XPPoiInfo findPointByBizPoint(XPPointBaseData xPPointBaseData) {
        int findBizPoint = findBizPoint(xPPointBaseData);
        if (findBizPoint > -1 && findBizPoint < this.mXPPointList.size()) {
            return this.mXPPointList.get(findBizPoint);
        }
        L.Tag tag = this.mTag;
        L.e(tag, "findPointByBizPoint can't find point :" + xPPointBaseData + " in " + this.mXPBizPointList.toString());
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final XPPoiInfo findPointByBizPoint(XPPointBaseData xPPointBaseData, List<XPPointBaseData> list, List<XPPoiInfo> list2) {
        int findBizPoint = findBizPoint(list, xPPointBaseData);
        if (findBizPoint > -1 && findBizPoint < list2.size()) {
            return list2.get(findBizPoint);
        }
        L.Tag tag = this.mTag;
        L.e(tag, "findPointByBizPoint can't find point :" + xPPointBaseData + " in " + list2.toString());
        return null;
    }

    public final XPPoiInfo getFavoritePoi() {
        return this.mFavoritePoi;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean isExpanded() {
        int i = this.mCurrentExpandedPosition;
        return i > -1 && i < this.mXPPointList.size() && this.mCurrentExpandedPosition < this.mXPBizPointList.size();
    }

    public final int getCurrentExpandedIndex() {
        return this.mCurrentExpandedPosition;
    }

    public final XPPoiInfo getCurrentExpandedPoint() {
        if (!isExpanded()) {
            if (L.ENABLE) {
                L.d(this.mTag, "getCurrentExpandedPoint = null");
                return null;
            }
            return null;
        }
        return this.mXPPointList.get(this.mCurrentExpandedPosition);
    }

    public final XPPointBaseData getCurrentExpandedBizPoint() {
        if (!isExpanded()) {
            if (L.ENABLE) {
                L.d(this.mTag, "getCurrentExpandedBizPoint = null");
                return null;
            }
            return null;
        }
        return this.mXPBizPointList.get(this.mCurrentExpandedPosition);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void updateXPPoiInfoList(@NonNull List<XPPoiInfo> list) {
        int size = list.size();
        if (L.ENABLE) {
            L.d(this.mTag, "updateXPPoiInfoList.size = " + size);
        }
        XPPointBaseData currentExpandedBizPoint = getCurrentExpandedBizPoint();
        if (L.ENABLE) {
            L.d(this.mTag, "updateXPPoiInfoList oldBizPoint = " + currentExpandedBizPoint);
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < size; i++) {
            XPPoiInfo xPPoiInfo = list.get(i);
            if (xPPoiInfo == null) {
                L.e(this.mTag, "updateXPPoiInfoList poiInfoList.get(i) == null , i = " + i);
                arrayList.add(new XPPointBaseData());
            } else {
                if (L.ENABLE) {
                    L.d(this.mTag, "item[" + i + "] = " + xPPoiInfo.dumpXPPoiInfo());
                }
                arrayList.add(generateBizPoint(size, i, xPPoiInfo));
            }
        }
        int findBizPoint = findBizPoint(arrayList, currentExpandedBizPoint);
        if (L.ENABLE) {
            L.d(this.mTag, "updateXPPoiInfoList oldPosition = " + this.mCurrentExpandedPosition + ", newPosition = " + findBizPoint);
        }
        if (currentExpandedBizPoint != null && findBizPoint == -1) {
            L.e(this.mTag, "updateXPPoiInfoList can't find point :" + currentExpandedBizPoint + " in " + arrayList.toString());
            if (L.ENABLE) {
                L.d(this.mTag, "updateXPPoiInfoList clearFocus");
            }
            this.mDecoratorCallback.getMainContext().getDecoratorManager().clearFocus();
        }
        if (this.mDecoratorCallback != null) {
            List<XPPointBaseData> updatePointList = getUpdatePointList(this.mXPBizPointList, arrayList);
            List<XPPointBaseData> removePointList = getRemovePointList(this.mXPBizPointList, updatePointList);
            List<XPPointBaseData> addPointList = getAddPointList(arrayList, updatePointList);
            this.mCurrentExpandedPosition = findBizPoint;
            this.mXPBizPointList.clear();
            this.mXPBizPointList.addAll(arrayList);
            this.mXPPointList.clear();
            this.mXPPointList.addAll(list);
            this.mDecoratorCallback.onPointUpdate(updatePointList, addPointList, removePointList);
            if (L.ENABLE) {
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    L.d(this.mTag, "newBizPointList[" + i2 + "] = " + arrayList.get(i2));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NonNull
    public List<XPPointBaseData> getUpdatePointList(List<XPPointBaseData> list, List<XPPointBaseData> list2) {
        ArrayList arrayList = new ArrayList(list);
        arrayList.retainAll(list2);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NonNull
    public List<XPPointBaseData> getAddPointList(List<XPPointBaseData> list, List<XPPointBaseData> list2) {
        ArrayList arrayList = new ArrayList(list);
        arrayList.removeAll(list2);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NonNull
    public List<XPPointBaseData> getRemovePointList(List<XPPointBaseData> list, List<XPPointBaseData> list2) {
        ArrayList arrayList = new ArrayList(list);
        arrayList.removeAll(list2);
        return arrayList;
    }

    private int findPoint(XPPoiInfo xPPoiInfo) {
        return findPoint(this.mXPPointList, xPPoiInfo);
    }

    private int findBizPoint(XPPointBaseData xPPointBaseData) {
        return findBizPoint(this.mXPBizPointList, xPPointBaseData);
    }

    private int findPoint(List<XPPoiInfo> list, XPPoiInfo xPPoiInfo) {
        for (int i = 0; i < list.size(); i++) {
            if (isSamePoiId(xPPoiInfo, list.get(i))) {
                return i;
            }
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (isSameCoordinate(xPPoiInfo, list.get(i2))) {
                return i2;
            }
        }
        if (L.ENABLE) {
            L.Tag tag = this.mTag;
            StringBuilder sb = new StringBuilder();
            sb.append("findPoint INVALID_INDEX ");
            sb.append(xPPoiInfo == null ? "null" : xPPoiInfo.dumpXPPoiInfo());
            L.d(tag, sb.toString());
            return -1;
        }
        return -1;
    }

    private int findBizPoint(List<XPPointBaseData> list, XPPointBaseData xPPointBaseData) {
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                if (isSamePoint(xPPointBaseData, list.get(i))) {
                    if (L.ENABLE) {
                        L.Tag tag = this.mTag;
                        L.d(tag, "findBizPoint isSamePoint xpPointBaseData = " + xPPointBaseData + " , bizPointList.get(" + i + ")) = " + list.get(i));
                    }
                    return i;
                }
            }
        }
        if (L.ENABLE) {
            L.Tag tag2 = this.mTag;
            L.d(tag2, "findBizPoint INVALID_INDEX " + xPPointBaseData);
            return -1;
        }
        return -1;
    }

    private boolean isSamePoint(XPPoiInfo xPPoiInfo, XPPoiInfo xPPoiInfo2) {
        return isSamePoiId(xPPoiInfo, xPPoiInfo2) || isSameCoordinate(xPPoiInfo, xPPoiInfo2);
    }

    private boolean isSameCoordinate(XPPoiInfo xPPoiInfo, XPPoiInfo xPPoiInfo2) {
        return xPPoiInfo != null && xPPoiInfo2 != null && RootUtil.compareDouble(xPPoiInfo.getDisplayLat(), xPPoiInfo2.getDisplayLat()) && RootUtil.compareDouble(xPPoiInfo.getDisplayLon(), xPPoiInfo2.getDisplayLon());
    }

    private boolean isSamePoiId(XPPoiInfo xPPoiInfo, XPPoiInfo xPPoiInfo2) {
        if (xPPoiInfo == null || xPPoiInfo2 == null) {
            return false;
        }
        if (118 == xPPoiInfo.getCategory() && 118 == xPPoiInfo2.getCategory()) {
            XPCarServiceInfo xPCarServiceInfo = xPPoiInfo.getXPCarServiceInfo();
            XPCarServiceInfo xPCarServiceInfo2 = xPPoiInfo2.getXPCarServiceInfo();
            if (xPCarServiceInfo != null && !TextUtils.isEmpty(xPCarServiceInfo.getAutoId()) && xPCarServiceInfo2 != null && !TextUtils.isEmpty(xPCarServiceInfo2.getAutoId()) && TextUtils.equals(xPCarServiceInfo.getAutoId(), xPCarServiceInfo2.getAutoId())) {
                if (L.ENABLE) {
                    L.Tag tag = this.mTag;
                    L.d(tag, "isSamePoint xpCarServiceInfo.getAutoId = " + xPCarServiceInfo.getAutoId());
                }
                return true;
            }
        }
        return (TextUtils.isEmpty(xPPoiInfo.getPoiId()) || TextUtils.isEmpty(xPPoiInfo2.getPoiId()) || !TextUtils.equals(xPPoiInfo.getPoiId(), xPPoiInfo2.getPoiId())) ? false : true;
    }

    private boolean isSamePoint(XPPointBaseData xPPointBaseData, XPPointBaseData xPPointBaseData2) {
        if (xPPointBaseData == null || xPPointBaseData2 == null) {
            return false;
        }
        return Objects.equals(xPPointBaseData.id, xPPointBaseData2.id);
    }
}
