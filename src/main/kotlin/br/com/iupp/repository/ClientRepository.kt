package br.com.iupp.repository

import br.com.iupp.model.ClientEntity
import javax.inject.Singleton

@Singleton
interface ClientRepository {
    fun repSaveClient(clienteEntity: ClientEntity):ClientEntity
}