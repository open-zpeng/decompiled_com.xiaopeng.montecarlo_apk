package com.autonavi.gbl.aosclient.model;

import com.autonavi.gbl.util.model.BinaryStream;
import java.io.Serializable;
/* loaded from: classes.dex */
public class GWsCloudUploadRequestParam extends BLRequestBase implements Serializable {
    public String mode = "";
    public BinaryStream content = new BinaryStream();
    public long uploadTime = 0;
    public int environment = 0;
    public String md5 = "";
    public String log_version = "";
}
