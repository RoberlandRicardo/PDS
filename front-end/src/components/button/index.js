import React from "react";
import "./styles.css";

function Button(props) {

    const {children, className, style, outline, ...rest} = props;

    return (
        <a {...rest} 
            className={"standard-button " + (outline ? "standard-button-bg-color-outline " : "standard-button-bg-color ") + className}  
            style={{...style}} >
            {children} 
        </a>
    )
}

export default Button;