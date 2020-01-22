package ar.com.jalmeyda.kotlin.controller

import ar.com.jalmeyda.kotlin.db.UserRepository
import ar.com.jalmeyda.kotlin.domain.User
import io.swagger.annotations.ApiOperation
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController(val userRepository: UserRepository) {

    @ApiOperation(value = "Get User", response = User::class)
    @GetMapping("/users")
    fun findUser(@RequestParam(value = "name") name: String): User =
        userRepository.findById(name).orElseThrow {
            clientException(
                name
            )
        }

    @ApiOperation(value = "Find users which a match a regex name", response = List::class)
    @GetMapping("/users/regex")
    fun findUsersByRegex(@RequestParam(value = "name") name: String): List<User> =
        userRepository.findByNameRegex(name)

    @ApiOperation(value = "Add User", response = User::class)
    @PostMapping("/users")
    fun saveUser(@RequestBody user: User): User = userRepository.insert(user)
}
