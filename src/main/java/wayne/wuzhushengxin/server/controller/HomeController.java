package wayne.wuzhushengxin.server.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by jiangwulin on 2017/3/11.
 */
@RestController
@RequestMapping(value="/")
public class HomeController extends BaseController {
    private static final Logger log = LoggerFactory.getLogger(HomeController.class);

    @RequestMapping(value = "home",method = RequestMethod.GET)
    public void homePage(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String htmlPath = "static/html/home.html";
        createStaticHtml("home.ftl", request, htmlPath);
        response.sendRedirect(htmlPath);
    }
}
