import React from 'react'
import { Route, Routes } from 'react-router-dom'

import './App.css'
import Login from './components/login/Login'
import PetForm from './components/pets/PetForm'


function App() {
  return (
    <div className="App">
      <Routes>
        <Route path="/login" element={<Login />} />
        <Route path="/pet" element={<PetForm />} />
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
