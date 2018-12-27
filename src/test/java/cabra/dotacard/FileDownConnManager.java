package cabra.dotacard;

import org.apache.tomcat.util.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;
import java.util.concurrent.*;

/**
 * @date:2018/11/23
 * @description
 **/
public class FileDownConnManager {

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


    private static final Logger logger = LoggerFactory.getLogger(FileDownConnManager.class);

    private static final FileDownConnManager connManager = new FileDownConnManager();

    private static ExecutorService executorService = Executors.newFixedThreadPool(10); //10个线程跑

    public static FileDownConnManager getDefaultManager() {
        return connManager;
    }

    public static byte[] fileDown(final String netURL) throws ExecutionException, InterruptedException {

        Future<byte[]> future = executorService.submit(new Callable<byte[]>() {
            @Override
            public byte[] call() throws Exception {
                Date date = new Date();
                URL url;
                byte[] getData = new byte[0];
                InputStream is = null;
                try {
                    url = new URL(netURL);
                    URLConnection connection = url.openConnection();
                    is = connection.getInputStream();
                    getData = readInputStream(is);

                } catch (IOException e) {
                    logger.error("从URL获得字节流数组失败 " + e);
                } finally {
                    try {
                        is.close();
                    } catch (IOException e) {
                        logger.error("从URL获得字节流数组流释放失败 " + e);
                    }
                }
                return getData;
            }
        });
        return future.get();
    }

}
