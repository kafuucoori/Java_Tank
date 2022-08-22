package top.kafuucoori.tank;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @Author: KafuuCoori
 * @Date: 2022/8/22 - 08 - 22 - 15:02
 * @Description: top.kafuucoori.tank
 * @version: 1.0
 */
public class Mian {

    public static void main(String[] args) throws InterruptedException {
        TankFrame tf = new TankFrame(); // 创建窗口

        while(true) {
            Thread.sleep(50);
            tf.repaint();
        }

    }

}
