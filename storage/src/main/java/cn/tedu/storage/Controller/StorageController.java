package cn.tedu.storage.Controller;

import cn.tedu.storage.Service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class StorageController {
    @Autowired
    private StorageService storageService;

    @GetMapping("/decrease")
    public String decrease(Long productId ,Integer count)throws Exception{
        log.info("减少商品库存,productId="+productId+",count"+count);
        //库存本地事务
        storageService.decrease(productId, count);

        return "减少库存成功";
    }

}
