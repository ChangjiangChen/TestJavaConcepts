package com.algorithm.learn.test.unit1.jpanel;

import javax.swing.*;

/**
 * @author : Chen Changjiang
 * @date : 2019/12/16
 * @description :
 */
public class TestJPanel {

    private JPanel myPanel;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JCheckBox checkBox1;
    private JRadioButton radioButton1;
    private JTextPane textAreaTextPane;

    public static void init() {
        JFrame frame = new JFrame("TestJPanel");
        frame.setContentPane(new TestJPanel().myPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
