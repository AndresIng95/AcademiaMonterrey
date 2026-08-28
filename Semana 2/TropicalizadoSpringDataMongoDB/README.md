So, I fought a bug for a cuple of hours, anyway...
Para redundancia los endpoints tambien se agregaron en un archivo de texto en esta carpeta
Aqui estan los comandos de powershell, confirmado que tambien aparecen en Mongo express $BASE = "http://localhost:8081/api/teams"
Invoke-RestMethod -Uri $BASE -Method GET | ConvertTo-Json

Resultado fue

{ "value": [

          ],
"Count":  0

}

$body = @{ name = "Rayados" city = "Monterrey" sport = "Soccer" } | ConvertTo-Json

$result = Invoke-RestMethod -Uri $BASE -Method POST -ContentType "application/json" -Body $body

$ID = $result.id

Write-Host "creado: $ID"

Invoke-RestMethod -Uri "$BASE/$ID" -Method GET | ConvertTo-Json

Resultado fue

{ "name": "Rayados", "city": "Monterrey", "sport": "Soccer", "id": "6a88f81fb35703cd2126f63e" }

$body = @{ id = $ID name = "Tigres UANL" city = "San Nicolas de los Garza" sport = "Professional Soccer" } | ConvertTo-Json

Invoke-RestMethod -Uri $BASE -Method PUT -ContentType "application/json" -Body $body | ConvertTo-Json

Resultado fue

{ "name": "Tigres UANL", "city": "San Nicolas de los Garza", "sport": "Professional Soccer", "id": "6a88f81fb35703cd2126f63e" }

$body = @{ sport = "Liga MX Soccer" } | ConvertTo-Json

Invoke-RestMethod -Uri "$BASE/$ID" -Method PATCH -ContentType "application/json" -Body $body | ConvertTo-Json

Resultado fue

{ "name": "Tigres UANL", "city": "San Nicolas de los Garza", "sport": "Liga MX Soccer", "id": "6a88f81fb35703cd2126f63e" }

Invoke-RestMethod -Uri "$BASE/$ID" -Method DELETE

Resultado fue

Deleted team id - 6a88f81fb35703cd2126f63e

Invoke-RestMethod -Uri $BASE -Method GET | ConvertTo-Json

Resultado fue

{ "value": [

          ],
"Count":  0

}
