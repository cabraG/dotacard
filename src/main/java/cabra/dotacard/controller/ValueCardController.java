package cabra.dotacard.controller;


import cabra.dotacard.entity.ValueCard;
import cabra.dotacard.services.ValueCardService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/card")
public class ValueCardController {

    @Resource(name = "valueCardServiceImpl")
    private ValueCardService  valueCardService;


    @CrossOrigin(origins="*")//允许跨域请求
    @GetMapping(value="/cards")
    /**
    * @description: 载入
    * @author: cabra
    * @Param: []
    * @Returntype: java.util.List<cabra.dotacard.entity.ValueCard>
     * @Date: 2018/11/15
    **/
    public List<ValueCard> cardlist(){
        return valueCardService.getCardList();
    }



    @CrossOrigin(origins="*")//允许跨域请求
    @PostMapping(value="/search")
    /**
    * @description:条件查询
    * @author: cabra
    * @Param: 
    * @Returntype: 
     * @Date: 2018/11/12
    **/
    public List<ValueCard> search(@RequestBody Map<String, Object> params){
        String input=(String) params.get("input");
        List<String>  ctype= (ArrayList) params.get("ctype");
        List<String>  color= (ArrayList) params.get("color");
        List<String>  RARITY= (ArrayList) params.get("RARITY");
        ValueCard valueCard=new ValueCard();
        for (String c:color){
            System.out.println(c);
            if(c.equals("b")){
                valueCard.setIs_black(true);
            }
            if(c.equals("r")){
                valueCard.setIs_red(true);

            }
            if(c.equals("g")){
                valueCard.setIs_green(true);
            }
            if(c.equals("u")){
                valueCard.setIs_blue(true);
            }
        }

        return valueCardService.search(input,ctype,valueCard,RARITY);
    }

    @CrossOrigin(origins="*")//允许跨域请求
    @GetMapping(value="/searchbycid")
    public List<ValueCard> findbyimg(String cid){

        return valueCardService.findbyimg(cid);

    }

}