package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GWsMapapiPoiCodepointRequestParam extends BLRequestBase implements Serializable {
    public GCodepointRequestClassify classifyRequest = new GCodepointRequestClassify();
    public GCodepointRequestKeyword keywordRequest = new GCodepointRequestKeyword();
    public int requestType = 0;
}
