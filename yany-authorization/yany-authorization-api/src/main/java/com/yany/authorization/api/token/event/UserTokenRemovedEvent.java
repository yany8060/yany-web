package com.yany.authorization.api.token.event;

import com.yany.authorization.api.token.UserToken;
import org.springframework.context.ApplicationEvent;

/**
 * Created by yanyong on 2018/5/15.
 */
public class UserTokenRemovedEvent extends ApplicationEvent {

    public UserTokenRemovedEvent(UserToken token) {
        super(token);
    }

    public UserToken getDetail() {
        return (UserToken) getSource();
    }
}
