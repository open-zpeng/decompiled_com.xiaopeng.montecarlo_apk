package lombok.javac.apt;

import java.nio.charset.CharsetDecoder;
import javax.tools.JavaFileObject;
/* loaded from: xp_Montecarlo-benchEdward.apk:lombok/javac/apt/LombokFileObject.SCL.lombok */
interface LombokFileObject extends JavaFileObject {
    CharsetDecoder getDecoder(boolean z);
}
