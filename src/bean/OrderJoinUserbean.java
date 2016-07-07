package bean;

import java.util.Date;

/**
 * Created by falling on 16/7/7.
 */
public class OrderJoinUserbean implements Bean {
    private int id;
    private Integer userId;
    private String location;
    private Date time;
    private Double total;
    private Integer state;
    private String remark;
    private String username;
    private String tel;


    public OrderJoinUserbean(int id, Integer userId, String location, Date time, Double total, Integer state, String remark, String username, String tel) {
        this.id = id;
        this.userId = userId;
        this.location = location;
        this.time = time;
        this.total = total;
        this.state = state;
        this.remark = remark;
        this.username = username;
        this.tel = tel;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
