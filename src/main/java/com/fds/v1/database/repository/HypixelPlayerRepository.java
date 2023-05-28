package com.fds.v1.database.repository;

import com.fds.v1.database.node.DiscordUser;
import com.fds.v1.database.node.HypixelPlayer;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface HypixelPlayerRepository extends Neo4jRepository<DiscordUser, String> {
    @Query("MATCH (p:HypixelPlayer) WHERE p.name = $name RETURN p")
    HypixelPlayer getByName(@Param("name") String name);

    @Query("MATCH (p:HypixelPlayer) WHERE p.id = $id RETURN p")
    HypixelPlayer getById(String id);

    @Query("MATCH (h:HypixelPlayer) WHERE h.id = $id SET h = hypixelPlayer RETURN h")
    HypixelPlayer updateById(@Param("id") String id, @Param("hypixelPlayer") HypixelPlayer hypixelPlayer);

    @Query("MATCH (h:HypixelPlayer) WHERE h.id = $id DELETE h RETURN h")
    HypixelPlayer removeById(@Param("id") String id);

    HypixelPlayer save(HypixelPlayer hypixelPlayer);
}
