package Graphics;

import Tools.Loadable;

import javax.swing.*;

public class TextEditorGUI implements Loadable {
    private JFrame frame;
    private JPanel mainPanel;
    private JTextArea textArea;
    private String title;

    public TextEditorGUI(String title) {
        this.title = title;
    }

    @Override
    public void init() {
        frame = new JFrame(title);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setMinimumSize(mainPanel.getMinimumSize());

        frame.add(mainPanel);
    }

    @Override
    public void run() {
        init();

        frame.setVisible(true);
    }
}
