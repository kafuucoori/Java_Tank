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
    private boolean live = true;
    private int x, y;
    private Dir dir;
    TankFrame tf = null;

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
                g.drawImage(ResourceMgr.bulletL, x+20, y+20,null);
                break;
            case UP:
                g.drawImage(ResourceMgr.bulletU, x+20, y+20,null);
                break;
            case Right:
                g.drawImage(ResourceMgr.bulletR, x+20, y+20,null);
                break;
            case DOWN:
                g.drawImage(ResourceMgr.bulletD, x+20, y+20,null);
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
