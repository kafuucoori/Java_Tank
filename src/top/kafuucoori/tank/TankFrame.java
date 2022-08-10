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
    // 初始化玩家坦克位置和方向
    Tank myTank = new Tank(200, 200, Dir.UP);

    // 初始化子弹
    Bullet b = new Bullet(300, 300 ,Dir.DOWN);

    // 创建窗口
    public TankFrame() {
        // 设置窗口大小
        setSize(1500, 800);
        // 设置窗口大小不可变
        setResizable(false);
        // 设置窗口标题
        setTitle("Tank War");
        // 设置窗口可见
        setVisible(true);
        // 添加窗口监听器
        this.addKeyListener(new MyKeyListener());
        // 使窗口可以正常关闭
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    @Override
    // 窗口重新绘制时会自动调用
    public void paint(Graphics g) {
        myTank.paint(g);
        b.paint(g);
    }

    // 键盘监听处理
    class MyKeyListener extends KeyAdapter {
        // 定义各按键状态
        boolean bl = false;
        boolean br = false;
        boolean bu = false;
        boolean bd = false;

        @Override
        public void keyPressed(KeyEvent e) {
            // 获取按键返回值
            int key = e.getKeyCode();

            switch (key) {
                case KeyEvent.VK_LEFT:
                    bl = true; break;
                case KeyEvent.VK_RIGHT:
                    br = true; break;
                case KeyEvent.VK_UP:
                    bu = true; break;
                case KeyEvent.VK_DOWN:
                    bd = true; break;
                default: break;
            }
            // 根据按键设置坦克朝向
            setMainTankDir();
        }

        @Override
        public void keyReleased(KeyEvent e) {
            int key = e.getKeyCode();

            switch (key) {
                case KeyEvent.VK_LEFT:
                    bl = false; break;
                case KeyEvent.VK_RIGHT:
                    br = false; break;
                case KeyEvent.VK_UP:
                    bu = false; break;
                case KeyEvent.VK_DOWN:
                    bd = false; break;
                default: break;
            }
            setMainTankDir();
        }

        private void setMainTankDir() {
            if(!bl && !br && !bu && !bd)
                myTank.setMoving(false);
            else {
                myTank.setMoving(true);
                if (bl) myTank.setDir(Dir.LEFT);
                if (br) myTank.setDir(Dir.Right);
                if (bu) myTank.setDir(Dir.UP);
                if (bd) myTank.setDir(Dir.DOWN);
            }

        }
    }
}
