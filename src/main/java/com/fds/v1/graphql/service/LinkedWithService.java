package com.fds.v1.graphql.service;

import com.fds.v1.database.edge.LinkedWith;
import com.fds.v1.database.node.DiscordUser;
import com.fds.v1.database.repository.DiscordUserRepository;
import com.fds.v1.database.repository.LinkedWithRepository;
import com.fds.v1.error.NotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class LinkedWithService {
    private final LinkedWithRepository linkedWithRepository;
    private final DiscordUserRepository discordUserRepository;

    public LinkedWithService(LinkedWithRepository linkedWithRepository, DiscordUserRepository discordUserRepository) {
        this.linkedWithRepository = linkedWithRepository;
        this.discordUserRepository = discordUserRepository;
    }

    public LinkedWith link(String discordUserId, String hypixelPlayerId, String linkedByName) {
        DiscordUser user = discordUserRepository.getById(discordUserId);
        if (user == null) throw new NotFoundException("Discord user with id:" + discordUserId + " not found");
        LinkedWith edge = new LinkedWith(user, System.currentTimeMillis(), linkedByName);
        return linkedWithRepository.linkWith(edge);
    }

    public LinkedWith unlink(String discordUserId) {
        return linkedWithRepository.unlinkFrom(discordUserId);
    }
}
