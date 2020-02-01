package Singleton;

/**
 * 饿汉式
 * 在类加载时直接实例化单例
 * 缺点，类加载时就创建实例，浪费空间
 */
public class HungryMan {
    /**
     * 类加载时创建初始化
     */
    private static final HungryMan INSTANCE = new HungryMan();

    /**
     * 私有化构造方法
     */
    private HungryMan(){}

    /**
     * 提供全局访问点
     * @return 单例对象
     */
    public static HungryMan getInstance() {
        return INSTANCE;
    }
}
