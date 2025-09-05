package com.back.domain.post.postUser.entity

import com.back.global.jpa.entity.BaseTime
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.ManyToOne

@Entity
class PostUserAttr(
    @field:ManyToOne val subject: PostUser,
    val name: String,
    @field:Column(name = "val", columnDefinition = "TEXT") var value: String,
) : BaseTime() {

}
