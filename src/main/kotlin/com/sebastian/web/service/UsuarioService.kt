package com.sebastian.web.service

import com.sebastian.web.model.UsuarioModel
import com.sebastian.web.repository.UsuarioRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

    @Service
    class UsuarioService {
        @Autowired
        lateinit var usuarioRepository: UsuarioRepository


        fun list(): List<UsuarioModel> {
            return usuarioRepository.findAll()
        }

        fun update(usuario:UsuarioModel):UsuarioModel{
            return usuarioRepository.save(usuario)
        }

        fun updateUser (usuario:UsuarioModel):UsuarioModel {
            val response = usuarioRepository.findById(usuario.id!!)
                ?: throw Exception()
            response.apply {
                this.id=usuario.id
            }
            return usuarioRepository.save(response)
        }

        fun delete (id:Long): Boolean{
            usuarioRepository.deleteById(id)
            return true
        }
    }