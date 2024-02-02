package lombok.bytecode;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
/* loaded from: xp_Montecarlo-benchEdward.apk:lombok/bytecode/FixedClassWriter.SCL.lombok */
class FixedClassWriter extends ClassWriter {
    /* JADX INFO: Access modifiers changed from: package-private */
    public FixedClassWriter(ClassReader classReader, int flags) {
        super(classReader, flags);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.objectweb.asm.ClassWriter
    public String getCommonSuperClass(String type1, String type2) {
        try {
            return super.getCommonSuperClass(type1, type2);
        } catch (OutOfMemoryError e) {
            throw e;
        } catch (Throwable unused) {
            return "java/lang/Object";
        }
    }
}
