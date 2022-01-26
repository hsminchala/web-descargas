package com.sebastian.web.service

import com.sebastian.web.model.ProgramaModel
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

        fun update(usuario:UsuarioModel):UsuarioModel{
            try {
                usuario.user?.takeIf { it.trim().isNotEmpty() }
                    ?: throw Exception("Usuario esta vacio")
                val response = usuarioRepository.findById(usuario.id)
                    ?: throw Exception()
                return usuarioRepository.save(response)
            } catch (ex:Exception){
                throw ResponseStatusException(
                    HttpStatus.NOT_FOUND, "No se ha actualizado, revise todos los campos", ex)
            }
        }

    fun save(usuario: UsuarioModel): UsuarioModel {
        try {
            usuario.user?.takeIf { it.trim().isNotEmpty() }
                ?: throw Exception("Usuario no debe ser vacio")
            return usuarioRepository.save(usuario)
        } catch(ex:Exception){
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND, ex.message
            )
        }
    }

        fun updateUser (usuario:UsuarioModel):UsuarioModel {
            try {
                usuario.user?.takeIf { it.trim().isNotEmpty() }
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