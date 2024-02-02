package lombok.delombok;

import com.autonavi.common.tool.FDManager;
import com.sun.tools.javac.code.Symtab;
import com.sun.tools.javac.comp.Todo;
import com.sun.tools.javac.file.BaseFileManager;
import com.sun.tools.javac.main.Arguments;
import com.sun.tools.javac.main.JavaCompiler;
import com.sun.tools.javac.tree.JCTree;
import com.sun.tools.javac.util.Context;
import com.sun.tools.javac.util.ListBuffer;
import com.xiaopeng.montecarlo.navcore.location.LocationUtils;
import com.xiaopeng.montecarlo.root.util.DebugProperties;
import com.zwitserloot.cmdreader.CmdReader;
import com.zwitserloot.cmdreader.Description;
import com.zwitserloot.cmdreader.Excludes;
import com.zwitserloot.cmdreader.FullName;
import com.zwitserloot.cmdreader.InvalidCommandLineException;
import com.zwitserloot.cmdreader.Mandatory;
import com.zwitserloot.cmdreader.Sequential;
import com.zwitserloot.cmdreader.Shorthand;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URI;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.regex.Pattern;
import javax.tools.DiagnosticListener;
import javax.tools.JavaFileManager;
import javax.tools.JavaFileObject;
import lombok.Lombok;
import lombok.javac.CommentCatcher;
import lombok.javac.Javac;
import lombok.javac.LombokOptions;
import lombok.javac.apt.LombokProcessor;
import lombok.permit.Permit;
/* loaded from: xp_Montecarlo-benchEdward.apk:lombok/delombok/Delombok.SCL.lombok */
public class Delombok {
    private Writer presetWriter;
    private boolean verbose;
    private boolean noCopy;
    private boolean onlyChanged;
    private boolean disablePreview;
    private String classpath;
    private String sourcepath;
    private String bootclasspath;
    private String modulepath;
    private static final Field MODULE_FIELD = getModuleField();
    private static Method attributeMethod;
    private static Method flowMethod;
    private Charset charset = Charset.defaultCharset();
    private Context context = new Context();
    private PrintStream feedback = System.err;
    private boolean force = false;
    private LinkedHashMap<File, File> fileToBase = new LinkedHashMap<>();
    private List<File> filesToParse = new ArrayList();
    private Map<String, String> formatPrefs = new HashMap();
    private File output = null;

    public void setWriter(Writer writer) {
        this.presetWriter = writer;
    }

    /* loaded from: xp_Montecarlo-benchEdward.apk:lombok/delombok/Delombok$CmdArgs.SCL.lombok */
    private static class CmdArgs {
        @Excludes({"quiet"})
        @Description("Print the name of each file as it is being delombok-ed.")
        @Shorthand({"v"})
        private boolean verbose;
        @FullName("format-help")
        private boolean formatHelp;
        @Excludes({DebugProperties.VALUE_BLLOG_LEVEL_VERBOSE})
        @Description("No warnings or errors will be emitted to standard error")
        @Shorthand({"q"})
        private boolean quiet;
        @Description("Sets the encoding of your source files. Defaults to the system default charset. Example: \"UTF-8\"")
        @Shorthand({"e"})
        private String encoding;
        @Description("Print delombok-ed code to standard output instead of saving it in target directory")
        @Shorthand({"p"})
        private boolean print;
        @Description("Directory to save delomboked files to")
        @Mandatory(onlyIfNot = {"print", "help", "format-help"})
        @Shorthand({"d"})
        private String target;
        @Description("Classpath (analogous to javac -cp option)")
        @Shorthand({"c"})
        private String classpath;
        @Description("Sourcepath (analogous to javac -sourcepath option)")
        @Shorthand({"s"})
        private String sourcepath;
        @Description("override Bootclasspath (analogous to javac -bootclasspath option)")
        private String bootclasspath;
        @Description("Module path (analogous to javac --module-path option)")
        @FullName("module-path")
        private String modulepath;
        @Description("Lombok will only delombok source files. Without this option, non-java, non-class files are copied to the target directory.")
        @Shorthand({"n"})
        private boolean nocopy;
        @Description("Output only changed files (implies -n)")
        private boolean onlyChanged;
        @Description("By default lombok enables preview features if available (introduced in JDK 12). With this option, lombok won't do that.")
        @FullName("disable-preview")
        private boolean disablePreview;
        private boolean help;
        @Description("Sets formatting rules. Use --format-help to list all available rules. Unset format rules are inferred by scanning the source for usages.")
        @Shorthand({"f"})
        private List<String> format = new ArrayList();
        @Description("Files to delombok. Provide either a file, or a directory. If you use a directory, all files in it (recursive) are delombok-ed")
        @Sequential
        private List<String> input = new ArrayList();

