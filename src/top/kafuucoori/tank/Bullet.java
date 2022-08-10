package top.kafuucoori.tank;

import java.awt.*;

/**
 * @Author: KafuuCoori
 * @Date: 2022/8/10 - 08 - 10 - 17:52
 * @Description: top.kafuucoori.tank
 * @version: 1.0
 */
public class Bullet {
    private static final int SPEED = 12;
    private static int WIDTH = 10, HEIGHT = 10;
    private int x, y;
    private Dir dir;

    public Bullet(int x, int y, Dir dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }

    public void paint(Graphics g) {
        // 获取初始颜色
        Color c = g.getColor();
        // 设置画笔颜色
        g.setColor(Color.RED);
        // 填充一个内切圆形
        g.fillOval(x, y, WIDTH, HEIGHT);
        // 将画笔变回初始颜色
        g.setColor(c);
        // 子弹移动
        move();
    }

    private void move() {
        switch(dir) {
            case LEFT: x -= SPEED; break;
            case Right: x += SPEED; break;
            case UP: y -= SPEED; break;
            case DOWN: y += SPEED; break;
        }
    }

}
