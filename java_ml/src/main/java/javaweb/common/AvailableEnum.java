/**
 * Copyright (c) 2017 Qunar.com. All Rights Reserved.
 */
package javaweb.common;

/**
 * @author jintao.wang Date: 17-11-10 Time: 下午2:29
 */
public enum AvailableEnum {
    NOT_AVAILABLE("无效", 0), AVAILABLE("有效", 1);

    private String name;
    private int index;

    AvailableEnum(String name, int index) {
        this.name = name;
        this.index = index;
    }

    @Override
    public String toString() {
        return "AvailableEnum{" + "name='" + name + '\'' + ", index=" + index + '}';
    }
}
