package com.fds.v1.database.node;

import com.fds.v1.lib.Common;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Node
public class User {
    public User() {
        this.id = Common.uuid("mojang-account");
    }

    @Id
    private String id;
    private String email;
    private String password;
    private long createdAt;
}
