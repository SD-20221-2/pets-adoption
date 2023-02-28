import React, { useState } from 'react'
import { useDispatch } from 'react-redux'
import { Button, Form, Input, Image, Header } from 'semantic-ui-react'
import { loginActions } from '../../actions/login.actions'

import './Login.css'
import petsLogo from '../../assets/pets-logo.png'

const Login = () => {
  const dispatch = useDispatch()

  const [email, setEmail] = useState('')
  const [password, setPassword] = useState('')

  const authenticate = event => {
    event.preventDefault()

    const loginRequest = {
      username: email.substring(0, email.indexOf('@')),
      password: password
    }

    dispatch(loginActions.login(loginRequest))
  }

  const onChange = setState => {
    return event => setState(event.target.value)
  }

  return (
    <div className="login-form">
      <Header className="login-header">
        <p>PETS</p>
        <p>ADOPTION</p>
      </Header>
      <Image src={petsLogo} />
      <Form onSubmit={authenticate}>
        <Form.Field
          control={Input}
          value={email}
          onChange={onChange(setEmail)}
          placeholder="Digite o e-mail cadastrado"
        />

        <Form.Field
          control={Input}
          value={password}
          type='password' 
          onChange={onChange(setPassword)}
          placeholder="Digite sua senha"
        />
        <Button
          className="login-button"
          type="submit"
          color="yellow"
          content="Entrar"
          onClick={() => {}}
        />
      </Form>
    </div>
  )
}

export default Login
