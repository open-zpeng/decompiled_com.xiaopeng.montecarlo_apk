package com.xiaopeng.montecarlo.navcore.bean.direction;

import com.xiaopeng.montecarlo.root.util.L;
/* loaded from: classes.dex */
public class ACCUserData {
    private static final int EXPERT_ACC_SUGGESTION_SPEED = 70;
    private static final int EXPERT_DRIVE_DIST_ACC_ON = 2000;
    private static final int EXPERT_REMAIN_DIST_ACC_ON = 8000;
    private static final int EXPERT_USE_NUMBER = 3;
    public static final int MAX_USE_NUMBER = 10;
    private static final int NEWCOMER_ACC_SUGGESTION_SPEED = 70;
    private static final int NEWCOMER_DRIVE_DIST_ACC_ON = 2000;
    private static final int NEWCOMER_REMAIN_DIST_ACC_ON = 3000;
    private static final L.Tag TAG = new L.Tag("ACCUserData");
    private int mACCSuggestionSpeed;
    private int mDriveDistACCOn;
    private int mRemainDistACCOn;
    private Type mType = Type.INVALID;

    /* loaded from: classes.dex */
    public enum Type {
        INVALID,
        NEWCOMER,
        EXPERT
    }

    public void setACCSuggestionSpeed(int i) {
        this.mACCSuggestionSpeed = i;
    }

    public void setDriveDistACCOn(int i) {
        this.mDriveDistACCOn = i;
    }

    public void setRemainDistACCOn(int i) {
        this.mRemainDistACCOn = i;
    }

    public void setType(Type type) {
        this.mType = type;
    }

    public Type getType() {
        return this.mType;
    }

    public int getDriveDistACCOn() {
        return this.mDriveDistACCOn;
    }

    public int getRemainDistACCOn() {
        return this.mRemainDistACCOn;
    }

    public int getACCSuggestionSpeed() {
        return this.mACCSuggestionSpeed;
    }

    public ACCUserData(int i) {
        switchUser(i);
    }

    private ACCUserData() {
    }

    public void switchUser(int i) {
        Type type = Type.NEWCOMER;
        if (i > 3) {
            type = Type.EXPERT;
        }
        if (this.mType == type) {
            return;
        }
        L.Tag tag = TAG;
        L.i(tag, this.mType + " to " + type);
        this.mType = type;
        int i2 = AnonymousClass1.$SwitchMap$com$xiaopeng$montecarlo$navcore$bean$direction$ACCUserData$Type[this.mType.ordinal()];
        if (i2 == 1) {
            this.mDriveDistACCOn = 2000;
            this.mRemainDistACCOn = 3000;
            this.mACCSuggestionSpeed = 70;
        } else if (i2 == 2) {
            this.mDriveDistACCOn = 2000;
            this.mRemainDistACCOn = 8000;
            this.mACCSuggestionSpeed = 70;
        } else {
            this.mDriveDistACCOn = 2000;
            this.mRemainDistACCOn = 2000;
            this.mACCSuggestionSpeed = 2000;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.xiaopeng.montecarlo.navcore.bean.direction.ACCUserData$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$xiaopeng$montecarlo$navcore$bean$direction$ACCUserData$Type = new int[Type.values().length];

        static {
            try {
                $SwitchMap$com$xiaopeng$montecarlo$navcore$bean$direction$ACCUserData$Type[Type.NEWCOMER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$xiaopeng$montecarlo$navcore$bean$direction$ACCUserData$Type[Type.EXPERT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }
}
