package com.autonavi.gbl.map.model;

import com.autonavi.gbl.map.model.EGLDeviceWorkMode;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class DeviceAttribute implements Serializable {
    public int configAttrNum;
    public ArrayList<EglConfigAttr> configAttribs;
    @EGLDeviceWorkMode.EGLDeviceWorkMode1
    public int deviceWorkMode;
    public long display;
    public boolean isNeedAntialias;
    public boolean isRecordeable;
    public int maxVideoMemory;
    public int samples;
    public int uiTaskDeviceId;

    public DeviceAttribute() {
        this.isRecordeable = false;
        this.isNeedAntialias = true;
        this.samples = 4;
        this.configAttrNum = 0;
        this.configAttribs = new ArrayList<>();
        this.deviceWorkMode = 0;
        this.uiTaskDeviceId = 0;
        this.display = -1L;
        this.maxVideoMemory = 800;
    }

    public DeviceAttribute(boolean z, boolean z2, int i, int i2, ArrayList<EglConfigAttr> arrayList, @EGLDeviceWorkMode.EGLDeviceWorkMode1 int i3, int i4, long j, int i5) {
        this.isRecordeable = z;
        this.isNeedAntialias = z2;
        this.samples = i;
        this.configAttrNum = i2;
        this.configAttribs = arrayList;
        this.deviceWorkMode = i3;
        this.uiTaskDeviceId = i4;
        this.display = j;
        this.maxVideoMemory = i5;
    }
}
