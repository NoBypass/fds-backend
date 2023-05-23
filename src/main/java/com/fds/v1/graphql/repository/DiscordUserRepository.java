package com.fds.v1.graphql.repository;

import com.fds.v1.lib.Common;
import com.redislabs.redisgraph.ResultSet;
import com.redislabs.redisgraph.impl.api.RedisGraph;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DiscordUserRepository {

    private final RedisGraph db;

    public DiscordUserRepository() {
        this.db = new RedisGraph("localhost", 6379);
    }

    public ResultSet get(String name) {
        String query = "MATCH (d:DiscordUser {id: '" + name + "'}) RETURN d";
        return db.query("$", query);
    }

    public ResultSet link(String id) {
        String query = "MATCH (d:DiscordUser {id: '" + id + "'}) SET d.uuid = '" + Common.generateUUID() + "' RETURN d";
        return db.query("$", query);
    }

    public ResultSet unlink(String id) {
        String query = "MATCH (d:DiscordUser {id: '" + id + "'}) SET d.uuid = '' RETURN d";
        return db.query("$", query);
    }

    public ResultSet add(String id) {
        String query = "CREATE (d:DiscordUser {id: '" + id + "', uuid: ''}) RETURN d";
        return db.query("$", query);
    }

    public ResultSet remove(String id) {
        String query = "MATCH (d:DiscordUser {id: '" + id + "'}) DELETE d";
        return db.query("$", query);
    }

    public ResultSet change(String id, String uuid, Integer dailyStreak, Integer xp, Integer lastDailyAt, Integer messagesSent, Integer registeredAt) {
        List<String> keys = List.of("uuid", "dailyStreak", "xp", "lastDailyAt", "messagesSent", "registeredAt");
        List<String> values = List.of(uuid, dailyStreak.toString(), xp.toString(), lastDailyAt.toString(), messagesSent.toString(), registeredAt.toString());
        String query = "MATCH (d:DiscordUser {id: '" + id + "'}) SET " + Common.optionalQuery("d", keys, values) + " RETURN d";
        return db.query("$", query);
    }
}
