package br.com.dimdim.transaction_service

import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDateTime
import jakarta.servlet.http.HttpServletRequest

@RestController
class HomeController {

    @GetMapping(value = ["/"], produces = [MediaType.TEXT_HTML_VALUE, MediaType.APPLICATION_JSON_VALUE])
    fun home(request: HttpServletRequest): Any {
        val acceptHeader = request.getHeader("Accept") ?: ""
        
        // Se o navegador pedir HTML, retorna página bonita
        if (acceptHeader.contains("text/html") || !acceptHeader.contains("application/json")) {
            return """
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Transaction Service - DimDim Bank</title>
    <style>
        * { margin: 0; padding: 0; box-sizing: border-box; }
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            min-height: 100vh;
            display: flex;
            align-items: center;
            justify-content: center;
            padding: 20px;
        }
        .container {
            background: white;
            border-radius: 20px;
            box-shadow: 0 20px 60px rgba(0,0,0,0.3);
            padding: 40px;
            max-width: 600px;
            width: 100%;
        }
        h1 {
            color: #667eea;
            margin-bottom: 10px;
            font-size: 2.5em;
        }
        .subtitle {
            color: #666;
            margin-bottom: 30px;
            font-size: 1.1em;
        }
        .status {
            display: inline-block;
            background: #10b981;
            color: white;
            padding: 8px 16px;
            border-radius: 20px;
            font-weight: bold;
            margin-bottom: 30px;
        }
        .info {
            background: #f3f4f6;
            padding: 20px;
            border-radius: 10px;
            margin-bottom: 20px;
        }
        .info-item {
            margin: 10px 0;
            display: flex;
            justify-content: space-between;
        }
        .info-label {
            font-weight: bold;
            color: #374151;
        }
        .info-value {
            color: #6b7280;
        }
        .endpoints {
            margin-top: 30px;
        }
        .endpoints h2 {
            color: #667eea;
            margin-bottom: 15px;
            font-size: 1.5em;
        }
        .endpoint-item {
            background: #f9fafb;
            padding: 15px;
            border-radius: 8px;
            margin: 10px 0;
            border-left: 4px solid #667eea;
        }
        .endpoint-name {
            font-weight: bold;
            color: #374151;
            margin-bottom: 5px;
        }
        .endpoint-path {
            color: #667eea;
            font-family: 'Courier New', monospace;
            font-size: 0.9em;
        }
        .footer {
            text-align: center;
            margin-top: 30px;
            color: #9ca3af;
            font-size: 0.9em;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>🏦 DimDim Bank</h1>
        <p class="subtitle">Transaction Service API</p>
        <div class="status">✅ Status: UP</div>
        
        <div class="info">
            <div class="info-item">
                <span class="info-label">Versão:</span>
                <span class="info-value">1.0.0</span>
            </div>
            <div class="info-item">
                <span class="info-label">Timestamp:</span>
                <span class="info-value">${LocalDateTime.now()}</span>
            </div>
        </div>
        
        <div class="endpoints">
            <h2>📡 Endpoints Disponíveis</h2>
            <div class="endpoint-item">
                <div class="endpoint-name">Health Check</div>
                <div class="endpoint-path">/actuator/health</div>
            </div>
            <div class="endpoint-item">
                <div class="endpoint-name">Application Info</div>
                <div class="endpoint-path">/actuator/info</div>
            </div>
            <div class="endpoint-item">
                <div class="endpoint-name">Bank Statements</div>
                <div class="endpoint-path">/statements/{customerId}</div>
            </div>
        </div>
        
        <div class="footer">
            <p>🚀 Deploy automatizado via Azure DevOps Pipeline</p>
        </div>
    </div>
</body>
</html>
            """.trimIndent()
        }
        
        // Retorna JSON para APIs
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

