package com.sebastian.web.service

import UsuarioRepository
import com.sebastian.web.model.UsuarioModel
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
            val response = usuarioRepository.findById(usuario.id)
                ?: throw Exception()
            response.apply {
                this.user=usuario.user
            }
            return usuarioRepository.save(usuario)
        }

        fun delete (id:Long): Boolean{
            usuarioRepository.deleteById(id)
            return true
        }
    }