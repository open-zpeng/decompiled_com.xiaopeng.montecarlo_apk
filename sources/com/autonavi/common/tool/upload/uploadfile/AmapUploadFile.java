package com.autonavi.common.tool.upload.uploadfile;

import android.text.TextUtils;
import com.autonavi.common.tool.ICrashLogController;
import com.autonavi.common.tool.http.HttpEngine;
import com.autonavi.common.tool.util.LogUtil;
import java.io.File;
/* loaded from: classes.dex */
public class AmapUploadFile extends BaseUploadFile {
    /* JADX INFO: Access modifiers changed from: protected */
    public AmapUploadFile(File file, File[] fileArr, ICrashLogController iCrashLogController) {
        super(file, fileArr, iCrashLogController);
    }

    @Override // com.autonavi.common.tool.upload.uploadfile.BaseUploadFile
    public void uploadFile() {
        if (!ensureParamRight()) {
            LogUtil.log("upload file param error");
            return;
        }
        String uploadUrl = this.mController.getUploadUrl(this.mUploadFile);
        if (TextUtils.isEmpty(uploadUrl)) {
            return;
        }
        new HttpEngine().postFileInBody(uploadUrl, this.mUploadFile, this);
    }
}
