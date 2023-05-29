package com.fds.v1.database.service;

import com.fds.v1.database.node.HypixelPlayer;
import com.fds.v1.database.repository.HypixelPlayerRepository;
import com.fds.v1.lib.error.NotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class HypixelPlayerService {
    private final HypixelPlayerRepository hypixelPlayerRepository;

    public HypixelPlayerService(HypixelPlayerRepository hypixelPlayerRepository) {
        this.hypixelPlayerRepository = hypixelPlayerRepository;
    }

    public HypixelPlayer add(boolean isTracked) {
        HypixelPlayer player = new HypixelPlayer(isTracked);
        return hypixelPlayerRepository.save(player);
    }

    public HypixelPlayer remove(String id) {
        try {
            return hypixelPlayerRepository.removeById(id);
        } catch (Exception e) {
            throw new RuntimeException("Failed to remove Hypixel player", e);
        }
    }

    public HypixelPlayer change(String id, Boolean isTracked) {
        try {
            HypixelPlayer player = hypixelPlayerRepository.getById(id);
            if (player == null) throw new NotFoundException("Player with id:" + id + " not found");
            if (isTracked != null) player.setTracked(isTracked);
            return hypixelPlayerRepository.updateById(id, player);
        } catch (Exception e) {
            throw new RuntimeException("Failed to change Hypixel player", e);
        }
    }

    public HypixelPlayer getByName(String name) {
        return hypixelPlayerRepository.getByName(name);
    }
}
