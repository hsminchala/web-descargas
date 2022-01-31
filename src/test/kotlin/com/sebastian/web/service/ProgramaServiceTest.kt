package com.sebastian.web.service

import com.google.gson.Gson
import com.sebastian.web.model.ProgramaModel
import com.sebastian.web.repository.DescargasRepository
import com.sebastian.web.repository.ProgramaRepository
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.springframework.boot.test.context.SpringBootTest
import java.io.File

@SpringBootTest
class ProgramaServiceTest {

    @InjectMocks
    lateinit var programaService: ProgramaService

    @Mock
    lateinit var programaRepository: ProgramaRepository


    val jsonString = File("./src/test/resources/programa/createPrograma.json").readText(Charsets.UTF_8)
    val programaMock = Gson().fromJson(jsonString, ProgramaModel::class.java)


    val returnObject: ProgramaModel = ProgramaModel().apply {
        id = 1
        nombrePrograma = "Jupiter"
        version = "5.4.2"
    }
    val newObject: ProgramaModel = ProgramaModel().apply {
        id = 1
        nombrePrograma = "Jupiter"
        version = "5.4.2"
    }


    @Test
    fun createPrograma() {
        Mockito.`when`(programaRepository.save(Mockito.any(ProgramaModel::class.java))).thenReturn(programaMock)
        val response = programaService.save(programaMock)
        Assertions.assertEquals(response.id, programaMock.id)
        Assertions.assertEquals(response.nombrePrograma, programaMock.nombrePrograma)
    }

    @Test
    fun createProgramaFailed() {
        Assertions.assertThrows(Exception::class.java) {
            programaMock.apply {
                nombrePrograma = " "
            }
            Mockito.`when`(programaRepository.save(Mockito.any(ProgramaModel::class.java))).thenReturn(programaMock)
            programaService.save(programaMock)
        }
    }

    @Test
    fun updateIsCorrect() {
        Mockito.`when`(programaRepository.findById(newObject.id)).thenReturn(returnObject)
        Mockito.`when`(programaRepository.save(Mockito.any(ProgramaModel::class.java))).thenReturn(returnObject)
        val response = programaService.update(newObject)
        Assertions.assertEquals(response.id, returnObject.id)
        Assertions.assertEquals(response.nombrePrograma, returnObject.nombrePrograma)
    }



    @Test
    fun updateIsNotExistFailed() {
        Assertions.assertThrows(Exception::class.java) {
            Mockito.`when`(programaRepository.findById(returnObject.id)).thenReturn(null)
            Mockito.`when`(programaRepository.save(Mockito.any(ProgramaModel::class.java))).thenReturn(returnObject)
            programaService.update(newObject)
        }
    }


    @Test
    fun updateIsIncorrectNombre() {
        Assertions.assertThrows(Exception::class.java) {
            programaMock.apply { nombrePrograma = "  " }
            Mockito.`when`(programaRepository.findById(returnObject.id)).thenReturn(programaMock)
            Mockito.`when`(programaRepository.save(Mockito.any(ProgramaModel::class.java))).thenReturn(programaMock)
            programaService.update(programaMock)
        }
    }

    @Test
    fun updateNombrePrograma(){
        Mockito.`when`(programaRepository.findById(newObject.id)).thenReturn(returnObject)
        Mockito.`when`(programaRepository.save(Mockito.any(ProgramaModel::class.java))).thenReturn(returnObject)
        val response = programaService.updatePrograma(newObject)
        Assertions.assertEquals(response.id, returnObject.id)
        Assertions.assertEquals(response.nombrePrograma, returnObject.nombrePrograma)
    }

    @Test
    fun updateIsIncorrectNombrePrograma() {
        Assertions.assertThrows(Exception::class.java) {
            programaMock.apply { nombrePrograma = "  " }
            Mockito.`when`(programaRepository.findById(returnObject.id)).thenReturn(programaMock)
            Mockito.`when`(programaRepository.save(Mockito.any(ProgramaModel::class.java))).thenReturn(programaMock)
            programaService.updatePrograma(programaMock)
        }
    }


//    @Test
//    fun delete(){
//        Mockito.`when`(programaRepository.findById(newObject.id)).thenReturn(returnObject)
//                Mockito.`when`(programaRepository.deleteById(newObject.id!!))
//        val response = programaService.delete(returnObject.id!!)
//        Assertions.assertEquals(response,true)
//    }

}
