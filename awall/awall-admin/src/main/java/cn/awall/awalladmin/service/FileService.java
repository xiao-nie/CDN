package cn.awall.awalladmin.service;

import cn.awall.awalladmin.pojo.UFile;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FileService {

     List<UFile> queryAll();

     List<UFile> queryByLimit(@Param("i") int page, @Param("n") int limit);

     UFile queryById(Long id);

     Integer add(UFile UFile);

     Integer delById(Long id);

     Integer delByUrl(String url);
}
