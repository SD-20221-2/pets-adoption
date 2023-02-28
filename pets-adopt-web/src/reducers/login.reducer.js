import { loginActionTypes } from "../constants/login";

const INITAL_STATE_LOGIN = {
  token: "",
  isAuthenticated: false,
  message: {},
  loading: false
}

const loginReducer = (state = INITAL_STATE_LOGIN, actions) => {
  switch (actions.type) {
    case loginActionTypes.LOGIN_SUCCESS:
      return { ...state, message: {}, loading: false, token: actions.payload, isAuthenticated: true }

    case loginActionTypes.LOGIN_FAIL || loginActionTypes.INVALID_TOKEN:
      return { ...state, message: actions.payload, loading: false, token: '', isAuthenticated: false }

    case loginActionTypes.VALID_TOKEN:
      return { ...state, message: {}, loading: false, isAuthenticated: true }

    default:
      return state
  }
}

const INITAL_STATE_NEW_USER = {
  user: {},
  message: {},
  loading: false
}

const newUserReducer = (state = INITAL_STATE_NEW_USER, actions) => {
  switch (actions.type) {
    case loginActionTypes.CREATE_SUCCESS:
      return { ...state, message: {}, loading: false, user: actions.payload }

    case loginActionTypes.CREATE_FAIL:
      return { ...state, message: actions.payload, loading: false, user: {} }

    default:
      return state
  }
}

export { loginReducer, newUserReducer }