package com.back.domain.post.postUser.service

import com.back.domain.post.postUser.entity.PostUser
import com.back.domain.post.postUser.entity.PostUserAttr
import com.back.domain.post.postUser.repository.PostUserAttrRepository
import org.springframework.stereotype.Service

enum class PostUserAttrName {
    POSTS_COUNT,
    POST_COMMENTS_COUNT,
}

@Service
class PostUserAttrService(
    private val postUserAttrRepository: PostUserAttrRepository,
) {
    fun getPostsCountAttr(subject: PostUser) =
        postUserAttrRepository.findBySubjectAndName(subject, PostUserAttrName.POSTS_COUNT.name)
            ?: PostUserAttr(subject, PostUserAttrName.POSTS_COUNT.name).let {
                postUserAttrRepository.save(it)
            }

    fun getPostsCount(subject: PostUser) = getPostsCountAttr(subject).value.toInt()

    fun incrementPostsCount(subject: PostUser) {
        val attr = getPostsCountAttr(subject)

        attr.increment(1)
    }

    fun decrementPostsCount(subject: PostUser) {
        val attr = getPostsCountAttr(subject)

        attr.decrement(1)
    }
}
