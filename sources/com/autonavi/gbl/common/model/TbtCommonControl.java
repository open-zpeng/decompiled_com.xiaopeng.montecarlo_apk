package com.autonavi.gbl.common.model;

import android.util.Log;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.common.model.impl.ITbtCommonControlImpl;
import com.autonavi.gbl.common.observer.ITBTResReader;
import com.autonavi.gbl.common.observer.impl.ITBTResReaderImpl;
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

    protected void clean() {
    }

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
        TypeHelper typeHelper;
        try {
            Method method = TbtCommonControl.class.getMethod("getInstance", new Class[0]);
            ITbtCommonControlImpl iTbtCommonControlImpl = ITbtCommonControlImpl.getInstance();
            if (iTbtCommonControlImpl == null || (typeHelper = gTypeHelper) == null) {
                return null;
            }
            return (TbtCommonControl) typeHelper.transfer(method, -1, (Object) iTbtCommonControlImpl, true);
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public int init(WorkPath workPath, UserConfig userConfig) {
        ITbtCommonControlImpl iTbtCommonControlImpl = this.mControl;
        if (iTbtCommonControlImpl != null) {
            return iTbtCommonControlImpl.init(workPath, userConfig);
        }
        return Integer.MIN_VALUE;
    }

    public void setTBTResReader(ITBTResReader iTBTResReader) {
        TypeHelper typeHelper;
        try {
            Method method = TbtCommonControl.class.getMethod("setTBTResReader", ITBTResReader.class);
            ITBTResReaderImpl iTBTResReaderImpl = null;
            if (iTBTResReader != null && (typeHelper = this.mTypeHelper) != null) {
                iTBTResReaderImpl = (ITBTResReaderImpl) typeHelper.transfer(method, 0, iTBTResReader);
            }
            ITbtCommonControlImpl iTbtCommonControlImpl = this.mControl;
            if (iTbtCommonControlImpl != null) {
                iTbtCommonControlImpl.setTBTResReader(iTBTResReaderImpl);
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

    public synchronized void delete() {
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
