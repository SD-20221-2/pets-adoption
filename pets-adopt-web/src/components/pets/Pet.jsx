import React from 'react'
import { Card } from 'semantic-ui-react'

import dogPhoto from '../../assets/dog-border-square.png'

import './Pet.css'

const Pet = ({ pet }) => {
  return (
    <Card
      image={dogPhoto}
      header={pet.nome}
      meta={pet.raca}
      description={pet.descricao}
      extra={pet.historia}
    />
  )
}

export default Pet
