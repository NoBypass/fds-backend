package com.fds.v1.database.node;

import com.fds.v1.lib.Common;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

import java.util.UUID;

@Node
public class DiscordUser {

    public DiscordUser(long uuid) {
        this.uuid = uuid;
        this.id = UUID.randomUUID().toString();
    }

    public DiscordUser() {
        this.id = Common.uuid("discord-user");
    }

    @Id
    private String id;
    private long uuid;
    private Integer dailyStreak;
    private Integer xp;
    private Integer lastDailyAt;
    private Integer messagesSent;
    private Integer registeredAt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getUuid() {
        return uuid;
    }

    public void setUuid(long uuid) {
        this.uuid = uuid;
    }

    public Integer getDailyStreak() {
        return dailyStreak;
    }

    public void setDailyStreak(Integer dailyStreak) {
        this.dailyStreak = dailyStreak;
    }

    public Integer getXp() {
        return xp;
    }

    public void setXp(Integer xp) {
        this.xp = xp;
    }

    public Integer getLastDailyAt() {
        return lastDailyAt;
    }

    public void setLastDailyAt(Integer lastDailyAt) {
        this.lastDailyAt = lastDailyAt;
    }

    public Integer getMessagesSent() {
        return messagesSent;
    }

    public void setMessagesSent(Integer messagesSent) {
        this.messagesSent = messagesSent;
    }

    public Integer getRegisteredAt() {
        return registeredAt;
    }

    public void setRegisteredAt(Integer registeredAt) {
        this.registeredAt = registeredAt;
    }

}