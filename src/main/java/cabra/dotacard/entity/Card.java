package cabra.dotacard.entity;

import java.io.Serializable;

public class Card implements Serializable {
    private Integer cardid;

    private String enname;

    private String zhname;

    private String color;

    private Integer cost;

    private String bc;

    private String ec;

    private String zhdescribe;

    private String endescribe;

    private Integer rare;

    private static final long serialVersionUID = 1L;

    public Integer getCardid() {
        return cardid;
    }

    public void setCardid(Integer cardid) {
        this.cardid = cardid;
    }

    public String getEnname() {
        return enname;
    }

    public void setEnname(String enname) {
        this.enname = enname == null ? null : enname.trim();
    }

    public String getZhname() {
        return zhname;
    }

    public void setZhname(String zhname) {
        this.zhname = zhname == null ? null : zhname.trim();
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color == null ? null : color.trim();
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public String getBc() {
        return bc;
    }

    public void setBc(String bc) {
        this.bc = bc == null ? null : bc.trim();
    }

    public String getEc() {
        return ec;
    }

    public void setEc(String ec) {
        this.ec = ec == null ? null : ec.trim();
    }

    public String getZhdescribe() {
        return zhdescribe;
    }

    public void setZhdescribe(String zhdescribe) {
        this.zhdescribe = zhdescribe == null ? null : zhdescribe.trim();
    }

    public String getEndescribe() {
        return endescribe;
    }

    public void setEndescribe(String endescribe) {
        this.endescribe = endescribe == null ? null : endescribe.trim();
    }

    public Integer getRare() {
        return rare;
    }

    public void setRare(Integer rare) {
        this.rare = rare;
    }
}