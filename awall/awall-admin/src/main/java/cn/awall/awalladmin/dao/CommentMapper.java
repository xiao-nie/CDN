package cn.awall.awalladmin.dao;

import cn.awall.awalladmin.pojo.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CommentMapper {

    //插入
    public int addComment(Comment comment);

    //通过id删除评论
    public int deleteCommentById(Long comId);

    //通过id修改数据
    public int updateCommentById(Comment comment);

    //通过条件查询数据
    public List<Comment> selectCommentByComment(Comment comment);

}
