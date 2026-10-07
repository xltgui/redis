import redis.clients.jedis.RedisClient;
import redis.clients.jedis.args.ListPosition;

import java.util.List;

public class Exercicio4 {
    public static void main(String[] args) {
        RedisClient redis = RedisClient.create();

        for (int i = 0; i < 10; i++) {
            redis.lpush("User-" + i, "ValorUser-" + i);
        }

        redis.close();
    }

}
