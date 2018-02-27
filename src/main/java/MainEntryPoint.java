import Graphics.LoadingGUI;

import javax.swing.*;

public class MainEntryPoint {
    public static LoadingGUI loadingGUI;

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Runnable[] runnables = {
                runnable,
                runnable,
                runnable,
                runnable,
                runnable,
                runnable,
                runnable
        };

        loadingGUI = new LoadingGUI(runnables);
    }
}
