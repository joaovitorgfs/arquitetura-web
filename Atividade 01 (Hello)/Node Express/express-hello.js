const express = require('express');
app = express();

app.get("/hello", (request, response) => {
    let name = request.query.name;
    response.send("Hello! " + name);
});

app.listen(3000);

console.log("Servidor inicado na porta 3000");