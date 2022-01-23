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




}


