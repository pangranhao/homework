package cn.phr.entity.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("t_ticket")
public class Ticket {
   /* SELECT
    t_ticket.id,
    t_ticket.flightid,
    t_ticket.type,
    t_ticket.tptalcount,
    t_ticket.price
            FROM
    t_ticket*/
@TableId(value = "id",type = IdType.AUTO)
   private Integer id;
   private Integer flightid;
   private String typenames;
   private Integer tptalcount;
   private String price;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFlightid() {
        return flightid;
    }

    public void setFlightid(Integer flightid) {
        this.flightid = flightid;
    }

    public String getTypenames() {
        return typenames;
    }

    public void setTypenames(String typenames) {
        this.typenames = typenames;
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
}
