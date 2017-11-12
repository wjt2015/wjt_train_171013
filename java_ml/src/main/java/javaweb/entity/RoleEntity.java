package javaweb.entity;

import java.util.Date;
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
addComment.sh
addComment.sh~
arr.sh
date.sh
delete2.sh
delete2.sh~
delete3.sh
delete3.sh~
delete.sh
delete.sh~
grep_test2.sh
grep_test.sh
modify2.sh
modify.sh
output.txt
reg.txt
rename.sh
rename.sh~
sed.sh
sed.txt
substitute.sh
@author
jintao.wang
Date:
2017-11-10
Time:
下午
9:38
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
@Accessors(chain
=
true)
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
addComment.log
addComment.sh
addComment.sh~
arr.sh
date.sh
delete2.sh
delete2.sh~
delete3.sh
delete3.sh~
delete.sh
delete.sh~
grep_test2.sh
grep_test.sh
modify2.sh
modify.sh
output.txt
reg.txt
rename.sh
rename.sh~
sed.sh
sed.txt
substitute.sh
@author
jintao.wang
Date:
2017-11-10
Time:
下午
9:39
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
@Accessors(chain
=
true)
public class RoleEntity extends BaseEntity {
    private Integer id;

    private String name;

    private String detail;

    private Byte available;

    private Date createTime;

    private String createUser;

    private Date updateTime;

    private String updateUser;

    private Integer countofmember;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail == null ? null : detail.trim();
    }

    public Byte getAvailable() {
        return available;
    }

    public void setAvailable(Byte available) {
        this.available = available;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser == null ? null : updateUser.trim();
    }

    public Integer getCountofmember() {
        return countofmember;
    }

    public void setCountofmember(Integer countofmember) {
        this.countofmember = countofmember;
    }
}