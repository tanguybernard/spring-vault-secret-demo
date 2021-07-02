package com.springvault.demo

import org.springframework.context.annotation.Configuration
import org.springframework.vault.annotation.VaultPropertySource

@Configuration
@VaultPropertySource(
    "secret/db/preprod", propertyNamePrefix = "db.preprod."
)
class ConfigVaultDbSecret