package com.fds.v1.database.edge;

import com.fds.v1.database.node.DiscordUser;
import com.fds.v1.lib.Common;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.TargetNode;

import java.util.UUID;


public class LinkedWith {

    public LinkedWith() {
        this.id = Common.uuid("linked-with");
    }

    @Id
    private String id;

    @TargetNode
    private DiscordUser discordUser;

    @Property
    private long linkedAt;

    @Property
    private String linkedByName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public DiscordUser getDiscordUser() {
        return discordUser;
    }

    public void setDiscordUser(DiscordUser discordUser) {
        this.discordUser = discordUser;
    }

    public long getLinkedAt() {
        return linkedAt;
    }

    public void setLinkedAt(long linkedAt) {
        this.linkedAt = linkedAt;
    }

    public String getLinkedByName() {
        return linkedByName;
    }

    public void setLinkedByName(String linkedByName) {
        this.linkedByName = linkedByName;
    }
}
