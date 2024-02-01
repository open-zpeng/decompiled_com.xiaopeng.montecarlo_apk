package lombok.javac.apt;

import java.nio.charset.CharsetDecoder;
import javax.tools.JavaFileObject;
/* loaded from: 地图_V1.10.0_20240112105442_Release.apk:lombok/javac/apt/LombokFileObject.SCL.lombok */
interface LombokFileObject extends JavaFileObject {
    CharsetDecoder getDecoder(boolean z);
}
