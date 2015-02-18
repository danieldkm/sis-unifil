package ExemplosSockets2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TestSocketThread {

    // Need away to stop the program...
    private static boolean acceptMore = true;

    public static void main(String[] args) {
        new TestSocketThread();
    }

    public TestSocketThread() {
        ServerSocket serverSocket = null;
        try {
             serverSocket = new ServerSocket(6969, 100);
            while (acceptMore) {
                Socket socket = serverSocket.accept();
                new Thread(new SocketThread(socket)).start();    
            }
        } catch (IOException exp) {
            exp.printStackTrace();
        } finally {
            try {
                serverSocket.close();
            } catch (Exception e) {
            }
        }
    }

    public class SocketThread implements Runnable {

        private Socket socket;

        public SocketThread(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            // Process socket...
        }
    }
}
