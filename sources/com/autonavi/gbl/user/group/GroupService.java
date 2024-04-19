package com.autonavi.gbl.user.group;

import android.util.Log;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.servicemanager.IService;
import com.autonavi.gbl.user.group.impl.IGroupServiceImpl;
import com.autonavi.gbl.user.group.model.GroupRequestCreate;
import com.autonavi.gbl.user.group.model.GroupRequestDissolve;
import com.autonavi.gbl.user.group.model.GroupRequestFriendList;
import com.autonavi.gbl.user.group.model.GroupRequestInfo;
import com.autonavi.gbl.user.group.model.GroupRequestInvite;
import com.autonavi.gbl.user.group.model.GroupRequestInviteQRUrl;
import com.autonavi.gbl.user.group.model.GroupRequestJoin;
import com.autonavi.gbl.user.group.model.GroupRequestKick;
import com.autonavi.gbl.user.group.model.GroupRequestQuit;
import com.autonavi.gbl.user.group.model.GroupRequestSetNickName;
import com.autonavi.gbl.user.group.model.GroupRequestStatus;
import com.autonavi.gbl.user.group.model.GroupRequestUpdate;
import com.autonavi.gbl.user.group.model.GroupRequestUrlTranslate;
import com.autonavi.gbl.user.group.observer.IGroupServiceObserver;
import com.autonavi.gbl.user.group.observer.impl.IGroupServiceObserverImpl;
import com.autonavi.gbl.util.model.ErrorCode;
import com.autonavi.gbl.util.model.ServiceInitStatus;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Iterator;
@IntfAuto(target = IGroupServiceImpl.class, type = BuildType.JCTRL)
/* loaded from: classes2.dex */
public class GroupService implements IService {
    private static String PACKAGE = ReflexTool.PN(GroupService.class);
    private IGroupServiceImpl mControl;
    private boolean mHasDestroy;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected GroupService(long j, boolean z) {
        this((IGroupServiceImpl) ReflexTool.invokeDeclConstructorSafe(IGroupServiceImpl.class, new Class[]{Long.TYPE, Boolean.TYPE}, new Object[]{Long.valueOf(j), Boolean.valueOf(z)}));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(GroupService.class, this, this.mControl);
        }
    }

    public GroupService(IGroupServiceImpl iGroupServiceImpl) {
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mHasDestroy = false;
        this.mControl = null;
        $constructor(iGroupServiceImpl);
    }

    private void $constructor(IGroupServiceImpl iGroupServiceImpl) {
        if (iGroupServiceImpl != null) {
            this.mControl = iGroupServiceImpl;
            this.mTargetId = String.format("GroupService_%s_%d", String.valueOf(IGroupServiceImpl.getCPtr(this.mControl)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    protected IGroupServiceImpl getControl() {
        return this.mControl;
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public boolean isRecycled() {
        IGroupServiceImpl iGroupServiceImpl = this.mControl;
        if (iGroupServiceImpl != null) {
            return iGroupServiceImpl.isRecycled();
        }
        return true;
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public long getPtr() {
        IGroupServiceImpl iGroupServiceImpl = this.mControl;
        if (iGroupServiceImpl != null) {
            return iGroupServiceImpl.getPtr();
        }
        return 0L;
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public void onCreate() {
        IGroupServiceImpl iGroupServiceImpl = this.mControl;
        if (iGroupServiceImpl != null) {
            iGroupServiceImpl.onCreate();
        }
    }

    @ErrorCode.ErrorCode1
    public int init() {
        IGroupServiceImpl iGroupServiceImpl = this.mControl;
        if (iGroupServiceImpl != null) {
            return iGroupServiceImpl.init();
        }
        return Integer.MIN_VALUE;
    }

    public void unInit() {
        IGroupServiceImpl iGroupServiceImpl = this.mControl;
        if (iGroupServiceImpl != null) {
            iGroupServiceImpl.unInit();
        }
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    @ServiceInitStatus.ServiceInitStatus1
    public int isInit() {
        IGroupServiceImpl iGroupServiceImpl = this.mControl;
        if (iGroupServiceImpl != null) {
            return iGroupServiceImpl.isInit();
        }
        return Integer.MIN_VALUE;
    }

    public String getVersion() {
        IGroupServiceImpl iGroupServiceImpl = this.mControl;
        if (iGroupServiceImpl != null) {
            return iGroupServiceImpl.getVersion();
        }
        return null;
    }

    public int getServiceID() {
        IGroupServiceImpl iGroupServiceImpl = this.mControl;
        if (iGroupServiceImpl != null) {
            return iGroupServiceImpl.getServiceID();
        }
        return 0;
    }

    @ErrorCode.ErrorCode1
    public int addObserver(IGroupServiceObserver iGroupServiceObserver) {
        try {
            Method method = GroupService.class.getMethod("addObserver", IGroupServiceObserver.class);
            if (iGroupServiceObserver != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r2 = typeHelper != null ? (IGroupServiceObserverImpl) typeHelper.transfer(method, 0, iGroupServiceObserver) : null;
                if (r2 == null) {
                    DebugTool.e("%s: $ob == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.user.group.GroupService.1
                    }));
                    return Integer.MIN_VALUE;
                }
            }
            IGroupServiceImpl iGroupServiceImpl = this.mControl;
            if (iGroupServiceImpl != null) {
                return iGroupServiceImpl.addObserver(r2);
            }
            return Integer.MIN_VALUE;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return Integer.MIN_VALUE;
        }
    }

    public void removeObserver(IGroupServiceObserver iGroupServiceObserver) {
        try {
            Method method = GroupService.class.getMethod("removeObserver", IGroupServiceObserver.class);
            if (iGroupServiceObserver != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r1 = typeHelper != null ? (IGroupServiceObserverImpl) typeHelper.transfer(method, 0, iGroupServiceObserver) : null;
                if (r1 == null) {
                    DebugTool.e("%s: $ob == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.user.group.GroupService.2
                    }));
                }
            }
            IGroupServiceImpl iGroupServiceImpl = this.mControl;
            if (iGroupServiceImpl != null) {
                iGroupServiceImpl.removeObserver(r1);
                TypeHelper typeHelper2 = this.mTypeHelper;
                if (typeHelper2 != null) {
                    typeHelper2.unbind(method, 0, iGroupServiceObserver);
                }
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    @ErrorCode.ErrorCode1
    public int executeRequest(GroupRequestStatus groupRequestStatus) {
        IGroupServiceImpl iGroupServiceImpl = this.mControl;
        if (iGroupServiceImpl != null) {
            return iGroupServiceImpl.executeRequest(groupRequestStatus);
        }
        return Integer.MIN_VALUE;
    }

    @ErrorCode.ErrorCode1
    public int executeRequest(GroupRequestCreate groupRequestCreate) {
        IGroupServiceImpl iGroupServiceImpl = this.mControl;
        if (iGroupServiceImpl != null) {
            return iGroupServiceImpl.executeRequest(groupRequestCreate);
        }
        return Integer.MIN_VALUE;
    }

    @ErrorCode.ErrorCode1
    public int executeRequest(GroupRequestDissolve groupRequestDissolve) {
        IGroupServiceImpl iGroupServiceImpl = this.mControl;
        if (iGroupServiceImpl != null) {
            return iGroupServiceImpl.executeRequest(groupRequestDissolve);
        }
        return Integer.MIN_VALUE;
    }

    @ErrorCode.ErrorCode1
    public int executeRequest(GroupRequestJoin groupRequestJoin) {
        IGroupServiceImpl iGroupServiceImpl = this.mControl;
        if (iGroupServiceImpl != null) {
            return iGroupServiceImpl.executeRequest(groupRequestJoin);
        }
        return Integer.MIN_VALUE;
    }

    @ErrorCode.ErrorCode1
    public int executeRequest(GroupRequestQuit groupRequestQuit) {
        IGroupServiceImpl iGroupServiceImpl = this.mControl;
        if (iGroupServiceImpl != null) {
            return iGroupServiceImpl.executeRequest(groupRequestQuit);
        }
        return Integer.MIN_VALUE;
    }

    @ErrorCode.ErrorCode1
    public int executeRequest(GroupRequestInvite groupRequestInvite) {
        IGroupServiceImpl iGroupServiceImpl = this.mControl;
        if (iGroupServiceImpl != null) {
            return iGroupServiceImpl.executeRequest(groupRequestInvite);
        }
        return Integer.MIN_VALUE;
    }

    @ErrorCode.ErrorCode1
    public int executeRequest(GroupRequestKick groupRequestKick) {
        IGroupServiceImpl iGroupServiceImpl = this.mControl;
        if (iGroupServiceImpl != null) {
            return iGroupServiceImpl.executeRequest(groupRequestKick);
        }
        return Integer.MIN_VALUE;
    }

    @ErrorCode.ErrorCode1
    public int executeRequest(GroupRequestInfo groupRequestInfo) {
        IGroupServiceImpl iGroupServiceImpl = this.mControl;
        if (iGroupServiceImpl != null) {
            return iGroupServiceImpl.executeRequest(groupRequestInfo);
        }
        return Integer.MIN_VALUE;
    }

    @ErrorCode.ErrorCode1
    public int executeRequest(GroupRequestUpdate groupRequestUpdate) {
        IGroupServiceImpl iGroupServiceImpl = this.mControl;
        if (iGroupServiceImpl != null) {
            return iGroupServiceImpl.executeRequest(groupRequestUpdate);
        }
        return Integer.MIN_VALUE;
    }

    @ErrorCode.ErrorCode1
    public int executeRequest(GroupRequestSetNickName groupRequestSetNickName) {
        IGroupServiceImpl iGroupServiceImpl = this.mControl;
        if (iGroupServiceImpl != null) {
            return iGroupServiceImpl.executeRequest(groupRequestSetNickName);
        }
        return Integer.MIN_VALUE;
    }

    @ErrorCode.ErrorCode1
    public int executeRequest(GroupRequestFriendList groupRequestFriendList) {
        IGroupServiceImpl iGroupServiceImpl = this.mControl;
        if (iGroupServiceImpl != null) {
            return iGroupServiceImpl.executeRequest(groupRequestFriendList);
        }
        return Integer.MIN_VALUE;
    }

    @ErrorCode.ErrorCode1
    public int executeRequest(GroupRequestInviteQRUrl groupRequestInviteQRUrl) {
        IGroupServiceImpl iGroupServiceImpl = this.mControl;
        if (iGroupServiceImpl != null) {
            return iGroupServiceImpl.executeRequest(groupRequestInviteQRUrl);
        }
        return Integer.MIN_VALUE;
    }

    @ErrorCode.ErrorCode1
    public int executeRequest(GroupRequestUrlTranslate groupRequestUrlTranslate) {
        IGroupServiceImpl iGroupServiceImpl = this.mControl;
        if (iGroupServiceImpl != null) {
            return iGroupServiceImpl.executeRequest(groupRequestUrlTranslate);
        }
        return Integer.MIN_VALUE;
    }

    @ErrorCode.ErrorCode1
    public int abortRequest(long j) {
        IGroupServiceImpl iGroupServiceImpl = this.mControl;
        if (iGroupServiceImpl != null) {
            return iGroupServiceImpl.abortRequest(j);
        }
        return Integer.MIN_VALUE;
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.user.group.GroupService.3
        });
        objArr[1] = String.valueOf(this.mTypeHelper != null);
        DebugTool.d("%s: mTypeHelper=%s", objArr);
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mTypeHelper = null;
        }
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public void onDestroy() {
        this.mHasDestroy = true;
        clean();
    }

    protected void clean() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.user.group.GroupService.4
        }));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            Iterator it = ((HashSet) typeHelper.getBindSet("com.autonavi.gbl.user.group.observer.IGroupServiceObserver")).iterator();
            while (it.hasNext()) {
                removeObserver((IGroupServiceObserver) it.next());
            }
        }
    }

    protected synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.user.group.GroupService.5
        }));
        if (!this.mHasDestroy) {
            onDestroy();
        }
        if (this.mTypeHelper != null) {
            TypeHelper typeHelper = this.mTypeHelper;
            TypeHelper.unbindAllTarget(PACKAGE, this);
        }
        if (this.mControl != null) {
            this.mControl = null;
        }
        unbind();
    }
}
