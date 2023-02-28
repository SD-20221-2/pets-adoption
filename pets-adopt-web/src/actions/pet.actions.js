import { petActionTypes } from '../constants/pets'
import { JWTUtils } from '../utils/jwt-key'

const petActions = {
  save: function (pet) {
    return dispatch => {
      fetch('http://localhost:8080/api/v1/pets', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json', 'Authorization': JWTUtils.bearer() },
        body: JSON.stringify(pet)
      })
        .then(response => response.json())
        .then(result => {
          dispatch({ type: petActionTypes.SAVE, payload: pet })
          // dispatch({ type: messageActionTypes.SUCCESS, payload: result })
        })
        .catch(
        //   error => {
        //   dispatch({ type: messageActionTypes.ERROR, payload: error })
        // }
      )
    }
  },

  list: function () {
    return dispatch => {
      fetch('http://localhost:8080/api/v1/pets/all', {
        method: 'GET',
        headers: { 'Content-Type': 'application/json', 'Authorization': JWTUtils.bearer() }
      })
        .then(response => response.json())
        .then(body =>
          dispatch({ type: petActionTypes.LIST, payload: [...body] })
        )
        .catch(
        //   error => {
        //   dispatch({ type: messageActionTypes.ERROR, payload: error })
        // }
      )
    }
  }
}


export { petActions }