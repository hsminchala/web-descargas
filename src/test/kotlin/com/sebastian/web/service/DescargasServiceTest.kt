package com.sebastian.web.service

import com.google.gson.Gson
import com.sebastian.web.model.DescargasModel
import com.sebastian.web.model.ProgramaModel
import com.sebastian.web.repository.DescargasRepository
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.springframework.boot.test.context.SpringBootTest
import java.io.File

@SpringBootTest
class DescargasServiceTest {

    @InjectMocks
    lateinit var descargasService: DescargasService

    @Mock
    lateinit var descargasRepository: DescargasRepository

    val jsonString = File("./src/test/resources/descargas/createDescargas.json").readText(Charsets.UTF_8)
    val descargasMock = Gson().fromJson(jsonString, DescargasModel::class.java)


    @Test
    fun createDescarga(){
        Mockito.`when`(descargasRepository.save(Mockito.any(DescargasModel::class.java))).thenReturn(descargasMock)
        val response = descargasService.save(descargasMock)
        Assertions.assertEquals(response.id, descargasMock.id)
        Assertions.assertEquals(response.nDescarga, descargasMock.nDescarga)
        Assertions.assertEquals(response.fechaDescarga, descargasMock.fechaDescarga)
    }

    @Test
    fun createDescargaFailed() {
        Assertions.assertThrows(Exception::class.java) {
            descargasMock.apply {
                nDescarga = " "
            }
            Mockito.`when`(descargasRepository.save(Mockito.any(DescargasModel::class.java))).thenReturn(descargasMock)
            descargasService.save(descargasMock)
        }
    }

}