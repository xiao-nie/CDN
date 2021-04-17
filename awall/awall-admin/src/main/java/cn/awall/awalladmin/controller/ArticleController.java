package cn.awall.awalladmin.controller;

import cn.awall.awalladmin.pojo.Article;
import cn.awall.awalladmin.pojo.User;
import cn.awall.awalladmin.service.ArticleService;
import cn.awall.awalladmin.service.UserService;
import cn.awall.awalladmin.vo.CommonResult;
import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

@CrossOrigin
@RestController
public class ArticleController {

    @Resource
    private ObjectMapper mapper;
    @Resource
    private ArticleService articleService;
    @Resource
    private UserService userService;

    //分页查询
    @SneakyThrows
    @GetMapping("/articles/{page}/{len}")
    public CommonResult queryByPage(@PathVariable int page,@PathVariable int len){

        ArrayList<ObjectNode> list = new ArrayList<>();
        List<Article> articles = articleService.getArticlesByPage(page, len);
        for (Article article : articles) {
            Long userId = article.getUserId();
            User user = userService.getUser(userId);
            ObjectNode node = mapper.createObjectNode();
            ObjectNode userNode = mapper.createObjectNode();
            userNode.put("nikeName",user.getNikename());
            userNode.put("rz",user.getAc());
            userNode.put("url",user.getHeadImg());
            node.put("user",userNode);
            node.put("date",article.getDate().toString());
            node.put("text",article.getContent());
            node.put("imgs","");
            node.put("star",article.getStar());
            node.put("show",false);
            node.put("id",article.getArticleId());
            node.put("url","#/article/"+article.getArticleId());
            list.add(node);
        }
        String jsonRes = mapper.writeValueAsString(list);
        return new CommonResult(200,jsonRes);
    }

    //发布文章
    @SneakyThrows
    @PostMapping("/articles/pubArticle")
    public CommonResult<String> pubArticle(@RequestBody Object obj, HttpServletRequest request){

        String userId = (String)request.getSession().getAttribute("userId");
        Map<String, String> map = mapper.readValue(JSON.toJSONString(obj), Map.class);

        Article article = new Article();
        article.setArticleId(null);
        article.setUserId(Long.valueOf(userId));
        article.setClassify(map.get("classify"));
        article.setContent(map.get("text"));
        article.setCount(0L);
        article.setDate(new Date());
        article.setStar(0);
        article.setTag(map.get("tag"));
        article.setUrl("#/article/1");
        int i = articleService.pubArticle(article);
        if (i==1){
            return new CommonResult<>(200,"发布成功!");
        }
        return new CommonResult<>(500,"发布失败!");
    }
}
