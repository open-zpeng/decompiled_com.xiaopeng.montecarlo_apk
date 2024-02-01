package com.autonavi.gbl.layer.model;

import com.autonavi.gbl.common.path.option.PathInfo;
import java.io.Serializable;
/* loaded from: classes2.dex */
public class BizPathInfoAttrs implements Serializable {
    public BizRouteDrawCtrlAttrs mDrawAtts;
    public PathInfo mPathInfo;

    public BizPathInfoAttrs() {
        this.mPathInfo = new PathInfo();
        this.mDrawAtts = new BizRouteDrawCtrlAttrs();
    }

    public BizPathInfoAttrs(PathInfo pathInfo, BizRouteDrawCtrlAttrs bizRouteDrawCtrlAttrs) {
        this.mPathInfo = pathInfo;
        this.mDrawAtts = bizRouteDrawCtrlAttrs;
    }
}
