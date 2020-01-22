package ar.com.jalmeyda.kotlin.domain

import org.springframework.data.annotation.Id
import javax.validation.constraints.Min
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

class User(
    @NotEmpty @Id val name: String,
    @NotNull @Min(18) val age: Int
) {
    override fun toString(): String = "Name: $name Age: $age"
}