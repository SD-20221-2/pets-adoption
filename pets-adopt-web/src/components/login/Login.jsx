import React, { useState } from 'react'
import { useDispatch } from 'react-redux'
import { Button, Form, Input, Image, Header } from 'semantic-ui-react'
import { loginActions } from '../../actions/login.actions'

import './Login.css'
import petsLogo from '../../assets/pets-logo.png'
import MenuNav from '../menu/MenuNav'
import { JWTUtils } from '../../utils/jwt-key'
import LoginCheck from './LoginCheck'

const Login = props => {
  if (props.logout) {
    JWTUtils.clear()
  }

  const dispatch = useDispatch()

  const [novoUsuario, setNovoUsuario] = useState(false)
  const [fullname, setFullname] = useState('')
  const [email, setEmail] = useState('')
  const [phone, setPhone] = useState('')
  const [password, setPassword] = useState('')

  const authenticate = event => {
    event.preventDefault()

    const loginRequest = {
      username: email.substring(0, email.indexOf('@')),
      password: password
    }

    clearState()
    dispatch(loginActions.login(loginRequest))
  }

  const create = event => {
    event.preventDefault()

    const newUser = {
      username: email.substring(0, email.indexOf('@')),
      fullname,
      email,
      phone,
      password
    }

    clearState()
    dispatch(loginActions.create(newUser))
  }

  const clearState = () => {
    setNovoUsuario(false)
    setFullname('')
    setEmail('')
    setPhone('')
    setPassword('')
  }

  const onChange = setState => {
    return event => setState(event.target.value)
  }

  return (
    <div>
      <MenuNav />
      <div className="login-form">
        <Header className="login-header">
          <p>PETS</p>
          <p>ADOPTION</p>
        </Header>
        <Image src={petsLogo} />
        <Form onSubmit={novoUsuario ? create : authenticate}>
          {novoUsuario ? (
            <>
              <Form.Field
                control={Input}
                value={fullname}
                onChange={onChange(setFullname)}
                placeholder="Nome Completo"
              />
              <Form.Field
                control={Input}
                value={phone}
                onChange={onChange(setPhone)}
                placeholder="Telefone"
              />
            </>
          ) : (
            ''
          )}
          <Form.Field
            control={Input}
            value={email}
            onChange={onChange(setEmail)}
            placeholder="E-mail"
          />
          <Form.Field
            control={Input}
            value={password}
            type="password"
            onChange={onChange(setPassword)}
            placeholder="Senha"
          />
          <Button
            className="login-button"
            type="submit"
            color="yellow"
            content={novoUsuario ? 'Cadastrar' : 'Entrar'}
            onClick={() => {}}
          />
        </Form>
        <div className="login-button-new">
          <Button
            type="submit"
            color="instagram"
            content="Novo por aqui?"
            onClick={() => setNovoUsuario(!novoUsuario)}
          />
        </div>
      </div>
      <LoginCheck redirectTo="/" omit={true} />
    </div>
  )
}

export default Login
