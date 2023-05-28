package com.fds.v1.graphql.service;

import com.fds.v1.database.node.DiscordUser;
import com.fds.v1.database.node.HypixelPlayer;
import com.fds.v1.database.repository.DiscordUserRepository;
import com.fds.v1.database.repository.HypixelPlayerRepository;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class QueryService implements GraphQLQueryResolver {
    private final DiscordUserRepository discordUserRepository;
    private final HypixelPlayerRepository hypixelPlayerRepository;

    public QueryService(DiscordUserRepository discordUserRepository, HypixelPlayerRepository hypixelPlayerRepository) {
        this.discordUserRepository = discordUserRepository;
        this.hypixelPlayerRepository = hypixelPlayerRepository;
    }

    public HypixelPlayer hypixelPlayer(String name) {
        return hypixelPlayerRepository.getByName(name);
    }

    public DiscordUser discordUser(long uuid) {
        return discordUserRepository.getByUuid(uuid);
    }
}