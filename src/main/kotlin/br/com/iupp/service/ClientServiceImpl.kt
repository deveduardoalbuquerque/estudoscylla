package br.com.iupp.service

import br.com.iupp.model.ClientEntity
import br.com.iupp.repository.ClientRepository
import javax.inject.Singleton

@Singleton
class ClientServiceImpl(val clientRepository: ClientRepository):ClientService {

    override fun saveClient(clientEntity: ClientEntity): ClientEntity {
        clientRepository.repSaveClient(clientEntity)
        return clientEntity
    }
}