package com.yany.commons.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yanyong on 2018/5/8.
 */
public final class ThreadLocalUtils {

    //    private static final ThreadLocal<Map<String, Object>> local = new ThreadLocal<>();
    private static final ThreadLocal<Map<String, Object>> local = ThreadLocal.withInitial(HashMap::new);


    /**
     * @return threadLocal中的全部值
     */
    public static Map<String, Object> getAll() {
        return local.get();
    }

    public static <T> T get(String key) {
        return (T) local.get().get(key);
    }


}
