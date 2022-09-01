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
    public static int WIDTH = ResourceMgr.bulletD.getWidth();
    public static int Height = ResourceMgr.bulletD.getHeight();
    private boolean live = true;
    private int x, y;
    private Dir dir;
    TankFrame tf = null;

    // 构造子弹
    public Bullet(int x, int y, Dir dir, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
    }

    // 绘制子弹
    public void paint(Graphics g) {
        if(!live) {
            tf.bullets.remove(this);    // 删除超出窗口范围的子弹
        }

        switch(dir) {
            case LEFT:
                g.drawImage(ResourceMgr.bulletL, x, y,null);
                break;
            case UP:
                g.drawImage(ResourceMgr.bulletU, x, y,null);
                break;
            case Right:
                g.drawImage(ResourceMgr.bulletR, x, y,null);
                break;
            case DOWN:
                g.drawImage(ResourceMgr.bulletD, x, y,null);
                break;
        }

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

        if(x < 0 || y < 0 || x > TankFrame.GAME_WIDTH || y > TankFrame.GAME_HEIGHT) live = false;
    }

}
