package lombok.launch;

import java.lang.reflect.Field;
import java.util.Set;
import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Completion;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.Element;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.TypeElement;
import sun.misc.Unsafe;
/* compiled from: AnnotationProcessor.java */
/* loaded from: classes3.dex */
class AnnotationProcessorHider {

    /* compiled from: AnnotationProcessor.java */
    /* loaded from: classes3.dex */
    public static class AstModificationNotifierData {
        public static volatile boolean lombokInvoked;
    }

    AnnotationProcessorHider() {
    }

    /* loaded from: classes3.dex */
    public static class AnnotationProcessor extends AbstractProcessor {
        private final AbstractProcessor instance = createWrappedInstance();

        public Set<String> getSupportedOptions() {
            return this.instance.getSupportedOptions();
        }

        public Set<String> getSupportedAnnotationTypes() {
            return this.instance.getSupportedAnnotationTypes();
        }

        public SourceVersion getSupportedSourceVersion() {
            return this.instance.getSupportedSourceVersion();
        }

        public void init(ProcessingEnvironment processingEnvironment) {
            disableJava9SillyWarning();
            AstModificationNotifierData.lombokInvoked = true;
            this.instance.init(processingEnvironment);
            super.init(processingEnvironment);
        }

        private void disableJava9SillyWarning() {
            try {
                Field declaredField = Unsafe.class.getDeclaredField("theUnsafe");
                declaredField.setAccessible(true);
                Unsafe unsafe = (Unsafe) declaredField.get(null);
                Class<?> cls = Class.forName("jdk.internal.module.IllegalAccessLogger");
                unsafe.putObjectVolatile(cls, unsafe.staticFieldOffset(cls.getDeclaredField("logger")), (Object) null);
            } catch (Throwable unused) {
            }
        }

        public boolean process(Set<? extends TypeElement> set, RoundEnvironment roundEnvironment) {
            return this.instance.process(set, roundEnvironment);
        }

        public Iterable<? extends Completion> getCompletions(Element element, AnnotationMirror annotationMirror, ExecutableElement executableElement, String str) {
            return this.instance.getCompletions(element, annotationMirror, executableElement, str);
        }

        private static AbstractProcessor createWrappedInstance() {
            try {
                return (AbstractProcessor) Main.getShadowClassLoader().loadClass("lombok.core.AnnotationProcessor").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (Throwable th) {
                if (th instanceof Error) {
                    throw ((Error) th);
                }
                if (th instanceof RuntimeException) {
                    throw ((RuntimeException) th);
                }
                throw new RuntimeException(th);
            }
        }
    }

    /* compiled from: AnnotationProcessor.java */
    @SupportedAnnotationTypes({"lombok.*"})
    /* loaded from: classes3.dex */
    public static class ClaimingProcessor extends AbstractProcessor {
        public boolean process(Set<? extends TypeElement> set, RoundEnvironment roundEnvironment) {
            return true;
        }

        public SourceVersion getSupportedSourceVersion() {
            return SourceVersion.latest();
        }
    }
}
