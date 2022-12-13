import axios from "axios";
import { useContext } from "react";
import { MainContext } from "../stores/mainContext";

const api = axios.create({
    baseURL: "http://localhost:8080" 
});

function useEnviarRequisicao() {

    const {logedUser} = useContext(MainContext);
    
    function enviarRequisicao({method, endpoint, data, headers}) {

        var response = null;

        const config = {
            headers: {...headers,
                'Access-Control-Allow-Origin': '*',
                'Content-Type': 'application/json',
            }
        }

        if (logedUser)
            config.headers.Authorization = "Bearer " + logedUser.token;

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