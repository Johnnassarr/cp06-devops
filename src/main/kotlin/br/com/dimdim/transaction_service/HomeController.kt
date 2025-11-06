package br.com.dimdim.transaction_service

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDateTime

@RestController
class HomeController {

    @GetMapping("/")
    fun home(): Map<String, Any> {
        return mapOf(
            "service" to "Transaction Service - DimDim Bank",
            "status" to "UP",
            "version" to "1.0.0",
            "timestamp" to LocalDateTime.now().toString(),
            "endpoints" to mapOf(
                "health" to "/actuator/health",
                "info" to "/actuator/info",
                "statements" to "/statements/{customerId}"
            )
        )
    }
}

