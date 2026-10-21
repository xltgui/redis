package Exercicio10;

import redis.clients.jedis.RedisClient;

import java.util.Random;

public class Subscriber {
    public static void main(String[] args) {
        RedisClient redis = RedisClient.create();

        for (int i = 0; i < 20; i++ ) {
            Random random = new Random();
            redis.publish("Numero: " + i, String.valueOf(random.nextInt()));
        }
    }
}
