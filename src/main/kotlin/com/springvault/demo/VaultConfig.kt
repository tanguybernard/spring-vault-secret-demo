package com.springvault.demo

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
    }

    override fun clientAuthentication(): ClientAuthentication {
        return TokenAuthentication(environment.getRequiredProperty("spring.cloud.vault.token"));
    }
}
