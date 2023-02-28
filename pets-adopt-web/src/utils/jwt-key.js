const USER_JWT_KEY = 'USER_JWT_KEY'

const store = (token) => {
  localStorage.setItem(USER_JWT_KEY, token)
}

const clear = () => {
  localStorage.removeItem(USER_JWT_KEY)
}

const hasToken = () => {
  return localStorage.getItem(USER_JWT_KEY) !== null
}

const bearer = () => {
  return 'Bearer ' + localStorage.getItem(USER_JWT_KEY)
}

const JWTUtils = {
  store,
  bearer,
  hasToken,
  clear
}

export { JWTUtils }