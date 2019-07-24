package com.boot.security.server.utils;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import net.glxn.qrgen.core.image.ImageType;
import net.glxn.qrgen.javase.QRCode;

import javax.imageio.ImageIO;
import javax.swing.filechooser.FileSystemView;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Autror by zjw
 */
public class ORCodeUtil {

 public static void main(String[] args) {
     int a = 988;
     int b = 66;
     int c = 6;
  String s="1";
   String[] aa=s.split(",");
//System.out.print(aa.length);
for(String q:aa){

    System.out.println(q);
}


 }


    public static void imgUrl(String url, String fileName) {
        try {
            String replacePath = fileName.replace("/", "\\");
            System.out.println(url);
            System.out.println(fileName);
            String f = "D:\\Common\\ShangTuGuanLiXiTong\\target\\classes\\static\\UploadFiles\\ORCodeImgs\\svv453431.jpg";
            System.out.println("开始");
            System.out.println(f);
            ByteArrayOutputStream out = QRCode.from(url).to(ImageType.PNG).stream();
            byte[] data = out.toByteArray();
            OutputStream oute = new FileOutputStream(new File(f));
            oute.write(data);
            oute.flush();
            oute.close();
            System.out.println("收工");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public static String createQrCode(String url, String path,String fileName) {
        try {
            Map<EncodeHintType, String> hints = new HashMap<>();
            hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
            BitMatrix bitMatrix = new MultiFormatWriter().encode(url, BarcodeFormat.QR_CODE, 400, 400, hints);
            //String path1="D:\\Common\\ShangTuGuanLiXiTong\\target\\classes\\static\\UploadFiles\\ORCodeImgs";



            File file = new File(path, fileName);
            if (file.exists()|| ((file.getParentFile().exists() || file.getParentFile().mkdirs()) && file.createNewFile())) {
                System.out.println(bitMatrix);
                System.out.println(file);
                writeToFile(bitMatrix, "jpg", file);
                System.out.println("搞定：" + file);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    static void writeToFile(BitMatrix matrix, String format, File file) throws IOException {
        BufferedImage image = toBufferedImage(matrix);
        if (!ImageIO.write(image, format, file)) {
            throw new IOException("Could not write an image of format " + format + " to " + file);
        }
    }

    static void writeToStream(BitMatrix matrix, String format, OutputStream stream) throws IOException {
        BufferedImage image = toBufferedImage(matrix);
        if (!ImageIO.write(image, format, stream)) {
            throw new IOException("Could not write an image of format " + format);
        }
    }

    private static final int BLACK = 0xFF000000;
    private static final int WHITE = 0xFFFFFFFF;

    private static BufferedImage toBufferedImage(BitMatrix matrix) {
        int width = matrix.getWidth();
        int height = matrix.getHeight();
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {

                image.setRGB(x, y, matrix.get(x, y) ? BLACK : WHITE);
            }
        }
        return image;
    }

}
