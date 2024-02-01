package com.xiaopeng.montecarlo.scenes.popdialogscene;

import com.xiaopeng.montecarlo.aimessage.AiMsgManager;
import com.xiaopeng.montecarlo.base.IBasePresenter;
import com.xiaopeng.montecarlo.base.IMapLogicView;
/* loaded from: classes3.dex */
public interface IPopDialogContract {

    /* loaded from: classes3.dex */
    public interface LogicView extends IMapLogicView<PopDialogPresenter> {
        void dialWithBT(AiMsgManager aiMsgManager, String str);

        void exit();

        void fillContent();
    }

    /* loaded from: classes3.dex */
    public interface Presenter extends IBasePresenter {
        void onInitView(int i, Object obj);
    }
}
