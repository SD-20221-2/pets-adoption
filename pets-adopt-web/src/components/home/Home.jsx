import React from 'react'
import { Image } from 'semantic-ui-react'
// import LoginCheck from '../login/LoginCheck'
import MenuNav from '../menu/MenuNav'

import dogAndCat from '../../assets/gato-e-cachorro.png'
import './Home.css'

const Home = () => {
  return (
    <div>
      <MenuNav location="/" />
      <div className="home-container">
        <div className="home-titles">
          <h1 className="home-titles-h1">Adote um bichinho!</h1>
          <h2>Sem burocracia</h2>
          <h2>Com Segurança</h2>
          <br />
          <h3>um novo bichinho para fazer parte da familia</h3>
        </div>
        <div>
          <Image className="home-img" src={dogAndCat} />
        </div>
      </div>
    </div>
  )
}

export default Home