        private CmdArgs() {
        }
    }

    private static String indentAndWordbreak(String in, int indent, int maxLen) {
        StringBuilder out = new StringBuilder();
        StringBuilder line = new StringBuilder();
        StringBuilder word = new StringBuilder();
        int len = in.length();
        int i = 0;
        while (i < len + 1) {
            char c = i == len ? ' ' : in.charAt(i);
            if (c == ' ') {
                if (line.length() + word.length() < maxLen) {
                    line.append((CharSequence) word);
                } else {
                    if (out.length() > 0) {
                        out.append(FDManager.LINE_SEPERATOR);
                    }
                    for (int j = 0; j < indent; j++) {
                        out.append(" ");
                    }
                    out.append((CharSequence) line);
                    line.setLength(0);
                    line.append(word.toString().trim());
                }
                word.setLength(0);
            }
            if (i < len) {
                word.append(c);
            }
            i++;
        }
        if (line.length() > 0) {
            if (out.length() > 0) {
                out.append(FDManager.LINE_SEPERATOR);
            }
            for (int j2 = 0; j2 < indent; j2++) {
                out.append(" ");
            }
            out.append((CharSequence) line);
        }
        return out.toString();
    }

    static String getPathOfSelf() {
        String url;
        String url2 = Delombok.class.getResource("Delombok.class").toString();
        if (url2.endsWith("lombok/delombok/Delombok.class")) {
            url = urlDecode(url2.substring(0, url2.length() - "lombok/delombok/Delombok.class".length()));
        } else if (url2.endsWith("lombok/delombok/Delombok.SCL.lombok")) {
            url = urlDecode(url2.substring(0, url2.length() - "lombok/delombok/Delombok.SCL.lombok".length()));
        } else {
            return null;
        }
        if (url.startsWith("jar:file:") && url.endsWith("!/")) {
            return url.substring(9, url.length() - 2);
        }
        if (url.startsWith("file:")) {
            return url.substring(5);
        }
        return null;
    }

