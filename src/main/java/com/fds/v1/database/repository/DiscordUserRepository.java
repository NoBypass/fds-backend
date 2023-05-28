package com.fds.v1.database.repository;

import com.fds.v1.database.node.DiscordUser;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DiscordUserRepository extends Neo4jRepository<DiscordUser, String> {
    @Query("MATCH (d:DiscordUser) WHERE d.uuid = $uuid RETURN d")
    DiscordUser getByUuid(@Param("uuid") long uuid);

    @Query("MATCH (d:DiscordUser) WHERE d.id = $id RETURN d")
    DiscordUser getById(@Param("id") String id);

    @Query("MATCH (d:DiscordUser) WHERE d.id = $id SET d = $discordUser RETURN d")
    DiscordUser updateById(@Param("id") String id, @Param("discordUser") DiscordUser discordUser);

    @Query("MATCH (d:DiscordUser) WHERE d.id = $id DELETE d RETURN d")
    DiscordUser removeById(@Param("id") String id);
}
