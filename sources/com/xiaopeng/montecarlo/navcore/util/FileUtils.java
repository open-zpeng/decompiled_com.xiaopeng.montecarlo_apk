package com.xiaopeng.montecarlo.navcore.util;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
/* loaded from: classes3.dex */
public class FileUtils {
    @NonNull
    public static byte[] readAllBytes(@NonNull String str) {
        return readAllBytes(new File(str));
    }

    @NonNull
    public static byte[] readAllBytes(@Nullable File file) {
        FileInputStream fileInputStream;
        byte[] bArr = new byte[0];
        if (file == null || !file.exists()) {
            return bArr;
        }
        FileChannel fileChannel = null;
        try {
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    fileChannel = fileInputStream.getChannel();
                    ByteBuffer allocate = ByteBuffer.allocate((int) fileChannel.size());
                    while (fileChannel.read(allocate) > 0) {
                    }
                    byte[] array = allocate.array();
                    safetyClose(fileChannel);
                    safetyClose(fileInputStream);
                    return array;
                } catch (IOException e) {
                    e = e;
                    e.printStackTrace();
                    safetyClose(fileChannel);
                    safetyClose(fileInputStream);
                    return bArr;
                }
            } catch (Throwable th) {
                th = th;
                safetyClose(null);
                safetyClose(null);
                throw th;
            }
        } catch (IOException e2) {
            e = e2;
            fileInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            safetyClose(null);
            safetyClose(null);
            throw th;
        }
    }

    public static void safetyClose(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
