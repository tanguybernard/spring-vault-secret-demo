package com.springvault.demo

import org.springframework.beans.factory.annotation.Autowired
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

    @Value("\${db.preprod.login}")
    var loginPreprod: String? = null

    @Value("\${vault.general.demo.password}")
    private val password: String? = null

    @Value("\${vault.general.demo.url}")
    private val url: String? = null

    @PostConstruct
    fun postConstruct() {
        println("##########################")
        println(dbusername)
        println(password)
        println(url)
        println(loginPreprod)

        println("##########################")
    }
}

fun main(args: Array<String>) {
    runApplication<DemoApplication>(*args)
}
