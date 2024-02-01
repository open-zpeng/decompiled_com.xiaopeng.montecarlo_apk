package com.autonavi.gbl.aosclient.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.aosclient.model.GWsTserviceTeamUserFriendsResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackWsTserviceTeamUserFriends;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsTserviceTeamUserFriendsImpl;
@IntfAuto(target = ICallBackWsTserviceTeamUserFriends.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class CallBackWsTserviceTeamUserFriendsRouter extends ICallBackWsTserviceTeamUserFriendsImpl {
    private static BindTable BIND_TABLE = new BindTable(CallBackWsTserviceTeamUserFriendsRouter.class);
    private static String PACKAGE = ReflexTool.PN(CallBackWsTserviceTeamUserFriendsRouter.class);
    private TypeHelper mHelper;
    private ICallBackWsTserviceTeamUserFriends mObserver;
    private String mTargetId;

    private void $constructor(String str, ICallBackWsTserviceTeamUserFriends iCallBackWsTserviceTeamUserFriends) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ICallBackWsTserviceTeamUserFriendsImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iCallBackWsTserviceTeamUserFriends;
    }

    protected CallBackWsTserviceTeamUserFriendsRouter(String str, ICallBackWsTserviceTeamUserFriends iCallBackWsTserviceTeamUserFriends, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsTserviceTeamUserFriends);
    }

    protected CallBackWsTserviceTeamUserFriendsRouter(String str, ICallBackWsTserviceTeamUserFriends iCallBackWsTserviceTeamUserFriends) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsTserviceTeamUserFriends);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsTserviceTeamUserFriendsImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsTserviceTeamUserFriendsImpl
    public void onRecvAck(GWsTserviceTeamUserFriendsResponseParam gWsTserviceTeamUserFriendsResponseParam) {
        ICallBackWsTserviceTeamUserFriends iCallBackWsTserviceTeamUserFriends = this.mObserver;
        if (iCallBackWsTserviceTeamUserFriends != null) {
            iCallBackWsTserviceTeamUserFriends.onRecvAck(gWsTserviceTeamUserFriendsResponseParam);
        }
    }
}
