package cabra.dotacard.entity;

import java.util.List;

/**
 * @date:2018/11/17
 * @description
 **/
public class OneCardData {


    private ValueCard main_card;

    public ValueCard getHeroactiveskill() {
        return heroactiveskill;
    }

    public void setHeroactiveskill(ValueCard heroactiveskill) {
        this.heroactiveskill = heroactiveskill;
    }

    private ValueCard heroactiveskill;
    private ValueCard heropasstive;
    private List<ValueCard> otherref;

    public ValueCard getMain_card() {
        return main_card;
    }

    public void setMain_card(ValueCard main_card) {
        this.main_card = main_card;
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
