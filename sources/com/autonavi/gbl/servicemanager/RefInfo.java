package com.autonavi.gbl.servicemanager;

import java.util.ArrayList;
/* loaded from: classes2.dex */
public class RefInfo {
    private static final ArrayList<Long> PATHLIST = new ArrayList<>();
    private static long pathCnt = 0;
    private boolean isEnableRegVM;
    private boolean isRegister;
    private long ptr;
    private int ptrSize;
    private Callback refCb;
    private long refId;

    /* loaded from: classes2.dex */
    public interface Callback {
        void delete(long j);
    }

    public RefInfo(Callback callback, long j, int i, long j2, boolean z) {
        this.refCb = callback;
        this.ptr = j;
        this.ptrSize = i;
        this.isEnableRegVM = z;
        this.refId = j2;
        register();
    }

    private void register() {
        boolean z = false;
        this.isRegister = false;
        if (this.ptrSize <= 0 || !this.isEnableRegVM || this.refId == 0) {
            return;
        }
        synchronized (PATHLIST) {
            int i = 0;
            while (true) {
                if (i >= PATHLIST.size()) {
                    break;
                } else if (PATHLIST.get(i).longValue() == this.refId) {
                    z = true;
                    break;
                } else {
                    i++;
                }
            }
            if (!z) {
                PATHLIST.add(new Long(this.refId));
                this.isRegister = VmReflect.registerNativeSize(this.ptrSize);
            }
        }
    }

    public void delete() {
        long j = this.ptr;
        if (j != 0) {
            this.refCb.delete(j);
        }
        if (this.isRegister && this.isEnableRegVM) {
            VmReflect.registerFreeSize(this.ptrSize);
        }
        if (this.refId != 0) {
            synchronized (PATHLIST) {
                int i = 0;
                while (true) {
                    if (i >= PATHLIST.size()) {
                        break;
                    }
                    Long l = PATHLIST.get(i);
                    if (l.longValue() == this.refId) {
                        PATHLIST.remove(l);
                        break;
                    }
                    i++;
                }
            }
        }
    }

    public long getRefId() {
        return this.refId;
    }
}
