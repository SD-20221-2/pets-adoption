import React, { useEffect } from 'react'
import { useDispatch, useSelector } from 'react-redux'
import HeaderExampleBlock from '../Header';
import { petActions } from '../../actions/pet.actions'
import Pet from './Pet'

const Pets = () => {
  const dispatch = useDispatch()
  const pets = useSelector(state => state.petReducer.pets)

  useEffect(() => {
    dispatch(petActions.list())
  }, [dispatch])

  return (
    <div>
      <HeaderExampleBlock/>
      {pets.map(pet => (
        <Pet ket={pet.id} pet={pet} />
      ))}
    </div>
  )
}

export default Pets
