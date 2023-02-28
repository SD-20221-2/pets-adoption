import React, { useState } from 'react'
import NewPet from '../pet/NewPet'
import './Adoption.css'
import { Button } from 'semantic-ui-react'

const Adoption = () => {
  const [clicked, setClicked] = useState(false)
  return (
    <>
      {!clicked ? (
        <div>
          <Button primary floated="left" onClick={() => setClicked(true)}>
            Cadastrar Pet
          </Button>
        </div>
      ) : (
        <div>
          <Button primary floated="left" onClick={() => setClicked(false)}>
            &times;
          </Button>
          <NewPet clear={setClicked} />
        </div>
      )}
    </>
  )
}

export default Adoption
