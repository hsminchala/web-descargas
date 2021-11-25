package com.sebastian.web.controllers

import com.sebastian.web.model.DescargasModel
import com.sebastian.web.service.DescargasService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/descargas")
@CrossOrigin(methods = [RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH, RequestMethod.PUT])

class DescargasController { //cambio de modelo=descargas a DescargasModel

        @Autowired
        lateinit var descargasService: DescargasService

        @GetMapping
        fun list(): List<DescargasModel>{
            return descargasService.list()
        }

        @PutMapping
        fun update (@RequestBody descargas: DescargasModel):DescargasModel{
            return descargasService.update(descargas)
        }

        @PatchMapping
        fun patch(@RequestBody descargas:DescargasModel):DescargasModel{
            return descargasService.updateNdescarga(descargas)
        }

        @DeleteMapping("/delete/{id}")
        fun delete (@PathVariable("id") id: Long):Boolean{
            return descargasService.delete(id)
        }
    }