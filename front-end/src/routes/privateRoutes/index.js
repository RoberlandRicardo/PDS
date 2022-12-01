import React, { useContext } from "react";
import { Outlet, Navigate } from "react-router-dom";
import { MainContext } from "../../stores/mainContext";

function PrivateRoutes() {

    const {logedUser} = useContext(MainContext);

    return (
        logedUser ? <Outlet/> : <Navigate to="/error403" />
    )
}

export default PrivateRoutes;