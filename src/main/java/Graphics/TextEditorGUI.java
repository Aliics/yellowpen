package Graphics;

import javax.swing.*;

public class TextEditorGUI implements Runnable {
    private JFrame frame;
    private JPanel mainPanel;
    private String title;

    public TextEditorGUI(String title) {
        this.title = title;
    }

    @Override
    public void run() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setTitle(title);
        frame.setMinimumSize(mainPanel.getMinimumSize());
        frame.setPreferredSize(mainPanel.getPreferredSize());

        frame.add(mainPanel);

        frame.setVisible(true);
    }

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public void setMainPanel(JPanel mainPanel) {
        this.mainPanel = mainPanel;
    }
}
