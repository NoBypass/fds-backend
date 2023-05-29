package com.fds.v1.database.repository;

import com.fds.v1.database.edge.LinkedWith;
import com.fds.v1.database.node.DiscordUser;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LinkedWithRepository extends Neo4jRepository<DiscordUser, String> {
    @Query("MATCH (d:DiscordUser), (h:HypixelPlayer) " +
            "WHERE d.id = $discordUserId AND h.id = hypixelPlayerId " +
            "CREATE (d)-[l:LINKED_WITH]->(u) " +
            "SET l = $linkedWith " +
            "RETURN l")
    LinkedWith linkWith(@Param("linkedWith") LinkedWith linkedWith);

    @Query("MATCH (d:DiscordUser)-[l:LINKED_WITH]->() " +
            "WHERE d.id = $discordUserId " +
            "DELETE l " +
            "RETURN l")
    LinkedWith unlinkFrom(String discordUserId);

    @Query("MATCH (d:DiscordUser)-[l:LINKED_WITH]->(h:HypixelPlayer) WHERE l.id = $id RETURN l")
    LinkedWith findLinkedWithById(@Param("id") String id);

}
