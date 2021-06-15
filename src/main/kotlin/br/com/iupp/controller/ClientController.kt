package br.com.iupp.controller

import br.com.iupp.controller.dot.ClientRequest
import br.com.iupp.controller.dot.ClientResponse

import br.com.iupp.service.ClientService
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.*
import io.micronaut.validation.Validated
import java.util.*
import javax.validation.Valid

@Validated
@Controller("/api/v1/clients")
class ClientController(val service: ClientService) {

    @Post
    fun createClient(@Body @Valid clientRequest: ClientRequest):HttpResponse<ClientResponse>{
        return HttpResponse.created(service.saveClient(clientRequest))
    }

    @Get
    fun listClient():List<ClientResponse>{
        return service.listClient()
    }
    @Get("/{uuid}")
    fun findClientByUUID(@PathVariable uuid: UUID):ClientResponse{
        return service.findClientebyId(uuid)
    }

}