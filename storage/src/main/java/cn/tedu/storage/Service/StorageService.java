package cn.tedu.storage.Service;

public interface StorageService {
    void decrease(Long productId, Integer count) throws Exception;
}
