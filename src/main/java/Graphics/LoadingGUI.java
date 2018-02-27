package Graphics;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoadingGUI {
    private JFrame jFrame;
    private JPanel mainPanel;
    private JLabel loadingLabel;
    private JProgressBar loadingBar;
    private JButton cancelLoadingButton;
    private Thread loadThread;

    public LoadingGUI(Runnable runnable) {
        Runnable[] runnables = {runnable};

        new LoadingGUI(runnables);
    }

    public LoadingGUI(Runnable[] runnables) {
        jFrame = new JFrame();
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setMinimumSize(mainPanel.getMinimumSize());
        jFrame.setResizable(false);

        cancelLoadingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                loadThread.stop();
                jFrame.dispose();
            }
        });

        jFrame.add(mainPanel);

        jFrame.setVisible(true);

        loadThread = new Thread(() -> {
            int end = runnables.length;
            int current = 1;

            for (Runnable runnable : runnables) {
                setLoadingPercent(current, end);

                current++;

                runnable.run();
            }

            jFrame.dispose();
        });

        loadThread.start();
    }

    public void setLoadingPercent(int min, int max) {
        double percent = (min != 0 ? (double) min / (double) max: 0) * 100;

        System.out.println(percent);

        loadingLabel.setText(String.format("Loading [%d / %d]", min, max));
        loadingBar.setValue((int) percent);
    }

    public JFrame getjFrame() {
        return jFrame;
    }

    public void setjFrame(JFrame jFrame) {
        this.jFrame = jFrame;
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

    public Thread getLoadThread() {
        return loadThread;
    }

    public void setLoadThread(Thread loadThread) {
        this.loadThread = loadThread;
    }
}
