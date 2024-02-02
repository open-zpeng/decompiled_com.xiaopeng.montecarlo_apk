package com.autonavi.gbl.lane.model;

import com.autonavi.gbl.lane.model.BSD_DIRECTION;
import com.autonavi.gbl.lane.model.WARNS_STATUS;
import com.autonavi.gbl.lane.model.WARN_GRADE;
import com.autonavi.gbl.lane.model.WARN_TYPE;
import java.io.Serializable;
/* loaded from: classes.dex */
public class WarnInfo implements Serializable {
    @BSD_DIRECTION.BSD_DIRECTION1
    public int bsdDirection;
    @WARN_GRADE.WARN_GRADE1
    public int warnGrade;
    @WARNS_STATUS.WARNS_STATUS1
    public int warnStatus;
    @WARN_TYPE.WARN_TYPE1
    public int warnType;

    public WarnInfo() {
        this.warnStatus = 0;
        this.warnType = 0;
        this.bsdDirection = 0;
        this.warnGrade = 0;
    }

    public WarnInfo(@WARNS_STATUS.WARNS_STATUS1 int i, @WARN_TYPE.WARN_TYPE1 int i2, @BSD_DIRECTION.BSD_DIRECTION1 int i3, @WARN_GRADE.WARN_GRADE1 int i4) {
        this.warnStatus = i;
        this.warnType = i2;
        this.bsdDirection = i3;
        this.warnGrade = i4;
    }
}
