package com.autonavi.gbl.common.path.model;

import com.autonavi.gbl.common.model.Coord2DDouble;
import java.io.Serializable;
/* loaded from: classes.dex */
public class JamBubblesOfSegment implements Serializable {
    public JamBubblesSegmentDeepInfo cost;
    public JamBubblesSegmentData data;
    public JamBubblesSegmentDeepInfo deepInfo;
    public JamBubblesSegmentDeepInfo degree;
    public Coord2DDouble display;
    public int jumpType;
    public JamBubblesLinkSegment linkSegment;
    public String pic;
    public String picPath;
    public JamBubblesPostBack postback;
    public int showType;
    public JamBubblesSegmentDeepInfo trend;

    public JamBubblesOfSegment() {
        this.deepInfo = new JamBubblesSegmentDeepInfo();
        this.trend = new JamBubblesSegmentDeepInfo();
        this.cost = new JamBubblesSegmentDeepInfo();
        this.degree = new JamBubblesSegmentDeepInfo();
        this.linkSegment = new JamBubblesLinkSegment();
        this.data = new JamBubblesSegmentData();
        this.pic = "";
        this.picPath = "";
        this.display = new Coord2DDouble();
        this.jumpType = -1;
        this.showType = 1;
        this.postback = new JamBubblesPostBack();
    }

    public JamBubblesOfSegment(JamBubblesSegmentDeepInfo jamBubblesSegmentDeepInfo, JamBubblesSegmentDeepInfo jamBubblesSegmentDeepInfo2, JamBubblesSegmentDeepInfo jamBubblesSegmentDeepInfo3, JamBubblesSegmentDeepInfo jamBubblesSegmentDeepInfo4, JamBubblesLinkSegment jamBubblesLinkSegment, JamBubblesSegmentData jamBubblesSegmentData, String str, String str2, Coord2DDouble coord2DDouble, int i, int i2, JamBubblesPostBack jamBubblesPostBack) {
        this.deepInfo = jamBubblesSegmentDeepInfo;
        this.trend = jamBubblesSegmentDeepInfo2;
        this.cost = jamBubblesSegmentDeepInfo3;
        this.degree = jamBubblesSegmentDeepInfo4;
        this.linkSegment = jamBubblesLinkSegment;
        this.data = jamBubblesSegmentData;
        this.pic = str;
        this.picPath = str2;
        this.display = coord2DDouble;
        this.jumpType = i;
        this.showType = i2;
        this.postback = jamBubblesPostBack;
    }
}
