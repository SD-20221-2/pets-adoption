import { loginActionTypes } from "../constants/login";
import { JWTUtils } from "../utils/jwt-key";

const login = (loginRequest) => {
  return dispatch => {
    fetch('http://localhost:8080/api/v1/auth/login', {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(loginRequest)
    })
      .then(response => response.json())
      .then(result => {
        dispatch(loginSucess(result))
      })
      .catch(error => {
        dispatch(loginFail(error))
      })
  }
}

const isValid = () => {
  return dispatch => {
    fetch('http://localhost:8080/api/v1/auth/login', {
      method: 'POST',
      headers: { 'Content-Type': 'application/json', 'Authorization': JWTUtils.bearer() }
    })
      .then(response => response.status)
      .then(status => {
        dispatch({ type: loginActionTypes.VALID_TOKEN, payload: { isAuthenticated: status === 200 } })
      })
  }
}

const create = (newUser) => {
  return dispatch => {
    fetch('http://localhost:8080/api/v1/auth/create', {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(newUser)
    })
      .then(response => response.json())
      .then(result => {
        dispatch(createSucess(result))
      })
      .catch(error => {
        dispatch(createFail(error))
      })
  }
}

const loginSucess = (content) => {
  JWTUtils.store(content.token)
  return { type: loginActionTypes.LOGIN_SUCCESS, payload: content.token }
}

const loginFail = (message) => {
  return { type: loginActionTypes.LOGIN_FAIL, payload: message }
}

const createSucess = (content) => {
  JWTUtils.store(content.token)
  return { type: loginActionTypes.CREATE_SUCCESS, payload: content }
}

const createFail = (message) => {
  return { type: loginActionTypes.CREATE_FAIL, payload: message }
}

const loginActions = {
  login,
  create,
  isValid
}

export { loginActions }