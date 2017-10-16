/**
 * Copyright (c) 2017 Qunar.com. All Rights Reserved.
 */
package javaweb.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author jintao.wang  Date: 17-10-16 Time: 下午8:39
 */
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class LoginUserModel {
    private Integer id;

    private String userName;

    private String password;

    private Long loginTime;

    private Byte role;

    private Byte isLogin;
}
    