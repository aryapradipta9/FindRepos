import control.DriverControl;
import javax.swing.SwingUtilities;

/**
 * Created by 13515017 / Putu Arya Pradipta.
 * Tanggal 6/18/2017.
 * FileName : Main.java.
 */
public class Main {
  /**
   * Program utama.
   * @param args kosong
   */
  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      @Override
      public void run() {
        new DriverControl();
      }
    });

  }
}
