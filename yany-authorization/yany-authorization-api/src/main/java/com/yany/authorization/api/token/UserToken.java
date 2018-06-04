package com.yany.authorization.api.token;

import com.yany.authorization.api.exception.UnAuthorizedException;

import java.io.Serializable;

/**
 * Created by yanyong on 2018/5/13.
 */
public interface UserToken extends Serializable, Comparable<UserToken> {

    /**
     * @return 用户id
     * @see User#getId()
     */
    String getUserId();

    /**
     * @return token
     */
    String getToken();

    /**
     * @return 请求总次数
     */
    long getRequestTimes();

    /**
     * @return 最后一次请求时间
     */
    long getLastRequestTime();

    /**
     * @return 首次请求时间
     */
    long getSignInTime();

    /**
     * @return 令牌状态
     */
    TokenState getState();

    /**
     * @return 令牌类型, 默认:default
     */
    String getType();

    /**
     * @return 最大停止活动间隔
     */
    long getMaxInactiveInterval();

    /**
     * @return 是否正常
     */
    default boolean isEffective() {
        return getState() == TokenState.effective;
    }

    /**
     * @return 是否已过期
     */
    default boolean isExpired() {
        return getState() == TokenState.expired;
    }

    /**
     * @return 是否离线
     */
    default boolean isOffline() {
        return getState() == TokenState.offline;
    }

    default boolean validate() {
        if (!isEffective()) {
            throw new UnAuthorizedException(getState());
        }
        return true;
    }

    @Override
    default int compareTo(UserToken target) {
        return Long.valueOf(getSignInTime()).compareTo(target.getSignInTime());
    }
}
