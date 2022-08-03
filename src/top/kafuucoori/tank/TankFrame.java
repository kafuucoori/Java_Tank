package top.kafuucoori.tank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @Author: KafuuCoori
 * @Date: 2022/8/3 - 08 - 03 - 10:50
 * @Description: top.kafuucoori.tank
 * @version: 1.0
 */
public class TankFrame extends Frame {
    // 定义坐标值
    int x = 200, y = 200;

    // 创建窗口
    public TankFrame() {
        // 设置窗口大小
        setSize(800, 600);
        // 设置窗口大小不可变
        setResizable(false);
        // 设置窗口标题
        setTitle("Tank War");
        // 设置窗口可见
        setVisible(true);
        // 添加窗口监听器

        this.addKeyListener(new MyKeyListener());

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // 使窗口可以正常关闭
                System.exit(0);
            }
        });
    }

    @Override
    // 窗口重新绘制时会自动调用
    public void paint(Graphics g) {
        // 填充一个矩形
        g.fillRect(x, y, 50, 50);
    }

    // 键盘监听处理
    class MyKeyListener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            x += 30;
            repaint();
        }

        @Override
        public void keyReleased(KeyEvent e) {
            super.keyReleased(e);
        }
    }
}
