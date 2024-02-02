package com.autonavi.common.tool.upload.uploadfile;

import android.text.TextUtils;
import com.autonavi.common.tool.ICrashLogController;
import com.autonavi.common.tool.http.HttpCallback;
import com.autonavi.common.tool.util.CrashFileManager;
import com.autonavi.common.tool.util.LogUtil;
import com.xiaopeng.speech.protocol.bean.recommend.RecommendBean;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import org.json.JSONObject;
/* loaded from: classes.dex */
public abstract class BaseUploadFile implements HttpCallback {
    protected ICrashLogController mController;
    protected File[] mOriginFileLists;
    protected File mUploadFile;
    protected boolean mUploadSucess = false;

    protected abstract void uploadFile();

    /* JADX INFO: Access modifiers changed from: protected */
    public BaseUploadFile(File file, File[] fileArr, ICrashLogController iCrashLogController) {
        this.mUploadFile = file;
        this.mOriginFileLists = fileArr;
        this.mController = iCrashLogController;
    }

    public void doUpload() {
        uploadFile();
        clearAfterUploadFile();
    }

    protected void clearAfterUploadFile() {
        File file = this.mUploadFile;
        if (file != null) {
            try {
                file.delete();
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean ensureParamRight() {
        File[] fileArr;
        File file = this.mUploadFile;
        return (file == null || !file.exists() || (fileArr = this.mOriginFileLists) == null || fileArr.length == 0 || this.mController == null) ? false : true;
    }

    public boolean isUploadSucess() {
        return this.mUploadSucess;
    }

    protected void deleteFileList(File[] fileArr) {
        if (fileArr == null || fileArr.length == 0) {
            return;
        }
        for (File file : fileArr) {
            try {
                file.delete();
            } catch (Throwable th) {
                th.printStackTrace();
            }
            if (file.exists()) {
                try {
                    new FileWriter(file, false).close();
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
        }
    }

    @Override // com.autonavi.common.tool.http.HttpCallback
    public void onError(Throwable th) {
        th.printStackTrace();
        CrashFileManager crashFileManager = CrashFileManager.getInstance();
        File[] fileArr = this.mOriginFileLists;
        crashFileManager.appendUploadFlag(fileArr, " uploadFailed. exception:" + th.toString());
    }

    @Override // com.autonavi.common.tool.http.HttpCallback
    public void onFinish(HttpURLConnection httpURLConnection) throws Throwable {
        LogUtil.logE("http on Finish");
        try {
            try {
                try {
                    int responseCode = httpURLConnection.getResponseCode();
                    InputStream inputStream = httpURLConnection.getInputStream();
                    StringBuilder sb = new StringBuilder();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "utf-8"));
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        sb.append(readLine);
                    }
                    String sb2 = sb.toString();
                    LogUtil.logE(sb2);
                    String str = "";
                    boolean z = false;
                    if (!TextUtils.isEmpty(sb2)) {
                        JSONObject jSONObject = new JSONObject(sb2);
                        z = jSONObject.optBoolean(RecommendBean.SHOW_TIME_RESULT, false);
                        str = jSONObject.optString("message", "");
                        if (responseCode < 300 && z) {
                            LogUtil.logE("http success");
                            deleteFileList(this.mOriginFileLists);
                            this.mUploadSucess = true;
                        }
                    }
                    if (!this.mUploadSucess) {
                        LogUtil.logE("http error");
                        CrashFileManager crashFileManager = CrashFileManager.getInstance();
                        File[] fileArr = this.mOriginFileLists;
                        crashFileManager.appendUploadFlag(fileArr, " uploadFailed. result:" + responseCode + " errorMessage:" + str + " result:" + z);
                    }
                    if (httpURLConnection == null || httpURLConnection.getInputStream() == null) {
                        return;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    CrashFileManager crashFileManager2 = CrashFileManager.getInstance();
                    File[] fileArr2 = this.mOriginFileLists;
                    crashFileManager2.appendUploadFlag(fileArr2, " uploadFailed. exception:" + e.toString());
                    if (httpURLConnection == null || httpURLConnection.getInputStream() == null) {
                        return;
                    }
                }
                httpURLConnection.getInputStream().close();
            } catch (Exception unused) {
            }
        } catch (Throwable th) {
            if (httpURLConnection != null) {
                try {
                    if (httpURLConnection.getInputStream() != null) {
                        httpURLConnection.getInputStream().close();
                    }
                } catch (Exception unused2) {
                }
            }
            throw th;
        }
    }
}
