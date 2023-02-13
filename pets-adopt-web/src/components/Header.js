import React from 'react'
import { Header, Segment } from 'semantic-ui-react'

const HeaderExampleFloating = () => (
  <Segment clearing>
    <Header as="h2" floated="right">
      Botão Login
    </Header>
    <Header as="h2" floated="right">
      Serviços de Pet
    </Header>
    <Header as="h2" floated="right">
      Adoção
    </Header>
    <Header as="h2" floated="right">
      Home
    </Header>
    <Header as="h2" floated="left">
      Icone
    </Header>
  </Segment>
)

export default HeaderExampleFloating
