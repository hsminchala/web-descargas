package com.sebastian.web.service

import com.sebastian.web.model.UsersModel
import com.sebastian.web.repository.UsersRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class UsersService {
    @Autowired
    lateinit var usersRepository: UsersRepository


    fun list(): List<UsersModel> {
        return usersRepository.findAll()
    }

    fun getUser(username: String?): UsersModel?{
        try {
            val response = usersRepository.findByUsername(username)
                ?: throw Exception("No existe el usuario")
            return response
        } catch (ex:Exception){
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND, "User not found", ex)
        }
    }

    fun update(user: UsersModel): UsersModel {
        return usersRepository.save(user)
    }

    fun delete (id:Long): Boolean{
        usersRepository.deleteById(id)
        return true
    }
}