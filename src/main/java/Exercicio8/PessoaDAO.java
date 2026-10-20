package Exercicio8;

import Exercicio8.Pessoa;
import redis.clients.jedis.RedisClient;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class PessoaDAO {
    RedisClient redis = RedisClient.create();

    public Pessoa read(String key, Long id) {
        Pessoa pessoa = null;
        try {
            byte[] data = redis.get((key + id).getBytes());
            ByteArrayInputStream bis = new ByteArrayInputStream(data);
            ObjectInputStream ois = new ObjectInputStream(bis);
            pessoa = (Pessoa) ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pessoa;
    }

    public void create(String key, Pessoa value) {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream bos = new ObjectOutputStream(baos);
            bos.writeObject(value);
            redis.set((key + value.id()).getBytes(), baos.toByteArray());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update(String key, Pessoa value) {
        this.create(key, value);
    }

    public void delete(String key) {
        redis.del(key);
    }
}
