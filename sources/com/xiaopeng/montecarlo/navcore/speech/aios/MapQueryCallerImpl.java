package com.xiaopeng.montecarlo.navcore.speech.aios;

import android.text.TextUtils;
import com.autonavi.gbl.pos.model.LocParallelRoadInfo;
import com.xiaopeng.montecarlo.navcore.setting.SettingWrapper;
import com.xiaopeng.montecarlo.navcore.speech.request.SpeechRequestFactory;
import com.xiaopeng.montecarlo.navcore.xptbt.TBTManager;
import com.xiaopeng.montecarlo.root.carfeature.CarFeatureManager;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.speech.protocol.node.navi.bean.AddressBean;
import com.xiaopeng.speech.protocol.node.navi.bean.PoiBean;
import com.xiaopeng.speech.protocol.query.navi.IMapQueryCaller;
/* loaded from: classes3.dex */
public class MapQueryCallerImpl implements IMapQueryCaller {
    private static final L.Tag TAG = new L.Tag("NaviModel_MapQueryCallerImpl");
    private NaviModel mNaviModel;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MapQueryCallerImpl(NaviModel naviModel) {
        this.mNaviModel = naviModel;
    }

    @Override // com.xiaopeng.speech.protocol.query.navi.IMapQueryCaller
    public boolean isCruise() {
        Object postRequestForResult = SpeechRequestFactory.getInstance().postRequestForResult(10002);
        L.Tag tag = TAG;
        L.i(tag, "isCruise " + postRequestForResult);
        if (postRequestForResult == null || !(postRequestForResult instanceof Boolean)) {
            return false;
        }
        return ((Boolean) postRequestForResult).booleanValue();
    }

    @Override // com.xiaopeng.speech.protocol.query.navi.IMapQueryCaller
    public boolean isExplorePath() {
        Object postRequestForResult = SpeechRequestFactory.getInstance().postRequestForResult(10003);
        L.Tag tag = TAG;
        L.i(tag, "isExplorePath " + postRequestForResult);
        if (postRequestForResult == null || !(postRequestForResult instanceof Boolean)) {
            return false;
        }
        return ((Boolean) postRequestForResult).booleanValue();
    }

    @Override // com.xiaopeng.speech.protocol.query.navi.IMapQueryCaller
    public boolean isNavigation() {
        Object postRequestForResult = SpeechRequestFactory.getInstance().postRequestForResult(10001);
        L.Tag tag = TAG;
        L.i(tag, "isNavigation " + postRequestForResult);
        if (postRequestForResult == null || !(postRequestForResult instanceof Boolean)) {
            return false;
        }
        return ((Boolean) postRequestForResult).booleanValue();
    }

    @Override // com.xiaopeng.speech.protocol.query.navi.IMapQueryCaller
    public boolean isSRMap() {
        Object postRequestForResult = SpeechRequestFactory.getInstance().postRequestForResult(10015);
        L.Tag tag = TAG;
        L.i(tag, "isSRMap: " + postRequestForResult);
        if (postRequestForResult instanceof Boolean) {
            return ((Boolean) postRequestForResult).booleanValue();
        }
        return false;
    }

    @Override // com.xiaopeng.speech.protocol.query.navi.IMapQueryCaller
    public boolean isCalculatePath() {
        Object postRequestForResult = SpeechRequestFactory.getInstance().postRequestForResult(10004);
        L.Tag tag = TAG;
        L.i(tag, "isCalculatePath " + postRequestForResult);
        if (postRequestForResult == null || !(postRequestForResult instanceof Boolean)) {
            return false;
        }
        return ((Boolean) postRequestForResult).booleanValue();
    }

    @Override // com.xiaopeng.speech.protocol.query.navi.IMapQueryCaller
    public int getFavoriteOpenStatus() {
        boolean isEmpty = TextUtils.isEmpty(SettingWrapper.getAccountUId());
        L.Tag tag = TAG;
        L.i(tag, "getFavoriteOpenStatus flag:" + (isEmpty ? 1 : 0));
        return isEmpty ? 1 : 0;
    }

    @Override // com.xiaopeng.speech.protocol.query.navi.IMapQueryCaller
    public int getOpenControlStatus() {
        boolean isEmpty = TextUtils.isEmpty(SettingWrapper.getLicensePlate());
        L.Tag tag = TAG;
        L.i(tag, "getOpenControlStatus flag:" + (isEmpty ? 1 : 0));
        return isEmpty ? 1 : 0;
    }

