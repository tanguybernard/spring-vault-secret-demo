package com.springvault.demo

import org.springframework.context.annotation.Configuration
import org.springframework.vault.annotation.VaultPropertySource

@Configuration
@VaultPropertySource(
    "secret/general/test", propertyNamePrefix = "vault.general.")
class ConfigVaultGeneralSecret