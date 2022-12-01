import React from "react";
import "./styles.css";

function Input(props) {

    const {className, style, label, ...rest} = props;

    return (
        <div 
            className={"container-standard-input " + className}
            style={{...style}}  >
            <div className={"label-standard-input"}>{label ? label : ""}</div>
            <input {...rest} 
                className={"standard-input"}
                
            />
        </div>
    )
}

export default Input;