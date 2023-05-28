package com.fds.v1.database.repository;

import com.fds.v1.database.edge.LinkedWith;
import com.fds.v1.database.node.DiscordUser;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LinkedWithRepository extends Neo4jRepository<DiscordUser, String> {
    @Query("MATCH (d:DiscordUser), (u:User) " +
            "WHERE d.id = $discordUserId AND u.id = $userId " +
            "CREATE (d)-[l:LINKED_WITH]->(u) " +
            "SET l.linkedAt = timestamp(), l.linkedByName = $linkedByName " +
            "RETURN l")
    LinkedWith linkWith(@Param("discordUserId") String discordUserId, @Param("hypixelPlayerId") String hypixelPlayerId, @Param("linkedByName") String linkedByName);

    @Query("MATCH (d:DiscordUser)-[l:LINKED_WITH]->(u:User) " +
            "WHERE d.id = $discordUserId AND u.id = $hypixelPlayerId " +
            "DELETE l " +
            "RETURN l")
    LinkedWith unlinkFrom(String discordUserId, String hypixelPlayerId);

    @Query("MATCH (d:DiscordUser)-[l:LINKED_WITH]->(u:User) WHERE l.id = $id RETURN l")
    LinkedWith findLinkedWithById(@Param("id") String id);

}
