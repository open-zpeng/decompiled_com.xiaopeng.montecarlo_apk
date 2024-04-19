package com.autonavi.gbl.consis;

import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.consis.impl.ChannelParcelImpl;
@IntfAuto(target = ChannelParcelImpl.class, type = BuildType.JCTRL)
/* loaded from: classes.dex */
public class ChannelParcel {
    private static String PACKAGE = ReflexTool.PN(ChannelParcel.class);
    private ChannelParcelImpl mControl;
    private boolean mHasDestroy;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected ChannelParcel(long j, boolean z) {
        this(new ChannelParcelImpl(j, z));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(ChannelParcel.class, this, this.mControl);
        }
    }

    public ChannelParcel() {
        this(new ChannelParcelImpl());
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(ChannelParcel.class, this, this.mControl);
        }
    }

    public ChannelParcel(String str, long j) {
        this(new ChannelParcelImpl(str, j));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(ChannelParcel.class, this, this.mControl);
        }
    }

    public ChannelParcel(ChannelParcelImpl channelParcelImpl) {
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mHasDestroy = false;
        this.mControl = null;
        $constructor(channelParcelImpl);
    }

    private void $constructor(ChannelParcelImpl channelParcelImpl) {
        if (channelParcelImpl != null) {
            this.mControl = channelParcelImpl;
            this.mTargetId = String.format("ChannelParcel_%s_%d", String.valueOf(ChannelParcelImpl.getCPtr(this.mControl)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    protected ChannelParcelImpl getControl() {
        return this.mControl;
    }

    public boolean readBool() {
        ChannelParcelImpl channelParcelImpl = this.mControl;
        if (channelParcelImpl != null) {
            return channelParcelImpl.readBool();
        }
        return false;
    }

    public int readInt() {
        ChannelParcelImpl channelParcelImpl = this.mControl;
        if (channelParcelImpl != null) {
            return channelParcelImpl.readInt();
        }
        return 0;
    }

    public long readInt64() {
        ChannelParcelImpl channelParcelImpl = this.mControl;
        if (channelParcelImpl != null) {
            return channelParcelImpl.readInt64();
        }
        return 0L;
    }

    public short readInt16() {
        ChannelParcelImpl channelParcelImpl = this.mControl;
        if (channelParcelImpl != null) {
            return channelParcelImpl.readInt16();
        }
        return (short) 0;
    }

    public short readUInt16() {
        ChannelParcelImpl channelParcelImpl = this.mControl;
        if (channelParcelImpl != null) {
            return channelParcelImpl.readUInt16();
        }
        return (short) 0;
    }

    public float readFloat() {
        ChannelParcelImpl channelParcelImpl = this.mControl;
        if (channelParcelImpl != null) {
            return channelParcelImpl.readFloat();
        }
        return 0.0f;
    }

    public double readDouble() {
        ChannelParcelImpl channelParcelImpl = this.mControl;
        if (channelParcelImpl != null) {
            return channelParcelImpl.readDouble();
        }
        return 0.0d;
    }

    public byte readUnSignedChar() {
        ChannelParcelImpl channelParcelImpl = this.mControl;
        if (channelParcelImpl != null) {
            return channelParcelImpl.readUnSignedChar();
        }
        return (byte) 0;
    }

    public byte readChar() {
        ChannelParcelImpl channelParcelImpl = this.mControl;
        if (channelParcelImpl != null) {
            return channelParcelImpl.readChar();
        }
        return (byte) 0;
    }

    public String data() {
        ChannelParcelImpl channelParcelImpl = this.mControl;
        if (channelParcelImpl != null) {
            return channelParcelImpl.data();
        }
        return null;
    }

    public long dataSize() {
        ChannelParcelImpl channelParcelImpl = this.mControl;
        if (channelParcelImpl != null) {
            return channelParcelImpl.dataSize();
        }
        return 0L;
    }

    public long dataPosition() {
        ChannelParcelImpl channelParcelImpl = this.mControl;
        if (channelParcelImpl != null) {
            return channelParcelImpl.dataPosition();
        }
        return 0L;
    }

    public long dataCapacity() {
        ChannelParcelImpl channelParcelImpl = this.mControl;
        if (channelParcelImpl != null) {
            return channelParcelImpl.dataCapacity();
        }
        return 0L;
    }

    public void setDataPosition(long j) {
        ChannelParcelImpl channelParcelImpl = this.mControl;
        if (channelParcelImpl != null) {
            channelParcelImpl.setDataPosition(j);
        }
    }

    public boolean write(long j, long j2) {
        ChannelParcelImpl channelParcelImpl = this.mControl;
        if (channelParcelImpl != null) {
            return channelParcelImpl.write(j, j2);
        }
        return false;
    }

    public boolean writeBool(boolean z) {
        ChannelParcelImpl channelParcelImpl = this.mControl;
        if (channelParcelImpl != null) {
            return channelParcelImpl.writeBool(z);
        }
        return false;
    }

    public boolean writeInt(int i) {
        ChannelParcelImpl channelParcelImpl = this.mControl;
        if (channelParcelImpl != null) {
            return channelParcelImpl.writeInt(i);
        }
        return false;
    }

    public boolean writeInt64(long j) {
        ChannelParcelImpl channelParcelImpl = this.mControl;
        if (channelParcelImpl != null) {
            return channelParcelImpl.writeInt64(j);
        }
        return false;
    }

    public boolean writeInt16(short s) {
        ChannelParcelImpl channelParcelImpl = this.mControl;
        if (channelParcelImpl != null) {
            return channelParcelImpl.writeInt16(s);
        }
        return false;
    }

    public boolean writeUInt16(int i) {
        ChannelParcelImpl channelParcelImpl = this.mControl;
        if (channelParcelImpl != null) {
            return channelParcelImpl.writeUInt16(i);
        }
        return false;
    }

    public boolean writeFloat(float f) {
        ChannelParcelImpl channelParcelImpl = this.mControl;
        if (channelParcelImpl != null) {
            return channelParcelImpl.writeFloat(f);
        }
        return false;
    }

    public boolean writeDouble(double d) {
        ChannelParcelImpl channelParcelImpl = this.mControl;
        if (channelParcelImpl != null) {
            return channelParcelImpl.writeDouble(d);
        }
        return false;
    }

    public boolean writeUnSignedChar(short s) {
        ChannelParcelImpl channelParcelImpl = this.mControl;
        if (channelParcelImpl != null) {
            return channelParcelImpl.writeUnSignedChar(s);
        }
        return false;
    }

    public boolean writeChar(byte b) {
        ChannelParcelImpl channelParcelImpl = this.mControl;
        if (channelParcelImpl != null) {
            return channelParcelImpl.writeChar(b);
        }
        return false;
    }

    public boolean writeString(String str) {
        ChannelParcelImpl channelParcelImpl = this.mControl;
        if (channelParcelImpl != null) {
            return channelParcelImpl.writeString(str);
        }
        return false;
    }

    public String readString() {
        ChannelParcelImpl channelParcelImpl = this.mControl;
        if (channelParcelImpl != null) {
            return channelParcelImpl.readString();
        }
        return null;
    }

    public String releaseBuf(int[] iArr) {
        if (iArr != null && iArr.length == 0) {
            iArr = null;
        }
        ChannelParcelImpl channelParcelImpl = this.mControl;
        if (channelParcelImpl != null) {
            return channelParcelImpl.releaseBuf(iArr);
        }
        return null;
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.consis.ChannelParcel.1
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
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.consis.ChannelParcel.2
        }));
    }

    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.consis.ChannelParcel.3
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
