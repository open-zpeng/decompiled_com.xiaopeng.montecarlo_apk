package com.autonavi.gbl.consis;

import android.util.Log;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.consis.impl.ChannelParcelImpl;
import com.autonavi.gbl.consis.impl.ChannelParcelableImpl;
import com.autonavi.gbl.consis.model.ChannelMessageType;
import java.lang.reflect.Method;
@IntfAuto(target = ChannelParcelableImpl.class, type = BuildType.JCTRL)
/* loaded from: classes.dex */
public class ChannelParcelable {
    private static String PACKAGE = ReflexTool.PN(ChannelParcelable.class);
    private ChannelParcelableImpl mControl;
    private boolean mHasDestroy;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected void clean() {
    }

    protected ChannelParcelable(long j, boolean z) {
        this(new ChannelParcelableImpl(j, z));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(ChannelParcelable.class, this, this.mControl);
        }
    }

    public ChannelParcelable(ChannelParcelableImpl channelParcelableImpl) {
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mHasDestroy = false;
        this.mControl = null;
        $constructor(channelParcelableImpl);
    }

    private void $constructor(ChannelParcelableImpl channelParcelableImpl) {
        if (channelParcelableImpl != null) {
            this.mControl = channelParcelableImpl;
            this.mTargetId = String.format("ChannelParcelable_%s_%d", String.valueOf(ChannelParcelableImpl.getCPtr(this.mControl)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    protected ChannelParcelableImpl getControl() {
        return this.mControl;
    }

    public void setMsgType(@ChannelMessageType.ChannelMessageType1 int i) {
        ChannelParcelableImpl channelParcelableImpl = this.mControl;
        if (channelParcelableImpl != null) {
            channelParcelableImpl.setMsgType(i);
        }
    }

    @ChannelMessageType.ChannelMessageType1
    public int getMsgType() {
        ChannelParcelableImpl channelParcelableImpl = this.mControl;
        if (channelParcelableImpl != null) {
            return channelParcelableImpl.getMsgType();
        }
        return Integer.MIN_VALUE;
    }

    public void setSubType(int i) {
        ChannelParcelableImpl channelParcelableImpl = this.mControl;
        if (channelParcelableImpl != null) {
            channelParcelableImpl.setSubType(i);
        }
    }

    public int getSubType() {
        ChannelParcelableImpl channelParcelableImpl = this.mControl;
        if (channelParcelableImpl != null) {
            return channelParcelableImpl.getSubType();
        }
        return 0;
    }

    public int writeToParcel(ChannelParcel channelParcel) {
        TypeHelper typeHelper;
        try {
            Method method = ChannelParcelable.class.getMethod("writeToParcel", ChannelParcel.class);
            ChannelParcelImpl channelParcelImpl = null;
            if (channelParcel != null && (typeHelper = this.mTypeHelper) != null) {
                channelParcelImpl = (ChannelParcelImpl) typeHelper.transfer(method, 0, channelParcel);
            }
            ChannelParcelableImpl channelParcelableImpl = this.mControl;
            if (channelParcelableImpl != null) {
                return channelParcelableImpl.writeToParcel(channelParcelImpl);
            }
            return Integer.MIN_VALUE;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return Integer.MIN_VALUE;
        }
    }

    public int readFromParcel(ChannelParcel channelParcel) {
        TypeHelper typeHelper;
        try {
            Method method = ChannelParcelable.class.getMethod("readFromParcel", ChannelParcel.class);
            ChannelParcelImpl channelParcelImpl = null;
            if (channelParcel != null && (typeHelper = this.mTypeHelper) != null) {
                channelParcelImpl = (ChannelParcelImpl) typeHelper.transfer(method, 0, channelParcel);
            }
            ChannelParcelableImpl channelParcelableImpl = this.mControl;
            if (channelParcelableImpl != null) {
                return channelParcelableImpl.readFromParcel(channelParcelImpl);
            }
            return Integer.MIN_VALUE;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return Integer.MIN_VALUE;
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
