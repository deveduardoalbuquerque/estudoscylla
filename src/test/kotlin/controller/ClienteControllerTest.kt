package controller

import br.com.iupp.controller.ClientController
import br.com.iupp.controller.dto.ClientRequest
import br.com.iupp.controller.dto.ClientResponse
import br.com.iupp.service.ClientService
import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe
import io.micronaut.test.extensions.kotest.annotation.MicronautTest
import io.mockk.every
import io.mockk.mockk
import java.util.*


@MicronautTest
class ClienteControllerTest: AnnotationSpec() {

    val clientService = mockk<ClientService>(relaxed = true)
    val clientController: ClientController = ClientController(clientService)

    val id = UUID.randomUUID()

    lateinit var clientRequest: ClientRequest
    lateinit var clientResponse: ClientResponse

    @BeforeEach
    fun setUp(){
        clientRequest = ClientRequest(name = "bia", email = "bia@email.com",cpf = "12345678900")
        clientResponse = ClientResponse(id = id,name = "bia", email = "bia@email.com")
    }

    @Test
    fun `should be received a created client`() {
        every { clientService.saveClient(any()) } answers { clientResponse }
        val result = clientController.createClient(clientRequest).body()
        result shouldBe  clientResponse
    }

    @Test
    fun `should be received a created list of clients`(){
        every { clientService.listClient() } answers { listOf(clientResponse) }
        val result = clientController.listClient()
        result shouldBe listOf(clientResponse)
    }

    @Test
    fun `should be received a clientResponse find by id of type uuid`(){
        every { clientService.findClientebyId(any()) } answers { clientResponse }
        val result = clientController.findClientByUUID(id)
        result shouldBe clientResponse
    }
}