package javaweb.entity;

import javaweb.common.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * @author jintao.wang Date: 2017-11-13 Time: 下午 2:31
 */
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Accessors(chain = true)
public class RoleAuthorityEntity extends BaseEntity {
    private Integer id;
    private Integer roleId;
    private Integer authorityId;
}
