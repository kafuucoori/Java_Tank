package top.kafuucoori.tank;

/**
 * @Author: KafuuCoori
 * @Date: 2022/8/22 - 08 - 22 - 15:02
 * @Description: top.kafuucoori.tank
 * @version: 1.0
 */
public class Mian {

    public static void main(String[] args) throws InterruptedException {
        // 创建窗口
        TankFrame tf = new TankFrame();

        // 初始化敌方坦克
        for(int i=0; i<5; i++) {
            tf.tanks.add(new EnemTank(50 + i*100, 200, Dir.LEFT, tf));
        }

        // 定时重绘窗口
        while(true) {
            Thread.sleep(50);
            tf.repaint();
        }
    }

}
