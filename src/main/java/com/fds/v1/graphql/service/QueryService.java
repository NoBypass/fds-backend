package com.fds.v1.graphql.service;

import com.fds.v1.graphql.mapper.ResultSetMapper;
import com.fds.v1.graphql.node.DiscordUser;
import com.fds.v1.graphql.node.HypixelPlayer;
import com.fds.v1.graphql.repository.DiscordUserRepository;
import com.fds.v1.graphql.repository.HypixelPlayerRepository;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

@Component
public class QueryService implements GraphQLQueryResolver {
    private final DiscordUserRepository discordUserRepository;
    private final HypixelPlayerRepository hypixelPlayerRepository;

    public QueryService(DiscordUserRepository discordUserRepository, HypixelPlayerRepository hypixelPlayerRepository) {
        this.discordUserRepository = discordUserRepository;
        this.hypixelPlayerRepository = hypixelPlayerRepository;
    }

    public HypixelPlayer hypixelPlayer(String name) {
        return ResultSetMapper.mapHypixelPlayer(hypixelPlayerRepository.get(name));
    }

    public DiscordUser discordUser(String uuid) {
        return ResultSetMapper.mapDiscordUser(discordUserRepository.get(uuid));
    }
}