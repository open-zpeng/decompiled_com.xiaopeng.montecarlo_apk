package com.autonavi.common.tool.upload.uploadfile;

import android.text.TextUtils;
import com.autonavi.common.tool.ICrashLogController;
import com.autonavi.common.tool.http.HttpEngine;
import com.autonavi.common.tool.util.AESUtils;
import com.autonavi.common.tool.util.CrashFileManager;
import com.autonavi.common.tool.util.LogUtil;
import com.autonavi.common.tool.util.MessageDigestUtil;
import com.xiaopeng.montecarlo.navcore.location.LocationUtils;
import java.io.File;
/* loaded from: classes.dex */
public class RestUploadFile extends BaseUploadFile {
    private static final String ONLINE_URL = "http://autoapi.amap.com/ws/page/upload";
    private static final String TEST_URL = "http://test.autoapi.amap.com/ws/page/upload";

    /* JADX INFO: Access modifiers changed from: protected */
    public RestUploadFile(File file, File[] fileArr, ICrashLogController iCrashLogController) {
        super(file, fileArr, iCrashLogController);
        LogUtil.logE("Using RestUploadFile");
    }

    @Override // com.autonavi.common.tool.upload.uploadfile.BaseUploadFile
    public void uploadFile() {
        if (!ensureParamRight()) {
            LogUtil.logE("upload param error");
            return;
        }
        String restUploadUrl = this.mController.getRestUploadUrl();
        String valueOf = String.valueOf(this.mController.getUploadParamProduct());
        String uploadParamSecurityCode = this.mController.getUploadParamSecurityCode();
        String uploadParamKey = this.mController.getUploadParamKey();
        if (TextUtils.isEmpty(uploadParamKey) || TextUtils.isEmpty(uploadParamSecurityCode) || TextUtils.isEmpty(valueOf)) {
            LogUtil.logE("upload param lack");
            return;
        }
        String dip = this.mController.getDip();
        String diu = this.mController.getDiu();
        String div = this.mController.getDiv();
        String dic = this.mController.getDic();
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        String stringMD5 = MessageDigestUtil.getStringMD5("key=" + uploadParamKey + "&timestamp=" + currentTimeMillis + LocationUtils.DR_RECORD_VALUE_SPLIT_CHAR + uploadParamSecurityCode);
        StringBuilder sb = new StringBuilder();
        appendParam(sb, "product", valueOf);
        appendParam(sb, "type", "1");
        appendParam(sb, "platform", "1");
        appendParam(sb, "dip", dip);
        appendParam(sb, "diu", diu);
        appendParam(sb, "div", div);
        appendParam(sb, "dic", dic);
        String sb2 = sb.toString();
        LogUtil.logE("rest queryStr = " + sb2);
        try {
            String Encrypt = AESUtils.Encrypt(sb2);
            HttpEngine httpEngine = new HttpEngine();
            httpEngine.restPostFileInBody(restUploadUrl + "?" + Encrypt, currentTimeMillis, uploadParamKey, stringMD5, this.mUploadFile, this);
        } catch (Exception unused) {
            CrashFileManager.getInstance().appendUploadFlag(this.mOriginFileLists, " uploadFailed.");
        }
    }

    private void appendParam(StringBuilder sb, String str, String str2) {
        if (sb == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        if (sb.length() != 0) {
            sb.append("&");
        }
        sb.append(str);
        sb.append("=");
        sb.append(str2);
    }
}
