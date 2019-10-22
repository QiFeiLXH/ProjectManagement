package spring.master.path.test;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @BelongsProject: ProjectManagement
 * @BelongsPackage: spring.master.path.test
 * @Author: QiFei
 * @CreateTime: 2019-10-14 10:07
 * @Description: 谷歌ZXing二维码生成
 */
public class ZXingQRcodeCreate {
    private static final int BLACK = 0xFF000000;
    //二维码颜色
    private static final int WHITE = 0xFFFFFFFF;

    @Test
    public void QRcodeCreate(){
        String content = "BEGIN:VCARD\n" +
                "VERSION:3.0\n" +
                "N:浪里小白龙\n" + //姓名
                "EMAIL:123456789@gmail.com\n" + //邮箱
                "TEL;CELL:+86 7894161\n" + //手机
                "TEL;WORK:85513\n" + //电话
                "TEL;WORK;FAX:12451\n"+ //传真
                "TEL;HOME;FAX:78451\n"+ //传真
                "ORG:创业慧康科技股份有限公司\n" + //公司
                "TITLE:开发\n" + // 岗位名称
                "ADR;WORK:罗布泊\n"+   //地址
                "URL:www.bsoft.com.cn\n" +
                "END:VCARD";
        zxingCodeCreate(content, 300, 300, "D:/qrcode.jpg", "jpg");

    }

    public static void zxingCodeCreate(String text, int width, int height, String outPutPath, String imageType){
        Map<EncodeHintType, String> his = new HashMap<EncodeHintType, String>();
        //设置编码字符集
        his.put(EncodeHintType.CHARACTER_SET, "utf-8");
        try {
            //1、生成二维码
            BitMatrix encode = new MultiFormatWriter().encode(text, BarcodeFormat.QR_CODE, width, height, his);

            //2、获取二维码宽高
            int codeWidth = encode.getWidth();
            int codeHeight = encode.getHeight();

            //3、将二维码放入缓冲流
            BufferedImage image = new BufferedImage(codeWidth, codeHeight, BufferedImage.TYPE_INT_RGB);
            for (int i = 0; i < codeWidth; i++) {
                for (int j = 0; j < codeHeight; j++) {
                    //4、循环将二维码内容定入图片
                    image.setRGB(i, j, encode.get(i, j) ? BLACK : WHITE);
                }
            }
            File outPutImage = new File(outPutPath);
            //如果图片不存在创建图片
            if(!outPutImage.exists())
                outPutImage.createNewFile();
            //5、将二维码写入图片
            ImageIO.write(image, imageType, outPutImage);
        } catch (WriterException e) {
            e.printStackTrace();
            System.out.println("二维码生成失败");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("生成二维码图片失败");
        }
    }
}
