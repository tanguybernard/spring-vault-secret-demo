package com.springvault.demo.configuration

import org.springframework.context.annotation.Configuration
import org.springframework.vault.annotation.VaultPropertySource

@Configuration
@VaultPropertySource(
    "secret/general", propertyNamePrefix = "vault.general.")
class ConfigVaultGeneralSecret