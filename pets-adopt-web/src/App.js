import React from 'react'
import { Route, Routes } from 'react-router-dom'

import './App.css'
import Home from './components/home/Home'
import Login from './components/login/Login'
import PetList from './components/pets/PetList'
import PetForm from './components/pets/PetForm'


function App() {
  return (
    <div className="App">
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/login" element={<Login />} />
        <Route path="/logout" element={<Login logout={true} />} />
        <Route path="/pets" element={<PetList />} />
        <Route path="/pets/new" element={<PetForm />} />
        <Route path="*" element={<PageNotFound />} />
      </Routes>
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
