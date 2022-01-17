package com.sebastian.web.service

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class UserServiceTest {

    @Autowired
    lateinit var usersService: UsersService


    @Test
    fun substractFromNextTen(){
        val response = usersService.substractFromNextTen(47)
        Assertions.assertEquals(3,response)
    }

    @Test
    fun NotsubstractFromNextTen(){
        val response = usersService.substractFromNextTen(0)
        Assertions.assertEquals(10,response)
    }

    @Test
    fun ValidarCedula(){
        val response = usersService.validarCedula("0150265759")
        Assertions.assertEquals(true,response)
    }
    
        @Test
    fun ValidarCedulaFalso(){
        val response = usersService.validarCedula("0150265755")
        Assertions.assertEquals(false,response)
    }

}
