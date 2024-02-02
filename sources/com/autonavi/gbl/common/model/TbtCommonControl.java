package com.autonavi.gbl.common.model;

import android.util.Log;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.common.model.impl.ITbtCommonControlImpl;
import com.autonavi.gbl.common.model.impl.UserConfigImpl;
import com.autonavi.gbl.common.model.impl.WorkPathImpl;
import com.autonavi.gbl.common.observer.ITBTResReader;
import com.autonavi.gbl.common.observer.impl.ITBTResReaderImpl;
import com.autonavi.gbl.util.model.ErrorCode;
import java.lang.reflect.Method;
@IntfAuto(target = ITbtCommonControlImpl.class, type = BuildType.JCTRL)
/* loaded from: classes.dex */
public class TbtCommonControl {
    private static String PACKAGE = ReflexTool.PN(TbtCommonControl.class);
    private static TypeHelper gTypeHelper = new TypeHelper(PACKAGE);
    private ITbtCommonControlImpl mControl;
    private boolean mHasDestroy;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected TbtCommonControl(long j, boolean z) {
        this(new ITbtCommonControlImpl(j, z));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(TbtCommonControl.class, this, this.mControl);
        }
    }

    public TbtCommonControl(ITbtCommonControlImpl iTbtCommonControlImpl) {
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mHasDestroy = false;
        this.mControl = null;
        $constructor(iTbtCommonControlImpl);
    }

    private void $constructor(ITbtCommonControlImpl iTbtCommonControlImpl) {
        if (iTbtCommonControlImpl != null) {
            this.mControl = iTbtCommonControlImpl;
            this.mTargetId = String.format("TbtCommonControl_%s_%d", String.valueOf(ITbtCommonControlImpl.getCPtr(this.mControl)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    protected ITbtCommonControlImpl getControl() {
        return this.mControl;
    }

    public static TbtCommonControl getInstance() {
        try {
            Method method = TbtCommonControl.class.getMethod("getInstance", new Class[0]);
            ITbtCommonControlImpl iTbtCommonControlImpl = ITbtCommonControlImpl.getInstance();
            if (iTbtCommonControlImpl != null) {
                TypeHelper typeHelper = gTypeHelper;
                r0 = typeHelper != null ? (TbtCommonControl) typeHelper.transfer(method, -1, (Object) iTbtCommonControlImpl, true) : null;
                if (r0 == null) {
                    DebugTool.e("%s: $ret == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.common.model.TbtCommonControl.1
                    }));
                }
            }
            return r0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    @ErrorCode.ErrorCode1
    public int init(WorkPath workPath, UserConfig userConfig) {
        WorkPathImpl workPathImpl;
        try {
            Method method = TbtCommonControl.class.getMethod("init", WorkPath.class, UserConfig.class);
            if (workPath != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                workPathImpl = typeHelper != null ? (WorkPathImpl) typeHelper.transfer(method, 0, workPath) : null;
                if (workPathImpl == null) {
                    DebugTool.e("%s: $path == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.common.model.TbtCommonControl.2
                    }));
                    return Integer.MIN_VALUE;
                }
            } else {
                workPathImpl = null;
            }
            if (userConfig != null) {
                TypeHelper typeHelper2 = this.mTypeHelper;
                r2 = typeHelper2 != null ? (UserConfigImpl) typeHelper2.transfer(method, 1, userConfig) : null;
                if (r2 == null) {
                    DebugTool.e("%s: $cfg == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.common.model.TbtCommonControl.3
                    }));
                    return Integer.MIN_VALUE;
                }
            }
            ITbtCommonControlImpl iTbtCommonControlImpl = this.mControl;
            if (iTbtCommonControlImpl != null) {
                return iTbtCommonControlImpl.init(workPathImpl, r2);
            }
            return Integer.MIN_VALUE;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return Integer.MIN_VALUE;
        }
    }

    public void setTBTResReader(ITBTResReader iTBTResReader) {
        try {
            Method method = TbtCommonControl.class.getMethod("setTBTResReader", ITBTResReader.class);
            if (iTBTResReader != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r1 = typeHelper != null ? (ITBTResReaderImpl) typeHelper.transfer(method, 0, iTBTResReader) : null;
                if (r1 == null) {
                    DebugTool.e("%s: $pResReader == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.common.model.TbtCommonControl.4
                    }));
                }
            }
            ITbtCommonControlImpl iTbtCommonControlImpl = this.mControl;
            if (iTbtCommonControlImpl != null) {
                iTbtCommonControlImpl.setTBTResReader(r1);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public void unInit() {
        ITbtCommonControlImpl iTbtCommonControlImpl = this.mControl;
        if (iTbtCommonControlImpl != null) {
            iTbtCommonControlImpl.unInit();
        }
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.common.model.TbtCommonControl.5
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
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.common.model.TbtCommonControl.6
        }));
    }

    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.common.model.TbtCommonControl.7
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
