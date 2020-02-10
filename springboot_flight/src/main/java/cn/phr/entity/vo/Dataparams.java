package cn.phr.entity.vo;

public class Dataparams {
    private Integer draw;
    private Integer length;
    private Integer start;
    private String name;
    private String startdate;
    private String typeid;
    private String startterminalid;

    public String getStartterminalid() {
        return startterminalid;
    }

    public void setStartterminalid(String startterminalid) {
        this.startterminalid = startterminalid;
    }

    public String getTypeid() {
        return typeid;
    }

    public void setTypeid(String typeid) {
        this.typeid = typeid;
    }

    public String getStartdate() {
        return startdate;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDraw() {
        return draw;
    }

    public void setDraw(Integer draw) {
        this.draw = draw;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }
}
