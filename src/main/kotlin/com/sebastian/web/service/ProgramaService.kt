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
            } catch(ex:Exception){
                throw ResponseStatusException(
                    HttpStatus.NOT_FOUND, ex.message
                )
            }
        }


        fun update(programa:ProgramaModel):ProgramaModel{
            return programaRepository.save(programa)
        }

        fun updatePrograma (programa: ProgramaModel):ProgramaModel {
            try {
                programa.nombrePrograma?.trim()?.isEmpty()
                    ?: throw java.lang.Exception("Programa no puede estar vacio")
                val response = programaRepository.findById(programa.id)
                    ?: throw Exception()
                response.apply {
                    this.nombrePrograma = programa.nombrePrograma
                }
                return programaRepository.save(response)
            } catch (ex:Exception){
                throw ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Programa no encontrado", ex)
            }
        }


        fun delete (id:Long): Boolean{
            programaRepository.deleteById(id)
            return true
        }

    fun verifyWord(nombrePrograma: String?):Boolean{
        if (nombrePrograma?.length!!<3){
            return false
        }
        return true
    }

    }