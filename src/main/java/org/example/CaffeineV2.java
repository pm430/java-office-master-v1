package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CaffeineV2 {

    private static final int TIME_INTERVAL = 5 * 60 * 1000; // 5 minutes in milliseconds

    public static void main(String[] args) {
        JFrame frame = new JFrame("Caffeine");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 100);
        frame.setLocationRelativeTo(null);

        JButton button = new JButton("Drink coffee");
        frame.add(button, BorderLayout.CENTER);

        button.addActionListener(new ActionListener() {
            Timer timer;

            @Override
            public void actionPerformed(ActionEvent e) {
                if (timer == null) {
                    timer = new Timer(TIME_INTERVAL, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            moveMouse();
                        }
                    });
                    timer.start();
                    button.setText("Stop");
                    frame.setExtendedState(JFrame.ICONIFIED); // 창을 최소화합니다.
                } else {
                    timer.stop();
                    timer = null;
                    button.setText("Drink coffee");
                    //frame.setExtendedState(JFrame.NORMAL); // 창을 원래 크기로 복원합니다.
                }
            }
        });

        frame.setVisible(true);
    }

    private static void moveMouse() {
        try {
            Robot robot = new Robot();
            Point currentMousePosition = MouseInfo.getPointerInfo().getLocation();
            robot.mouseMove(currentMousePosition.x + 1, currentMousePosition.y + 1);
            robot.mouseMove(currentMousePosition.x, currentMousePosition.y);
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }
}
