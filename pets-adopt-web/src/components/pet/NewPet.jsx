import React, { useState } from 'react'
import { useDispatch } from 'react-redux'

import { petActions } from '../../actions/pet.actions'

const NewPet = ({clear}) => {
  const dispatch = useDispatch()

  const [name, setName] = useState('')
  const [breed, setBreed] = useState('')
  const [type, setType] = useState('dog')
  const [ageMonthYear, setAgeMonthYear] = useState('')
  const [characteristics, setCharacteristics] = useState('')

  const save = event => {
    event.preventDefault()

    const pet = {
      name,
      breed,
      type,
      ageMonthYear,
      characteristics
    }

    console.log(pet)
    dispatch(petActions.save(pet))
    clearState()
  }

  const clearState = () => {
    setName('')
    setBreed('')
    setType('')
    setAgeMonthYear('')
    setCharacteristics('')
    clear()
  }

  const onChange = setState => {
    return event => setState(event.target.value)
  }

  return (
    <div>
      <form onSubmit={save}>
        <label htmlFor="name">Nome</label>
        <input
          type="text"
          placeholder="opcional"
          name={name}
          value={name}
          onChange={onChange(setName)}
        />
        <br />
        <label htmlFor="breed">Raça</label>
        <input
          type="text"
          placeholder="opcional"
          name={breed}
          value={breed}
          onChange={onChange(setBreed)}
        />
        <br />
        <input
          type="radio"
          id="dog"
          name="type"
          value="dog"
          onChange={onChange(setType)}
          checked
        />
        <label htmlFor="dog"> Cachorro</label>
        <input
          type="radio"
          id="cat"
          name="type"
          value="cat"
          onChange={onChange(setType)}
        />
        <label htmlFor="cat"> Gato</label>
        <br />
        <label htmlFor="age_month_year">Mês/Ano de Nascimento</label>
        <br />
        <input
          type="date"
          placeholder="mês/ano aproximado de nascimento"
          name="ageMonthYear"
          value={ageMonthYear}
          onChange={onChange(setAgeMonthYear)}
        />
        <br />
        <label htmlFor="characteristics">Características</label>
        <br />
        <textarea
          placeholder="descrição do animal"
          name="characteristics"
          value={characteristics}
          onChange={onChange(setCharacteristics)}
        />
        <br />
        <button type="submit" onClick={() => {}}>
          Salvar
        </button>
      </form>
    </div>
  )
}

export default NewPet
