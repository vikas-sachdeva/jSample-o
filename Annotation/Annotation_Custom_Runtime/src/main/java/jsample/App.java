package jsample;

import jsample.annotation.parser.AnnotationParser;
import jsample.annotation.user.AnnotationUser;

public class App {
	public static void main(String[] args) {

		AnnotationParser.parseAnnotation(AnnotationUser.class);

	}
}
