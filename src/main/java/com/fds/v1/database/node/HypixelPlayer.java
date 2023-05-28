package com.fds.v1.database.node;

import com.fds.v1.database.edge.LinkedWith;
import com.fds.v1.lib.Common;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.UUID;

@Node
public class HypixelPlayer {

    public HypixelPlayer(Boolean isTracked) {
        this.isTracked = isTracked;
    }

    public HypixelPlayer() {
        this.id = Common.uuid("hypixel-player");
    }

    @Id
    private String id;
    private Boolean isTracked;
    @Relationship("LINKED_WITH")
    private LinkedWith linkedWith;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Boolean getTracked() {
        return isTracked;
    }

    public void setTracked(Boolean tracked) {
        isTracked = tracked;
    }

    public LinkedWith getLinkedWith() {
        return linkedWith;
    }

    public void setLinkedWith(LinkedWith linkedWith) {
        this.linkedWith = linkedWith;
    }
}
