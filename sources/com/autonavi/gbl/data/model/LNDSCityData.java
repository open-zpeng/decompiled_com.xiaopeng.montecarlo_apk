package com.autonavi.gbl.data.model;

import com.autonavi.gbl.data.model.TaskStatusCode;
import java.io.Serializable;
/* loaded from: classes.dex */
public class LNDSCityData implements Serializable {
    public int adcode;
    public String filePath;
    public float percent;
    @TaskStatusCode.TaskStatusCode1
    public int taskState;
    public int updateFlag;

    public LNDSCityData() {
        this.adcode = 0;
        this.taskState = 0;
        this.percent = 0.0f;
        this.filePath = "";
        this.updateFlag = 0;
    }

    public LNDSCityData(int i, @TaskStatusCode.TaskStatusCode1 int i2, float f, String str, int i3) {
        this.adcode = i;
        this.taskState = i2;
        this.percent = f;
        this.filePath = str;
        this.updateFlag = i3;
    }
}
