package cn.phr.entity.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("ssm_job")
public class Job {
    @TableId(value = "jobids",type = IdType.AUTO)
    private Integer jobids;
    private String jobname;

    public Integer getJobids() {
        return jobids;
    }

    public void setJobids(Integer jobids) {
        this.jobids = jobids;
    }

    public String getJobname() {
        return jobname;
    }

    public void setJobname(String jobname) {
        this.jobname = jobname;
    }
}
