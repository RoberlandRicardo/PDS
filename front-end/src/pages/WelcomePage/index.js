import React from "react";
import Button from "../../components/button";
import styles from './styles.module.css';

function WelcomePage() {
    return (
        <main className={styles.main}>
            <section className={styles.textContainer}>
                <h1 className={styles.h1}>Bem vindo ao <strong>MultiTarefa</strong></h1>
                <h4 className={styles.h4}>Com o MultiTarefa, você consegue organizar e criar tarefas de maneira prática e fácil.</h4>
                <div className={styles.buttonContainer}>
                    <Button className={styles.buttonMain} href="/login" >
                        LOGAR
                    </Button >
                    <Button className={styles.buttonMain} href="/registrar" outline >
                        REGISTRAR
                    </Button >
                </div>
            </section>
            <section className={styles.imageContainer}>
                <img className={styles.img} src={require("../../assets/images/to-do-list-rafiki.png")} alt="Homem anotando suas tarefas" />
            </section>
        </main>
    )
}

export default WelcomePage;