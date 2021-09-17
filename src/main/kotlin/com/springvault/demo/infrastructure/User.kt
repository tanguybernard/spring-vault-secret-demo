package com.springvault.demo.infrastructure

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id


@Entity
@javax.persistence.Table(name="users")
data class User(
    @Id @GeneratedValue var id: Int? = null,
    @Column(name="first_name") var firstName: String? = null,
    @Column(name="last_name") var lastName: String? = null)