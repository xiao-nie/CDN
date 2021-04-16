package cn.awall.awalladmin.service;

import cn.awall.awalladmin.pojo.Article;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ArticleService {
    //发布文章
    int pubArticle(Article article);
    //分页查询
    List<Article> getArticlesByPage(int pageNum,int len);

    Article queryArticleById(Long id);

    int countAdd(Long id);
}
