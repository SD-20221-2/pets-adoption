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
        dispatch({ type: loginActionTypes.LOGIN, payload: loginRequest })
        dispatch(loginSucess(result))
      })
      .catch(error => {
        dispatch(loginFail(error))
      })
  }
}

const loginSucess = (content) => {
  JWTUtils.store(content.token)
  return { type: loginActionTypes.LOGIN_SUCCESS, payload: content.token }
}

const loginFail = (error) => {
  return { type: loginActionTypes.LOGIN_FAIL, payload: error }
}

const loginActions = {
  login
}

export { loginActions }