package com.autonavi.gbl.layer.model;

import android.util.Log;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.common.path.option.PathInfo;
import com.autonavi.gbl.common.path.option.impl.PathInfoImpl;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Set;
/* loaded from: classes.dex */
public class BizPathInfoAttrs implements Serializable {
    private BizRouteDrawCtrlAttrs mDrawAtts;
    private PathInfoImpl mPathInfo;
    private TypeHelper mTypeHelper;

    public void delete() {
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mTypeHelper = null;
        }
    }

    private void initTypeHelper() {
        this.mTypeHelper = new TypeHelper("BizPathInfoAttrs" + hashCode());
    }

    private void recordByIntfAuto() {
        getPathInfo();
    }

    public void setPathInfo(PathInfo pathInfo) {
        ReflexTool.EM(new Object() { // from class: com.autonavi.gbl.layer.model.BizPathInfoAttrs.1
        });
        try {
            Method method = getClass().getMethod("setPathInfo", PathInfo.class);
            TypeHelper typeHelper = this.mTypeHelper;
            if (typeHelper != null) {
                Set bindSet = typeHelper.getBindSet(method, 0);
                bindSet.remove(pathInfo);
                this.mPathInfo = (PathInfoImpl) this.mTypeHelper.transfer(method, 0, pathInfo);
                this.mTypeHelper.unbindSet(method, 0, bindSet);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public PathInfo getPathInfo() {
        if (this.mTypeHelper != null && this.mPathInfo != null) {
            ReflexTool.EM(new Object() { // from class: com.autonavi.gbl.layer.model.BizPathInfoAttrs.2
            });
            try {
                return (PathInfo) this.mTypeHelper.transfer(getClass().getMethod("getPathInfo", new Class[0]), -1, (Object) this.mPathInfo, true);
            } catch (Exception e) {
                Log.w("INTFAUTO", Log.getStackTraceString(e));
            }
        }
        return null;
    }

    public void setDrawAtts(BizRouteDrawCtrlAttrs bizRouteDrawCtrlAttrs) {
        this.mDrawAtts = bizRouteDrawCtrlAttrs;
    }

    public BizRouteDrawCtrlAttrs getDrawAtts() {
        return this.mDrawAtts;
    }

    public BizPathInfoAttrs() {
        initTypeHelper();
        Constructor EC = ReflexTool.EC(new Object() { // from class: com.autonavi.gbl.layer.model.BizPathInfoAttrs.3
        });
        TypeHelper typeHelper = this.mTypeHelper;
        this.mPathInfo = typeHelper != null ? (PathInfoImpl) typeHelper.transfer(EC, 0, new PathInfo()) : null;
        this.mDrawAtts = new BizRouteDrawCtrlAttrs();
        recordByIntfAuto();
    }

    protected BizPathInfoAttrs(PathInfoImpl pathInfoImpl, BizRouteDrawCtrlAttrs bizRouteDrawCtrlAttrs) {
        initTypeHelper();
        this.mPathInfo = pathInfoImpl;
        this.mDrawAtts = bizRouteDrawCtrlAttrs;
        recordByIntfAuto();
    }

    public BizPathInfoAttrs(PathInfo pathInfo, BizRouteDrawCtrlAttrs bizRouteDrawCtrlAttrs) {
        initTypeHelper();
        Constructor EC = ReflexTool.EC(new Object() { // from class: com.autonavi.gbl.layer.model.BizPathInfoAttrs.4
        });
        TypeHelper typeHelper = this.mTypeHelper;
        this.mPathInfo = typeHelper != null ? (PathInfoImpl) typeHelper.transfer(EC, 0, pathInfo) : null;
        this.mDrawAtts = bizRouteDrawCtrlAttrs;
        recordByIntfAuto();
    }
}
