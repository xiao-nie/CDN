package cn.awall.awalladmin.dao;

import cn.awall.awalladmin.pojo.UFile;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface FileDAO {

   public List<UFile> queryAll();

   public List<UFile> queryByLimit(@Param("i") int i,@Param("n") int n);

   public UFile queryById(@Param("id") Long id);

   public UFile queryByUrl(@Param("url") String url);

   public List<UFile> queryByList(@Param("list") List<Integer> list);

   public UFile queryByPath(@Param("path") String path);

   Integer add(UFile UFile);

   public Integer delById(@Param("id") Long id);

   public Integer delByUrl(@Param("url") String url);

   public Integer delByList(@Param("list") List<String> list);

   public Integer setById(Map map);

}
