import React, { useState } from 'react'
import { Button, Form, Image, Select } from 'semantic-ui-react'
import { useDispatch } from 'react-redux'

import { petActions } from '../../actions/pet.actions'
import dogPhoto from '../../assets/dog.png'

import './PetForm.css'

const options = [
  { key: 's', text: 'Sim', value: true },
  { key: 'n', text: 'Não', value: false }
]

const optionsPetType = [
  { key: 'd', text: 'Cachorro', value: 'dog' },
  { key: 'c', text: 'Gato', value: 'cat' }
]

const PetForm = () => {
  const dispatch = useDispatch()

  const [nome, setNome] = useState('')
  const [raca, setRaca] = useState('')
  const [peso, setPeso] = useState('')
  const [descricao, setDescricao] = useState('')
  const [historia, setHistoria] = useState('')
  const [altura, setAltura] = useState('')
  const [coloracaoPelo, setColoracaoPelo] = useState('')
  const [dataNascimento, setDataNascimento] = useState('')
  const [vacinado, setVacinado] = useState(true)
  const [castrado, setCastrado] = useState(true)
  const [tipoAnimal, setTipoAnimal] = useState('dog')

  const onChange = setState => {
    return event => setState(event.target.value)
  }

  const save = event => {
    event.preventDefault()
    const pet = {
      nome,
      raca,
      peso,
      descricao,
      historia,
      altura,
      coloracaoPelo,
      dataNascimento,
      vacinado,
      castrado,
      tipoAnimal
    }
    dispatch(petActions.save(pet))
  }

  return (
    <div className="pet-form-root">
      <p className="per-form-header">
        Preencha os campos a seguir e cadastre seu pet
      </p>
      <div className="pet-form-container">
        <div>
          <Image className="pet-form-img" src={dogPhoto} />
        </div>
        <div className="pet-form">
          <Form onSubmit={save}>
            <Form.Input
              type="text"
              placeholder="Nome"
              value={nome}
              onChange={onChange(setNome)}
            />
            <Form.Input
              type="text"
              placeholder="Raça"
              value={raca}
              onChange={onChange(setRaca)}
            />
            <Form.Input
              type="text"
              placeholder="Peso (kg)"
              value={peso}
              onChange={onChange(setPeso)}
            />
            <Form.Input
              type="text"
              placeholder="Descrição"
              value={descricao}
              onChange={onChange(setDescricao)}
            />
            <Form.TextArea
              type="text"
              placeholder="História"
              value={historia}
              onChange={onChange(setHistoria)}
            />
            <Form.Group>
              <Form.Input
                type="text"
                placeholder="Altura (cm)"
                width={8}
                value={altura}
                onChange={onChange(setAltura)}
              />
              <Form.Input
                type="text"
                placeholder="Coloração do pelo"
                width={8}
                value={coloracaoPelo}
                onChange={onChange(setColoracaoPelo)}
              />
            </Form.Group>
            <Form.Group>
              <Form.Input
                type="date"
                label="Data de Nascimento"
                width={4}
                value={dataNascimento}
                onChange={onChange(setDataNascimento)}
              />
              <Form.Select
                control={Select}
                fluid
                options={options}
                label="Vacinado?"
                width={4}
                value={vacinado}
                onChange={onChange(setVacinado)}
              />
              <Form.Select
                control={Select}
                fluid
                options={options}
                label="Castrado?"
                width={4}
                value={castrado}
                onChange={onChange(setCastrado)}
              />
              <Form.Select
                control={Select}
                fluid
                options={optionsPetType}
                label="Tipo Animal?"
                width={4}
                value={tipoAnimal}
                onChange={onChange(setTipoAnimal)}
              />
            </Form.Group>
            <Button
              className="pet-button"
              type="submit"
              color="yellow"
              content="Cadastrar Pet"
              onClick={() => {}}
            />
          </Form>
        </div>
      </div>
    </div>
  )
}

export default PetForm
