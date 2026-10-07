import redis.clients.jedis.RedisClient;

public class Exercicio5 {
    public static void main(String[] args) {
        MyRedisClient redisCreator = new MyRedisClient();
        var redis = redisCreator.getRedis();
        for (int i = 0; i < 10; i++) {
            redis.sadd("UserSet-" + i, "ValorUserSet-" + i);
        }
        redis.close();
    }
}
