import redis.clients.jedis.RedisClient;

public class MyRedisClient {
    private RedisClient redis;

    public MyRedisClient() {
       this.redis = RedisClient.create();
    }

    public redis.clients.jedis.RedisClient getRedis() {
        return redis;
    }
}
