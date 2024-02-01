package com.autonavi.gbl.util;

import android.util.Log;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.util.impl.TimeUtilImpl;
import com.autonavi.gbl.util.model.DateTime;
import com.autonavi.gbl.util.model.TimeSourceFlag;
import com.autonavi.gbl.util.observer.ITimeSource;
import com.autonavi.gbl.util.observer.impl.TimeSourceImpl;
import java.lang.reflect.Method;
@IntfAuto(target = TimeUtilImpl.class, type = BuildType.JCTRL)
/* loaded from: classes2.dex */
public class TimeUtil {
    private static String PACKAGE = ReflexTool.PN(TimeUtil.class);
    private static TypeHelper gTypeHelper = new TypeHelper(PACKAGE);
    private TimeUtilImpl mControl;
    private boolean mHasDestroy;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected void clean() {
    }

    protected TimeUtil(long j, boolean z) {
        this(new TimeUtilImpl(j, z));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(TimeUtil.class, this, this.mControl);
        }
    }

    public TimeUtil() {
        this(new TimeUtilImpl());
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(TimeUtil.class, this, this.mControl);
        }
    }

    public TimeUtil(TimeUtilImpl timeUtilImpl) {
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mHasDestroy = false;
        this.mControl = null;
        $constructor(timeUtilImpl);
    }

    private void $constructor(TimeUtilImpl timeUtilImpl) {
        if (timeUtilImpl != null) {
            this.mControl = timeUtilImpl;
            this.mTargetId = String.format("TimeUtil_%s_%d", String.valueOf(TimeUtilImpl.getCPtr(this.mControl)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    protected TimeUtilImpl getControl() {
        return this.mControl;
    }

    public static void registerTimeSource(ITimeSource iTimeSource, @TimeSourceFlag.TimeSourceFlag1 int i) {
        TypeHelper typeHelper;
        try {
            Method method = TimeUtil.class.getMethod("registerTimeSource", ITimeSource.class, Integer.TYPE);
            TimeSourceImpl timeSourceImpl = null;
            if (iTimeSource != null && (typeHelper = gTypeHelper) != null) {
                timeSourceImpl = (TimeSourceImpl) typeHelper.transfer(method, 0, iTimeSource);
            }
            TimeUtilImpl.registerTimeSource(timeSourceImpl, i);
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public static void registerTimeSource(ITimeSource iTimeSource) {
        TypeHelper typeHelper;
        try {
            Method method = TimeUtil.class.getMethod("registerTimeSource", ITimeSource.class);
            TimeSourceImpl timeSourceImpl = null;
            if (iTimeSource != null && (typeHelper = gTypeHelper) != null) {
                timeSourceImpl = (TimeSourceImpl) typeHelper.transfer(method, 0, iTimeSource);
            }
            TimeUtilImpl.registerTimeSource(timeSourceImpl);
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public static void setGPSTime(long j) {
        TimeUtilImpl.setGPSTime(j);
    }

    public static long getGPSTime() {
        return TimeUtilImpl.getGPSTime();
    }

    public static long getNetWorkTime(int[] iArr) {
        if (iArr != null && iArr.length == 0) {
            iArr = null;
        }
        return TimeUtilImpl.getNetWorkTime(iArr);
    }

    public static long getTickCount() {
        return TimeUtilImpl.getTickCount();
    }

    public static long iso2UTC(String str) {
        return TimeUtilImpl.iso2UTC(str);
    }

    public static long getLocalTime() {
        return TimeUtilImpl.getLocalTime();
    }

    public static DateTime getLocalTime2() {
        return TimeUtilImpl.getLocalTime2();
    }

    public static DateTime uTC2DateTime(long j) {
        return TimeUtilImpl.uTC2DateTime(j);
    }

    public static DateTime uTC2DateTimeBj(long j) {
        return TimeUtilImpl.uTC2DateTimeBj(j);
    }

    public static long dateTime2UTC(DateTime dateTime) {
        return TimeUtilImpl.dateTime2UTC(dateTime);
    }

    public static long dateTimeBj2UTC(DateTime dateTime) {
        return TimeUtilImpl.dateTimeBj2UTC(dateTime);
    }

    public static long getTimeUTC() {
        return TimeUtilImpl.getTimeUTC();
    }

    public static long getTimeSpan() {
        return TimeUtilImpl.getTimeSpan();
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
