import React, { useContext } from "react";
import { useNavigate } from "react-router-dom";
import Button from "../../components/button";
import Input from "../../components/input";
import { MainContext } from "../../stores/mainContext";
import styles from "./styles.module.css";

function Login(params) {

    const navigate = useNavigate();

    const { setLogedUser } = useContext(MainContext);

    function executeLogin(params) {

        setLogedUser({
            nome: "aaa",
            email: "oi",
            token: "123"
        });

        navigate("/homepage");
    }

    return (
        <main className={styles.main}>
            <section className={styles.section}>
                <h1 className={styles.h1 + ' logo-font'}>MultiTarefas</h1>
                <form className={styles.form}>
                    <h6 className={styles.h6}>Entrar</h6>
                    <Input label="Login" className={styles.input} />
                    <Input label="Senha" type="password" className={styles.input} />
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