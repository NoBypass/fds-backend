package com.fds.v1.graphql.controller;

import com.fds.v1.graphql.node.DiscordUser;
import com.fds.v1.graphql.service.MutationService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

@Controller
public class MutationController {
    private final MutationService mutationService;

    public MutationController(MutationService mutationService) {
        this.mutationService = mutationService;
    }

    @MutationMapping
    public DiscordUser addDiscordUser(@Argument String uuid) {
        return mutationService.addDiscordUser(uuid);
    }
}
