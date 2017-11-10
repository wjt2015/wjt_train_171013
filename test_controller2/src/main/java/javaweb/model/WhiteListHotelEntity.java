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
public class WhiteListHotelEntity extends BaseEntity {
    private Integer id;

    private String hotelSeq;
    /**
     * whiteListId，该酒店所属的白名单的id
     */
    private Integer whiteListId;

    public WhiteListHotelEntity setCreateTime(Date createTime) {
        super.setCreateTime(createTime);
        return this;
    }

    public WhiteListHotelEntity setCreateUser(String createUser) {
        super.setCreateUser(createUser);
        return this;
    }

    public WhiteListHotelEntity setUpdateTime(Date updateTime) {
        super.setUpdateTime(updateTime);
        return this;
    }

    public WhiteListHotelEntity setUpdateUser(String updateUser) {
        super.setUpdateUser(updateUser);
        return this;
    }
}

