import { combineReducers } from 'redux'

import { petReducer } from './pet.reducer'
import { loginReducer } from './login.reducer'

const reducers = combineReducers({
  loginReducer,
  petReducer
})

export { reducers }
