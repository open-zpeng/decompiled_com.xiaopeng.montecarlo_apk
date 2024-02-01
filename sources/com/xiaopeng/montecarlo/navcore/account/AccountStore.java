package com.xiaopeng.montecarlo.navcore.account;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.autonavi.gbl.user.account.model.AccountProfile;
import com.xiaopeng.montecarlo.navcore.setting.SettingWrapper;
import com.xiaopeng.montecarlo.root.util.L;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class AccountStore {
    private static final L.Tag TAG = new L.Tag("AccountStore");
    private static volatile AccountStore sAccountStore;
    private final Map<String, XpUserData> mXpAccountInfoMap = new HashMap();

    private AccountStore() {
    }

    public static AccountStore getInstance() {
        if (sAccountStore == null) {
            synchronized (AccountStore.class) {
                if (sAccountStore == null) {
                    sAccountStore = new AccountStore();
                }
            }
        }
        return sAccountStore;
    }

    @NonNull
    public XpUserData getCurrentXpAccountInfo() {
        return getXpAccountInfo(XPAccountServiceWrapper.getInstance().getUserId());
    }

    @NonNull
    public XpUserData getXpAccountInfo(String str) {
        XpUserData xpUserData;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        synchronized (this.mXpAccountInfoMap) {
            xpUserData = this.mXpAccountInfoMap.get(str);
            if (xpUserData == null) {
                L.Tag tag = TAG;
                L.i(tag, "getXpAccountInfo new !! userId:" + str);
                xpUserData = new XpUserData(str);
                this.mXpAccountInfoMap.put(str, xpUserData);
            }
        }
        return xpUserData;
    }

    public synchronized void clearCurrentXpAccountInfo() {
        SettingWrapper.saveAccountSid("");
        SettingWrapper.saveAccountOpenId("");
        XpUserData currentXpAccountInfo = getCurrentXpAccountInfo();
        currentXpAccountInfo.setOpenId("");
        currentXpAccountInfo.setSid("");
    }

    public synchronized void clearLastXpAccountInfo() {
        SettingWrapper.saveLastAccountOpenId("");
        SettingWrapper.saveLastAccountSid("");
    }

    public synchronized void resetXpAccountInfo() {
        String accountOpenId = SettingWrapper.getAccountOpenId();
        String accountSid = SettingWrapper.getAccountSid();
        SettingWrapper.saveLastAccountOpenId(accountOpenId);
        SettingWrapper.saveLastAccountSid(accountSid);
        clearCurrentXpAccountInfo();
        L.Tag tag = TAG;
        L.i(tag, "bindmap account resetXpAccountInfo ，save last account openid=" + accountOpenId + "| sid=" + accountSid);
    }

    public synchronized void resetCurrentXpAMapInfo() {
        SettingWrapper.setAmapLoginStatus(false);
        SettingWrapper.setBlCookieLastTime(0L);
        L.i(TAG, "bindmap  resetCurrentXpAMapInfo ");
    }

    public synchronized void setCurrentXpAccountLoginAMap() {
        SettingWrapper.setBindAMapStatusValue(0);
        SettingWrapper.saveBindAMapStatus(true);
        SettingWrapper.saveIsAMapAccount(true);
        SettingWrapper.setAmapLoginStatus(true);
        SettingWrapper.setCurrentAMapLoginXpUserId(XPAccountServiceWrapper.getInstance().getUserId());
        L.Tag tag = TAG;
        L.i(tag, "setCurrentXpAccountLoginAMap xpUid:" + XPAccountServiceWrapper.getInstance().getUserId());
    }

    public synchronized void setCurrentXpAccountBindAMap() {
        SettingWrapper.setBindAMapStatusValue(0);
        SettingWrapper.saveBindAMapStatus(true);
        if (!SettingWrapper.getFistBindAmap()) {
            SettingWrapper.saveFirstBindAmap(true);
        }
    }

    public synchronized void setAMapAccountLogout() {
        SettingWrapper.setAmapLoginStatus(false);
        SettingWrapper.setCurrentAMapLoginXpUserId("");
        SettingWrapper.setBlCookieLastTime(0L);
        BLMsgPushServiceWrapper.getInstance().setLoginInfo("");
        BLAccountServiceWrapper.getInstance().getAccountService().deleteUserData();
        SettingWrapper.setBlAccountProfile("");
        L.i(TAG, "setAMapAccountLogout , clear amap login info~");
    }

    public synchronized boolean isCurrentXpLoginAMap() {
        L.Tag tag = TAG;
        L.i(tag, "isCurrentXpLoginAMap getCarLoginFlag:" + BLAccountServiceWrapper.getInstance().getAccountService().getCarLoginFlag());
        if (BLAccountServiceWrapper.getInstance().getAccountService().getCarLoginFlag()) {
            if (!XPAccountServiceWrapper.getInstance().isTempType()) {
                if (TextUtils.equals(SettingWrapper.getCurrentAMapLoginXpUserId(), XPAccountServiceWrapper.getInstance().getUserId())) {
                    return true;
                }
            }
            return true;
        }
        return false;
    }

    public synchronized boolean isLastAMapAccountLogin() {
        if (!BLAccountServiceWrapper.getInstance().getAccountService().getCarLoginFlag()) {
            L.i(TAG, "isLastAMapAccountLogin getCarLoginFlag = false ,amap is not login");
            return false;
        }
        String currentAMapLoginXpUserId = SettingWrapper.getCurrentAMapLoginXpUserId();
        if (!TextUtils.isEmpty(currentAMapLoginXpUserId)) {
            if (XPAccountServiceWrapper.getInstance().isTempType()) {
                L.Tag tag = TAG;
                L.i(tag, "isLastAMapAccountLogin->true because currentXpUser is temp and currentAMapLoginXpUserId is " + currentAMapLoginXpUserId);
                return true;
            }
            String userId = XPAccountServiceWrapper.getInstance().getUserId();
            L.Tag tag2 = TAG;
            L.i(tag2, "isLastAMapAccountLogin currentXpUserId:" + userId + ",currentAMapLoginXpUserId:" + currentAMapLoginXpUserId);
            return !TextUtils.equals(userId, currentAMapLoginXpUserId);
        }
        L.Tag tag3 = TAG;
        L.i(tag3, "isLastAMapAccountLogin aMapUid:" + BLAccountServiceWrapper.getInstance().getUserId());
        return true;
    }

    public boolean isCurrentLoginAMapUser(String str) {
        AccountProfile userData = BLAccountServiceWrapper.getInstance().getAccountService().getUserData();
        if (TextUtils.isEmpty(str) || userData == null) {
            return true;
        }
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "isCurrentLoginAMapUser aMapUserId:" + str + "  currentAccountId:" + userData.uid);
        }
        return TextUtils.equals(str, userData.uid);
    }
}
