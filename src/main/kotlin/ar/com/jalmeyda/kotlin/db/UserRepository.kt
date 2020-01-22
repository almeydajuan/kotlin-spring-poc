package ar.com.jalmeyda.kotlin.db

import ar.com.jalmeyda.kotlin.domain.User
import org.springframework.data.mongodb.repository.MongoRepository

interface UserRepository : MongoRepository<User, String> {

    fun findByNameRegex(name: String): List<User>
}

