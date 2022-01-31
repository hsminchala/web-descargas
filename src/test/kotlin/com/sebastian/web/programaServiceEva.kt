package com.sebastian.web

import com.sebastian.web.model.ProgramaModel
import com.sebastian.web.service.ProgramaService
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class ProgramaServiceEva {

    @Autowired
    lateinit var programaService: ProgramaService

@Test
fun validatePrograma(){
val response = programaService.validatePrograma()
    Assertions.assertEquals(true, response)
}

    @Test
    fun validateProgramaFail(){
        Assertions.assertThrows(Exception::class.java) {
            val response = programaService.validatePrograma()
            Assertions.assertEquals(true, response)
        }
    }
}