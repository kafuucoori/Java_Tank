package top.kafuucoori.tank;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @Author: KafuuCoori
 * @Date: 2022/8/29 - 08 - 29 - 17:21
 * @Description: top.kafuucoori.tank
 * @version: 1.0
 */
public class ResourceMgr {

    // 定义图片
    public static BufferedImage tankL, tankU, tankR, tankD;
    public static BufferedImage etankL, etankU, etankR, etankD;
    public static BufferedImage bulletL, bulletU, bulletR, bulletD;

    // 加载图片
    static {
        try {
            tankL = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("./imgs/MainTank1_L.png"));
            tankU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("./imgs/MainTank1_U.png"));
            tankR = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("./imgs/MainTank1_R.png"));
            tankD = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("./imgs/MainTank1_D.png"));

            etankL = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("./imgs/EnemTank1_L.png"));
            etankU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("./imgs/EnemTank1_U.png"));
            etankR = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("./imgs/EnemTank1_R.png"));
            etankD = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("./imgs/EnemTank1_D.png"));

            bulletL = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("./imgs/MainBullet_L.png"));
            bulletU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("./imgs/MainBullet_U.png"));
            bulletR = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("./imgs/MainBullet_R.png"));
            bulletD = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("./imgs/MainBullet_D.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
