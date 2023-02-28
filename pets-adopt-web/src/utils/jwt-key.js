const USER_JWT_KEY = 'USER_JWT_KEY'

const store = (token) => {
  localStorage.setItem(USER_JWT_KEY, token)
}

const bearer = () => {
  return 'Bearer ' + localStorage.getItem(USER_JWT_KEY)
}

const JWTUtils = {
  store, bearer: bearer
}

export { JWTUtils }