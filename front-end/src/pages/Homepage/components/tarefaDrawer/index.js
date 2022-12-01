import React from "react";
import styles from './style.module.css';
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faAngleRight } from '@fortawesome/free-solid-svg-icons'

function TarefaDrawer({cor, nome}) {
    return (
        <li className={styles.line}>
            <div style={{display:'flex', flexDirection: 'row'}}>
                <div className={styles.iconColor}
                    style={{backgroundColor: cor}}></div>
                {nome}
            </div>
            <FontAwesomeIcon icon={faAngleRight} />
        </li>
    )
}

export default TarefaDrawer;