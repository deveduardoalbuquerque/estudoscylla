package br.com.iupp.controller.dto

import io.micronaut.core.annotation.Introspected
import org.hibernate.validator.constraints.br.CPF
import javax.validation.constraints.NotBlank

@Introspected
data class ClientRequest (
    @field:NotBlank val name:String,
    @field:NotBlank val email:String,
    @field:NotBlank @field:CPF val cpf:String
)
