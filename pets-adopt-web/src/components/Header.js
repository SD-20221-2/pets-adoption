import React from 'react'
import { Link } from 'react-router-dom'
import { Header, Segment, Image, Button } from 'semantic-ui-react'

const HeaderExampleFloating = () => (
 <Segment clearing>
    <Button  primary floated='right' >Botão Login</Button>
    <Link to="/pets">
    <Header as='h2' floated='right' href='mailto:jack@semantic-ui.com'>
      Serviços de Pet
    </Header>
    </Link>
    <Link to="/adoption">
    <Header as='h2' floated='right'>
      Adoção
    </Header>
    </Link>
    <Link to="/">
    <Header as='h2' floated='right'>
      Home
    </Header>
    </Link>
    <Image src={"https://static.petz.com.br/images/logo.png"} size='tiny' />
  </Segment>
)

export default HeaderExampleFloating

