package com.fds.v1.graphql.mapper;

import com.fds.v1.graphql.node.DiscordUser;
import com.fds.v1.graphql.node.HypixelPlayer;
import com.fds.v1.lib.Common;
import com.redislabs.redisgraph.Record;
import com.redislabs.redisgraph.ResultSet;

public class ResultSetMapper {
    public static DiscordUser mapDiscordUser(ResultSet resultSet) {
        if (resultSet.hasNext()) {
            Record record = resultSet.next();
            DiscordUser user = new DiscordUser();
            user.setId(record.getString("id"));
            user.setUuid(record.getString("uuid"));
            user.setDailyStreak(Common.intFromRecord(record, "dailyStreak"));
            user.setXp(Common.intFromRecord(record, "xp"));
            user.setLastDailyAt(Common.intFromRecord(record, "lastDailyAt"));
            user.setMessagesSent(Common.intFromRecord(record, "messagesSent"));
            user.setRegisteredAt(Common.intFromRecord(record, "registeredAt"));
            HypixelPlayer linkedPlayer = ResultSetMapper.mapHypixelPlayer(resultSet);
            user.setLinkedWith(linkedPlayer);
            return user;
        }
        return null;
    }

    public static HypixelPlayer mapHypixelPlayer(ResultSet resultSet) {
        if (resultSet.hasNext()) {
            Record record = resultSet.next();
            HypixelPlayer player = new HypixelPlayer();
            player.setId(record.getString("id"));
            player.setTracked(Common.boolFromRecord(record, "isTracked"));
            DiscordUser linkedUser = ResultSetMapper.mapDiscordUser(resultSet);
            player.setLinkedWith(linkedUser);
            return player;
        }
        return null;
    }
}
