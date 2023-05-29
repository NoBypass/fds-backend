# FDS-Backend

## Contents
- [FDS-Backend](#fds-backend)
    - [Contents](#contents)
    - [Stack](#stack)
    - [Getting Started](#getting-started)
      - [Prerequisites](#prerequisites)
      - [Run](#run)
    - [API](#api)
      - [GraphQL](#graphql)
        - [Queries](#queries)
        - [Mutations](#mutations)
      - [REST](#rest)
      - [WebSocket](#websocket)
      - [Authentication](#authentication)
  - [Contact](#contact)

***

## Stack
- Java 17 (Gradle)
- Spring Boot
- Neo4j 5.8.0
- GraphQL

***

## Getting Started
### Prerequisites
``Java 17`` is required to run this project. [Download Java 17](https://www.oracle.com/java/technologies/downloads/#java17)\
``Neo4j Desktop`` is required to run and manage the database. [Download Neo4j Desktop](https://neo4j.com/download/)\
``Docker`` is recommended to more easily run the project. [Download Docker](https://www.docker.com/products/docker-desktop)

### Run
**Docker**: Run the following command in the root directory of the project.
```shell 
docker build -t fds-backend .
docker run --name fds-backend -p 8080:8080 -p 7474:7474 -p 7687:7687 fds-backend
```

***

## API
### GraphQL
**Route:** ``/graphql``
#### Queries
```graphql
hypixelPlayer(name: ID!): HypixelPlayer # Get a Hypixel player by their Minecraft username.
discordUser(uuid: ID!): DiscordUser # Get a Discord user by their Discord ID
```
#### Mutations
```graphql
addHypixelPlayer(name: String!): HypixelPlayer # Add a Hypixel player with their Minecraft username.
removeHypixelPlayer(id: ID!): HypixelPlayer # Remove a Hypixel player by their ID.
changeHypixelPlayer(id: ID!, name: String, isTracked: Boolean): HypixelPlayer  # Change a Hypixel player's name or tracked status.

linkDiscordUser(id: ID!): DiscordUser # Link a Discord user by their Discord ID.
unlinkDiscordUser(id: ID!): DiscordUser # Unlink a Discord user by their Discord ID.

addDiscordUser(uuid: String!): DiscordUser # Add a Discord user by their Minecraft UUID.
removeDiscordUser(id: ID!): DiscordUser # Remove a Discord user by their Discord ID.
changeDiscordUser(id: ID!, uuid: String, dailyStreak: Int, xp: Int, lastDailyAt: Int, messagesSent: Int, registeredAt: Int): DiscordUser # Change a Discord user's properties.
```

### REST
(Not implemented yet)

### WebSocket
(Not implemented yet)

### Authentication
(Not implemented yet)

***

## Contact
- [Discord Server](https://discord.gg/DCgAecjphr)
- Discord DM ``@NoBypass#0001``