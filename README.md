## API Endpoints
Use POSTMAN to try the following endpoints:


## Get list of Animals

### Request

    `GET /animals/all`

    `http://localhost:8080/animals/all`



## Get Animal by Id
### Request


    `GET /animals/{animalId}`

    `http://localhost:8080/animals/{animalId}`
     
## Create a new Animal

### Request

    `POST /animals/new`
    
    `http://localhost:8080/animals/new` 
    Example data: '{ "name": "Stegosaurus","scientificName": "Stegosaurus armatus","species": "Dinosaur","habitat": "Woodlands","description": "A big dinosaur with large plates on it's back."}'

## Get Animals by name

### Request

    `GET /animals/name_search?name={name}`

    `http://localhost:8080/animals/name_search?name={name}`
    

## Get Animals by species

### Request

    `GET /animals/search_species?species={species name}`

    `http://localhost:8080/animals/search_species?species={name of species}`




## Update an existing Animal

### Request

    `PUT /animals/update/{Id}`
    
    `http://localhost:8080/animals/update/{Id}`

## Delete an existing Animal

### Request

    `DELETE /animals/delete/{animalId}`
    
    `http://localhost:8080/animals/delete/{animalId}`
