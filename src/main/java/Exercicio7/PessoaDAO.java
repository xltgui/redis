package Exercicio7;

import redis.clients.jedis.RedisClient;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class PessoaDAO {
    RedisClient redis = RedisClient.create();

    public Pessoa read(String key, Long id) {
        String dataKey = key + id.toString();
        Map<String, String> data = redis.hgetAll(dataKey);
        List<Pessoa> pessoas = new ArrayList<>();
        if (data == null || data.isEmpty()) {
            throw new RuntimeException("Nenhum dado encontrado para esta chave: " +  dataKey);
        }
        return new Pessoa(id, data.get("nome"), data.get("telefone"));
    }

    public void create(String key, Pessoa value) {
        Map<String, String> data = new LinkedHashMap<>();
        if (value.nome() != null) {
            data.put("nome", value.nome());
        }
        if (value.telefone() != null) {
            data.put("telefone", value.telefone());
        }

        redis.hset(key + value.id(), data);
    }

    public void update(String key, Pessoa value) {
        this.create(key, value);
    }

    public void delete(String key) {
        redis.del(key);
    }
}
