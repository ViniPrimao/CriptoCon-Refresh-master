package levandowski.primao.criptocon.model;

public class Coin {
    private String name;
    private Double price_brl;
    private Double percent_change_24h;
    private Double percent_change_1h;

    public Coin() {
    }

    public Coin(String name, Double price_brl, Double percent_change_24h, Double percent_change_1h) {
        this.name = name;
        this.price_brl = price_brl;
        this.percent_change_24h = percent_change_24h;
        this.percent_change_1h = percent_change_1h;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice_brl() {
        return price_brl;
    }

    public void setPrice_brl(Double price_brl) {
        this.price_brl = price_brl;
    }

    public Double getPercent_change_24h() {
        return percent_change_24h;
    }

    public void setPercent_change_24h(Double percent_change_24h) {
        this.percent_change_24h = percent_change_24h;
    }

    public Double getPercent_change_1h() {
        return percent_change_1h;
    }

    public void setPercent_change_1h(Double percent_change_1h) {
        this.percent_change_1h = percent_change_1h;
    }

}