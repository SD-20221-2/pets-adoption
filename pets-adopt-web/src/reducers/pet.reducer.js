import { petActionTypes } from '../constants/pets'

const INITAL_STATE = {
  pets: []
}

const petReducer = (state = INITAL_STATE, actions) => {
  switch (actions.type) {
    case petActionTypes.SAVE:
      return { pets: [...state.pets, { ...actions.payload }] }
    case petActionTypes.LIST:
      return { pets: [...actions.payload] }
    default:
      return state
  }
}

export { petReducer }
