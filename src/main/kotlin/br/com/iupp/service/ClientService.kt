package br.com.iupp.service

import br.com.iupp.model.ClientEntity
import javax.inject.Singleton

@Singleton
interface ClientService {

    fun saveClient(clientEntity: ClientEntity):ClientEntity

}