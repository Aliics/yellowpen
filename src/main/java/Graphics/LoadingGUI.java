package Graphics;

import javax.swing.*;
import java.awt.*;

public class LoadingGUI implements Runnable {
    private JFrame frame;
    private JPanel mainPanel;
    private JLabel loadingLabel;
    private JProgressBar loadingBar;
    private JButton cancelLoadingButton;
    private Runnable[] runnables;
    private boolean isLoading;

    public LoadingGUI(String title, Runnable runnable) {
        Runnable[] runnables = {runnable};

        new LoadingGUI(title, runnables);
    }

    public LoadingGUI(String title, Runnable[] runnables) {
        if (isLoading) return;
        isLoading = true;

        this.runnables = runnables;

        frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setTitle(title);
        frame.setMinimumSize(mainPanel.getMinimumSize());
        frame.setLocation(new Point(
                Toolkit.getDefaultToolkit().getScreenSize().width / 2 - frame.getBounds().width / 2,
                Toolkit.getDefaultToolkit().getScreenSize().height / 2 - frame.getBounds().height / 2
        ));
        frame.setResizable(false);

        cancelLoadingButton.addActionListener(e -> quitLoading());

        frame.add(mainPanel);

        frame.setVisible(true);
    }

    private void setLoadingPercent(int min, int max) {
        double percent = (min != 0 ? (double) min / (double) max : 0) * 100;

        loadingLabel.setText(String.format("Loading [%d / %d]", min, max));
        loadingBar.setValue((int) percent);
    }

    private void quitLoading() {
        isLoading = false;

        frame.dispose();
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

    public JLabel getLoadingLabel() {
        return loadingLabel;
    }

    public void setLoadingLabel(JLabel loadingLabel) {
        this.loadingLabel = loadingLabel;
    }

    public JProgressBar getLoadingBar() {
        return loadingBar;
    }

    public void setLoadingBar(JProgressBar loadingBar) {
        this.loadingBar = loadingBar;
    }

    public JButton getCancelLoadingButton() {
        return cancelLoadingButton;
    }

    public void setCancelLoadingButton(JButton cancelLoadingButton) {
        this.cancelLoadingButton = cancelLoadingButton;
    }

    public boolean isLoading() {
        return isLoading;
    }

    public void setLoading(boolean loading) {
        isLoading = loading;
    }

    @Override
    public void run() {
        int end = runnables.length;
        int current = 1;

        for (Runnable runnable : runnables) {
            if (!isLoading) break;
            setLoadingPercent(current, end);

            current++;

            runnable.run();
        }

        quitLoading();
    }
}
