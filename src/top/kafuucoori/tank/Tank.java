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
    private Dir dir;
    private boolean moving = false;
    private static final int SPEED = 6;
    private TankFrame tf = null;

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

    public Tank(int x, int y, Dir dir, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
    }

    // 绘制坦克
    public void paint(Graphics g) {
        switch(dir) {
            case LEFT:
                g.drawImage(ResourceMgr.tankL, x, y,null);
                break;
            case UP:
                g.drawImage(ResourceMgr.tankU, x, y,null);
                break;
            case Right:
                g.drawImage(ResourceMgr.tankR, x, y,null);
                break;
            case DOWN:
                g.drawImage(ResourceMgr.tankD, x, y,null);
                break;
        }
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

    // 坦克开火
    public void fire() {
        tf.bullets.add(new Bullet(this.x, this.y, this.dir, this.tf));
    }

}
