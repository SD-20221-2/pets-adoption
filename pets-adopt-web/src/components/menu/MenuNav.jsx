import React from 'react'
import { Link } from 'react-router-dom'
import { Button, Menu } from 'semantic-ui-react'
import { JWTUtils } from '../../utils/jwt-key'

import './MenuNav.css'

const MenuNav = props => {
  return (
    <div>
      <Menu borderless pointing secondary attached="top">
        <Menu.Menu position="right">
          <Link to="/">
            <Menu.Item name="home" active={props.location === '/'}>
              Home
            </Menu.Item>
          </Link>

          <Link to="/pets">
            <Menu.Item name="find" active={props.location === '/pets'}>
              Encontrar Pet
            </Menu.Item>
          </Link>

          <Link to="/pets/new">
            <Menu.Item name="new" active={props.location === '/pets/new'}>
              Cadastrar Pet
            </Menu.Item>
          </Link>
          {/* <Link to="/complaint">
            <Menu.Item
              name="complaint"
              active={props.location === '/complaint'}
            >
              Fazer denúncia
            </Menu.Item>
          </Link> */}
          {JWTUtils.hasToken() ? (
            <Link to="/logout">
            <Button>Logout</Button>
          </Link>
          ) : (
            <Link to="/login">
              <Button>Login</Button>
            </Link>
          )}
        </Menu.Menu>
      </Menu>
    </div>
  )
}

export default MenuNav
