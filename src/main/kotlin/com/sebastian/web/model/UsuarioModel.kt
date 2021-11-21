package com.sebastian.web.model
import javax.persistence.*

    @Entity
    @Table(name = "usuario")
    class UsuarioModel{
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Id
        @Column(updatable = false)
        var id: Long? = null
        var user: String? = null
    }