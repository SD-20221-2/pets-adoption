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
        .then(() => {
          dispatch({ type: petActionTypes.SAVE, payload: pet })
        })
        .catch(
          error => {
            console.log(error)
          }
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
        .then(response => check(response))
        .catch(
          error => {
            console.log(error)
          }
        )

      function check(response) {
        return response.statusCode !== 200 ?
          dispatch({ type: petActionTypes.LIST, payload: [...response] }) :
          dispatch({ type: petActionTypes.LIST })
      }
    }
  }
}


export { petActions }