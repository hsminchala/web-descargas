package com.sebastian.web.model

import javax.persistence.*

class UsersModel {
    @Entity
    @Table(name = "users")
    class UsuariosModel{
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Id
        @Column(updatable = false)
        var id: Long? = null
        var username: String? = null
        var password: String? = null
    }
}