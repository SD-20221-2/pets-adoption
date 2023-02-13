import React from 'react'

const Pet = ({ pet }) => {
  return (
    <div>
      <p>{pet.name}</p>
      <p>{pet.characteristics}</p>
    </div>
  )
}

export default Pet
