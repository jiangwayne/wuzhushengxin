package wayne.wuzhushengxin.server.model.entity;

import java.time.LocalDate;
import java.util.Date;

/**
 * Created by jw on 2017/3/15.
 */
public class ArticleEntity {
    private int id;
    private String title;
    private int views;
    private int comments;
    private String brief;
    private String url;
    private int categoryId;
    private LocalDate gmtCreate;
    private LocalDate gmtModify;


    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getComments() {
        return comments;
    }

    public void setComments(int comments) {
        this.comments = comments;
    }

    public LocalDate getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(LocalDate gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public LocalDate getGmtModify() {
        return gmtModify;
    }

    public void setGmtModify(LocalDate gmtModify) {
        this.gmtModify = gmtModify;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }
}
