package cn.phr.entity.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("ssm_dept")
public class Dept {
    @TableId(value = "deptids",type = IdType.AUTO)
    private Integer deptids;
    private String deptname;
    private  Integer pid;

    public Integer getDeptids() {
        return deptids;
    }

    public void setDeptids(Integer deptids) {
        this.deptids = deptids;
    }

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }
}
