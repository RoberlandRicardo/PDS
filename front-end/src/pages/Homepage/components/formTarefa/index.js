import React from "react";
import styles from "./styles.module.css";
import Input from "../../../../components/input";

function FormTarefa(params) {
    return (
        <form className={styles.formTarefa}>
            <h2 className={styles.tituloForm}>Cadastrar nova tarefa</h2>
            <div>Titulo</div>
            <Input className={styles.campo} />
            <div>Descrição</div>
            <textarea className={styles.descricao} />
            <section className={styles.divCampo}>
                <div>
                    <div>Data</div>
                    <Input className={styles.midCampo} type="date" />
                </div>
                <div>
                    <div>Selecione as tags</div>
                    <select className={styles.midCampo}>
                        <option>Escolha uma opção...</option>
                    </select>
                </div>
                <div>
                    <div>Selecione um status inicial</div>
                    <select className={styles.midCampo}>
                        <option>Escolha uma opção...</option>
                    </select>
                </div>
            </section>
        </form>
    )
}

export default FormTarefa;