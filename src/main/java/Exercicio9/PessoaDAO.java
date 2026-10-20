package Exercicio9;

import redis.clients.jedis.RedisClient;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

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

            redis.hset(key.getBytes(), longByteArray(value.id()), baos.toByteArray());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private byte[] longByteArray(long id) {
        return new byte[] {(byte) (id >>> 48), (byte) (id >>> 32), (byte) (id >>> 16), (byte) id};
    }

    public void update(String key, Pessoa value) {
        this.create(key, value);
    }

    public void delete(String key) {
        redis.del(key);
    }
}
