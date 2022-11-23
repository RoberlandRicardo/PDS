import React from "react";
import { BrowserRouter} from "react-router-dom";
import ContainerRoutes from "./routes";
import MainContextProvider from "./stores/mainContext";


function App() {
    return (
        <BrowserRouter>
            <MainContextProvider>
                <ContainerRoutes/>
            </MainContextProvider>
        </BrowserRouter>
    );
}

export default App;