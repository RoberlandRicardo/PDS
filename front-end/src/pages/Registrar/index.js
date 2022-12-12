import React from "react";
import Button from "../../components/button";
import Input from "../../components/input";
import styles from "./styles.module.css";
import useEnviarRequisicao from "../../api/enviarRequisicao";

function Registrar(params) {

    const {enviarRequisicao} = useEnviarRequisicao()

    function cadastrar() {
        enviarRequisicao({
            method: "POST",
            endpoint: "/usuario"
        })
    }

    return (
        <main className={styles.main}>
            <section className={styles.section}>
                <h1 className={styles.h1 + ' logo-font'}>MultiTarefas</h1>
                <form className={styles.form}>
                    <h6 className={styles.h6}>Registrar</h6>
                    <Input label="Nome" className={styles.input} />
                    <Input label="Senha" type="password" className={styles.input} />
                    <Input label="Repita sua senha" type="password" className={styles.input} />
                    <Input label="Email" type="email" className={styles.input} />
                </form>
                <Button className={styles.buttonSubmit} onClick={() => cadastrar()}> ENVIAR </Button>
                <a className={styles.linkButton} href="/login">Já possui conta? Faça o login</a>
            </section>
        </main>
    )
}

export default Registrar;