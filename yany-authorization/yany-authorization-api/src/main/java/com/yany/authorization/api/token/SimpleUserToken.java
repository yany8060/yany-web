package com.yany.authorization.api.token;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 用户令牌信息
 * Created by yanyong on 2018/5/15.
 */
public class SimpleUserToken implements UserToken {
    private String userId;

    private String token;

    private String type = "default";

    private volatile TokenState state;

    private AtomicLong requestTimesCounter = new AtomicLong(0);

    private volatile long lastRequestTime = System.currentTimeMillis();

    private volatile long firstRequestTime = System.currentTimeMillis();

    private volatile long requestTimes;

    /**
     * 最大停止活动间隔
     */
    private long maxInactiveInterval;


    @Override
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }


    @Override
    public long getRequestTimes() {
        return requestTimesCounter.get();
    }

    @Override
    public long getLastRequestTime() {
        return lastRequestTime;
    }

    public void setLastRequestTime(long lastRequestTime) {
        this.lastRequestTime = lastRequestTime;
    }

    @Override
    public long getSignInTime() {
        return firstRequestTime;
    }

    public void setRequestTimes(long requestTimes) {
        this.requestTimes = requestTimes;
        requestTimesCounter.set(requestTimes);
    }

    @Override
    public TokenState getState() {
        return state;
    }

    public void setState(TokenState state) {
        this.state = state;
    }

    @Override
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public long getMaxInactiveInterval() {
        return maxInactiveInterval;
    }

    public void setMaxInactiveInterval(long maxInactiveInterval) {
        this.maxInactiveInterval = maxInactiveInterval;
    }


    public SimpleUserToken copy() {
        SimpleUserToken userToken = new SimpleUserToken();
        userToken.firstRequestTime = firstRequestTime;
        userToken.lastRequestTime = lastRequestTime;
        userToken.requestTimesCounter = new AtomicLong(requestTimesCounter.get());
        userToken.token = token;
        userToken.userId = userId;
        userToken.state = state;
        userToken.maxInactiveInterval = maxInactiveInterval;
        userToken.type = type;
        return userToken;
    }

    @Override
    public int hashCode() {
        return token.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return obj != null && hashCode() == obj.hashCode();
    }
}
