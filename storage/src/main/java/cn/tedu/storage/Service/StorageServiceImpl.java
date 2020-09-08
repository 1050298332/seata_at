package cn.tedu.storage.Service;

import cn.tedu.storage.mapper.StorageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StorageServiceImpl implements StorageService{
    @Autowired
    private StorageMapper storageMapper;
    @Transactional  //本地事务注解   可选 不加也行
    @Override
    public void decrease(Long productId, Integer count) throws Exception {
        storageMapper.decrease(productId, count);
    }



}
