package top.kafuucoori.tank;

import java.awt.*;

/**
 * @Author: KafuuCoori
 * @Date: 2022/8/24 - 08 - 24 - 9:22
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

    // 绘制子弹
    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.RED);
        g.fillOval(x, y, WIDTH, HEIGHT); // 绘制子弹(内切圆)
        move();
    }

    // 子弹移动
    private void move() {
        switch(dir) {
            case LEFT: x -= SPEED; break;
            case UP: y -= SPEED; break;
            case Right: x += SPEED; break;
            case DOWN: y += SPEED; break;
        }
    }

}
