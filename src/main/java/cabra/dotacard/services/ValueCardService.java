package cabra.dotacard.services;

import cabra.dotacard.entity.OneCardData;
import cabra.dotacard.entity.ValueCard;

import java.util.List;

public interface ValueCardService {
    
    
    
    /**
    * @description: 获得全部卡片
    * @author: cabra
    * @Param: 
    * @Returntype: 
     * @Date: 2018/11/12
    **/
     List<ValueCard> getCardList();


    List<ValueCard> search(String input, List<String> ctype, ValueCard valueCard, List<String> RARITY, List<String> item_type);


    OneCardData findbyimg(String cid);
}
