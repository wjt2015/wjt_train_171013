package javaweb.entity;
import javaweb.common.BaseEntity;
import
lombok.AllArgsConstructor;
import
lombok.Getter;
import
lombok.NoArgsConstructor;
import
lombok.Setter;
import
lombok.ToString;
import
lombok.experimental.Accessors;
/**
@author
jintao.wang
Date:
2017-11-13
Time:
下午
5:25
*/
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Accessors(chain
=
true)
public class AccountEntity extends BaseEntity {
    private Integer id;
    private String qtalk;
    private String name;
}
