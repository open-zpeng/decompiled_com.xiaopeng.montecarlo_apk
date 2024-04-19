package com.autonavi.gbl.multi.impl;

import com.autonavi.gbl.consis.impl.ChannelParcelable;
/* loaded from: classes2.dex */
public class RenderChannelParcelable extends ChannelParcelable {
    private transient long swigCPtr;

    private static native long RenderChannelParcelable_SWIGUpcast(long j);

    private static native void destroyNativeObj(long j);

    public RenderChannelParcelable(long j, boolean z) {
        super(RenderChannelParcelable_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    public static long getCPtr(RenderChannelParcelable renderChannelParcelable) {
        if (renderChannelParcelable == null) {
            return 0L;
        }
        return renderChannelParcelable.swigCPtr;
    }

    @Override // com.autonavi.gbl.consis.impl.ChannelParcelable
    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                destroyNativeObj(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
        super.delete();
    }
}
