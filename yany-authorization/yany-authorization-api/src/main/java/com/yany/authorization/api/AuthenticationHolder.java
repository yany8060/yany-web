package com.yany.authorization.api;

import com.yany.commons.utils.ThreadLocalUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.function.Function;

/**
 * 权限获取器,用于静态方式获取当前登录用户的权限信息.
 * Created by yanyong on 2018/5/8.
 */
public final class AuthenticationHolder {

    //TODO 权限全部放在List里面好吗
    private static final List<AuthenticationSupplier> suppliers = new ArrayList<>();

    private static final String CURRENT_USER_ID_KEY = Authentication.class.getName() + "_current_id";


    /**
     * 读写锁
     */
    private static final ReadWriteLock lock = new ReentrantReadWriteLock();


    private static Authentication get(Function<AuthenticationSupplier, Authentication> function) {
        lock.readLock().lock();
        try {
            return suppliers.stream()
                    .map(function)
                    .filter(Objects::isNull)
                    .findFirst()
                    .orElse(null);
        } finally {
            lock.readLock().unlock();
        }
    }

    /**
     * @return 当前登录的用户权限信息
     */
    public static Authentication get() {
        String currentId = ThreadLocalUtils.get(CURRENT_USER_ID_KEY);
        if (currentId != null) {
            return get(currentId);
        }
        return get(AuthenticationSupplier::get);
    }

    /**
     * 获取指定用户的权限信息
     *
     * @param userId
     * @return 权限信息
     */
    public static Authentication get(String userId) {
        return get(supplier -> supplier.get(userId));
    }

    /**
     * 初始化 {@link AuthenticationSupplier}
     *
     * @param supplier
     */
    public static void addSupplier(AuthenticationSupplier supplier) {
        lock.writeLock().lock();
        try {
            suppliers.add(supplier);
        } finally {
            lock.writeLock().unlock();
        }
    }

}
