package com.autonavi.gbl.map;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.map.impl.OperatorWeatherImpl;
import com.autonavi.gbl.map.model.TextBuffer;
import com.autonavi.gbl.map.model.WEATHER_TYPE;
@IntfAuto(target = OperatorWeatherImpl.class, type = BuildType.JCTRL)
/* loaded from: classes.dex */
public class OperatorWeather {
    private static String PACKAGE = ReflexTool.PN(OperatorWeather.class);
    private OperatorWeatherImpl mControl;
    private boolean mHasDestroy;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected OperatorWeather(long j, boolean z) {
        this(new OperatorWeatherImpl(j, z));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(OperatorWeather.class, this, this.mControl);
        }
    }

    public OperatorWeather(OperatorWeatherImpl operatorWeatherImpl) {
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mHasDestroy = false;
        this.mControl = null;
        $constructor(operatorWeatherImpl);
    }

    private void $constructor(OperatorWeatherImpl operatorWeatherImpl) {
        if (operatorWeatherImpl != null) {
            this.mControl = operatorWeatherImpl;
            this.mTargetId = String.format("OperatorWeather_%s_%d", String.valueOf(OperatorWeatherImpl.getCPtr(this.mControl)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    protected OperatorWeatherImpl getControl() {
        return this.mControl;
    }

    public void startWeatherEffect(@WEATHER_TYPE.WEATHER_TYPE1 int i, TextBuffer textBuffer, long j) {
        OperatorWeatherImpl operatorWeatherImpl = this.mControl;
        if (operatorWeatherImpl != null) {
            operatorWeatherImpl.startWeatherEffect(i, textBuffer, j);
        }
    }

    public void stopWeatherEffect(boolean z) {
        OperatorWeatherImpl operatorWeatherImpl = this.mControl;
        if (operatorWeatherImpl != null) {
            operatorWeatherImpl.stopWeatherEffect(z);
        }
    }

    public int getAnimationState() {
        OperatorWeatherImpl operatorWeatherImpl = this.mControl;
        if (operatorWeatherImpl != null) {
            return operatorWeatherImpl.getAnimationState();
        }
        return 0;
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.OperatorWeather.1
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
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.OperatorWeather.2
        }));
    }

    protected synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.OperatorWeather.3
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
