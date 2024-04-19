package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class GFeedbackDescription implements Serializable {
    public GFeedbackDescEditDes editDes;
    public ArrayList<GFeedbackDescReDes> reDes;
    public String uDes;

    public GFeedbackDescription() {
        this.uDes = "";
        this.reDes = new ArrayList<>();
        this.editDes = new GFeedbackDescEditDes();
    }

    public GFeedbackDescription(String str, ArrayList<GFeedbackDescReDes> arrayList, GFeedbackDescEditDes gFeedbackDescEditDes) {
        this.uDes = str;
        this.reDes = arrayList;
        this.editDes = gFeedbackDescEditDes;
    }
}
