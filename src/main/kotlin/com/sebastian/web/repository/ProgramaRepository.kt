package com.sebastian.web.repository

import com.sebastian.web.model.ProgramaModel
import org.springframework.data.jpa.repository.JpaRepository

    interface ProgramaRepository: JpaRepository<ProgramaModel, Long> {

    }