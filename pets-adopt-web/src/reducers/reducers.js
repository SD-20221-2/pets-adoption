import { combineReducers } from 'redux'

import { petReducer } from './pet.reducer'
import { loginReducer, newUserReducer } from './login.reducer'

const reducers = combineReducers({
  loginReducer,
  petReducer,
  newUserReducer
})

export { reducers }
