package com.sebastian.web.model

import javax.annotation.processing.Generated
import javax.persistence.*

    @Entity
    @Table(name = "descargas")
    class DescargasModel {
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Id
        @Column(updatable = false)
        var id: Long? = null
        var nDescarga: String? = null
}