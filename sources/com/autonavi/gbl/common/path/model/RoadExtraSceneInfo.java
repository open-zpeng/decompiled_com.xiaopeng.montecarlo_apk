package com.autonavi.gbl.common.path.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class RoadExtraSceneInfo implements Serializable {
    public String m_brief;
    public int m_dis_to_end;
    public long m_display_val;
    public short m_info_type;
    public long m_lat;
    public int m_link_idx;
    public long m_lon;
    public short m_mask_flag;
    public short m_mask_flag2;
    public short m_priority;
    public int m_seg_idx;
    public short m_show_class;
    public short m_show_subclass;
    public short m_show_type;
    public String m_title;
    public String m_title_forshow;

    public RoadExtraSceneInfo() {
        this.m_info_type = (short) 0;
        this.m_show_type = (short) 0;
        this.m_priority = (short) 0;
        this.m_mask_flag = (short) 0;
        this.m_lon = 0L;
        this.m_lat = 0L;
        this.m_seg_idx = 0;
        this.m_link_idx = 0;
        this.m_dis_to_end = 0;
        this.m_brief = "";
        this.m_title = "";
        this.m_display_val = 0L;
        this.m_show_class = (short) 0;
        this.m_show_subclass = (short) 0;
        this.m_mask_flag2 = (short) 0;
        this.m_title_forshow = "";
    }

    public RoadExtraSceneInfo(short s, short s2, short s3, short s4, long j, long j2, int i, int i2, int i3, String str, String str2, long j3, short s5, short s6, short s7, String str3) {
        this.m_info_type = s;
        this.m_show_type = s2;
        this.m_priority = s3;
        this.m_mask_flag = s4;
        this.m_lon = j;
        this.m_lat = j2;
        this.m_seg_idx = i;
        this.m_link_idx = i2;
        this.m_dis_to_end = i3;
        this.m_brief = str;
        this.m_title = str2;
        this.m_display_val = j3;
        this.m_show_class = s5;
        this.m_show_subclass = s6;
        this.m_mask_flag2 = s7;
        this.m_title_forshow = str3;
    }
}
