package com.sebastian.web.service

import com.sebastian.web.model.UsersModel
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service
import java.util.ArrayList

@Service
class GymUserDetailsService : UserDetailsService {
    @Autowired
    lateinit var usersService: UsersService

    override fun loadUserByUsername(username: String?): UserDetails {
        val response = usersService.getUser(username)
        return User(response?.username,"{noop}admin"+response?.password, ArrayList())
    }
}