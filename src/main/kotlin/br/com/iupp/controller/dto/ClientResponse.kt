package br.com.iupp.controller.dto

import io.micronaut.core.annotation.Introspected
import java.util.*

@Introspected
data class ClientResponse(
    val id:UUID,
    val name:String,
    val email:String)