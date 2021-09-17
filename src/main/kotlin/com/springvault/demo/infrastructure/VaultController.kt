package com.springvault.demo.infrastructure



import com.springvault.demo.application.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/rest/vault")
class VaultController() {

    @Autowired
    private val userService: UserService? = null

    @Value("\${server.port}")
    private val port: Int? = null



    @GetMapping("user/{userId}")
    fun user(@PathVariable userId: Int) : String {
        val existUser: User = userService!!.getUser(userId)
        return "${existUser.firstName!!} ${existUser.lastName!!}"

    }

}