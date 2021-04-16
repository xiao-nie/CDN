package cn.awall.awalladmin.dao;

import cn.awall.awalladmin.pojo.Notice;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface NoticeMapper {

    //插入数据
    public int addNotice(Notice notice);

    //删除数据
    public int deleteNoticeById(Long noticeId);

    //修改信息
    public int updateNotice(Notice notice);

    //按条件查询
    public List<Notice> selectNotice(Notice notice);

}
