import com.alibaba.fastjson.JSON;
import com.test.pojo.JsonRootBean;
import com.test.pojo.Tmufequerys;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;

public class URLFilter {

    private static final String JSON_PATH="C:\\Users\\pro\\Desktop\\record.txt";
    private static final String RESULT_PATH="C:\\Users\\pro\\Desktop\\record.xls";


    public static String txt2String(File file) {
        StringBuilder result = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));//构造一个BufferedReader类来读取文件
            String s;
            while ((s = br.readLine()) != null) {//使用readLine方法，一次读一行
                result.append(System.lineSeparator() + s);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result.toString();
    }

    private static HashMap<String, List<Tmufequerys>> getMap(List<Tmufequerys> tmufequerysList){
        HashMap<String, List<Tmufequerys>> map = new HashMap();
        for (Tmufequerys tmufequerys : tmufequerysList) {
            String wrsscore = String.valueOf(tmufequerys.getWrsscore());
            if (map.containsKey(wrsscore)) {
                map.get(wrsscore).add(tmufequerys);
            } else {
                List array = new ArrayList();
                array.add(tmufequerys);
                map.put(wrsscore, array);
            }

        }
        return map;
    }

    private static void write(HashMap<String, List<Tmufequerys>> map){
        File xlsFile = new File(RESULT_PATH);
        // 创建一个工作簿
        WritableWorkbook workbook=null;
        try {
            workbook = Workbook.createWorkbook(xlsFile);
            //创建一个sheet页
            WritableSheet sheet = workbook.createSheet("sheet1", 0);

            Iterator<Map.Entry<String, List<Tmufequerys>>> entries = map.entrySet().iterator();
            int row = 0;
            while (entries.hasNext()) {
                Map.Entry<String, List<Tmufequerys>> entry = entries.next();
                for (Tmufequerys tmufequerys : entry.getValue()) {
                    //列：wrsscore,name,url
                    sheet.addCell(new Label(0, row, entry.getKey()));
                    sheet.addCell(new Label(1, row, tmufequerys.getCategories().get(0).getName()));
                    sheet.addCell(new Label(2, row, tmufequerys.getUrl()));
                    row++;
                }
            }
            workbook.write();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                workbook.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        File file = new File(JSON_PATH);
        // 读json文件
        String fileContent = txt2String(file);
        //json string 转成bean
        JsonRootBean bean = JSON.parseObject(fileContent, JsonRootBean.class);
        List<Tmufequerys> tmufequerysList = bean.getTmufequerys();

        //放到 wrsscore为key的map
        HashMap<String, List<Tmufequerys>> map =getMap(tmufequerysList);
        //写到excel
        write(map);
    }
}
