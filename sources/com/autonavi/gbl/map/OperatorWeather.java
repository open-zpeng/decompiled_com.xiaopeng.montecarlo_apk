package com.autonavi.gbl.map;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.map.impl.IOperatorWeatherImpl;
import com.autonavi.gbl.map.model.TextBuffer;
import com.autonavi.gbl.map.model.WEATHER_TYPE;
@IntfAuto(target = IOperatorWeatherImpl.class, type = BuildType.JCTRL)
/* loaded from: classes2.dex */
public class OperatorWeather {
    private static String PACKAGE = ReflexTool.PN(OperatorWeather.class);
    private IOperatorWeatherImpl mControl;
    private boolean mHasDestroy;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected void clean() {
    }

    protected OperatorWeather(long j, boolean z) {
        this(new IOperatorWeatherImpl(j, z));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(OperatorWeather.class, this, this.mControl);
        }
    }

    public OperatorWeather(IOperatorWeatherImpl iOperatorWeatherImpl) {
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mHasDestroy = false;
        this.mControl = null;
        $constructor(iOperatorWeatherImpl);
    }

    private void $constructor(IOperatorWeatherImpl iOperatorWeatherImpl) {
        if (iOperatorWeatherImpl != null) {
            this.mControl = iOperatorWeatherImpl;
            this.mTargetId = String.format("OperatorWeather_%s_%d", String.valueOf(IOperatorWeatherImpl.getCPtr(this.mControl)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    protected IOperatorWeatherImpl getControl() {
        return this.mControl;
    }

    public void startWeatherEffect(@WEATHER_TYPE.WEATHER_TYPE1 int i, TextBuffer textBuffer, long j) {
        IOperatorWeatherImpl iOperatorWeatherImpl = this.mControl;
        if (iOperatorWeatherImpl != null) {
            iOperatorWeatherImpl.startWeatherEffect(i, textBuffer, j);
        }
    }

    public void stopWeatherEffect(boolean z) {
        IOperatorWeatherImpl iOperatorWeatherImpl = this.mControl;
        if (iOperatorWeatherImpl != null) {
            iOperatorWeatherImpl.stopWeatherEffect(z);
        }
    }

    public int getAnimationState() {
        IOperatorWeatherImpl iOperatorWeatherImpl = this.mControl;
        if (iOperatorWeatherImpl != null) {
            return iOperatorWeatherImpl.getAnimationState();
        }
        return 0;
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
