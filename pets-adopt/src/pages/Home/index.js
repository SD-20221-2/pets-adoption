import React from 'react';
import {ContainerPage, StyledView } from '../../components/Main'
import  ButtonExampleEmphasis from '../../components/Buttons'

const Page = () => {
    return(
        <StyledView>
        <ContainerPage>
            <h1>Adote um Bichinho!</h1>
            <h1>Sem burocracia e </h1>
            <h1>Com segurança.</h1>
            <h3>Com segurança para o pet e para você, aqui voce pode facilmente encontrar</h3>
            <h3>um novo bichinho para fazer parte da familia</h3>
            <ButtonExampleEmphasis/>
        </ContainerPage>
        </StyledView>
    );
}

export default Page;