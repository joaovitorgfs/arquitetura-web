const http = require("http");

http.createServer((request, response) => {
    response.write("Hello, web!");
    response.end();
}).listen(3000);

console.log("Servidor iniciado na porta 3000");
