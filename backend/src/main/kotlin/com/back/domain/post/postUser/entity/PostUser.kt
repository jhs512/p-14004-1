package com.back.domain.post.postUser.entity

import com.back.domain.member.member.entity.Member
import com.back.global.jpa.entity.BaseTime
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table
import org.hibernate.annotations.NaturalId

@Entity
@Table(name = "MEMBER")
class PostUser(
    id: Int,
    @NaturalId @field:Column(unique = true) val username: String,
    @Column(name = "nickname") var name: String,
    @Column(columnDefinition = "INT DEFAULT 0") var postsCount: Int = 0,
    @Column(columnDefinition = "INT DEFAULT 0") var postCommentsCount: Int = 0,
) : BaseTime(id) {
    constructor(member: Member) : this(
        member.id,
        member.username,
        member.nickname,
    ) {

    }

    fun incrementPostsCount() = postsCount++

    fun decrementPostsCount() = postsCount--

    fun incrementPostCommentsCount() = postCommentsCount++

    fun decrementPostCommentsCount() = postCommentsCount--
}
