package com.xiaopeng.montecarlo.root.util.ioutil;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.Md5Util;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import net.lingala.zip4j.ZipFile;
import net.lingala.zip4j.model.FileHeader;
/* loaded from: classes3.dex */
public class EncryptZipUtil {
    private static final L.Tag TAG = new L.Tag("EncryptZipUtil");

    public static String parseDecodeZipPassword(String str) {
        if (TextUtils.isEmpty(str) || !str.endsWith("_encrypted.zip")) {
            L.Tag tag = TAG;
            L.e(tag, "parseDecodeZipPassword error:" + str);
            return "";
        }
        String upperCase = Md5Util.toMd5Hex(str.replaceAll("_encrypted\\.zip", "")).toUpperCase();
        if (L.ENABLE) {
            L.Tag tag2 = TAG;
            L.d(tag2, "parseDecodeZipPassword fileName:" + str + ",MD5 result:" + upperCase);
        }
        return upperCase;
    }

    public static String uncompressEncodedZip(@NonNull File file, @NonNull String str) {
        List<File> uncompressZip4j;
        try {
            try {
                uncompressZip4j = uncompressZip4j(file.getPath(), str, parseDecodeZipPassword(file.getName()));
            } catch (Exception e) {
                e.printStackTrace();
                if (!file.exists()) {
                    return "";
                }
            }
            if (uncompressZip4j.size() == 1) {
                String absolutePath = uncompressZip4j.get(0).getAbsolutePath();
                if (file.exists()) {
                    file.delete();
                }
                return absolutePath;
            }
            L.Tag tag = TAG;
            L.e(tag, "uncompressEncodedZip file size error:" + uncompressZip4j.size());
            if (!file.exists()) {
                return "";
            }
            file.delete();
            return "";
        } catch (Throwable th) {
            if (file.exists()) {
                file.delete();
            }
            throw th;
        }
    }

    public static List<File> uncompressZip4j(String str, String str2, String str3) throws IOException {
        ZipFile zipFile;
        if (TextUtils.isEmpty(str3)) {
            zipFile = new ZipFile(str);
        } else {
            zipFile = new ZipFile(str, str3.toCharArray());
        }
        zipFile.extractAll(str2);
        List<FileHeader> fileHeaders = zipFile.getFileHeaders();
        ArrayList arrayList = new ArrayList();
        for (FileHeader fileHeader : fileHeaders) {
            if (!fileHeader.isDirectory()) {
                arrayList.add(new File(str2, fileHeader.getFileName()));
            }
        }
        return arrayList;
    }
}
