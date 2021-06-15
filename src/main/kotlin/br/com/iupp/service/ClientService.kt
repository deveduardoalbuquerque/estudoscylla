package br.com.iupp.service

import br.com.iupp.controller.dto.ClientRequest
import br.com.iupp.controller.dto.ClientResponse
import java.util.*
import javax.inject.Singleton

@Singleton
interface ClientService {

    fun saveClient(clientEntity: ClientRequest): ClientResponse
    fun listClient():List<ClientResponse>
    fun findClientebyId(clienteId: UUID): ClientResponse?
    fun deleteClientById(uuid:UUID)


}