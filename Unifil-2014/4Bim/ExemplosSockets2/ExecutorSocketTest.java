package ExemplosSockets2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorSocketTest {

	// Need away to stop the program...
	private static boolean acceptMore = true;

	public static void main(String[] args) {
		new ExecutorSocketTest();
	}

	public ExecutorSocketTest() {
		ServerSocket serverSocket = null;
		ExecutorService executorService = Executors.newFixedThreadPool(100);
		try {
			serverSocket = new ServerSocket(6969, 100);
			while (acceptMore) {
				Socket socket = serverSocket.accept();
				executorService.submit(new SocketCallable(socket));
			}
		} catch (IOException exp) {
			exp.printStackTrace();
		} finally {
			try {
				serverSocket.close();
			} catch (Exception e) {
			}
			executorService.shutdownNow();
		}
	}

	/**
	 *
	 * @author swhitehead
	 */
	public class SocketCallable implements Callable {

		private Socket socket;

		public SocketCallable(Socket socket) {
			this.socket = socket;
		}

		@Override
		public Object call() throws Exception {
			// Process socket requests...
			return null;
		}
	}
}