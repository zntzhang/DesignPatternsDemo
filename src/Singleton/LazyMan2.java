package Singleton;

/**
 * 懒汉式 双重检查锁单例
 * 为了保证单例的线程安全，使用双重加锁的方式
 * 问题：加锁所造成的性能问题
 */
public class LazyMan2 {
    /**
     * 类加载时不初始化实例
     * <p>
     * volatile 可以防止指令重排序问题
     */
    private volatile static LazyMan2 INSTANCE;

    /**
     * 私有化构造方法
     */
    private LazyMan2() {
    }

    /**
     * 等到调用时初始化单例实例
     * 如果没有 synchronized关键字，容易出现线程安全问题，因此需要添加synchronized进行同步
     *
     * @return 单例对象
     */
    public static LazyMan2 getInstance() {
        // 1.如果INSTANCE不为null，则不需要获取锁，提高性能
        if (INSTANCE == null)
            synchronized (LazyMan2.class) {
                // 2.为了避免多线程解锁后重复创建对象
                if (INSTANCE == null)
                    /*
                     * CPU执行时会转换成JVM指令执行
                     *
                     * 1.分配内存给这个对象
                     * 2.初始化对象
                     * 3.将初始化后的对象和内存地址建立关联，赋值
                     * 第二步和第三步可能调换顺序（赋值在创建对象之前），线程B在线程A赋值完时判断instance就不为null了，此时B拿到的将是一个没有初始化完成的半成品。
                     * 所以会在单例对象添加volatile修饰
                     */
                    INSTANCE = new LazyMan2();
            }
        return INSTANCE;
    }
}
