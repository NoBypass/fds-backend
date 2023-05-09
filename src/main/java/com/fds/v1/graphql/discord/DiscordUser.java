package com.fds.v1.graphql.discord;

import com.fds.v1.graphql.hypixel.HypixelPlayer;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.lang.Nullable;

@RedisHash("DiscordUser")
public class DiscordUser {
    private String uuid;
    private Integer dailyStreak;
    @Nullable
    private Integer xp;
    @Nullable
    private Integer lastDailyAt;
    @Nullable
    private Integer messagesSent;
    private Integer registeredAt;
    private HypixelPlayer hypixelPlayer;


}