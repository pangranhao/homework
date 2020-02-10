package cn.phr.entity.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("t_area")
public class Areas {
   /* SELECT
    t_area.areaid,
    t_area.areaname,
    t_area.type,
    t_area.pid
            FROM
    t_area*/
   @TableId(value = "areaid",type = IdType.AUTO)
   private Integer areaid;
   private String areaname;
   private Integer type;
   private Integer pid;

    public Integer getAreaid() {
        return areaid;
    }

    public void setAreaid(Integer areaid) {
        this.areaid = areaid;
    }

    public String getAreaname() {
        return areaname;
    }

    public void setAreaname(String areaname) {
        this.areaname = areaname;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }
}
