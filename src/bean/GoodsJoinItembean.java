package bean;

/**
 * 订单详情用的Bean
 * Created by falling on 2016/6/9.
 */
public class GoodsJoinItembean implements Bean {
    private int id;
    private String name;
    private Double price;
    private String type;
    private Integer number;

    public GoodsJoinItembean(int id, String name, Double price, String type, Integer number) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.type = type;
        this.number = number;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
