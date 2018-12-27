package cabra.dotacard;

import cabra.dotacard.dao.ReferencesMapper;
import cabra.dotacard.dao.ValueCardMapper;
import cabra.dotacard.entity.*;
import ch.qos.logback.core.util.FileUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONReader;
import org.apache.tomcat.util.ExceptionUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sun.net.www.content.image.png;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DotacardApplicationTests {

    @Autowired
    private ValueCardMapper valueCardMapper;

    @Autowired
    private ReferencesMapper ReferencesMapper;

    private static final String FILE_PATH = "E:\\save\\projectsource\\dotacard\\card_set_0.0.json";//new_json.json,test1.txt,all_json,base_json

    @Test
    public void contextLoads() {
    }

    @Test
    public void vdaotest(){
        ValueCard valueCard=new ValueCard();
        valueCard.setIs_red(true);
        int cout=0;
        for(ValueCard vc:valueCardMapper.getCardList()){
            System.out.println("tostring: " + vc.getLarge_image().getSchinese()+"count: "+(cout++));
        }
    }
@Test
public void rdaotest(){
       for( References references:ReferencesMapper.Searchbycid("10001")){
           System.out.println(references.getRefertences_id());

       }

}
    public static Object setProperty(Object beanObj, String property, Object value) throws IntrospectionException, IllegalArgumentException, IllegalAccessException, InvocationTargetException {
        //此处应该判断beanObj,property不为null
        PropertyDescriptor pd = new PropertyDescriptor(property, beanObj.getClass());
        Method setMethod = pd.getWriteMethod();
        if(setMethod == null){

        }
        return setMethod.invoke(beanObj, value);
    }

    public Object getValue(Object dto,String name) throws Exception {
        Method[] m = dto.getClass().getMethods();
        for (int i = 0; i < m.length; i++) {
            if (("get" + name).toLowerCase().equals(m[i].getName().toLowerCase())) {
                return m[i].invoke(dto);
            }
        }
        return null;
    }

    @Test
    public void reflecttest() throws Exception {
        References references=new References();
        ValueCard valueCard=new ValueCard();
        Card_name card_name=new Card_name();
        valueCard.setCard_name(new Card_name());
        valueCard.getCard_name().setSchinese("123");

        System.out.println(valueCard.getCard_name().getSchinese());
        try {
            setProperty(references,"card_id",101);
        }catch (Exception e){
            System.out.println(e);
        }
        int i;

        System.out.println(getValue(references,"card_id") instanceof Integer);
        String te="123";

        System.out.println(references.getCard_id());
    }

    public static String ReadFile(String Path){
        BufferedReader reader = null;
        String laststr = "";
        try{
            FileInputStream fileInputStream = new FileInputStream(Path);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
            reader = new BufferedReader(inputStreamReader);
            String tempString = null;
            while((tempString = reader.readLine()) != null){
                laststr += tempString;
            }
            reader.close();
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            if(reader != null){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return laststr;
    }

    /**
     * 从输入流中获取字节数组
     * @param inputStream
     * @return
     * @throws IOException
     */

    public static  byte[] readInputStream(InputStream inputStream) throws IOException {
        byte[] buffer = new byte[1024];
        int len = 0;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        while((len = inputStream.read(buffer)) != -1) {
            bos.write(buffer, 0, len);
        }
        bos.close();
        return bos.toByteArray();
    }

     /**
     * 从网络Url中下载文件
     * @param urlStr
     * @param fileName
     * @param savePath
     * @throws IOException
     */
    public static void  downLoadFromUrl(String urlStr,String fileName,String savePath) throws IOException{
        URL url = new URL(urlStr);
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        //设置超时间为3秒
        conn.setConnectTimeout(3*1000);
        //防止屏蔽程序抓取而返回403错误
        conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");

        //得到输入流
        InputStream inputStream = conn.getInputStream();
        //获取自己数组
        byte[] getData = readInputStream(inputStream);

        //文件保存位置
        File saveDir = new File(savePath);
        if(!saveDir.exists()){
            saveDir.mkdir();
        }
        File file = new File(saveDir+File.separator+fileName);
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(getData);
        if(fos!=null){
            fos.close();
        }
        if(inputStream!=null){
            inputStream.close();
        }


        System.out.println("info:"+url+" download success");

    }





    public static String getMatcher(String regex, String source) {
        String result = "";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(source);
        while (matcher.find()) {
            result = matcher.group(0);
        }
        return result;
    }



    @Test
    public void urldowldtest() {
      String[] urlarry=  valueCardMapper.getimageurl();
        for(String url:urlarry){
    String str = url;
    String pattern = "(\\w+_){2}\\w+";
    String newpattren="(?<=set0./)\\d+";
    String result =getMatcher(newpattren,str)+".jpg";
        try{
            byte[] by1 = FileDownConnManager.fileDown(url);

            File saveDir = new File("E:\\1webfront\\dotacard\\src\\images\\artifact\\mini");
            if(!saveDir.exists()){
                saveDir.mkdir();
            }
            File file = new File(saveDir+File.separator+result);
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(by1);
            if(fos!=null){
                fos.close();
            }
            /*downLoadFromUrl(str,
                    result,"E:\\1webfront\\dotacard\\src\\images\\artifact");*/
        }catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
        }

        }
    }

    @Test
    public void jsondeal(){
        String filepath="E:\\save\\projectsource\\dotacard\\card_set_1.1.json";
        String jsonContent = ReadFile(filepath);


        JSONArray jsonArray = JSON.parseArray(jsonContent);
        JSONObject jsonObject=new JSONObject();


        for(int i=0;i<jsonArray.size();i++){

            jsonObject=jsonArray.getJSONObject(i);
            jsonObject.getString("ename");
            System.out.println(jsonObject.getString("ename"));
        }


    }

    @Test
    public void testjson() throws FileNotFoundException {

        String jsonContent = ReadFile(FILE_PATH);
        List<ValueCard> valueCardList= JSON.parseArray(jsonContent,ValueCard.class);
        for(ValueCard valueCard:valueCardList){
            if(valueCard.getRarity()!=null) {
                if (valueCard.getRarity().equals("Common")) {
                    valueCard.setNumrarity(1);

                }
                if (valueCard.getRarity().equals("Uncommon")) {
                    valueCard.setNumrarity(2);

                }
                if (valueCard.getRarity().equals("Rare")) {
                    valueCard.setNumrarity(3);

                }
            }
            for(References references:valueCard.getReferences()){
                references.setRefertences_id(valueCard.getCard_id());
                ReferencesMapper.rdainit(references);
            }
            valueCardMapper.cdainit(valueCard);
        }

    }

    @Test
    //读入大量数据使用reader的方式，不会一次载入内存，效率较高。实现失败。先使用parsearr的方式
    public void ReadWithFastJson() throws FileNotFoundException {


        JSONReader reader = new JSONReader(new FileReader(new File(FILE_PATH)));
        //reader.startArray();//---> [  开启读List对象
        reader.startArray();
        while (reader.hasNext()) {
            reader.startObject();
            ValueCard valueCard = new ValueCard();
            List<References> referencesList = new ArrayList<>();
            while (reader.hasNext()) {
                String key = reader.readString();
                System.out.print("key " + key);
                if (key.equals("card_id")) {
                    valueCard.setCard_id(reader.readInteger());
                }

              else  if (key.equals("card_name")) {
                    reader.startObject();
                    System.out.print("start object item");
                    Card_name card_name = new Card_name();
                    valueCard.setCard_name(card_name);
                    while (reader.hasNext()) {
                        String objectKey = reader.readString();
                        String objectValue = reader.readObject().toString();
                        System.out.print(" key " + objectKey);
                        System.out.print(" value " + objectValue);

                        if (objectKey.equals("schinese"))
                            card_name.setSchinese(objectValue);
                        if (objectKey.equals("english"))
                            card_name.setEnglish(objectValue);
                    }
                    reader.endObject();
                    System.out.print("end object item");
                } else if (key.equals("card_text")) {
                    reader.startObject();
                    System.out.print("start object item");
                    Card_text card_text = new Card_text();
                    valueCard.setCard_text(card_text);
                    while (reader.hasNext()) {
                        String objectKey = reader.readString();
                        String objectValue = reader.readObject().toString();
                        System.out.print(" key " + objectKey);
                        System.out.print(" value " + objectValue);
                        if (objectKey.equals("schinese"))
                            card_text.setSchinese(objectValue);
                        if (objectKey.equals("english"))
                            card_text.setEnglish(objectValue);
                    }
                    reader.endObject();
                    System.out.print("end object item");

                } else if (key.equals("mini_image")) {
                    reader.startObject();
                    System.out.print("start object item");
                    valueCard.setMini_image(new Mini_image());
                    while (reader.hasNext()) {
                        String objectKey = reader.readString();
                        String objectValue = reader.readObject().toString();
                        System.out.print(" key " + objectKey);
                        System.out.print(" value " + objectValue);
                        if (objectKey.equals("schinese"))
                            valueCard.getMini_image().setSchinese(objectValue);
                    }
                    reader.endObject();
                    System.out.print("end object item");

                } else if (key.equals("large_image")) {
                    reader.startObject();
                    System.out.print("start object item");
                    valueCard.setLarge_image(new Large_image());
                    while (reader.hasNext()) {
                        String objectKey = reader.readString();
                        String objectValue = reader.readObject().toString();
                        System.out.print(" key " + objectKey);
                        System.out.print(" value " + objectValue);
                        if (objectKey.equals("schinese"))
                            valueCard.getLarge_image().setSchinese(objectValue);
                    }
                    reader.endObject();
                    System.out.print("end object item");

                } else if (key.equals("ingame_image")) {
                    reader.startObject();
                    System.out.print("start object item");
                    valueCard.setIngame_image(new Ingame_image());
                    while (reader.hasNext()) {
                        String objectKey = reader.readString();
                        String objectValue = reader.readObject().toString();
                        System.out.print(" key " + objectKey);
                        System.out.print(" value " + objectValue);
                        if (objectKey.equals("schinese"))
                            valueCard.getIngame_image().setSchinese(objectValue);
                    }
                    reader.endObject();
                    System.out.print("end object item");

                }
                else if (key.equals("rarity")) {
                    if (reader.readObject().toString().equals("Common")) {
                        valueCard.setNumrarity(1);

                    }
                    if (reader.readObject().toString().equals("Uncommon")) {
                        valueCard.setNumrarity(2);

                    }
                    if (reader.readObject().toString().equals("Rare")) {
                        valueCard.setNumrarity(3);
                    }

                }
                else if (key.equals("references")) {
                    reader.startArray();
                    System.out.print("start " + key);
                    while (reader.hasNext()) {
                        References references = new References();
                        references.setRefertences_id(valueCard.getCard_id());
                        reader.startObject();
                        System.out.print("start arraylist item");
                        while (reader.hasNext()) {
                            String objectKey = reader.readString();
                            String objectValue = reader.readObject().toString();
                            System.out.print(" key " + objectKey);
                            System.out.print(" value " + objectValue);


                            if (objectKey.equals("ref_type")) {

                                references.setRef_type(objectValue);

                            } else {
                                try {
                                    setProperty(references, objectKey, Integer.valueOf(objectValue));
                                } catch (Exception e) {
                                    System.out.println(e);
                                }
                            }

                        }
                        ReferencesMapper.rdainit(references);
                        referencesList.add(references);
                        reader.endObject();
                        System.out.print("end object item");

                    }
                    reader.endArray();
                    System.out.print("end arraylist item");

                }
                else if(key.equals("is_blue")){
                    reader.readObject(valueCard.isIs_blue());
                    System.out.println("blueis"+reader.readObject());
                    valueCard.setIs_blue(true);
                }
                else if(key.equals("is_red")){
                    System.out.println(reader.readObject());
                    valueCard.setIs_red(true);
                }
                else if(key.equals("is_black")){
                    System.out.println(reader.readObject());
                    valueCard.setIs_black(true);
                }
                else if(key.equals("is_green")){
                    System.out.println(reader.readObject());
                    valueCard.setIs_green(true);
                }
                else {
                    try {
                        if (getValue(valueCard, key) instanceof Integer) {
                            setProperty(valueCard, key, reader.readInteger());

                        } else{
                            setProperty(valueCard, key, reader.readObject().toString());
                        }


                    } catch (Exception e) {
                        System.out.println(e);
                    }


                }

                System.out.print("start fastjson");

            }
            reader.endObject();
            //reader.endArray();//---> ]
            System.out.print("start fastjson");
            valueCard.setReferences(referencesList);
            valueCardMapper.cdainit(valueCard);
        }

    }
}
