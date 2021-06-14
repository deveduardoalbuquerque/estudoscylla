package br.com.iupp.model

import io.micronaut.core.annotation.Introspected

@Introspected
data class ClientEntity(
    val name:String,
    val email:String,
    val cpf:String
)