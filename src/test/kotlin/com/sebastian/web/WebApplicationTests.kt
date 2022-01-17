package com.sebastian.web

import com.sebastian.web.service.ProgramaService
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class WebApplicationTests {

	@Autowired
	lateinit var programaService: ProgramaService

	@Test
	fun contextLoads() {

	}
	@Test
	fun verifySizeWordWhenIsIncorrect(){
		val response: Boolean = programaService.verifyWord("J")
		Assertions.assertEquals(false,response)
	}

	@Test
	fun verifySizeWordWhenIsCorrect(){
		val response: Boolean = programaService.verifyWord("Jajaja... te cache hermanito")
		Assertions.assertEquals(true,response)
	}
}
