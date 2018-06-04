package com.yany.authorization.api.token;

import java.util.List;
import java.util.function.Consumer;

/**
 * Created by yanyong on 2018/5/15.
 */
public interface UserTokenManager {
    /**
     * 根据token获取用户令牌信息
     *
     * @param token token
     * @return 令牌信息, 未授权时返回null
     */
    UserToken getByToken(String token);

    /**
     * 根据用户id，获取全部令牌信息，如果没有则返回空集合而不是<code>null</code>
     *
     * @param userId 用户id
     * @return 授权信息
     */
    List<UserToken> getByUserId(String userId);

    /**
     * @param userId 用户ID
     * @return 用户是否已经授权
     */
    boolean userIsLoggedIn(String userId);

    /**
     * @param token token
     * @return token是否已登记
     */
    boolean tokenIsLoggedIn(String token);

    /**
     * @return 总用户数量，一个用户多个地方登陆数量算1
     */
    long totalUser();

    /**
     * @return 总token数量
     */
    long totalToken();

    /**
     * @return 所有token
     */
    List<UserToken> allLoggedUser();

    /**
     * 遍历全部token信息
     *
     * @param consumer token消费者
     */
    void allLoggedUser(Consumer<UserToken> consumer);

    /**
     * 删除用户授权信息
     *
     * @param userId 用户ID
     */
    void signOutByUserId(String userId);

    /**
     * 根据token删除
     *
     * @param token 令牌
     */
    void signOutByToken(String token);

    /**
     * 修改userId的状态
     *
     * @param userId userId
     * @param state  状态
     * @see this#changeTokenState
     */
    void changeUserState(String userId, TokenState state);

    /**
     * 修改token的状态
     *
     * @param token token
     * @param state 状态
     */
    void changeTokenState(String token, TokenState state);

    /**
     * 登记一个用户的token
     *
     * @param token               token
     * @param type                令牌类型
     * @param userId              用户id
     * @param maxInactiveInterval 最大不活动时间,超过后令牌状态{@link UserToken#getState()}将变为过期{@link TokenState#expired}
     */
    UserToken signIn(String token, String type, String userId, long maxInactiveInterval);

    /**
     * 更新token,使其不过期
     *
     * @param token token
     */
    void touch(String token);

    /**
     * 检查已过期的token,并将其remove
     *
     * @see this#signOutByToken(String)
     */
    void checkExpiredToken();
}
