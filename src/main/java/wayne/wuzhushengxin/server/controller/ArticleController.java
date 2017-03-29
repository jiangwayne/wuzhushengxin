package wayne.wuzhushengxin.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import wayne.wuzhushengxin.server.model.bizmodel.BizArticle;
import wayne.wuzhushengxin.server.model.entity.ArticleEntity;
import wayne.wuzhushengxin.server.service.ArticleService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Created by jiangwulin on 2017/3/21.
 */
@RestController
@RequestMapping(value="/")
public class ArticleController extends BaseController {
    @Autowired
    private ArticleService articleService;
    //文章
    @RequestMapping(value = "article",method = RequestMethod.GET)
    public void articlePage(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int id = Integer.parseInt(request.getParameter("id"));
        BizArticle article = articleService.getArticle(id);
        if(article == null){
            return;
        }
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("page", article.getPage());
        dataMap.put("article", article);

        String htmlPath = "/static/html/" + article.getUrl() + ".html";

        createStaticHtml("article.ftl", request, htmlPath, dataMap);
        response.sendRedirect(htmlPath);
    }

}
