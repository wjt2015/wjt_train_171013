/**
 * Copyright (c) 2017 Qunar.com. All Rights Reserved.
 */
package javaweb.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * @author jintao.wang  Date: 17-10-18 Time: 下午2:13
 */
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CookieInfo implements Serializable{

    private static final long serialVersionUID = -964330938981871643L;

    private List<String> domainList;
    private List<String> idList;
    private List<String> userinfoList;
}
    