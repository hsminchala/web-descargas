package com.sebastian.web.model

import javax.persistence.*

@Entity
@Table(name = "programa")
class ProgramaModel {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    @Column(name = "nombre_programa")
    var nombrePrograma: String? = null
    var version: String? = null
}