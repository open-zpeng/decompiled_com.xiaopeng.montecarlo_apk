package lombok.javac;

import com.autonavi.gbl.guide.model.RangeType;
import com.xiaopeng.montecarlo.util.SpeechRecognizerHelper;
import java.io.File;
import java.util.Collection;
import java.util.Iterator;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.tools.Diagnostic;
import javax.tools.DiagnosticListener;
import javax.tools.JavaFileObject;
/* loaded from: 地图_V1.10.0_20240112105442_Release.apk:lombok/javac/CapturingDiagnosticListener.SCL.lombok */
public class CapturingDiagnosticListener implements DiagnosticListener<JavaFileObject> {
    private final File file;
    private final Collection<CompilerMessage> messages;

    public CapturingDiagnosticListener(File file, Collection<CompilerMessage> messages) {
        this.file = file;
        this.messages = messages;
    }

    public void report(Diagnostic<? extends JavaFileObject> d) {
        String msg = d.getMessage(Locale.ENGLISH);
        Matcher m = Pattern.compile("^" + Pattern.quote(this.file.getAbsolutePath()) + "\\s*:\\s*\\d+\\s*:\\s*(?:warning:\\s*)?(.*)$", 32).matcher(msg);
        if (m.matches()) {
            msg = m.group(1);
        }
        if (msg.equals("deprecated item is not annotated with @Deprecated")) {
            return;
        }
        this.messages.add(new CompilerMessage(d.getLineNumber(), d.getStartPosition(), d.getKind() == Diagnostic.Kind.ERROR, msg));
    }

    public void suppress(int start, int end) {
        Iterator<CompilerMessage> it = this.messages.iterator();
        while (it.hasNext()) {
            long pos = it.next().getPosition();
            if (pos >= start && pos < end) {
                it.remove();
            }
        }
    }

    /* loaded from: 地图_V1.10.0_20240112105442_Release.apk:lombok/javac/CapturingDiagnosticListener$CompilerMessage.SCL.lombok */
    public static final class CompilerMessage {
        private final long line;
        private final long position;
        private final boolean isError;
        private final String message;

        public CompilerMessage(long line, long position, boolean isError, String message) {
            this.line = line;
            this.position = position;
            this.isError = isError;
            this.message = message;
        }

        public long getLine() {
            return this.line;
        }

        public long getPosition() {
            return this.position;
        }

        public boolean isError() {
            return this.isError;
        }

        public String getMessage() {
            return this.message;
        }

        public int hashCode() {
            int result = (31 * 1) + (this.isError ? RangeType.RANGETYPE_CAMERA_SPEED_PROMPT : 1237);
            return (31 * ((31 * result) + ((int) (this.line ^ (this.line >>> 32))))) + (this.message == null ? 0 : this.message.hashCode());
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && getClass() == obj.getClass()) {
                CompilerMessage other = (CompilerMessage) obj;
                if (this.isError == other.isError && this.line == other.line) {
                    return this.message == null ? other.message == null : this.message.equals(other.message);
                }
                return false;
            }
            return false;
        }

        public String toString() {
            Object[] objArr = new Object[3];
            objArr[0] = Long.valueOf(this.line);
            objArr[1] = this.isError ? SpeechRecognizerHelper.TTS_SPEAK_ERROR : "WARNING";
            objArr[2] = this.message;
            return String.format("%d %s %s", objArr);
        }
    }
}
