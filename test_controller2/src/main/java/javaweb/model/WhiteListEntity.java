package javaweb.model;

import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@NoArgsConstructor
@Getter
@Setter
@Accessors(chain = true)
@ToString
public class WhiteListEntity extends BaseEntity {

    private Integer id;

    private String name;
    /**
     * n表示这个白名单包含的酒店数量
     */
    private Integer nCountOfHotels;

    public WhiteListEntity setCreateTime(Date createTime) {
        super.setCreateTime(createTime);
        return this;
    }

    public WhiteListEntity setCreateUser(String createUser) {
        super.setCreateUser(createUser);
        return this;
    }

    public WhiteListEntity setUpdateTime(Date updateTime) {
        super.setUpdateTime(updateTime);
        return this;
    }

    public WhiteListEntity setUpdateUser(String updateUser) {
        super.setUpdateUser(updateUser);
        return this;
    }
}

