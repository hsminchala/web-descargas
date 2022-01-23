package com.sebastian.web.service

import com.sebastian.web.model.DescargasModel
import com.sebastian.web.model.UsuarioModel
import com.sebastian.web.repository.DescargasRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class DescargasService {
    @Autowired
    lateinit var descargasRepository: DescargasRepository


    fun list(): List<DescargasModel> {
        return descargasRepository.findAll()
    }

    fun save(descargas: DescargasModel): DescargasModel {
        try {
            descargas.nDescarga?.takeIf { it.trim().isNotEmpty() }
                ?: throw Exception("Descargas no debe ser vacio")
            descargas.fechaDescarga?.takeIf { it.trim().isNotEmpty() }
                ?: throw Exception("Fecha de descarga no debe ser vacio")
            return descargasRepository.save(descargas)
        } catch(ex:Exception){
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND, ex.message
            )
        }
    }

    fun update(descargas: DescargasModel): DescargasModel {
        return descargasRepository.save(descargas)
    }

        fun updateNdescarga(descargas: DescargasModel): DescargasModel {
            try {
                descargas.nDescarga?.trim()?.isEmpty()
                    ?: throw java.lang.Exception("El numero de descarga no puede estar vacio")
                val response = descargasRepository.findById(descargas.id)
                    ?: throw Exception()
                response.apply {
                    this.nDescarga = descargas.nDescarga
                }
                return descargasRepository.save(response)
            } catch (ex:Exception){
                throw ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Descargas no encontrada", ex)
            }
        }


    fun delete (id:Long): Boolean{
        descargasRepository.deleteById(id)
        return true
    }
}