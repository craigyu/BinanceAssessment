# Binance Assessment Assignment

## Overview
This project is done for the assesment of PNK Admin Engineer at Binance.US \
To see the detail of the assesment requirement, please check out the `assignment.pdf` file.

IMPORTANT: you need to run both back and frond end to see the working implemented functionalities. There is no mock data at front end.

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

### Completed Tasks
- Basic Layout
- Dashboard & List side menu
- Dashboard component displays texts
- List component displays a list of message objects
- Insert, Edit, Delete entries 
- Draggable pop-up dialogs
- Partial responsive design

---
## Envisioned but not implemented
When planning for this project, I had lots of ideas for features, but I ended up not doing them due to lack of time. These are:
- Backend unit test
- Frontend component test using Cypress
- End-to-End test
- containerize using Docker
- Login page
- Auth on front and back end
- Toggle dark theme
- Finish responsive design 
- Use an actual DB
- Form Validation
- DB data validation using Models


---
## Conclusion
Since this project is fairly straightforward, I did not implement any test due to my limited time. I believe by implemnting the backend can better demonstrate my range of skills. However, I do believe the importance of having tests.\
Though I'm more experienced with React as front end and Node as back end, I really enjoyed doing this project and trying out Java + Spring, it was less complicated than I thought. Coming back to Vue after a few years made me appreciate React a little more, it just feels more structured, but I think it's mostly due to my familiarity with React. 