package com.xiaopeng.montecarlo.root.util.ioutil;

import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.RootUtil;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
/* loaded from: classes2.dex */
public class FileIOUtil<T> {
    private static final L.Tag TAG = new L.Tag("FileIOUtil");
    private Class<T> mClazz;

    public FileIOUtil() {
        this.mClazz = null;
    }

    public FileIOUtil(Class<T> cls) {
        this.mClazz = null;
        if (cls == null) {
            throw new NullPointerException();
        }
        this.mClazz = cls;
    }

    public static boolean makeDirs(String str) {
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.exists();
    }

    public static String readString(String str) {
        String str2;
        File file = new File(str);
        BufferedReader bufferedReader = null;
        String str3 = null;
        bufferedReader = null;
        if (!file.exists() || file.isDirectory()) {
            L.e(TAG, "open failed:" + file.exists() + file.isDirectory());
            return null;
        }
        StringBuilder sb = new StringBuilder();
        try {
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new FileReader(str));
                while (true) {
                    try {
                        str3 = bufferedReader2.readLine();
                        if (str3 != null) {
                            sb.append(str3.trim());
                        } else {
                            String sb2 = sb.toString();
                            try {
                                bufferedReader2.close();
                                return sb2;
                            } catch (IOException e) {
                                e.printStackTrace();
                                return sb2;
                            }
                        }
                    } catch (Exception e2) {
                        e = e2;
                        str2 = str3;
                        bufferedReader = bufferedReader2;
                        L.e(TAG, e.getMessage());
                        e.printStackTrace();
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e3) {
                                e3.printStackTrace();
                            }
                        }
                        return str2;
                    } catch (Throwable th) {
                        th = th;
                        bufferedReader = bufferedReader2;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e4) {
                                e4.printStackTrace();
                            }
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e5) {
            e = e5;
            str2 = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:62:0x0093 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0089 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean writeObject2SDCard(java.lang.String r4, java.lang.String r5, T r6) {
        /*
            r3 = this;
            boolean r0 = com.xiaopeng.montecarlo.root.util.RootUtil.isSdcardExist()
            if (r0 == 0) goto L9c
            java.io.File r0 = new java.io.File
            r0.<init>(r4)
            boolean r1 = r0.exists()
            if (r1 != 0) goto L14
            r0.mkdirs()
        L14:
            java.io.File r0 = new java.io.File
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r4)
            r1.append(r5)
            java.lang.String r4 = r1.toString()
            r0.<init>(r4)
            boolean r4 = r0.exists()
            if (r4 == 0) goto L31
            r0.delete()
        L31:
            r4 = 0
            r0.createNewFile()     // Catch: java.lang.Throwable -> L69 java.lang.Exception -> L6c
            java.io.FileOutputStream r5 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L69 java.lang.Exception -> L6c
            r5.<init>(r0)     // Catch: java.lang.Throwable -> L69 java.lang.Exception -> L6c
            java.io.ObjectOutputStream r0 = new java.io.ObjectOutputStream     // Catch: java.lang.Throwable -> L5f java.lang.Exception -> L64
            r0.<init>(r5)     // Catch: java.lang.Throwable -> L5f java.lang.Exception -> L64
            r0.writeObject(r6)     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L5a
            r4 = 1
            r5.close()     // Catch: java.io.IOException -> L47
            goto L4b
        L47:
            r5 = move-exception
            r5.printStackTrace()
        L4b:
            r0.close()     // Catch: java.io.IOException -> L50
            goto L9d
        L50:
            r5 = move-exception
            r5.printStackTrace()
            goto L9d
        L55:
            r4 = move-exception
            r2 = r5
            r5 = r4
            r4 = r2
            goto L87
        L5a:
            r4 = move-exception
            r2 = r5
            r5 = r4
            r4 = r2
            goto L6e
        L5f:
            r6 = move-exception
            r0 = r4
            r4 = r5
            r5 = r6
            goto L87
        L64:
            r6 = move-exception
            r0 = r4
            r4 = r5
            r5 = r6
            goto L6e
        L69:
            r5 = move-exception
            r0 = r4
            goto L87
        L6c:
            r5 = move-exception
            r0 = r4
        L6e:
            r5.printStackTrace()     // Catch: java.lang.Throwable -> L86
            if (r4 == 0) goto L7b
            r4.close()     // Catch: java.io.IOException -> L77
            goto L7b
        L77:
            r4 = move-exception
            r4.printStackTrace()
        L7b:
            if (r0 == 0) goto L9c
            r0.close()     // Catch: java.io.IOException -> L81
            goto L9c
        L81:
            r4 = move-exception
            r4.printStackTrace()
            goto L9c
        L86:
            r5 = move-exception
        L87:
            if (r4 == 0) goto L91
            r4.close()     // Catch: java.io.IOException -> L8d
            goto L91
        L8d:
            r4 = move-exception
            r4.printStackTrace()
        L91:
            if (r0 == 0) goto L9b
            r0.close()     // Catch: java.io.IOException -> L97
            goto L9b
        L97:
            r4 = move-exception
            r4.printStackTrace()
        L9b:
            throw r5
        L9c:
            r4 = 0
        L9d:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaopeng.montecarlo.root.util.ioutil.FileIOUtil.writeObject2SDCard(java.lang.String, java.lang.String, java.lang.Object):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:62:0x0093 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0089 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean writeList2SDCard(java.lang.String r4, java.lang.String r5, java.util.List<T> r6) {
        /*
            r3 = this;
            boolean r0 = com.xiaopeng.montecarlo.root.util.RootUtil.isSdcardExist()
            if (r0 == 0) goto L9c
            java.io.File r0 = new java.io.File
            r0.<init>(r4)
            boolean r1 = r0.exists()
            if (r1 != 0) goto L14
            r0.mkdirs()
        L14:
            java.io.File r0 = new java.io.File
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r4)
            r1.append(r5)
            java.lang.String r4 = r1.toString()
            r0.<init>(r4)
            boolean r4 = r0.exists()
            if (r4 == 0) goto L31
            r0.delete()
        L31:
            r4 = 0
            r0.createNewFile()     // Catch: java.lang.Throwable -> L69 java.io.IOException -> L6c
            java.io.FileOutputStream r5 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L69 java.io.IOException -> L6c
            r5.<init>(r0)     // Catch: java.lang.Throwable -> L69 java.io.IOException -> L6c
            java.io.ObjectOutputStream r0 = new java.io.ObjectOutputStream     // Catch: java.lang.Throwable -> L5f java.io.IOException -> L64
            r0.<init>(r5)     // Catch: java.lang.Throwable -> L5f java.io.IOException -> L64
            r0.writeObject(r6)     // Catch: java.lang.Throwable -> L55 java.io.IOException -> L5a
            r4 = 1
            r5.close()     // Catch: java.io.IOException -> L47
            goto L4b
        L47:
            r5 = move-exception
            r5.printStackTrace()
        L4b:
            r0.close()     // Catch: java.io.IOException -> L50
            goto L9d
        L50:
            r5 = move-exception
            r5.printStackTrace()
            goto L9d
        L55:
            r4 = move-exception
            r2 = r5
            r5 = r4
            r4 = r2
            goto L87
        L5a:
            r4 = move-exception
            r2 = r5
            r5 = r4
            r4 = r2
            goto L6e
        L5f:
            r6 = move-exception
            r0 = r4
            r4 = r5
            r5 = r6
            goto L87
        L64:
            r6 = move-exception
            r0 = r4
            r4 = r5
            r5 = r6
            goto L6e
        L69:
            r5 = move-exception
            r0 = r4
            goto L87
        L6c:
            r5 = move-exception
            r0 = r4
        L6e:
            r5.printStackTrace()     // Catch: java.lang.Throwable -> L86
            if (r4 == 0) goto L7b
            r4.close()     // Catch: java.io.IOException -> L77
            goto L7b
        L77:
            r4 = move-exception
            r4.printStackTrace()
        L7b:
            if (r0 == 0) goto L9c
            r0.close()     // Catch: java.io.IOException -> L81
            goto L9c
        L81:
            r4 = move-exception
            r4.printStackTrace()
            goto L9c
        L86:
            r5 = move-exception
        L87:
            if (r4 == 0) goto L91
            r4.close()     // Catch: java.io.IOException -> L8d
            goto L91
        L8d:
            r4 = move-exception
            r4.printStackTrace()
        L91:
            if (r0 == 0) goto L9b
            r0.close()     // Catch: java.io.IOException -> L97
            goto L9b
        L97:
            r4 = move-exception
            r4.printStackTrace()
        L9b:
            throw r5
        L9c:
            r4 = 0
        L9d:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaopeng.montecarlo.root.util.ioutil.FileIOUtil.writeList2SDCard(java.lang.String, java.lang.String, java.util.List):boolean");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.io.ObjectInputStream] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r6v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r6v11, types: [java.io.FileInputStream, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r6v3, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* JADX WARN: Type inference failed for: r6v8 */
    /* JADX WARN: Type inference failed for: r6v9, types: [java.io.FileInputStream] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x003c -> B:60:0x007b). Please submit an issue!!! */
    public T readObjectFromSDCard(String str) {
        ObjectInputStream objectInputStream;
        T readObject;
        T t = null;
        if (RootUtil.isSdcardExist()) {
            ?? file = new File(str);
            ?? exists = file.exists();
            try {
                try {
                } catch (Throwable th) {
                    th = th;
                }
            } catch (IOException e) {
                e.printStackTrace();
                t = t;
            }
            if (exists != 0) {
                try {
                    exists = new FileInputStream((File) file);
                } catch (Exception e2) {
                    e = e2;
                    exists = 0;
                    objectInputStream = null;
                } catch (Throwable th2) {
                    file = 0;
                    th = th2;
                    exists = 0;
                }
                try {
                    objectInputStream = new ObjectInputStream(exists);
                    try {
                        if (this.mClazz != null) {
                            readObject = this.mClazz.cast(objectInputStream.readObject());
                        } else {
                            readObject = objectInputStream.readObject();
                        }
                        try {
                            exists.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                        objectInputStream.close();
                        t = readObject;
                    } catch (Exception e4) {
                        e = e4;
                        e.printStackTrace();
                        if (exists != 0) {
                            try {
                                exists.close();
                            } catch (IOException e5) {
                                e5.printStackTrace();
                            }
                        }
                        if (objectInputStream != null) {
                            objectInputStream.close();
                            t = t;
                        }
                        return t;
                    }
                } catch (Exception e6) {
                    e = e6;
                    objectInputStream = null;
                } catch (Throwable th3) {
                    th = th3;
                    file = 0;
                    if (exists != 0) {
                        try {
                            exists.close();
                        } catch (IOException e7) {
                            e7.printStackTrace();
                        }
                    }
                    if (file != 0) {
                        try {
                            file.close();
                        } catch (IOException e8) {
                            e8.printStackTrace();
                        }
                    }
                    throw th;
                }
            }
        }
        return t;
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x0061 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x006b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.util.List<T> readListFromSDCard(java.lang.String r5) {
        /*
            r4 = this;
            boolean r0 = com.xiaopeng.montecarlo.root.util.RootUtil.isSdcardExist()
            r1 = 0
            if (r0 == 0) goto L74
            java.io.File r0 = new java.io.File
            r0.<init>(r5)
            boolean r5 = r0.exists()
            if (r5 == 0) goto L74
            java.io.FileInputStream r5 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L3e java.lang.Exception -> L43
            r5.<init>(r0)     // Catch: java.lang.Throwable -> L3e java.lang.Exception -> L43
            java.io.ObjectInputStream r0 = new java.io.ObjectInputStream     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L3b
            r0.<init>(r5)     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L3b
            java.lang.Object r2 = r0.readObject()     // Catch: java.lang.Exception -> L34 java.lang.Throwable -> L5e
            java.util.List r2 = (java.util.List) r2     // Catch: java.lang.Exception -> L34 java.lang.Throwable -> L5e
            r5.close()     // Catch: java.io.IOException -> L26
            goto L2a
        L26:
            r5 = move-exception
            r5.printStackTrace()
        L2a:
            r0.close()     // Catch: java.io.IOException -> L2e
            goto L32
        L2e:
            r5 = move-exception
            r5.printStackTrace()
        L32:
            r1 = r2
            goto L74
        L34:
            r2 = move-exception
            goto L46
        L36:
            r0 = move-exception
            r3 = r1
            r1 = r0
            r0 = r3
            goto L5f
        L3b:
            r2 = move-exception
            r0 = r1
            goto L46
        L3e:
            r5 = move-exception
            r0 = r1
            r1 = r5
            r5 = r0
            goto L5f
        L43:
            r2 = move-exception
            r5 = r1
            r0 = r5
        L46:
            r2.printStackTrace()     // Catch: java.lang.Throwable -> L5e
            if (r5 == 0) goto L53
            r5.close()     // Catch: java.io.IOException -> L4f
            goto L53
        L4f:
            r5 = move-exception
            r5.printStackTrace()
        L53:
            if (r0 == 0) goto L74
            r0.close()     // Catch: java.io.IOException -> L59
            goto L74
        L59:
            r5 = move-exception
            r5.printStackTrace()
            goto L74
        L5e:
            r1 = move-exception
        L5f:
            if (r5 == 0) goto L69
            r5.close()     // Catch: java.io.IOException -> L65
            goto L69
        L65:
            r5 = move-exception
            r5.printStackTrace()
        L69:
            if (r0 == 0) goto L73
            r0.close()     // Catch: java.io.IOException -> L6f
            goto L73
        L6f:
            r5 = move-exception
            r5.printStackTrace()
        L73:
            throw r1
        L74:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaopeng.montecarlo.root.util.ioutil.FileIOUtil.readListFromSDCard(java.lang.String):java.util.List");
    }
}
