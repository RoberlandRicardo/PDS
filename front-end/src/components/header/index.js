import React from "react";
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import { faCircleUser, faSearch } from '@fortawesome/free-solid-svg-icons'
import { faBell} from '@fortawesome/free-regular-svg-icons';
import "./styles.css";

function Header() {
    return (
        <header className="main-header">
            <h4 className="logo-font title-header">MultiTarefas</h4>
            <nav className="nav-header">
                <div className="item-nav-header"><FontAwesomeIcon className="icon-standard-header" icon={faSearch} />Pesquisar</div>
                <div className="item-nav-header"><FontAwesomeIcon className="icon-standard-header" icon={faBell} />Notificações</div>
                <FontAwesomeIcon className="icon-session-header" icon={faCircleUser} />
            </nav>
        </header>
    )
}

export default Header;