package top.kafuucoori.tank;

import java.awt.*;

/**
 * @Author: KafuuCoori
 * @Date: 2022/8/9 - 08 - 09 - 11:57
 * @Description: top.kafuucoori.tank
 * @version: 1.0
 */
public class Tank {
    // 定义坐标值
    private int x, y;
    // 定义坦克方向
    private Dir dir;
    // 设置坦克单次移动的距离，私有静态，不可变
    private static final int SPEED = 10;

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

    public void paint(Graphics g) {
        // 填充一个矩形
        g.fillRect(x, y, 50, 50);

        switch(dir) {
            case LEFT: x -= SPEED; break;
            case Right: x += SPEED; break;
            case UP: y -= SPEED; break;
            case DOWN: y += SPEED; break;
        }
    }

}
