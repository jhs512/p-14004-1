package com.back.domain.post.postUser.entity

import com.back.domain.member.member.entity.Member
import com.back.global.jpa.entity.BaseTime
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table

@Entity
@Table(name = "MEMBER")
class PostUser(
    id: Int,
    @Column(name = "nickname") var name: String,
) : BaseTime(id) {
    constructor(member: Member) : this(
        member.id,
        member.nickname,
    ) {

    }
}
