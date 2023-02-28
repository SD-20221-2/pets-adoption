import React, { useEffect } from 'react'
import { useDispatch, useSelector } from 'react-redux'
import { Card, Header } from 'semantic-ui-react'
import { petActions } from '../../actions/pet.actions'
import LoginCheck from '../login/LoginCheck'
import MenuNav from '../menu/MenuNav'
import Pet from './Pet'

import './PetList.css'

const PetList = () => {
  const pets = useSelector(state => state.petReducer.pets)
  const dispatch = useDispatch()

  useEffect(() => {
    dispatch(petActions.list())
  }, [dispatch])

  return (
    <div>
      <MenuNav location="/pets" />
      <LoginCheck>
        <div className="pet-list-container">
          <Header size="huge">Pets</Header>
          <Card.Group itemsPerRow={5}>
            {pets.map(pet => (
              <Pet key={pet.id} pet={pet} />
            ))}
          </Card.Group>
        </div>
      </LoginCheck>
    </div>
  )
}

export default PetList
