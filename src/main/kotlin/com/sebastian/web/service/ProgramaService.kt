package com.sebastian.web.service

import com.sebastian.web.model.DescargasModel
import com.sebastian.web.model.ProgramaModel
import com.sebastian.web.repository.DescargasRepository
import com.sebastian.web.repository.ProgramaRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
@Service
class ProgramaService {
        @Autowired
        lateinit var programaRepository: ProgramaRepository


        fun list(): List<ProgramaModel> { //descargas

            return programaRepository.findAll()
        }


        fun update(programa:ProgramaModel):ProgramaModel{
            return ProgramaRepository.save(programa)
        }

        fun updateDescription (programa: ProgramaModel):ProgramaModel {
            val response = programaRepository.findById(programa.id)
                ?: throw Exception()
            response.apply {
                this.description=programa.description
            }
            return programaRepository.save(programa)
        }

        fun delete (id:Long): Boolean{
            programaRepository.deleteById(id)
            return true
        }
    }