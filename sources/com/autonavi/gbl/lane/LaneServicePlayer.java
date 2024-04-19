package com.autonavi.gbl.lane;

import android.util.Log;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.lane.impl.ILaneServicePlayerImpl;
import com.autonavi.gbl.lane.observer.ILaneServicePlayerObserver;
import com.autonavi.gbl.lane.observer.impl.ILaneServicePlayerObserverImpl;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Iterator;
@IntfAuto(target = ILaneServicePlayerImpl.class, type = BuildType.JCTRL)
/* loaded from: classes.dex */
public class LaneServicePlayer {
    private static String PACKAGE = ReflexTool.PN(LaneServicePlayer.class);
    private ILaneServicePlayerImpl mControl;
    private boolean mHasDestroy;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected LaneServicePlayer(long j, boolean z) {
        this(new ILaneServicePlayerImpl(j, z));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(LaneServicePlayer.class, this, this.mControl);
        }
    }

    public LaneServicePlayer(ILaneServicePlayerImpl iLaneServicePlayerImpl) {
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mHasDestroy = false;
        this.mControl = null;
        $constructor(iLaneServicePlayerImpl);
    }

    private void $constructor(ILaneServicePlayerImpl iLaneServicePlayerImpl) {
        if (iLaneServicePlayerImpl != null) {
            this.mControl = iLaneServicePlayerImpl;
            this.mTargetId = String.format("LaneServicePlayer_%s_%d", String.valueOf(ILaneServicePlayerImpl.getCPtr(this.mControl)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    protected ILaneServicePlayerImpl getControl() {
        return this.mControl;
    }

    public boolean setPlayerPath(String str, int i) {
        ILaneServicePlayerImpl iLaneServicePlayerImpl = this.mControl;
        if (iLaneServicePlayerImpl != null) {
            return iLaneServicePlayerImpl.setPlayerPath(str, i);
        }
        return false;
    }

    public boolean enableServicePlayerInnerSetX(boolean z) {
        ILaneServicePlayerImpl iLaneServicePlayerImpl = this.mControl;
        if (iLaneServicePlayerImpl != null) {
            return iLaneServicePlayerImpl.enableServicePlayerInnerSetX(z);
        }
        return false;
    }

    public boolean enableUsePlayerResource(boolean z) {
        ILaneServicePlayerImpl iLaneServicePlayerImpl = this.mControl;
        if (iLaneServicePlayerImpl != null) {
            return iLaneServicePlayerImpl.enableUsePlayerResource(z);
        }
        return false;
    }

    public boolean enableRepeatPlay(boolean z) {
        ILaneServicePlayerImpl iLaneServicePlayerImpl = this.mControl;
        if (iLaneServicePlayerImpl != null) {
            return iLaneServicePlayerImpl.enableRepeatPlay(z);
        }
        return false;
    }

    public boolean setPlayIndex(long j) {
        ILaneServicePlayerImpl iLaneServicePlayerImpl = this.mControl;
        if (iLaneServicePlayerImpl != null) {
            return iLaneServicePlayerImpl.setPlayIndex(j);
        }
        return false;
    }

    public boolean setPlaySpeed(float f) {
        ILaneServicePlayerImpl iLaneServicePlayerImpl = this.mControl;
        if (iLaneServicePlayerImpl != null) {
            return iLaneServicePlayerImpl.setPlaySpeed(f);
        }
        return false;
    }

    public boolean registerServicePlayer(ILaneServicePlayerObserver iLaneServicePlayerObserver) {
        try {
            Method method = LaneServicePlayer.class.getMethod("registerServicePlayer", ILaneServicePlayerObserver.class);
            if (iLaneServicePlayerObserver != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r2 = typeHelper != null ? (ILaneServicePlayerObserverImpl) typeHelper.transfer(method, 0, iLaneServicePlayerObserver) : null;
                if (r2 == null) {
                    DebugTool.e("%s: $pObserver == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.lane.LaneServicePlayer.1
                    }));
                    return false;
                }
            }
            ILaneServicePlayerImpl iLaneServicePlayerImpl = this.mControl;
            if (iLaneServicePlayerImpl != null) {
                return iLaneServicePlayerImpl.registerServicePlayer(r2);
            }
            return false;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return false;
        }
    }

    public boolean unRegisterServicePlayer(ILaneServicePlayerObserver iLaneServicePlayerObserver) {
        try {
            Method method = LaneServicePlayer.class.getMethod("unRegisterServicePlayer", ILaneServicePlayerObserver.class);
            if (iLaneServicePlayerObserver != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r2 = typeHelper != null ? (ILaneServicePlayerObserverImpl) typeHelper.transfer(method, 0, iLaneServicePlayerObserver) : null;
                if (r2 == null) {
                    DebugTool.e("%s: $pObserver == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.lane.LaneServicePlayer.2
                    }));
                    return false;
                }
            }
            ILaneServicePlayerImpl iLaneServicePlayerImpl = this.mControl;
            if (iLaneServicePlayerImpl != null) {
                boolean unRegisterServicePlayer = iLaneServicePlayerImpl.unRegisterServicePlayer(r2);
                TypeHelper typeHelper2 = this.mTypeHelper;
                if (typeHelper2 != null) {
                    typeHelper2.unbind(method, 0, iLaneServicePlayerObserver);
                }
                return unRegisterServicePlayer;
            }
            return false;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return false;
        }
    }

    public boolean startPlay() {
        ILaneServicePlayerImpl iLaneServicePlayerImpl = this.mControl;
        if (iLaneServicePlayerImpl != null) {
            return iLaneServicePlayerImpl.startPlay();
        }
        return false;
    }

    public boolean stopPlay() {
        ILaneServicePlayerImpl iLaneServicePlayerImpl = this.mControl;
        if (iLaneServicePlayerImpl != null) {
            return iLaneServicePlayerImpl.stopPlay();
        }
        return false;
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.lane.LaneServicePlayer.3
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
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.lane.LaneServicePlayer.4
        }));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            Iterator it = ((HashSet) typeHelper.getBindSet("com.autonavi.gbl.lane.observer.ILaneServicePlayerObserver")).iterator();
            while (it.hasNext()) {
                unRegisterServicePlayer((ILaneServicePlayerObserver) it.next());
            }
        }
    }

    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.lane.LaneServicePlayer.5
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
