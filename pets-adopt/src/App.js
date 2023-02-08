import HeaderExampleBlock from './components/Header';
import React  from 'react';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import './App.css';
import Home from './pages/Home'
import Adocao from './pages/Adocao'

function App() {
  return (
    <div className="App">
      <BrowserRouter>
        <HeaderExampleBlock/>
          <Routes>
            <Route path='/' element={<Home/>}/>
            <Route path='/adocao' element={<Adocao/>}/>
          </Routes>
        </BrowserRouter>
    </div>
  );
}

export default App;
