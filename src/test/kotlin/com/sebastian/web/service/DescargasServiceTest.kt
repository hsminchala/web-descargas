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


    val returnObject: DescargasModel = DescargasModel().apply {
        id = 1
        nDescarga = "45"
        fechaDescarga = "25/01/2022"
    }
    val newObject: DescargasModel = DescargasModel().apply {
        id = 1
        nDescarga = "45"
        fechaDescarga = "25/01/2022"
    }


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

    @Test
    fun updateIsCorrect() {
        Mockito.`when`(descargasRepository.findById(newObject.id)).thenReturn(returnObject)
        Mockito.`when`(descargasRepository.save(Mockito.any(DescargasModel::class.java))).thenReturn(returnObject)
        val response = descargasService.update(newObject)
        Assertions.assertEquals(response.id, returnObject.id)
        Assertions.assertEquals(response.nDescarga, returnObject.nDescarga)
    }

    @Test
    fun updateIsNotExistFailed() {
        Assertions.assertThrows(Exception::class.java) {
            Mockito.`when`(descargasRepository.findById(returnObject.id)).thenReturn(null)
            Mockito.`when`(descargasRepository.save(Mockito.any(DescargasModel::class.java))).thenReturn(returnObject)
            descargasService.update(newObject)
        }
    }

    @Test
    fun updateIsIncorrectNumber() {
        Assertions.assertThrows(Exception::class.java) {
            descargasMock.apply { nDescarga = " " }
            Mockito.`when`(descargasRepository.findById(returnObject.id)).thenReturn(descargasMock)
            Mockito.`when`(descargasRepository.save(Mockito.any(DescargasModel::class.java))).thenReturn(descargasMock)
            descargasService.update(descargasMock)
        }
    }

    @Test
    fun updateNumberDownload() {
        Mockito.`when`(descargasRepository.findById(newObject.id)).thenReturn(returnObject)
        Mockito.`when`(descargasRepository.save(Mockito.any(DescargasModel::class.java))).thenReturn(returnObject)
        val response = descargasService.updateNdescarga(newObject)
        Assertions.assertEquals(response.id, returnObject.id)
        Assertions.assertEquals(response.nDescarga, returnObject.nDescarga)
    }

    @Test
    fun updateIncorrectNumberDownload() {
        Assertions.assertThrows(Exception::class.java) {
            descargasMock.apply { nDescarga = "  " }
            Mockito.`when`(descargasRepository.findById(returnObject.id)).thenReturn(descargasMock)
            Mockito.`when`(descargasRepository.save(Mockito.any(DescargasModel::class.java))).thenReturn(descargasMock)
            descargasService.updateNdescarga(descargasMock)
        }
    }

}