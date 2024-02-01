package com.alibaba.android.ark;

import java.io.Serializable;
import java.util.HashMap;
/* loaded from: classes.dex */
public final class AIMMsgTextContent implements Serializable {
    private static final long serialVersionUID = 6800891814637130955L;
    public String encryptedText;
    public HashMap<String, String> extension;
    public String text;

    public AIMMsgTextContent(String str, String str2, HashMap<String, String> hashMap) {
        this.text = str;
        this.encryptedText = str2;
        this.extension = hashMap;
    }

    public AIMMsgTextContent() {
    }

    public String getText() {
        return this.text;
    }

    public String getEncryptedText() {
        return this.encryptedText;
    }

    public HashMap<String, String> getExtension() {
        return this.extension;
    }

    public String toString() {
        return "AIMMsgTextContent{text=" + this.text + ",encryptedText=" + this.encryptedText + ",extension=" + this.extension + "}";
    }
}
