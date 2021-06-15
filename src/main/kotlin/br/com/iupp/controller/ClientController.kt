package br.com.iupp.controller

import br.com.iupp.controller.dto.ClientRequest
import br.com.iupp.controller.dto.ClientResponse

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
    fun findClientByUUID(@PathVariable uuid: UUID):HttpResponse<ClientResponse>{
        val result: ClientResponse? =  service.findClientebyId(uuid)
        if(result == null){
            return HttpResponse.notFound()
        }else{
            return HttpResponse.ok(result)
        }
    }

    @Delete("/{uuid}")
    fun deleteClientById(@PathVariable uuid:UUID){
        service.deleteClientById(uuid = uuid)
    }

}