    private static String urlDecode(String in) {
        try {
            return URLDecoder.decode(in, "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            throw new InternalError("UTF-8 not supported");
        }
    }

    public static void main(String[] rawArgs) {
        try {
            rawArgs = fileExpand(rawArgs);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
        CmdReader<CmdArgs> reader = CmdReader.of(CmdArgs.class);
        try {
            CmdArgs args = reader.make(rawArgs);
            if (args.help || (args.input.isEmpty() && !args.formatHelp)) {
                if (!args.help) {
                    System.err.println("ERROR: no files or directories to delombok specified.");
                }
                System.err.println(cmdHelp(reader));
                System.exit(args.help ? 0 : 1);
                return;
            }
            Delombok delombok = new Delombok();
            if (args.quiet) {
                delombok.setFeedback(new PrintStream(new OutputStream() { // from class: lombok.delombok.Delombok.1
                    @Override // java.io.OutputStream
                    public void write(int b) throws IOException {
                    }
                }));
            }
            if (args.formatHelp) {
                System.out.println("Available format keys (to use, -f key:value -f key2:value2 -f ... ):");
                for (Map.Entry<String, String> e2 : FormatPreferences.getKeysAndDescriptions().entrySet()) {
                    System.out.print("  ");
                    System.out.print(e2.getKey());
                    System.out.println(LocationUtils.DR_RECORD_VALUE_SPLIT_CHAR);
                    System.out.println(indentAndWordbreak(e2.getValue(), 4, 70));
                }
                System.out.println("Example: -f indent:4 -f emptyLines:indent");
                System.out.println("The '-f pretty' option is shorthand for '-f suppressWarnings:skip -f generated:skip -f danceAroundIdeChecks:skip -f generateDelombokComment:skip -f javaLangAsFQN:skip'");
                System.exit(0);
                return;
            }
            try {
                delombok.setFormatPreferences(formatOptionsToMap(args.format));
                if (args.encoding != null) {
                    try {
                        delombok.setCharset(args.encoding);
                    } catch (UnsupportedCharsetException unused) {
                        System.err.println("ERROR: Not a known charset: " + args.encoding);
                        System.exit(1);
                        return;
                    }
                }
                if (args.verbose) {
                    delombok.setVerbose(true);
                }
                if (args.nocopy || args.onlyChanged) {
                    delombok.setNoCopy(true);
                }
                if (args.disablePreview) {
                    delombok.setDisablePreview(true);
                }
                if (args.onlyChanged) {
                    delombok.setOnlyChanged(true);
                }
                if (args.print) {
                    delombok.setOutputToStandardOut();
                } else {
                    delombok.setOutput(new File(args.target));
                }
                if (args.classpath != null) {
                    delombok.setClasspath(args.classpath);
                }
                if (args.sourcepath != null) {
                    delombok.setSourcepath(args.sourcepath);
                }
                if (args.bootclasspath != null) {
                    delombok.setBootclasspath(args.bootclasspath);
                }
                if (args.modulepath != null) {
                    delombok.setModulepath(args.modulepath);
                }
                try {
                    for (String in : args.input) {
                        File f = new File(in).getAbsoluteFile();
                        if (f.isFile()) {
                            delombok.addFile(f.getParentFile(), f.getName());
                        } else if (f.isDirectory()) {
                            delombok.addDirectory(f);
                        } else if (!f.exists()) {
                            if (!args.quiet) {
                                System.err.println("WARNING: does not exist - skipping: " + f);
                            }
                        } else if (!args.quiet) {
                            System.err.println("WARNING: not a standard file or directory - skipping: " + f);
                        }
                    }
                    delombok.delombok();
                } catch (Exception e3) {
                    if (!args.quiet) {
                        String msg = e3.getMessage();
                        if (msg == null || !msg.startsWith("DELOMBOK: ")) {
                            e3.printStackTrace();
                        } else {
                            System.err.println(msg.substring("DELOMBOK: ".length()));
                        }
                        System.exit(1);
                    }
                }
            } catch (InvalidFormatOptionException e4) {
                System.out.println(String.valueOf(e4.getMessage()) + " Try --format-help.");
                System.exit(1);
            }
        } catch (InvalidCommandLineException e5) {
            System.err.println("ERROR: " + e5.getMessage());
            System.err.println(cmdHelp(reader));
            System.exit(1);
        }
    }

    private static String cmdHelp(CmdReader<CmdArgs> reader) {
        String x = reader.generateCommandLineHelp("delombok");
        int idx = x.indexOf(10);
        return String.valueOf(x.substring(0, idx)) + "\n You can use @filename.args to read arguments from the file 'filename.args'.\n" + x.substring(idx);
    }

    private static String[] fileExpand(String[] rawArgs) throws IOException {
        String[] out = rawArgs;
        int offset = 0;
        for (int i = 0; i < rawArgs.length; i++) {
            if (rawArgs[i].length() > 0 && rawArgs[i].charAt(0) == '@') {
                String[] parts = readArgsFromFile(rawArgs[i].substring(1));
                String[] newOut = new String[(out.length + parts.length) - 1];
                System.arraycopy(out, 0, newOut, 0, i + offset);
                System.arraycopy(parts, 0, newOut, i + offset, parts.length);
                System.arraycopy(out, i + offset + 1, newOut, i + offset + parts.length, out.length - ((i + offset) + 1));
                offset += parts.length - 1;
                out = newOut;
            }
        }
        return out;
    }

    private static String[] readArgsFromFile(String file) throws IOException {
        InputStream in = new FileInputStream(file);
        StringBuilder s = new StringBuilder();
        try {
            InputStreamReader isr = new InputStreamReader(in, "UTF-8");
            char[] c = new char[4096];
            while (true) {
                int r = isr.read(c);
                if (r == -1) {
                    break;
                }
                s.append(c, 0, r);
            }
            isr.close();
            in.close();
            List<String> x = new ArrayList<>();
            StringBuilder a = new StringBuilder();
            int state = 1;
            for (int i = 0; i < s.length(); i++) {
                char c2 = s.charAt(i);
                if (state < 0) {
                    state = -state;
                    if (c2 != '\n') {
                        a.append(c2);
                    }
                } else if (state == 1) {
                    if (c2 == '\\') {
                        state = -1;
                    } else if (c2 == '\"') {
                        state = 2;
                    } else if (c2 == '\'') {
                        state = 3;
                    } else if (Character.isWhitespace(c2)) {
                        String aa = a.toString();
                        if (!aa.isEmpty()) {
                            x.add(aa);
                        }
                        a.setLength(0);
                    } else {
                        a.append(c2);
                    }
                } else if (state == 2) {
                    if (c2 == '\\') {
                        state = -2;
                    } else if (c2 == '\"') {
                        state = 1;
                        x.add(a.toString());
                        a.setLength(0);
                    } else {
                        a.append(c2);
                    }
                } else if (state == 3) {
                    if (c2 == '\'') {
                        state = 1;
                        x.add(a.toString());
                        a.setLength(0);
                    } else {
                        a.append(c2);
                    }
                }
            }
            if (state == 1) {
                String aa2 = a.toString();
                if (!aa2.isEmpty()) {
                    x.add(aa2);
                }
            } else if (state < 0) {
                throw new IOException("Unclosed backslash escape in @ file");
            } else {
                if (state == 2) {
                    throw new IOException("Unclosed \" in @ file");
                }
                if (state == 3) {
                    throw new IOException("Unclosed ' in @ file");
                }
            }
            return (String[]) x.toArray(new String[0]);
        } catch (Throwable th) {
            in.close();
            throw th;
        }
    }

    /* loaded from: xp_Montecarlo-benchEdward.apk:lombok/delombok/Delombok$InvalidFormatOptionException.SCL.lombok */
    public static class InvalidFormatOptionException extends Exception {
        public InvalidFormatOptionException(String msg) {
            super(msg);
        }
    }

    public static Map<String, String> formatOptionsToMap(List<String> formatOptions) throws InvalidFormatOptionException {
        boolean prettyEnabled = false;
        Map<String, String> formatPrefs = new HashMap<>();
        for (String format : formatOptions) {
            int idx = format.indexOf(58);
            if (idx == -1) {
                if (format.equalsIgnoreCase("pretty")) {
                    prettyEnabled = true;
                } else {
                    throw new InvalidFormatOptionException("Format keys need to be 2 values separated with a colon.");
                }
            } else {
                String key = format.substring(0, idx);
                String value = format.substring(idx + 1);
                boolean valid = false;
                Iterator<String> it = FormatPreferences.getKeysAndDescriptions().keySet().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    String k = it.next();
                    if (k.equalsIgnoreCase(key)) {
                        valid = true;
                        break;
                    }
                }
                if (!valid) {
                    throw new InvalidFormatOptionException("Unknown format key: '" + key + "'.");
                }
                formatPrefs.put(key.toLowerCase(), value);
            }
        }
        if (prettyEnabled) {
            if (!formatPrefs.containsKey("suppresswarnings")) {
                formatPrefs.put("suppresswarnings", "skip");
            }
            if (!formatPrefs.containsKey("generated")) {
                formatPrefs.put("generated", "skip");
            }
            if (!formatPrefs.containsKey("dancearoundidechecks")) {
                formatPrefs.put("dancearoundidechecks", "skip");
            }
            if (!formatPrefs.containsKey("generatedelombokcomment")) {
                formatPrefs.put("generatedelombokcomment", "skip");
            }
            if (!formatPrefs.containsKey("javalangasfqn")) {
                formatPrefs.put("javalangasfqn", "skip");
            }
        }
        return formatPrefs;
    }

    public void setFormatPreferences(Map<String, String> prefs) {
        this.formatPrefs = prefs;
    }

    public void setCharset(String charsetName) throws UnsupportedCharsetException {
        if (charsetName == null) {
            this.charset = Charset.defaultCharset();
        } else {
            this.charset = Charset.forName(charsetName);
        }
    }

    public void setDiagnosticsListener(DiagnosticListener<JavaFileObject> diagnostics) {
        if (diagnostics != null) {
            this.context.put(DiagnosticListener.class, diagnostics);
        }
    }

    public void setForceProcess(boolean force) {
        this.force = force;
    }

    public void setFeedback(PrintStream feedback) {
        this.feedback = feedback;
    }

    public void setClasspath(String classpath) {
        this.classpath = classpath;
    }

    public void setSourcepath(String sourcepath) {
        this.sourcepath = sourcepath;
    }

    public void setBootclasspath(String bootclasspath) {
        this.bootclasspath = bootclasspath;
    }

    public void setVerbose(boolean verbose) {
        this.verbose = verbose;
    }

    public void setNoCopy(boolean noCopy) {
        this.noCopy = noCopy;
    }

    public void setDisablePreview(boolean disablePreview) {
        this.disablePreview = disablePreview;
    }

    public void setOnlyChanged(boolean onlyChanged) {
        this.onlyChanged = onlyChanged;
    }

    public void setOutput(File dir) {
        if (dir.isFile() || (!dir.isDirectory() && dir.getName().endsWith(".java"))) {
            throw new IllegalArgumentException("DELOMBOK: delombok will only write to a directory. If you want to delombok a single file, use -p to output to standard output, then redirect this to a file:\ndelombok MyJavaFile.java -p >MyJavaFileDelombok.java");
        }
        this.output = dir;
    }

    public void setOutputToStandardOut() {
        this.output = null;
    }

    public void setModulepath(String modulepath) {
        this.modulepath = modulepath;
    }

    public void addDirectory(File base) throws IOException {
        addDirectory0(false, base, "", 0);
    }

    public void addDirectory1(boolean copy, File base, String name) throws IOException {
        File f = new File(base, name);
        if (!f.isFile()) {
            if (!f.exists()) {
                this.feedback.printf("Skipping %s because it does not exist.\n", canonical(f));
                return;
            } else if (!f.isDirectory()) {
                this.feedback.printf("Skipping %s because it is a special file type.\n", canonical(f));
                return;
            } else {
                return;
            }
        }
        String extension = getExtension(f);
        if (!extension.equals("java")) {
            if (!extension.equals("class")) {
                copy(copy, base, name);
                return;
            } else {
                skipClass(name);
                return;
            }
        }
        addFile(base, name);
    }

    private void addDirectory0(boolean inHiddenDir, File base, String suffix, int loop) throws IOException {
        File dir = suffix.isEmpty() ? base : new File(base, suffix);
        if (dir.isDirectory()) {
            boolean thisDirIsHidden = !inHiddenDir && new File(canonical(dir)).getName().startsWith(".");
            if (loop >= 100) {
                this.feedback.printf("Over 100 subdirectories? I'm guessing there's a loop in your directory structure. Skipping: %s\n", suffix);
                return;
            }
            File[] list = dir.listFiles();
            if (list.length > 0) {
                if (thisDirIsHidden && !this.noCopy && this.output != null) {
                    this.feedback.printf("Only processing java files (not copying non-java files) in %s because it's a hidden directory.\n", canonical(dir));
                }
                for (File f : list) {
                    addDirectory0(inHiddenDir || thisDirIsHidden, base, String.valueOf(suffix) + (suffix.isEmpty() ? "" : File.separator) + f.getName(), loop + 1);
                }
                return;
            } else if (!thisDirIsHidden && !this.noCopy && !inHiddenDir && this.output != null && !suffix.isEmpty()) {
                File emptyDir = new File(this.output, suffix);
                emptyDir.mkdirs();
                if (this.verbose) {
                    this.feedback.printf("Creating empty directory: %s\n", canonical(emptyDir));
                    return;
                }
                return;
            } else {
                return;
            }
        }
        addDirectory1((inHiddenDir || this.noCopy) ? false : true, base, suffix);
    }

    private void skipClass(String fileName) {
        if (this.verbose) {
            this.feedback.printf("Skipping class file: %s\n", fileName);
        }
    }

    private void copy(boolean copy, File base, String fileName) throws IOException {
        if (this.output == null) {
            this.feedback.printf("Skipping resource file: %s\n", fileName);
        } else if (!copy) {
            if (this.verbose) {
                this.feedback.printf("Skipping resource file: %s\n", fileName);
            }
        } else {
            if (this.verbose) {
                this.feedback.printf("Copying resource file: %s\n", fileName);
            }
            byte[] b = new byte[65536];
            File inFile = new File(base, fileName);
            FileInputStream in = new FileInputStream(inFile);
            try {
                File outFile = new File(this.output, fileName);
                outFile.getParentFile().mkdirs();
                FileOutputStream out = new FileOutputStream(outFile);
                while (true) {
                    int r = in.read(b);
                    if (r != -1) {
                        out.write(b, 0, r);
                    } else {
                        out.close();
                        return;
                    }
                }
            } finally {
                in.close();
            }
        }
    }

    public void addFile(File base, String fileName) throws IOException {
        if (this.output != null && canonical(base).equals(canonical(this.output))) {
            throw new IOException("DELOMBOK: Output file and input file refer to the same filesystem location. Specify a separate path for output.");
        }
        File f = new File(base, fileName);
        this.filesToParse.add(f);
        this.fileToBase.put(f, base);
    }

    private static <T> com.sun.tools.javac.util.List<T> toJavacList(List<T> list) {
        com.sun.tools.javac.util.List<T> out = com.sun.tools.javac.util.List.nil();
        ListIterator<T> li = list.listIterator(list.size());
        while (li.hasPrevious()) {
            out = out.prepend(li.previous());
        }
        return out;
    }

    private static Field getModuleField() {
        try {
            return Permit.getField(JCTree.JCCompilationUnit.class, "modle");
        } catch (NoSuchFieldException unused) {
            return null;
        } catch (SecurityException unused2) {
            return null;
        }
    }

    public boolean delombok() throws IOException {
        JavaCompiler delegate;
        Writer rawWriter;
        LombokOptions options = LombokOptionsFactory.getDelombokOptions(this.context);
        options.deleteLombokAnnotations();
        options.putJavacOption("ENCODING", this.charset.name());
        if (this.classpath != null) {
            options.putJavacOption("CLASSPATH", unpackClasspath(this.classpath));
        }
        if (this.sourcepath != null) {
            options.putJavacOption("SOURCEPATH", this.sourcepath);
        }
        if (this.bootclasspath != null) {
            options.putJavacOption("BOOTCLASSPATH", unpackClasspath(this.bootclasspath));
        }
        options.setFormatPreferences(new FormatPreferences(this.formatPrefs));
        options.put("compilePolicy", "check");
        if (Javac.getJavaCompilerVersion() >= 9) {
            Arguments args = Arguments.instance(this.context);
            List<String> argsList = new ArrayList<>();
            if (this.classpath != null) {
                argsList.add("--class-path");
                argsList.add(options.get("--class-path"));
            }
            if (this.sourcepath != null) {
                argsList.add("--source-path");
                argsList.add(options.get("--source-path"));
            }
            if (this.bootclasspath != null) {
                argsList.add("--boot-class-path");
                argsList.add(options.get("--boot-class-path"));
            }
            if (this.charset != null) {
                argsList.add("-encoding");
                argsList.add(this.charset.name());
            }
            String pathToSelfJar = getPathOfSelf();
            if (pathToSelfJar != null) {
                argsList.add("--module-path");
                argsList.add((this.modulepath == null || this.modulepath.isEmpty()) ? pathToSelfJar : String.valueOf(pathToSelfJar) + File.pathSeparator + this.modulepath);
            } else if (this.modulepath != null && !this.modulepath.isEmpty()) {
                argsList.add("--module-path");
                argsList.add(this.modulepath);
            }
            if (!this.disablePreview && Javac.getJavaCompilerVersion() >= 11) {
                argsList.add("--enable-preview");
            }
            if (Javac.getJavaCompilerVersion() < 15) {
                String[] argv = (String[]) argsList.toArray(new String[0]);
                args.init("javac", argv);
            } else {
                args.init("javac", argsList);
            }
            options.put("diags.legacy", "TRUE");
            options.put("allowStringFolding", "FALSE");
        } else if (this.modulepath != null && !this.modulepath.isEmpty()) {
            throw new IllegalStateException("DELOMBOK: Option --module-path requires usage of JDK9 or higher.");
        }
        CommentCatcher catcher = CommentCatcher.create(this.context, Javac.getJavaCompilerVersion() >= 13);
        JavaCompiler compiler = catcher.getCompiler();
        List<JCTree.JCCompilationUnit> roots = new ArrayList<>();
        Map<JCTree.JCCompilationUnit, File> baseMap = new IdentityHashMap<>();
        Set<LombokProcessor> processors = Collections.singleton(new LombokProcessor());
        if (Javac.getJavaCompilerVersion() >= 9) {
            BaseFileManager baseFileManager = (JavaFileManager) this.context.get(JavaFileManager.class);
            if (baseFileManager instanceof BaseFileManager) {
                Arguments args2 = Arguments.instance(this.context);
                baseFileManager.setContext(this.context);
                baseFileManager.handleOptions(args2.getDeferredFileManagerOptions());
            }
        }
        if (Javac.getJavaCompilerVersion() < 9) {
            compiler.initProcessAnnotations(processors);
        } else {
            compiler.initProcessAnnotations(processors, Collections.emptySet(), Collections.emptySet());
        }
        Object unnamedModule = Javac.getJavaCompilerVersion() >= 9 ? Symtab.instance(this.context).unnamedModule : null;
        for (File fileToParse : this.filesToParse) {
            JCTree.JCCompilationUnit unit = compiler.parse(fileToParse.getAbsolutePath());
            if (Javac.getJavaCompilerVersion() >= 9) {
                try {
                    MODULE_FIELD.set(unit, unnamedModule);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
            baseMap.put(unit, this.fileToBase.get(fileToParse));
            roots.add(unit);
        }
        if (compiler.errorCount() > 0) {
            return false;
        }
        for (JCTree.JCCompilationUnit unit2 : roots) {
            catcher.setComments(unit2, new DocCommentIntegrator().integrate(catcher.getComments(unit2), unit2));
        }
        if (Javac.getJavaCompilerVersion() >= 9) {
            compiler.initModules(com.sun.tools.javac.util.List.from((JCTree.JCCompilationUnit[]) roots.toArray(new JCTree.JCCompilationUnit[0])));
        }
        com.sun.tools.javac.util.List<JCTree.JCCompilationUnit> trees = compiler.enterTrees(toJavacList(roots));
        if (Javac.getJavaCompilerVersion() < 9) {
            delegate = compiler.processAnnotations(trees, com.sun.tools.javac.util.List.nil());
        } else {
            delegate = compiler;
            compiler.processAnnotations(trees, com.sun.tools.javac.util.List.nil());
        }
        Object care = callAttributeMethodOnJavaCompiler(delegate, delegate.todo);
        callFlowMethodOnJavaCompiler(delegate, care);
        FormatPreferences fps = new FormatPreferences(this.formatPrefs);
        for (JCTree.JCCompilationUnit unit3 : roots) {
            DelombokResult result = new DelombokResult(catcher.getComments(unit3), catcher.getTextBlockStarts(unit3), unit3, this.force || options.isChanged(unit3), fps);
            if (this.onlyChanged && !result.isChanged() && !options.isChanged(unit3)) {
                if (this.verbose) {
                    this.feedback.printf("File: %s [%s]\n", unit3.sourcefile.getName(), "unchanged (skipped)");
                }
            } else {
                if (this.verbose) {
                    PrintStream printStream = this.feedback;
                    Object[] objArr = new Object[3];
                    objArr[0] = unit3.sourcefile.getName();
                    objArr[1] = result.isChanged() ? "delomboked" : "unchanged";
                    objArr[2] = (!this.force || options.isChanged(unit3)) ? "" : " (forced)";
                    printStream.printf("File: %s [%s%s]\n", objArr);
                }
                if (this.presetWriter != null) {
                    rawWriter = createUnicodeEscapeWriter(this.presetWriter);
                } else {
                    rawWriter = this.output == null ? createStandardOutWriter() : createFileWriter(this.output, baseMap.get(unit3), unit3.sourcefile.toUri());
                }
                BufferedWriter writer = new BufferedWriter(rawWriter);
                try {
                    result.print(writer);
                    if (this.output != null) {
                        writer.close();
                    } else {
                        writer.flush();
                    }
                } catch (Throwable th) {
                    if (this.output != null) {
                        writer.close();
                    } else {
                        writer.flush();
                    }
                    throw th;
                }
            }
        }
        delegate.close();
        return true;
    }

    private String unpackClasspath(String cp) {
        String[] parts = cp.split(Pattern.quote(File.pathSeparator));
        StringBuilder out = new StringBuilder();
        for (String p : parts) {
            if (!p.endsWith("*")) {
                if (out.length() > 0) {
                    out.append(File.pathSeparator);
                }
                out.append(p);
            } else {
                File f = new File(p.substring(0, p.length() - 2));
                File[] files = f.listFiles();
                if (files != null) {
                    for (File file : files) {
                        if (file.isFile()) {
                            if (out.length() > 0) {
                                out.append(File.pathSeparator);
                            }
                            out.append((CharSequence) p, 0, p.length() - 1);
                            out.append(file.getName());
                        }
                    }
                }
            }
        }
        return out.toString();
    }

    private static Object callAttributeMethodOnJavaCompiler(JavaCompiler compiler, Todo arg) {
        if (attributeMethod == null) {
            try {
                attributeMethod = Permit.getMethod(JavaCompiler.class, "attribute", Queue.class);
            } catch (NoSuchMethodException unused) {
                try {
                    attributeMethod = Permit.getMethod(JavaCompiler.class, "attribute", ListBuffer.class);
                } catch (NoSuchMethodException e2) {
                    throw Lombok.sneakyThrow(e2);
                }
            }
        }
        try {
            return attributeMethod.invoke(compiler, arg);
        } catch (Exception e) {
            if (e instanceof InvocationTargetException) {
                throw Lombok.sneakyThrow(e.getCause());
            }
            throw Lombok.sneakyThrow(e);
        }
    }

    private static void callFlowMethodOnJavaCompiler(JavaCompiler compiler, Object arg) {
        if (flowMethod == null) {
            try {
                flowMethod = Permit.getMethod(JavaCompiler.class, "flow", Queue.class);
            } catch (NoSuchMethodException unused) {
                try {
                    flowMethod = Permit.getMethod(JavaCompiler.class, "flow", com.sun.tools.javac.util.List.class);
                } catch (NoSuchMethodException e2) {
                    throw Lombok.sneakyThrow(e2);
                }
            }
        }
        try {
            flowMethod.invoke(compiler, arg);
        } catch (Exception e) {
            if (!(e instanceof InvocationTargetException)) {
                throw Lombok.sneakyThrow(e);
            }
            throw Lombok.sneakyThrow(e.getCause());
        }
    }

    private static String canonical(File dir) {
        try {
            return dir.getCanonicalPath();
        } catch (Exception unused) {
            return dir.getAbsolutePath();
        }
    }

    private static String getExtension(File dir) {
        String name = dir.getName();
        int idx = name.lastIndexOf(46);
        return idx == -1 ? "" : name.substring(idx + 1);
    }

    private Writer createFileWriter(File outBase, File inBase, URI file) throws IOException {
        File outFile;
        URI base = inBase.toURI();
        URI relative = base.relativize(base.resolve(file));
        if (relative.isAbsolute()) {
            outFile = new File(outBase, new File(relative).getName());
        } else {
            outFile = new File(outBase, relative.getPath());
        }
        outFile.getParentFile().mkdirs();
        FileOutputStream out = new FileOutputStream(outFile);
        return createUnicodeEscapeWriter(out);
    }

    private Writer createStandardOutWriter() {
        return createUnicodeEscapeWriter(System.out);
    }

    private Writer createUnicodeEscapeWriter(Writer writer) {
        return new UnicodeEscapeWriter(writer, this.charset);
    }

    private Writer createUnicodeEscapeWriter(OutputStream out) {
        return new UnicodeEscapeWriter(new OutputStreamWriter(out, this.charset), this.charset);
    }
}
