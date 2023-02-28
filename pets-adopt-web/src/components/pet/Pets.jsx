import React, { useEffect } from 'react'
import { useDispatch, useSelector } from 'react-redux'
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
      {pets.map(pet => (
        <Pet key={pet.id} pet={pet} />
      ))}
    </div>
  )
}

export default Pets
