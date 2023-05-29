package com.fds.v1.api.graphql;

import com.fds.v1.database.node.DiscordUser;
import com.fds.v1.database.service.DiscordUserService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

@Controller
public class DiscordUserController {
    private final DiscordUserService discordUserService;

    public DiscordUserController(DiscordUserService discordUserService) {
        this.discordUserService = discordUserService;
    }

    @MutationMapping
    public DiscordUser addDiscordUser(@Argument long uuid) {
        return discordUserService.add(uuid);
    }
}
