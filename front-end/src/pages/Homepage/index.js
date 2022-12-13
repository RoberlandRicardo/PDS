import Header from "../../components/header";
import styles from "./styles.module.css";
import Button from "../../components/button";
import TarefaDrawer from "./components/tarefaDrawer";
import { useContext, useEffect, useState } from "react";
import useEnviarRequisicao from "../../api/enviarRequisicao";
import { MainContext } from "../../stores/mainContext";
import FormTarefa from "./components/formTarefa";

function Homepage() {

    const {enviarRequisicao} = useEnviarRequisicao()

    const {logedUser} = useContext(MainContext);

    const [tarefas, setTarefas] = useState([]);
    const [showTarefas, setShowTarefas] = useState(null);

    useEffect(() => {
        loadTarefas();
    }, [])

    async function loadTarefas(params) {
        const response = await enviarRequisicao({
            method: 'GET',
            endpoint: `/tarefa/usuario/${logedUser.id}`,
        })

        if (!response) {

        } else if (response.status >= 200 && response.status < 300) {
            setTarefas(response.data.content);
        } else {

        }
    }

    return (
        <main>
            <Header/>
            <div className={styles.dashboard}>
                <nav className={styles.drawer}>
                    <div className={styles.content}>
                        <header className={styles.headerDrawer}>
                            <strong>Tarefas</strong>
                            <Button className={styles.buttonNewTarefa}>+</Button>
                        </header>
                        <ul>
                        {[...Array(10)].map((x, i) =>
                            <TarefaDrawer key={i} cor='#032176' nome={"Tarefa"} />
                        )}
                        
                        </ul>
                    </div>
                </nav>
                <div className={styles.containerFormTarefa}>
                    {!showTarefas && <FormTarefa />}
                </div>
            </div>
        </main>
    )
}

export default Homepage;