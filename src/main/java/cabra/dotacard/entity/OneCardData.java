package cabra.dotacard.entity;

import java.util.List;

/**
 * @date:2018/11/17
 * @description
 **/
public class OneCardData {


    private ValueCard main_card;
    private String heroActiveName;
    private ValueCard heropasstive;
    private List<ValueCard> otherref;

    public ValueCard getMain_card() {
        return main_card;
    }

    public void setMain_card(ValueCard main_card) {
        this.main_card = main_card;
    }

    public String getHeroActiveName() {
        return heroActiveName;
    }

    public void setHeroActiveName(String heroActiveName) {
        this.heroActiveName = heroActiveName;
    }

    public ValueCard getHeropasstive() {
        return heropasstive;
    }

    public void setHeropasstive(ValueCard heropasstive) {
        this.heropasstive = heropasstive;
    }

    public List<ValueCard> getOtherref() {
        return otherref;
    }

    public void setOtherref(List<ValueCard> otherref) {
        this.otherref = otherref;
    }
}
