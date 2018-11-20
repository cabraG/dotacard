package cabra.dotacard.dao;

import cabra.dotacard.entity.ValueCard;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.List;

public interface ValueCardMapper {

    int cdainit(@Param("valueCard")ValueCard valueCard);

    List<ValueCard> checkselect(@Param("valueCard")ValueCard valueCard);

    List<ValueCard> getCardList();

    List<ValueCard> search(@Param("input")String input,
                           @Param("ctype")List<String> ctype
            , @Param("color")ValueCard color
            , @Param("RARITY")List<String> RARITY);
    ValueCard findbycid(@Param("cid")String cid);
}
