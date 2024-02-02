package com.xiaopeng.montecarlo.views.dialog;

import com.xiaopeng.montecarlo.root.dataprovider.BaseCallBack;
import com.xiaopeng.montecarlo.scenes.linkseamlessnaviscene.dataprovider.params.LinkSeamlessBindAmapParam;
/* loaded from: classes3.dex */
public interface IDialogDataProvider {
    void bindAmap(LinkSeamlessBindAmapParam linkSeamlessBindAmapParam, BaseCallBack baseCallBack);

    void fetchSecBindAMap(BaseCallBack baseCallBack);
}
