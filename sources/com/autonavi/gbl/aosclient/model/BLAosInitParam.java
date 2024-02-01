package com.autonavi.gbl.aosclient.model;

import android.util.Log;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.aosclient.observer.ICallBackAuthentication;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackAuthenticationImpl;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Set;
/* loaded from: classes.dex */
public class BLAosInitParam implements Serializable {
    private boolean mAuthentication;
    private ICallBackAuthenticationImpl mCallback;
    private String mStrAuthenticationDBPath;
    private TypeHelper mTypeHelper;
    private String pid;
    private String vid;

    public void delete() {
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mTypeHelper = null;
        }
    }

    private void initTypeHelper() {
        this.mTypeHelper = new TypeHelper("BLAosInitParam" + hashCode());
    }

    private void recordByIntfAuto() {
        getCallback();
    }

    public void setAuthentication(boolean z) {
        this.mAuthentication = z;
    }

    public boolean getAuthentication() {
        return this.mAuthentication;
    }

    public void setStrAuthenticationDBPath(String str) {
        this.mStrAuthenticationDBPath = str;
    }

    public String getStrAuthenticationDBPath() {
        return this.mStrAuthenticationDBPath;
    }

    public void setVid(String str) {
        this.vid = str;
    }

    public String getVid() {
        return this.vid;
    }

    public void setPid(String str) {
        this.pid = str;
    }

    public String getPid() {
        return this.pid;
    }

    public void setCallback(ICallBackAuthentication iCallBackAuthentication) {
        ReflexTool.EM(new Object() { // from class: com.autonavi.gbl.aosclient.model.BLAosInitParam.1
        });
        try {
            Method method = getClass().getMethod("setCallback", ICallBackAuthentication.class);
            TypeHelper typeHelper = this.mTypeHelper;
            if (typeHelper != null) {
                Set bindSet = typeHelper.getBindSet(method, 0);
                bindSet.remove(iCallBackAuthentication);
                this.mCallback = (ICallBackAuthenticationImpl) this.mTypeHelper.transfer(method, 0, iCallBackAuthentication);
                this.mTypeHelper.unbindSet(method, 0, bindSet);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public ICallBackAuthentication getCallback() {
        if (this.mTypeHelper != null && this.mCallback != null) {
            ReflexTool.EM(new Object() { // from class: com.autonavi.gbl.aosclient.model.BLAosInitParam.2
            });
            try {
                return (ICallBackAuthentication) this.mTypeHelper.transfer(getClass().getMethod("getCallback", new Class[0]), -1, (Object) this.mCallback, true);
            } catch (Exception e) {
                Log.w("INTFAUTO", Log.getStackTraceString(e));
            }
        }
        return null;
    }

    public BLAosInitParam() {
        initTypeHelper();
        this.mAuthentication = false;
        this.mStrAuthenticationDBPath = "";
        this.vid = "";
        this.pid = "";
        this.mCallback = null;
        recordByIntfAuto();
    }

    protected BLAosInitParam(boolean z, String str, String str2, String str3, ICallBackAuthenticationImpl iCallBackAuthenticationImpl) {
        initTypeHelper();
        this.mAuthentication = z;
        this.mStrAuthenticationDBPath = str;
        this.vid = str2;
        this.pid = str3;
        this.mCallback = iCallBackAuthenticationImpl;
        recordByIntfAuto();
    }

    public BLAosInitParam(boolean z, String str, String str2, String str3, ICallBackAuthentication iCallBackAuthentication) {
        initTypeHelper();
        Constructor EC = ReflexTool.EC(new Object() { // from class: com.autonavi.gbl.aosclient.model.BLAosInitParam.3
        });
        this.mAuthentication = z;
        this.mStrAuthenticationDBPath = str;
        this.vid = str2;
        this.pid = str3;
        TypeHelper typeHelper = this.mTypeHelper;
        this.mCallback = typeHelper != null ? (ICallBackAuthenticationImpl) typeHelper.transfer(EC, 4, iCallBackAuthentication) : null;
        recordByIntfAuto();
    }
}
