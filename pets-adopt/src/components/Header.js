import React from 'react'
import { Header, Segment, Image, Button } from 'semantic-ui-react'

const HeaderExampleFloating = () => (
 <Segment clearing>
    <Button  primary floated='right' >Botão Login</Button>
    <Header as='h2' floated='right' >
      Serviços de Pet
    </Header>
    <Header as='h2' floated='right'>
      Adoção
    </Header>
    <Header as='h2' floated='right'>
      Home
    </Header>
    <Image src={"https://static.petz.com.br/images/logo.png"} size='tiny' />
  </Segment>
)

export default HeaderExampleFloating

