import { combineReducers } from "redux";

import { petReducer } from "./pet.reducer";
import { messageReducer } from './message.reducer'

const reducers = combineReducers({
  petReducer,
  messageReducer
})

export { reducers }