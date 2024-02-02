package com.xiaopeng.montecarlo.scenes.restrictscene;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.data.model.CityItemInfo;
import com.autonavi.gbl.layer.model.BizRouteRestrictInfo;
import com.xiaopeng.montecarlo.base.scene.BasePresenter;
import com.xiaopeng.montecarlo.navcore.bean.restrict.XPGReStrictedAreaDataRuleRes;
import com.xiaopeng.montecarlo.navcore.bean.restrict.XPGRestrictRule;
import com.xiaopeng.montecarlo.navcore.download.MapDataManager;
import com.xiaopeng.montecarlo.navcore.event.SpeechNaviEvent;
import com.xiaopeng.montecarlo.navcore.state.IStateListener;
import com.xiaopeng.montecarlo.navcore.state.StateManager;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.UiHandlerUtil;
import com.xiaopeng.montecarlo.scenes.restrictscene.IRestrictContract;
import com.xiaopeng.montecarlo.speech.command.ICommandCallback;
import com.xiaopeng.montecarlo.stat.RestrictStatUtil;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class RestrictScenePresenter extends BasePresenter implements IRestrictContract.Presenter, IStateListener {
    private static final L.Tag TAG = new L.Tag("RestrictFragmentPresenter");
    private IRestrictContract.LogicView mLogicView;
    XPGReStrictedAreaDataRuleRes mDataRule = null;
    private String mStartCityName = null;
    private String mEndCityName = null;

    public RestrictScenePresenter(IRestrictContract.LogicView logicView) {
        this.mLogicView = logicView;
        IRestrictContract.LogicView logicView2 = this.mLogicView;
        if (logicView2 != null) {
            logicView2.setPresenter(this);
        }
    }

    @Override // com.xiaopeng.montecarlo.base.scene.BasePresenter, com.xiaopeng.montecarlo.base.scene.AbstractBasePresenter, com.xiaopeng.montecarlo.base.IBasePresenter
    public void onResume() {
        super.onResume();
        StateManager.getInstance().addListener(this);
        StateManager.getInstance().switchActiveState();
        StateManager.getInstance().start(0, 10000);
        RestrictStatUtil.sendStatDataWhenRestrict();
    }

    @Override // com.xiaopeng.montecarlo.base.scene.BasePresenter, com.xiaopeng.montecarlo.base.scene.AbstractBasePresenter, com.xiaopeng.montecarlo.base.IBasePresenter
    public void onPause() {
        super.onPause();
        StateManager.getInstance().removeListener(this);
    }

    @Override // com.xiaopeng.montecarlo.base.scene.BasePresenter, com.xiaopeng.montecarlo.base.scene.AbstractBasePresenter, com.xiaopeng.montecarlo.base.IBasePresenter
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.xiaopeng.montecarlo.base.scene.BasePresenter, com.xiaopeng.montecarlo.base.scene.AbstractBasePresenter, com.xiaopeng.montecarlo.base.IBasePresenter
    public void show() {
        super.show();
    }

    @Override // com.xiaopeng.montecarlo.base.scene.BasePresenter, com.xiaopeng.montecarlo.base.scene.AbstractBasePresenter, com.xiaopeng.montecarlo.base.IBasePresenter
    public void hide() {
        super.hide();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onInitView(XPGReStrictedAreaDataRuleRes xPGReStrictedAreaDataRuleRes, final int i, final int i2) {
        this.mLogicView.bindView();
        this.mDataRule = xPGReStrictedAreaDataRuleRes;
        this.mLogicView.showRestrictedDetail(this.mDataRule.mCities);
        UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.restrictscene.RestrictScenePresenter.1
            @Override // java.lang.Runnable
            public void run() {
                RestrictScenePresenter.this.drawRestrictedAreaRules(i, i2);
            }
        });
        this.mLogicView.onInitView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void drawRestrictedAreaRules(int i, int i2) {
        if ((checkIsLegal() || this.mDataRule == null) && i >= 0 && i <= this.mDataRule.mCities.size() && i2 >= 0 && i2 <= this.mDataRule.mCities.get(i).mRules.size()) {
            handleRuleInInternel(this.mDataRule.mCities.get(i).mRules.get(i2));
        }
    }

    private void handleRuleInInternel(@NonNull XPGRestrictRule xPGRestrictRule) {
        if (L.ENABLE) {
            L.d(TAG, "handleRuleInInternel startTime=" + System.currentTimeMillis());
        }
        this.mLogicView.preDrawRestrict(xPGRestrictRule.mBound, true);
        int size = xPGRestrictRule.mAreapoints == null ? 0 : xPGRestrictRule.mAreapoints.size();
        int size2 = xPGRestrictRule.mLinepoints == null ? 0 : xPGRestrictRule.mLinepoints.size();
        if (L.ENABLE) {
            L.d(TAG, " handleRuleInInternel areaSize=" + size + " lineSize=" + size2);
        }
        if (size > 0) {
            for (int i = 0; i < size; i++) {
                BizRouteRestrictInfo bizRouteRestrictInfo = new BizRouteRestrictInfo();
                bizRouteRestrictInfo.polygonPoints.addAll(xPGRestrictRule.toBLCoord3DDoubleArrayList(xPGRestrictRule.mAreapoints.get(i)));
                bizRouteRestrictInfo.isDrawPolygonRim = true;
                this.mLogicView.drawRules(bizRouteRestrictInfo);
                if (L.ENABLE) {
                    L.d(TAG, "handleRuleInInternel draw lines & areas areaIndex = " + i);
                }
            }
        }
        if (size2 > 0) {
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < size2; i2++) {
                ArrayList<Coord3DDouble> bLCoord3DDoubleArrayList = xPGRestrictRule.toBLCoord3DDoubleArrayList(xPGRestrictRule.mLinepoints.get(i2));
                if (CollectionUtils.isNotEmpty(bLCoord3DDoubleArrayList)) {
                    arrayList.add(bLCoord3DDoubleArrayList);
                }
            }
            BizRouteRestrictInfo bizRouteRestrictInfo2 = new BizRouteRestrictInfo();
            bizRouteRestrictInfo2.lineInfos.addAll(arrayList);
            bizRouteRestrictInfo2.isDrawPolygonRim = true;
            this.mLogicView.drawRules(bizRouteRestrictInfo2);
            if (L.ENABLE) {
                L.d(TAG, "handleRuleInInternel only draw lines allPointLines.size = " + arrayList.size());
            }
        }
        if (L.ENABLE) {
            L.d(TAG, "handleRuleInInternel endTime=" + System.currentTimeMillis());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public short getCityType(String str) {
        int endCityCode;
        CityItemInfo cityInfo;
        int startCityCode;
        CityItemInfo cityInfo2;
        if (TextUtils.isEmpty(str)) {
            return (short) 0;
        }
        if (TextUtils.isEmpty(this.mStartCityName) && (startCityCode = RestrictManager.getInstance().getStartCityCode()) != -1 && (cityInfo2 = MapDataManager.getInstance().getCityInfo(startCityCode)) != null) {
            this.mStartCityName = cityInfo2.cityName;
        }
        if (TextUtils.isEmpty(this.mEndCityName) && (endCityCode = RestrictManager.getInstance().getEndCityCode()) != -1 && (cityInfo = MapDataManager.getInstance().getCityInfo(endCityCode)) != null) {
            this.mEndCityName = cityInfo.cityName;
        }
        if (TextUtils.isEmpty(this.mStartCityName) || TextUtils.isEmpty(this.mEndCityName)) {
            return (short) 0;
        }
        if (str.equals(this.mStartCityName)) {
            return (short) 1;
        }
        return str.equals(this.mEndCityName) ? (short) 2 : (short) 3;
    }

    private boolean checkIsLegal() {
        IRestrictContract.LogicView logicView = this.mLogicView;
        return logicView != null && logicView.isSceneLegal();
    }

    @Override // com.xiaopeng.montecarlo.navcore.state.IStateListener
    public void onStateChange(int i) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "onStateChange:" + i);
        }
        if (1 == i) {
            this.mLogicView.exitRestrictScene();
        }
    }

    @Override // com.xiaopeng.montecarlo.base.scene.AbstractBasePresenter, com.xiaopeng.montecarlo.speech.command.ISpeechEvent
    public boolean onSpeechEvent(SpeechNaviEvent speechNaviEvent, ICommandCallback iCommandCallback) {
        int i = speechNaviEvent.what;
        if (i != 312) {
            switch (i) {
                case 407:
                    L.i(TAG, "SPEECH_MAP_MODE_NORTH_UP");
                    this.mLogicView.getSpeechEventBizHelper().setMapModeNorthUpNotSupported(iCommandCallback);
                    return true;
                case SpeechNaviEvent.SPEECH_MAP_MODE_HEAD_UP_2D /* 408 */:
                    L.i(TAG, "SPEECH_MAP_MODE_HEAD_UP_2D");
                    this.mLogicView.getSpeechEventBizHelper().setMapModeHeadUp2DNotSupported(iCommandCallback);
                    return true;
                case SpeechNaviEvent.SPEECH_MAP_MODE_HEAD_UP_3D /* 409 */:
                    L.i(TAG, "SPEECH_MAP_MODE_HEAD_UP_3D");
                    this.mLogicView.getSpeechEventBizHelper().setMapModeHeadUp3DNotSupported(iCommandCallback);
                    return true;
            }
        }
        L.Tag tag = TAG;
        L.i(tag, "SPEECH_ROUTE_NEW_DEST_WITH_VIAS, isSceneVisible:" + this.mLogicView.isSceneLegal());
        if (this.mLogicView.isSceneLegal()) {
            this.mLogicView.getSpeechEventBizHelper().routeNewDestWithVias(this.mLogicView.getMainContext().getCurrentScene(), speechNaviEvent);
            return true;
        }
        return false;
    }
}
