package com.autonavi.common.tool.http;

import com.alibaba.sdk.android.oss.common.OSSConstants;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.util.List;
/* loaded from: classes.dex */
class MultipartEntity implements HttpEntity {
    private static byte[] BOUNDARY_PREFIX_BYTES = "--------7da3d81520810".getBytes();
    private static byte[] END_BYTES = "\r\n".getBytes();
    private static byte[] TWO_DASHES_BYTES = "--".getBytes();
    private byte[] boundaryPostfixBytes;
    private String charset;
    private String contentType;
    private List<KeyValuePair> multipartParams;

    public MultipartEntity(List<KeyValuePair> list, String str) {
        this.multipartParams = list;
        this.charset = str;
        generateContentType();
    }

    private void generateContentType() {
        String hexString = Double.toHexString(Math.random() * 65535.0d);
        this.boundaryPostfixBytes = hexString.getBytes();
        this.contentType = "multipart/form-data; boundary=" + new String(BOUNDARY_PREFIX_BYTES) + hexString;
    }

    @Override // com.autonavi.common.tool.http.HttpEntity
    public String getContentType() {
        return this.contentType;
    }

    @Override // com.autonavi.common.tool.http.HttpEntity
    public void writeTo(OutputStream outputStream) throws IOException {
        for (KeyValuePair keyValuePair : this.multipartParams) {
            writeEntry(outputStream, this.charset, keyValuePair.key, keyValuePair.value, this.boundaryPostfixBytes);
        }
        byte[] bArr = TWO_DASHES_BYTES;
        writeLine(outputStream, bArr, BOUNDARY_PREFIX_BYTES, this.boundaryPostfixBytes, bArr);
        outputStream.flush();
    }

    private void writeEntry(OutputStream outputStream, String str, String str2, Object obj, byte[] bArr) throws IOException {
        byte[] bytes;
        writeLine(outputStream, TWO_DASHES_BYTES, BOUNDARY_PREFIX_BYTES, bArr);
        if (obj instanceof File) {
            File file = (File) obj;
            String name = file.getName();
            String guessContentTypeFromName = HttpURLConnection.guessContentTypeFromName(name);
            if (guessContentTypeFromName == null) {
                guessContentTypeFromName = OSSConstants.DEFAULT_OBJECT_CONTENT_TYPE;
            }
            String replaceFirst = guessContentTypeFromName.replaceFirst("\\/jpg$", "/jpeg");
            writeLine(outputStream, ("Content-Disposition: form-data; name=\"" + str2 + "\"; filename=\"" + name + "\"").getBytes());
            StringBuilder sb = new StringBuilder();
            sb.append("Content-Type: ");
            sb.append(replaceFirst);
            writeLine(outputStream, sb.toString().getBytes(), END_BYTES);
            writeStreamAndCloseIn(outputStream, new FileInputStream(file));
            return;
        }
        writeLine(outputStream, ("Content-Disposition: form-data; name=\"" + str2 + "\"").getBytes(), END_BYTES);
        if (obj instanceof InputStream) {
            writeStreamAndCloseIn(outputStream, (InputStream) obj);
            return;
        }
        if (obj instanceof byte[]) {
            bytes = (byte[]) obj;
        } else {
            bytes = String.valueOf(obj).getBytes(str);
        }
        writeLine(outputStream, bytes);
    }

    private void writeLine(OutputStream outputStream, byte[]... bArr) throws IOException {
        for (byte[] bArr2 : bArr) {
            outputStream.write(bArr2);
        }
        outputStream.write(END_BYTES);
    }

    private void writeStreamAndCloseIn(OutputStream outputStream, InputStream inputStream) throws IOException {
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read >= 0) {
                outputStream.write(bArr, 0, read);
            } else {
                inputStream.close();
                outputStream.write(END_BYTES);
                return;
            }
        }
    }
}
