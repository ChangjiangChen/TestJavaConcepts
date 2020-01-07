package com.algorithm.learn.test.unit1.jpanel;

import javax.swing.*;
import java.awt.*;
import java.awt.font.GlyphVector;

/**
 * @author : ChenChangjiang
 */
public class JavaPanelUsageOf520 extends JFrame {

    private static final int WIDTH = 1200;
    private static final int HEIGHT = 900;

    private static int WINDOW_WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width;
    private static int WINDOW_HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height;

    public JavaPanelUsageOf520() {
        //设置窗口标题
        super("");
        this.setBackground(Color.BLACK);
        //设置窗口位置
        this.setLocation((WINDOW_WIDTH - WIDTH) / 2, (WINDOW_HEIGHT - HEIGHT) / 2);
        //设置窗口大小
        this.setSize(WIDTH, HEIGHT);
        //设置窗口布局
        this.setLayout(getLayout());
        //设置窗口可见
        this.setVisible(true);
        //设置窗口默认关闭方式
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    @Override
    public void paint(Graphics g) {
        //横纵坐标以及半径
        double x, y, r;
        Image image = this.createImage(WIDTH, HEIGHT);
        Graphics pic = image.getGraphics();
        for (int i = -2; i < 90; i++) {
            for (int j = -2; j < 90; j++) {
                r = Math.PI / 45 + Math.PI / 45 * i * (1 - Math.sin(Math.PI / 45 * j)) * 18;
                x = r * Math.cos(Math.PI / 45 * j) * Math.sin(Math.PI / 45 * i) + WIDTH / 2;
                y = -r * Math.sin(Math.PI / 45 * j) + HEIGHT / 3;
                pic.setColor(Color.CYAN);
                pic.fillOval((int) x, (int) y, 2, 2);
            }
            //生成图片
            g.drawImage(image, 0, 0, this);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Font f = new Font("宋体", Font.BOLD, 60);
        GlyphVector v = f.createGlyphVector(getFontMetrics(f).getFontRenderContext(), "--滚滚爸爸送给滚滚妈妈的520礼物");
        Shape shape = v.getOutline();
        Rectangle bounds = shape.getBounds();
        Graphics2D gg = (Graphics2D) g;
        gg.translate(
                (getWidth() - bounds.width) / 2 - bounds.x,
                (getHeight() - bounds.height) / 1.2 - bounds.y
        );
        gg.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        gg.setColor(Color.WHITE);
        gg.fill(shape);
        gg.setColor(Color.pink);
        gg.setStroke(new BasicStroke(3));
        gg.draw(shape);
    }
}
