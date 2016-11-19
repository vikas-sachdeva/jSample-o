package jsample;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Calendar;
import java.util.Date;

public class App {
	public static void main(String[] args)
			throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException, InstantiationException, IOException {

		// Specify URL of the JAR file
		URL url = new URL("file:///F:/mine/eclipse/git_workspace/URL_Class_Loader_Jar/jars/test.jar");
		URL[] classLoaderUrls = new URL[] { url };

		try (URLClassLoader urlClassLoader = new URLClassLoader(classLoaderUrls)) {

			System.out.println("Loading Employee class...");
			Class<?> empClass = urlClassLoader.loadClass("jsample.Employee");

			Constructor<?> constructor = empClass.getConstructor(Integer.class, String.class, String.class,
					String.class, String.class, Date.class);

			Calendar dateofbirth = Calendar.getInstance();
			dateofbirth.clear();
			dateofbirth.set(1980, 10, 2);

			System.out.println("Creating Employee object...");
			Object emp = constructor.newInstance(101, "Alice", "Teacher", "Male", "English", dateofbirth.getTime());

			Method method = empClass.getMethod("toString");
			Object empDetails = method.invoke(emp);
			System.out.println("Employee created - " + empDetails);

		}
	}
}