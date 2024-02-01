package com.autonavi.gbl.recorder;

import android.util.Log;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.recorder.impl.IPlayerImpl;
import com.autonavi.gbl.recorder.impl.IRecorderImpl;
import com.autonavi.gbl.recorder.impl.IRecorderServiceImpl;
import com.autonavi.gbl.servicemanager.IService;
import com.autonavi.gbl.util.model.ServiceInitStatus;
import java.lang.reflect.Method;
@IntfAuto(target = IRecorderServiceImpl.class, type = BuildType.JCTRL)
/* loaded from: classes2.dex */
public class RecorderService implements IService {
    private static String PACKAGE = ReflexTool.PN(RecorderService.class);
    private IRecorderServiceImpl mControl;
    private boolean mHasDestroy;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected void clean() {
    }

    protected RecorderService(long j, boolean z) {
        this((IRecorderServiceImpl) ReflexTool.invokeDeclConstructorSafe(IRecorderServiceImpl.class, new Class[]{Long.TYPE, Boolean.TYPE}, new Object[]{Long.valueOf(j), Boolean.valueOf(z)}));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(RecorderService.class, this, this.mControl);
        }
    }

    public RecorderService(IRecorderServiceImpl iRecorderServiceImpl) {
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mHasDestroy = false;
        this.mControl = null;
        $constructor(iRecorderServiceImpl);
    }

    private void $constructor(IRecorderServiceImpl iRecorderServiceImpl) {
        if (iRecorderServiceImpl != null) {
            this.mControl = iRecorderServiceImpl;
            this.mTargetId = String.format("RecorderService_%s_%d", String.valueOf(IRecorderServiceImpl.getCPtr(this.mControl)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    protected IRecorderServiceImpl getControl() {
        return this.mControl;
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public boolean isRecycled() {
        IRecorderServiceImpl iRecorderServiceImpl = this.mControl;
        if (iRecorderServiceImpl != null) {
            return iRecorderServiceImpl.isRecycled();
        }
        return true;
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public long getPtr() {
        IRecorderServiceImpl iRecorderServiceImpl = this.mControl;
        if (iRecorderServiceImpl != null) {
            return iRecorderServiceImpl.getPtr();
        }
        return 0L;
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public void onCreate() {
        IRecorderServiceImpl iRecorderServiceImpl = this.mControl;
        if (iRecorderServiceImpl != null) {
            iRecorderServiceImpl.onCreate();
        }
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    @ServiceInitStatus.ServiceInitStatus1
    public int isInit() {
        IRecorderServiceImpl iRecorderServiceImpl = this.mControl;
        if (iRecorderServiceImpl != null) {
            return iRecorderServiceImpl.isInit();
        }
        return Integer.MIN_VALUE;
    }

    public String getVersion() {
        IRecorderServiceImpl iRecorderServiceImpl = this.mControl;
        if (iRecorderServiceImpl != null) {
            return iRecorderServiceImpl.getVersion();
        }
        return null;
    }

    public void logSwitch(int i) {
        IRecorderServiceImpl iRecorderServiceImpl = this.mControl;
        if (iRecorderServiceImpl != null) {
            iRecorderServiceImpl.logSwitch(i);
        }
    }

    public Recorder getRecorder() {
        IRecorderImpl recorder;
        TypeHelper typeHelper;
        try {
            Method method = RecorderService.class.getMethod("getRecorder", new Class[0]);
            IRecorderServiceImpl iRecorderServiceImpl = this.mControl;
            if (iRecorderServiceImpl == null || (recorder = iRecorderServiceImpl.getRecorder()) == null || (typeHelper = this.mTypeHelper) == null) {
                return null;
            }
            return (Recorder) typeHelper.transfer(method, -1, (Object) recorder, true);
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public Player getPlayer() {
        IPlayerImpl player;
        TypeHelper typeHelper;
        try {
            Method method = RecorderService.class.getMethod("getPlayer", new Class[0]);
            IRecorderServiceImpl iRecorderServiceImpl = this.mControl;
            if (iRecorderServiceImpl == null || (player = iRecorderServiceImpl.getPlayer()) == null || (typeHelper = this.mTypeHelper) == null) {
                return null;
            }
            return (Player) typeHelper.transfer(method, -1, (Object) player, true);
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    protected void unbind() {
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
