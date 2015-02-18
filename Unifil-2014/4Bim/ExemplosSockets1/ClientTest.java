package ExemplosSockets1;

import javax.swing.JFrame;

public class ClientTest {
   public static void main(String[] args) {
      Client charlie;
//      charlie = new Client("69.125.13.88");
      charlie = new Client("localhost");
      charlie.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      charlie.startRunning();
   }
}