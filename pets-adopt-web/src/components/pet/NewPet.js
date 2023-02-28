import React, { useState } from 'react'
import { useDispatch } from 'react-redux'
import { Form, Input, Radio, TextArea } from 'semantic-ui-react'
import styles from '../home/Home.css'

import { petActions } from '../../actions/pet.actions'

const NewPet = ({ clear }) => {
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
    <div className={styles.homeContainer}>
      <Form onSubmit={save}>
        <Form.Group widths="equal">
          <Form.Field
            control={Input}
            label="Nome"
            placeholder="opcional"
            value={name}
            onChange={onChange(setName)}
          />
          <Form.Field
            control={Input}
            label="Raça"
            placeholder="opcional"
            value={breed}
            onChange={onChange(setBreed)}
          />
        </Form.Group>
        <Form.Group inline>
          <Form.Field
            control={Radio}
            label="Cachorro"
            id="dog"
            name="type"
            value="dog"
            onChange={onChange(setType)}
            checked
          />
          <Form.Field
            control={Radio}
            label="Gato"
            type="radio"
            id="cat"
            name="type"
            value="cat"
            onChange={onChange(setType)}
          />
        </Form.Group>
        <Form.Field
          control={Input}
          type="date"
          placeholder="mês/ano aproximado de nascimento"
          name="ageMonthYear"
          value={ageMonthYear}
          onChange={onChange(setAgeMonthYear)}
        />
        <Form.Field
          control={TextArea}
          label=" Caracteristicas"
          placeholder="Descrição do Animal"
          value={characteristics}
          onChange={onChange(setCharacteristics)}
        />
        <Form.Button type="submit" onClick={() => {}}>
          Salvar
        </Form.Button>
      </Form>
    </div>
  )
}

export default NewPet
