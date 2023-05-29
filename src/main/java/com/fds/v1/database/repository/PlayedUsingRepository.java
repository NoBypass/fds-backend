package com.fds.v1.database.repository;

import com.fds.v1.database.edge.LinkedWith;
import com.fds.v1.database.edge.PlayedUsing;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;

public interface PlayedUsingRepository extends Neo4jRepository<PlayedUsing, String> {
    @Query("MATCH (d:DiscordUser), (u:User) " +
            "WHERE d.id = $discordUserId AND u.id = $userId " +
            "CREATE (d)-[l:LINKED_WITH]->(u) " +
            "SET l.linkedAt = timestamp(), l.linkedByName = $linkedByName " +
            "RETURN l")
    LinkedWith linkWith(@Param("mojangAccountId") String mojangAccountId, @Param("hypixelPlayerId") String hypixelPlayerId, @Param("linkedByName") String linkedByName);
}
