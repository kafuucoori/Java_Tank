package top.kafuucoori.tank;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @Author: KafuuCoori
 * @Date: 2022/8/3 - 08 - 03 - 10:31
 * @Description: top.kafuucoori.tank
 * @version: 1.0
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {
        // 创建一个新窗口
        TankFrame tf = new TankFrame();

        // 每50ms重绘一次窗口
        while(true) {
            Thread.sleep(50);
            tf.repaint();
        }
    }
}
