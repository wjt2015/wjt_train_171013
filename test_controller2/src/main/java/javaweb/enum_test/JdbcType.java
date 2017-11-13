/**
 * Copyright (c) 2017 Qunar.com. All Rights Reserved.
 */
package javaweb.enum_test;

import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

/**
 * @author jintao.wang Date: 17-10-24 Time: 下午5:51
 */
public enum JdbcType {
    /*
     * This is added to enable basic support for the ARRAY data type - but a custom type handler is still required
     */
    ARRAY(Types.ARRAY), BIT(Types.BIT), TINYINT(Types.TINYINT), SMALLINT(Types.SMALLINT), INTEGER(
            Types.INTEGER), BIGINT(Types.BIGINT), FLOAT(Types.FLOAT), REAL(Types.REAL), DOUBLE(Types.DOUBLE), NUMERIC(
                    Types.NUMERIC), DECIMAL(Types.DECIMAL), CHAR(Types.CHAR), VARCHAR(Types.VARCHAR), LONGVARCHAR(
                            Types.LONGVARCHAR), DATE(Types.DATE), TIME(Types.TIME), TIMESTAMP(Types.TIMESTAMP), BINARY(
                                    Types.BINARY), VARBINARY(Types.VARBINARY), LONGVARBINARY(Types.LONGVARBINARY), NULL(
                                            Types.NULL), OTHER(Types.OTHER), BLOB(
                                                    Types.BLOB), CLOB(Types.CLOB), BOOLEAN(Types.BOOLEAN), CURSOR(-10), // Oracle
    UNDEFINED(Integer.MIN_VALUE + 1000), NVARCHAR(Types.NVARCHAR), // JDK6
    NCHAR(Types.NCHAR), // JDK6
    NCLOB(Types.NCLOB), // JDK6
    STRUCT(Types.STRUCT);

    private static Map<Integer, JdbcType> codeLookup = new HashMap<Integer, JdbcType>();

    static {
        for (JdbcType type : JdbcType.values()) {
            System.out.println("TYPE_CODE=" + type.TYPE_CODE + ";type=" + type);
            codeLookup.put(type.TYPE_CODE, type);
        }
    }

    public final int TYPE_CODE;

    JdbcType(int code) {

        this.TYPE_CODE = code;
        System.out.println("TYPE_CODE=" + this.TYPE_CODE);
    }

    public static JdbcType forCode(int code) {
        System.out.println("\tcodeLookup=" + codeLookup);
        System.out.println("finish!!");
        return codeLookup.get(code);
        org.apache.ibatis.type.JdbcType jdbcType2;
    }
}
