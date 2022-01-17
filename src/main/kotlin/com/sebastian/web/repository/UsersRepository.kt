package com.sebastian.web.repository
import com.sebastian.web.model.UsersModel
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface UsersRepository:JpaRepository<UsersModel, Long> {
    fun findById(id:Long?):UsersModel?
    @Query(value = "SELECT * FROM USERS u WHERE u.username = :username",
        nativeQuery = true)
    fun findByUsername(username:String?):UsersModel?
}