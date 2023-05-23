package com.fds.v1.graphql.service;

import com.fds.v1.graphql.mapper.ResultSetMapper;
import com.fds.v1.graphql.node.DiscordUser;
import com.fds.v1.graphql.node.HypixelPlayer;
import com.fds.v1.graphql.repository.DiscordUserRepository;
import com.fds.v1.graphql.repository.HypixelPlayerRepository;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.stereotype.Component;

@Component
public class MutationService implements GraphQLMutationResolver {
    private final DiscordUserRepository discordUserRepository;
    private final HypixelPlayerRepository hypixelPlayerRepository;

    public MutationService(DiscordUserRepository discordUserRepository, HypixelPlayerRepository hypixelPlayerRepository) {
        this.discordUserRepository = discordUserRepository;
        this.hypixelPlayerRepository = hypixelPlayerRepository;
    }

    public HypixelPlayer addHypixelPlayer(String name, Boolean isTracked) {
        return ResultSetMapper.mapHypixelPlayer(hypixelPlayerRepository.add(name, isTracked));
    }

    public HypixelPlayer removeHypixelPlayer(String id) {
        return ResultSetMapper.mapHypixelPlayer(hypixelPlayerRepository.remove(id));
    }

    public HypixelPlayer changeHypixelPlayer(String id, String name, Boolean isTracked) {
        return ResultSetMapper.mapHypixelPlayer(hypixelPlayerRepository.change(id, name, isTracked));
    }

    public DiscordUser linkDiscordUser(String id) {
        return ResultSetMapper.mapDiscordUser(discordUserRepository.link(id));
    }

    public DiscordUser unlinkDiscordUser(String id) {
        return ResultSetMapper.mapDiscordUser(discordUserRepository.unlink(id));
    }

    public DiscordUser addDiscordUser(String uuid) {
        return ResultSetMapper.mapDiscordUser(discordUserRepository.add(uuid));
    }

    public DiscordUser removeDiscordUser(String id) {
          return ResultSetMapper.mapDiscordUser(discordUserRepository.remove(id));
    }

    public DiscordUser changeDiscordUser(String id, String uuid, Integer dailyStreak, Integer xp, Integer lastDailyAt, Integer messagesSent, Integer registeredAt) {
        return ResultSetMapper.mapDiscordUser(discordUserRepository.change(id, uuid, dailyStreak, xp, lastDailyAt, messagesSent, registeredAt));
    }
}