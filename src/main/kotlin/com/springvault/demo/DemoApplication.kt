package com.springvault.demo

import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import javax.annotation.PostConstruct

@SpringBootApplication
class DemoApplication : CommandLineRunner {
    override fun run(vararg args: String?) {

    }

    @Value("\${spring.datasource.username}")
    var dbusername: String? = null

    @Value("\${vault.general.login}")
    var login: String? = null

    @Value("\${db.demo.password}")
    private val password: String? = null

    @Value("\${vault.general.url}")
    private val url: String? = null

    @PostConstruct
    fun postConstruct() {
        println("##########################")
        println(dbusername)
        println(password)
        println(url)
        println(login)
        println("##########################")
    }
}

fun main(args: Array<String>) {
    runApplication<DemoApplication>(*args)
}
