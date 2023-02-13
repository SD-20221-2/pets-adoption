import React, { useState } from 'react'
import NewPet from '../pet/NewPet'

import './Adoption.css'

const Adoption = () => {
  const [clicked, setClicked] = useState(false)
  return (
    <>
      {!clicked ? (
        <div>
          <button onClick={() => setClicked(true)}>Cadastrar Pet</button>
        </div>
      ) : (
        <div>
          <button onClick={() => setClicked(false)}>&times;</button>
          <NewPet clear={setClicked}/>
        </div>
      )}
    </>
  )
}

export default Adoption
