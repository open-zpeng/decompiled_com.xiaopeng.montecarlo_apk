package com.autonavi.gbl.consis;

import android.util.Log;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.consis.impl.IChannelMsgSyncControllerImpl;
import com.autonavi.gbl.guide.model.NaviPath;
import com.autonavi.gbl.guide.model.NaviType;
import com.autonavi.gbl.guide.model.impl.NaviPathImpl;
import java.lang.reflect.Method;
@IntfAuto(target = IChannelMsgSyncControllerImpl.class, type = BuildType.JCTRL)
/* loaded from: classes.dex */
public class ChannelMsgSyncController {
    private static String PACKAGE = ReflexTool.PN(ChannelMsgSyncController.class);
    private IChannelMsgSyncControllerImpl mControl;
    private boolean mHasDestroy;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected ChannelMsgSyncController(long j, boolean z) {
        this(new IChannelMsgSyncControllerImpl(j, z));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(ChannelMsgSyncController.class, this, this.mControl);
        }
    }

    public ChannelMsgSyncController(IChannelMsgSyncControllerImpl iChannelMsgSyncControllerImpl) {
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mHasDestroy = false;
        this.mControl = null;
        $constructor(iChannelMsgSyncControllerImpl);
    }

    private void $constructor(IChannelMsgSyncControllerImpl iChannelMsgSyncControllerImpl) {
        if (iChannelMsgSyncControllerImpl != null) {
            this.mControl = iChannelMsgSyncControllerImpl;
            this.mTargetId = String.format("ChannelMsgSyncController_%s_%d", String.valueOf(IChannelMsgSyncControllerImpl.getCPtr(this.mControl)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    protected IChannelMsgSyncControllerImpl getControl() {
        return this.mControl;
    }

    public boolean startNavi(long j, @NaviType.NaviType1 int i, int i2) {
        IChannelMsgSyncControllerImpl iChannelMsgSyncControllerImpl = this.mControl;
        if (iChannelMsgSyncControllerImpl != null) {
            return iChannelMsgSyncControllerImpl.startNavi(j, i, i2);
        }
        return false;
    }

    public boolean stopNavi(long j, int i) {
        IChannelMsgSyncControllerImpl iChannelMsgSyncControllerImpl = this.mControl;
        if (iChannelMsgSyncControllerImpl != null) {
            return iChannelMsgSyncControllerImpl.stopNavi(j, i);
        }
        return false;
    }

    public boolean pauseNavi(long j, int i) {
        IChannelMsgSyncControllerImpl iChannelMsgSyncControllerImpl = this.mControl;
        if (iChannelMsgSyncControllerImpl != null) {
            return iChannelMsgSyncControllerImpl.pauseNavi(j, i);
        }
        return false;
    }

    public boolean resumeNavi(long j, int i) {
        IChannelMsgSyncControllerImpl iChannelMsgSyncControllerImpl = this.mControl;
        if (iChannelMsgSyncControllerImpl != null) {
            return iChannelMsgSyncControllerImpl.resumeNavi(j, i);
        }
        return false;
    }

    public boolean setNaviPath(NaviPath naviPath, long j, int i) {
        try {
            Method method = ChannelMsgSyncController.class.getMethod("setNaviPath", NaviPath.class, Long.TYPE, Integer.TYPE);
            if (naviPath != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r2 = typeHelper != null ? (NaviPathImpl) typeHelper.transfer(method, 0, naviPath) : null;
                if (r2 == null) {
                    DebugTool.e("%s: $naviPath == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.consis.ChannelMsgSyncController.1
                    }));
                    return false;
                }
            }
            IChannelMsgSyncControllerImpl iChannelMsgSyncControllerImpl = this.mControl;
            if (iChannelMsgSyncControllerImpl != null) {
                return iChannelMsgSyncControllerImpl.setNaviPath(r2, j, i);
            }
            return false;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return false;
        }
    }

    public void selectMainPathID(long j, int i) {
        IChannelMsgSyncControllerImpl iChannelMsgSyncControllerImpl = this.mControl;
        if (iChannelMsgSyncControllerImpl != null) {
            iChannelMsgSyncControllerImpl.selectMainPathID(j, i);
        }
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.consis.ChannelMsgSyncController.2
        });
        objArr[1] = String.valueOf(this.mTypeHelper != null);
        DebugTool.d("%s: mTypeHelper=%s", objArr);
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mTypeHelper = null;
        }
    }

    public void onDestroy() {
        this.mHasDestroy = true;
        clean();
    }

    protected void clean() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.consis.ChannelMsgSyncController.3
        }));
    }

    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.consis.ChannelMsgSyncController.4
        }));
        if (!this.mHasDestroy) {
            onDestroy();
        }
        if (this.mTypeHelper != null) {
            TypeHelper typeHelper = this.mTypeHelper;
            TypeHelper.unbindAllTarget(PACKAGE, this);
        }
        if (this.mControl != null) {
            ReflexTool.invokeDeclMethodSafe(this.mControl, RequestParameters.SUBRESOURCE_DELETE, null, null);
            this.mControl = null;
        }
        unbind();
    }
}
