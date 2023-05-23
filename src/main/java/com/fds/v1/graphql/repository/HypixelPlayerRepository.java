package com.fds.v1.graphql.repository;

import com.fds.v1.lib.Common;
import com.redislabs.redisgraph.ResultSet;
import com.redislabs.redisgraph.impl.api.RedisGraph;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HypixelPlayerRepository {

    private final RedisGraph db;

    public HypixelPlayerRepository() {
        this.db = new RedisGraph("localhost", 6379);
    }
    
    public ResultSet add(String uuid, Boolean isTracked) {
        if (isTracked == null) isTracked = false;
        String query = "CREATE (p:Player {id: '" + Common.generateUUID() + "', uuid: '" + uuid + "', isTracked: '" + isTracked + "'})";
        return db.query("$", query);
    }

    public ResultSet get(String name) {
        String query = "MATCH (p:Player {name: '" + name + "'}) RETURN p";
        return db.query("$", query);
    }

    public ResultSet remove(String id) {
        String query = "MATCH (p:Player {id: '" + id + "'}) DELETE p";
        return db.query("$", query);
    }

    public ResultSet change(String id, String name, Boolean isTracked) {
        List<String> keys = List.of("name", "isTracked");
        List<String> values = List.of(name, isTracked.toString());
        String query = "MATCH (p:Player {id: '" + id + "'}) SET " + Common.optionalQuery("p", keys, values) + " RETURN p";
        return db.query("$", query);
    }
}
