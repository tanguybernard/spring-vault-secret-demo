package com.springvault.demo.controller



import com.springvault.demo.model.User
import com.springvault.demo.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/rest/vault")
class VaultController() {

    @Autowired
    private val userService: UserService? = null


    var name = "World"

    @Value("\${server.port}")
    private val port: Int? = null



    @GetMapping("user/{userId}")
    fun user(@PathVariable userId: Int) : String {
        val existUser: User = userService!!.getUser(userId)
        return existUser.firstName!!

    }

}