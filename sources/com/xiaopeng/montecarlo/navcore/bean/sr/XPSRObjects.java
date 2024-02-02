package com.xiaopeng.montecarlo.navcore.bean.sr;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class XPSRObjects implements Serializable {
    public XPRelativePos mLocalCarPos;
    public XPRelativePos mLocalRefPos;
    public ArrayList<XPSRObject> mObjects;

    public ArrayList<XPSRObject> getObjects() {
        return this.mObjects;
    }

    public void setObjects(ArrayList<XPSRObject> arrayList) {
        this.mObjects = arrayList;
    }

    public XPRelativePos getLocalRefPos() {
        return this.mLocalRefPos;
    }

    public void setLocalRefPos(XPRelativePos xPRelativePos) {
        this.mLocalRefPos = xPRelativePos;
    }

    public XPRelativePos getLocalCarPos() {
        return this.mLocalCarPos;
    }

    public void setLocalCarPos(XPRelativePos xPRelativePos) {
        this.mLocalCarPos = xPRelativePos;
    }
}
