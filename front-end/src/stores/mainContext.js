import React, { useState } from "react";

const initialValue = {
    logedUser: null
}

export const MainContext = React.createContext(initialValue);

function MainContextProvider({children}) {
    
    const [logedUser, setLogedUser] = useState(initialValue.logedUser);

    const valueProvider = {
        logedUser,
        setLogedUser,
    }

    return (
        <MainContext.Provider value={valueProvider} >
            {children}
        </MainContext.Provider>
    )
}

export default MainContextProvider;