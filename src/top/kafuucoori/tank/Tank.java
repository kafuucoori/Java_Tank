package top.kafuucoori.tank;

import java.awt.*;

/**
 * @Author: KafuuCoori
 * @Date: 2022/8/24 - 08 - 24 - 8:48
 * @Description: top.kafuucoori.tank
 * @version: 1.0
 */
public class Tank {

    private int x, y;
    private Dir dir = Dir.DOWN;
    private boolean moving = false;
    private static final int SPEED = 6;

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public Tank(int x, int y, Dir dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }

    // 绘制坦克
    public void paint(Graphics g) {
        g.fillRect(x, y, 50, 50);
        move();
    }

    // 坦克移动
    private void move() {
        if(!moving) return;
        switch(dir) {
            case LEFT: x -= SPEED; break;
            case UP: y -= SPEED; break;
            case Right: x += SPEED; break;
            case DOWN: y += SPEED; break;
        }
    }

}
