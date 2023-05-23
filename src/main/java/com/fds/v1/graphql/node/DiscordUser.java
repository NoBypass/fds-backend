package com.fds.v1.graphql.node;

public class DiscordUser {
    private String id;
    private String uuid;
    private Integer dailyStreak;
    private Integer xp;
    private Integer lastDailyAt;
    private Integer messagesSent;
    private Integer registeredAt;
    private HypixelPlayer linkedWith;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
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

    public HypixelPlayer getLinkedWith() {
        return linkedWith;
    }

    public void setLinkedWith(HypixelPlayer linkedWith) {
        this.linkedWith = linkedWith;
    }
}