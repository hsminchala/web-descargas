package com.sebastian.web.controllers

import com.sebastian.web.model.ProgramaModel
import com.sebastian.web.service.ProgramaService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/entidad")
@CrossOrigin(methods = [RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH, RequestMethod.PUT])

class ProgramaController {
    @Autowired
    lateinit var programaService: ProgramaService

    @GetMapping
    fun list(): List<ProgramaModel>{
        return programaService.list()
    }

    @PutMapping
    fun update (@RequestBody customerAll: ProgramaModel): ProgramaModel {
        return programaService.update(customerAll)
    }

    @PatchMapping
    fun patch(@RequestBody programa: ProgramaModel): ProgramaModel {
        return programaService.updateVersion(programa)
    }

    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long):Boolean{
        return programaService.delete(id)
    }
}