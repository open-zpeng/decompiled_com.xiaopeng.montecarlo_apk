package com.autonavi.gbl.common.model;

import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.common.model.impl.UserConfigImpl;
@IntfAuto(target = UserConfigImpl.class, type = BuildType.JCTRL)
/* loaded from: classes.dex */
public class UserConfig {
    private static String PACKAGE = ReflexTool.PN(UserConfig.class);
    private UserConfigImpl mControl;
    private boolean mHasDestroy;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected UserConfig(long j, boolean z) {
        this(new UserConfigImpl(j, z));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(UserConfig.class, this, this.mControl);
        }
    }

    public UserConfig() {
        this(new UserConfigImpl());
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(UserConfig.class, this, this.mControl);
        }
    }

    public UserConfig(UserConfigImpl userConfigImpl) {
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mHasDestroy = false;
        this.mControl = null;
        $constructor(userConfigImpl);
    }

    private void $constructor(UserConfigImpl userConfigImpl) {
        if (userConfigImpl != null) {
            this.mControl = userConfigImpl;
            this.mTargetId = String.format("UserConfig_%s_%d", String.valueOf(UserConfigImpl.getCPtr(this.mControl)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    protected UserConfigImpl getControl() {
        return this.mControl;
    }

    public void setUserCode(String str) {
        UserConfigImpl userConfigImpl = this.mControl;
        if (userConfigImpl != null) {
            userConfigImpl.setUserCode(str);
        }
    }

    public String getUserCode() {
        UserConfigImpl userConfigImpl = this.mControl;
        if (userConfigImpl != null) {
            return userConfigImpl.getUserCode();
        }
        return null;
    }

    public void setUserBatch(String str) {
        UserConfigImpl userConfigImpl = this.mControl;
        if (userConfigImpl != null) {
            userConfigImpl.setUserBatch(str);
        }
    }

    public String getUserBatch() {
        UserConfigImpl userConfigImpl = this.mControl;
        if (userConfigImpl != null) {
            return userConfigImpl.getUserBatch();
        }
        return null;
    }

    public void setDeviceID(String str) {
        UserConfigImpl userConfigImpl = this.mControl;
        if (userConfigImpl != null) {
            userConfigImpl.setDeviceID(str);
        }
    }

    public String getDeviceID() {
        UserConfigImpl userConfigImpl = this.mControl;
        if (userConfigImpl != null) {
            return userConfigImpl.getDeviceID();
        }
        return null;
    }

    public void setPassword(String str) {
        UserConfigImpl userConfigImpl = this.mControl;
        if (userConfigImpl != null) {
            userConfigImpl.setPassword(str);
        }
    }

    public String getPassword() {
        UserConfigImpl userConfigImpl = this.mControl;
        if (userConfigImpl != null) {
            return userConfigImpl.getPassword();
        }
        return null;
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.common.model.UserConfig.1
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
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.common.model.UserConfig.2
        }));
    }

    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.common.model.UserConfig.3
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
