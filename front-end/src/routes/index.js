import { Routes, Route } from 'react-router-dom';
import Error403 from '../pages/ErrorPages/Error403';
import Homepage from '../pages/Homepage';
import Login from "../pages/Login";
import Registrar from "../pages/Registrar";
import WelcomePage from "../pages/WelcomePage/index";
import PrivateRoutes from './privateRoutes';

function ContainerRoutes(params) {
    return (
        <Routes>
            <Route path='/' element={<WelcomePage />} />
            <Route path='/login' element={<Login />} />
            <Route path='/registrar' element={<Registrar />} />
            <Route path='/error403' element={<Error403 />} />
            {/* <Route element={<PrivateRoutes />}> */}
                <Route element={<Homepage />} path='/homepage' />
            {/* </Route> */}
        </Routes>
    )
}

export default ContainerRoutes;