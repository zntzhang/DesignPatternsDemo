package Singleton;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 容器式单例
 *
 * 容器式单例都属于注册式单例模式，其核心思想是：
 * 在使用时，先去容器中查找，如果找到了，就将查出来的对象返回
 * 否则，实例化，然后转载到容器中，最后将实例化的对象返回
 */
public class ContainerSingleton {
    /**
     * 单例容器
     * 存在线程安全问题，因此使用ConcurrentHashMap
     */
    private static final Map<String, Object> ioc = new ConcurrentHashMap<>();

    /**
     * 私有化构造函数
     */
    private ContainerSingleton() {
    }

    /**
     * 容器式单例模式
     *
     * @param key 获取单例的key
     * @return 单例对象
     */
    public static Object getBean(String key) {
        if (ioc.containsKey(key)) {//如果有就取出返回
            return ioc.get(key);
        }

        //如果没有，新建-装载-返回
        try {
            Object instance = Class.forName(key).newInstance();
            ioc.put(key, instance);
            return instance;
        } catch (Exception e) {
            e.printStackTrace();
        }
        //装载异常， 返回空
        return null;
    }
}
