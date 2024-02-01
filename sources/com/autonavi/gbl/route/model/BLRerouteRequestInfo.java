package com.autonavi.gbl.route.model;

import android.util.Log;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.common.path.option.RouteOption;
import com.autonavi.gbl.common.path.option.impl.IRouteOptionImpl;
import com.autonavi.gbl.util.errorcode.Route;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Set;
/* loaded from: classes2.dex */
public class BLRerouteRequestInfo implements Serializable {
    private int errCode;
    private TypeHelper mTypeHelper;
    private IRouteOptionImpl option;
    private long requestId;

    public void delete() {
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mTypeHelper = null;
        }
    }

    private void initTypeHelper() {
        this.mTypeHelper = new TypeHelper("BLRerouteRequestInfo" + hashCode());
    }

    private void recordByIntfAuto() {
        getOption();
    }

    public void setRequestId(long j) {
        this.requestId = j;
    }

    public long getRequestId() {
        return this.requestId;
    }

    public void setErrCode(int i) {
        this.errCode = i;
    }

    public int getErrCode() {
        return this.errCode;
    }

    public void setOption(RouteOption routeOption) {
        ReflexTool.EM(new Object() { // from class: com.autonavi.gbl.route.model.BLRerouteRequestInfo.1
        });
        try {
            Method method = getClass().getMethod("setOption", RouteOption.class);
            TypeHelper typeHelper = this.mTypeHelper;
            if (typeHelper != null) {
                Set bindSet = typeHelper.getBindSet(method, 0);
                bindSet.remove(routeOption);
                this.option = (IRouteOptionImpl) this.mTypeHelper.transfer(method, 0, routeOption);
                this.mTypeHelper.unbindSet(method, 0, bindSet);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public RouteOption getOption() {
        if (this.mTypeHelper != null && this.option != null) {
            ReflexTool.EM(new Object() { // from class: com.autonavi.gbl.route.model.BLRerouteRequestInfo.2
            });
            try {
                return (RouteOption) this.mTypeHelper.transfer(getClass().getMethod("getOption", new Class[0]), -1, (Object) this.option, true);
            } catch (Exception e) {
                Log.w("INTFAUTO", Log.getStackTraceString(e));
            }
        }
        return null;
    }

    public BLRerouteRequestInfo() {
        initTypeHelper();
        this.requestId = 0L;
        this.errCode = Route.ErrorCodeUnknown;
        this.option = null;
        recordByIntfAuto();
    }

    protected BLRerouteRequestInfo(long j, int i, IRouteOptionImpl iRouteOptionImpl) {
        initTypeHelper();
        this.requestId = j;
        this.errCode = i;
        this.option = iRouteOptionImpl;
        recordByIntfAuto();
    }

    public BLRerouteRequestInfo(long j, int i, RouteOption routeOption) {
        initTypeHelper();
        Constructor EC = ReflexTool.EC(new Object() { // from class: com.autonavi.gbl.route.model.BLRerouteRequestInfo.3
        });
        this.requestId = j;
        this.errCode = i;
        TypeHelper typeHelper = this.mTypeHelper;
        this.option = typeHelper != null ? (IRouteOptionImpl) typeHelper.transfer(EC, 2, routeOption) : null;
        recordByIntfAuto();
    }
}
