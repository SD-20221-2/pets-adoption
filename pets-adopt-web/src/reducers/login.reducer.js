import { loginActionTypes } from "../constants/login";

const INITAL_STATE = {
  token: "",
  error: "",
  loading: false
}

const loginReducer = (state = INITAL_STATE, actions) => {
  switch (actions.type) {
    case loginActionTypes.LOGIN:
      return { ...state, error: '', loading: true }
    case loginActionTypes.LOGIN_SUCCESS:
      return { ...state, error: '', loading: false, token: actions.payload }
    case loginActionTypes.LOGIN_FAIL:
      return { ...state, error: actions.payload, loading: false }
    default:
      return state
  }
}

export { loginReducer }