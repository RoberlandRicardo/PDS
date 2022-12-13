import React, { useContext, useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import Button from "../../components/button";
import Input from "../../components/input";
import { MainContext } from "../../stores/mainContext";
import styles from "./styles.module.css";
import useEnviarRequisicao from "../../api/enviarRequisicao";

function Login(params) {

    const navigate = useNavigate();

    const {enviarRequisicao} = useEnviarRequisicao()

    const { setLogedUser } = useContext(MainContext);

    const [email, setEmail] = useState();
    const [senha, setSenha] = useState();

    async function executeLogin(params) {

        const response = await enviarRequisicao({
            method: "POST",
            endpoint: "/login",
            data: {
                email: email,
                senha: senha,
            }
        })

        if (!response) {

        } else if (response.status >= 200 && response.status < 300) {
            localStorage.setItem('token', JSON.stringify(response.data.token));
            setLogedUser(
                response.data
            );
            navigate("/homepage");
        } else {

        }
    }

    return (
        <main className={styles.main}>
            <section className={styles.section}>
                <h1 className={styles.h1 + ' logo-font'}>MultiTarefas</h1>
                <form className={styles.form}>
                    <h6 className={styles.h6}>Entrar</h6>
                    <Input label="Email" className={styles.input} onChange={({target}) => setEmail(target.value)}/>
                    <Input label="Senha" type="password" className={styles.input} onChange={({target}) => setSenha(target.value)}/>
                </form>
                <Button className={styles.buttonSubmit} onClick={() => executeLogin()}> REALIZAR LOGIN </Button>
                <a 
                    className={styles.linkButton} 
                    href="/registrar"
                    >Ainda não possui conta? Registre-se agora.</a>
            </section>
        </main>
    )
}

export default Login;