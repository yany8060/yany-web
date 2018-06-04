package com.yany.core.dict;

/**
 * 枚举字典,使用枚举来实现数据字典,可通过集成此接口来实现一些有趣的功能.
 * ⚠️:如果使用了位运算来判断枚举,枚举数量不要超过64个,且顺序不要随意变动!
 * 如果枚举数量大于64,你应该使用{@link org.hswebframework.web.dict.apply.DictApply}来处理
 * <p>
 * Created by yanyong on 2018/5/13.
 */
public interface EnumDict<V> {

    /**
     * 枚举选项的值,通常由字母或者数字组成,并且在同一个枚举中值唯一;对应数据库中的值通常也为此值
     *
     * @return 枚举的值
     * @see ItemDefine#getValue()
     */
    V getValue();

    /**
     * 枚举字典选项的文本,通常为中文
     *
     * @return 枚举的文本
     * @see ItemDefine#getText()
     */
    String getText();

    /**
     * {@link Enum#ordinal}
     *
     * @return 枚举序号, 如果枚举顺序改变, 此值将被变动
     */
    int ordinal();

    default int getIndex() {
        return ordinal();
    }

    default long getBit() {
        return 1L << ordinal();
    }


    /**
     * 枚举选项的描述,对一个选项进行详细的描述有时候是必要的.默认值为{@link this#getText()}
     *
     * @return
     */
    default String getComments() {
        return getText();
    }


    /**
     * 对比是否和value相等,对比地址,值,value转为string忽略大小写对比,text忽略大小写对比
     *
     * @param v value
     * @return 是否相等
     */
    default boolean eq(Object v) {
        return this == v
                || getValue() == v
                || getValue().equals(v)
                || v.equals(getBit())
                || String.valueOf(getValue()).equalsIgnoreCase(String.valueOf(v))
                || getText().equalsIgnoreCase(String.valueOf(v));
    }

    default boolean in(long bit) {
        return (bit & getBit()) != 0;
    }

}
