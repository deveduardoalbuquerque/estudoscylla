package br.com.iupp.service

import br.com.iupp.controller.dot.ClientRequest
import br.com.iupp.controller.dot.ClientResponse
import br.com.iupp.model.ClientEntity
import br.com.iupp.repository.ClientRepository
import java.util.*
import javax.inject.Singleton

@Singleton
class ClientServiceImpl(val clientRepository: ClientRepository):ClientService {

    override fun saveClient(clientRequest: ClientRequest): ClientResponse {
        val clientToSave = ClientEntity(UUID.randomUUID(),clientRequest.name,clientRequest.email, clientRequest.cpf)
        val clientSaved:ClientEntity= clientRepository.repSaveClient(clientToSave)
        return ClientResponse(clientSaved.id, clientSaved.name, clientSaved.email)
    }

    override fun listClient():List<ClientResponse> {
        return clientRepository.ListOfClient()
    }

    override fun findClientebyId(clienteId: UUID): ClientResponse {
        return clientRepository.findClienteById(clienteId)
    }
}