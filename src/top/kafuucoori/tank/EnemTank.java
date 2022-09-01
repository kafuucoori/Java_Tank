package top.kafuucoori.tank;

import java.awt.*;

/**
 * @Author: KafuuCoori
 * @Date: 2022/8/24 - 08 - 24 - 8:48
 * @Description: top.kafuucoori.tank
 * @version: 1.0
 */
public class EnemTank {

    private int x, y;
    private Dir dir;
    private TankFrame tf = null;
    private boolean moving = false;
    private static final int SPEED = 6;
    public static int WIDTH = ResourceMgr.etankD.getWidth();
    public static int Height = ResourceMgr.etankD.getHeight();

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

    public EnemTank(int x, int y, Dir dir, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
    }

    // 绘制坦克
    public void paint(Graphics g) {
        switch(dir) {
            case LEFT:
                g.drawImage(ResourceMgr.etankL, x, y,null);
                break;
            case UP:
                g.drawImage(ResourceMgr.etankU, x, y,null);
                break;
            case Right:
                g.drawImage(ResourceMgr.etankR, x, y,null);
                break;
            case DOWN:
                g.drawImage(ResourceMgr.etankD, x, y,null);
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
        int bX = this.x + EnemTank.WIDTH/2 - Bullet.WIDTH/2;
        int bY = this.y + EnemTank.Height/2 - Bullet.Height/2;
        tf.bullets.add(new Bullet(bX, bY, this.dir, this.tf));
    }

}