    @Override // com.xiaopeng.speech.protocol.query.navi.IMapQueryCaller
    public int getSwitchMainRoadStatus() {
        int i;
        LocParallelRoadInfo locParallelRoadInfo = TBTManager.getInstance().getPosServiceWrapper().getLocParallelRoadInfo();
        if (locParallelRoadInfo != null) {
            i = 1;
            if (1 == locParallelRoadInfo.flag) {
                i = 0;
            }
        } else {
            i = -1;
        }
        L.Tag tag = TAG;
        L.i(tag, "getSwitchMainRoadStatus flag:" + i);
        return i;
    }

    @Override // com.xiaopeng.speech.protocol.query.navi.IMapQueryCaller
    public int getSwitchSideRoadStatus() {
        int i;
        LocParallelRoadInfo locParallelRoadInfo = TBTManager.getInstance().getPosServiceWrapper().getLocParallelRoadInfo();
        if (locParallelRoadInfo != null) {
            i = 1;
            if (1 != locParallelRoadInfo.flag) {
                i = 0;
            }
        } else {
            i = -1;
        }
        L.Tag tag = TAG;
        L.i(tag, "getSwitchSideRoadStatus flag:" + i);
        return i;
    }

    @Override // com.xiaopeng.speech.protocol.query.navi.IMapQueryCaller
    public String getCommonAddress(AddressBean addressBean) {
        String addressType = addressBean.getAddressType();
        L.Tag tag = TAG;
        L.i(tag, "onAddressGet getCommonAddress: " + addressType);
        Object postRequestForResult = SpeechRequestFactory.getInstance().postRequestForResult(10008, addressType);
        L.Tag tag2 = TAG;
        L.i(tag2, "getCommonAddress: " + postRequestForResult);
        if (postRequestForResult == null || !(postRequestForResult instanceof String)) {
            return null;
        }
        return (String) postRequestForResult;
    }

    @Override // com.xiaopeng.speech.protocol.query.navi.IMapQueryCaller
    public String getNavigationInfo() {
        Object postRequestForResult = SpeechRequestFactory.getInstance().postRequestForResult(10007);
        L.Tag tag = TAG;
        L.i(tag, "getNavigationInfo " + postRequestForResult);
        if (postRequestForResult == null || !(postRequestForResult instanceof String)) {
            return null;
        }
        return (String) postRequestForResult;
    }

    @Override // com.xiaopeng.speech.protocol.query.navi.IMapQueryCaller
    public boolean isZoominMax() {
        Object postRequestForResult = SpeechRequestFactory.getInstance().postRequestForResult(10005);
        L.Tag tag = TAG;
        L.i(tag, "isZoomInMax " + postRequestForResult);
        if (postRequestForResult == null || !(postRequestForResult instanceof Boolean)) {
            return false;
        }
        return ((Boolean) postRequestForResult).booleanValue();
    }

    @Override // com.xiaopeng.speech.protocol.query.navi.IMapQueryCaller
    public boolean isZoomoutMin() {
        Object postRequestForResult = SpeechRequestFactory.getInstance().postRequestForResult(10006);
        L.Tag tag = TAG;
        L.i(tag, "isZoomoutMin " + postRequestForResult);
        if (postRequestForResult == null || !(postRequestForResult instanceof Boolean)) {
            return false;
        }
        return ((Boolean) postRequestForResult).booleanValue();
    }

    @Override // com.xiaopeng.speech.protocol.query.navi.IMapQueryCaller
    public int getCurrentScaleLevel() {
        if (CarFeatureManager.INSTANCE.isVoiceControlNaviScaleLevle()) {
            Object postRequestForResult = SpeechRequestFactory.getInstance().postRequestForResult(10014);
            L.Tag tag = TAG;
            L.i(tag, "getCurrentScaleLevel " + postRequestForResult);
            if (postRequestForResult == null || !(postRequestForResult instanceof Integer)) {
                return -1000;
            }
            return ((Integer) postRequestForResult).intValue();
        }
        L.i(TAG, "Current car type doesn't support getCurrentScaleLevel");
        return -1000;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void postAddressGetResult(boolean z, boolean z2, PoiBean poiBean) {
        this.mNaviModel.getNaviNode().postAddressGetResult(z, z2, poiBean);
    }
}
