package br.com.iupp.controller

import br.com.iupp.model.ClientEntity
import br.com.iupp.service.ClientService
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post


@Controller("/api/v1/clients")
class ClientController(val service: ClientService) {

    @Post
    fun teste(@Body clientEntity: ClientEntity):ClientEntity{
        return service.saveClient(clientEntity)
    }

}