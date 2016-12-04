package jsample.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.CompletionCallback;
import javax.ws.rs.container.Suspended;

@Path("/resource")
public class AsyncResource {

	@GET
	public void getMessage(@Suspended final AsyncResponse asyncResponse) {
		System.out.println("1. Registering callback, thread = " + Thread.currentThread().getName());
		asyncResponse.register(new CompletionCallback() {
			@Override
			public void onComplete(Throwable throwable) {
				if (throwable == null) {
					// no error
					System.out.println(
							"5. Request processing is successful, thread = " + Thread.currentThread().getName());
				} else {
					System.out.println(
							"5. Error occurred in request processing, thread = " + Thread.currentThread().getName());
				}
			}
		});
		System.out.println(
				"2. Creating new thread for expensive operation, thread = " + Thread.currentThread().getName());
		new Thread(new Runnable() {
			@Override
			public void run() {
				String result = expensiveOperation();
				// return the response
				System.out
						.println("4. Notify callback and send response, thread = " + Thread.currentThread().getName());
				asyncResponse.resume(result);
			}

			private String expensiveOperation() {
				try {
					Thread.sleep(1000 * 20);
					return "Asynchronous Response";
				} catch (InterruptedException e) {
					e.printStackTrace();
					return null;
				}
			}
		}).start();
		System.out.println("3. Original thread exiting, thread = " + Thread.currentThread().getName());
	}
}