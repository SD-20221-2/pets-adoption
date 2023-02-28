import React, { Children } from 'react'
import { useSelector } from 'react-redux'
import { Navigate } from 'react-router-dom'
import { Header } from 'semantic-ui-react'
import { JWTUtils } from '../../utils/jwt-key'

const LoginCheck = ({ children, redirectTo, omit = false }) => {
  const isAuthenticated = useSelector(
    state => state.loginReducer.isAuthenticated
  )

  if (isAuthenticated || JWTUtils.hasToken()) {
    if (redirectTo) {
      return (
        <div>
          <Navigate to={redirectTo} />
        </div>
      )
    }
  } else if (!omit) {
    return (
      <div>
        {' '}
        <Header as="h3" textAlign="center" color="red">
          Usuário não logado
        </Header>
      </div>
    )
  }
  return children ? Children.map(children, child => <div>{child}</div>) : ''
}
export default LoginCheck
