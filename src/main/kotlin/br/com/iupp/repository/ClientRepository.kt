package br.com.iupp.repository

import br.com.iupp.controller.dot.ClientResponse
import br.com.iupp.model.ClientEntity
import io.micronaut.http.HttpResponse
import java.util.*
import javax.inject.Singleton

@Singleton
interface ClientRepository {

    fun repSaveClient(clienteEntity: ClientEntity):ClientEntity
    fun ListOfClient():List<ClientResponse>
    fun findClienteById(uuid:UUID):ClientResponse?
    fun deleteClienteById(uuid:UUID)

}