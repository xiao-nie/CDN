package cn.awall.awalladmin;

import cn.awall.awalladmin.dao.ArticleMapper;
import cn.awall.awalladmin.pojo.Article;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Date;

@SpringBootTest
public class ArticleMapperTest {

    @Resource
    ArticleMapper articleMapper;
    @Test
    public void test1(){
        Article article = new Article();
        article.setArticleId(1L);
        article.setUserId(1L);
        article.setClassify("找对象");
        article.setContent("在这找个对象，女的会Java、linux、前端、网安等等");
        article.setCount(0L);
        article.setDate(new Date());
        article.setStar(0);
        article.setTag("找对象");
        article.setUrl("#/article/1");
        int i = articleMapper.addArticle(article);
        System.out.println(i);
    }
}
