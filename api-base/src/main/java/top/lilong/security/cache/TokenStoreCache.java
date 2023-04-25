package top.lilong.security.cache;


import lombok.AllArgsConstructor;
import top.lilong.common.cache.RedisCache;
import top.lilong.common.cache.RedisKeys;
import top.lilong.security.user.UserDetail;
import org.springframework.stereotype.Component;


/**
 * 登录用户的缓存操作
 *
 * @author
 */
@Component
@AllArgsConstructor
public class TokenStoreCache {

    private final RedisCache redisCache;

    public void saveUser(String accessToken, UserDetail user) {
        String key = RedisKeys.getAccessTokenKey(accessToken);
        redisCache.set(key, user);
    }

    public UserDetail getUser(String accessToken) {
        String key = RedisKeys.getAccessTokenKey(accessToken);
        return (UserDetail) redisCache.get(key);
    }

    public void deleteUser(String accessToken) {
        String key = RedisKeys.getAccessTokenKey(accessToken);
        redisCache.delete(key);
    }
}
