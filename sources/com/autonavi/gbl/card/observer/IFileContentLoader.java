package com.autonavi.gbl.card.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.card.router.FileContentLoaderRouter;
import com.autonavi.gbl.util.model.BinaryStream;
@IntfAuto(target = FileContentLoaderRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface IFileContentLoader {
    boolean loadFileContent(String str, BinaryStream binaryStream, String[] strArr);
}
