package com.autonavi.gbl.util;

import android.util.Log;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.util.impl.IWordBreakerImpl;
import com.autonavi.gbl.util.observer.IWordBreakAdapter;
import com.autonavi.gbl.util.observer.impl.IWordBreakAdapterImpl;
import java.lang.reflect.Method;
@IntfAuto(target = IWordBreakerImpl.class, type = BuildType.JCTRL)
/* loaded from: classes2.dex */
public class WordBreaker {
    private static String PACKAGE = ReflexTool.PN(WordBreaker.class);
    private static TypeHelper gTypeHelper = new TypeHelper(PACKAGE);
    private IWordBreakerImpl mControl;
    private boolean mHasDestroy;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected void clean() {
    }

    protected WordBreaker(long j, boolean z) {
        this(new IWordBreakerImpl(j, z));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(WordBreaker.class, this, this.mControl);
        }
    }

    public WordBreaker(IWordBreakerImpl iWordBreakerImpl) {
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mHasDestroy = false;
        this.mControl = null;
        $constructor(iWordBreakerImpl);
    }

    private void $constructor(IWordBreakerImpl iWordBreakerImpl) {
        if (iWordBreakerImpl != null) {
            this.mControl = iWordBreakerImpl;
            this.mTargetId = String.format("WordBreaker_%s_%d", String.valueOf(IWordBreakerImpl.getCPtr(this.mControl)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    protected IWordBreakerImpl getControl() {
        return this.mControl;
    }

    public static WordBreaker getInstance() {
        TypeHelper typeHelper;
        try {
            Method method = WordBreaker.class.getMethod("getInstance", new Class[0]);
            IWordBreakerImpl iWordBreakerImpl = IWordBreakerImpl.getInstance();
            if (iWordBreakerImpl == null || (typeHelper = gTypeHelper) == null) {
                return null;
            }
            return (WordBreaker) typeHelper.transfer(method, -1, (Object) iWordBreakerImpl, true);
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public void setAdapter(IWordBreakAdapter iWordBreakAdapter) {
        TypeHelper typeHelper;
        try {
            Method method = WordBreaker.class.getMethod("setAdapter", IWordBreakAdapter.class);
            IWordBreakAdapterImpl iWordBreakAdapterImpl = null;
            if (iWordBreakAdapter != null && (typeHelper = this.mTypeHelper) != null) {
                iWordBreakAdapterImpl = (IWordBreakAdapterImpl) typeHelper.transfer(method, 0, iWordBreakAdapter);
            }
            IWordBreakerImpl iWordBreakerImpl = this.mControl;
            if (iWordBreakerImpl != null) {
                iWordBreakerImpl.setAdapter(iWordBreakAdapterImpl);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
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
