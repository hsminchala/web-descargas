package com.sebastian.web.service
import com.sebastian.web.model.DescargasModel
import com.sebastian.web.model.ProgramaModel
import com.sebastian.web.repository.DescargasRepository
import com.sebastian.web.repository.ProgramaRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class ProgramaService {
    @Autowired
    lateinit var programaRepository: ProgramaRepository


    fun list(): List<ProgramaModel> {
        return programaRepository.findAll()
    }

    fun save(programa: ProgramaModel): ProgramaModel {
        try {
            programa.nombrePrograma?.takeIf { it.trim().isNotEmpty() }
                ?: throw Exception("Nombre programa no debe ser vacio")
            programa.version?.takeIf { it.trim().isNotEmpty() }
                ?: throw Exception("Version no debe ser vacio")

            return programaRepository.save(programa)
        } catch (ex: Exception) {
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND, ex.message
            )
        }
    }


    fun update(programa: ProgramaModel): ProgramaModel {
        try {
            programa.nombrePrograma?.takeIf { it.trim().isNotEmpty() }
                ?: throw Exception("No deje campos vacios")
            programa.version?.takeIf { it.trim().isNotEmpty() }
                ?: throw Exception("No deje campos vacios")
            val response = programaRepository.findById(programa.id)
                ?: throw Exception()
            return programaRepository.save(response)
        } catch (ex: Exception) {
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND, "No se ha actualizado, revise todos los campos", ex
            )
        }
    }


    fun updatePrograma(programa: ProgramaModel): ProgramaModel {
        try {
            programa.nombrePrograma?.takeIf { it.trim().isNotEmpty() }
                ?: throw Exception("Programa no puede estar vacio")
            val response = programaRepository.findById(programa.id)
                ?: throw Exception()
            response.apply {
                this.nombrePrograma = programa.nombrePrograma
            }
            return programaRepository.save(response)
        } catch (ex: Exception) {
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND, "Programa no encontrado", ex
            )
        }
    }


    fun delete(id: Long): Boolean {
        try {
            programaRepository.findById(id)
                ?: throw Exception("No existe el id")
            programaRepository.deleteById(id!!)
            return true
        } catch (ex: Exception) {
            throw Exception()

        }

    }

    fun verifyWord(nombrePrograma: String?): Boolean {
        if (nombrePrograma?.length!! < 3) {
            return false
        }
        return true
    }

    fun validatePrograma(): Boolean {
        for (i in 0..String().length) {
            val lista = listOf<String>("Kotlin", "Java", "AHK")
        }
        return true
    }

    }