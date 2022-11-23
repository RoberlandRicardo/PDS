import Header from "../../components/header";
import styles from "./styles.module.css";
import Button from "../../components/button";
import TarefaDrawer from "./components/tarefaDrawer";

function Homepage() {
    return (
        <main>
            <Header/>
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
        </main>
    )
}

export default Homepage;