package com.alibaba.sdk.android.oss.network;

import com.alibaba.sdk.android.oss.common.HttpMethod;
import com.alibaba.sdk.android.oss.internal.OSSRetryHandler;
import com.alibaba.sdk.android.oss.internal.RequestMessage;
import com.alibaba.sdk.android.oss.internal.ResponseMessage;
import com.alibaba.sdk.android.oss.internal.ResponseParser;
import com.alibaba.sdk.android.oss.model.OSSResult;
import java.util.HashMap;
import java.util.concurrent.Callable;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Response;
/* loaded from: classes.dex */
public class OSSRequestTask<T extends OSSResult> implements Callable<T> {
    private OkHttpClient client;
    private ExecutionContext context;
    private int currentRetryCount = 0;
    private RequestMessage message;
    private ResponseParser<T> responseParser;
    private OSSRetryHandler retryHandler;

    public OSSRequestTask(RequestMessage requestMessage, ResponseParser responseParser, ExecutionContext executionContext, int i) {
        this.responseParser = responseParser;
        this.message = requestMessage;
        this.context = executionContext;
        this.client = executionContext.getClient();
        this.retryHandler = new OSSRetryHandler(i);
    }

    /* JADX WARN: Removed duplicated region for block: B:119:0x038c  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x03be  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x031f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0198 A[Catch: Exception -> 0x02ce, TryCatch #0 {Exception -> 0x02ce, blocks: (B:3:0x0004, B:5:0x000c, B:6:0x0019, B:8:0x003a, B:10:0x0043, B:12:0x0050, B:13:0x0062, B:15:0x0068, B:16:0x007f, B:71:0x01fd, B:27:0x00c6, B:28:0x00cc, B:29:0x00d2, B:33:0x00dd, B:35:0x00ec, B:64:0x0198, B:66:0x01a0, B:67:0x01ab, B:69:0x01cc, B:70:0x01e9, B:38:0x0103, B:40:0x010b, B:43:0x0128, B:44:0x0130, B:45:0x0131, B:47:0x0139, B:51:0x0169, B:57:0x0173, B:58:0x0176, B:59:0x0177, B:61:0x017f, B:62:0x018d, B:11:0x004a, B:89:0x02c6, B:90:0x02cd), top: B:149:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01ca  */
    @Override // java.util.concurrent.Callable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public T call() throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 1102
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.oss.network.OSSRequestTask.call():com.alibaba.sdk.android.oss.model.OSSResult");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.alibaba.sdk.android.oss.network.OSSRequestTask$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$alibaba$sdk$android$oss$common$HttpMethod = new int[HttpMethod.values().length];

        static {
            try {
                $SwitchMap$com$alibaba$sdk$android$oss$common$HttpMethod[HttpMethod.POST.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$alibaba$sdk$android$oss$common$HttpMethod[HttpMethod.PUT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$alibaba$sdk$android$oss$common$HttpMethod[HttpMethod.GET.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$alibaba$sdk$android$oss$common$HttpMethod[HttpMethod.HEAD.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$alibaba$sdk$android$oss$common$HttpMethod[HttpMethod.DELETE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    private ResponseMessage buildResponseMessage(RequestMessage requestMessage, Response response) {
        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setRequest(requestMessage);
        responseMessage.setResponse(response);
        HashMap hashMap = new HashMap();
        Headers headers = response.headers();
        for (int i = 0; i < headers.size(); i++) {
            hashMap.put(headers.name(i), headers.value(i));
        }
        responseMessage.setHeaders(hashMap);
        responseMessage.setStatusCode(response.code());
        responseMessage.setContentLength(response.body().contentLength());
        responseMessage.setContent(response.body().byteStream());
        return responseMessage;
    }
}
