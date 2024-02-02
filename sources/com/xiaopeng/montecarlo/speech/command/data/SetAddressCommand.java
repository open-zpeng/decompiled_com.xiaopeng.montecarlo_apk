package com.xiaopeng.montecarlo.speech.command.data;

import com.xiaopeng.montecarlo.navcore.bean.favorite.FavoriteAddress;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import com.xiaopeng.montecarlo.navcore.event.SpeechNaviEvent;
import com.xiaopeng.montecarlo.navcore.favorite.FavoriteDataManager;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.speech.command.BaseSpeechCommand;
import com.xiaopeng.montecarlo.speech.command.CommandPriority;
import com.xiaopeng.speech.protocol.node.navi.bean.PoiBean;
@CommandPriority(priority = 40)
/* loaded from: classes3.dex */
public class SetAddressCommand extends BaseSpeechCommand {
    private static final L.Tag TAG = new L.Tag("SetAddressCommand");
    private boolean mIsExecute = false;
    private PoiBean mPoiBean;
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

    public SetAddressCommand(AddressType addressType, PoiBean poiBean) {
        this.mType = addressType;
        this.mPoiBean = poiBean;
    }

    @Override // com.xiaopeng.montecarlo.speech.command.BaseSpeechCommand, com.xiaopeng.montecarlo.speech.command.ICommandRecorder
    public void doSomething() {
        if (AddressType.HOME == this.mType) {
            setHome();
        } else if (AddressType.COMPANY == this.mType) {
            setCompany();
        } else {
            L.Tag tag = TAG;
            L.i(tag, "type error:" + this.mType);
            this.mIsExecute = true;
            return;
        }
        executeSpeechEvent(new SpeechNaviEvent(108));
        SpeechNaviEvent speechNaviEvent = new SpeechNaviEvent(903);
        speechNaviEvent.setPoiBean(this.mPoiBean);
        executeSpeechEvent(speechNaviEvent);
        this.mIsExecute = true;
    }

    private void setHome() {
        FavoriteDataManager.getInstance().setHome(new FavoriteAddress(new XPPoiInfo(this.mPoiBean)));
    }

    private void setCompany() {
        FavoriteDataManager.getInstance().setCompany(new FavoriteAddress(new XPPoiInfo(this.mPoiBean)));
    }

    @Override // com.xiaopeng.montecarlo.speech.command.BaseSpeechCommand, com.xiaopeng.montecarlo.speech.command.ICommandRecorder
    public boolean isAchieveGoals() {
        return this.mIsExecute;
    }
}
