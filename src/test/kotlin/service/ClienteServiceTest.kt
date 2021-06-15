package service

import br.com.iupp.controller.dot.ClientRequest
import br.com.iupp.controller.dot.ClientResponse
import br.com.iupp.model.ClientEntity
import br.com.iupp.repository.ClientRepository
import br.com.iupp.repository.ClientRepositoryImpl
import br.com.iupp.service.ClientService
import br.com.iupp.service.ClientServiceImpl
import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.inspectors.buildAssertionError
import io.kotest.matchers.shouldBe
import io.micronaut.test.extensions.kotest.annotation.MicronautTest
import io.mockk.every
import io.mockk.mockk
import java.util.*

@MicronautTest
class ClienteServiceTest:AnnotationSpec() {

    val repository = mockk<ClientRepository>(relaxed = true)
    val service = ClientServiceImpl(repository)

    lateinit var clientEntity: ClientEntity
    lateinit var clientRequest: ClientRequest
    lateinit var clientResponse: ClientResponse

    val id = UUID.randomUUID()

    @BeforeEach
    fun setUp(){

        clientEntity = ClientEntity(id = id,name = "bia", email = "bia@gmail.com", cpf = "12345678900")
        clientRequest = ClientRequest("bia","bia@gmail.com","12345678900")
        clientResponse = ClientResponse(id = id, name = "bia", email = "bia@gmail.com")
    }

    @Test
    fun `send a client request and should be received a client response`(){
        every { repository.repSaveClient(any()) } answers { clientEntity }
        val result = service.saveClient(clientRequest)
        result shouldBe clientResponse
    }

    @Test
    fun `should be received a list of clientResponse`(){
        every { repository.ListOfClient() }  answers { listOf(clientResponse) }
        val result  = service.listClient()
        result shouldBe listOf(clientResponse)
    }

    @Test
    fun `should be received a clientResponse`(){
        every { repository.findClienteById(any())} answers { clientResponse }
        val result = service.findClientebyId(id)
        result shouldBe clientResponse
    }





}