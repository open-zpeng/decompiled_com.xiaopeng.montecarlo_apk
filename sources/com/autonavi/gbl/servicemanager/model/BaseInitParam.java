package com.autonavi.gbl.servicemanager.model;

import com.autonavi.auto.bl.puglin.annotations.JniDto;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.util.observer.IPlatformInterface;
import com.autonavi.gbl.util.observer.impl.IPlatformInterfaceImpl;
@JniDto
/* loaded from: classes2.dex */
public class BaseInitParam {
    private static long BL_DEFAULT_MAX_FILES = 40;
    private static long BL_DEFAULT_MAX_FILE_SIZE = 20971520;
    public long maxFileSize;
    public long maxFiles;
    public long recordCacheMaxFileSize;
    public long recordCacheMaxFiles;
    private TypeHelper _typeHepler = new TypeHelper("BaseInitParam_");
    private long pPlatformUtil = 0;
    public String logFileName = "BLLog";
    public String logPath = "./";
    public long logLevel = ALCLogLevel.LogLevelNone;
    public long groupMask = ALCGroup.GROUP_MASK_BL;
    public int serverType = 0;
    public String restKey = "";
    public String restSecurityCode = "";
    public String restConfigPath = "";
    public String aosDBPath = "";
    public boolean bLogcat = false;
    public boolean async = false;

    public void setIPlatformInterface(IPlatformInterface iPlatformInterface) {
        IPlatformInterfaceImpl iPlatformInterfaceImpl = (IPlatformInterfaceImpl) this._typeHepler.transfer("com.autonavi.gbl.util.observer.impl.IPlatformInterfaceImpl", (Object) iPlatformInterface, true);
        if (iPlatformInterfaceImpl != null) {
            this.pPlatformUtil = IPlatformInterfaceImpl.getCPtr(iPlatformInterfaceImpl);
        }
    }

    public long getPlatformUtil() {
        return this.pPlatformUtil;
    }

    public BaseInitParam() {
        long j = BL_DEFAULT_MAX_FILES;
        this.maxFiles = j;
        long j2 = BL_DEFAULT_MAX_FILE_SIZE;
        this.maxFileSize = j2;
        this.recordCacheMaxFiles = j;
        this.recordCacheMaxFileSize = j2;
    }
}
