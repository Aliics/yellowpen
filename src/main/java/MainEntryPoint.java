import Graphics.LoadingGUI;
import Graphics.TextEditorGUI;
import Tools.Loadable;

import javax.swing.*;

public class MainEntryPoint {
    public static LoadingGUI loadingGUI;

    public static void main(String[] args) {
        setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");

        Loadable[] initialLoad = {new TextEditorGUI("Main Window")};

        loadingGUI = new LoadingGUI("Inital Setup", initialLoad);
        loadingGUI.run();
    }

    static void setLookAndFeel(String lookAndFeel) {
        try {
            UIManager.setLookAndFeel(lookAndFeel);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
