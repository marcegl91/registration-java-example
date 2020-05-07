# Registration Example

Endpoint: api/users

HTTP verb: POST

Payload:
```json
{
	"username": "user",
	"name": "User",
	"birthDate": "1980-04-05",
	"password": "secret",
	"address": "Street 123",
	"city": "Example City",
	"state": "Example State",
	"country": "Example Country",
	"emailSubscription": true,
	"numberOfLanguages": 5
}
```

Response:

```json
{
    "id": 1,
    "username": "user",
    "name": "User",
    "birthDate": "1980-04-05",
    "address": "Street 123",
    "city": "Example City",
    "state": "Example State",
    "country": "Example Country",
    "emailSubscription": true,
    "numberOfLanguages": 5
}
```
