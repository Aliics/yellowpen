import Graphics.LoadingGUI;
import Graphics.TextEditorGUI;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class MainEntryPoint {
    public static LoadingGUI loadingGUI;
    public static Runnable[] runnables;

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }

        List<Runnable> runnableArray = new ArrayList<>();
        runnableArray.add(new TextEditorGUI("Main Window"));

        runnables = new Runnable[runnableArray.size()];

        runnableArray.toArray(runnables);

        loadingGUI = new LoadingGUI("Initial Setup", runnables);
        loadingGUI.run();
    }
}
