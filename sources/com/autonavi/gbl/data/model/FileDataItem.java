package com.autonavi.gbl.data.model;

import com.autonavi.gbl.data.model.TaskStatusCode;
import java.io.Serializable;
import java.math.BigInteger;
/* loaded from: classes.dex */
public class FileDataItem implements Serializable {
    public String desc;
    public String filePath;
    public int hidden;
    public int id;
    public String imageFilePath;
    public boolean isNew;
    public boolean isRecommended;
    public boolean isUpdate;
    public String name;
    public float percent;
    public int srcCode;
    public String subName;
    @TaskStatusCode.TaskStatusCode1
    public int taskState;
    public BigInteger unpackDataSize;
    public String version;
    public BigInteger zipDataSize;

    public FileDataItem() {
        this.isNew = false;
        this.isRecommended = false;
        this.isUpdate = false;
        this.id = 0;
        this.srcCode = 0;
        this.hidden = 0;
        this.zipDataSize = new BigInteger("0");
        this.unpackDataSize = new BigInteger("0");
        this.taskState = 0;
        this.percent = 0.0f;
        this.name = "";
        this.subName = "";
        this.version = "";
        this.desc = "";
        this.imageFilePath = "";
        this.filePath = "";
    }

    public FileDataItem(boolean z, boolean z2, boolean z3, int i, int i2, int i3, BigInteger bigInteger, BigInteger bigInteger2, @TaskStatusCode.TaskStatusCode1 int i4, float f, String str, String str2, String str3, String str4, String str5, String str6) {
        this.isNew = z;
        this.isRecommended = z2;
        this.isUpdate = z3;
        this.id = i;
        this.srcCode = i2;
        this.hidden = i3;
        this.zipDataSize = bigInteger;
        this.unpackDataSize = bigInteger2;
        this.taskState = i4;
        this.percent = f;
        this.name = str;
        this.subName = str2;
        this.version = str3;
        this.desc = str4;
        this.imageFilePath = str5;
        this.filePath = str6;
    }
}
