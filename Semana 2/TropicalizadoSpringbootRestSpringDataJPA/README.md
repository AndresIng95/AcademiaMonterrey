Se escogio la entidad Team para demostrar los cambios en una nueva instancia del Springboot con data JPA.
Los campos elegidos fueron id como en el programa base, name, city, y sport. Un ejemplo seria:
                     {
                      "name":  "Tigres UANL",
                      "city":  "Monterrey",
                      "sport":  "Soccer",
                      "id":  1
                     },
La nueba base de datos se crea de acuerdo al archivo sql incluido en este folder, usando la plataforma mysql directa en el puerto 8070
El archivo de de application properties tiene mas detalles en cuanto a la instanciacion. 

Los endpoints quedaron de la siguiente manera (duplicado en el archivo de TeamRestController para redundancia):
/*The Windows powershell terminal commands that were used to test the program
 * 
 * 
 * 
 * $BASE = "http://localhost:8070/api/teams" 
 * Invoke-RestMethod -Uri $BASE -Method GET | ConvertTo-Json
 * 
 * $team = @{
>>     name  = "America"
>>     city  = "Cd de Mexico"
>>     sport = "Soccer"
>> } | ConvertTo-Json
 * 
 * 
 * Invoke-RestMethod -Uri $BASE -Method POST `
>>     -ContentType "application/json" `
>>     -Body $team | ConvertTo-Json
 * 
 * Invoke-RestMethod -Uri "$BASE/3" -Method GET | ConvertTo-Json
 * 
 * Invoke-RestMethod -Uri "$BASE/6" -Method GET | ConvertTo-Json
 * 
 * $team = @{
>>     id    = 3
>>     name  = "Los Angeles Dodgers"
>>     city  = "Los Angeles"
>>     sport = "Baseball"
>> } | ConvertTo-Json
 * 
 * Invoke-RestMethod -Uri $BASE -Method PUT `
>>     -ContentType "application/json" `
>>     -Body $team | ConvertTo-Json
 * 
 * $patch = @{
>>     city = "San Nicolas de los Garza"
>> } | ConvertTo-Json
 * 
 * Invoke-RestMethod -Uri "$BASE/1" -Method PATCH `
>>     -ContentType "application/json" `
>>     -Body $patch | ConvertTo-Json
 * 
 * Invoke-RestMethod -Uri "$BASE/3" -Method DELETE
 * 
 * 
 * All changes where reflected on the database.
 * 
 */
