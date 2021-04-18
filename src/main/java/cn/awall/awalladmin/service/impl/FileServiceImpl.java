package cn.awall.awalladmin.service.impl;


import cn.awall.awalladmin.dao.FileDAO;
import cn.awall.awalladmin.pojo.UFile;
import cn.awall.awalladmin.service.FileService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class FileServiceImpl implements FileService {

    @Resource
    private FileDAO fileDAO;

    @Override
    public List<UFile> queryAll() {
        return fileDAO.queryAll();
    }

    @Override
    public List<UFile> queryByLimit(int page, int limit) {
        int i = (page-1)*10;
        return fileDAO.queryByLimit(i,limit);
    }

    @Override
    public UFile queryById(Long id) {
        return fileDAO.queryById(id);
    }

    @Override
    public Integer add(UFile UFile) {
        return fileDAO.add(UFile);
    }

    @Override
    public Integer delById(Long id) {
        return fileDAO.delById(id);
    }

    @Override
    public Integer delByUrl(String url) {
        return fileDAO.delByUrl(url);
    }
}
