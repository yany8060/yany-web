package com.yany.core.id;


import com.yany.commons.utils.RandomUtil;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by yanyong on 2018/4/26.
 */
public interface IDGenerator<T> {
    T generate();

    IDGenerator<String> UUID = java.util.UUID.randomUUID()::toString;

    IDGenerator<String> RANDMOM = RandomUtil::randomChar;

    IDGenerator<String> MD5 = () -> {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(UUID.generate().concat(RandomUtil.randomChar()).getBytes());
            return new BigInteger(1, md.digest()).toString(16);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    };

}
