# Vault Demo


## Install

### 1) Launch docker containers

    docker-compose up -d

### 2) Into docker container

#### Create secret

    vault login vault-plaintext-root-token

    vault kv put secret/db/test demo.username=root demo.password=mySuperPassword1234!

    vault kv put secret/general login=toto aws_preprod_key=azertyYolo1234 url=https://github.com/tanguybernard/spring-vault-secret-demo

NB : In production use a limited token (non-root) to get secret that you need at runtime (you can limit usage of token for example)

Ex (Token created for 10min and limit usage)

    vault token create -use-limit=3

_-use-limit_ (int: 0) - Number of times this token can be used. After the last use, the token is automatically revoked. By default, tokens can be used an unlimited number of times until their expiration.

NB : Spring Vault use token to check settings and for each route declared. So if you have 2 routes, limit the usage of this token to 3 for example.

Credits : https://www.vaultproject.io/docs/commands/token/create#use-limit


#### Policy

KV v2 backend for secret storage, the policy structures are slightly different.
I ended up having to specify secret/metadata/ for listing permissions and secret/data/ for create/update/read

e.g :

    path "secret/*" {
    capabilities = ["list",]
    }
    
    path "secret/data/db/*" {
    capabilities = ["read", "list"]
    }


source: https://serverfault.com/questions/978445/hashicorp-vault-policy-restricting-one-specific-sub-node-in-a-path


### 3) Launch Springboot app with vault token as environment variable

    SPRING_CLOUD_VAULT_TOKEN=vault-plaintext-root-token


### 4) 

Enable plugin database

    vault secrets enable database

Configure

    vault write database/config/my-mysql-database \
    plugin_name=mysql-database-plugin \
    connection_url="{{username}}:{{password}}@tcp(db-test-spring:3306)/" \
    allowed_roles="my-role" \
    username="root" \
    password="mySuperPassword1234!"

Create role

    vault write database/roles/my-role \
    db_name=my-mysql-database \
    creation_statements="CREATE USER '{{name}}'@'%' IDENTIFIED BY '{{password}}';GRANT SELECT ON *.* TO '{{name}}'@'%';" \
    default_ttl="1h" \
    max_ttl="24h"


Get credentials

    vault read database/creds/my-role

Try:

    update users set first_name=Tom where id=1;


## Tips and Tricks

Get secret with curl command

    curl -H "X-Vault-Token: vault-plaintext-root-token" -X GET  http://127.0.0.1:8200/v1/secret/data/hello


## Credits

https://medium.com/@Ankitthakur/spring-boot-spring-vault-e9e973a17036

https://examples.javacodegeeks.com/an-intro-to-spring-cloud-vault/

https://www.it-swarm-fr.com/fr/java/spring-boot-comment-masquer-les-mots-de-passe-dans-le-fichier-de-proprietes/826180111/
