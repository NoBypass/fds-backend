package com.fds.v1.graphql.service;

import com.fds.v1.database.node.DiscordUser;
import com.fds.v1.database.repository.DiscordUserRepository;
import com.fds.v1.error.NotFoundException;
import com.fds.v1.lib.Common;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@Component
public class DiscordUserService {
    private final DiscordUserRepository discordUserRepository;

    public DiscordUserService(DiscordUserRepository discordUserRepository) {
        this.discordUserRepository = discordUserRepository;
    }

    public DiscordUser add(long uuid) {
        DiscordUser user = new DiscordUser(uuid);
        return discordUserRepository.save(user);
    }

    public DiscordUser remove(String id) {
        return discordUserRepository.removeById(id);
    }

    public DiscordUser change(String id, Map<String, Object> properties) {
        try {
            DiscordUser existing = discordUserRepository.getById(id);
            if (existing == null) throw new NotFoundException("User with id:" + id + " not found");

            return discordUserRepository.updateById(id, Common.updateObjectWithMap(existing, properties));
        } catch (Exception e) {
            throw new RuntimeException("Failed to change Discord user", e);
        }
    }

    public DiscordUser getByUuid(long uuid) {
        return discordUserRepository.getByUuid(uuid);
    }
}
