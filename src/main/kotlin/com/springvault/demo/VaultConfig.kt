package com.springvault.demo

/*
@Configuration
@VaultPropertySource("secret/vaultdemo2")
class VaultConfig {

    @Value("\${spring.datasource.password}")
    val dbpassword: String = "root"
}*/


import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.cloud.vault.config.VaultConfigurer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

import org.springframework.vault.authentication.ClientAuthentication
import org.springframework.vault.authentication.TokenAuthentication
import org.springframework.vault.client.VaultEndpoint
import org.springframework.vault.config.AbstractVaultConfiguration
import java.net.URI



@Configuration
class VaultConfig: AbstractVaultConfiguration() {

    override fun vaultEndpoint(): VaultEndpoint {
        return VaultEndpoint.from(environment.getRequiredProperty("spring.cloud.vault.uri", URI::class.java))

        //return VaultEndpoint.from(URI("http://127.0.0.1:8200"))
    }

    override fun clientAuthentication(): ClientAuthentication {
        return TokenAuthentication(environment.getRequiredProperty("spring.cloud.vault.token"));
    }
}
