import React from 'react'
import { Route, Routes } from 'react-router-dom'

import './App.css'

import Adoption from './components/adoption/Adoption'
import Home from './components/home/Home'
import Message from './components/messages/Message'
import Pets from './components/pet/Pets'

function App() {
  return (
    <div className="App">
      <Routes>
        <Route exact path="/" element={<Home />} />
        <Route path="/adoption" element={<Adoption />} />
        <Route path="/pets" element={<Pets />} />
        <Route path="*" element={<PageNotFound />} />
      </Routes>
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
