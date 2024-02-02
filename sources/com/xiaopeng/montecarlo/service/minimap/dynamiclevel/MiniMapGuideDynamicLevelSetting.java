package com.xiaopeng.montecarlo.service.minimap.dynamiclevel;

import com.xiaopeng.montecarlo.dynamiclevel.base.DynamicLevelSetting;
import com.xiaopeng.montecarlo.root.util.L;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class MiniMapGuideDynamicLevelSetting extends DynamicLevelSetting {
    private static final L.Tag TAG = new L.Tag("MiniMapGuideDynamicLevelSetting");
    private RoadLevelInfo mRoadLevelInfo;
    private float mRemainDis = 0.0f;
    private ArrayList<RoadLevelInfo> mRoadLevelInfoArrayList = new ArrayList<>();

    @Override // com.xiaopeng.montecarlo.dynamiclevel.base.DynamicLevelSetting
    public boolean isEnableDynamicDegree() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MiniMapGuideDynamicLevelSetting() {
        this.mRoadLevelInfoArrayList.add(new HighAndFastSpeed2DRoadLevelInfo());
        this.mRoadLevelInfoArrayList.add(new NormalSpeed2DRoadLevelInfo());
        this.mRoadLevelInfoArrayList.add(new HighAndFastSpeed3DRoadLevelInfo());
        this.mRoadLevelInfoArrayList.add(new NormalSpeed3DRoadLevelInfo());
    }

    @Override // com.xiaopeng.montecarlo.dynamiclevel.base.DynamicLevelSetting
    public float getLevel() {
        RoadLevelInfo roadLevelInfo = this.mRoadLevelInfo;
        if (roadLevelInfo != null) {
            return roadLevelInfo.getLevel(this.mRemainDis);
        }
        return -1.0f;
    }

    public boolean isOverMaxDistanceLimit() {
        RoadLevelInfo roadLevelInfo = this.mRoadLevelInfo;
        return roadLevelInfo != null && roadLevelInfo.isOverMaxDistanceLimit(this.mRemainDis);
    }

    public void update(float f, int i, boolean z) {
        this.mRemainDis = f;
        int i2 = (i == 0 || i == 6) ? z ? 2 : 0 : z ? 3 : 1;
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.v(tag, "update curRoadClass--" + i);
        }
        this.mRoadLevelInfo = this.mRoadLevelInfoArrayList.get(i2);
    }

    /* loaded from: classes3.dex */
    static class RoadLevelInfo {
        private int mMaxDistLimit;
        List<DynamicLevelSetting.SettingInfo> mSettingInfoList = new ArrayList();

        RoadLevelInfo(int i) {
            this.mMaxDistLimit = i;
        }

        boolean isOverMaxDistanceLimit(float f) {
            return f > ((float) this.mMaxDistLimit);
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x0048  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        float getLevel(float r5) {
            /*
                r4 = this;
                r0 = 0
            L1:
                java.util.List<com.xiaopeng.montecarlo.dynamiclevel.base.DynamicLevelSetting$SettingInfo> r1 = r4.mSettingInfoList
                int r1 = r1.size()
                if (r0 >= r1) goto L42
                java.util.List<com.xiaopeng.montecarlo.dynamiclevel.base.DynamicLevelSetting$SettingInfo> r1 = r4.mSettingInfoList
                java.lang.Object r1 = r1.get(r0)
                com.xiaopeng.montecarlo.dynamiclevel.base.DynamicLevelSetting$SettingInfo r1 = (com.xiaopeng.montecarlo.dynamiclevel.base.DynamicLevelSetting.SettingInfo) r1
                int r2 = r1.start
                float r2 = (float) r2
                int r2 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
                if (r2 < 0) goto L1f
                int r2 = r1.end
                float r2 = (float) r2
                int r2 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
                if (r2 < 0) goto L23
            L1f:
                int r2 = r1.end
                if (r2 >= 0) goto L3f
            L23:
                int r0 = r1.start
                if (r0 <= 0) goto L3c
                int r0 = r1.end
                if (r0 > 0) goto L2c
                goto L3c
            L2c:
                float r0 = r1.level
                int r2 = r1.start
                float r2 = (float) r2
                float r2 = r5 - r2
                int r3 = r1.end
                int r1 = r1.start
                int r3 = r3 - r1
                float r1 = (float) r3
                float r2 = r2 / r1
                float r0 = r0 - r2
                goto L44
            L3c:
                float r0 = r1.level
                goto L44
            L3f:
                int r0 = r0 + 1
                goto L1
            L42:
                r0 = -1082130432(0xffffffffbf800000, float:-1.0)
            L44:
                boolean r1 = com.xiaopeng.montecarlo.root.util.L.ENABLE
                if (r1 == 0) goto L68
                com.xiaopeng.montecarlo.root.util.L$Tag r1 = com.xiaopeng.montecarlo.service.minimap.dynamiclevel.MiniMapGuideDynamicLevelSetting.access$000()
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r3 = "getLevel---linkRemain:"
                r2.append(r3)
                r2.append(r5)
                java.lang.String r5 = "   level:"
                r2.append(r5)
                r2.append(r0)
                java.lang.String r5 = r2.toString()
                com.xiaopeng.montecarlo.root.util.L.v(r1, r5)
            L68:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.xiaopeng.montecarlo.service.minimap.dynamiclevel.MiniMapGuideDynamicLevelSetting.RoadLevelInfo.getLevel(float):float");
        }
    }

    /* loaded from: classes3.dex */
    private static class HighAndFastSpeed2DRoadLevelInfo extends RoadLevelInfo {
        HighAndFastSpeed2DRoadLevelInfo() {
            super(600);
            this.mSettingInfoList.add(new DynamicLevelSetting.SettingInfo(0, 300, 17.0f));
            this.mSettingInfoList.add(new DynamicLevelSetting.SettingInfo(300, 600, 17.0f));
            this.mSettingInfoList.add(new DynamicLevelSetting.SettingInfo(600, -1, 15.0f));
        }
    }

    /* loaded from: classes3.dex */
    private static class NormalSpeed2DRoadLevelInfo extends RoadLevelInfo {
        NormalSpeed2DRoadLevelInfo() {
            super(500);
            this.mSettingInfoList.add(new DynamicLevelSetting.SettingInfo(0, 200, 17.0f));
            this.mSettingInfoList.add(new DynamicLevelSetting.SettingInfo(200, 500, 17.0f));
            this.mSettingInfoList.add(new DynamicLevelSetting.SettingInfo(500, -1, 15.0f));
        }
    }

    /* loaded from: classes3.dex */
    private static class HighAndFastSpeed3DRoadLevelInfo extends RoadLevelInfo {
        HighAndFastSpeed3DRoadLevelInfo() {
            super(600);
            this.mSettingInfoList.add(new DynamicLevelSetting.SettingInfo(0, 300, 18.0f));
            this.mSettingInfoList.add(new DynamicLevelSetting.SettingInfo(300, 600, 18.0f));
            this.mSettingInfoList.add(new DynamicLevelSetting.SettingInfo(600, -1, 16.0f));
        }
    }

    /* loaded from: classes3.dex */
    private static class NormalSpeed3DRoadLevelInfo extends RoadLevelInfo {
        NormalSpeed3DRoadLevelInfo() {
            super(500);
            this.mSettingInfoList.add(new DynamicLevelSetting.SettingInfo(0, 200, 18.0f));
            this.mSettingInfoList.add(new DynamicLevelSetting.SettingInfo(200, 500, 18.0f));
            this.mSettingInfoList.add(new DynamicLevelSetting.SettingInfo(500, -1, 16.0f));
        }
    }
}
