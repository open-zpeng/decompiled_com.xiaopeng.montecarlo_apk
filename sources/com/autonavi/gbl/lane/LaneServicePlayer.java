package com.autonavi.gbl.lane;

import android.util.Log;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.lane.impl.ILaneServicePlayerImpl;
import com.autonavi.gbl.lane.observer.ILanePlayerAdapter;
import com.autonavi.gbl.lane.observer.ILaneServicePlayerObserver;
import com.autonavi.gbl.lane.observer.impl.ILanePlayerAdapterImpl;
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

    @Deprecated
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
        TypeHelper typeHelper;
        try {
            Method method = LaneServicePlayer.class.getMethod("registerServicePlayer", ILaneServicePlayerObserver.class);
            ILaneServicePlayerObserverImpl iLaneServicePlayerObserverImpl = null;
            if (iLaneServicePlayerObserver != null && (typeHelper = this.mTypeHelper) != null) {
                iLaneServicePlayerObserverImpl = (ILaneServicePlayerObserverImpl) typeHelper.transfer(method, 0, iLaneServicePlayerObserver);
            }
            ILaneServicePlayerImpl iLaneServicePlayerImpl = this.mControl;
            if (iLaneServicePlayerImpl != null) {
                return iLaneServicePlayerImpl.registerServicePlayer(iLaneServicePlayerObserverImpl);
            }
            return false;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return false;
        }
    }

    public boolean unRegisterServicePlayer(ILaneServicePlayerObserver iLaneServicePlayerObserver) {
        TypeHelper typeHelper;
        try {
            Method method = LaneServicePlayer.class.getMethod("unRegisterServicePlayer", ILaneServicePlayerObserver.class);
            ILaneServicePlayerObserverImpl iLaneServicePlayerObserverImpl = null;
            if (iLaneServicePlayerObserver != null && (typeHelper = this.mTypeHelper) != null) {
                iLaneServicePlayerObserverImpl = (ILaneServicePlayerObserverImpl) typeHelper.transfer(method, 0, iLaneServicePlayerObserver);
            }
            ILaneServicePlayerImpl iLaneServicePlayerImpl = this.mControl;
            if (iLaneServicePlayerImpl != null) {
                boolean unRegisterServicePlayer = iLaneServicePlayerImpl.unRegisterServicePlayer(iLaneServicePlayerObserverImpl);
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

    public boolean setPlayerAdapter(ILanePlayerAdapter iLanePlayerAdapter) {
        TypeHelper typeHelper;
        try {
            Method method = LaneServicePlayer.class.getMethod("setPlayerAdapter", ILanePlayerAdapter.class);
            ILanePlayerAdapterImpl iLanePlayerAdapterImpl = null;
            if (iLanePlayerAdapter != null && (typeHelper = this.mTypeHelper) != null) {
                iLanePlayerAdapterImpl = (ILanePlayerAdapterImpl) typeHelper.transfer(method, 0, iLanePlayerAdapter);
            }
            ILaneServicePlayerImpl iLaneServicePlayerImpl = this.mControl;
            if (iLaneServicePlayerImpl != null) {
                return iLaneServicePlayerImpl.setPlayerAdapter(iLanePlayerAdapterImpl);
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
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            Iterator it = ((HashSet) typeHelper.getBindSet("com.autonavi.gbl.lane.observer.ILaneServicePlayerObserver")).iterator();
            while (it.hasNext()) {
                unRegisterServicePlayer((ILaneServicePlayerObserver) it.next());
            }
        }
    }

    protected synchronized void delete() {
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
