package com.autonavi.common.tool.upload;

import android.text.TextUtils;
import com.autonavi.common.tool.util.LogUtil;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import org.apache.commons.compress.archivers.ArchiveStreamFactory;
/* loaded from: classes.dex */
public class UploadFileFilter {
    private static final long MAX_SIZE = 670000;
    private static final String TAG = "UploadFileFilter";
    private File mCrashDir;

    public UploadFileFilter(File file) {
        this.mCrashDir = file;
    }

    public File[] getUploadFiles() {
        File file = this.mCrashDir;
        if (file == null || !file.exists()) {
            LogUtil.log("crash dir is not exist");
            return null;
        }
        clearZipOrEmptyFiles(this.mCrashDir);
        return this.mCrashDir.listFiles(new FilenameFilter() { // from class: com.autonavi.common.tool.upload.UploadFileFilter.1
            @Override // java.io.FilenameFilter
            public boolean accept(File file2, String str) {
                return str.startsWith("crash") && str.endsWith("tmp") && new File(file2, str).length() != 0;
            }
        });
    }

    public File getUploadFilesAndZip(List<File> list, String str) {
        BufferedInputStream bufferedInputStream;
        ZipOutputStream zipOutputStream;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        File[] uploadFiles = getUploadFiles();
        if (uploadFiles == null || uploadFiles.length == 0) {
            LogUtil.log("crash***.tmp is empty");
            return null;
        }
        File file = new File(str);
        try {
            zipOutputStream = new ZipOutputStream(new FileOutputStream(file, true));
            try {
                byte[] bArr = new byte[1024];
                int length = uploadFiles.length;
                long j = 0;
                int i = 0;
                bufferedInputStream = null;
                while (i < length) {
                    try {
                        try {
                            File file2 = uploadFiles[i];
                            if (j + file2.length() >= MAX_SIZE) {
                                break;
                            }
                            BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(file2));
                            try {
                                zipOutputStream.putNextEntry(new ZipEntry(file2.getName()));
                                while (true) {
                                    int read = bufferedInputStream2.read(bArr, 0, 1024);
                                    if (read <= 0) {
                                        break;
                                    }
                                    zipOutputStream.write(bArr, 0, read);
                                }
                                long length2 = file.length();
                                zipOutputStream.closeEntry();
                                bufferedInputStream2.close();
                                list.add(file2);
                                i++;
                                bufferedInputStream = bufferedInputStream2;
                                j = length2;
                            } catch (Exception e) {
                                e = e;
                                bufferedInputStream = bufferedInputStream2;
                                e.printStackTrace();
                                if (zipOutputStream != null) {
                                    try {
                                        zipOutputStream.close();
                                    } catch (IOException unused) {
                                    }
                                }
                                if (bufferedInputStream != null) {
                                    try {
                                        bufferedInputStream.close();
                                    } catch (IOException unused2) {
                                    }
                                }
                                return null;
                            } catch (Throwable th) {
                                th = th;
                                bufferedInputStream = bufferedInputStream2;
                                if (zipOutputStream != null) {
                                    try {
                                        zipOutputStream.close();
                                    } catch (IOException unused3) {
                                    }
                                }
                                if (bufferedInputStream != null) {
                                    try {
                                        bufferedInputStream.close();
                                    } catch (IOException unused4) {
                                    }
                                }
                                throw th;
                            }
                        } catch (Exception e2) {
                            e = e2;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
                if (list.isEmpty()) {
                    LogUtil.log("final file is empty");
                    try {
                        zipOutputStream.close();
                    } catch (IOException unused5) {
                    }
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (IOException unused6) {
                        }
                    }
                    return null;
                }
                File file3 = new File(str);
                try {
                    zipOutputStream.close();
                } catch (IOException unused7) {
                }
                if (bufferedInputStream != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (IOException unused8) {
                    }
                }
                return file3;
            } catch (Exception e3) {
                e = e3;
                bufferedInputStream = null;
            } catch (Throwable th3) {
                th = th3;
                bufferedInputStream = null;
            }
        } catch (Exception e4) {
            e = e4;
            bufferedInputStream = null;
            zipOutputStream = null;
        } catch (Throwable th4) {
            th = th4;
            bufferedInputStream = null;
            zipOutputStream = null;
        }
    }

    private void clearZipOrEmptyFiles(File file) {
        File[] listFiles;
        if (file == null || !file.exists() || (listFiles = file.listFiles(new FilenameFilter() { // from class: com.autonavi.common.tool.upload.UploadFileFilter.2
            @Override // java.io.FilenameFilter
            public boolean accept(File file2, String str) {
                return str.endsWith(ArchiveStreamFactory.ZIP) || new File(file2, str).length() == 0;
            }
        })) == null || listFiles.length == 0) {
            return;
        }
        for (File file2 : listFiles) {
            LogUtil.log(32768, TAG, "file name = " + file2.getName() + " is delete");
            file2.delete();
        }
    }
}
