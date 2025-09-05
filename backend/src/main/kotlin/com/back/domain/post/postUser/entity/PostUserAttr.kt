package com.back.domain.post.postUser.entity

import com.back.global.jpa.entity.BaseTime
import jakarta.persistence.*

@Entity
@Table(
    uniqueConstraints = [
        UniqueConstraint(columnNames = ["subject_id", "name"])
    ]
)
class PostUserAttr(
    @field:ManyToOne
    @field:JoinColumn(name = "subject_id")
    val subject: PostUser,
    val name: String,
    @field:Column(name = "val", columnDefinition = "TEXT") var value: String,
) : BaseTime() {

}
