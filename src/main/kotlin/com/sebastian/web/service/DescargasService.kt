package com.sebastian.web.service

import com.sebastian.web.model.DescargasModel
import com.sebastian.web.model.UsuarioModel
import com.sebastian.web.repository.DescargasRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class DescargasService {
    @Autowired
    lateinit var descargasRepository: DescargasRepository


    fun list(): List<DescargasModel> {
        return descargasRepository.findAll()
    }

    fun update(descargas: DescargasModel): DescargasModel {
        return descargasRepository.save(usuario)
    }

    fun updateUser (descargas: DescargasModel): DescargasModel {
        val response = descargasRepository.findById(descargas.id)
            ?: throw Exception()
        response.apply {
            this.user=descargas.user
        }
        return descargasRepository.save(descargas)
    }

    fun delete (id:Long): Boolean{
        descargasRepository.deleteById(id)
        return true
    }
}