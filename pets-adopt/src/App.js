import HeaderExampleBlock from './components/Buttons';
import ButtonExampleEmphasis from './components/Header';
import React  from 'react';
import './App.css';

function App() {
  return (
    <div className="App">
      <ButtonExampleEmphasis/>
      <h2>Adote um bichinho!</h2>
      <h2>Sem burocracia e</h2>
      <h2>com Segurança.</h2>
      <h3>Com Segurança para o pet e para você, qui você pode facilmente encontra</h3>
      <h3>um novo bichinho para fazer parte da familia.</h3>
      <HeaderExampleBlock />
    </div>
  );
}

export default App;
