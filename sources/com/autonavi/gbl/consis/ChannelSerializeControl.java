package com.autonavi.gbl.consis;

import android.util.Log;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.common.path.option.RouteOption;
import com.autonavi.gbl.common.path.option.impl.IRouteOptionImpl;
import com.autonavi.gbl.consis.impl.ChannelParcelImpl;
import com.autonavi.gbl.consis.impl.ChannelSerializeControlImpl;
import java.lang.reflect.Method;
@IntfAuto(target = ChannelSerializeControlImpl.class, type = BuildType.JCTRL)
/* loaded from: classes.dex */
public class ChannelSerializeControl {
    private static String PACKAGE = ReflexTool.PN(ChannelSerializeControl.class);
    private static TypeHelper gTypeHelper = new TypeHelper(PACKAGE);
    private ChannelSerializeControlImpl mControl;
    private boolean mHasDestroy;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected void clean() {
    }

    protected ChannelSerializeControl(long j, boolean z) {
        this(new ChannelSerializeControlImpl(j, z));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(ChannelSerializeControl.class, this, this.mControl);
        }
    }

    public ChannelSerializeControl() {
        this(new ChannelSerializeControlImpl());
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(ChannelSerializeControl.class, this, this.mControl);
        }
    }

    public ChannelSerializeControl(ChannelSerializeControlImpl channelSerializeControlImpl) {
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mHasDestroy = false;
        this.mControl = null;
        $constructor(channelSerializeControlImpl);
    }

    private void $constructor(ChannelSerializeControlImpl channelSerializeControlImpl) {
        if (channelSerializeControlImpl != null) {
            this.mControl = channelSerializeControlImpl;
            this.mTargetId = String.format("ChannelSerializeControl_%s_%d", String.valueOf(ChannelSerializeControlImpl.getCPtr(this.mControl)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    protected ChannelSerializeControlImpl getControl() {
        return this.mControl;
    }

    public static void writeToParcel(ChannelParcel channelParcel, RouteOption routeOption) {
        TypeHelper typeHelper;
        TypeHelper typeHelper2;
        try {
            Method method = ChannelSerializeControl.class.getMethod("writeToParcel", ChannelParcel.class, RouteOption.class);
            IRouteOptionImpl iRouteOptionImpl = null;
            ChannelParcelImpl channelParcelImpl = (channelParcel == null || (typeHelper2 = gTypeHelper) == null) ? null : (ChannelParcelImpl) typeHelper2.transfer(method, 0, channelParcel);
            if (routeOption != null && (typeHelper = gTypeHelper) != null) {
                iRouteOptionImpl = (IRouteOptionImpl) typeHelper.transfer(method, 1, routeOption);
            }
            ChannelSerializeControlImpl.writeToParcel(channelParcelImpl, iRouteOptionImpl);
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public static void readFromParcel(ChannelParcel channelParcel, RouteOption routeOption) {
        TypeHelper typeHelper;
        TypeHelper typeHelper2;
        try {
            Method method = ChannelSerializeControl.class.getMethod("readFromParcel", ChannelParcel.class, RouteOption.class);
            IRouteOptionImpl iRouteOptionImpl = null;
            ChannelParcelImpl channelParcelImpl = (channelParcel == null || (typeHelper2 = gTypeHelper) == null) ? null : (ChannelParcelImpl) typeHelper2.transfer(method, 0, channelParcel);
            if (routeOption != null && (typeHelper = gTypeHelper) != null) {
                iRouteOptionImpl = (IRouteOptionImpl) typeHelper.transfer(method, 1, routeOption);
            }
            ChannelSerializeControlImpl.readFromParcel(channelParcelImpl, iRouteOptionImpl);
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
