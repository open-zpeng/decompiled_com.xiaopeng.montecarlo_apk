package com.autonavi.gbl.user.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.user.group.model.GroupResponseCreate;
import com.autonavi.gbl.user.group.model.GroupResponseDissolve;
import com.autonavi.gbl.user.group.model.GroupResponseFriendList;
import com.autonavi.gbl.user.group.model.GroupResponseInfo;
import com.autonavi.gbl.user.group.model.GroupResponseInvite;
import com.autonavi.gbl.user.group.model.GroupResponseInviteQRUrl;
import com.autonavi.gbl.user.group.model.GroupResponseJoin;
import com.autonavi.gbl.user.group.model.GroupResponseKick;
import com.autonavi.gbl.user.group.model.GroupResponseQuit;
import com.autonavi.gbl.user.group.model.GroupResponseSetNickName;
import com.autonavi.gbl.user.group.model.GroupResponseStatus;
import com.autonavi.gbl.user.group.model.GroupResponseUpdate;
import com.autonavi.gbl.user.group.model.GroupResponseUrlTranslate;
import com.autonavi.gbl.user.group.observer.IGroupServiceObserver;
import com.autonavi.gbl.user.group.observer.impl.IGroupServiceObserverImpl;
@IntfAuto(target = IGroupServiceObserver.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class GroupServiceObserverRouter extends IGroupServiceObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(GroupServiceObserverRouter.class);
    private static String PACKAGE = ReflexTool.PN(GroupServiceObserverRouter.class);
    private TypeHelper mHelper;
    private IGroupServiceObserver mObserver;
    private String mTargetId;

    private void $constructor(String str, IGroupServiceObserver iGroupServiceObserver) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(IGroupServiceObserverImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iGroupServiceObserver;
    }

    protected GroupServiceObserverRouter(String str, IGroupServiceObserver iGroupServiceObserver, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iGroupServiceObserver);
    }

    protected GroupServiceObserverRouter(String str, IGroupServiceObserver iGroupServiceObserver) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iGroupServiceObserver);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.user.group.observer.impl.IGroupServiceObserverImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.user.group.observer.impl.IGroupServiceObserverImpl
    public void onNotify(int i, long j, GroupResponseStatus groupResponseStatus) {
        IGroupServiceObserver iGroupServiceObserver = this.mObserver;
        if (iGroupServiceObserver != null) {
            iGroupServiceObserver.onNotify(i, j, groupResponseStatus);
        }
    }

    @Override // com.autonavi.gbl.user.group.observer.impl.IGroupServiceObserverImpl
    public void onNotify(int i, long j, GroupResponseCreate groupResponseCreate) {
        IGroupServiceObserver iGroupServiceObserver = this.mObserver;
        if (iGroupServiceObserver != null) {
            iGroupServiceObserver.onNotify(i, j, groupResponseCreate);
        }
    }

    @Override // com.autonavi.gbl.user.group.observer.impl.IGroupServiceObserverImpl
    public void onNotify(int i, long j, GroupResponseDissolve groupResponseDissolve) {
        IGroupServiceObserver iGroupServiceObserver = this.mObserver;
        if (iGroupServiceObserver != null) {
            iGroupServiceObserver.onNotify(i, j, groupResponseDissolve);
        }
    }

    @Override // com.autonavi.gbl.user.group.observer.impl.IGroupServiceObserverImpl
    public void onNotify(int i, long j, GroupResponseJoin groupResponseJoin) {
        IGroupServiceObserver iGroupServiceObserver = this.mObserver;
        if (iGroupServiceObserver != null) {
            iGroupServiceObserver.onNotify(i, j, groupResponseJoin);
        }
    }

    @Override // com.autonavi.gbl.user.group.observer.impl.IGroupServiceObserverImpl
    public void onNotify(int i, long j, GroupResponseQuit groupResponseQuit) {
        IGroupServiceObserver iGroupServiceObserver = this.mObserver;
        if (iGroupServiceObserver != null) {
            iGroupServiceObserver.onNotify(i, j, groupResponseQuit);
        }
    }

    @Override // com.autonavi.gbl.user.group.observer.impl.IGroupServiceObserverImpl
    public void onNotify(int i, long j, GroupResponseInvite groupResponseInvite) {
        IGroupServiceObserver iGroupServiceObserver = this.mObserver;
        if (iGroupServiceObserver != null) {
            iGroupServiceObserver.onNotify(i, j, groupResponseInvite);
        }
    }

    @Override // com.autonavi.gbl.user.group.observer.impl.IGroupServiceObserverImpl
    public void onNotify(int i, long j, GroupResponseKick groupResponseKick) {
        IGroupServiceObserver iGroupServiceObserver = this.mObserver;
        if (iGroupServiceObserver != null) {
            iGroupServiceObserver.onNotify(i, j, groupResponseKick);
        }
    }

    @Override // com.autonavi.gbl.user.group.observer.impl.IGroupServiceObserverImpl
    public void onNotify(int i, long j, GroupResponseInfo groupResponseInfo) {
        IGroupServiceObserver iGroupServiceObserver = this.mObserver;
        if (iGroupServiceObserver != null) {
            iGroupServiceObserver.onNotify(i, j, groupResponseInfo);
        }
    }

    @Override // com.autonavi.gbl.user.group.observer.impl.IGroupServiceObserverImpl
    public void onNotify(int i, long j, GroupResponseUpdate groupResponseUpdate) {
        IGroupServiceObserver iGroupServiceObserver = this.mObserver;
        if (iGroupServiceObserver != null) {
            iGroupServiceObserver.onNotify(i, j, groupResponseUpdate);
        }
    }

    @Override // com.autonavi.gbl.user.group.observer.impl.IGroupServiceObserverImpl
    public void onNotify(int i, long j, GroupResponseSetNickName groupResponseSetNickName) {
        IGroupServiceObserver iGroupServiceObserver = this.mObserver;
        if (iGroupServiceObserver != null) {
            iGroupServiceObserver.onNotify(i, j, groupResponseSetNickName);
        }
    }

    @Override // com.autonavi.gbl.user.group.observer.impl.IGroupServiceObserverImpl
    public void onNotify(int i, long j, GroupResponseFriendList groupResponseFriendList) {
        IGroupServiceObserver iGroupServiceObserver = this.mObserver;
        if (iGroupServiceObserver != null) {
            iGroupServiceObserver.onNotify(i, j, groupResponseFriendList);
        }
    }

    @Override // com.autonavi.gbl.user.group.observer.impl.IGroupServiceObserverImpl
    public void onNotify(int i, long j, GroupResponseInviteQRUrl groupResponseInviteQRUrl) {
        IGroupServiceObserver iGroupServiceObserver = this.mObserver;
        if (iGroupServiceObserver != null) {
            iGroupServiceObserver.onNotify(i, j, groupResponseInviteQRUrl);
        }
    }

    @Override // com.autonavi.gbl.user.group.observer.impl.IGroupServiceObserverImpl
    public void onNotify(int i, long j, GroupResponseUrlTranslate groupResponseUrlTranslate) {
        IGroupServiceObserver iGroupServiceObserver = this.mObserver;
        if (iGroupServiceObserver != null) {
            iGroupServiceObserver.onNotify(i, j, groupResponseUrlTranslate);
        }
    }
}
