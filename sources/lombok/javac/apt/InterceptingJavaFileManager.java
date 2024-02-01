package lombok.javac.apt;

import java.io.IOException;
import javax.tools.FileObject;
import javax.tools.ForwardingJavaFileManager;
import javax.tools.JavaFileManager;
import javax.tools.JavaFileObject;
import lombok.core.DiagnosticsReceiver;
import lombok.javac.apt.LombokFileObjects;
/* loaded from: 地图_V1.10.0_20240112105442_Release.apk:lombok/javac/apt/InterceptingJavaFileManager.SCL.lombok */
final class InterceptingJavaFileManager extends ForwardingJavaFileManager<JavaFileManager> {
    private final DiagnosticsReceiver diagnostics;
    private final LombokFileObjects.Compiler compiler;

    /* JADX INFO: Access modifiers changed from: package-private */
    public InterceptingJavaFileManager(JavaFileManager original, DiagnosticsReceiver diagnostics) {
        super(original);
        this.compiler = LombokFileObjects.getCompiler(original);
        this.diagnostics = diagnostics;
    }

    public JavaFileObject getJavaFileForOutput(JavaFileManager.Location location, String className, JavaFileObject.Kind kind, FileObject sibling) throws IOException {
        JavaFileObject fileObject = this.fileManager.getJavaFileForOutput(location, className, kind, sibling);
        return kind != JavaFileObject.Kind.CLASS ? fileObject : LombokFileObjects.createIntercepting(this.compiler, fileObject, className, this.diagnostics);
    }
}
