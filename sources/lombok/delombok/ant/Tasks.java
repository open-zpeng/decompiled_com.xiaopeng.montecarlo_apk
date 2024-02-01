package lombok.delombok.ant;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Location;
import org.apache.tools.ant.Task;
import org.apache.tools.ant.types.FileSet;
import org.apache.tools.ant.types.Path;
import org.apache.tools.ant.types.Reference;
/* compiled from: DelombokTask.java */
/* loaded from: classes3.dex */
class Tasks {
    Tasks() {
    }

    /* compiled from: DelombokTask.java */
    /* loaded from: classes3.dex */
    public static class Format {
        private String value;

        public int hashCode() {
            String str = this.value;
            return 31 + (str == null ? 0 : str.hashCode());
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && getClass() == obj.getClass()) {
                Format format = (Format) obj;
                String str = this.value;
                if (str == null) {
                    if (format.value != null) {
                        return false;
                    }
                } else if (!str.equals(format.value)) {
                    return false;
                }
                return true;
            }
            return false;
        }

        public String toString() {
            return "FormatOption [value=" + this.value + "]";
        }

        public String getValue() {
            return this.value;
        }

        public void setValue(String str) {
            this.value = str;
        }
    }

    /* compiled from: DelombokTask.java */
    /* loaded from: classes3.dex */
    public static class Delombok extends Task {
        private static ClassLoader shadowLoader;
        private Path classpath;
        private String encoding;
        private List<Format> formatOptions = new ArrayList();
        private File fromDir;
        private Path modulepath;
        private Path path;
        private Path sourcepath;
        private File toDir;
        private boolean verbose;

        public void setClasspath(Path path) {
            Path path2 = this.classpath;
            if (path2 == null) {
                this.classpath = path;
            } else {
                path2.append(path);
            }
        }

        public Path createClasspath() {
            if (this.classpath == null) {
                this.classpath = new Path(getProject());
            }
            return this.classpath.createPath();
        }

        public void setClasspathRef(Reference reference) {
            createClasspath().setRefid(reference);
        }

        public void setSourcepath(Path path) {
            Path path2 = this.sourcepath;
            if (path2 == null) {
                this.sourcepath = path;
            } else {
                path2.append(path);
            }
        }

        public Path createSourcepath() {
            if (this.sourcepath == null) {
                this.sourcepath = new Path(getProject());
            }
            return this.sourcepath.createPath();
        }

        public void setSourcepathRef(Reference reference) {
            createSourcepath().setRefid(reference);
        }

        public void setModulepath(Path path) {
            Path path2 = this.modulepath;
            if (path2 == null) {
                this.modulepath = path;
            } else {
                path2.append(path);
            }
        }

        public Path createModulepath() {
            if (this.modulepath == null) {
                this.modulepath = new Path(getProject());
            }
            return this.modulepath.createPath();
        }

        public void setModulepathRef(Reference reference) {
            createModulepath().setRefid(reference);
        }

        public void setFrom(File file) {
            this.fromDir = file;
        }

        public void setTo(File file) {
            this.toDir = file;
        }

        public void setVerbose(boolean z) {
            this.verbose = z;
        }

        public void setEncoding(String str) {
            this.encoding = str;
        }

        public void addFileset(FileSet fileSet) {
            if (this.path == null) {
                this.path = new Path(getProject());
            }
            this.path.add(fileSet);
        }

        public void addFormat(Format format) {
            this.formatOptions.add(format);
        }

        public static Class<?> shadowLoadClass(String str) {
            try {
                if (shadowLoader == null) {
                    try {
                        Class.forName("lombok.core.LombokNode");
                        shadowLoader = Delombok.class.getClassLoader();
                    } catch (ClassNotFoundException unused) {
                        Method declaredMethod = Class.forName("lombok.launch.Main").getDeclaredMethod("getShadowClassLoader", new Class[0]);
                        declaredMethod.setAccessible(true);
                        shadowLoader = (ClassLoader) declaredMethod.invoke(null, new Object[0]);
                    }
                }
                return Class.forName(str, true, shadowLoader);
            } catch (Exception e) {
                if (e instanceof RuntimeException) {
                    throw ((RuntimeException) e);
                }
                throw new RuntimeException(e);
            }
        }

        public void execute() throws BuildException {
            Field[] declaredFields;
            Location location = getLocation();
            try {
                Object newInstance = shadowLoadClass("lombok.delombok.ant.DelombokTaskImpl").getConstructor(new Class[0]).newInstance(new Object[0]);
                for (Field field : getClass().getDeclaredFields()) {
                    if (!field.isSynthetic() && !Modifier.isStatic(field.getModifiers())) {
                        Field declaredField = newInstance.getClass().getDeclaredField(field.getName());
                        declaredField.setAccessible(true);
                        if (field.getName().equals("formatOptions")) {
                            ArrayList arrayList = new ArrayList();
                            for (Format format : this.formatOptions) {
                                if (format.getValue() == null) {
                                    throw new BuildException("'value' property required for <format>");
                                }
                                arrayList.add(format.getValue());
                            }
                            declaredField.set(newInstance, arrayList);
                        } else {
                            declaredField.set(newInstance, field.get(this));
                        }
                    }
                }
                newInstance.getClass().getMethod("execute", Location.class).invoke(newInstance, location);
            } catch (Exception e) {
                boolean z = e instanceof InvocationTargetException;
                Throwable th = e;
                if (z) {
                    th = e.getCause();
                }
                if (th instanceof Error) {
                    throw ((Error) th);
                }
                if (!(th instanceof RuntimeException)) {
                    throw new RuntimeException(th);
                }
                throw ((RuntimeException) th);
            }
        }
    }
}
