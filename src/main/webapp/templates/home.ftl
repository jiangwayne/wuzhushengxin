<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Home</title>

    <meta charset="utf-8">
    <meta name="description" content="个人博客,学习笔记,知识分享">
    <meta name="keywords" content="数学，算法，编程">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link rel="stylesheet" href="/static/css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="/static/css/common.css" type="text/css">
    <link rel="stylesheet" href="/static/css/header.css" type="text/css">
    <script src="/static/js/jquery-3.1.1.min.js"></script>
</head>
<body>
<div id="page-container">
    <#assign page="${page}">
    <#include "header.ftl">
    <section id="page">
        <div class="container">
            <div class="row">
                <div class="col-lg-8 col-sm-8 column">
                    <#if articleList ??>
                        <#list articleList as article>
                            <header>
                                <h4>${article.categoryName}</h4>
                                <div></div>
                                <#--<span>数学分析</span>-->
                            </header>
                            <article class="post">
                                <header>
                                    <h3><a href="/article?id=${article.id}">${article.title}</a></h3>
                                    <span>${article.gmtCreate[0..9]} / 阅读(${article.views}) / 评论(${article.comments})</span>
                                </header>
                                <div class="editor-styles">
                                    <p>${article.brief}</p>
                                </div>
                                <footer>
                                    <div>
                                        <a href="/article?id=${article.id}">阅读全文...</a>
                                    </div>
                                    <hr>
                                </footer>
                            </article>
                        </#list>
                    <#else>
                        <div>没有文章</div>
                    </#if>
                    <nav id="post-nav">
                        <#--<a href="#">早期文章</a>-->
                    </nav>
                </div>
                <div class="col-lg-4 col-sm-4 column space">
                    <#include "sidebar.ftl">
                </div>
            </div>
        </div>
    </section>
    <#include "footer.ftl">
</div>
</body></html>