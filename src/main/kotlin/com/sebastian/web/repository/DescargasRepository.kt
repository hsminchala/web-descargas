package com.sebastian.web.repository
import com.sebastian.web.model.DescargasModel
import org.springframework.data.jpa.repository.JpaRepository

    interface DescargasRepository: JpaRepository<DescargasModel, Long> {

    }