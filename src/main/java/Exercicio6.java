import redis.clients.jedis.RedisClient;

import java.util.Map;

public class Exercicio6 {
    public static void main(String[] args) {
        RedisClient redis = RedisClient.create();

        Map<String, Double> users = Map.of(
                "Anakin1", 8d,
                "Anakin2", 2d,
                "Anakin3", 5d,
                "Anakin4", 7d,
                "Anakin5", 9d,
                "Anakin6", 0d,
                "Anakin7", 3d,
                "Anakin8", 1d,
                "Anakin9", 11d
        );

        for (int i = 0; i < 10; i++) {
            double random = Math.random();
            redis.zadd("StarWars-Users", users);
        }
    }
}
