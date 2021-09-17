package com.springvault.demo.infrastructure

import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Int>