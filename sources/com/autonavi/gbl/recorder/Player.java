package com.autonavi.gbl.recorder;

import android.util.Log;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.recorder.impl.IPlayerImpl;
import com.autonavi.gbl.recorder.model.PlayParam;
import com.autonavi.gbl.recorder.observer.IPlayerObserver;
import com.autonavi.gbl.recorder.observer.impl.IPlayerObserverImpl;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Iterator;
@IntfAuto(target = IPlayerImpl.class, type = BuildType.JCTRL)
/* loaded from: classes2.dex */
public class Player {
    private static String PACKAGE = ReflexTool.PN(Player.class);
    private IPlayerImpl mControl;
    private boolean mHasDestroy;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected Player(long j, boolean z) {
        this(new IPlayerImpl(j, z));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(Player.class, this, this.mControl);
        }
    }

    public Player(IPlayerImpl iPlayerImpl) {
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mHasDestroy = false;
        this.mControl = null;
        $constructor(iPlayerImpl);
    }

    private void $constructor(IPlayerImpl iPlayerImpl) {
        if (iPlayerImpl != null) {
            this.mControl = iPlayerImpl;
            this.mTargetId = String.format("Player_%s_%d", String.valueOf(IPlayerImpl.getCPtr(this.mControl)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    protected IPlayerImpl getControl() {
        return this.mControl;
    }

    public int seekTo(long j) {
        IPlayerImpl iPlayerImpl = this.mControl;
        if (iPlayerImpl != null) {
            return iPlayerImpl.seekTo(j);
        }
        return Integer.MIN_VALUE;
    }

    public int setPlaySpeed(float f) {
        IPlayerImpl iPlayerImpl = this.mControl;
        if (iPlayerImpl != null) {
            return iPlayerImpl.setPlaySpeed(f);
        }
        return Integer.MIN_VALUE;
    }

    public int setParam(PlayParam playParam) {
        IPlayerImpl iPlayerImpl = this.mControl;
        if (iPlayerImpl != null) {
            return iPlayerImpl.setParam(playParam);
        }
        return Integer.MIN_VALUE;
    }

    public PlayParam getParam() {
        IPlayerImpl iPlayerImpl = this.mControl;
        if (iPlayerImpl != null) {
            return iPlayerImpl.getParam();
        }
        return null;
    }

    public int addObserver(IPlayerObserver iPlayerObserver) {
        TypeHelper typeHelper;
        try {
            Method method = Player.class.getMethod("addObserver", IPlayerObserver.class);
            IPlayerObserverImpl iPlayerObserverImpl = null;
            if (iPlayerObserver != null && (typeHelper = this.mTypeHelper) != null) {
                iPlayerObserverImpl = (IPlayerObserverImpl) typeHelper.transfer(method, 0, iPlayerObserver);
            }
            IPlayerImpl iPlayerImpl = this.mControl;
            if (iPlayerImpl != null) {
                return iPlayerImpl.addObserver(iPlayerObserverImpl);
            }
            return Integer.MIN_VALUE;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return Integer.MIN_VALUE;
        }
    }

    public int removeObserver(IPlayerObserver iPlayerObserver) {
        TypeHelper typeHelper;
        int i = Integer.MIN_VALUE;
        try {
            Method method = Player.class.getMethod("removeObserver", IPlayerObserver.class);
            IPlayerObserverImpl iPlayerObserverImpl = null;
            if (iPlayerObserver != null && (typeHelper = this.mTypeHelper) != null) {
                iPlayerObserverImpl = (IPlayerObserverImpl) typeHelper.transfer(method, 0, iPlayerObserver);
            }
            IPlayerImpl iPlayerImpl = this.mControl;
            if (iPlayerImpl != null) {
                i = iPlayerImpl.removeObserver(iPlayerObserverImpl);
                TypeHelper typeHelper2 = this.mTypeHelper;
                if (typeHelper2 != null) {
                    typeHelper2.unbind(method, 0, iPlayerObserver);
                }
            }
            return i;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return Integer.MIN_VALUE;
        }
    }

    public int start() {
        IPlayerImpl iPlayerImpl = this.mControl;
        if (iPlayerImpl != null) {
            return iPlayerImpl.start();
        }
        return Integer.MIN_VALUE;
    }

    public int stop() {
        IPlayerImpl iPlayerImpl = this.mControl;
        if (iPlayerImpl != null) {
            return iPlayerImpl.stop();
        }
        return Integer.MIN_VALUE;
    }

    public int pause() {
        IPlayerImpl iPlayerImpl = this.mControl;
        if (iPlayerImpl != null) {
            return iPlayerImpl.pause();
        }
        return Integer.MIN_VALUE;
    }

    public int resume() {
        IPlayerImpl iPlayerImpl = this.mControl;
        if (iPlayerImpl != null) {
            return iPlayerImpl.resume();
        }
        return Integer.MIN_VALUE;
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
            Iterator it = ((HashSet) typeHelper.getBindSet("com.autonavi.gbl.recorder.observer.IPlayerObserver")).iterator();
            while (it.hasNext()) {
                removeObserver((IPlayerObserver) it.next());
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
