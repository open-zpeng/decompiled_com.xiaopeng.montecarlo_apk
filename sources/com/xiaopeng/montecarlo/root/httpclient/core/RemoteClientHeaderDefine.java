package com.xiaopeng.montecarlo.root.httpclient.core;

import com.xiaopeng.montecarlo.root.httpclient.constants.ClientEncodingTypeEnum;
import com.xiaopeng.montecarlo.root.httpclient.constants.ClientTypeEnum;
import com.xiaopeng.montecarlo.root.httpclient.constants.EncryptTypeEnum;
/* loaded from: classes2.dex */
public class RemoteClientHeaderDefine {
    private boolean mRequireOpenId = false;
    private boolean mRequireSid = false;
    private boolean mRequireUserId = false;
    private boolean mRequireOtp = false;
    private boolean mRequireVin = true;
    private boolean mRequireClientKey = true;
    private boolean mRequireNonce = true;
    private EncryptTypeEnum mEncryptType = EncryptTypeEnum.XP_ENCRYPT_TYPE_NONE;
    private ClientTypeEnum mClientType = ClientTypeEnum.XP_CLIENT_TYPE_XMARTOS;
    private ClientEncodingTypeEnum mClientEncodingType = ClientEncodingTypeEnum.XP_CLIENT_ENCODING_NONE;

    protected boolean canEqual(Object obj) {
        return obj instanceof RemoteClientHeaderDefine;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof RemoteClientHeaderDefine) {
            RemoteClientHeaderDefine remoteClientHeaderDefine = (RemoteClientHeaderDefine) obj;
            if (remoteClientHeaderDefine.canEqual(this) && isRequireOpenId() == remoteClientHeaderDefine.isRequireOpenId() && isRequireSid() == remoteClientHeaderDefine.isRequireSid() && isRequireUserId() == remoteClientHeaderDefine.isRequireUserId() && isRequireOtp() == remoteClientHeaderDefine.isRequireOtp() && isRequireVin() == remoteClientHeaderDefine.isRequireVin() && isRequireClientKey() == remoteClientHeaderDefine.isRequireClientKey() && isRequireNonce() == remoteClientHeaderDefine.isRequireNonce()) {
                EncryptTypeEnum encryptType = getEncryptType();
                EncryptTypeEnum encryptType2 = remoteClientHeaderDefine.getEncryptType();
                if (encryptType != null ? encryptType.equals(encryptType2) : encryptType2 == null) {
                    ClientTypeEnum clientType = getClientType();
                    ClientTypeEnum clientType2 = remoteClientHeaderDefine.getClientType();
                    if (clientType != null ? clientType.equals(clientType2) : clientType2 == null) {
                        ClientEncodingTypeEnum clientEncodingType = getClientEncodingType();
                        ClientEncodingTypeEnum clientEncodingType2 = remoteClientHeaderDefine.getClientEncodingType();
                        return clientEncodingType != null ? clientEncodingType.equals(clientEncodingType2) : clientEncodingType2 == null;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        int i = (((((((((((((isRequireOpenId() ? 79 : 97) + 59) * 59) + (isRequireSid() ? 79 : 97)) * 59) + (isRequireUserId() ? 79 : 97)) * 59) + (isRequireOtp() ? 79 : 97)) * 59) + (isRequireVin() ? 79 : 97)) * 59) + (isRequireClientKey() ? 79 : 97)) * 59) + (isRequireNonce() ? 79 : 97);
        EncryptTypeEnum encryptType = getEncryptType();
        int hashCode = (i * 59) + (encryptType == null ? 43 : encryptType.hashCode());
        ClientTypeEnum clientType = getClientType();
        int hashCode2 = (hashCode * 59) + (clientType == null ? 43 : clientType.hashCode());
        ClientEncodingTypeEnum clientEncodingType = getClientEncodingType();
        return (hashCode2 * 59) + (clientEncodingType != null ? clientEncodingType.hashCode() : 43);
    }

    public RemoteClientHeaderDefine setClientEncodingType(ClientEncodingTypeEnum clientEncodingTypeEnum) {
        this.mClientEncodingType = clientEncodingTypeEnum;
        return this;
    }

    public RemoteClientHeaderDefine setClientType(ClientTypeEnum clientTypeEnum) {
        this.mClientType = clientTypeEnum;
        return this;
    }

    public RemoteClientHeaderDefine setEncryptType(EncryptTypeEnum encryptTypeEnum) {
        this.mEncryptType = encryptTypeEnum;
        return this;
    }

    public RemoteClientHeaderDefine setRequireClientKey(boolean z) {
        this.mRequireClientKey = z;
        return this;
    }

    public RemoteClientHeaderDefine setRequireNonce(boolean z) {
        this.mRequireNonce = z;
        return this;
    }

    public RemoteClientHeaderDefine setRequireOpenId(boolean z) {
        this.mRequireOpenId = z;
        return this;
    }

    public RemoteClientHeaderDefine setRequireOtp(boolean z) {
        this.mRequireOtp = z;
        return this;
    }

    public RemoteClientHeaderDefine setRequireSid(boolean z) {
        this.mRequireSid = z;
        return this;
    }

    public RemoteClientHeaderDefine setRequireUserId(boolean z) {
        this.mRequireUserId = z;
        return this;
    }

    public RemoteClientHeaderDefine setRequireVin(boolean z) {
        this.mRequireVin = z;
        return this;
    }

    public String toString() {
        return "RemoteClientHeaderDefine(mRequireOpenId=" + isRequireOpenId() + ", mRequireSid=" + isRequireSid() + ", mRequireUserId=" + isRequireUserId() + ", mRequireOtp=" + isRequireOtp() + ", mRequireVin=" + isRequireVin() + ", mRequireClientKey=" + isRequireClientKey() + ", mRequireNonce=" + isRequireNonce() + ", mEncryptType=" + getEncryptType() + ", mClientType=" + getClientType() + ", mClientEncodingType=" + getClientEncodingType() + ")";
    }

    public boolean isRequireOpenId() {
        return this.mRequireOpenId;
    }

    public boolean isRequireSid() {
        return this.mRequireSid;
    }

    public boolean isRequireUserId() {
        return this.mRequireUserId;
    }

    public boolean isRequireOtp() {
        return this.mRequireOtp;
    }

    public boolean isRequireVin() {
        return this.mRequireVin;
    }

    public boolean isRequireClientKey() {
        return this.mRequireClientKey;
    }

    public boolean isRequireNonce() {
        return this.mRequireNonce;
    }

    public EncryptTypeEnum getEncryptType() {
        return this.mEncryptType;
    }

    public ClientTypeEnum getClientType() {
        return this.mClientType;
    }

    public ClientEncodingTypeEnum getClientEncodingType() {
        return this.mClientEncodingType;
    }
}
