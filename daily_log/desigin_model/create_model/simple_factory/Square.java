package simple_factory;

/**
 * @description
 * @date 2020/1/5
 */
public class Square extends Polygon{

    @Override
    void draw() {
        System.out.println("画一个正方形");
    }

    @Override
    void erase() {
        System.out.println("将正方形擦除");
    }
}
