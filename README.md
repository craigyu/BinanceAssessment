# Binance Assessment Assignment

## Overview
This project is done for the assesment of PNK Admin Engineer at Binance.US \
To see the detail of the assesment requirement, please check out the `assignment.pdf` file.

---

## Back-end
### To run:
- simply run `java -jar RestBackend.jar`
- the server listens on port `5000`
- you can try out the REST API with the postman collection example `BinanceBackend.postman_collection.json`

### Tech Stack
- Java
- Spring

### Description
This simple backend is using in-memory DB and has one endpoint `/messages`\
It accepts 4 type of request:
- `GET` `/messages` return all meesages
- `POST` `/messages` insert a message item 
- `PUT` `/messages/:id` update a message entry by id
- `DELETE` `/messages/:id` delete a message entry by id

---

## Front-end
### To run:
1. `cd` to the `Frontend` folder
2. run `npm install` to install packages
3. run `npm run serve` to start the development server, default port is `8080`
4. Visit `http://localhost:8080`

### Tech Stack
- Vue v3
- Element Plus
- Tailwind CSS
