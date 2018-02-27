package Graphics;

import Tools.Loadable;

import javax.swing.*;
import java.awt.*;

public class LoadingGUI implements Loadable {
    private JFrame frame;
    private JPanel mainPanel;
    private JProgressBar loadingBar;
    private JLabel loadingLabel;
    private JButton cancelLoadingButton;
    private String title;
    private Loadable[] loadables;

    public LoadingGUI(String title, Loadable[] loadables) {
        this.title = title;
        this.loadables = new Loadable[loadables.length];
        this.loadables = loadables;
    }

    @Override
    public void init() {
        frame = new JFrame(title);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setMinimumSize(mainPanel.getMinimumSize());
        frame.setResizable(false);

        frame.add(mainPanel);

        int displayWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
        int displayHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
        int frameWidth = frame.getBounds().width;
        int frameHeight = frame.getBounds().height;

        frame.setLocation(new Point(
                displayWidth / 2 - frameWidth / 2,
                displayHeight / 2 - frameHeight / 2
        ));

        cancelLoadingButton.addActionListener(actionEvent -> frame.dispose());

        frame.setVisible(true);
    }

    @Override
    public void run() {
        init();

        for (int i = 0; i < loadables.length; i++) {
            if (!frame.isVisible()) break;

            setProgress(i + 1, loadables.length);

            loadables[i].run();
        }

        frame.dispose();
    }

    private void setProgress(int min, int max) {
        double percent = (min != 0 ? (double) min / (double) max : 0) * 100;

        loadingLabel.setText(String.format("Loading [ %d / %d ]", min, max));
        loadingBar.setValue((int) percent);
    }
}
