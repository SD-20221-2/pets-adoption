import { messageActionTypes } from "../constants/messages";

const INITIAL_STATE = {}

const messageReducer = (state = INITIAL_STATE, actions) => {
  switch (actions.type) {
    case messageActionTypes.SUCCESS:
      return { response: actions.payload }
    case messageActionTypes.HIDE:
      return INITIAL_STATE
    default:
      return state
  }
}

export { messageReducer }