package com.fds.v1.database.repository;

import com.fds.v1.database.node.MojangAccount;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;

public interface MojangAccountRepository extends Neo4jRepository<MojangAccount, String> {
    MojangAccount findByName(String name);
    @Query("MATCH (m:MojangAccount) WHERE m.id = $id SET m.name = name RETURN m")
    MojangAccount changeName(@Param("id") String id, @Param("name") String name);
}
