import org.springframework.util.StringUtils;

/**
 * @description 类和对象
 * @date 2019/8/1
 */
public class ClassAndObject {

    /**
     *  类和对象的概念
     *
     *   1、对象是类的一个实例，通过构造函数创建
     */

    private ClassAndObject() {}

    // 静态内部类+饿汉模式 、安全，但是初始化的时候会直接创建对象，导致资源浪费
    static class InnerClassHungry {
        // 单例模式， 私有化构造函数，私有化实例对象，
        // 只能本类调用，向外暴露一个获取对象的方法
        private InnerClassHungry(){}
        private static final InnerClassHungry instanceHungry = new InnerClassHungry();
        public static InnerClassHungry getInnerClass() {
            return instanceHungry;
        }
    }

    // 静态内部类+懒汉模式、不安全
    static class InnerClassLazy{
        private InnerClassLazy() {}
        private static InnerClassLazy instanceLazy;
        public InnerClassLazy getInstanceLazy() {
            if (StringUtils.isEmpty(instanceLazy)) {
                instanceLazy = new InnerClassLazy();
            }
            return instanceLazy;
        }
    }

    // 双重锁
    static class InnerClassDoubleLock {
        private InnerClassDoubleLock(){}
        private volatile static InnerClassDoubleLock innerClassDoubleLock;
        public InnerClassDoubleLock getInnerClassDoubleLock() {
            if (StringUtils.isEmpty(innerClassDoubleLock)) {
                synchronized (this) {
                    if (StringUtils.isEmpty(innerClassDoubleLock)) {
                        innerClassDoubleLock = new InnerClassDoubleLock();
                    }
                }
            }
            return innerClassDoubleLock;
        }
    }

    private static class StaticInnerClass{
        private final static ClassAndObject classAndObject = new ClassAndObject();
    }

    public static ClassAndObject getInstance () {
        return StaticInnerClass.classAndObject;
    }

    
}
