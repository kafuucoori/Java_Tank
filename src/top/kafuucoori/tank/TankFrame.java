package top.kafuucoori.tank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @Author: KafuuCoori
 * @Date: 2022/8/22 - 08 - 22 - 17:16
 * @Description: top.kafuucoori.tank
 * @version: 1.0
 */
public class TankFrame extends Frame {

    int x = 600, y = 400;

    public TankFrame() {
        setSize(1300, 800); // 设置窗口大小
        setResizable(false); // 禁用窗口改变大小
        setTitle("Tank War"); // 设置标题
        setVisible(true); // 设置窗口可见
        this.addKeyListener(new MyKeyListener()); // 开启键盘监听
        // 设置 窗口可关闭
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    @Override
    public void paint(Graphics g) { // 窗口重新绘制时自动调用
        g.fillRect(x, y, 50, 50); // 绘制坦克
    }

    class MyKeyListener extends KeyAdapter {

        boolean bL = false;
        boolean bU = false;
        boolean bR = false;
        boolean bD = false;

        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            switch (key) {
                case KeyEvent.VK_LEFT: bL = true; break;
                case KeyEvent.VK_UP: bU = true; break;
                case KeyEvent.VK_RIGHT: bR = true; break;
                case KeyEvent.VK_DOWN: bD = true; break;
                default: break;
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            int key = e.getKeyCode();
            switch (key) {
                case KeyEvent.VK_LEFT: bL = false; break;
                case KeyEvent.VK_UP: bU = false; break;
                case KeyEvent.VK_RIGHT: bR = false; break;
                case KeyEvent.VK_DOWN: bD = false; break;
                default: break;
            }
        }
    }

}
