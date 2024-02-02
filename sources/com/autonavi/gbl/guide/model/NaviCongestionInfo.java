package com.autonavi.gbl.guide.model;

import android.util.Log;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.guide.model.impl.NaviCongestionInfoImpl;
import java.lang.reflect.Method;
import java.util.ArrayList;
@IntfAuto(target = NaviCongestionInfoImpl.class, type = BuildType.JCTRL)
/* loaded from: classes.dex */
public class NaviCongestionInfo {
    private static String PACKAGE = ReflexTool.PN(NaviCongestionInfo.class);
    private NaviCongestionInfoImpl mControl;
    private boolean mHasDestroy;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected NaviCongestionInfo(long j, boolean z) {
        this(new NaviCongestionInfoImpl(j, z));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(NaviCongestionInfo.class, this, this.mControl);
        }
    }

    public NaviCongestionInfo() {
        this(new NaviCongestionInfoImpl());
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(NaviCongestionInfo.class, this, this.mControl);
        }
    }

    public NaviCongestionInfo(NaviCongestionInfoImpl naviCongestionInfoImpl) {
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mHasDestroy = false;
        this.mControl = null;
        $constructor(naviCongestionInfoImpl);
    }

    private void $constructor(NaviCongestionInfoImpl naviCongestionInfoImpl) {
        if (naviCongestionInfoImpl != null) {
            this.mControl = naviCongestionInfoImpl;
            this.mTargetId = String.format("NaviCongestionInfo_%s_%d", String.valueOf(NaviCongestionInfoImpl.getCPtr(this.mControl)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    protected NaviCongestionInfoImpl getControl() {
        return this.mControl;
    }

    public void setPathID(long j) {
        NaviCongestionInfoImpl naviCongestionInfoImpl = this.mControl;
        if (naviCongestionInfoImpl != null) {
            naviCongestionInfoImpl.setPathID(j);
        }
    }

    public long getPathID() {
        NaviCongestionInfoImpl naviCongestionInfoImpl = this.mControl;
        if (naviCongestionInfoImpl != null) {
            return naviCongestionInfoImpl.getPathID();
        }
        return 0L;
    }

    public void setTotalTimeOfSeconds(long j) {
        NaviCongestionInfoImpl naviCongestionInfoImpl = this.mControl;
        if (naviCongestionInfoImpl != null) {
            naviCongestionInfoImpl.setTotalTimeOfSeconds(j);
        }
    }

    public long getTotalTimeOfSeconds() {
        NaviCongestionInfoImpl naviCongestionInfoImpl = this.mControl;
        if (naviCongestionInfoImpl != null) {
            return naviCongestionInfoImpl.getTotalTimeOfSeconds();
        }
        return 0L;
    }

    public void setTotalRemainDist(long j) {
        NaviCongestionInfoImpl naviCongestionInfoImpl = this.mControl;
        if (naviCongestionInfoImpl != null) {
            naviCongestionInfoImpl.setTotalRemainDist(j);
        }
    }

    public long getTotalRemainDist() {
        NaviCongestionInfoImpl naviCongestionInfoImpl = this.mControl;
        if (naviCongestionInfoImpl != null) {
            return naviCongestionInfoImpl.getTotalRemainDist();
        }
        return 0L;
    }

    public void setUnobstructed(boolean z) {
        NaviCongestionInfoImpl naviCongestionInfoImpl = this.mControl;
        if (naviCongestionInfoImpl != null) {
            naviCongestionInfoImpl.setUnobstructed(z);
        }
    }

    public boolean getUnobstructed() {
        NaviCongestionInfoImpl naviCongestionInfoImpl = this.mControl;
        if (naviCongestionInfoImpl != null) {
            return naviCongestionInfoImpl.getUnobstructed();
        }
        return false;
    }

    public void setCongestionInfos(ArrayList<NaviCongestionDetailInfo> arrayList) {
        NaviCongestionInfoImpl naviCongestionInfoImpl = this.mControl;
        if (naviCongestionInfoImpl != null) {
            naviCongestionInfoImpl.setCongestionInfos(arrayList);
        }
    }

    public ArrayList<NaviCongestionDetailInfo> getCongestionInfos() {
        NaviCongestionInfoImpl naviCongestionInfoImpl = this.mControl;
        if (naviCongestionInfoImpl != null) {
            return naviCongestionInfoImpl.getCongestionInfos();
        }
        return null;
    }

    public void setExtend(CongestExtend congestExtend) {
        NaviCongestionInfoImpl naviCongestionInfoImpl = this.mControl;
        if (naviCongestionInfoImpl != null) {
            naviCongestionInfoImpl.setExtend(congestExtend);
        }
    }

    public CongestExtend getExtend() {
        NaviCongestionInfoImpl naviCongestionInfoImpl = this.mControl;
        if (naviCongestionInfoImpl != null) {
            return naviCongestionInfoImpl.getExtend();
        }
        return null;
    }

    public void copy(NaviCongestionInfo naviCongestionInfo) {
        try {
            Method method = NaviCongestionInfo.class.getMethod("copy", NaviCongestionInfo.class);
            if (naviCongestionInfo != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r1 = typeHelper != null ? (NaviCongestionInfoImpl) typeHelper.transfer(method, 0, naviCongestionInfo) : null;
                if (r1 == null) {
                    DebugTool.e("%s: $src == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.guide.model.NaviCongestionInfo.1
                    }));
                }
            }
            NaviCongestionInfoImpl naviCongestionInfoImpl = this.mControl;
            if (naviCongestionInfoImpl != null) {
                naviCongestionInfoImpl.copy(r1);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.guide.model.NaviCongestionInfo.2
        });
        objArr[1] = String.valueOf(this.mTypeHelper != null);
        DebugTool.d("%s: mTypeHelper=%s", objArr);
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mTypeHelper = null;
        }
    }

    public void onDestroy() {
        this.mHasDestroy = true;
        clean();
    }

    protected void clean() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.guide.model.NaviCongestionInfo.3
        }));
    }

    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.guide.model.NaviCongestionInfo.4
        }));
        if (!this.mHasDestroy) {
            onDestroy();
        }
        if (this.mTypeHelper != null) {
            TypeHelper typeHelper = this.mTypeHelper;
            TypeHelper.unbindAllTarget(PACKAGE, this);
        }
        if (this.mControl != null) {
            ReflexTool.invokeDeclMethodSafe(this.mControl, RequestParameters.SUBRESOURCE_DELETE, null, null);
            this.mControl = null;
        }
        unbind();
    }
}
