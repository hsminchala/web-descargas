package com.sebastian.web.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Table
import javax.persistence.Id
import javax.persistence.Column

@Entity
@Table(name = "users")
class UsersModel {

        @Id
        @Column(updatable = false)
        var id: Long? = null
        var username: String? = null
        var password: String? = null
}