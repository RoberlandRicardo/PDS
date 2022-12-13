import React, { useState, useEffect } from "react";
import { useNavigate } from "react-router-dom";
import Button from "../../components/button";
import Input from "../../components/input";
import styles from "./styles.module.css";
import useEnviarRequisicao from "../../api/enviarRequisicao";
import bcrypt from 'bcryptjs';

function Registrar(params) {

    const navigate = useNavigate();

    const {enviarRequisicao} = useEnviarRequisicao()

    const [nome, setNome] = useState("");
    const [email, setEmail] = useState("");
    const [senha, setSenha] = useState("");
    const [repeteSenha, setRepeteSenha] = useState("");
    const [camposValidados, setCamposValidados] = useState(false);

    useEffect(() => {

    }, [senha, repeteSenha])

    async function cadastrar() {

        var hashedSenha = await bcrypt.hash(senha, await bcrypt.genSalt());

        const response = await enviarRequisicao({
            method: "POST",
            endpoint: "/usuario",
            data: {
                nome: nome,
                email: email,
                senha: hashedSenha,
            }
        })

        if (!response) {

        } else if (response.status >= 200 && response.status < 300) {
            navigate("/login");
        } else {

        }
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