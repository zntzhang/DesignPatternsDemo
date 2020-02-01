package Singleton;

/**
 * 枚举单例模式
 * 属于装载类单例模式
 *
 * 在调用时，先查询容器中是否有此对象的实例，有就取出直接返回，否则新建一个实例并且将其装载到容器中
 * 体现在Enum.valueOf((Class)cl, name);这个方法上
 */
public enum EnumSingleton {
    INSTANCE;

    /**
     * 用来扩展的对象
     */
    private Object object;

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    /**
     * 提供全局访问点
     *
     * @return 单例对象
     */
    public static EnumSingleton getInstance() {
        return INSTANCE;
    }
}
