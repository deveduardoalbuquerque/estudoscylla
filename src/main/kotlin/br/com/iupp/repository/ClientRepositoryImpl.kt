package br.com.iupp.repository

import br.com.iupp.model.ClientEntity
import com.datastax.oss.driver.api.core.CqlSession
import javax.inject.Singleton

@Singleton
class ClientRepositoryImpl(val cqlSession: CqlSession):ClientRepository {

    override fun repSaveClient(clienteEntity: ClientEntity): ClientEntity {

//        cqlSession.execute(
//            SimpleStatement
//                .newInstance(
//                    "INSERT INTO mykeyspace.client(id,name,email,cpf) VALUES(?,?,?,?)",
//                    UUID.randomUUID(),
//                    clienteEntity.name,
//                    clienteEntity.email,
//                    clienteEntity.cpf
//                )
//        )

        return clienteEntity
    }
}