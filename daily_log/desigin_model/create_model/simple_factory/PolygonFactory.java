package simple_factory;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.text.DateFormat;

/**
 * @description
 * @date 2020/1/5
 */
public class PolygonFactory {

    public enum PolygonType {
        // 三角形
        TRIANGLE(1),

        // 正方形
        SQUARE(2),

        // 圆形
        ROUNDNESS(3),

        ;
        private int type;

        PolygonType(int type) {
            this.type = type;
        }

        public int getType() {
            return type;
        }
    }

    public static Polygon getPolygon(int polygonType) {
        Polygon polygon;
        if (PolygonType.TRIANGLE.getType() == polygonType) {
            polygon = new Triangle();
        } else if (PolygonType.SQUARE.getType() == polygonType) {
            polygon = new Square();
        } else if (PolygonType.ROUNDNESS.getType() == polygonType) {
            polygon = new Roundness();
        } else {
            throw new RuntimeException("no such Polygon");
        }
        return polygon;
    }

    public static void main(String[] args) throws Exception {
        PolygonFactory.getPolygon(1).draw();

        DateFormat.getDateInstance();

        KeyGenerator deSede = KeyGenerator.getInstance("DESede");
        SecretKey secretKey = deSede.generateKey();
        secretKey.getAlgorithm();

        Cipher cipher = Cipher.getInstance("DESede");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] bytes = cipher.doFinal("hello, design pattern".getBytes());
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            stringBuilder.append(bytes[i]);
        }
        System.out.println(stringBuilder.toString());

        Cipher cipher1 = Cipher.getInstance("DESede");
        cipher1.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] bytes1 = cipher1.doFinal(bytes);
        StringBuilder stringBuilder1 = new StringBuilder();
        for (int i = 0; i < bytes1.length; i++) {
            stringBuilder1.append(bytes1[i]);
        }

        System.out.println(stringBuilder1);

    }
}
