package com.fds.v1.database.edge;

import com.fds.v1.database.node.HypixelPlayer;
import com.fds.v1.lib.Common;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.TargetNode;

public class PlayedUsing {
    public PlayedUsing() {
        this.id = Common.uuid("played-using");
    }

    @Id
    private String id;
    @Property
    private long registeredAt;
    @TargetNode
    private HypixelPlayer hypixelPlayer;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getRegisteredAt() {
        return registeredAt;
    }

    public void setRegisteredAt(long registeredAt) {
        this.registeredAt = registeredAt;
    }

    public HypixelPlayer getHypixelPlayer() {
        return hypixelPlayer;
    }

    public void setHypixelPlayer(HypixelPlayer hypixelPlayer) {
        this.hypixelPlayer = hypixelPlayer;
    }
}
