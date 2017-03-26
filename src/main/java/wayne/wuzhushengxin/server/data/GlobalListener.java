package wayne.wuzhushengxin.server.data;

import com.admai.adx.server.framework.util.LogFileWriteThread;
import com.admai.adx.server.framework.util.LogPointFileWriteThread;
import com.admai.adx.server.framework.util.LogSdkFileWriteThread;
import com.admai.dsp.server.core.common.DspFileWriteThread;
import com.admai.dsp.server.core.common.JsPointThread;
import com.admai.oldapi.server.common.FileWriteThread;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.ContextLoader;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Created by Wayne.Jiang on 2015/12/22.
 */

/**
 * 全局监听器 初始化时加载相关数据
 */
@WebListener
public class GlobalListener implements ServletContextListener, HttpSessionListener {

    @Autowired
    private LogFileWriteThread logFileWriteThread;

    @Autowired
    private LogSdkFileWriteThread logSdkFileWriteThread;

    @Autowired
    private LogPointFileWriteThread logPointFileWriteThread;

    @Autowired
    private FileWriteThread oldFileWriteThread;


    @Autowired
    private DspFileWriteThread dspFileWriteThread;

    @Autowired
    private RedisWriteThread redisWriteThread;

    @Autowired
    ExceptionHandler exceptionHandlerThread;

    @Autowired
    private JsPointThread jsPointThread;

    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("context initializing");
        //初始化server
        DataServer.init();
        System.out.println("done. DataServer.init();");

        // adx广告日志线程
        logFileWriteThread = ContextLoader.getCurrentWebApplicationContext().getBean(LogFileWriteThread.class);
        System.out.println("done. logFileWriteThread = ContextLoader.getCurrentWebApplicationContext().getBean(LogFileWriteThread.class); ");
        Thread logThread = new Thread(logFileWriteThread);
        System.out.println("done. Thread logThread = new Thread(logFileWriteThread); ");
        logThread.start();
        System.out.println("done. logThread.start(); ");

        // sdk日志线程
        logSdkFileWriteThread = ContextLoader.getCurrentWebApplicationContext().getBean(LogSdkFileWriteThread.class);
        System.out.println("done. logSdkFileWriteThread = ContextLoader.getCurrentWebApplicationContext().getBean(LogSdkFileWriteThread.class); ");
        Thread logSdkThread = new Thread(logSdkFileWriteThread);
        System.out.println("done. Thread logSdkThread = new Thread(logSdkFileWriteThread); ");
        logSdkThread.start();
        System.out.println("done. logSdkThread.start(); ");

        // point日志线程
        logPointFileWriteThread = ContextLoader.getCurrentWebApplicationContext().getBean(LogPointFileWriteThread.class);
        System.out.println("done. logPointFileWriteThread = ContextLoader.getCurrentWebApplicationContext().getBean(logPointFileWriteThread.class); ");
        Thread logPointThread = new Thread(logPointFileWriteThread);
        System.out.println("done. Thread logPointThread = new Thread(LogPointFileWriteThread); ");
        logPointThread.start();
        System.out.println("done. logPointThread.start(); ");

        // oldserver api广告日志线程
        oldFileWriteThread = ContextLoader.getCurrentWebApplicationContext().getBean(FileWriteThread.class);
        Thread oldlogThread = new Thread(oldFileWriteThread);
        oldlogThread.start();
        System.out.println("done. oldlogThread.start(); ");


        // dsp广告日志线程
        dspFileWriteThread = ContextLoader.getCurrentWebApplicationContext().getBean(DspFileWriteThread.class);
        Thread dspLogThread = new Thread(dspFileWriteThread);
        dspLogThread.start();
        System.out.println("done. dspLogThread.start(); ");

        //js埋点日志
        jsPointThread = ContextLoader.getCurrentWebApplicationContext().getBean(JsPointThread.class);
        Thread jsThread = new Thread(jsPointThread);
        jsThread.start();
        System.out.println("done. jsPointThread.start(); ");

        //redis write线程
        redisWriteThread = ContextLoader.getCurrentWebApplicationContext().getBean(RedisWriteThread.class);
        Thread redisThread = new Thread(redisWriteThread);
        redisThread.start();
        System.out.println("done. redisThread.start(); ");

//        JedisResource js = ContextLoader.getCurrentWebApplicationContext().getBean(JedisResource.class);
//        for(int i = 0; i <1; i++){
//            RedisWriteThread redisWriteThread = new RedisWriteThread(i);
//            redisWriteThread.setJedisResource(js);
//            Thread redisThread = new Thread(redisWriteThread);
//            redisThread.start();
//            System.out.println("done. redisThread.start(); ---" + i);
//        }

        //异常处理线程(包含邮件发送)
        exceptionHandlerThread = ContextLoader.getCurrentWebApplicationContext().getBean(ExceptionHandler.class);
        Thread exceptionThread = new Thread(exceptionHandlerThread);
        exceptionThread.start();
        System.out.println("done. exceptionThread.start(); ");

        //主要处理平均投放
        //BalanceServer.init();
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }

    public void sessionCreated(HttpSessionEvent httpSessionEvent) {

    }

    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {

    }
}
