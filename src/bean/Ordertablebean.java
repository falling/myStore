package bean;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by falling on 2016/5/26.
 */
@Entity
@Table(name = "ordertable", schema = "store")
public class Ordertablebean implements Bean {
    private int id;
    private Integer userId;
    private String location;
    private Date time;
    private Double total;
    private String state;
    private String remark;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "userId", nullable = true)
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "location", nullable = false, length = 255)
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Basic
    @Column(name = "time", nullable = true)
    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Basic
    @Column(name = "total", nullable = true, precision = 0)
    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    @Basic
    @Column(name = "state", nullable = true, length = 255)
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Basic
    @Column(name = "remark", nullable = true, length = 255)
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ordertablebean that = (Ordertablebean) o;

        if (id != that.id) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (location != null ? !location.equals(that.location) : that.location != null) return false;
        if (time != null ? !time.equals(that.time) : that.time != null) return false;
        if (total != null ? !total.equals(that.total) : that.total != null) return false;
        if (state != null ? !state.equals(that.state) : that.state != null) return false;
        if (remark != null ? !remark.equals(that.remark) : that.remark != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (location != null ? location.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + (total != null ? total.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (remark != null ? remark.hashCode() : 0);
        return result;
    }
}
