package com.fds.v1.graphql.hypixel;

import com.fds.v1.graphql.discord.DiscordUser;
import org.springframework.data.redis.core.RedisHash;

@RedisHash("HypixelPlayer")
public class HypixelPlayer {
    private Boolean isTracked;
    private DiscordUser discordUser;
}
