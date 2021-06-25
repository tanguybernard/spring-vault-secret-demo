# Vault Demo


## Install

### 1) Launch docker containers

    docker-compose up -d

### 2) Into docker container

    vault login vault-plaintext-root-token

    vault kv put secret/vaultdemo2 demo.username=demouser demo.password=demovault demo.url=notyetset dbusername=root dbpassword=root


NB : In production use a limited token (non-root) to get secret that you need at runtime (you can use one shot token for this)

Ex (Token created for 10min and limites to one used)

    vault token create -limit=1

_-use-limit_ (int: 0) - Number of times this token can be used. After the last use, the token is automatically revoked. By default, tokens can be used an unlimited number of times until their expiration.

Credits : https://www.vaultproject.io/docs/commands/token/create#use-limit



### 3) Into mysql container

    create database dbtest;

    CREATE TABLE users ( id smallint unsigned not null auto_increment, first_name varchar(20), last_name varchar(20), constraint pk_example primary key (id) );
    
    INSERT INTO users ( first_name, last_name ) VALUES ( 'John', 'Doeremifasollasi' );

### 4) Launch Springboot app with vault token as environment variable

    SPRING_CLOUD_VAULT_TOKEN=vault-plaintext-root-token

## Tips and Tricks

Get secret with curl command

    curl -H "X-Vault-Token: vault-plaintext-root-token" -X GET  http://127.0.0.1:8200/v1/secret/data/hello


## Credits

https://medium.com/@Ankitthakur/spring-boot-spring-vault-e9e973a17036

https://examples.javacodegeeks.com/an-intro-to-spring-cloud-vault/
