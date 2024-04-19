package com.xiaopeng.montecarlo.root.httpclient.core;
/* loaded from: classes3.dex */
public class OriginNetworkResponseInfoOnlyForHttpClient {
    int mOriginNetworkResponseCode;
    String mOriginNetworkResponseData;
    String mOriginNetworkResponseMessage;

    protected boolean canEqual(Object obj) {
        return obj instanceof OriginNetworkResponseInfoOnlyForHttpClient;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof OriginNetworkResponseInfoOnlyForHttpClient) {
            OriginNetworkResponseInfoOnlyForHttpClient originNetworkResponseInfoOnlyForHttpClient = (OriginNetworkResponseInfoOnlyForHttpClient) obj;
            if (originNetworkResponseInfoOnlyForHttpClient.canEqual(this) && getOriginNetworkResponseCode() == originNetworkResponseInfoOnlyForHttpClient.getOriginNetworkResponseCode()) {
                String originNetworkResponseMessage = getOriginNetworkResponseMessage();
                String originNetworkResponseMessage2 = originNetworkResponseInfoOnlyForHttpClient.getOriginNetworkResponseMessage();
                if (originNetworkResponseMessage != null ? originNetworkResponseMessage.equals(originNetworkResponseMessage2) : originNetworkResponseMessage2 == null) {
                    String originNetworkResponseData = getOriginNetworkResponseData();
                    String originNetworkResponseData2 = originNetworkResponseInfoOnlyForHttpClient.getOriginNetworkResponseData();
                    return originNetworkResponseData != null ? originNetworkResponseData.equals(originNetworkResponseData2) : originNetworkResponseData2 == null;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        String originNetworkResponseMessage = getOriginNetworkResponseMessage();
        int originNetworkResponseCode = ((getOriginNetworkResponseCode() + 59) * 59) + (originNetworkResponseMessage == null ? 43 : originNetworkResponseMessage.hashCode());
        String originNetworkResponseData = getOriginNetworkResponseData();
        return (originNetworkResponseCode * 59) + (originNetworkResponseData != null ? originNetworkResponseData.hashCode() : 43);
    }

    public OriginNetworkResponseInfoOnlyForHttpClient setOriginNetworkResponseCode(int i) {
        this.mOriginNetworkResponseCode = i;
        return this;
    }

    public OriginNetworkResponseInfoOnlyForHttpClient setOriginNetworkResponseData(String str) {
        this.mOriginNetworkResponseData = str;
        return this;
    }

    public OriginNetworkResponseInfoOnlyForHttpClient setOriginNetworkResponseMessage(String str) {
        this.mOriginNetworkResponseMessage = str;
        return this;
    }

    public String toString() {
        return "OriginNetworkResponseInfoOnlyForHttpClient(mOriginNetworkResponseCode=" + getOriginNetworkResponseCode() + ", mOriginNetworkResponseMessage=" + getOriginNetworkResponseMessage() + ", mOriginNetworkResponseData=" + getOriginNetworkResponseData() + ")";
    }

    public int getOriginNetworkResponseCode() {
        return this.mOriginNetworkResponseCode;
    }

    public String getOriginNetworkResponseMessage() {
        return this.mOriginNetworkResponseMessage;
    }

    public String getOriginNetworkResponseData() {
        return this.mOriginNetworkResponseData;
    }
}
