package com.autonavi.gbl.aosclient.model;

import com.autonavi.gbl.util.model.BinaryStream;
import java.io.Serializable;
/* loaded from: classes.dex */
public class GWsShieldAsbpApiUploadRequestParam extends BLRequestBase implements Serializable {
    public String deviceId = "";
    public String projectNo = "";
    public long uploadTime = 0;
    public BinaryStream content = new BinaryStream();
    public String md5 = "";
    public int total = 0;
    public int step = 0;
}
