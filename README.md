# Vault Demo


## Install

### 1) Launch docker containers

    docker-compose up -d

### 2) Into docker container

    vault login vault-plaintext-root-token

    vault kv put secret/db/test demo.username=root demo.password=mySuperPassword1234!

    vault kv put secret/general login=toto aws_preprod_key=azertyYolo1234 url=https://github.com/tanguybernard/spring-vault-secret-demo

NB : In production use a limited token (non-root) to get secret that you need at runtime (you can limit usage of token for example)

Ex (Token created for 10min and limit usage)

    vault token create -use-limit=3

_-use-limit_ (int: 0) - Number of times this token can be used. After the last use, the token is automatically revoked. By default, tokens can be used an unlimited number of times until their expiration.

NB : Spring Vault use token to check settings and for each route declared. So if you have 2 routes, limit the usage of this token to 3 for example.

Credits : https://www.vaultproject.io/docs/commands/token/create#use-limit

### 3) Launch Springboot app with vault token as environment variable

    SPRING_CLOUD_VAULT_TOKEN=vault-plaintext-root-token

## Tips and Tricks

Get secret with curl command

    curl -H "X-Vault-Token: vault-plaintext-root-token" -X GET  http://127.0.0.1:8200/v1/secret/data/hello


## Credits

https://medium.com/@Ankitthakur/spring-boot-spring-vault-e9e973a17036

https://examples.javacodegeeks.com/an-intro-to-spring-cloud-vault/

https://www.it-swarm-fr.com/fr/java/spring-boot-comment-masquer-les-mots-de-passe-dans-le-fichier-de-proprietes/826180111/
