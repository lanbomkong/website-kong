package simple_factory;

/**
 * @description
 * @date 2020/1/5
 */
public class Triangle extends Polygon{

    @Override
    void draw() {
        System.out.println("画一个三角形");
    }

    @Override
    void erase() {
        System.out.println("将三角形擦除");
    }
}
