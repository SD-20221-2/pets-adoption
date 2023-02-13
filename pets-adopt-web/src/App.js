import React from 'react'
import { NavLink, Route, Routes } from 'react-router-dom'

import './App.css'

import Adoption from './components/adoption/Adoption'
import Home from './components/home/Home'
import Message from './components/messages/Message'
import Pets from './components/pet/Pets'

function App() {
  return (
    <div className="App">
      <header>
        <nav>
          <ul>
            <li>
              <NavLink to="/">Home</NavLink>
            </li>
            <li>
              <NavLink to="/adoption">Adoção</NavLink>
            </li>
            <li>
              <NavLink to="/pets">Serviços de pet</NavLink>
            </li>
          </ul>
        </nav>
      </header>
      <main>
        <Routes>
          <Route exact path="/" element={<Home />} />
          <Route path="/adoption" element={<Adoption />} />
          <Route path="/pets" element={<Pets />} />
          <Route path="*" element={<PageNotFound />} />
        </Routes>
      </main>
      <footer>
        <Message />
      </footer>
    </div>
  )
}

function PageNotFound() {
  return (
    <>
      <h1>404</h1>
      <p>Página não encontrada!</p>
    </>
  )
}

export default App
