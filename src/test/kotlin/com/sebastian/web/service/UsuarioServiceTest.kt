package com.sebastian.web.service

import com.google.gson.Gson
import com.sebastian.web.model.ProgramaModel
import com.sebastian.web.model.UsuarioModel
import com.sebastian.web.repository.UsuarioRepository
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.springframework.boot.test.context.SpringBootTest
import java.io.File

@SpringBootTest
class UsuarioServiceTest {

    @InjectMocks
    lateinit var usuarioService: UsuarioService

    @Mock
    lateinit var usuarioRepository: UsuarioRepository


    val jsonString = File("./src/test/resources/usuario/createUsuario.json").readText(Charsets.UTF_8)
    val usuarioMock = Gson().fromJson(jsonString, UsuarioModel::class.java)

    val returnObject: UsuarioModel = UsuarioModel().apply {
        id = 1
        user = "Julio"
    }
    val newObject: UsuarioModel = UsuarioModel().apply {
        id = 1
        user = "Julio"
    }


    @Test
    fun createUsuario() {
        Mockito.`when`(usuarioRepository.save(Mockito.any(UsuarioModel::class.java))).thenReturn(usuarioMock)
        val response = usuarioService.save(usuarioMock)
        Assertions.assertEquals(response.id, usuarioMock.id)
        Assertions.assertEquals(response.user, usuarioMock.user)
    }

    @Test
    fun createUsuarioFailed() {
        Assertions.assertThrows(Exception::class.java) {
            usuarioMock.apply {
                user = " "
            }
            Mockito.`when`(usuarioRepository.save(Mockito.any(UsuarioModel::class.java))).thenReturn(usuarioMock)
            usuarioService.save(usuarioMock)
        }
    }

    @Test
    fun updateIsCorrect() {
        Mockito.`when`(usuarioRepository.findById(newObject.id)).thenReturn(returnObject)
        Mockito.`when`(usuarioRepository.save(Mockito.any(UsuarioModel::class.java))).thenReturn(returnObject)
        val response = usuarioService.update(newObject)
        Assertions.assertEquals(response.id, returnObject.id)
        Assertions.assertEquals(response.user, returnObject.user)
    }

    @Test
    fun updateNotExistFailed() {
        Assertions.assertThrows(Exception::class.java) {
            Mockito.`when`(usuarioRepository.findById(returnObject.id)).thenReturn(null)
            Mockito.`when`(usuarioRepository.save(Mockito.any(UsuarioModel::class.java))).thenReturn(returnObject)
            usuarioService.update(newObject)
        }
    }

    @Test
    fun updateUser(){
        Mockito.`when`(usuarioRepository.findById(newObject.id)).thenReturn(returnObject)
        Mockito.`when`(usuarioRepository.save(Mockito.any(UsuarioModel::class.java))).thenReturn(returnObject)
        val response = usuarioService.updateUser(newObject)
        Assertions.assertEquals(response.id, returnObject.id)
        Assertions.assertEquals(response.user, returnObject.user)
    }


    @Test
    fun updateIsIncorrectUser() {
        Assertions.assertThrows(Exception::class.java) {
            usuarioMock.apply { user = "  " }
            Mockito.`when`(usuarioRepository.findById(returnObject.id)).thenReturn(usuarioMock)
            Mockito.`when`(usuarioRepository.save(Mockito.any(UsuarioModel::class.java))).thenReturn(usuarioMock)
            usuarioService.updateUser(usuarioMock)
        }
    }



}


