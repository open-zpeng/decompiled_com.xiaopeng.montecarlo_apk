package lombok.javac.apt;

import com.sun.tools.javac.file.BaseFileObject;
import com.sun.tools.javac.file.JavacFileManager;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.net.URI;
import java.nio.charset.CharsetDecoder;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.NestingKind;
import javax.tools.JavaFileObject;
/* loaded from: xp_Montecarlo-benchEdward.apk:lombok/javac/apt/Javac7BaseFileObjectWrapper.SCL.lombok */
class Javac7BaseFileObjectWrapper extends BaseFileObject {
    private final LombokFileObject delegate;

    public Javac7BaseFileObjectWrapper(LombokFileObject delegate) {
        super((JavacFileManager) null);
        this.delegate = delegate;
    }

    public boolean isNameCompatible(String simpleName, JavaFileObject.Kind kind) {
        return this.delegate.isNameCompatible(simpleName, kind);
    }

    public URI toUri() {
        return this.delegate.toUri();
    }

    public String getName() {
        return this.delegate.getName();
    }

    public CharSequence getCharContent(boolean ignoreEncodingErrors) throws IOException {
        return this.delegate.getCharContent(ignoreEncodingErrors);
    }

    public InputStream openInputStream() throws IOException {
        return this.delegate.openInputStream();
    }

    public Reader openReader(boolean ignoreEncodingErrors) throws IOException {
        return this.delegate.openReader(ignoreEncodingErrors);
    }

    public Writer openWriter() throws IOException {
        return this.delegate.openWriter();
    }

    public OutputStream openOutputStream() throws IOException {
        return this.delegate.openOutputStream();
    }

    public long getLastModified() {
        return this.delegate.getLastModified();
    }

    public boolean delete() {
        return this.delegate.delete();
    }

    public JavaFileObject.Kind getKind() {
        return this.delegate.getKind();
    }

    public NestingKind getNestingKind() {
        return this.delegate.getNestingKind();
    }

    public Modifier getAccessLevel() {
        return this.delegate.getAccessLevel();
    }

    protected CharsetDecoder getDecoder(boolean ignoreEncodingErrors) {
        return this.delegate.getDecoder(ignoreEncodingErrors);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Javac7BaseFileObjectWrapper)) {
            return false;
        }
        return this.delegate.equals(((Javac7BaseFileObjectWrapper) obj).delegate);
    }

    public int hashCode() {
        return this.delegate.hashCode();
    }

    public String toString() {
        return this.delegate.toString();
    }
}
