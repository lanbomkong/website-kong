package simple_factory;

/**
 * @description
 * @date 2020/1/5
 */
public class Roundness extends Polygon{
    @Override
    void draw() {
        System.out.println("画一个圆形");
    }

    @Override
    void erase() {
        System.out.println("将圆形擦除");
    }
}
