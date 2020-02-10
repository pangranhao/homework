package cn.phr.entity.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("t_type")
public class Types {

   /* SELECT
    t_type.typeids,
    t_type.typename,
    t_type.typec
            FROM
    t_type*/
   @TableId(value = "typeids",type = IdType.AUTO)
   private Integer typeids;
   private String typename;
   private String typec;

    public Integer getTypeids() {
        return typeids;
    }

    public void setTypeids(Integer typeids) {
        this.typeids = typeids;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    public String getTypec() {
        return typec;
    }

    public void setTypec(String typec) {
        this.typec = typec;
    }
}
