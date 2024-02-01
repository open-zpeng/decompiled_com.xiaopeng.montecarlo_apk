package com.xiaopeng.montecarlo.speech.command.data;

import com.xiaopeng.montecarlo.navcore.bean.favorite.FavoriteAddress;
import com.xiaopeng.montecarlo.navcore.favorite.FavoriteDataManager;
import com.xiaopeng.montecarlo.navcore.speech.aios.NaviModel;
import com.xiaopeng.montecarlo.navcore.speech.data.SpeechCacheData;
import com.xiaopeng.montecarlo.root.network.XPNetworkManager;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.speech.command.BaseSpeechCommand;
import com.xiaopeng.montecarlo.speech.command.CommandPriority;
import com.xiaopeng.speech.protocol.node.navi.bean.PoiBean;
import com.xiaopeng.speech.protocol.node.navi.bean.StartNaviBean;
@CommandPriority(priority = 41)
/* loaded from: classes3.dex */
public class GetAddressCommand extends BaseSpeechCommand {
    private static final L.Tag TAG = new L.Tag("GetAddressCommand");
    private boolean mIsExecute = false;
    private AddressType mType;

    /* loaded from: classes3.dex */
    public enum AddressType {
        HOME,
        COMPANY
    }

    @Override // com.xiaopeng.montecarlo.speech.command.BaseSpeechCommand, com.xiaopeng.montecarlo.speech.command.ICommandRecorder
    public void onFailed() {
    }

    @Override // com.xiaopeng.montecarlo.speech.command.BaseSpeechCommand, com.xiaopeng.montecarlo.speech.command.ICommandRecorder
    public void onSuccess() {
    }

    public GetAddressCommand(AddressType addressType) {
        this.mType = addressType;
    }

    @Override // com.xiaopeng.montecarlo.speech.command.BaseSpeechCommand, com.xiaopeng.montecarlo.speech.command.ICommandRecorder
    public void doSomething() {
        if (AddressType.HOME == this.mType) {
            getHome();
        } else if (AddressType.COMPANY == this.mType) {
            getCompany();
        }
        this.mIsExecute = true;
    }

    private void getCompany() {
        FavoriteAddress company = FavoriteDataManager.getInstance().getCompany();
        if (company == null) {
            if (XPNetworkManager.INSTANCE.isNetworkConnected()) {
                PoiBean companyFromBigData = SpeechCacheData.getInstance().getCompanyFromBigData();
                NaviModel.getInstance().postAddressGetResult(false, companyFromBigData != null, companyFromBigData);
                return;
            }
            NaviModel.getInstance().postAddressGetResult(false, false, null);
            return;
        }
        PoiBean poiBean = company.toPoiBean();
        L.Tag tag = TAG;
        L.i(tag, "onAddressGet company: " + poiBean);
        new StartNaviBean().setPoiBean(poiBean);
        NaviModel.getInstance().postAddressGetResult(true, false, poiBean);
    }

    private void getHome() {
        FavoriteAddress home = FavoriteDataManager.getInstance().getHome();
        if (home == null) {
            if (XPNetworkManager.INSTANCE.isNetworkConnected()) {
                PoiBean homeFromBigData = SpeechCacheData.getInstance().getHomeFromBigData();
                NaviModel.getInstance().postAddressGetResult(false, homeFromBigData != null, homeFromBigData);
                return;
            }
            NaviModel.getInstance().postAddressGetResult(false, false, null);
            return;
        }
        PoiBean poiBean = home.toPoiBean();
        L.Tag tag = TAG;
        L.i(tag, "onAddressGet home: " + poiBean);
        new StartNaviBean().setPoiBean(poiBean);
        NaviModel.getInstance().postAddressGetResult(true, false, poiBean);
    }

    @Override // com.xiaopeng.montecarlo.speech.command.BaseSpeechCommand, com.xiaopeng.montecarlo.speech.command.ICommandRecorder
    public boolean isAchieveGoals() {
        return this.mIsExecute;
    }
}
