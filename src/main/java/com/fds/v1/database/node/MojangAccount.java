package com.fds.v1.database.node;

import com.fds.v1.lib.Common;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Node
public class MojangAccount {
    public MojangAccount() {
        this.id = Common.uuid("mojang-account");
    }

    public MojangAccount(String name, String uuid) {
        this.name = name;
        this.uuid = uuid;
        this.id = Common.uuid("mojang-account");
    }

    @Id
    private String id;
    private String name;
    private String uuid;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
