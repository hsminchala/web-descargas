package com.sebastian.web.repository
import com.sebastian.web.model.UsuarioModel
import org.springframework.data.jpa.repository.JpaRepository

interface UsuarioRepository:JpaRepository<UsuarioModel, Long> {
    fun findById(id:Long?):UsuarioModel?
}