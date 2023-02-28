import React from 'react'
import { Item, Label } from 'semantic-ui-react'

const Pet = ({ pet }) => {
  return (
    
    <div>
      <Item>
      <Item.Image src='https://clarissaaranha.com.br/wp-content/uploads/2020/04/neve-pet-shop-18.jpg' />

      <Item.Content>
        <Item.Header as='a'>{pet.name}</Item.Header>
        <Item.Meta>
          <span className='cinema'>{pet.type}</span>
        </Item.Meta>
        <Item.Description>{pet.characteristics}</Item.Description>
        <Item.Extra>
          <Label>{pet.breed}</Label>
        </Item.Extra>
      </Item.Content>
    </Item>
    </div>
  )
}

export default Pet
