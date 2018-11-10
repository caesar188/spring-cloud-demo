import java.io.File;
import java.io.FileOutputStream;

public class IPGens {
    public static void main(String[] args) {
        FileOutputStream out = null;
        int a= 255,b = 255,row=0,max=10200;//写文件行数

        try {
            //经过测试：FileOutputStream执行耗时:17，6，10 毫秒
            out = new FileOutputStream(new File("C:\\Users\\pro\\Desktop\\test.spl"));
            long begin = System.currentTimeMillis();
            for (int i = 0; i <=a&&row<=max; i++) {
                for (int j = 0; j <=b&&++row<=max; j++) {
                    out.write(("INSERT INTO `DNS_AUTH_DOMAIN_RECORD` VALUES ('"+row+"', null, 'test"+row+".com.', '2', null, '3600', null, 'a', '192.168."+i+"."+j+"');\r\n").getBytes());
                }
            }
            out.close();
            long end = System.currentTimeMillis();
            System.out.println("FileOutputStream执行耗时:" + (end - begin) + " 毫秒");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
