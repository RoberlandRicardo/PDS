import React, { useState } from "react";
import Button from "../../components/button";
import Input from "../../components/input";
import styles from "./styles.module.css";
import useEnviarRequisicao from "../../api/enviarRequisicao";

function Registrar(params) {

    const {enviarRequisicao} = useEnviarRequisicao()

    const [nome, setNome] = useState();
    const [email, setEmail] = useState();
    const [senha, setSenha] = useState();
    const [repeteSenha, setRepeteSenha] = useState();
    const [camposValidados, setCamposValidados] = useState();

    function cadastrar() {
       
        enviarRequisicao({
            method: "POST",
            endpoint: "/usuario",
            data: {
                nome: nome,
                email: email,
                senha: senha,
            }
        })
    }

    return (
        <main className={styles.main}>
            <section className={styles.section}>
                <h1 className={styles.h1 + ' logo-font'}>MultiTarefas</h1>
                <form className={styles.form}>
                    <h6 className={styles.h6}>Registrar</h6>
                    <Input label="Nome" className={styles.input} onChange={({target}) => setNome(target.value)}/>
                    <Input label="Senha" type="password" className={styles.input} onChange={({target}) => setSenha(target.value)} />
                    <Input label="Repita sua senha" type="password" className={styles.input} onChange={({target}) => setRepeteSenha(target.value)}/>
                    <Input label="Email" type="email" className={styles.input} onChange={({target}) => setEmail(target.value)}/>
                </form>
                <Button className={styles.buttonSubmit} onClick={() => cadastrar()}> ENVIAR </Button>
                <a className={styles.linkButton} href="/login">Já possui conta? Faça o login</a>
            </section>
        </main>
    )
}

export default Registrar;