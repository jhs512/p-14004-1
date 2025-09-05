package com.back.domain.post.postUser.entity

import com.back.global.jpa.entity.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.ManyToOne

@Entity
class PostUserAttr(
    @field:ManyToOne(fetch = FetchType.LAZY) val subject: PostUser,
    val name: String,
    @field:Column(name = "val", columnDefinition = "TEXT") var value: String = "",
) : BaseEntity() {
    fun increment(amount: Int) {
        val newValue = (value.toIntOrNull() ?: 0) + amount
        value = newValue.toString()
    }

    fun decrement(amount: Int) {
        val newValue = (value.toIntOrNull() ?: 0) - amount
        value = newValue.toString()
    }
}
