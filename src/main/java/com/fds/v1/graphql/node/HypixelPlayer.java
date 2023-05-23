package com.fds.v1.graphql.node;

public class HypixelPlayer {
    private String id;
    private Boolean isTracked;
    private DiscordUser linkedWith;

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

    public DiscordUser getLinkedWith() {
        return linkedWith;
    }

    public void setLinkedWith(DiscordUser linkedWith) {
        this.linkedWith = linkedWith;
    }
}
