import axios from "axios";

const api = axios.create({
    baseURL: "http://localhost:8080" 
});

function useEnviarRequisicao() {
    
    function enviarRequisicao({method, endpoint, data, headers}) {

        var response = null;

        const config = {
            headers: {...headers,
                'Access-Control-Allow-Origin': '*',
                'Content-Type': 'application/json'
            }
        }

        switch (method) {
            case 'GET':
                response = api.get(endpoint, config);
            break;
            case 'POST':
                response = api.post(endpoint, data, config);
            break;
            case 'PUT':
                response = api.put(endpoint, data, config);
            break;
            case 'DELETE':
                response = api.delete(endpoint, config);
            break;
        }
        return response

    }

    return {
        enviarRequisicao
    }
}
export default useEnviarRequisicao