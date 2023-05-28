package com.fds.v1.graphql.service;

import com.fds.v1.database.edge.LinkedWith;
import com.fds.v1.database.repository.DiscordUserRepository;
import com.fds.v1.database.repository.HypixelPlayerRepository;
import com.fds.v1.database.node.DiscordUser;
import com.fds.v1.database.node.HypixelPlayer;
import com.fds.v1.database.repository.LinkedWithRepository;
import com.fds.v1.error.NotFoundException;
import com.fds.v1.lib.Common;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service
@Component
public class MutationService implements GraphQLMutationResolver {
    private final DiscordUserRepository discordUserRepository;
    private final HypixelPlayerRepository hypixelPlayerRepository;
    private final LinkedWithRepository linkedWithRepository;

    public MutationService(DiscordUserRepository discordUserRepository, HypixelPlayerRepository hypixelPlayerRepository, LinkedWithRepository linkedWithRepository) {
        this.discordUserRepository = discordUserRepository;
        this.hypixelPlayerRepository = hypixelPlayerRepository;
        this.linkedWithRepository = linkedWithRepository;
    }

    public HypixelPlayer addHypixelPlayer(boolean isTracked) {
        HypixelPlayer player = new HypixelPlayer(isTracked);
        return hypixelPlayerRepository.save(player);
    }

    public HypixelPlayer removeHypixelPlayer(String id) {
        try {
            return hypixelPlayerRepository.removeById(id);
        } catch (Exception e) {
            throw new RuntimeException("Failed to remove Hypixel player", e);
        }
    }

    public HypixelPlayer changeHypixelPlayer(String id, Boolean isTracked) {
        try {
            HypixelPlayer player = hypixelPlayerRepository.getById(id);
            if (player == null) throw new NotFoundException("Player with id:" + id + " not found");
            if (isTracked != null) player.setTracked(isTracked);
            return hypixelPlayerRepository.updateById(id, player);
        } catch (Exception e) {
            throw new RuntimeException("Failed to change Hypixel player", e);
        }
    }

    public LinkedWith linkDiscordUser(String discordUserId, String hypixelPlayerId, String linkedByName) {
        return linkedWithRepository.linkWith(discordUserId, hypixelPlayerId, linkedByName);
    }

    public LinkedWith unlinkDiscordUser(String discordUserId, String hypixelPlayerId) {
        return linkedWithRepository.unlinkFrom(discordUserId, hypixelPlayerId);
    }

    public DiscordUser addDiscordUser(long uuid) {
        DiscordUser user = new DiscordUser(uuid);
        return discordUserRepository.save(user);
    }

    public DiscordUser removeDiscordUser(String id) {
        return discordUserRepository.removeById(id);
    }

    public DiscordUser changeDiscordUser(String id, Map<String, Object> properties) {
        try {
            DiscordUser existing = discordUserRepository.getById(id);
            if (existing == null) throw new NotFoundException("User with id:" + id + " not found");

            return discordUserRepository.updateById(id, Common.updateObjectWithMap(existing, properties));
        } catch (Exception e) {
            throw new RuntimeException("Failed to change Discord user", e);
        }
    }
}
