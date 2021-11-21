package com.sebastian.web.controllers

import com.sebastian.web.model.DescargasModel
import com.sebastian.web.service.DescargasService
import com.sebastian.web.service.ProgramaService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/entidad")
@CrossOrigin(methods = [RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH, RequestMethod.PUT])

class DescargasController { //cambio de modelo=descargas a DescargasModel

        @Autowired
        lateinit var descargasService: DescargasService

        @GetMapping
        fun list(): List<DescargasModel>{
            return descargasService.list()
        }

        @PutMapping
        fun update (@RequestBody customerAll: DescargasModel):DescargasModel{
            return DescargasService.update(customerAll)
        }

        @PatchMapping
        fun patch(@RequestBody descargas:DescargasModel):DescargasModel{
            return DescargasService.updateWeight(descargas)
        }

        @DeleteMapping("/delete/{id}")
        fun delete (@PathVariable("id") id: Long):Boolean{
            return DescargasService.delete(id)
        }

    }