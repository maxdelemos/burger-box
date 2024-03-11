import http from 'k6/http';
import { sleep } from 'k6';

export const options = {
    vus: 50, // 50 usuários simultâneos
    duration: '120s', // Durante 120 segundos
};

export default function () {
    for (let i = 1; i <= 1000; i++) {

        let payload = JSON.stringify({
            nome: "PINGA-" + gerarStringAleatoria(10),
            descricao: "PINGA",
            imagem: "PINGA",
            categorias: [{ codigo: "BEBIDA" }],
            preco: "10"
        });

        let params = {
            headers: {
                'Content-Type': 'application/json',
                'Accept': '*/*'
            }
        };

        http.post('http://localhost:9000/api/produtos', payload, params);
    }
}

function gerarStringAleatoria(tamanho) {
    const caracteres = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789';
    let resultado = '';

    for (let i = 0; i < tamanho; i++) {
        const indice = Math.floor(Math.random() * caracteres.length);
        resultado += caracteres.charAt(indice);
    }

    return resultado;
}
