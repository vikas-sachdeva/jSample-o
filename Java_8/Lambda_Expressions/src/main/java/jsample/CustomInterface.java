package jsample;

@FunctionalInterface
interface AppInterface {

	public void doSomething();

}

public class CustomInterface {

	public static void test(AppInterface app2Interface) {
		app2Interface.doSomething();
	}

	public static void main(String[] args) {

		/**
		 * Without lambda expression
		 */
		test(new AppInterface() {

			@Override
			public void doSomething() {
				System.out.println("Interface method is called in traditional way");
			}
		});

		/**
		 * With lambda expression
		 */
		test(

				() -> System.out.println("Interface method is called using Lambda Expressions"));
		/**
		 * With lambda expression
		 */
		test(

				() -> {
					System.out.println("Statement 1 of Interface method called using Lambda Expressions ");
					System.out.println("Statement 2 of Interface method called using Lambda Expressions ");
				});
	}
}