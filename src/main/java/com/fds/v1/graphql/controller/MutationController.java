package com.fds.v1.graphql.controller;

import com.fds.v1.database.node.DiscordUser;
import com.fds.v1.graphql.service.DiscordUserService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

@Controller
public class MutationController {
    private final DiscordUserService discordUserService;

    public MutationController(DiscordUserService discordUserService) {
        this.discordUserService = discordUserService;
    }

    @MutationMapping
    public DiscordUser addDiscordUser(@Argument long uuid) {
        return discordUserService.add(uuid);
    }
}
