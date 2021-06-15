package br.com.iupp.repository

import br.com.iupp.controller.dot.ClientResponse
import br.com.iupp.model.ClientEntity
import com.datastax.oss.driver.api.core.CqlSession
import com.datastax.oss.driver.api.core.cql.ResultSet
import com.datastax.oss.driver.api.core.cql.Row
import com.datastax.oss.driver.api.core.cql.SimpleStatement
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.PathVariable
import java.util.*
import javax.inject.Singleton
import kotlin.collections.ArrayList

@Singleton
class ClientRepositoryImpl(private val cqlSession: CqlSession):ClientRepository {

    override fun repSaveClient(clienteEntity: ClientEntity): ClientEntity {

        cqlSession.execute(
            SimpleStatement
                .newInstance(
                    "INSERT INTO mydata.client(id,name,email,cpf) VALUES(?,?,?,?)",
                    UUID.randomUUID(),
                    clienteEntity.name,
                    clienteEntity.email,
                    clienteEntity.cpf
                )
        )
        return clienteEntity
    }

    override fun ListOfClient():List<ClientResponse> {
        val result = cqlSession.execute(
            SimpleStatement
                .newInstance(
                    "SELECT id, name, email,cpf FROM mydata.client"
                )
        )

        val clientResponse:MutableList<ClientResponse> = ArrayList<ClientResponse>()
        for (row:Row in result){
            var id:UUID = row.getUuid("id") ?: UUID.randomUUID()
            var name:String =row.getString("name") ?: ""
            var email:String =row.getString("email") ?: ""
            clientResponse.add(ClientResponse(name = name,email=email,id = id))
        }
        return clientResponse
    }

    override fun findClienteById(uuid: UUID): ClientResponse {

        val result: ResultSet = cqlSession.execute(
            SimpleStatement
                .newInstance(
                    "SELECT id,name,email FROM mydata.client WHERE id = ?",
                    uuid
                )
        )

        val clientResponse:MutableList<ClientResponse> = ArrayList<ClientResponse>()
        for (row:Row in result){
            var id:UUID = row.getUuid("id") ?: UUID.randomUUID()
            var name:String =row.getString("name") ?: ""
            var email:String =row.getString("email") ?: ""
            clientResponse.add(ClientResponse(name = name,email=email,id = id))
        }
        return clientResponse.get(0)
    }

}
//id para testar consultar bob
//bc64e0a0-8b9f-4ded-9388-91192454ac0e