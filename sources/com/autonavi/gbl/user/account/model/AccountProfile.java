package com.autonavi.gbl.user.account.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class AccountProfile extends UserProfile implements Serializable {
    public int level = 0;
    public int gender = 0;
    public int checkin_count = 0;
    public String birthday = "";
    public String description = "";
    public ArrayList<AccountProvider> providers = new ArrayList<>();
    public boolean carLoginFlag = false;
    public UserCar car = new UserCar();
}
