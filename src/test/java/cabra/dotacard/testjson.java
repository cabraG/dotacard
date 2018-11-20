package cabra.dotacard;

import cabra.dotacard.entity.References;
import cabra.dotacard.entity.ValueCard;
import com.alibaba.fastjson.JSONReader;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

@RunWith(SpringRunner.class)
@SpringBootTest
public class testjson {
    private static final String FILE_PATH = "C:\\Users\\Administrator\\Desktop\\png\\test.txt";

@Test
    public void ReadWithFastJson() throws FileNotFoundException {


        JSONReader jsonReader = new JSONReader(new FileReader(new File(FILE_PATH)));

  /*      jsonReader.startObject();
        while (jsonReader.hasNext()) {
            String key = jsonReader.readString();
            if (key.equals("card_name"))//"key"对应的Object只有一个
            {
                Object obj = jsonReader.readObject();//
                String val = obj.toString();
                System.out.println("obj: " + obj + ", value: " + val);
            } else if (key.equals("card_name")) {//"anotherKey"对应的是一个List对象*/
        jsonReader.startArray();//---> [  开启读List对象
        while (jsonReader.hasNext()) {
            ValueCard objBean = jsonReader.readObject(ValueCard.class);
            String english = objBean.getCard_name().getEnglish();
            for(References ref:objBean.getReferences()){
                ref.setRefertences_id(objBean.getCard_id());
                System.out.println("Refca_id: " + ref.getCard_id());
            }
            for(References ref1:objBean.getReferences()){
                System.out.println("ca_id: " + ref1.getRefertences_id());
            }
            System.out.println("tostring: " + objBean.toString());
        }
        jsonReader.endArray();//---> ]
        jsonReader.close();
    }
         /*   jsonReader.endArray();//---> ]
            jsonReader.close();*/
}

/*}
}*/




