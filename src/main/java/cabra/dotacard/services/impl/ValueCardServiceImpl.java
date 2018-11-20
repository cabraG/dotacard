package cabra.dotacard.services.impl;

import cabra.dotacard.dao.ReferencesMapper;
import cabra.dotacard.dao.ValueCardMapper;
import cabra.dotacard.entity.OneCardData;
import cabra.dotacard.entity.References;
import cabra.dotacard.entity.ValueCard;
import cabra.dotacard.services.ValueCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service(value = "valueCardServiceImpl")
public class ValueCardServiceImpl implements ValueCardService {


    @Autowired
    ValueCardMapper valueCardMapper;

    @Autowired
    ReferencesMapper referencesMapper;


    @Override
    public List<ValueCard> getCardList() {
        return valueCardMapper.getCardList();
    }

    @Override
    public List<ValueCard> search(String input, List<String> ctype, ValueCard valueCard, List<String> RARITY) {
        return valueCardMapper.search(input,ctype,valueCard,RARITY);
    }

    @Override
    public List<ValueCard> findbyimg(String cid) {
        List<ValueCard> valueCardList=new ArrayList<>();
        valueCardList.add(valueCardMapper.findbycid(cid));
        if(referencesMapper.Searchbycid(cid)!=null || referencesMapper.Searchbycid(cid).size()!=0 ) {
            for (References ref : referencesMapper.Searchbycid(cid)) {
                valueCardList.add(valueCardMapper.findbycid(String.valueOf(ref.getRefertences_id())));
                if(valueCardMapper.findbycid(String.valueOf(ref.getRefertences_id())).getCard_type().equals("Ability")
                        ||valueCardMapper.findbycid(String.valueOf(ref.getRefertences_id())).getCard_type().equals("Passive Ability")){
                  List<References> innerreflist=
                          referencesMapper.Searchbycid(String.valueOf(
                                  valueCardMapper.findbycid(String.valueOf(
                                                  ref.getRefertences_id())).
                                  getCard_id()));
                    if(innerreflist!=null && innerreflist.size()!=0){
                        for(References innerref:innerreflist){
                            valueCardList.add(valueCardMapper.findbycid(String.valueOf(innerref.getRefertences_id())));

                        }
                    }
                }

                //通过获得的关系id,排除技能和被动技能后再逐条查出卡片加入list，既list的第一个元素为详细卡片显示，其他为其关系卡片。技能以及被动技能将

            }
        }


        for  ( int  i  =   0 ; i  <  valueCardList.size()  -   1 ; i ++ )  {
            for  ( int  j  =  valueCardList.size()  -   1 ; j  >  i; j -- )  {
                if  (valueCardList.get(j).getCard_id()==(valueCardList.get(i).getCard_id()))  {
                    valueCardList.remove(j);
                }
            }
        }
        //去重

        OneCardData oneCardData=new OneCardData();
        oneCardData.setMain_card(valueCardList.get(0));
        List<ValueCard> valueCardli_reset=new ArrayList<>();
        for(int i=1;i<valueCardList.size();i++){
            if(valueCardList.get(i).getCard_type().equals("Ability")){
                oneCardData.setHeroActiveName(valueCardList.get(i).getCard_name().getEnglish());
            }
            if(valueCardList.get(i).getCard_type().equals("Passive Ability")){

            }
            valueCardli_reset.add(valueCardList.get(i));
        }
       //封裝
        oneCardData.setOtherref(valueCardli_reset);
        return valueCardList;
    }
}
