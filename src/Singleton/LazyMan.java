package Singleton;

/**
 * 懒汉式 未加锁 存在线程安全问题
 * 在调用时才实例化单例
 */
public class LazyMan {
    /**
     * 类加载时不初始化实例
     */
    private static LazyMan INSTANCE;

    /**
     * 私有化构造方法
     */
    private LazyMan() {
    }

    public static synchronized LazyMan getInstance() {
        //这里需要办法保证只有一个实例
        if (INSTANCE == null)
            INSTANCE = new LazyMan();
        return INSTANCE;
    }
}
