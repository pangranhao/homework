package cn.phr.entity.po;

import cn.phr.comm.Excel;
import cn.phr.comm.ExcleHeard;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@TableName("t_flight")
@ExcleHeard(title = "航班管理")
public class Flight {
   /* t_flight.id,
    t_flight.`name`,
    t_flight.typeid,
    t_flight.starttime,
    t_flight.enftime,
    t_flight.startterminalid,
    t_flight.endterminalid*/
   //航班ID
   @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
   //航班名称
   @Excel(name = "名字")
   private String name;
   //机型ID
   private String typeid;
   //起飞时间

   private String starttime;
   //到达时间

   private  String enftime;
    //出发机场航站楼id
   private String startterminalid;
   // 到大机场航站楼id
   private String endterminalid;
   //取消航班
    private Integer isup;

/*======================从表属性===================================*/
    //航班票数
   private Integer tptalcount;
   //价钱
   private String price;
    //机型名称
   private String typename;
   //地区名称
   private String areaname;

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
        this.name = name;
    }

    public String getTypeid() {
        return typeid;
    }

    public void setTypeid(String typeid) {
        this.typeid = typeid;
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public String getEnftime() {
        return enftime;
    }

    public void setEnftime(String enftime) {
        this.enftime = enftime;
    }

    public String getStartterminalid() {
        return startterminalid;
    }

    public void setStartterminalid(String startterminalid) {
        this.startterminalid = startterminalid;
    }

    public String getEndterminalid() {
        return endterminalid;
    }

    public void setEndterminalid(String endterminalid) {
        this.endterminalid = endterminalid;
    }

    public Integer getIsup() {
        return isup;
    }

    public void setIsup(Integer isup) {
        this.isup = isup;
    }

    public Integer getTptalcount() {
        return tptalcount;
    }

    public void setTptalcount(Integer tptalcount) {
        this.tptalcount = tptalcount;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    public String getAreaname() {
        return areaname;
    }

    public void setAreaname(String areaname) {
        this.areaname = areaname;
    }
}
