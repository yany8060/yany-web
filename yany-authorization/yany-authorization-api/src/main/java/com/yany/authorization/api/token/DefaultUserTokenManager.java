package com.yany.authorization.api.token;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.function.Consumer;

/**
 * Created by yanyong on 2018/5/15.
 */
public class DefaultUserTokenManager implements UserTokenManager {

    protected final ConcurrentMap<String, SimpleUserToken> tokenStorage;

    protected final ConcurrentMap<String, Set<String>> userStorage;


    public DefaultUserTokenManager(ConcurrentMap<String, SimpleUserToken> tokenStorage, ConcurrentMap<String, Set<String>> userStorage) {
        this.tokenStorage = tokenStorage;
        this.userStorage = userStorage;
    }

    public DefaultUserTokenManager(ConcurrentMap<String, SimpleUserToken> tokenStorage) {
        this(tokenStorage, new ConcurrentHashMap<>());
    }

    public DefaultUserTokenManager() {
        this(new ConcurrentHashMap<>(256));
    }

    /**
     * 根据用户id获取token集合
     *
     * @param userId
     * @return
     */
    protected Set<String> getUserToken(String userId) {
        // 如果userId对应的value存在则返回,否则返回new HashSet<>()
        return userStorage.computeIfAbsent(userId, key -> new HashSet<>());
    }

    private SimpleUserToken checkTimeout(SimpleUserToken detail) {
        if (null == detail) {
            return null;
        }

        if (detail.getMaxInactiveInterval() <= 0) {
            // Token 没有过期限制
            return detail;
        }
        if (System.currentTimeMillis() - detail.getLastRequestTime() > detail.getMaxInactiveInterval()) {
            // Token 过期
            changeTokenState(detail, TokenState.expired);
            return detail;
        }
        return detail;
    }

    @Override
    public UserToken getByToken(String token) {
        return null;
    }

    @Override
    public List<UserToken> getByUserId(String userId) {
        return null;
    }

    @Override
    public boolean userIsLoggedIn(String userId) {
        return false;
    }

    @Override
    public boolean tokenIsLoggedIn(String token) {
        return false;
    }

    @Override
    public long totalUser() {
        return 0;
    }

    @Override
    public long totalToken() {
        return 0;
    }

    @Override
    public List<UserToken> allLoggedUser() {
        return null;
    }

    @Override
    public void allLoggedUser(Consumer<UserToken> consumer) {

    }

    @Override
    public void signOutByUserId(String userId) {

    }

    @Override
    public void signOutByToken(String token) {

    }

    @Override
    public void changeUserState(String userId, TokenState state) {

    }


    public void changeTokenState(SimpleUserToken userToken, TokenState state) {
        if (null != userToken) {
            SimpleUserToken copy = userToken.copy();

            userToken.setState(state);
//            syncToken(userToken);

//            publishEvent(new UserTokenChangedEvent(copy, userToken));
        }
    }

    @Override
    public void changeTokenState(String token, TokenState state) {

    }

    @Override
    public UserToken signIn(String token, String type, String userId, long maxInactiveInterval) {
        return null;
    }

    @Override
    public void touch(String token) {

    }

    @Override
    public void checkExpiredToken() {

    }
}
