package jsample.annotation.parser;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import jsample.annotation.MethodInfo;

public class AnnotationParser {

	public static void parseAnnotation(Class<?> classToParse) {
		try {
			for (Method method : classToParse.getMethods()) {
				// checks if MethodInfo annotation is present for the method

				if (method.isAnnotationPresent(jsample.annotation.MethodInfo.class)) {

					// iterates all the annotations available in the method
					for (Annotation anno : method.getDeclaredAnnotations()) {
						System.out.println("Annotation in Method '" + method + "' : " + anno);
					}

					MethodInfo methodAnno = method.getAnnotation(MethodInfo.class);
					if (methodAnno.revision() == 1) {
						System.out.println("Method with revision no 1 = " + method);
					}
				}
			}
		} catch (SecurityException e) {
			e.printStackTrace();
		}
	}
}