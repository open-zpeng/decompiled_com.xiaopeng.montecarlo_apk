package com.autonavi.common.tool.upload.uploadfile;

import com.autonavi.common.tool.ICrashLogController;
import java.io.File;
/* loaded from: classes.dex */
public final class UploadFileFactory {
    public BaseUploadFile createUploadFile(File file, File[] fileArr, ICrashLogController iCrashLogController) {
        if (iCrashLogController == null) {
            return null;
        }
        if (iCrashLogController.useRestUploadInterface()) {
            return new RestUploadFile(file, fileArr, iCrashLogController);
        }
        return new AmapUploadFile(file, fileArr, iCrashLogController);
    }
}
