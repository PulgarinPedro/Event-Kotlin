package com.example.prueba.repository

import com.example.prueba.model.Member
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MemberRepository  : JpaRepository<Member, Long?> {
    fun findById(id: Long?): Member?
}