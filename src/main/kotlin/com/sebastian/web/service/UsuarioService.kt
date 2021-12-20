package com.sebastian.web.service

import com.sebastian.web.model.UsuarioModel
import com.sebastian.web.repository.UsuarioRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
    class UsuarioService {
        @Autowired
        lateinit var usuarioRepository: UsuarioRepository


        fun list(): List<UsuarioModel> {
            return usuarioRepository.findAll()
        }

        fun update(usuarioModel:UsuarioModel):UsuarioModel{
            return usuarioRepository.save(usuarioModel)
        }

    fun save(usuario: UsuarioModel):UsuarioModel{
        return usuarioRepository.save(usuario)
    }

        fun updateUser (usuario:UsuarioModel):UsuarioModel {
            try {
                usuario.user?.trim()?.isEmpty()
                    ?: throw java.lang.Exception("Usuario no puede estar vacio")
                val response = usuarioRepository.findById(usuario.id)
                    ?: throw Exception()
                response.apply {
                    this.user = usuario.user
                }
                return usuarioRepository.save(response)
            } catch (ex:Exception){
                throw ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Usuario no encontrado", ex)
            }
            }

        fun delete (id:Long): Boolean{
            usuarioRepository.deleteById(id)
            return true
        }
    }