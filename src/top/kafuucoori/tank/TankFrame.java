package top.kafuucoori.tank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: KafuuCoori
 * @Date: 2022/8/22 - 08 - 22 - 17:16
 * @Description: top.kafuucoori.tank
 * @version: 1.0
 */
public class TankFrame extends Frame {

    Tank myTank = new Tank(600, 400, Dir.DOWN, this);
    List<Bullet> bullets = new ArrayList<>();
    static final int GAME_WIDTH = 1300, GAME_HEIGHT = 800;

    // 创建窗口
    public TankFrame() {
        setSize(GAME_WIDTH, GAME_HEIGHT); // 设置窗口大小
        setResizable(false); // 禁用窗口改变大小
        setTitle("Tank War"); // 设置标题
        setVisible(true); // 设置窗口可见
        this.addKeyListener(new MyKeyListener()); // 开启键盘监听
        // 设置窗口可关闭
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    Image offScreenImage = null;
    @Override   // 双缓冲解决屏幕闪烁
    public void update(Graphics g) {
        if (offScreenImage == null) {
            offScreenImage = this.createImage(GAME_WIDTH, GAME_HEIGHT);
        }
        Graphics gOffScreen = offScreenImage.getGraphics();
        Color c = gOffScreen.getColor();
        gOffScreen.setColor(Color.BLACK);
        gOffScreen.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
        gOffScreen.setColor(c);
        paint(gOffScreen);
        g.drawImage(offScreenImage, 0, 0, null);
    }

    @Override   // 绘制画面内容
    public void paint(Graphics g) { // 窗口重新绘制时自动调用
        myTank.paint(g);
        for(int i=0; i<bullets.size(); i++) {
            bullets.get(i).paint(g);
        }
    }

    // 键盘监听处理
    class MyKeyListener extends KeyAdapter {

        boolean bL = false;
        boolean bU = false;
        boolean bR = false;
        boolean bD = false;

        @Override   // 键盘按下处理
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            switch (key) {
                case KeyEvent.VK_LEFT:  bL = true; break;
                case KeyEvent.VK_UP:    bU = true; break;
                case KeyEvent.VK_RIGHT: bR = true; break;
                case KeyEvent.VK_DOWN:  bD = true; break;
                case KeyEvent.VK_SPACE: myTank.fire();  break;
                default: break;
            }
            setMainTankDir();
        }

        @Override   // 键盘抬起处理
        public void keyReleased(KeyEvent e) {
            int key = e.getKeyCode();
            switch (key) {
                case KeyEvent.VK_LEFT:  bL = false; break;
                case KeyEvent.VK_UP:    bU = false; break;
                case KeyEvent.VK_RIGHT: bR = false; break;
                case KeyEvent.VK_DOWN:  bD = false; break;
                default: break;
            }
            setMainTankDir();
        }

        // 设置玩家坦克方向
        private void setMainTankDir() {
            if(!bL && !bU && !bR && !bD){
                myTank.setMoving(false);
            } else {
                myTank.setMoving(true);
                if(bL) myTank.setDir(Dir.LEFT);
                if(bU) myTank.setDir(Dir.UP);
                if(bR) myTank.setDir(Dir.Right);
                if(bD) myTank.setDir(Dir.DOWN);
            }
        }

    }

}
