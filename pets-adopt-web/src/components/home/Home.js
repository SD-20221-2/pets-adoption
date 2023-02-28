import React from 'react'
import styles from './Home.css'

const Home = () => {
  return (
    <div className={styles.home_container}>
      <h2>Adote um bichinho!</h2>
      <h2>Sem burocracia e</h2>
      <h2>com Segurança.</h2>
      <img src="https://www.balance.com.br/assets/images/page-home/gato-e-cachorro.png" alt="" data-image-width="696" data-image-height="340"></img>
      <h3>
        Com Segurança para o pet e para você, qui você pode facilmente encontrar
      </h3>
      <h3>um novo bichinho para fazer parte da familia.</h3>
    </div>
  )
}

export default Home
