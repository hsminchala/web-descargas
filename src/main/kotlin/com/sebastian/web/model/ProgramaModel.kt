package com.sebastian.web.model

import javax.persistence.*

@Entity
@Table(name = "programa")
class ProgramaModel {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    var version: String? = null
}