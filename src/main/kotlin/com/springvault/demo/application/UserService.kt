package com.springvault.demo.application


import com.springvault.demo.infrastructure.User
import com.springvault.demo.infrastructure.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
@Transactional
class UserService {
    @Autowired
    private val userRepository: UserRepository? = null
    fun listAllUser(): List<User> {
        return userRepository!!.findAll()
    }

    fun saveUser(user: User) {
        userRepository!!.save<User>(user)
    }

    fun getUser(id: Int): User {
        return userRepository!!.findById(id).get()
    }

    fun deleteUser(id: Int) {
        userRepository!!.deleteById(id)
    }
}